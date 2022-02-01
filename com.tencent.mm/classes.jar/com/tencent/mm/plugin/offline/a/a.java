package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.dvp;
import com.tencent.mm.protocal.protobuf.dvq;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/offline/model/CgiOfflineEnableToken;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/OfflineEnableResponse;", "password", "", "(Ljava/lang/String;)V", "getPassword", "()Ljava/lang/String;", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b<dvq>
{
  public static final a Myz;
  private final String hPy;
  
  static
  {
    AppMethodBeat.i(269127);
    Myz = new a((byte)0);
    AppMethodBeat.o(269127);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(269126);
    this.hPy = paramString;
    paramString = new dvp();
    paramString.pRM = this.hPy;
    c.a locala = new c.a();
    locala.otE = ((com.tencent.mm.bx.a)paramString);
    locala.otF = ((com.tencent.mm.bx.a)new dvq());
    locala.funcId = 10744;
    locala.uri = "/cgi-bin/mmpay-bin/offlineenable";
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    AppMethodBeat.o(269126);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/offline/model/CgiOfflineEnableToken$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.a
 * JD-Core Version:    0.7.0.1
 */