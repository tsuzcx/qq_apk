package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.model.ay.h;
import com.tencent.mm.plugin.webview.model.ay.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
    Object localObject = eVw().Eae.eUt();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = eVw().Eae.eUt();
      if ((paramVarArgs.Eni == null) || (paramVarArgs.Eni.size() == 0)) {
        AppMethodBeat.o(79800);
      }
    }
    else
    {
      if (((ay.i)localObject).Eni == null) {
        ((ay.i)localObject).Eni = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < paramVarArgs.length)
        {
          ae.i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", new Object[] { paramVarArgs[i] });
          ((ay.i)localObject).Eni.add(paramVarArgs[i]);
          i += 1;
        }
        break;
        ((ay.i)localObject).Eni.clear();
      }
    }
    localObject = g.yxI;
    g.m(12033, paramVarArgs.Eni);
    paramVarArgs.Eni.clear();
    AppMethodBeat.o(79800);
  }
  
  public final void idKeyReport(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(79801);
    ae.i("MicroMsg.WebViewUI.UtilsImpl", "idkey report, id = %s, key = %s, value = %s", new Object[] { paramString1, paramString2, paramString3 });
    if ((!bu.isNullOrNil(paramString1)) && (!bu.isNullOrNil(paramString2)) && (!bu.isNullOrNil(paramString3)))
    {
      int i = bu.getInt(paramString1, 0);
      int j = bu.getInt(paramString2, 0);
      int k = bu.getInt(paramString3, 0);
      g.yxI.idkeyStat(i, j, k, false);
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
      ae.d(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      ae.e(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      ae.i(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      ae.v(paramString1, paramString2);
      AppMethodBeat.o(79799);
      return;
      ae.w(paramString1, paramString2);
    }
  }
  
  public final void kvReport(String... paramVarArgs)
  {
    AppMethodBeat.i(79802);
    Object localObject = eVw().Eae.eUu();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = eVw().Eae.eUu();
      if ((paramVarArgs.Eni == null) || (paramVarArgs.Eni.size() == 0)) {
        AppMethodBeat.o(79802);
      }
    }
    else
    {
      if (((ay.h)localObject).Eni == null) {
        ((ay.h)localObject).Eni = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < paramVarArgs.length)
        {
          ae.i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", new Object[] { paramVarArgs[i] });
          ((ay.h)localObject).Eni.add(paramVarArgs[i]);
          i += 1;
        }
        break;
        ((ay.h)localObject).Eni.clear();
      }
    }
    localObject = g.yxI;
    g.m(12666, paramVarArgs.Eni);
    paramVarArgs.Eni.clear();
    AppMethodBeat.o(79802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */