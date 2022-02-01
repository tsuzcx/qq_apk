package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;
import org.xwalk.core.Log;

public final class aa
{
  static aa MNj = null;
  public IWebStorage MNi;
  
  private aa()
  {
    AppMethodBeat.i(156798);
    this.MNi = null;
    IWebStorage localIWebStorage = j.g(WebView.getCurWebType()).createWebviewStorage();
    if (localIWebStorage == null)
    {
      Log.e("WebStorage", "create WebStorage failed webStg is null, cur core kind is " + WebView.getCurWebType());
      AppMethodBeat.o(156798);
      return;
    }
    this.MNi = localIWebStorage;
    AppMethodBeat.o(156798);
  }
  
  public static aa gfG()
  {
    try
    {
      AppMethodBeat.i(156797);
      if (MNj == null) {
        MNj = new aa();
      }
      aa localaa = MNj;
      AppMethodBeat.o(156797);
      return localaa;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.aa
 * JD-Core Version:    0.7.0.1
 */