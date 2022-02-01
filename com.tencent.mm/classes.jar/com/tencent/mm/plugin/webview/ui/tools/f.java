package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.model.ax.h;
import com.tencent.mm.plugin.webview.model.ax.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
    Object localObject = enA().AMJ.ems();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = enA().AMJ.ems();
      if ((paramVarArgs.AZs == null) || (paramVarArgs.AZs.size() == 0)) {
        AppMethodBeat.o(79800);
      }
    }
    else
    {
      if (((ax.i)localObject).AZs == null) {
        ((ax.i)localObject).AZs = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < paramVarArgs.length)
        {
          ad.i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", new Object[] { paramVarArgs[i] });
          ((ax.i)localObject).AZs.add(paramVarArgs[i]);
          i += 1;
        }
        break;
        ((ax.i)localObject).AZs.clear();
      }
    }
    localObject = h.vKh;
    h.h(12033, paramVarArgs.AZs);
    paramVarArgs.AZs.clear();
    AppMethodBeat.o(79800);
  }
  
  public final void idKeyReport(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(79801);
    ad.i("MicroMsg.WebViewUI.UtilsImpl", "idkey report, id = %s, key = %s, value = %s", new Object[] { paramString1, paramString2, paramString3 });
    if ((!bt.isNullOrNil(paramString1)) && (!bt.isNullOrNil(paramString2)) && (!bt.isNullOrNil(paramString3)))
    {
      int i = bt.getInt(paramString1, 0);
      int j = bt.getInt(paramString2, 0);
      int k = bt.getInt(paramString3, 0);
      h.vKh.idkeyStat(i, j, k, false);
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
      ad.d(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      ad.e(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      ad.i(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      ad.v(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      ad.w(paramString1, paramString2);
    }
  }
  
  public final void kvReport(String... paramVarArgs)
  {
    AppMethodBeat.i(79802);
    Object localObject = enA().AMJ.emt();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = enA().AMJ.emt();
      if ((paramVarArgs.AZs == null) || (paramVarArgs.AZs.size() == 0)) {
        AppMethodBeat.o(79802);
      }
    }
    else
    {
      if (((ax.h)localObject).AZs == null) {
        ((ax.h)localObject).AZs = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < paramVarArgs.length)
        {
          ad.i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", new Object[] { paramVarArgs[i] });
          ((ax.h)localObject).AZs.add(paramVarArgs[i]);
          i += 1;
        }
        break;
        ((ax.h)localObject).AZs.clear();
      }
    }
    localObject = h.vKh;
    h.h(12666, paramVarArgs.AZs);
    paramVarArgs.AZs.clear();
    AppMethodBeat.o(79802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */