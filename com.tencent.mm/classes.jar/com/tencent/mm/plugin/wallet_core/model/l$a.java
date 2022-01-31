package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class l$a
{
  public int id;
  public Orders.ShowInfo uic;
  
  public static a aE(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46764);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(46764);
      return null;
    }
    a locala = new a();
    locala.id = paramJSONObject.optInt("id");
    paramJSONObject = paramJSONObject.optJSONObject("show_info");
    if (paramJSONObject != null)
    {
      Orders.ShowInfo localShowInfo = new Orders.ShowInfo();
      localShowInfo.name = paramJSONObject.optString("name");
      localShowInfo.value = paramJSONObject.optString("value");
      localShowInfo.ukF = paramJSONObject.optInt("value_attr");
      localShowInfo.nmk = paramJSONObject.optString("name_color");
      localShowInfo.ukA = paramJSONObject.optString("value_color");
      locala.uic = localShowInfo;
    }
    AppMethodBeat.o(46764);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.l.a
 * JD-Core Version:    0.7.0.1
 */