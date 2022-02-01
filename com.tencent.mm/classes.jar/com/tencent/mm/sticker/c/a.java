package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/task/CgiGetLensInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "lensId", "", "(Ljava/lang/String;)V", "getLensId", "()Ljava/lang/String;", "plugin-sticker_release"})
public final class a
  extends c<bxa>
{
  private final String uTz;
  
  public a(String paramString)
  {
    AppMethodBeat.i(105981);
    this.uTz = paramString;
    paramString = new bwz();
    bxa localbxa = new bxa();
    paramString.LensId = this.uTz;
    localbxa.setBaseResponse(new jh());
    localbxa.BaseResponse.Tef = new eaf();
    d.a locala = new d.a();
    locala.c((com.tencent.mm.cd.a)paramString);
    locala.d((com.tencent.mm.cd.a)localbxa);
    locala.TW("/cgi-bin/micromsg-bin/getlensinfo");
    locala.vD(3903);
    c(locala.bgN());
    AppMethodBeat.o(105981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.c.a
 * JD-Core Version:    0.7.0.1
 */