package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  public static JSONObject a(ald paramald)
  {
    AppMethodBeat.i(67828);
    if (paramald == null)
    {
      paramald = new JSONObject();
      AppMethodBeat.o(67828);
      return paramald;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("favor_compose_id", paramald.GCO);
      LinkedList localLinkedList = paramald.GdG;
      new ale();
      localJSONObject.put("favor_info_list,", fw(localLinkedList));
      localJSONObject.put("show_favor_amount,", paramald.GCP);
      localJSONObject.put("show_pay_amount,", paramald.GCQ);
      localJSONObject.put("total_favor_amount,", paramald.GCR);
      localJSONObject.put("favor_desc", paramald.ynr);
      localJSONObject.put("compose_sort_flag", paramald.GCS);
      localJSONObject.put("extend_str", paramald.GmU);
      AppMethodBeat.o(67828);
      return localJSONObject;
    }
    catch (Exception paramald)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramald, "", new Object[0]);
      }
    }
  }
  
  private static JSONObject a(ale paramale)
  {
    AppMethodBeat.i(67826);
    if (paramale == null)
    {
      paramale = new JSONObject();
      AppMethodBeat.o(67826);
      return paramale;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fav_type", paramale.GCT);
      localJSONObject.put("fav_sub_type", paramale.GCU);
      localJSONObject.put("fav_property", paramale.GCV);
      localJSONObject.put("favor_type_desc", paramale.GCW);
      localJSONObject.put("fav_id", paramale.GCX);
      localJSONObject.put("fav_name", paramale.GCY);
      localJSONObject.put("fav_desc", paramale.GCZ);
      localJSONObject.put("favor_use_manual", paramale.GDa);
      localJSONObject.put("favor_remarks", paramale.GDb);
      localJSONObject.put("fav_price", paramale.GDc);
      localJSONObject.put("real_fav_fee", paramale.GDd);
      localJSONObject.put("fav_scope_type", paramale.GDe);
      localJSONObject.put("business_receipt_no", paramale.GDf);
      localJSONObject.put("unavailable", paramale.GDg);
      AppMethodBeat.o(67826);
      return localJSONObject;
    }
    catch (Exception paramale)
    {
      ae.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramale, "", new Object[0]);
      AppMethodBeat.o(67826);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(dk paramdk)
  {
    AppMethodBeat.i(67829);
    if (paramdk == null)
    {
      paramdk = new JSONObject();
      AppMethodBeat.o(67829);
      return paramdk;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel", paramdk.channel);
      localJSONObject.put("favor_compose_info", a(paramdk.FOi));
      localJSONObject.put("f2f_id", paramdk.FOf);
      localJSONObject.put("payok_checksign", paramdk.FOh);
      localJSONObject.put("receiver_openid", paramdk.yoT);
      localJSONObject.put("receiver_username", paramdk.iWC);
      localJSONObject.put("scan_scene", paramdk.yns);
      localJSONObject.put("scene", paramdk.scene);
      localJSONObject.put("total_amount", paramdk.FOj);
      localJSONObject.put("trans_id", paramdk.FOg);
      AppMethodBeat.o(67829);
      return localJSONObject;
    }
    catch (Exception paramdk)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramdk, "", new Object[0]);
      }
    }
  }
  
  public static JSONObject a(qb paramqb)
  {
    AppMethodBeat.i(67824);
    if (paramqb == null)
    {
      paramqb = new JSONObject();
      AppMethodBeat.o(67824);
      return paramqb;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      LinkedList localLinkedList = paramqb.GdG;
      new ale();
      localJSONObject.put("favor_info_list", fw(localLinkedList));
      localLinkedList = paramqb.GdH;
      new ald();
      localJSONObject.put("favor_compose_result_list", fx(localLinkedList));
      localJSONObject.put("default_fav_compose_id", paramqb.GdI);
      localJSONObject.put("favor_resp_sign", paramqb.GdJ);
      localJSONObject.put("no_compose_wording", paramqb.GdK);
      AppMethodBeat.o(67824);
      return localJSONObject;
    }
    catch (Exception paramqb)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramqb, "", new Object[0]);
      }
    }
  }
  
  private static JSONArray fw(List<ale> paramList)
  {
    AppMethodBeat.i(67825);
    if (paramList == null)
    {
      paramList = new JSONArray();
      AppMethodBeat.o(67825);
      return paramList;
    }
    localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        localJSONArray.put(i, a((ale)paramList.next()));
        i += 1;
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      ae.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramList, "", new Object[0]);
      AppMethodBeat.o(67825);
    }
  }
  
  private static JSONArray fx(List<ald> paramList)
  {
    AppMethodBeat.i(67827);
    if (paramList == null)
    {
      paramList = new JSONArray();
      AppMethodBeat.o(67827);
      return paramList;
    }
    localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        localJSONArray.put(i, a((ald)paramList.next()));
        i += 1;
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      ae.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramList, "", new Object[0]);
      AppMethodBeat.o(67827);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.a
 * JD-Core Version:    0.7.0.1
 */