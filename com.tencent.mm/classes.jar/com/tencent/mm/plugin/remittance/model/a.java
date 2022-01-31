package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  public static JSONObject a(adg paramadg)
  {
    AppMethodBeat.i(44717);
    if (paramadg == null)
    {
      paramadg = new JSONObject();
      AppMethodBeat.o(44717);
      return paramadg;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("favor_compose_id", paramadg.wVK);
      LinkedList localLinkedList = paramadg.wAS;
      new adh();
      localJSONObject.put("favor_info_list,", cM(localLinkedList));
      localJSONObject.put("show_favor_amount,", paramadg.wVL);
      localJSONObject.put("show_pay_amount,", paramadg.wVM);
      localJSONObject.put("total_favor_amount,", paramadg.wVN);
      localJSONObject.put("favor_desc", paramadg.qiO);
      localJSONObject.put("compose_sort_flag", paramadg.wVO);
      localJSONObject.put("extend_str", paramadg.wIJ);
      AppMethodBeat.o(44717);
      return localJSONObject;
    }
    catch (Exception paramadg)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramadg, "", new Object[0]);
      }
    }
  }
  
  private static JSONObject a(adh paramadh)
  {
    AppMethodBeat.i(44715);
    if (paramadh == null)
    {
      paramadh = new JSONObject();
      AppMethodBeat.o(44715);
      return paramadh;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fav_type", paramadh.wVP);
      localJSONObject.put("fav_sub_type", paramadh.wVQ);
      localJSONObject.put("fav_property", paramadh.wVR);
      localJSONObject.put("favor_type_desc", paramadh.wVS);
      localJSONObject.put("fav_id", paramadh.wVT);
      localJSONObject.put("fav_name", paramadh.wVU);
      localJSONObject.put("fav_desc", paramadh.wVV);
      localJSONObject.put("favor_use_manual", paramadh.wVW);
      localJSONObject.put("favor_remarks", paramadh.wVX);
      localJSONObject.put("fav_price", paramadh.wVY);
      localJSONObject.put("real_fav_fee", paramadh.wVZ);
      localJSONObject.put("fav_scope_type", paramadh.wWa);
      localJSONObject.put("business_receipt_no", paramadh.wWb);
      localJSONObject.put("unavailable", paramadh.wWc);
      AppMethodBeat.o(44715);
      return localJSONObject;
    }
    catch (Exception paramadh)
    {
      ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramadh, "", new Object[0]);
      AppMethodBeat.o(44715);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(cz paramcz)
  {
    AppMethodBeat.i(44718);
    if (paramcz == null)
    {
      paramcz = new JSONObject();
      AppMethodBeat.o(44718);
      return paramcz;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel", paramcz.cCy);
      localJSONObject.put("favor_compose_info", a(paramcz.wps));
      localJSONObject.put("f2f_id", paramcz.wpp);
      localJSONObject.put("payok_checksign", paramcz.wpr);
      localJSONObject.put("receiver_openid", paramcz.qkn);
      localJSONObject.put("receiver_username", paramcz.wpt);
      localJSONObject.put("scan_scene", paramcz.qiP);
      localJSONObject.put("scene", paramcz.scene);
      localJSONObject.put("total_amount", paramcz.wpu);
      localJSONObject.put("trans_id", paramcz.wpq);
      AppMethodBeat.o(44718);
      return localJSONObject;
    }
    catch (Exception paramcz)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramcz, "", new Object[0]);
      }
    }
  }
  
  public static JSONObject a(mk parammk)
  {
    AppMethodBeat.i(44713);
    if (parammk == null)
    {
      parammk = new JSONObject();
      AppMethodBeat.o(44713);
      return parammk;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      LinkedList localLinkedList = parammk.wAS;
      new adh();
      localJSONObject.put("favor_info_list", cM(localLinkedList));
      localLinkedList = parammk.wAT;
      new adg();
      localJSONObject.put("favor_compose_result_list", cN(localLinkedList));
      localJSONObject.put("default_fav_compose_id", parammk.wAU);
      localJSONObject.put("favor_resp_sign", parammk.wAV);
      localJSONObject.put("no_compose_wording", parammk.wAW);
      AppMethodBeat.o(44713);
      return localJSONObject;
    }
    catch (Exception parammk)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", parammk, "", new Object[0]);
      }
    }
  }
  
  private static JSONArray cM(List<adh> paramList)
  {
    AppMethodBeat.i(44714);
    if (paramList == null)
    {
      paramList = new JSONArray();
      AppMethodBeat.o(44714);
      return paramList;
    }
    localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        localJSONArray.put(i, a((adh)paramList.next()));
        i += 1;
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramList, "", new Object[0]);
      AppMethodBeat.o(44714);
    }
  }
  
  private static JSONArray cN(List<adg> paramList)
  {
    AppMethodBeat.i(44716);
    if (paramList == null)
    {
      paramList = new JSONArray();
      AppMethodBeat.o(44716);
      return paramList;
    }
    localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        localJSONArray.put(i, a((adg)paramList.next()));
        i += 1;
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      ab.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramList, "", new Object[0]);
      AppMethodBeat.o(44716);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.a
 * JD-Core Version:    0.7.0.1
 */