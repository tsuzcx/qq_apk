package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class j$a
{
  public Orders.ShowInfo Aej;
  public int id;
  
  public static a aZ(JSONObject paramJSONObject)
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
      localShowInfo.AgR = paramJSONObject.optInt("value_attr");
      localShowInfo.rVi = paramJSONObject.optString("name_color");
      localShowInfo.AgM = paramJSONObject.optString("value_color");
      locala.Aej = localShowInfo;
    }
    AppMethodBeat.o(70281);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.j.a
 * JD-Core Version:    0.7.0.1
 */