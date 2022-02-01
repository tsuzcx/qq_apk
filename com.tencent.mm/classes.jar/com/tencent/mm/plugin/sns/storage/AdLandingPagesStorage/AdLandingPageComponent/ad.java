package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class ad
{
  public int bizId;
  public String dAM;
  public int dep;
  public String dpC;
  public String dvK;
  public String iYE;
  public String jyu;
  public String uin;
  public String wBR;
  public String wSi;
  public int wXj;
  public boolean wXk;
  public String wXl;
  public boolean wXn;
  public String wXo;
  public Map<String, String> wXp;
  
  public ad()
  {
    AppMethodBeat.i(96323);
    this.wXn = false;
    this.wXp = new HashMap();
    AppMethodBeat.o(96323);
  }
  
  public final String aps(String paramString)
  {
    AppMethodBeat.i(96324);
    paramString = (String)this.wXp.get(paramString);
    AppMethodBeat.o(96324);
    return paramString;
  }
  
  public final String getSnsId()
  {
    if (this.dpC == null) {
      return "";
    }
    return this.dpC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad
 * JD-Core Version:    0.7.0.1
 */