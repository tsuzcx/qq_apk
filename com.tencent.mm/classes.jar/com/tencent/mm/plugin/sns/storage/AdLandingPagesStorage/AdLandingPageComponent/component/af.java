package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class af
  extends m
  implements View.OnClickListener
{
  private WeImageView KsZ;
  private int Kta = 0;
  private Context mContext;
  private TextView rR;
  
  public af(Context paramContext, ag paramag, ViewGroup paramViewGroup)
  {
    super(paramContext, paramag, paramViewGroup);
    this.mContext = paramContext;
  }
  
  public final boolean by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(219228);
    if (!super.by(paramJSONObject))
    {
      AppMethodBeat.o(219228);
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.Kta);
      AppMethodBeat.o(219228);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.Sns.AdLandingPageShareComponent", "setComponentKVReportData exp=" + paramJSONObject.toString());
      AppMethodBeat.o(219228);
    }
    return false;
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(219222);
    ag localag = (ag)this.KqB;
    this.rR.setText(localag.Kne);
    if (!TextUtils.isEmpty(localag.KlM)) {
      try
      {
        int i = Color.parseColor(localag.KlM);
        this.rR.setTextColor(i);
        this.KsZ.setIconColor(i);
        AppMethodBeat.o(219222);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Sns.AdLandingPageShareComponent", "parseColor exp=" + localException.toString());
      }
    }
    AppMethodBeat.o(219222);
  }
  
  protected final void fKi()
  {
    AppMethodBeat.i(219221);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.KqB.paddingLeft, (int)this.KqB.paddingTop, (int)this.KqB.paddingRight, (int)this.KqB.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(219221);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(219224);
    View localView = this.contentView;
    this.rR = ((TextView)localView.findViewById(i.f.txt));
    this.KsZ = ((WeImageView)localView.findViewById(i.f.icon));
    localView.setOnClickListener(this);
    AppMethodBeat.o(219224);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_share_comp;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(219226);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageShareComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.Kta += 1;
    if ((this.mContext instanceof SnsAdNativeLandingPagesUI)) {
      ((SnsAdNativeLandingPagesUI)this.mContext).fVf();
    }
    a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageShareComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(219226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af
 * JD-Core Version:    0.7.0.1
 */