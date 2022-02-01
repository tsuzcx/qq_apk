package com.tencent.mm.plugin.wallet_core.model.mall;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aum;
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.protocal.protobuf.awm;
import com.tencent.mm.protocal.protobuf.ecu;
import com.tencent.mm.protocal.protobuf.ecx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.y.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static int DsW = -256;
  public static int DsX = 621019136;
  public static int DsY = 637534720;
  
  public static ArrayList<MallNews> J(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(70539);
    try
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramJSONArray.length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        MallNews localMallNews = new MallNews(localJSONObject.optString("activity_jump_funcid"));
        localMallNews.Dtd = localJSONObject.optString("activity_icon_link");
        localMallNews.Dtb = localJSONObject.optString("activity_msg_content");
        localMallNews.Dtf = localJSONObject.optString("activity_tips");
        localArrayList.add(localMallNews);
        i += 1;
      }
      AppMethodBeat.o(70539);
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      ae.printErrStackTrace("MicroMsg.MallLogic", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(70539);
    }
    return null;
  }
  
  public static ArrayList<a> K(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(70540);
    try
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramJSONArray.length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        a locala = new a();
        locala.DsO = localJSONObject.optInt("banner_id");
        locala.DsP = localJSONObject.optString("banner_title");
        locala.DsQ = localJSONObject.optString("banner_link");
        localArrayList.add(locala);
        i += 1;
      }
      AppMethodBeat.o(70540);
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      ae.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + paramJSONArray.getMessage());
      AppMethodBeat.o(70540);
    }
    return null;
  }
  
  public static SparseArray<String> L(JSONArray paramJSONArray)
  {
    int i = 0;
    AppMethodBeat.i(70541);
    try
    {
      SparseArray localSparseArray = new SparseArray();
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        int j = localJSONObject.optInt("type_id", 0);
        if (j != 0) {
          localSparseArray.put(j, localJSONObject.optString("type_name"));
        }
        i += 1;
      }
      AppMethodBeat.o(70541);
      return localSparseArray;
    }
    catch (JSONException paramJSONArray)
    {
      ae.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + paramJSONArray.getMessage());
      AppMethodBeat.o(70541);
    }
    return null;
  }
  
  public static ArrayList<MallFunction> M(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(70544);
    try
    {
      ArrayList localArrayList = new ArrayList();
      int k = paramJSONArray.length();
      ae.d("MicroMsg.MallLogic", "functions.jsonArray.length : ".concat(String.valueOf(k)));
      int i = 0;
      Object localObject1;
      for (;;)
      {
        localObject1 = localArrayList;
        if (i >= k) {
          break;
        }
        Object localObject2 = paramJSONArray.getJSONObject(i);
        localObject1 = new MallFunction();
        ((MallFunction)localObject1).jFZ = ((JSONObject)localObject2).getString("func_id");
        ((MallFunction)localObject1).dLB = ((JSONObject)localObject2).getString("func_name");
        ((MallFunction)localObject1).DsR = ((JSONObject)localObject2).optString("func_icon_url");
        ((MallFunction)localObject1).vQp = ((JSONObject)localObject2).optString("hd_icon_url");
        ((MallFunction)localObject1).vQq = ((JSONObject)localObject2).optString("func_foregroud_icon_url");
        ((MallFunction)localObject1).dPb = ((JSONObject)localObject2).optString("native_url");
        ((MallFunction)localObject1).uEo = ((JSONObject)localObject2).optString("h5_url");
        ((MallFunction)localObject1).type = ((JSONObject)localObject2).optInt("property_type", 0);
        ((MallFunction)localObject1).DsU = ((JSONObject)localObject2).optString("third_party_disclaimer");
        ((MallFunction)localObject1).DsV = ((JSONObject)localObject2).optInt("download_restrict", 0);
        Object localObject3 = ((JSONObject)localObject2).optJSONArray("remark_name_list");
        if (localObject3 != null)
        {
          ((MallFunction)localObject1).DsS = new ArrayList();
          int m = ((JSONArray)localObject3).length();
          int j = 0;
          while (j < m)
          {
            ((MallFunction)localObject1).DsS.add(((JSONArray)localObject3).getString(j));
            j += 1;
          }
        }
        localObject3 = ((JSONObject)localObject2).optJSONArray("activity_info_list");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() != 0))
        {
          localObject2 = ((MallFunction)localObject1).jFZ;
          localObject3 = ((JSONArray)localObject3).getJSONObject(0);
          localObject2 = new MallNews((String)localObject2);
          ((MallNews)localObject2).ByB = ((JSONObject)localObject3).optString("activity_id");
          ((MallNews)localObject2).dqk = ((JSONObject)localObject3).optString("activity_ticket");
          ((MallNews)localObject2).Dtb = ((JSONObject)localObject3).optString("activity_msg_content");
          ((MallNews)localObject2).Dtc = ((JSONObject)localObject3).optString("activity_link");
          ((MallNews)localObject2).Dtd = ((JSONObject)localObject3).optString("activity_icon_link");
          ((MallNews)localObject2).Dte = ((JSONObject)localObject3).optInt("activity_expired_time");
          ((MallNews)localObject2).Dtf = ((JSONObject)localObject3).optString("activity_tips");
          ((MallNews)localObject2).DqM = ((JSONObject)localObject3).optInt("activity_type");
          ((MallNews)localObject2).Dti = ((JSONObject)localObject3).optString("activity_url");
          ((MallNews)localObject2).Dtg = ((JSONObject)localObject3).optInt("is_msg_reserved");
          ((MallFunction)localObject1).DsT = ((MallNews)localObject2);
        }
        localArrayList.add(localObject1);
        i += 1;
      }
      return localObject1;
    }
    catch (JSONException paramJSONArray)
    {
      ae.printErrStackTrace("MicroMsg.MallLogic", paramJSONArray, "", new Object[0]);
      localObject1 = null;
      AppMethodBeat.o(70544);
    }
  }
  
  public static void Wi(int paramInt)
  {
    AppMethodBeat.i(70546);
    if ((d.FFH & DsW) == paramInt)
    {
      g.ajS();
      i = ((Integer)g.ajR().ajA().get(270343, Integer.valueOf(0))).intValue();
      if (paramInt != i) {
        ae.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + paramInt + ", clickedV=" + i);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (v.aAM()))
      {
        ae.d("MicroMsg.MallLogic", "Show mall entry redot");
        c.ahI().w(262156, true);
        g.ajS();
        g.ajR().ajA().set(270343, Integer.valueOf(paramInt));
        g.ajS();
        g.ajR().ajA().set(am.a.IUw, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(70546);
      return;
    }
  }
  
  public static void a(awm paramawm)
  {
    AppMethodBeat.i(190199);
    try
    {
      paramawm = new String(paramawm.toByteArray(), "ISO-8859-1");
      ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(am.a.Jei, paramawm);
      ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().fuc();
      AppMethodBeat.o(190199);
      return;
    }
    catch (IOException paramawm)
    {
      ae.e("MicroMsg.MallLogic", "save config exp, " + paramawm.getLocalizedMessage());
      AppMethodBeat.o(190199);
    }
  }
  
  public static String eKA()
  {
    AppMethodBeat.i(190206);
    String str = eKu().GOc;
    AppMethodBeat.o(190206);
    return str;
  }
  
  public static String eKt()
  {
    AppMethodBeat.i(70545);
    Object localObject = (TelephonyManager)ak.getContext().getSystemService("phone");
    if (localObject != null) {}
    for (localObject = ((TelephonyManager)localObject).getNetworkCountryIso();; localObject = "")
    {
      AppMethodBeat.o(70545);
      return localObject;
    }
  }
  
  private static awm eKu()
  {
    AppMethodBeat.i(190200);
    awm localawm = new awm();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(am.a.Jei, null);
    if (bu.isNullOrNil(str)) {
      ae.i("MicroMsg.MallLogic", "getMallNewFunctionListRespone is null");
    }
    for (;;)
    {
      AppMethodBeat.o(190200);
      return localawm;
      try
      {
        localawm.parseFrom(str.getBytes("ISO-8859-1"));
        ae.i("MicroMsg.MallLogic", "getMallNewFunctionListRespone success");
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.MallLogic", "getMallNewFunctionListRespone fail, " + localException.getLocalizedMessage());
      }
    }
  }
  
  public static SparseArray<String> eKv()
  {
    AppMethodBeat.i(190201);
    SparseArray localSparseArray = new SparseArray();
    Object localObject1 = eKu();
    if (((awm)localObject1).GroupList != null)
    {
      localObject1 = ((awm)localObject1).GroupList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (aun)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((aun)localObject2).GLv;
          localSparseArray.put(((ecx)localObject2).GLu, ((ecx)localObject2).GLc);
        }
      }
    }
    AppMethodBeat.o(190201);
    return localSparseArray;
  }
  
  public static SparseArray<Integer> eKw()
  {
    AppMethodBeat.i(190202);
    SparseArray localSparseArray = new SparseArray();
    awm localawm = eKu();
    if (localawm.GroupList != null)
    {
      int i = 0;
      while (i < localawm.GroupList.size())
      {
        aun localaun = (aun)localawm.GroupList.get(i);
        if (localaun != null) {
          localSparseArray.put(localaun.GLv.GLu, Integer.valueOf(i + 1));
        }
        i += 1;
      }
    }
    AppMethodBeat.o(190202);
    return localSparseArray;
  }
  
  public static ArrayList<Integer> eKx()
  {
    AppMethodBeat.i(190203);
    ArrayList localArrayList = new ArrayList();
    awm localawm = eKu();
    if (localawm.GroupList != null)
    {
      int i = 0;
      while (i < localawm.GroupList.size())
      {
        aun localaun = (aun)localawm.GroupList.get(i);
        if (localaun != null) {
          localArrayList.add(Integer.valueOf(localaun.GLv.GLu));
        }
        i += 1;
      }
    }
    AppMethodBeat.o(190203);
    return localArrayList;
  }
  
  public static ArrayList<aum> eKy()
  {
    AppMethodBeat.i(190204);
    ArrayList localArrayList = new ArrayList();
    Object localObject = eKu();
    if (((awm)localObject).GroupList != null)
    {
      localObject = ((awm)localObject).GroupList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aun localaun = (aun)((Iterator)localObject).next();
        if (localaun != null)
        {
          Iterator localIterator = localaun.GLw.iterator();
          while (localIterator.hasNext())
          {
            aum localaum = (aum)localIterator.next();
            if (localaum != null)
            {
              localaum.GLu = localaun.GLv.GLu;
              localArrayList.add(localaum);
            }
          }
        }
      }
    }
    AppMethodBeat.o(190204);
    return localArrayList;
  }
  
  public static SparseArray<ArrayList<Integer>> eKz()
  {
    AppMethodBeat.i(190205);
    SparseArray localSparseArray = new SparseArray();
    Object localObject = eKu();
    if (((awm)localObject).GroupList != null)
    {
      localObject = ((awm)localObject).GroupList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aun localaun = (aun)((Iterator)localObject).next();
        if (localaun != null)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = localaun.GLw.iterator();
          while (localIterator.hasNext())
          {
            aum localaum = (aum)localIterator.next();
            if (localaum != null) {
              localArrayList.add(Integer.valueOf(localaum.GLn.IhV));
            }
          }
          localSparseArray.put(localaun.GLv.GLu, localArrayList);
        }
      }
    }
    AppMethodBeat.o(190205);
    return localSparseArray;
  }
  
  public static boolean gT(List<a> paramList)
  {
    AppMethodBeat.i(70542);
    g.ajS();
    int j = ((Integer)g.ajR().ajA().get(270342, Integer.valueOf(0))).intValue();
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ae.d("MicroMsg.MallLogic", "i:" + i + ", lastClickedListMaxId:" + j + ", actId:" + ((a)paramList.get(i)).DsO);
        if (((a)paramList.get(i)).DsO > j)
        {
          AppMethodBeat.o(70542);
          return true;
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(70542);
    return false;
  }
  
  public static void gU(List<a> paramList)
  {
    AppMethodBeat.i(70543);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ae.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
      AppMethodBeat.o(70543);
      return;
    }
    int i = ((a)paramList.get(0)).DsO;
    ae.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId".concat(String.valueOf(i)));
    g.ajS();
    g.ajR().ajA().set(270342, Integer.valueOf(i));
    g.ajS();
    g.ajR().ajA().fuc();
    AppMethodBeat.o(70543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.b
 * JD-Core Version:    0.7.0.1
 */