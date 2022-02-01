package com.tencent.mm.plugin.teenmode.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.protocal.protobuf.el;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/NetSceneAgreeAuthorization;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/AgreeTeenagerModeAuthorizationResp;", "wardUserName", "", "businessType", "", "businessKey", "msgSvrId", "", "(Ljava/lang/String;ILjava/lang/String;J)V", "req", "Lcom/tencent/mm/protocal/protobuf/AgreeTeenagerModeAuthorizationReq;", "getReq", "()Lcom/tencent/mm/protocal/protobuf/AgreeTeenagerModeAuthorizationReq;", "req$delegate", "Lkotlin/Lazy;", "Companion", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b<el>
{
  public static final a SYH;
  private final j SYI;
  
  static
  {
    AppMethodBeat.i(278873);
    SYH = new a((byte)0);
    AppMethodBeat.o(278873);
  }
  
  public d(String paramString1, final int paramInt, final String paramString2, final long paramLong)
  {
    AppMethodBeat.i(278869);
    this.SYI = k.cm((kotlin.g.a.a)new b(paramString1, paramInt, paramString2, paramLong));
    paramString1 = new c.a();
    paramString1.otE = ((com.tencent.mm.bx.a)this.SYI.getValue());
    paramString1.otF = ((com.tencent.mm.bx.a)new el());
    paramString1.uri = "/cgi-bin/micromsg-bin/agreeteenagermodeauthorization";
    paramString1.funcId = 6216;
    c(paramString1.bEF());
    AppMethodBeat.o(278869);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/NetSceneAgreeAuthorization$Companion;", "", "()V", "TAG", "", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/AgreeTeenagerModeAuthorizationReq;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ek>
  {
    b(String paramString1, int paramInt, String paramString2, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.d
 * JD-Core Version:    0.7.0.1
 */