package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.model.ay.h;
import com.tencent.mm.plugin.webview.model.ay.i;
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
    Object localObject = eRK().DIg.eQH();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = eRK().DIg.eQH();
      if ((paramVarArgs.DVj == null) || (paramVarArgs.DVj.size() == 0)) {
        AppMethodBeat.o(79800);
      }
    }
    else
    {
      if (((ay.i)localObject).DVj == null) {
        ((ay.i)localObject).DVj = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < paramVarArgs.length)
        {
          ad.i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", new Object[] { paramVarArgs[i] });
          ((ay.i)localObject).DVj.add(paramVarArgs[i]);
          i += 1;
        }
        break;
        ((ay.i)localObject).DVj.clear();
      }
    }
    localObject = g.yhR;
    g.l(12033, paramVarArgs.DVj);
    paramVarArgs.DVj.clear();
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
      g.yhR.idkeyStat(i, j, k, false);
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
    Object localObject = eRK().DIg.eQI();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = eRK().DIg.eQI();
      if ((paramVarArgs.DVj == null) || (paramVarArgs.DVj.size() == 0)) {
        AppMethodBeat.o(79802);
      }
    }
    else
    {
      if (((ay.h)localObject).DVj == null) {
        ((ay.h)localObject).DVj = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < paramVarArgs.length)
        {
          ad.i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", new Object[] { paramVarArgs[i] });
          ((ay.h)localObject).DVj.add(paramVarArgs[i]);
          i += 1;
        }
        break;
        ((ay.h)localObject).DVj.clear();
      }
    }
    localObject = g.yhR;
    g.l(12666, paramVarArgs.DVj);
    paramVarArgs.DVj.clear();
    AppMethodBeat.o(79802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */