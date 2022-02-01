package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bpf;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.protocal.protobuf.dqi;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/task/CgiGetLensInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "lensId", "", "(Ljava/lang/String;)V", "getLensId", "()Ljava/lang/String;", "plugin-sticker_release"})
public final class a
  extends c<bpg>
{
  private final String rnS;
  
  public a(String paramString)
  {
    AppMethodBeat.i(105981);
    this.rnS = paramString;
    paramString = new bpf();
    bpg localbpg = new bpg();
    paramString.Lso = this.rnS;
    localbpg.setBaseResponse(new BaseResponse());
    localbpg.BaseResponse.ErrMsg = new dqi();
    d.a locala = new d.a();
    locala.c((com.tencent.mm.bw.a)paramString);
    locala.d((com.tencent.mm.bw.a)localbpg);
    locala.MB("/cgi-bin/micromsg-bin/getlensinfo");
    locala.sG(3903);
    c(locala.aXF());
    AppMethodBeat.o(105981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.c.a
 * JD-Core Version:    0.7.0.1
 */