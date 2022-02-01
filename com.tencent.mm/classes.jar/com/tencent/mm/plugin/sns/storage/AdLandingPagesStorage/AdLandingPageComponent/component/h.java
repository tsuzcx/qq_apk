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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i.a;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends a
{
  int clickCount;
  private TextView hJR;
  private LinearLayout qlu;
  private ImageView wYW;
  private LinearLayout wYX;
  i wZM;
  private View wZN;
  private ImageView wZO;
  
  public h(Context paramContext, i parami, ViewGroup paramViewGroup)
  {
    super(paramContext, parami, paramViewGroup);
    this.wZM = parami;
  }
  
  public final boolean aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96460);
    if (!super.aG(paramJSONObject))
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
  
  protected final void dvN()
  {
    AppMethodBeat.i(96459);
    this.hJR.setText(this.wZM.wVJ.sOy);
    if (this.wZM.wWI)
    {
      this.wZO.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131232854));
      this.wYW.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131233863));
      this.hJR.setTextColor(-16777216);
      this.wYX.setBackgroundResource(2131230900);
    }
    for (;;)
    {
      this.wYX.setPadding((int)this.wZM.paddingLeft, 0, (int)this.wZM.paddingRight, 0);
      this.qlu.setPadding(0, (int)this.wZM.paddingTop, 0, (int)this.wZM.paddingBottom);
      a(this.wYX);
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96457);
          paramAnonymousView = h.this;
          paramAnonymousView.clickCount += 1;
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("map_view_type", 1);
          paramAnonymousView.putExtra("kwebmap_slat", h.this.wZM.wVJ.sOv);
          paramAnonymousView.putExtra("kwebmap_lng", h.this.wZM.wVJ.sOw);
          paramAnonymousView.putExtra("kwebmap_scale", h.this.wZM.wVJ.dpd);
          paramAnonymousView.putExtra("kPoiName", h.this.wZM.wVJ.dtN);
          paramAnonymousView.putExtra("Kwebmap_locaion", h.this.wZM.wVJ.sOy);
          ad.i("AdLandingBorderedComp", "locatint to slat " + h.this.wZM.wVJ.sOv + ", slong " + h.this.wZM.wVJ.sOw + ", " + h.this.wZM.wVJ.dtN);
          d.b(h.this.context, "location", ".ui.RedirectUI", paramAnonymousView, 2);
          AppMethodBeat.o(96457);
        }
      };
      if (this.wZN != null) {
        this.wZN.setOnClickListener(local1);
      }
      AppMethodBeat.o(96459);
      return;
      this.wZO.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131232850));
      this.wYW.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131233862));
      this.hJR.setTextColor(-1);
      this.wYX.setBackgroundResource(2131230901);
    }
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(96458);
    View localView = this.contentView;
    this.wZO = ((ImageView)localView.findViewById(2131301384));
    this.wYW = ((ImageView)localView.findViewById(2131304172));
    this.hJR = ((TextView)localView.findViewById(2131298996));
    this.wYX = ((LinearLayout)localView.findViewById(2131301023));
    this.qlu = ((LinearLayout)localView.findViewById(2131298736));
    this.wZN = this.wYX;
    AppMethodBeat.o(96458);
  }
  
  protected final int getLayout()
  {
    return 2131495503;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h
 * JD-Core Version:    0.7.0.1
 */