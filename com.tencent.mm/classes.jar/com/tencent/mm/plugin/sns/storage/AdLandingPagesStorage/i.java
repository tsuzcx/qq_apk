package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.b.a;
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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aq;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
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
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
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
  public static int Kyu = 750;
  public static int Kyv = 10;
  private static Set<i.b> Kyw = null;
  
  private static String M(String paramString, Map<String, String> paramMap)
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
    LinkedList localLinkedList = new a(paramString, "adxml").Kyx;
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
        Iterator localIterator3 = ((g)localIterator2.next()).Kyp.iterator();
        while (localIterator3.hasNext())
        {
          aa localaa = (aa)localIterator3.next();
          if (((localaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)) && (!Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localaa).toN)) && (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localaa).toN.equals(str3)))
          {
            paramString = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localaa).tpJ;
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
  
  public static String R(SnsInfo paramSnsInfo)
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
    paramSnsInfo = M(localAdSnsInfo.field_adxml, paramSnsInfo.mappedCanvasCardExt);
    AppMethodBeat.o(97355);
    return paramSnsInfo;
  }
  
  private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e Y(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(246767);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e locale = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e();
    locale.Klf = Util.nullAs((String)paramMap.get(paramString + ".webViewUrl"), "");
    locale.Klh = Util.safeParseInt((String)paramMap.get(paramString + ".webViewHeight"));
    locale.Klg = Util.safeParseInt((String)paramMap.get(paramString + ".webViewWidth"));
    locale.Kli = Util.safeParseInt((String)paramMap.get(paramString + ".hideWebViewProgress"));
    AppMethodBeat.o(246767);
    return locale;
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
    int[] arrayOfInt = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao.ib(MMApplicationContext.getContext());
    paramInt1 = Math.min(arrayOfInt[0], arrayOfInt[1]);
    float f1 = (float)paramDouble;
    float f2 = paramInt3;
    f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao.cc(paramInt1 * (f1 * f2) / paramInt2);
    AppMethodBeat.o(97332);
    return f1;
  }
  
  private static aa a(Map<String, String> paramMap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(97343);
    int i = Util.safeParseInt((String)paramMap.get(paramString + ".type"));
    aa localaa = null;
    if (!agz(i)) {}
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
      if (agA(i))
      {
        paramMap = d(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (agB(i))
      {
        paramMap = e(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (agC(i))
      {
        paramMap = f(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (agD(i))
      {
        paramMap = g(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (agE(i))
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
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao();
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao)localObject1).url = Util.nullAs((String)paramMap.get(paramString + ".webviewUrl"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao)localObject1).Kmh = Util.nullAs((String)paramMap.get(paramString + ".qrExtInfo"), "");
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((aa)localObject1).KmF = agF(paramInt4);
        ((aa)localObject1).type = k;
        ((aa)localObject1).subType = m;
        a((aa)localObject1, paramMap, paramString, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(97333);
      return localObject1;
      localObject1 = c(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      continue;
      localObject1 = new ah();
      ((ah)localObject1).KmC = k;
      ((ah)localObject1).subType = m;
      ((ah)localObject1).Knk = Util.nullAs((String)paramMap.get(paramString + ".content"), "");
      ((ah)localObject1).KlP = Util.safeParseInt((String)paramMap.get(paramString + ".textAlignment"));
      ((ah)localObject1).FdA = Util.nullAs((String)paramMap.get(paramString + ".fontColor"), "");
      ((ah)localObject1).textSize = a(Util.safeParseDouble((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
      if ((Util.safeParseInt((String)paramMap.get(paramString + ".showType")) & ah.Knf) > 0)
      {
        bool = true;
        label656:
        ((ah)localObject1).Knl = bool;
        if ((Util.safeParseInt((String)paramMap.get(paramString + ".showType")) & ah.Kng) <= 0) {
          break label881;
        }
        bool = true;
        label705:
        ((ah)localObject1).Knm = bool;
        if ((Util.safeParseInt((String)paramMap.get(paramString + ".showType")) & ah.Knh) <= 0) {
          break label887;
        }
      }
      label881:
      label887:
      for (boolean bool = true;; bool = false)
      {
        ((ah)localObject1).Knn = bool;
        ((ah)localObject1).maxLines = Util.safeParseInt((String)paramMap.get(paramString + ".maxLines"));
        ((ah)localObject1).KlO = Util.safeParseInt((String)paramMap.get(paramString + ".fontType"));
        ((ah)localObject1).Kno = Util.safeParseFloat((String)paramMap.get(paramString + ".lineSpace"));
        break;
        bool = false;
        break label656;
        bool = false;
        break label705;
      }
      label1015:
      Object localObject2;
      if (m == 2)
      {
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).appid = ((String)paramMap.get(paramString + ".appid"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkH = ((String)paramMap.get(paramString + ".wxAppid"));
        if (Util.safeParseInt((String)paramMap.get(paramString + ".useGameDownloadWidget")) == 1)
        {
          bool = true;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkI = bool;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).JxO = ((String)paramMap.get(paramString + ".appPageUrlAndroid"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).channelId = ((String)paramMap.get(paramString + ".channelId"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).abY = ((String)paramMap.get(paramString + ".pkg"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkL = Util.safeParseInt((String)paramMap.get(paramString + ".platform"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkM = ((String)paramMap.get(paramString + ".warningAndroid"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkN = ((String)paramMap.get(paramString + ".btnBgColorTheme"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkP = ((String)paramMap.get(paramString + ".btnBgColorThemePressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkO = ((String)paramMap.get(paramString + ".btnBgColorThemeDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkQ = ((String)paramMap.get(paramString + ".btnBorderColorTheme"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkS = ((String)paramMap.get(paramString + ".btnBorderColorThemePressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkR = ((String)paramMap.get(paramString + ".btnBorderColorThemeDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkT = ((String)paramMap.get(paramString + ".fontColor"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkV = ((String)paramMap.get(paramString + ".fontColorPressed"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkU = ((String)paramMap.get(paramString + ".fontColorDisable"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkY = Util.safeParseInt((String)paramMap.get(paramString + ".showDownloadTip"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).Klb = Util.nullAs((String)paramMap.get(paramString + ".toOpenAppText"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkZ = Util.safeParseInt((String)paramMap.get(paramString + ".marketFlag"));
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).KkZ > 0)
          {
            localObject2 = aL(paramMap);
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).Kla = ((Intent)localObject2);
            }
          }
        }
      }
      Object localObject3;
      for (;;)
      {
        ((r)localObject1).KmC = k;
        ((r)localObject1).subType = m;
        ((r)localObject1).title = Util.nullAs((String)paramMap.get(paramString + ".btnTitle"), "");
        ((r)localObject1).KlJ = Util.safeParseInt((String)paramMap.get(paramString + ".btnType"));
        ((r)localObject1).KlK = Util.nullAs((String)paramMap.get(paramString + ".btnJumpUrl"), "");
        ((r)localObject1).KlL = Util.nullAs((String)paramMap.get(paramString + ".btnJumpApp"), "");
        ((r)localObject1).KlM = Util.nullAs((String)paramMap.get(paramString + ".fontColor"), "");
        ((r)localObject1).fontSize = a(Util.safeParseDouble((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
        ((r)localObject1).KlO = Util.safeParseInt((String)paramMap.get(paramString + ".btnFontType"));
        ((r)localObject1).KlP = Util.safeParseInt((String)paramMap.get(paramString + ".btnAlignment"));
        ((r)localObject1).KlN = a(Util.safeParseDouble((String)paramMap.get(paramString + ".borderSize")), paramInt1, paramInt2, paramInt3);
        ((r)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".btnHeight")), paramInt1, paramInt2, paramInt3);
        ((r)localObject1).KlQ = Util.nullAs((String)paramMap.get(paramString + ".btnBgColorTheme"), "");
        ((r)localObject1).KlR = Util.nullAs((String)paramMap.get(paramString + ".btnBorderColorTheme"), "");
        ((r)localObject1).KlS = Util.nullAs((String)paramMap.get(paramString + ".btnBgImgUrl"), "");
        ((r)localObject1).KlT = Util.safeParseInt((String)paramMap.get(paramString + ".bCanLongPress"));
        ((r)localObject1).KlU = Util.safeParseInt((String)paramMap.get(paramString + ".bHideActionSheet"));
        ((r)localObject1).KlV = Util.safeParseInt((String)paramMap.get(paramString + ".hideProductActionHeader"));
        ((r)localObject1).KlW = Util.safeParseInt((String)paramMap.get(paramString + ".showProductActionCancelButton"));
        ((r)localObject1).KlY = Util.nullAs((String)paramMap.get(paramString + ".productActionTitle"), "");
        ((r)localObject1).KlX = Util.nullAs((String)paramMap.get(paramString + ".productActionBuffer"), "");
        ((r)localObject1).KlZ = Util.nullAs((String)paramMap.get(paramString + ".productActionIconUrl"), "");
        ((r)localObject1).bDI = a(Util.safeParseInt((String)paramMap.get(paramString + ".cornerRadius")), paramInt1, paramInt2, paramInt3);
        ((r)localObject1).Kmb = Util.nullAs((String)paramMap.get(paramString + ".btnIconUrl"), "");
        ((r)localObject1).Kmc = a(Util.safeParseInt((String)paramMap.get(paramString + ".btnIconSize")), paramInt1, paramInt2, paramInt3);
        if (paramMap.containsKey(paramString + ".productActionItem.componentItem.type")) {
          ((r)localObject1).Kma = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString + ".productActionItem.componentItem");
        }
        break;
        bool = false;
        break label1015;
        if (m == 4)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).toN = Util.nullAs((String)paramMap.get(paramString + ".cardTpId"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).tpJ = Util.nullAs((String)paramMap.get(paramString + ".cardExt"), "");
        }
        else if (m == 7)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)localObject1).Klw = Util.nullAs((String)paramMap.get(paramString + ".jumpCanvasId"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)localObject1).Klx = Util.nullAs((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)localObject1).Kly = Util.safeParseInt((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)localObject1).Klz = Util.safeParseInt((String)paramMap.get(paramString + ".btnCanvasEnterType"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)localObject1).KlA = Util.safeParseInt((String)paramMap.get(paramString + ".btnCanvasSource"));
        }
        else if (m == 8)
        {
          localObject1 = new l();
          ((l)localObject1).username = ((String)paramMap.get(paramString + ".weappUserName"));
          ((l)localObject1).fWP = ((String)paramMap.get(paramString + ".weappPath"));
          ((l)localObject1).Jxz = Util.safeParseInt((String)paramMap.get(paramString + ".miniProgramType"));
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
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i.a(d1, d2, i, (String)localObject1, (String)localObject2));
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
              break label3409;
            }
            ((List)localObject3).add(localObject1);
            i += 1;
            break;
          }
          label3409:
          if (!((List)localObject3).isEmpty())
          {
            localObject1 = new k((List)localObject3);
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
          ((o)localObject1).uMJ = ((String)paramMap.get(paramString + ".weappUserName"));
          ((o)localObject1).KlC = ((String)paramMap.get(paramString + ".weAppID"));
          ((o)localObject1).businessId = ((String)paramMap.get(paramString + ".businessId"));
          ((o)localObject1).oOB = ((String)paramMap.get(paramString + ".sessionFrom"));
          ((o)localObject1).KlD = Util.safeParseInt((String)paramMap.get(paramString + ".showMessageCard"));
          ((o)localObject1).oOK = Util.nullAsNil((String)paramMap.get(paramString + ".sendMessageTitle"));
          ((o)localObject1).oOM = Util.nullAsNil((String)paramMap.get(paramString + ".sendMessageImg"));
          ((o)localObject1).oOL = Util.nullAsNil((String)paramMap.get(paramString + ".sendMessagePath"));
        }
        else if (m == 13)
        {
          localObject1 = new p();
          ((p)localObject1).KlE = Util.safeParseInt((String)paramMap.get(paramString + ".sid"));
          ((p)localObject1).KlF = Util.safeParseInt((String)paramMap.get(paramString + ".compid"));
        }
        else if (m == 14)
        {
          localObject1 = new h();
          ((h)localObject1).Kls = Util.nullAsNil((String)paramMap.get(paramString + ".redEnvelopsSkinBtnDisableWording"));
          ((h)localObject1).Klt = Util.safeParseLong(paramString + ".redEnvelopsSkinDisableTime");
          ((h)localObject1).fHO = Util.nullAsNil((String)paramMap.get(paramString + ".redEnvelopesSkinId"));
        }
        else if (m == 15)
        {
          localObject1 = new ac();
          ((ac)localObject1).KmS = Util.nullAs((String)paramMap.get(paramString + ".qrUrl"), "");
          ((ac)localObject1).Kmh = Util.nullAs((String)paramMap.get(paramString + ".qrExtInfo"), "");
          ((ac)localObject1).KmT = Util.safeParseInt((String)paramMap.get(paramString + ".needUpdateQrUrl"));
          ((ac)localObject1).KmU = Util.safeParseInt((String)paramMap.get(paramString + ".qrScanDirectJump"));
        }
        else if (m == 16)
        {
          localObject1 = new ad();
          ((ad)localObject1).KmV = ADXml.b.Q(paramMap, ".adxml.adScanInfo");
        }
        else if (m == 17)
        {
          localObject1 = new x();
          ((x)localObject1).lFl = Util.nullAs((String)paramMap.get(paramString + ".brandUsername"), "");
          ((x)localObject1).JxP = Util.nullAs((String)paramMap.get(paramString + ".brandHead"), "");
          ((x)localObject1).fzM = Util.nullAs((String)paramMap.get(paramString + ".brandName"), "");
          ((x)localObject1).JxQ = Util.nullAs((String)paramMap.get(paramString + ".brandDesc"), "");
          ((x)localObject1).JxR = Util.nullAs((String)paramMap.get(paramString + ".btnTitleAfterAddBrand"), "");
          ((x)localObject1).Kmv = Util.nullAs((String)paramMap.get(paramString + ".compatibleJumpUrl"), "");
        }
        else if (m == 18)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).KlB = Util.nullAsNil((String)paramMap.get(paramString + ".wxGroupInfo"));
        }
        else if (m == 19)
        {
          localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.component.b.a();
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).JxS = Util.nullAs((String)paramMap.get(paramString + ".couponAppId"), "");
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).JxT = Util.nullAs((String)paramMap.get(paramString + ".couponStockId"), "");
        }
        else if (m == 20)
        {
          localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.component.b.d();
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.d)localObject1).finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.d)localObject1).JxY = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveNoticeId"));
        }
        else if (m == 21)
        {
          localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.component.b.c();
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.c)localObject1).finderUsername = Util.nullAsNil((String)paramMap.get(paramString + ".finderUsername"));
        }
        else
        {
          localObject1 = new r();
        }
      }
      localObject1 = new u();
      ((u)localObject1).KmC = k;
      ((u)localObject1).subType = m;
      ((u)localObject1).Kmf = Util.nullAs((String)paramMap.get(paramString + ".pureImageUrl"), "");
      ((u)localObject1).bgColor = Util.nullAs((String)paramMap.get(paramString + ".bgColor"), "");
      if ((paramMap.containsKey(paramString + ".bgColorAlpha")) && (((u)localObject1).bgColor.length() > 0)) {
        ((u)localObject1).bgColor = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(paramString + ".bgColorAlpha")) * 255.0D)), ((u)localObject1).bgColor.substring(1) });
      }
      ((u)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((u)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      ((u)localObject1).Kme = false;
      if (Util.safeParseInt((String)paramMap.get(paramString + ".enableQRScan")) == 1)
      {
        bool = true;
        label5071:
        ((u)localObject1).Kmg = bool;
        ((u)localObject1).Kmh = Util.nullAs((String)paramMap.get(paramString + ".qrExtInfo"), "");
        if (Util.safeParseInt((String)paramMap.get(paramString + ".needUpdateQrUrl")) != 1) {
          break label5291;
        }
      }
      label5291:
      for (bool = true;; bool = false)
      {
        ((u)localObject1).Kmi = bool;
        ((u)localObject1).bDI = a(Util.safeParseInt((String)paramMap.get(paramString + ".cornerRadius")), paramInt1, paramInt2, paramInt3);
        ((u)localObject1).fileSize = Util.safeParseLong((String)paramMap.get(paramString + ".fileSize"));
        ((u)localObject1).md5 = Util.nullAsNil((String)paramMap.get(paramString + ".imageMd5"));
        break;
        bool = false;
        break label5071;
      }
      localObject1 = new t();
      ((t)localObject1).KmC = k;
      ((t)localObject1).subType = m;
      ((t)localObject1).Kmf = Util.nullAs((String)paramMap.get(paramString + ".panoramaImageUrl"), "");
      ((t)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((t)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      continue;
      localObject1 = new u();
      ((u)localObject1).KmC = k;
      ((u)localObject1).subType = m;
      ((u)localObject1).Kmf = Util.nullAs((String)paramMap.get(paramString + ".fullScreenImageUrl"), "");
      ((u)localObject1).Kme = true;
      if (Util.safeParseInt((String)paramMap.get(paramString + ".enableQRScan")) == 1) {}
      for (bool = true;; bool = false)
      {
        ((u)localObject1).Kmg = bool;
        ((u)localObject1).kYn = Util.safeParseInt((String)paramMap.get(paramString + ".scaleType"));
        break;
      }
      localObject1 = new w();
      ((w)localObject1).KmC = k;
      ((w)localObject1).subType = m;
      ((w)localObject1).Kml = Util.nullAs((String)paramMap.get(paramString + ".sightVideoUrl"), "");
      ((w)localObject1).Kmm = Util.nullAs((String)paramMap.get(paramString + ".sightThumbUrl"), "");
      ((w)localObject1).JCf = Util.nullAs((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((w)localObject1).Kmn = Util.nullAs((String)paramMap.get(paramString + ".jumpText"), "");
      ((w)localObject1).Klw = Util.nullAs((String)paramMap.get(paramString + ".jumpCanvasId"), "");
      ((w)localObject1).Klx = Util.nullAs((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
      ((w)localObject1).Kly = Util.safeParseInt((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
      try
      {
        ((w)localObject1).Kmo = Color.parseColor((String)paramMap.get(paramString + ".jumpTextColor"));
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((w)localObject1).Kmp = Color.parseColor((String)paramMap.get(paramString + ".separatorColor"));
            ((w)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".sightDisplayWidth")), paramInt1, paramInt2, paramInt3);
            ((w)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".sightDisplayHeight")), paramInt1, paramInt2, paramInt3);
            ((w)localObject1).Kmq = Util.safeParseInt((String)paramMap.get(paramString + ".sightDisplayType"));
            localObject2 = Util.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
            i = Util.safeParseInt((String)paramMap.get(paramString + ".floatStartTime"));
            if ((!Util.isNullOrNil((String)localObject2)) && (i > 0))
            {
              localObject3 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj();
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject3).fOG = ((String)localObject2);
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject3).Knx = i;
              ((w)localObject1).Klq = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject3);
            }
            if (Util.safeParseInt((String)paramMap.get(".adxml.adCanvasInfo.heightRoundingType")) <= 0) {
              break label6451;
            }
            bool = true;
            ((w)localObject1).Kmr = bool;
            if (Util.safeParseInt((String)paramMap.get(paramString + ".downloadVideoByCdn")) <= 0) {
              break label6457;
            }
            bool = true;
            ((w)localObject1).Kms = bool;
            if (Util.safeParseInt((String)paramMap.get(paramString + ".forbiddenControlView")) <= 0) {
              break label6463;
            }
            bool = true;
            ((w)localObject1).Klm = bool;
            ((w)localObject1).Kmu = j(paramMap, paramString + ".floatBarComponentItem", paramInt1, paramInt2, paramInt3, paramInt4);
            ((w)localObject1).Kmt = Util.safeParseLong((String)paramMap.get(paramString + ".fileSize"));
            break;
            localException1 = localException1;
            ((w)localObject1).Kmo = Color.rgb(255, 255, 255);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ((w)localObject1).Kmp = Color.rgb(255, 255, 255);
            continue;
            label6451:
            bool = false;
            continue;
            label6457:
            bool = false;
            continue;
            label6463:
            bool = false;
          }
        }
      }
      localObject1 = new an();
      ((an)localObject1).KmC = k;
      ((an)localObject1).subType = m;
      ((an)localObject1).JCf = Util.nullAs((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((an)localObject1).Knz = Util.nullAs((String)paramMap.get(paramString + ".streamVideoThumb"), "");
      ((an)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".streamDisplayWidth")), paramInt1, paramInt2, paramInt3);
      ((an)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".streamDisplayHeight")), paramInt1, paramInt2, paramInt3);
      ((an)localObject1).KnA = Util.safeParseInt((String)paramMap.get(paramString + ".streamDisplayType"));
      String str1 = Util.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
      int i = Util.safeParseInt((String)paramMap.get(paramString + ".floatStartTime"));
      if ((!Util.isNullOrNil(str1)) && (i > 0))
      {
        localObject3 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject3).fOG = str1;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject3).Knx = i;
        ((an)localObject1).Klq = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject3);
      }
      if (Util.safeParseInt((String)paramMap.get(".adxml.adCanvasInfo.heightRoundingType")) > 0)
      {
        bool = true;
        label6827:
        ((an)localObject1).Kmr = bool;
        ((an)localObject1).Kmu = j(paramMap, paramString + ".floatBarComponentItem", paramInt1, paramInt2, paramInt3, paramInt4);
        if (Util.safeParseInt((String)paramMap.get(paramString + ".alwaysAutoPlay")) != 1) {
          break label6970;
        }
        bool = true;
        label6908:
        ((an)localObject1).KnB = bool;
        if (Util.safeParseInt((String)paramMap.get(paramString + ".forceLandscapeWhenTurnToFullScreen")) != 1) {
          break label6976;
        }
      }
      label6970:
      label6976:
      for (bool = true;; bool = false)
      {
        ((an)localObject1).Klp = bool;
        break;
        bool = false;
        break label6827;
        bool = false;
        break label6908;
      }
      localObject1 = new am();
      ((am)localObject1).KmC = k;
      ((am)localObject1).subType = m;
      ((am)localObject1).h5Url = Util.nullAs((String)paramMap.get(paramString + ".webviewUrl"), "");
      continue;
      double d1 = a(Util.safeParseDouble((String)paramMap.get(paramString + ".topLineSize")), paramInt1, paramInt2, paramInt3);
      double d2 = a(Util.safeParseDouble((String)paramMap.get(paramString + ".bottomLineSize")), paramInt1, paramInt2, paramInt3);
      if (agF(paramInt4)) {
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
            localObject1 = new j(d1, d2, new j.a(d3, d4, j, (String)localObject1, str1), i);
            break;
          }
        }
      }
      label9892:
      label10181:
      label10187:
      label10193:
      if (k == 122)
      {
        str1 = paramString + ".phoneNumList.phoneNum";
        localObject3 = new ArrayList();
        j = 0;
        if (j == 0) {}
        for (localObject1 = (String)paramMap.get(str1);; localObject1 = (String)paramMap.get(str1 + j))
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label7518;
          }
          ((List)localObject3).add(localObject1);
          j += 1;
          break;
        }
        label7518:
        if (!((List)localObject3).isEmpty())
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d(d1, d2, i, (List)localObject3);
        }
        else
        {
          AppMethodBeat.o(97333);
          return null;
          localObject1 = new af();
          ((af)localObject1).KmC = k;
          ((af)localObject1).subType = m;
          ((af)localObject1).label = Util.nullAs((String)paramMap.get(paramString + ".label"), "");
          ((af)localObject1).value = ((float)Util.safeParseDouble((String)paramMap.get(paramString + ".value")));
          ((af)localObject1).Knd = Util.nullAs((String)paramMap.get(paramString + ".foregroundImage"), "");
          ((af)localObject1).fontSize = a(Util.safeParseDouble((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
          ((af)localObject1).nWx = Util.nullAs((String)paramMap.get(paramString + ".backgroundColor"), "");
          continue;
          localObject1 = b(paramMap, paramString, paramInt1, paramInt2, paramInt3);
          continue;
          localObject1 = new v();
          ((v)localObject1).KjY = Util.nullAs((String)paramMap.get(paramString + ".sphereThumbUrl"), "");
          ((v)localObject1).KjH = Util.safeParseInt((String)paramMap.get(paramString + ".displayType"));
          ((v)localObject1).KjW = Util.safeParseInt((String)paramMap.get(paramString + ".gestureDelayTime"));
          ((v)localObject1).KjX = Util.nullAs((String)paramMap.get(paramString + ".sphereImageUrl"), "");
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
                ((v)localObject1).Kmj = Util.nullAs((String)paramMap.get(".adxml.adSphereCardInfo.sphereImageUrl"), "");
                ((v)localObject1).Kmk = Util.nullAs((String)paramMap.get(".adxml.adSphereCardInfo.sphereThumbUrl"), "");
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
          ((ae)localObject1).KmW = Util.nullAs((String)paramMap.get(paramString + ".backgroundImg"), "");
          ((ae)localObject1).iconUrl = Util.nullAs((String)paramMap.get(paramString + ".iconUrl"), "");
          ((ae)localObject1).title = Util.nullAs((String)paramMap.get(paramString + ".title"), "");
          ((ae)localObject1).desc = Util.nullAs((String)paramMap.get(paramString + ".desc"), "");
          ((ae)localObject1).Knb = Util.safeParseInt((String)paramMap.get(paramString + ".onlyShowInTimelineAd"));
          if (Util.safeParseInt((String)paramMap.get(paramString + ".isFullClickable")) == 1)
          {
            bool = true;
            label8555:
            ((ae)localObject1).KmY = bool;
            ((ae)localObject1).KmZ = ((int)a(Util.safeParseDouble((String)paramMap.get(paramString + ".appearPaddingTop")), paramInt1, paramInt2, paramInt3));
            ((ae)localObject1).Kna = ((int)a(Util.safeParseDouble((String)paramMap.get(paramString + ".appearPaddingBottom")), paramInt1, paramInt2, paramInt3));
          }
          try
          {
            str2 = paramString + ".backgroundColor";
            localObject3 = paramString + ".backgroundColorAlpha";
            ((ae)localObject1).nWx = Util.nullAs((String)paramMap.get(str2), "");
            if ((paramMap.containsKey(localObject3)) && (((ae)localObject1).nWx.length() > 0)) {
              ((ae)localObject1).nWx = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(localObject3)) * 255.0D)), ((ae)localObject1).nWx.substring(1) });
            }
          }
          catch (Exception localException6)
          {
            try
            {
              str2 = paramString + ".titleColor";
              localObject3 = paramString + ".titleColorAlpha";
              ((ae)localObject1).lnt = Util.nullAs((String)paramMap.get(str2), "");
              if ((paramMap.containsKey(localObject3)) && (((ae)localObject1).lnt.length() > 0)) {
                ((ae)localObject1).lnt = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(localObject3)) * 255.0D)), ((ae)localObject1).lnt.substring(1) });
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
                  ((ae)localObject1).KmX = Util.nullAs((String)paramMap.get(str2), "");
                  if ((paramMap.containsKey(localObject3)) && (((ae)localObject1).KmX.length() > 0)) {
                    ((ae)localObject1).KmX = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(localObject3)) * 255.0D)), ((ae)localObject1).KmX.substring(1) });
                  }
                  ((ae)localObject1).Knc = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
                  if (!(((ae)localObject1).Knc instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)) {
                    break label10209;
                  }
                  ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)((ae)localObject1).Knc).KkX = true;
                  break;
                  bool = false;
                  break label8555;
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
          localObject1 = Y(paramMap, paramString);
          continue;
          localObject1 = new q();
          ((q)localObject1).KlH = Util.nullAs((String)paramMap.get(paramString + ".swipeText"), "");
          ((q)localObject1).KlI = Util.safeParseInt((String)paramMap.get(paramString + ".swipeActionType"));
          ((q)localObject1).jumpUrl = Util.nullAs((String)paramMap.get(paramString + ".jumpUrl"), "");
          continue;
          localObject1 = i(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
          continue;
          localObject1 = new ag();
          ((ag)localObject1).Kne = Util.nullAsNil((String)paramMap.get(paramString + ".shareText"));
          ((ag)localObject1).KlM = Util.nullAsNil((String)paramMap.get(paramString + ".fontColor"));
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).KmC = k;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).subType = m;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).videoUrl = Util.nullAs((String)paramMap.get(paramString + ".videoUrl"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).thumbUrl = Util.nullAs((String)paramMap.get(paramString + ".thumbUrl"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).Klj = Util.safeParseInt((String)paramMap.get(paramString + ".playerMode"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).KjH = Util.safeParseInt((String)paramMap.get(paramString + ".displayType"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).width = a(Util.safeParseDouble((String)paramMap.get(paramString + ".displayWidth")), paramInt1, paramInt2, paramInt3);
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).height = a(Util.safeParseDouble((String)paramMap.get(paramString + ".displayHeight")), paramInt1, paramInt2, paramInt3);
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).Klk = Util.nullAs((String)paramMap.get(paramString + ".videoMd5"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).Kll = Util.nullAs((String)paramMap.get(paramString + ".thumbMd5"), "");
          if (Util.safeParseInt((String)paramMap.get(paramString + ".forbiddenControlView")) > 0)
          {
            bool = true;
            label9847:
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).Klm = bool;
            if (Util.safeParseInt((String)paramMap.get(paramString + ".forbiddenAutoPlay")) <= 0) {
              break label10181;
            }
            bool = true;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).Kln = bool;
            if (Util.safeParseInt((String)paramMap.get(paramString + ".forbiddenPreload")) <= 0) {
              break label10187;
            }
            bool = true;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).Klo = bool;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).preloadRatio = Util.safeParseInt((String)paramMap.get(paramString + ".preloadRatio"));
            if (Util.safeParseInt((String)paramMap.get(paramString + ".forceLandscapeWhenTurnToFullScreen")) <= 0) {
              break label10193;
            }
          }
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).Klp = bool;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).Klr = j(paramMap, paramString + ".floatBarComponentItem", paramInt1, paramInt2, paramInt3, paramInt4);
            String str3 = Util.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
            i = Util.safeParseInt((String)paramMap.get(paramString + ".floatStartTime"));
            if ((!Util.isNullOrNil(str3)) && (i > 0))
            {
              localObject3 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj();
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject3).fOG = str3;
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject3).Knx = i;
              ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).Klq = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)localObject3);
            }
            break;
            bool = false;
            break label9847;
            bool = false;
            break label9892;
            bool = false;
            break label9937;
          }
          localObject1 = com.tencent.mm.plugin.sns.ad.landingpage.component.b.f.L(paramMap, paramString);
        }
      }
      else
      {
        label9937:
        label10209:
        localObject1 = null;
      }
    }
  }
  
  private static void a(aa paramaa, Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(97338);
    paramaa.KmC = Util.safeParseInt((String)paramMap.get(paramString + ".type"));
    paramaa.type = paramaa.KmC;
    paramaa.KmB = Util.nullAs((String)paramMap.get(paramString + ".id"), "");
    paramaa.paddingTop = a(Util.safeParseDouble((String)paramMap.get(paramString + ".paddingTop")), paramInt1, paramInt2, paramInt3);
    paramaa.paddingBottom = a(Util.safeParseDouble((String)paramMap.get(paramString + ".paddingBottom")), paramInt1, paramInt2, paramInt3);
    paramaa.paddingLeft = a(Util.safeParseDouble((String)paramMap.get(paramString + ".paddingLeft")), paramInt1, paramInt2, paramInt3);
    paramaa.paddingRight = a(Util.safeParseDouble((String)paramMap.get(paramString + ".paddingRight")), paramInt1, paramInt2, paramInt3);
    paramaa.subType = Util.safeParseInt((String)paramMap.get(paramString + ".subType"));
    paramaa.KmG = Util.nullAs((String)paramMap.get(paramString + ".cellBackgroundColor"), "");
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
        paramaa.KmJ = bool1;
        str1 = paramString + ".noReport";
        if (!paramMap.containsKey(str1)) {
          break label960;
        }
        if (!"1".equals(paramMap.get(str1))) {
          break label954;
        }
        bool1 = true;
        paramaa.KmK = bool1;
        str1 = Util.nullAs((String)paramMap.get(paramString + ".layoutWidth"), "");
        str2 = Util.nullAs((String)paramMap.get(paramString + ".layoutHeight"), "");
        if (TextUtils.isEmpty(str1)) {
          break label985;
        }
        d = Util.safeParseDouble(str1);
        if (d >= 0.0D) {
          break label968;
        }
        paramaa.KmD = ((float)d);
        label560:
        if (TextUtils.isEmpty(str2)) {
          break label1012;
        }
        d = Util.safeParseDouble(str2);
        if (d >= 0.0D) {
          break label995;
        }
        paramaa.KmE = ((float)d);
        label589:
        str1 = (String)paramMap.get(paramString + ".verticalAlignment");
        str2 = (String)paramMap.get(paramString + ".horizontalAlignment");
        if (!TextUtils.isEmpty(str1)) {
          break label1022;
        }
        paramaa.KmH = -1;
        label664:
        if (!TextUtils.isEmpty(str2)) {
          break label1034;
        }
        paramaa.KmI = -1;
        label677:
        if (Util.safeParseInt((String)paramMap.get(paramString + ".isTwistAnimView")) != 1) {
          break label1046;
        }
        bool1 = true;
        label716:
        paramaa.KmL = bool1;
        if (Util.safeParseInt((String)paramMap.get(paramString + ".isDefaultTwistCard")) != 1) {
          break label1052;
        }
        bool1 = true;
        label761:
        paramaa.KmM = bool1;
        paramaa.KmN = Util.nullAsNil((String)paramMap.get(paramString + ".twistCardId"));
        if (Util.safeParseInt((String)paramMap.get(paramString + ".isShakeAnimView")) != 1) {
          break label1058;
        }
      }
    }
    label1034:
    label1046:
    label1052:
    label1058:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramaa.KmO = bool1;
      paramaa.KmP = Util.nullAsNil((String)paramMap.get(paramString + ".jumpExtInfo"));
      paramString = paramString + ".fileSize";
      if (paramMap.containsKey(paramString)) {
        paramaa.fileSize = Util.safeParseInt((String)paramMap.get(paramString));
      }
      AppMethodBeat.o(97338);
      return;
      bool1 = false;
      break;
      paramaa.KmJ = true;
      break label400;
      label954:
      bool1 = false;
      break label453;
      label960:
      paramaa.KmK = false;
      break label459;
      label968:
      paramaa.KmD = a(d, paramInt1, paramInt2, paramInt3);
      break label560;
      label985:
      paramaa.KmD = 2.147484E+009F;
      break label560;
      label995:
      paramaa.KmE = a(d, paramInt1, paramInt2, paramInt3);
      break label589;
      label1012:
      paramaa.KmE = 2.147484E+009F;
      break label589;
      label1022:
      paramaa.KmH = Util.safeParseInt(str1);
      break label664;
      paramaa.KmI = Util.safeParseInt(str2);
      break label677;
      bool1 = false;
      break label716;
      bool1 = false;
      break label761;
    }
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, Activity paramActivity)
  {
    AppMethodBeat.i(97351);
    String str = paramTimeLineObject.canvasInfo;
    long l = new BigInteger(paramTimeLineObject.Id).longValue();
    LinkedList localLinkedList = paramTimeLineObject.ContentObj.Sqr;
    boolean bool;
    Object localObject;
    int i;
    int j;
    if (!TextUtils.isEmpty(str))
    {
      if ((TextUtils.isEmpty(str)) || (!bbf(str))) {
        break label459;
      }
      paramTimeLineObject = "";
      bool = bbe(str);
      if (!bool) {
        break label479;
      }
      localObject = com.tencent.mm.model.c.d.bgC().buU("Sns_Canvas_GameShare_JumpWay");
      if (com.tencent.mm.model.c.d.bgC().buT("Sns_Canvas_GameShare_JumpWay") == 0)
      {
        i = 0;
        j = i;
        paramTimeLineObject = (TimeLineObject)localObject;
        if (i == 0)
        {
          j = i;
          paramTimeLineObject = (TimeLineObject)localObject;
          if (fSr())
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
        localObject = com.tencent.mm.plugin.sns.model.aj.fOI().Rd(l);
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
          localIntent.putExtra("sns_landing_pages_share_thumb_url", ((cvt)localLinkedList.get(0)).TDF);
        }
        localIntent.putExtra("sns_landing_pages_expid", paramTimeLineObject);
        localIntent.putExtra("sns_landig_pages_from_source", 11);
        localIntent.setClass(paramActivity, SnsAdNativeLandingPagesUI.class);
        localIntent.putExtra("sns_landing_pages_xml", str);
        localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        localIntent.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
        paramTimeLineObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramTimeLineObject.aFh(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Ljava/lang/String;JLjava/util/List;Landroid/app/Activity;IZ)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramTimeLineObject.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Ljava/lang/String;JLjava/util/List;Landroid/app/Activity;IZ)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
        label459:
        Log.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str });
      }
      label479:
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
      str = "exp=" + com.tencent.mm.model.c.d.bgC().buU("Sns_Canvas_GameShare_JumpWay") + "_" + paramInt;
    }
    try
    {
      str = m(paramString, new String[] { str });
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
    com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(97346);
    return true;
  }
  
  private static Intent aL(Map<String, String> paramMap)
  {
    AppMethodBeat.i(246751);
    paramMap = com.tencent.mm.plugin.sns.device.appstore.a.c(MMApplicationContext.getContext(), paramMap);
    if (paramMap != null)
    {
      paramMap = paramMap.fNs();
      AppMethodBeat.o(246751);
      return paramMap;
    }
    AppMethodBeat.o(246751);
    return null;
  }
  
  public static boolean agA(int paramInt)
  {
    return paramInt == 101;
  }
  
  public static boolean agB(int paramInt)
  {
    return paramInt == 103;
  }
  
  public static boolean agC(int paramInt)
  {
    return paramInt == 104;
  }
  
  public static boolean agD(int paramInt)
  {
    return paramInt == 105;
  }
  
  public static boolean agE(int paramInt)
  {
    return paramInt == 139;
  }
  
  private static boolean agF(int paramInt)
  {
    paramInt |= 0xFF000000;
    return paramInt + 16777216 > -1 - paramInt;
  }
  
  public static boolean agz(int paramInt)
  {
    return (paramInt == 101) || (paramInt == 103) || (paramInt == 104) || (paramInt == 105) || (paramInt == 139);
  }
  
  private static ap b(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(97334);
    localap = new ap();
    try
    {
      paramString = paramString + ".radarChart";
      localap.KnC = ((String)paramMap.get(paramString + ".borderImg"));
      localap.KnI = ((String)paramMap.get(paramString + ".maskImg"));
      localap.KnD = ((String)paramMap.get(paramString + ".coverColor"));
      localap.KnE = Color.parseColor((String)paramMap.get(paramString + ".labelFont.$color"));
      localap.KnF = ((int)a(Util.safeParseDouble((String)paramMap.get(paramString + ".labelFont.$size")), paramInt1, paramInt2, paramInt3));
      localap.KnG = Color.parseColor((String)paramMap.get(paramString + ".scoreFont.$color"));
      localap.KnH = ((int)a(Util.safeParseDouble((String)paramMap.get(paramString + ".scoreFont.$size")), paramInt1, paramInt2, paramInt3));
      localap.borderWidth = a(Util.safeParseDouble((String)paramMap.get(paramString + ".borderImgWidth")), paramInt1, paramInt2, paramInt3);
      String str = paramString + ".itemList.item";
      paramInt1 = 0;
      if (paramInt1 != 0) {}
      for (paramString = str + paramInt1;; paramString = str)
      {
        ap.a locala = new ap.a();
        locala.label = ((String)paramMap.get(paramString + ".label"));
        locala.KnJ = ((String)paramMap.get(paramString + ".score"));
        locala.value = ((float)Util.safeParseDouble((String)paramMap.get(paramString + ".value")));
        if ((TextUtils.isEmpty(locala.label)) && (TextUtils.isEmpty(locala.KnJ))) {
          break label567;
        }
        localap.moS.add(locala);
        paramInt1 += 1;
        break;
      }
      label567:
      return localap;
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
      if (!paramString.KmJ) {
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
  
  private static boolean bbe(String paramString)
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
  
  public static boolean bbf(String paramString)
  {
    AppMethodBeat.i(293057);
    boolean bool = lc(paramString, "adCanvasInfo");
    AppMethodBeat.o(293057);
    return bool;
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
        if (paramString.KmJ) {
          locals.Kmd.add(paramString);
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
  
  private static al d(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97337);
    al localal = new al();
    a(localal, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localal.Kny = Util.safeParseInt((String)paramMap.get(paramString + ".pageCtrType"));
    boolean bool;
    label148:
    String str1;
    int i;
    if (Util.safeParseInt((String)paramMap.get(paramString + ".isFullScreen")) == 1)
    {
      bool = true;
      localal.AJP = bool;
      if (Util.safeParseInt((String)paramMap.get(paramString + ".autoCarousel")) != 1) {
        break label278;
      }
      bool = true;
      localal.autoCarousel = bool;
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
        if (paramString.KmJ) {
          locals.Kmd.add(paramString);
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
      if (locals.Kmd.size() == 0) {
        break label363;
      }
      localal.Kmd.add(locals);
      i += 1;
    }
    label363:
    AppMethodBeat.o(97337);
    return localal;
  }
  
  private static aa e(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97339);
    ab localab = new ab();
    localab.KmR = Util.safeParseInt((String)paramMap.get(paramString + ".subType"));
    localab.KmA = aq.a(paramMap, paramString, paramInt1, paramInt2, paramInt3);
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
      if (paramString.KmJ) {
        localab.KmQ.add(paramString);
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
    localz.cornerRadius = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), Util.safeParseInt((String)paramMap.get(paramString + ".cornerRadius")));
    localz.ayS = localList;
    localz.KmA = aq.a(paramMap, paramString, paramInt1, paramInt2, paramInt3);
    a(localz, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(97340);
    return localz;
  }
  
  private static boolean fSr()
  {
    AppMethodBeat.i(97349);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.bgB().Mu("100150");
    if (localc.isValid())
    {
      int i = Util.getInt((String)localc.hvz().get("openCanvas"), 0);
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
  
  private static void fSs()
  {
    AppMethodBeat.i(97354);
    if (Kyw != null)
    {
      AppMethodBeat.o(97354);
      return;
    }
    Kyw = new HashSet();
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
          ((i.b)localObject5).KyB = i;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((i.b)localObject5).KyC = k;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((i.b)localObject5).KyD = i1;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          Kyw.add(localObject5);
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
  
  private static aa g(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97341);
    Object localObject = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    y localy = new y();
    localy.cornerRadius = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), Util.safeParseInt((String)paramMap.get(paramString + ".cornerRadius")));
    localy.Kmw = Util.safeParseInt((String)paramMap.get(paramString + ".autoShow"));
    localy.Kmx = Util.safeParseInt((String)paramMap.get(paramString + ".noAnimation"));
    localy.Kmy = Util.safeParseInt((String)paramMap.get(paramString + ".forbiddenToClose"));
    localy.Kmz = Util.safeParseInt((String)paramMap.get(paramString + ".noBackground"));
    localy.ayS = ((List)localObject);
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
      if (paramString.KmJ) {
        localy.ayS.add(paramString);
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
    AppMethodBeat.i(246762);
    List localList = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.plugin.sns.ad.landingpage.component.b.b localb = new com.tencent.mm.plugin.sns.ad.landingpage.component.b.b();
    localb.ayS = localList;
    localb.JBF = Util.nullAsNil((String)paramMap.get(paramString + ".transitionImg"));
    try
    {
      localb.JBG = com.tencent.mm.plugin.sns.data.m.kp(Util.nullAsNil((String)paramMap.get(paramString + ".transitionColor")), Util.nullAsNil((String)paramMap.get(paramString + ".transitionColorAlpha")));
      localb.JBH = b.a.K(paramMap, paramString);
      a(localb, paramMap, paramString, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(246762);
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
  
  public static void hD(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m> paramList)
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
      if (agz(localm.KqB.type)) {
        localArrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)localm).fKf());
      }
    }
    if (!localArrayList.isEmpty())
    {
      hD(localArrayList);
      paramList.addAll(localArrayList);
    }
    AppMethodBeat.o(97357);
  }
  
  private static com.tencent.mm.plugin.sns.ad.landingpage.component.b.e i(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(246768);
    com.tencent.mm.plugin.sns.ad.landingpage.component.b.e locale = new com.tencent.mm.plugin.sns.ad.landingpage.component.b.e();
    locale.JBL = Util.nullAs((String)paramMap.get(paramString + ".title"), "");
    locale.JBM = Util.safeParseInt((String)paramMap.get(paramString + ".autoJump"));
    locale.JBN = Util.safeParseInt((String)paramMap.get(paramString + ".swipeJumpOffset"));
    paramMap = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramMap instanceof r)) {
      locale.JBO = ((r)paramMap);
    }
    AppMethodBeat.o(246768);
    return locale;
  }
  
  private static ak j(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(246769);
    ak localak = new ak();
    a(localak, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localak.desc = Util.nullAs((String)paramMap.get(paramString + ".desc"), "");
    boolean bool;
    if (Util.safeParseInt((String)paramMap.get(paramString + ".isFullClickable")) == 1) {
      bool = true;
    }
    for (;;)
    {
      localak.KmY = bool;
      try
      {
        String str1 = paramString + ".descColor";
        String str2 = paramString + ".descColorAlpha";
        localak.KmX = Util.nullAs((String)paramMap.get(str1), "");
        if ((paramMap.containsKey(str2)) && (localak.KmX.length() > 0)) {
          localak.KmX = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble((String)paramMap.get(str2)) * 255.0D)), localak.KmX.substring(1) });
        }
        localak.Knc = a(paramMap, paramString + ".componentItem", paramInt1, paramInt2, paramInt3, paramInt4);
        if ((localak.Knc instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localak.Knc).KkX = true;
        }
        AppMethodBeat.o(246769);
        return localak;
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
  
  public static String la(String paramString1, String paramString2)
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
  
  public static String lb(String paramString1, String paramString2)
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
  
  public static boolean lc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97353);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(97353);
      return false;
    }
    if (Kyw == null) {
      fSs();
    }
    if ((Kyw != null) && (!Kyw.isEmpty()))
    {
      Map localMap = XmlParser.parseXml(paramString1, paramString2, null);
      if ((localMap == null) || (localMap.isEmpty()))
      {
        Log.w("AdLandingPagesParseHelper", "invalid landingpages xml,".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(97353);
        return false;
      }
      i.b localb = new i.b((byte)0);
      localb.KyB = 0;
      localb.KyC = Util.safeParseInt((String)localMap.get(".adCanvasInfo.type"));
      localb.KyD = Util.safeParseInt((String)localMap.get(".adCanvasInfo.subtype"));
      if (!Kyw.contains(localb))
      {
        Log.i("AdLandingPagesParseHelper", "invalid canvas type ".concat(String.valueOf(localb)));
        AppMethodBeat.o(97353);
        return false;
      }
      int i = 0;
      for (;;)
      {
        localb.KyB = 1;
        if (i == 0) {}
        for (paramString1 = ".adCanvasInfo.PageList.Page";; paramString1 = ".adCanvasInfo.PageList.Page" + i)
        {
          if (!localMap.containsKey(paramString1 + ".componentItemList.componentItem.type")) {
            break label592;
          }
          localb.KyC = Util.safeParseInt((String)localMap.get(paramString1 + ".type"));
          localb.KyD = Util.safeParseInt((String)localMap.get(paramString1 + ".subType"));
          if (Kyw.contains(localb)) {
            break;
          }
          Log.i("AdLandingPagesParseHelper", "invalid page type ".concat(String.valueOf(localb)));
          AppMethodBeat.o(97353);
          return false;
        }
        paramString2 = paramString1 + ".componentItemList.componentItem";
        localb.KyB = 2;
        int j = 0;
        for (;;)
        {
          if (j == 0) {}
          for (paramString1 = paramString2;; paramString1 = paramString2 + j)
          {
            if (!localMap.containsKey(paramString1 + ".type")) {
              break label585;
            }
            localb.KyC = Util.safeParseInt((String)localMap.get(paramString1 + ".type"));
            localb.KyD = Util.safeParseInt((String)localMap.get(paramString1 + ".subType"));
            if (Kyw.contains(localb)) {
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
      localb.KyB = 2;
      paramString1 = localMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        Object localObject = (Map.Entry)paramString1.next();
        if ((((Map.Entry)localObject).getKey() != null) && (((String)((Map.Entry)localObject).getKey()).matches("[\\s\\S]*\\.componentItem[0-9]*\\.type$")))
        {
          paramString2 = (String)((Map.Entry)localObject).getKey();
          localObject = ((String)((Map.Entry)localObject).getKey()).replace(".type", ".subType");
          localb.KyC = Util.safeParseInt((String)localMap.get(paramString2));
          localb.KyD = Util.safeParseInt((String)localMap.get(localObject));
          if (!Kyw.contains(localb))
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
  
  public static String m(String paramString, String... paramVarArgs)
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
  
  public static String n(String paramString, String... paramVarArgs)
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
    boolean bool2;
    boolean bool1;
    if (!TextUtils.isEmpty(str2)) {
      if ((!TextUtils.isEmpty(str2)) && (lc(str2, "adCanvasInfo")))
      {
        str1 = "";
        bool2 = bbe(str2);
        if (!bool2) {
          break label325;
        }
        str1 = com.tencent.mm.model.c.d.bgC().buU("Sns_Canvas_GameShare_JumpWay");
        if (!TextUtils.isEmpty(str1))
        {
          int i = com.tencent.mm.model.c.d.bgC().buT("Sns_Canvas_GameShare_JumpWay");
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
        paramIntent.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramIntent.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (((paramContext instanceof Activity)) && ((ADXml.isTwistAdCanvas(str2)) || (ADXml.isShakeAdCanvas(str2)))) {
          ((Activity)paramContext).overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(97350);
        return true;
        bool1 = true;
        continue;
        bool1 = fSr();
      }
      else
      {
        bool1 = a(str2, paramContext, bool2, paramIntent.getIntExtra("sns_landig_pages_from_source", -1));
        AppMethodBeat.o(97350);
        return bool1;
        Log.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str2 });
        AppMethodBeat.o(97350);
        return false;
        label325:
        bool1 = true;
      }
    }
  }
  
  public static final class a
  {
    public com.tencent.mm.plugin.sns.ad.landingpage.component.b.e KyA;
    public LinkedList<g> Kyx;
    public ae Kyy;
    public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e Kyz;
    
    public a(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97329);
      this.Kyx = new LinkedList();
      this.Kyy = null;
      this.Kyz = null;
      this.KyA = null;
      long l = System.currentTimeMillis();
      ld(paramString1, paramString2);
      Log.i("AdLandingPagesParseHelper", "parse adlanding xml, timeCost=" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(97329);
    }
    
    private void ld(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97330);
      if (TextUtils.isEmpty(paramString1))
      {
        AppMethodBeat.o(97330);
        return;
      }
      paramString1 = i.la(paramString1, "");
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
          i = i.Kyv;
        }
      }
      j = k;
      if (k == 0)
      {
        j = k;
        if (i1 == 1) {
          j = i.Kyu;
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
            localg.Kyn = Util.nullAs((String)localMap.get((String)localObject1 + ".backgroundCover"), "");
            localg.nWx = Util.nullAs((String)localMap.get((String)localObject1 + ".backgroundColor"), "");
            if (Util.safeParseInt((String)localMap.get((String)localObject1 + ".backgroundCover.$isAddBlur")) <= 0) {
              break label629;
            }
            bool = true;
            localg.Kyo = bool;
            localg.id = k;
            localObject2 = (String)localObject1 + ".if";
            if (!localMap.containsKey(localObject2)) {
              break label641;
            }
            if (!"1".equals(localMap.get(localObject2))) {
              break label635;
            }
            bool = true;
            localg.Kyr = bool;
            if (!localg.Kyr) {
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
              if (TextUtils.isEmpty(localg.nWx)) {
                continue;
              }
              n = Color.parseColor(localg.nWx);
              localaa1 = i.b(localMap, i1, j, i, n, (String)localObject2);
            }
            catch (Exception localException2)
            {
              int n;
              aa localaa1;
              label629:
              label635:
              Log.e("AdLandingPagesParseHelper", Util.stackTraceToString(localException2));
              label641:
              label650:
              aa localaa2 = i.b(localMap, i1, j, i, 0, (String)localObject2);
              continue;
              localg.Kyp.add(localaa2);
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
              localg.Kys.add(localObject1);
              m += 1;
              continue;
              localObject1 = (String)localObject2 + m;
              continue;
              if (localg.Kyp.size() == 0) {
                break label894;
              }
            }
            if (localaa1 == null) {
              continue;
            }
            if (!localaa1.KmJ) {
              continue;
            }
            i.b(localaa1, localMap, (String)localObject2, i1, j, i);
            if (!(localaa1 instanceof y)) {
              continue;
            }
            localg.Kyq.put(localaa1.KmB, localaa1);
            m += 1;
            break label497;
            localObject1 = paramString1 + k;
            break;
            bool = false;
            break label389;
            bool = false;
            break label457;
            localg.Kyr = true;
            break label464;
            localObject2 = str + m;
            continue;
            n = 0;
          }
          this.Kyx.add(localg);
          label885:
          k += 1;
        }
        label894:
        if ((this.Kyx != null) && (this.Kyx.size() > 0)) {
          ((g)this.Kyx.get(0)).CAd = true;
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
              if (!(paramString2 instanceof ae)) {
                break label1187;
              }
              this.Kyy = ((ae)paramString2);
              if (!(paramString2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)) {
                break label1202;
              }
              this.Kyz = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)paramString2);
              if (!(paramString2 instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.b.e)) {
                break label1217;
              }
              this.KyA = ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.e)paramString2);
              k += 1;
            }
            if (paramString2 != null) {
              break;
            }
            Log.d("AdLandingPagesParseHelper", "parse the item: the global item is null, globalItemsStr = ".concat(String.valueOf(paramString1)));
            if (this.Kyy == null) {
              break label1226;
            }
            paramString1 = this.Kyx.iterator();
            for (;;)
            {
              if (!paramString1.hasNext()) {
                break label1226;
              }
              paramString2 = (g)paramString1.next();
              if (paramString2.Kys.size() > 0)
              {
                localObject1 = paramString2.Kys.iterator();
                if (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (String)((Iterator)localObject1).next();
                  if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(this.Kyy.KmB)) || (!((String)localObject2).equals(this.Kyy.KmB))) {
                    break;
                  }
                  paramString2.Kyt = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i
 * JD-Core Version:    0.7.0.1
 */