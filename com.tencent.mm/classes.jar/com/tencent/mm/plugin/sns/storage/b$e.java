package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b$e
{
  public String bFw;
  public String bNZ;
  public String bth;
  public String oAa = "";
  public List<b.h> oBQ = new ArrayList();
  
  public final void r(Map<String, String> paramMap, String paramString)
  {
    this.oAa = bk.aM((String)paramMap.get(paramString + ".adxml.adTurnActionLink"), "");
    String str = (String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appUserName");
    if (!TextUtils.isEmpty(str))
    {
      this.bNZ = str;
      this.bth = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.appVersion"));
      this.bFw = ((String)paramMap.get(paramString + ".adxml.adTurnActionExtWeApp.relativePagePath"));
    }
    str = paramString + ".adxml.adTurnInfo.materialInfo";
    int i = 0;
    if (i > 0) {}
    for (paramString = str + i;; paramString = str)
    {
      if ((paramMap.get(paramString + ".displayType") != null) && (((String)paramMap.get(paramString + ".displayType")).length() > 0))
      {
        b.h localh = new b.h();
        localh.title = bk.aM((String)paramMap.get(paramString + ".title"), "");
        localh.desc = bk.aM((String)paramMap.get(paramString + ".desc"), "");
        localh.oBK = bk.ZR((String)paramMap.get(paramString + ".displayType"));
        this.oBQ.add(localh);
        i += 1;
        break;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b.e
 * JD-Core Version:    0.7.0.1
 */