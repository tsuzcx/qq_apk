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
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class ai
  extends n
  implements View.OnClickListener
{
  private int QRA = 0;
  private WeImageView QRz;
  private Context mContext;
  private TextView sQ;
  
  public ai(Context paramContext, ag paramag, ViewGroup paramViewGroup)
  {
    super(paramContext, paramag, paramViewGroup);
    this.mContext = paramContext;
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(306944);
    View localView = this.contentView;
    this.sQ = ((TextView)localView.findViewById(b.f.txt));
    this.QRz = ((WeImageView)localView.findViewById(b.f.icon));
    localView.setOnClickListener(this);
    AppMethodBeat.o(306944);
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(306952);
    if (!super.bP(paramJSONObject))
    {
      AppMethodBeat.o(306952);
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.QRA);
      AppMethodBeat.o(306952);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.Sns.AdLandingPageShareComponent", "setComponentKVReportData exp=" + paramJSONObject.toString());
      AppMethodBeat.o(306952);
    }
    return false;
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_share_comp;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(306938);
    ag localag = (ag)this.QOV;
    this.sQ.setText(localag.QLj);
    if (!TextUtils.isEmpty(localag.QJR)) {
      try
      {
        int i = Color.parseColor(localag.QJR);
        this.sQ.setTextColor(i);
        this.QRz.setIconColor(i);
        AppMethodBeat.o(306938);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Sns.AdLandingPageShareComponent", "parseColor exp=" + localException.toString());
      }
    }
    AppMethodBeat.o(306938);
  }
  
  protected final void hal()
  {
    AppMethodBeat.i(306929);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.QOV.paddingLeft, (int)this.QOV.paddingTop, (int)this.QOV.paddingRight, (int)this.QOV.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(306929);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(306949);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageShareComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.QRA += 1;
    if ((this.mContext instanceof SnsAdNativeLandingPagesUI)) {
      ((SnsAdNativeLandingPagesUI)this.mContext).hnw();
    }
    a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageShareComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(306949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai
 * JD-Core Version:    0.7.0.1
 */