package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class m$f
{
  public String Dje;
  public String nickName;
  public String userName;
  
  public static f aNs(String paramString)
  {
    AppMethodBeat.i(28346);
    Map localMap = XmlParser.parseXml(paramString, "bizprofile", null);
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new f();
        paramString.nickName = Util.nullAsNil((String)localMap.get(".bizprofile.nickname"));
        paramString.userName = Util.nullAsNil((String)localMap.get(".bizprofile.username"));
        paramString.Dje = Util.nullAsNil((String)localMap.get(".bizprofile.showchat"));
        AppMethodBeat.o(28346);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.ShakeTVXmlParser", paramString, "", new Object[0]);
        paramString = null;
        continue;
      }
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.f
 * JD-Core Version:    0.7.0.1
 */