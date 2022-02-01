package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bph;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.dqi;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/task/CgiGetLensList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "type", "", "pageBuff", "", "lensCtx", "(I[B[B)V", "plugin-sticker_release"})
public final class b
  extends c<bpi>
{
  public b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(105982);
    bph localbph = new bph();
    localbph.ReqType = paramInt;
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    localbph.LXB = new com.tencent.mm.bw.b(arrayOfByte);
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    localbph.LXC = new com.tencent.mm.bw.b(paramArrayOfByte1);
    paramArrayOfByte1 = new bpi();
    paramArrayOfByte1.setBaseResponse(new BaseResponse());
    paramArrayOfByte1.getBaseResponse().ErrMsg = new dqi();
    paramArrayOfByte2 = new d.a();
    paramArrayOfByte2.c((a)localbph);
    paramArrayOfByte2.d((a)paramArrayOfByte1);
    paramArrayOfByte2.MB("/cgi-bin/micromsg-bin/getlenslist");
    paramArrayOfByte2.sG(3847);
    c(paramArrayOfByte2.aXF());
    AppMethodBeat.o(105982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.c.b
 * JD-Core Version:    0.7.0.1
 */