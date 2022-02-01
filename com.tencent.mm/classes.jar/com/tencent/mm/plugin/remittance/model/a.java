package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.qv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  public static JSONObject a(aos paramaos)
  {
    AppMethodBeat.i(67828);
    if (paramaos == null)
    {
      paramaos = new JSONObject();
      AppMethodBeat.o(67828);
      return paramaos;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("favor_compose_id", paramaos.SBk);
      LinkedList localLinkedList = paramaos.RZg;
      new aot();
      localJSONObject.put("favor_info_list,", gX(localLinkedList));
      localJSONObject.put("show_favor_amount,", paramaos.SBl);
      localJSONObject.put("show_pay_amount,", paramaos.SBm);
      localJSONObject.put("total_favor_amount,", paramaos.SBn);
      localJSONObject.put("favor_desc", paramaos.Ila);
      localJSONObject.put("compose_sort_flag", paramaos.SBo);
      localJSONObject.put("extend_str", paramaos.SiM);
      AppMethodBeat.o(67828);
      return localJSONObject;
    }
    catch (Exception paramaos)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramaos, "", new Object[0]);
      }
    }
  }
  
  private static JSONObject a(aot paramaot)
  {
    AppMethodBeat.i(67826);
    if (paramaot == null)
    {
      paramaot = new JSONObject();
      AppMethodBeat.o(67826);
      return paramaot;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fav_type", paramaot.SBp);
      localJSONObject.put("fav_sub_type", paramaot.SBq);
      localJSONObject.put("fav_property", paramaot.SBr);
      localJSONObject.put("favor_type_desc", paramaot.SBs);
      localJSONObject.put("fav_id", paramaot.SBt);
      localJSONObject.put("fav_name", paramaot.SBu);
      localJSONObject.put("fav_desc", paramaot.SBv);
      localJSONObject.put("favor_use_manual", paramaot.SBw);
      localJSONObject.put("favor_remarks", paramaot.SBx);
      localJSONObject.put("fav_price", paramaot.SBy);
      localJSONObject.put("real_fav_fee", paramaot.SBz);
      localJSONObject.put("fav_scope_type", paramaot.SBA);
      localJSONObject.put("business_receipt_no", paramaot.SBB);
      localJSONObject.put("unavailable", paramaot.SBC);
      AppMethodBeat.o(67826);
      return localJSONObject;
    }
    catch (Exception paramaot)
    {
      Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramaot, "", new Object[0]);
      AppMethodBeat.o(67826);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(ds paramds)
  {
    AppMethodBeat.i(67829);
    if (paramds == null)
    {
      paramds = new JSONObject();
      AppMethodBeat.o(67829);
      return paramds;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel", paramds.channel);
      localJSONObject.put("favor_compose_info", a(paramds.RJh));
      localJSONObject.put("f2f_id", paramds.RJf);
      localJSONObject.put("payok_checksign", paramds.RJg);
      localJSONObject.put("receiver_openid", paramds.ImY);
      localJSONObject.put("receiver_username", paramds.llO);
      localJSONObject.put("scan_scene", paramds.Ilb);
      localJSONObject.put("scene", paramds.scene);
      localJSONObject.put("total_amount", paramds.RJi);
      localJSONObject.put("trans_id", paramds.InV);
      AppMethodBeat.o(67829);
      return localJSONObject;
    }
    catch (Exception paramds)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramds, "", new Object[0]);
      }
    }
  }
  
  public static JSONObject a(qv paramqv)
  {
    AppMethodBeat.i(67824);
    if (paramqv == null)
    {
      paramqv = new JSONObject();
      AppMethodBeat.o(67824);
      return paramqv;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      LinkedList localLinkedList = paramqv.RZg;
      new aot();
      localJSONObject.put("favor_info_list", gX(localLinkedList));
      localLinkedList = paramqv.RZh;
      new aos();
      localJSONObject.put("favor_compose_result_list", gY(localLinkedList));
      localJSONObject.put("default_fav_compose_id", paramqv.RZi);
      localJSONObject.put("favor_resp_sign", paramqv.RZj);
      localJSONObject.put("no_compose_wording", paramqv.RZk);
      AppMethodBeat.o(67824);
      return localJSONObject;
    }
    catch (Exception paramqv)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramqv, "", new Object[0]);
      }
    }
  }
  
  private static JSONArray gX(List<aot> paramList)
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
        localJSONArray.put(i, a((aot)paramList.next()));
        i += 1;
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramList, "", new Object[0]);
      AppMethodBeat.o(67825);
    }
  }
  
  private static JSONArray gY(List<aos> paramList)
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
        localJSONArray.put(i, a((aos)paramList.next()));
        i += 1;
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramList, "", new Object[0]);
      AppMethodBeat.o(67827);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.a
 * JD-Core Version:    0.7.0.1
 */