package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.sg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public static JSONObject a(asl paramasl)
  {
    AppMethodBeat.i(67828);
    if (paramasl == null)
    {
      paramasl = new JSONObject();
      AppMethodBeat.o(67828);
      return paramasl;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("favor_compose_id", paramasl.ZCd);
      LinkedList localLinkedList = paramasl.YXg;
      new asm();
      localJSONObject.put("favor_info_list,", jX(localLinkedList));
      localJSONObject.put("show_favor_amount,", paramasl.ZCe);
      localJSONObject.put("show_pay_amount,", paramasl.ZCf);
      localJSONObject.put("total_favor_amount,", paramasl.ZCg);
      localJSONObject.put("favor_desc", paramasl.OhO);
      localJSONObject.put("compose_sort_flag", paramasl.ZCh);
      localJSONObject.put("extend_str", paramasl.ZgS);
      AppMethodBeat.o(67828);
      return localJSONObject;
    }
    catch (Exception paramasl)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramasl, "", new Object[0]);
      }
    }
  }
  
  private static JSONObject a(asm paramasm)
  {
    AppMethodBeat.i(67826);
    if (paramasm == null)
    {
      paramasm = new JSONObject();
      AppMethodBeat.o(67826);
      return paramasm;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fav_type", paramasm.ZCi);
      localJSONObject.put("fav_sub_type", paramasm.ZCj);
      localJSONObject.put("fav_property", paramasm.ZCk);
      localJSONObject.put("favor_type_desc", paramasm.ZCl);
      localJSONObject.put("fav_id", paramasm.ZCm);
      localJSONObject.put("fav_name", paramasm.ZCn);
      localJSONObject.put("fav_desc", paramasm.ZCo);
      localJSONObject.put("favor_use_manual", paramasm.ZCp);
      localJSONObject.put("favor_remarks", paramasm.ZCq);
      localJSONObject.put("fav_price", paramasm.ZCr);
      localJSONObject.put("real_fav_fee", paramasm.ZCs);
      localJSONObject.put("fav_scope_type", paramasm.ZCt);
      localJSONObject.put("business_receipt_no", paramasm.ZCu);
      localJSONObject.put("unavailable", paramasm.Zxg);
      AppMethodBeat.o(67826);
      return localJSONObject;
    }
    catch (Exception paramasm)
    {
      Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramasm, "", new Object[0]);
      AppMethodBeat.o(67826);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(eh parameh)
  {
    AppMethodBeat.i(67829);
    if (parameh == null)
    {
      parameh = new JSONObject();
      AppMethodBeat.o(67829);
      return parameh;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel", parameh.channel);
      localJSONObject.put("favor_compose_info", a(parameh.OiK));
      localJSONObject.put("f2f_id", parameh.YGt);
      localJSONObject.put("payok_checksign", parameh.YGu);
      localJSONObject.put("receiver_openid", parameh.Oiw);
      localJSONObject.put("receiver_username", parameh.nQU);
      localJSONObject.put("scan_scene", parameh.OhP);
      localJSONObject.put("scene", parameh.scene);
      localJSONObject.put("total_amount", parameh.YGv);
      localJSONObject.put("trans_id", parameh.Oln);
      AppMethodBeat.o(67829);
      return localJSONObject;
    }
    catch (Exception parameh)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", parameh, "", new Object[0]);
      }
    }
  }
  
  public static JSONObject a(sg paramsg)
  {
    AppMethodBeat.i(67824);
    if (paramsg == null)
    {
      paramsg = new JSONObject();
      AppMethodBeat.o(67824);
      return paramsg;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      LinkedList localLinkedList = paramsg.YXg;
      new asm();
      localJSONObject.put("favor_info_list", jX(localLinkedList));
      localLinkedList = paramsg.YXh;
      new asl();
      localJSONObject.put("favor_compose_result_list", jY(localLinkedList));
      localJSONObject.put("default_fav_compose_id", paramsg.YXi);
      localJSONObject.put("favor_resp_sign", paramsg.OiL);
      localJSONObject.put("no_compose_wording", paramsg.YXj);
      AppMethodBeat.o(67824);
      return localJSONObject;
    }
    catch (Exception paramsg)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramsg, "", new Object[0]);
      }
    }
  }
  
  private static JSONArray jX(List<asm> paramList)
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
        localJSONArray.put(i, a((asm)paramList.next()));
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
  
  private static JSONArray jY(List<asl> paramList)
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
        localJSONArray.put(i, a((asl)paramList.next()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.b
 * JD-Core Version:    0.7.0.1
 */