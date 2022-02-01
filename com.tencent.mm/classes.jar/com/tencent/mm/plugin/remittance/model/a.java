package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  public static JSONObject a(anr paramanr)
  {
    AppMethodBeat.i(67828);
    if (paramanr == null)
    {
      paramanr = new JSONObject();
      AppMethodBeat.o(67828);
      return paramanr;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("favor_compose_id", paramanr.LyJ);
      LinkedList localLinkedList = paramanr.KXX;
      new ans();
      localJSONObject.put("favor_info_list,", gr(localLinkedList));
      localJSONObject.put("show_favor_amount,", paramanr.LyK);
      localJSONObject.put("show_pay_amount,", paramanr.LyL);
      localJSONObject.put("total_favor_amount,", paramanr.LyM);
      localJSONObject.put("favor_desc", paramanr.Coh);
      localJSONObject.put("compose_sort_flag", paramanr.LyN);
      localJSONObject.put("extend_str", paramanr.Lhy);
      AppMethodBeat.o(67828);
      return localJSONObject;
    }
    catch (Exception paramanr)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramanr, "", new Object[0]);
      }
    }
  }
  
  private static JSONObject a(ans paramans)
  {
    AppMethodBeat.i(67826);
    if (paramans == null)
    {
      paramans = new JSONObject();
      AppMethodBeat.o(67826);
      return paramans;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fav_type", paramans.LyO);
      localJSONObject.put("fav_sub_type", paramans.LyP);
      localJSONObject.put("fav_property", paramans.LyQ);
      localJSONObject.put("favor_type_desc", paramans.LyR);
      localJSONObject.put("fav_id", paramans.LyS);
      localJSONObject.put("fav_name", paramans.LyT);
      localJSONObject.put("fav_desc", paramans.LyU);
      localJSONObject.put("favor_use_manual", paramans.LyV);
      localJSONObject.put("favor_remarks", paramans.LyW);
      localJSONObject.put("fav_price", paramans.LyX);
      localJSONObject.put("real_fav_fee", paramans.LyY);
      localJSONObject.put("fav_scope_type", paramans.LyZ);
      localJSONObject.put("business_receipt_no", paramans.Lza);
      localJSONObject.put("unavailable", paramans.Lzb);
      AppMethodBeat.o(67826);
      return localJSONObject;
    }
    catch (Exception paramans)
    {
      Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramans, "", new Object[0]);
      AppMethodBeat.o(67826);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(du paramdu)
  {
    AppMethodBeat.i(67829);
    if (paramdu == null)
    {
      paramdu = new JSONObject();
      AppMethodBeat.o(67829);
      return paramdu;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel", paramdu.channel);
      localJSONObject.put("favor_compose_info", a(paramdu.KHP));
      localJSONObject.put("f2f_id", paramdu.KHM);
      localJSONObject.put("payok_checksign", paramdu.KHO);
      localJSONObject.put("receiver_openid", paramdu.CpJ);
      localJSONObject.put("receiver_username", paramdu.jTz);
      localJSONObject.put("scan_scene", paramdu.Coi);
      localJSONObject.put("scene", paramdu.scene);
      localJSONObject.put("total_amount", paramdu.KHQ);
      localJSONObject.put("trans_id", paramdu.KHN);
      AppMethodBeat.o(67829);
      return localJSONObject;
    }
    catch (Exception paramdu)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramdu, "", new Object[0]);
      }
    }
  }
  
  public static JSONObject a(rc paramrc)
  {
    AppMethodBeat.i(67824);
    if (paramrc == null)
    {
      paramrc = new JSONObject();
      AppMethodBeat.o(67824);
      return paramrc;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      LinkedList localLinkedList = paramrc.KXX;
      new ans();
      localJSONObject.put("favor_info_list", gr(localLinkedList));
      localLinkedList = paramrc.KXY;
      new anr();
      localJSONObject.put("favor_compose_result_list", gs(localLinkedList));
      localJSONObject.put("default_fav_compose_id", paramrc.KXZ);
      localJSONObject.put("favor_resp_sign", paramrc.KYa);
      localJSONObject.put("no_compose_wording", paramrc.KYb);
      AppMethodBeat.o(67824);
      return localJSONObject;
    }
    catch (Exception paramrc)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramrc, "", new Object[0]);
      }
    }
  }
  
  private static JSONArray gr(List<ans> paramList)
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
        localJSONArray.put(i, a((ans)paramList.next()));
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
  
  private static JSONArray gs(List<anr> paramList)
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
        localJSONArray.put(i, a((anr)paramList.next()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.a
 * JD-Core Version:    0.7.0.1
 */