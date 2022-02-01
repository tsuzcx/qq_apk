package com.tencent.mm.plugin.teenmode.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.protocal.protobuf.nd;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/NetSceneBindGuardian;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BindTeenagerModeGuardianResp;", "wardUserName", "", "ticket", "(Ljava/lang/String;Ljava/lang/String;)V", "req", "Lcom/tencent/mm/protocal/protobuf/BindTeenagerModeGuardianReq;", "getReq", "()Lcom/tencent/mm/protocal/protobuf/BindTeenagerModeGuardianReq;", "req$delegate", "Lkotlin/Lazy;", "Companion", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends b<nd>
{
  public static final a SYN;
  private final j SYI;
  
  static
  {
    AppMethodBeat.i(278871);
    SYN = new a((byte)0);
    AppMethodBeat.o(278871);
  }
  
  public e(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(278868);
    this.SYI = k.cm((kotlin.g.a.a)new b(paramString1, paramString2));
    paramString1 = new c.a();
    paramString1.otE = ((com.tencent.mm.bx.a)this.SYI.getValue());
    paramString1.otF = ((com.tencent.mm.bx.a)new nd());
    paramString1.uri = "/cgi-bin/micromsg-bin/bindteenagermodeguardian";
    paramString1.funcId = 4225;
    c(paramString1.bEF());
    AppMethodBeat.o(278868);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/NetSceneBindGuardian$Companion;", "", "()V", "TAG", "", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/BindTeenagerModeGuardianReq;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<nc>
  {
    b(String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.e
 * JD-Core Version:    0.7.0.1
 */