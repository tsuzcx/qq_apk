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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
  extends a
{
  private ImageView EbJ;
  private LinearLayout EbK;
  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i EcB;
  private View EcC;
  private ImageView EcD;
  int clickCount;
  private TextView jCB;
  private LinearLayout tmh;
  
  public i(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i parami, ViewGroup paramViewGroup)
  {
    super(paramContext, parami, paramViewGroup);
    this.EcB = parami;
  }
  
  public final boolean bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96460);
    if (!super.bp(paramJSONObject))
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
  
  protected final void eWT()
  {
    AppMethodBeat.i(96459);
    this.jCB.setText(this.EcB.DYc.yFx);
    if (this.EcB.DZm)
    {
      this.EcD.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131233309));
      this.EbJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131234687));
      this.jCB.setTextColor(-16777216);
      this.EbK.setBackgroundResource(2131230920);
    }
    for (;;)
    {
      this.EbK.setPadding((int)this.EcB.paddingLeft, 0, (int)this.EcB.paddingRight, 0);
      this.tmh.setPadding(0, (int)this.EcB.paddingTop, 0, (int)this.EcB.paddingBottom);
      a(this.EbK);
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96457);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingLbsComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = i.this;
          paramAnonymousView.clickCount += 1;
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("map_view_type", 1);
          paramAnonymousView.putExtra("kwebmap_slat", i.this.EcB.DYc.yFu);
          paramAnonymousView.putExtra("kwebmap_lng", i.this.EcB.DYc.yFv);
          paramAnonymousView.putExtra("kwebmap_scale", i.this.EcB.DYc.dRt);
          paramAnonymousView.putExtra("kPoiName", i.this.EcB.DYc.dWi);
          paramAnonymousView.putExtra("Kwebmap_locaion", i.this.EcB.DYc.yFx);
          Log.i("AdLandingBorderedComp", "locatint to slat " + i.this.EcB.DYc.yFu + ", slong " + i.this.EcB.DYc.yFv + ", " + i.this.EcB.DYc.dWi);
          c.b(i.this.context, "location", ".ui.RedirectUI", paramAnonymousView, 2002);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingLbsComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96457);
        }
      };
      if (this.EcC != null) {
        this.EcC.setOnClickListener(local1);
      }
      AppMethodBeat.o(96459);
      return;
      this.EcD.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131233305));
      this.EbJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131234686));
      this.jCB.setTextColor(-1);
      this.EbK.setBackgroundResource(2131230921);
    }
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(96458);
    View localView = this.contentView;
    this.EcD = ((ImageView)localView.findViewById(2131303139));
    this.EbJ = ((ImageView)localView.findViewById(2131307076));
    this.jCB = ((TextView)localView.findViewById(2131299495));
    this.EbK = ((LinearLayout)localView.findViewById(2131302668));
    this.tmh = ((LinearLayout)localView.findViewById(2131299174));
    this.EcC = this.EbK;
    AppMethodBeat.o(96458);
  }
  
  protected final int getLayout()
  {
    return 2131496388;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i
 * JD-Core Version:    0.7.0.1
 */