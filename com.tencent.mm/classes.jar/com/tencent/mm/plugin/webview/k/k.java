package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.aa;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/util/WebViewKernelUtil;", "", "()V", "CHROME_KERNEL_NO_COMMIT_VERSION", "", "CHROME_PACKAGE_NAME", "", "SPLITER", "TAG", "systemKernelVersion", "currentKernelSupportPageCommitVisible", "", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "systemWebViewKernelVersion", "webview-sdk_release"})
public final class k
{
  private static int QAf;
  public static final k QAg;
  
  static
  {
    AppMethodBeat.i(207285);
    QAg = new k();
    AppMethodBeat.o(207285);
  }
  
  public static int g(MMWebView paramMMWebView)
  {
    int k = 0;
    AppMethodBeat.i(207283);
    int i;
    if (QAf > 0)
    {
      i = QAf;
      AppMethodBeat.o(207283);
      return i;
    }
    Object localObject1 = MMApplicationContext.getContext();
    p.j(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getPackageManager().getPackageInfo("com.google.android.webview", 0);
    if (localObject1 != null) {
      try
      {
        localObject1 = ((PackageInfo)localObject1).versionName;
        if (localObject1 != null) {
          if (localObject1 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(207283);
            throw ((Throwable)localObject1);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Log.i("MicroMsg.WebViewKernelUtil", "Get KernelVersion From PKG Error:" + localThrowable.getMessage());
        i = 0;
      }
    }
    while (i > 0)
    {
      QAf = i;
      AppMethodBeat.o(207283);
      return i;
      Object localObject2 = localThrowable.toLowerCase();
      p.j(localObject2, "(this as java.lang.String).toLowerCase()");
      if (localObject2 != null)
      {
        localObject2 = n.a((CharSequence)localObject2, new String[] { "." });
        if (localObject2 != null)
        {
          localObject2 = (String)((List)localObject2).get(0);
          if (localObject2 != null)
          {
            localObject2 = n.bHC((String)localObject2);
            if (localObject2 == null) {}
          }
        }
      }
      for (i = ((Integer)localObject2).intValue();; i = 0) {
        break;
      }
      i = 0;
    }
    int j = k;
    if (paramMMWebView != null) {
      try
      {
        paramMMWebView = paramMMWebView.getSettings();
        j = k;
        if (paramMMWebView != null)
        {
          paramMMWebView = paramMMWebView.getUserAgentString();
          j = k;
          if (paramMMWebView != null)
          {
            if (paramMMWebView != null) {
              break label313;
            }
            paramMMWebView = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(207283);
            throw paramMMWebView;
          }
        }
      }
      catch (Throwable paramMMWebView)
      {
        Log.i("MicroMsg.WebViewKernelUtil", "Get KernelVersion From UA Error:" + paramMMWebView.getMessage());
        j = i;
      }
    }
    for (;;)
    {
      QAf = j;
      AppMethodBeat.o(207283);
      return j;
      label313:
      paramMMWebView = paramMMWebView.toLowerCase();
      p.j(paramMMWebView, "(this as java.lang.String).toLowerCase()");
      j = k;
      if (paramMMWebView != null)
      {
        paramMMWebView = n.b((CharSequence)paramMMWebView, new String[] { "chrome/" });
        j = k;
        if (paramMMWebView != null)
        {
          paramMMWebView = (String)paramMMWebView.get(1);
          j = k;
          if (paramMMWebView != null)
          {
            paramMMWebView = n.b((CharSequence)paramMMWebView, new String[] { " " });
            j = k;
            if (paramMMWebView != null)
            {
              paramMMWebView = (String)paramMMWebView.get(0);
              j = k;
              if (paramMMWebView != null)
              {
                paramMMWebView = n.b((CharSequence)paramMMWebView, new String[] { "." });
                j = k;
                if (paramMMWebView != null)
                {
                  paramMMWebView = (String)paramMMWebView.get(0);
                  j = k;
                  if (paramMMWebView != null)
                  {
                    paramMMWebView = n.bHC(paramMMWebView);
                    j = k;
                    if (paramMMWebView != null) {
                      j = paramMMWebView.intValue();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.k
 * JD-Core Version:    0.7.0.1
 */