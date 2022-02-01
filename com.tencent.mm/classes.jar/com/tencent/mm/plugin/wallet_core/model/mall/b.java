package com.tencent.mm.plugin.wallet_core.model.mall;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bfw;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.exc;
import com.tencent.mm.protocal.protobuf.exf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
  public static int Ici = -256;
  public static int Icj = 621019136;
  public static int Ick = 637534720;
  
  public static ArrayList<MallNews> O(JSONArray paramJSONArray)
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
        localMallNews.Icp = localJSONObject.optString("activity_icon_link");
        localMallNews.Icn = localJSONObject.optString("activity_msg_content");
        localMallNews.Icq = localJSONObject.optString("activity_tips");
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
  
  public static ArrayList<a> P(JSONArray paramJSONArray)
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
        locala.Ica = localJSONObject.optInt("banner_id");
        locala.Icb = localJSONObject.optString("banner_title");
        locala.Icc = localJSONObject.optString("banner_link");
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
  
  public static SparseArray<String> Q(JSONArray paramJSONArray)
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
  
  public static ArrayList<MallFunction> R(JSONArray paramJSONArray)
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
        ((MallFunction)localObject1).kHR = ((JSONObject)localObject2).getString("func_id");
        ((MallFunction)localObject1).edq = ((JSONObject)localObject2).getString("func_name");
        ((MallFunction)localObject1).Icd = ((JSONObject)localObject2).optString("func_icon_url");
        ((MallFunction)localObject1).zkt = ((JSONObject)localObject2).optString("hd_icon_url");
        ((MallFunction)localObject1).zku = ((JSONObject)localObject2).optString("func_foregroud_icon_url");
        ((MallFunction)localObject1).egX = ((JSONObject)localObject2).optString("native_url");
        ((MallFunction)localObject1).h5Url = ((JSONObject)localObject2).optString("h5_url");
        ((MallFunction)localObject1).type = ((JSONObject)localObject2).optInt("property_type", 0);
        ((MallFunction)localObject1).Icg = ((JSONObject)localObject2).optString("third_party_disclaimer");
        ((MallFunction)localObject1).Ich = ((JSONObject)localObject2).optInt("download_restrict", 0);
        Object localObject3 = ((JSONObject)localObject2).optJSONArray("remark_name_list");
        if (localObject3 != null)
        {
          ((MallFunction)localObject1).Ice = new ArrayList();
          int m = ((JSONArray)localObject3).length();
          int j = 0;
          while (j < m)
          {
            ((MallFunction)localObject1).Ice.add(((JSONArray)localObject3).getString(j));
            j += 1;
          }
        }
        localObject3 = ((JSONObject)localObject2).optJSONArray("activity_info_list");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() != 0))
        {
          localObject2 = ((MallFunction)localObject1).kHR;
          localObject3 = ((JSONArray)localObject3).getJSONObject(0);
          localObject2 = new MallNews((String)localObject2);
          ((MallNews)localObject2).FJm = ((JSONObject)localObject3).optString("activity_id");
          ((MallNews)localObject2).dHx = ((JSONObject)localObject3).optString("activity_ticket");
          ((MallNews)localObject2).Icn = ((JSONObject)localObject3).optString("activity_msg_content");
          ((MallNews)localObject2).Ico = ((JSONObject)localObject3).optString("activity_link");
          ((MallNews)localObject2).Icp = ((JSONObject)localObject3).optString("activity_icon_link");
          ((MallNews)localObject2).DrO = ((JSONObject)localObject3).optInt("activity_expired_time");
          ((MallNews)localObject2).Icq = ((JSONObject)localObject3).optString("activity_tips");
          ((MallNews)localObject2).trD = ((JSONObject)localObject3).optInt("activity_type");
          ((MallNews)localObject2).Ict = ((JSONObject)localObject3).optString("activity_url");
          ((MallNews)localObject2).Icr = ((JSONObject)localObject3).optInt("is_msg_reserved");
          ((MallFunction)localObject1).Icf = ((MallNews)localObject2);
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
  
  public static void a(bhw parambhw)
  {
    AppMethodBeat.i(214206);
    try
    {
      parambhw = com.tencent.e.f.e.bytesToHexString(parambhw.toByteArray());
      ((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.OnP, parambhw);
      ((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().gBI();
      AppMethodBeat.o(214206);
      return;
    }
    catch (IOException parambhw)
    {
      Log.e("MicroMsg.MallLogic", "save config exp, " + parambhw.getLocalizedMessage());
      AppMethodBeat.o(214206);
    }
  }
  
  public static void aeM(int paramInt)
  {
    AppMethodBeat.i(70546);
    if ((d.KyO & Ici) == paramInt)
    {
      g.aAi();
      i = ((Integer)g.aAh().azQ().get(270343, Integer.valueOf(0))).intValue();
      if (paramInt != i) {
        Log.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + paramInt + ", clickedV=" + i);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (z.aUj()))
      {
        Log.d("MicroMsg.MallLogic", "Show mall entry redot");
        c.axV().A(262156, true);
        g.aAi();
        g.aAh().azQ().set(270343, Integer.valueOf(paramInt));
        g.aAi();
        g.aAh().azQ().set(ar.a.OcK, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(70546);
      return;
    }
  }
  
  public static String fRY()
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
  
  private static bhw fRZ()
  {
    AppMethodBeat.i(214207);
    bhw localbhw = new bhw();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.OnP, null);
    if (Util.isNullOrNil(str)) {
      Log.i("MicroMsg.MallLogic", "getMallNewFunctionListRespone is null");
    }
    for (;;)
    {
      AppMethodBeat.o(214207);
      return localbhw;
      try
      {
        localbhw.parseFrom(com.tencent.e.f.e.bqe(str));
        Log.i("MicroMsg.MallLogic", "getMallNewFunctionListRespone success");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MallLogic", "getMallNewFunctionListRespone fail, " + localException.getLocalizedMessage());
      }
    }
  }
  
  public static SparseArray<String> fSa()
  {
    AppMethodBeat.i(214208);
    SparseArray localSparseArray = new SparseArray();
    Object localObject1 = fRZ();
    if (((bhw)localObject1).GroupList != null)
    {
      localObject1 = ((bhw)localObject1).GroupList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (bfw)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((bfw)localObject2).LPz != null))
        {
          localObject2 = ((bfw)localObject2).LPz;
          localSparseArray.put(((exf)localObject2).LPy, ((exf)localObject2).LPg);
        }
      }
    }
    AppMethodBeat.o(214208);
    return localSparseArray;
  }
  
  public static SparseArray<Integer> fSb()
  {
    AppMethodBeat.i(214209);
    SparseArray localSparseArray = new SparseArray();
    bhw localbhw = fRZ();
    if (localbhw.GroupList != null)
    {
      int i = 0;
      while (i < localbhw.GroupList.size())
      {
        bfw localbfw = (bfw)localbhw.GroupList.get(i);
        if ((localbfw != null) && (localbfw.LPz != null)) {
          localSparseArray.put(localbfw.LPz.LPy, Integer.valueOf(i + 1));
        }
        i += 1;
      }
    }
    AppMethodBeat.o(214209);
    return localSparseArray;
  }
  
  public static ArrayList<Integer> fSc()
  {
    AppMethodBeat.i(214210);
    ArrayList localArrayList = new ArrayList();
    bhw localbhw = fRZ();
    if (localbhw.GroupList != null)
    {
      int i = 0;
      while (i < localbhw.GroupList.size())
      {
        bfw localbfw = (bfw)localbhw.GroupList.get(i);
        if ((localbfw != null) && (localbfw.LPz != null)) {
          localArrayList.add(Integer.valueOf(localbfw.LPz.LPy));
        }
        i += 1;
      }
    }
    AppMethodBeat.o(214210);
    return localArrayList;
  }
  
  public static ArrayList<bfv> fSd()
  {
    AppMethodBeat.i(214211);
    ArrayList localArrayList = new ArrayList();
    Object localObject = fRZ();
    if (((bhw)localObject).GroupList != null)
    {
      localObject = ((bhw)localObject).GroupList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bfw localbfw = (bfw)((Iterator)localObject).next();
        if (localbfw != null)
        {
          Iterator localIterator = localbfw.LPA.iterator();
          while (localIterator.hasNext())
          {
            bfv localbfv = (bfv)localIterator.next();
            if (localbfv != null)
            {
              localbfv.LPy = localbfw.LPz.LPy;
              localArrayList.add(localbfv);
            }
          }
        }
      }
    }
    AppMethodBeat.o(214211);
    return localArrayList;
  }
  
  public static SparseArray<ArrayList<Integer>> fSe()
  {
    AppMethodBeat.i(214212);
    SparseArray localSparseArray = new SparseArray();
    Object localObject = fRZ();
    if (((bhw)localObject).GroupList != null)
    {
      localObject = ((bhw)localObject).GroupList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bfw localbfw = (bfw)((Iterator)localObject).next();
        if (localbfw != null)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = localbfw.LPA.iterator();
          while (localIterator.hasNext())
          {
            bfv localbfv = (bfv)localIterator.next();
            if (localbfv != null) {
              localArrayList.add(Integer.valueOf(localbfv.LPr.Nuz));
            }
          }
          localSparseArray.put(localbfw.LPz.LPy, localArrayList);
        }
      }
    }
    AppMethodBeat.o(214212);
    return localSparseArray;
  }
  
  public static String fSf()
  {
    AppMethodBeat.i(214213);
    String str = fRZ().LSh;
    AppMethodBeat.o(214213);
    return str;
  }
  
  public static boolean hZ(List<a> paramList)
  {
    AppMethodBeat.i(70542);
    g.aAi();
    int j = ((Integer)g.aAh().azQ().get(270342, Integer.valueOf(0))).intValue();
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        Log.d("MicroMsg.MallLogic", "i:" + i + ", lastClickedListMaxId:" + j + ", actId:" + ((a)paramList.get(i)).Ica);
        if (((a)paramList.get(i)).Ica > j)
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
  
  public static void ia(List<a> paramList)
  {
    AppMethodBeat.i(70543);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      Log.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
      AppMethodBeat.o(70543);
      return;
    }
    int i = ((a)paramList.get(0)).Ica;
    Log.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId".concat(String.valueOf(i)));
    g.aAi();
    g.aAh().azQ().set(270342, Integer.valueOf(i));
    g.aAi();
    g.aAh().azQ().gBI();
    AppMethodBeat.o(70543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.b
 * JD-Core Version:    0.7.0.1
 */