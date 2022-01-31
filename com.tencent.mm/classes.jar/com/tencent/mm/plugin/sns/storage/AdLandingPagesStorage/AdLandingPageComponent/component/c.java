package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
{
  int clickCount;
  LinearLayout mDJ;
  private ImageView ruP;
  private ImageView ruQ;
  private TextView ruR;
  LinearLayout ruS;
  
  public c(Context paramContext, d paramd, ViewGroup paramViewGroup)
  {
    super(paramContext, paramd, paramViewGroup);
  }
  
  public final boolean aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(37037);
    if (!super.aq(paramJSONObject))
    {
      AppMethodBeat.o(37037);
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      AppMethodBeat.o(37037);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ab.printErrStackTrace("AdLandingBorderedComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(37037);
    }
    return false;
  }
  
  public final void cqK()
  {
    AppMethodBeat.i(37036);
    if (((d)this.rve).rrT.isEmpty())
    {
      AppMethodBeat.o(37036);
      return;
    }
    View localView = this.contentView;
    this.ruP = ((ImageView)localView.findViewById(2131822804));
    this.ruQ = ((ImageView)localView.findViewById(2131821555));
    this.ruR = ((TextView)localView.findViewById(2131821115));
    this.mDJ = ((LinearLayout)localView.findViewById(2131821084));
    this.ruS = ((LinearLayout)localView.findViewById(2131827856));
    AppMethodBeat.o(37036);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37035);
    this.ruR.setText((CharSequence)((d)this.rve).rrT.get(0));
    if (((d)this.rve).rsM)
    {
      this.ruP.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2130840549));
      this.ruQ.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2130840170));
      this.ruR.setTextColor(-16777216);
      this.ruS.setBackgroundResource(2130837666);
    }
    for (;;)
    {
      this.ruS.setPadding((int)((d)this.rve).paddingLeft, 0, (int)((d)this.rve).paddingRight, 0);
      this.mDJ.setPadding(0, (int)((d)this.rve).paddingTop, 0, (int)((d)this.rve).paddingBottom);
      a(this.ruS);
      this.ruS.setOnClickListener(new c.1(this));
      AppMethodBeat.o(37035);
      return;
      this.ruP.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2130840548));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c
 * JD-Core Version:    0.7.0.1
 */