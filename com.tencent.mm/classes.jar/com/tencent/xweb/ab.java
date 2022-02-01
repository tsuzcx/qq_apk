package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import org.xwalk.core.Log;

public final class ab
{
  static ab aaaV = null;
  public IWebStorage aaaU;
  
  private ab()
  {
    AppMethodBeat.i(156798);
    this.aaaU = null;
    IWebStorage localIWebStorage = l.h(WebView.getCurWebType()).createWebviewStorage();
    if (localIWebStorage == null)
    {
      Log.e("WebStorage", "create WebStorage failed webStg is null, cur core kind is " + WebView.getCurWebType());
      AppMethodBeat.o(156798);
      return;
    }
    this.aaaU = localIWebStorage;
    AppMethodBeat.o(156798);
  }
  
  public static ab iwG()
  {
    try
    {
      AppMethodBeat.i(156797);
      if (aaaV == null) {
        aaaV = new ab();
      }
      ab localab = aaaV;
      AppMethodBeat.o(156797);
      return localab;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.ab
 * JD-Core Version:    0.7.0.1
 */