package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
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
  public static int rCj = 750;
  public static int rCk = 10;
  private static Set<i.a> rCl = null;
  
  public static boolean Eo(int paramInt)
  {
    return (paramInt == 101) || (paramInt == 103) || (paramInt == 104) || (paramInt == 105);
  }
  
  public static boolean Ep(int paramInt)
  {
    return paramInt == 101;
  }
  
  public static boolean Eq(int paramInt)
  {
    return paramInt == 103;
  }
  
  public static boolean Er(int paramInt)
  {
    return paramInt == 104;
  }
  
  public static boolean Es(int paramInt)
  {
    return paramInt == 105;
  }
  
  private static boolean Et(int paramInt)
  {
    paramInt |= 0xFF000000;
    return paramInt + 16777216 > -1 - paramInt;
  }
  
  public static float a(double paramDouble, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(37733);
    if (paramInt1 == 0)
    {
      f1 = (float)paramDouble;
      AppMethodBeat.o(37733);
      return f1;
    }
    if (paramInt2 == 0)
    {
      f1 = (float)paramDouble;
      AppMethodBeat.o(37733);
      return f1;
    }
    paramInt1 = ae.eU(ah.getContext())[0];
    float f1 = (float)paramDouble;
    float f2 = paramInt3;
    f1 = ae.bb(paramInt1 * (f1 * f2) / paramInt2);
    AppMethodBeat.o(37733);
    return f1;
  }
  
  private static ad a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(37735);
    localad = new ad();
    try
    {
      paramString = paramString + ".radarChart";
      localad.rtn = ((String)paramMap.get(paramString + ".borderImg"));
      localad.rtt = ((String)paramMap.get(paramString + ".maskImg"));
      localad.rto = ((String)paramMap.get(paramString + ".coverColor"));
      localad.rtp = Color.parseColor((String)paramMap.get(paramString + ".labelFont.$color"));
      localad.rtq = ((int)a(bo.apX((String)paramMap.get(paramString + ".labelFont.$size")), paramInt1, paramInt2, paramInt3));
      localad.rtr = Color.parseColor((String)paramMap.get(paramString + ".scoreFont.$color"));
      localad.rts = ((int)a(bo.apX((String)paramMap.get(paramString + ".scoreFont.$size")), paramInt1, paramInt2, paramInt3));
      localad.borderWidth = a(bo.apX((String)paramMap.get(paramString + ".borderImgWidth")), paramInt1, paramInt2, paramInt3);
      String str = paramString + ".itemList.item";
      paramInt1 = 0;
      if (paramInt1 != 0) {}
      for (paramString = str + paramInt1;; paramString = str)
      {
        ad.a locala = new ad.a();
        locala.label = ((String)paramMap.get(paramString + ".label"));
        locala.rtu = ((String)paramMap.get(paramString + ".score"));
        locala.value = ((float)bo.apX((String)paramMap.get(paramString + ".value")));
        if ((TextUtils.isEmpty(locala.label)) && (TextUtils.isEmpty(locala.rtu))) {
          break label553;
        }
        localad.itemList.add(locala);
        paramInt1 += 1;
        break;
      }
      label553:
      return localad;
    }
    catch (Exception paramMap)
    {
      com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", bo.l(paramMap));
      AppMethodBeat.o(37735);
    }
  }
  
  private static t a(Map<String, String> paramMap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    AppMethodBeat.i(37744);
    int i = bo.apV((String)paramMap.get(paramString + ".type"));
    t localt = null;
    if (!Eo(i)) {}
    for (;;)
    {
      try
      {
        localt = a(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
        paramMap = localt;
      }
      catch (Exception localException)
      {
        paramMap = a(paramMap, paramString, paramInt1, paramInt2, paramInt3, 0);
        continue;
      }
      AppMethodBeat.o(37744);
      return paramMap;
      if (Ep(i))
      {
        paramMap = d(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (Eq(i))
      {
        paramMap = e(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (Er(i))
      {
        paramMap = f(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else if (Es(i))
      {
        paramMap = g(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the type" + i + " is not client known type");
        paramMap = localException;
      }
    }
  }
  
  private static t a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(37734);
    int k = bo.apV((String)paramMap.get(paramString + ".type"));
    int m = bo.apV((String)paramMap.get(paramString + ".subType"));
    Object localObject1;
    switch (k)
    {
    default: 
      AppMethodBeat.o(37734);
      return null;
    case 82: 
      localObject1 = new ac();
      ((ac)localObject1).url = bo.bf((String)paramMap.get(paramString + ".webviewUrl"), "");
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((t)localObject1).rsM = Et(paramInt4);
        ((t)localObject1).type = k;
        ((t)localObject1).subType = m;
        a((t)localObject1, paramMap, paramString, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(37734);
      return localObject1;
      localObject1 = c(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      continue;
      localObject1 = new w();
      ((w)localObject1).rsJ = k;
      ((w)localObject1).subType = m;
      ((w)localObject1).rta = bo.bf((String)paramMap.get(paramString + ".content"), "");
      ((w)localObject1).textAlignment = bo.apV((String)paramMap.get(paramString + ".textAlignment"));
      ((w)localObject1).oKE = bo.bf((String)paramMap.get(paramString + ".fontColor"), "");
      ((w)localObject1).textSize = a(bo.apX((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
      if ((bo.apV((String)paramMap.get(paramString + ".showType")) & w.rsV) > 0)
      {
        bool = true;
        label546:
        ((w)localObject1).rtb = bool;
        if ((bo.apV((String)paramMap.get(paramString + ".showType")) & w.rsW) <= 0) {
          break label771;
        }
        bool = true;
        label595:
        ((w)localObject1).rtc = bool;
        if ((bo.apV((String)paramMap.get(paramString + ".showType")) & w.rsX) <= 0) {
          break label777;
        }
      }
      label771:
      label777:
      for (boolean bool = true;; bool = false)
      {
        ((w)localObject1).rtd = bool;
        ((w)localObject1).maxLines = bo.apV((String)paramMap.get(paramString + ".maxLines"));
        ((w)localObject1).rsi = bo.apV((String)paramMap.get(paramString + ".fontType"));
        ((w)localObject1).rte = bo.apY((String)paramMap.get(paramString + ".lineSpace"));
        break;
        bool = false;
        break label546;
        bool = false;
        break label595;
      }
      if (m == 2)
      {
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).cwc = ((String)paramMap.get(paramString + ".appid"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).rrQ = ((String)paramMap.get(paramString + ".appPageUrlAndroid"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).channelId = ((String)paramMap.get(paramString + ".channelId"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).Ca = ((String)paramMap.get(paramString + ".pkg"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).rrF = bo.apV((String)paramMap.get(paramString + ".platform"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).rrG = ((String)paramMap.get(paramString + ".warningAndroid"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).rrH = ((String)paramMap.get(paramString + ".btnBgColorTheme"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).rrJ = ((String)paramMap.get(paramString + ".btnBgColorThemePressed"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).rrI = ((String)paramMap.get(paramString + ".btnBgColorThemeDisable"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).rrK = ((String)paramMap.get(paramString + ".btnBorderColorTheme"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).rrM = ((String)paramMap.get(paramString + ".btnBorderColorThemePressed"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).rrL = ((String)paramMap.get(paramString + ".btnBorderColorThemeDisable"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).rrN = ((String)paramMap.get(paramString + ".fontColor"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).rrP = ((String)paramMap.get(paramString + ".fontColorPressed"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).rrO = ((String)paramMap.get(paramString + ".fontColorDisable"));
      }
      String str1;
      Object localObject2;
      for (;;)
      {
        ((l)localObject1).rsJ = k;
        ((l)localObject1).subType = m;
        ((l)localObject1).title = bo.bf((String)paramMap.get(paramString + ".btnTitle"), "");
        ((l)localObject1).rsd = bo.apV((String)paramMap.get(paramString + ".btnType"));
        ((l)localObject1).rse = bo.bf((String)paramMap.get(paramString + ".btnJumpUrl"), "");
        ((l)localObject1).rsf = bo.bf((String)paramMap.get(paramString + ".btnJumpApp"), "");
        ((l)localObject1).rsg = bo.bf((String)paramMap.get(paramString + ".fontColor"), "");
        ((l)localObject1).fontSize = a(bo.apX((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
        ((l)localObject1).rsi = bo.apV((String)paramMap.get(paramString + ".btnFontType"));
        ((l)localObject1).textAlignment = bo.apV((String)paramMap.get(paramString + ".btnAlignment"));
        ((l)localObject1).rsh = a(bo.apX((String)paramMap.get(paramString + ".borderSize")), paramInt1, paramInt2, paramInt3);
        ((l)localObject1).height = a(bo.apX((String)paramMap.get(paramString + ".btnHeight")), paramInt1, paramInt2, paramInt3);
        ((l)localObject1).rsj = bo.bf((String)paramMap.get(paramString + ".btnBgColorTheme"), "");
        ((l)localObject1).rsk = bo.bf((String)paramMap.get(paramString + ".btnBorderColorTheme"), "");
        ((l)localObject1).rsl = bo.bf((String)paramMap.get(paramString + ".btnBgImgUrl"), "");
        ((l)localObject1).rsm = bo.apV((String)paramMap.get(paramString + ".bCanLongPress"));
        ((l)localObject1).rsn = bo.apV((String)paramMap.get(paramString + ".bHideActionSheet"));
        ((l)localObject1).rso = bo.apV((String)paramMap.get(paramString + ".hideProductActionHeader"));
        ((l)localObject1).rsp = bo.apV((String)paramMap.get(paramString + ".showProductActionCancelButton"));
        ((l)localObject1).rsr = bo.bf((String)paramMap.get(paramString + ".productActionTitle"), "");
        ((l)localObject1).rsq = bo.bf((String)paramMap.get(paramString + ".productActionBuffer"), "");
        ((l)localObject1).rss = bo.bf((String)paramMap.get(paramString + ".productActionIconUrl"), "");
        if (paramMap.containsKey(paramString + ".productActionItem.componentItem.type")) {
          ((l)localObject1).rst = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString + ".productActionItem.componentItem");
        }
        break;
        if (m == 4)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)localObject1).knc = bo.bf((String)paramMap.get(paramString + ".cardTpId"), "");
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)localObject1).knR = bo.bf((String)paramMap.get(paramString + ".cardExt"), "");
        }
        else if (m == 7)
        {
          localObject1 = new j();
          ((j)localObject1).rrW = bo.bf((String)paramMap.get(paramString + ".jumpCanvasId"), "");
          ((j)localObject1).rrX = bo.bf((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
          ((j)localObject1).rrY = bo.apV((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
          ((j)localObject1).rrZ = bo.apV((String)paramMap.get(paramString + ".btnCanvasEnterType"));
          ((j)localObject1).rsa = bo.apV((String)paramMap.get(paramString + ".btnCanvasSource"));
        }
        else if (m == 8)
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i();
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1).username = ((String)paramMap.get(paramString + ".weappUserName"));
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1).cIS = ((String)paramMap.get(paramString + ".weappPath"));
        }
        else if (m == 9)
        {
          d1 = bo.apX((String)paramMap.get(paramString + ".location.$x"));
          d2 = bo.apX((String)paramMap.get(paramString + ".location.$y"));
          i = bo.apV((String)paramMap.get(paramString + ".location.$scale"));
          localObject1 = (String)paramMap.get(paramString + ".location.$label");
          str1 = (String)paramMap.get(paramString + ".location.$poiname");
          if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(str1)))
          {
            AppMethodBeat.o(37734);
            return null;
          }
          localObject1 = new f(new f.a(d1, d2, i, (String)localObject1, str1));
        }
        else if (m == 10)
        {
          str1 = paramString + ".phoneNumList.phoneNum";
          localObject2 = new ArrayList();
          i = 0;
          if (i == 0) {}
          for (localObject1 = (String)paramMap.get(str1);; localObject1 = (String)paramMap.get(str1 + i))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label2907;
            }
            ((List)localObject2).add(localObject1);
            i += 1;
            break;
          }
          label2907:
          if (!((List)localObject2).isEmpty())
          {
            localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h((List)localObject2);
          }
          else
          {
            AppMethodBeat.o(37734);
            return null;
          }
        }
        else if (m == 12)
        {
          localObject1 = new k();
          ((k)localObject1).loD = ((String)paramMap.get(paramString + ".weappUserName"));
          ((k)localObject1).rsb = ((String)paramMap.get(paramString + ".weAppID"));
          ((k)localObject1).hKu = ((String)paramMap.get(paramString + ".businessId"));
          ((k)localObject1).sessionFrom = ((String)paramMap.get(paramString + ".sessionFrom"));
          ((k)localObject1).rsc = bo.apV((String)paramMap.get(paramString + ".showMessageCard"));
        }
        else
        {
          localObject1 = new l();
        }
      }
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o();
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).rsJ = k;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).subType = m;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).rsw = bo.bf((String)paramMap.get(paramString + ".pureImageUrl"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).rrh = bo.bf((String)paramMap.get(paramString + ".bgColor"), "");
      if ((paramMap.containsKey(paramString + ".bgColorAlpha")) && (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).rrh.length() > 0)) {
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).rrh = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bo.apX((String)paramMap.get(paramString + ".bgColorAlpha")) * 255.0D)), ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).rrh.substring(1) });
      }
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).width = a(bo.apX((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).height = a(bo.apX((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).rsv = false;
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n();
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).rsJ = k;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).subType = m;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).rsw = bo.bf((String)paramMap.get(paramString + ".panoramaImageUrl"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).width = a(bo.apX((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)localObject1).height = a(bo.apX((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o();
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).rsJ = k;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).subType = m;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).rsw = bo.bf((String)paramMap.get(paramString + ".fullScreenImageUrl"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).rsv = true;
      continue;
      localObject1 = new q();
      ((q)localObject1).rsJ = k;
      ((q)localObject1).subType = m;
      ((q)localObject1).rsz = bo.bf((String)paramMap.get(paramString + ".sightVideoUrl"), "");
      ((q)localObject1).rsA = bo.bf((String)paramMap.get(paramString + ".sightThumbUrl"), "");
      ((q)localObject1).rsB = bo.bf((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((q)localObject1).rsC = bo.bf((String)paramMap.get(paramString + ".jumpText"), "");
      ((q)localObject1).rrW = bo.bf((String)paramMap.get(paramString + ".jumpCanvasId"), "");
      ((q)localObject1).rrX = bo.bf((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
      ((q)localObject1).rrY = bo.apV((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
      try
      {
        ((q)localObject1).rsD = Color.parseColor((String)paramMap.get(paramString + ".jumpTextColor"));
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((q)localObject1).rsE = Color.parseColor((String)paramMap.get(paramString + ".separatorColor"));
            ((q)localObject1).width = a(bo.apX((String)paramMap.get(paramString + ".sightDisplayWidth")), paramInt1, paramInt2, paramInt3);
            ((q)localObject1).height = a(bo.apX((String)paramMap.get(paramString + ".sightDisplayHeight")), paramInt1, paramInt2, paramInt3);
            ((q)localObject1).rsF = bo.apV((String)paramMap.get(paramString + ".sightDisplayType"));
            str1 = bo.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
            i = bo.apV((String)paramMap.get(paramString + ".floatStartTime"));
            if ((!bo.isNullOrNil(str1)) && (i > 0))
            {
              localObject2 = new y();
              ((y)localObject2).cCo = str1;
              ((y)localObject2).rtj = i;
              ((q)localObject1).rsG = ((y)localObject2);
            }
            break;
            localException1 = localException1;
            ((q)localObject1).rsD = Color.rgb(255, 255, 255);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ((q)localObject1).rsE = Color.rgb(255, 255, 255);
          }
        }
      }
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab();
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1).rsJ = k;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1).subType = m;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1).rsB = bo.bf((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1).rtl = bo.bf((String)paramMap.get(paramString + ".streamVideoThumb"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1).width = a(bo.apX((String)paramMap.get(paramString + ".streamDisplayWidth")), paramInt1, paramInt2, paramInt3);
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1).height = a(bo.apX((String)paramMap.get(paramString + ".streamDisplayHeight")), paramInt1, paramInt2, paramInt3);
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1).rtm = bo.apV((String)paramMap.get(paramString + ".streamDisplayType"));
      String str2 = bo.nullAsNil((String)paramMap.get(paramString + ".floatComponentId"));
      int i = bo.apV((String)paramMap.get(paramString + ".floatStartTime"));
      if ((!bo.isNullOrNil(str2)) && (i > 0))
      {
        localObject2 = new y();
        ((y)localObject2).cCo = str2;
        ((y)localObject2).rtj = i;
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject1).rsG = ((y)localObject2);
      }
      continue;
      localObject1 = new aa();
      ((aa)localObject1).rsJ = k;
      ((aa)localObject1).subType = m;
      ((aa)localObject1).nDe = bo.bf((String)paramMap.get(paramString + ".webviewUrl"), "");
      continue;
      double d1 = a(bo.apX((String)paramMap.get(paramString + ".topLineSize")), paramInt1, paramInt2, paramInt3);
      double d2 = a(bo.apX((String)paramMap.get(paramString + ".bottomLineSize")), paramInt1, paramInt2, paramInt3);
      if (Et(paramInt4)) {
        i = Color.argb(51, 0, 0, 0);
      }
      int j;
      for (;;)
      {
        if (k == 121)
        {
          double d3 = bo.apX((String)paramMap.get(paramString + ".location.$x"));
          double d4 = bo.apX((String)paramMap.get(paramString + ".location.$y"));
          j = bo.apV((String)paramMap.get(paramString + ".location.$scale"));
          localObject1 = (String)paramMap.get(paramString + ".location.$label");
          str2 = (String)paramMap.get(paramString + ".location.$poiname");
          if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(str2)))
          {
            AppMethodBeat.o(37734);
            return null;
            i = Color.argb(51, 255, 255, 255);
          }
          else
          {
            localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g(d1, d2, new g.a(d3, d4, j, (String)localObject1, str2), i);
            break;
          }
        }
      }
      if (k == 122)
      {
        str2 = paramString + ".phoneNumList.phoneNum";
        localObject2 = new ArrayList();
        j = 0;
        if (j == 0) {}
        for (localObject1 = (String)paramMap.get(str2);; localObject1 = (String)paramMap.get(str2 + j))
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label5199;
          }
          ((List)localObject2).add(localObject1);
          j += 1;
          break;
        }
        label5199:
        if (!((List)localObject2).isEmpty())
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d(d1, d2, i, (List)localObject2);
        }
        else
        {
          AppMethodBeat.o(37734);
          return null;
          localObject1 = new v();
          ((v)localObject1).rsJ = k;
          ((v)localObject1).subType = m;
          ((v)localObject1).label = bo.bf((String)paramMap.get(paramString + ".label"), "");
          ((v)localObject1).value = ((float)bo.apX((String)paramMap.get(paramString + ".value")));
          ((v)localObject1).rsU = bo.bf((String)paramMap.get(paramString + ".foregroundImage"), "");
          ((v)localObject1).fontSize = a(bo.apX((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
          ((v)localObject1).hhh = bo.bf((String)paramMap.get(paramString + ".backgroundColor"), "");
          continue;
          localObject1 = a(paramMap, paramString, paramInt1, paramInt2, paramInt3);
          continue;
          localObject1 = new p();
          ((p)localObject1).rrg = bo.bf((String)paramMap.get(paramString + ".sphereThumbUrl"), "");
          ((p)localObject1).rqV = bo.apV((String)paramMap.get(paramString + ".displayType"));
          ((p)localObject1).rre = bo.apV((String)paramMap.get(paramString + ".gestureDelayTime"));
          ((p)localObject1).rrf = bo.bf((String)paramMap.get(paramString + ".sphereImageUrl"), "");
          try
          {
            ((p)localObject1).rrh = bo.bf((String)paramMap.get(paramString + ".bgColor"), "");
            if ((paramMap.containsKey(paramString + ".bgColorAlpha")) && (((p)localObject1).rrh.length() > 0)) {
              ((p)localObject1).rrh = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bo.apX((String)paramMap.get(paramString + ".bgColorAlpha")) * 255.0D)), ((p)localObject1).rrh.substring(1) });
            }
          }
          catch (Exception localException3)
          {
            try
            {
              for (;;)
              {
                ((p)localObject1).width = a(bo.apX((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
                ((p)localObject1).height = a(bo.apX((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
                ((p)localObject1).rsx = bo.bf((String)paramMap.get(".adxml.adSphereCardInfo.sphereImageUrl"), "");
                ((p)localObject1).rsy = bo.bf((String)paramMap.get(".adxml.adSphereCardInfo.sphereThumbUrl"), "");
                break;
                localException3 = localException3;
                com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse color exp=" + localException3.toString());
              }
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                ((p)localObject1).width = 0.0F;
                ((p)localObject1).height = 0.0F;
                com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse size exp=" + localException4.toString());
              }
            }
          }
        }
      }
      else
      {
        localObject1 = null;
      }
    }
  }
  
  private static void a(t paramt, Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(37739);
    paramt.rsJ = bo.apV((String)paramMap.get(paramString + ".type"));
    paramt.type = paramt.rsJ;
    paramt.rsI = bo.bf((String)paramMap.get(paramString + ".id"), "");
    paramt.paddingTop = a(bo.apX((String)paramMap.get(paramString + ".paddingTop")), paramInt1, paramInt2, paramInt3);
    paramt.paddingBottom = a(bo.apX((String)paramMap.get(paramString + ".paddingBottom")), paramInt1, paramInt2, paramInt3);
    paramt.paddingLeft = a(bo.apX((String)paramMap.get(paramString + ".paddingLeft")), paramInt1, paramInt2, paramInt3);
    paramt.paddingRight = a(bo.apX((String)paramMap.get(paramString + ".paddingRight")), paramInt1, paramInt2, paramInt3);
    paramt.subType = bo.apV((String)paramMap.get(paramString + ".subType"));
    paramt.rsN = bo.bf((String)paramMap.get(paramString + ".cellBackgroundColor"), "");
    String str1 = paramString + ".if";
    boolean bool1;
    label398:
    label452:
    label458:
    double d;
    if (paramMap.containsKey(str1)) {
      if ("1".equals(paramMap.get(str1)))
      {
        bool1 = true;
        paramt.rsQ = bool1;
        str1 = paramString + ".noReport";
        if (!paramMap.containsKey(str1)) {
          break label701;
        }
        if (!"1".equals(paramMap.get(str1))) {
          break label695;
        }
        bool1 = bool2;
        paramt.rsR = bool1;
        str1 = bo.bf((String)paramMap.get(paramString + ".layoutWidth"), "");
        String str2 = bo.bf((String)paramMap.get(paramString + ".layoutHeight"), "");
        if (TextUtils.isEmpty(str1)) {
          break label726;
        }
        d = bo.apX(str1);
        if (d >= 0.0D) {
          break label709;
        }
        paramt.rsK = ((float)d);
        label559:
        if (TextUtils.isEmpty(str2)) {
          break label753;
        }
        d = bo.apX(str2);
        if (d >= 0.0D) {
          break label736;
        }
        paramt.rsL = ((float)d);
        label588:
        str1 = (String)paramMap.get(paramString + ".verticalAlignment");
        paramMap = (String)paramMap.get(paramString + ".horizontalAlignment");
        if (!TextUtils.isEmpty(str1)) {
          break label763;
        }
      }
    }
    label695:
    label701:
    label709:
    label726:
    label736:
    label753:
    label763:
    for (paramt.rsO = -1;; paramt.rsO = bo.apV(str1))
    {
      if (!TextUtils.isEmpty(paramMap)) {
        break label775;
      }
      paramt.rsP = -1;
      AppMethodBeat.o(37739);
      return;
      bool1 = false;
      break;
      paramt.rsQ = true;
      break label398;
      bool1 = false;
      break label452;
      paramt.rsR = false;
      break label458;
      paramt.rsK = a(d, paramInt1, paramInt2, paramInt3);
      break label559;
      paramt.rsK = 2.147484E+009F;
      break label559;
      paramt.rsL = a(d, paramInt1, paramInt2, paramInt3);
      break label588;
      paramt.rsL = 2.147484E+009F;
      break label588;
    }
    label775:
    paramt.rsP = bo.apV(paramMap);
    AppMethodBeat.o(37739);
  }
  
  public static boolean a(TimeLineObject paramTimeLineObject, Activity paramActivity)
  {
    AppMethodBeat.i(37752);
    String str = paramTimeLineObject.sbN;
    long l = new BigInteger(paramTimeLineObject.Id).longValue();
    LinkedList localLinkedList = paramTimeLineObject.xTS.wOa;
    boolean bool;
    Object localObject;
    int i;
    int j;
    if (!TextUtils.isEmpty(str))
    {
      if ((TextUtils.isEmpty(str)) || (!abq(str))) {
        break label382;
      }
      paramTimeLineObject = "";
      bool = abp(str);
      if (!bool) {
        break label402;
      }
      localObject = com.tencent.mm.model.c.c.abV().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
      if (com.tencent.mm.model.c.c.abV().eB("Sns_Canvas_GameShare_JumpWay", 0) == 0)
      {
        i = 0;
        j = i;
        paramTimeLineObject = (TimeLineObject)localObject;
        if (i == 0)
        {
          j = i;
          paramTimeLineObject = (TimeLineObject)localObject;
          if (crW())
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
        localObject = ag.cpf().lZ(l);
        Intent localIntent = new Intent();
        if (localObject != null)
        {
          localIntent.putExtra("sns_landing_pages_share_sns_id", ((com.tencent.mm.plugin.sns.storage.n)localObject).getSnsId());
          localIntent.putExtra("sns_landing_pages_rawSnsId", ((com.tencent.mm.plugin.sns.storage.n)localObject).csh().Id);
          localIntent.putExtra("sns_landing_pages_ux_info", ((com.tencent.mm.plugin.sns.storage.n)localObject).csP());
          localIntent.putExtra("sns_landing_pages_aid", ((com.tencent.mm.plugin.sns.storage.n)localObject).csM());
          localIntent.putExtra("sns_landing_pages_traceid", ((com.tencent.mm.plugin.sns.storage.n)localObject).csN());
          localIntent.putExtra("sns_landing_pages_rec_src", ((com.tencent.mm.plugin.sns.storage.n)localObject).csR());
        }
        if ((localLinkedList != null) && (localLinkedList.size() > 0)) {
          localIntent.putExtra("sns_landing_pages_share_thumb_url", ((bcs)localLinkedList.get(0)).xrS);
        }
        localIntent.putExtra("sns_landing_pages_expid", paramTimeLineObject);
        localIntent.putExtra("sns_landig_pages_from_source", 11);
        localIntent.setClass(paramActivity, SnsAdNativeLandingPagesUI.class);
        localIntent.putExtra("sns_landing_pages_xml", str);
        localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        paramActivity.startActivity(localIntent);
        AppMethodBeat.o(37752);
        return true;
        i = 1;
        break;
      }
      b(str, paramActivity, bool, 11);
      for (;;)
      {
        AppMethodBeat.o(37752);
        return false;
        label382:
        com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str });
      }
      label402:
      j = 1;
    }
  }
  
  private static boolean abp(String paramString)
  {
    AppMethodBeat.i(37746);
    if (bo.apV(bo.bf((String)br.F(paramString, "adCanvasInfo").get(".adCanvasInfo.bizId"), "")) == 1)
    {
      AppMethodBeat.o(37746);
      return true;
    }
    AppMethodBeat.o(37746);
    return false;
  }
  
  public static boolean abq(String paramString)
  {
    AppMethodBeat.i(156756);
    boolean bool = gD(paramString, "adCanvasInfo");
    AppMethodBeat.o(156756);
    return bool;
  }
  
  public static LinkedList<g> am(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(37745);
    Object localObject2 = new String(paramString1);
    Object localObject1 = localObject2;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString3);
      localObject1 = localObject2;
      com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "the jsonObject is " + localJSONObject.toString());
      localObject1 = localObject2;
      Iterator localIterator = localJSONObject.keys();
      paramString3 = (String)localObject2;
      localObject1 = paramString3;
      localObject2 = paramString3;
      if (localIterator.hasNext())
      {
        localObject1 = paramString3;
        localObject2 = localIterator.next();
        if (localObject2 == null) {
          break label234;
        }
        localObject1 = paramString3;
        if (!(localObject2 instanceof String)) {
          break label234;
        }
        localObject1 = paramString3;
        localObject2 = (String)localObject2;
        localObject1 = paramString3;
        String str = localJSONObject.getString((String)localObject2);
        localObject1 = paramString3;
        if (bo.isNullOrNil(str)) {
          break label234;
        }
        localObject1 = paramString3;
        paramString3 = paramString3.replace("{{" + (String)localObject2 + "}}", "<![CDATA[" + str + "]]>");
      }
      for (;;)
      {
        break;
      }
    }
    catch (Exception paramString3)
    {
      com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the json is parsed error : ".concat(String.valueOf(paramString1)));
      localObject2 = localObject1;
      paramString1 = gC((String)localObject2, paramString2);
      AppMethodBeat.o(37745);
      return paramString1;
    }
  }
  
  private static List<t> b(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(37736);
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
      if (!paramString.rsQ) {
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
      com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "comp " + paramString.toString() + " ifCondition is false");
    }
    label147:
    AppMethodBeat.o(37736);
    return localArrayList;
  }
  
  private static boolean b(String paramString, Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(37747);
    paramString = (String)br.F(paramString, "adCanvasInfo").get(".adCanvasInfo.shareWebUrl");
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(37747);
      return false;
    }
    String str = paramString;
    if (paramBoolean) {
      str = "exp=" + com.tencent.mm.model.c.c.abV().getExpIdByKey("Sns_Canvas_GameShare_JumpWay") + "_" + paramInt;
    }
    try
    {
      str = m(paramString, new String[] { str });
      paramString = str;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      label102:
      break label102;
    }
    com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "canvas jump url ".concat(String.valueOf(paramString)));
    str = paramString;
    paramString = new Intent();
    paramString.putExtra("rawUrl", str);
    paramString.putExtra("showShare", true);
    com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(37747);
    return true;
  }
  
  private static m c(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(37737);
    m localm = new m();
    try
    {
      i = Color.parseColor((String)paramMap.get(paramString + ".bgColorTheme"));
      localm.backgroundColor = ((int)(bo.getDouble((String)paramMap.get(paramString + ".bgColorAlpha"), 0.0D) * 255.0D) << 24 | i & 0xFFFFFF);
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
        if (paramString.rsQ) {
          localm.rsu.add(paramString);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "%s", new Object[] { bo.l(localException) });
        localm.backgroundColor = Color.argb(51, 0, 0, 0);
        continue;
        paramString = localException + i;
      }
      label260:
      AppMethodBeat.o(37737);
    }
    return localm;
  }
  
  private static boolean crW()
  {
    AppMethodBeat.i(37750);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100150");
    if (localc.isValid())
    {
      int i = bo.getInt((String)localc.dvN().get("openCanvas"), 0);
      com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "canOpenGameCanvas abtest=".concat(String.valueOf(i)));
      if (i == 1)
      {
        AppMethodBeat.o(37750);
        return true;
      }
      AppMethodBeat.o(37750);
      return false;
    }
    AppMethodBeat.o(37750);
    return false;
  }
  
  private static void crX()
  {
    AppMethodBeat.i(37755);
    if (rCl != null)
    {
      AppMethodBeat.o(37755);
      return;
    }
    rCl = new HashSet();
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    for (;;)
    {
      int k;
      try
      {
        localInputStream = ah.getContext().getAssets().open("sns/canvas_valid_type.xml");
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
            if (bo.getInt(localXmlPullParser.getAttributeValue(null, "android"), 0) != 1) {
              continue;
            }
            localObject2 = localInputStream;
            localObject4 = localInputStream;
            localObject1 = localInputStream;
            i1 = bo.getInt(localXmlPullParser.getAttributeValue(null, "val"), -1);
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
          localObject5 = new i.a((byte)0);
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((i.a)localObject5).rCm = i;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((i.a)localObject5).rCn = k;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          ((i.a)localObject5).rCo = i1;
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          rCl.add(localObject5);
          localObject2 = localInputStream;
          localObject4 = localInputStream;
          localObject1 = localInputStream;
          com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "valid canvas type ".concat(String.valueOf(localObject5)));
          m = i;
        }
      }
      catch (IOException localIOException6)
      {
        InputStream localInputStream;
        localObject1 = localObject2;
        com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", bo.l(localIOException6));
        if (localObject2 != null)
        {
          try
          {
            localObject2.close();
            AppMethodBeat.o(37755);
            return;
          }
          catch (IOException localIOException2)
          {
            AppMethodBeat.o(37755);
            return;
          }
          if (localInputStream != null) {
            try
            {
              localInputStream.close();
              AppMethodBeat.o(37755);
              return;
            }
            catch (IOException localIOException1)
            {
              AppMethodBeat.o(37755);
              return;
            }
          }
        }
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        IOException localIOException3 = localIOException6;
        com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", bo.l(localXmlPullParserException));
        if (localIOException6 != null) {
          try
          {
            localIOException6.close();
            AppMethodBeat.o(37755);
            return;
          }
          catch (IOException localIOException4)
          {
            AppMethodBeat.o(37755);
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
          AppMethodBeat.o(37755);
          throw localObject3;
          AppMethodBeat.o(37755);
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
  
  private static z d(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(37738);
    z localz = new z();
    a(localz, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localz.rtk = bo.apV((String)paramMap.get(paramString + ".pageCtrType"));
    boolean bool;
    String str1;
    int i;
    if (bo.apV((String)paramMap.get(paramString + ".isFullScreen")) == 1)
    {
      bool = true;
      localz.jew = bool;
      str1 = paramString + ".componentGroupList.componentGroup";
      i = 0;
    }
    for (;;)
    {
      label142:
      m localm;
      String str2;
      int j;
      if (i == 0)
      {
        paramString = str1;
        localm = new m();
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
        if (paramString.rsQ) {
          localm.rsu.add(paramString);
        }
        j += 1;
        break label176;
        bool = false;
        break;
        paramString = str1 + i;
        break label142;
      }
      label280:
      if (localm.rsu.size() == 0) {
        break label311;
      }
      localz.rsu.add(localm);
      i += 1;
    }
    label311:
    AppMethodBeat.o(37738);
    return localz;
  }
  
  public static void df(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h> paramList)
  {
    AppMethodBeat.i(37758);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(37758);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h localh = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h)localIterator.next();
      if (Eo(localh.cqV().type)) {
        localArrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)localh).cqT());
      }
    }
    if (!localArrayList.isEmpty())
    {
      df(localArrayList);
      paramList.addAll(localArrayList);
    }
    AppMethodBeat.o(37758);
  }
  
  private static t e(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(37740);
    u localu = new u();
    localu.rsT = bo.apV((String)paramMap.get(paramString + ".subType"));
    a(localu, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    String str = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = str;; paramString = str + i)
    {
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label161;
      }
      if (paramString.rsQ) {
        localu.rsS.add(paramString);
      }
      i += 1;
      break;
    }
    label161:
    AppMethodBeat.o(37740);
    return localu;
  }
  
  private static t f(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(37741);
    Object localObject = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    s locals = new s();
    locals.aWy = ((List)localObject);
    a(locals, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localObject = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = (String)localObject;; paramString = (String)localObject + i)
    {
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label147;
      }
      if (paramString.rsQ) {
        locals.aWy.add(paramString);
      }
      i += 1;
      break;
    }
    label147:
    AppMethodBeat.o(37741);
    return locals;
  }
  
  private static t g(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(37742);
    Object localObject = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    r localr = new r();
    localr.rsH = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), bo.apV((String)paramMap.get(paramString + ".cornerRadius")));
    localr.aWy = ((List)localObject);
    a(localr, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localObject = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0) {}
    for (paramString = (String)localObject;; paramString = (String)localObject + i)
    {
      paramString = a(paramMap, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
      if (paramString == null) {
        break label190;
      }
      if (paramString.rsQ) {
        localr.aWy.add(paramString);
      }
      i += 1;
      break;
    }
    label190:
    AppMethodBeat.o(37742);
    return localr;
  }
  
  public static LinkedList<g> gC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37743);
    LinkedList localLinkedList = new LinkedList();
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(37743);
      return localLinkedList;
    }
    if (TextUtils.isEmpty(paramString1)) {}
    Map localMap;
    for (;;)
    {
      localMap = br.F(paramString1, paramString2);
      if (localMap != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ab.w("AdLandingPagesParseHelper", " parse landingpages xml is error ,".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(37743);
      return localLinkedList;
      paramString1 = paramString1.replaceAll("\\{\\{.*?\\}\\}", "");
    }
    int i1 = bo.apV((String)localMap.get("." + paramString2 + ".adCanvasInfo.sizeType"));
    int j = bo.apV((String)localMap.get("." + paramString2 + ".adCanvasInfo.basicRootFontSize"));
    int k = bo.apV((String)localMap.get("." + paramString2 + ".adCanvasInfo.basicWidth"));
    int i = j;
    if (j == 0)
    {
      i = j;
      if (i1 == 1) {
        i = rCk;
      }
    }
    j = k;
    if (k == 0)
    {
      j = k;
      if (i1 == 1) {
        j = rCj;
      }
    }
    if ((!bo.isNullOrNil(paramString2)) && (!".adCanvasInfo.PageList.Page".equals("adCanvasInfo"))) {}
    for (paramString1 = "." + paramString2 + ".adCanvasInfo.PageList.Page";; paramString1 = ".adCanvasInfo.PageList.Page")
    {
      k = 0;
      for (;;)
      {
        g localg;
        boolean bool;
        label420:
        Object localObject;
        label489:
        label496:
        String str;
        int m;
        if (k == 0)
        {
          paramString2 = paramString1;
          localg = new g();
          localg.rCe = bo.bf((String)localMap.get(paramString2 + ".backgroundCover"), "");
          localg.hhh = bo.bf((String)localMap.get(paramString2 + ".backgroundColor"), "");
          if (bo.apV((String)localMap.get(paramString2 + ".backgroundCover.$isAddBlur")) <= 0) {
            break label655;
          }
          bool = true;
          localg.rCf = bool;
          localg.id = k;
          localObject = paramString2 + ".if";
          if (!localMap.containsKey(localObject)) {
            break label667;
          }
          if (!"1".equals(localMap.get(localObject))) {
            break label661;
          }
          bool = true;
          localg.rCi = bool;
          if (!localg.rCi) {
            break label802;
          }
          str = paramString2 + ".componentItemList.componentItem";
          m = 0;
          label529:
          if (m != 0) {
            break label676;
          }
          paramString2 = str;
        }
        for (;;)
        {
          try
          {
            if (TextUtils.isEmpty(localg.hhh)) {
              continue;
            }
            n = Color.parseColor(localg.hhh);
            localObject = a(localMap, i1, j, i, n, paramString2);
          }
          catch (Exception localException)
          {
            int n;
            label655:
            label661:
            label667:
            label676:
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", bo.l(localException));
            t localt = a(localMap, i1, j, i, 0, paramString2);
            continue;
            localg.rCg.add(localt);
            continue;
            com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "comp " + localt.toString() + " ifCondition is false");
            continue;
          }
          if (localObject == null) {
            break label783;
          }
          if (!((t)localObject).rsQ) {
            continue;
          }
          a((t)localObject, localMap, paramString2, i1, j, i);
          if (!(localObject instanceof r)) {
            continue;
          }
          localg.rCh.put(((t)localObject).rsI, localObject);
          m += 1;
          break label529;
          paramString2 = paramString1 + k;
          break;
          bool = false;
          break label420;
          bool = false;
          break label489;
          localg.rCi = true;
          break label496;
          paramString2 = str + m;
          continue;
          n = 0;
        }
        label783:
        if (localg.rCg.size() == 0) {
          break;
        }
        localLinkedList.add(localg);
        label802:
        k += 1;
      }
      if (localLinkedList.size() > 0) {
        ((g)localLinkedList.get(0)).njm = true;
      }
      AppMethodBeat.o(37743);
      return localLinkedList;
    }
  }
  
  public static boolean gD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37754);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(37754);
      return false;
    }
    if (rCl == null) {
      crX();
    }
    if ((rCl != null) && (!rCl.isEmpty()))
    {
      Map localMap = br.F(paramString1, paramString2);
      if ((localMap == null) || (localMap.isEmpty()))
      {
        com.tencent.mm.sdk.platformtools.ab.w("AdLandingPagesParseHelper", "invalid landingpages xml,".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(37754);
        return false;
      }
      i.a locala = new i.a((byte)0);
      locala.rCm = 0;
      locala.rCn = bo.apV((String)localMap.get(".adCanvasInfo.type"));
      locala.rCo = bo.apV((String)localMap.get(".adCanvasInfo.subtype"));
      if (!rCl.contains(locala))
      {
        com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "invalid canvas type ".concat(String.valueOf(locala)));
        AppMethodBeat.o(37754);
        return false;
      }
      int i = 0;
      for (;;)
      {
        locala.rCm = 1;
        if (i == 0) {}
        for (paramString1 = ".adCanvasInfo.PageList.Page";; paramString1 = ".adCanvasInfo.PageList.Page" + i)
        {
          if (!localMap.containsKey(paramString1 + ".componentItemList.componentItem.type")) {
            break label586;
          }
          locala.rCn = bo.apV((String)localMap.get(paramString1 + ".type"));
          locala.rCo = bo.apV((String)localMap.get(paramString1 + ".subType"));
          if (rCl.contains(locala)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "invalid page type ".concat(String.valueOf(locala)));
          AppMethodBeat.o(37754);
          return false;
        }
        paramString2 = paramString1 + ".componentItemList.componentItem";
        locala.rCm = 2;
        int j = 0;
        for (;;)
        {
          if (j == 0) {}
          for (paramString1 = paramString2;; paramString1 = paramString2 + j)
          {
            if (!localMap.containsKey(paramString1 + ".type")) {
              break label579;
            }
            locala.rCn = bo.apV((String)localMap.get(paramString1 + ".type"));
            locala.rCo = bo.apV((String)localMap.get(paramString1 + ".subType"));
            if (rCl.contains(locala)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(locala)));
            AppMethodBeat.o(37754);
            return false;
          }
          j += 1;
        }
        label579:
        i += 1;
      }
      label586:
      locala.rCm = 2;
      paramString1 = localMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        Object localObject = (Map.Entry)paramString1.next();
        if ((((Map.Entry)localObject).getKey() != null) && (((String)((Map.Entry)localObject).getKey()).matches("[\\s\\S]*\\.componentItem[0-9]*\\.type$")))
        {
          paramString2 = (String)((Map.Entry)localObject).getKey();
          localObject = ((String)((Map.Entry)localObject).getKey()).replace(".type", ".subType");
          locala.rCn = bo.apV((String)localMap.get(paramString2));
          locala.rCo = bo.apV((String)localMap.get(localObject));
          if (!rCl.contains(locala))
          {
            com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(locala)));
            AppMethodBeat.o(37754);
            return false;
          }
        }
      }
      AppMethodBeat.o(37754);
      return true;
    }
    AppMethodBeat.o(37754);
    return false;
  }
  
  public static String m(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(37748);
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
        AppMethodBeat.o(37748);
        return paramString;
      }
    }
    AppMethodBeat.o(37748);
    return paramString;
  }
  
  public static String n(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(37749);
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
        AppMethodBeat.o(37749);
        return paramString;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "append url params failed, %s", new Object[] { paramString.toString() });
        AppMethodBeat.o(37749);
        return str1;
      }
    }
    paramString = str1 + paramString + paramVarArgs;
    AppMethodBeat.o(37749);
    return paramString;
  }
  
  private static String x(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(37757);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the adLandingPagesXml is empty");
      AppMethodBeat.o(37757);
      return null;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
      AppMethodBeat.o(37757);
      return null;
    }
    LinkedList localLinkedList = gC(paramString, "adxml");
    Iterator localIterator1 = paramMap.keySet().iterator();
    String str1 = paramString;
    String str3;
    String str2;
    Iterator localIterator2;
    while (localIterator1.hasNext())
    {
      str3 = (String)localIterator1.next();
      if (!bo.isNullOrNil(str3))
      {
        str2 = (String)paramMap.get(str3);
        if (!bo.isNullOrNil(str2))
        {
          localIterator2 = localLinkedList.iterator();
          paramString = null;
        }
      }
    }
    label336:
    label338:
    for (;;)
    {
      if (localIterator2.hasNext())
      {
        Iterator localIterator3 = ((g)localIterator2.next()).rCg.iterator();
        while (localIterator3.hasNext())
        {
          t localt = (t)localIterator3.next();
          if (((localt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)) && (!bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)localt).knc)) && (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)localt).knc.equals(str3)))
          {
            paramString = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)localt).knR;
            label241:
            if (paramString == null) {
              break label338;
            }
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (bo.isNullOrNil(paramString)) {
            break label336;
          }
          com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "old card ext is " + paramString + " and new card ext is " + str2);
          str1 = str1.replace(paramString, str2);
          try
          {
            paramString = str1.replace(bo.apT(paramString), bo.apT(str2));
            str1 = paramString;
          }
          catch (Exception paramString)
          {
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the xml is error");
          }
        }
        break;
        AppMethodBeat.o(37757);
        return str1;
        break label241;
      }
      break;
    }
  }
  
  public static String y(com.tencent.mm.plugin.sns.storage.n paramn)
  {
    AppMethodBeat.i(37756);
    if (paramn == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the snsinfo is null");
      AppMethodBeat.o(37756);
      return null;
    }
    if (!paramn.Ex(32))
    {
      com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the snsinfo is not a ad");
      AppMethodBeat.o(37756);
      return null;
    }
    com.tencent.mm.plugin.sns.storage.e locale = paramn.csQ();
    if (locale == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the adSnsInfo is null");
      AppMethodBeat.o(37756);
      return null;
    }
    com.tencent.mm.plugin.sns.storage.b localb = paramn.csb();
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the adxml is null");
      AppMethodBeat.o(37756);
      return null;
    }
    paramn = paramn.csd();
    if (paramn == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the adInfo is null");
      AppMethodBeat.o(37756);
      return null;
    }
    if (!localb.cqk())
    {
      com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the snsinfo is not a landingpage");
      AppMethodBeat.o(37756);
      return null;
    }
    if ((paramn.rpx == null) || (paramn.rpx.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
      AppMethodBeat.o(37756);
      return null;
    }
    paramn = x(locale.field_adxml, paramn.rpx);
    AppMethodBeat.o(37756);
    return paramn;
  }
  
  public static boolean y(Intent paramIntent, Context paramContext)
  {
    boolean bool1 = false;
    AppMethodBeat.i(37751);
    String str2 = paramIntent.getStringExtra("sns_landing_pages_xml");
    String str1;
    boolean bool2;
    if (!TextUtils.isEmpty(str2)) {
      if ((!TextUtils.isEmpty(str2)) && (gD(str2, "adCanvasInfo")))
      {
        str1 = "";
        bool2 = abp(str2);
        if (!bool2) {
          break label216;
        }
        str1 = com.tencent.mm.model.c.c.abV().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
        if (!TextUtils.isEmpty(str1))
        {
          int i = com.tencent.mm.model.c.c.abV().eB("Sns_Canvas_GameShare_JumpWay", 0);
          com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "abtestvalue = ".concat(String.valueOf(i)));
          if (i != 0) {}
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
        paramContext.startActivity(paramIntent);
        AppMethodBeat.o(37751);
        return true;
        bool1 = true;
        continue;
        bool1 = crW();
      }
      else
      {
        bool1 = b(str2, paramContext, bool2, paramIntent.getIntExtra("sns_landig_pages_from_source", -1));
        AppMethodBeat.o(37751);
        return bool1;
        com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str2 });
        AppMethodBeat.o(37751);
        return false;
        label216:
        bool1 = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i
 * JD-Core Version:    0.7.0.1
 */