package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.core.l;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.ui.widget.pulldown.NestedBounceView;
import com.tencent.xweb.WebView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "halfScreenWebView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView;", "(Ljava/lang/ref/WeakReference;)V", "clientListener", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewInterceptor$HalfScreenWebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewInterceptor$HalfScreenWebViewClientListener;", "controllerListener", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewInterceptor$HalfScreenWebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewInterceptor$HalfScreenWebViewControllerListener;", "getHalfScreenWebView", "()Ljava/lang/ref/WeakReference;", "destroy", "", "HalfScreenWebViewClientListener", "HalfScreenWebViewControllerListener", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends m
{
  private final WeakReference<a> Xpn;
  final a Xpo;
  private final b Xpp;
  
  public b(WeakReference<a> paramWeakReference)
  {
    AppMethodBeat.i(298094);
    this.Xpn = paramWeakReference;
    this.Xpo = new a(this.Xpn);
    this.Xpp = new b(this.Xpn);
    AppMethodBeat.o(298094);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewInterceptor$HalfScreenWebViewClientListener;", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "halfScreenWebView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView;", "(Ljava/lang/ref/WeakReference;)V", "getHalfScreenWebView", "()Ljava/lang/ref/WeakReference;", "doUpdateVisitedHistory", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "isReload", "", "onPageCommitVisible", "onPageFinished", "onPageStarted", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends h
  {
    private final WeakReference<a> Xpn;
    
    public a(WeakReference<a> paramWeakReference)
    {
      AppMethodBeat.i(298117);
      this.Xpn = paramWeakReference;
      AppMethodBeat.o(298117);
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(298145);
      super.b(paramWebView, paramString);
      paramString = this.Xpn;
      if (paramString != null)
      {
        paramString = (a)paramString.get();
        if (paramString != null)
        {
          paramString.iyX();
          paramString.d(paramWebView);
        }
      }
      AppMethodBeat.o(298145);
    }
    
    public final void b(WebView paramWebView, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(298157);
      super.b(paramWebView, paramString, paramBoolean);
      paramString = this.Xpn;
      if (paramString != null)
      {
        paramString = (a)paramString.get();
        if (paramString != null) {
          paramString.d(paramWebView);
        }
      }
      AppMethodBeat.o(298157);
    }
    
    public final void e(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(298125);
      super.e(paramWebView, paramString);
      paramWebView = this.Xpn;
      if (paramWebView != null) {
        paramWebView.get();
      }
      AppMethodBeat.o(298125);
    }
    
    public final void h(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(298138);
      super.h(paramWebView, paramString);
      paramWebView = this.Xpn;
      if (paramWebView != null)
      {
        paramWebView = (a)paramWebView.get();
        if (paramWebView != null)
        {
          paramString = paramWebView.Xpb;
          if (paramString != null) {
            paramString.setBounce(true);
          }
          paramWebView.auS(paramWebView.iCb());
          paramWebView.atr(paramWebView.iCa());
        }
      }
      AppMethodBeat.o(298138);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebViewInterceptor$HalfScreenWebViewControllerListener;", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "halfScreenWebView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView;", "(Ljava/lang/ref/WeakReference;)V", "getHalfScreenWebView", "()Ljava/lang/ref/WeakReference;", "onAuthError", "", "reason", "", "reqUrl", "", "errType", "errCode", "errMsg", "onProgressBarEnd", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends l
  {
    private final WeakReference<a> Xpn;
    
    public b(WeakReference<a> paramWeakReference)
    {
      AppMethodBeat.i(298119);
      this.Xpn = paramWeakReference;
      AppMethodBeat.o(298119);
    }
    
    public final void b(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(298126);
      s.u(paramString1, "reqUrl");
      s.u(paramString2, "errMsg");
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(298126);
        return;
        paramString1 = this.Xpn;
        if (paramString1 != null)
        {
          paramString1 = (a)paramString1.get();
          if (paramString1 != null) {
            paramString1.iyW();
          }
        }
      }
    }
    
    public final void cxW()
    {
      AppMethodBeat.i(298134);
      super.cxW();
      Object localObject = this.Xpn;
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).iyX();
        }
      }
      AppMethodBeat.o(298134);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.b
 * JD-Core Version:    0.7.0.1
 */