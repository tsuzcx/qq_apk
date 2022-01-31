package com.tencent.mm.plugin.wallet_core.model.mall;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static int qzA = -256;
  public static int qzB = 621019136;
  public static int qzC = 637534720;
  
  public static ArrayList<a> A(JSONArray paramJSONArray)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramJSONArray.length();
      int i = 0;
      Object localObject;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = paramJSONArray.getJSONObject(i);
        a locala = new a();
        locala.qzs = ((JSONObject)localObject).optInt("banner_id");
        locala.qzt = ((JSONObject)localObject).optString("banner_title");
        locala.qzu = ((JSONObject)localObject).optString("banner_link");
        localArrayList.add(locala);
        i += 1;
      }
      return localObject;
    }
    catch (JSONException paramJSONArray)
    {
      y.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + paramJSONArray.getMessage());
      localObject = null;
    }
  }
  
  public static void AQ(int paramInt)
  {
    if ((d.spa & qzA) == paramInt)
    {
      g.DQ();
      i = ((Integer)g.DP().Dz().get(270343, Integer.valueOf(0))).intValue();
      if (paramInt != i) {
        y.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + paramInt + ", clickedV=" + i);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (q.Gs()))
      {
        y.d("MicroMsg.MallLogic", "Show mall entry redot");
        c.BS().v(262156, true);
        g.DQ();
        g.DP().Dz().o(270343, Integer.valueOf(paramInt));
        g.DQ();
        g.DP().Dz().c(ac.a.uwW, Long.valueOf(System.currentTimeMillis()));
      }
      return;
    }
  }
  
  public static SparseArray<String> B(JSONArray paramJSONArray)
  {
    int i = 0;
    try
    {
      SparseArray localSparseArray = new SparseArray();
      Object localObject;
      for (;;)
      {
        localObject = localSparseArray;
        if (i >= paramJSONArray.length()) {
          break;
        }
        localObject = paramJSONArray.getJSONObject(i);
        int j = ((JSONObject)localObject).optInt("type_id", 0);
        if (j != 0) {
          localSparseArray.put(j, ((JSONObject)localObject).optString("type_name"));
        }
        i += 1;
      }
      return localObject;
    }
    catch (JSONException paramJSONArray)
    {
      y.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + paramJSONArray.getMessage());
      localObject = null;
    }
  }
  
  public static ArrayList<MallFunction> C(JSONArray paramJSONArray)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      int k = paramJSONArray.length();
      y.d("MicroMsg.MallLogic", "functions.jsonArray.length : " + k);
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
        ((MallFunction)localObject1).npy = ((JSONObject)localObject2).getString("func_id");
        ((MallFunction)localObject1).caU = ((JSONObject)localObject2).getString("func_name");
        ((MallFunction)localObject1).qzv = ((JSONObject)localObject2).optString("func_icon_url");
        ((MallFunction)localObject1).lZc = ((JSONObject)localObject2).optString("hd_icon_url");
        ((MallFunction)localObject1).lZd = ((JSONObject)localObject2).optString("func_foregroud_icon_url");
        ((MallFunction)localObject1).ceb = ((JSONObject)localObject2).optString("native_url");
        ((MallFunction)localObject1).lfj = ((JSONObject)localObject2).optString("h5_url");
        ((MallFunction)localObject1).type = ((JSONObject)localObject2).optInt("property_type", 0);
        ((MallFunction)localObject1).qzy = ((JSONObject)localObject2).optString("third_party_disclaimer");
        ((MallFunction)localObject1).qzz = ((JSONObject)localObject2).optInt("download_restrict", 0);
        Object localObject3 = ((JSONObject)localObject2).optJSONArray("remark_name_list");
        if (localObject3 != null)
        {
          ((MallFunction)localObject1).qzw = new ArrayList();
          int m = ((JSONArray)localObject3).length();
          int j = 0;
          while (j < m)
          {
            ((MallFunction)localObject1).qzw.add(((JSONArray)localObject3).getString(j));
            j += 1;
          }
        }
        localObject3 = ((JSONObject)localObject2).optJSONArray("activity_info_list");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() != 0))
        {
          localObject2 = ((MallFunction)localObject1).npy;
          localObject3 = ((JSONArray)localObject3).getJSONObject(0);
          localObject2 = new MallNews((String)localObject2);
          ((MallNews)localObject2).pva = ((JSONObject)localObject3).optString("activity_id");
          ((MallNews)localObject2).bJY = ((JSONObject)localObject3).optString("activity_ticket");
          ((MallNews)localObject2).qzF = ((JSONObject)localObject3).optString("activity_msg_content");
          ((MallNews)localObject2).qzG = ((JSONObject)localObject3).optString("activity_link");
          ((MallNews)localObject2).qzH = ((JSONObject)localObject3).optString("activity_icon_link");
          ((MallNews)localObject2).qzI = ((JSONObject)localObject3).optInt("activity_expired_time");
          ((MallNews)localObject2).qzJ = ((JSONObject)localObject3).optString("activity_tips");
          ((MallNews)localObject2).qxA = ((JSONObject)localObject3).optInt("activity_type");
          ((MallNews)localObject2).qzM = ((JSONObject)localObject3).optString("activity_url");
          ((MallNews)localObject2).qzK = ((JSONObject)localObject3).optInt("is_msg_reserved");
          ((MallFunction)localObject1).qzx = ((MallNews)localObject2);
        }
        localArrayList.add(localObject1);
        i += 1;
      }
      return localObject1;
    }
    catch (JSONException paramJSONArray)
    {
      y.printErrStackTrace("MicroMsg.MallLogic", paramJSONArray, "", new Object[0]);
      localObject1 = null;
    }
  }
  
  public static String bWf()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)ae.getContext().getSystemService("phone");
    if (localTelephonyManager != null) {
      return localTelephonyManager.getNetworkCountryIso();
    }
    return "";
  }
  
  public static boolean cT(List<a> paramList)
  {
    g.DQ();
    int j = ((Integer)g.DP().Dz().get(270342, Integer.valueOf(0))).intValue();
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        y.d("MicroMsg.MallLogic", "i:" + i + ", lastClickedListMaxId:" + j + ", actId:" + ((a)paramList.get(i)).qzs);
        if (((a)paramList.get(i)).qzs > j) {
          return true;
        }
        i -= 1;
      }
    }
    return false;
  }
  
  public static void cU(List<a> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0))
    {
      y.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
      return;
    }
    int i = ((a)paramList.get(0)).qzs;
    y.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId" + i);
    g.DQ();
    g.DP().Dz().o(270342, Integer.valueOf(i));
    g.DQ();
    g.DP().Dz().mC(true);
  }
  
  public static ArrayList<MallNews> z(JSONArray paramJSONArray)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramJSONArray.length();
      int i = 0;
      Object localObject;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = paramJSONArray.getJSONObject(i);
        MallNews localMallNews = new MallNews(((JSONObject)localObject).optString("activity_jump_funcid"));
        localMallNews.qzH = ((JSONObject)localObject).optString("activity_icon_link");
        localMallNews.qzF = ((JSONObject)localObject).optString("activity_msg_content");
        localMallNews.qzJ = ((JSONObject)localObject).optString("activity_tips");
        localArrayList.add(localMallNews);
        i += 1;
      }
      return localObject;
    }
    catch (JSONException paramJSONArray)
    {
      y.printErrStackTrace("MicroMsg.MallLogic", paramJSONArray, "", new Object[0]);
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.b
 * JD-Core Version:    0.7.0.1
 */