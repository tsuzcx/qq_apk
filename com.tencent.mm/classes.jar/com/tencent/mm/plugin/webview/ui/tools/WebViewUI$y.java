package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.an.i;
import com.tencent.mm.plugin.webview.model.an.j;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qqvideo.proxy.api.IUtils;
import java.util.ArrayList;
import java.util.List;

final class WebViewUI$y
  implements IUtils
{
  private WebViewUI$y(WebViewUI paramWebViewUI) {}
  
  public final void httpproxyReport(String... paramVarArgs)
  {
    Object localObject = this.rpH.rfg.ccn();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = this.rpH.rfg.ccn();
      localObject = this.rpH.gGn;
      if ((paramVarArgs.rgI != null) && (paramVarArgs.rgI.size() != 0) && (localObject != null)) {}
    }
    else
    {
      if (((an.j)localObject).rgI == null) {
        ((an.j)localObject).rgI = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < paramVarArgs.length)
        {
          y.i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", new Object[] { paramVarArgs[i] });
          ((an.j)localObject).rgI.add(paramVarArgs[i]);
          i += 1;
        }
        break;
        ((an.j)localObject).rgI.clear();
      }
    }
    e.a((d)localObject, 12033, paramVarArgs.rgI);
    paramVarArgs.rgI.clear();
  }
  
  public final void idKeyReport(String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.WebViewUI", "idkey report, id = %s, key = %s, value = %s", new Object[] { paramString1, paramString2, paramString3 });
    if ((!bk.bl(paramString1)) && (!bk.bl(paramString2)) && (!bk.bl(paramString3)))
    {
      int i = bk.getInt(paramString1, 0);
      int j = bk.getInt(paramString2, 0);
      int k = bk.getInt(paramString3, 0);
      h.nFQ.a(i, j, k, false);
    }
  }
  
  public final void javaUtilLog(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      y.d(paramString1, paramString2);
      return;
    case 6: 
      y.e(paramString1, paramString2);
      return;
    case 4: 
      y.i(paramString1, paramString2);
      return;
    case 2: 
      y.v(paramString1, paramString2);
      return;
    }
    y.w(paramString1, paramString2);
  }
  
  public final void kvReport(String... paramVarArgs)
  {
    Object localObject = this.rpH.rfg.cco();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      paramVarArgs = this.rpH.rfg.cco();
      localObject = this.rpH.gGn;
      if ((paramVarArgs.rgI != null) && (paramVarArgs.rgI.size() != 0) && (localObject != null)) {}
    }
    else
    {
      if (((an.i)localObject).rgI == null) {
        ((an.i)localObject).rgI = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < paramVarArgs.length)
        {
          y.i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", new Object[] { paramVarArgs[i] });
          ((an.i)localObject).rgI.add(paramVarArgs[i]);
          i += 1;
        }
        break;
        ((an.i)localObject).rgI.clear();
      }
    }
    e.a((d)localObject, 12666, paramVarArgs.rgI);
    paramVarArgs.rgI.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.y
 * JD-Core Version:    0.7.0.1
 */