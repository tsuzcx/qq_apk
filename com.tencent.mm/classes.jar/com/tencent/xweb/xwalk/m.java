package com.tencent.xweb.xwalk;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import com.tencent.xweb.internal.g;
import com.tencent.xweb.o;
import org.xwalk.core.Log;

public final class m
  implements g
{
  private boolean aipn;
  
  public final o khd()
  {
    AppMethodBeat.i(183742);
    r localr = r.a.kjn();
    AppMethodBeat.o(183742);
    return localr;
  }
  
  public final void khe()
  {
    AppMethodBeat.i(183743);
    String str1;
    String str2;
    int i;
    if (!this.aipn)
    {
      str1 = a.keX().qM("setEnabledTraceCategory", WebView.getCurStrModule());
      str2 = a.keX().qM("setTraceSampleRatioInTenThousand", WebView.getCurStrModule());
      if ((!TextUtils.isEmpty(str2)) && (TextUtils.isDigitsOnly(str2))) {
        break label135;
      }
      i = 0;
    }
    for (;;)
    {
      str2 = a.keX().qM("enableWindowPerformanceSampleRatio", WebView.getCurStrModule());
      try
      {
        j = Integer.parseInt(str2);
        r.a.kjn();
        Log.i("XWalkExtensionInternal", "setProfileConfig with enabledTraceCategory: " + str1 + " traceSampleRatio: " + i + " enableWindowPerformanceSampleRatio: " + j);
        r.e(str1, i, j, false);
        this.aipn = true;
        AppMethodBeat.o(183743);
        return;
        label135:
        i = Integer.parseInt(str2);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          Log.e("XWalkExtensionInternal", "initProfile error:".concat(String.valueOf(localNumberFormatException)));
          int j = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.m
 * JD-Core Version:    0.7.0.1
 */