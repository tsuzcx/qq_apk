package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class e
{
  public String PLR;
  public String PLS;
  public String finderLiveId;
  public String finderUsername;
  
  public static e F(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309850);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(309850);
      return null;
    }
    String str = (String)paramMap.get(paramString + ".finderUsername");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(309850);
      return null;
    }
    try
    {
      e locale = new e();
      locale.finderUsername = Util.nullAsNil(str);
      locale.finderLiveId = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveId"));
      locale.PLR = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveFeedExportId"));
      locale.PLS = Util.nullAsNil((String)paramMap.get(paramString + ".finderLiveFeedNonceId"));
      return locale;
    }
    finally
    {
      AppMethodBeat.o(309850);
    }
    return null;
  }
  
  public static class a
  {
    public String PLU;
    public String PLV;
    public String PLW;
    public b PMA;
    public List<a> PMc;
    
    public a()
    {
      AppMethodBeat.i(309845);
      this.PMc = new ArrayList();
      AppMethodBeat.o(309845);
    }
    
    public final a G(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(309860);
      if (d.isEmpty(paramMap))
      {
        AppMethodBeat.o(309860);
        return null;
      }
      try
      {
        boolean bool = paramMap.containsKey(paramString);
        if (!bool) {
          return null;
        }
        this.PLU = Util.nullAsNil((String)paramMap.get(paramString + ".bgImage"));
        this.PLV = Util.nullAsNil((String)paramMap.get(paramString + ".avatar"));
        this.PLW = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
        this.PMA = new b().I(paramMap, paramString + ".productInfo");
        String str = paramString + ".liveCheerIconList.iconInfo";
        int i = 0;
        StringBuilder localStringBuilder = new StringBuilder().append(str);
        if (i == 0) {}
        for (paramString = "";; paramString = Integer.valueOf(i))
        {
          paramString = paramString;
          if (!paramMap.containsKey(paramString)) {
            break label282;
          }
          paramString = new a().H(paramMap, paramString);
          this.PMc.add(paramString);
          i += 1;
          break;
        }
        label282:
        return this;
      }
      finally
      {
        AppMethodBeat.o(309860);
      }
      return null;
    }
    
    public static final class a
    {
      public String PMB;
      public int PMC;
      
      public final a H(Map<String, String> paramMap, String paramString)
      {
        AppMethodBeat.i(309857);
        this.PMB = Util.nullAsNil((String)paramMap.get(paramString + ".iconUrl"));
        this.PMC = Util.safeParseInt((String)paramMap.get(paramString + ".sampleRate"));
        AppMethodBeat.o(309857);
        return this;
      }
    }
    
    public static final class b
    {
      public String PLX;
      public String PLY;
      public String PLZ;
      public String PMa;
      public String PMb;
      
      public final b I(Map<String, String> paramMap, String paramString)
      {
        AppMethodBeat.i(309851);
        this.PLX = Util.nullAsNil((String)paramMap.get(paramString + ".image"));
        this.PLY = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
        this.PLZ = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
        this.PMa = Util.nullAsNil((String)paramMap.get(paramString + ".actionTitle"));
        this.PMb = Util.nullAsNil((String)paramMap.get(paramString + ".canvasId"));
        AppMethodBeat.o(309851);
        return this;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.e
 * JD-Core Version:    0.7.0.1
 */