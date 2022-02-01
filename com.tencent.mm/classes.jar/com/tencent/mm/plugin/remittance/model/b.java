package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public static LinkedList<ahe> A(JSONArray paramJSONArray)
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
        ahe localahe = new ahe();
        localahe.Djm = localJSONObject.optString("favor_compose_id");
        localahe.Djn = localJSONObject.optLong("show_favor_amount");
        localahe.Djo = localJSONObject.optLong("show_pay_amount");
        localahe.Djp = localJSONObject.optString("total_favor_amount");
        localahe.vzN = localJSONObject.optString("favor_desc");
        localahe.Djq = localJSONObject.optLong("compose_sort_flag");
        localahe.CUC = localJSONObject.optString("extend_str");
        localahe.CMg = B(localJSONObject.optJSONArray("favor_info_list"));
        localLinkedList.add(localahe);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONArray)
    {
      ad.printErrStackTrace("MicroMsg.BusiFavorInfoParser", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(67830);
    }
  }
  
  public static LinkedList<ahf> B(JSONArray paramJSONArray)
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
        ahf localahf = new ahf();
        localahf.DjD = localJSONObject.optString("business_receipt_no");
        localahf.CUC = localJSONObject.optString("extend_str");
        localahf.Djx = localJSONObject.optString("fav_desc");
        localahf.Djv = localJSONObject.optLong("fav_id", 0L);
        localahf.Djw = localJSONObject.optString("fav_name");
        localahf.DjA = localJSONObject.optString("fav_price");
        localahf.Djt = localJSONObject.optLong("fav_property", 0L);
        localahf.DjC = localJSONObject.optInt("fav_scope_type", 0);
        localahf.Djs = localJSONObject.optLong("fav_sub_type", 0L);
        localahf.Djr = localJSONObject.optLong("fav_type", 0L);
        localahf.Djz = localJSONObject.optString("favor_remarks");
        localahf.Dju = localJSONObject.optString("favor_type_desc");
        localahf.Djy = localJSONObject.optString("favor_use_manual");
        localahf.DjB = localJSONObject.optString("real_fav_fee");
        localahf.DjE = localJSONObject.optInt("unavailable");
        localLinkedList.add(localahf);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONArray)
    {
      ad.printErrStackTrace("MicroMsg.BusiFavorInfoParser", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(67831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.b
 * JD-Core Version:    0.7.0.1
 */