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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class ag
  extends m
  implements View.OnClickListener
{
  private WeImageView EfX;
  private int EfY = 0;
  private TextView Ws;
  private Context mContext;
  
  public ag(Context paramContext, af paramaf, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaf, paramViewGroup);
    this.mContext = paramContext;
  }
  
  public final boolean bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(203022);
    if (!super.bp(paramJSONObject))
    {
      AppMethodBeat.o(203022);
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.EfY);
      AppMethodBeat.o(203022);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.Sns.AdLandingPageShareComponent", "setComponentKVReportData exp=" + paramJSONObject.toString());
      AppMethodBeat.o(203022);
    }
    return false;
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(203019);
    af localaf = (af)this.EcX;
    this.Ws.setText(localaf.DZJ);
    if (!TextUtils.isEmpty(localaf.DYt)) {
      try
      {
        int i = Color.parseColor(localaf.DYt);
        this.Ws.setTextColor(i);
        this.EfX.setIconColor(i);
        AppMethodBeat.o(203019);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Sns.AdLandingPageShareComponent", "parseColor exp=" + localException.toString());
      }
    }
    AppMethodBeat.o(203019);
  }
  
  protected final void eWX()
  {
    AppMethodBeat.i(203018);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.EcX.paddingLeft, (int)this.EcX.paddingTop, (int)this.EcX.paddingRight, (int)this.EcX.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(203018);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(203020);
    View localView = this.contentView;
    this.Ws = ((TextView)localView.findViewById(2131309554));
    this.EfX = ((WeImageView)localView.findViewById(2131302468));
    localView.setOnClickListener(this);
    AppMethodBeat.o(203020);
  }
  
  protected final int getLayout()
  {
    return 2131496393;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203021);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageShareComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.EfY += 1;
    if ((this.mContext instanceof SnsAdNativeLandingPagesUI)) {
      ((SnsAdNativeLandingPagesUI)this.mContext).fgY();
    }
    a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageShareComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(203021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag
 * JD-Core Version:    0.7.0.1
 */