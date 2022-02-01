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
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
  extends a
{
  private ImageView Kpe;
  private LinearLayout Kpf;
  j Kqd;
  private View Kqe;
  private ImageView Kqf;
  int clickCount;
  private TextView msF;
  private LinearLayout wSF;
  
  public i(Context paramContext, j paramj, ViewGroup paramViewGroup)
  {
    super(paramContext, paramj, paramViewGroup);
    this.Kqd = paramj;
  }
  
  public final boolean by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96460);
    if (!super.by(paramJSONObject))
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
  
  protected final void fKe()
  {
    AppMethodBeat.i(96459);
    this.msF.setText(this.Kqd.Klv.Ejq);
    if (this.Kqd.KmF)
    {
      this.Kqf.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.e.lbs_w));
      this.Kpe.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.e.right_arrow_w));
      this.msF.setTextColor(-16777216);
      this.Kpf.setBackgroundResource(i.e.adlanding_comp_click_dark);
    }
    for (;;)
    {
      this.Kpf.setPadding((int)this.Kqd.paddingLeft, 0, (int)this.Kqd.paddingRight, 0);
      this.wSF.setPadding(0, (int)this.Kqd.paddingTop, 0, (int)this.Kqd.paddingBottom);
      d(this.Kpf);
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96457);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingLbsComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = i.this;
          paramAnonymousView.clickCount += 1;
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("map_view_type", 1);
          paramAnonymousView.putExtra("kwebmap_slat", i.this.Kqd.Klv.Ejn);
          paramAnonymousView.putExtra("kwebmap_lng", i.this.Kqd.Klv.Ejo);
          paramAnonymousView.putExtra("kwebmap_scale", i.this.Kqd.Klv.fKJ);
          paramAnonymousView.putExtra("kPoiName", i.this.Kqd.Klv.fPN);
          paramAnonymousView.putExtra("Kwebmap_locaion", i.this.Kqd.Klv.Ejq);
          Log.i("AdLandingBorderedComp", "locatint to slat " + i.this.Kqd.Klv.Ejn + ", slong " + i.this.Kqd.Klv.Ejo + ", " + i.this.Kqd.Klv.fPN);
          c.b(i.this.context, "location", ".ui.RedirectUI", paramAnonymousView, 2002);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingLbsComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96457);
        }
      };
      if (this.Kqe != null) {
        this.Kqe.setOnClickListener(local1);
      }
      AppMethodBeat.o(96459);
      return;
      this.Kqf.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.e.lbs));
      this.Kpe.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.e.right_arrow));
      this.msF.setTextColor(-1);
      this.Kpf.setBackgroundResource(i.e.adlanding_comp_click_light);
    }
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(96458);
    View localView = this.contentView;
    this.Kqf = ((ImageView)localView.findViewById(i.f.left_icon));
    this.Kpe = ((ImageView)localView.findViewById(i.f.right_arrow));
    this.msF = ((TextView)localView.findViewById(i.f.desc));
    this.Kpf = ((LinearLayout)localView.findViewById(i.f.innter_container));
    this.wSF = ((LinearLayout)localView.findViewById(i.f.container));
    this.Kqe = this.Kpf;
    AppMethodBeat.o(96458);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_lbs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i
 * JD-Core Version:    0.7.0.1
 */