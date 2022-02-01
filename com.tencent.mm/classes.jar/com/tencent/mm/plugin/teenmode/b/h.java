package com.tencent.mm.plugin.teenmode.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.fqz;
import com.tencent.mm.protocal.protobuf.fra;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/NetSceneUnbindGuardian;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UnbindTeenagerModeGuardianResp;", "guardianUserName", "", "(Ljava/lang/String;)V", "req", "Lcom/tencent/mm/protocal/protobuf/UnbindTeenagerModeGuardianReq;", "getReq", "()Lcom/tencent/mm/protocal/protobuf/UnbindTeenagerModeGuardianReq;", "req$delegate", "Lkotlin/Lazy;", "Companion", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends b<fra>
{
  public static final a SYR;
  private final j SYI;
  
  static
  {
    AppMethodBeat.i(278876);
    SYR = new a((byte)0);
    AppMethodBeat.o(278876);
  }
  
  public h(String paramString)
  {
    AppMethodBeat.i(278872);
    this.SYI = k.cm((kotlin.g.a.a)new b(paramString));
    paramString = new c.a();
    paramString.otE = ((com.tencent.mm.bx.a)this.SYI.getValue());
    paramString.otF = ((com.tencent.mm.bx.a)new fra());
    paramString.uri = "/cgi-bin/micromsg-bin/unbindteenagermodeguardian";
    paramString.funcId = 5848;
    c(paramString.bEF());
    AppMethodBeat.o(278872);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/NetSceneUnbindGuardian$Companion;", "", "()V", "TAG", "", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/UnbindTeenagerModeGuardianReq;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<fqz>
  {
    b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.h
 * JD-Core Version:    0.7.0.1
 */