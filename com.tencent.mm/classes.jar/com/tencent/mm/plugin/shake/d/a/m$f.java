package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class m$f
{
  public String bNK;
  public String userName;
  public String wob;
  
  public static f anj(String paramString)
  {
    AppMethodBeat.i(28346);
    Map localMap = bw.K(paramString, "bizprofile");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new f();
        paramString.bNK = bt.nullAsNil((String)localMap.get(".bizprofile.nickname"));
        paramString.userName = bt.nullAsNil((String)localMap.get(".bizprofile.username"));
        paramString.wob = bt.nullAsNil((String)localMap.get(".bizprofile.showchat"));
        AppMethodBeat.o(28346);
        return paramString;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.ShakeTVXmlParser", paramString, "", new Object[0]);
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