package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ho;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class u
{
  public String DrI;
  public String DrJ;
  public String dyI;
  
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
      localu.dyI = paramJSONObject.optString("wording");
      localu.DrI = paramJSONObject.optString("btn_cancel");
      localu.DrJ = paramJSONObject.optString("btn_confirm");
      AppMethodBeat.o(70406);
      return localu;
    }
    catch (Exception paramJSONObject)
    {
      ae.e("MicroMsg.UnderAgeDialog", "parseUnderAgeDialogFromJson Exception:%s %s", new Object[] { paramJSONObject.getClass().getSimpleName(), paramJSONObject.getMessage() });
      AppMethodBeat.o(70406);
    }
    return null;
  }
  
  public static void tW(int paramInt)
  {
    AppMethodBeat.i(70407);
    ho localho = new ho();
    localho.dQB = paramInt;
    localho.aLH();
    AppMethodBeat.o(70407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.u
 * JD-Core Version:    0.7.0.1
 */