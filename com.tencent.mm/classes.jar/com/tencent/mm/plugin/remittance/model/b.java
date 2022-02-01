package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public static LinkedList<aos> E(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(67830);
    localLinkedList = new LinkedList();
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(67830);
      return localLinkedList;
    }
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        aos localaos = new aos();
        localaos.SBk = localJSONObject.optString("favor_compose_id");
        localaos.SBl = localJSONObject.optLong("show_favor_amount");
        localaos.SBm = localJSONObject.optLong("show_pay_amount");
        localaos.SBn = localJSONObject.optString("total_favor_amount");
        localaos.Ila = localJSONObject.optString("favor_desc");
        localaos.SBo = localJSONObject.optLong("compose_sort_flag");
        localaos.SiM = localJSONObject.optString("extend_str");
        localaos.RZg = F(localJSONObject.optJSONArray("favor_info_list"));
        localLinkedList.add(localaos);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONArray)
    {
      Log.printErrStackTrace("MicroMsg.BusiFavorInfoParser", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(67830);
    }
  }
  
  public static LinkedList<aot> F(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(67831);
    localLinkedList = new LinkedList();
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(67831);
      return localLinkedList;
    }
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        aot localaot = new aot();
        localaot.SBB = localJSONObject.optString("business_receipt_no");
        localaot.SiM = localJSONObject.optString("extend_str");
        localaot.SBv = localJSONObject.optString("fav_desc");
        localaot.SBt = localJSONObject.optLong("fav_id", 0L);
        localaot.SBu = localJSONObject.optString("fav_name");
        localaot.SBy = localJSONObject.optString("fav_price");
        localaot.SBr = localJSONObject.optLong("fav_property", 0L);
        localaot.SBA = localJSONObject.optInt("fav_scope_type", 0);
        localaot.SBq = localJSONObject.optLong("fav_sub_type", 0L);
        localaot.SBp = localJSONObject.optLong("fav_type", 0L);
        localaot.SBx = localJSONObject.optString("favor_remarks");
        localaot.SBs = localJSONObject.optString("favor_type_desc");
        localaot.SBw = localJSONObject.optString("favor_use_manual");
        localaot.SBz = localJSONObject.optString("real_fav_fee");
        localaot.SBC = localJSONObject.optInt("unavailable");
        localLinkedList.add(localaot);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONArray)
    {
      Log.printErrStackTrace("MicroMsg.BusiFavorInfoParser", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(67831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.b
 * JD-Core Version:    0.7.0.1
 */