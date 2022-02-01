package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public static LinkedList<anr> D(JSONArray paramJSONArray)
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
        anr localanr = new anr();
        localanr.LyJ = localJSONObject.optString("favor_compose_id");
        localanr.LyK = localJSONObject.optLong("show_favor_amount");
        localanr.LyL = localJSONObject.optLong("show_pay_amount");
        localanr.LyM = localJSONObject.optString("total_favor_amount");
        localanr.Coh = localJSONObject.optString("favor_desc");
        localanr.LyN = localJSONObject.optLong("compose_sort_flag");
        localanr.Lhy = localJSONObject.optString("extend_str");
        localanr.KXX = E(localJSONObject.optJSONArray("favor_info_list"));
        localLinkedList.add(localanr);
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
  
  public static LinkedList<ans> E(JSONArray paramJSONArray)
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
        ans localans = new ans();
        localans.Lza = localJSONObject.optString("business_receipt_no");
        localans.Lhy = localJSONObject.optString("extend_str");
        localans.LyU = localJSONObject.optString("fav_desc");
        localans.LyS = localJSONObject.optLong("fav_id", 0L);
        localans.LyT = localJSONObject.optString("fav_name");
        localans.LyX = localJSONObject.optString("fav_price");
        localans.LyQ = localJSONObject.optLong("fav_property", 0L);
        localans.LyZ = localJSONObject.optInt("fav_scope_type", 0);
        localans.LyP = localJSONObject.optLong("fav_sub_type", 0L);
        localans.LyO = localJSONObject.optLong("fav_type", 0L);
        localans.LyW = localJSONObject.optString("favor_remarks");
        localans.LyR = localJSONObject.optString("favor_type_desc");
        localans.LyV = localJSONObject.optString("favor_use_manual");
        localans.LyY = localJSONObject.optString("real_fav_fee");
        localans.Lzb = localJSONObject.optInt("unavailable");
        localLinkedList.add(localans);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.b
 * JD-Core Version:    0.7.0.1
 */