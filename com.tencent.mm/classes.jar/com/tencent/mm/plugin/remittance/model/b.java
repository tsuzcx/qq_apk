package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public static LinkedList<akt> B(JSONArray paramJSONArray)
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
        akt localakt = new akt();
        localakt.Gke = localJSONObject.optString("favor_compose_id");
        localakt.Gkf = localJSONObject.optLong("show_favor_amount");
        localakt.Gkg = localJSONObject.optLong("show_pay_amount");
        localakt.Gkh = localJSONObject.optString("total_favor_amount");
        localakt.xXz = localJSONObject.optString("favor_desc");
        localakt.Gki = localJSONObject.optLong("compose_sort_flag");
        localakt.FUv = localJSONObject.optString("extend_str");
        localakt.FLh = C(localJSONObject.optJSONArray("favor_info_list"));
        localLinkedList.add(localakt);
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
  
  public static LinkedList<aku> C(JSONArray paramJSONArray)
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
        aku localaku = new aku();
        localaku.Gkv = localJSONObject.optString("business_receipt_no");
        localaku.FUv = localJSONObject.optString("extend_str");
        localaku.Gkp = localJSONObject.optString("fav_desc");
        localaku.Gkn = localJSONObject.optLong("fav_id", 0L);
        localaku.Gko = localJSONObject.optString("fav_name");
        localaku.Gks = localJSONObject.optString("fav_price");
        localaku.Gkl = localJSONObject.optLong("fav_property", 0L);
        localaku.Gku = localJSONObject.optInt("fav_scope_type", 0);
        localaku.Gkk = localJSONObject.optLong("fav_sub_type", 0L);
        localaku.Gkj = localJSONObject.optLong("fav_type", 0L);
        localaku.Gkr = localJSONObject.optString("favor_remarks");
        localaku.Gkm = localJSONObject.optString("favor_type_desc");
        localaku.Gkq = localJSONObject.optString("favor_use_manual");
        localaku.Gkt = localJSONObject.optString("real_fav_fee");
        localaku.Gkw = localJSONObject.optInt("unavailable");
        localLinkedList.add(localaku);
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