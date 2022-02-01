package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
{
  public static String xmr = "title";
  public static String xms = "tip";
  public static String xmt = "buttonTitle";
  private static Boolean xmu = null;
  private static Boolean xmv = null;
  
  public static boolean Nu(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8) || (paramInt == 4);
  }
  
  public static void aY(Context paramContext, String paramString)
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
  
  public static a arZ(String paramString)
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
      locala.nUr = paramString.optString("card_tp_id");
      locala.lRv = paramString.optInt("card_type");
      locala.dvP = paramString.optString("card_ext");
      AppMethodBeat.o(52073);
      return locala;
    }
    catch (JSONException paramString)
    {
      ac.printErrStackTrace("MicroMsg.ScannerUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(52073);
    }
    return null;
  }
  
  public static ArrayList<a> asa(String paramString)
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
        ac.e("MicroMsg.ScannerUtil", "parseCardListItemArray cardItemListJson is null");
        AppMethodBeat.o(52074);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        a locala = new a();
        locala.nUr = localJSONObject.optString("card_tp_id");
        locala.lRv = localJSONObject.optInt("card_type");
        locala.dvP = localJSONObject.optString("card_ext");
        localArrayList.add(locala);
        i += 1;
      }
      AppMethodBeat.o(52074);
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      ac.printErrStackTrace("MicroMsg.ScannerUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(52074);
    }
    return null;
  }
  
  public static boolean ay(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(52075);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ac.e("MicroMsg.ScannerUtil", "list == null || list.size() == 0");
      AppMethodBeat.o(52075);
      return false;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      a locala = (a)paramArrayList.get(i);
      if ((locala != null) && (zG(locala.lRv)))
      {
        AppMethodBeat.o(52075);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(52075);
    return false;
  }
  
  private static void dBA()
  {
    AppMethodBeat.i(199563);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWK, 0);
    if ((i != 0) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      xmv = Boolean.valueOf(bool);
      ac.i("MicroMsg.ScannerUtil", "alvinluo updateEnableMultiCode clicfg_scan_code_multi_code_enable config: %d, enable: %b", new Object[] { Integer.valueOf(i), xmv });
      AppMethodBeat.o(199563);
      return;
    }
  }
  
  public static boolean dBv()
  {
    AppMethodBeat.i(52078);
    int i = ((a)com.tencent.mm.kernel.g.ab(a.class)).ZY().getInt("EnableNewOCRTranslation", 0);
    Object localObject = ((a)com.tencent.mm.kernel.g.ab(a.class)).ZY().getValue("PicTranslationSupportUserLanguage");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.ScannerUtil", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject, ab.eUO() });
      if ((i != 1) || (bs.isNullOrNil((String)localObject))) {
        break;
      }
      localObject = ((String)localObject).split(";");
      if ((localObject == null) || (!Arrays.asList((Object[])localObject).contains(ab.eUO()))) {
        break;
      }
      AppMethodBeat.o(52078);
      return true;
    }
    AppMethodBeat.o(52078);
    return false;
  }
  
  public static void dBw()
  {
    AppMethodBeat.i(199561);
    dBy();
    dBA();
    AppMethodBeat.o(199561);
  }
  
  public static boolean dBx()
  {
    AppMethodBeat.i(52079);
    ac.i("MicroMsg.ScannerUtil", "alvinluo showScanGoodsTab %b", new Object[] { xmu });
    if (xmu == null) {
      dBy();
    }
    boolean bool = xmu.booleanValue();
    AppMethodBeat.o(52079);
    return bool;
  }
  
  private static void dBy()
  {
    AppMethodBeat.i(52080);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWy, 0);
    if (i != 1) {}
    for (boolean bool = true;; bool = false)
    {
      xmu = Boolean.valueOf(bool);
      ac.i("MicroMsg.ScannerUtil", "alvinluo updateShowScanGoodsTabSwitch clicfg_disable_scan_goods_tab config: %d, show: %b", new Object[] { Integer.valueOf(i), xmu });
      AppMethodBeat.o(52080);
      return;
    }
  }
  
  public static boolean dBz()
  {
    AppMethodBeat.i(199562);
    if (xmv == null) {
      dBA();
    }
    boolean bool = xmv.booleanValue();
    AppMethodBeat.o(199562);
    return bool;
  }
  
  public static String iP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52077);
    Object localObject2 = com.tencent.mm.m.g.ZY().getValue("ScanBookWording");
    ac.i("MicroMsg.ScannerUtil", "scan image dynamic wording: " + bs.nullAsNil((String)localObject2));
    Object localObject1 = paramString2;
    if (!bs.isNullOrNil((String)localObject2))
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
        if (!bs.isNullOrNil(paramString1)) {
          localObject1 = paramString1;
        }
      }
    }
    AppMethodBeat.o(52077);
    return localObject1;
  }
  
  public static boolean zG(int paramInt)
  {
    AppMethodBeat.i(52072);
    com.tencent.mm.plugin.card.c.b localb = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.card.c.b.class);
    if (localb != null)
    {
      boolean bool = localb.zG(paramInt);
      AppMethodBeat.o(52072);
      return bool;
    }
    AppMethodBeat.o(52072);
    return false;
  }
  
  public static final class a
  {
    public String dvP;
    public int lRv;
    public String nUr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.o
 * JD-Core Version:    0.7.0.1
 */