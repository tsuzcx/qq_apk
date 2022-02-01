package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Map;

public final class d
{
  public static int PMn = 1;
  public static int PMo = 2;
  @p(hkF=7)
  public e PMi;
  public d.d PMj;
  @p(hkF=7)
  public a PMk;
  @p(hkF=7)
  public b PMl;
  @p(hkF=7)
  public c PMm;
  public int oQU;
  
  public static boolean aWh(String paramString)
  {
    AppMethodBeat.i(309862);
    if ((paramString != null) && (paramString.contains("<eggAnimationInfo>")))
    {
      AppMethodBeat.o(309862);
      return true;
    }
    AppMethodBeat.o(309862);
    return false;
  }
  
  public static d b(Map<String, String> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(309854);
    if ((paramMap == null) || (paramMap.size() == 0) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(309854);
      return null;
    }
    if (paramInt == PMo)
    {
      String str = paramString + ".adCanvasInfo.eggAnimationInfo";
      if (paramMap.containsKey(str))
      {
        paramMap = z(paramMap, str);
        AppMethodBeat.o(309854);
        return paramMap;
      }
      paramString = paramString + ".adFullCardGestureCanvasInfo.eggAnimationInfo";
      if (paramMap.containsKey(paramString))
      {
        paramMap = z(paramMap, paramString);
        AppMethodBeat.o(309854);
        return paramMap;
      }
    }
    else
    {
      paramString = paramString + ".adCanvasInfo.eggAnimationInfo";
      if (paramMap.containsKey(paramString))
      {
        paramMap = z(paramMap, paramString);
        AppMethodBeat.o(309854);
        return paramMap;
      }
    }
    AppMethodBeat.o(309854);
    return null;
  }
  
  private static d z(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309869);
    d locald = new d();
    locald.oQU = Util.safeParseInt((String)paramMap.get(paramString + ".animationType"));
    switch (locald.oQU)
    {
    default: 
      AppMethodBeat.o(309869);
      return null;
    case 1: 
      locald.PMi = e.E(paramMap, paramString + ".hugeDiskInfo");
      AppMethodBeat.o(309869);
      return locald;
    case 3: 
      locald.PMk = a.A(paramMap, paramString + ".dropCardAnimInfo");
      AppMethodBeat.o(309869);
      return locald;
    case 4: 
      locald.PMl = b.B(paramMap, paramString + ".pagThemeAnimInfo");
      AppMethodBeat.o(309869);
      return locald;
    case 2: 
      locald.PMj = d.d.D(paramMap, paramString + ".simpleTwistAnimInfo");
      AppMethodBeat.o(309869);
      return locald;
    }
    locald.PMm = c.C(paramMap, paramString + ".randomSpriteAnimInfo");
    AppMethodBeat.o(309869);
    return locald;
  }
  
  public static final class a
  {
    public ArrayList<a> PMp;
    @p(hkF=2)
    public String PMq;
    public String PMr;
    
    public static a A(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(309868);
      for (;;)
      {
        int i;
        try
        {
          String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".transitionAnimationUrl"));
          String str3 = Util.nullAsNil((String)paramMap.get(paramString + ".transitionAnimationMD5"));
          ArrayList localArrayList = new ArrayList();
          i = 0;
          Object localObject2 = new StringBuilder().append(paramString).append(".transitionImgInfos.transitionImgInfo");
          Object localObject1;
          if (i == 0)
          {
            localObject1 = "";
            localObject1 = localObject1;
            if (paramMap.containsKey(localObject1)) {
              localObject2 = Util.nullAsNil((String)paramMap.get((String)localObject1 + ".transitionImg"));
            }
          }
          else
          {
            try
            {
              localObject1 = m.lP(Util.nullAsNil((String)paramMap.get((String)localObject1 + ".transitionColor")), Util.nullAsNil((String)paramMap.get((String)localObject1 + ".transitionColorAlpha")));
              if ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject1))) {
                break label386;
              }
              a locala = new a();
              locala.ADt = ((String)localObject2);
              locala.nRQ = ((String)localObject1);
              localArrayList.add(locala);
              break label386;
              localObject1 = Integer.valueOf(i);
            }
            catch (Exception localException)
            {
              Log.e("AdEggAnimationInfo", "parseFromXml ShakeCardInfo parse color exp=" + localException.toString());
              String str1 = "";
              continue;
            }
          }
          if (localArrayList.size() > 0)
          {
            paramMap = new a();
            paramMap.PMp = localArrayList;
            paramMap.PMq = str2;
            paramMap.PMr = str3;
            AppMethodBeat.o(309868);
            return paramMap;
          }
        }
        finally
        {
          Log.e("AdEggAnimationInfo", "ShakeCardInfo parseFromXml, exp=" + paramMap.toString());
          AppMethodBeat.o(309868);
          return null;
        }
        label386:
        i += 1;
      }
    }
    
    public static final class a
    {
      public String ADt;
      public String nRQ;
    }
  }
  
  public static final class b
  {
    @p(hkF=2)
    public String PMs;
    public String PMt;
    
    public static b B(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(309873);
      if (paramMap.containsKey(paramString))
      {
        b localb = new b();
        localb.PMs = Util.nullAsNil((String)paramMap.get(paramString + ".simpleTransitionAnimationUrl"));
        localb.PMt = Util.nullAsNil((String)paramMap.get(paramString + ".simpleTransitionAnimationMD5"));
        AppMethodBeat.o(309873);
        return localb;
      }
      AppMethodBeat.o(309873);
      return null;
    }
  }
  
  public static final class c
  {
    public int PMu;
    public int PMv;
    public int PMw;
    @p(hkF=1)
    public String PMx;
    
    public static c C(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(309872);
      if (paramMap.containsKey(paramString))
      {
        c localc = new c();
        localc.PMu = Util.safeParseInt((String)paramMap.get(paramString + ".spriteType"));
        localc.PMv = Util.safeParseInt((String)paramMap.get(paramString + ".spriteSizeType"));
        localc.PMw = Util.safeParseInt((String)paramMap.get(paramString + ".spriteDuration"));
        localc.PMx = Util.nullAsNil((String)paramMap.get(paramString + ".spriteImageUrl"));
        AppMethodBeat.o(309872);
        return localc;
      }
      AppMethodBeat.o(309872);
      return null;
    }
  }
  
  public static final class e
  {
    @p(hkF=1)
    public String PMy;
    public String PMz;
    public boolean isClockwise;
    
    public static e E(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(309861);
      if (paramMap.containsKey(paramString))
      {
        e locale = new e();
        if (Util.safeParseInt((String)paramMap.get(paramString + ".clockwise")) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          locale.isClockwise = bool;
          locale.PMy = Util.nullAsNil((String)paramMap.get(paramString + ".transitionImg"));
          locale.PMz = m.lP(Util.nullAsNil((String)paramMap.get(paramString + ".transitionColor")), Util.nullAsNil((String)paramMap.get(paramString + ".transitionColorAlpha")));
          AppMethodBeat.o(309861);
          return locale;
        }
      }
      AppMethodBeat.o(309861);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.d
 * JD-Core Version:    0.7.0.1
 */