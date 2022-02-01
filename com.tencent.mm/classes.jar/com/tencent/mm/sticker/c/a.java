package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.protocal.protobuf.crm;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/task/CgiGetLensInfo;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "lensId", "", "(Ljava/lang/String;)V", "getLensId", "()Ljava/lang/String;", "plugin-sticker_release"})
public final class a
  extends c<ayy>
{
  private final String pmO;
  
  public a(String paramString)
  {
    AppMethodBeat.i(105981);
    this.pmO = paramString;
    paramString = new ayx();
    ayy localayy = new ayy();
    paramString.Ewy = this.pmO;
    localayy.setBaseResponse(new BaseResponse());
    localayy.BaseResponse.ErrMsg = new crm();
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bw.a)paramString);
    locala.d((com.tencent.mm.bw.a)localayy);
    locala.Am("/cgi-bin/micromsg-bin/getlensinfo");
    locala.op(3903);
    c(locala.aAz());
    AppMethodBeat.o(105981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.c.a
 * JD-Core Version:    0.7.0.1
 */