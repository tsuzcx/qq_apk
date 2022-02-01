package com.tencent.mm.plugin.wallet_core.model.mall;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.protocal.protobuf.atx;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.z.c;
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
  public static int Dbs = -256;
  public static int Dbt = 621019136;
  public static int Dbu = 637534720;
  
  public static ArrayList<MallNews> I(JSONArray paramJSONArray)
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
        localMallNews.Dbz = localJSONObject.optString("activity_icon_link");
        localMallNews.Dbx = localJSONObject.optString("activity_msg_content");
        localMallNews.DbB = localJSONObject.optString("activity_tips");
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
  
  public static ArrayList<a> J(JSONArray paramJSONArray)
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
        locala.Dbk = localJSONObject.optInt("banner_id");
        locala.Dbl = localJSONObject.optString("banner_title");
        locala.Dbm = localJSONObject.optString("banner_link");
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
  
  public static SparseArray<String> K(JSONArray paramJSONArray)
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
  
  public static ArrayList<MallFunction> L(JSONArray paramJSONArray)
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
        ((MallFunction)localObject1).jDb = ((JSONObject)localObject2).getString("func_id");
        ((MallFunction)localObject1).dKm = ((JSONObject)localObject2).getString("func_name");
        ((MallFunction)localObject1).Dbn = ((JSONObject)localObject2).optString("func_icon_url");
        ((MallFunction)localObject1).vEl = ((JSONObject)localObject2).optString("hd_icon_url");
        ((MallFunction)localObject1).vEm = ((JSONObject)localObject2).optString("func_foregroud_icon_url");
        ((MallFunction)localObject1).dNL = ((JSONObject)localObject2).optString("native_url");
        ((MallFunction)localObject1).usV = ((JSONObject)localObject2).optString("h5_url");
        ((MallFunction)localObject1).type = ((JSONObject)localObject2).optInt("property_type", 0);
        ((MallFunction)localObject1).Dbq = ((JSONObject)localObject2).optString("third_party_disclaimer");
        ((MallFunction)localObject1).Dbr = ((JSONObject)localObject2).optInt("download_restrict", 0);
        Object localObject3 = ((JSONObject)localObject2).optJSONArray("remark_name_list");
        if (localObject3 != null)
        {
          ((MallFunction)localObject1).Dbo = new ArrayList();
          int m = ((JSONArray)localObject3).length();
          int j = 0;
          while (j < m)
          {
            ((MallFunction)localObject1).Dbo.add(((JSONArray)localObject3).getString(j));
            j += 1;
          }
        }
        localObject3 = ((JSONObject)localObject2).optJSONArray("activity_info_list");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() != 0))
        {
          localObject2 = ((MallFunction)localObject1).jDb;
          localObject3 = ((JSONArray)localObject3).getJSONObject(0);
          localObject2 = new MallNews((String)localObject2);
          ((MallNews)localObject2).Bhd = ((JSONObject)localObject3).optString("activity_id");
          ((MallNews)localObject2).dpf = ((JSONObject)localObject3).optString("activity_ticket");
          ((MallNews)localObject2).Dbx = ((JSONObject)localObject3).optString("activity_msg_content");
          ((MallNews)localObject2).Dby = ((JSONObject)localObject3).optString("activity_link");
          ((MallNews)localObject2).Dbz = ((JSONObject)localObject3).optString("activity_icon_link");
          ((MallNews)localObject2).DbA = ((JSONObject)localObject3).optInt("activity_expired_time");
          ((MallNews)localObject2).DbB = ((JSONObject)localObject3).optString("activity_tips");
          ((MallNews)localObject2).CZh = ((JSONObject)localObject3).optInt("activity_type");
          ((MallNews)localObject2).DbE = ((JSONObject)localObject3).optString("activity_url");
          ((MallNews)localObject2).DbC = ((JSONObject)localObject3).optInt("is_msg_reserved");
          ((MallFunction)localObject1).Dbp = ((MallNews)localObject2);
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
  
  public static void VB(int paramInt)
  {
    AppMethodBeat.i(70546);
    if ((d.Fnj & Dbs) == paramInt)
    {
      g.ajD();
      i = ((Integer)g.ajC().ajl().get(270343, Integer.valueOf(0))).intValue();
      if (paramInt != i) {
        ad.d("MicroMsg.MallLogic", "Mall reddot show, targetV=" + paramInt + ", clickedV=" + i);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (u.aAw()))
      {
        ad.d("MicroMsg.MallLogic", "Show mall entry redot");
        c.aht().w(262156, true);
        g.ajD();
        g.ajC().ajl().set(270343, Integer.valueOf(paramInt));
        g.ajD();
        g.ajC().ajl().set(al.a.IzX, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(70546);
      return;
    }
  }
  
  public static void a(avw paramavw)
  {
    AppMethodBeat.i(199320);
    try
    {
      paramavw = new String(paramavw.toByteArray(), "ISO-8859-1");
      ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(al.a.IJC, paramavw);
      ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().fqc();
      AppMethodBeat.o(199320);
      return;
    }
    catch (IOException paramavw)
    {
      ad.e("MicroMsg.MallLogic", "save config exp, " + paramavw.getLocalizedMessage());
      AppMethodBeat.o(199320);
    }
  }
  
  public static String eGM()
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
  
  private static avw eGN()
  {
    AppMethodBeat.i(199321);
    avw localavw = new avw();
    String str = (String)((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(al.a.IJC, null);
    if (bt.isNullOrNil(str)) {
      ad.i("MicroMsg.MallLogic", "getMallNewFunctionListRespone is null");
    }
    for (;;)
    {
      AppMethodBeat.o(199321);
      return localavw;
      try
      {
        localavw.parseFrom(str.getBytes("ISO-8859-1"));
        ad.i("MicroMsg.MallLogic", "getMallNewFunctionListRespone success");
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.MallLogic", "getMallNewFunctionListRespone fail, " + localException.getLocalizedMessage());
      }
    }
  }
  
  public static SparseArray<String> eGO()
  {
    AppMethodBeat.i(199322);
    SparseArray localSparseArray = new SparseArray();
    Object localObject1 = eGN();
    if (((avw)localObject1).GroupList != null)
    {
      localObject1 = ((avw)localObject1).GroupList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (atx)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((atx)localObject2).GrX;
          localSparseArray.put(((ebg)localObject2).GrW, ((ebg)localObject2).GrE);
        }
      }
    }
    AppMethodBeat.o(199322);
    return localSparseArray;
  }
  
  public static SparseArray<Integer> eGP()
  {
    AppMethodBeat.i(199323);
    SparseArray localSparseArray = new SparseArray();
    avw localavw = eGN();
    if (localavw.GroupList != null)
    {
      int i = 0;
      while (i < localavw.GroupList.size())
      {
        atx localatx = (atx)localavw.GroupList.get(i);
        if (localatx != null) {
          localSparseArray.put(localatx.GrX.GrW, Integer.valueOf(i + 1));
        }
        i += 1;
      }
    }
    AppMethodBeat.o(199323);
    return localSparseArray;
  }
  
  public static ArrayList<atw> eGQ()
  {
    AppMethodBeat.i(199324);
    ArrayList localArrayList = new ArrayList();
    Object localObject = eGN();
    if (((avw)localObject).GroupList != null)
    {
      localObject = ((avw)localObject).GroupList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        atx localatx = (atx)((Iterator)localObject).next();
        if (localatx != null)
        {
          Iterator localIterator = localatx.GrY.iterator();
          while (localIterator.hasNext())
          {
            atw localatw = (atw)localIterator.next();
            if (localatw != null)
            {
              localatw.GrW = localatx.GrX.GrW;
              localArrayList.add(localatw);
            }
          }
        }
      }
    }
    AppMethodBeat.o(199324);
    return localArrayList;
  }
  
  public static SparseArray<ArrayList<Integer>> eGR()
  {
    AppMethodBeat.i(199325);
    SparseArray localSparseArray = new SparseArray();
    Object localObject = eGN();
    if (((avw)localObject).GroupList != null)
    {
      localObject = ((avw)localObject).GroupList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        atx localatx = (atx)((Iterator)localObject).next();
        if (localatx != null)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = localatx.GrY.iterator();
          while (localIterator.hasNext())
          {
            atw localatw = (atw)localIterator.next();
            if (localatw != null) {
              localArrayList.add(Integer.valueOf(localatw.GrP.HNO));
            }
          }
          localSparseArray.put(localatx.GrX.GrW, localArrayList);
        }
      }
    }
    AppMethodBeat.o(199325);
    return localSparseArray;
  }
  
  public static String eGS()
  {
    AppMethodBeat.i(199326);
    String str = eGN().GuD;
    AppMethodBeat.o(199326);
    return str;
  }
  
  public static boolean gK(List<a> paramList)
  {
    AppMethodBeat.i(70542);
    g.ajD();
    int j = ((Integer)g.ajC().ajl().get(270342, Integer.valueOf(0))).intValue();
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ad.d("MicroMsg.MallLogic", "i:" + i + ", lastClickedListMaxId:" + j + ", actId:" + ((a)paramList.get(i)).Dbk);
        if (((a)paramList.get(i)).Dbk > j)
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
  
  public static void gL(List<a> paramList)
  {
    AppMethodBeat.i(70543);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ad.w("MicroMsg.MallLogic", "func[setBannerRedDotClick] actList null or empty");
      AppMethodBeat.o(70543);
      return;
    }
    int i = ((a)paramList.get(0)).Dbk;
    ad.d("MicroMsg.MallLogic", "func[setBannerRedDotClick], lastClickedListMaxId".concat(String.valueOf(i)));
    g.ajD();
    g.ajC().ajl().set(270342, Integer.valueOf(i));
    g.ajD();
    g.ajC().ajl().fqc();
    AppMethodBeat.o(70543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.b
 * JD-Core Version:    0.7.0.1
 */