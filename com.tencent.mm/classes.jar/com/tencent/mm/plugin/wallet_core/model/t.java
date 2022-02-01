package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gj;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class t
{
  public String BzK;
  public String BzL;
  public String dlQ;
  
  public static t bd(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70406);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(70406);
      return null;
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("under_age_dialog");
      if (paramJSONObject == null)
      {
        AppMethodBeat.o(70406);
        return null;
      }
      t localt = new t();
      localt.dlQ = paramJSONObject.optString("wording");
      localt.BzK = paramJSONObject.optString("btn_cancel");
      localt.BzL = paramJSONObject.optString("btn_confirm");
      AppMethodBeat.o(70406);
      return localt;
    }
    catch (Exception paramJSONObject)
    {
      ac.e("MicroMsg.UnderAgeDialog", "parseUnderAgeDialogFromJson Exception:%s %s", new Object[] { paramJSONObject.getClass().getSimpleName(), paramJSONObject.getMessage() });
      AppMethodBeat.o(70406);
    }
    return null;
  }
  
  public static void tn(int paramInt)
  {
    AppMethodBeat.i(70407);
    gj localgj = new gj();
    localgj.dCQ = paramInt;
    localgj.aHZ();
    AppMethodBeat.o(70407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.t
 * JD-Core Version:    0.7.0.1
 */