package com.tencent.mm.plugin.sns.ad.landingpage.component.info;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class b$a
{
  public int PRR;
  public int PRS;
  public int PRT;
  public String iconUrl;
  public String title;
  
  public static a Y(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(310651);
    try
    {
      paramString = paramString + ".randomEncoreInfo";
      int i = Util.safeParseInt((String)paramMap.get(paramString + ".encoreType"));
      String str1 = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
      String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".imageUrl"));
      if ((i > 0) && (!TextUtils.isEmpty(str1)))
      {
        a locala = new a();
        locala.PRR = i;
        locala.title = str1;
        locala.iconUrl = str2;
        locala.PRS = Util.safeParseInt((String)paramMap.get(paramString + ".triggerGForceMin"));
        locala.PRT = Util.safeParseInt((String)paramMap.get(paramString + ".triggerGForceMax"));
        AppMethodBeat.o(310651);
        return locala;
      }
    }
    finally
    {
      Log.e("MicroMsg.AdLandingPageComponentInfo", "RandomEncoreInfo parseFromXml, exp=" + paramMap.toString());
      AppMethodBeat.o(310651);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.info.b.a
 * JD-Core Version:    0.7.0.1
 */