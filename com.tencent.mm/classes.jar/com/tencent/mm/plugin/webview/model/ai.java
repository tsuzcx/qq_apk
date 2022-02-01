package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.cxt;
import com.tencent.mm.protocal.protobuf.cxv;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "Factory", "plugin-webview_release"})
public abstract interface ai
{
  public abstract String eQl();
  
  public abstract b eQm();
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory;", "", "()V", "wrap", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "resp", "Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeConfirmResp;", "Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;", "plugin-webview_release"})
  public static final class a
  {
    public static final a DTW;
    
    static
    {
      AppMethodBeat.i(207584);
      DTW = new a();
      AppMethodBeat.o(207584);
    }
    
    public static final ai a(cxt paramcxt)
    {
      AppMethodBeat.i(207582);
      p.h(paramcxt, "resp");
      paramcxt = (ai)new a(paramcxt);
      AppMethodBeat.o(207582);
      return paramcxt;
    }
    
    public static final ai a(cxv paramcxv)
    {
      AppMethodBeat.i(207583);
      p.h(paramcxv, "resp");
      paramcxv = (ai)new b(paramcxv);
      AppMethodBeat.o(207583);
      return paramcxv;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory$wrap$1", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "plugin-webview_release"})
    public static final class a
      implements ai
    {
      a(cxt paramcxt) {}
      
      public final String eQl()
      {
        return this.DTX.Fxq;
      }
      
      public final b eQm()
      {
        return this.DTX.Hpi;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory$wrap$2", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "plugin-webview_release"})
    public static final class b
      implements ai
    {
      b(cxv paramcxv) {}
      
      public final String eQl()
      {
        return this.DTY.Fxq;
      }
      
      public final b eQm()
      {
        return this.DTY.Hpi;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ai
 * JD-Core Version:    0.7.0.1
 */