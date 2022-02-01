package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.cyp;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "Factory", "plugin-webview_release"})
public abstract interface ai
{
  public abstract String eTX();
  
  public abstract b eTY();
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory;", "", "()V", "wrap", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "resp", "Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeConfirmResp;", "Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;", "plugin-webview_release"})
  public static final class a
  {
    public static final a ElW;
    
    static
    {
      AppMethodBeat.i(199340);
      ElW = new a();
      AppMethodBeat.o(199340);
    }
    
    public static final ai a(cyn paramcyn)
    {
      AppMethodBeat.i(199338);
      p.h(paramcyn, "resp");
      paramcyn = (ai)new a(paramcyn);
      AppMethodBeat.o(199338);
      return paramcyn;
    }
    
    public static final ai a(cyp paramcyp)
    {
      AppMethodBeat.i(199339);
      p.h(paramcyp, "resp");
      paramcyp = (ai)new b(paramcyp);
      AppMethodBeat.o(199339);
      return paramcyp;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory$wrap$1", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "plugin-webview_release"})
    public static final class a
      implements ai
    {
      a(cyn paramcyn) {}
      
      public final String eTX()
      {
        return this.ElX.FPO;
      }
      
      public final b eTY()
      {
        return this.ElX.HIK;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory$wrap$2", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "plugin-webview_release"})
    public static final class b
      implements ai
    {
      b(cyp paramcyp) {}
      
      public final String eTX()
      {
        return this.ElY.FPO;
      }
      
      public final b eTY()
      {
        return this.ElY.HIK;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ai
 * JD-Core Version:    0.7.0.1
 */