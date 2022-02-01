package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.protocal.protobuf.ebg;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "Factory", "plugin-webview_release"})
public abstract interface ai
{
  public abstract String gVH();
  
  public abstract b gVI();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory;", "", "()V", "wrap", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "resp", "Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeConfirmResp;", "Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;", "plugin-webview_release"})
  public static final class a
  {
    public static final a PVo;
    
    static
    {
      AppMethodBeat.i(266333);
      PVo = new a();
      AppMethodBeat.o(266333);
    }
    
    public static final ai a(ebe paramebe)
    {
      AppMethodBeat.i(266331);
      p.k(paramebe, "resp");
      paramebe = (ai)new a(paramebe);
      AppMethodBeat.o(266331);
      return paramebe;
    }
    
    public static final ai a(ebg paramebg)
    {
      AppMethodBeat.i(266332);
      p.k(paramebg, "resp");
      paramebg = (ai)new b(paramebg);
      AppMethodBeat.o(266332);
      return paramebg;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory$wrap$1", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "plugin-webview_release"})
    public static final class a
      implements ai
    {
      a(ebe paramebe) {}
      
      public final String gVH()
      {
        return this.PVp.SjB;
      }
      
      public final b gVI()
      {
        return this.PVp.Ugg;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory$wrap$2", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "plugin-webview_release"})
    public static final class b
      implements ai
    {
      b(ebg paramebg) {}
      
      public final String gVH()
      {
        return this.PVq.SjB;
      }
      
      public final b gVI()
      {
        return this.PVq.Ugg;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ai
 * JD-Core Version:    0.7.0.1
 */