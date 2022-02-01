package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.euv;
import com.tencent.mm.protocal.protobuf.eux;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "Factory", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ai
{
  public abstract String ivp();
  
  public abstract b ivq();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory;", "", "()V", "wrap", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "resp", "Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeConfirmResp;", "Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a WLV;
    
    static
    {
      AppMethodBeat.i(298391);
      WLV = new a();
      AppMethodBeat.o(298391);
    }
    
    public static final ai a(euv parameuv)
    {
      AppMethodBeat.i(298381);
      s.u(parameuv, "resp");
      parameuv = (ai)new a(parameuv);
      AppMethodBeat.o(298381);
      return parameuv;
    }
    
    public static final ai a(eux parameux)
    {
      AppMethodBeat.i(298385);
      s.u(parameux, "resp");
      parameux = (ai)new b(parameux);
      AppMethodBeat.o(298385);
      return parameux;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory$wrap$1", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements ai
    {
      a(euv parameuv) {}
      
      public final String ivp()
      {
        return this.WLW.ZhF;
      }
      
      public final b ivq()
      {
        return this.WLW.abxG;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory$wrap$2", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements ai
    {
      b(eux parameux) {}
      
      public final String ivp()
      {
        return this.WLX.ZhF;
      }
      
      public final b ivq()
      {
        return this.WLX.abxG;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ai
 * JD-Core Version:    0.7.0.1
 */