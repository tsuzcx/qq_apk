package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class m$f
{
  public String blZ;
  public String qPm;
  public String userName;
  
  public static f Zj(String paramString)
  {
    AppMethodBeat.i(24676);
    Map localMap = br.F(paramString, "bizprofile");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new f();
        paramString.blZ = bo.nullAsNil((String)localMap.get(".bizprofile.nickname"));
        paramString.userName = bo.nullAsNil((String)localMap.get(".bizprofile.username"));
        paramString.qPm = bo.nullAsNil((String)localMap.get(".bizprofile.showchat"));
        AppMethodBeat.o(24676);
        return paramString;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.ShakeTVXmlParser", paramString, "", new Object[0]);
        paramString = null;
        continue;
      }
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.f
 * JD-Core Version:    0.7.0.1
 */