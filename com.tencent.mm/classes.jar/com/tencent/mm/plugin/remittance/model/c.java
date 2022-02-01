package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  public static LinkedList<asl> J(JSONArray paramJSONArray)
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
        asl localasl = new asl();
        localasl.ZCd = localJSONObject.optString("favor_compose_id");
        localasl.ZCe = localJSONObject.optLong("show_favor_amount");
        localasl.ZCf = localJSONObject.optLong("show_pay_amount");
        localasl.ZCg = localJSONObject.optString("total_favor_amount");
        localasl.OhO = localJSONObject.optString("favor_desc");
        localasl.ZCh = localJSONObject.optLong("compose_sort_flag");
        localasl.ZgS = localJSONObject.optString("extend_str");
        localasl.YXg = K(localJSONObject.optJSONArray("favor_info_list"));
        localLinkedList.add(localasl);
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
  
  public static LinkedList<asm> K(JSONArray paramJSONArray)
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
        asm localasm = new asm();
        localasm.ZCu = localJSONObject.optString("business_receipt_no");
        localasm.ZgS = localJSONObject.optString("extend_str");
        localasm.ZCo = localJSONObject.optString("fav_desc");
        localasm.ZCm = localJSONObject.optLong("fav_id", 0L);
        localasm.ZCn = localJSONObject.optString("fav_name");
        localasm.ZCr = localJSONObject.optString("fav_price");
        localasm.ZCk = localJSONObject.optLong("fav_property", 0L);
        localasm.ZCt = localJSONObject.optInt("fav_scope_type", 0);
        localasm.ZCj = localJSONObject.optLong("fav_sub_type", 0L);
        localasm.ZCi = localJSONObject.optLong("fav_type", 0L);
        localasm.ZCq = localJSONObject.optString("favor_remarks");
        localasm.ZCl = localJSONObject.optString("favor_type_desc");
        localasm.ZCp = localJSONObject.optString("favor_use_manual");
        localasm.ZCs = localJSONObject.optString("real_fav_fee");
        localasm.Zxg = localJSONObject.optInt("unavailable");
        localLinkedList.add(localasm);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.c
 * JD-Core Version:    0.7.0.1
 */