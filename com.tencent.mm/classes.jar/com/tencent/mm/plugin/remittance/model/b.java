package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public static LinkedList<ald> C(JSONArray paramJSONArray)
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
        ald localald = new ald();
        localald.GCO = localJSONObject.optString("favor_compose_id");
        localald.GCP = localJSONObject.optLong("show_favor_amount");
        localald.GCQ = localJSONObject.optLong("show_pay_amount");
        localald.GCR = localJSONObject.optString("total_favor_amount");
        localald.ynr = localJSONObject.optString("favor_desc");
        localald.GCS = localJSONObject.optLong("compose_sort_flag");
        localald.GmU = localJSONObject.optString("extend_str");
        localald.GdG = D(localJSONObject.optJSONArray("favor_info_list"));
        localLinkedList.add(localald);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONArray)
    {
      ae.printErrStackTrace("MicroMsg.BusiFavorInfoParser", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(67830);
    }
  }
  
  public static LinkedList<ale> D(JSONArray paramJSONArray)
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
        ale localale = new ale();
        localale.GDf = localJSONObject.optString("business_receipt_no");
        localale.GmU = localJSONObject.optString("extend_str");
        localale.GCZ = localJSONObject.optString("fav_desc");
        localale.GCX = localJSONObject.optLong("fav_id", 0L);
        localale.GCY = localJSONObject.optString("fav_name");
        localale.GDc = localJSONObject.optString("fav_price");
        localale.GCV = localJSONObject.optLong("fav_property", 0L);
        localale.GDe = localJSONObject.optInt("fav_scope_type", 0);
        localale.GCU = localJSONObject.optLong("fav_sub_type", 0L);
        localale.GCT = localJSONObject.optLong("fav_type", 0L);
        localale.GDb = localJSONObject.optString("favor_remarks");
        localale.GCW = localJSONObject.optString("favor_type_desc");
        localale.GDa = localJSONObject.optString("favor_use_manual");
        localale.GDd = localJSONObject.optString("real_fav_fee");
        localale.GDg = localJSONObject.optInt("unavailable");
        localLinkedList.add(localale);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONArray)
    {
      ae.printErrStackTrace("MicroMsg.BusiFavorInfoParser", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(67831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.b
 * JD-Core Version:    0.7.0.1
 */