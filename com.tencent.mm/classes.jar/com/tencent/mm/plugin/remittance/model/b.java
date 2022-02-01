package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public static LinkedList<aid> A(JSONArray paramJSONArray)
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
        aid localaid = new aid();
        localaid.ECs = localJSONObject.optString("favor_compose_id");
        localaid.ECt = localJSONObject.optLong("show_favor_amount");
        localaid.ECu = localJSONObject.optLong("show_pay_amount");
        localaid.ECv = localJSONObject.optString("total_favor_amount");
        localaid.wJS = localJSONObject.optString("favor_desc");
        localaid.ECw = localJSONObject.optLong("compose_sort_flag");
        localaid.Enm = localJSONObject.optString("extend_str");
        localaid.EeI = B(localJSONObject.optJSONArray("favor_info_list"));
        localLinkedList.add(localaid);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONArray)
    {
      ac.printErrStackTrace("MicroMsg.BusiFavorInfoParser", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(67830);
    }
  }
  
  public static LinkedList<aie> B(JSONArray paramJSONArray)
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
        aie localaie = new aie();
        localaie.ECJ = localJSONObject.optString("business_receipt_no");
        localaie.Enm = localJSONObject.optString("extend_str");
        localaie.ECD = localJSONObject.optString("fav_desc");
        localaie.ECB = localJSONObject.optLong("fav_id", 0L);
        localaie.ECC = localJSONObject.optString("fav_name");
        localaie.ECG = localJSONObject.optString("fav_price");
        localaie.ECz = localJSONObject.optLong("fav_property", 0L);
        localaie.ECI = localJSONObject.optInt("fav_scope_type", 0);
        localaie.ECy = localJSONObject.optLong("fav_sub_type", 0L);
        localaie.ECx = localJSONObject.optLong("fav_type", 0L);
        localaie.ECF = localJSONObject.optString("favor_remarks");
        localaie.ECA = localJSONObject.optString("favor_type_desc");
        localaie.ECE = localJSONObject.optString("favor_use_manual");
        localaie.ECH = localJSONObject.optString("real_fav_fee");
        localaie.ECK = localJSONObject.optInt("unavailable");
        localLinkedList.add(localaie);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONArray)
    {
      ac.printErrStackTrace("MicroMsg.BusiFavorInfoParser", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(67831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.b
 * JD-Core Version:    0.7.0.1
 */