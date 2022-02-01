package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public final class af
{
  public String aQj;
  public int bizId;
  public String dAg;
  public String dGD;
  public int doj;
  public String jWi;
  public String kwD;
  public String uin;
  public String zMk;
  public int zRN;
  public boolean zRO;
  public String zRP;
  public boolean zRQ;
  public String zRR;
  public Map<String, String> zRS;
  public String zsJ;
  
  public af()
  {
    AppMethodBeat.i(96323);
    this.zRQ = false;
    this.zRS = new HashMap();
    AppMethodBeat.o(96323);
  }
  
  public final String aBb(String paramString)
  {
    AppMethodBeat.i(96324);
    paramString = (String)this.zRS.get(paramString);
    AppMethodBeat.o(96324);
    return paramString;
  }
  
  public final String dZT()
  {
    AppMethodBeat.i(219381);
    if (bu.isNullOrNil(this.zRR))
    {
      AppMethodBeat.o(219381);
      return "";
    }
    String str = this.zRR;
    AppMethodBeat.o(219381);
    return str;
  }
  
  public final String getSnsId()
  {
    if (this.dAg == null) {
      return "";
    }
    return this.dAg;
  }
  
  public final String getViewId()
  {
    AppMethodBeat.i(219380);
    if (bu.isNullOrNil(this.aQj))
    {
      AppMethodBeat.o(219380);
      return "";
    }
    String str = this.aQj;
    AppMethodBeat.o(219380);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af
 * JD-Core Version:    0.7.0.1
 */