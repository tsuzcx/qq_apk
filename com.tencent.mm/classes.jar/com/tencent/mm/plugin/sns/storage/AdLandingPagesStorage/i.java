package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.c;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class i
{
  public static int AcV = 750;
  public static int AcW = 10;
  private static Set<i.b> AcX = null;
  
  private static String F(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(97356);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "the adLandingPagesXml is empty");
      AppMethodBeat.o(97356);
      return null;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
      AppMethodBeat.o(97356);
      return null;
    }
    LinkedList localLinkedList = new a(paramString, "adxml").AcY;
    Iterator localIterator1 = paramMap.keySet().iterator();
    String str1 = paramString;
    String str3;
    String str2;
    Iterator localIterator2;
    while (localIterator1.hasNext())
    {
      str3 = (String)localIterator1.next();
      if (!bu.isNullOrNil(str3))
      {
        str2 = (String)paramMap.get(str3);
        if (!bu.isNullOrNil(str2))
        {
          localIterator2 = localLinkedList.iterator();
          paramString = null;
        }
      }
    }
    label333:
    label335:
    for (;;)
    {
      if (localIterator2.hasNext())
      {
        Iterator localIterator3 = ((g)localIterator2.next()).AcQ.iterator();
        while (localIterator3.hasNext())
        {
          y localy = (y)localIterator3.next();
          if (((localy instanceof f)) && (!bu.isNullOrNil(((f)localy).oFe)) && (((f)localy).oFe.equals(str3)))
          {
            paramString = ((f)localy).oGb;
            label242:
            if (paramString == null) {
              break label335;
            }
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (bu.isNullOrNil(paramString)) {
            break label333;
          }
          com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "old card ext is " + paramString + " and new card ext is " + str2);
          str1 = str1.replace(paramString, str2);
          try
          {
            paramString = str1.replace(bu.aSz(paramString), bu.aSz(str2));
            str1 = paramString;
          }
          catch (Exception paramString)
          {
            com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "the xml is error");
          }
        }
        break;
        AppMethodBeat.o(97356);
        return str1;
        break label242;
      }
      break;
    }
  }
  
  public static String J(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(97355);
    if (paramp == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "the snsinfo is null");
      AppMethodBeat.o(97355);
      return null;
    }
    if (!paramp.Rt(32))
    {
      com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "the snsinfo is not a ad");
      AppMethodBeat.o(97355);
      return null;
    }
    com.tencent.mm.plugin.sns.storage.e locale = paramp.ecy();
    if (locale == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "the adSnsInfo is null");
      AppMethodBeat.o(97355);
      return null;
    }
    com.tencent.mm.plugin.sns.storage.b localb = paramp.dVj();
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "the adxml is null");
      AppMethodBeat.o(97355);
      return null;
    }
    paramp = paramp.dVi();
    if (paramp == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "the adInfo is null");
      AppMethodBeat.o(97355);
      return null;
    }
    if (!localb.dZv())
    {
      com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "the snsinfo is not a landingpage");
      AppMethodBeat.o(97355);
      return null;
    }
    if ((paramp.zMm == null) || (paramp.zMm.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
      AppMethodBeat.o(97355);
      return null;
    }
    paramp = F(locale.field_adxml, paramp.zMm);
    AppMethodBeat.o(97355);
    return paramp;
  }
  
  public static boolean Rk(int paramInt)
  {
    return (paramInt == 101) || (paramInt == 103) || (paramInt == 104) || (paramInt == 105);
  }
  
  public static boolean Rl(int paramInt)
  {
    return paramInt == 101;
  }
  
  public static boolean Rm(int paramInt)
  {
    return paramInt == 103;
  }
  
  public static boolean Rn(int paramInt)
  {
    return paramInt == 104;
  }
  
  public static boolean Ro(int paramInt)
  {
    return paramInt == 105;
  }
  
  private static boolean Rp(int paramInt)
  {
    paramInt |= 0xFF000000;
    return paramInt + 16777216 > -1 - paramInt;
  }
  
  public static float a(double paramDouble, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(97332);
    if (paramInt1 == 0)
    {
      f1 = (float)paramDouble;
      AppMethodBeat.o(97332);
      return f1;
    }
    if (paramInt2 == 0)
    {
      f1 = (float)paramDouble;
      AppMethodBeat.o(97332);
      return f1;
    }
    int[] arrayOfInt = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an.gp(com.tencent.mm.sdk.platformtools.ak.getContext());
    paramInt1 = Math.min(arrayOfInt[0], arrayOfInt[1]);
    float f1 = (float)paramDouble;
    float f2 = paramInt3;
    f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an.bA(paramInt1 * (f1 * f2) / paramInt2);
    AppMethodBeat.o(97332);
    return f1;
  }
  
  private static y a(Map<String, String> paramMap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(97343);
    int i = bu.aSB((String)paramMap.get(paramString + ".type"));
    y localy = null;
    if (!Rk(i)) {}
    for (;;)
    {
      try
      {
        localy = a(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
        paramMap = localy;
      }
      catch (Exception localException)
      {
        paramMap = a(paramMap, paramString, paramInt1, paramInt2, paramInt3, 0);
        continue;
      }
      AppMethodBeat.o(97343);
      return paramMap;
      if (Rl(i))
      {
        paramMap = d(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (Rm(i))
      {
        paramMap = e(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (Rn(i))
      {
        paramMap = f(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (Ro(i))
      {
        paramMap = g(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "the type" + i + " is not client known type");
        paramMap = localException;
      }
    }
  }
  
  private static y a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97333);
    int k = bu.aSB((String)paramMap.get(paramString + ".type"));
    int m = bu.aSB((String)paramMap.get(paramString + ".subType"));
    Object localObject1;
    switch (k)
    {
    default: 
      AppMethodBeat.o(97333);
      return null;
    case 82: 
      localObject1 = new al();
      ((al)localObject1).url = bu.bI((String)paramMap.get(paramString + ".webviewUrl"), "");
      ((al)localObject1).zQM = bu.bI((String)paramMap.get(paramString + ".qrExtInfo"), "");
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((y)localObject1).zRk = Rp(paramInt4);
        ((y)localObject1).type = k;
        ((y)localObject1).subType = m;
        a((y)localObject1, paramMap, paramString, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(97333);
      return localObject1;
      localObject1 = c(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae();
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).zRh = k;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).subType = m;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).zRI = bu.bI((String)paramMap.get(paramString + ".content"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).textAlignment = bu.aSB((String)paramMap.get(paramString + ".textAlignment"));
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).wdx = bu.bI((String)paramMap.get(paramString + ".fontColor"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).textSize = a(bu.aSD((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
      if ((bu.aSB((String)paramMap.get(paramString + ".showType")) & com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae.zRD) > 0)
      {
        bool = true;
        label624:
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).zRJ = bool;
        if ((bu.aSB((String)paramMap.get(paramString + ".showType")) & com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae.zRE) <= 0) {
          break label849;
        }
        bool = true;
        label673:
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).zRK = bool;
        if ((bu.aSB((String)paramMap.get(paramString + ".showType")) & com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae.zRF) <= 0) {
          break label855;
        }
      }
      label849:
      label855:
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).zRL = bool;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).maxLines = bu.aSB((String)paramMap.get(paramString + ".maxLines"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).zQw = bu.aSB((String)paramMap.get(paramString + ".fontType"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localObject1).zRM = bu.aSE((String)paramMap.get(paramString + ".lineSpace"));
        break;
        bool = false;
        break label624;
        bool = false;
        break label673;
      }
      label983:
      Object localObject2;
      if (m == 2)
      {
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).dwb = ((String)paramMap.get(paramString + ".appid"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPA = ((String)paramMap.get(paramString + ".wxAppid"));
        if (bu.aSB((String)paramMap.get(paramString + ".useGameDownloadWidget")) == 1)
        {
          bool = true;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPB = bool;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zMz = ((String)paramMap.get(paramString + ".appPageUrlAndroid"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).channelId = ((String)paramMap.get(paramString + ".channelId"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).Lw = ((String)paramMap.get(paramString + ".pkg"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPE = bu.aSB((String)paramMap.get(paramString + ".platform"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPF = ((String)paramMap.get(paramString + ".warningAndroid"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPG = ((String)paramMap.get(paramString + ".btnBgColorTheme"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPI = ((String)paramMap.get(paramString + ".btnBgColorThemePressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPH = ((String)paramMap.get(paramString + ".btnBgColorThemeDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPJ = ((String)paramMap.get(paramString + ".btnBorderColorTheme"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPL = ((String)paramMap.get(paramString + ".btnBorderColorThemePressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPK = ((String)paramMap.get(paramString + ".btnBorderColorThemeDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPM = ((String)paramMap.get(paramString + ".fontColor"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPO = ((String)paramMap.get(paramString + ".fontColorPressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPN = ((String)paramMap.get(paramString + ".fontColorDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPR = bu.aSB((String)paramMap.get(paramString + ".showDownloadTip"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPS = bu.aSB((String)paramMap.get(paramString + ".marketFlag"));
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPS > 0)
          {
            localObject2 = aT(paramMap);
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zPT = ((Intent)localObject2);
            }
          }
        }
      }
      Object localObject3;
      for (;;)
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zRh = k;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).subType = m;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).title = bu.bI((String)paramMap.get(paramString + ".btnTitle"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQr = bu.aSB((String)paramMap.get(paramString + ".btnType"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQs = bu.bI((String)paramMap.get(paramString + ".btnJumpUrl"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQt = bu.bI((String)paramMap.get(paramString + ".btnJumpApp"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQu = bu.bI((String)paramMap.get(paramString + ".fontColor"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).fontSize = a(bu.aSD((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQw = bu.aSB((String)paramMap.get(paramString + ".btnFontType"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).textAlignment = bu.aSB((String)paramMap.get(paramString + ".btnAlignment"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQv = a(bu.aSD((String)paramMap.get(paramString + ".borderSize")), paramInt1, paramInt2, paramInt3);
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).height = a(bu.aSD((String)paramMap.get(paramString + ".btnHeight")), paramInt1, paramInt2, paramInt3);
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQx = bu.bI((String)paramMap.get(paramString + ".btnBgColorTheme"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQy = bu.bI((String)paramMap.get(paramString + ".btnBorderColorTheme"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQz = bu.bI((String)paramMap.get(paramString + ".btnBgImgUrl"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQA = bu.aSB((String)paramMap.get(paramString + ".bCanLongPress"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQB = bu.aSB((String)paramMap.get(paramString + ".bHideActionSheet"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQC = bu.aSB((String)paramMap.get(paramString + ".hideProductActionHeader"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQD = bu.aSB((String)paramMap.get(paramString + ".showProductActionCancelButton"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQF = bu.bI((String)paramMap.get(paramString + ".productActionTitle"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQE = bu.bI((String)paramMap.get(paramString + ".productActionBuffer"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQG = bu.bI((String)paramMap.get(paramString + ".productActionIconUrl"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).tm = a(bu.aSB((String)paramMap.get(paramString + ".cornerRadius")), paramInt1, paramInt2, paramInt3);
        if (paramMap.containsKey(paramString + ".productActionItem.componentItem.type")) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQH = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString + ".productActionItem.componentItem");
        }
        break;
        bool = false;
        break label983;
        if (m == 4)
        {
          localObject1 = new f();
          ((f)localObject1).oFe = bu.bI((String)paramMap.get(paramString + ".cardTpId"), "");
          ((f)localObject1).oGb = bu.bI((String)paramMap.get(paramString + ".cardExt"), "");
        }
        else if (m == 7)
        {
          localObject1 = new l();
          ((l)localObject1).zQf = bu.bI((String)paramMap.get(paramString + ".jumpCanvasId"), "");
          ((l)localObject1).zQg = bu.bI((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
          ((l)localObject1).zQh = bu.aSB((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
          ((l)localObject1).zQi = bu.aSB((String)paramMap.get(paramString + ".btnCanvasEnterType"));
          ((l)localObject1).zQj = bu.aSB((String)paramMap.get(paramString + ".btnCanvasSource"));
        }
        else if (m == 8)
        {
          localObject1 = new k();
          ((k)localObject1).username = ((String)paramMap.get(paramString + ".weappUserName"));
          ((k)localObject1).dKV = ((String)paramMap.get(paramString + ".weappPath"));
        }
        else if (m == 9)
        {
          d1 = bu.aSD((String)paramMap.get(paramString + ".location.$x"));
          d2 = bu.aSD((String)paramMap.get(paramString + ".location.$y"));
          i = bu.aSB((String)paramMap.get(paramString + ".location.$scale"));
          localObject1 = (String)paramMap.get(paramString + ".location.$label");
          localObject2 = (String)paramMap.get(paramString + ".location.$poiname");
          if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2)))
          {
            AppMethodBeat.o(97333);
            return null;
          }
          localObject1 = new h(new h.a(d1, d2, i, (String)localObject1, (String)localObject2));
        }
        else if (m == 10)
        {
          localObject2 = paramString + ".phoneNumList.phoneNum";
          localObject3 = new ArrayList();
          i = 0;
          if (i == 0) {}
          for (localObject1 = (String)paramMap.get(localObject2);; localObject1 = (String)paramMap.get((String)localObject2 + i))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label3231;
            }
            ((List)localObject3).add(localObject1);
            i += 1;
            break;
          }
          label3231:
          if (!((List)localObject3).isEmpty())
          {
            localObject1 = new j((List)localObject3);
          }
          else
          {
            AppMethodBeat.o(97333);
            return null;
          }
        }
        else if (m == 12)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)localObject1).pSx = ((String)paramMap.get(paramString + ".weappUserName"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)localObject1).zQk = ((String)paramMap.get(paramString + ".weAppID"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)localObject1).kNn = ((String)paramMap.get(paramString + ".businessId"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)localObject1).kNe = ((String)paramMap.get(paramString + ".sessionFrom"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)localObject1).zQl = bu.aSB((String)paramMap.get(paramString + ".showMessageCard"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)localObject1).kNo = bu.nullAsNil((String)paramMap.get(paramString + ".sendMessageTitle"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)localObject1).kNq = bu.nullAsNil((String)paramMap.get(paramString + ".sendMessageImg"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)localObject1).kNp = bu.nullAsNil((String)paramMap.get(paramString + ".sendMessagePath"));
        }
        else if (m == 13)
        {
          localObject1 = new n();
          ((n)localObject1).zQm = bu.aSB((String)paramMap.get(paramString + ".sid"));
          ((n)localObject1).zQn = bu.aSB((String)paramMap.get(paramString + ".compid"));
        }
        else if (m == 14)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).zQb = bu.nullAsNil((String)paramMap.get(paramString + ".redEnvelopsSkinBtnDisableWording"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).zQc = bu.aSC(paramString + ".redEnvelopsSkinDisableTime");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).dwW = bu.nullAsNil((String)paramMap.get(paramString + ".redEnvelopesSkinId"));
        }
        else if (m == 15)
        {
          localObject1 = new aa();
          ((aa)localObject1).zRs = bu.bI((String)paramMap.get(paramString + ".qrUrl"), "");
          ((aa)localObject1).zQM = bu.bI((String)paramMap.get(paramString + ".qrExtInfo"), "");
          ((aa)localObject1).zRt = bu.aSB((String)paramMap.get(paramString + ".needUpdateQrUrl"));
        }
        else if (m == 16)
        {
          localObject1 = new ab();
          ((ab)localObject1).zRu = b.b.t(paramMap, ".adxml.adScanInfo");
        }
        else if (m == 17)
        {
          localObject1 = new v();
          ((v)localObject1).hTJ = bu.bI((String)paramMap.get(paramString + ".brandUsername"), "");
          ((v)localObject1).ztf = bu.bI((String)paramMap.get(paramString + ".brandHead"), "");
          ((v)localObject1).dpI = bu.bI((String)paramMap.get(paramString + ".brandName"), "");
          ((v)localObject1).ztg = bu.bI((String)paramMap.get(paramString + ".brandDesc"), "");
          ((v)localObject1).zth = bu.bI((String)paramMap.get(paramString + ".btnTitleAfterAddBrand"), "");
        }
        else
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p();
        }
      }
      localObject1 = new s();
      ((s)localObject1).zRh = k;
      ((s)localObject1).subType = m;
      ((s)localObject1).zQK = bu.bI((String)paramMap.get(paramString + ".pureImageUrl"), "");
      ((s)localObject1).zOW = bu.bI((String)paramMap.get(paramString + ".bgColor"), "");
      if ((paramMap.containsKey(paramString + ".bgColorAlpha")) && (((s)localObject1).zOW.length() > 0)) {
        ((s)localObject1).zOW = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bu.aSD((String)paramMap.get(paramString + ".bgColorAlpha")) * 255.0D)), ((s)localObject1).zOW.substring(1) });
      }
      ((s)localObject1).width = a(bu.aSD((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((s)localObject1).height = a(bu.aSD((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      ((s)localObject1).zQJ = false;
      if (bu.aSB((String)paramMap.get(paramString + ".enableQRScan")) == 1) {}
      for (bool = true;; bool = false)
      {
        ((s)localObject1).zQL = bool;
        ((s)localObject1).zQM = bu.bI((String)paramMap.get(paramString + ".qrExtInfo"), "");
        break;
      }
      localObject1 = new r();
      ((r)localObject1).zRh = k;
      ((r)localObject1).subType = m;
      ((r)localObject1).zQK = bu.bI((String)paramMap.get(paramString + ".panoramaImageUrl"), "");
      ((r)localObject1).width = a(bu.aSD((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((r)localObject1).height = a(bu.aSD((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      continue;
      localObject1 = new s();
      ((s)localObject1).zRh = k;
      ((s)localObject1).subType = m;
      ((s)localObject1).zQK = bu.bI((String)paramMap.get(paramString + ".fullScreenImageUrl"), "");
      ((s)localObject1).zQJ = true;
      if (bu.aSB((String)paramMap.get(paramString + ".enableQRScan")) == 1) {}
      for (bool = true;; bool = false)
      {
        ((s)localObject1).zQL = bool;
        break;
      }
      localObject1 = new u();
      ((u)localObject1).zRh = k;
      ((u)localObject1).subType = m;
      ((u)localObject1).zQP = bu.bI((String)paramMap.get(paramString + ".sightVideoUrl"), "");
      ((u)localObject1).zQQ = bu.bI((String)paramMap.get(paramString + ".sightThumbUrl"), "");
      ((u)localObject1).zQR = bu.bI((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((u)localObject1).zQS = bu.bI((String)paramMap.get(paramString + ".jumpText"), "");
      ((u)localObject1).zQf = bu.bI((String)paramMap.get(paramString + ".jumpCanvasId"), "");
      ((u)localObject1).zQg = bu.bI((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
      ((u)localObject1).zQh = bu.aSB((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
      try
      {
        ((u)localObject1).zQT = Color.parseColor((String)paramMap.get(paramString + ".jumpTextColor"));
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((u)localObject1).zQU = Color.parseColor((String)paramMap.get(paramString + ".separatorColor"));
            ((u)localObject1).width = a(bu.aSD((String)paramMap.get(paramString + ".sightDisplayWidth")), paramInt1, paramInt2, paramInt3);
            ((u)localObject1).height = a(bu.aSD((String)paramMap.get(paramString + ".sightDisplayHeight")), paramInt1, paramInt2, paramInt3);
            ((u)localObject1).zQV = bu.aSB((String)paramMap.get(paramString + ".sightDisplayType"));
            localObject2 = bu.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
            i = bu.aSB((String)paramMap.get(paramString + ".floatStartTime"));
            if ((!bu.isNullOrNil((String)localObject2)) && (i > 0))
            {
              localObject3 = new ag();
              ((ag)localObject3).dDp = ((String)localObject2);
              ((ag)localObject3).zRT = i;
              ((u)localObject1).zQW = ((ag)localObject3);
            }
            if (bu.aSB((String)paramMap.get(".adxml.adCanvasInfo.heightRoundingType")) <= 0) {
              break label5660;
            }
            bool = true;
            ((u)localObject1).zQX = bool;
            if (bu.aSB((String)paramMap.get(paramString + ".downloadVideoByCdn")) <= 0) {
              break label5666;
            }
            bool = true;
            ((u)localObject1).zQY = bool;
            ((u)localObject1).zRa = i(paramMap, paramString + ".floatBarComponentItem", paramInt1, paramInt2, paramInt3, paramInt4);
            ((u)localObject1).zQZ = bu.aSC((String)paramMap.get(paramString + ".fileSize"));
            break;
            localException1 = localException1;
            ((u)localObject1).zQT = Color.rgb(255, 255, 255);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ((u)localObject1).zQU = Color.rgb(255, 255, 255);
            continue;
            label5660:
            bool = false;
            continue;
            label5666:
            bool = false;
          }
        }
      }
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak();
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).zRh = k;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).subType = m;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).zQR = bu.bI((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).zRV = bu.bI((String)paramMap.get(paramString + ".streamVideoThumb"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).width = a(bu.aSD((String)paramMap.get(paramString + ".streamDisplayWidth")), paramInt1, paramInt2, paramInt3);
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).height = a(bu.aSD((String)paramMap.get(paramString + ".streamDisplayHeight")), paramInt1, paramInt2, paramInt3);
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).zRW = bu.aSB((String)paramMap.get(paramString + ".streamDisplayType"));
      String str1 = bu.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
      int i = bu.aSB((String)paramMap.get(paramString + ".floatStartTime"));
      if ((!bu.isNullOrNil(str1)) && (i > 0))
      {
        localObject3 = new ag();
        ((ag)localObject3).dDp = str1;
        ((ag)localObject3).zRT = i;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).zQW = ((ag)localObject3);
      }
      if (bu.aSB((String)paramMap.get(".adxml.adCanvasInfo.heightRoundingType")) > 0) {}
      for (bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).zQX = bool;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)localObject1).zRa = i(paramMap, paramString + ".floatBarComponentItem", paramInt1, paramInt2, paramInt3, paramInt4);
        break;
      }
      localObject1 = new aj();
      ((aj)localObject1).zRh = k;
      ((aj)localObject1).subType = m;
      ((aj)localObject1).uEo = bu.bI((String)paramMap.get(paramString + ".webviewUrl"), "");
      continue;
      double d1 = a(bu.aSD((String)paramMap.get(paramString + ".topLineSize")), paramInt1, paramInt2, paramInt3);
      double d2 = a(bu.aSD((String)paramMap.get(paramString + ".bottomLineSize")), paramInt1, paramInt2, paramInt3);
      if (Rp(paramInt4)) {
        i = Color.argb(51, 0, 0, 0);
      }
      int j;
      for (;;)
      {
        if (k == 121)
        {
          double d3 = bu.aSD((String)paramMap.get(paramString + ".location.$x"));
          double d4 = bu.aSD((String)paramMap.get(paramString + ".location.$y"));
          j = bu.aSB((String)paramMap.get(paramString + ".location.$scale"));
          localObject1 = (String)paramMap.get(paramString + ".location.$label");
          str1 = (String)paramMap.get(paramString + ".location.$poiname");
          if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(str1)))
          {
            AppMethodBeat.o(97333);
            return null;
            i = Color.argb(51, 255, 255, 255);
          }
          else
          {
            localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i(d1, d2, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i.a(d3, d4, j, (String)localObject1, str1), i);
            break;
          }
        }
      }
      if (k == 122)
      {
        str1 = paramString + ".phoneNumList.phoneNum";
        localObject3 = new ArrayList();
        j = 0;
        if (j == 0) {}
        for (localObject1 = (String)paramMap.get(str1);; localObject1 = (String)paramMap.get(str1 + j))
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label6620;
          }
          ((List)localObject3).add(localObject1);
          j += 1;
          break;
        }
        label6620:
        if (!((List)localObject3).isEmpty())
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d(d1, d2, i, (List)localObject3);
        }
        else
        {
          AppMethodBeat.o(97333);
          return null;
          localObject1 = new ad();
          ((ad)localObject1).zRh = k;
          ((ad)localObject1).subType = m;
          ((ad)localObject1).label = bu.bI((String)paramMap.get(paramString + ".label"), "");
          ((ad)localObject1).value = ((float)bu.aSD((String)paramMap.get(paramString + ".value")));
          ((ad)localObject1).zRC = bu.bI((String)paramMap.get(paramString + ".foregroundImage"), "");
          ((ad)localObject1).fontSize = a(bu.aSD((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
          ((ad)localObject1).jZm = bu.bI((String)paramMap.get(paramString + ".backgroundColor"), "");
          continue;
          localObject1 = b(paramMap, paramString, paramInt1, paramInt2, paramInt3);
          continue;
          localObject1 = new t();
          ((t)localObject1).zOV = bu.bI((String)paramMap.get(paramString + ".sphereThumbUrl"), "");
          ((t)localObject1).zOE = bu.aSB((String)paramMap.get(paramString + ".displayType"));
          ((t)localObject1).zOT = bu.aSB((String)paramMap.get(paramString + ".gestureDelayTime"));
          ((t)localObject1).zOU = bu.bI((String)paramMap.get(paramString + ".sphereImageUrl"), "");
          try
          {
            ((t)localObject1).zOW = bu.bI((String)paramMap.get(paramString + ".bgColor"), "");
            if ((paramMap.containsKey(paramString + ".bgColorAlpha")) && (((t)localObject1).zOW.length() > 0)) {
              ((t)localObject1).zOW = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bu.aSD((String)paramMap.get(paramString + ".bgColorAlpha")) * 255.0D)), ((t)localObject1).zOW.substring(1) });
            }
          }
          catch (Exception localException3)
          {
            try
            {
              for (;;)
              {
                ((t)localObject1).width = a(bu.aSD((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
                ((t)localObject1).height = a(bu.aSD((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
                ((t)localObject1).zQN = bu.bI((String)paramMap.get(".adxml.adSphereCardInfo.sphereImageUrl"), "");
                ((t)localObject1).zQO = bu.bI((String)paramMap.get(".adxml.adSphereCardInfo.sphereThumbUrl"), "");
                break;
                localException3 = localException3;
                com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse color exp=" + localException3.toString());
              }
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                ((t)localObject1).width = 0.0F;
                ((t)localObject1).height = 0.0F;
                com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse size exp=" + localException4.toString());
              }
            }
          }
          localObject1 = new ac();
          ((ac)localObject1).zRv = bu.bI((String)paramMap.get(paramString + ".backgroundImg"), "");
          ((ac)localObject1).iconUrl = bu.bI((String)paramMap.get(paramString + ".iconUrl"), "");
          ((ac)localObject1).title = bu.bI((String)paramMap.get(paramString + ".title"), "");
          ((ac)localObject1).desc = bu.bI((String)paramMap.get(paramString + ".desc"), "");
          ((ac)localObject1).zRA = bu.aSB((String)paramMap.get(paramString + ".onlyShowInTimelineAd"));
          if (bu.aSB((String)paramMap.get(paramString + ".isFullClickable")) == 1)
          {
            bool = true;
            label7669:
            ((ac)localObject1).zRx = bool;
            ((ac)localObject1).zRy = ((int)a(bu.aSD((String)paramMap.get(paramString + ".appearPaddingTop")), paramInt1, paramInt2, paramInt3));
            ((ac)localObject1).zRz = ((int)a(bu.aSD((String)paramMap.get(paramString + ".appearPaddingBottom")), paramInt1, paramInt2, paramInt3));
          }
          try
          {
            str2 = paramString + ".backgroundColor";
            localObject3 = paramString + ".backgroundColorAlpha";
            ((ac)localObject1).jZm = bu.bI((String)paramMap.get(str2), "");
            if ((paramMap.containsKey(localObject3)) && (((ac)localObject1).jZm.length() > 0)) {
              ((ac)localObject1).jZm = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bu.aSD((String)paramMap.get(localObject3)) * 255.0D)), ((ac)localObject1).jZm.substring(1) });
            }
          }
          catch (Exception localException6)
          {
            try
            {
              str2 = paramString + ".titleColor";
              localObject3 = paramString + ".titleColorAlpha";
              ((ac)localObject1).titleColor = bu.bI((String)paramMap.get(str2), "");
              if ((paramMap.containsKey(localObject3)) && (((ac)localObject1).titleColor.length() > 0)) {
                ((ac)localObject1).titleColor = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bu.aSD((String)paramMap.get(localObject3)) * 255.0D)), ((ac)localObject1).titleColor.substring(1) });
              }
            }
            catch (Exception localException6)
            {
              try
              {
                for (;;)
                {
                  String str2 = paramString + ".descColor";
                  localObject3 = paramString + ".descColorAlpha";
                  ((ac)localObject1).zRw = bu.bI((String)paramMap.get(str2), "");
                  if ((paramMap.containsKey(localObject3)) && (((ac)localObject1).zRw.length() > 0)) {
                    ((ac)localObject1).zRw = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bu.aSD((String)paramMap.get(localObject3)) * 255.0D)), ((ac)localObject1).zRw.substring(1) });
                  }
                  ((ac)localObject1).zRB = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
                  if (!(((ac)localObject1).zRB instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)) {
                    break label8501;
                  }
                  ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)((ac)localObject1).zRB).zPQ = true;
                  break;
                  bool = false;
                  break label7669;
                  localException5 = localException5;
                  com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse backgroundColor exp=" + localException5.toString());
                  continue;
                  localException6 = localException6;
                  com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse titleColor exp=" + localException6.toString());
                }
              }
              catch (Exception localException7)
              {
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse descColor exp=" + localException7.toString());
                }
              }
            }
          }
          localObject1 = y(paramMap, paramString);
          continue;
          localObject1 = new o();
          ((o)localObject1).zQp = bu.bI((String)paramMap.get(paramString + ".swipeText"), "");
          ((o)localObject1).zQq = bu.aSB((String)paramMap.get(paramString + ".swipeActionType"));
          ((o)localObject1).jumpUrl = bu.bI((String)paramMap.get(paramString + ".jumpUrl"), "");
          continue;
          localObject1 = h(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
        }
      }
      else
      {
        label8501:
        localObject1 = null;
      }
    }
  }
  
  private static void a(y paramy, Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(97338);
    paramy.zRh = bu.aSB((String)paramMap.get(paramString + ".type"));
    paramy.type = paramy.zRh;
    paramy.zRg = bu.bI((String)paramMap.get(paramString + ".id"), "");
    paramy.paddingTop = a(bu.aSD((String)paramMap.get(paramString + ".paddingTop")), paramInt1, paramInt2, paramInt3);
    paramy.paddingBottom = a(bu.aSD((String)paramMap.get(paramString + ".paddingBottom")), paramInt1, paramInt2, paramInt3);
    paramy.paddingLeft = a(bu.aSD((String)paramMap.get(paramString + ".paddingLeft")), paramInt1, paramInt2, paramInt3);
    paramy.paddingRight = a(bu.aSD((String)paramMap.get(paramString + ".paddingRight")), paramInt1, paramInt2, paramInt3);
    paramy.subType = bu.aSB((String)paramMap.get(paramString + ".subType"));
    paramy.zRl = bu.bI((String)paramMap.get(paramString + ".cellBackgroundColor"), "");
    String str1 = paramString + ".if";
    boolean bool1;
    label401:
    label455:
    label461:
    double d;
    if (paramMap.containsKey(str1)) {
      if ("1".equals(paramMap.get(str1)))
      {
        bool1 = true;
        paramy.zRo = bool1;
        str1 = paramString + ".noReport";
        if (!paramMap.containsKey(str1)) {
          break label706;
        }
        if (!"1".equals(paramMap.get(str1))) {
          break label700;
        }
        bool1 = bool2;
        paramy.zRp = bool1;
        str1 = bu.bI((String)paramMap.get(paramString + ".layoutWidth"), "");
        String str2 = bu.bI((String)paramMap.get(paramString + ".layoutHeight"), "");
        if (TextUtils.isEmpty(str1)) {
          break label731;
        }
        d = bu.aSD(str1);
        if (d >= 0.0D) {
          break label714;
        }
        paramy.zRi = ((float)d);
        label564:
        if (TextUtils.isEmpty(str2)) {
          break label758;
        }
        d = bu.aSD(str2);
        if (d >= 0.0D) {
          break label741;
        }
        paramy.zRj = ((float)d);
        label593:
        str1 = (String)paramMap.get(paramString + ".verticalAlignment");
        paramMap = (String)paramMap.get(paramString + ".horizontalAlignment");
        if (!TextUtils.isEmpty(str1)) {
          break label768;
        }
      }
    }
    label768:
    for (paramy.zRm = -1;; paramy.zRm = bu.aSB(str1))
    {
      if (!TextUtils.isEmpty(paramMap)) {
        break label780;
      }
      paramy.zRn = -1;
      AppMethodBeat.o(97338);
      return;
      bool1 = false;
      break;
      paramy.zRo = true;
      break label401;
      label700:
      bool1 = false;
      break label455;
      label706:
      paramy.zRp = false;
      break label461;
      label714:
      paramy.zRi = a(d, paramInt1, paramInt2, paramInt3);
      break label564;
      label731:
      paramy.zRi = 2.147484E+009F;
      break label564;
      label741:
      paramy.zRj = a(d, paramInt1, paramInt2, paramInt3);
      break label593;
      label758:
      paramy.zRj = 2.147484E+009F;
      break label593;
    }
    label780:
    paramy.zRn = bu.aSB(paramMap);
    AppMethodBeat.o(97338);
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, Activity paramActivity)
  {
    AppMethodBeat.i(97351);
    String str = paramTimeLineObject.AkC;
    long l = new BigInteger(paramTimeLineObject.Id).longValue();
    LinkedList localLinkedList = paramTimeLineObject.HUG.Gtx;
    boolean bool;
    Object localObject;
    int i;
    int j;
    if (!TextUtils.isEmpty(str))
    {
      if ((TextUtils.isEmpty(str)) || (!aBm(str))) {
        break label449;
      }
      paramTimeLineObject = "";
      bool = aBl(str);
      if (!bool) {
        break label469;
      }
      localObject = com.tencent.mm.model.c.d.aDJ().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
      if (com.tencent.mm.model.c.d.aDJ().gv("Sns_Canvas_GameShare_JumpWay", 0) == 0)
      {
        i = 0;
        j = i;
        paramTimeLineObject = (TimeLineObject)localObject;
        if (i == 0)
        {
          j = i;
          paramTimeLineObject = (TimeLineObject)localObject;
          if (ebG())
          {
            j = 1;
            paramTimeLineObject = (TimeLineObject)localObject;
          }
        }
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        localObject = com.tencent.mm.plugin.sns.model.ah.dXE().AG(l);
        Intent localIntent = new Intent();
        if (localObject != null)
        {
          localIntent.putExtra("sns_landing_pages_share_sns_id", ((com.tencent.mm.plugin.sns.storage.p)localObject).getSnsId());
          localIntent.putExtra("sns_landing_pages_rawSnsId", ((com.tencent.mm.plugin.sns.storage.p)localObject).ebP().Id);
          localIntent.putExtra("sns_landing_pages_ux_info", ((com.tencent.mm.plugin.sns.storage.p)localObject).ecx());
          localIntent.putExtra("sns_landing_pages_aid", ((com.tencent.mm.plugin.sns.storage.p)localObject).ect());
          localIntent.putExtra("sns_landing_pages_traceid", ((com.tencent.mm.plugin.sns.storage.p)localObject).ecu());
          localIntent.putExtra("sns_landing_pages_rec_src", ((com.tencent.mm.plugin.sns.storage.p)localObject).ecz());
        }
        if ((localLinkedList != null) && (localLinkedList.size() > 0)) {
          localIntent.putExtra("sns_landing_pages_share_thumb_url", ((bzh)localLinkedList.get(0)).Hmj);
        }
        localIntent.putExtra("sns_landing_pages_expid", paramTimeLineObject);
        localIntent.putExtra("sns_landig_pages_from_source", 11);
        localIntent.setClass(paramActivity, SnsAdNativeLandingPagesUI.class);
        localIntent.putExtra("sns_landing_pages_xml", str);
        localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        paramTimeLineObject = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramTimeLineObject.ahE(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Ljava/lang/String;JLjava/util/List;Landroid/app/Activity;IZ)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramTimeLineObject.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Ljava/lang/String;JLjava/util/List;Landroid/app/Activity;IZ)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(97351);
        return true;
        i = 1;
        break;
      }
      a(str, paramActivity, bool, 11);
      for (;;)
      {
        AppMethodBeat.o(97351);
        return false;
        label449:
        com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str });
      }
      label469:
      j = 1;
    }
  }
  
  private static boolean a(String paramString, Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(97346);
    paramString = (String)bx.M(paramString, "adCanvasInfo").get(".adCanvasInfo.shareWebUrl");
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(97346);
      return false;
    }
    String str = paramString;
    if (paramBoolean) {
      str = "exp=" + com.tencent.mm.model.c.d.aDJ().getExpIdByKey("Sns_Canvas_GameShare_JumpWay") + "_" + paramInt;
    }
    try
    {
      str = n(paramString, new String[] { str });
      paramString = str;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      label102:
      break label102;
    }
    com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "canvas jump url ".concat(String.valueOf(paramString)));
    str = paramString;
    paramString = new Intent();
    paramString.putExtra("rawUrl", str);
    paramString.putExtra("showShare", true);
    com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(97346);
    return true;
  }
  
  private static boolean aBl(String paramString)
  {
    AppMethodBeat.i(97345);
    if (bu.aSB(bu.bI((String)bx.M(paramString, "adCanvasInfo").get(".adCanvasInfo.bizId"), "")) == 1)
    {
      AppMethodBeat.o(97345);
      return true;
    }
    AppMethodBeat.o(97345);
    return false;
  }
  
  public static boolean aBm(String paramString)
  {
    AppMethodBeat.i(224105);
    boolean bool = jS(paramString, "adCanvasInfo");
    AppMethodBeat.o(224105);
    return bool;
  }
  
  private static Intent aT(Map<String, String> paramMap)
  {
    AppMethodBeat.i(219626);
    paramMap = com.tencent.mm.plugin.sns.device.appstore.a.b(com.tencent.mm.sdk.platformtools.ak.getContext(), paramMap);
    if (paramMap != null)
    {
      paramMap = paramMap.dWs();
      AppMethodBeat.o(219626);
      return paramMap;
    }
    AppMethodBeat.o(219626);
    return null;
  }
  
  private static am b(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(97334);
    localam = new am();
    try
    {
      paramString = paramString + ".radarChart";
      localam.zRX = ((String)paramMap.get(paramString + ".borderImg"));
      localam.zSd = ((String)paramMap.get(paramString + ".maskImg"));
      localam.zRY = ((String)paramMap.get(paramString + ".coverColor"));
      localam.zRZ = Color.parseColor((String)paramMap.get(paramString + ".labelFont.$color"));
      localam.zSa = ((int)a(bu.aSD((String)paramMap.get(paramString + ".labelFont.$size")), paramInt1, paramInt2, paramInt3));
      localam.zSb = Color.parseColor((String)paramMap.get(paramString + ".scoreFont.$color"));
      localam.zSc = ((int)a(bu.aSD((String)paramMap.get(paramString + ".scoreFont.$size")), paramInt1, paramInt2, paramInt3));
      localam.borderWidth = a(bu.aSD((String)paramMap.get(paramString + ".borderImgWidth")), paramInt1, paramInt2, paramInt3);
      String str = paramString + ".itemList.item";
      paramInt1 = 0;
      if (paramInt1 != 0) {}
      for (paramString = str + paramInt1;; paramString = str)
      {
        am.a locala = new am.a();
        locala.label = ((String)paramMap.get(paramString + ".label"));
        locala.zSe = ((String)paramMap.get(paramString + ".score"));
        locala.value = ((float)bu.aSD((String)paramMap.get(paramString + ".value")));
        if ((TextUtils.isEmpty(locala.label)) && (TextUtils.isEmpty(locala.zSe))) {
          break label567;
        }
        localam.iDI.add(locala);
        paramInt1 += 1;
        break;
      }
      label567:
      return localam;
    }
    catch (Exception paramMap)
    {
      com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", bu.o(paramMap));
      AppMethodBeat.o(97334);
    }
  }
  
  private static List<y> b(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97335);
    ArrayList localArrayList = new ArrayList();
    String str = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0)
    {
      paramString = str;
      label48:
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label147;
      }
      if (!paramString.zRo) {
        break label113;
      }
      localArrayList.add(paramString);
    }
    for (;;)
    {
      i += 1;
      break;
      paramString = str + i;
      break label48;
      label113:
      com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "comp " + paramString.toString() + " ifCondition is false");
    }
    label147:
    AppMethodBeat.o(97335);
    return localArrayList;
  }
  
  private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q c(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97336);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q localq = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q();
    try
    {
      i = Color.parseColor((String)paramMap.get(paramString + ".bgColorTheme"));
      localq.backgroundColor = ((int)(bu.getDouble((String)paramMap.get(paramString + ".bgColorAlpha"), 0.0D) * 255.0D) << 24 | i & 0xFFFFFF);
      paramString = paramString + ".componentGroupList";
      String str = paramString + ".componentItem";
      i = 0;
      while (i == 0)
      {
        paramString = str;
        paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
        if (paramString == null) {
          break label260;
        }
        if (paramString.zRo) {
          localq.zQI.add(paramString);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "%s", new Object[] { bu.o(localException) });
        localq.backgroundColor = Color.argb(51, 0, 0, 0);
        continue;
        paramString = localException + i;
      }
      label260:
      AppMethodBeat.o(97336);
    }
    return localq;
  }
  
  private static ai d(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97337);
    ai localai = new ai();
    a(localai, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localai.zRU = bu.aSB((String)paramMap.get(paramString + ".pageCtrType"));
    boolean bool;
    String str1;
    int i;
    if (bu.aSB((String)paramMap.get(paramString + ".isFullScreen")) == 1)
    {
      bool = true;
      localai.ncj = bool;
      str1 = paramString + ".componentGroupList.componentGroup";
      i = 0;
    }
    for (;;)
    {
      label142:
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q localq;
      String str2;
      int j;
      if (i == 0)
      {
        paramString = str1;
        localq = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q();
        str2 = paramString + ".componentItem";
        j = 0;
        label176:
        if (j != 0) {
          break label256;
        }
      }
      label256:
      for (paramString = str2;; paramString = str2 + j)
      {
        paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
        if (paramString == null) {
          break label280;
        }
        if (paramString.zRo) {
          localq.zQI.add(paramString);
        }
        j += 1;
        break label176;
        bool = false;
        break;
        paramString = str1 + i;
        break label142;
      }
      label280:
      if (localq.zQI.size() == 0) {
        break label311;
      }
      localai.zQI.add(localq);
      i += 1;
    }
    label311:
    AppMethodBeat.o(97337);
    return localai;
  }
  
  private static y e(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97339);
    z localz = new z();
    localz.zRr = bu.aSB((String)paramMap.get(paramString + ".subType"));
    localz.zRf = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an.a(paramMap, paramString, paramInt1, paramInt2, paramInt3);
    a(localz, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    String str = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = str;; paramString = str + i)
    {
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label176;
      }
      if (paramString.zRo) {
        localz.zRq.add(paramString);
      }
      i += 1;
      break;
    }
    label176:
    AppMethodBeat.o(97339);
    return localz;
  }
  
  private static boolean ebG()
  {
    AppMethodBeat.i(97349);
    c localc = com.tencent.mm.model.c.d.aDI().xi("100150");
    if (localc.isValid())
    {
      int i = bu.getInt((String)localc.fsy().get("openCanvas"), 0);
      com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "canOpenGameCanvas abtest=".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(97349);
        return true;
      }
      AppMethodBeat.o(97349);
      return false;
    }
    AppMethodBeat.o(97349);
    return false;
  }
  
  private static void ebH()
  {
    AppMethodBeat.i(97354);
    if (AcX != null)
    {
      AppMethodBeat.o(97354);
      return;
    }
    AcX = new HashSet();
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    for (;;)
    {
      int k;
      try
      {
        localInputStream = com.tencent.mm.sdk.platformtools.ak.getContext().getAssets().open("sns/canvas_valid_type.xml");
        localObject2 = localInputStream;
        localObject4 = localInputStream;
        localObject1 = localInputStream;
        XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        localObject2 = localInputStream;
        localObject4 = localInputStream;
        localObject1 = localInputStream;
        localXmlPullParser.setInput(localInputStream, "UTF-8");
        localObject2 = localInputStream;
        localObject4 = localInputStream;
        localObject1 = localInputStream;
        j = localXmlPullParser.getEventType();
        k = -1;
        i = -1;
        if (j != 1)
        {
          m = i;
          if (j != 2) {
            break label706;
          }
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          Object localObject5 = localXmlPullParser.getName();
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          if ("canvastype".equals(localObject5))
          {
            i = 0;
            j = 0;
            m = i;
            if (j == -1) {
              break label706;
            }
            localObject2 = localInputStream;
            localObject4 = localInputStream;
            localObject1 = localInputStream;
            if (bu.getInt(localXmlPullParser.getAttributeValue(null, "android"), 0) != 1) {
              continue;
            }
            localObject2 = localInputStream;
            localObject4 = localInputStream;
            localObject1 = localInputStream;
            i1 = bu.getInt(localXmlPullParser.getAttributeValue(null, "val"), -1);
            continue;
            localObject2 = localInputStream;
            localObject4 = localInputStream;
            localObject1 = localInputStream;
            j = localXmlPullParser.next();
            k = n;
            i = m;
            continue;
          }
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          if ("pagetype".equals(localObject5))
          {
            i = 1;
            j = 1;
            continue;
          }
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          if ("componenttype".equals(localObject5))
          {
            i = 2;
            j = 2;
            continue;
          }
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          if (!"subtype".equals(localObject5)) {
            break label712;
          }
          j = 3;
          continue;
          m = i;
          if (i == -1) {
            break label706;
          }
          m = i;
          if (k == -1) {
            break label706;
          }
          m = i;
          if (i1 == -1) {
            break label706;
          }
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          localObject5 = new i.b((byte)0);
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((i.b)localObject5).Adc = i;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((i.b)localObject5).Add = k;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((i.b)localObject5).Ade = i1;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          AcX.add(localObject5);
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "valid canvas type ".concat(String.valueOf(localObject5)));
          m = i;
        }
      }
      catch (IOException localIOException6)
      {
        InputStream localInputStream;
        localObject1 = localObject2;
        com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", bu.o(localIOException6));
        if (localObject2 != null)
        {
          try
          {
            localObject2.close();
            AppMethodBeat.o(97354);
            return;
          }
          catch (IOException localIOException2)
          {
            AppMethodBeat.o(97354);
            return;
          }
          if (localInputStream != null) {
            try
            {
              localInputStream.close();
              AppMethodBeat.o(97354);
              return;
            }
            catch (IOException localIOException1)
            {
              AppMethodBeat.o(97354);
              return;
            }
          }
        }
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        IOException localIOException3 = localIOException6;
        com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", bu.o(localXmlPullParserException));
        if (localIOException6 != null) {
          try
          {
            localIOException6.close();
            AppMethodBeat.o(97354);
            return;
          }
          catch (IOException localIOException4)
          {
            AppMethodBeat.o(97354);
            return;
          }
        }
      }
      finally
      {
        int i;
        if (localIOException4 != null) {}
        try
        {
          localIOException4.close();
          AppMethodBeat.o(97354);
          throw localObject3;
          AppMethodBeat.o(97354);
          return;
        }
        catch (IOException localIOException5)
        {
          continue;
        }
        int i1 = -1;
        n = i1;
        int m = i;
        switch (j)
        {
        }
        m = i;
      }
      label706:
      int n = k;
      continue;
      label712:
      int j = -1;
    }
  }
  
  private static y f(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97340);
    Object localObject = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    x localx = new x();
    localx.hF = com.tencent.mm.cb.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ak.getContext(), bu.aSB((String)paramMap.get(paramString + ".cornerRadius")));
    localx.aQH = ((List)localObject);
    localx.zRf = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an.a(paramMap, paramString, paramInt1, paramInt2, paramInt3);
    a(localx, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localObject = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = (String)localObject;; paramString = (String)localObject + i)
    {
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label204;
      }
      if (paramString.zRo) {
        localx.aQH.add(paramString);
      }
      i += 1;
      break;
    }
    label204:
    AppMethodBeat.o(97340);
    return localx;
  }
  
  public static void fX(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m> paramList)
  {
    AppMethodBeat.i(97357);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(97357);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m localm = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)localIterator.next();
      if (Rk(localm.eaw().type)) {
        localArrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)localm).eaj());
      }
    }
    if (!localArrayList.isEmpty())
    {
      fX(localArrayList);
      paramList.addAll(localArrayList);
    }
    AppMethodBeat.o(97357);
  }
  
  private static y g(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97341);
    Object localObject = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    w localw = new w();
    localw.hF = com.tencent.mm.cb.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ak.getContext(), bu.aSB((String)paramMap.get(paramString + ".cornerRadius")));
    localw.zRb = bu.aSB((String)paramMap.get(paramString + ".autoShow"));
    localw.zRc = bu.aSB((String)paramMap.get(paramString + ".noAnimation"));
    localw.zRd = bu.aSB((String)paramMap.get(paramString + ".forbiddenToClose"));
    localw.zRe = bu.aSB((String)paramMap.get(paramString + ".noBackground"));
    localw.aQH = ((List)localObject);
    a(localw, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localObject = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = (String)localObject;; paramString = (String)localObject + i)
    {
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label338;
      }
      if (paramString.zRo) {
        localw.aQH.add(paramString);
      }
      i += 1;
      break;
    }
    label338:
    AppMethodBeat.o(97341);
    return localw;
  }
  
  private static com.tencent.mm.plugin.sns.ad.landingpage.component.b.a h(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(219629);
    com.tencent.mm.plugin.sns.ad.landingpage.component.b.a locala = new com.tencent.mm.plugin.sns.ad.landingpage.component.b.a();
    locala.znG = bu.bI((String)paramMap.get(paramString + ".title"), "");
    locala.znH = bu.aSB((String)paramMap.get(paramString + ".autoJump"));
    locala.znI = bu.aSB((String)paramMap.get(paramString + ".swipeJumpOffset"));
    paramMap = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramMap instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)) {
      locala.znJ = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)paramMap);
    }
    AppMethodBeat.o(219629);
    return locala;
  }
  
  private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah i(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(219630);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah localah = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah();
    a(localah, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localah.desc = bu.bI((String)paramMap.get(paramString + ".desc"), "");
    boolean bool;
    if (bu.aSB((String)paramMap.get(paramString + ".isFullClickable")) == 1) {
      bool = true;
    }
    for (;;)
    {
      localah.zRx = bool;
      try
      {
        String str1 = paramString + ".descColor";
        String str2 = paramString + ".descColorAlpha";
        localah.zRw = bu.bI((String)paramMap.get(str1), "");
        if ((paramMap.containsKey(str2)) && (localah.zRw.length() > 0)) {
          localah.zRw = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bu.aSD((String)paramMap.get(str2)) * 255.0D)), localah.zRw.substring(1) });
        }
        localah.zRB = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
        if ((localah.zRB instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localah.zRB).zPQ = true;
        }
        AppMethodBeat.o(219630);
        return localah;
        bool = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse descColor exp=" + localException.toString());
        }
      }
    }
  }
  
  public static String jQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97342);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(97342);
      return paramString1;
    }
    paramString1 = paramString1.replaceAll("\\{\\{.*?\\}\\}", paramString2);
    AppMethodBeat.o(97342);
    return paramString1;
  }
  
  public static String jR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97344);
    Object localObject2 = new String(paramString1);
    Object localObject1 = localObject2;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString2);
      localObject1 = localObject2;
      com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "the jsonObject is " + localJSONObject.toString());
      localObject1 = localObject2;
      Iterator localIterator = localJSONObject.keys();
      paramString2 = (String)localObject2;
      localObject1 = paramString2;
      localObject2 = paramString2;
      if (localIterator.hasNext())
      {
        localObject1 = paramString2;
        localObject2 = localIterator.next();
        if (localObject2 == null) {
          break label213;
        }
        localObject1 = paramString2;
        if (!(localObject2 instanceof String)) {
          break label213;
        }
        localObject1 = paramString2;
        localObject2 = (String)localObject2;
        localObject1 = paramString2;
        String str = localJSONObject.getString((String)localObject2);
        localObject1 = paramString2;
        if (bu.isNullOrNil(str)) {
          break label213;
        }
        localObject1 = paramString2;
        paramString2 = paramString2.replace("{{" + (String)localObject2 + "}}", "<![CDATA[" + str + "]]>");
      }
      for (;;)
      {
        break;
      }
    }
    catch (Exception paramString2)
    {
      com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "the json is parsed error : ".concat(String.valueOf(paramString1)));
      localObject2 = localObject1;
      AppMethodBeat.o(97344);
      return localObject2;
    }
  }
  
  public static boolean jS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97353);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(97353);
      return false;
    }
    if (AcX == null) {
      ebH();
    }
    if ((AcX != null) && (!AcX.isEmpty()))
    {
      Map localMap = bx.M(paramString1, paramString2);
      if ((localMap == null) || (localMap.isEmpty()))
      {
        com.tencent.mm.sdk.platformtools.ae.w("AdLandingPagesParseHelper", "invalid landingpages xml,".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(97353);
        return false;
      }
      i.b localb = new i.b((byte)0);
      localb.Adc = 0;
      localb.Add = bu.aSB((String)localMap.get(".adCanvasInfo.type"));
      localb.Ade = bu.aSB((String)localMap.get(".adCanvasInfo.subtype"));
      if (!AcX.contains(localb))
      {
        com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "invalid canvas type ".concat(String.valueOf(localb)));
        AppMethodBeat.o(97353);
        return false;
      }
      int i = 0;
      for (;;)
      {
        localb.Adc = 1;
        if (i == 0) {}
        for (paramString1 = ".adCanvasInfo.PageList.Page";; paramString1 = ".adCanvasInfo.PageList.Page" + i)
        {
          if (!localMap.containsKey(paramString1 + ".componentItemList.componentItem.type")) {
            break label588;
          }
          localb.Add = bu.aSB((String)localMap.get(paramString1 + ".type"));
          localb.Ade = bu.aSB((String)localMap.get(paramString1 + ".subType"));
          if (AcX.contains(localb)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "invalid page type ".concat(String.valueOf(localb)));
          AppMethodBeat.o(97353);
          return false;
        }
        paramString2 = paramString1 + ".componentItemList.componentItem";
        localb.Adc = 2;
        int j = 0;
        for (;;)
        {
          if (j == 0) {}
          for (paramString1 = paramString2;; paramString1 = paramString2 + j)
          {
            if (!localMap.containsKey(paramString1 + ".type")) {
              break label581;
            }
            localb.Add = bu.aSB((String)localMap.get(paramString1 + ".type"));
            localb.Ade = bu.aSB((String)localMap.get(paramString1 + ".subType"));
            if (AcX.contains(localb)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(localb)));
            AppMethodBeat.o(97353);
            return false;
          }
          j += 1;
        }
        label581:
        i += 1;
      }
      label588:
      localb.Adc = 2;
      paramString1 = localMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        Object localObject = (Map.Entry)paramString1.next();
        if ((((Map.Entry)localObject).getKey() != null) && (((String)((Map.Entry)localObject).getKey()).matches("[\\s\\S]*\\.componentItem[0-9]*\\.type$")))
        {
          paramString2 = (String)((Map.Entry)localObject).getKey();
          localObject = ((String)((Map.Entry)localObject).getKey()).replace(".type", ".subType");
          localb.Add = bu.aSB((String)localMap.get(paramString2));
          localb.Ade = bu.aSB((String)localMap.get(localObject));
          if (!AcX.contains(localb))
          {
            com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(localb)));
            AppMethodBeat.o(97353);
            return false;
          }
        }
      }
      AppMethodBeat.o(97353);
      return true;
    }
    AppMethodBeat.o(97353);
    return false;
  }
  
  public static String n(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(97347);
    URI localURI = new URI(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramVarArgs[i]).append("&");
      i += 1;
    }
    if (localStringBuilder.length() > 1)
    {
      paramString = localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      paramVarArgs = localURI.getQuery();
      if (paramVarArgs == null) {}
      for (paramString = paramString.toString();; paramString = paramVarArgs + "&" + paramString.toString())
      {
        paramString = new URI(localURI.getScheme(), localURI.getAuthority(), localURI.getPath(), paramString, localURI.getFragment()).toString();
        AppMethodBeat.o(97347);
        return paramString;
      }
    }
    AppMethodBeat.o(97347);
    return paramString;
  }
  
  public static String o(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(97348);
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    paramVarArgs = TextUtils.join("&", paramVarArgs);
    paramString = "?";
    if (str1.contains("?")) {
      paramString = "&";
    }
    if (str1.contains("#")) {
      try
      {
        int i = str1.indexOf("#");
        String str2 = str1.substring(0, i);
        String str3 = str1.substring(i + 1);
        paramString = str2 + paramString + paramVarArgs + str3;
        AppMethodBeat.o(97348);
        return paramString;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", "append url params failed, %s", new Object[] { paramString.toString() });
        AppMethodBeat.o(97348);
        return str1;
      }
    }
    paramString = str1 + paramString + paramVarArgs;
    AppMethodBeat.o(97348);
    return paramString;
  }
  
  private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e y(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(219628);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e locale = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e();
    locale.zPX = bu.bI((String)paramMap.get(paramString + ".webViewUrl"), "");
    locale.zPZ = bu.aSB((String)paramMap.get(paramString + ".webViewHeight"));
    locale.zPY = bu.aSB((String)paramMap.get(paramString + ".webViewWidth"));
    locale.zQa = bu.aSB((String)paramMap.get(paramString + ".hideWebViewProgress"));
    AppMethodBeat.o(219628);
    return locale;
  }
  
  public static boolean z(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(97350);
    String str2 = paramIntent.getStringExtra("sns_landing_pages_xml");
    String str1;
    boolean bool2;
    boolean bool1;
    if (!TextUtils.isEmpty(str2)) {
      if ((!TextUtils.isEmpty(str2)) && (jS(str2, "adCanvasInfo")))
      {
        str1 = "";
        bool2 = aBl(str2);
        if (!bool2) {
          break label284;
        }
        str1 = com.tencent.mm.model.c.d.aDJ().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
        if (!TextUtils.isEmpty(str1))
        {
          int i = com.tencent.mm.model.c.d.aDJ().gv("Sns_Canvas_GameShare_JumpWay", 0);
          com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "abtestvalue = ".concat(String.valueOf(i)));
          if (i == 0) {
            bool1 = false;
          }
        }
      }
    }
    for (;;)
    {
      if (bool1)
      {
        paramIntent = new Intent(paramIntent);
        paramIntent.setClass(paramContext, SnsAdNativeLandingPagesUI.class);
        paramIntent.putExtra("sns_landing_pages_expid", str1);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahE(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(97350);
        return true;
        bool1 = true;
        continue;
        bool1 = ebG();
      }
      else
      {
        bool1 = a(str2, paramContext, bool2, paramIntent.getIntExtra("sns_landig_pages_from_source", -1));
        AppMethodBeat.o(97350);
        return bool1;
        com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str2 });
        AppMethodBeat.o(97350);
        return false;
        label284:
        bool1 = true;
      }
    }
  }
  
  public static final class a
  {
    public LinkedList<g> AcY;
    public ac AcZ;
    public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e Ada;
    public com.tencent.mm.plugin.sns.ad.landingpage.component.b.a Adb;
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97329);
      this.AcY = new LinkedList();
      this.AcZ = null;
      this.Ada = null;
      this.Adb = null;
      long l = System.currentTimeMillis();
      jT(paramString1, paramString2);
      com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "parse adlanding xml, timeCost=" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(97329);
    }
    
    private void jT(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97330);
      if (TextUtils.isEmpty(paramString1))
      {
        AppMethodBeat.o(97330);
        return;
      }
      paramString1 = i.jQ(paramString1, "");
      Map localMap = bx.M(paramString1, paramString2);
      if (localMap == null)
      {
        com.tencent.mm.sdk.platformtools.ae.w("AdLandingPagesParseHelper", " parse landingpages xml is error ,".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(97330);
        return;
      }
      int i1 = bu.aSB((String)localMap.get("." + paramString2 + ".adCanvasInfo.sizeType"));
      int j = bu.aSB((String)localMap.get("." + paramString2 + ".adCanvasInfo.basicRootFontSize"));
      int k = bu.aSB((String)localMap.get("." + paramString2 + ".adCanvasInfo.basicWidth"));
      int i = j;
      if (j == 0)
      {
        i = j;
        if (i1 == 1) {
          i = i.AcW;
        }
      }
      j = k;
      if (k == 0)
      {
        j = k;
        if (i1 == 1) {
          j = i.AcV;
        }
      }
      if ((!bu.isNullOrNil(paramString2)) && (!".adCanvasInfo.PageList.Page".equals("adCanvasInfo"))) {}
      for (paramString1 = "." + paramString2 + ".adCanvasInfo.PageList.Page";; paramString1 = ".adCanvasInfo.PageList.Page")
      {
        k = 0;
        label388:
        Object localObject2;
        for (;;)
        {
          g localg;
          boolean bool;
          label456:
          label463:
          String str;
          int m;
          if (k == 0)
          {
            localObject1 = paramString1;
            localg = new g();
            localg.AcO = bu.bI((String)localMap.get((String)localObject1 + ".backgroundCover"), "");
            localg.jZm = bu.bI((String)localMap.get((String)localObject1 + ".backgroundColor"), "");
            if (bu.aSB((String)localMap.get((String)localObject1 + ".backgroundCover.$isAddBlur")) <= 0) {
              break label628;
            }
            bool = true;
            localg.AcP = bool;
            localg.id = k;
            localObject2 = (String)localObject1 + ".if";
            if (!localMap.containsKey(localObject2)) {
              break label640;
            }
            if (!"1".equals(localMap.get(localObject2))) {
              break label634;
            }
            bool = true;
            localg.AcS = bool;
            if (!localg.AcS) {
              break label884;
            }
            str = (String)localObject1 + ".componentItemList.componentItem";
            m = 0;
            label496:
            if (m != 0) {
              break label649;
            }
            localObject2 = str;
          }
          for (;;)
          {
            try
            {
              if (TextUtils.isEmpty(localg.jZm)) {
                continue;
              }
              n = Color.parseColor(localg.jZm);
              localy1 = i.b(localMap, i1, j, i, n, (String)localObject2);
            }
            catch (Exception localException2)
            {
              int n;
              y localy1;
              label628:
              label634:
              com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", bu.o(localException2));
              label640:
              label649:
              y localy2 = i.b(localMap, i1, j, i, 0, (String)localObject2);
              continue;
              localg.AcQ.add(localy2);
              continue;
              com.tencent.mm.sdk.platformtools.ae.i("AdLandingPagesParseHelper", "comp " + localy2.toString() + " ifCondition is false");
              continue;
              localObject2 = (String)localObject1 + ".forbiddenGlobalItems.id";
              m = 0;
              if (m != 0) {
                continue;
              }
              localObject1 = localObject2;
              localObject1 = bu.bI((String)localMap.get(localObject1), "");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              localg.AcT.add(localObject1);
              m += 1;
              continue;
              localObject1 = (String)localObject2 + m;
              continue;
              if (localg.AcQ.size() == 0) {
                break label893;
              }
            }
            if (localy1 == null) {
              continue;
            }
            if (!localy1.zRo) {
              continue;
            }
            i.b(localy1, localMap, (String)localObject2, i1, j, i);
            if (!(localy1 instanceof w)) {
              continue;
            }
            localg.AcR.put(localy1.zRg, localy1);
            m += 1;
            break label496;
            localObject1 = paramString1 + k;
            break;
            bool = false;
            break label388;
            bool = false;
            break label456;
            localg.AcS = true;
            break label463;
            localObject2 = str + m;
            continue;
            n = 0;
          }
          this.AcY.add(localg);
          label884:
          k += 1;
        }
        label893:
        if ((this.AcY != null) && (this.AcY.size() > 0)) {
          ((g)this.AcY.get(0)).uej = true;
        }
        Object localObject1 = "." + paramString2 + ".adCanvasInfo.globalComponentItems.componentItem";
        k = 0;
        label1186:
        label1201:
        label1216:
        for (;;)
        {
          if (k == 0) {}
          for (paramString1 = (String)localObject1;; paramString1 = (String)localObject1 + k)
          {
            paramString2 = null;
            try
            {
              localObject2 = i.b(localMap, i1, j, i, 0, paramString1);
              paramString2 = (String)localObject2;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ae.e("AdLandingPagesParseHelper", bu.o(localException1));
              }
              com.tencent.mm.sdk.platformtools.ae.d("AdLandingPagesParseHelper", "parse the item: the global item existed, globalItemsStr = ".concat(String.valueOf(paramString1)));
              if (!(paramString2 instanceof ac)) {
                break label1186;
              }
              this.AcZ = ((ac)paramString2);
              if (!(paramString2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)) {
                break label1201;
              }
              this.Ada = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)paramString2);
              if (!(paramString2 instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)) {
                break label1216;
              }
              this.Adb = ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)paramString2);
              k += 1;
            }
            if (paramString2 != null) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ae.d("AdLandingPagesParseHelper", "parse the item: the global item is null, globalItemsStr = ".concat(String.valueOf(paramString1)));
            if (this.AcZ == null) {
              break label1225;
            }
            paramString1 = this.AcY.iterator();
            for (;;)
            {
              if (!paramString1.hasNext()) {
                break label1225;
              }
              paramString2 = (g)paramString1.next();
              if (paramString2.AcT.size() > 0)
              {
                localObject1 = paramString2.AcT.iterator();
                if (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (String)((Iterator)localObject1).next();
                  if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(this.AcZ.zRg)) || (!((String)localObject2).equals(this.AcZ.zRg))) {
                    break;
                  }
                  paramString2.AcU = true;
                }
              }
            }
          }
        }
        label1225:
        AppMethodBeat.o(97330);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i
 * JD-Core Version:    0.7.0.1
 */