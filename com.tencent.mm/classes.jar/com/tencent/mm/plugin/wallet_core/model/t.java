package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.et;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class t
{
  public String Ahq;
  public String Ahr;
  public String doh;
  
  public static t bc(JSONObject paramJSONObject)
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
      localt.doh = paramJSONObject.optString("wording");
      localt.Ahq = paramJSONObject.optString("btn_cancel");
      localt.Ahr = paramJSONObject.optString("btn_confirm");
      AppMethodBeat.o(70406);
      return localt;
    }
    catch (Exception paramJSONObject)
    {
      ad.e("MicroMsg.UnderAgeDialog", "parseUnderAgeDialogFromJson Exception:%s %s", new Object[] { paramJSONObject.getClass().getSimpleName(), paramJSONObject.getMessage() });
      AppMethodBeat.o(70406);
    }
    return null;
  }
  
  public static void sw(int paramInt)
  {
    AppMethodBeat.i(70407);
    et localet = new et();
    localet.dFd = paramInt;
    localet.aBj();
    AppMethodBeat.o(70407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.t
 * JD-Core Version:    0.7.0.1
 */