package com.tencent.mm.plugin.sns.ad.landingpage.component.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b
  extends aa
{
  public String JBF;
  public String JBG;
  public a JBH;
  public List<aa> ayS;
  
  public b()
  {
    AppMethodBeat.i(217215);
    this.ayS = new ArrayList();
    AppMethodBeat.o(217215);
  }
  
  public final List<aa> fKw()
  {
    return this.ayS;
  }
  
  public static final class a
  {
    public ArrayList<a> JBI;
    public String JBJ;
    public String JBK;
    
    public static a K(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(265626);
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
              localObject1 = m.kp(Util.nullAsNil((String)paramMap.get((String)localObject1 + ".transitionColor")), Util.nullAsNil((String)paramMap.get((String)localObject1 + ".transitionColorAlpha")));
              if ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject1))) {
                break label378;
              }
              a locala = new a();
              locala.xei = ((String)localObject2);
              locala.lmL = ((String)localObject1);
              localArrayList.add(locala);
              break label378;
              localObject1 = Integer.valueOf(i);
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.AdLandingPageComponentInfo", "parseFromXml ShakeCardInfo parse color exp=" + localException.toString());
              String str1 = "";
              continue;
            }
          }
          paramMap = new a();
          paramMap.JBI = localArrayList;
          paramMap.JBJ = str2;
          paramMap.JBK = str3;
          AppMethodBeat.o(265626);
          return paramMap;
        }
        catch (Throwable paramMap)
        {
          Log.e("MicroMsg.AdLandingPageComponentInfo", "parseFromXml, exp=" + paramMap.toString());
          AppMethodBeat.o(265626);
          return null;
        }
        label378:
        i += 1;
      }
    }
    
    public static final class a
    {
      public String lmL;
      public String xei;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.b.b
 * JD-Core Version:    0.7.0.1
 */