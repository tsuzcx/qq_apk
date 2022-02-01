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
  private boolean SHG;
  
  public final m htD()
  {
    AppMethodBeat.i(183742);
    s locals = s.a.hvb();
    AppMethodBeat.o(183742);
    return locals;
  }
  
  public final void htE()
  {
    AppMethodBeat.i(183743);
    String str1;
    int k;
    String str2;
    int i;
    if (!this.SHG)
    {
      str1 = a.brI(WebView.getCurStrModule());
      k = a.brH(WebView.getCurStrModule());
      str2 = a.nS("enableWindowPerformanceSampleRatio", WebView.getCurStrModule());
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
    s.a.hvb();
    Log.d("XWalkExtensionInternal", "setProfileConfig with enabledTraceCategory: " + str1 + " traceSampleRatio: " + k + " enableWindowPerformanceSampleRatio: " + i);
    s.bb(str1, k, i);
    this.SHG = true;
    AppMethodBeat.o(183743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.n
 * JD-Core Version:    0.7.0.1
 */