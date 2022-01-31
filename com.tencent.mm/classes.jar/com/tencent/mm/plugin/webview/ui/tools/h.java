package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.plugin.webview.model.as.j;
import com.tencent.mm.plugin.webview.model.as.k;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(7589);
    Object localObject = ddt().uVh.dcq();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = ddt().uVh.dcq();
      localObject = ddt().igU;
      if ((paramVarArgs.uWW == null) || (paramVarArgs.uWW.size() == 0) || (localObject == null)) {
        AppMethodBeat.o(7589);
      }
    }
    else
    {
      if (((as.k)localObject).uWW == null) {
        ((as.k)localObject).uWW = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < paramVarArgs.length)
        {
          ab.i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", new Object[] { paramVarArgs[i] });
          ((as.k)localObject).uWW.add(paramVarArgs[i]);
          i += 1;
        }
        break;
        ((as.k)localObject).uWW.clear();
      }
    }
    g.a((d)localObject, 12033, paramVarArgs.uWW);
    paramVarArgs.uWW.clear();
    AppMethodBeat.o(7589);
  }
  
  public final void idKeyReport(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(7590);
    ab.i("MicroMsg.WebViewUI.UtilsImpl", "idkey report, id = %s, key = %s, value = %s", new Object[] { paramString1, paramString2, paramString3 });
    if ((!bo.isNullOrNil(paramString1)) && (!bo.isNullOrNil(paramString2)) && (!bo.isNullOrNil(paramString3)))
    {
      int i = bo.getInt(paramString1, 0);
      int j = bo.getInt(paramString2, 0);
      int k = bo.getInt(paramString3, 0);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(i, j, k, false);
    }
    AppMethodBeat.o(7590);
  }
  
  public final void javaUtilLog(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(7588);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(7588);
      return;
      ab.d(paramString1, paramString2);
      AppMethodBeat.o(7588);
      return;
      ab.e(paramString1, paramString2);
      AppMethodBeat.o(7588);
      return;
      ab.i(paramString1, paramString2);
      AppMethodBeat.o(7588);
      return;
      ab.v(paramString1, paramString2);
      AppMethodBeat.o(7588);
      return;
      ab.w(paramString1, paramString2);
    }
  }
  
  public final void kvReport(String... paramVarArgs)
  {
    AppMethodBeat.i(7591);
    Object localObject = ddt().uVh.dcr();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = ddt().uVh.dcr();
      localObject = ddt().igU;
      if ((paramVarArgs.uWW == null) || (paramVarArgs.uWW.size() == 0) || (localObject == null)) {
        AppMethodBeat.o(7591);
      }
    }
    else
    {
      if (((as.j)localObject).uWW == null) {
        ((as.j)localObject).uWW = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < paramVarArgs.length)
        {
          ab.i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", new Object[] { paramVarArgs[i] });
          ((as.j)localObject).uWW.add(paramVarArgs[i]);
          i += 1;
        }
        break;
        ((as.j)localObject).uWW.clear();
      }
    }
    g.a((d)localObject, 12666, paramVarArgs.uWW);
    paramVarArgs.uWW.clear();
    AppMethodBeat.o(7591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */