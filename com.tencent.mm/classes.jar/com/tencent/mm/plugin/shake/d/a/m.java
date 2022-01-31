package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class m
{
  public static final class b
  {
    public String pqC;
    public String qPk;
    public String thumbUrl;
    public String title;
    
    public static b Zf(String paramString)
    {
      AppMethodBeat.i(24672);
      Map localMap = br.F(paramString, "nativepay");
      if (localMap != null) {}
      for (;;)
      {
        try
        {
          paramString = new b();
          paramString.title = bo.nullAsNil((String)localMap.get(".nativepay.title"));
          paramString.thumbUrl = bo.nullAsNil((String)localMap.get(".nativepay.thumburl"));
          paramString.qPk = bo.nullAsNil((String)localMap.get(".nativepay.wx_pay_url"));
          paramString.pqC = bo.nullAsNil((String)localMap.get(".nativepay.price"));
          AppMethodBeat.o(24672);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.m
 * JD-Core Version:    0.7.0.1
 */