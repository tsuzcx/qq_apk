package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lf;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class u
{
  public String IaU;
  public String IaV;
  public String dQx;
  
  public static u bM(JSONObject paramJSONObject)
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
      u localu = new u();
      localu.dQx = paramJSONObject.optString("wording");
      localu.IaU = paramJSONObject.optString("btn_cancel");
      localu.IaV = paramJSONObject.optString("btn_confirm");
      AppMethodBeat.o(70406);
      return localu;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.UnderAgeDialog", "parseUnderAgeDialogFromJson Exception:%s %s", new Object[] { paramJSONObject.getClass().getSimpleName(), paramJSONObject.getMessage() });
      AppMethodBeat.o(70406);
    }
    return null;
  }
  
  public static void xV(int paramInt)
  {
    AppMethodBeat.i(70407);
    lf locallf = new lf();
    locallf.ejA = paramInt;
    locallf.bfK();
    AppMethodBeat.o(70407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.u
 * JD-Core Version:    0.7.0.1
 */