package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import com.tencent.xweb.internal.f;
import com.tencent.xweb.m;
import org.xwalk.core.Log;

public final class n
  implements f
{
  private boolean aaiW;
  
  public final m ixm()
  {
    AppMethodBeat.i(183742);
    s locals = s.a.iyU();
    AppMethodBeat.o(183742);
    return locals;
  }
  
  public final void ixn()
  {
    AppMethodBeat.i(183743);
    String str1;
    int k;
    String str2;
    int i;
    if (!this.aaiW)
    {
      str1 = a.bEH(WebView.getCurStrModule());
      k = a.bEG(WebView.getCurStrModule());
      str2 = a.oO("enableWindowPerformanceSampleRatio", WebView.getCurStrModule());
      i = 0;
    }
    try
    {
      int j = Integer.parseInt(str2);
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label47:
      break label47;
    }
    s.a.iyU();
    Log.d("XWalkExtensionInternal", "setProfileConfig with enabledTraceCategory: " + str1 + " traceSampleRatio: " + k + " enableWindowPerformanceSampleRatio: " + i);
    s.be(str1, k, i);
    this.aaiW = true;
    AppMethodBeat.o(183743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.n
 * JD-Core Version:    0.7.0.1
 */