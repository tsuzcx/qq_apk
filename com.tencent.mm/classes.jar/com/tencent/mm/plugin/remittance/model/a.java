package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  public static LinkedList<apu> I(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(288812);
    localLinkedList = new LinkedList();
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(288812);
      return localLinkedList;
    }
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        apu localapu = new apu();
        localapu.Zxa = localJSONObject.optLong("extra_buy_id");
        localapu.Zxb = localJSONObject.optString("extra_buy_name");
        localapu.Zxc = localJSONObject.optLong("good_original_price");
        localapu.Zxd = localJSONObject.optLong("good_add_price");
        localapu.Zxe = localJSONObject.optString("extra_buy_good_name");
        localapu.Zxf = localJSONObject.optString("extra_buy_good_pic");
        localapu.Zxg = localJSONObject.optInt("unavailable");
        localapu.Zxh = localJSONObject.optString("unavailable_reason");
        localapu.Bvd = localJSONObject.optBoolean("selected");
        localLinkedList.add(localapu);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONArray)
    {
      Log.printErrStackTrace("MicroMsg.BusiExtraBuyInfoParser", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(288812);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.a
 * JD-Core Version:    0.7.0.1
 */