package com.tencent.mm.plugin.websearch.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.protocal.protobuf.ghg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchData;", "T", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/app/IAppForegroundListener;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;)V", "TAG", "", "getUiComponent", "()Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "setUiComponent", "destroy", "", "getWebViewId", "", "onAppBackground", "activity", "onAppForeground", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "querySearchWeb", "paramsStr", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a<T>
  implements com.tencent.mm.am.h, q
{
  private final String TAG;
  public f<T> WrK;
  
  public a(f<T> paramf)
  {
    AppMethodBeat.i(315260);
    this.WrK = paramf;
    this.TAG = "MicroMsg.WebSearch.BaseWebSearchData";
    com.tencent.mm.kernel.h.aZW().a(2975, (com.tencent.mm.am.h)this);
    AppForegroundDelegate.heY.a((q)this);
    AppMethodBeat.o(315260);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(315265);
    com.tencent.mm.kernel.h.aZW().b(2975, (com.tencent.mm.am.h)this);
    AppForegroundDelegate.heY.b((q)this);
    AppMethodBeat.o(315265);
  }
  
  public final int ipD()
  {
    AppMethodBeat.i(315280);
    Object localObject = this.WrK;
    if (localObject == null)
    {
      AppMethodBeat.o(315280);
      return -1;
    }
    localObject = ((f)localObject).getWebView();
    if (localObject == null)
    {
      AppMethodBeat.o(315280);
      return -1;
    }
    int i = ((WebSearchWebView)localObject).hashCode();
    AppMethodBeat.o(315280);
    return i;
  }
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(315292);
    Log.i(this.TAG, kotlin.g.b.s.X("onAppBackground ", paramString));
    Object localObject = this.WrK;
    if (localObject != null)
    {
      localObject = ((f)localObject).fyU();
      if (localObject != null) {
        ((b)localObject).biJ(paramString);
      }
    }
    AppMethodBeat.o(315292);
  }
  
  public void onAppForeground(String paramString)
  {
    AppMethodBeat.i(315287);
    Log.i(this.TAG, kotlin.g.b.s.X("onAppForeground ", paramString));
    Object localObject = this.WrK;
    if (localObject != null)
    {
      localObject = ((f)localObject).fyU();
      if (localObject != null) {
        ((b)localObject).biI(paramString);
      }
    }
    AppMethodBeat.o(315287);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(315273);
    ghg localghg;
    if (((paramp instanceof x)) && (((x)paramp).hVk == ipD()))
    {
      localghg = ((x)paramp).hMP();
      if (localghg != null) {
        break label107;
      }
      paramString = null;
    }
    for (;;)
    {
      if (paramString == null)
      {
        paramString = ((a)this).WrK;
        if (paramString != null)
        {
          paramString = paramString.fyU();
          if (paramString != null)
          {
            paramp = ((x)paramp).hOG;
            kotlin.g.b.s.s(paramp, "scene.requestId");
            paramString.h(-1, "", "", paramp);
          }
        }
      }
      AppMethodBeat.o(315273);
      return;
      label107:
      Object localObject = this.WrK;
      if (localObject == null)
      {
        paramString = null;
      }
      else
      {
        b localb = ((f)localObject).fyU();
        if (localb == null)
        {
          paramString = null;
        }
        else
        {
          localObject = paramString;
          if (paramString == null) {
            localObject = "";
          }
          String str = localghg.acds;
          paramString = str;
          if (str == null) {
            paramString = "";
          }
          str = localghg.hOG;
          kotlin.g.b.s.s(str, "it.requestId");
          paramString = localb.h(paramInt2, (String)localObject, paramString, str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.a
 * JD-Core Version:    0.7.0.1
 */