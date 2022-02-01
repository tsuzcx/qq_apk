package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class m$f
{
  public String bVF;
  public String userName;
  public String zem;
  
  public static f ayI(String paramString)
  {
    AppMethodBeat.i(28346);
    Map localMap = bx.M(paramString, "bizprofile");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new f();
        paramString.bVF = bu.nullAsNil((String)localMap.get(".bizprofile.nickname"));
        paramString.userName = bu.nullAsNil((String)localMap.get(".bizprofile.username"));
        paramString.zem = bu.nullAsNil((String)localMap.get(".bizprofile.showchat"));
        AppMethodBeat.o(28346);
        return paramString;
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.ShakeTVXmlParser", paramString, "", new Object[0]);
        paramString = null;
        continue;
      }
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.f
 * JD-Core Version:    0.7.0.1
 */