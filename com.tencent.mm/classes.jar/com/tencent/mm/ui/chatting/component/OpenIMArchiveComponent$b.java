package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.coh;
import com.tencent.mm.protocal.protobuf.coi;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/OpenIMArchiveComponent$NetSceneGetArchiveInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetOpenIMArchivePopUpInfoResp;", "userName", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "req", "Lcom/tencent/mm/protocal/protobuf/GetOpenIMArchivePopUpInfoReq;", "getReq", "()Lcom/tencent/mm/protocal/protobuf/GetOpenIMArchivePopUpInfoReq;", "req$delegate", "Lkotlin/Lazy;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OpenIMArchiveComponent$b
  extends b<coi>
{
  public static final a aevu;
  private final j SYI;
  
  static
  {
    AppMethodBeat.i(256185);
    aevu = new a((byte)0);
    AppMethodBeat.o(256185);
  }
  
  public OpenIMArchiveComponent$b(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(256180);
    this.SYI = k.cm((kotlin.g.a.a)new b(paramString1, paramString2));
    paramString1 = new c.a();
    paramString1.otE = ((com.tencent.mm.bx.a)this.SYI.getValue());
    paramString1.otF = ((com.tencent.mm.bx.a)new coi());
    paramString1.uri = "/cgi-bin/micromsg-bin/getopenimarchivepopupinfo";
    paramString1.funcId = 6987;
    c(paramString1.bEF());
    AppMethodBeat.o(256180);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/OpenIMArchiveComponent$NetSceneGetArchiveInfo$Companion;", "", "()V", "TAG", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/GetOpenIMArchivePopUpInfoReq;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<coh>
  {
    b(String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.OpenIMArchiveComponent.b
 * JD-Core Version:    0.7.0.1
 */