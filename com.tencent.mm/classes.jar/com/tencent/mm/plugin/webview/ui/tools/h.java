package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.model.ba.i;
import com.tencent.mm.plugin.webview.model.ba.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qqvideo.proxy.api.IUtils;
import java.util.ArrayList;
import java.util.List;

public final class h
  extends a
  implements IUtils
{
  public h(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
  }
  
  public final void httpproxyReport(String... paramVarArgs)
  {
    AppMethodBeat.i(79800);
    Object localObject = gXq().PIx.gWf();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = gXq().PIx.gWf();
      if ((paramVarArgs.PWD == null) || (paramVarArgs.PWD.size() == 0)) {
        AppMethodBeat.o(79800);
      }
    }
    else
    {
      if (((ba.j)localObject).PWD == null) {
        ((ba.j)localObject).PWD = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < paramVarArgs.length)
        {
          Log.i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", new Object[] { paramVarArgs[i] });
          ((ba.j)localObject).PWD.add(paramVarArgs[i]);
          i += 1;
        }
        break;
        ((ba.j)localObject).PWD.clear();
      }
    }
    localObject = com.tencent.mm.plugin.report.service.h.IzE;
    com.tencent.mm.plugin.report.service.h.u(12033, paramVarArgs.PWD);
    paramVarArgs.PWD.clear();
    AppMethodBeat.o(79800);
  }
  
  public final void idKeyReport(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(79801);
    Log.i("MicroMsg.WebViewUI.UtilsImpl", "idkey report, id = %s, key = %s, value = %s", new Object[] { paramString1, paramString2, paramString3 });
    if ((!Util.isNullOrNil(paramString1)) && (!Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(paramString3)))
    {
      int i = Util.getInt(paramString1, 0);
      int j = Util.getInt(paramString2, 0);
      int k = Util.getInt(paramString3, 0);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(i, j, k, false);
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
      Log.d(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      Log.e(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      Log.i(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      Log.v(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      Log.w(paramString1, paramString2);
    }
  }
  
  public final void kvReport(String... paramVarArgs)
  {
    AppMethodBeat.i(79802);
    Object localObject = gXq().PIx.gWg();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = gXq().PIx.gWg();
      if ((paramVarArgs.PWD == null) || (paramVarArgs.PWD.size() == 0)) {
        AppMethodBeat.o(79802);
      }
    }
    else
    {
      if (((ba.i)localObject).PWD == null) {
        ((ba.i)localObject).PWD = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < paramVarArgs.length)
        {
          Log.i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", new Object[] { paramVarArgs[i] });
          ((ba.i)localObject).PWD.add(paramVarArgs[i]);
          i += 1;
        }
        break;
        ((ba.i)localObject).PWD.clear();
      }
    }
    localObject = com.tencent.mm.plugin.report.service.h.IzE;
    com.tencent.mm.plugin.report.service.h.u(12666, paramVarArgs.PWD);
    paramVarArgs.PWD.clear();
    AppMethodBeat.o(79802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */