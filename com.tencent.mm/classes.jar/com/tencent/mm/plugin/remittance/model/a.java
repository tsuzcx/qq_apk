package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  public static JSONObject a(akt paramakt)
  {
    AppMethodBeat.i(67828);
    if (paramakt == null)
    {
      paramakt = new JSONObject();
      AppMethodBeat.o(67828);
      return paramakt;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("favor_compose_id", paramakt.Gke);
      LinkedList localLinkedList = paramakt.FLh;
      new aku();
      localJSONObject.put("favor_info_list,", fo(localLinkedList));
      localJSONObject.put("show_favor_amount,", paramakt.Gkf);
      localJSONObject.put("show_pay_amount,", paramakt.Gkg);
      localJSONObject.put("total_favor_amount,", paramakt.Gkh);
      localJSONObject.put("favor_desc", paramakt.xXz);
      localJSONObject.put("compose_sort_flag", paramakt.Gki);
      localJSONObject.put("extend_str", paramakt.FUv);
      AppMethodBeat.o(67828);
      return localJSONObject;
    }
    catch (Exception paramakt)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramakt, "", new Object[0]);
      }
    }
  }
  
  private static JSONObject a(aku paramaku)
  {
    AppMethodBeat.i(67826);
    if (paramaku == null)
    {
      paramaku = new JSONObject();
      AppMethodBeat.o(67826);
      return paramaku;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fav_type", paramaku.Gkj);
      localJSONObject.put("fav_sub_type", paramaku.Gkk);
      localJSONObject.put("fav_property", paramaku.Gkl);
      localJSONObject.put("favor_type_desc", paramaku.Gkm);
      localJSONObject.put("fav_id", paramaku.Gkn);
      localJSONObject.put("fav_name", paramaku.Gko);
      localJSONObject.put("fav_desc", paramaku.Gkp);
      localJSONObject.put("favor_use_manual", paramaku.Gkq);
      localJSONObject.put("favor_remarks", paramaku.Gkr);
      localJSONObject.put("fav_price", paramaku.Gks);
      localJSONObject.put("real_fav_fee", paramaku.Gkt);
      localJSONObject.put("fav_scope_type", paramaku.Gku);
      localJSONObject.put("business_receipt_no", paramaku.Gkv);
      localJSONObject.put("unavailable", paramaku.Gkw);
      AppMethodBeat.o(67826);
      return localJSONObject;
    }
    catch (Exception paramaku)
    {
      ad.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramaku, "", new Object[0]);
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
      localJSONObject.put("favor_compose_info", a(paramdk.FvK));
      localJSONObject.put("f2f_id", paramdk.FvH);
      localJSONObject.put("payok_checksign", paramdk.FvJ);
      localJSONObject.put("receiver_openid", paramdk.xZb);
      localJSONObject.put("receiver_username", paramdk.iTJ);
      localJSONObject.put("scan_scene", paramdk.xXA);
      localJSONObject.put("scene", paramdk.scene);
      localJSONObject.put("total_amount", paramdk.FvL);
      localJSONObject.put("trans_id", paramdk.FvI);
      AppMethodBeat.o(67829);
      return localJSONObject;
    }
    catch (Exception paramdk)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramdk, "", new Object[0]);
      }
    }
  }
  
  public static JSONObject a(pz parampz)
  {
    AppMethodBeat.i(67824);
    if (parampz == null)
    {
      parampz = new JSONObject();
      AppMethodBeat.o(67824);
      return parampz;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      LinkedList localLinkedList = parampz.FLh;
      new aku();
      localJSONObject.put("favor_info_list", fo(localLinkedList));
      localLinkedList = parampz.FLi;
      new akt();
      localJSONObject.put("favor_compose_result_list", fp(localLinkedList));
      localJSONObject.put("default_fav_compose_id", parampz.FLj);
      localJSONObject.put("favor_resp_sign", parampz.FLk);
      localJSONObject.put("no_compose_wording", parampz.FLl);
      AppMethodBeat.o(67824);
      return localJSONObject;
    }
    catch (Exception parampz)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", parampz, "", new Object[0]);
      }
    }
  }
  
  private static JSONArray fo(List<aku> paramList)
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
        localJSONArray.put(i, a((aku)paramList.next()));
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
  
  private static JSONArray fp(List<akt> paramList)
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
        localJSONArray.put(i, a((akt)paramList.next()));
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