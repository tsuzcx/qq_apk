package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  public static JSONObject a(aid paramaid)
  {
    AppMethodBeat.i(67828);
    if (paramaid == null)
    {
      paramaid = new JSONObject();
      AppMethodBeat.o(67828);
      return paramaid;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("favor_compose_id", paramaid.ECs);
      LinkedList localLinkedList = paramaid.EeI;
      new aie();
      localJSONObject.put("favor_info_list,", fb(localLinkedList));
      localJSONObject.put("show_favor_amount,", paramaid.ECt);
      localJSONObject.put("show_pay_amount,", paramaid.ECu);
      localJSONObject.put("total_favor_amount,", paramaid.ECv);
      localJSONObject.put("favor_desc", paramaid.wJS);
      localJSONObject.put("compose_sort_flag", paramaid.ECw);
      localJSONObject.put("extend_str", paramaid.Enm);
      AppMethodBeat.o(67828);
      return localJSONObject;
    }
    catch (Exception paramaid)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramaid, "", new Object[0]);
      }
    }
  }
  
  private static JSONObject a(aie paramaie)
  {
    AppMethodBeat.i(67826);
    if (paramaie == null)
    {
      paramaie = new JSONObject();
      AppMethodBeat.o(67826);
      return paramaie;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fav_type", paramaie.ECx);
      localJSONObject.put("fav_sub_type", paramaie.ECy);
      localJSONObject.put("fav_property", paramaie.ECz);
      localJSONObject.put("favor_type_desc", paramaie.ECA);
      localJSONObject.put("fav_id", paramaie.ECB);
      localJSONObject.put("fav_name", paramaie.ECC);
      localJSONObject.put("fav_desc", paramaie.ECD);
      localJSONObject.put("favor_use_manual", paramaie.ECE);
      localJSONObject.put("favor_remarks", paramaie.ECF);
      localJSONObject.put("fav_price", paramaie.ECG);
      localJSONObject.put("real_fav_fee", paramaie.ECH);
      localJSONObject.put("fav_scope_type", paramaie.ECI);
      localJSONObject.put("business_receipt_no", paramaie.ECJ);
      localJSONObject.put("unavailable", paramaie.ECK);
      AppMethodBeat.o(67826);
      return localJSONObject;
    }
    catch (Exception paramaie)
    {
      ac.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramaie, "", new Object[0]);
      AppMethodBeat.o(67826);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(dj paramdj)
  {
    AppMethodBeat.i(67829);
    if (paramdj == null)
    {
      paramdj = new JSONObject();
      AppMethodBeat.o(67829);
      return paramdj;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel", paramdj.channel);
      localJSONObject.put("favor_compose_info", a(paramdj.DQv));
      localJSONObject.put("f2f_id", paramdj.DQs);
      localJSONObject.put("payok_checksign", paramdj.DQu);
      localJSONObject.put("receiver_openid", paramdj.wLu);
      localJSONObject.put("receiver_username", paramdj.iAz);
      localJSONObject.put("scan_scene", paramdj.wJT);
      localJSONObject.put("scene", paramdj.scene);
      localJSONObject.put("total_amount", paramdj.DQw);
      localJSONObject.put("trans_id", paramdj.DQt);
      AppMethodBeat.o(67829);
      return localJSONObject;
    }
    catch (Exception paramdj)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramdj, "", new Object[0]);
      }
    }
  }
  
  public static JSONObject a(ou paramou)
  {
    AppMethodBeat.i(67824);
    if (paramou == null)
    {
      paramou = new JSONObject();
      AppMethodBeat.o(67824);
      return paramou;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      LinkedList localLinkedList = paramou.EeI;
      new aie();
      localJSONObject.put("favor_info_list", fb(localLinkedList));
      localLinkedList = paramou.EeJ;
      new aid();
      localJSONObject.put("favor_compose_result_list", fc(localLinkedList));
      localJSONObject.put("default_fav_compose_id", paramou.EeK);
      localJSONObject.put("favor_resp_sign", paramou.EeL);
      localJSONObject.put("no_compose_wording", paramou.EeM);
      AppMethodBeat.o(67824);
      return localJSONObject;
    }
    catch (Exception paramou)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramou, "", new Object[0]);
      }
    }
  }
  
  private static JSONArray fb(List<aie> paramList)
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
        localJSONArray.put(i, a((aie)paramList.next()));
        i += 1;
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      ac.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramList, "", new Object[0]);
      AppMethodBeat.o(67825);
    }
  }
  
  private static JSONArray fc(List<aid> paramList)
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
        localJSONArray.put(i, a((aid)paramList.next()));
        i += 1;
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      ac.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramList, "", new Object[0]);
      AppMethodBeat.o(67827);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.a
 * JD-Core Version:    0.7.0.1
 */