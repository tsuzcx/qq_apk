package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.cxn;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/task/CgiGetLensInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "lensId", "", "(Ljava/lang/String;)V", "getLensId", "()Ljava/lang/String;", "plugin-sticker_release"})
public final class a
  extends com.tencent.mm.ak.a<bds>
{
  private final String pWT;
  
  public a(String paramString)
  {
    AppMethodBeat.i(105981);
    this.pWT = paramString;
    paramString = new bdr();
    bds localbds = new bds();
    paramString.GwI = this.pWT;
    localbds.setBaseResponse(new BaseResponse());
    localbds.BaseResponse.ErrMsg = new cxn();
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bw.a)paramString);
    locala.d((com.tencent.mm.bw.a)localbds);
    locala.DN("/cgi-bin/micromsg-bin/getlensinfo");
    locala.oS(3903);
    c(locala.aDS());
    AppMethodBeat.o(105981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.c.a
 * JD-Core Version:    0.7.0.1
 */