package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.fru;
import com.tencent.mm.protocal.protobuf.frv;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/OpenIMArchiveComponent$NetSceneUpdateArchiveStatus;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateOpenIMArchiveStatusResp;", "userName", "", "url", "status", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "req", "Lcom/tencent/mm/protocal/protobuf/UpdateOpenIMArchiveStatusReq;", "getReq", "()Lcom/tencent/mm/protocal/protobuf/UpdateOpenIMArchiveStatusReq;", "req$delegate", "Lkotlin/Lazy;", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OpenIMArchiveComponent$c
  extends b<frv>
{
  public static final a aevv;
  private final j SYI;
  
  static
  {
    AppMethodBeat.i(256161);
    aevv = new a((byte)0);
    AppMethodBeat.o(256161);
  }
  
  public OpenIMArchiveComponent$c(final String paramString1, final String paramString2, int paramInt)
  {
    AppMethodBeat.i(256155);
    this.SYI = k.cm((kotlin.g.a.a)new b(paramInt, paramString1, paramString2));
    paramString1 = new c.a();
    paramString1.otE = ((com.tencent.mm.bx.a)this.SYI.getValue());
    paramString1.otF = ((com.tencent.mm.bx.a)new frv());
    paramString1.uri = "/cgi-bin/micromsg-bin/updateopenimarchivestatus";
    paramString1.funcId = 6924;
    c(paramString1.bEF());
    AppMethodBeat.o(256155);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/OpenIMArchiveComponent$NetSceneUpdateArchiveStatus$Companion;", "", "()V", "TAG", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/UpdateOpenIMArchiveStatusReq;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<fru>
  {
    b(int paramInt, String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.OpenIMArchiveComponent.c
 * JD-Core Version:    0.7.0.1
 */