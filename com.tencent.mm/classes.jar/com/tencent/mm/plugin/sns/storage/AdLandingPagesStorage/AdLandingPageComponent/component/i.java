package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
  extends a
{
  private LinearLayout Api;
  private ImageView QNl;
  private LinearLayout QNm;
  j QOk;
  private View QOl;
  private ImageView QOm;
  int clickCount;
  private TextView pmf;
  
  public i(Context paramContext, j paramj, ViewGroup paramViewGroup)
  {
    super(paramContext, paramj, paramViewGroup);
    this.QOk = paramj;
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(96458);
    View localView = this.contentView;
    this.QOm = ((ImageView)localView.findViewById(b.f.left_icon));
    this.QNl = ((ImageView)localView.findViewById(b.f.right_arrow));
    this.pmf = ((TextView)localView.findViewById(b.f.desc));
    this.QNm = ((LinearLayout)localView.findViewById(b.f.innter_container));
    this.Api = ((LinearLayout)localView.findViewById(b.f.container));
    this.QOl = this.QNm;
    AppMethodBeat.o(96458);
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96460);
    if (!super.bP(paramJSONObject))
    {
      AppMethodBeat.o(96460);
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      AppMethodBeat.o(96460);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("AdLandingBorderedComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96460);
    }
    return false;
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_lbs;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96459);
    this.pmf.setText(this.QOk.QJC.KbZ);
    if (this.QOk.QKK)
    {
      this.QOm.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.e.lbs_w));
      this.QNl.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.e.right_arrow_w));
      this.pmf.setTextColor(-16777216);
      this.QNm.setBackgroundResource(b.e.adlanding_comp_click_dark);
    }
    for (;;)
    {
      this.QNm.setPadding((int)this.QOk.paddingLeft, 0, (int)this.QOk.paddingRight, 0);
      this.Api.setPadding(0, (int)this.QOk.paddingTop, 0, (int)this.QOk.paddingBottom);
      f(this.QNm);
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96457);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingLbsComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = i.this;
          paramAnonymousView.clickCount += 1;
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("map_view_type", 1);
          paramAnonymousView.putExtra("kwebmap_slat", i.this.QOk.QJC.KbW);
          paramAnonymousView.putExtra("kwebmap_lng", i.this.QOk.QJC.KbX);
          paramAnonymousView.putExtra("kwebmap_scale", i.this.QOk.QJC.hQp);
          paramAnonymousView.putExtra("kPoiName", i.this.QOk.QJC.hVI);
          paramAnonymousView.putExtra("Kwebmap_locaion", i.this.QOk.QJC.KbZ);
          Log.i("AdLandingBorderedComp", "locatint to slat " + i.this.QOk.QJC.KbW + ", slong " + i.this.QOk.QJC.KbX + ", " + i.this.QOk.QJC.hVI);
          c.b(i.this.context, "location", ".ui.RedirectUI", paramAnonymousView, 2002);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingLbsComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96457);
        }
      };
      if (this.QOl != null) {
        this.QOl.setOnClickListener(local1);
      }
      AppMethodBeat.o(96459);
      return;
      this.QOm.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.e.lbs));
      this.QNl.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.e.right_arrow));
      this.pmf.setTextColor(-1);
      this.QNm.setBackgroundResource(b.e.adlanding_comp_click_light);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i
 * JD-Core Version:    0.7.0.1
 */