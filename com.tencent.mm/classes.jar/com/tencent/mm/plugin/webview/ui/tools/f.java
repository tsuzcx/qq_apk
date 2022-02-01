package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.model.ax.h;
import com.tencent.mm.plugin.webview.model.ax.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.qqvideo.proxy.api.IUtils;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends a
  implements IUtils
{
  public f(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
  }
  
  public final void httpproxyReport(String... paramVarArgs)
  {
    AppMethodBeat.i(79800);
    Object localObject = eCT().Cfc.eBN();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = eCT().Cfc.eBN();
      if ((paramVarArgs.CrF == null) || (paramVarArgs.CrF.size() == 0)) {
        AppMethodBeat.o(79800);
      }
    }
    else
    {
      if (((ax.i)localObject).CrF == null) {
        ((ax.i)localObject).CrF = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < paramVarArgs.length)
        {
          ac.i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", new Object[] { paramVarArgs[i] });
          ((ax.i)localObject).CrF.add(paramVarArgs[i]);
          i += 1;
        }
        break;
        ((ax.i)localObject).CrF.clear();
      }
    }
    localObject = h.wUl;
    h.k(12033, paramVarArgs.CrF);
    paramVarArgs.CrF.clear();
    AppMethodBeat.o(79800);
  }
  
  public final void idKeyReport(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(79801);
    ac.i("MicroMsg.WebViewUI.UtilsImpl", "idkey report, id = %s, key = %s, value = %s", new Object[] { paramString1, paramString2, paramString3 });
    if ((!bs.isNullOrNil(paramString1)) && (!bs.isNullOrNil(paramString2)) && (!bs.isNullOrNil(paramString3)))
    {
      int i = bs.getInt(paramString1, 0);
      int j = bs.getInt(paramString2, 0);
      int k = bs.getInt(paramString3, 0);
      h.wUl.idkeyStat(i, j, k, false);
    }
    AppMethodBeat.o(79801);
  }
  
  public final void javaUtilLog(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(79799);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79799);
      return;
      ac.d(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      ac.e(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      ac.i(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      ac.v(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      ac.w(paramString1, paramString2);
    }
  }
  
  public final void kvReport(String... paramVarArgs)
  {
    AppMethodBeat.i(79802);
    Object localObject = eCT().Cfc.eBO();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = eCT().Cfc.eBO();
      if ((paramVarArgs.CrF == null) || (paramVarArgs.CrF.size() == 0)) {
        AppMethodBeat.o(79802);
      }
    }
    else
    {
      if (((ax.h)localObject).CrF == null) {
        ((ax.h)localObject).CrF = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < paramVarArgs.length)
        {
          ac.i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", new Object[] { paramVarArgs[i] });
          ((ax.h)localObject).CrF.add(paramVarArgs[i]);
          i += 1;
        }
        break;
        ((ax.h)localObject).CrF.clear();
      }
    }
    localObject = h.wUl;
    h.k(12666, paramVarArgs.CrF);
    paramVarArgs.CrF.clear();
    AppMethodBeat.o(79802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */