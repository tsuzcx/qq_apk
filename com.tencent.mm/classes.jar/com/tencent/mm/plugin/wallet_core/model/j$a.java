package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class j$a
{
  public Orders.ShowInfo VFK;
  public int id;
  
  public static a co(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70281);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(70281);
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
      localShowInfo.VIN = paramJSONObject.optInt("value_attr");
      localShowInfo.ICv = paramJSONObject.optString("name_color");
      localShowInfo.VII = paramJSONObject.optString("value_color");
      locala.VFK = localShowInfo;
    }
    AppMethodBeat.o(70281);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.j.a
 * JD-Core Version:    0.7.0.1
 */