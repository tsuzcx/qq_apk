package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.protocal.protobuf.cwt;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/task/CgiGetLensInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "lensId", "", "(Ljava/lang/String;)V", "getLensId", "()Ljava/lang/String;", "plugin-sticker_release"})
public final class a
  extends com.tencent.mm.al.a<bdc>
{
  private final String pQo;
  
  public a(String paramString)
  {
    AppMethodBeat.i(105981);
    this.pQo = paramString;
    paramString = new bdb();
    bdc localbdc = new bdc();
    paramString.Geb = this.pQo;
    localbdc.setBaseResponse(new BaseResponse());
    localbdc.BaseResponse.ErrMsg = new cwt();
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bx.a)paramString);
    locala.d((com.tencent.mm.bx.a)localbdc);
    locala.Dl("/cgi-bin/micromsg-bin/getlensinfo");
    locala.oP(3903);
    c(locala.aDC());
    AppMethodBeat.o(105981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.c.a
 * JD-Core Version:    0.7.0.1
 */