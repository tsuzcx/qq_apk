package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.bu;

public final class c$a
{
  public akf Ekw;
  public String dIA;
  public String desc;
  public String dwb;
  public String thumbUrl;
  public String title;
  public String url;
  
  public final boolean valid()
  {
    AppMethodBeat.i(78836);
    if (!bu.isNullOrNil(this.url))
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