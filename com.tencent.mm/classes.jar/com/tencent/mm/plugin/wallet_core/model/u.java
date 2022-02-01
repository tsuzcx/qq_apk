package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hm;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class u
{
  public String Dad;
  public String Dae;
  public String dxD;
  
  public static u bm(JSONObject paramJSONObject)
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
      localu.dxD = paramJSONObject.optString("wording");
      localu.Dad = paramJSONObject.optString("btn_cancel");
      localu.Dae = paramJSONObject.optString("btn_confirm");
      AppMethodBeat.o(70406);
      return localu;
    }
    catch (Exception paramJSONObject)
    {
      ad.e("MicroMsg.UnderAgeDialog", "parseUnderAgeDialogFromJson Exception:%s %s", new Object[] { paramJSONObject.getClass().getSimpleName(), paramJSONObject.getMessage() });
      AppMethodBeat.o(70406);
    }
    return null;
  }
  
  public static void tQ(int paramInt)
  {
    AppMethodBeat.i(70407);
    hm localhm = new hm();
    localhm.dPl = paramInt;
    localhm.aLk();
    AppMethodBeat.o(70407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.u
 * JD-Core Version:    0.7.0.1
 */