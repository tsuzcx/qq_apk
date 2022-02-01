package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.protocal.protobuf.cmd;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/task/CgiGetLensInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "lensId", "", "(Ljava/lang/String;)V", "getLensId", "()Ljava/lang/String;", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b<cmd>
{
  private final String ygo;
  
  public a(String paramString)
  {
    AppMethodBeat.i(105981);
    this.ygo = paramString;
    paramString = new cmc();
    cmd localcmd = new cmd();
    paramString.LensId = this.ygo;
    localcmd.setBaseResponse(new kd());
    localcmd.BaseResponse.akjO = new etl();
    c.a locala = new c.a();
    locala.otE = ((com.tencent.mm.bx.a)paramString);
    locala.otF = ((com.tencent.mm.bx.a)localcmd);
    locala.uri = "/cgi-bin/micromsg-bin/getlensinfo";
    locala.funcId = 3903;
    c(locala.bEF());
    AppMethodBeat.o(105981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.c.a
 * JD-Core Version:    0.7.0.1
 */