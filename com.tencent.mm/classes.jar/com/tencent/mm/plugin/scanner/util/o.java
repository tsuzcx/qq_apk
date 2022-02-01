package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
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
  public static String yQs = "title";
  public static String yQt = "tip";
  public static String yQu = "buttonTitle";
  private static Boolean yQv = null;
  private static Boolean yQw = null;
  
  public static boolean AB(int paramInt)
  {
    AppMethodBeat.i(52072);
    com.tencent.mm.plugin.card.c.b localb = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.card.c.b.class);
    if (localb != null)
    {
      boolean bool = localb.AB(paramInt);
      AppMethodBeat.o(52072);
      return bool;
    }
    AppMethodBeat.o(52072);
    return false;
  }
  
  public static boolean PD(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8) || (paramInt == 4);
  }
  
  public static boolean ax(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(52075);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ae.e("MicroMsg.ScannerUtil", "list == null || list.size() == 0");
      AppMethodBeat.o(52075);
      return false;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      a locala = (a)paramArrayList.get(i);
      if ((locala != null) && (AB(locala.mwj)))
      {
        AppMethodBeat.o(52075);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(52075);
    return false;
  }
  
  public static a ayp(String paramString)
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
      locala.oEo = paramString.optString("card_tp_id");
      locala.mwj = paramString.optInt("card_type");
      locala.dJc = paramString.optString("card_ext");
      AppMethodBeat.o(52073);
      return locala;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.ScannerUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(52073);
    }
    return null;
  }
  
  public static ArrayList<a> ayq(String paramString)
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
        ae.e("MicroMsg.ScannerUtil", "parseCardListItemArray cardItemListJson is null");
        AppMethodBeat.o(52074);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        a locala = new a();
        locala.oEo = localJSONObject.optString("card_tp_id");
        locala.mwj = localJSONObject.optInt("card_type");
        locala.dJc = localJSONObject.optString("card_ext");
        localArrayList.add(locala);
        i += 1;
      }
      AppMethodBeat.o(52074);
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.ScannerUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(52074);
    }
    return null;
  }
  
  public static void bd(Context paramContext, String paramString)
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
  
  public static boolean dQl()
  {
    AppMethodBeat.i(52078);
    int i = ((a)com.tencent.mm.kernel.g.ab(a.class)).acL().getInt("EnableNewOCRTranslation", 0);
    Object localObject = ((a)com.tencent.mm.kernel.g.ab(a.class)).acL().getValue("PicTranslationSupportUserLanguage");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.ScannerUtil", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject, ad.fom() });
      if ((i != 1) || (bu.isNullOrNil((String)localObject))) {
        break;
      }
      localObject = ((String)localObject).split(";");
      if ((localObject == null) || (!Arrays.asList((Object[])localObject).contains(ad.fom()))) {
        break;
      }
      AppMethodBeat.o(52078);
      return true;
    }
    AppMethodBeat.o(52078);
    return false;
  }
  
  public static void dQm()
  {
    AppMethodBeat.i(189519);
    dQo();
    dQq();
    AppMethodBeat.o(189519);
  }
  
  public static boolean dQn()
  {
    AppMethodBeat.i(52079);
    ae.i("MicroMsg.ScannerUtil", "alvinluo showScanGoodsTab %b", new Object[] { yQv });
    if (yQv == null) {
      dQo();
    }
    boolean bool = yQv.booleanValue();
    AppMethodBeat.o(52079);
    return bool;
  }
  
  private static void dQo()
  {
    AppMethodBeat.i(52080);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIP, 0);
    if (i != 1) {}
    for (boolean bool = true;; bool = false)
    {
      yQv = Boolean.valueOf(bool);
      ae.i("MicroMsg.ScannerUtil", "alvinluo updateShowScanGoodsTabSwitch clicfg_disable_scan_goods_tab config: %d, show: %b", new Object[] { Integer.valueOf(i), yQv });
      AppMethodBeat.o(52080);
      return;
    }
  }
  
  public static boolean dQp()
  {
    AppMethodBeat.i(189520);
    if (yQw == null) {
      dQq();
    }
    boolean bool = yQw.booleanValue();
    AppMethodBeat.o(189520);
    return bool;
  }
  
  private static void dQq()
  {
    AppMethodBeat.i(189521);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJb, 0);
    if ((i != 0) || (j.DEBUG) || (j.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      yQw = Boolean.valueOf(bool);
      ae.i("MicroMsg.ScannerUtil", "alvinluo updateEnableMultiCode clicfg_scan_code_multi_code_enable config: %d, enable: %b", new Object[] { Integer.valueOf(i), yQw });
      AppMethodBeat.o(189521);
      return;
    }
  }
  
  public static String jg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52077);
    Object localObject2 = com.tencent.mm.n.g.acL().getValue("ScanBookWording");
    ae.i("MicroMsg.ScannerUtil", "scan image dynamic wording: " + bu.nullAsNil((String)localObject2));
    Object localObject1 = paramString2;
    if (!bu.isNullOrNil((String)localObject2))
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
        if (!bu.isNullOrNil(paramString1)) {
          localObject1 = paramString1;
        }
      }
    }
    AppMethodBeat.o(52077);
    return localObject1;
  }
  
  public static final class a
  {
    public String dJc;
    public int mwj;
    public String oEo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.o
 * JD-Core Version:    0.7.0.1
 */