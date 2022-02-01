package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.rt;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class v
{
  public String VJm;
  public String VJn;
  public String wording;
  
  public static void BI(int paramInt)
  {
    AppMethodBeat.i(70407);
    rt localrt = new rt();
    localrt.ikE = paramInt;
    localrt.bMH();
    AppMethodBeat.o(70407);
  }
  
  public static v ct(JSONObject paramJSONObject)
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
      v localv = new v();
      localv.wording = paramJSONObject.optString("wording");
      localv.VJm = paramJSONObject.optString("btn_cancel");
      localv.VJn = paramJSONObject.optString("btn_confirm");
      AppMethodBeat.o(70406);
      return localv;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.UnderAgeDialog", "parseUnderAgeDialogFromJson Exception:%s %s", new Object[] { paramJSONObject.getClass().getSimpleName(), paramJSONObject.getMessage() });
      AppMethodBeat.o(70406);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.v
 * JD-Core Version:    0.7.0.1
 */