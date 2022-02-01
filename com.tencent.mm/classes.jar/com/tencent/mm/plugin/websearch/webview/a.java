package com.tencent.mm.plugin.websearch.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.fks;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchData;", "T", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;)V", "getUiComponent", "()Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "setUiComponent", "destroy", "", "getWebViewId", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "querySearchWeb", "paramsStr", "ui-websearch_release"})
public class a<T>
  implements i
{
  public d<T> PBs;
  
  public a(d<T> paramd)
  {
    AppMethodBeat.i(198518);
    this.PBs = paramd;
    h.aGY().a(2975, (i)this);
    AppMethodBeat.o(198518);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(198510);
    h.aGY().b(2975, (i)this);
    AppMethodBeat.o(198510);
  }
  
  public final int gQm()
  {
    AppMethodBeat.i(198517);
    Object localObject = this.PBs;
    if (localObject != null)
    {
      localObject = ((d)localObject).esG();
      if (localObject != null)
      {
        int i = ((WebSearchWebView)localObject).hashCode();
        AppMethodBeat.o(198517);
        return i;
      }
    }
    AppMethodBeat.o(198517);
    return -1;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(198516);
    if (((paramq instanceof w)) && (((w)paramq).gQB() == gQm()))
    {
      fks localfks = ((w)paramq).gpT();
      if (localfks != null)
      {
        Object localObject = this.PBs;
        if (localObject == null) {
          break label191;
        }
        b localb = ((d)localObject).esJ();
        if (localb == null) {
          break label191;
        }
        localObject = paramString;
        if (paramString == null) {
          localObject = "";
        }
        String str = localfks.UJk;
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        str = localfks.fIY;
        p.j(str, "it.requestId");
        localb.h(paramInt2, (String)localObject, paramString, str);
      }
    }
    label191:
    for (paramString = x.aazN;; paramString = null)
    {
      if (paramString == null)
      {
        paramString = ((a)this).PBs;
        if (paramString != null)
        {
          paramString = paramString.esJ();
          if (paramString != null)
          {
            paramq = ((w)paramq).gQA();
            p.j(paramq, "scene.requestId");
            paramString.h(-1, "", "", paramq);
            paramString = x.aazN;
          }
        }
      }
      AppMethodBeat.o(198516);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.a
 * JD-Core Version:    0.7.0.1
 */