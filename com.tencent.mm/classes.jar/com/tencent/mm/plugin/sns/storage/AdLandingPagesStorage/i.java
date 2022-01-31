package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h.a;
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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y.a;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class i
{
  public static int oKA = 750;
  public static int oKB = 10;
  private static Set<i.a> oKC = null;
  
  private static boolean Ov(String paramString)
  {
    return bk.ZR(bk.aM((String)bn.s(paramString, "adCanvasInfo").get(".adCanvasInfo.bizId"), "")) == 1;
  }
  
  public static boolean Ow(String paramString)
  {
    return eW(paramString, "adCanvasInfo");
  }
  
  public static float a(double paramDouble, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return (float)paramDouble;
    }
    if (paramInt2 == 0) {
      return (float)paramDouble;
    }
    paramInt1 = ((WindowManager)ae.getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    float f1 = (float)paramDouble;
    float f2 = paramInt3;
    return ad.aD(paramInt1 * (f1 * f2) / paramInt2);
  }
  
  private static s a(Map<String, String> paramMap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    int j = bk.ZR((String)paramMap.get(paramString + ".type"));
    if (ym(j)) {
      try
      {
        s locals = a(paramMap, paramString, paramInt1, paramInt3, paramInt2, paramInt4);
        return locals;
      }
      catch (Exception localException)
      {
        return a(paramMap, paramString, paramInt1, paramInt3, paramInt2, 0);
      }
    }
    if (j == 101) {}
    for (int i = 1; i != 0; i = 0) {
      return d(paramMap, paramString, paramInt1, paramInt3, paramInt2, paramInt4);
    }
    if (yn(j)) {
      return e(paramMap, paramString, paramInt1, paramInt3, paramInt2, paramInt4);
    }
    com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", "the type" + j + " is not client known type");
    return null;
  }
  
  private static s a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = bk.ZR((String)paramMap.get(paramString + ".type"));
    int m = bk.ZR((String)paramMap.get(paramString + ".subType"));
    Object localObject2;
    Object localObject1;
    switch (k)
    {
    default: 
      localObject2 = null;
      return localObject2;
    case 82: 
      localObject1 = new x();
      ((x)localObject1).url = bk.aM((String)paramMap.get(paramString + ".webviewUrl"), "");
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      ((s)localObject1).oDo = yo(paramInt4);
      ((s)localObject1).type = k;
      ((s)localObject1).brC = m;
      a((s)localObject1, paramMap, paramString, paramInt1, paramInt2, paramInt3);
      return localObject1;
      localObject2 = b(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e();
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)localObject1).aPf = ((List)localObject2);
      continue;
      localObject1 = c(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      continue;
      localObject1 = new u();
      ((u)localObject1).oDh = k;
      ((u)localObject1).brC = m;
      ((u)localObject1).oDD = bk.aM((String)paramMap.get(paramString + ".content"), "");
      ((u)localObject1).textAlignment = bk.ZR((String)paramMap.get(paramString + ".textAlignment"));
      ((u)localObject1).oDE = bk.aM((String)paramMap.get(paramString + ".fontColor"), "");
      ((u)localObject1).dOB = a(bk.ZT((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
      if ((bk.ZR((String)paramMap.get(paramString + ".showType")) & u.oDy) > 0)
      {
        bool = true;
        label567:
        ((u)localObject1).oDF = bool;
        if ((bk.ZR((String)paramMap.get(paramString + ".showType")) & u.oDz) <= 0) {
          break label788;
        }
        bool = true;
        label615:
        ((u)localObject1).oDG = bool;
        if ((bk.ZR((String)paramMap.get(paramString + ".showType")) & u.oDA) <= 0) {
          break label794;
        }
      }
      label788:
      label794:
      for (boolean bool = true;; bool = false)
      {
        ((u)localObject1).oDH = bool;
        ((u)localObject1).maxLines = bk.ZR((String)paramMap.get(paramString + ".maxLines"));
        ((u)localObject1).oDI = bk.ZR((String)paramMap.get(paramString + ".fontType"));
        ((u)localObject1).oDJ = bk.ZU((String)paramMap.get(paramString + ".lineSpace"));
        break;
        bool = false;
        break label567;
        bool = false;
        break label615;
      }
      if (m == 2)
      {
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b();
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).bOL = ((String)paramMap.get(paramString + ".appid"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).oCr = ((String)paramMap.get(paramString + ".appPageUrlAndroid"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).channelId = ((String)paramMap.get(paramString + ".channelId"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).Bo = ((String)paramMap.get(paramString + ".pkg"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).oCg = bk.ZR((String)paramMap.get(paramString + ".platform"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).oCh = ((String)paramMap.get(paramString + ".warningAndroid"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).oCi = ((String)paramMap.get(paramString + ".btnBgColorTheme"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).oCk = ((String)paramMap.get(paramString + ".btnBgColorThemePressed"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).oCj = ((String)paramMap.get(paramString + ".btnBgColorThemeDisable"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).oCl = ((String)paramMap.get(paramString + ".btnBorderColorTheme"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).oCn = ((String)paramMap.get(paramString + ".btnBorderColorThemePressed"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).oCm = ((String)paramMap.get(paramString + ".btnBorderColorThemeDisable"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).oCo = ((String)paramMap.get(paramString + ".fontColor"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).oCq = ((String)paramMap.get(paramString + ".fontColorPressed"));
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject1).oCp = ((String)paramMap.get(paramString + ".fontColorDisable"));
      }
      int i;
      ArrayList localArrayList;
      for (;;)
      {
        ((l)localObject1).oDh = k;
        ((l)localObject1).brC = m;
        ((l)localObject1).title = bk.aM((String)paramMap.get(paramString + ".btnTitle"), "");
        ((l)localObject1).oCC = bk.ZR((String)paramMap.get(paramString + ".btnType"));
        ((l)localObject1).oCD = bk.aM((String)paramMap.get(paramString + ".btnJumpUrl"), "");
        ((l)localObject1).oCE = bk.aM((String)paramMap.get(paramString + ".btnJumpApp"), "");
        ((l)localObject1).oCF = bk.aM((String)paramMap.get(paramString + ".fontColor"), "");
        ((l)localObject1).fontSize = a(bk.ZT((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
        ((l)localObject1).textAlignment = bk.ZR((String)paramMap.get(paramString + ".btnAlignment"));
        ((l)localObject1).oCG = a(bk.ZT((String)paramMap.get(paramString + ".borderSize")), paramInt1, paramInt2, paramInt3);
        ((l)localObject1).height = a(bk.ZT((String)paramMap.get(paramString + ".btnHeight")), paramInt1, paramInt2, paramInt3);
        ((l)localObject1).oCH = bk.aM((String)paramMap.get(paramString + ".btnBgColorTheme"), "");
        ((l)localObject1).oCI = bk.aM((String)paramMap.get(paramString + ".btnBorderColorTheme"), "");
        ((l)localObject1).oCJ = bk.aM((String)paramMap.get(paramString + ".btnBgImgUrl"), "");
        ((l)localObject1).oCK = bk.ZR((String)paramMap.get(paramString + ".bCanLongPress"));
        ((l)localObject1).oCL = bk.ZR((String)paramMap.get(paramString + ".bHideActionSheet"));
        ((l)localObject1).oCM = bk.ZR((String)paramMap.get(paramString + ".hideProductActionHeader"));
        ((l)localObject1).oCN = bk.ZR((String)paramMap.get(paramString + ".showProductActionCancelButton"));
        ((l)localObject1).oCP = bk.aM((String)paramMap.get(paramString + ".productActionTitle"), "");
        ((l)localObject1).oCO = bk.aM((String)paramMap.get(paramString + ".productActionBuffer"), "");
        ((l)localObject1).oCQ = bk.aM((String)paramMap.get(paramString + ".productActionIconUrl"), "");
        if (paramMap.containsKey(paramString + ".productActionItem.componentItem.type")) {
          ((l)localObject1).oCR = a(paramMap, paramInt1, paramInt3, paramInt2, paramInt4, paramString + ".productActionItem.componentItem");
        }
        break;
        if (m == 4)
        {
          localObject1 = new f();
          ((f)localObject1).imf = bk.aM((String)paramMap.get(paramString + ".cardTpId"), "");
          ((f)localObject1).imW = bk.aM((String)paramMap.get(paramString + ".cardExt"), "");
        }
        else if (m == 7)
        {
          localObject1 = new k();
          ((k)localObject1).oCx = bk.aM((String)paramMap.get(paramString + ".jumpCanvasId"), "");
          ((k)localObject1).oCy = bk.aM((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
          ((k)localObject1).oCz = bk.ZR((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
          ((k)localObject1).oCA = bk.ZR((String)paramMap.get(paramString + ".btnCanvasEnterType"));
          ((k)localObject1).oCB = bk.ZR((String)paramMap.get(paramString + ".btnCanvasSource"));
        }
        else if (m == 8)
        {
          localObject1 = new j();
          ((j)localObject1).username = ((String)paramMap.get(paramString + ".weappUserName"));
          ((j)localObject1).cas = ((String)paramMap.get(paramString + ".weappPath"));
        }
        else if (m == 9)
        {
          d1 = bk.ZT((String)paramMap.get(paramString + ".location.$x"));
          d2 = bk.ZT((String)paramMap.get(paramString + ".location.$y"));
          i = bk.ZR((String)paramMap.get(paramString + ".location.$scale"));
          localObject1 = (String)paramMap.get(paramString + ".location.$label");
          localObject2 = (String)paramMap.get(paramString + ".location.$poiname");
          if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2))) {
            return null;
          }
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g(new g.a(d1, d2, i, (String)localObject1, (String)localObject2));
        }
        else if (m == 10)
        {
          localObject2 = paramString + ".phoneNumList.phoneNum";
          localArrayList = new ArrayList();
          i = 0;
          if (i == 0) {}
          for (localObject1 = (String)paramMap.get(localObject2);; localObject1 = (String)paramMap.get((String)localObject2 + i))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label2879;
            }
            localArrayList.add(localObject1);
            i += 1;
            break;
          }
          label2879:
          if (!localArrayList.isEmpty()) {
            localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i(localArrayList);
          } else {
            return null;
          }
        }
        else
        {
          localObject1 = new l();
        }
      }
      localObject1 = new p();
      ((p)localObject1).oDh = k;
      ((p)localObject1).brC = m;
      ((p)localObject1).oCV = bk.aM((String)paramMap.get(paramString + ".pureImageUrl"), "");
      ((p)localObject1).oCW = bk.aM((String)paramMap.get(paramString + ".bgColor"), "");
      if ((paramMap.containsKey(paramString + ".bgColorAlpha")) && (((p)localObject1).oCW.length() > 0)) {
        ((p)localObject1).oCW = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(bk.ZT((String)paramMap.get(paramString + ".bgColorAlpha")) * 255.0D)), ((p)localObject1).oCW.substring(1) });
      }
      ((p)localObject1).width = a(bk.ZT((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((p)localObject1).height = a(bk.ZT((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      ((p)localObject1).oCT = false;
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o();
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).oDh = k;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).brC = m;
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).oCV = bk.aM((String)paramMap.get(paramString + ".panoramaImageUrl"), "");
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).width = a(bk.ZT((String)paramMap.get(paramString + ".imageWidth")), paramInt1, paramInt2, paramInt3);
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).height = a(bk.ZT((String)paramMap.get(paramString + ".imageHeight")), paramInt1, paramInt2, paramInt3);
      continue;
      localObject1 = new p();
      ((p)localObject1).oDh = k;
      ((p)localObject1).brC = m;
      ((p)localObject1).oCV = bk.aM((String)paramMap.get(paramString + ".fullScreenImageUrl"), "");
      ((p)localObject1).oCT = true;
      continue;
      localObject1 = new q();
      ((q)localObject1).oDh = k;
      ((q)localObject1).brC = m;
      ((q)localObject1).oCX = bk.aM((String)paramMap.get(paramString + ".sightVideoUrl"), "");
      ((q)localObject1).oCY = bk.aM((String)paramMap.get(paramString + ".sightThumbUrl"), "");
      ((q)localObject1).oCZ = bk.aM((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((q)localObject1).oDa = bk.aM((String)paramMap.get(paramString + ".jumpText"), "");
      ((q)localObject1).oCx = bk.aM((String)paramMap.get(paramString + ".jumpCanvasId"), "");
      ((q)localObject1).oCy = bk.aM((String)paramMap.get(paramString + ".jumpCanvasExt"), "");
      ((q)localObject1).oCz = bk.ZR((String)paramMap.get(paramString + ".jumpCanvasNoStore"));
      try
      {
        ((q)localObject1).oDb = Color.parseColor((String)paramMap.get(paramString + ".jumpTextColor"));
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((q)localObject1).oDc = Color.parseColor((String)paramMap.get(paramString + ".separatorColor"));
            ((q)localObject1).width = a(bk.ZT((String)paramMap.get(paramString + ".sightDisplayWidth")), paramInt1, paramInt2, paramInt3);
            ((q)localObject1).height = a(bk.ZT((String)paramMap.get(paramString + ".sightDisplayHeight")), paramInt1, paramInt2, paramInt3);
            ((q)localObject1).oDd = bk.ZR((String)paramMap.get(paramString + ".sightDisplayType"));
            break;
            localException1 = localException1;
            ((q)localObject1).oDb = Color.rgb(255, 255, 255);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ((q)localObject1).oDc = Color.rgb(255, 255, 255);
          }
        }
      }
      localObject1 = new w();
      ((w)localObject1).oDh = k;
      ((w)localObject1).brC = m;
      ((w)localObject1).oCZ = bk.aM((String)paramMap.get(paramString + ".streamVideoUrl"), "");
      ((w)localObject1).oDK = bk.aM((String)paramMap.get(paramString + ".streamVideoThumb"), "");
      ((w)localObject1).width = a(bk.ZT((String)paramMap.get(paramString + ".streamDisplayWidth")), paramInt1, paramInt2, paramInt3);
      ((w)localObject1).height = a(bk.ZT((String)paramMap.get(paramString + ".streamDisplayHeight")), paramInt1, paramInt2, paramInt3);
      ((w)localObject1).oDL = bk.ZR((String)paramMap.get(paramString + ".streamDisplayType"));
      continue;
      localObject1 = new v();
      ((v)localObject1).oDh = k;
      ((v)localObject1).brC = m;
      ((v)localObject1).lfj = bk.aM((String)paramMap.get(paramString + ".webviewUrl"), "");
      continue;
      double d1 = a(bk.ZT((String)paramMap.get(paramString + ".topLineSize")), paramInt1, paramInt2, paramInt3);
      double d2 = a(bk.ZT((String)paramMap.get(paramString + ".bottomLineSize")), paramInt1, paramInt2, paramInt3);
      if (yo(paramInt4)) {
        i = Color.argb(51, 0, 0, 0);
      }
      int j;
      String str;
      for (;;)
      {
        if (k == 121)
        {
          double d3 = bk.ZT((String)paramMap.get(paramString + ".location.$x"));
          double d4 = bk.ZT((String)paramMap.get(paramString + ".location.$y"));
          j = bk.ZR((String)paramMap.get(paramString + ".location.$scale"));
          localObject1 = (String)paramMap.get(paramString + ".location.$label");
          str = (String)paramMap.get(paramString + ".location.$poiname");
          if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(str)))
          {
            return null;
            i = Color.argb(51, 255, 255, 255);
          }
          else
          {
            localObject1 = new h(d1, d2, new h.a(d3, d4, j, (String)localObject1, str), i);
            break;
          }
        }
      }
      if (k == 122)
      {
        str = paramString + ".phoneNumList.phoneNum";
        localArrayList = new ArrayList();
        j = 0;
        if (j == 0) {}
        for (localObject1 = (String)paramMap.get(str);; localObject1 = (String)paramMap.get(str + j))
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label4747;
          }
          localArrayList.add(localObject1);
          j += 1;
          break;
        }
        label4747:
        if (!localArrayList.isEmpty())
        {
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d(d1, d2, i, localArrayList);
        }
        else
        {
          return null;
          localObject1 = new t();
          ((t)localObject1).oDh = k;
          ((t)localObject1).brC = m;
          ((t)localObject1).label = bk.aM((String)paramMap.get(paramString + ".label"), "");
          ((t)localObject1).value = ((float)bk.ZT((String)paramMap.get(paramString + ".value")));
          ((t)localObject1).oDx = bk.aM((String)paramMap.get(paramString + ".foregroundImage"), "");
          ((t)localObject1).fontSize = a(bk.ZT((String)paramMap.get(paramString + ".fontSize")), paramInt1, paramInt2, paramInt3);
          ((t)localObject1).fNR = bk.aM((String)paramMap.get(paramString + ".backgroundColor"), "");
          continue;
          localObject1 = a(paramMap, paramString, paramInt1, paramInt2, paramInt3);
        }
      }
      else
      {
        localObject1 = null;
      }
    }
  }
  
  private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y a(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    localy = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y();
    try
    {
      paramString = paramString + ".radarChart";
      localy.oDM = ((String)paramMap.get(paramString + ".borderImg"));
      localy.oDS = ((String)paramMap.get(paramString + ".maskImg"));
      localy.oDN = ((String)paramMap.get(paramString + ".coverColor"));
      localy.oDO = Color.parseColor((String)paramMap.get(paramString + ".labelFont.$color"));
      localy.oDP = ((int)a(bk.ZT((String)paramMap.get(paramString + ".labelFont.$size")), paramInt1, paramInt2, paramInt3));
      localy.oDQ = Color.parseColor((String)paramMap.get(paramString + ".scoreFont.$color"));
      localy.oDR = ((int)a(bk.ZT((String)paramMap.get(paramString + ".scoreFont.$size")), paramInt1, paramInt2, paramInt3));
      localy.borderWidth = a(bk.ZT((String)paramMap.get(paramString + ".borderImgWidth")), paramInt1, paramInt2, paramInt3);
      String str = paramString + ".itemList.item";
      paramInt1 = 0;
      if (paramInt1 != 0) {}
      for (paramString = str + paramInt1;; paramString = str)
      {
        y.a locala = new y.a();
        locala.label = ((String)paramMap.get(paramString + ".label"));
        locala.oDT = ((String)paramMap.get(paramString + ".score"));
        locala.value = ((float)bk.ZT((String)paramMap.get(paramString + ".value")));
        if ((TextUtils.isEmpty(locala.label)) && (TextUtils.isEmpty(locala.oDT))) {
          break label561;
        }
        localy.itemList.add(locala);
        paramInt1 += 1;
        break;
      }
      return localy;
    }
    catch (Exception paramMap)
    {
      com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", bk.j(paramMap));
    }
  }
  
  private static void a(s params, Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    params.oDh = bk.ZR((String)paramMap.get(paramString + ".type"));
    params.type = params.oDh;
    params.oDg = bk.aM((String)paramMap.get(paramString + ".id"), "");
    params.oDi = a(bk.ZT((String)paramMap.get(paramString + ".paddingTop")), paramInt1, paramInt2, paramInt3);
    params.oDj = a(bk.ZT((String)paramMap.get(paramString + ".paddingBottom")), paramInt1, paramInt2, paramInt3);
    params.oDk = a(bk.ZT((String)paramMap.get(paramString + ".paddingLeft")), paramInt1, paramInt2, paramInt3);
    params.oDl = a(bk.ZT((String)paramMap.get(paramString + ".paddingRight")), paramInt1, paramInt2, paramInt3);
    params.brC = bk.ZR((String)paramMap.get(paramString + ".subType"));
    params.oDp = bk.aM((String)paramMap.get(paramString + ".cellBackgroundColor"), "");
    String str1 = paramString + ".if";
    boolean bool1;
    label392:
    label446:
    label452:
    double d;
    if (paramMap.containsKey(str1)) {
      if ("1".equals(paramMap.get(str1)))
      {
        bool1 = true;
        params.oDs = bool1;
        str1 = paramString + ".noReport";
        if (!paramMap.containsKey(str1)) {
          break label689;
        }
        if (!"1".equals(paramMap.get(str1))) {
          break label683;
        }
        bool1 = bool2;
        params.oDt = bool1;
        str1 = bk.aM((String)paramMap.get(paramString + ".layoutWidth"), "");
        String str2 = bk.aM((String)paramMap.get(paramString + ".layoutHeight"), "");
        if (TextUtils.isEmpty(str1)) {
          break label714;
        }
        d = bk.ZT(str1);
        if (d >= 0.0D) {
          break label697;
        }
        params.oDm = ((float)d);
        label553:
        if (TextUtils.isEmpty(str2)) {
          break label741;
        }
        d = bk.ZT(str2);
        if (d >= 0.0D) {
          break label724;
        }
        params.oDn = ((float)d);
        label582:
        str1 = (String)paramMap.get(paramString + ".verticalAlignment");
        paramMap = (String)paramMap.get(paramString + ".horizontalAlignment");
        if (!TextUtils.isEmpty(str1)) {
          break label751;
        }
      }
    }
    label683:
    label689:
    label697:
    label714:
    label724:
    label741:
    label751:
    for (params.oDq = -1;; params.oDq = bk.ZR(str1))
    {
      if (!TextUtils.isEmpty(paramMap)) {
        break label763;
      }
      params.oDr = -1;
      return;
      bool1 = false;
      break;
      params.oDs = true;
      break label392;
      bool1 = false;
      break label446;
      params.oDt = false;
      break label452;
      params.oDm = a(d, paramInt1, paramInt2, paramInt3);
      break label553;
      params.oDm = 2.147484E+009F;
      break label553;
      params.oDn = a(d, paramInt1, paramInt2, paramInt3);
      break label582;
      params.oDn = 2.147484E+009F;
      break label582;
    }
    label763:
    params.oDr = bk.ZR(paramMap);
  }
  
  public static boolean a(bxk parambxk, Activity paramActivity)
  {
    String str = parambxk.pjl;
    long l = new BigInteger(parambxk.lsK).longValue();
    LinkedList localLinkedList = parambxk.tNr.sPJ;
    boolean bool;
    Object localObject;
    int i;
    int j;
    if (!TextUtils.isEmpty(str))
    {
      if ((TextUtils.isEmpty(str)) || (!eW(str, "adCanvasInfo"))) {
        break label366;
      }
      parambxk = "";
      bool = Ov(str);
      if (!bool) {
        break label386;
      }
      localObject = com.tencent.mm.model.c.c.IY().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
      if (com.tencent.mm.model.c.c.IY().dt("Sns_Canvas_GameShare_JumpWay", 0) == 0)
      {
        i = 0;
        j = i;
        parambxk = (bxk)localObject;
        if (i == 0)
        {
          j = i;
          parambxk = (bxk)localObject;
          if (bFU())
          {
            j = 1;
            parambxk = (bxk)localObject;
          }
        }
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        localObject = af.bDF().gt(l);
        Intent localIntent = new Intent();
        if (localObject != null)
        {
          localIntent.putExtra("sns_landing_pages_share_sns_id", ((com.tencent.mm.plugin.sns.storage.n)localObject).bGk());
          localIntent.putExtra("sns_landing_pages_rawSnsId", ((com.tencent.mm.plugin.sns.storage.n)localObject).bGe().lsK);
          localIntent.putExtra("sns_landing_pages_ux_info", ((com.tencent.mm.plugin.sns.storage.n)localObject).bGM());
          localIntent.putExtra("sns_landing_pages_aid", ((com.tencent.mm.plugin.sns.storage.n)localObject).bGJ());
          localIntent.putExtra("sns_landing_pages_traceid", ((com.tencent.mm.plugin.sns.storage.n)localObject).bGK());
          localIntent.putExtra("sns_landing_pages_rec_src", ((com.tencent.mm.plugin.sns.storage.n)localObject).bGO());
        }
        if ((localLinkedList != null) && (localLinkedList.size() > 0)) {
          localIntent.putExtra("sns_landing_pages_share_thumb_url", ((awd)localLinkedList.get(0)).trP);
        }
        localIntent.putExtra("sns_landing_pages_expid", parambxk);
        localIntent.putExtra("sns_landig_pages_from_source", 11);
        localIntent.setClass(paramActivity, SnsAdNativeLandingPagesUI.class);
        localIntent.putExtra("sns_landing_pages_xml", str);
        localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        paramActivity.startActivity(localIntent);
        return true;
        i = 1;
        break;
      }
      b(str, paramActivity, bool, 11);
      for (;;)
      {
        return false;
        label366:
        com.tencent.mm.sdk.platformtools.y.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str });
      }
      label386:
      j = 1;
    }
  }
  
  private static List<s> b(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramString + ".layoutItems.componentItem";
    int i = 0;
    if (i == 0)
    {
      paramString = str;
      label42:
      paramString = a(paramMap, paramInt1, paramInt3, paramInt2, paramInt4, paramString);
      if (paramString == null) {
        break label141;
      }
      if (!paramString.oDs) {
        break label107;
      }
      localArrayList.add(paramString);
    }
    for (;;)
    {
      i += 1;
      break;
      paramString = str + i;
      break label42;
      label107:
      com.tencent.mm.sdk.platformtools.y.i("AdLandingPagesParseHelper", "comp " + paramString.toString() + " ifCondition is false");
    }
    label141:
    return localArrayList;
  }
  
  private static boolean b(String paramString, Context paramContext, boolean paramBoolean, int paramInt)
  {
    paramString = (String)bn.s(paramString, "adCanvasInfo").get(".adCanvasInfo.shareWebUrl");
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = paramString;
    if (paramBoolean) {
      str = "exp=" + com.tencent.mm.model.c.c.IY().getExpIdByKey("Sns_Canvas_GameShare_JumpWay") + "_" + paramInt;
    }
    try
    {
      str = k(paramString, new String[] { str });
      paramString = str;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      label89:
      break label89;
    }
    com.tencent.mm.sdk.platformtools.y.i("AdLandingPagesParseHelper", "canvas jump url " + paramString);
    str = paramString;
    paramString = new Intent();
    paramString.putExtra("rawUrl", str);
    paramString.putExtra("showShare", true);
    com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
    return true;
  }
  
  private static boolean bFU()
  {
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100150");
    if (localc.isValid())
    {
      int i = bk.getInt((String)localc.ctr().get("openCanvas"), 0);
      com.tencent.mm.sdk.platformtools.y.i("AdLandingPagesParseHelper", "canOpenGameCanvas abtest=" + i);
      return i == 1;
    }
    return false;
  }
  
  private static m c(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    m localm = new m();
    try
    {
      i = Color.parseColor((String)paramMap.get(paramString + ".bgColorTheme"));
      localm.backgroundColor = ((int)(bk.getDouble((String)paramMap.get(paramString + ".bgColorAlpha"), 0.0D) * 255.0D) << 24 | i & 0xFFFFFF);
      paramString = paramString + ".componentGroupList";
      str = paramString + ".componentItem";
      i = 0;
      while (i == 0)
      {
        paramString = str;
        int j = bk.ZR((String)paramMap.get(paramString + ".type"));
        s locals = null;
        if (ym(j)) {
          locals = a(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
        }
        if (locals == null) {
          break label302;
        }
        if (locals.oDs) {
          localm.oCS.add(locals);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        String str;
        com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", "%s", new Object[] { bk.j(localException) });
        localm.backgroundColor = Color.argb(51, 0, 0, 0);
        continue;
        paramString = str + i;
      }
    }
    label302:
    return localm;
  }
  
  public static LinkedList<g> c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Object localObject2 = new String(paramString1);
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString3);
        localObject1 = localObject2;
        com.tencent.mm.sdk.platformtools.y.i("AdLandingPagesParseHelper", "the jsonObject is " + localJSONObject.toString());
        localObject1 = localObject2;
        Iterator localIterator = localJSONObject.keys();
        paramString3 = (String)localObject2;
        localObject1 = paramString3;
        localObject2 = paramString3;
        if (localIterator.hasNext())
        {
          localObject1 = paramString3;
          localObject2 = localIterator.next();
          if (localObject2 != null)
          {
            localObject1 = paramString3;
            if ((localObject2 instanceof String))
            {
              localObject1 = paramString3;
              localObject2 = (String)localObject2;
              localObject1 = paramString3;
              String str = localJSONObject.getString((String)localObject2);
              localObject1 = paramString3;
              if (!bk.bl(str))
              {
                localObject1 = paramString3;
                paramString3 = paramString3.replace("{{" + (String)localObject2 + "}}", "<![CDATA[" + str + "]]>");
              }
            }
          }
        }
        else
        {
          return r((String)localObject2, paramString2, paramString4, paramString5);
        }
      }
      catch (Exception paramString3)
      {
        com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", "the json is parsed error : " + paramString1);
        localObject2 = localObject1;
      }
    }
  }
  
  private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n d(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n localn = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n();
    a(localn, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    localn.oCU = bk.ZR((String)paramMap.get(paramString + ".pageCtrType"));
    boolean bool;
    String str1;
    int i;
    if (bk.ZR((String)paramMap.get(paramString + ".isFullScreen")) == 1)
    {
      bool = true;
      localn.hqp = bool;
      str1 = paramString + ".componentGroupList.componentGroup";
      i = 0;
    }
    for (;;)
    {
      label136:
      m localm;
      String str2;
      int j;
      if (i == 0)
      {
        paramString = str1;
        localm = new m();
        str2 = paramString + ".componentItem";
        j = 0;
        label170:
        if (j != 0) {
          break label298;
        }
      }
      label298:
      for (paramString = str2;; paramString = str2 + j)
      {
        int k = bk.ZR((String)paramMap.get(paramString + ".type"));
        s locals = null;
        if (ym(k)) {
          locals = a(paramMap, paramString, paramInt1, paramInt2, paramInt3, paramInt4);
        }
        if (locals == null) {
          break label322;
        }
        if (locals.oDs) {
          localm.oCS.add(locals);
        }
        j += 1;
        break label170;
        bool = false;
        break;
        paramString = str1 + i;
        break label136;
      }
      label322:
      if (localm.oCS.size() == 0) {
        break label353;
      }
      localn.oCS.add(localm);
      i += 1;
    }
    label353:
    return localn;
  }
  
  private static s e(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    r localr = new r();
    localr.oDf = bk.ZR((String)paramMap.get(paramString + ".subType"));
    a(localr, paramMap, paramString, paramInt1, paramInt2, paramInt3);
    String str2 = paramString + ".layoutItems.componentItem";
    int i = 0;
    String str1;
    label90:
    int j;
    if (i == 0)
    {
      str1 = str2;
      j = bk.ZR((String)paramMap.get(str1 + ".type"));
      paramString = null;
      if (!ym(j)) {
        break label202;
      }
      paramString = a(paramMap, str1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    for (;;)
    {
      if (paramString == null) {
        break label226;
      }
      if (paramString.oDs) {
        localr.oDe.add(paramString);
      }
      i += 1;
      break;
      str1 = str2 + i;
      break label90;
      label202:
      if (yn(j)) {
        paramString = e(paramMap, str1, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    label226:
    return localr;
  }
  
  /* Error */
  public static boolean eW(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: aload_0
    //   10: invokestatic 512	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +10 -> 23
    //   16: aload_1
    //   17: invokestatic 512	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +5 -> 25
    //   23: iconst_0
    //   24: ireturn
    //   25: getstatic 20	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i:oKC	Ljava/util/Set;
    //   28: ifnonnull +546 -> 574
    //   31: getstatic 20	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i:oKC	Ljava/util/Set;
    //   34: ifnonnull +540 -> 574
    //   37: new 1199	java/util/HashSet
    //   40: dup
    //   41: invokespecial 1200	java/util/HashSet:<init>	()V
    //   44: putstatic 20	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i:oKC	Ljava/util/Set;
    //   47: invokestatic 66	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   50: invokevirtual 1204	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   53: ldc_w 1206
    //   56: invokevirtual 1212	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   59: astore 11
    //   61: aload 11
    //   63: astore 9
    //   65: aload 11
    //   67: astore 10
    //   69: aload 11
    //   71: astore 8
    //   73: invokestatic 1218	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   76: invokevirtual 1222	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   79: astore 12
    //   81: aload 11
    //   83: astore 9
    //   85: aload 11
    //   87: astore 10
    //   89: aload 11
    //   91: astore 8
    //   93: aload 12
    //   95: aload 11
    //   97: ldc_w 1224
    //   100: invokeinterface 1230 3 0
    //   105: aload 11
    //   107: astore 9
    //   109: aload 11
    //   111: astore 10
    //   113: aload 11
    //   115: astore 8
    //   117: aload 12
    //   119: invokeinterface 1233 1 0
    //   124: istore_3
    //   125: iconst_m1
    //   126: istore 4
    //   128: iconst_m1
    //   129: istore_2
    //   130: iload_3
    //   131: iconst_1
    //   132: if_icmpeq +505 -> 637
    //   135: iload_2
    //   136: istore 5
    //   138: iload_3
    //   139: iconst_2
    //   140: if_icmpne +1283 -> 1423
    //   143: aload 11
    //   145: astore 9
    //   147: aload 11
    //   149: astore 10
    //   151: aload 11
    //   153: astore 8
    //   155: aload 12
    //   157: invokeinterface 1236 1 0
    //   162: astore 13
    //   164: aload 11
    //   166: astore 9
    //   168: aload 11
    //   170: astore 10
    //   172: aload 11
    //   174: astore 8
    //   176: ldc_w 1238
    //   179: aload 13
    //   181: invokevirtual 844	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   184: ifeq +108 -> 292
    //   187: iconst_0
    //   188: istore_2
    //   189: iconst_0
    //   190: istore_3
    //   191: iload_2
    //   192: istore 5
    //   194: iload_3
    //   195: iconst_m1
    //   196: if_icmpeq +1227 -> 1423
    //   199: aload 11
    //   201: astore 9
    //   203: aload 11
    //   205: astore 10
    //   207: aload 11
    //   209: astore 8
    //   211: aload 12
    //   213: aconst_null
    //   214: ldc_w 1240
    //   217: invokeinterface 1243 3 0
    //   222: iconst_0
    //   223: invokestatic 1090	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   226: iconst_1
    //   227: if_icmpne +1151 -> 1378
    //   230: aload 11
    //   232: astore 9
    //   234: aload 11
    //   236: astore 10
    //   238: aload 11
    //   240: astore 8
    //   242: aload 12
    //   244: aconst_null
    //   245: ldc_w 1245
    //   248: invokeinterface 1243 3 0
    //   253: iconst_m1
    //   254: invokestatic 1090	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   257: istore 7
    //   259: goto +1122 -> 1381
    //   262: aload 11
    //   264: astore 9
    //   266: aload 11
    //   268: astore 10
    //   270: aload 11
    //   272: astore 8
    //   274: aload 12
    //   276: invokeinterface 1247 1 0
    //   281: istore_3
    //   282: iload 6
    //   284: istore 4
    //   286: iload 5
    //   288: istore_2
    //   289: goto -159 -> 130
    //   292: aload 11
    //   294: astore 9
    //   296: aload 11
    //   298: astore 10
    //   300: aload 11
    //   302: astore 8
    //   304: ldc_w 1249
    //   307: aload 13
    //   309: invokevirtual 844	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   312: ifeq +10 -> 322
    //   315: iconst_1
    //   316: istore_2
    //   317: iconst_1
    //   318: istore_3
    //   319: goto -128 -> 191
    //   322: aload 11
    //   324: astore 9
    //   326: aload 11
    //   328: astore 10
    //   330: aload 11
    //   332: astore 8
    //   334: ldc_w 1251
    //   337: aload 13
    //   339: invokevirtual 844	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   342: ifeq +10 -> 352
    //   345: iconst_2
    //   346: istore_2
    //   347: iconst_2
    //   348: istore_3
    //   349: goto -158 -> 191
    //   352: aload 11
    //   354: astore 9
    //   356: aload 11
    //   358: astore 10
    //   360: aload 11
    //   362: astore 8
    //   364: ldc_w 1253
    //   367: aload 13
    //   369: invokevirtual 844	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   372: ifeq +1058 -> 1430
    //   375: iconst_3
    //   376: istore_3
    //   377: goto -186 -> 191
    //   380: iload_2
    //   381: istore 5
    //   383: iload_2
    //   384: iconst_m1
    //   385: if_icmpeq +1038 -> 1423
    //   388: iload_2
    //   389: istore 5
    //   391: iload 4
    //   393: iconst_m1
    //   394: if_icmpeq +1029 -> 1423
    //   397: iload_2
    //   398: istore 5
    //   400: iload 7
    //   402: iconst_m1
    //   403: if_icmpeq +1020 -> 1423
    //   406: aload 11
    //   408: astore 9
    //   410: aload 11
    //   412: astore 10
    //   414: aload 11
    //   416: astore 8
    //   418: new 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a
    //   421: dup
    //   422: iconst_0
    //   423: invokespecial 1256	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:<init>	(B)V
    //   426: astore 13
    //   428: aload 11
    //   430: astore 9
    //   432: aload 11
    //   434: astore 10
    //   436: aload 11
    //   438: astore 8
    //   440: aload 13
    //   442: iload_2
    //   443: putfield 1259	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKD	I
    //   446: aload 11
    //   448: astore 9
    //   450: aload 11
    //   452: astore 10
    //   454: aload 11
    //   456: astore 8
    //   458: aload 13
    //   460: iload 4
    //   462: putfield 1262	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKE	I
    //   465: aload 11
    //   467: astore 9
    //   469: aload 11
    //   471: astore 10
    //   473: aload 11
    //   475: astore 8
    //   477: aload 13
    //   479: iload 7
    //   481: putfield 1265	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKF	I
    //   484: aload 11
    //   486: astore 9
    //   488: aload 11
    //   490: astore 10
    //   492: aload 11
    //   494: astore 8
    //   496: getstatic 20	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i:oKC	Ljava/util/Set;
    //   499: aload 13
    //   501: invokeinterface 1268 2 0
    //   506: pop
    //   507: aload 11
    //   509: astore 9
    //   511: aload 11
    //   513: astore 10
    //   515: aload 11
    //   517: astore 8
    //   519: ldc 129
    //   521: new 97	java/lang/StringBuilder
    //   524: dup
    //   525: ldc_w 1270
    //   528: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   531: aload 13
    //   533: invokevirtual 1273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokestatic 1036	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   542: iload_2
    //   543: istore 5
    //   545: goto +878 -> 1423
    //   548: astore 10
    //   550: aload 9
    //   552: astore 8
    //   554: ldc 129
    //   556: aload 10
    //   558: invokestatic 805	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   561: invokestatic 144	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: aload 9
    //   566: ifnull +8 -> 574
    //   569: aload 9
    //   571: invokevirtual 1278	java/io/InputStream:close	()V
    //   574: getstatic 20	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i:oKC	Ljava/util/Set;
    //   577: ifnull -554 -> 23
    //   580: getstatic 20	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i:oKC	Ljava/util/Set;
    //   583: invokeinterface 1279 1 0
    //   588: ifne -565 -> 23
    //   591: aload_0
    //   592: aload_1
    //   593: invokestatic 31	com/tencent/mm/sdk/platformtools/bn:s	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   596: astore 8
    //   598: aload 8
    //   600: ifnull +13 -> 613
    //   603: aload 8
    //   605: invokeinterface 1280 1 0
    //   610: ifeq +92 -> 702
    //   613: ldc 129
    //   615: new 97	java/lang/StringBuilder
    //   618: dup
    //   619: ldc_w 1282
    //   622: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   625: aload_0
    //   626: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 1285	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: iconst_0
    //   636: ireturn
    //   637: aload 11
    //   639: ifnull -65 -> 574
    //   642: aload 11
    //   644: invokevirtual 1278	java/io/InputStream:close	()V
    //   647: goto -73 -> 574
    //   650: astore 8
    //   652: goto -78 -> 574
    //   655: astore 9
    //   657: aload 10
    //   659: astore 8
    //   661: ldc 129
    //   663: aload 9
    //   665: invokestatic 805	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   668: invokestatic 144	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   671: aload 10
    //   673: ifnull -99 -> 574
    //   676: aload 10
    //   678: invokevirtual 1278	java/io/InputStream:close	()V
    //   681: goto -107 -> 574
    //   684: astore 8
    //   686: goto -112 -> 574
    //   689: astore_0
    //   690: aload 8
    //   692: ifnull +8 -> 700
    //   695: aload 8
    //   697: invokevirtual 1278	java/io/InputStream:close	()V
    //   700: aload_0
    //   701: athrow
    //   702: new 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a
    //   705: dup
    //   706: iconst_0
    //   707: invokespecial 1256	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:<init>	(B)V
    //   710: astore 9
    //   712: aload 9
    //   714: iconst_0
    //   715: putfield 1259	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKD	I
    //   718: aload 9
    //   720: aload 8
    //   722: ldc_w 1287
    //   725: invokeinterface 39 2 0
    //   730: checkcast 41	java/lang/String
    //   733: invokestatic 53	com/tencent/mm/sdk/platformtools/bk:ZR	(Ljava/lang/String;)I
    //   736: putfield 1262	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKE	I
    //   739: aload 9
    //   741: aload 8
    //   743: ldc_w 1289
    //   746: invokeinterface 39 2 0
    //   751: checkcast 41	java/lang/String
    //   754: invokestatic 53	com/tencent/mm/sdk/platformtools/bk:ZR	(Ljava/lang/String;)I
    //   757: putfield 1265	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKF	I
    //   760: getstatic 20	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i:oKC	Ljava/util/Set;
    //   763: aload 9
    //   765: invokeinterface 1292 2 0
    //   770: ifne +28 -> 798
    //   773: ldc 129
    //   775: new 97	java/lang/StringBuilder
    //   778: dup
    //   779: ldc_w 1294
    //   782: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   785: aload 9
    //   787: invokevirtual 1273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   790: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: invokestatic 1036	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   796: iconst_0
    //   797: ireturn
    //   798: iconst_0
    //   799: istore_2
    //   800: aload 9
    //   802: iconst_1
    //   803: putfield 1259	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKD	I
    //   806: iload_2
    //   807: ifne +149 -> 956
    //   810: ldc_w 1296
    //   813: astore_0
    //   814: aload 8
    //   816: new 97	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   823: aload_0
    //   824: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: ldc_w 1298
    //   830: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   836: invokeinterface 434 2 0
    //   841: ifeq +351 -> 1192
    //   844: aload 9
    //   846: aload 8
    //   848: new 97	java/lang/StringBuilder
    //   851: dup
    //   852: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   855: aload_0
    //   856: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: ldc 106
    //   861: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: invokeinterface 39 2 0
    //   872: checkcast 41	java/lang/String
    //   875: invokestatic 53	com/tencent/mm/sdk/platformtools/bk:ZR	(Ljava/lang/String;)I
    //   878: putfield 1262	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKE	I
    //   881: aload 9
    //   883: aload 8
    //   885: new 97	java/lang/StringBuilder
    //   888: dup
    //   889: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   892: aload_0
    //   893: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: ldc 148
    //   898: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   904: invokeinterface 39 2 0
    //   909: checkcast 41	java/lang/String
    //   912: invokestatic 53	com/tencent/mm/sdk/platformtools/bk:ZR	(Ljava/lang/String;)I
    //   915: putfield 1265	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKF	I
    //   918: getstatic 20	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i:oKC	Ljava/util/Set;
    //   921: aload 9
    //   923: invokeinterface 1292 2 0
    //   928: ifne +52 -> 980
    //   931: ldc 129
    //   933: new 97	java/lang/StringBuilder
    //   936: dup
    //   937: ldc_w 1300
    //   940: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   943: aload 9
    //   945: invokevirtual 1273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   948: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: invokestatic 1036	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   954: iconst_0
    //   955: ireturn
    //   956: new 97	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   963: ldc_w 1296
    //   966: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: iload_2
    //   970: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   973: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: astore_0
    //   977: goto -163 -> 814
    //   980: new 97	java/lang/StringBuilder
    //   983: dup
    //   984: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   987: aload_0
    //   988: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: ldc_w 1302
    //   994: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1000: astore_1
    //   1001: aload 9
    //   1003: iconst_2
    //   1004: putfield 1259	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKD	I
    //   1007: iconst_0
    //   1008: istore_3
    //   1009: iload_3
    //   1010: ifne +146 -> 1156
    //   1013: aload_1
    //   1014: astore_0
    //   1015: aload 8
    //   1017: new 97	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1024: aload_0
    //   1025: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: ldc 106
    //   1030: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1036: invokeinterface 434 2 0
    //   1041: ifeq +144 -> 1185
    //   1044: aload 9
    //   1046: aload 8
    //   1048: new 97	java/lang/StringBuilder
    //   1051: dup
    //   1052: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1055: aload_0
    //   1056: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: ldc 106
    //   1061: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1067: invokeinterface 39 2 0
    //   1072: checkcast 41	java/lang/String
    //   1075: invokestatic 53	com/tencent/mm/sdk/platformtools/bk:ZR	(Ljava/lang/String;)I
    //   1078: putfield 1262	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKE	I
    //   1081: aload 9
    //   1083: aload 8
    //   1085: new 97	java/lang/StringBuilder
    //   1088: dup
    //   1089: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1092: aload_0
    //   1093: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: ldc 148
    //   1098: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1104: invokeinterface 39 2 0
    //   1109: checkcast 41	java/lang/String
    //   1112: invokestatic 53	com/tencent/mm/sdk/platformtools/bk:ZR	(Ljava/lang/String;)I
    //   1115: putfield 1265	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKF	I
    //   1118: getstatic 20	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i:oKC	Ljava/util/Set;
    //   1121: aload 9
    //   1123: invokeinterface 1292 2 0
    //   1128: ifne +50 -> 1178
    //   1131: ldc 129
    //   1133: new 97	java/lang/StringBuilder
    //   1136: dup
    //   1137: ldc_w 1304
    //   1140: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1143: aload 9
    //   1145: invokevirtual 1273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1148: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1151: invokestatic 1036	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1154: iconst_0
    //   1155: ireturn
    //   1156: new 97	java/lang/StringBuilder
    //   1159: dup
    //   1160: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1163: aload_1
    //   1164: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: iload_3
    //   1168: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1171: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1174: astore_0
    //   1175: goto -160 -> 1015
    //   1178: iload_3
    //   1179: iconst_1
    //   1180: iadd
    //   1181: istore_3
    //   1182: goto -173 -> 1009
    //   1185: iload_2
    //   1186: iconst_1
    //   1187: iadd
    //   1188: istore_2
    //   1189: goto -389 -> 800
    //   1192: aload 9
    //   1194: iconst_2
    //   1195: putfield 1259	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKD	I
    //   1198: aload 8
    //   1200: invokeinterface 1308 1 0
    //   1205: invokeinterface 1311 1 0
    //   1210: astore_0
    //   1211: aload_0
    //   1212: invokeinterface 1137 1 0
    //   1217: ifeq +150 -> 1367
    //   1220: aload_0
    //   1221: invokeinterface 1141 1 0
    //   1226: checkcast 1313	java/util/Map$Entry
    //   1229: astore 10
    //   1231: aload 10
    //   1233: invokeinterface 1316 1 0
    //   1238: ifnull -27 -> 1211
    //   1241: aload 10
    //   1243: invokeinterface 1316 1 0
    //   1248: checkcast 41	java/lang/String
    //   1251: ldc_w 1318
    //   1254: invokevirtual 1321	java/lang/String:matches	(Ljava/lang/String;)Z
    //   1257: ifeq -46 -> 1211
    //   1260: aload 10
    //   1262: invokeinterface 1316 1 0
    //   1267: checkcast 41	java/lang/String
    //   1270: astore_1
    //   1271: aload 10
    //   1273: invokeinterface 1316 1 0
    //   1278: checkcast 41	java/lang/String
    //   1281: ldc 106
    //   1283: ldc 148
    //   1285: invokevirtual 1159	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1288: astore 10
    //   1290: aload 9
    //   1292: aload 8
    //   1294: aload_1
    //   1295: invokeinterface 39 2 0
    //   1300: checkcast 41	java/lang/String
    //   1303: invokestatic 53	com/tencent/mm/sdk/platformtools/bk:ZR	(Ljava/lang/String;)I
    //   1306: putfield 1262	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKE	I
    //   1309: aload 9
    //   1311: aload 8
    //   1313: aload 10
    //   1315: invokeinterface 39 2 0
    //   1320: checkcast 41	java/lang/String
    //   1323: invokestatic 53	com/tencent/mm/sdk/platformtools/bk:ZR	(Ljava/lang/String;)I
    //   1326: putfield 1265	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i$a:oKF	I
    //   1329: getstatic 20	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/i:oKC	Ljava/util/Set;
    //   1332: aload 9
    //   1334: invokeinterface 1292 2 0
    //   1339: ifne -128 -> 1211
    //   1342: ldc 129
    //   1344: new 97	java/lang/StringBuilder
    //   1347: dup
    //   1348: ldc_w 1304
    //   1351: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1354: aload 9
    //   1356: invokevirtual 1273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1359: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1362: invokestatic 1036	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1365: iconst_0
    //   1366: ireturn
    //   1367: iconst_1
    //   1368: ireturn
    //   1369: astore 8
    //   1371: goto -797 -> 574
    //   1374: astore_1
    //   1375: goto -675 -> 700
    //   1378: iconst_m1
    //   1379: istore 7
    //   1381: iload 7
    //   1383: istore 6
    //   1385: iload_2
    //   1386: istore 5
    //   1388: iload_3
    //   1389: tableswitch	default:+31 -> 1420, 0:+-1127->262, 1:+-1127->262, 2:+-1127->262, 3:+-1009->380
    //   1421: istore 5
    //   1423: iload 4
    //   1425: istore 6
    //   1427: goto -1165 -> 262
    //   1430: iconst_m1
    //   1431: istore_3
    //   1432: goto -1241 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1435	0	paramString1	String
    //   0	1435	1	paramString2	String
    //   129	1292	2	i	int
    //   124	1308	3	j	int
    //   126	1298	4	k	int
    //   136	1286	5	m	int
    //   282	1144	6	n	int
    //   257	1125	7	i1	int
    //   4	600	8	localObject1	Object
    //   650	1	8	localIOException1	java.io.IOException
    //   659	1	8	localIOException2	java.io.IOException
    //   684	628	8	localIOException3	java.io.IOException
    //   1369	1	8	localIOException4	java.io.IOException
    //   7	563	9	localObject2	Object
    //   655	9	9	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   710	645	9	locala	i.a
    //   1	513	10	localObject3	Object
    //   548	129	10	localIOException5	java.io.IOException
    //   1229	85	10	localObject4	Object
    //   59	584	11	localInputStream	java.io.InputStream
    //   79	196	12	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   162	370	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   47	61	548	java/io/IOException
    //   73	81	548	java/io/IOException
    //   93	105	548	java/io/IOException
    //   117	125	548	java/io/IOException
    //   155	164	548	java/io/IOException
    //   176	187	548	java/io/IOException
    //   211	230	548	java/io/IOException
    //   242	259	548	java/io/IOException
    //   274	282	548	java/io/IOException
    //   304	315	548	java/io/IOException
    //   334	345	548	java/io/IOException
    //   364	375	548	java/io/IOException
    //   418	428	548	java/io/IOException
    //   440	446	548	java/io/IOException
    //   458	465	548	java/io/IOException
    //   477	484	548	java/io/IOException
    //   496	507	548	java/io/IOException
    //   519	542	548	java/io/IOException
    //   642	647	650	java/io/IOException
    //   47	61	655	org/xmlpull/v1/XmlPullParserException
    //   73	81	655	org/xmlpull/v1/XmlPullParserException
    //   93	105	655	org/xmlpull/v1/XmlPullParserException
    //   117	125	655	org/xmlpull/v1/XmlPullParserException
    //   155	164	655	org/xmlpull/v1/XmlPullParserException
    //   176	187	655	org/xmlpull/v1/XmlPullParserException
    //   211	230	655	org/xmlpull/v1/XmlPullParserException
    //   242	259	655	org/xmlpull/v1/XmlPullParserException
    //   274	282	655	org/xmlpull/v1/XmlPullParserException
    //   304	315	655	org/xmlpull/v1/XmlPullParserException
    //   334	345	655	org/xmlpull/v1/XmlPullParserException
    //   364	375	655	org/xmlpull/v1/XmlPullParserException
    //   418	428	655	org/xmlpull/v1/XmlPullParserException
    //   440	446	655	org/xmlpull/v1/XmlPullParserException
    //   458	465	655	org/xmlpull/v1/XmlPullParserException
    //   477	484	655	org/xmlpull/v1/XmlPullParserException
    //   496	507	655	org/xmlpull/v1/XmlPullParserException
    //   519	542	655	org/xmlpull/v1/XmlPullParserException
    //   676	681	684	java/io/IOException
    //   47	61	689	finally
    //   73	81	689	finally
    //   93	105	689	finally
    //   117	125	689	finally
    //   155	164	689	finally
    //   176	187	689	finally
    //   211	230	689	finally
    //   242	259	689	finally
    //   274	282	689	finally
    //   304	315	689	finally
    //   334	345	689	finally
    //   364	375	689	finally
    //   418	428	689	finally
    //   440	446	689	finally
    //   458	465	689	finally
    //   477	484	689	finally
    //   496	507	689	finally
    //   519	542	689	finally
    //   554	564	689	finally
    //   661	671	689	finally
    //   569	574	1369	java/io/IOException
    //   695	700	1374	java/io/IOException
  }
  
  public static String k(String paramString, String... paramVarArgs)
  {
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
      if (paramVarArgs != null) {
        break label122;
      }
    }
    label122:
    for (paramString = paramString.toString();; paramString = paramVarArgs + "&" + paramString.toString())
    {
      paramString = new URI(localURI.getScheme(), localURI.getAuthority(), localURI.getPath(), paramString, localURI.getFragment()).toString();
      return paramString;
    }
  }
  
  public static String l(String paramString, String... paramVarArgs)
  {
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
        return paramString;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", "append url params failed, %s", new Object[] { paramString.toString() });
        return str1;
      }
    }
    return str1 + paramString + paramVarArgs;
  }
  
  public static String r(String paramString, Map<String, String> paramMap)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", "the adLandingPagesXml is empty");
      return null;
    }
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
      return null;
    }
    LinkedList localLinkedList = r(paramString, "adxml", "adId", "");
    Iterator localIterator1 = paramMap.keySet().iterator();
    String str1 = paramString;
    String str3;
    String str2;
    Iterator localIterator2;
    while (localIterator1.hasNext())
    {
      str3 = (String)localIterator1.next();
      if (!bk.bl(str3))
      {
        str2 = (String)paramMap.get(str3);
        if (!bk.bl(str2))
        {
          localIterator2 = localLinkedList.iterator();
          paramString = null;
        }
      }
    }
    label317:
    label319:
    for (;;)
    {
      if (localIterator2.hasNext())
      {
        Iterator localIterator3 = ((g)localIterator2.next()).oKx.iterator();
        while (localIterator3.hasNext())
        {
          s locals = (s)localIterator3.next();
          if (((locals instanceof f)) && (!bk.bl(((f)locals).imf)) && (((f)locals).imf.equals(str3)))
          {
            paramString = ((f)locals).imW;
            label228:
            if (paramString == null) {
              break label319;
            }
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (bk.bl(paramString)) {
            break label317;
          }
          com.tencent.mm.sdk.platformtools.y.i("AdLandingPagesParseHelper", "old card ext is " + paramString + " and new card ext is " + str2);
          str1 = str1.replace(paramString, str2);
          try
          {
            paramString = str1.replace(bk.ZP(paramString), bk.ZP(str2));
            str1 = paramString;
          }
          catch (Exception paramString)
          {
            com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", "the xml is error");
          }
        }
        break;
        return str1;
        break label228;
      }
      break;
    }
  }
  
  public static LinkedList<g> r(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    LinkedList localLinkedList = new LinkedList();
    if (TextUtils.isEmpty(paramString1)) {
      return localLinkedList;
    }
    if (TextUtils.isEmpty(paramString1)) {}
    Map localMap;
    for (;;)
    {
      localMap = bn.s(paramString1, paramString2);
      if (localMap != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.y.w("AdLandingPagesParseHelper", " parse landingpages xml is error ," + paramString1);
      return localLinkedList;
      paramString1 = paramString1.replaceAll("\\{\\{.*?\\}\\}", "");
    }
    int i1 = bk.ZR((String)localMap.get("." + paramString2 + ".adCanvasInfo.sizeType"));
    int i = bk.ZR((String)localMap.get("." + paramString2 + ".adCanvasInfo.basicRootFontSize"));
    int k = bk.ZR((String)localMap.get("." + paramString2 + ".adCanvasInfo.basicWidth"));
    if ((i == 0) && (i1 == 1)) {
      i = oKB;
    }
    for (;;)
    {
      int j = k;
      if (k == 0)
      {
        j = k;
        if (i1 == 1) {
          j = oKA;
        }
      }
      if ((!bk.bl(paramString2)) && (!".adCanvasInfo.PageList.Page".equals("adCanvasInfo"))) {}
      for (paramString1 = "." + paramString2 + ".adCanvasInfo.PageList.Page";; paramString1 = ".adCanvasInfo.PageList.Page")
      {
        k = 0;
        for (;;)
        {
          g localg;
          boolean bool;
          label410:
          Object localObject;
          label479:
          label486:
          String str;
          int m;
          if (k == 0)
          {
            paramString2 = paramString1;
            localg = new g();
            localg.oKv = bk.aM((String)localMap.get(paramString2 + ".backgroundCover"), "");
            localg.fNR = bk.aM((String)localMap.get(paramString2 + ".backgroundColor"), "");
            if (bk.ZR((String)localMap.get(paramString2 + ".backgroundCover.$isAddBlur")) <= 0) {
              break label662;
            }
            bool = true;
            localg.oKw = bool;
            localg.id = k;
            localObject = paramString2 + ".if";
            if (!localMap.containsKey(localObject)) {
              break label674;
            }
            if (!"1".equals(localMap.get(localObject))) {
              break label668;
            }
            bool = true;
            localg.oKy = bool;
            if (!localg.oKy) {
              break label797;
            }
            str = paramString2 + ".componentItemList.componentItem";
            m = 0;
            label519:
            if (m != 0) {
              break label683;
            }
            paramString2 = str;
          }
          for (;;)
          {
            try
            {
              if (TextUtils.isEmpty(localg.fNR)) {
                continue;
              }
              n = Color.parseColor(localg.fNR);
              localObject = a(localMap, i1, i, j, n, paramString2);
            }
            catch (Exception localException)
            {
              int n;
              label662:
              label668:
              label674:
              label683:
              com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", bk.j(localException));
              s locals = a(localMap, i1, i, j, 0, paramString2);
              continue;
              com.tencent.mm.sdk.platformtools.y.i("AdLandingPagesParseHelper", "comp " + locals.toString() + " ifCondition is false");
              continue;
            }
            if (localObject == null) {
              break label778;
            }
            if (!((s)localObject).oDs) {
              continue;
            }
            if (((s)localObject).type == 21)
            {
              ((l)localObject).oAk = paramString4;
              ((l)localObject).oAl = paramString3;
            }
            a((s)localObject, localMap, paramString2, i1, j, i);
            localg.oKx.add(localObject);
            m += 1;
            break label519;
            paramString2 = paramString1 + k;
            break;
            bool = false;
            break label410;
            bool = false;
            break label479;
            localg.oKy = true;
            break label486;
            paramString2 = str + m;
            continue;
            n = 0;
          }
          label778:
          if (localg.oKx.size() == 0) {
            break;
          }
          localLinkedList.add(localg);
          label797:
          k += 1;
        }
        if (localLinkedList.size() > 0) {
          ((g)localLinkedList.get(0)).oKz = true;
        }
        return localLinkedList;
      }
    }
  }
  
  private static boolean ym(int paramInt)
  {
    return (paramInt != 101) && (paramInt != 103);
  }
  
  private static boolean yn(int paramInt)
  {
    return paramInt == 103;
  }
  
  private static boolean yo(int paramInt)
  {
    paramInt |= 0xFF000000;
    return paramInt + 16777216 > -1 - paramInt;
  }
  
  public static String z(com.tencent.mm.plugin.sns.storage.n paramn)
  {
    if (paramn == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", "the snsinfo is null");
      return null;
    }
    if (!paramn.yr(32))
    {
      com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", "the snsinfo is not a ad");
      return null;
    }
    com.tencent.mm.plugin.sns.storage.e locale = paramn.bGN();
    if (locale == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", "the adSnsInfo is null");
      return null;
    }
    com.tencent.mm.plugin.sns.storage.b localb = paramn.bFZ();
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", "the adxml is null");
      return null;
    }
    paramn = paramn.bGb();
    if (paramn == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", "the adInfo is null");
      return null;
    }
    if (!localb.bEE())
    {
      com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", "the snsinfo is not a landingpage");
      return null;
    }
    if ((paramn.oAn == null) || (paramn.oAn.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
      return null;
    }
    return r(locale.field_adxml, paramn.oAn);
  }
  
  public static boolean z(Intent paramIntent, Context paramContext)
  {
    boolean bool1 = false;
    String str2 = paramIntent.getStringExtra("sns_landing_pages_xml");
    String str1;
    boolean bool2;
    if (!TextUtils.isEmpty(str2)) {
      if ((!TextUtils.isEmpty(str2)) && (eW(str2, "adCanvasInfo")))
      {
        str1 = "";
        bool2 = Ov(str2);
        if (!bool2) {
          break label196;
        }
        str1 = com.tencent.mm.model.c.c.IY().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
        if (!TextUtils.isEmpty(str1))
        {
          int i = com.tencent.mm.model.c.c.IY().dt("Sns_Canvas_GameShare_JumpWay", 0);
          com.tencent.mm.sdk.platformtools.y.i("AdLandingPagesParseHelper", "abtestvalue = " + i);
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
        return true;
        bool1 = true;
        continue;
        bool1 = bFU();
      }
      else
      {
        return b(str2, paramContext, bool2, paramIntent.getIntExtra("sns_landig_pages_from_source", -1));
        com.tencent.mm.sdk.platformtools.y.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[] { str2 });
        return false;
        label196:
        bool1 = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i
 * JD-Core Version:    0.7.0.1
 */