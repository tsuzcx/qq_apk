package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class m$f
{
  public String aVr;
  public String obd;
  public String userName;
  
  public static f MB(String paramString)
  {
    paramString = bn.s(paramString, "bizprofile");
    if (paramString != null) {
      try
      {
        f localf = new f();
        localf.aVr = bk.pm((String)paramString.get(".bizprofile.nickname"));
        localf.userName = bk.pm((String)paramString.get(".bizprofile.username"));
        localf.obd = bk.pm((String)paramString.get(".bizprofile.showchat"));
        return localf;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.ShakeTVXmlParser", paramString, "", new Object[0]);
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.f
 * JD-Core Version:    0.7.0.1
 */