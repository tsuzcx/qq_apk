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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i.a;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends a
{
  int clickCount;
  private TextView ikp;
  private LinearLayout qTW;
  private ImageView ylK;
  private LinearLayout ylL;
  private View ymA;
  private ImageView ymB;
  i ymz;
  
  public h(Context paramContext, i parami, ViewGroup paramViewGroup)
  {
    super(paramContext, parami, paramViewGroup);
    this.ymz = parami;
  }
  
  public final boolean aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96460);
    if (!super.aH(paramJSONObject))
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
      ac.printErrStackTrace("AdLandingBorderedComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96460);
    }
    return false;
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(96458);
    View localView = this.contentView;
    this.ymB = ((ImageView)localView.findViewById(2131301384));
    this.ylK = ((ImageView)localView.findViewById(2131304172));
    this.ikp = ((TextView)localView.findViewById(2131298996));
    this.ylL = ((LinearLayout)localView.findViewById(2131301023));
    this.qTW = ((LinearLayout)localView.findViewById(2131298736));
    this.ymA = this.ylL;
    AppMethodBeat.o(96458);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96459);
    this.ikp.setText(this.ymz.yix.tWL);
    if (this.ymz.yjw)
    {
      this.ymB.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131232854));
      this.ylK.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131233863));
      this.ikp.setTextColor(-16777216);
      this.ylL.setBackgroundResource(2131230900);
    }
    for (;;)
    {
      this.ylL.setPadding((int)this.ymz.paddingLeft, 0, (int)this.ymz.paddingRight, 0);
      this.qTW.setPadding(0, (int)this.ymz.paddingTop, 0, (int)this.ymz.paddingBottom);
      a(this.ylL);
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96457);
          paramAnonymousView = h.this;
          paramAnonymousView.clickCount += 1;
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("map_view_type", 1);
          paramAnonymousView.putExtra("kwebmap_slat", h.this.ymz.yix.tWI);
          paramAnonymousView.putExtra("kwebmap_lng", h.this.ymz.yix.tWJ);
          paramAnonymousView.putExtra("kwebmap_scale", h.this.ymz.yix.dmN);
          paramAnonymousView.putExtra("kPoiName", h.this.ymz.yix.dry);
          paramAnonymousView.putExtra("Kwebmap_locaion", h.this.ymz.yix.tWL);
          ac.i("AdLandingBorderedComp", "locatint to slat " + h.this.ymz.yix.tWI + ", slong " + h.this.ymz.yix.tWJ + ", " + h.this.ymz.yix.dry);
          d.b(h.this.context, "location", ".ui.RedirectUI", paramAnonymousView, 2);
          AppMethodBeat.o(96457);
        }
      };
      if (this.ymA != null) {
        this.ymA.setOnClickListener(local1);
      }
      AppMethodBeat.o(96459);
      return;
      this.ymB.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131232850));
      this.ylK.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131233862));
      this.ikp.setTextColor(-1);
      this.ylL.setBackgroundResource(2131230901);
    }
  }
  
  protected final int getLayout()
  {
    return 2131495503;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h
 * JD-Core Version:    0.7.0.1
 */