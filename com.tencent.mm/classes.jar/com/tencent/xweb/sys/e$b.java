package com.tencent.xweb.sys;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class e$b
{
  HashMap<String, ValueCallback<String>> BHF;
  int BHG;
  
  public e$b()
  {
    AppMethodBeat.i(84699);
    this.BHF = new HashMap();
    this.BHG = 0;
    AppMethodBeat.o(84699);
  }
  
  @JavascriptInterface
  public final void notifyJava(String paramString1, String paramString2)
  {
    AppMethodBeat.i(84700);
    ValueCallback localValueCallback = (ValueCallback)this.BHF.get(paramString1);
    if (localValueCallback != null)
    {
      localValueCallback.onReceiveValue(paramString2);
      this.BHF.remove(paramString1);
    }
    AppMethodBeat.o(84700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.sys.e.b
 * JD-Core Version:    0.7.0.1
 */