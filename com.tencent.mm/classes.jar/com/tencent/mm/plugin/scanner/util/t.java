package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.card.c.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
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
  public static String qDP = "title";
  public static String qDQ = "tip";
  public static String qDR = "buttonTitle";
  
  public static boolean P(ArrayList<t.a> paramArrayList)
  {
    AppMethodBeat.i(81498);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ab.e("MicroMsg.ScannerUtil", "list == null || list.size() == 0");
      AppMethodBeat.o(81498);
      return false;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      t.a locala = (t.a)paramArrayList.get(i);
      if ((locala != null) && (sX(locala.iFL)))
      {
        AppMethodBeat.o(81498);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(81498);
    return false;
  }
  
  public static int YP(String paramString)
  {
    AppMethodBeat.i(81494);
    if (paramString == null)
    {
      AppMethodBeat.o(81494);
      return 0;
    }
    if (("EAN-13".equals(paramString)) || ("EAN_13".equals(paramString)))
    {
      AppMethodBeat.o(81494);
      return 4;
    }
    if (("EAN-8".equals(paramString)) || ("EAN_8".equals(paramString)))
    {
      AppMethodBeat.o(81494);
      return 3;
    }
    if ("EAN-2".equals(paramString))
    {
      AppMethodBeat.o(81494);
      return 1;
    }
    if ("EAN-5".equals(paramString))
    {
      AppMethodBeat.o(81494);
      return 2;
    }
    if (("UPC-A".equals(paramString)) || ("UPC_A".equals(paramString)))
    {
      AppMethodBeat.o(81494);
      return 5;
    }
    if (("UPC-E".equals(paramString)) || ("UPC_E".equals(paramString)))
    {
      AppMethodBeat.o(81494);
      return 6;
    }
    if (("CODE-39".equals(paramString)) || ("CODE_39".equals(paramString)))
    {
      AppMethodBeat.o(81494);
      return 9;
    }
    if (("CODE-93".equals(paramString)) || ("CODE_93".equals(paramString)))
    {
      AppMethodBeat.o(81494);
      return 10;
    }
    if (("CODE-128".equals(paramString)) || ("CODE_128".equals(paramString)))
    {
      AppMethodBeat.o(81494);
      return 11;
    }
    if ("COMPOSITE".equals(paramString))
    {
      AppMethodBeat.o(81494);
      return 12;
    }
    if (("I/25".equals(paramString)) || ("ITF".equals(paramString)))
    {
      AppMethodBeat.o(81494);
      return 13;
    }
    if ("DATABAR".equals(paramString))
    {
      AppMethodBeat.o(81494);
      return 7;
    }
    if ("DATABAR-EXP".equals(paramString))
    {
      AppMethodBeat.o(81494);
      return 8;
    }
    if ("RSS_14".equals(paramString))
    {
      AppMethodBeat.o(81494);
      return 15;
    }
    if ("RSS_EXPANDED".equals(paramString))
    {
      AppMethodBeat.o(81494);
      return 16;
    }
    if ("MAXICODE".equals(paramString))
    {
      AppMethodBeat.o(81494);
      return 18;
    }
    if ("PDF_417".equals(paramString))
    {
      AppMethodBeat.o(81494);
      return 20;
    }
    if ("QR_CODE".equals(paramString))
    {
      AppMethodBeat.o(81494);
      return 19;
    }
    if ("CODABAR".equals(paramString))
    {
      AppMethodBeat.o(81494);
      return 17;
    }
    if ("ISBN10".equals(paramString))
    {
      AppMethodBeat.o(81494);
      return 14;
    }
    if ("DATA_MATRIX".equals(paramString))
    {
      AppMethodBeat.o(81494);
      return 21;
    }
    if ("WX_CODE".equals(paramString))
    {
      AppMethodBeat.o(81494);
      return 22;
    }
    AppMethodBeat.o(81494);
    return 0;
  }
  
  public static t.a YQ(String paramString)
  {
    AppMethodBeat.i(81496);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(81496);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      t.a locala = new t.a();
      locala.kml = paramString.optString("card_tp_id");
      locala.iFL = paramString.optInt("card_type");
      locala.cHo = paramString.optString("card_ext");
      AppMethodBeat.o(81496);
      return locala;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.ScannerUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(81496);
    }
    return null;
  }
  
  public static ArrayList<t.a> YR(String paramString)
  {
    AppMethodBeat.i(81497);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(81497);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        ab.e("MicroMsg.ScannerUtil", "parseCardListItemArray cardItemListJson is null");
        AppMethodBeat.o(81497);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        t.a locala = new t.a();
        locala.kml = localJSONObject.optString("card_tp_id");
        locala.iFL = localJSONObject.optInt("card_type");
        locala.cHo = localJSONObject.optString("card_ext");
        localArrayList.add(locala);
        i += 1;
      }
      AppMethodBeat.o(81497);
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.ScannerUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(81497);
    }
    return null;
  }
  
  public static void aP(Context paramContext, String paramString)
  {
    AppMethodBeat.i(81499);
    h.a(paramContext, paramString, null, false, new t.1());
    AppMethodBeat.o(81499);
  }
  
  public static boolean cjO()
  {
    AppMethodBeat.i(81501);
    int i = ((a)com.tencent.mm.kernel.g.E(a.class)).Nq().getInt("EnableNewOCRTranslation", 0);
    Object localObject = ((a)com.tencent.mm.kernel.g.E(a.class)).Nq().getValue("NewOCRTranslationSupportUserLanguage");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.ScannerUtil", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject, aa.dsG() });
      if ((i != 1) || (bo.isNullOrNil((String)localObject))) {
        break;
      }
      localObject = ((String)localObject).split(";");
      if ((localObject == null) || (!Arrays.asList((Object[])localObject).contains(aa.dsG()))) {
        break;
      }
      AppMethodBeat.o(81501);
      return true;
    }
    AppMethodBeat.o(81501);
    return false;
  }
  
  public static String ge(String paramString1, String paramString2)
  {
    AppMethodBeat.i(81500);
    Object localObject2 = com.tencent.mm.m.g.Nq().getValue("ScanBookWording");
    ab.i("MicroMsg.ScannerUtil", "scan image dynamic wording: " + bo.nullAsNil((String)localObject2));
    Object localObject1 = paramString2;
    if (!bo.isNullOrNil((String)localObject2))
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
        if (!bo.isNullOrNil(paramString1)) {
          localObject1 = paramString1;
        }
      }
    }
    AppMethodBeat.o(81500);
    return localObject1;
  }
  
  public static boolean sX(int paramInt)
  {
    AppMethodBeat.i(81495);
    b localb = (b)com.tencent.mm.kernel.g.E(b.class);
    if (localb != null)
    {
      boolean bool = localb.sX(paramInt);
      AppMethodBeat.o(81495);
      return bool;
    }
    AppMethodBeat.o(81495);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.t
 * JD-Core Version:    0.7.0.1
 */