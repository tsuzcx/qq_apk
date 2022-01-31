package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b$f
{
  public String appVersion;
  public String cmG;
  public String cvr;
  public String rpk;
  public List<b.i> rrj;
  
  public b$f()
  {
    AppMethodBeat.i(36902);
    this.rpk = "";
    this.rrj = new ArrayList();
    AppMethodBeat.o(36902);
  }
  
  public final void r(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(36903);
    this.rpk = bo.bf((String)paramMap.get(paramString + ".adxml.adTurnActionLink"), "");
    String str = (String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appUserName");
    if (!TextUtils.isEmpty(str))
    {
      this.cvr = str;
      this.appVersion = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appVersion"));
      this.cmG = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.relativePagePath"));
    }
    str = paramString + ".adxml.adTurnInfo.materialInfo";
    int i = 0;
    if (i > 0) {}
    for (paramString = str + i;; paramString = str)
    {
      if ((paramMap.get(paramString + ".displayType") != null) && (((String)paramMap.get(paramString + ".displayType")).length() > 0))
      {
        b.i locali = new b.i();
        locali.title = bo.bf((String)paramMap.get(paramString + ".title"), "");
        locali.desc = bo.bf((String)paramMap.get(paramString + ".desc"), "");
        locali.rqV = bo.apV((String)paramMap.get(paramString + ".displayType"));
        this.rrj.add(locali);
        i += 1;
        break;
      }
      AppMethodBeat.o(36903);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b.f
 * JD-Core Version:    0.7.0.1
 */