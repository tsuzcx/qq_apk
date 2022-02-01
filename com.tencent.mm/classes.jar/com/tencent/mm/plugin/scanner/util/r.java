package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r
{
  public static String CUD = "title";
  public static String CUE = "tip";
  public static String CUF = "buttonTitle";
  private static Boolean CUG = null;
  private static Boolean CUH = null;
  
  public static boolean Eg(int paramInt)
  {
    AppMethodBeat.i(52072);
    com.tencent.mm.plugin.card.c.b localb = (com.tencent.mm.plugin.card.c.b)g.af(com.tencent.mm.plugin.card.c.b.class);
    if (localb != null)
    {
      boolean bool = localb.Eg(paramInt);
      AppMethodBeat.o(52072);
      return bool;
    }
    AppMethodBeat.o(52072);
    return false;
  }
  
  public static boolean Xd(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8) || (paramInt == 4);
  }
  
  public static boolean Xe(int paramInt)
  {
    return paramInt == 12;
  }
  
  public static boolean Xf(int paramInt)
  {
    return paramInt == 3;
  }
  
  public static a aMU(String paramString)
  {
    AppMethodBeat.i(52073);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(52073);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      a locala = new a();
      locala.pRX = paramString.optString("card_tp_id");
      locala.nHh = paramString.optInt("card_type");
      locala.eaP = paramString.optString("card_ext");
      AppMethodBeat.o(52073);
      return locala;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.ScannerUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(52073);
    }
    return null;
  }
  
  public static ArrayList<a> aMV(String paramString)
  {
    AppMethodBeat.i(52074);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(52074);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        Log.e("MicroMsg.ScannerUtil", "parseCardListItemArray cardItemListJson is null");
        AppMethodBeat.o(52074);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        a locala = new a();
        locala.pRX = localJSONObject.optString("card_tp_id");
        locala.nHh = localJSONObject.optInt("card_type");
        locala.eaP = localJSONObject.optString("card_ext");
        localArrayList.add(locala);
        i += 1;
      }
      AppMethodBeat.o(52074);
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.ScannerUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(52074);
    }
    return null;
  }
  
  public static boolean aO(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(52075);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      Log.e("MicroMsg.ScannerUtil", "list == null || list.size() == 0");
      AppMethodBeat.o(52075);
      return false;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      a locala = (a)paramArrayList.get(i);
      if ((locala != null) && (Eg(locala.nHh)))
      {
        AppMethodBeat.o(52075);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(52075);
    return false;
  }
  
  public static void bv(Context paramContext, String paramString)
  {
    AppMethodBeat.i(52076);
    com.tencent.mm.ui.base.h.a(paramContext, paramString, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(52071);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(52071);
      }
    });
    AppMethodBeat.o(52076);
  }
  
  public static boolean eSd()
  {
    AppMethodBeat.i(52078);
    int i = ((a)g.af(a.class)).aqJ().getInt("EnableNewOCRTranslation", 0);
    Object localObject = ((a)g.af(a.class)).aqJ().getValue("PicTranslationSupportUserLanguage");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ScannerUtil", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject, LocaleUtil.getApplicationLanguage() });
      if ((i != 1) || (Util.isNullOrNil((String)localObject))) {
        break;
      }
      localObject = ((String)localObject).split(";");
      if ((localObject == null) || (!Arrays.asList((Object[])localObject).contains(LocaleUtil.getApplicationLanguage()))) {
        break;
      }
      AppMethodBeat.o(52078);
      return true;
    }
    AppMethodBeat.o(52078);
    return false;
  }
  
  public static void eSe()
  {
    AppMethodBeat.i(240829);
    eSg();
    eSi();
    AppMethodBeat.o(240829);
  }
  
  public static boolean eSf()
  {
    AppMethodBeat.i(52079);
    Log.i("MicroMsg.ScannerUtil", "alvinluo showScanGoodsTab %b", new Object[] { CUG });
    if (CUG == null) {
      eSg();
    }
    boolean bool = CUG.booleanValue();
    AppMethodBeat.o(52079);
    return bool;
  }
  
  private static void eSg()
  {
    AppMethodBeat.i(52080);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sek, 0);
    if (i != 1) {}
    for (boolean bool = true;; bool = false)
    {
      CUG = Boolean.valueOf(bool);
      Log.i("MicroMsg.ScannerUtil", "alvinluo updateShowScanGoodsTabSwitch clicfg_disable_scan_goods_tab config: %d, show: %b", new Object[] { Integer.valueOf(i), CUG });
      AppMethodBeat.o(52080);
      return;
    }
  }
  
  public static boolean eSh()
  {
    AppMethodBeat.i(240830);
    if (CUH == null) {
      eSi();
    }
    boolean bool = CUH.booleanValue();
    AppMethodBeat.o(240830);
    return bool;
  }
  
  private static void eSi()
  {
    AppMethodBeat.i(240831);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sez, 0);
    if ((i != 0) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      CUH = Boolean.valueOf(bool);
      Log.i("MicroMsg.ScannerUtil", "alvinluo updateEnableMultiCode clicfg_scan_code_multi_code_enable config: %d, enable: %b", new Object[] { Integer.valueOf(i), CUH });
      AppMethodBeat.o(240831);
      return;
    }
  }
  
  public static String jR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52077);
    Object localObject2 = com.tencent.mm.n.h.aqJ().getValue("ScanBookWording");
    Log.i("MicroMsg.ScannerUtil", "scan image dynamic wording: " + Util.nullAsNil((String)localObject2));
    Object localObject1 = paramString2;
    if (!Util.isNullOrNil((String)localObject2))
    {
      localObject2 = ((String)localObject2).split("&");
      localObject1 = paramString2;
      if (localObject2 != null)
      {
        localObject1 = new HashMap();
        int i = 0;
        while (i < localObject2.length)
        {
          String[] arrayOfString = localObject2[i].split("=");
          if (arrayOfString.length == 2) {
            ((Map)localObject1).put(arrayOfString[0], arrayOfString[1]);
          }
          i += 1;
        }
        paramString1 = (String)((Map)localObject1).get(paramString1);
        localObject1 = paramString2;
        if (!Util.isNullOrNil(paramString1)) {
          localObject1 = paramString1;
        }
      }
    }
    AppMethodBeat.o(52077);
    return localObject1;
  }
  
  public static final class a
  {
    public String eaP;
    public int nHh;
    public String pRX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.r
 * JD-Core Version:    0.7.0.1
 */