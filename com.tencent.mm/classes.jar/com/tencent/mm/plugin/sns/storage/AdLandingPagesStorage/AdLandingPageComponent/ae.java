package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class ae
{
  public String aQj;
  public int bizId;
  public String dFy;
  public int dnh;
  public String dzb;
  public String jSR;
  public String ktn;
  public String uin;
  public int zAN;
  public boolean zAO;
  public String zAP;
  public boolean zAQ;
  public String zAR;
  public Map<String, String> zAS;
  public String zeg;
  public String zuP;
  
  public ae()
  {
    AppMethodBeat.i(96323);
    this.zAQ = false;
    this.zAS = new HashMap();
    AppMethodBeat.o(96323);
  }
  
  public final String azK(String paramString)
  {
    AppMethodBeat.i(96324);
    paramString = (String)this.zAS.get(paramString);
    AppMethodBeat.o(96324);
    return paramString;
  }
  
  public final String dWr()
  {
    AppMethodBeat.i(197886);
    if (bt.isNullOrNil(this.zAR))
    {
      AppMethodBeat.o(197886);
      return "";
    }
    String str = this.zAR;
    AppMethodBeat.o(197886);
    return str;
  }
  
  public final String getSnsId()
  {
    if (this.dzb == null) {
      return "";
    }
    return this.dzb;
  }
  
  public final String getViewId()
  {
    AppMethodBeat.i(197885);
    if (bt.isNullOrNil(this.aQj))
    {
      AppMethodBeat.o(197885);
      return "";
    }
    String str = this.aQj;
    AppMethodBeat.o(197885);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae
 * JD-Core Version:    0.7.0.1
 */