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
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i.a;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
  extends a
{
  int clickCount;
  private TextView iDG;
  private LinearLayout rEk;
  private LinearLayout zCA;
  private ImageView zCz;
  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i zDs;
  private View zDt;
  private ImageView zDu;
  
  public i(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i parami, ViewGroup paramViewGroup)
  {
    super(paramContext, parami, paramViewGroup);
    this.zDs = parami;
  }
  
  public final boolean aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96460);
    if (!super.aQ(paramJSONObject))
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
      ad.printErrStackTrace("AdLandingBorderedComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96460);
    }
    return false;
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(96458);
    View localView = this.contentView;
    this.zDu = ((ImageView)localView.findViewById(2131301384));
    this.zCz = ((ImageView)localView.findViewById(2131304172));
    this.iDG = ((TextView)localView.findViewById(2131298996));
    this.zCA = ((LinearLayout)localView.findViewById(2131301023));
    this.rEk = ((LinearLayout)localView.findViewById(2131298736));
    this.zDt = this.zCA;
    AppMethodBeat.o(96458);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96459);
    this.iDG.setText(this.zDs.zyF.uZu);
    if (this.zDs.zAk)
    {
      this.zDu.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131232854));
      this.zCz.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131233863));
      this.iDG.setTextColor(-16777216);
      this.zCA.setBackgroundResource(2131230900);
    }
    for (;;)
    {
      this.zCA.setPadding((int)this.zDs.paddingLeft, 0, (int)this.zDs.paddingRight, 0);
      this.rEk.setPadding(0, (int)this.zDs.paddingTop, 0, (int)this.zDs.paddingBottom);
      a(this.zCA);
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96457);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingLbsComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = i.this;
          paramAnonymousView.clickCount += 1;
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("map_view_type", 1);
          paramAnonymousView.putExtra("kwebmap_slat", i.this.zDs.zyF.uZr);
          paramAnonymousView.putExtra("kwebmap_lng", i.this.zDs.zyF.uZs);
          paramAnonymousView.putExtra("kwebmap_scale", i.this.zDs.zyF.dyB);
          paramAnonymousView.putExtra("kPoiName", i.this.zDs.zyF.dDq);
          paramAnonymousView.putExtra("Kwebmap_locaion", i.this.zDs.zyF.uZu);
          ad.i("AdLandingBorderedComp", "locatint to slat " + i.this.zDs.zyF.uZr + ", slong " + i.this.zDs.zyF.uZs + ", " + i.this.zDs.zyF.dDq);
          d.b(i.this.context, "location", ".ui.RedirectUI", paramAnonymousView, 2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingLbsComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96457);
        }
      };
      if (this.zDt != null) {
        this.zDt.setOnClickListener(local1);
      }
      AppMethodBeat.o(96459);
      return;
      this.zDu.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131232850));
      this.zCz.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131233862));
      this.iDG.setTextColor(-1);
      this.zCA.setBackgroundResource(2131230901);
    }
  }
  
  protected final int getLayout()
  {
    return 2131495503;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i
 * JD-Core Version:    0.7.0.1
 */