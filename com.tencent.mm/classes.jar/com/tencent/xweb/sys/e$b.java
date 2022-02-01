package com.tencent.xweb.sys;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class e$b
{
  HashMap<String, ValueCallback<String>> SEx;
  int SEy;
  
  public e$b()
  {
    AppMethodBeat.i(153723);
    this.SEx = new HashMap();
    this.SEy = 0;
    AppMethodBeat.o(153723);
  }
  
  @JavascriptInterface
  public final void notifyJava(String paramString1, String paramString2)
  {
    AppMethodBeat.i(153724);
    ValueCallback localValueCallback = (ValueCallback)this.SEx.get(paramString1);
    if (localValueCallback != null)
    {
      localValueCallback.onReceiveValue(paramString2);
      this.SEx.remove(paramString1);
    }
    AppMethodBeat.o(153724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.sys.e.b
 * JD-Core Version:    0.7.0.1
 */