package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bdu;
import com.tencent.mm.protocal.protobuf.cxn;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/task/CgiGetLensList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "type", "", "pageBuff", "", "lensCtx", "(I[B[B)V", "plugin-sticker_release"})
public final class b
  extends com.tencent.mm.ak.a<bdu>
{
  public b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(105982);
    bdt localbdt = new bdt();
    localbdt.ReqType = paramInt;
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    localbdt.GTp = new com.tencent.mm.bw.b(arrayOfByte);
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    localbdt.GTq = new com.tencent.mm.bw.b(paramArrayOfByte1);
    paramArrayOfByte1 = new bdu();
    paramArrayOfByte1.setBaseResponse(new BaseResponse());
    paramArrayOfByte1.getBaseResponse().ErrMsg = new cxn();
    paramArrayOfByte2 = new b.a();
    paramArrayOfByte2.c((com.tencent.mm.bw.a)localbdt);
    paramArrayOfByte2.d((com.tencent.mm.bw.a)paramArrayOfByte1);
    paramArrayOfByte2.DN("/cgi-bin/micromsg-bin/getlenslist");
    paramArrayOfByte2.oS(3847);
    c(paramArrayOfByte2.aDS());
    AppMethodBeat.o(105982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.c.b
 * JD-Core Version:    0.7.0.1
 */