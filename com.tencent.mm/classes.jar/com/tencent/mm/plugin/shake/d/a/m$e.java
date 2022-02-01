package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class m$e
{
  public String dqK;
  public String link;
  public String thumbUrl;
  public String title;
  
  public static e asr(String paramString)
  {
    AppMethodBeat.i(28345);
    Map localMap = bv.L(paramString, "h5url");
    if (localMap != null) {}
    for (;;)
    {
      try
      {
        paramString = new e();
        paramString.title = bs.nullAsNil((String)localMap.get(".h5url.title"));
        paramString.thumbUrl = bs.nullAsNil((String)localMap.get(".h5url.thumburl"));
        paramString.link = bs.nullAsNil((String)localMap.get(".h5url.link"));
        paramString.dqK = bs.nullAsNil((String)localMap.get(".h5url.username"));
        AppMethodBeat.o(28345);
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
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m.e
 * JD-Core Version:    0.7.0.1
 */