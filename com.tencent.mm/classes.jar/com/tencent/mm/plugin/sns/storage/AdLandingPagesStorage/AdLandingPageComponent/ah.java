package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class ah
{
  public int DZU;
  public boolean DZV;
  public String DZW;
  public boolean DZX;
  public String DZY;
  public long DZZ;
  public Map<String, String> Eaa;
  public String adExtInfo;
  public String aid;
  public int bizId;
  public String dRS;
  public String kZe;
  public String lAN;
  public int source;
  public String uin;
  public String uxInfo;
  public String viewId;
  
  public ah()
  {
    AppMethodBeat.i(96323);
    this.DZX = false;
    this.DZZ = 0L;
    this.Eaa = new HashMap();
    AppMethodBeat.o(96323);
  }
  
  public final String aPU(String paramString)
  {
    AppMethodBeat.i(96324);
    paramString = (String)this.Eaa.get(paramString);
    AppMethodBeat.o(96324);
    return paramString;
  }
  
  public final String fcN()
  {
    AppMethodBeat.i(202831);
    if (Util.isNullOrNil(this.DZY))
    {
      AppMethodBeat.o(202831);
      return "";
    }
    String str = this.DZY;
    AppMethodBeat.o(202831);
    return str;
  }
  
  public final String getSnsId()
  {
    if (this.dRS == null) {
      return "";
    }
    return this.dRS;
  }
  
  public final String getViewId()
  {
    AppMethodBeat.i(202830);
    if (Util.isNullOrNil(this.viewId))
    {
      AppMethodBeat.o(202830);
      return "";
    }
    String str = this.viewId;
    AppMethodBeat.o(202830);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah
 * JD-Core Version:    0.7.0.1
 */