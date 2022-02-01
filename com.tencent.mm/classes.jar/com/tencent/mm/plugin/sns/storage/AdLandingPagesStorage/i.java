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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
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
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
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
  public static int yuB = 750;
  public static int yuC = 10;
  private static Set<i.b> yuD = null;
  
  private static String D(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(97356);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "the adLandingPagesXml is empty");
      AppMethodBeat.o(97356);
      return null;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
      AppMethodBeat.o(97356);
      return null;
    }
    LinkedList localLinkedList = new a(paramString, "adxml").yuE;
    Iterator localIterator1 = paramMap.keySet().iterator();
    String str1 = paramString;
    String str3;
    String str2;
    Iterator localIterator2;
    while (localIterator1.hasNext())
    {
      str3 = (String)localIterator1.next();
      if (!bs.isNullOrNil(str3))
      {
        str2 = (String)paramMap.get(str3);
        if (!bs.isNullOrNil(str2))
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
        Iterator localIterator3 = ((g)localIterator2.next()).yuw.iterator();
        while (localIterator3.hasNext())
        {
          x localx = (x)localIterator3.next();
          if (((localx instanceof f)) && (!bs.isNullOrNil(((f)localx).nVh)) && (((f)localx).nVh.equals(str3)))
          {
            paramString = ((f)localx).nWf;
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
          if (bs.isNullOrNil(paramString)) {
            break label333;
          }
          com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "old card ext is " + paramString + " and new card ext is " + str2);
          str1 = str1.replace(paramString, str2);
          try
          {
            paramString = str1.replace(bs.aLw(paramString), bs.aLw(str2));
            str1 = paramString;
          }
          catch (Exception paramString)
          {
            com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "the xml is error");
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
  
  public static String H(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(97355);
    if (paramp == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "the snsinfo is null");
      AppMethodBeat.o(97355);
      return null;
    }
    if (!paramp.Pe(32))
    {
      com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "the snsinfo is not a ad");
      AppMethodBeat.o(97355);
      return null;
    }
    com.tencent.mm.plugin.sns.storage.e locale = paramp.dME();
    if (locale == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "the adSnsInfo is null");
      AppMethodBeat.o(97355);
      return null;
    }
    com.tencent.mm.plugin.sns.storage.b localb = paramp.dFR();
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "the adxml is null");
      AppMethodBeat.o(97355);
      return null;
    }
    paramp = paramp.dFQ();
    if (paramp == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "the adInfo is null");
      AppMethodBeat.o(97355);
      return null;
    }
    if (!localb.dJG())
    {
      com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "the snsinfo is not a landingpage");
      AppMethodBeat.o(97355);
      return null;
    }
    if ((paramp.yeQ == null) || (paramp.yeQ.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
      AppMethodBeat.o(97355);
      return null;
    }
    paramp = D(locale.field_adxml, paramp.yeQ);
    AppMethodBeat.o(97355);
    return paramp;
  }
  
  public static boolean OV(int paramInt)
  {
    return (paramInt == 101) || (paramInt == 103) || (paramInt == 104) || (paramInt == 105);
  }
  
  public static boolean OW(int paramInt)
  {
    return paramInt == 101;
  }
  
  public static boolean OX(int paramInt)
  {
    return paramInt == 103;
  }
  
  public static boolean OY(int paramInt)
  {
    return paramInt == 104;
  }
  
  public static boolean OZ(int paramInt)
  {
    return paramInt == 105;
  }
  
  private static boolean Pa(int paramInt)
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
    int[] arrayOfInt = al.gg(com.tencent.mm.sdk.platformtools.ai.getContext());
    paramInt1 = Math.min(arrayOfInt[0], arrayOfInt[1]);
    float f1 = (float)paramDouble;
    float f2 = paramInt3;
    f1 = al.bz(paramInt1 * (f1 * f2) / paramInt2);
    AppMethodBeat.o(97332);
    return f1;
  }
  
  private static ak a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(97334);
    localak = new ak();
    try
    {
      paramString = paramString + ".radarChart";
      localak.yki = ((String)paramMap.get(paramString + ".borderImg"));
      localak.yko = ((String)paramMap.get(paramString + ".maskImg"));
      localak.ykj = ((String)paramMap.get(paramString + ".coverColor"));
      localak.ykk = Color.parseColor((String)paramMap.get(paramString + ".labelFont.$color"));
      localak.ykl = ((int)a(bs.aLA((String)paramMap.get(paramString + ".labelFont.$size")), paramInt1, paramInt2, paramInt3));
      localak.ykm = Color.parseColor((String)paramMap.get(paramString + ".scoreFont.$color"));
      localak.ykn = ((int)a(bs.aLA((String)paramMap.get(paramString + ".scoreFont.$size")), paramInt1, paramInt2, paramInt3));
      localak.borderWidth = a(bs.aLA((String)paramMap.get(paramString + ".borderImgWidth")), paramInt1, paramInt2, paramInt3);
      String str = paramString + ".itemList.item";
      paramInt1 = 0;
      if (paramInt1 != 0) {}
      for (paramString = str + paramInt1;; paramString = str)
      {
        ak.a locala = new ak.a();
        locala.label = ((String)paramMap.get(paramString + ".label"));
        locala.ykp = ((String)paramMap.get(paramString + ".score"));
        locala.value = ((float)bs.aLA((String)paramMap.get(paramString + ".value")));
        if ((TextUtils.isEmpty(locala.label)) && (TextUtils.isEmpty(locala.ykp))) {
          break label564;
        }
        localak.ihv.add(locala);
        paramInt1 += 1;
        break;
      }
      label564:
      return localak;
    }
    catch (Exception paramMap)
    {
      com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", bs.m(paramMap));
      AppMethodBeat.o(97334);
    }
  }
  
  private static x a(Map<String, String> paramMap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(97343);
    int i = bs.aLy((String)paramMap.get(paramString + ".type"));
    x localx = null;
    if (!OV(i)) {}
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
      if (OW(i))
      {
        paramMap = d(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (OX(i))
      {
        paramMap = e(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (OY(i))
      {
        paramMap = f(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (OZ(i))
      {
        paramMap = g(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "the type" + i + " is not client known type");
        paramMap = localException;
      }
    }
  }
  
  private static x a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97333);
    int k = bs.aLy((String)paramMap.get(paramString + ".type"));
    int m = bs.aLy((String)paramMap.get(paramString + ".subType"));
    Object localObject1;
    switch (k)
    {
    default: 
      AppMethodBeat.o(97333);
      return null;
    case 82: 
      localObject1 = new aj();
      ((aj)localObject1).url = bs.bG((String)paramMap.get(paramString + ".webviewUrl"), "");
      ((aj)localObject1).yjf = bs.bG((String)paramMap.get(paramString + ".qrExtInfo"), "");
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((x)localObject1).yjw = Pa(paramInt4);
        ((x)localObject1).type = k;
        ((x)localObject1).subType = m;
        a((x)localObject1, paramMap, paramString, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(97333);
      return localObject1;
      localObject1 = c(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      continue;
      localObject1 = new ad();
      ((ad)localObject1).yjt = k;
      ((ad)localObject1).subType = m;
      ((ad)localObject1).yjT = bs.bG((String)paramMap.get(paramString + ".content"), "");
      ((ad)localObject1).textAlignment = bs.aLy((String)paramMap.get(paramString + ".textAlignment"));
      ((ad)localObject1).uOk = bs.bG((String)paramMap.get(paramString + ".fontColor"), "");
      ((ad)localObject1).textSize = a(bs.aLA((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
      if ((bs.aLy((String)paramMap.get(paramString + ".showType")) & ad.yjO) > 0)
      {
        bool = true;
        label620:
        ((ad)localObject1).yjU = bool;
        if ((bs.aLy((String)paramMap.get(paramString + ".showType")) & ad.yjP) <= 0) {
          break label845;
        }
        bool = true;
        label669:
        ((ad)localObject1).yjV = bool;
        if ((bs.aLy((String)paramMap.get(paramString + ".showType")) & ad.yjQ) <= 0) {
          break label851;
        }
      }
      label845:
      label851:
      for (boolean bool = true;; bool = false)
      {
        ((ad)localObject1).yjW = bool;
        ((ad)localObject1).maxLines = bs.aLy((String)paramMap.get(paramString + ".maxLines"));
        ((ad)localObject1).yiP = bs.aLy((String)paramMap.get(paramString + ".fontType"));
        ((ad)localObject1).yjX = bs.aLB((String)paramMap.get(paramString + ".lineSpace"));
        break;
        bool = false;
        break label620;
        bool = false;
        break label669;
      }
      label979:
      Object localObject2;
      if (m == 2)
      {
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).djj = ((String)paramMap.get(paramString + ".appid"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yhT = ((String)paramMap.get(paramString + ".wxAppid"));
        if (bs.aLy((String)paramMap.get(paramString + ".useGameDownloadWidget")) == 1)
        {
          bool = true;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yhU = bool;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yfc = ((String)paramMap.get(paramString + ".appPageUrlAndroid"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).channelId = ((String)paramMap.get(paramString + ".channelId"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).JG = ((String)paramMap.get(paramString + ".pkg"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yhX = bs.aLy((String)paramMap.get(paramString + ".platform"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yhY = ((String)paramMap.get(paramString + ".warningAndroid"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yhZ = ((String)paramMap.get(paramString + ".btnBgColorTheme"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yib = ((String)paramMap.get(paramString + ".btnBgColorThemePressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yia = ((String)paramMap.get(paramString + ".btnBgColorThemeDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yic = ((String)paramMap.get(paramString + ".btnBorderColorTheme"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yie = ((String)paramMap.get(paramString + ".btnBorderColorThemePressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yid = ((String)paramMap.get(paramString + ".btnBorderColorThemeDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yif = ((String)paramMap.get(paramString + ".fontColor"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yih = ((String)paramMap.get(paramString + ".fontColorPressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yig = ((String)paramMap.get(paramString + ".fontColorDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yik = bs.aLy((String)paramMap.get(paramString + ".showDownloadTip"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yil = bs.aLy((String)paramMap.get(paramString + ".marketFlag"));
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yil > 0)
          {
            localObject2 = aK(paramMap);
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).yim = ((Intent)localObject2);
            }
          }
        }
      }
      Object localObject3;
      for (;;)
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yjt = k;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).subType = m;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).title = bs.bG((String)paramMap.get(paramString + ".btnTitle"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiK = bs.aLy((String)paramMap.get(paramString + ".btnType"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiL = bs.bG((String)paramMap.get(paramString + ".btnJumpUrl"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiM = bs.bG((String)paramMap.get(paramString + ".btnJumpApp"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiN = bs.bG((String)paramMap.get(paramString + ".fontColor"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).bsJ = a(bs.aLA((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiP = bs.aLy((String)paramMap.get(paramString + ".btnFontType"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).textAlignment = bs.aLy((String)paramMap.get(paramString + ".btnAlignment"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiO = a(bs.aLA((String)paramMap.get(paramString + ".borderSize")), paramInt1, paramInt2, paramInt3);
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).height = a(bs.aLA((String)paramMap.get(paramString + ".btnHeight")), paramInt1, paramInt2, paramInt3);
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiQ = bs.bG((String)paramMap.get(paramString + ".btnBgColorTheme"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiR = bs.bG((String)paramMap.get(paramString + ".btnBorderColorTheme"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiS = bs.bG((String)paramMap.get(paramString + ".btnBgImgUrl"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiT = bs.aLy((String)paramMap.get(paramString + ".bCanLongPress"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiU = bs.aLy((String)paramMap.get(paramString + ".bHideActionSheet"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiV = bs.aLy((String)paramMap.get(paramString + ".hideProductActionHeader"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiW = bs.aLy((String)paramMap.get(paramString + ".showProductActionCancelButton"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiY = bs.bG((String)paramMap.get(paramString + ".productActionTitle"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiX = bs.bG((String)paramMap.get(paramString + ".productActionBuffer"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yiZ = bs.bG((String)paramMap.get(paramString + ".productActionIconUrl"), "");
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).rs = a(bs.aLy((String)paramMap.get(paramString + ".cornerRadius")), paramInt1, paramInt2, paramInt3);
        if (paramMap.containsKey(paramString + ".productActionItem.componentItem.type")) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).yja = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString + ".productActionItem.componentItem");
        }
        break;
        bool = false;
        break label979;
        if (m == 4)
        {
          localObject1 = new f();
          ((f)localObject1).nVh = bs.bG((String)paramMap.get(paramString + ".cardTpId"), "");
          ((f)localObject1).nWf = bs.bG((String)paramMap.get(paramString + ".cardExt"), "");
        }
        else if (m == 7)
        {
          localObject1 = new l();
          ((l)localObject1).yiy = bs.bG((String)paramMap.get(paramString + ".jumpCanvasId"), "");
          ((l)localObject1).yiz = bs.bG((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
          ((l)localObject1).yiA = bs.aLy((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
          ((l)localObject1).yiB = bs.aLy((String)paramMap.get(paramString + ".btnCanvasEnterType"));
          ((l)localObject1).yiC = bs.aLy((String)paramMap.get(paramString + ".btnCanvasSource"));
        }
        else if (m == 8)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1).username = ((String)paramMap.get(paramString + ".weappUserName"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1).dxv = ((String)paramMap.get(paramString + ".weappPath"));
        }
        else if (m == 9)
        {
          d1 = bs.aLA((String)paramMap.get(paramString + ".location.$x"));
          d2 = bs.aLA((String)paramMap.get(paramString + ".location.$y"));
          i = bs.aLy((String)paramMap.get(paramString + ".location.$scale"));
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
              break label3227;
            }
            ((List)localObject3).add(localObject1);
            i += 1;
            break;
          }
          label3227:
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
          ((m)localObject1).pis = ((String)paramMap.get(paramString + ".weappUserName"));
          ((m)localObject1).yiD = ((String)paramMap.get(paramString + ".weAppID"));
          ((m)localObject1).koY = ((String)paramMap.get(paramString + ".businessId"));
          ((m)localObject1).koP = ((String)paramMap.get(paramString + ".sessionFrom"));
          ((m)localObject1).yiE = bs.aLy((String)paramMap.get(paramString + ".showMessageCard"));
          ((m)localObject1).koZ = bs.nullAsNil((String)paramMap.get(paramString + ".sendMessageTitle"));
          ((m)localObject1).kpb = bs.nullAsNil((String)paramMap.get(paramString + ".sendMessageImg"));
          ((m)localObject1).kpa = bs.nullAsNil((String)paramMap.get(paramString + ".sendMessagePath"));
        }
        else if (m == 13)
        {
          localObject1 = new n();
          ((n)localObject1).yiF = bs.aLy((String)paramMap.get(paramString + ".sid"));
          ((n)localObject1).yiG = bs.aLy((String)paramMap.get(paramString + ".compid"));
        }
        else if (m == 14)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).yiu = bs.nullAsNil((String)paramMap.get(paramString + ".redEnvelopsSkinBtnDisableWording"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).yiv = bs.aLz(paramString + ".redEnvelopsSkinDisableTime");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).dke = bs.nullAsNil((String)paramMap.get(paramString + ".redEnvelopesSkinId"));
        }
        else if (m == 15)
        {
          localObject1 = new z();
          ((z)localObject1).yjE = bs.bG((String)paramMap.get(paramString + ".qrUrl"), "");
          ((z)localObject1).yjf = bs.bG((String)paramMap.get(paramString + ".qrExtInfo"), "");
        }
        else if (m == 16)
        {
          localObject1 = new aa();
          ((aa)localObject1).yjF = b.a.r(paramMap, ".adxml.adScanInfo");
        }
        else
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p();
        }
      }
      localObject1 = new s();
      ((s)localObject1).yjt = k;
      ((s)localObject1).subType = m;
      ((s)localObject1).yjd = bs.bG((String)paramMap.get(paramString + ".pureImageUrl"), "");
      ((s)localObject1).yhq = bs.bG((String)paramMap.get(paramString + ".bgColor"), "");
      if ((paramMap.containsKey(paramString + ".bgColorAlpha")) && (((s)localObject1).yhq.length() > 0)) {
        ((s)localObject1).yhq = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bs.aLA((String)paramMap.get(paramString + ".bgColorAlpha")) * 255.0D)), ((s)localObject1).yhq.substring(1) });
      }
      ((s)localObject1).width = a(bs.aLA((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((s)localObject1).height = a(bs.aLA((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      ((s)localObject1).yjc = false;
      if (bs.aLy((String)paramMap.get(paramString + ".enableQRScan")) == 1) {}
      for (bool = true;; bool = false)
      {
        ((s)localObject1).yje = bool;
        ((s)localObject1).yjf = bs.bG((String)paramMap.get(paramString + ".qrExtInfo"), "");
        break;
      }
      localObject1 = new r();
      ((r)localObject1).yjt = k;
      ((r)localObject1).subType = m;
      ((r)localObject1).yjd = bs.bG((String)paramMap.get(paramString + ".panoramaImageUrl"), "");
      ((r)localObject1).width = a(bs.aLA((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((r)localObject1).height = a(bs.aLA((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      continue;
      localObject1 = new s();
      ((s)localObject1).yjt = k;
      ((s)localObject1).subType = m;
      ((s)localObject1).yjd = bs.bG((String)paramMap.get(paramString + ".fullScreenImageUrl"), "");
      ((s)localObject1).yjc = true;
      if (bs.aLy((String)paramMap.get(paramString + ".enableQRScan")) == 1) {}
      for (bool = true;; bool = false)
      {
        ((s)localObject1).yje = bool;
        break;
      }
      localObject1 = new u();
      ((u)localObject1).yjt = k;
      ((u)localObject1).subType = m;
      ((u)localObject1).yji = bs.bG((String)paramMap.get(paramString + ".sightVideoUrl"), "");
      ((u)localObject1).yjj = bs.bG((String)paramMap.get(paramString + ".sightThumbUrl"), "");
      ((u)localObject1).yjk = bs.bG((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((u)localObject1).yjl = bs.bG((String)paramMap.get(paramString + ".jumpText"), "");
      ((u)localObject1).yiy = bs.bG((String)paramMap.get(paramString + ".jumpCanvasId"), "");
      ((u)localObject1).yiz = bs.bG((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
      ((u)localObject1).yiA = bs.aLy((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
      try
      {
        ((u)localObject1).yjm = Color.parseColor((String)paramMap.get(paramString + ".jumpTextColor"));
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((u)localObject1).yjn = Color.parseColor((String)paramMap.get(paramString + ".separatorColor"));
            ((u)localObject1).width = a(bs.aLA((String)paramMap.get(paramString + ".sightDisplayWidth")), paramInt1, paramInt2, paramInt3);
            ((u)localObject1).height = a(bs.aLA((String)paramMap.get(paramString + ".sightDisplayHeight")), paramInt1, paramInt2, paramInt3);
            ((u)localObject1).yjo = bs.aLy((String)paramMap.get(paramString + ".sightDisplayType"));
            localObject2 = bs.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
            i = bs.aLy((String)paramMap.get(paramString + ".floatStartTime"));
            if ((!bs.isNullOrNil((String)localObject2)) && (i > 0))
            {
              localObject3 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af();
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)localObject3).dqx = ((String)localObject2);
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)localObject3).yke = i;
              ((u)localObject1).yjp = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)localObject3);
            }
            if (bs.aLy((String)paramMap.get(".adxml.adCanvasInfo.heightRoundingType")) <= 0) {
              break label5328;
            }
            bool = true;
            ((u)localObject1).yjq = bool;
            if (bs.aLy((String)paramMap.get(paramString + ".downloadVideoByCdn")) <= 0) {
              break label5334;
            }
            bool = true;
            ((u)localObject1).yjr = bool;
            break;
            localException1 = localException1;
            ((u)localObject1).yjm = Color.rgb(255, 255, 255);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ((u)localObject1).yjn = Color.rgb(255, 255, 255);
            continue;
            label5328:
            bool = false;
            continue;
            label5334:
            bool = false;
          }
        }
      }
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai();
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).yjt = k;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).subType = m;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).yjk = bs.bG((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).ykg = bs.bG((String)paramMap.get(paramString + ".streamVideoThumb"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).width = a(bs.aLA((String)paramMap.get(paramString + ".streamDisplayWidth")), paramInt1, paramInt2, paramInt3);
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).height = a(bs.aLA((String)paramMap.get(paramString + ".streamDisplayHeight")), paramInt1, paramInt2, paramInt3);
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).ykh = bs.aLy((String)paramMap.get(paramString + ".streamDisplayType"));
      String str1 = bs.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
      int i = bs.aLy((String)paramMap.get(paramString + ".floatStartTime"));
      if ((!bs.isNullOrNil(str1)) && (i > 0))
      {
        localObject3 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)localObject3).dqx = str1;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)localObject3).yke = i;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).yjp = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)localObject3);
      }
      if (bs.aLy((String)paramMap.get(".adxml.adCanvasInfo.heightRoundingType")) > 0) {}
      for (bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)localObject1).yjq = bool;
        break;
      }
      localObject1 = new ah();
      ((ah)localObject1).yjt = k;
      ((ah)localObject1).subType = m;
      ((ah)localObject1).tuw = bs.bG((String)paramMap.get(paramString + ".webviewUrl"), "");
      continue;
      double d1 = a(bs.aLA((String)paramMap.get(paramString + ".topLineSize")), paramInt1, paramInt2, paramInt3);
      double d2 = a(bs.aLA((String)paramMap.get(paramString + ".bottomLineSize")), paramInt1, paramInt2, paramInt3);
      if (Pa(paramInt4)) {
        i = Color.argb(51, 0, 0, 0);
      }
      int j;
      for (;;)
      {
        if (k == 121)
        {
          double d3 = bs.aLA((String)paramMap.get(paramString + ".location.$x"));
          double d4 = bs.aLA((String)paramMap.get(paramString + ".location.$y"));
          j = bs.aLy((String)paramMap.get(paramString + ".location.$scale"));
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
            break label6253;
          }
          ((List)localObject3).add(localObject1);
          j += 1;
          break;
        }
        label6253:
        if (!((List)localObject3).isEmpty())
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d(d1, d2, i, (List)localObject3);
        }
        else
        {
          AppMethodBeat.o(97333);
          return null;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)localObject1).yjt = k;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)localObject1).subType = m;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)localObject1).label = bs.bG((String)paramMap.get(paramString + ".label"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)localObject1).value = ((float)bs.aLA((String)paramMap.get(paramString + ".value")));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)localObject1).yjN = bs.bG((String)paramMap.get(paramString + ".foregroundImage"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)localObject1).bsJ = a(bs.aLA((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)localObject1).jBX = bs.bG((String)paramMap.get(paramString + ".backgroundColor"), "");
          continue;
          localObject1 = a(paramMap, paramString, paramInt1, paramInt2, paramInt3);
          continue;
          localObject1 = new t();
          ((t)localObject1).yhp = bs.bG((String)paramMap.get(paramString + ".sphereThumbUrl"), "");
          ((t)localObject1).ygY = bs.aLy((String)paramMap.get(paramString + ".displayType"));
          ((t)localObject1).yhn = bs.aLy((String)paramMap.get(paramString + ".gestureDelayTime"));
          ((t)localObject1).yho = bs.bG((String)paramMap.get(paramString + ".sphereImageUrl"), "");
          try
          {
            ((t)localObject1).yhq = bs.bG((String)paramMap.get(paramString + ".bgColor"), "");
            if ((paramMap.containsKey(paramString + ".bgColorAlpha")) && (((t)localObject1).yhq.length() > 0)) {
              ((t)localObject1).yhq = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bs.aLA((String)paramMap.get(paramString + ".bgColorAlpha")) * 255.0D)), ((t)localObject1).yhq.substring(1) });
            }
          }
          catch (Exception localException3)
          {
            try
            {
              for (;;)
              {
                ((t)localObject1).width = a(bs.aLA((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
                ((t)localObject1).height = a(bs.aLA((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
                ((t)localObject1).yjg = bs.bG((String)paramMap.get(".adxml.adSphereCardInfo.sphereImageUrl"), "");
                ((t)localObject1).yjh = bs.bG((String)paramMap.get(".adxml.adSphereCardInfo.sphereThumbUrl"), "");
                break;
                localException3 = localException3;
                com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse color exp=" + localException3.toString());
              }
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                ((t)localObject1).width = 0.0F;
                ((t)localObject1).height = 0.0F;
                com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse size exp=" + localException4.toString());
              }
            }
          }
          localObject1 = new ab();
          ((ab)localObject1).yjG = bs.bG((String)paramMap.get(paramString + ".backgroundImg"), "");
          ((ab)localObject1).iconUrl = bs.bG((String)paramMap.get(paramString + ".iconUrl"), "");
          ((ab)localObject1).title = bs.bG((String)paramMap.get(paramString + ".title"), "");
          ((ab)localObject1).desc = bs.bG((String)paramMap.get(paramString + ".desc"), "");
          ((ab)localObject1).yjL = bs.aLy((String)paramMap.get(paramString + ".onlyShowInTimelineAd"));
          if (bs.aLy((String)paramMap.get(paramString + ".isFullClickable")) == 1)
          {
            bool = true;
            ((ab)localObject1).yjI = bool;
            ((ab)localObject1).yjJ = ((int)a(bs.aLA((String)paramMap.get(paramString + ".appearPaddingTop")), paramInt1, paramInt2, paramInt3));
            ((ab)localObject1).yjK = ((int)a(bs.aLA((String)paramMap.get(paramString + ".appearPaddingBottom")), paramInt1, paramInt2, paramInt3));
          }
          try
          {
            str2 = paramString + ".backgroundColor";
            localObject3 = paramString + ".backgroundColorAlpha";
            ((ab)localObject1).jBX = bs.bG((String)paramMap.get(str2), "");
            if ((paramMap.containsKey(localObject3)) && (((ab)localObject1).jBX.length() > 0)) {
              ((ab)localObject1).jBX = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bs.aLA((String)paramMap.get(localObject3)) * 255.0D)), ((ab)localObject1).jBX.substring(1) });
            }
          }
          catch (Exception localException6)
          {
            try
            {
              str2 = paramString + ".titleColor";
              localObject3 = paramString + ".titleColorAlpha";
              ((ab)localObject1).titleColor = bs.bG((String)paramMap.get(str2), "");
              if ((paramMap.containsKey(localObject3)) && (((ab)localObject1).titleColor.length() > 0)) {
                ((ab)localObject1).titleColor = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bs.aLA((String)paramMap.get(localObject3)) * 255.0D)), ((ab)localObject1).titleColor.substring(1) });
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
                  ((ab)localObject1).yjH = bs.bG((String)paramMap.get(str2), "");
                  if ((paramMap.containsKey(localObject3)) && (((ab)localObject1).yjH.length() > 0)) {
                    ((ab)localObject1).yjH = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bs.aLA((String)paramMap.get(localObject3)) * 255.0D)), ((ab)localObject1).yjH.substring(1) });
                  }
                  ((ab)localObject1).yjM = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
                  if (!(((ab)localObject1).yjM instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)) {
                    break label8118;
                  }
                  ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)((ab)localObject1).yjM).yij = true;
                  break;
                  bool = false;
                  break label7302;
                  localException5 = localException5;
                  com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse backgroundColor exp=" + localException5.toString());
                  continue;
                  localException6 = localException6;
                  com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse titleColor exp=" + localException6.toString());
                }
              }
              catch (Exception localException7)
              {
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse descColor exp=" + localException7.toString());
                }
              }
            }
          }
          localObject1 = v(paramMap, paramString);
          continue;
          localObject1 = new o();
          ((o)localObject1).yiI = bs.bG((String)paramMap.get(paramString + ".swipeText"), "");
          ((o)localObject1).yiJ = bs.aLy((String)paramMap.get(paramString + ".swipeActionType"));
          ((o)localObject1).jumpUrl = bs.bG((String)paramMap.get(paramString + ".jumpUrl"), "");
        }
      }
      else
      {
        label7302:
        label8118:
        localObject1 = null;
      }
    }
  }
  
  private static void a(x paramx, Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(97338);
    paramx.yjt = bs.aLy((String)paramMap.get(paramString + ".type"));
    paramx.type = paramx.yjt;
    paramx.yjs = bs.bG((String)paramMap.get(paramString + ".id"), "");
    paramx.paddingTop = a(bs.aLA((String)paramMap.get(paramString + ".paddingTop")), paramInt1, paramInt2, paramInt3);
    paramx.paddingBottom = a(bs.aLA((String)paramMap.get(paramString + ".paddingBottom")), paramInt1, paramInt2, paramInt3);
    paramx.paddingLeft = a(bs.aLA((String)paramMap.get(paramString + ".paddingLeft")), paramInt1, paramInt2, paramInt3);
    paramx.paddingRight = a(bs.aLA((String)paramMap.get(paramString + ".paddingRight")), paramInt1, paramInt2, paramInt3);
    paramx.subType = bs.aLy((String)paramMap.get(paramString + ".subType"));
    paramx.yjx = bs.bG((String)paramMap.get(paramString + ".cellBackgroundColor"), "");
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
        paramx.yjA = bool1;
        str1 = paramString + ".noReport";
        if (!paramMap.containsKey(str1)) {
          break label707;
        }
        if (!"1".equals(paramMap.get(str1))) {
          break label701;
        }
        bool1 = bool2;
        paramx.yjB = bool1;
        str1 = bs.bG((String)paramMap.get(paramString + ".layoutWidth"), "");
        String str2 = bs.bG((String)paramMap.get(paramString + ".layoutHeight"), "");
        if (TextUtils.isEmpty(str1)) {
          break label732;
        }
        d = bs.aLA(str1);
        if (d >= 0.0D) {
          break label715;
        }
        paramx.yju = ((float)d);
        label565:
        if (TextUtils.isEmpty(str2)) {
          break label759;
        }
        d = bs.aLA(str2);
        if (d >= 0.0D) {
          break label742;
        }
        paramx.yjv = ((float)d);
        label594:
        str1 = (String)paramMap.get(paramString + ".verticalAlignment");
        paramMap = (String)paramMap.get(paramString + ".horizontalAlignment");
        if (!TextUtils.isEmpty(str1)) {
          break label769;
        }
      }
    }
    label769:
    for (paramx.yjy = -1;; paramx.yjy = bs.aLy(str1))
    {
      if (!TextUtils.isEmpty(paramMap)) {
        break label781;
      }
      paramx.yjz = -1;
      AppMethodBeat.o(97338);
      return;
      bool1 = false;
      break;
      paramx.yjA = true;
      break label402;
      label701:
      bool1 = false;
      break label456;
      label707:
      paramx.yjB = false;
      break label462;
      label715:
      paramx.yju = a(d, paramInt1, paramInt2, paramInt3);
      break label565;
      label732:
      paramx.yju = 2.147484E+009F;
      break label565;
      label742:
      paramx.yjv = a(d, paramInt1, paramInt2, paramInt3);
      break label594;
      label759:
      paramx.yjv = 2.147484E+009F;
      break label594;
    }
    label781:
    paramx.yjz = bs.aLy(paramMap);
    AppMethodBeat.o(97338);
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, Activity paramActivity)
  {
    AppMethodBeat.i(97351);
    String str = paramTimeLineObject.yCb;
    long l = new BigInteger(paramTimeLineObject.Id).longValue();
    LinkedList localLinkedList = paramTimeLineObject.FQo.Etz;
    boolean bool;
    Object localObject;
    int i;
    int j;
    if (!TextUtils.isEmpty(str))
    {
      if ((TextUtils.isEmpty(str)) || (!auO(str))) {
        break label449;
      }
      paramTimeLineObject = "";
      bool = auN(str);
      if (!bool) {
        break label469;
      }
      localObject = com.tencent.mm.model.c.d.aAq().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
      if (com.tencent.mm.model.c.d.aAq().fP("Sns_Canvas_GameShare_JumpWay", 0) == 0)
      {
        i = 0;
        j = i;
        paramTimeLineObject = (TimeLineObject)localObject;
        if (i == 0)
        {
          j = i;
          paramTimeLineObject = (TimeLineObject)localObject;
          if (dLM())
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
        localObject = com.tencent.mm.plugin.sns.model.af.dHR().xK(l);
        Intent localIntent = new Intent();
        if (localObject != null)
        {
          localIntent.putExtra("sns_landing_pages_share_sns_id", ((com.tencent.mm.plugin.sns.storage.p)localObject).getSnsId());
          localIntent.putExtra("sns_landing_pages_rawSnsId", ((com.tencent.mm.plugin.sns.storage.p)localObject).dLV().Id);
          localIntent.putExtra("sns_landing_pages_ux_info", ((com.tencent.mm.plugin.sns.storage.p)localObject).dMD());
          localIntent.putExtra("sns_landing_pages_aid", ((com.tencent.mm.plugin.sns.storage.p)localObject).dMz());
          localIntent.putExtra("sns_landing_pages_traceid", ((com.tencent.mm.plugin.sns.storage.p)localObject).dMA());
          localIntent.putExtra("sns_landing_pages_rec_src", ((com.tencent.mm.plugin.sns.storage.p)localObject).dMF());
        }
        if ((localLinkedList != null) && (localLinkedList.size() > 0)) {
          localIntent.putExtra("sns_landing_pages_share_thumb_url", ((btz)localLinkedList.get(0)).Fjh);
        }
        localIntent.putExtra("sns_landing_pages_expid", paramTimeLineObject);
        localIntent.putExtra("sns_landig_pages_from_source", 11);
        localIntent.setClass(paramActivity, SnsAdNativeLandingPagesUI.class);
        localIntent.putExtra("sns_landing_pages_xml", str);
        localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        paramTimeLineObject = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramTimeLineObject.aeD(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Ljava/lang/String;JLjava/util/List;Landroid/app/Activity;IZ)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramTimeLineObject.lR(0));
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
        com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str });
      }
      label469:
      j = 1;
    }
  }
  
  private static boolean a(String paramString, Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(97346);
    paramString = (String)bv.L(paramString, "adCanvasInfo").get(".adCanvasInfo.shareWebUrl");
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(97346);
      return false;
    }
    String str = paramString;
    if (paramBoolean) {
      str = "exp=" + com.tencent.mm.model.c.d.aAq().getExpIdByKey("Sns_Canvas_GameShare_JumpWay") + "_" + paramInt;
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
    com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "canvas jump url ".concat(String.valueOf(paramString)));
    str = paramString;
    paramString = new Intent();
    paramString.putExtra("rawUrl", str);
    paramString.putExtra("showShare", true);
    com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(97346);
    return true;
  }
  
  private static Intent aK(Map<String, String> paramMap)
  {
    AppMethodBeat.i(200318);
    paramMap = com.tencent.mm.plugin.sns.device.appstore.a.b(com.tencent.mm.sdk.platformtools.ai.getContext(), paramMap);
    if (paramMap != null)
    {
      paramMap = paramMap.dGF();
      AppMethodBeat.o(200318);
      return paramMap;
    }
    AppMethodBeat.o(200318);
    return null;
  }
  
  private static boolean auN(String paramString)
  {
    AppMethodBeat.i(97345);
    if (bs.aLy(bs.bG((String)bv.L(paramString, "adCanvasInfo").get(".adCanvasInfo.bizId"), "")) == 1)
    {
      AppMethodBeat.o(97345);
      return true;
    }
    AppMethodBeat.o(97345);
    return false;
  }
  
  public static boolean auO(String paramString)
  {
    AppMethodBeat.i(210267);
    boolean bool = jz(paramString, "adCanvasInfo");
    AppMethodBeat.o(210267);
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
      if (!paramString.yjA) {
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
      com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "comp " + paramString.toString() + " ifCondition is false");
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
      localq.backgroundColor = ((int)(bs.getDouble((String)paramMap.get(paramString + ".bgColorAlpha"), 0.0D) * 255.0D) << 24 | i & 0xFFFFFF);
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
        if (paramString.yjA) {
          localq.yjb.add(paramString);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "%s", new Object[] { bs.m(localException) });
        localq.backgroundColor = Color.argb(51, 0, 0, 0);
        continue;
        paramString = localException + i;
      }
      label260:
      AppMethodBeat.o(97336);
    }
    return localq;
  }
  
  private static ag d(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97337);
    ag localag = new ag();
    a(localag, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localag.ykf = bs.aLy((String)paramMap.get(paramString + ".pageCtrType"));
    boolean bool;
    String str1;
    int i;
    if (bs.aLy((String)paramMap.get(paramString + ".isFullScreen")) == 1)
    {
      bool = true;
      localag.mwy = bool;
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
        if (paramString.yjA) {
          localq.yjb.add(paramString);
        }
        j += 1;
        break label176;
        bool = false;
        break;
        paramString = str1 + i;
        break label142;
      }
      label280:
      if (localq.yjb.size() == 0) {
        break label311;
      }
      localag.yjb.add(localq);
      i += 1;
    }
    label311:
    AppMethodBeat.o(97337);
    return localag;
  }
  
  private static boolean dLM()
  {
    AppMethodBeat.i(97349);
    c localc = com.tencent.mm.model.c.d.aAp().tJ("100150");
    if (localc.isValid())
    {
      int i = bs.getInt((String)localc.eYV().get("openCanvas"), 0);
      com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "canOpenGameCanvas abtest=".concat(String.valueOf(i)));
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
  
  private static void dLN()
  {
    AppMethodBeat.i(97354);
    if (yuD != null)
    {
      AppMethodBeat.o(97354);
      return;
    }
    yuD = new HashSet();
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    for (;;)
    {
      int k;
      try
      {
        localInputStream = com.tencent.mm.sdk.platformtools.ai.getContext().getAssets().open("sns/canvas_valid_type.xml");
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
            if (bs.getInt(localXmlPullParser.getAttributeValue(null, "android"), 0) != 1) {
              continue;
            }
            localObject2 = localInputStream;
            localObject4 = localInputStream;
            localObject1 = localInputStream;
            i1 = bs.getInt(localXmlPullParser.getAttributeValue(null, "val"), -1);
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
          ((i.b)localObject5).yuH = i;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((i.b)localObject5).yuI = k;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((i.b)localObject5).yuJ = i1;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          yuD.add(localObject5);
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "valid canvas type ".concat(String.valueOf(localObject5)));
          m = i;
        }
      }
      catch (IOException localIOException6)
      {
        InputStream localInputStream;
        localObject1 = localObject2;
        com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", bs.m(localIOException6));
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
        com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", bs.m(localXmlPullParserException));
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
    localy.yjD = bs.aLy((String)paramMap.get(paramString + ".subType"));
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
      if (paramString.yjA) {
        localy.yjC.add(paramString);
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
    localw.bsA = ((List)localObject);
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
      if (paramString.yjA) {
        localw.bsA.add(paramString);
      }
      i += 1;
      break;
    }
    label147:
    AppMethodBeat.o(97340);
    return localw;
  }
  
  public static void fD(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k> paramList)
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
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k localk = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k)localIterator.next();
      if (OV(localk.dKA().type)) {
        localArrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)localk).dKu());
      }
    }
    if (!localArrayList.isEmpty())
    {
      fD(localArrayList);
      paramList.addAll(localArrayList);
    }
    AppMethodBeat.o(97357);
  }
  
  private static x g(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97341);
    Object localObject = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    v localv = new v();
    localv.fO = com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), bs.aLy((String)paramMap.get(paramString + ".cornerRadius")));
    localv.bsA = ((List)localObject);
    a(localv, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localObject = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = (String)localObject;; paramString = (String)localObject + i)
    {
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label190;
      }
      if (paramString.yjA) {
        localv.bsA.add(paramString);
      }
      i += 1;
      break;
    }
    label190:
    AppMethodBeat.o(97341);
    return localv;
  }
  
  public static String jx(String paramString1, String paramString2)
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
  
  public static String jy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97344);
    Object localObject2 = new String(paramString1);
    Object localObject1 = localObject2;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString2);
      localObject1 = localObject2;
      com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "the jsonObject is " + localJSONObject.toString());
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
        if (bs.isNullOrNil(str)) {
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
      com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "the json is parsed error : ".concat(String.valueOf(paramString1)));
      localObject2 = localObject1;
      AppMethodBeat.o(97344);
      return localObject2;
    }
  }
  
  public static boolean jz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97353);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(97353);
      return false;
    }
    if (yuD == null) {
      dLN();
    }
    if ((yuD != null) && (!yuD.isEmpty()))
    {
      Map localMap = bv.L(paramString1, paramString2);
      if ((localMap == null) || (localMap.isEmpty()))
      {
        com.tencent.mm.sdk.platformtools.ac.w("AdLandingPagesParseHelper", "invalid landingpages xml,".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(97353);
        return false;
      }
      i.b localb = new i.b((byte)0);
      localb.yuH = 0;
      localb.yuI = bs.aLy((String)localMap.get(".adCanvasInfo.type"));
      localb.yuJ = bs.aLy((String)localMap.get(".adCanvasInfo.subtype"));
      if (!yuD.contains(localb))
      {
        com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "invalid canvas type ".concat(String.valueOf(localb)));
        AppMethodBeat.o(97353);
        return false;
      }
      int i = 0;
      for (;;)
      {
        localb.yuH = 1;
        if (i == 0) {}
        for (paramString1 = ".adCanvasInfo.PageList.Page";; paramString1 = ".adCanvasInfo.PageList.Page" + i)
        {
          if (!localMap.containsKey(paramString1 + ".componentItemList.componentItem.type")) {
            break label591;
          }
          localb.yuI = bs.aLy((String)localMap.get(paramString1 + ".type"));
          localb.yuJ = bs.aLy((String)localMap.get(paramString1 + ".subType"));
          if (yuD.contains(localb)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "invalid page type ".concat(String.valueOf(localb)));
          AppMethodBeat.o(97353);
          return false;
        }
        paramString2 = paramString1 + ".componentItemList.componentItem";
        localb.yuH = 2;
        int j = 0;
        for (;;)
        {
          if (j == 0) {}
          for (paramString1 = paramString2;; paramString1 = paramString2 + j)
          {
            if (!localMap.containsKey(paramString1 + ".type")) {
              break label584;
            }
            localb.yuI = bs.aLy((String)localMap.get(paramString1 + ".type"));
            localb.yuJ = bs.aLy((String)localMap.get(paramString1 + ".subType"));
            if (yuD.contains(localb)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(localb)));
            AppMethodBeat.o(97353);
            return false;
          }
          j += 1;
        }
        label584:
        i += 1;
      }
      label591:
      localb.yuH = 2;
      paramString1 = localMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        Object localObject = (Map.Entry)paramString1.next();
        if ((((Map.Entry)localObject).getKey() != null) && (((String)((Map.Entry)localObject).getKey()).matches("[\\s\\S]*\\.componentItem[0-9]*\\.type$")))
        {
          paramString2 = (String)((Map.Entry)localObject).getKey();
          localObject = ((String)((Map.Entry)localObject).getKey()).replace(".type", ".subType");
          localb.yuI = bs.aLy((String)localMap.get(paramString2));
          localb.yuJ = bs.aLy((String)localMap.get(localObject));
          if (!yuD.contains(localb))
          {
            com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(localb)));
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
        com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", "append url params failed, %s", new Object[] { paramString.toString() });
        AppMethodBeat.o(97348);
        return str1;
      }
    }
    paramString = str1 + paramString + paramVarArgs;
    AppMethodBeat.o(97348);
    return paramString;
  }
  
  private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e v(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(200320);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e locale = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e();
    locale.yiq = bs.bG((String)paramMap.get(paramString + ".webViewUrl"), "");
    locale.yis = bs.l(paramMap.get(paramString + ".webViewHeight"), 0);
    locale.yir = bs.l(paramMap.get(paramString + ".webViewWidth"), 0);
    locale.yit = bs.l(paramMap.get(paramString + ".hideWebViewProgress"), 0);
    AppMethodBeat.o(200320);
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
      if ((!TextUtils.isEmpty(str2)) && (jz(str2, "adCanvasInfo")))
      {
        str1 = "";
        bool2 = auN(str2);
        if (!bool2) {
          break label284;
        }
        str1 = com.tencent.mm.model.c.d.aAq().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
        if (!TextUtils.isEmpty(str1))
        {
          int i = com.tencent.mm.model.c.d.aAq().fP("Sns_Canvas_GameShare_JumpWay", 0);
          com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "abtestvalue = ".concat(String.valueOf(i)));
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
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(97350);
        return true;
        bool1 = true;
        continue;
        bool1 = dLM();
      }
      else
      {
        bool1 = a(str2, paramContext, bool2, paramIntent.getIntExtra("sns_landig_pages_from_source", -1));
        AppMethodBeat.o(97350);
        return bool1;
        com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str2 });
        AppMethodBeat.o(97350);
        return false;
        label284:
        bool1 = true;
      }
    }
  }
  
  public static final class a
  {
    public LinkedList<g> yuE;
    public ab yuF;
    public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e yuG;
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97329);
      this.yuE = new LinkedList();
      this.yuF = null;
      this.yuG = null;
      long l = System.currentTimeMillis();
      jA(paramString1, paramString2);
      com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "parse adlanding xml, timeCost=" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(97329);
    }
    
    private void jA(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97330);
      if (TextUtils.isEmpty(paramString1))
      {
        AppMethodBeat.o(97330);
        return;
      }
      paramString1 = i.jx(paramString1, "");
      Map localMap = bv.L(paramString1, paramString2);
      if (localMap == null)
      {
        com.tencent.mm.sdk.platformtools.ac.w("AdLandingPagesParseHelper", " parse landingpages xml is error ,".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(97330);
        return;
      }
      int i1 = bs.aLy((String)localMap.get("." + paramString2 + ".adCanvasInfo.sizeType"));
      int j = bs.aLy((String)localMap.get("." + paramString2 + ".adCanvasInfo.basicRootFontSize"));
      int k = bs.aLy((String)localMap.get("." + paramString2 + ".adCanvasInfo.basicWidth"));
      int i = j;
      if (j == 0)
      {
        i = j;
        if (i1 == 1) {
          i = i.yuC;
        }
      }
      j = k;
      if (k == 0)
      {
        j = k;
        if (i1 == 1) {
          j = i.yuB;
        }
      }
      if ((!bs.isNullOrNil(paramString2)) && (!".adCanvasInfo.PageList.Page".equals("adCanvasInfo"))) {}
      for (paramString1 = "." + paramString2 + ".adCanvasInfo.PageList.Page";; paramString1 = ".adCanvasInfo.PageList.Page")
      {
        k = 0;
        Object localObject1;
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
            localg.yuu = bs.bG((String)localMap.get((String)localObject1 + ".backgroundCover"), "");
            localg.jBX = bs.bG((String)localMap.get((String)localObject1 + ".backgroundColor"), "");
            if (bs.aLy((String)localMap.get((String)localObject1 + ".backgroundCover.$isAddBlur")) <= 0) {
              break label628;
            }
            bool = true;
            localg.yuv = bool;
            localg.id = k;
            localObject2 = (String)localObject1 + ".if";
            if (!localMap.containsKey(localObject2)) {
              break label640;
            }
            if (!"1".equals(localMap.get(localObject2))) {
              break label634;
            }
            bool = true;
            localg.yuy = bool;
            if (!localg.yuy) {
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
              if (TextUtils.isEmpty(localg.jBX)) {
                continue;
              }
              n = Color.parseColor(localg.jBX);
              localx1 = i.b(localMap, i1, j, i, n, (String)localObject2);
            }
            catch (Exception localException)
            {
              int n;
              x localx1;
              label628:
              label634:
              com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", bs.m(localException));
              label640:
              label649:
              x localx2 = i.b(localMap, i1, j, i, 0, (String)localObject2);
              continue;
              localg.yuw.add(localx2);
              continue;
              com.tencent.mm.sdk.platformtools.ac.i("AdLandingPagesParseHelper", "comp " + localx2.toString() + " ifCondition is false");
              continue;
              localObject2 = (String)localObject1 + ".forbiddenGlobalItems.id";
              m = 0;
              if (m != 0) {
                continue;
              }
              localObject1 = localObject2;
              localObject1 = bs.bG((String)localMap.get(localObject1), "");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              localg.yuz.add(localObject1);
              m += 1;
              continue;
              localObject1 = (String)localObject2 + m;
              continue;
              if (localg.yuw.size() == 0) {
                break label893;
              }
            }
            if (localx1 == null) {
              continue;
            }
            if (!localx1.yjA) {
              continue;
            }
            i.b(localx1, localMap, (String)localObject2, i1, j, i);
            if (!(localx1 instanceof v)) {
              continue;
            }
            localg.yux.put(localx1.yjs, localx1);
            m += 1;
            break label496;
            localObject1 = paramString1 + k;
            break;
            bool = false;
            break label388;
            bool = false;
            break label456;
            localg.yuy = true;
            break label463;
            localObject2 = str + m;
            continue;
            n = 0;
          }
          this.yuE.add(localg);
          label884:
          k += 1;
        }
        label893:
        if ((this.yuE != null) && (this.yuE.size() > 0)) {
          ((g)this.yuE.get(0)).sWJ = true;
        }
        paramString2 = "." + paramString2 + ".adCanvasInfo.globalComponentItems.componentItem";
        k = 0;
        for (;;)
        {
          if (k == 0) {
            paramString1 = paramString2;
          }
          try
          {
            for (;;)
            {
              paramString1 = i.b(localMap, i1, j, i, 0, paramString1);
              if (!(paramString1 instanceof ab)) {
                break;
              }
              this.yuF = ((ab)paramString1);
              if (this.yuF == null) {
                break label1174;
              }
              paramString1 = this.yuE.iterator();
              for (;;)
              {
                if (!paramString1.hasNext()) {
                  break label1174;
                }
                paramString2 = (g)paramString1.next();
                if (paramString2.yuz.size() > 0)
                {
                  localObject1 = paramString2.yuz.iterator();
                  if (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (String)((Iterator)localObject1).next();
                    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(this.yuF.yjs)) || (!((String)localObject2).equals(this.yuF.yjs))) {
                      break;
                    }
                    paramString2.yuA = true;
                  }
                }
              }
              paramString1 = paramString2 + k;
            }
          }
          catch (Exception paramString1)
          {
            do
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ac.e("AdLandingPagesParseHelper", bs.m(paramString1));
                paramString1 = null;
                continue;
                if (!(paramString1 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)) {
                  break;
                }
                this.yuG = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)paramString1);
              }
            } while (paramString1 == null);
            k += 1;
          }
        }
        label1174:
        AppMethodBeat.o(97330);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i
 * JD-Core Version:    0.7.0.1
 */