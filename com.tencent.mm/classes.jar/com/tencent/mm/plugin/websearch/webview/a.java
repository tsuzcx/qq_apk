package com.tencent.mm.plugin.websearch.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.fab;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchData;", "T", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;)V", "getUiComponent", "()Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "setUiComponent", "destroy", "", "getWebViewId", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "querySearchWeb", "paramsStr", "ui-websearch_release"})
public class a<T>
  implements i
{
  public d<T> IHe;
  
  public a(d<T> paramd)
  {
    AppMethodBeat.i(198044);
    this.IHe = paramd;
    g.azz().a(2975, (i)this);
    AppMethodBeat.o(198044);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(198041);
    g.azz().b(2975, (i)this);
    AppMethodBeat.o(198041);
  }
  
  public final int fXz()
  {
    AppMethodBeat.i(198043);
    Object localObject = this.IHe;
    if (localObject != null)
    {
      localObject = ((d)localObject).dQg();
      if (localObject != null)
      {
        int i = ((WebSearchWebView)localObject).hashCode();
        AppMethodBeat.o(198043);
        return i;
      }
    }
    AppMethodBeat.o(198043);
    return -1;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(198042);
    if (((paramq instanceof w)) && (((w)paramq).fXQ() == fXz()))
    {
      fab localfab = ((w)paramq).fxY();
      if (localfab != null)
      {
        Object localObject = this.IHe;
        if (localObject == null) {
          break label191;
        }
        b localb = ((d)localObject).dQj();
        if (localb == null) {
          break label191;
        }
        localObject = paramString;
        if (paramString == null) {
          localObject = "";
        }
        String str = localfab.NvZ;
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        str = localfab.dPI;
        p.g(str, "it.requestId");
        localb.h(paramInt2, (String)localObject, paramString, str);
      }
    }
    label191:
    for (paramString = x.SXb;; paramString = null)
    {
      if (paramString == null)
      {
        paramString = ((a)this).IHe;
        if (paramString != null)
        {
          paramString = paramString.dQj();
          if (paramString != null)
          {
            paramq = ((w)paramq).fXP();
            p.g(paramq, "scene.requestId");
            paramString.h(-1, "", "", paramq);
            paramString = x.SXb;
          }
        }
      }
      AppMethodBeat.o(198042);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.a
 * JD-Core Version:    0.7.0.1
 */