package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.b;
import com.tencent.mm.plugin.sns.storage.ADXml.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
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
  public static int Eln = 750;
  public static int Elo = 10;
  private static Set<i.b> Elp = null;
  
  private static String K(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(97356);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("AdLandingPagesParseHelper", "the adLandingPagesXml is empty");
      AppMethodBeat.o(97356);
      return null;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      Log.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
      AppMethodBeat.o(97356);
      return null;
    }
    LinkedList localLinkedList = new a(paramString, "adxml").Elq;
    Iterator localIterator1 = paramMap.keySet().iterator();
    String str1 = paramString;
    String str3;
    String str2;
    Iterator localIterator2;
    while (localIterator1.hasNext())
    {
      str3 = (String)localIterator1.next();
      if (!Util.isNullOrNil(str3))
      {
        str2 = (String)paramMap.get(str3);
        if (!Util.isNullOrNil(str2))
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
        Iterator localIterator3 = ((g)localIterator2.next()).Eli.iterator();
        while (localIterator3.hasNext())
        {
          z localz = (z)localIterator3.next();
          if (((localz instanceof f)) && (!Util.isNullOrNil(((f)localz).cardTpId)) && (((f)localz).cardTpId.equals(str3)))
          {
            paramString = ((f)localz).cardExt;
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
          if (Util.isNullOrNil(paramString)) {
            break label333;
          }
          Log.i("AdLandingPagesParseHelper", "old card ext is " + paramString + " and new card ext is " + str2);
          str1 = str1.replace(paramString, str2);
          try
          {
            paramString = str1.replace(Util.escapeStringForXml(paramString), Util.escapeStringForXml(str2));
            str1 = paramString;
          }
          catch (Exception paramString)
          {
            Log.e("AdLandingPagesParseHelper", "the xml is error");
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
  
  private static e L(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(203162);
    e locale = new e();
    locale.DXV = Util.nullAs((String)paramMap.get(paramString + ".webViewUrl"), "");
    locale.DXX = Util.safeParseInt((String)paramMap.get(paramString + ".webViewHeight"));
    locale.DXW = Util.safeParseInt((String)paramMap.get(paramString + ".webViewWidth"));
    locale.DXY = Util.safeParseInt((String)paramMap.get(paramString + ".hideWebViewProgress"));
    AppMethodBeat.o(203162);
    return locale;
  }
  
  public static String Q(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97355);
    if (paramSnsInfo == null)
    {
      Log.e("AdLandingPagesParseHelper", "the snsinfo is null");
      AppMethodBeat.o(97355);
      return null;
    }
    if (!paramSnsInfo.isAd())
    {
      Log.e("AdLandingPagesParseHelper", "the snsinfo is not a ad");
      AppMethodBeat.o(97355);
      return null;
    }
    AdSnsInfo localAdSnsInfo = paramSnsInfo.getAdSnsInfo();
    if (localAdSnsInfo == null)
    {
      Log.e("AdLandingPagesParseHelper", "the adSnsInfo is null");
      AppMethodBeat.o(97355);
      return null;
    }
    ADXml localADXml = paramSnsInfo.getAdXml();
    if (localADXml == null)
    {
      Log.e("AdLandingPagesParseHelper", "the adxml is null");
      AppMethodBeat.o(97355);
      return null;
    }
    paramSnsInfo = paramSnsInfo.getAdInfo();
    if (paramSnsInfo == null)
    {
      Log.e("AdLandingPagesParseHelper", "the adInfo is null");
      AppMethodBeat.o(97355);
      return null;
    }
    if (!localADXml.isLandingPagesAd())
    {
      Log.e("AdLandingPagesParseHelper", "the snsinfo is not a landingpage");
      AppMethodBeat.o(97355);
      return null;
    }
    if ((paramSnsInfo.mappedCanvasCardExt == null) || (paramSnsInfo.mappedCanvasCardExt.size() == 0))
    {
      Log.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
      AppMethodBeat.o(97355);
      return null;
    }
    paramSnsInfo = K(localAdSnsInfo.field_adxml, paramSnsInfo.mappedCanvasCardExt);
    AppMethodBeat.o(97355);
    return paramSnsInfo;
  }
  
  public static boolean Zi(int paramInt)
  {
    return (paramInt == 101) || (paramInt == 103) || (paramInt == 104) || (paramInt == 105) || (paramInt == 139);
  }
  
  public static boolean Zj(int paramInt)
  {
    return paramInt == 101;
  }
  
  public static boolean Zk(int paramInt)
  {
    return paramInt == 103;
  }
  
  public static boolean Zl(int paramInt)
  {
    return paramInt == 104;
  }
  
  public static boolean Zm(int paramInt)
  {
    return paramInt == 105;
  }
  
  public static boolean Zn(int paramInt)
  {
    return paramInt == 139;
  }
  
  private static boolean Zo(int paramInt)
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
    int[] arrayOfInt = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap.ha(MMApplicationContext.getContext());
    paramInt1 = Math.min(arrayOfInt[0], arrayOfInt[1]);
    float f1 = (float)paramDouble;
    float f2 = paramInt3;
    f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap.bU(paramInt1 * (f1 * f2) / paramInt2);
    AppMethodBeat.o(97332);
    return f1;
  }
  
  private static z a(Map<String, String> paramMap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(97343);
    int i = Util.safeParseInt((String)paramMap.get(paramString + ".type"));
    z localz = null;
    if (!Zi(i)) {}
    for (;;)
    {
      try
      {
        localz = a(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
        paramMap = localz;
      }
      catch (Exception localException)
      {
        paramMap = a(paramMap, paramString, paramInt1, paramInt2, paramInt3, 0);
        continue;
      }
      AppMethodBeat.o(97343);
      return paramMap;
      if (Zj(i))
      {
        paramMap = d(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (Zk(i))
      {
        paramMap = e(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (Zl(i))
      {
        paramMap = f(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (Zm(i))
      {
        paramMap = g(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (Zn(i))
      {
        paramMap = h(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else
      {
        Log.e("AdLandingPagesParseHelper", "the type" + i + " is not client known type");
        paramMap = localException;
      }
    }
  }
  
  private static z a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97333);
    int k = Util.safeParseInt((String)paramMap.get(paramString + ".type"));
    int m = Util.safeParseInt((String)paramMap.get(paramString + ".subType"));
    Object localObject1;
    switch (k)
    {
    default: 
      AppMethodBeat.o(97333);
      return null;
    case 82: 
      localObject1 = new an();
      ((an)localObject1).url = Util.nullAs((String)paramMap.get(paramString + ".webviewUrl"), "");
      ((an)localObject1).DYM = Util.nullAs((String)paramMap.get(paramString + ".qrExtInfo"), "");
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((z)localObject1).DZm = Zo(paramInt4);
        ((z)localObject1).type = k;
        ((z)localObject1).subType = m;
        a((z)localObject1, paramMap, paramString, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(97333);
      return localObject1;
      localObject1 = c(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      continue;
      localObject1 = new ag();
      ((ag)localObject1).DZj = k;
      ((ag)localObject1).subType = m;
      ((ag)localObject1).DZP = Util.nullAs((String)paramMap.get(paramString + ".content"), "");
      ((ag)localObject1).textAlignment = Util.safeParseInt((String)paramMap.get(paramString + ".textAlignment"));
      ((ag)localObject1).zyf = Util.nullAs((String)paramMap.get(paramString + ".fontColor"), "");
      ((ag)localObject1).textSize = a(Util.safeParseDouble((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
      if ((Util.safeParseInt((String)paramMap.get(paramString + ".showType")) & ag.DZK) > 0)
      {
        bool = true;
        label632:
        ((ag)localObject1).DZQ = bool;
        if ((Util.safeParseInt((String)paramMap.get(paramString + ".showType")) & ag.DZL) <= 0) {
          break label857;
        }
        bool = true;
        label681:
        ((ag)localObject1).DZR = bool;
        if ((Util.safeParseInt((String)paramMap.get(paramString + ".showType")) & ag.DZM) <= 0) {
          break label863;
        }
      }
      label857:
      label863:
      for (boolean bool = true;; bool = false)
      {
        ((ag)localObject1).DZS = bool;
        ((ag)localObject1).maxLines = Util.safeParseInt((String)paramMap.get(paramString + ".maxLines"));
        ((ag)localObject1).DYv = Util.safeParseInt((String)paramMap.get(paramString + ".fontType"));
        ((ag)localObject1).DZT = Util.safeParseFloat((String)paramMap.get(paramString + ".lineSpace"));
        break;
        bool = false;
        break label632;
        bool = false;
        break label681;
      }
      label991:
      Object localObject2;
      if (m == 2)
      {
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).dNI = ((String)paramMap.get(paramString + ".appid"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXy = ((String)paramMap.get(paramString + ".wxAppid"));
        if (Util.safeParseInt((String)paramMap.get(paramString + ".useGameDownloadWidget")) == 1)
        {
          bool = true;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXz = bool;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).appPageUrl = ((String)paramMap.get(paramString + ".appPageUrlAndroid"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).channelId = ((String)paramMap.get(paramString + ".channelId"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).LG = ((String)paramMap.get(paramString + ".pkg"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXC = Util.safeParseInt((String)paramMap.get(paramString + ".platform"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXD = ((String)paramMap.get(paramString + ".warningAndroid"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXE = ((String)paramMap.get(paramString + ".btnBgColorTheme"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXG = ((String)paramMap.get(paramString + ".btnBgColorThemePressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXF = ((String)paramMap.get(paramString + ".btnBgColorThemeDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXH = ((String)paramMap.get(paramString + ".btnBorderColorTheme"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXJ = ((String)paramMap.get(paramString + ".btnBorderColorThemePressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXI = ((String)paramMap.get(paramString + ".btnBorderColorThemeDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXK = ((String)paramMap.get(paramString + ".fontColor"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXM = ((String)paramMap.get(paramString + ".fontColorPressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXL = ((String)paramMap.get(paramString + ".fontColorDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXP = Util.safeParseInt((String)paramMap.get(paramString + ".showDownloadTip"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXQ = Util.safeParseInt((String)paramMap.get(paramString + ".marketFlag"));
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXQ > 0)
          {
            localObject2 = aR(paramMap);
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).DXR = ((Intent)localObject2);
            }
          }
        }
      }
      Object localObject3;
      for (;;)
      {
        ((q)localObject1).DZj = k;
        ((q)localObject1).subType = m;
        ((q)localObject1).title = Util.nullAs((String)paramMap.get(paramString + ".btnTitle"), "");
        ((q)localObject1).DYq = Util.safeParseInt((String)paramMap.get(paramString + ".btnType"));
        ((q)localObject1).DYr = Util.nullAs((String)paramMap.get(paramString + ".btnJumpUrl"), "");
        ((q)localObject1).DYs = Util.nullAs((String)paramMap.get(paramString + ".btnJumpApp"), "");
        ((q)localObject1).DYt = Util.nullAs((String)paramMap.get(paramString + ".fontColor"), "");
        ((q)localObject1).fontSize = a(Util.safeParseDouble((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
        ((q)localObject1).DYv = Util.safeParseInt((String)paramMap.get(paramString + ".btnFontType"));
        ((q)localObject1).textAlignment = Util.safeParseInt((String)paramMap.get(paramString + ".btnAlignment"));
        ((q)localObject1).DYu = a(Util.safeParseDouble((String)paramMap.get(paramString + ".borderSize")), paramInt1, paramInt2, paramInt3);
        ((q)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".btnHeight")), paramInt1, paramInt2, paramInt3);
        ((q)localObject1).DYw = Util.nullAs((String)paramMap.get(paramString + ".btnBgColorTheme"), "");
        ((q)localObject1).DYx = Util.nullAs((String)paramMap.get(paramString + ".btnBorderColorTheme"), "");
        ((q)localObject1).DYy = Util.nullAs((String)paramMap.get(paramString + ".btnBgImgUrl"), "");
        ((q)localObject1).DYz = Util.safeParseInt((String)paramMap.get(paramString + ".bCanLongPress"));
        ((q)localObject1).DYA = Util.safeParseInt((String)paramMap.get(paramString + ".bHideActionSheet"));
        ((q)localObject1).DYB = Util.safeParseInt((String)paramMap.get(paramString + ".hideProductActionHeader"));
        ((q)localObject1).DYC = Util.safeParseInt((String)paramMap.get(paramString + ".showProductActionCancelButton"));
        ((q)localObject1).DYE = Util.nullAs((String)paramMap.get(paramString + ".productActionTitle"), "");
        ((q)localObject1).DYD = Util.nullAs((String)paramMap.get(paramString + ".productActionBuffer"), "");
        ((q)localObject1).DYF = Util.nullAs((String)paramMap.get(paramString + ".productActionIconUrl"), "");
        ((q)localObject1).tt = a(Util.safeParseInt((String)paramMap.get(paramString + ".cornerRadius")), paramInt1, paramInt2, paramInt3);
        ((q)localObject1).DYH = Util.nullAs((String)paramMap.get(paramString + ".btnIconUrl"), "");
        if (paramMap.containsKey(paramString + ".productActionItem.componentItem.type")) {
          ((q)localObject1).DYG = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString + ".productActionItem.componentItem");
        }
        break;
        bool = false;
        break label991;
        if (m == 4)
        {
          localObject1 = new f();
          ((f)localObject1).cardTpId = Util.nullAs((String)paramMap.get(paramString + ".cardTpId"), "");
          ((f)localObject1).cardExt = Util.nullAs((String)paramMap.get(paramString + ".cardExt"), "");
        }
        else if (m == 7)
        {
          localObject1 = new l();
          ((l)localObject1).DYd = Util.nullAs((String)paramMap.get(paramString + ".jumpCanvasId"), "");
          ((l)localObject1).DYe = Util.nullAs((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
          ((l)localObject1).DYf = Util.safeParseInt((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
          ((l)localObject1).DYg = Util.safeParseInt((String)paramMap.get(paramString + ".btnCanvasEnterType"));
          ((l)localObject1).DYh = Util.safeParseInt((String)paramMap.get(paramString + ".btnCanvasSource"));
        }
        else if (m == 8)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1).username = ((String)paramMap.get(paramString + ".weappUserName"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1).ecK = ((String)paramMap.get(paramString + ".weappPath"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1).weAppType = Util.safeParseInt((String)paramMap.get(paramString + ".miniProgramType"));
        }
        else if (m == 9)
        {
          d1 = Util.safeParseDouble((String)paramMap.get(paramString + ".location.$x"));
          d2 = Util.safeParseDouble((String)paramMap.get(paramString + ".location.$y"));
          i = Util.safeParseInt((String)paramMap.get(paramString + ".location.$scale"));
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
              break label3301;
            }
            ((List)localObject3).add(localObject1);
            i += 1;
            break;
          }
          label3301:
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
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).weappUserName = ((String)paramMap.get(paramString + ".weappUserName"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).DYj = ((String)paramMap.get(paramString + ".weAppID"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).businessId = ((String)paramMap.get(paramString + ".businessId"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).lRW = ((String)paramMap.get(paramString + ".sessionFrom"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).DYk = Util.safeParseInt((String)paramMap.get(paramString + ".showMessageCard"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).lSf = Util.nullAsNil((String)paramMap.get(paramString + ".sendMessageTitle"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).lSh = Util.nullAsNil((String)paramMap.get(paramString + ".sendMessageImg"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).lSg = Util.nullAsNil((String)paramMap.get(paramString + ".sendMessagePath"));
        }
        else if (m == 13)
        {
          localObject1 = new o();
          ((o)localObject1).DYl = Util.safeParseInt((String)paramMap.get(paramString + ".sid"));
          ((o)localObject1).DYm = Util.safeParseInt((String)paramMap.get(paramString + ".compid"));
        }
        else if (m == 14)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).DXZ = Util.nullAsNil((String)paramMap.get(paramString + ".redEnvelopsSkinBtnDisableWording"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).DYa = Util.safeParseLong(paramString + ".redEnvelopsSkinDisableTime");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).dOD = Util.nullAsNil((String)paramMap.get(paramString + ".redEnvelopesSkinId"));
        }
        else if (m == 15)
        {
          localObject1 = new ab();
          ((ab)localObject1).DZy = Util.nullAs((String)paramMap.get(paramString + ".qrUrl"), "");
          ((ab)localObject1).DYM = Util.nullAs((String)paramMap.get(paramString + ".qrExtInfo"), "");
          ((ab)localObject1).DZz = Util.safeParseInt((String)paramMap.get(paramString + ".needUpdateQrUrl"));
        }
        else if (m == 16)
        {
          localObject1 = new ac();
          ((ac)localObject1).DZA = ADXml.b.F(paramMap, ".adxml.adScanInfo");
        }
        else if (m == 17)
        {
          localObject1 = new w();
          ((w)localObject1).brandUsername = Util.nullAs((String)paramMap.get(paramString + ".brandUsername"), "");
          ((w)localObject1).brandHead = Util.nullAs((String)paramMap.get(paramString + ".brandHead"), "");
          ((w)localObject1).brandName = Util.nullAs((String)paramMap.get(paramString + ".brandName"), "");
          ((w)localObject1).brandDesc = Util.nullAs((String)paramMap.get(paramString + ".brandDesc"), "");
          ((w)localObject1).btnTitleAfterAddBrand = Util.nullAs((String)paramMap.get(paramString + ".btnTitleAfterAddBrand"), "");
        }
        else if (m == 18)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)localObject1).DYi = Util.nullAsNil((String)paramMap.get(paramString + ".wxGroupInfo"));
        }
        else if (m == 19)
        {
          localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.component.b.a();
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).couponAppId = Util.nullAs((String)paramMap.get(paramString + ".couponAppId"), "");
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).couponStockId = Util.nullAs((String)paramMap.get(paramString + ".couponStockId"), "");
        }
        else if (m == 20)
        {
          localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.component.b.c();
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.c)localObject1).finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.c)localObject1).finderLiveNoticeId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveNoticeId"));
        }
        else
        {
          localObject1 = new q();
        }
      }
      localObject1 = new t();
      ((t)localObject1).DZj = k;
      ((t)localObject1).subType = m;
      ((t)localObject1).DYK = Util.nullAs((String)paramMap.get(paramString + ".pureImageUrl"), "");
      ((t)localObject1).DWN = Util.nullAs((String)paramMap.get(paramString + ".bgColor"), "");
      if ((paramMap.containsKey(paramString + ".bgColorAlpha")) && (((t)localObject1).DWN.length() > 0)) {
        ((t)localObject1).DWN = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(paramString + ".bgColorAlpha")) * 255.0D)), ((t)localObject1).DWN.substring(1) });
      }
      ((t)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((t)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      ((t)localObject1).DYJ = false;
      if (Util.safeParseInt((String)paramMap.get(paramString + ".enableQRScan")) == 1)
      {
        bool = true;
        label4831:
        ((t)localObject1).DYL = bool;
        ((t)localObject1).DYM = Util.nullAs((String)paramMap.get(paramString + ".qrExtInfo"), "");
        if (Util.safeParseInt((String)paramMap.get(paramString + ".needUpdateQrUrl")) != 1) {
          break label4977;
        }
      }
      label4977:
      for (bool = true;; bool = false)
      {
        ((t)localObject1).DYN = bool;
        ((t)localObject1).tt = a(Util.safeParseInt((String)paramMap.get(paramString + ".cornerRadius")), paramInt1, paramInt2, paramInt3);
        break;
        bool = false;
        break label4831;
      }
      localObject1 = new s();
      ((s)localObject1).DZj = k;
      ((s)localObject1).subType = m;
      ((s)localObject1).DYK = Util.nullAs((String)paramMap.get(paramString + ".panoramaImageUrl"), "");
      ((s)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((s)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      continue;
      localObject1 = new t();
      ((t)localObject1).DZj = k;
      ((t)localObject1).subType = m;
      ((t)localObject1).DYK = Util.nullAs((String)paramMap.get(paramString + ".fullScreenImageUrl"), "");
      ((t)localObject1).DYJ = true;
      if (Util.safeParseInt((String)paramMap.get(paramString + ".enableQRScan")) == 1) {}
      for (bool = true;; bool = false)
      {
        ((t)localObject1).DYL = bool;
        ((t)localObject1).scaleType = Util.safeParseInt((String)paramMap.get(paramString + ".scaleType"));
        break;
      }
      localObject1 = new v();
      ((v)localObject1).DZj = k;
      ((v)localObject1).subType = m;
      ((v)localObject1).DYQ = Util.nullAs((String)paramMap.get(paramString + ".sightVideoUrl"), "");
      ((v)localObject1).DYR = Util.nullAs((String)paramMap.get(paramString + ".sightThumbUrl"), "");
      ((v)localObject1).DYS = Util.nullAs((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((v)localObject1).DYT = Util.nullAs((String)paramMap.get(paramString + ".jumpText"), "");
      ((v)localObject1).DYd = Util.nullAs((String)paramMap.get(paramString + ".jumpCanvasId"), "");
      ((v)localObject1).DYe = Util.nullAs((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
      ((v)localObject1).DYf = Util.safeParseInt((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
      try
      {
        ((v)localObject1).DYU = Color.parseColor((String)paramMap.get(paramString + ".jumpTextColor"));
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((v)localObject1).DYV = Color.parseColor((String)paramMap.get(paramString + ".separatorColor"));
            ((v)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".sightDisplayWidth")), paramInt1, paramInt2, paramInt3);
            ((v)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".sightDisplayHeight")), paramInt1, paramInt2, paramInt3);
            ((v)localObject1).DYW = Util.safeParseInt((String)paramMap.get(paramString + ".sightDisplayType"));
            localObject2 = Util.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
            i = Util.safeParseInt((String)paramMap.get(paramString + ".floatStartTime"));
            if ((!Util.isNullOrNil((String)localObject2)) && (i > 0))
            {
              localObject3 = new ai();
              ((ai)localObject3).dVe = ((String)localObject2);
              ((ai)localObject3).Eab = i;
              ((v)localObject1).DYX = ((ai)localObject3);
            }
            if (Util.safeParseInt((String)paramMap.get(".adxml.adCanvasInfo.heightRoundingType")) <= 0) {
              break label6137;
            }
            bool = true;
            ((v)localObject1).DYY = bool;
            if (Util.safeParseInt((String)paramMap.get(paramString + ".downloadVideoByCdn")) <= 0) {
              break label6143;
            }
            bool = true;
            ((v)localObject1).DYZ = bool;
            if (Util.safeParseInt((String)paramMap.get(paramString + ".forbiddenControlView")) <= 0) {
              break label6149;
            }
            bool = true;
            ((v)localObject1).DZa = bool;
            ((v)localObject1).DZc = j(paramMap, paramString + ".floatBarComponentItem", paramInt1, paramInt2, paramInt3, paramInt4);
            ((v)localObject1).DZb = Util.safeParseLong((String)paramMap.get(paramString + ".fileSize"));
            break;
            localException1 = localException1;
            ((v)localObject1).DYU = Color.rgb(255, 255, 255);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ((v)localObject1).DYV = Color.rgb(255, 255, 255);
            continue;
            label6137:
            bool = false;
            continue;
            label6143:
            bool = false;
            continue;
            label6149:
            bool = false;
          }
        }
      }
      localObject1 = new am();
      ((am)localObject1).DZj = k;
      ((am)localObject1).subType = m;
      ((am)localObject1).DYS = Util.nullAs((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((am)localObject1).Ead = Util.nullAs((String)paramMap.get(paramString + ".streamVideoThumb"), "");
      ((am)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".streamDisplayWidth")), paramInt1, paramInt2, paramInt3);
      ((am)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".streamDisplayHeight")), paramInt1, paramInt2, paramInt3);
      ((am)localObject1).Eae = Util.safeParseInt((String)paramMap.get(paramString + ".streamDisplayType"));
      String str1 = Util.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
      int i = Util.safeParseInt((String)paramMap.get(paramString + ".floatStartTime"));
      if ((!Util.isNullOrNil(str1)) && (i > 0))
      {
        localObject3 = new ai();
        ((ai)localObject3).dVe = str1;
        ((ai)localObject3).Eab = i;
        ((am)localObject1).DYX = ((ai)localObject3);
      }
      if (Util.safeParseInt((String)paramMap.get(".adxml.adCanvasInfo.heightRoundingType")) > 0)
      {
        bool = true;
        label6513:
        ((am)localObject1).DYY = bool;
        ((am)localObject1).DZc = j(paramMap, paramString + ".floatBarComponentItem", paramInt1, paramInt2, paramInt3, paramInt4);
        if (Util.safeParseInt((String)paramMap.get(paramString + ".alwaysAutoPlay")) != 1) {
          break label6656;
        }
        bool = true;
        label6594:
        ((am)localObject1).Eaf = bool;
        if (Util.safeParseInt((String)paramMap.get(paramString + ".forceLandscapeWhenTurnToFullScreen")) != 1) {
          break label6662;
        }
      }
      label6656:
      label6662:
      for (bool = true;; bool = false)
      {
        ((am)localObject1).Eag = bool;
        break;
        bool = false;
        break label6513;
        bool = false;
        break label6594;
      }
      localObject1 = new al();
      ((al)localObject1).DZj = k;
      ((al)localObject1).subType = m;
      ((al)localObject1).h5Url = Util.nullAs((String)paramMap.get(paramString + ".webviewUrl"), "");
      continue;
      double d1 = a(Util.safeParseDouble((String)paramMap.get(paramString + ".topLineSize")), paramInt1, paramInt2, paramInt3);
      double d2 = a(Util.safeParseDouble((String)paramMap.get(paramString + ".bottomLineSize")), paramInt1, paramInt2, paramInt3);
      if (Zo(paramInt4)) {
        i = Color.argb(51, 0, 0, 0);
      }
      int j;
      for (;;)
      {
        if (k == 121)
        {
          double d3 = Util.safeParseDouble((String)paramMap.get(paramString + ".location.$x"));
          double d4 = Util.safeParseDouble((String)paramMap.get(paramString + ".location.$y"));
          j = Util.safeParseInt((String)paramMap.get(paramString + ".location.$scale"));
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
            break label7204;
          }
          ((List)localObject3).add(localObject1);
          j += 1;
          break;
        }
        label7204:
        if (!((List)localObject3).isEmpty())
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d(d1, d2, i, (List)localObject3);
        }
        else
        {
          AppMethodBeat.o(97333);
          return null;
          localObject1 = new ae();
          ((ae)localObject1).DZj = k;
          ((ae)localObject1).subType = m;
          ((ae)localObject1).label = Util.nullAs((String)paramMap.get(paramString + ".label"), "");
          ((ae)localObject1).value = ((float)Util.safeParseDouble((String)paramMap.get(paramString + ".value")));
          ((ae)localObject1).DZI = Util.nullAs((String)paramMap.get(paramString + ".foregroundImage"), "");
          ((ae)localObject1).fontSize = a(Util.safeParseDouble((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
          ((ae)localObject1).lco = Util.nullAs((String)paramMap.get(paramString + ".backgroundColor"), "");
          continue;
          localObject1 = b(paramMap, paramString, paramInt1, paramInt2, paramInt3);
          continue;
          localObject1 = new u();
          ((u)localObject1).DWM = Util.nullAs((String)paramMap.get(paramString + ".sphereThumbUrl"), "");
          ((u)localObject1).DWw = Util.safeParseInt((String)paramMap.get(paramString + ".displayType"));
          ((u)localObject1).DWK = Util.safeParseInt((String)paramMap.get(paramString + ".gestureDelayTime"));
          ((u)localObject1).DWL = Util.nullAs((String)paramMap.get(paramString + ".sphereImageUrl"), "");
          try
          {
            ((u)localObject1).DWN = Util.nullAs((String)paramMap.get(paramString + ".bgColor"), "");
            if ((paramMap.containsKey(paramString + ".bgColorAlpha")) && (((u)localObject1).DWN.length() > 0)) {
              ((u)localObject1).DWN = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(paramString + ".bgColorAlpha")) * 255.0D)), ((u)localObject1).DWN.substring(1) });
            }
          }
          catch (Exception localException3)
          {
            try
            {
              for (;;)
              {
                ((u)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
                ((u)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
                ((u)localObject1).DYO = Util.nullAs((String)paramMap.get(".adxml.adSphereCardInfo.sphereImageUrl"), "");
                ((u)localObject1).DYP = Util.nullAs((String)paramMap.get(".adxml.adSphereCardInfo.sphereThumbUrl"), "");
                break;
                localException3 = localException3;
                Log.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse color exp=" + localException3.toString());
              }
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                ((u)localObject1).width = 0.0F;
                ((u)localObject1).height = 0.0F;
                Log.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse size exp=" + localException4.toString());
              }
            }
          }
          localObject1 = new ad();
          ((ad)localObject1).DZB = Util.nullAs((String)paramMap.get(paramString + ".backgroundImg"), "");
          ((ad)localObject1).iconUrl = Util.nullAs((String)paramMap.get(paramString + ".iconUrl"), "");
          ((ad)localObject1).title = Util.nullAs((String)paramMap.get(paramString + ".title"), "");
          ((ad)localObject1).desc = Util.nullAs((String)paramMap.get(paramString + ".desc"), "");
          ((ad)localObject1).DZG = Util.safeParseInt((String)paramMap.get(paramString + ".onlyShowInTimelineAd"));
          if (Util.safeParseInt((String)paramMap.get(paramString + ".isFullClickable")) == 1)
          {
            bool = true;
            label8241:
            ((ad)localObject1).DZD = bool;
            ((ad)localObject1).DZE = ((int)a(Util.safeParseDouble((String)paramMap.get(paramString + ".appearPaddingTop")), paramInt1, paramInt2, paramInt3));
            ((ad)localObject1).DZF = ((int)a(Util.safeParseDouble((String)paramMap.get(paramString + ".appearPaddingBottom")), paramInt1, paramInt2, paramInt3));
          }
          try
          {
            str2 = paramString + ".backgroundColor";
            localObject3 = paramString + ".backgroundColorAlpha";
            ((ad)localObject1).lco = Util.nullAs((String)paramMap.get(str2), "");
            if ((paramMap.containsKey(localObject3)) && (((ad)localObject1).lco.length() > 0)) {
              ((ad)localObject1).lco = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(localObject3)) * 255.0D)), ((ad)localObject1).lco.substring(1) });
            }
          }
          catch (Exception localException6)
          {
            try
            {
              str2 = paramString + ".titleColor";
              localObject3 = paramString + ".titleColorAlpha";
              ((ad)localObject1).iyd = Util.nullAs((String)paramMap.get(str2), "");
              if ((paramMap.containsKey(localObject3)) && (((ad)localObject1).iyd.length() > 0)) {
                ((ad)localObject1).iyd = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(localObject3)) * 255.0D)), ((ad)localObject1).iyd.substring(1) });
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
                  ((ad)localObject1).DZC = Util.nullAs((String)paramMap.get(str2), "");
                  if ((paramMap.containsKey(localObject3)) && (((ad)localObject1).DZC.length() > 0)) {
                    ((ad)localObject1).DZC = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(localObject3)) * 255.0D)), ((ad)localObject1).DZC.substring(1) });
                  }
                  ((ad)localObject1).DZH = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
                  if (!(((ad)localObject1).DZH instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)) {
                    break label9154;
                  }
                  ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)((ad)localObject1).DZH).DXO = true;
                  break;
                  bool = false;
                  break label8241;
                  localException5 = localException5;
                  Log.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse backgroundColor exp=" + localException5.toString());
                  continue;
                  localException6 = localException6;
                  Log.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse titleColor exp=" + localException6.toString());
                }
              }
              catch (Exception localException7)
              {
                for (;;)
                {
                  Log.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse descColor exp=" + localException7.toString());
                }
              }
            }
          }
          localObject1 = L(paramMap, paramString);
          continue;
          localObject1 = new p();
          ((p)localObject1).DYo = Util.nullAs((String)paramMap.get(paramString + ".swipeText"), "");
          ((p)localObject1).DYp = Util.safeParseInt((String)paramMap.get(paramString + ".swipeActionType"));
          ((p)localObject1).jumpUrl = Util.nullAs((String)paramMap.get(paramString + ".jumpUrl"), "");
          continue;
          localObject1 = i(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
          continue;
          localObject1 = new af();
          ((af)localObject1).DZJ = Util.nullAsNil((String)paramMap.get(paramString + ".shareText"));
          ((af)localObject1).DYt = Util.nullAsNil((String)paramMap.get(paramString + ".fontColor"));
        }
      }
      else
      {
        label9154:
        localObject1 = null;
      }
    }
  }
  
  private static void a(z paramz, Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(97338);
    paramz.DZj = Util.safeParseInt((String)paramMap.get(paramString + ".type"));
    paramz.type = paramz.DZj;
    paramz.DZi = Util.nullAs((String)paramMap.get(paramString + ".id"), "");
    paramz.paddingTop = a(Util.safeParseDouble((String)paramMap.get(paramString + ".paddingTop")), paramInt1, paramInt2, paramInt3);
    paramz.paddingBottom = a(Util.safeParseDouble((String)paramMap.get(paramString + ".paddingBottom")), paramInt1, paramInt2, paramInt3);
    paramz.paddingLeft = a(Util.safeParseDouble((String)paramMap.get(paramString + ".paddingLeft")), paramInt1, paramInt2, paramInt3);
    paramz.paddingRight = a(Util.safeParseDouble((String)paramMap.get(paramString + ".paddingRight")), paramInt1, paramInt2, paramInt3);
    paramz.subType = Util.safeParseInt((String)paramMap.get(paramString + ".subType"));
    paramz.DZn = Util.nullAs((String)paramMap.get(paramString + ".cellBackgroundColor"), "");
    String str1 = paramString + ".if";
    label400:
    label453:
    label459:
    String str2;
    double d;
    if (paramMap.containsKey(str1)) {
      if ("1".equals(paramMap.get(str1)))
      {
        bool1 = true;
        paramz.DZq = bool1;
        str1 = paramString + ".noReport";
        if (!paramMap.containsKey(str1)) {
          break label867;
        }
        if (!"1".equals(paramMap.get(str1))) {
          break label861;
        }
        bool1 = true;
        paramz.DZr = bool1;
        str1 = Util.nullAs((String)paramMap.get(paramString + ".layoutWidth"), "");
        str2 = Util.nullAs((String)paramMap.get(paramString + ".layoutHeight"), "");
        if (TextUtils.isEmpty(str1)) {
          break label892;
        }
        d = Util.safeParseDouble(str1);
        if (d >= 0.0D) {
          break label875;
        }
        paramz.DZk = ((float)d);
        label560:
        if (TextUtils.isEmpty(str2)) {
          break label919;
        }
        d = Util.safeParseDouble(str2);
        if (d >= 0.0D) {
          break label902;
        }
        paramz.DZl = ((float)d);
        label589:
        str1 = (String)paramMap.get(paramString + ".verticalAlignment");
        str2 = (String)paramMap.get(paramString + ".horizontalAlignment");
        if (!TextUtils.isEmpty(str1)) {
          break label929;
        }
        paramz.DZo = -1;
        label664:
        if (!TextUtils.isEmpty(str2)) {
          break label941;
        }
        paramz.DZp = -1;
        label677:
        if (Util.safeParseInt((String)paramMap.get(paramString + ".isTwistAnimView")) != 1) {
          break label953;
        }
        bool1 = true;
        label716:
        paramz.DZs = bool1;
        if (Util.safeParseInt((String)paramMap.get(paramString + ".isDefaultTwistCard")) != 1) {
          break label959;
        }
      }
    }
    label902:
    label919:
    label929:
    label941:
    label953:
    label959:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramz.DZt = bool1;
      paramz.DZu = Util.nullAsNil((String)paramMap.get(paramString + ".twistCardId"));
      paramz.DZv = Util.nullAsNil((String)paramMap.get(paramString + ".jumpExtInfo"));
      AppMethodBeat.o(97338);
      return;
      bool1 = false;
      break;
      paramz.DZq = true;
      break label400;
      label861:
      bool1 = false;
      break label453;
      label867:
      paramz.DZr = false;
      break label459;
      label875:
      paramz.DZk = a(d, paramInt1, paramInt2, paramInt3);
      break label560;
      label892:
      paramz.DZk = 2.147484E+009F;
      break label560;
      paramz.DZl = a(d, paramInt1, paramInt2, paramInt3);
      break label589;
      paramz.DZl = 2.147484E+009F;
      break label589;
      paramz.DZo = Util.safeParseInt(str1);
      break label664;
      paramz.DZp = Util.safeParseInt(str2);
      break label677;
      bool1 = false;
      break label716;
    }
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, Activity paramActivity)
  {
    AppMethodBeat.i(97351);
    String str = paramTimeLineObject.canvasInfo;
    long l = new BigInteger(paramTimeLineObject.Id).longValue();
    LinkedList localLinkedList = paramTimeLineObject.ContentObj.LoV;
    boolean bool;
    Object localObject;
    int i;
    int j;
    if (!TextUtils.isEmpty(str))
    {
      if ((TextUtils.isEmpty(str)) || (!aQg(str))) {
        break label448;
      }
      paramTimeLineObject = "";
      bool = aQf(str);
      if (!bool) {
        break label468;
      }
      localObject = com.tencent.mm.model.c.d.aXv().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
      if (com.tencent.mm.model.c.d.aXv().gO("Sns_Canvas_GameShare_JumpWay", 0) == 0)
      {
        i = 0;
        j = i;
        paramTimeLineObject = (TimeLineObject)localObject;
        if (i == 0)
        {
          j = i;
          paramTimeLineObject = (TimeLineObject)localObject;
          if (fex())
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
        localObject = com.tencent.mm.plugin.sns.model.aj.faO().JJ(l);
        Intent localIntent = new Intent();
        if (localObject != null)
        {
          localIntent.putExtra("sns_landing_pages_share_sns_id", ((SnsInfo)localObject).getSnsId());
          localIntent.putExtra("sns_landing_pages_rawSnsId", ((SnsInfo)localObject).getTimeLine().Id);
          localIntent.putExtra("sns_landing_pages_ux_info", ((SnsInfo)localObject).getUxinfo());
          localIntent.putExtra("sns_landing_pages_aid", ((SnsInfo)localObject).getAid());
          localIntent.putExtra("sns_landing_pages_traceid", ((SnsInfo)localObject).getTraceid());
          localIntent.putExtra("sns_landing_pages_rec_src", ((SnsInfo)localObject).getAdRecSrc());
        }
        if ((localLinkedList != null) && (localLinkedList.size() > 0)) {
          localIntent.putExtra("sns_landing_pages_share_thumb_url", ((cnb)localLinkedList.get(0)).Msz);
        }
        localIntent.putExtra("sns_landing_pages_expid", paramTimeLineObject);
        localIntent.putExtra("sns_landig_pages_from_source", 11);
        localIntent.setClass(paramActivity, SnsAdNativeLandingPagesUI.class);
        localIntent.putExtra("sns_landing_pages_xml", str);
        localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        paramTimeLineObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramTimeLineObject.axQ(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Ljava/lang/String;JLjava/util/List;Landroid/app/Activity;IZ)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramTimeLineObject.pG(0));
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
        label448:
        Log.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str });
      }
      label468:
      j = 1;
    }
  }
  
  private static boolean a(String paramString, Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(97346);
    paramString = (String)XmlParser.parseXml(paramString, "adCanvasInfo", null).get(".adCanvasInfo.shareWebUrl");
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(97346);
      return false;
    }
    String str = paramString;
    if (paramBoolean) {
      str = "exp=" + com.tencent.mm.model.c.d.aXv().getExpIdByKey("Sns_Canvas_GameShare_JumpWay") + "_" + paramInt;
    }
    try
    {
      str = n(paramString, new String[] { str });
      paramString = str;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      label103:
      break label103;
    }
    Log.i("AdLandingPagesParseHelper", "canvas jump url ".concat(String.valueOf(paramString)));
    str = paramString;
    paramString = new Intent();
    paramString.putExtra("rawUrl", str);
    paramString.putExtra("showShare", true);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(97346);
    return true;
  }
  
  private static boolean aQf(String paramString)
  {
    AppMethodBeat.i(97345);
    if (Util.safeParseInt(Util.nullAs((String)XmlParser.parseXml(paramString, "adCanvasInfo", null).get(".adCanvasInfo.bizId"), "")) == 1)
    {
      AppMethodBeat.o(97345);
      return true;
    }
    AppMethodBeat.o(97345);
    return false;
  }
  
  public static boolean aQg(String paramString)
  {
    AppMethodBeat.i(258598);
    boolean bool = kG(paramString, "adCanvasInfo");
    AppMethodBeat.o(258598);
    return bool;
  }
  
  private static Intent aR(Map<String, String> paramMap)
  {
    AppMethodBeat.i(203159);
    paramMap = com.tencent.mm.plugin.sns.device.appstore.a.b(MMApplicationContext.getContext(), paramMap);
    if (paramMap != null)
    {
      paramMap = paramMap.eZA();
      AppMethodBeat.o(203159);
      return paramMap;
    }
    AppMethodBeat.o(203159);
    return null;
  }
  
  private static ao b(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(97334);
    localao = new ao();
    try
    {
      paramString = paramString + ".radarChart";
      localao.Eah = ((String)paramMap.get(paramString + ".borderImg"));
      localao.Ean = ((String)paramMap.get(paramString + ".maskImg"));
      localao.Eai = ((String)paramMap.get(paramString + ".coverColor"));
      localao.Eaj = Color.parseColor((String)paramMap.get(paramString + ".labelFont.$color"));
      localao.Eak = ((int)a(Util.safeParseDouble((String)paramMap.get(paramString + ".labelFont.$size")), paramInt1, paramInt2, paramInt3));
      localao.Eal = Color.parseColor((String)paramMap.get(paramString + ".scoreFont.$color"));
      localao.Eam = ((int)a(Util.safeParseDouble((String)paramMap.get(paramString + ".scoreFont.$size")), paramInt1, paramInt2, paramInt3));
      localao.borderWidth = a(Util.safeParseDouble((String)paramMap.get(paramString + ".borderImgWidth")), paramInt1, paramInt2, paramInt3);
      String str = paramString + ".itemList.item";
      paramInt1 = 0;
      if (paramInt1 != 0) {}
      for (paramString = str + paramInt1;; paramString = str)
      {
        ao.a locala = new ao.a();
        locala.label = ((String)paramMap.get(paramString + ".label"));
        locala.Eao = ((String)paramMap.get(paramString + ".score"));
        locala.value = ((float)Util.safeParseDouble((String)paramMap.get(paramString + ".value")));
        if ((TextUtils.isEmpty(locala.label)) && (TextUtils.isEmpty(locala.Eao))) {
          break label567;
        }
        localao.jzm.add(locala);
        paramInt1 += 1;
        break;
      }
      label567:
      return localao;
    }
    catch (Exception paramMap)
    {
      Log.e("AdLandingPagesParseHelper", Util.stackTraceToString(paramMap));
      AppMethodBeat.o(97334);
    }
  }
  
  private static List<z> b(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
      if (!paramString.DZq) {
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
      Log.i("AdLandingPagesParseHelper", "comp " + paramString.toString() + " ifCondition is false");
    }
    label147:
    AppMethodBeat.o(97335);
    return localArrayList;
  }
  
  private static r c(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97336);
    r localr = new r();
    try
    {
      i = Color.parseColor((String)paramMap.get(paramString + ".bgColorTheme"));
      localr.backgroundColor = ((int)(Util.getDouble((String)paramMap.get(paramString + ".bgColorAlpha"), 0.0D) * 255.0D) << 24 | i & 0xFFFFFF);
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
        if (paramString.DZq) {
          localr.DYI.add(paramString);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        Log.e("AdLandingPagesParseHelper", "%s", new Object[] { Util.stackTraceToString(localException) });
        localr.backgroundColor = Color.argb(51, 0, 0, 0);
        continue;
        paramString = localException + i;
      }
      label260:
      AppMethodBeat.o(97336);
    }
    return localr;
  }
  
  private static ak d(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97337);
    ak localak = new ak();
    a(localak, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localak.Eac = Util.safeParseInt((String)paramMap.get(paramString + ".pageCtrType"));
    boolean bool;
    label148:
    String str1;
    int i;
    if (Util.safeParseInt((String)paramMap.get(paramString + ".isFullScreen")) == 1)
    {
      bool = true;
      localak.onr = bool;
      if (Util.safeParseInt((String)paramMap.get(paramString + ".autoCarousel")) != 1) {
        break label278;
      }
      bool = true;
      localak.autoCarousel = bool;
      str1 = paramString + ".componentGroupList.componentGroup";
      i = 0;
    }
    for (;;)
    {
      label188:
      r localr;
      String str2;
      int j;
      if (i == 0)
      {
        paramString = str1;
        localr = new r();
        str2 = paramString + ".componentItem";
        j = 0;
        label222:
        if (j != 0) {
          break label308;
        }
      }
      label278:
      label308:
      for (paramString = str2;; paramString = str2 + j)
      {
        paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
        if (paramString == null) {
          break label332;
        }
        if (paramString.DZq) {
          localr.DYI.add(paramString);
        }
        j += 1;
        break label222;
        bool = false;
        break;
        bool = false;
        break label148;
        paramString = str1 + i;
        break label188;
      }
      label332:
      if (localr.DYI.size() == 0) {
        break label363;
      }
      localak.DYI.add(localr);
      i += 1;
    }
    label363:
    AppMethodBeat.o(97337);
    return localak;
  }
  
  private static z e(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97339);
    aa localaa = new aa();
    localaa.DZx = Util.safeParseInt((String)paramMap.get(paramString + ".subType"));
    localaa.DZh = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap.a(paramMap, paramString, paramInt1, paramInt2, paramInt3);
    a(localaa, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    String str = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = str;; paramString = str + i)
    {
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label176;
      }
      if (paramString.DZq) {
        localaa.DZw.add(paramString);
      }
      i += 1;
      break;
    }
    label176:
    AppMethodBeat.o(97339);
    return localaa;
  }
  
  private static z f(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97340);
    List localList = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    y localy = new y();
    localy.hH = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), Util.safeParseInt((String)paramMap.get(paramString + ".cornerRadius")));
    localy.aQz = localList;
    localy.DZh = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap.a(paramMap, paramString, paramInt1, paramInt2, paramInt3);
    a(localy, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(97340);
    return localy;
  }
  
  private static boolean fex()
  {
    AppMethodBeat.i(97349);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aXu().Fu("100150");
    if (localc.isValid())
    {
      int i = Util.getInt((String)localc.gzz().get("openCanvas"), 0);
      Log.i("AdLandingPagesParseHelper", "canOpenGameCanvas abtest=".concat(String.valueOf(i)));
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
  
  private static void fey()
  {
    AppMethodBeat.i(97354);
    if (Elp != null)
    {
      AppMethodBeat.o(97354);
      return;
    }
    Elp = new HashSet();
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    for (;;)
    {
      int k;
      try
      {
        localInputStream = MMApplicationContext.getContext().getAssets().open("sns/canvas_valid_type.xml");
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
            if (Util.getInt(localXmlPullParser.getAttributeValue(null, "android"), 0) != 1) {
              continue;
            }
            localObject2 = localInputStream;
            localObject4 = localInputStream;
            localObject1 = localInputStream;
            i1 = Util.getInt(localXmlPullParser.getAttributeValue(null, "val"), -1);
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
          ((i.b)localObject5).Elu = i;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((i.b)localObject5).Elv = k;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((i.b)localObject5).Elw = i1;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          Elp.add(localObject5);
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          Log.i("AdLandingPagesParseHelper", "valid canvas type ".concat(String.valueOf(localObject5)));
          m = i;
        }
      }
      catch (IOException localIOException6)
      {
        InputStream localInputStream;
        localObject1 = localObject2;
        Log.e("AdLandingPagesParseHelper", Util.stackTraceToString(localIOException6));
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
        Log.e("AdLandingPagesParseHelper", Util.stackTraceToString(localXmlPullParserException));
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
  
  private static z g(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97341);
    Object localObject = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    x localx = new x();
    localx.hH = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), Util.safeParseInt((String)paramMap.get(paramString + ".cornerRadius")));
    localx.DZd = Util.safeParseInt((String)paramMap.get(paramString + ".autoShow"));
    localx.DZe = Util.safeParseInt((String)paramMap.get(paramString + ".noAnimation"));
    localx.DZf = Util.safeParseInt((String)paramMap.get(paramString + ".forbiddenToClose"));
    localx.DZg = Util.safeParseInt((String)paramMap.get(paramString + ".noBackground"));
    localx.aQz = ((List)localObject);
    a(localx, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localObject = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = (String)localObject;; paramString = (String)localObject + i)
    {
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label338;
      }
      if (paramString.DZq) {
        localx.aQz.add(paramString);
      }
      i += 1;
      break;
    }
    label338:
    AppMethodBeat.o(97341);
    return localx;
  }
  
  public static void gU(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m> paramList)
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
      if (Zi(localm.fdk().type)) {
        localArrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)localm).eWU());
      }
    }
    if (!localArrayList.isEmpty())
    {
      gU(localArrayList);
      paramList.addAll(localArrayList);
    }
    AppMethodBeat.o(97357);
  }
  
  private static z h(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(203160);
    List localList = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.plugin.sns.ad.landingpage.component.b.b localb = new com.tencent.mm.plugin.sns.ad.landingpage.component.b.b();
    localb.aQz = localList;
    localb.DtQ = Util.nullAsNil((String)paramMap.get(paramString + ".transitionImg"));
    try
    {
      localb.DtR = com.tencent.mm.plugin.sns.data.k.jV(Util.nullAsNil((String)paramMap.get(paramString + ".transitionColor")), Util.nullAsNil((String)paramMap.get(paramString + ".transitionColorAlpha")));
      a(localb, paramMap, paramString, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(203160);
      return localb;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse color exp=" + localException.toString());
      }
    }
  }
  
  private static com.tencent.mm.plugin.sns.ad.landingpage.component.b.d i(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(203163);
    com.tencent.mm.plugin.sns.ad.landingpage.component.b.d locald = new com.tencent.mm.plugin.sns.ad.landingpage.component.b.d();
    locald.DtS = Util.nullAs((String)paramMap.get(paramString + ".title"), "");
    locald.DtT = Util.safeParseInt((String)paramMap.get(paramString + ".autoJump"));
    locald.DtU = Util.safeParseInt((String)paramMap.get(paramString + ".swipeJumpOffset"));
    paramMap = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramMap instanceof q)) {
      locald.DtV = ((q)paramMap);
    }
    AppMethodBeat.o(203163);
    return locald;
  }
  
  private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj j(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(203164);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj localaj = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj();
    a(localaj, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localaj.desc = Util.nullAs((String)paramMap.get(paramString + ".desc"), "");
    boolean bool;
    if (Util.safeParseInt((String)paramMap.get(paramString + ".isFullClickable")) == 1) {
      bool = true;
    }
    for (;;)
    {
      localaj.DZD = bool;
      try
      {
        String str1 = paramString + ".descColor";
        String str2 = paramString + ".descColorAlpha";
        localaj.DZC = Util.nullAs((String)paramMap.get(str1), "");
        if ((paramMap.containsKey(str2)) && (localaj.DZC.length() > 0)) {
          localaj.DZC = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(str2)) * 255.0D)), localaj.DZC.substring(1) });
        }
        localaj.DZH = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
        if ((localaj.DZH instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localaj.DZH).DXO = true;
        }
        AppMethodBeat.o(203164);
        return localaj;
        bool = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse descColor exp=" + localException.toString());
        }
      }
    }
  }
  
  public static String kE(String paramString1, String paramString2)
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
  
  public static String kF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97344);
    Object localObject2 = new String(paramString1);
    Object localObject1 = localObject2;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString2);
      localObject1 = localObject2;
      Log.i("AdLandingPagesParseHelper", "the jsonObject is " + localJSONObject.toString());
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
        if (Util.isNullOrNil(str)) {
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
      Log.e("AdLandingPagesParseHelper", "the json is parsed error : ".concat(String.valueOf(paramString1)));
      localObject2 = localObject1;
      AppMethodBeat.o(97344);
      return localObject2;
    }
  }
  
  public static boolean kG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97353);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(97353);
      return false;
    }
    if (Elp == null) {
      fey();
    }
    if ((Elp != null) && (!Elp.isEmpty()))
    {
      Map localMap = XmlParser.parseXml(paramString1, paramString2, null);
      if ((localMap == null) || (localMap.isEmpty()))
      {
        Log.w("AdLandingPagesParseHelper", "invalid landingpages xml,".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(97353);
        return false;
      }
      i.b localb = new i.b((byte)0);
      localb.Elu = 0;
      localb.Elv = Util.safeParseInt((String)localMap.get(".adCanvasInfo.type"));
      localb.Elw = Util.safeParseInt((String)localMap.get(".adCanvasInfo.subtype"));
      if (!Elp.contains(localb))
      {
        Log.i("AdLandingPagesParseHelper", "invalid canvas type ".concat(String.valueOf(localb)));
        AppMethodBeat.o(97353);
        return false;
      }
      int i = 0;
      for (;;)
      {
        localb.Elu = 1;
        if (i == 0) {}
        for (paramString1 = ".adCanvasInfo.PageList.Page";; paramString1 = ".adCanvasInfo.PageList.Page" + i)
        {
          if (!localMap.containsKey(paramString1 + ".componentItemList.componentItem.type")) {
            break label592;
          }
          localb.Elv = Util.safeParseInt((String)localMap.get(paramString1 + ".type"));
          localb.Elw = Util.safeParseInt((String)localMap.get(paramString1 + ".subType"));
          if (Elp.contains(localb)) {
            break;
          }
          Log.i("AdLandingPagesParseHelper", "invalid page type ".concat(String.valueOf(localb)));
          AppMethodBeat.o(97353);
          return false;
        }
        paramString2 = paramString1 + ".componentItemList.componentItem";
        localb.Elu = 2;
        int j = 0;
        for (;;)
        {
          if (j == 0) {}
          for (paramString1 = paramString2;; paramString1 = paramString2 + j)
          {
            if (!localMap.containsKey(paramString1 + ".type")) {
              break label585;
            }
            localb.Elv = Util.safeParseInt((String)localMap.get(paramString1 + ".type"));
            localb.Elw = Util.safeParseInt((String)localMap.get(paramString1 + ".subType"));
            if (Elp.contains(localb)) {
              break;
            }
            Log.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(localb)));
            AppMethodBeat.o(97353);
            return false;
          }
          j += 1;
        }
        label585:
        i += 1;
      }
      label592:
      localb.Elu = 2;
      paramString1 = localMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        Object localObject = (Map.Entry)paramString1.next();
        if ((((Map.Entry)localObject).getKey() != null) && (((String)((Map.Entry)localObject).getKey()).matches("[\\s\\S]*\\.componentItem[0-9]*\\.type$")))
        {
          paramString2 = (String)((Map.Entry)localObject).getKey();
          localObject = ((String)((Map.Entry)localObject).getKey()).replace(".type", ".subType");
          localb.Elv = Util.safeParseInt((String)localMap.get(paramString2));
          localb.Elw = Util.safeParseInt((String)localMap.get(localObject));
          if (!Elp.contains(localb))
          {
            Log.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(localb)));
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
        Log.e("AdLandingPagesParseHelper", "append url params failed, %s", new Object[] { paramString.toString() });
        AppMethodBeat.o(97348);
        return str1;
      }
    }
    paramString = str1 + paramString + paramVarArgs;
    AppMethodBeat.o(97348);
    return paramString;
  }
  
  public static boolean y(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(97350);
    String str2 = paramIntent.getStringExtra("sns_landing_pages_xml");
    String str1;
    boolean bool2;
    boolean bool1;
    if (!TextUtils.isEmpty(str2)) {
      if ((!TextUtils.isEmpty(str2)) && (kG(str2, "adCanvasInfo")))
      {
        str1 = "";
        bool2 = aQf(str2);
        if (!bool2) {
          break label307;
        }
        str1 = com.tencent.mm.model.c.d.aXv().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
        if (!TextUtils.isEmpty(str1))
        {
          int i = com.tencent.mm.model.c.d.aXv().gO("Sns_Canvas_GameShare_JumpWay", 0);
          Log.i("AdLandingPagesParseHelper", "abtestvalue = ".concat(String.valueOf(i)));
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
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (((paramContext instanceof Activity)) && (ADXml.k.aPT(str2))) {
          ((Activity)paramContext).overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(97350);
        return true;
        bool1 = true;
        continue;
        bool1 = fex();
      }
      else
      {
        bool1 = a(str2, paramContext, bool2, paramIntent.getIntExtra("sns_landig_pages_from_source", -1));
        AppMethodBeat.o(97350);
        return bool1;
        Log.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str2 });
        AppMethodBeat.o(97350);
        return false;
        label307:
        bool1 = true;
      }
    }
  }
  
  public static final class a
  {
    public LinkedList<g> Elq;
    public ad Elr;
    public e Els;
    public com.tencent.mm.plugin.sns.ad.landingpage.component.b.d Elt;
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97329);
      this.Elq = new LinkedList();
      this.Elr = null;
      this.Els = null;
      this.Elt = null;
      long l = System.currentTimeMillis();
      kH(paramString1, paramString2);
      Log.i("AdLandingPagesParseHelper", "parse adlanding xml, timeCost=" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(97329);
    }
    
    private void kH(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97330);
      if (TextUtils.isEmpty(paramString1))
      {
        AppMethodBeat.o(97330);
        return;
      }
      paramString1 = i.kE(paramString1, "");
      Map localMap = XmlParser.parseXml(paramString1, paramString2, null);
      if (localMap == null)
      {
        Log.w("AdLandingPagesParseHelper", " parse landingpages xml is error ,".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(97330);
        return;
      }
      int i1 = Util.safeParseInt((String)localMap.get("." + paramString2 + ".adCanvasInfo.sizeType"));
      int j = Util.safeParseInt((String)localMap.get("." + paramString2 + ".adCanvasInfo.basicRootFontSize"));
      int k = Util.safeParseInt((String)localMap.get("." + paramString2 + ".adCanvasInfo.basicWidth"));
      int i = j;
      if (j == 0)
      {
        i = j;
        if (i1 == 1) {
          i = i.Elo;
        }
      }
      j = k;
      if (k == 0)
      {
        j = k;
        if (i1 == 1) {
          j = i.Eln;
        }
      }
      if ((!Util.isNullOrNil(paramString2)) && (!".adCanvasInfo.PageList.Page".equals("adCanvasInfo"))) {}
      for (paramString1 = "." + paramString2 + ".adCanvasInfo.PageList.Page";; paramString1 = ".adCanvasInfo.PageList.Page")
      {
        k = 0;
        label389:
        Object localObject2;
        for (;;)
        {
          g localg;
          boolean bool;
          label457:
          label464:
          String str;
          int m;
          if (k == 0)
          {
            localObject1 = paramString1;
            localg = new g();
            localg.Elg = Util.nullAs((String)localMap.get((String)localObject1 + ".backgroundCover"), "");
            localg.lco = Util.nullAs((String)localMap.get((String)localObject1 + ".backgroundColor"), "");
            if (Util.safeParseInt((String)localMap.get((String)localObject1 + ".backgroundCover.$isAddBlur")) <= 0) {
              break label629;
            }
            bool = true;
            localg.Elh = bool;
            localg.id = k;
            localObject2 = (String)localObject1 + ".if";
            if (!localMap.containsKey(localObject2)) {
              break label641;
            }
            if (!"1".equals(localMap.get(localObject2))) {
              break label635;
            }
            bool = true;
            localg.Elk = bool;
            if (!localg.Elk) {
              break label885;
            }
            str = (String)localObject1 + ".componentItemList.componentItem";
            m = 0;
            label497:
            if (m != 0) {
              break label650;
            }
            localObject2 = str;
          }
          for (;;)
          {
            try
            {
              if (TextUtils.isEmpty(localg.lco)) {
                continue;
              }
              n = Color.parseColor(localg.lco);
              localz1 = i.b(localMap, i1, j, i, n, (String)localObject2);
            }
            catch (Exception localException2)
            {
              int n;
              z localz1;
              label629:
              label635:
              Log.e("AdLandingPagesParseHelper", Util.stackTraceToString(localException2));
              label641:
              label650:
              z localz2 = i.b(localMap, i1, j, i, 0, (String)localObject2);
              continue;
              localg.Eli.add(localz2);
              continue;
              Log.i("AdLandingPagesParseHelper", "comp " + localz2.toString() + " ifCondition is false");
              continue;
              localObject2 = (String)localObject1 + ".forbiddenGlobalItems.id";
              m = 0;
              if (m != 0) {
                continue;
              }
              localObject1 = localObject2;
              localObject1 = Util.nullAs((String)localMap.get(localObject1), "");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              localg.Ell.add(localObject1);
              m += 1;
              continue;
              localObject1 = (String)localObject2 + m;
              continue;
              if (localg.Eli.size() == 0) {
                break label894;
              }
            }
            if (localz1 == null) {
              continue;
            }
            if (!localz1.DZq) {
              continue;
            }
            i.b(localz1, localMap, (String)localObject2, i1, j, i);
            if (!(localz1 instanceof x)) {
              continue;
            }
            localg.Elj.put(localz1.DZi, localz1);
            m += 1;
            break label497;
            localObject1 = paramString1 + k;
            break;
            bool = false;
            break label389;
            bool = false;
            break label457;
            localg.Elk = true;
            break label464;
            localObject2 = str + m;
            continue;
            n = 0;
          }
          this.Elq.add(localg);
          label885:
          k += 1;
        }
        label894:
        if ((this.Elq != null) && (this.Elq.size() > 0)) {
          ((g)this.Elq.get(0)).xwi = true;
        }
        Object localObject1 = "." + paramString2 + ".adCanvasInfo.globalComponentItems.componentItem";
        k = 0;
        label1187:
        label1202:
        label1217:
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
                Log.e("AdLandingPagesParseHelper", Util.stackTraceToString(localException1));
              }
              Log.d("AdLandingPagesParseHelper", "parse the item: the global item existed, globalItemsStr = ".concat(String.valueOf(paramString1)));
              if (!(paramString2 instanceof ad)) {
                break label1187;
              }
              this.Elr = ((ad)paramString2);
              if (!(paramString2 instanceof e)) {
                break label1202;
              }
              this.Els = ((e)paramString2);
              if (!(paramString2 instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.b.d)) {
                break label1217;
              }
              this.Elt = ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.d)paramString2);
              k += 1;
            }
            if (paramString2 != null) {
              break;
            }
            Log.d("AdLandingPagesParseHelper", "parse the item: the global item is null, globalItemsStr = ".concat(String.valueOf(paramString1)));
            if (this.Elr == null) {
              break label1226;
            }
            paramString1 = this.Elq.iterator();
            for (;;)
            {
              if (!paramString1.hasNext()) {
                break label1226;
              }
              paramString2 = (g)paramString1.next();
              if (paramString2.Ell.size() > 0)
              {
                localObject1 = paramString2.Ell.iterator();
                if (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (String)((Iterator)localObject1).next();
                  if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(this.Elr.DZi)) || (!((String)localObject2).equals(this.Elr.DZi))) {
                    break;
                  }
                  paramString2.Elm = true;
                }
              }
            }
          }
        }
        label1226:
        AppMethodBeat.o(97330);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i
 * JD-Core Version:    0.7.0.1
 */