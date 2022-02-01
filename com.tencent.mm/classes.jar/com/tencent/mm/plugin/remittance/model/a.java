package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  public static JSONObject a(ahe paramahe)
  {
    AppMethodBeat.i(67828);
    if (paramahe == null)
    {
      paramahe = new JSONObject();
      AppMethodBeat.o(67828);
      return paramahe;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("favor_compose_id", paramahe.Djm);
      LinkedList localLinkedList = paramahe.CMg;
      new ahf();
      localJSONObject.put("favor_info_list,", eV(localLinkedList));
      localJSONObject.put("show_favor_amount,", paramahe.Djn);
      localJSONObject.put("show_pay_amount,", paramahe.Djo);
      localJSONObject.put("total_favor_amount,", paramahe.Djp);
      localJSONObject.put("favor_desc", paramahe.vzN);
      localJSONObject.put("compose_sort_flag", paramahe.Djq);
      localJSONObject.put("extend_str", paramahe.CUC);
      AppMethodBeat.o(67828);
      return localJSONObject;
    }
    catch (Exception paramahe)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramahe, "", new Object[0]);
      }
    }
  }
  
  private static JSONObject a(ahf paramahf)
  {
    AppMethodBeat.i(67826);
    if (paramahf == null)
    {
      paramahf = new JSONObject();
      AppMethodBeat.o(67826);
      return paramahf;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fav_type", paramahf.Djr);
      localJSONObject.put("fav_sub_type", paramahf.Djs);
      localJSONObject.put("fav_property", paramahf.Djt);
      localJSONObject.put("favor_type_desc", paramahf.Dju);
      localJSONObject.put("fav_id", paramahf.Djv);
      localJSONObject.put("fav_name", paramahf.Djw);
      localJSONObject.put("fav_desc", paramahf.Djx);
      localJSONObject.put("favor_use_manual", paramahf.Djy);
      localJSONObject.put("favor_remarks", paramahf.Djz);
      localJSONObject.put("fav_price", paramahf.DjA);
      localJSONObject.put("real_fav_fee", paramahf.DjB);
      localJSONObject.put("fav_scope_type", paramahf.DjC);
      localJSONObject.put("business_receipt_no", paramahf.DjD);
      localJSONObject.put("unavailable", paramahf.DjE);
      AppMethodBeat.o(67826);
      return localJSONObject;
    }
    catch (Exception paramahf)
    {
      ad.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramahf, "", new Object[0]);
      AppMethodBeat.o(67826);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(dh paramdh)
  {
    AppMethodBeat.i(67829);
    if (paramdh == null)
    {
      paramdh = new JSONObject();
      AppMethodBeat.o(67829);
      return paramdh;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel", paramdh.channel);
      localJSONObject.put("favor_compose_info", a(paramdh.CxZ));
      localJSONObject.put("f2f_id", paramdh.CxW);
      localJSONObject.put("payok_checksign", paramdh.CxY);
      localJSONObject.put("receiver_openid", paramdh.vBp);
      localJSONObject.put("receiver_username", paramdh.iaw);
      localJSONObject.put("scan_scene", paramdh.vzO);
      localJSONObject.put("scene", paramdh.scene);
      localJSONObject.put("total_amount", paramdh.Cya);
      localJSONObject.put("trans_id", paramdh.CxX);
      AppMethodBeat.o(67829);
      return localJSONObject;
    }
    catch (Exception paramdh)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramdh, "", new Object[0]);
      }
    }
  }
  
  public static JSONObject a(on paramon)
  {
    AppMethodBeat.i(67824);
    if (paramon == null)
    {
      paramon = new JSONObject();
      AppMethodBeat.o(67824);
      return paramon;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      LinkedList localLinkedList = paramon.CMg;
      new ahf();
      localJSONObject.put("favor_info_list", eV(localLinkedList));
      localLinkedList = paramon.CMh;
      new ahe();
      localJSONObject.put("favor_compose_result_list", eW(localLinkedList));
      localJSONObject.put("default_fav_compose_id", paramon.CMi);
      localJSONObject.put("favor_resp_sign", paramon.CMj);
      localJSONObject.put("no_compose_wording", paramon.CMk);
      AppMethodBeat.o(67824);
      return localJSONObject;
    }
    catch (Exception paramon)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramon, "", new Object[0]);
      }
    }
  }
  
  private static JSONArray eV(List<ahf> paramList)
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
        localJSONArray.put(i, a((ahf)paramList.next()));
        i += 1;
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      ad.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramList, "", new Object[0]);
      AppMethodBeat.o(67825);
    }
  }
  
  private static JSONArray eW(List<ahe> paramList)
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
        localJSONArray.put(i, a((ahe)paramList.next()));
        i += 1;
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      ad.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramList, "", new Object[0]);
      AppMethodBeat.o(67827);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.a
 * JD-Core Version:    0.7.0.1
 */