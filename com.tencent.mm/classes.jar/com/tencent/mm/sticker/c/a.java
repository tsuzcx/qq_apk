package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.cmf;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/task/CgiGetLensInfo;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "lensId", "", "(Ljava/lang/String;)V", "getLensId", "()Ljava/lang/String;", "plugin-sticker_release"})
public final class a
  extends c<avs>
{
  private final String oJp;
  
  public a(String paramString)
  {
    AppMethodBeat.i(105981);
    this.oJp = paramString;
    paramString = new avr();
    avs localavs = new avs();
    paramString.Dds = this.oJp;
    localavs.setBaseResponse(new BaseResponse());
    localavs.BaseResponse.ErrMsg = new cmf();
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bx.a)paramString);
    locala.d((com.tencent.mm.bx.a)localavs);
    locala.wg("/cgi-bin/micromsg-bin/getlensinfo");
    locala.nB(3903);
    c(locala.atI());
    AppMethodBeat.o(105981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.c.a
 * JD-Core Version:    0.7.0.1
 */