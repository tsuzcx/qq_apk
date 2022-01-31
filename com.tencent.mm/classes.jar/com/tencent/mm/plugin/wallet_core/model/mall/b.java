package com.tencent.mm.plugin.wallet_core.model.mall;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.x.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static int umk = -256;
  public static int uml = 621019136;
  public static int umm = 637534720;
  
  public static ArrayList<MallNews> F(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(47007);
    try
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramJSONArray.length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        MallNews localMallNews = new MallNews(localJSONObject.optString("activity_jump_funcid"));
        localMallNews.umr = localJSONObject.optString("activity_icon_link");
        localMallNews.ump = localJSONObject.optString("activity_msg_content");
        localMallNews.umt = localJSONObject.optString("activity_tips");
        localArrayList.add(localMallNews);
        i += 1;
      }
      AppMethodBeat.o(47007);
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      ab.printErrStackTrace("MicroMsg.MallLogic", paramJSONArray, "", new Object[0]);
      AppMethodBeat.o(47007);
    }
    return null;
  }
  
  public static ArrayList<a> G(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(47008);
    try
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramJSONArray.length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        a locala = new a();
        locala.umc = localJSONObject.optInt("banner_id");
        locala.umd = localJSONObject.optString("banner_title");
        locala.ume = localJSONObject.optString("banner_link");
        localArrayList.add(locala);
        i += 1;
      }
      AppMethodBeat.o(47008);
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      ab.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + paramJSONArray.getMessage());
      AppMethodBeat.o(47008);
    }
    return null;
  }
  
  public static SparseArray<String> H(JSONArray paramJSONArray)
  {
    int i = 0;
    AppMethodBeat.i(47009);
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
      AppMethodBeat.o(47009);
      return localSparseArray;
    }
    catch (JSONException paramJSONArray)
    {
      ab.w("MicroMsg.MallLogic", "func[parseBannerActList], exp:" + paramJSONArray.getMessage());
      AppMethodBeat.o(47009);
    }
    return null;
  }
  
  public static ArrayList<MallFunction> I(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(47012);
    try
    {
      ArrayList localArrayList = new ArrayList();
      int k = paramJSONArray.length();
      ab.d("MicroMsg.MallLogic", "functions.jsonArray.length : ".concat(String.valueOf(k)));
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
        ((MallFunction)localObject1).pUM = ((JSONObject)localObject2).getString("func_id");
        ((MallFunction)localObject1).cJt = ((JSONObject)localObject2).getString("func_name");
        ((MallFunction)localObject1).umf = ((JSONObject)localObject2).optString("func_icon_url");
        ((MallFunction)localObject1).oyK = ((JSONObject)localObject2).optString("hd_icon_url");
        ((MallFunction)localObject1).oyL = ((JSONObject)localObject2).optString("func_foregroud_icon_url");
        ((MallFunction)localObject1).cMO = ((JSONObject)localObject2).optString("native_url");
        ((MallFunction)localObject1).nDe = ((JSONObject)localObject2).optString("h5_url");
        ((MallFunction)localObject1).type = ((JSONObject)localObject2).optInt("property_type", 0);
        ((MallFunction)localObject1).umi = ((JSONObject)localObject2).optString("third_party_disclaimer");
        ((MallFunction)localObject1).umj = ((JSONObject)localObject2).optInt("download_restrict", 0);
        Object localObject3 = ((JSONObject)localObject2).optJSONArray("remark_name_list");
        if (localObject3 != null)
        {
          ((MallFunction)localObject1).umg = new ArrayList();
          int m = ((JSONArray)localObject3).length();
          int j = 0;
          while (j < m)
          {
            ((MallFunction)localObject1).umg.add(((JSONArray)localObject3).getString(j));
            j += 1;
          }
        }
        localObject3 = ((JSONObject)localObject2).optJSONArray("activity_info_list");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() != 0))
        {
          localObject2 = ((MallFunction)localObject1).pUM;
          localObject3 = ((JSONArray)localObject3).getJSONObject(0);
          localObject2 = new MallNews((String)localObject2);
          ((MallNews)localObject2).sWB = ((JSONObject)localObject3).optString("activity_id");
          ((MallNews)localObject2).crs = ((JSONObject)localObject3).optString("activity_ticket");
          ((MallNews)localObject2).ump = ((JSONObject)localObject3).optString("activity_msg_content");
          ((MallNews)localObject2).umq = ((JSONObject)localObject3).optString("activity_link");
          ((MallNews)localObject2).umr = ((JSONObject)localObject3).optString("activity_icon_link");
          ((MallNews)localObject2).ums = ((JSONObject)localObject3).optInt("activity_expired_time");
          ((MallNews)localObject2).umt = ((JSONObject)localObject3).optString("activity_tips");
          ((MallNews)localObject2).uki = ((JSONObject)localObject3).optInt("activity_type");
          ((MallNews)localObject2).umw = ((JSONObject)localObject3).optString("activity_url");
          ((MallNews)localObject2).umu = ((JSONObject)localObject3).optInt("is_msg_reserved");
          ((MallFunction)localObject1).umh = ((MallNews)localObject2);
        }
        localArrayList.add(localObject1);
        i += 1;
      }
      return localObject1;
    }
    catch (JSONException paramJSONArray)
    {
      ab.printErrStackTrace("MicroMsg.MallLogic", paramJSONArray, "", new Object[0]);
      localObject1 = null;
      AppMethodBeat.o(47012);
    }
  }
  
  public static void IB(int paramInt)
  {
    AppMethodBeat.i(47014);
    if ((d.whH & umk) == paramInt)
    {
      g.RM();
      i = ((Integer)g.RL().Ru().get(270343, Integer.valueOf(0))).intValue();
      if (paramInt != i) {
        ab.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + paramInt + ", clickedV=" + i);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (r.Zw()))
      {
        ab.d("MicroMsg.MallLogic", "Show mall entry redot");
        c.PJ().x(262156, true);
        g.RM();
        g.RL().Ru().set(270343, Integer.valueOf(paramInt));
        g.RM();
        g.RL().Ru().set(ac.a.yHf, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(47014);
      return;
    }
  }
  
  public static String cUW()
  {
    AppMethodBeat.i(47013);
    Object localObject = (TelephonyManager)ah.getContext().getSystemService("phone");
    if (localObject != null) {}
    for (localObject = ((TelephonyManager)localObject).getNetworkCountryIso();; localObject = "")
    {
      AppMethodBeat.o(47013);
      return localObject;
    }
  }
  
  public static boolean dW(List<a> paramList)
  {
    AppMethodBeat.i(47010);
    g.RM();
    int j = ((Integer)g.RL().Ru().get(270342, Integer.valueOf(0))).intValue();
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ab.d("MicroMsg.MallLogic", "i:" + i + ", lastClickedListMaxId:" + j + ", actId:" + ((a)paramList.get(i)).umc);
        if (((a)paramList.get(i)).umc > j)
        {
          AppMethodBeat.o(47010);
          return true;
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(47010);
    return false;
  }
  
  public static void dX(List<a> paramList)
  {
    AppMethodBeat.i(47011);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ab.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
      AppMethodBeat.o(47011);
      return;
    }
    int i = ((a)paramList.get(0)).umc;
    ab.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId".concat(String.valueOf(i)));
    g.RM();
    g.RL().Ru().set(270342, Integer.valueOf(i));
    g.RM();
    g.RL().Ru().dww();
    AppMethodBeat.o(47011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.b
 * JD-Core Version:    0.7.0.1
 */