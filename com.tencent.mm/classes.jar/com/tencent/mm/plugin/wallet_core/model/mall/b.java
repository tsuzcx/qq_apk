package com.tencent.mm.plugin.wallet_core.model.mall;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static int AiF = -256;
  public static int AiG = 621019136;
  public static int AiH = 637534720;
  
  public static ArrayList<MallNews> H(JSONArray paramJSONArray)
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
        localMallNews.AiM = localJSONObject.optString("activity_icon_link");
        localMallNews.AiK = localJSONObject.optString("activity_msg_content");
        localMallNews.AiO = localJSONObject.optString("activity_tips");
        localArrayList.add(localMallNews);
        i += 1;
      }
      AppMethodBeat.o(70539);
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      ad.printErrStackTrace("MicroMsg.MallLogic", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(70539);
    }
    return null;
  }
  
  public static ArrayList<a> I(JSONArray paramJSONArray)
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
        locala.Aix = localJSONObject.optInt("banner_id");
        locala.Aiy = localJSONObject.optString("banner_title");
        locala.Aiz = localJSONObject.optString("banner_link");
        localArrayList.add(locala);
        i += 1;
      }
      AppMethodBeat.o(70540);
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      ad.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + paramJSONArray.getMessage());
      AppMethodBeat.o(70540);
    }
    return null;
  }
  
  public static SparseArray<String> J(JSONArray paramJSONArray)
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
      ad.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + paramJSONArray.getMessage());
      AppMethodBeat.o(70541);
    }
    return null;
  }
  
  public static ArrayList<MallFunction> K(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(70544);
    try
    {
      ArrayList localArrayList = new ArrayList();
      int k = paramJSONArray.length();
      ad.d("MicroMsg.MallLogic", "functions.jsonArray.length : ".concat(String.valueOf(k)));
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
        ((MallFunction)localObject1).uWF = ((JSONObject)localObject2).getString("func_id");
        ((MallFunction)localObject1).dAn = ((JSONObject)localObject2).getString("func_name");
        ((MallFunction)localObject1).AiA = ((JSONObject)localObject2).optString("func_icon_url");
        ((MallFunction)localObject1).ttl = ((JSONObject)localObject2).optString("hd_icon_url");
        ((MallFunction)localObject1).ttm = ((JSONObject)localObject2).optString("func_foregroud_icon_url");
        ((MallFunction)localObject1).dDM = ((JSONObject)localObject2).optString("native_url");
        ((MallFunction)localObject1).smD = ((JSONObject)localObject2).optString("h5_url");
        ((MallFunction)localObject1).type = ((JSONObject)localObject2).optInt("property_type", 0);
        ((MallFunction)localObject1).AiD = ((JSONObject)localObject2).optString("third_party_disclaimer");
        ((MallFunction)localObject1).AiE = ((JSONObject)localObject2).optInt("download_restrict", 0);
        Object localObject3 = ((JSONObject)localObject2).optJSONArray("remark_name_list");
        if (localObject3 != null)
        {
          ((MallFunction)localObject1).AiB = new ArrayList();
          int m = ((JSONArray)localObject3).length();
          int j = 0;
          while (j < m)
          {
            ((MallFunction)localObject1).AiB.add(((JSONArray)localObject3).getString(j));
            j += 1;
          }
        }
        localObject3 = ((JSONObject)localObject2).optJSONArray("activity_info_list");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() != 0))
        {
          localObject2 = ((MallFunction)localObject1).uWF;
          localObject3 = ((JSONArray)localObject3).getJSONObject(0);
          localObject2 = new MallNews((String)localObject2);
          ((MallNews)localObject2).yCo = ((JSONObject)localObject3).optString("activity_id");
          ((MallNews)localObject2).dgo = ((JSONObject)localObject3).optString("activity_ticket");
          ((MallNews)localObject2).AiK = ((JSONObject)localObject3).optString("activity_msg_content");
          ((MallNews)localObject2).AiL = ((JSONObject)localObject3).optString("activity_link");
          ((MallNews)localObject2).AiM = ((JSONObject)localObject3).optString("activity_icon_link");
          ((MallNews)localObject2).AiN = ((JSONObject)localObject3).optInt("activity_expired_time");
          ((MallNews)localObject2).AiO = ((JSONObject)localObject3).optString("activity_tips");
          ((MallNews)localObject2).Agu = ((JSONObject)localObject3).optInt("activity_type");
          ((MallNews)localObject2).AiR = ((JSONObject)localObject3).optString("activity_url");
          ((MallNews)localObject2).AiP = ((JSONObject)localObject3).optInt("is_msg_reserved");
          ((MallFunction)localObject1).AiC = ((MallNews)localObject2);
        }
        localArrayList.add(localObject1);
        i += 1;
      }
      return localObject1;
    }
    catch (JSONException paramJSONArray)
    {
      ad.printErrStackTrace("MicroMsg.MallLogic", paramJSONArray, "", new Object[0]);
      localObject1 = null;
      AppMethodBeat.o(70544);
    }
  }
  
  public static void RA(int paramInt)
  {
    AppMethodBeat.i(70546);
    if ((d.CpK & AiF) == paramInt)
    {
      g.afC();
      i = ((Integer)g.afB().afk().get(270343, Integer.valueOf(0))).intValue();
      if (paramInt != i) {
        ad.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + paramInt + ", clickedV=" + i);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (u.aqQ()))
      {
        ad.d("MicroMsg.MallLogic", "Show mall entry redot");
        c.adr().w(262156, true);
        g.afC();
        g.afB().afk().set(270343, Integer.valueOf(paramInt));
        g.afC();
        g.afB().afk().set(ae.a.FpQ, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(70546);
      return;
    }
  }
  
  public static String edr()
  {
    AppMethodBeat.i(70545);
    Object localObject = (TelephonyManager)aj.getContext().getSystemService("phone");
    if (localObject != null) {}
    for (localObject = ((TelephonyManager)localObject).getNetworkCountryIso();; localObject = "")
    {
      AppMethodBeat.o(70545);
      return localObject;
    }
  }
  
  public static boolean gm(List<a> paramList)
  {
    AppMethodBeat.i(70542);
    g.afC();
    int j = ((Integer)g.afB().afk().get(270342, Integer.valueOf(0))).intValue();
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ad.d("MicroMsg.MallLogic", "i:" + i + ", lastClickedListMaxId:" + j + ", actId:" + ((a)paramList.get(i)).Aix);
        if (((a)paramList.get(i)).Aix > j)
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
  
  public static void gn(List<a> paramList)
  {
    AppMethodBeat.i(70543);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ad.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
      AppMethodBeat.o(70543);
      return;
    }
    int i = ((a)paramList.get(0)).Aix;
    ad.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId".concat(String.valueOf(i)));
    g.afC();
    g.afB().afk().set(270342, Integer.valueOf(i));
    g.afC();
    g.afB().afk().eKy();
    AppMethodBeat.o(70543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.b
 * JD-Core Version:    0.7.0.1
 */