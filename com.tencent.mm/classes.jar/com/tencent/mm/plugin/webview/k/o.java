package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ad;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/util/WebViewKernelUtil;", "", "()V", "CHROME_KERNEL_NO_COMMIT_VERSION", "", "CHROME_PACKAGE_NAME", "", "SPLITER", "TAG", "systemKernelVersion", "currentKernelSupportPageCommitVisible", "", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "systemWebViewKernelVersion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final o Xtm;
  private static int Xtn;
  
  static
  {
    AppMethodBeat.i(295695);
    Xtm = new o();
    AppMethodBeat.o(295695);
  }
  
  public static int j(MMWebView paramMMWebView)
  {
    int k = 0;
    AppMethodBeat.i(295690);
    int i;
    if (Xtn > 0)
    {
      i = Xtn;
      AppMethodBeat.o(295690);
      return i;
    }
    Object localObject1 = MMApplicationContext.getContext().getPackageManager().getPackageInfo("com.google.android.webview", 0);
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = ((PackageInfo)localObject1).versionName;
        if (localObject1 == null)
        {
          i = 0;
          if (i <= 0) {
            break;
          }
          Xtn = i;
          AppMethodBeat.o(295690);
          return i;
        }
        localObject1 = ((String)localObject1).toLowerCase();
        s.s(localObject1, "(this as java.lang.String).toLowerCase()");
        if (localObject1 == null)
        {
          i = 0;
        }
        else
        {
          localObject1 = n.a((CharSequence)localObject1, new String[] { "." });
          if (localObject1 == null)
          {
            i = 0;
          }
          else
          {
            localObject1 = (String)((List)localObject1).get(0);
            if (localObject1 == null)
            {
              i = 0;
            }
            else
            {
              localObject1 = n.bJF((String)localObject1);
              if (localObject1 == null)
              {
                i = 0;
              }
              else
              {
                i = ((Integer)localObject1).intValue();
                continue;
                i = 0;
              }
            }
          }
        }
      }
      finally
      {
        Log.i("MicroMsg.WebViewKernelUtil", s.X("Get KernelVersion From PKG Error:", localObject2.getMessage()));
      }
    }
    int j;
    if (paramMMWebView == null) {
      j = k;
    }
    for (;;)
    {
      Xtn = j;
      AppMethodBeat.o(295690);
      return j;
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
            paramMMWebView = paramMMWebView.toLowerCase();
            s.s(paramMMWebView, "(this as java.lang.String).toLowerCase()");
            j = k;
            if (paramMMWebView != null)
            {
              paramMMWebView = n.a((CharSequence)paramMMWebView, new String[] { "chrome/" });
              j = k;
              if (paramMMWebView != null)
              {
                paramMMWebView = (String)paramMMWebView.get(1);
                j = k;
                if (paramMMWebView != null)
                {
                  paramMMWebView = n.a((CharSequence)paramMMWebView, new String[] { " " });
                  j = k;
                  if (paramMMWebView != null)
                  {
                    paramMMWebView = (String)paramMMWebView.get(0);
                    j = k;
                    if (paramMMWebView != null)
                    {
                      paramMMWebView = n.a((CharSequence)paramMMWebView, new String[] { "." });
                      j = k;
                      if (paramMMWebView != null)
                      {
                        paramMMWebView = (String)paramMMWebView.get(0);
                        j = k;
                        if (paramMMWebView != null)
                        {
                          paramMMWebView = n.bJF(paramMMWebView);
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
      finally
      {
        Log.i("MicroMsg.WebViewKernelUtil", s.X("Get KernelVersion From UA Error:", paramMMWebView.getMessage()));
        j = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.o
 * JD-Core Version:    0.7.0.1
 */