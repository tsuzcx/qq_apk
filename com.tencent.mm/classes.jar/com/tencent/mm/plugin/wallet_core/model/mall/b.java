package com.tencent.mm.plugin.wallet_core.model.mall;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.d.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.bph;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.fhs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.aa;
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
  public static int OUu = -256;
  public static int OUv = 621019136;
  public static int OUw = 637534720;
  
  public static ArrayList<MallNews> Q(JSONArray paramJSONArray)
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
        localMallNews.OUB = localJSONObject.optString("activity_icon_link");
        localMallNews.OUz = localJSONObject.optString("activity_msg_content");
        localMallNews.OUC = localJSONObject.optString("activity_tips");
        localArrayList.add(localMallNews);
        i += 1;
      }
      AppMethodBeat.o(70539);
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      Log.printErrStackTrace("MicroMsg.MallLogic", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(70539);
    }
    return null;
  }
  
  public static ArrayList<a> R(JSONArray paramJSONArray)
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
        locala.OUm = localJSONObject.optInt("banner_id");
        locala.OUn = localJSONObject.optString("banner_title");
        locala.OUo = localJSONObject.optString("banner_link");
        localArrayList.add(locala);
        i += 1;
      }
      AppMethodBeat.o(70540);
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      Log.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + paramJSONArray.getMessage());
      AppMethodBeat.o(70540);
    }
    return null;
  }
  
  public static SparseArray<String> S(JSONArray paramJSONArray)
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
      Log.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + paramJSONArray.getMessage());
      AppMethodBeat.o(70541);
    }
    return null;
  }
  
  public static ArrayList<MallFunction> T(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(70544);
    try
    {
      ArrayList localArrayList = new ArrayList();
      int k = paramJSONArray.length();
      Log.d("MicroMsg.MallLogic", "functions.jsonArray.length : ".concat(String.valueOf(k)));
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
        ((MallFunction)localObject1).nBK = ((JSONObject)localObject2).getString("func_id");
        ((MallFunction)localObject1).fXz = ((JSONObject)localObject2).getString("func_name");
        ((MallFunction)localObject1).OUp = ((JSONObject)localObject2).optString("func_icon_url");
        ((MallFunction)localObject1).EPJ = ((JSONObject)localObject2).optString("hd_icon_url");
        ((MallFunction)localObject1).EPK = ((JSONObject)localObject2).optString("func_foregroud_icon_url");
        ((MallFunction)localObject1).gbn = ((JSONObject)localObject2).optString("native_url");
        ((MallFunction)localObject1).h5Url = ((JSONObject)localObject2).optString("h5_url");
        ((MallFunction)localObject1).type = ((JSONObject)localObject2).optInt("property_type", 0);
        ((MallFunction)localObject1).OUs = ((JSONObject)localObject2).optString("third_party_disclaimer");
        ((MallFunction)localObject1).OUt = ((JSONObject)localObject2).optInt("download_restrict", 0);
        Object localObject3 = ((JSONObject)localObject2).optJSONArray("remark_name_list");
        if (localObject3 != null)
        {
          ((MallFunction)localObject1).OUq = new ArrayList();
          int m = ((JSONArray)localObject3).length();
          int j = 0;
          while (j < m)
          {
            ((MallFunction)localObject1).OUq.add(((JSONArray)localObject3).getString(j));
            j += 1;
          }
        }
        localObject3 = ((JSONObject)localObject2).optJSONArray("activity_info_list");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() != 0))
        {
          localObject2 = ((MallFunction)localObject1).nBK;
          localObject3 = ((JSONArray)localObject3).getJSONObject(0);
          localObject2 = new MallNews((String)localObject2);
          ((MallNews)localObject2).oym = ((JSONObject)localObject3).optString("activity_id");
          ((MallNews)localObject2).fAo = ((JSONObject)localObject3).optString("activity_ticket");
          ((MallNews)localObject2).OUz = ((JSONObject)localObject3).optString("activity_msg_content");
          ((MallNews)localObject2).OUA = ((JSONObject)localObject3).optString("activity_link");
          ((MallNews)localObject2).OUB = ((JSONObject)localObject3).optString("activity_icon_link");
          ((MallNews)localObject2).expireTime = ((JSONObject)localObject3).optInt("activity_expired_time");
          ((MallNews)localObject2).OUC = ((JSONObject)localObject3).optString("activity_tips");
          ((MallNews)localObject2).wYj = ((JSONObject)localObject3).optInt("activity_type");
          ((MallNews)localObject2).OUF = ((JSONObject)localObject3).optString("activity_url");
          ((MallNews)localObject2).OUD = ((JSONObject)localObject3).optInt("is_msg_reserved");
          ((MallFunction)localObject1).OUr = ((MallNews)localObject2);
        }
        localArrayList.add(localObject1);
        i += 1;
      }
      return localObject1;
    }
    catch (JSONException paramJSONArray)
    {
      Log.printErrStackTrace("MicroMsg.MallLogic", paramJSONArray, "", new Object[0]);
      localObject1 = null;
      AppMethodBeat.o(70544);
    }
  }
  
  public static void a(bph parambph)
  {
    AppMethodBeat.i(273692);
    try
    {
      parambph = e.aC(parambph.toByteArray());
      ((com.tencent.mm.plugin.wxpay.a.a)h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.VDf, parambph);
      ((com.tencent.mm.plugin.wxpay.a.a)h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().hxT();
      AppMethodBeat.o(273692);
      return;
    }
    catch (IOException parambph)
    {
      Log.e("MicroMsg.MallLogic", "save config exp, " + parambph.getLocalizedMessage());
      AppMethodBeat.o(273692);
    }
  }
  
  public static void amz(int paramInt)
  {
    AppMethodBeat.i(70546);
    if ((d.RAD & OUu) == paramInt)
    {
      h.aHH();
      i = ((Integer)h.aHG().aHp().b(270343, Integer.valueOf(0))).intValue();
      if (paramInt != i) {
        Log.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + paramInt + ", clickedV=" + i);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (z.bdl()))
      {
        Log.d("MicroMsg.MallLogic", "Show mall entry redot");
        c.aFn().C(262156, true);
        h.aHH();
        h.aHG().aHp().i(270343, Integer.valueOf(paramInt));
        h.aHH();
        h.aHG().aHp().set(ar.a.VqN, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(70546);
      return;
    }
  }
  
  public static String gKD()
  {
    AppMethodBeat.i(70545);
    Object localObject = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
    if (localObject != null) {}
    for (localObject = ((TelephonyManager)localObject).getNetworkCountryIso();; localObject = "")
    {
      AppMethodBeat.o(70545);
      return localObject;
    }
  }
  
  private static bph gKE()
  {
    AppMethodBeat.i(273693);
    bph localbph = new bph();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.VDf, null);
    if (Util.isNullOrNil(str)) {
      Log.i("MicroMsg.MallLogic", "getMallNewFunctionListRespone is null");
    }
    for (;;)
    {
      AppMethodBeat.o(273693);
      return localbph;
      try
      {
        localbph.parseFrom(e.bCW(str));
        Log.i("MicroMsg.MallLogic", "getMallNewFunctionListRespone success");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MallLogic", "getMallNewFunctionListRespone fail, " + localException.getLocalizedMessage());
      }
    }
  }
  
  public static SparseArray<String> gKF()
  {
    AppMethodBeat.i(273694);
    SparseArray localSparseArray = new SparseArray();
    Object localObject1 = gKE();
    if (((bph)localObject1).GroupList != null)
    {
      localObject1 = ((bph)localObject1).GroupList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (bmx)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((bmx)localObject2).SXN != null))
        {
          localObject2 = ((bmx)localObject2).SXN;
          localSparseArray.put(((fhs)localObject2).SXM, ((fhs)localObject2).SXx);
        }
      }
    }
    AppMethodBeat.o(273694);
    return localSparseArray;
  }
  
  public static SparseArray<Integer> gKG()
  {
    AppMethodBeat.i(273695);
    SparseArray localSparseArray = new SparseArray();
    bph localbph = gKE();
    if (localbph.GroupList != null)
    {
      int i = 0;
      while (i < localbph.GroupList.size())
      {
        bmx localbmx = (bmx)localbph.GroupList.get(i);
        if ((localbmx != null) && (localbmx.SXN != null)) {
          localSparseArray.put(localbmx.SXN.SXM, Integer.valueOf(i + 1));
        }
        i += 1;
      }
    }
    AppMethodBeat.o(273695);
    return localSparseArray;
  }
  
  public static ArrayList<Integer> gKH()
  {
    AppMethodBeat.i(273696);
    ArrayList localArrayList = new ArrayList();
    bph localbph = gKE();
    if (localbph.GroupList != null)
    {
      int i = 0;
      while (i < localbph.GroupList.size())
      {
        bmx localbmx = (bmx)localbph.GroupList.get(i);
        if ((localbmx != null) && (localbmx.SXN != null)) {
          localArrayList.add(Integer.valueOf(localbmx.SXN.SXM));
        }
        i += 1;
      }
    }
    AppMethodBeat.o(273696);
    return localArrayList;
  }
  
  public static ArrayList<bmw> gKI()
  {
    AppMethodBeat.i(273698);
    ArrayList localArrayList = new ArrayList();
    Object localObject = gKE();
    if (((bph)localObject).GroupList != null)
    {
      localObject = ((bph)localObject).GroupList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bmx localbmx = (bmx)((Iterator)localObject).next();
        if (localbmx != null)
        {
          Iterator localIterator = localbmx.SXO.iterator();
          while (localIterator.hasNext())
          {
            bmw localbmw = (bmw)localIterator.next();
            if (localbmw != null)
            {
              localbmw.SXM = localbmx.SXN.SXM;
              localArrayList.add(localbmw);
            }
          }
        }
      }
    }
    AppMethodBeat.o(273698);
    return localArrayList;
  }
  
  public static SparseArray<ArrayList<Integer>> gKJ()
  {
    AppMethodBeat.i(273700);
    SparseArray localSparseArray = new SparseArray();
    Object localObject = gKE();
    if (((bph)localObject).GroupList != null)
    {
      localObject = ((bph)localObject).GroupList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bmx localbmx = (bmx)((Iterator)localObject).next();
        if (localbmx != null)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = localbmx.SXO.iterator();
          while (localIterator.hasNext())
          {
            bmw localbmw = (bmw)localIterator.next();
            if (localbmw != null) {
              localArrayList.add(Integer.valueOf(localbmw.SXF.UHA));
            }
          }
          localSparseArray.put(localbmx.SXN.SXM, localArrayList);
        }
      }
    }
    AppMethodBeat.o(273700);
    return localSparseArray;
  }
  
  public static String gKK()
  {
    AppMethodBeat.i(273701);
    String str = gKE().TaR;
    AppMethodBeat.o(273701);
    return str;
  }
  
  public static boolean iP(List<a> paramList)
  {
    AppMethodBeat.i(70542);
    h.aHH();
    int j = ((Integer)h.aHG().aHp().b(270342, Integer.valueOf(0))).intValue();
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        Log.d("MicroMsg.MallLogic", "i:" + i + ", lastClickedListMaxId:" + j + ", actId:" + ((a)paramList.get(i)).OUm);
        if (((a)paramList.get(i)).OUm > j)
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
  
  public static void iQ(List<a> paramList)
  {
    AppMethodBeat.i(70543);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      Log.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
      AppMethodBeat.o(70543);
      return;
    }
    int i = ((a)paramList.get(0)).OUm;
    Log.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId".concat(String.valueOf(i)));
    h.aHH();
    h.aHG().aHp().i(270342, Integer.valueOf(i));
    h.aHH();
    h.aHG().aHp().hxT();
    AppMethodBeat.o(70543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.b
 * JD-Core Version:    0.7.0.1
 */