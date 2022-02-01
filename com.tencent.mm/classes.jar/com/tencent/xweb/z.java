package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;
import org.xwalk.core.Log;

public final class z
{
  static z INn = null;
  public IWebStorage INm;
  
  private z()
  {
    AppMethodBeat.i(156798);
    this.INm = null;
    IWebStorage localIWebStorage = j.g(WebView.getCurWebType()).createWebviewStorage();
    if (localIWebStorage == null)
    {
      Log.e("WebStorage", "create WebStorage failed webStg is null, cur core kind is " + WebView.getCurWebType());
      AppMethodBeat.o(156798);
      return;
    }
    this.INm = localIWebStorage;
    AppMethodBeat.o(156798);
  }
  
  public static z frj()
  {
    try
    {
      AppMethodBeat.i(156797);
      if (INn == null) {
        INn = new z();
      }
      z localz = INn;
      AppMethodBeat.o(156797);
      return localz;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.z
 * JD-Core Version:    0.7.0.1
 */