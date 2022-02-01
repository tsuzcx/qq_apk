package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class m$f
{
  public String bLs;
  public String userName;
  public String xzs;
  
  public static f ass(String paramString)
  {
    AppMethodBeat.i(28346);
    Map localMap = bv.L(paramString, "bizprofile");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new f();
        paramString.bLs = bs.nullAsNil((String)localMap.get(".bizprofile.nickname"));
        paramString.userName = bs.nullAsNil((String)localMap.get(".bizprofile.username"));
        paramString.xzs = bs.nullAsNil((String)localMap.get(".bizprofile.showchat"));
        AppMethodBeat.o(28346);
        return paramString;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.ShakeTVXmlParser", paramString, "", new Object[0]);
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