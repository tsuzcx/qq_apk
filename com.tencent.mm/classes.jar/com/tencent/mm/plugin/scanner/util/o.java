package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.base.h;
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
  public static String yAs = "title";
  public static String yAt = "tip";
  public static String yAu = "buttonTitle";
  private static Boolean yAv = null;
  private static Boolean yAw = null;
  
  public static boolean Ap(int paramInt)
  {
    AppMethodBeat.i(52072);
    com.tencent.mm.plugin.card.c.b localb = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.card.c.b.class);
    if (localb != null)
    {
      boolean bool = localb.Ap(paramInt);
      AppMethodBeat.o(52072);
      return bool;
    }
    AppMethodBeat.o(52072);
    return false;
  }
  
  public static boolean OW(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8) || (paramInt == 4);
  }
  
  public static boolean aw(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(52075);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ad.e("MicroMsg.ScannerUtil", "list == null || list.size() == 0");
      AppMethodBeat.o(52075);
      return false;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      a locala = (a)paramArrayList.get(i);
      if ((locala != null) && (Ap(locala.mrl)))
      {
        AppMethodBeat.o(52075);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(52075);
    return false;
  }
  
  public static a axa(String paramString)
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
      locala.oxM = paramString.optString("card_tp_id");
      locala.mrl = paramString.optInt("card_type");
      locala.dHY = paramString.optString("card_ext");
      AppMethodBeat.o(52073);
      return locala;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.ScannerUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(52073);
    }
    return null;
  }
  
  public static ArrayList<a> axb(String paramString)
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
        ad.e("MicroMsg.ScannerUtil", "parseCardListItemArray cardItemListJson is null");
        AppMethodBeat.o(52074);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        a locala = new a();
        locala.oxM = localJSONObject.optString("card_tp_id");
        locala.mrl = localJSONObject.optInt("card_type");
        locala.dHY = localJSONObject.optString("card_ext");
        localArrayList.add(locala);
        i += 1;
      }
      AppMethodBeat.o(52074);
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.ScannerUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(52074);
    }
    return null;
  }
  
  public static void bb(Context paramContext, String paramString)
  {
    AppMethodBeat.i(52076);
    h.a(paramContext, paramString, null, false, new DialogInterface.OnClickListener()
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
  
  public static boolean dMS()
  {
    AppMethodBeat.i(52078);
    int i = ((a)com.tencent.mm.kernel.g.ab(a.class)).acA().getInt("EnableNewOCRTranslation", 0);
    Object localObject = ((a)com.tencent.mm.kernel.g.ab(a.class)).acA().getValue("PicTranslationSupportUserLanguage");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ScannerUtil", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject, ac.fks() });
      if ((i != 1) || (bt.isNullOrNil((String)localObject))) {
        break;
      }
      localObject = ((String)localObject).split(";");
      if ((localObject == null) || (!Arrays.asList((Object[])localObject).contains(ac.fks()))) {
        break;
      }
      AppMethodBeat.o(52078);
      return true;
    }
    AppMethodBeat.o(52078);
    return false;
  }
  
  public static void dMT()
  {
    AppMethodBeat.i(186237);
    dMV();
    dMX();
    AppMethodBeat.o(186237);
  }
  
  public static boolean dMU()
  {
    AppMethodBeat.i(52079);
    ad.i("MicroMsg.ScannerUtil", "alvinluo showScanGoodsTab %b", new Object[] { yAv });
    if (yAv == null) {
      dMV();
    }
    boolean bool = yAv.booleanValue();
    AppMethodBeat.o(52079);
    return bool;
  }
  
  private static void dMV()
  {
    AppMethodBeat.i(52080);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBw, 0);
    if (i != 1) {}
    for (boolean bool = true;; bool = false)
    {
      yAv = Boolean.valueOf(bool);
      ad.i("MicroMsg.ScannerUtil", "alvinluo updateShowScanGoodsTabSwitch clicfg_disable_scan_goods_tab config: %d, show: %b", new Object[] { Integer.valueOf(i), yAv });
      AppMethodBeat.o(52080);
      return;
    }
  }
  
  public static boolean dMW()
  {
    AppMethodBeat.i(186238);
    if (yAw == null) {
      dMX();
    }
    boolean bool = yAw.booleanValue();
    AppMethodBeat.o(186238);
    return bool;
  }
  
  private static void dMX()
  {
    AppMethodBeat.i(186239);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBI, 0);
    if ((i != 0) || (i.DEBUG) || (i.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      yAw = Boolean.valueOf(bool);
      ad.i("MicroMsg.ScannerUtil", "alvinluo updateEnableMultiCode clicfg_scan_code_multi_code_enable config: %d, enable: %b", new Object[] { Integer.valueOf(i), yAw });
      AppMethodBeat.o(186239);
      return;
    }
  }
  
  public static String ja(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52077);
    Object localObject2 = com.tencent.mm.n.g.acA().getValue("ScanBookWording");
    ad.i("MicroMsg.ScannerUtil", "scan image dynamic wording: " + bt.nullAsNil((String)localObject2));
    Object localObject1 = paramString2;
    if (!bt.isNullOrNil((String)localObject2))
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
        if (!bt.isNullOrNil(paramString1)) {
          localObject1 = paramString1;
        }
      }
    }
    AppMethodBeat.o(52077);
    return localObject1;
  }
  
  public static final class a
  {
    public String dHY;
    public int mrl;
    public String oxM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.o
 * JD-Core Version:    0.7.0.1
 */