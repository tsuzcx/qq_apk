package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;
import org.xwalk.core.Log;

public final class aa
{
  static aa Mqf = null;
  public IWebStorage Mqe;
  
  private aa()
  {
    AppMethodBeat.i(156798);
    this.Mqe = null;
    IWebStorage localIWebStorage = j.g(WebView.getCurWebType()).createWebviewStorage();
    if (localIWebStorage == null)
    {
      Log.e("WebStorage", "create WebStorage failed webStg is null, cur core kind is " + WebView.getCurWebType());
      AppMethodBeat.o(156798);
      return;
    }
    this.Mqe = localIWebStorage;
    AppMethodBeat.o(156798);
  }
  
  public static aa gbe()
  {
    try
    {
      AppMethodBeat.i(156797);
      if (Mqf == null) {
        Mqf = new aa();
      }
      aa localaa = Mqf;
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