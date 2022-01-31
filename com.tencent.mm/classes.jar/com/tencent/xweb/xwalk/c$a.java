package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

final class c$a
  extends XWalkUpdater.UpdateConfig
{
  String BJk;
  
  private c$a(int paramInt)
  {
    super(null, false, paramInt);
  }
  
  public c$a(String paramString1, String paramString2)
  {
    this(i);
    AppMethodBeat.i(85175);
    this.BJk = paramString1;
    this.isMatchMd5 = false;
    this.isPatchUpdate = false;
    this.versionDetail = "local:".concat(String.valueOf(paramString2));
    AppMethodBeat.o(85175);
  }
  
  public final boolean checkValid()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.a
 * JD-Core Version:    0.7.0.1
 */