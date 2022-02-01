package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ob;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class v
{
  public String OTf;
  public String OTg;
  public String wording;
  
  public static void Bv(int paramInt)
  {
    AppMethodBeat.i(70407);
    ob localob = new ob();
    localob.gef = paramInt;
    localob.bpa();
    AppMethodBeat.o(70407);
  }
  
  public static v bX(JSONObject paramJSONObject)
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
      localv.OTf = paramJSONObject.optString("btn_cancel");
      localv.OTg = paramJSONObject.optString("btn_confirm");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.v
 * JD-Core Version:    0.7.0.1
 */