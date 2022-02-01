package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class f
{
  public static final String adwb;
  
  static
  {
    AppMethodBeat.i(249345);
    adwb = "https://" + WeChatHosts.domainString(a.k.host_weixin_qq_com);
    AppMethodBeat.o(249345);
  }
  
  public static String bjC(String paramString)
  {
    AppMethodBeat.i(141283);
    paramString = paramString + "_" + System.currentTimeMillis();
    AppMethodBeat.o(141283);
    return paramString;
  }
  
  public static final class n
  {
    public static int adwG = 0;
    public static int adwH = 1;
    public static int adwI = 2;
  }
  
  public static final class o
  {
    public static final String lZE = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.f
 * JD-Core Version:    0.7.0.1
 */