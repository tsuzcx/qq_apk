package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.protocal.c.yz;
import com.tencent.mm.protocal.c.za;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public static LinkedList<yz> t(JSONArray paramJSONArray)
  {
    localLinkedList = new LinkedList();
    if (paramJSONArray == null) {}
    for (;;)
    {
      return localLinkedList;
      int i = 0;
      try
      {
        while (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          yz localyz = new yz();
          localyz.sXL = localJSONObject.optString("favor_compose_id");
          localyz.sXM = localJSONObject.optLong("show_favor_amount");
          localyz.sXN = localJSONObject.optLong("show_pay_amount");
          localyz.sXO = localJSONObject.optString("total_favor_amount");
          localyz.nxN = localJSONObject.optString("favor_desc");
          localyz.sXP = localJSONObject.optLong("compose_sort_flag");
          localyz.sKU = localJSONObject.optString("extend_str");
          localyz.sEJ = u(localJSONObject.optJSONArray("favor_info_list"));
          localLinkedList.add(localyz);
          i += 1;
        }
        return localLinkedList;
      }
      catch (Exception paramJSONArray)
      {
        y.printErrStackTrace("MicroMsg.BusiFavorInfoParser", paramJSONArray, "", new Object[0]);
      }
    }
  }
  
  public static LinkedList<za> u(JSONArray paramJSONArray)
  {
    localLinkedList = new LinkedList();
    if (paramJSONArray == null) {}
    for (;;)
    {
      return localLinkedList;
      int i = 0;
      try
      {
        while (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          za localza = new za();
          localza.sYc = localJSONObject.optString("business_receipt_no");
          localza.sKU = localJSONObject.optString("extend_str");
          localza.sXW = localJSONObject.optString("fav_desc");
          localza.sXU = localJSONObject.optLong("fav_id", 0L);
          localza.sXV = localJSONObject.optString("fav_name");
          localza.sXZ = localJSONObject.optString("fav_price");
          localza.sXS = localJSONObject.optLong("fav_property", 0L);
          localza.sYb = localJSONObject.optInt("fav_scope_type", 0);
          localza.sXR = localJSONObject.optLong("fav_sub_type", 0L);
          localza.sXQ = localJSONObject.optLong("fav_type", 0L);
          localza.sXY = localJSONObject.optString("favor_remarks");
          localza.sXT = localJSONObject.optString("favor_type_desc");
          localza.sXX = localJSONObject.optString("favor_use_manual");
          localza.sYa = localJSONObject.optString("real_fav_fee");
          localza.sYd = localJSONObject.optInt("unavailable");
          localLinkedList.add(localza);
          i += 1;
        }
        return localLinkedList;
      }
      catch (Exception paramJSONArray)
      {
        y.printErrStackTrace("MicroMsg.BusiFavorInfoParser", paramJSONArray, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.b
 * JD-Core Version:    0.7.0.1
 */