package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.protocal.c.co;
import com.tencent.mm.protocal.c.jy;
import com.tencent.mm.protocal.c.yz;
import com.tencent.mm.protocal.c.za;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  public static JSONObject a(co paramco)
  {
    if (paramco == null) {
      return new JSONObject();
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel", paramco.bUR);
      localJSONObject.put("favor_compose_info", a(paramco.swf));
      localJSONObject.put("f2f_id", paramco.swc);
      localJSONObject.put("payok_checksign", paramco.swe);
      localJSONObject.put("receiver_openid", paramco.nzl);
      localJSONObject.put("receiver_username", paramco.swg);
      localJSONObject.put("scan_scene", paramco.nxO);
      localJSONObject.put("scene", paramco.scene);
      localJSONObject.put("total_amount", paramco.swh);
      localJSONObject.put("trans_id", paramco.swd);
      return localJSONObject;
    }
    catch (Exception paramco)
    {
      y.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramco, "", new Object[0]);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(jy paramjy)
  {
    if (paramjy == null) {
      return new JSONObject();
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      LinkedList localLinkedList = paramjy.sEJ;
      new za();
      localJSONObject.put("favor_info_list", cj(localLinkedList));
      localLinkedList = paramjy.sEK;
      new yz();
      localJSONObject.put("favor_compose_result_list", ck(localLinkedList));
      localJSONObject.put("default_fav_compose_id", paramjy.sEL);
      localJSONObject.put("favor_resp_sign", paramjy.sEM);
      localJSONObject.put("no_compose_wording", paramjy.sEN);
      return localJSONObject;
    }
    catch (Exception paramjy)
    {
      y.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramjy, "", new Object[0]);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(yz paramyz)
  {
    if (paramyz == null) {
      return new JSONObject();
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("favor_compose_id", paramyz.sXL);
      LinkedList localLinkedList = paramyz.sEJ;
      new za();
      localJSONObject.put("favor_info_list,", cj(localLinkedList));
      localJSONObject.put("show_favor_amount,", paramyz.sXM);
      localJSONObject.put("show_pay_amount,", paramyz.sXN);
      localJSONObject.put("total_favor_amount,", paramyz.sXO);
      localJSONObject.put("favor_desc", paramyz.nxN);
      localJSONObject.put("compose_sort_flag", paramyz.sXP);
      localJSONObject.put("extend_str", paramyz.sKU);
      return localJSONObject;
    }
    catch (Exception paramyz)
    {
      y.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramyz, "", new Object[0]);
    }
    return localJSONObject;
  }
  
  private static JSONObject a(za paramza)
  {
    if (paramza == null) {
      return new JSONObject();
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fav_type", paramza.sXQ);
      localJSONObject.put("fav_sub_type", paramza.sXR);
      localJSONObject.put("fav_property", paramza.sXS);
      localJSONObject.put("favor_type_desc", paramza.sXT);
      localJSONObject.put("fav_id", paramza.sXU);
      localJSONObject.put("fav_name", paramza.sXV);
      localJSONObject.put("fav_desc", paramza.sXW);
      localJSONObject.put("favor_use_manual", paramza.sXX);
      localJSONObject.put("favor_remarks", paramza.sXY);
      localJSONObject.put("fav_price", paramza.sXZ);
      localJSONObject.put("real_fav_fee", paramza.sYa);
      localJSONObject.put("fav_scope_type", paramza.sYb);
      localJSONObject.put("business_receipt_no", paramza.sYc);
      localJSONObject.put("unavailable", paramza.sYd);
      return localJSONObject;
    }
    catch (Exception paramza)
    {
      y.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramza, "", new Object[0]);
    }
    return localJSONObject;
  }
  
  private static JSONArray cj(List<za> paramList)
  {
    if (paramList == null) {
      return new JSONArray();
    }
    localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        localJSONArray.put(i, a((za)paramList.next()));
        i += 1;
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      y.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramList, "", new Object[0]);
    }
  }
  
  private static JSONArray ck(List<yz> paramList)
  {
    if (paramList == null) {
      return new JSONArray();
    }
    localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        localJSONArray.put(i, a((yz)paramList.next()));
        i += 1;
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      y.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", paramList, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.a
 * JD-Core Version:    0.7.0.1
 */