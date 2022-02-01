package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.Util;

public final class c$a
{
  public arn WKx;
  public String appid;
  public String desc;
  public String iah;
  public String thumbUrl;
  public String title;
  public String url;
  
  public final boolean boj()
  {
    AppMethodBeat.i(78836);
    if (!Util.isNullOrNil(this.url))
    {
      AppMethodBeat.o(78836);
      return true;
    }
    AppMethodBeat.o(78836);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.c.a
 * JD-Core Version:    0.7.0.1
 */