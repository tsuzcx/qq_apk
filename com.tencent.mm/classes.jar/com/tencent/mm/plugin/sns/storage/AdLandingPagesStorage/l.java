package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.adxml.d.a;
import com.tencent.mm.plugin.sns.ad.adxml.d.e;
import com.tencent.mm.plugin.sns.ad.landingpage.component.info.b.a;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aq;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ar.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.as;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
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

public final class l
{
  public static int QXw = 750;
  public static int QXx = 10;
  private static Set<l.b> QXy = null;
  
  public static String T(SnsInfo paramSnsInfo)
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
    paramSnsInfo = V(localAdSnsInfo.field_adxml, paramSnsInfo.mappedCanvasCardExt);
    AppMethodBeat.o(97355);
    return paramSnsInfo;
  }
  
  private static String V(String paramString, Map<String, String> paramMap)
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
    LinkedList localLinkedList = new a(paramString, "adxml").QXz;
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
        Iterator localIterator3 = ((h)localIterator2.next()).QXi.iterator();
        while (localIterator3.hasNext())
        {
          aa localaa = (aa)localIterator3.next();
          if (((localaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)) && (!Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localaa).wtm)) && (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localaa).wtm.equals(str3)))
          {
            paramString = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localaa).wui;
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
    int[] arrayOfInt = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar.jR(MMApplicationContext.getContext());
    paramInt1 = Math.min(arrayOfInt[0], arrayOfInt[1]);
    float f1 = (float)paramDouble;
    float f2 = paramInt3;
    f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar.dl(paramInt1 * (f1 * f2) / paramInt2);
    AppMethodBeat.o(97332);
    return f1;
  }
  
  private static aa a(Map<String, String> paramMap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(97343);
    int i = Util.safeParseInt((String)paramMap.get(paramString + ".type"));
    aa localaa = null;
    if (!als(i)) {}
    for (;;)
    {
      try
      {
        localaa = a(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
        paramMap = localaa;
      }
      catch (Exception localException)
      {
        paramMap = a(paramMap, paramString, paramInt1, paramInt2, paramInt3, 0);
        continue;
      }
      AppMethodBeat.o(97343);
      return paramMap;
      if (alt(i))
      {
        paramMap = d(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (alu(i))
      {
        paramMap = e(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (alv(i))
      {
        paramMap = f(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (alw(i))
      {
        paramMap = g(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (alx(i))
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
  
  private static aa a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
      localObject1 = new aq();
      ((aq)localObject1).url = Util.nullAs((String)paramMap.get(paramString + ".webviewUrl"), "");
      ((aq)localObject1).QKl = Util.nullAs((String)paramMap.get(paramString + ".qrExtInfo"), "");
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((aa)localObject1).QKK = aly(paramInt4);
        ((aa)localObject1).type = k;
        ((aa)localObject1).subType = m;
        a((aa)localObject1, paramMap, paramString, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(97333);
      return localObject1;
      localObject1 = c(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      continue;
      localObject1 = new ah();
      ((ah)localObject1).QKH = k;
      ((ah)localObject1).subType = m;
      ((ah)localObject1).QLp = Util.nullAs((String)paramMap.get(paramString + ".content"), "");
      ((ah)localObject1).QJU = Util.safeParseInt((String)paramMap.get(paramString + ".textAlignment"));
      ((ah)localObject1).KZj = Util.nullAs((String)paramMap.get(paramString + ".fontColor"), "");
      ((ah)localObject1).textSize = a(Util.safeParseDouble((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
      if ((Util.safeParseInt((String)paramMap.get(paramString + ".showType")) & ah.QLk) > 0)
      {
        bool = true;
        label664:
        ((ah)localObject1).QLq = bool;
        if ((Util.safeParseInt((String)paramMap.get(paramString + ".showType")) & ah.QLl) <= 0) {
          break label889;
        }
        bool = true;
        label713:
        ((ah)localObject1).QLr = bool;
        if ((Util.safeParseInt((String)paramMap.get(paramString + ".showType")) & ah.QLm) <= 0) {
          break label895;
        }
      }
      label889:
      label895:
      for (boolean bool = true;; bool = false)
      {
        ((ah)localObject1).QLs = bool;
        ((ah)localObject1).maxLines = Util.safeParseInt((String)paramMap.get(paramString + ".maxLines"));
        ((ah)localObject1).QJT = Util.safeParseInt((String)paramMap.get(paramString + ".fontType"));
        ((ah)localObject1).QLt = Util.safeParseFloat((String)paramMap.get(paramString + ".lineSpace"));
        break;
        bool = false;
        break label664;
        bool = false;
        break label713;
      }
      label1023:
      Object localObject2;
      if (m == 2)
      {
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).appid = ((String)paramMap.get(paramString + ".appid"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QIO = ((String)paramMap.get(paramString + ".wxAppid"));
        if (Util.safeParseInt((String)paramMap.get(paramString + ".useGameDownloadWidget")) == 1)
        {
          bool = true;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QIP = bool;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).PLD = ((String)paramMap.get(paramString + ".appPageUrlAndroid"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).channelId = ((String)paramMap.get(paramString + ".channelId"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).bJH = ((String)paramMap.get(paramString + ".pkg"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QIS = Util.safeParseInt((String)paramMap.get(paramString + ".platform"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QIT = ((String)paramMap.get(paramString + ".warningAndroid"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QIU = ((String)paramMap.get(paramString + ".btnBgColorTheme"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QIW = ((String)paramMap.get(paramString + ".btnBgColorThemePressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QIV = ((String)paramMap.get(paramString + ".btnBgColorThemeDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QIX = ((String)paramMap.get(paramString + ".btnBorderColorTheme"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QIZ = ((String)paramMap.get(paramString + ".btnBorderColorThemePressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QIY = ((String)paramMap.get(paramString + ".btnBorderColorThemeDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QJa = ((String)paramMap.get(paramString + ".fontColor"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QJc = ((String)paramMap.get(paramString + ".fontColorPressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QJb = ((String)paramMap.get(paramString + ".fontColorDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QJf = Util.safeParseInt((String)paramMap.get(paramString + ".showDownloadTip"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QJi = Util.nullAs((String)paramMap.get(paramString + ".toOpenAppText"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QJg = Util.safeParseInt((String)paramMap.get(paramString + ".marketFlag"));
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QJg > 0)
          {
            localObject2 = bc(paramMap);
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).QJh = ((Intent)localObject2);
            }
          }
        }
      }
      Object localObject4;
      for (;;)
      {
        ((r)localObject1).QKH = k;
        ((r)localObject1).subType = m;
        ((r)localObject1).title = Util.nullAs((String)paramMap.get(paramString + ".btnTitle"), "");
        ((r)localObject1).QJO = Util.safeParseInt((String)paramMap.get(paramString + ".btnType"));
        ((r)localObject1).QJP = Util.nullAs((String)paramMap.get(paramString + ".btnJumpUrl"), "");
        ((r)localObject1).QJQ = Util.nullAs((String)paramMap.get(paramString + ".btnJumpApp"), "");
        ((r)localObject1).QJR = Util.nullAs((String)paramMap.get(paramString + ".fontColor"), "");
        ((r)localObject1).fontSize = a(Util.safeParseDouble((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
        ((r)localObject1).QJT = Util.safeParseInt((String)paramMap.get(paramString + ".btnFontType"));
        ((r)localObject1).QJU = Util.safeParseInt((String)paramMap.get(paramString + ".btnAlignment"));
        ((r)localObject1).QJS = a(Util.safeParseDouble((String)paramMap.get(paramString + ".borderSize")), paramInt1, paramInt2, paramInt3);
        ((r)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".btnHeight")), paramInt1, paramInt2, paramInt3);
        ((r)localObject1).PSc = Util.nullAs((String)paramMap.get(paramString + ".btnBgColorTheme"), "");
        ((r)localObject1).QJV = Util.nullAs((String)paramMap.get(paramString + ".btnBorderColorTheme"), "");
        ((r)localObject1).QJW = Util.nullAs((String)paramMap.get(paramString + ".btnBgImgUrl"), "");
        ((r)localObject1).QJX = Util.safeParseInt((String)paramMap.get(paramString + ".bCanLongPress"));
        ((r)localObject1).QJY = Util.safeParseInt((String)paramMap.get(paramString + ".bHideActionSheet"));
        ((r)localObject1).QJZ = Util.safeParseInt((String)paramMap.get(paramString + ".hideProductActionHeader"));
        ((r)localObject1).QKa = Util.safeParseInt((String)paramMap.get(paramString + ".showProductActionCancelButton"));
        ((r)localObject1).QKc = Util.nullAs((String)paramMap.get(paramString + ".productActionTitle"), "");
        ((r)localObject1).QKb = Util.nullAs((String)paramMap.get(paramString + ".productActionBuffer"), "");
        ((r)localObject1).QKd = Util.nullAs((String)paramMap.get(paramString + ".productActionIconUrl"), "");
        ((r)localObject1).dwJ = a(Util.safeParseInt((String)paramMap.get(paramString + ".cornerRadius")), paramInt1, paramInt2, paramInt3);
        ((r)localObject1).QKf = Util.nullAs((String)paramMap.get(paramString + ".btnIconUrl"), "");
        ((r)localObject1).QKg = a(Util.safeParseInt((String)paramMap.get(paramString + ".btnIconSize")), paramInt1, paramInt2, paramInt3);
        if (paramMap.containsKey(paramString + ".productActionItem.componentItem.type")) {
          ((r)localObject1).QKe = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString + ".productActionItem.componentItem");
        }
        break;
        bool = false;
        break label1023;
        if (m == 4)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).wtm = Util.nullAs((String)paramMap.get(paramString + ".cardTpId"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).wui = Util.nullAs((String)paramMap.get(paramString + ".cardExt"), "");
        }
        else if (m == 7)
        {
          localObject1 = new m();
          ((m)localObject1).QJD = Util.nullAs((String)paramMap.get(paramString + ".jumpCanvasId"), "");
          ((m)localObject1).QJE = Util.nullAs((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
          ((m)localObject1).QJF = Util.safeParseInt((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
          ((m)localObject1).QJG = Util.safeParseInt((String)paramMap.get(paramString + ".btnCanvasEnterType"));
          ((m)localObject1).QJH = Util.safeParseInt((String)paramMap.get(paramString + ".btnCanvasSource"));
        }
        else if (m == 8)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject1).username = ((String)paramMap.get(paramString + ".weappUserName"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject1).icO = ((String)paramMap.get(paramString + ".weappPath"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)localObject1).PLo = Util.safeParseInt((String)paramMap.get(paramString + ".miniProgramType"));
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
          localObject1 = new i(new i.a(d1, d2, i, (String)localObject1, (String)localObject2));
        }
        else if (m == 10)
        {
          localObject2 = paramString + ".phoneNumList.phoneNum";
          localObject4 = new ArrayList();
          i = 0;
          if (i == 0) {}
          for (localObject1 = (String)paramMap.get(localObject2);; localObject1 = (String)paramMap.get((String)localObject2 + i))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label3433;
            }
            ((List)localObject4).add(localObject1);
            i += 1;
            break;
          }
          label3433:
          if (!((List)localObject4).isEmpty())
          {
            localObject1 = new k((List)localObject4);
          }
          else
          {
            AppMethodBeat.o(97333);
            return null;
          }
        }
        else if (m == 12)
        {
          localObject1 = new o();
          ((o)localObject1).xVm = ((String)paramMap.get(paramString + ".weappUserName"));
          ((o)localObject1).QJJ = ((String)paramMap.get(paramString + ".weAppID"));
          ((o)localObject1).businessId = ((String)paramMap.get(paramString + ".businessId"));
          ((o)localObject1).rSr = ((String)paramMap.get(paramString + ".sessionFrom"));
          ((o)localObject1).QJK = Util.safeParseInt((String)paramMap.get(paramString + ".showMessageCard"));
          ((o)localObject1).rSy = Util.nullAsNil((String)paramMap.get(paramString + ".sendMessageTitle"));
          ((o)localObject1).rSA = Util.nullAsNil((String)paramMap.get(paramString + ".sendMessageImg"));
          ((o)localObject1).rSz = Util.nullAsNil((String)paramMap.get(paramString + ".sendMessagePath"));
        }
        else if (m == 13)
        {
          localObject1 = new p();
          ((p)localObject1).oeO = Util.safeParseInt((String)paramMap.get(paramString + ".sid"));
          ((p)localObject1).QJL = Util.safeParseInt((String)paramMap.get(paramString + ".compid"));
        }
        else if (m == 14)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).QJz = Util.nullAsNil((String)paramMap.get(paramString + ".redEnvelopsSkinBtnDisableWording"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).QJA = Util.safeParseLong(paramString + ".redEnvelopsSkinDisableTime");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).hNo = Util.nullAsNil((String)paramMap.get(paramString + ".redEnvelopesSkinId"));
        }
        else if (m == 15)
        {
          localObject1 = new ac();
          ((ac)localObject1).QKX = Util.nullAs((String)paramMap.get(paramString + ".qrUrl"), "");
          ((ac)localObject1).QKl = Util.nullAs((String)paramMap.get(paramString + ".qrExtInfo"), "");
          ((ac)localObject1).QKY = Util.safeParseInt((String)paramMap.get(paramString + ".needUpdateQrUrl"));
          ((ac)localObject1).QKZ = Util.safeParseInt((String)paramMap.get(paramString + ".qrScanDirectJump"));
        }
        else if (m == 16)
        {
          localObject1 = new ad();
          ((ad)localObject1).QLa = ADXml.b.ah(paramMap, ".adxml.adScanInfo");
        }
        else if (m == 17)
        {
          localObject1 = new x();
          ((x)localObject1).owR = Util.nullAs((String)paramMap.get(paramString + ".brandUsername"), "");
          ((x)localObject1).PLE = Util.nullAs((String)paramMap.get(paramString + ".brandHead"), "");
          ((x)localObject1).hEy = Util.nullAs((String)paramMap.get(paramString + ".brandName"), "");
          ((x)localObject1).PLF = Util.nullAs((String)paramMap.get(paramString + ".brandDesc"), "");
          ((x)localObject1).PLG = Util.nullAs((String)paramMap.get(paramString + ".btnTitleAfterAddBrand"), "");
          ((x)localObject1).QKA = Util.nullAs((String)paramMap.get(paramString + ".compatibleJumpUrl"), "");
        }
        else if (m == 18)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).QJI = Util.nullAsNil((String)paramMap.get(paramString + ".wxGroupInfo"));
        }
        else if (m == 19)
        {
          localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.component.info.a();
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.a)localObject1).PLH = Util.nullAs((String)paramMap.get(paramString + ".couponAppId"), "");
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.a)localObject1).PLI = Util.nullAs((String)paramMap.get(paramString + ".couponStockId"), "");
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.a)localObject1).PRP = AdClickActionInfo.w(paramMap, paramString + ".onReceiveSuccess");
        }
        else if (m == 20)
        {
          localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.component.info.e();
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.e)localObject1).finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.e)localObject1).PLN = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveNoticeId"));
        }
        else if (m == 21)
        {
          localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.component.info.c();
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.c)localObject1).finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
        }
        else if (m == 22)
        {
          localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.component.info.d();
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.d)localObject1).finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.d)localObject1).PMe = Util.nullAsNil((String)paramMap.get(paramString + ".finderExportId"));
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.d)localObject1).PMd = Util.nullAsNil((String)paramMap.get(paramString + ".finderObjectNonceId"));
        }
        else if (m == 23)
        {
          localObject1 = new aj();
          ((aj)localObject1).hBT = Util.nullAsNil((String)paramMap.get(paramString + ".emotionProductId"));
        }
        else if (m == 24)
        {
          localObject1 = new ao();
          ((ao)localObject1).QLF = Util.nullAsNil((String)paramMap.get(paramString + ".jumpKefuUrl"));
        }
        else if (m == 25)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a.a();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a.a)localObject1).PMg = com.tencent.mm.plugin.sns.ad.adxml.a.u(paramMap, paramString + ".appointmentInfo");
        }
        else
        {
          localObject1 = new r();
        }
      }
      localObject1 = new u();
      ((u)localObject1).QKH = k;
      ((u)localObject1).subType = m;
      ((u)localObject1).QKj = Util.nullAs((String)paramMap.get(paramString + ".pureImageUrl"), "");
      ((u)localObject1).bgColor = Util.nullAs((String)paramMap.get(paramString + ".bgColor"), "");
      if ((paramMap.containsKey(paramString + ".bgColorAlpha")) && (((u)localObject1).bgColor.length() > 0)) {
        ((u)localObject1).bgColor = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(paramString + ".bgColorAlpha")) * 255.0D)), ((u)localObject1).bgColor.substring(1) });
      }
      ((u)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((u)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      ((u)localObject1).QKi = false;
      if (Util.safeParseInt((String)paramMap.get(paramString + ".enableQRScan")) == 1)
      {
        bool = true;
        label5426:
        ((u)localObject1).QKk = bool;
        ((u)localObject1).QKl = Util.nullAs((String)paramMap.get(paramString + ".qrExtInfo"), "");
        if (Util.safeParseInt((String)paramMap.get(paramString + ".needUpdateQrUrl")) != 1) {
          break label5647;
        }
      }
      label5647:
      for (bool = true;; bool = false)
      {
        ((u)localObject1).QKm = bool;
        ((u)localObject1).dwJ = a(Util.safeParseInt((String)paramMap.get(paramString + ".cornerRadius")), paramInt1, paramInt2, paramInt3);
        ((u)localObject1).fileSize = Util.safeParseLong((String)paramMap.get(paramString + ".fileSize"));
        ((u)localObject1).md5 = Util.nullAsNil((String)paramMap.get(paramString + ".imageMd5"));
        break;
        bool = false;
        break label5426;
      }
      localObject1 = new t();
      ((t)localObject1).QKH = k;
      ((t)localObject1).subType = m;
      ((t)localObject1).QKj = Util.nullAs((String)paramMap.get(paramString + ".panoramaImageUrl"), "");
      ((t)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((t)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      continue;
      localObject1 = new u();
      ((u)localObject1).QKH = k;
      ((u)localObject1).subType = m;
      ((u)localObject1).QKj = Util.nullAs((String)paramMap.get(paramString + ".fullScreenImageUrl"), "");
      ((u)localObject1).QKi = true;
      if (Util.safeParseInt((String)paramMap.get(paramString + ".enableQRScan")) == 1) {}
      for (bool = true;; bool = false)
      {
        ((u)localObject1).QKk = bool;
        ((u)localObject1).nDl = Util.safeParseInt((String)paramMap.get(paramString + ".scaleType"));
        break;
      }
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w();
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QKH = k;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).subType = m;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QKp = Util.nullAs((String)paramMap.get(paramString + ".sightVideoUrl"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QKq = Util.nullAs((String)paramMap.get(paramString + ".sightThumbUrl"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).PSB = Util.nullAs((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QKr = Util.nullAs((String)paramMap.get(paramString + ".jumpText"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QJD = Util.nullAs((String)paramMap.get(paramString + ".jumpCanvasId"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QJE = Util.nullAs((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QJF = Util.safeParseInt((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
      try
      {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QKs = Color.parseColor((String)paramMap.get(paramString + ".jumpTextColor"));
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QKt = Color.parseColor((String)paramMap.get(paramString + ".separatorColor"));
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".sightDisplayWidth")), paramInt1, paramInt2, paramInt3);
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".sightDisplayHeight")), paramInt1, paramInt2, paramInt3);
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QKu = Util.safeParseInt((String)paramMap.get(paramString + ".sightDisplayType"));
            localObject2 = Util.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
            i = Util.safeParseInt((String)paramMap.get(paramString + ".floatStartTime"));
            if ((!Util.isNullOrNil((String)localObject2)) && (i > 0))
            {
              localObject4 = new ak();
              ((ak)localObject4).hUz = ((String)localObject2);
              ((ak)localObject4).QLD = i;
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QJx = ((ak)localObject4);
            }
            if (Util.safeParseInt((String)paramMap.get(".adxml.adCanvasInfo.heightRoundingType")) <= 0) {
              break label6847;
            }
            bool = true;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QKv = bool;
            if (Util.safeParseInt((String)paramMap.get(paramString + ".downloadVideoByCdn")) <= 0) {
              break label6853;
            }
            bool = true;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QKw = bool;
            try
            {
              if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yIt, 0) != 1) {
                break label6859;
              }
              bool = true;
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QKx = bool;
            }
            finally
            {
              label6683:
              String str1;
              int j;
              break label6683;
            }
            if (Util.safeParseInt((String)paramMap.get(paramString + ".forbiddenControlView")) <= 0) {
              break label6865;
            }
            bool = true;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QJt = bool;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QKz = j(paramMap, paramString + ".floatBarComponentItem", paramInt1, paramInt2, paramInt3, paramInt4);
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QKy = Util.safeParseLong((String)paramMap.get(paramString + ".fileSize"));
            break;
            localException1 = localException1;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QKs = Color.rgb(255, 255, 255);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)localObject1).QKt = Color.rgb(255, 255, 255);
            continue;
            label6847:
            bool = false;
            continue;
            label6853:
            bool = false;
            continue;
            label6859:
            bool = false;
            continue;
            label6865:
            bool = false;
          }
        }
      }
      localObject1 = new ap();
      ((ap)localObject1).QKH = k;
      ((ap)localObject1).subType = m;
      ((ap)localObject1).PSB = Util.nullAs((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((ap)localObject1).QLG = Util.nullAs((String)paramMap.get(paramString + ".streamVideoThumb"), "");
      ((ap)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".streamDisplayWidth")), paramInt1, paramInt2, paramInt3);
      ((ap)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".streamDisplayHeight")), paramInt1, paramInt2, paramInt3);
      ((ap)localObject1).QLH = Util.safeParseInt((String)paramMap.get(paramString + ".streamDisplayType"));
      str1 = Util.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
      int i = Util.safeParseInt((String)paramMap.get(paramString + ".floatStartTime"));
      if ((!Util.isNullOrNil(str1)) && (i > 0))
      {
        localObject4 = new ak();
        ((ak)localObject4).hUz = str1;
        ((ak)localObject4).QLD = i;
        ((ap)localObject1).QJx = ((ak)localObject4);
      }
      if (Util.safeParseInt((String)paramMap.get(".adxml.adCanvasInfo.heightRoundingType")) > 0)
      {
        bool = true;
        label7231:
        ((ap)localObject1).QKv = bool;
        ((ap)localObject1).QKz = j(paramMap, paramString + ".floatBarComponentItem", paramInt1, paramInt2, paramInt3, paramInt4);
        if (Util.safeParseInt((String)paramMap.get(paramString + ".alwaysAutoPlay")) != 1) {
          break label7374;
        }
        bool = true;
        label7312:
        ((ap)localObject1).QLI = bool;
        if (Util.safeParseInt((String)paramMap.get(paramString + ".forceLandscapeWhenTurnToFullScreen")) != 1) {
          break label7380;
        }
      }
      label7374:
      label7380:
      for (bool = true;; bool = false)
      {
        ((ap)localObject1).QJw = bool;
        break;
        bool = false;
        break label7231;
        bool = false;
        break label7312;
      }
      localObject1 = new an();
      ((an)localObject1).QKH = k;
      ((an)localObject1).subType = m;
      ((an)localObject1).h5Url = Util.nullAs((String)paramMap.get(paramString + ".webviewUrl"), "");
      continue;
      double d1 = a(Util.safeParseDouble((String)paramMap.get(paramString + ".topLineSize")), paramInt1, paramInt2, paramInt3);
      double d2 = a(Util.safeParseDouble((String)paramMap.get(paramString + ".bottomLineSize")), paramInt1, paramInt2, paramInt3);
      if (aly(paramInt4)) {
        i = Color.argb(51, 0, 0, 0);
      }
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
            localObject1 = new j(d1, d2, new j.a(d3, d4, j, (String)localObject1, str1), i);
            break;
          }
        }
      }
      label8972:
      label10650:
      if (k == 122)
      {
        str1 = paramString + ".phoneNumList.phoneNum";
        localObject4 = new ArrayList();
        j = 0;
        if (j == 0) {}
        for (localObject1 = (String)paramMap.get(str1);; localObject1 = (String)paramMap.get(str1 + j))
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label7923;
          }
          ((List)localObject4).add(localObject1);
          j += 1;
          break;
        }
        label7923:
        if (!((List)localObject4).isEmpty())
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d(d1, d2, i, (List)localObject4);
        }
        else
        {
          AppMethodBeat.o(97333);
          return null;
          localObject1 = new af();
          ((af)localObject1).QKH = k;
          ((af)localObject1).subType = m;
          ((af)localObject1).label = Util.nullAs((String)paramMap.get(paramString + ".label"), "");
          ((af)localObject1).value = ((float)Util.safeParseDouble((String)paramMap.get(paramString + ".value")));
          ((af)localObject1).QLi = Util.nullAs((String)paramMap.get(paramString + ".foregroundImage"), "");
          ((af)localObject1).fontSize = a(Util.safeParseDouble((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
          ((af)localObject1).qWk = Util.nullAs((String)paramMap.get(paramString + ".backgroundColor"), "");
          continue;
          localObject1 = b(paramMap, paramString, paramInt1, paramInt2, paramInt3);
          continue;
          localObject1 = new v();
          ((v)localObject1).QHW = Util.nullAs((String)paramMap.get(paramString + ".sphereThumbUrl"), "");
          ((v)localObject1).QHE = Util.safeParseInt((String)paramMap.get(paramString + ".displayType"));
          ((v)localObject1).QHU = Util.safeParseInt((String)paramMap.get(paramString + ".gestureDelayTime"));
          ((v)localObject1).QHV = Util.nullAs((String)paramMap.get(paramString + ".sphereImageUrl"), "");
          try
          {
            ((v)localObject1).bgColor = Util.nullAs((String)paramMap.get(paramString + ".bgColor"), "");
            if ((paramMap.containsKey(paramString + ".bgColorAlpha")) && (((v)localObject1).bgColor.length() > 0)) {
              ((v)localObject1).bgColor = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(paramString + ".bgColorAlpha")) * 255.0D)), ((v)localObject1).bgColor.substring(1) });
            }
          }
          catch (Exception localException3)
          {
            try
            {
              for (;;)
              {
                ((v)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
                ((v)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
                ((v)localObject1).QKn = Util.nullAs((String)paramMap.get(".adxml.adSphereCardInfo.sphereImageUrl"), "");
                ((v)localObject1).QKo = Util.nullAs((String)paramMap.get(".adxml.adSphereCardInfo.sphereThumbUrl"), "");
                break;
                localException3 = localException3;
                Log.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse color exp=" + localException3.toString());
              }
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                ((v)localObject1).width = 0.0F;
                ((v)localObject1).height = 0.0F;
                Log.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse size exp=" + localException4.toString());
              }
            }
          }
          localObject1 = new ae();
          ((ae)localObject1).QLb = Util.nullAs((String)paramMap.get(paramString + ".backgroundImg"), "");
          ((ae)localObject1).iconUrl = Util.nullAs((String)paramMap.get(paramString + ".iconUrl"), "");
          ((ae)localObject1).title = Util.nullAs((String)paramMap.get(paramString + ".title"), "");
          ((ae)localObject1).desc = Util.nullAs((String)paramMap.get(paramString + ".desc"), "");
          ((ae)localObject1).QLg = Util.safeParseInt((String)paramMap.get(paramString + ".onlyShowInTimelineAd"));
          if (Util.safeParseInt((String)paramMap.get(paramString + ".isFullClickable")) == 1)
          {
            bool = true;
            ((ae)localObject1).QLd = bool;
            ((ae)localObject1).QLe = ((int)a(Util.safeParseDouble((String)paramMap.get(paramString + ".appearPaddingTop")), paramInt1, paramInt2, paramInt3));
            ((ae)localObject1).QLf = ((int)a(Util.safeParseDouble((String)paramMap.get(paramString + ".appearPaddingBottom")), paramInt1, paramInt2, paramInt3));
          }
          try
          {
            str2 = paramString + ".backgroundColor";
            localObject4 = paramString + ".backgroundColorAlpha";
            ((ae)localObject1).qWk = Util.nullAs((String)paramMap.get(str2), "");
            if ((paramMap.containsKey(localObject4)) && (((ae)localObject1).qWk.length() > 0)) {
              ((ae)localObject1).qWk = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(localObject4)) * 255.0D)), ((ae)localObject1).qWk.substring(1) });
            }
          }
          catch (Exception localException6)
          {
            try
            {
              str2 = paramString + ".titleColor";
              localObject4 = paramString + ".titleColorAlpha";
              ((ae)localObject1).nSx = Util.nullAs((String)paramMap.get(str2), "");
              if ((paramMap.containsKey(localObject4)) && (((ae)localObject1).nSx.length() > 0)) {
                ((ae)localObject1).nSx = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(localObject4)) * 255.0D)), ((ae)localObject1).nSx.substring(1) });
              }
            }
            catch (Exception localException6)
            {
              try
              {
                for (;;)
                {
                  String str2 = paramString + ".descColor";
                  localObject4 = paramString + ".descColorAlpha";
                  ((ae)localObject1).QLc = Util.nullAs((String)paramMap.get(str2), "");
                  if ((paramMap.containsKey(localObject4)) && (((ae)localObject1).QLc.length() > 0)) {
                    ((ae)localObject1).QLc = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(localObject4)) * 255.0D)), ((ae)localObject1).QLc.substring(1) });
                  }
                  ((ae)localObject1).QLh = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
                  if (!(((ae)localObject1).QLh instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)) {
                    break label10650;
                  }
                  ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)((ae)localObject1).QLh).QJe = true;
                  break;
                  bool = false;
                  break label8972;
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
          localObject1 = aq(paramMap, paramString);
          continue;
          localObject1 = new q();
          ((q)localObject1).QJM = Util.nullAs((String)paramMap.get(paramString + ".swipeText"), "");
          ((q)localObject1).QJN = Util.safeParseInt((String)paramMap.get(paramString + ".swipeActionType"));
          ((q)localObject1).jumpUrl = Util.nullAs((String)paramMap.get(paramString + ".jumpUrl"), "");
          continue;
          localObject1 = i(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
          continue;
          localObject1 = new ag();
          ((ag)localObject1).QLj = Util.nullAsNil((String)paramMap.get(paramString + ".shareText"));
          ((ag)localObject1).QJR = Util.nullAsNil((String)paramMap.get(paramString + ".fontColor"));
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).QKH = k;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).subType = m;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).videoUrl = Util.nullAs((String)paramMap.get(paramString + ".videoUrl"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).thumbUrl = Util.nullAs((String)paramMap.get(paramString + ".thumbUrl"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).QJq = Util.safeParseInt((String)paramMap.get(paramString + ".playerMode"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).QHE = Util.safeParseInt((String)paramMap.get(paramString + ".displayType"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".displayWidth")), paramInt1, paramInt2, paramInt3);
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".displayHeight")), paramInt1, paramInt2, paramInt3);
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).QJr = Util.nullAs((String)paramMap.get(paramString + ".videoMd5"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).QJs = Util.nullAs((String)paramMap.get(paramString + ".thumbMd5"), "");
          if (Util.safeParseInt((String)paramMap.get(paramString + ".forbiddenControlView")) > 0)
          {
            bool = true;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).QJt = bool;
            if (Util.safeParseInt((String)paramMap.get(paramString + ".forbiddenAutoPlay")) <= 0) {
              break label10607;
            }
            bool = true;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).QJu = bool;
            if (Util.safeParseInt((String)paramMap.get(paramString + ".forbiddenPreload")) <= 0) {
              break label10613;
            }
            bool = true;
            label10363:
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).QJv = bool;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).preloadRatio = Util.safeParseInt((String)paramMap.get(paramString + ".preloadRatio"));
            if (Util.safeParseInt((String)paramMap.get(paramString + ".forceLandscapeWhenTurnToFullScreen")) <= 0) {
              break label10619;
            }
          }
          label10613:
          label10619:
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).QJw = bool;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).QJy = j(paramMap, paramString + ".floatBarComponentItem", paramInt1, paramInt2, paramInt3, paramInt4);
            String str3 = Util.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
            i = Util.safeParseInt((String)paramMap.get(paramString + ".floatStartTime"));
            if ((!Util.isNullOrNil(str3)) && (i > 0))
            {
              localObject4 = new ak();
              ((ak)localObject4).hUz = str3;
              ((ak)localObject4).QLD = i;
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).QJx = ((ak)localObject4);
            }
            break;
            bool = false;
            break label10273;
            bool = false;
            break label10318;
            bool = false;
            break label10363;
          }
          localObject1 = com.tencent.mm.plugin.sns.ad.landingpage.component.info.h.ab(paramMap, paramString);
          continue;
          localObject1 = com.tencent.mm.plugin.sns.ad.landingpage.component.info.g.Z(paramMap, paramString);
        }
      }
      else
      {
        label10273:
        label10318:
        label10607:
        localObject1 = null;
      }
    }
  }
  
  private static void a(aa paramaa, Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(97338);
    paramaa.QKH = Util.safeParseInt((String)paramMap.get(paramString + ".type"));
    paramaa.type = paramaa.QKH;
    paramaa.QKG = Util.nullAs((String)paramMap.get(paramString + ".id"), "");
    paramaa.paddingTop = a(Util.safeParseDouble((String)paramMap.get(paramString + ".paddingTop")), paramInt1, paramInt2, paramInt3);
    paramaa.paddingBottom = a(Util.safeParseDouble((String)paramMap.get(paramString + ".paddingBottom")), paramInt1, paramInt2, paramInt3);
    paramaa.paddingLeft = a(Util.safeParseDouble((String)paramMap.get(paramString + ".paddingLeft")), paramInt1, paramInt2, paramInt3);
    paramaa.paddingRight = a(Util.safeParseDouble((String)paramMap.get(paramString + ".paddingRight")), paramInt1, paramInt2, paramInt3);
    paramaa.subType = Util.safeParseInt((String)paramMap.get(paramString + ".subType"));
    paramaa.QKL = Util.nullAs((String)paramMap.get(paramString + ".cellBackgroundColor"), "");
    String str1 = paramString + ".if";
    label401:
    label454:
    label460:
    String str2;
    double d;
    if (paramMap.containsKey(str1)) {
      if ("1".equals(paramMap.get(str1)))
      {
        bool1 = true;
        paramaa.QKO = bool1;
        str1 = paramString + ".noReport";
        if (!paramMap.containsKey(str1)) {
          break label963;
        }
        if (!"1".equals(paramMap.get(str1))) {
          break label957;
        }
        bool1 = true;
        paramaa.QKP = bool1;
        str1 = Util.nullAs((String)paramMap.get(paramString + ".layoutWidth"), "");
        str2 = Util.nullAs((String)paramMap.get(paramString + ".layoutHeight"), "");
        if (TextUtils.isEmpty(str1)) {
          break label988;
        }
        d = Util.safeParseDouble(str1);
        if (d >= 0.0D) {
          break label971;
        }
        paramaa.QKI = ((float)d);
        label563:
        if (TextUtils.isEmpty(str2)) {
          break label1015;
        }
        d = Util.safeParseDouble(str2);
        if (d >= 0.0D) {
          break label998;
        }
        paramaa.QKJ = ((float)d);
        label592:
        str1 = (String)paramMap.get(paramString + ".verticalAlignment");
        str2 = (String)paramMap.get(paramString + ".horizontalAlignment");
        if (!TextUtils.isEmpty(str1)) {
          break label1025;
        }
        paramaa.QKM = -1;
        label667:
        if (!TextUtils.isEmpty(str2)) {
          break label1037;
        }
        paramaa.QKN = -1;
        label680:
        if (Util.safeParseInt((String)paramMap.get(paramString + ".isTwistAnimView")) != 1) {
          break label1049;
        }
        bool1 = true;
        label719:
        paramaa.QKQ = bool1;
        if (Util.safeParseInt((String)paramMap.get(paramString + ".isDefaultTwistCard")) != 1) {
          break label1055;
        }
        bool1 = true;
        label764:
        paramaa.QKR = bool1;
        paramaa.PPh = Util.nullAsNil((String)paramMap.get(paramString + ".twistCardId"));
        if (Util.safeParseInt((String)paramMap.get(paramString + ".isShakeAnimView")) != 1) {
          break label1061;
        }
      }
    }
    label1025:
    label1037:
    label1049:
    label1055:
    label1061:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramaa.QKS = bool1;
      paramaa.QKT = Util.nullAsNil((String)paramMap.get(paramString + ".jumpExtInfo"));
      paramString = paramString + ".fileSize";
      if (paramMap.containsKey(paramString)) {
        paramaa.fileSize = Util.safeParseInt((String)paramMap.get(paramString));
      }
      AppMethodBeat.o(97338);
      return;
      bool1 = false;
      break;
      paramaa.QKO = true;
      break label401;
      label957:
      bool1 = false;
      break label454;
      label963:
      paramaa.QKP = false;
      break label460;
      label971:
      paramaa.QKI = a(d, paramInt1, paramInt2, paramInt3);
      break label563;
      label988:
      paramaa.QKI = 2.147484E+009F;
      break label563;
      label998:
      paramaa.QKJ = a(d, paramInt1, paramInt2, paramInt3);
      break label592;
      label1015:
      paramaa.QKJ = 2.147484E+009F;
      break label592;
      paramaa.QKM = Util.safeParseInt(str1);
      break label667;
      paramaa.QKN = Util.safeParseInt(str2);
      break label680;
      bool1 = false;
      break label719;
      bool1 = false;
      break label764;
    }
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, Activity paramActivity)
  {
    AppMethodBeat.i(97351);
    String str = paramTimeLineObject.canvasInfo;
    long l = new BigInteger(paramTimeLineObject.Id).longValue();
    LinkedList localLinkedList = paramTimeLineObject.ContentObj.Zpr;
    if (!TextUtils.isEmpty(str)) {
      if ((!TextUtils.isEmpty(str)) && (aZJ(str))) {
        if (!aZI(str)) {
          break label407;
        }
      }
    }
    label407:
    for (paramTimeLineObject = com.tencent.mm.model.newabtest.d.bEu().bvb("Sns_Canvas_GameShare_JumpWay");; paramTimeLineObject = "")
    {
      SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.model.al.hgB().vj(l);
      Intent localIntent = new Intent();
      if (localSnsInfo != null)
      {
        localIntent.putExtra("sns_landing_pages_share_sns_id", localSnsInfo.getSnsId());
        localIntent.putExtra("sns_landing_pages_rawSnsId", localSnsInfo.getTimeLine().Id);
        localIntent.putExtra("sns_landing_pages_ux_info", localSnsInfo.getUxinfo());
        localIntent.putExtra("sns_landing_pages_aid", localSnsInfo.getAid());
        localIntent.putExtra("sns_landing_pages_traceid", localSnsInfo.getTraceid());
        localIntent.putExtra("sns_landing_pages_rec_src", localSnsInfo.getAdRecSrc());
      }
      if ((localLinkedList != null) && (localLinkedList.size() > 0)) {
        localIntent.putExtra("sns_landing_pages_share_thumb_url", ((dmz)localLinkedList.get(0)).aaTl);
      }
      localIntent.putExtra("sns_landing_pages_expid", paramTimeLineObject);
      localIntent.putExtra("sns_landig_pages_from_source", 11);
      localIntent.setClass(paramActivity, SnsAdNativeLandingPagesUI.class);
      localIntent.putExtra("sns_landing_pages_xml", str);
      localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      localIntent.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
      paramTimeLineObject = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramTimeLineObject.aYi(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Ljava/lang/String;JLjava/util/List;Landroid/app/Activity;IZ)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramTimeLineObject.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Ljava/lang/String;JLjava/util/List;Landroid/app/Activity;IZ)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(97351);
      return true;
      Log.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str });
      AppMethodBeat.o(97351);
      return false;
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
      str = "exp=" + com.tencent.mm.model.newabtest.d.bEu().bvb("Sns_Canvas_GameShare_JumpWay") + "_" + paramInt;
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
  
  private static boolean aZI(String paramString)
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
  
  public static boolean aZJ(String paramString)
  {
    AppMethodBeat.i(369897);
    boolean bool = mL(paramString, "adCanvasInfo");
    AppMethodBeat.o(369897);
    return bool;
  }
  
  public static boolean als(int paramInt)
  {
    return (paramInt == 101) || (paramInt == 103) || (paramInt == 104) || (paramInt == 105) || (paramInt == 139);
  }
  
  public static boolean alt(int paramInt)
  {
    return paramInt == 101;
  }
  
  public static boolean alu(int paramInt)
  {
    return paramInt == 103;
  }
  
  public static boolean alv(int paramInt)
  {
    return paramInt == 104;
  }
  
  public static boolean alw(int paramInt)
  {
    return paramInt == 105;
  }
  
  public static boolean alx(int paramInt)
  {
    return paramInt == 139;
  }
  
  private static boolean aly(int paramInt)
  {
    paramInt |= 0xFF000000;
    return paramInt + 16777216 > -1 - paramInt;
  }
  
  private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e aq(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(306886);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e locale = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e();
    locale.QJm = Util.nullAs((String)paramMap.get(paramString + ".webViewUrl"), "");
    locale.QJo = Util.safeParseInt((String)paramMap.get(paramString + ".webViewHeight"));
    locale.QJn = Util.safeParseInt((String)paramMap.get(paramString + ".webViewWidth"));
    locale.QJp = Util.safeParseInt((String)paramMap.get(paramString + ".hideWebViewProgress"));
    AppMethodBeat.o(306886);
    return locale;
  }
  
  private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ar b(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(97334);
    localar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ar();
    try
    {
      paramString = paramString + ".radarChart";
      localar.QLJ = ((String)paramMap.get(paramString + ".borderImg"));
      localar.QLP = ((String)paramMap.get(paramString + ".maskImg"));
      localar.QLK = ((String)paramMap.get(paramString + ".coverColor"));
      localar.QLL = Color.parseColor((String)paramMap.get(paramString + ".labelFont.$color"));
      localar.QLM = ((int)a(Util.safeParseDouble((String)paramMap.get(paramString + ".labelFont.$size")), paramInt1, paramInt2, paramInt3));
      localar.QLN = Color.parseColor((String)paramMap.get(paramString + ".scoreFont.$color"));
      localar.QLO = ((int)a(Util.safeParseDouble((String)paramMap.get(paramString + ".scoreFont.$size")), paramInt1, paramInt2, paramInt3));
      localar.borderWidth = a(Util.safeParseDouble((String)paramMap.get(paramString + ".borderImgWidth")), paramInt1, paramInt2, paramInt3);
      String str = paramString + ".itemList.item";
      paramInt1 = 0;
      if (paramInt1 != 0) {}
      for (paramString = str + paramInt1;; paramString = str)
      {
        ar.a locala = new ar.a();
        locala.label = ((String)paramMap.get(paramString + ".label"));
        locala.QLQ = ((String)paramMap.get(paramString + ".score"));
        locala.value = ((float)Util.safeParseDouble((String)paramMap.get(paramString + ".value")));
        if ((TextUtils.isEmpty(locala.label)) && (TextUtils.isEmpty(locala.QLQ))) {
          break label567;
        }
        localar.piH.add(locala);
        paramInt1 += 1;
        break;
      }
      label567:
      return localar;
    }
    catch (Exception paramMap)
    {
      Log.e("AdLandingPagesParseHelper", Util.stackTraceToString(paramMap));
      AppMethodBeat.o(97334);
    }
  }
  
  private static List<aa> b(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
      if (!paramString.QKO) {
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
  
  private static Intent bc(Map<String, String> paramMap)
  {
    AppMethodBeat.i(306801);
    paramMap = com.tencent.mm.plugin.sns.device.appstore.a.c(MMApplicationContext.getContext(), paramMap);
    if (paramMap != null)
    {
      paramMap = paramMap.heU();
      AppMethodBeat.o(306801);
      return paramMap;
    }
    AppMethodBeat.o(306801);
    return null;
  }
  
  private static s c(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97336);
    s locals = new s();
    try
    {
      i = Color.parseColor((String)paramMap.get(paramString + ".bgColorTheme"));
      locals.backgroundColor = ((int)(Util.getDouble((String)paramMap.get(paramString + ".bgColorAlpha"), 0.0D) * 255.0D) << 24 | i & 0xFFFFFF);
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
        if (paramString.QKO) {
          locals.QKh.add(paramString);
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
        locals.backgroundColor = Color.argb(51, 0, 0, 0);
        continue;
        paramString = localException + i;
      }
      label260:
      AppMethodBeat.o(97336);
    }
    return locals;
  }
  
  public static boolean c(ADXml paramADXml, String paramString)
  {
    AppMethodBeat.i(306878);
    if (paramADXml == null)
    {
      AppMethodBeat.o(306878);
      return false;
    }
    paramADXml = paramADXml.xml;
    if (Util.isNullOrNil(new String[] { paramADXml, paramString }))
    {
      AppMethodBeat.o(306878);
      return false;
    }
    if (!paramADXml.contains("<adCanvasInfoLeft>"))
    {
      AppMethodBeat.o(306878);
      return false;
    }
    boolean bool = mL(paramString, "adCanvasInfo");
    AppMethodBeat.o(306878);
    return bool;
  }
  
  private static am d(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97337);
    am localam = new am();
    a(localam, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localam.QLE = Util.safeParseInt((String)paramMap.get(paramString + ".pageCtrType"));
    boolean bool;
    label148:
    String str1;
    int i;
    if (Util.safeParseInt((String)paramMap.get(paramString + ".isFullScreen")) == 1)
    {
      bool = true;
      localam.Flq = bool;
      if (Util.safeParseInt((String)paramMap.get(paramString + ".autoCarousel")) != 1) {
        break label278;
      }
      bool = true;
      localam.autoCarousel = bool;
      str1 = paramString + ".componentGroupList.componentGroup";
      i = 0;
    }
    for (;;)
    {
      label188:
      s locals;
      String str2;
      int j;
      if (i == 0)
      {
        paramString = str1;
        locals = new s();
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
        if (paramString.QKO) {
          locals.QKh.add(paramString);
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
      if (locals.QKh.size() == 0) {
        break label363;
      }
      localam.QKh.add(locals);
      i += 1;
    }
    label363:
    AppMethodBeat.o(97337);
    return localam;
  }
  
  public static boolean d(ADXml paramADXml, String paramString)
  {
    AppMethodBeat.i(306880);
    if (paramADXml == null)
    {
      AppMethodBeat.o(306880);
      return false;
    }
    paramADXml = paramADXml.xml;
    if (Util.isNullOrNil(new String[] { paramADXml, paramString }))
    {
      AppMethodBeat.o(306880);
      return false;
    }
    if (!paramADXml.contains("<adCanvasInfoRight>"))
    {
      AppMethodBeat.o(306880);
      return false;
    }
    boolean bool = mL(paramString, "adCanvasInfo");
    AppMethodBeat.o(306880);
    return bool;
  }
  
  private static aa e(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97339);
    ab localab = new ab();
    localab.QKW = Util.safeParseInt((String)paramMap.get(paramString + ".subType"));
    localab.QKF = as.a(paramMap, paramString, paramInt1, paramInt2, paramInt3);
    a(localab, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    String str = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = str;; paramString = str + i)
    {
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label176;
      }
      if (paramString.QKO) {
        localab.QKV.add(paramString);
      }
      i += 1;
      break;
    }
    label176:
    AppMethodBeat.o(97339);
    return localab;
  }
  
  private static aa f(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97340);
    List localList = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    z localz = new z();
    localz.cornerRadius = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), Util.safeParseInt((String)paramMap.get(paramString + ".cornerRadius")));
    localz.aAO = localList;
    localz.QKF = as.a(paramMap, paramString, paramInt1, paramInt2, paramInt3);
    a(localz, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(97340);
    return localz;
  }
  
  private static aa g(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97341);
    Object localObject = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    y localy = new y();
    localy.cornerRadius = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), Util.safeParseInt((String)paramMap.get(paramString + ".cornerRadius")));
    localy.QKB = Util.safeParseInt((String)paramMap.get(paramString + ".autoShow"));
    localy.QKC = Util.safeParseInt((String)paramMap.get(paramString + ".noAnimation"));
    localy.QKD = Util.safeParseInt((String)paramMap.get(paramString + ".forbiddenToClose"));
    localy.QKE = Util.safeParseInt((String)paramMap.get(paramString + ".noBackground"));
    localy.aAO = ((List)localObject);
    a(localy, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localObject = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = (String)localObject;; paramString = (String)localObject + i)
    {
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label338;
      }
      if (paramString.QKO) {
        localy.aAO.add(paramString);
      }
      i += 1;
      break;
    }
    label338:
    AppMethodBeat.o(97341);
    return localy;
  }
  
  private static aa h(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(306846);
    List localList = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.plugin.sns.ad.landingpage.component.info.b localb = new com.tencent.mm.plugin.sns.ad.landingpage.component.info.b();
    localb.aAO = localList;
    localb.PMi = d.e.E(paramMap, paramString);
    localb.PMk = d.a.A(paramMap, paramString);
    localb.PRQ = b.a.Y(paramMap, paramString);
    a(localb, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(306846);
    return localb;
  }
  
  private static void hkD()
  {
    AppMethodBeat.i(97354);
    if (QXy != null)
    {
      AppMethodBeat.o(97354);
      return;
    }
    QXy = new HashSet();
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
          localObject5 = new l.b((byte)0);
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((l.b)localObject5).QXE = i;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((l.b)localObject5).QXF = k;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((l.b)localObject5).QXG = i1;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          QXy.add(localObject5);
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
  
  private static com.tencent.mm.plugin.sns.ad.landingpage.component.info.f i(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(306890);
    com.tencent.mm.plugin.sns.ad.landingpage.component.info.f localf = new com.tencent.mm.plugin.sns.ad.landingpage.component.info.f();
    localf.MCJ = Util.nullAs((String)paramMap.get(paramString + ".title"), "");
    localf.PRU = Util.safeParseInt((String)paramMap.get(paramString + ".autoJump"));
    localf.PRV = Util.safeParseInt((String)paramMap.get(paramString + ".swipeJumpOffset"));
    paramMap = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramMap instanceof r)) {
      localf.PRW = ((r)paramMap);
    }
    AppMethodBeat.o(306890);
    return localf;
  }
  
  private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al j(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(306892);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al localal = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al();
    a(localal, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localal.desc = Util.nullAs((String)paramMap.get(paramString + ".desc"), "");
    boolean bool;
    if (Util.safeParseInt((String)paramMap.get(paramString + ".isFullClickable")) == 1) {
      bool = true;
    }
    for (;;)
    {
      localal.QLd = bool;
      try
      {
        String str1 = paramString + ".descColor";
        String str2 = paramString + ".descColorAlpha";
        localal.QLc = Util.nullAs((String)paramMap.get(str1), "");
        if ((paramMap.containsKey(str2)) && (localal.QLc.length() > 0)) {
          localal.QLc = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(str2)) * 255.0D)), localal.QLc.substring(1) });
        }
        localal.QLh = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
        if ((localal.QLh instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localal.QLh).QJe = true;
        }
        AppMethodBeat.o(306892);
        return localal;
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
  
  public static void kE(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n> paramList)
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
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n localn = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)localIterator.next();
      if (als(localn.QOV.type)) {
        localArrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)localn).hai());
      }
    }
    if (!localArrayList.isEmpty())
    {
      kE(localArrayList);
      paramList.addAll(localArrayList);
    }
    AppMethodBeat.o(97357);
  }
  
  public static String mJ(String paramString1, String paramString2)
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
  
  public static String mK(String paramString1, String paramString2)
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
  
  public static boolean mL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97353);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(97353);
      return false;
    }
    if (QXy == null) {
      hkD();
    }
    if ((QXy != null) && (!QXy.isEmpty()))
    {
      Map localMap = XmlParser.parseXml(paramString1, paramString2, null);
      if ((localMap == null) || (localMap.isEmpty()))
      {
        Log.w("AdLandingPagesParseHelper", "invalid landingpages xml,".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(97353);
        return false;
      }
      l.b localb = new l.b((byte)0);
      localb.QXE = 0;
      localb.QXF = Util.safeParseInt((String)localMap.get(".adCanvasInfo.type"));
      localb.QXG = Util.safeParseInt((String)localMap.get(".adCanvasInfo.subtype"));
      if (!QXy.contains(localb))
      {
        Log.i("AdLandingPagesParseHelper", "invalid canvas type ".concat(String.valueOf(localb)));
        AppMethodBeat.o(97353);
        return false;
      }
      int i = 0;
      for (;;)
      {
        localb.QXE = 1;
        if (i == 0) {}
        for (paramString1 = ".adCanvasInfo.PageList.Page";; paramString1 = ".adCanvasInfo.PageList.Page" + i)
        {
          if (!localMap.containsKey(paramString1 + ".componentItemList.componentItem.type")) {
            break label589;
          }
          localb.QXF = Util.safeParseInt((String)localMap.get(paramString1 + ".type"));
          localb.QXG = Util.safeParseInt((String)localMap.get(paramString1 + ".subType"));
          if (QXy.contains(localb)) {
            break;
          }
          Log.i("AdLandingPagesParseHelper", "invalid page type ".concat(String.valueOf(localb)));
          AppMethodBeat.o(97353);
          return false;
        }
        paramString2 = paramString1 + ".componentItemList.componentItem";
        localb.QXE = 2;
        int j = 0;
        for (;;)
        {
          if (j == 0) {}
          for (paramString1 = paramString2;; paramString1 = paramString2 + j)
          {
            if (!localMap.containsKey(paramString1 + ".type")) {
              break label582;
            }
            localb.QXF = Util.safeParseInt((String)localMap.get(paramString1 + ".type"));
            localb.QXG = Util.safeParseInt((String)localMap.get(paramString1 + ".subType"));
            if (QXy.contains(localb)) {
              break;
            }
            Log.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(localb)));
            AppMethodBeat.o(97353);
            return false;
          }
          j += 1;
        }
        label582:
        i += 1;
      }
      label589:
      localb.QXE = 2;
      paramString1 = localMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        Object localObject = (Map.Entry)paramString1.next();
        if ((((Map.Entry)localObject).getKey() != null) && (((String)((Map.Entry)localObject).getKey()).matches("[\\s\\S]*\\.componentItem[0-9]*\\.type$")))
        {
          paramString2 = (String)((Map.Entry)localObject).getKey();
          localObject = ((String)((Map.Entry)localObject).getKey()).replace(".type", ".subType");
          localb.QXF = Util.safeParseInt((String)localMap.get(paramString2));
          localb.QXG = Util.safeParseInt((String)localMap.get(localObject));
          if (!QXy.contains(localb))
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
  
  public static boolean x(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(97350);
    String str2 = paramIntent.getStringExtra("sns_landing_pages_xml");
    String str1;
    boolean bool;
    int i;
    if (!TextUtils.isEmpty(str2)) {
      if ((!TextUtils.isEmpty(str2)) && (mL(str2, "adCanvasInfo")))
      {
        str1 = "";
        bool = aZI(str2);
        if (!bool) {
          break label329;
        }
        str1 = com.tencent.mm.model.newabtest.d.bEu().bvb("Sns_Canvas_GameShare_JumpWay");
        if (!TextUtils.isEmpty(str1))
        {
          i = com.tencent.mm.model.newabtest.d.bEu().bva("Sns_Canvas_GameShare_JumpWay");
          Log.i("AdLandingPagesParseHelper", "abtestvalue = ".concat(String.valueOf(i)));
          if (i == 0) {
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramIntent = new Intent(paramIntent);
        paramIntent.setClass(paramContext, SnsAdNativeLandingPagesUI.class);
        paramIntent.putExtra("sns_landing_pages_expid", str1);
        paramIntent.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (((paramContext instanceof Activity)) && ((ADXml.isTwistAdCanvas(str2)) || (ADXml.isShakeAdCanvas(str2)) || (ADXml.isSimpleSharedShakeAd(str2)))) {
          ((Activity)paramContext).overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(97350);
        return true;
        i = 1;
        continue;
        i = 1;
      }
      else
      {
        bool = a(str2, paramContext, bool, paramIntent.getIntExtra("sns_landig_pages_from_source", -1));
        AppMethodBeat.o(97350);
        return bool;
        Log.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str2 });
        AppMethodBeat.o(97350);
        return false;
        label329:
        i = 1;
      }
    }
  }
  
  public static final class a
  {
    public ae QXA;
    public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e QXB;
    public com.tencent.mm.plugin.sns.ad.landingpage.component.info.f QXC;
    public com.tencent.mm.plugin.sns.ad.adxml.d QXD;
    public LinkedList<h> QXz;
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97329);
      this.QXz = new LinkedList();
      this.QXA = null;
      this.QXB = null;
      this.QXC = null;
      this.QXD = null;
      long l = System.currentTimeMillis();
      mM(paramString1, paramString2);
      Log.i("AdLandingPagesParseHelper", "parse adlanding xml, timeCost=" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(97329);
    }
    
    private void a(aa paramaa, int paramInt)
    {
      AppMethodBeat.i(306803);
      paramaa.QKU = paramInt;
      if (l.als(paramaa.type))
      {
        paramaa = paramaa.haE();
        if (paramaa != null)
        {
          paramaa = paramaa.iterator();
          while (paramaa.hasNext()) {
            a((aa)paramaa.next(), paramInt);
          }
        }
      }
      AppMethodBeat.o(306803);
    }
    
    private void a(h paramh, int paramInt)
    {
      AppMethodBeat.i(306797);
      if (paramh.QXi != null)
      {
        paramh = paramh.QXi.iterator();
        while (paramh.hasNext()) {
          a((aa)paramh.next(), paramInt);
        }
      }
      AppMethodBeat.o(306797);
    }
    
    private void mM(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97330);
      if (TextUtils.isEmpty(paramString1))
      {
        AppMethodBeat.o(97330);
        return;
      }
      paramString1 = l.mJ(paramString1, "");
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
          i = l.QXx;
        }
      }
      j = k;
      if (k == 0)
      {
        j = k;
        if (i1 == 1) {
          j = l.QXw;
        }
      }
      this.QXD = com.tencent.mm.plugin.sns.ad.adxml.d.b(localMap, ".".concat(String.valueOf(paramString2)), com.tencent.mm.plugin.sns.ad.adxml.d.PMn);
      if ((!Util.isNullOrNil(paramString2)) && (!".adCanvasInfo.PageList.Page".equals("adCanvasInfo"))) {}
      for (paramString1 = "." + paramString2 + ".adCanvasInfo.PageList.Page";; paramString1 = ".adCanvasInfo.PageList.Page")
      {
        k = 0;
        label410:
        Object localObject2;
        for (;;)
        {
          h localh;
          boolean bool;
          label478:
          label485:
          String str;
          int m;
          if (k == 0)
          {
            localObject1 = paramString1;
            localh = new h();
            localh.QXg = Util.nullAs((String)localMap.get((String)localObject1 + ".backgroundCover"), "");
            localh.qWk = Util.nullAs((String)localMap.get((String)localObject1 + ".backgroundColor"), "");
            if (Util.safeParseInt((String)localMap.get((String)localObject1 + ".backgroundCover.$isAddBlur")) <= 0) {
              break label650;
            }
            bool = true;
            localh.QXh = bool;
            localh.id = k;
            localObject2 = (String)localObject1 + ".if";
            if (!localMap.containsKey(localObject2)) {
              break label662;
            }
            if (!"1".equals(localMap.get(localObject2))) {
              break label656;
            }
            bool = true;
            localh.QXk = bool;
            if (!localh.QXk) {
              break label924;
            }
            str = (String)localObject1 + ".componentItemList.componentItem";
            m = 0;
            label518:
            if (m != 0) {
              break label671;
            }
            localObject2 = str;
          }
          for (;;)
          {
            try
            {
              if (TextUtils.isEmpty(localh.qWk)) {
                continue;
              }
              n = Color.parseColor(localh.qWk);
              localaa1 = l.b(localMap, i1, j, i, n, (String)localObject2);
            }
            catch (Exception localException2)
            {
              int n;
              aa localaa1;
              label650:
              label656:
              label662:
              label671:
              Log.e("AdLandingPagesParseHelper", Util.stackTraceToString(localException2));
              aa localaa2 = l.b(localMap, i1, j, i, 0, (String)localObject2);
              continue;
              localh.QXi.add(localaa2);
              continue;
              Log.i("AdLandingPagesParseHelper", "comp " + localaa2.toString() + " ifCondition is false");
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
              localh.QXl.add(localObject1);
              m += 1;
              continue;
              localObject1 = (String)localObject2 + m;
              continue;
              if (localh.QXi.size() == 0) {
                break label933;
              }
            }
            if (localaa1 == null) {
              continue;
            }
            if (!localaa1.QKO) {
              continue;
            }
            l.b(localaa1, localMap, (String)localObject2, i1, j, i);
            if (!(localaa1 instanceof y)) {
              continue;
            }
            localh.QXj.put(localaa1.QKG, localaa1);
            m += 1;
            break label518;
            localObject1 = paramString1 + k;
            break;
            bool = false;
            break label410;
            bool = false;
            break label478;
            localh.QXk = true;
            break label485;
            localObject2 = str + m;
            continue;
            n = 0;
          }
          this.QXz.add(localh);
          a(localh, this.QXz.size() - 1);
          label924:
          k += 1;
        }
        label933:
        if ((this.QXz != null) && (this.QXz.size() > 0)) {
          ((h)this.QXz.get(0)).AXE = true;
        }
        Object localObject1 = "." + paramString2 + ".adCanvasInfo.globalComponentItems.componentItem";
        k = 0;
        label1226:
        label1241:
        label1256:
        for (;;)
        {
          if (k == 0) {}
          for (paramString1 = (String)localObject1;; paramString1 = (String)localObject1 + k)
          {
            paramString2 = null;
            try
            {
              localObject2 = l.b(localMap, i1, j, i, 0, paramString1);
              paramString2 = (String)localObject2;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                Log.e("AdLandingPagesParseHelper", Util.stackTraceToString(localException1));
              }
              Log.d("AdLandingPagesParseHelper", "parse the item: the global item existed, globalItemsStr = ".concat(String.valueOf(paramString1)));
              if (!(paramString2 instanceof ae)) {
                break label1226;
              }
              this.QXA = ((ae)paramString2);
              if (!(paramString2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)) {
                break label1241;
              }
              this.QXB = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)paramString2);
              if (!(paramString2 instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.info.f)) {
                break label1256;
              }
              this.QXC = ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.f)paramString2);
              k += 1;
            }
            if (paramString2 != null) {
              break;
            }
            Log.d("AdLandingPagesParseHelper", "parse the item: the global item is null, globalItemsStr = ".concat(String.valueOf(paramString1)));
            if (this.QXA == null) {
              break label1265;
            }
            paramString1 = this.QXz.iterator();
            for (;;)
            {
              if (!paramString1.hasNext()) {
                break label1265;
              }
              paramString2 = (h)paramString1.next();
              if (paramString2.QXl.size() > 0)
              {
                localObject1 = paramString2.QXl.iterator();
                if (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (String)((Iterator)localObject1).next();
                  if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(this.QXA.QKG)) || (!((String)localObject2).equals(this.QXA.QKG))) {
                    break;
                  }
                  paramString2.QXm = true;
                }
              }
            }
          }
        }
        label1265:
        AppMethodBeat.o(97330);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l
 * JD-Core Version:    0.7.0.1
 */