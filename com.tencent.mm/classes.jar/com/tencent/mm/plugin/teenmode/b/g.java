package com.tencent.mm.plugin.teenmode.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.protocal.protobuf.ctk;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/NetScenePreBindGuardian;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetTeenagerModePreBindGuardianInfoResp;", "guardianUserName", "", "(Ljava/lang/String;)V", "req", "Lcom/tencent/mm/protocal/protobuf/GetTeenagerModePreBindGuardianInfoReq;", "getReq", "()Lcom/tencent/mm/protocal/protobuf/GetTeenagerModePreBindGuardianInfoReq;", "req$delegate", "Lkotlin/Lazy;", "Companion", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends b<ctk>
{
  public static final a SYP;
  private final j SYI;
  
  static
  {
    AppMethodBeat.i(278866);
    SYP = new a((byte)0);
    AppMethodBeat.o(278866);
  }
  
  public g(String paramString)
  {
    AppMethodBeat.i(278860);
    this.SYI = k.cm((kotlin.g.a.a)new b(paramString));
    paramString = new c.a();
    paramString.otE = ((com.tencent.mm.bx.a)this.SYI.getValue());
    paramString.otF = ((com.tencent.mm.bx.a)new ctk());
    paramString.uri = "/cgi-bin/micromsg-bin/getteenagermodeprebindguardianinfo";
    paramString.funcId = 6232;
    c(paramString.bEF());
    AppMethodBeat.o(278860);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/NetScenePreBindGuardian$Companion;", "", "()V", "TAG", "", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/GetTeenagerModePreBindGuardianInfoReq;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ctj>
  {
    b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.g
 * JD-Core Version:    0.7.0.1
 */