package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.plugin.card.c.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
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
  public static String nPW = "title";
  public static String nPX = "tip";
  public static String nPY = "buttonTitle";
  
  public static int Mi(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 0;
      if (("EAN-13".equals(paramString)) || ("EAN_13".equals(paramString))) {
        return 4;
      }
      if (("EAN-8".equals(paramString)) || ("EAN_8".equals(paramString))) {
        return 3;
      }
      if ("EAN-2".equals(paramString)) {
        return 1;
      }
      if ("EAN-5".equals(paramString)) {
        return 2;
      }
      if (("UPC-A".equals(paramString)) || ("UPC_A".equals(paramString))) {
        return 5;
      }
      if (("UPC-E".equals(paramString)) || ("UPC_E".equals(paramString))) {
        return 6;
      }
      if (("CODE-39".equals(paramString)) || ("CODE_39".equals(paramString))) {
        return 9;
      }
      if (("CODE-93".equals(paramString)) || ("CODE_93".equals(paramString))) {
        return 10;
      }
      if (("CODE-128".equals(paramString)) || ("CODE_128".equals(paramString))) {
        return 11;
      }
      if ("COMPOSITE".equals(paramString)) {
        return 12;
      }
      if (("I/25".equals(paramString)) || ("ITF".equals(paramString))) {
        return 13;
      }
      if ("DATABAR".equals(paramString)) {
        return 7;
      }
      if ("DATABAR-EXP".equals(paramString)) {
        return 8;
      }
      if ("RSS_14".equals(paramString)) {
        return 15;
      }
      if ("RSS_EXPANDED".equals(paramString)) {
        return 16;
      }
      if ("MAXICODE".equals(paramString)) {
        return 18;
      }
      if ("PDF_417".equals(paramString)) {
        return 20;
      }
      if ("QR_CODE".equals(paramString)) {
        return 19;
      }
      if ("CODABAR".equals(paramString)) {
        return 17;
      }
      if ("ISBN10".equals(paramString)) {
        return 14;
      }
      if ("DATA_MATRIX".equals(paramString)) {
        return 21;
      }
    } while (!"WX_CODE".equals(paramString));
    return 22;
  }
  
  public static r.a Mj(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      r.a locala = new r.a();
      locala.iln = paramString.optString("card_tp_id");
      locala.ilo = paramString.optInt("card_type");
      locala.bZd = paramString.optString("card_ext");
      return locala;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.ScannerUtil", paramString, "", new Object[0]);
    }
    return null;
  }
  
  public static ArrayList<r.a> Mk(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        y.e("MicroMsg.ScannerUtil", "parseCardListItemArray cardItemListJson is null");
        return null;
      }
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.ScannerUtil", paramString, "", new Object[0]);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length())
    {
      JSONObject localJSONObject = paramString.optJSONObject(i);
      r.a locala = new r.a();
      locala.iln = localJSONObject.optString("card_tp_id");
      locala.ilo = localJSONObject.optInt("card_type");
      locala.bZd = localJSONObject.optString("card_ext");
      localArrayList.add(locala);
      i += 1;
    }
    return localArrayList;
  }
  
  public static String Ml(String paramString)
  {
    return String.format("%s_%d.%s", new Object[] { byC(), Long.valueOf(System.currentTimeMillis()), paramString });
  }
  
  public static String Mm(String paramString)
  {
    return String.format("%s_%d.%s", new Object[] { byD(), Long.valueOf(System.currentTimeMillis()), paramString });
  }
  
  public static String Mn(String paramString)
  {
    return String.format("%s.%s", new Object[] { com.tencent.mm.compatible.util.e.dzD + "/scan_translation_bg", paramString });
  }
  
  public static boolean N(ArrayList<r.a> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      y.e("MicroMsg.ScannerUtil", "list == null || list.size() == 0");
    }
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramArrayList.size())
      {
        r.a locala = (r.a)paramArrayList.get(i);
        if ((locala != null) && (oN(locala.ilo))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static void aG(Context paramContext, String paramString)
  {
    h.a(paramContext, paramString, null, false, new r.1());
  }
  
  public static String byC()
  {
    return com.tencent.mm.compatible.util.e.dzD + "/scan_camera";
  }
  
  public static String byD()
  {
    return com.tencent.mm.compatible.util.e.dzD + "/scan_translation_result";
  }
  
  public static boolean byE()
  {
    int i = ((a)com.tencent.mm.kernel.g.r(a.class)).AA().getInt("EnableNewOCRTranslation", 0);
    Object localObject = ((a)com.tencent.mm.kernel.g.r(a.class)).AA().getValue("NewOCRTranslationSupportUserLanguage");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.ScannerUtil", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject, x.cqJ() });
      if ((i != 1) || (bk.bl((String)localObject))) {
        break;
      }
      localObject = ((String)localObject).split(";");
      if ((localObject == null) || (!Arrays.asList((Object[])localObject).contains(x.cqJ()))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static String eD(String paramString1, String paramString2)
  {
    Object localObject2 = com.tencent.mm.m.g.AA().getValue("ScanBookWording");
    y.i("MicroMsg.ScannerUtil", "scan image dynamic wording: " + bk.pm((String)localObject2));
    Object localObject1 = paramString2;
    if (!bk.bl((String)localObject2))
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
        if (!bk.bl(paramString1)) {
          localObject1 = paramString1;
        }
      }
    }
    return localObject1;
  }
  
  public static boolean oN(int paramInt)
  {
    b localb = (b)com.tencent.mm.kernel.g.r(b.class);
    if (localb != null) {
      return localb.oN(paramInt);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.r
 * JD-Core Version:    0.7.0.1
 */