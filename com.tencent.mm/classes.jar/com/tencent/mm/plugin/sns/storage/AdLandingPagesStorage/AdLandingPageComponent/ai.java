package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class ai
{
  public int Knp;
  public boolean Knq;
  public String Knr;
  public boolean Kns;
  public String Knt;
  public long Knu;
  public String Knv;
  public Map<String, String> Knw;
  public String adExtInfo;
  public String aid;
  public int bizId;
  public String fLp;
  public String nTp;
  public String owd;
  public String pId;
  public int source;
  public String uin;
  public String uxInfo;
  public String viewId;
  
  public ai()
  {
    AppMethodBeat.i(96323);
    this.Kns = false;
    this.Knu = 0L;
    this.Knv = "";
    this.pId = "";
    this.Knw = new HashMap();
    AppMethodBeat.o(96323);
  }
  
  public final String baR(String paramString)
  {
    AppMethodBeat.i(96324);
    paramString = (String)this.Knw.get(paramString);
    AppMethodBeat.o(96324);
    return paramString;
  }
  
  public final String fQE()
  {
    AppMethodBeat.i(256125);
    if (a.aeP(this.source))
    {
      if (!TextUtils.isEmpty(this.Knr)) {
        break label53;
      }
      Log.e("AdLandingPageData", "getUpdatedUxInfo is empty");
      a.fU(this.Knv, 10);
    }
    for (;;)
    {
      String str = this.Knr;
      AppMethodBeat.o(256125);
      return str;
      label53:
      a.fU(this.Knv, 9);
    }
  }
  
  public final String fQF()
  {
    AppMethodBeat.i(256130);
    if (Util.isNullOrNil(this.Knt))
    {
      AppMethodBeat.o(256130);
      return "";
    }
    String str = this.Knt;
    AppMethodBeat.o(256130);
    return str;
  }
  
  public final String getSnsId()
  {
    if (this.fLp == null) {
      return "";
    }
    return this.fLp;
  }
  
  public final String getViewId()
  {
    AppMethodBeat.i(256128);
    if (Util.isNullOrNil(this.viewId))
    {
      AppMethodBeat.o(256128);
      return "";
    }
    String str = this.viewId;
    AppMethodBeat.o(256128);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai
 * JD-Core Version:    0.7.0.1
 */