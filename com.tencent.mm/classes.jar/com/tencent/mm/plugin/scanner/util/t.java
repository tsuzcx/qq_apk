package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public static String PjO = "title";
  public static String PjP = "tip";
  public static String PjQ = "buttonTitle";
  private static Boolean PjR = null;
  private static Boolean PjS = null;
  
  public static boolean Ii(int paramInt)
  {
    AppMethodBeat.i(52072);
    b localb = (b)h.ax(b.class);
    if (localb != null)
    {
      boolean bool = localb.Ii(paramInt);
      AppMethodBeat.o(52072);
      return bool;
    }
    AppMethodBeat.o(52072);
    return false;
  }
  
  public static a aVm(String paramString)
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
      locala.wsy = paramString.optString("card_tp_id");
      locala.tNW = paramString.optInt("card_type");
      locala.iaJ = paramString.optString("card_ext");
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
  
  public static ArrayList<a> aVn(String paramString)
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
        locala.wsy = localJSONObject.optString("card_tp_id");
        locala.tNW = localJSONObject.optInt("card_type");
        locala.iaJ = localJSONObject.optString("card_ext");
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
  
  public static boolean aiG(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8) || (paramInt == 4);
  }
  
  public static boolean aiH(int paramInt)
  {
    return paramInt == 12;
  }
  
  public static boolean aiI(int paramInt)
  {
    return paramInt == 3;
  }
  
  public static void bK(Context paramContext, String paramString)
  {
    AppMethodBeat.i(52076);
    k.a(paramContext, paramString, null, false, new DialogInterface.OnClickListener()
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
  
  public static boolean by(ArrayList<a> paramArrayList)
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
      if ((locala != null) && (Ii(locala.tNW)))
      {
        AppMethodBeat.o(52075);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(52075);
    return false;
  }
  
  public static boolean gPB()
  {
    AppMethodBeat.i(314189);
    if (PjS == null) {
      gUq();
    }
    boolean bool = PjS.booleanValue();
    AppMethodBeat.o(314189);
    return bool;
  }
  
  public static boolean gUm()
  {
    AppMethodBeat.i(52078);
    int i = ((a)h.ax(a.class)).aRC().getInt("EnableNewOCRTranslation", 0);
    Object localObject = ((a)h.ax(a.class)).aRC().getValue("PicTranslationSupportUserLanguage");
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
  
  public static void gUn()
  {
    AppMethodBeat.i(314178);
    gUp();
    gUq();
    AppMethodBeat.o(314178);
  }
  
  public static boolean gUo()
  {
    AppMethodBeat.i(52079);
    Log.i("MicroMsg.ScannerUtil", "alvinluo showScanGoodsTab %b", new Object[] { PjR });
    if (PjR == null) {
      gUp();
    }
    boolean bool = PjR.booleanValue();
    AppMethodBeat.o(52079);
    return bool;
  }
  
  private static void gUp()
  {
    AppMethodBeat.i(52080);
    int i = ((c)h.ax(c.class)).a(c.a.zfW, 0);
    if (i != 1) {}
    for (boolean bool = true;; bool = false)
    {
      PjR = Boolean.valueOf(bool);
      Log.i("MicroMsg.ScannerUtil", "alvinluo updateShowScanGoodsTabSwitch clicfg_disable_scan_goods_tab config: %d, show: %b", new Object[] { Integer.valueOf(i), PjR });
      AppMethodBeat.o(52080);
      return;
    }
  }
  
  private static void gUq()
  {
    AppMethodBeat.i(314197);
    int i = ((c)h.ax(c.class)).a(c.a.zgd, 0);
    if ((i != 0) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      PjS = Boolean.valueOf(bool);
      Log.i("MicroMsg.ScannerUtil", "alvinluo updateEnableMultiCode clicfg_scan_code_multi_code_enable config: %d, enable: %b", new Object[] { Integer.valueOf(i), PjS });
      AppMethodBeat.o(314197);
      return;
    }
  }
  
  public static String lI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52077);
    Object localObject2 = i.aRC().getValue("ScanBookWording");
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
    public String iaJ;
    public int tNW;
    public String wsy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.t
 * JD-Core Version:    0.7.0.1
 */