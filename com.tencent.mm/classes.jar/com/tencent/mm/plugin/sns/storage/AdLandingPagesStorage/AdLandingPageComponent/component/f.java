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
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends a
{
  int clickCount;
  private LinearLayout mDJ;
  private ImageView ruQ;
  private TextView ruR;
  private LinearLayout ruS;
  g ruZ;
  private View rva;
  private ImageView rvb;
  
  public f(Context paramContext, g paramg, ViewGroup paramViewGroup)
  {
    super(paramContext, paramg, paramViewGroup);
    this.ruZ = paramg;
  }
  
  public final boolean aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(37060);
    if (!super.aq(paramJSONObject))
    {
      AppMethodBeat.o(37060);
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      AppMethodBeat.o(37060);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ab.printErrStackTrace("AdLandingBorderedComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(37060);
    }
    return false;
  }
  
  public final void cqK()
  {
    AppMethodBeat.i(37058);
    View localView = this.contentView;
    this.rvb = ((ImageView)localView.findViewById(2131822804));
    this.ruQ = ((ImageView)localView.findViewById(2131821555));
    this.ruR = ((TextView)localView.findViewById(2131821115));
    this.ruS = ((LinearLayout)localView.findViewById(2131827856));
    this.mDJ = ((LinearLayout)localView.findViewById(2131821084));
    this.rva = this.ruS;
    AppMethodBeat.o(37058);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37059);
    this.ruR.setText(this.ruZ.rrV.nZY);
    if (this.ruZ.rsM)
    {
      this.rvb.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2130839267));
      this.ruQ.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2130840170));
      this.ruR.setTextColor(-16777216);
      this.ruS.setBackgroundResource(2130837666);
    }
    for (;;)
    {
      this.ruS.setPadding((int)this.ruZ.paddingLeft, 0, (int)this.ruZ.paddingRight, 0);
      this.mDJ.setPadding(0, (int)this.ruZ.paddingTop, 0, (int)this.ruZ.paddingBottom);
      a(this.ruS);
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37057);
          paramAnonymousView = f.this;
          paramAnonymousView.clickCount += 1;
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("map_view_type", 1);
          paramAnonymousView.putExtra("kwebmap_slat", f.this.ruZ.rrV.nZV);
          paramAnonymousView.putExtra("kwebmap_lng", f.this.ruZ.rrV.nZW);
          paramAnonymousView.putExtra("kwebmap_scale", f.this.ruZ.rrV.cyX);
          paramAnonymousView.putExtra("kPoiName", f.this.ruZ.rrV.cDl);
          paramAnonymousView.putExtra("Kwebmap_locaion", f.this.ruZ.rrV.nZY);
          ab.i("AdLandingBorderedComp", "locatint to slat " + f.this.ruZ.rrV.nZV + ", slong " + f.this.ruZ.rrV.nZW + ", " + f.this.ruZ.rrV.cDl);
          d.b(f.this.context, "location", ".ui.RedirectUI", paramAnonymousView, 2);
          AppMethodBeat.o(37057);
        }
      };
      if (this.rva != null) {
        this.rva.setOnClickListener(local1);
      }
      AppMethodBeat.o(37059);
      return;
      this.rvb.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2130839263));
      this.ruQ.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2130840169));
      this.ruR.setTextColor(-1);
      this.ruS.setBackgroundResource(2130837667);
    }
  }
  
  protected final int getLayout()
  {
    return 2130970783;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f
 * JD-Core Version:    0.7.0.1
 */