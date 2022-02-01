package com.tencent.mm.plugin.wallet_core.model.mall;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.e.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.cdy;
import com.tencent.mm.protocal.protobuf.geb;
import com.tencent.mm.protocal.protobuf.gee;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.ab;
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
  public static int VKL = -256;
  public static int VKM = 621019136;
  public static int VKN = 637534720;
  
  public static ArrayList<MallNews> V(JSONArray paramJSONArray)
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
        localMallNews.VKS = localJSONObject.optString("activity_icon_link");
        localMallNews.VKQ = localJSONObject.optString("activity_msg_content");
        localMallNews.VKT = localJSONObject.optString("activity_tips");
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
  
  public static ArrayList<a> W(JSONArray paramJSONArray)
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
        locala.VKD = localJSONObject.optInt("banner_id");
        locala.VKE = localJSONObject.optString("banner_title");
        locala.VKF = localJSONObject.optString("banner_link");
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
  
  public static SparseArray<String> X(JSONArray paramJSONArray)
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
  
  public static ArrayList<MallFunction> Y(JSONArray paramJSONArray)
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
        ((MallFunction)localObject1).qBb = ((JSONObject)localObject2).getString("func_id");
        ((MallFunction)localObject1).idA = ((JSONObject)localObject2).getString("func_name");
        ((MallFunction)localObject1).VKG = ((JSONObject)localObject2).optString("func_icon_url");
        ((MallFunction)localObject1).KKg = ((JSONObject)localObject2).optString("hd_icon_url");
        ((MallFunction)localObject1).KKh = ((JSONObject)localObject2).optString("func_foregroud_icon_url");
        ((MallFunction)localObject1).ihx = ((JSONObject)localObject2).optString("native_url");
        ((MallFunction)localObject1).h5Url = ((JSONObject)localObject2).optString("h5_url");
        ((MallFunction)localObject1).type = ((JSONObject)localObject2).optInt("property_type", 0);
        ((MallFunction)localObject1).VKJ = ((JSONObject)localObject2).optString("third_party_disclaimer");
        ((MallFunction)localObject1).VKK = ((JSONObject)localObject2).optInt("download_restrict", 0);
        Object localObject3 = ((JSONObject)localObject2).optJSONArray("remark_name_list");
        if (localObject3 != null)
        {
          ((MallFunction)localObject1).VKH = new ArrayList();
          int m = ((JSONArray)localObject3).length();
          int j = 0;
          while (j < m)
          {
            ((MallFunction)localObject1).VKH.add(((JSONArray)localObject3).getString(j));
            j += 1;
          }
        }
        localObject3 = ((JSONObject)localObject2).optJSONArray("activity_info_list");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() != 0))
        {
          localObject2 = ((MallFunction)localObject1).qBb;
          localObject3 = ((JSONArray)localObject3).getJSONObject(0);
          localObject2 = new MallNews((String)localObject2);
          ((MallNews)localObject2).rBJ = ((JSONObject)localObject3).optString("activity_id");
          ((MallNews)localObject2).hFb = ((JSONObject)localObject3).optString("activity_ticket");
          ((MallNews)localObject2).VKQ = ((JSONObject)localObject3).optString("activity_msg_content");
          ((MallNews)localObject2).VKR = ((JSONObject)localObject3).optString("activity_link");
          ((MallNews)localObject2).VKS = ((JSONObject)localObject3).optString("activity_icon_link");
          ((MallNews)localObject2).expireTime = ((JSONObject)localObject3).optInt("activity_expired_time");
          ((MallNews)localObject2).VKT = ((JSONObject)localObject3).optString("activity_tips");
          ((MallNews)localObject2).Avy = ((JSONObject)localObject3).optInt("activity_type");
          ((MallNews)localObject2).VKW = ((JSONObject)localObject3).optString("activity_url");
          ((MallNews)localObject2).VKU = ((JSONObject)localObject3).optInt("is_msg_reserved");
          ((MallFunction)localObject1).VKI = ((MallNews)localObject2);
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
  
  public static void a(cdy paramcdy)
  {
    AppMethodBeat.i(301187);
    try
    {
      paramcdy = e.aC(paramcdy.toByteArray());
      ((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(at.a.adfZ, paramcdy);
      ((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().iZy();
      AppMethodBeat.o(301187);
      return;
    }
    catch (IOException paramcdy)
    {
      Log.e("MicroMsg.MallLogic", "save config exp, " + paramcdy.getLocalizedMessage());
      AppMethodBeat.o(301187);
    }
  }
  
  public static void asn(int paramInt)
  {
    AppMethodBeat.i(70546);
    if ((d.Yxh & VKL) == paramInt)
    {
      h.baF();
      i = ((Integer)h.baE().ban().d(270343, Integer.valueOf(0))).intValue();
      if (paramInt != i) {
        Log.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + paramInt + ", clickedV=" + i);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (z.bBd()))
      {
        Log.d("MicroMsg.MallLogic", "Show mall entry redot");
        c.aYo().Q(262156, true);
        h.baF();
        h.baE().ban().B(270343, Integer.valueOf(paramInt));
        h.baF();
        h.baE().ban().set(at.a.acSp, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(70546);
      return;
    }
  }
  
  public static String ijV()
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
  
  private static cdy ijW()
  {
    AppMethodBeat.i(301188);
    cdy localcdy = new cdy();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.adfZ, null);
    if (Util.isNullOrNil(str)) {
      Log.i("MicroMsg.MallLogic", "getMallNewFunctionListRespone is null");
    }
    for (;;)
    {
      AppMethodBeat.o(301188);
      return localcdy;
      try
      {
        localcdy.parseFrom(e.bFB(str));
        Log.i("MicroMsg.MallLogic", "getMallNewFunctionListRespone success");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MallLogic", "getMallNewFunctionListRespone fail, " + localException.getLocalizedMessage());
      }
    }
  }
  
  public static SparseArray<String> ijX()
  {
    AppMethodBeat.i(301189);
    SparseArray localSparseArray = new SparseArray();
    Object localObject1 = ijW();
    if (((cdy)localObject1).GroupList != null)
    {
      localObject1 = ((cdy)localObject1).GroupList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (car)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((car)localObject2).aajH != null))
        {
          localObject2 = ((car)localObject2).aajH;
          localSparseArray.put(((gee)localObject2).aajG, ((gee)localObject2).aajr);
        }
      }
    }
    AppMethodBeat.o(301189);
    return localSparseArray;
  }
  
  public static SparseArray<Integer> ijY()
  {
    AppMethodBeat.i(301190);
    SparseArray localSparseArray = new SparseArray();
    cdy localcdy = ijW();
    if (localcdy.GroupList != null)
    {
      int i = 0;
      while (i < localcdy.GroupList.size())
      {
        car localcar = (car)localcdy.GroupList.get(i);
        if ((localcar != null) && (localcar.aajH != null)) {
          localSparseArray.put(localcar.aajH.aajG, Integer.valueOf(i + 1));
        }
        i += 1;
      }
    }
    AppMethodBeat.o(301190);
    return localSparseArray;
  }
  
  public static ArrayList<Integer> ijZ()
  {
    AppMethodBeat.i(301191);
    ArrayList localArrayList = new ArrayList();
    cdy localcdy = ijW();
    if (localcdy.GroupList != null)
    {
      int i = 0;
      while (i < localcdy.GroupList.size())
      {
        car localcar = (car)localcdy.GroupList.get(i);
        if ((localcar != null) && (localcar.aajH != null)) {
          localArrayList.add(Integer.valueOf(localcar.aajH.aajG));
        }
        i += 1;
      }
    }
    AppMethodBeat.o(301191);
    return localArrayList;
  }
  
  public static ArrayList<caq> ika()
  {
    AppMethodBeat.i(301194);
    ArrayList localArrayList = new ArrayList();
    Object localObject = ijW();
    if (((cdy)localObject).GroupList != null)
    {
      localObject = ((cdy)localObject).GroupList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        car localcar = (car)((Iterator)localObject).next();
        if (localcar != null)
        {
          Iterator localIterator = localcar.aajI.iterator();
          while (localIterator.hasNext())
          {
            caq localcaq = (caq)localIterator.next();
            if (localcaq != null)
            {
              localcaq.aajG = localcar.aajH.aajG;
              localArrayList.add(localcaq);
            }
          }
        }
      }
    }
    AppMethodBeat.o(301194);
    return localArrayList;
  }
  
  public static SparseArray<ArrayList<Integer>> ikb()
  {
    AppMethodBeat.i(301196);
    SparseArray localSparseArray = new SparseArray();
    Object localObject = ijW();
    if (((cdy)localObject).GroupList != null)
    {
      localObject = ((cdy)localObject).GroupList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        car localcar = (car)((Iterator)localObject).next();
        if (localcar != null)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = localcar.aajI.iterator();
          while (localIterator.hasNext())
          {
            caq localcaq = (caq)localIterator.next();
            if (localcaq != null) {
              localArrayList.add(Integer.valueOf(localcaq.aajz.acbJ));
            }
          }
          localSparseArray.put(localcar.aajH.aajG, localArrayList);
        }
      }
    }
    AppMethodBeat.o(301196);
    return localSparseArray;
  }
  
  public static String ikc()
  {
    AppMethodBeat.i(301198);
    String str = ijW().aaod;
    AppMethodBeat.o(301198);
    return str;
  }
  
  public static boolean lX(List<a> paramList)
  {
    AppMethodBeat.i(70542);
    h.baF();
    int j = ((Integer)h.baE().ban().d(270342, Integer.valueOf(0))).intValue();
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        Log.d("MicroMsg.MallLogic", "i:" + i + ", lastClickedListMaxId:" + j + ", actId:" + ((a)paramList.get(i)).VKD);
        if (((a)paramList.get(i)).VKD > j)
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
  
  public static void lY(List<a> paramList)
  {
    AppMethodBeat.i(70543);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      Log.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
      AppMethodBeat.o(70543);
      return;
    }
    int i = ((a)paramList.get(0)).VKD;
    Log.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId".concat(String.valueOf(i)));
    h.baF();
    h.baE().ban().B(270342, Integer.valueOf(i));
    h.baF();
    h.baE().ban().iZy();
    AppMethodBeat.o(70543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.b
 * JD-Core Version:    0.7.0.1
 */