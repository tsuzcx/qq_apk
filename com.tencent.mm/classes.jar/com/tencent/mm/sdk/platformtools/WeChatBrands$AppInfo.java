package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cv.a;

public class WeChatBrands$AppInfo
{
  public static final String LANG_CN = "CN";
  public static final String LANG_EN = "EN";
  public static final String LANG_HK = "HK";
  public static final String LANG_TW = "TW";
  public static String lang;
  
  static
  {
    AppMethodBeat.i(249072);
    lang = getBrandLang(LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    AppMethodBeat.o(249072);
  }
  
  public static WhichApp current()
  {
    return a.YYb;
  }
  
  public static String getBrandLang(String paramString)
  {
    AppMethodBeat.i(249070);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(249070);
        return "EN";
        if (paramString.equals("zh_CN"))
        {
          i = 0;
          continue;
          if (paramString.equals("zh_HK"))
          {
            i = 1;
            continue;
            if (paramString.equals("zh_TW"))
            {
              i = 2;
              continue;
              if (paramString.equals("en")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    AppMethodBeat.o(249070);
    return "CN";
    AppMethodBeat.o(249070);
    return "HK";
    AppMethodBeat.o(249070);
    return "TW";
  }
  
  public static boolean isSimplifiedChinese()
  {
    AppMethodBeat.i(249068);
    boolean bool = String.valueOf(lang).toUpperCase().equals("CN");
    AppMethodBeat.o(249068);
    return bool;
  }
  
  public static final class WhichApp
  {
    private final int mDefaultXAgreementId;
    private final String mPackageName;
    private final String mUA;
    
    public WhichApp(String paramString1, String paramString2, int paramInt)
    {
      this.mPackageName = paramString1;
      this.mUA = paramString2;
      this.mDefaultXAgreementId = paramInt;
    }
    
    public final int getDefaultXAgreementId()
    {
      return this.mDefaultXAgreementId;
    }
    
    public final String getPackageName()
    {
      return this.mPackageName;
    }
    
    public final String getUserAgent()
    {
      return this.mUA;
    }
    
    public final boolean isMainland()
    {
      return this.mDefaultXAgreementId == 0;
    }
    
    public final boolean isUS()
    {
      return this.mDefaultXAgreementId == 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo
 * JD-Core Version:    0.7.0.1
 */