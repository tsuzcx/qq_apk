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
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i.a;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
  extends a
{
  int clickCount;
  private TextView iGz;
  private LinearLayout rMv;
  private ImageView zTB;
  private LinearLayout zTC;
  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i zUu;
  private View zUv;
  private ImageView zUw;
  
  public i(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i parami, ViewGroup paramViewGroup)
  {
    super(paramContext, parami, paramViewGroup);
    this.zUu = parami;
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
      ae.printErrStackTrace("AdLandingBorderedComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96460);
    }
    return false;
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(96458);
    View localView = this.contentView;
    this.zUw = ((ImageView)localView.findViewById(2131301384));
    this.zTB = ((ImageView)localView.findViewById(2131304172));
    this.iGz = ((TextView)localView.findViewById(2131298996));
    this.zTC = ((LinearLayout)localView.findViewById(2131301023));
    this.rMv = ((LinearLayout)localView.findViewById(2131298736));
    this.zUv = this.zTC;
    AppMethodBeat.o(96458);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96459);
    this.iGz.setText(this.zUu.zQe.vlF);
    if (this.zUu.zRk)
    {
      this.zUw.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131232854));
      this.zTB.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131233863));
      this.iGz.setTextColor(-16777216);
      this.zTC.setBackgroundResource(2131230900);
    }
    for (;;)
    {
      this.zTC.setPadding((int)this.zUu.paddingLeft, 0, (int)this.zUu.paddingRight, 0);
      this.rMv.setPadding(0, (int)this.zUu.paddingTop, 0, (int)this.zUu.paddingBottom);
      a(this.zTC);
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96457);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingLbsComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = i.this;
          paramAnonymousView.clickCount += 1;
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("map_view_type", 1);
          paramAnonymousView.putExtra("kwebmap_slat", i.this.zUu.zQe.vlC);
          paramAnonymousView.putExtra("kwebmap_lng", i.this.zUu.zQe.vlD);
          paramAnonymousView.putExtra("kwebmap_scale", i.this.zUu.zQe.dzG);
          paramAnonymousView.putExtra("kPoiName", i.this.zUu.zQe.dEv);
          paramAnonymousView.putExtra("Kwebmap_locaion", i.this.zUu.zQe.vlF);
          ae.i("AdLandingBorderedComp", "locatint to slat " + i.this.zUu.zQe.vlC + ", slong " + i.this.zUu.zQe.vlD + ", " + i.this.zUu.zQe.dEv);
          d.b(i.this.context, "location", ".ui.RedirectUI", paramAnonymousView, 2002);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingLbsComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96457);
        }
      };
      if (this.zUv != null) {
        this.zUv.setOnClickListener(local1);
      }
      AppMethodBeat.o(96459);
      return;
      this.zUw.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131232850));
      this.zTB.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131233862));
      this.iGz.setTextColor(-1);
      this.zTC.setBackgroundResource(2131230901);
    }
  }
  
  protected final int getLayout()
  {
    return 2131495503;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i
 * JD-Core Version:    0.7.0.1
 */