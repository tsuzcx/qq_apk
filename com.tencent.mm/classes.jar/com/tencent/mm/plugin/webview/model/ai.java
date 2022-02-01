package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.protocal.protobuf.drk;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "Factory", "plugin-webview_release"})
public abstract interface ai
{
  public abstract String gcK();
  
  public abstract b gcL();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory;", "", "()V", "wrap", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "resp", "Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeConfirmResp;", "Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;", "plugin-webview_release"})
  public static final class a
  {
    public static final a IYW;
    
    static
    {
      AppMethodBeat.i(210350);
      IYW = new a();
      AppMethodBeat.o(210350);
    }
    
    public static final ai a(dri paramdri)
    {
      AppMethodBeat.i(210348);
      p.h(paramdri, "resp");
      paramdri = (ai)new a(paramdri);
      AppMethodBeat.o(210348);
      return paramdri;
    }
    
    public static final ai a(drk paramdrk)
    {
      AppMethodBeat.i(210349);
      p.h(paramdrk, "resp");
      paramdrk = (ai)new b(paramdrk);
      AppMethodBeat.o(210349);
      return paramdrk;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory$wrap$1", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "plugin-webview_release"})
    public static final class a
      implements ai
    {
      a(dri paramdri) {}
      
      public final String gcK()
      {
        return this.IYX.KJw;
      }
      
      public final b gcL()
      {
        return this.IYX.MTX;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory$wrap$2", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "plugin-webview_release"})
    public static final class b
      implements ai
    {
      b(drk paramdrk) {}
      
      public final String gcK()
      {
        return this.IYY.KJw;
      }
      
      public final b gcL()
      {
        return this.IYY.MTX;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ai
 * JD-Core Version:    0.7.0.1
 */