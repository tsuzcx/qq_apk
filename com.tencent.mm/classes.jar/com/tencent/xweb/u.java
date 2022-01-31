package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.h;
import com.tencent.xweb.c.l;
import com.tencent.xweb.c.l.a;
import org.xwalk.core.Log;

public final class u
{
  static u BEc = null;
  public h BEb;
  
  private u()
  {
    AppMethodBeat.i(3838);
    this.BEb = null;
    h localh = l.e(WebView.getCurWebType()).createWebviewStorage();
    if (localh == null)
    {
      Log.e("WebStorage", "create WebStorage failed webStg is null, cur core kind is " + WebView.getCurWebType());
      AppMethodBeat.o(3838);
      return;
    }
    this.BEb = localh;
    AppMethodBeat.o(3838);
  }
  
  public static u dYA()
  {
    try
    {
      AppMethodBeat.i(3837);
      if (BEc == null) {
        BEc = new u();
      }
      u localu = BEc;
      AppMethodBeat.o(3837);
      return localu;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.u
 * JD-Core Version:    0.7.0.1
 */