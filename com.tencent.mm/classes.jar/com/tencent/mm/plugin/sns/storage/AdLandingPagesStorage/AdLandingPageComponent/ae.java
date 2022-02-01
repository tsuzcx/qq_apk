package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class ae
{
  public int bizId;
  public int dbL;
  public String dnn;
  public String dtx;
  public String dyy;
  public String jYR;
  public String jyU;
  public String uin;
  public String xOm;
  public String yeO;
  public int yjY;
  public boolean yjZ;
  public String yka;
  public boolean ykb;
  public String ykc;
  public Map<String, String> ykd;
  
  public ae()
  {
    AppMethodBeat.i(96323);
    this.ykb = false;
    this.ykd = new HashMap();
    AppMethodBeat.o(96323);
  }
  
  public final String auD(String paramString)
  {
    AppMethodBeat.i(96324);
    paramString = (String)this.ykd.get(paramString);
    AppMethodBeat.o(96324);
    return paramString;
  }
  
  public final String getSnsId()
  {
    if (this.dnn == null) {
      return "";
    }
    return this.dnn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae
 * JD-Core Version:    0.7.0.1
 */