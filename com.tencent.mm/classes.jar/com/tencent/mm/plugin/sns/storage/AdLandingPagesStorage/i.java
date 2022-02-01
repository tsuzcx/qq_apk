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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
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
import com.tencent.mm.plugin.sns.storage.b.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
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
  public static int zLO = 750;
  public static int zLP = 10;
  private static Set<i.b> zLQ = null;
  
  private static String E(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(97356);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "the adLandingPagesXml is empty");
      AppMethodBeat.o(97356);
      return null;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
      AppMethodBeat.o(97356);
      return null;
    }
    LinkedList localLinkedList = new a(paramString, "adxml").zLR;
    Iterator localIterator1 = paramMap.keySet().iterator();
    String str1 = paramString;
    String str3;
    String str2;
    Iterator localIterator2;
    while (localIterator1.hasNext())
    {
      str3 = (String)localIterator1.next();
      if (!bt.isNullOrNil(str3))
      {
        str2 = (String)paramMap.get(str3);
        if (!bt.isNullOrNil(str2))
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
        Iterator localIterator3 = ((g)localIterator2.next()).zLJ.iterator();
        while (localIterator3.hasNext())
        {
          x localx = (x)localIterator3.next();
          if (((localx instanceof f)) && (!bt.isNullOrNil(((f)localx).oyC)) && (((f)localx).oyC.equals(str3)))
          {
            paramString = ((f)localx).ozz;
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
          if (bt.isNullOrNil(paramString)) {
            break label333;
          }
          com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "old card ext is " + paramString + " and new card ext is " + str2);
          str1 = str1.replace(paramString, str2);
          try
          {
            paramString = str1.replace(bt.aRc(paramString), bt.aRc(str2));
            str1 = paramString;
          }
          catch (Exception paramString)
          {
            com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "the xml is error");
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
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "the snsinfo is null");
      AppMethodBeat.o(97355);
      return null;
    }
    if (!paramp.QM(32))
    {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "the snsinfo is not a ad");
      AppMethodBeat.o(97355);
      return null;
    }
    com.tencent.mm.plugin.sns.storage.e locale = paramp.dYU();
    if (locale == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "the adSnsInfo is null");
      AppMethodBeat.o(97355);
      return null;
    }
    com.tencent.mm.plugin.sns.storage.b localb = paramp.dRL();
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "the adxml is null");
      AppMethodBeat.o(97355);
      return null;
    }
    paramp = paramp.dRK();
    if (paramp == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "the adInfo is null");
      AppMethodBeat.o(97355);
      return null;
    }
    if (!localb.dVU())
    {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "the snsinfo is not a landingpage");
      AppMethodBeat.o(97355);
      return null;
    }
    if ((paramp.zuR == null) || (paramp.zuR.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
      AppMethodBeat.o(97355);
      return null;
    }
    paramp = E(locale.field_adxml, paramp.zuR);
    AppMethodBeat.o(97355);
    return paramp;
  }
  
  public static boolean QD(int paramInt)
  {
    return (paramInt == 101) || (paramInt == 103) || (paramInt == 104) || (paramInt == 105);
  }
  
  public static boolean QE(int paramInt)
  {
    return paramInt == 101;
  }
  
  public static boolean QF(int paramInt)
  {
    return paramInt == 103;
  }
  
  public static boolean QG(int paramInt)
  {
    return paramInt == 104;
  }
  
  public static boolean QH(int paramInt)
  {
    return paramInt == 105;
  }
  
  private static boolean QI(int paramInt)
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
    int[] arrayOfInt = am.gk(com.tencent.mm.sdk.platformtools.aj.getContext());
    paramInt1 = Math.min(arrayOfInt[0], arrayOfInt[1]);
    float f1 = (float)paramDouble;
    float f2 = paramInt3;
    f1 = am.bC(paramInt1 * (f1 * f2) / paramInt2);
    AppMethodBeat.o(97332);
    return f1;
  }
  
  private static al a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(97334);
    localal = new al();
    try
    {
      paramString = paramString + ".radarChart";
      localal.zAX = ((String)paramMap.get(paramString + ".borderImg"));
      localal.zBd = ((String)paramMap.get(paramString + ".maskImg"));
      localal.zAY = ((String)paramMap.get(paramString + ".coverColor"));
      localal.zAZ = Color.parseColor((String)paramMap.get(paramString + ".labelFont.$color"));
      localal.zBa = ((int)a(bt.aRg((String)paramMap.get(paramString + ".labelFont.$size")), paramInt1, paramInt2, paramInt3));
      localal.zBb = Color.parseColor((String)paramMap.get(paramString + ".scoreFont.$color"));
      localal.zBc = ((int)a(bt.aRg((String)paramMap.get(paramString + ".scoreFont.$size")), paramInt1, paramInt2, paramInt3));
      localal.borderWidth = a(bt.aRg((String)paramMap.get(paramString + ".borderImgWidth")), paramInt1, paramInt2, paramInt3);
      String str = paramString + ".itemList.item";
      paramInt1 = 0;
      if (paramInt1 != 0) {}
      for (paramString = str + paramInt1;; paramString = str)
      {
        al.a locala = new al.a();
        locala.label = ((String)paramMap.get(paramString + ".label"));
        locala.zBe = ((String)paramMap.get(paramString + ".score"));
        locala.value = ((float)bt.aRg((String)paramMap.get(paramString + ".value")));
        if ((TextUtils.isEmpty(locala.label)) && (TextUtils.isEmpty(locala.zBe))) {
          break label564;
        }
        localal.iAP.add(locala);
        paramInt1 += 1;
        break;
      }
      label564:
      return localal;
    }
    catch (Exception paramMap)
    {
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", bt.n(paramMap));
      AppMethodBeat.o(97334);
    }
  }
  
  private static x a(Map<String, String> paramMap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(97343);
    int i = bt.aRe((String)paramMap.get(paramString + ".type"));
    x localx = null;
    if (!QD(i)) {}
    for (;;)
    {
      try
      {
        localx = a(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
        paramMap = localx;
      }
      catch (Exception localException)
      {
        paramMap = a(paramMap, paramString, paramInt1, paramInt2, paramInt3, 0);
        continue;
      }
      AppMethodBeat.o(97343);
      return paramMap;
      if (QE(i))
      {
        paramMap = d(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (QF(i))
      {
        paramMap = e(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (QG(i))
      {
        paramMap = f(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (QH(i))
      {
        paramMap = g(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "the type" + i + " is not client known type");
        paramMap = localException;
      }
    }
  }
  
  private static x a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97333);
    int k = bt.aRe((String)paramMap.get(paramString + ".type"));
    int m = bt.aRe((String)paramMap.get(paramString + ".subType"));
    Object localObject1;
    switch (k)
    {
    default: 
      AppMethodBeat.o(97333);
      return null;
    case 82: 
      localObject1 = new ak();
      ((ak)localObject1).url = bt.bI((String)paramMap.get(paramString + ".webviewUrl"), "");
      ((ak)localObject1).zzN = bt.bI((String)paramMap.get(paramString + ".qrExtInfo"), "");
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((x)localObject1).zAk = QI(paramInt4);
        ((x)localObject1).type = k;
        ((x)localObject1).subType = m;
        a((x)localObject1, paramMap, paramString, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(97333);
      return localObject1;
      localObject1 = c(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad();
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).zAh = k;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).subType = m;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).zAI = bt.bI((String)paramMap.get(paramString + ".content"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).textAlignment = bt.aRe((String)paramMap.get(paramString + ".textAlignment"));
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).vRt = bt.bI((String)paramMap.get(paramString + ".fontColor"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).textSize = a(bt.aRg((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
      if ((bt.aRe((String)paramMap.get(paramString + ".showType")) & com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad.zAD) > 0)
      {
        bool = true;
        label628:
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).zAJ = bool;
        if ((bt.aRe((String)paramMap.get(paramString + ".showType")) & com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad.zAE) <= 0) {
          break label853;
        }
        bool = true;
        label677:
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).zAK = bool;
        if ((bt.aRe((String)paramMap.get(paramString + ".showType")) & com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad.zAF) <= 0) {
          break label859;
        }
      }
      label853:
      label859:
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).zAL = bool;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).maxLines = bt.aRe((String)paramMap.get(paramString + ".maxLines"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).zyX = bt.aRe((String)paramMap.get(paramString + ".fontType"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localObject1).zAM = bt.aRh((String)paramMap.get(paramString + ".lineSpace"));
        break;
        bool = false;
        break label628;
        bool = false;
        break label677;
      }
      label987:
      Object localObject2;
      if (m == 2)
      {
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).duW = ((String)paramMap.get(paramString + ".appid"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyb = ((String)paramMap.get(paramString + ".wxAppid"));
        if (bt.aRe((String)paramMap.get(paramString + ".useGameDownloadWidget")) == 1)
        {
          bool = true;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyc = bool;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zve = ((String)paramMap.get(paramString + ".appPageUrlAndroid"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).channelId = ((String)paramMap.get(paramString + ".channelId"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).Lw = ((String)paramMap.get(paramString + ".pkg"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyf = bt.aRe((String)paramMap.get(paramString + ".platform"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyg = ((String)paramMap.get(paramString + ".warningAndroid"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyh = ((String)paramMap.get(paramString + ".btnBgColorTheme"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyj = ((String)paramMap.get(paramString + ".btnBgColorThemePressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyi = ((String)paramMap.get(paramString + ".btnBgColorThemeDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyk = ((String)paramMap.get(paramString + ".btnBorderColorTheme"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zym = ((String)paramMap.get(paramString + ".btnBorderColorThemePressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyl = ((String)paramMap.get(paramString + ".btnBorderColorThemeDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyn = ((String)paramMap.get(paramString + ".fontColor"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyp = ((String)paramMap.get(paramString + ".fontColorPressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyo = ((String)paramMap.get(paramString + ".fontColorDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zys = bt.aRe((String)paramMap.get(paramString + ".showDownloadTip"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyt = bt.aRe((String)paramMap.get(paramString + ".marketFlag"));
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyt > 0)
          {
            localObject2 = aN(paramMap);
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).zyu = ((Intent)localObject2);
            }
          }
        }
      }
      Object localObject3;
      for (;;)
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zAh = k;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).subType = m;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).title = bt.bI((String)paramMap.get(paramString + ".btnTitle"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zyS = bt.aRe((String)paramMap.get(paramString + ".btnType"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zyT = bt.bI((String)paramMap.get(paramString + ".btnJumpUrl"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zyU = bt.bI((String)paramMap.get(paramString + ".btnJumpApp"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zyV = bt.bI((String)paramMap.get(paramString + ".fontColor"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).fontSize = a(bt.aRg((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zyX = bt.aRe((String)paramMap.get(paramString + ".btnFontType"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).textAlignment = bt.aRe((String)paramMap.get(paramString + ".btnAlignment"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zyW = a(bt.aRg((String)paramMap.get(paramString + ".borderSize")), paramInt1, paramInt2, paramInt3);
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).height = a(bt.aRg((String)paramMap.get(paramString + ".btnHeight")), paramInt1, paramInt2, paramInt3);
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zyY = bt.bI((String)paramMap.get(paramString + ".btnBgColorTheme"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zyZ = bt.bI((String)paramMap.get(paramString + ".btnBorderColorTheme"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzA = bt.bI((String)paramMap.get(paramString + ".btnBgImgUrl"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzB = bt.aRe((String)paramMap.get(paramString + ".bCanLongPress"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzC = bt.aRe((String)paramMap.get(paramString + ".bHideActionSheet"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzD = bt.aRe((String)paramMap.get(paramString + ".hideProductActionHeader"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzE = bt.aRe((String)paramMap.get(paramString + ".showProductActionCancelButton"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzG = bt.bI((String)paramMap.get(paramString + ".productActionTitle"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzF = bt.bI((String)paramMap.get(paramString + ".productActionBuffer"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzH = bt.bI((String)paramMap.get(paramString + ".productActionIconUrl"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).tm = a(bt.aRe((String)paramMap.get(paramString + ".cornerRadius")), paramInt1, paramInt2, paramInt3);
        if (paramMap.containsKey(paramString + ".productActionItem.componentItem.type")) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzI = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString + ".productActionItem.componentItem");
        }
        break;
        bool = false;
        break label987;
        if (m == 4)
        {
          localObject1 = new f();
          ((f)localObject1).oyC = bt.bI((String)paramMap.get(paramString + ".cardTpId"), "");
          ((f)localObject1).ozz = bt.bI((String)paramMap.get(paramString + ".cardExt"), "");
        }
        else if (m == 7)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject1).zyG = bt.bI((String)paramMap.get(paramString + ".jumpCanvasId"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject1).zyH = bt.bI((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject1).zyI = bt.aRe((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject1).zyJ = bt.aRe((String)paramMap.get(paramString + ".btnCanvasEnterType"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject1).zyK = bt.aRe((String)paramMap.get(paramString + ".btnCanvasSource"));
        }
        else if (m == 8)
        {
          localObject1 = new k();
          ((k)localObject1).username = ((String)paramMap.get(paramString + ".weappUserName"));
          ((k)localObject1).dJH = ((String)paramMap.get(paramString + ".weappPath"));
        }
        else if (m == 9)
        {
          d1 = bt.aRg((String)paramMap.get(paramString + ".location.$x"));
          d2 = bt.aRg((String)paramMap.get(paramString + ".location.$y"));
          i = bt.aRe((String)paramMap.get(paramString + ".location.$scale"));
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
              break label3235;
            }
            ((List)localObject3).add(localObject1);
            i += 1;
            break;
          }
          label3235:
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
          localObject1 = new m();
          ((m)localObject1).pLS = ((String)paramMap.get(paramString + ".weappUserName"));
          ((m)localObject1).zyL = ((String)paramMap.get(paramString + ".weAppID"));
          ((m)localObject1).kJY = ((String)paramMap.get(paramString + ".businessId"));
          ((m)localObject1).kJP = ((String)paramMap.get(paramString + ".sessionFrom"));
          ((m)localObject1).zyM = bt.aRe((String)paramMap.get(paramString + ".showMessageCard"));
          ((m)localObject1).kJZ = bt.nullAsNil((String)paramMap.get(paramString + ".sendMessageTitle"));
          ((m)localObject1).kKb = bt.nullAsNil((String)paramMap.get(paramString + ".sendMessageImg"));
          ((m)localObject1).kKa = bt.nullAsNil((String)paramMap.get(paramString + ".sendMessagePath"));
        }
        else if (m == 13)
        {
          localObject1 = new n();
          ((n)localObject1).zyN = bt.aRe((String)paramMap.get(paramString + ".sid"));
          ((n)localObject1).zyO = bt.aRe((String)paramMap.get(paramString + ".compid"));
        }
        else if (m == 14)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).zyC = bt.nullAsNil((String)paramMap.get(paramString + ".redEnvelopsSkinBtnDisableWording"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).zyD = bt.aRf(paramString + ".redEnvelopsSkinDisableTime");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).dvR = bt.nullAsNil((String)paramMap.get(paramString + ".redEnvelopesSkinId"));
        }
        else if (m == 15)
        {
          localObject1 = new z();
          ((z)localObject1).zAs = bt.bI((String)paramMap.get(paramString + ".qrUrl"), "");
          ((z)localObject1).zzN = bt.bI((String)paramMap.get(paramString + ".qrExtInfo"), "");
          ((z)localObject1).zAt = bt.aRe((String)paramMap.get(paramString + ".needUpdateQrUrl"));
        }
        else if (m == 16)
        {
          localObject1 = new aa();
          ((aa)localObject1).zAu = b.a.t(paramMap, ".adxml.adScanInfo");
        }
        else
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p();
        }
      }
      localObject1 = new s();
      ((s)localObject1).zAh = k;
      ((s)localObject1).subType = m;
      ((s)localObject1).zzL = bt.bI((String)paramMap.get(paramString + ".pureImageUrl"), "");
      ((s)localObject1).zxx = bt.bI((String)paramMap.get(paramString + ".bgColor"), "");
      if ((paramMap.containsKey(paramString + ".bgColorAlpha")) && (((s)localObject1).zxx.length() > 0)) {
        ((s)localObject1).zxx = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bt.aRg((String)paramMap.get(paramString + ".bgColorAlpha")) * 255.0D)), ((s)localObject1).zxx.substring(1) });
      }
      ((s)localObject1).width = a(bt.aRg((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((s)localObject1).height = a(bt.aRg((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      ((s)localObject1).zzK = false;
      if (bt.aRe((String)paramMap.get(paramString + ".enableQRScan")) == 1) {}
      for (bool = true;; bool = false)
      {
        ((s)localObject1).zzM = bool;
        ((s)localObject1).zzN = bt.bI((String)paramMap.get(paramString + ".qrExtInfo"), "");
        break;
      }
      localObject1 = new r();
      ((r)localObject1).zAh = k;
      ((r)localObject1).subType = m;
      ((r)localObject1).zzL = bt.bI((String)paramMap.get(paramString + ".panoramaImageUrl"), "");
      ((r)localObject1).width = a(bt.aRg((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((r)localObject1).height = a(bt.aRg((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      continue;
      localObject1 = new s();
      ((s)localObject1).zAh = k;
      ((s)localObject1).subType = m;
      ((s)localObject1).zzL = bt.bI((String)paramMap.get(paramString + ".fullScreenImageUrl"), "");
      ((s)localObject1).zzK = true;
      if (bt.aRe((String)paramMap.get(paramString + ".enableQRScan")) == 1) {}
      for (bool = true;; bool = false)
      {
        ((s)localObject1).zzM = bool;
        break;
      }
      localObject1 = new u();
      ((u)localObject1).zAh = k;
      ((u)localObject1).subType = m;
      ((u)localObject1).zzQ = bt.bI((String)paramMap.get(paramString + ".sightVideoUrl"), "");
      ((u)localObject1).zzR = bt.bI((String)paramMap.get(paramString + ".sightThumbUrl"), "");
      ((u)localObject1).zzS = bt.bI((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((u)localObject1).zzT = bt.bI((String)paramMap.get(paramString + ".jumpText"), "");
      ((u)localObject1).zyG = bt.bI((String)paramMap.get(paramString + ".jumpCanvasId"), "");
      ((u)localObject1).zyH = bt.bI((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
      ((u)localObject1).zyI = bt.aRe((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
      try
      {
        ((u)localObject1).zzU = Color.parseColor((String)paramMap.get(paramString + ".jumpTextColor"));
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((u)localObject1).zzV = Color.parseColor((String)paramMap.get(paramString + ".separatorColor"));
            ((u)localObject1).width = a(bt.aRg((String)paramMap.get(paramString + ".sightDisplayWidth")), paramInt1, paramInt2, paramInt3);
            ((u)localObject1).height = a(bt.aRg((String)paramMap.get(paramString + ".sightDisplayHeight")), paramInt1, paramInt2, paramInt3);
            ((u)localObject1).zzW = bt.aRe((String)paramMap.get(paramString + ".sightDisplayType"));
            localObject2 = bt.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
            i = bt.aRe((String)paramMap.get(paramString + ".floatStartTime"));
            if ((!bt.isNullOrNil((String)localObject2)) && (i > 0))
            {
              localObject3 = new af();
              ((af)localObject3).dCk = ((String)localObject2);
              ((af)localObject3).zAT = i;
              ((u)localObject1).zzX = ((af)localObject3);
            }
            if (bt.aRe((String)paramMap.get(".adxml.adCanvasInfo.heightRoundingType")) <= 0) {
              break label5445;
            }
            bool = true;
            ((u)localObject1).zzY = bool;
            if (bt.aRe((String)paramMap.get(paramString + ".downloadVideoByCdn")) <= 0) {
              break label5451;
            }
            bool = true;
            ((u)localObject1).zzZ = bool;
            ((u)localObject1).zAb = i(paramMap, paramString + ".floatBarComponentItem", paramInt1, paramInt2, paramInt3, paramInt4);
            ((u)localObject1).zAa = bt.aRf((String)paramMap.get(paramString + ".fileSize"));
            break;
            localException1 = localException1;
            ((u)localObject1).zzU = Color.rgb(255, 255, 255);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ((u)localObject1).zzV = Color.rgb(255, 255, 255);
            continue;
            label5445:
            bool = false;
            continue;
            label5451:
            bool = false;
          }
        }
      }
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj();
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).zAh = k;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).subType = m;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).zzS = bt.bI((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).zAV = bt.bI((String)paramMap.get(paramString + ".streamVideoThumb"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).width = a(bt.aRg((String)paramMap.get(paramString + ".streamDisplayWidth")), paramInt1, paramInt2, paramInt3);
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).height = a(bt.aRg((String)paramMap.get(paramString + ".streamDisplayHeight")), paramInt1, paramInt2, paramInt3);
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).zAW = bt.aRe((String)paramMap.get(paramString + ".streamDisplayType"));
      String str1 = bt.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
      int i = bt.aRe((String)paramMap.get(paramString + ".floatStartTime"));
      if ((!bt.isNullOrNil(str1)) && (i > 0))
      {
        localObject3 = new af();
        ((af)localObject3).dCk = str1;
        ((af)localObject3).zAT = i;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).zzX = ((af)localObject3);
      }
      if (bt.aRe((String)paramMap.get(".adxml.adCanvasInfo.heightRoundingType")) > 0) {}
      for (bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).zzY = bool;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject1).zAb = i(paramMap, paramString + ".floatBarComponentItem", paramInt1, paramInt2, paramInt3, paramInt4);
        break;
      }
      localObject1 = new ai();
      ((ai)localObject1).zAh = k;
      ((ai)localObject1).subType = m;
      ((ai)localObject1).usV = bt.bI((String)paramMap.get(paramString + ".webviewUrl"), "");
      continue;
      double d1 = a(bt.aRg((String)paramMap.get(paramString + ".topLineSize")), paramInt1, paramInt2, paramInt3);
      double d2 = a(bt.aRg((String)paramMap.get(paramString + ".bottomLineSize")), paramInt1, paramInt2, paramInt3);
      if (QI(paramInt4)) {
        i = Color.argb(51, 0, 0, 0);
      }
      int j;
      for (;;)
      {
        if (k == 121)
        {
          double d3 = bt.aRg((String)paramMap.get(paramString + ".location.$x"));
          double d4 = bt.aRg((String)paramMap.get(paramString + ".location.$y"));
          j = bt.aRe((String)paramMap.get(paramString + ".location.$scale"));
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
            break label6405;
          }
          ((List)localObject3).add(localObject1);
          j += 1;
          break;
        }
        label6405:
        if (!((List)localObject3).isEmpty())
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d(d1, d2, i, (List)localObject3);
        }
        else
        {
          AppMethodBeat.o(97333);
          return null;
          localObject1 = new ac();
          ((ac)localObject1).zAh = k;
          ((ac)localObject1).subType = m;
          ((ac)localObject1).label = bt.bI((String)paramMap.get(paramString + ".label"), "");
          ((ac)localObject1).value = ((float)bt.aRg((String)paramMap.get(paramString + ".value")));
          ((ac)localObject1).zAC = bt.bI((String)paramMap.get(paramString + ".foregroundImage"), "");
          ((ac)localObject1).fontSize = a(bt.aRg((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
          ((ac)localObject1).jVX = bt.bI((String)paramMap.get(paramString + ".backgroundColor"), "");
          continue;
          localObject1 = a(paramMap, paramString, paramInt1, paramInt2, paramInt3);
          continue;
          localObject1 = new t();
          ((t)localObject1).zxw = bt.bI((String)paramMap.get(paramString + ".sphereThumbUrl"), "");
          ((t)localObject1).zxf = bt.aRe((String)paramMap.get(paramString + ".displayType"));
          ((t)localObject1).zxu = bt.aRe((String)paramMap.get(paramString + ".gestureDelayTime"));
          ((t)localObject1).zxv = bt.bI((String)paramMap.get(paramString + ".sphereImageUrl"), "");
          try
          {
            ((t)localObject1).zxx = bt.bI((String)paramMap.get(paramString + ".bgColor"), "");
            if ((paramMap.containsKey(paramString + ".bgColorAlpha")) && (((t)localObject1).zxx.length() > 0)) {
              ((t)localObject1).zxx = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bt.aRg((String)paramMap.get(paramString + ".bgColorAlpha")) * 255.0D)), ((t)localObject1).zxx.substring(1) });
            }
          }
          catch (Exception localException3)
          {
            try
            {
              for (;;)
              {
                ((t)localObject1).width = a(bt.aRg((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
                ((t)localObject1).height = a(bt.aRg((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
                ((t)localObject1).zzO = bt.bI((String)paramMap.get(".adxml.adSphereCardInfo.sphereImageUrl"), "");
                ((t)localObject1).zzP = bt.bI((String)paramMap.get(".adxml.adSphereCardInfo.sphereThumbUrl"), "");
                break;
                localException3 = localException3;
                com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse color exp=" + localException3.toString());
              }
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                ((t)localObject1).width = 0.0F;
                ((t)localObject1).height = 0.0F;
                com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse size exp=" + localException4.toString());
              }
            }
          }
          localObject1 = new ab();
          ((ab)localObject1).zAv = bt.bI((String)paramMap.get(paramString + ".backgroundImg"), "");
          ((ab)localObject1).iconUrl = bt.bI((String)paramMap.get(paramString + ".iconUrl"), "");
          ((ab)localObject1).title = bt.bI((String)paramMap.get(paramString + ".title"), "");
          ((ab)localObject1).desc = bt.bI((String)paramMap.get(paramString + ".desc"), "");
          ((ab)localObject1).zAA = bt.aRe((String)paramMap.get(paramString + ".onlyShowInTimelineAd"));
          if (bt.aRe((String)paramMap.get(paramString + ".isFullClickable")) == 1)
          {
            bool = true;
            label7454:
            ((ab)localObject1).zAx = bool;
            ((ab)localObject1).zAy = ((int)a(bt.aRg((String)paramMap.get(paramString + ".appearPaddingTop")), paramInt1, paramInt2, paramInt3));
            ((ab)localObject1).zAz = ((int)a(bt.aRg((String)paramMap.get(paramString + ".appearPaddingBottom")), paramInt1, paramInt2, paramInt3));
          }
          try
          {
            str2 = paramString + ".backgroundColor";
            localObject3 = paramString + ".backgroundColorAlpha";
            ((ab)localObject1).jVX = bt.bI((String)paramMap.get(str2), "");
            if ((paramMap.containsKey(localObject3)) && (((ab)localObject1).jVX.length() > 0)) {
              ((ab)localObject1).jVX = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bt.aRg((String)paramMap.get(localObject3)) * 255.0D)), ((ab)localObject1).jVX.substring(1) });
            }
          }
          catch (Exception localException6)
          {
            try
            {
              str2 = paramString + ".titleColor";
              localObject3 = paramString + ".titleColorAlpha";
              ((ab)localObject1).titleColor = bt.bI((String)paramMap.get(str2), "");
              if ((paramMap.containsKey(localObject3)) && (((ab)localObject1).titleColor.length() > 0)) {
                ((ab)localObject1).titleColor = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bt.aRg((String)paramMap.get(localObject3)) * 255.0D)), ((ab)localObject1).titleColor.substring(1) });
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
                  ((ab)localObject1).zAw = bt.bI((String)paramMap.get(str2), "");
                  if ((paramMap.containsKey(localObject3)) && (((ab)localObject1).zAw.length() > 0)) {
                    ((ab)localObject1).zAw = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bt.aRg((String)paramMap.get(localObject3)) * 255.0D)), ((ab)localObject1).zAw.substring(1) });
                  }
                  ((ab)localObject1).zAB = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
                  if (!(((ab)localObject1).zAB instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)) {
                    break label8286;
                  }
                  ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)((ab)localObject1).zAB).zyr = true;
                  break;
                  bool = false;
                  break label7454;
                  localException5 = localException5;
                  com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse backgroundColor exp=" + localException5.toString());
                  continue;
                  localException6 = localException6;
                  com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse titleColor exp=" + localException6.toString());
                }
              }
              catch (Exception localException7)
              {
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse descColor exp=" + localException7.toString());
                }
              }
            }
          }
          localObject1 = x(paramMap, paramString);
          continue;
          localObject1 = new o();
          ((o)localObject1).zyQ = bt.bI((String)paramMap.get(paramString + ".swipeText"), "");
          ((o)localObject1).zyR = bt.aRe((String)paramMap.get(paramString + ".swipeActionType"));
          ((o)localObject1).jumpUrl = bt.bI((String)paramMap.get(paramString + ".jumpUrl"), "");
          continue;
          localObject1 = h(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
        }
      }
      else
      {
        label8286:
        localObject1 = null;
      }
    }
  }
  
  private static void a(x paramx, Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(97338);
    paramx.zAh = bt.aRe((String)paramMap.get(paramString + ".type"));
    paramx.type = paramx.zAh;
    paramx.zAg = bt.bI((String)paramMap.get(paramString + ".id"), "");
    paramx.paddingTop = a(bt.aRg((String)paramMap.get(paramString + ".paddingTop")), paramInt1, paramInt2, paramInt3);
    paramx.paddingBottom = a(bt.aRg((String)paramMap.get(paramString + ".paddingBottom")), paramInt1, paramInt2, paramInt3);
    paramx.paddingLeft = a(bt.aRg((String)paramMap.get(paramString + ".paddingLeft")), paramInt1, paramInt2, paramInt3);
    paramx.paddingRight = a(bt.aRg((String)paramMap.get(paramString + ".paddingRight")), paramInt1, paramInt2, paramInt3);
    paramx.subType = bt.aRe((String)paramMap.get(paramString + ".subType"));
    paramx.zAl = bt.bI((String)paramMap.get(paramString + ".cellBackgroundColor"), "");
    String str1 = paramString + ".if";
    boolean bool1;
    label402:
    label456:
    label462:
    double d;
    if (paramMap.containsKey(str1)) {
      if ("1".equals(paramMap.get(str1)))
      {
        bool1 = true;
        paramx.zAo = bool1;
        str1 = paramString + ".noReport";
        if (!paramMap.containsKey(str1)) {
          break label707;
        }
        if (!"1".equals(paramMap.get(str1))) {
          break label701;
        }
        bool1 = bool2;
        paramx.zAp = bool1;
        str1 = bt.bI((String)paramMap.get(paramString + ".layoutWidth"), "");
        String str2 = bt.bI((String)paramMap.get(paramString + ".layoutHeight"), "");
        if (TextUtils.isEmpty(str1)) {
          break label732;
        }
        d = bt.aRg(str1);
        if (d >= 0.0D) {
          break label715;
        }
        paramx.zAi = ((float)d);
        label565:
        if (TextUtils.isEmpty(str2)) {
          break label759;
        }
        d = bt.aRg(str2);
        if (d >= 0.0D) {
          break label742;
        }
        paramx.zAj = ((float)d);
        label594:
        str1 = (String)paramMap.get(paramString + ".verticalAlignment");
        paramMap = (String)paramMap.get(paramString + ".horizontalAlignment");
        if (!TextUtils.isEmpty(str1)) {
          break label769;
        }
      }
    }
    label769:
    for (paramx.zAm = -1;; paramx.zAm = bt.aRe(str1))
    {
      if (!TextUtils.isEmpty(paramMap)) {
        break label781;
      }
      paramx.zAn = -1;
      AppMethodBeat.o(97338);
      return;
      bool1 = false;
      break;
      paramx.zAo = true;
      break label402;
      label701:
      bool1 = false;
      break label456;
      label707:
      paramx.zAp = false;
      break label462;
      label715:
      paramx.zAi = a(d, paramInt1, paramInt2, paramInt3);
      break label565;
      label732:
      paramx.zAi = 2.147484E+009F;
      break label565;
      label742:
      paramx.zAj = a(d, paramInt1, paramInt2, paramInt3);
      break label594;
      label759:
      paramx.zAj = 2.147484E+009F;
      break label594;
    }
    label781:
    paramx.zAn = bt.aRe(paramMap);
    AppMethodBeat.o(97338);
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, Activity paramActivity)
  {
    AppMethodBeat.i(97351);
    String str = paramTimeLineObject.zTv;
    long l = new BigInteger(paramTimeLineObject.Id).longValue();
    LinkedList localLinkedList = paramTimeLineObject.HAT.GaQ;
    boolean bool;
    Object localObject;
    int i;
    int j;
    if (!TextUtils.isEmpty(str))
    {
      if ((TextUtils.isEmpty(str)) || (!azV(str))) {
        break label449;
      }
      paramTimeLineObject = "";
      bool = azU(str);
      if (!bool) {
        break label469;
      }
      localObject = com.tencent.mm.model.c.d.aDt().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
      if (com.tencent.mm.model.c.d.aDt().gm("Sns_Canvas_GameShare_JumpWay", 0) == 0)
      {
        i = 0;
        j = i;
        paramTimeLineObject = (TimeLineObject)localObject;
        if (i == 0)
        {
          j = i;
          paramTimeLineObject = (TimeLineObject)localObject;
          if (dYc())
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
        localObject = com.tencent.mm.plugin.sns.model.ag.dUe().Ai(l);
        Intent localIntent = new Intent();
        if (localObject != null)
        {
          localIntent.putExtra("sns_landing_pages_share_sns_id", ((com.tencent.mm.plugin.sns.storage.p)localObject).getSnsId());
          localIntent.putExtra("sns_landing_pages_rawSnsId", ((com.tencent.mm.plugin.sns.storage.p)localObject).dYl().Id);
          localIntent.putExtra("sns_landing_pages_ux_info", ((com.tencent.mm.plugin.sns.storage.p)localObject).dYT());
          localIntent.putExtra("sns_landing_pages_aid", ((com.tencent.mm.plugin.sns.storage.p)localObject).dYP());
          localIntent.putExtra("sns_landing_pages_traceid", ((com.tencent.mm.plugin.sns.storage.p)localObject).dYQ());
          localIntent.putExtra("sns_landing_pages_rec_src", ((com.tencent.mm.plugin.sns.storage.p)localObject).dYV());
        }
        if ((localLinkedList != null) && (localLinkedList.size() > 0)) {
          localIntent.putExtra("sns_landing_pages_share_thumb_url", ((byn)localLinkedList.get(0)).GSI);
        }
        localIntent.putExtra("sns_landing_pages_expid", paramTimeLineObject);
        localIntent.putExtra("sns_landig_pages_from_source", 11);
        localIntent.setClass(paramActivity, SnsAdNativeLandingPagesUI.class);
        localIntent.putExtra("sns_landing_pages_xml", str);
        localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        paramTimeLineObject = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramTimeLineObject.ahp(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Ljava/lang/String;JLjava/util/List;Landroid/app/Activity;IZ)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramTimeLineObject.mq(0));
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
        com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str });
      }
      label469:
      j = 1;
    }
  }
  
  private static boolean a(String paramString, Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(97346);
    paramString = (String)bw.M(paramString, "adCanvasInfo").get(".adCanvasInfo.shareWebUrl");
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(97346);
      return false;
    }
    String str = paramString;
    if (paramBoolean) {
      str = "exp=" + com.tencent.mm.model.c.d.aDt().getExpIdByKey("Sns_Canvas_GameShare_JumpWay") + "_" + paramInt;
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
    com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "canvas jump url ".concat(String.valueOf(paramString)));
    str = paramString;
    paramString = new Intent();
    paramString.putExtra("rawUrl", str);
    paramString.putExtra("showShare", true);
    com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(97346);
    return true;
  }
  
  private static Intent aN(Map<String, String> paramMap)
  {
    AppMethodBeat.i(198112);
    paramMap = com.tencent.mm.plugin.sns.device.appstore.a.b(com.tencent.mm.sdk.platformtools.aj.getContext(), paramMap);
    if (paramMap != null)
    {
      paramMap = paramMap.dSS();
      AppMethodBeat.o(198112);
      return paramMap;
    }
    AppMethodBeat.o(198112);
    return null;
  }
  
  private static boolean azU(String paramString)
  {
    AppMethodBeat.i(97345);
    if (bt.aRe(bt.bI((String)bw.M(paramString, "adCanvasInfo").get(".adCanvasInfo.bizId"), "")) == 1)
    {
      AppMethodBeat.o(97345);
      return true;
    }
    AppMethodBeat.o(97345);
    return false;
  }
  
  public static boolean azV(String paramString)
  {
    AppMethodBeat.i(221347);
    boolean bool = jM(paramString, "adCanvasInfo");
    AppMethodBeat.o(221347);
    return bool;
  }
  
  private static List<x> b(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
      if (!paramString.zAo) {
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
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "comp " + paramString.toString() + " ifCondition is false");
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
      localq.backgroundColor = ((int)(bt.getDouble((String)paramMap.get(paramString + ".bgColorAlpha"), 0.0D) * 255.0D) << 24 | i & 0xFFFFFF);
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
        if (paramString.zAo) {
          localq.zzJ.add(paramString);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "%s", new Object[] { bt.n(localException) });
        localq.backgroundColor = Color.argb(51, 0, 0, 0);
        continue;
        paramString = localException + i;
      }
      label260:
      AppMethodBeat.o(97336);
    }
    return localq;
  }
  
  private static ah d(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97337);
    ah localah = new ah();
    a(localah, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localah.zAU = bt.aRe((String)paramMap.get(paramString + ".pageCtrType"));
    boolean bool;
    String str1;
    int i;
    if (bt.aRe((String)paramMap.get(paramString + ".isFullScreen")) == 1)
    {
      bool = true;
      localah.mXd = bool;
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
        if (paramString.zAo) {
          localq.zzJ.add(paramString);
        }
        j += 1;
        break label176;
        bool = false;
        break;
        paramString = str1 + i;
        break label142;
      }
      label280:
      if (localq.zzJ.size() == 0) {
        break label311;
      }
      localah.zzJ.add(localq);
      i += 1;
    }
    label311:
    AppMethodBeat.o(97337);
    return localah;
  }
  
  private static boolean dYc()
  {
    AppMethodBeat.i(97349);
    c localc = com.tencent.mm.model.c.d.aDs().wz("100150");
    if (localc.isValid())
    {
      int i = bt.getInt((String)localc.foF().get("openCanvas"), 0);
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "canOpenGameCanvas abtest=".concat(String.valueOf(i)));
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
  
  private static void dYd()
  {
    AppMethodBeat.i(97354);
    if (zLQ != null)
    {
      AppMethodBeat.o(97354);
      return;
    }
    zLQ = new HashSet();
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    for (;;)
    {
      int k;
      try
      {
        localInputStream = com.tencent.mm.sdk.platformtools.aj.getContext().getAssets().open("sns/canvas_valid_type.xml");
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
            if (bt.getInt(localXmlPullParser.getAttributeValue(null, "android"), 0) != 1) {
              continue;
            }
            localObject2 = localInputStream;
            localObject4 = localInputStream;
            localObject1 = localInputStream;
            i1 = bt.getInt(localXmlPullParser.getAttributeValue(null, "val"), -1);
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
          ((i.b)localObject5).zLV = i;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((i.b)localObject5).zLW = k;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((i.b)localObject5).zLX = i1;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          zLQ.add(localObject5);
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "valid canvas type ".concat(String.valueOf(localObject5)));
          m = i;
        }
      }
      catch (IOException localIOException6)
      {
        InputStream localInputStream;
        localObject1 = localObject2;
        com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", bt.n(localIOException6));
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
        com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", bt.n(localXmlPullParserException));
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
  
  private static x e(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97339);
    y localy = new y();
    localy.zAr = bt.aRe((String)paramMap.get(paramString + ".subType"));
    a(localy, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    String str = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = str;; paramString = str + i)
    {
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label162;
      }
      if (paramString.zAo) {
        localy.zAq.add(paramString);
      }
      i += 1;
      break;
    }
    label162:
    AppMethodBeat.o(97339);
    return localy;
  }
  
  private static x f(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97340);
    Object localObject = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    w localw = new w();
    localw.aQH = ((List)localObject);
    a(localw, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localObject = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = (String)localObject;; paramString = (String)localObject + i)
    {
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label147;
      }
      if (paramString.zAo) {
        localw.aQH.add(paramString);
      }
      i += 1;
      break;
    }
    label147:
    AppMethodBeat.o(97340);
    return localw;
  }
  
  public static void fO(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l> paramList)
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
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l locall = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l)localIterator.next();
      if (QD(locall.dWS().type)) {
        localArrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)locall).dWH());
      }
    }
    if (!localArrayList.isEmpty())
    {
      fO(localArrayList);
      paramList.addAll(localArrayList);
    }
    AppMethodBeat.o(97357);
  }
  
  private static x g(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97341);
    Object localObject = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    v localv = new v();
    localv.hF = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aj.getContext(), bt.aRe((String)paramMap.get(paramString + ".cornerRadius")));
    localv.zAc = bt.aRe((String)paramMap.get(paramString + ".autoShow"));
    localv.zAd = bt.aRe((String)paramMap.get(paramString + ".noAnimation"));
    localv.zAe = bt.aRe((String)paramMap.get(paramString + ".forbiddenToClose"));
    localv.zAf = bt.aRe((String)paramMap.get(paramString + ".noBackground"));
    localv.aQH = ((List)localObject);
    a(localv, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localObject = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = (String)localObject;; paramString = (String)localObject + i)
    {
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label338;
      }
      if (paramString.zAo) {
        localv.aQH.add(paramString);
      }
      i += 1;
      break;
    }
    label338:
    AppMethodBeat.o(97341);
    return localv;
  }
  
  private static com.tencent.mm.plugin.sns.ad.landingpage.component.b.a h(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(198115);
    com.tencent.mm.plugin.sns.ad.landingpage.component.b.a locala = new com.tencent.mm.plugin.sns.ad.landingpage.component.b.a();
    locala.yXg = bt.bI((String)paramMap.get(paramString + ".title"), "");
    locala.yXh = bt.aRe((String)paramMap.get(paramString + ".autoJump"));
    paramMap = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramMap instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)) {
      locala.yXi = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)paramMap);
    }
    AppMethodBeat.o(198115);
    return locala;
  }
  
  private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag i(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(198116);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag localag = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag();
    a(localag, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localag.desc = bt.bI((String)paramMap.get(paramString + ".desc"), "");
    boolean bool;
    if (bt.aRe((String)paramMap.get(paramString + ".isFullClickable")) == 1) {
      bool = true;
    }
    for (;;)
    {
      localag.zAx = bool;
      try
      {
        String str1 = paramString + ".descColor";
        String str2 = paramString + ".descColorAlpha";
        localag.zAw = bt.bI((String)paramMap.get(str1), "");
        if ((paramMap.containsKey(str2)) && (localag.zAw.length() > 0)) {
          localag.zAw = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bt.aRg((String)paramMap.get(str2)) * 255.0D)), localag.zAw.substring(1) });
        }
        localag.zAB = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
        if ((localag.zAB instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localag.zAB).zyr = true;
        }
        AppMethodBeat.o(198116);
        return localag;
        bool = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse descColor exp=" + localException.toString());
        }
      }
    }
  }
  
  public static String jK(String paramString1, String paramString2)
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
  
  public static String jL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97344);
    Object localObject2 = new String(paramString1);
    Object localObject1 = localObject2;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString2);
      localObject1 = localObject2;
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "the jsonObject is " + localJSONObject.toString());
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
        if (bt.isNullOrNil(str)) {
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
      com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "the json is parsed error : ".concat(String.valueOf(paramString1)));
      localObject2 = localObject1;
      AppMethodBeat.o(97344);
      return localObject2;
    }
  }
  
  public static boolean jM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97353);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(97353);
      return false;
    }
    if (zLQ == null) {
      dYd();
    }
    if ((zLQ != null) && (!zLQ.isEmpty()))
    {
      Map localMap = bw.M(paramString1, paramString2);
      if ((localMap == null) || (localMap.isEmpty()))
      {
        com.tencent.mm.sdk.platformtools.ad.w("AdLandingPagesParseHelper", "invalid landingpages xml,".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(97353);
        return false;
      }
      i.b localb = new i.b((byte)0);
      localb.zLV = 0;
      localb.zLW = bt.aRe((String)localMap.get(".adCanvasInfo.type"));
      localb.zLX = bt.aRe((String)localMap.get(".adCanvasInfo.subtype"));
      if (!zLQ.contains(localb))
      {
        com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "invalid canvas type ".concat(String.valueOf(localb)));
        AppMethodBeat.o(97353);
        return false;
      }
      int i = 0;
      for (;;)
      {
        localb.zLV = 1;
        if (i == 0) {}
        for (paramString1 = ".adCanvasInfo.PageList.Page";; paramString1 = ".adCanvasInfo.PageList.Page" + i)
        {
          if (!localMap.containsKey(paramString1 + ".componentItemList.componentItem.type")) {
            break label591;
          }
          localb.zLW = bt.aRe((String)localMap.get(paramString1 + ".type"));
          localb.zLX = bt.aRe((String)localMap.get(paramString1 + ".subType"));
          if (zLQ.contains(localb)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "invalid page type ".concat(String.valueOf(localb)));
          AppMethodBeat.o(97353);
          return false;
        }
        paramString2 = paramString1 + ".componentItemList.componentItem";
        localb.zLV = 2;
        int j = 0;
        for (;;)
        {
          if (j == 0) {}
          for (paramString1 = paramString2;; paramString1 = paramString2 + j)
          {
            if (!localMap.containsKey(paramString1 + ".type")) {
              break label584;
            }
            localb.zLW = bt.aRe((String)localMap.get(paramString1 + ".type"));
            localb.zLX = bt.aRe((String)localMap.get(paramString1 + ".subType"));
            if (zLQ.contains(localb)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(localb)));
            AppMethodBeat.o(97353);
            return false;
          }
          j += 1;
        }
        label584:
        i += 1;
      }
      label591:
      localb.zLV = 2;
      paramString1 = localMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        Object localObject = (Map.Entry)paramString1.next();
        if ((((Map.Entry)localObject).getKey() != null) && (((String)((Map.Entry)localObject).getKey()).matches("[\\s\\S]*\\.componentItem[0-9]*\\.type$")))
        {
          paramString2 = (String)((Map.Entry)localObject).getKey();
          localObject = ((String)((Map.Entry)localObject).getKey()).replace(".type", ".subType");
          localb.zLW = bt.aRe((String)localMap.get(paramString2));
          localb.zLX = bt.aRe((String)localMap.get(localObject));
          if (!zLQ.contains(localb))
          {
            com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(localb)));
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
        com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", "append url params failed, %s", new Object[] { paramString.toString() });
        AppMethodBeat.o(97348);
        return str1;
      }
    }
    paramString = str1 + paramString + paramVarArgs;
    AppMethodBeat.o(97348);
    return paramString;
  }
  
  private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e x(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(198114);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e locale = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e();
    locale.zyy = bt.bI((String)paramMap.get(paramString + ".webViewUrl"), "");
    locale.zyA = bt.aRe((String)paramMap.get(paramString + ".webViewHeight"));
    locale.zyz = bt.aRe((String)paramMap.get(paramString + ".webViewWidth"));
    locale.zyB = bt.aRe((String)paramMap.get(paramString + ".hideWebViewProgress"));
    AppMethodBeat.o(198114);
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
      if ((!TextUtils.isEmpty(str2)) && (jM(str2, "adCanvasInfo")))
      {
        str1 = "";
        bool2 = azU(str2);
        if (!bool2) {
          break label284;
        }
        str1 = com.tencent.mm.model.c.d.aDt().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
        if (!TextUtils.isEmpty(str1))
        {
          int i = com.tencent.mm.model.c.d.aDt().gm("Sns_Canvas_GameShare_JumpWay", 0);
          com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "abtestvalue = ".concat(String.valueOf(i)));
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
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(97350);
        return true;
        bool1 = true;
        continue;
        bool1 = dYc();
      }
      else
      {
        bool1 = a(str2, paramContext, bool2, paramIntent.getIntExtra("sns_landig_pages_from_source", -1));
        AppMethodBeat.o(97350);
        return bool1;
        com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str2 });
        AppMethodBeat.o(97350);
        return false;
        label284:
        bool1 = true;
      }
    }
  }
  
  public static final class a
  {
    public LinkedList<g> zLR;
    public ab zLS;
    public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e zLT;
    public com.tencent.mm.plugin.sns.ad.landingpage.component.b.a zLU;
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97329);
      this.zLR = new LinkedList();
      this.zLS = null;
      this.zLT = null;
      this.zLU = null;
      long l = System.currentTimeMillis();
      jN(paramString1, paramString2);
      com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "parse adlanding xml, timeCost=" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(97329);
    }
    
    private void jN(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97330);
      if (TextUtils.isEmpty(paramString1))
      {
        AppMethodBeat.o(97330);
        return;
      }
      paramString1 = i.jK(paramString1, "");
      Map localMap = bw.M(paramString1, paramString2);
      if (localMap == null)
      {
        com.tencent.mm.sdk.platformtools.ad.w("AdLandingPagesParseHelper", " parse landingpages xml is error ,".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(97330);
        return;
      }
      int i1 = bt.aRe((String)localMap.get("." + paramString2 + ".adCanvasInfo.sizeType"));
      int j = bt.aRe((String)localMap.get("." + paramString2 + ".adCanvasInfo.basicRootFontSize"));
      int k = bt.aRe((String)localMap.get("." + paramString2 + ".adCanvasInfo.basicWidth"));
      int i = j;
      if (j == 0)
      {
        i = j;
        if (i1 == 1) {
          i = i.zLP;
        }
      }
      j = k;
      if (k == 0)
      {
        j = k;
        if (i1 == 1) {
          j = i.zLO;
        }
      }
      if ((!bt.isNullOrNil(paramString2)) && (!".adCanvasInfo.PageList.Page".equals("adCanvasInfo"))) {}
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
            localg.zLH = bt.bI((String)localMap.get((String)localObject1 + ".backgroundCover"), "");
            localg.jVX = bt.bI((String)localMap.get((String)localObject1 + ".backgroundColor"), "");
            if (bt.aRe((String)localMap.get((String)localObject1 + ".backgroundCover.$isAddBlur")) <= 0) {
              break label628;
            }
            bool = true;
            localg.zLI = bool;
            localg.id = k;
            localObject2 = (String)localObject1 + ".if";
            if (!localMap.containsKey(localObject2)) {
              break label640;
            }
            if (!"1".equals(localMap.get(localObject2))) {
              break label634;
            }
            bool = true;
            localg.zLL = bool;
            if (!localg.zLL) {
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
              if (TextUtils.isEmpty(localg.jVX)) {
                continue;
              }
              n = Color.parseColor(localg.jVX);
              localx1 = i.b(localMap, i1, j, i, n, (String)localObject2);
            }
            catch (Exception localException2)
            {
              int n;
              x localx1;
              label628:
              label634:
              com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", bt.n(localException2));
              label640:
              label649:
              x localx2 = i.b(localMap, i1, j, i, 0, (String)localObject2);
              continue;
              localg.zLJ.add(localx2);
              continue;
              com.tencent.mm.sdk.platformtools.ad.i("AdLandingPagesParseHelper", "comp " + localx2.toString() + " ifCondition is false");
              continue;
              localObject2 = (String)localObject1 + ".forbiddenGlobalItems.id";
              m = 0;
              if (m != 0) {
                continue;
              }
              localObject1 = localObject2;
              localObject1 = bt.bI((String)localMap.get(localObject1), "");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              localg.zLM.add(localObject1);
              m += 1;
              continue;
              localObject1 = (String)localObject2 + m;
              continue;
              if (localg.zLJ.size() == 0) {
                break label893;
              }
            }
            if (localx1 == null) {
              continue;
            }
            if (!localx1.zAo) {
              continue;
            }
            i.b(localx1, localMap, (String)localObject2, i1, j, i);
            if (!(localx1 instanceof v)) {
              continue;
            }
            localg.zLK.put(localx1.zAg, localx1);
            m += 1;
            break label496;
            localObject1 = paramString1 + k;
            break;
            bool = false;
            break label388;
            bool = false;
            break label456;
            localg.zLL = true;
            break label463;
            localObject2 = str + m;
            continue;
            n = 0;
          }
          this.zLR.add(localg);
          label884:
          k += 1;
        }
        label893:
        if ((this.zLR != null) && (this.zLR.size() > 0)) {
          ((g)this.zLR.get(0)).tTr = true;
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
                com.tencent.mm.sdk.platformtools.ad.e("AdLandingPagesParseHelper", bt.n(localException1));
              }
              com.tencent.mm.sdk.platformtools.ad.d("AdLandingPagesParseHelper", "parse the item: the global item existed, globalItemsStr = ".concat(String.valueOf(paramString1)));
              if (!(paramString2 instanceof ab)) {
                break label1186;
              }
              this.zLS = ((ab)paramString2);
              if (!(paramString2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)) {
                break label1201;
              }
              this.zLT = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)paramString2);
              if (!(paramString2 instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)) {
                break label1216;
              }
              this.zLU = ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)paramString2);
              k += 1;
            }
            if (paramString2 != null) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ad.d("AdLandingPagesParseHelper", "parse the item: the global item is null, globalItemsStr = ".concat(String.valueOf(paramString1)));
            if (this.zLS == null) {
              break label1225;
            }
            paramString1 = this.zLR.iterator();
            for (;;)
            {
              if (!paramString1.hasNext()) {
                break label1225;
              }
              paramString2 = (g)paramString1.next();
              if (paramString2.zLM.size() > 0)
              {
                localObject1 = paramString2.zLM.iterator();
                if (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (String)((Iterator)localObject1).next();
                  if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(this.zLS.zAg)) || (!((String)localObject2).equals(this.zLS.zAg))) {
                    break;
                  }
                  paramString2.zLN = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i
 * JD-Core Version:    0.7.0.1
 */