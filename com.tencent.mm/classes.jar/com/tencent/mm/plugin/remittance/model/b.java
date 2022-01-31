package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public static LinkedList<adg> y(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(44719);
    localLinkedList = new LinkedList();
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(44719);
      return localLinkedList;
    }
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        adg localadg = new adg();
        localadg.wVK = localJSONObject.optString("favor_compose_id");
        localadg.wVL = localJSONObject.optLong("show_favor_amount");
        localadg.wVM = localJSONObject.optLong("show_pay_amount");
        localadg.wVN = localJSONObject.optString("total_favor_amount");
        localadg.qiO = localJSONObject.optString("favor_desc");
        localadg.wVO = localJSONObject.optLong("compose_sort_flag");
        localadg.wIJ = localJSONObject.optString("extend_str");
        localadg.wAS = z(localJSONObject.optJSONArray("favor_info_list"));
        localLinkedList.add(localadg);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONArray)
    {
      ab.printErrStackTrace("MicroMsg.BusiFavorInfoParser", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(44719);
    }
  }
  
  public static LinkedList<adh> z(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(44720);
    localLinkedList = new LinkedList();
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(44720);
      return localLinkedList;
    }
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        adh localadh = new adh();
        localadh.wWb = localJSONObject.optString("business_receipt_no");
        localadh.wIJ = localJSONObject.optString("extend_str");
        localadh.wVV = localJSONObject.optString("fav_desc");
        localadh.wVT = localJSONObject.optLong("fav_id", 0L);
        localadh.wVU = localJSONObject.optString("fav_name");
        localadh.wVY = localJSONObject.optString("fav_price");
        localadh.wVR = localJSONObject.optLong("fav_property", 0L);
        localadh.wWa = localJSONObject.optInt("fav_scope_type", 0);
        localadh.wVQ = localJSONObject.optLong("fav_sub_type", 0L);
        localadh.wVP = localJSONObject.optLong("fav_type", 0L);
        localadh.wVX = localJSONObject.optString("favor_remarks");
        localadh.wVS = localJSONObject.optString("favor_type_desc");
        localadh.wVW = localJSONObject.optString("favor_use_manual");
        localadh.wVZ = localJSONObject.optString("real_fav_fee");
        localadh.wWc = localJSONObject.optInt("unavailable");
        localLinkedList.add(localadh);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONArray)
    {
      ab.printErrStackTrace("MicroMsg.BusiFavorInfoParser", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(44720);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.b
 * JD-Core Version:    0.7.0.1
 */