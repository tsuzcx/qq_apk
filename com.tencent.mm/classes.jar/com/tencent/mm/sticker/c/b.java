package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bdd;
import com.tencent.mm.protocal.protobuf.bde;
import com.tencent.mm.protocal.protobuf.cwt;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/task/CgiGetLensList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "type", "", "pageBuff", "", "lensCtx", "(I[B[B)V", "plugin-sticker_release"})
public final class b
  extends com.tencent.mm.al.a<bde>
{
  public b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(105982);
    bdd localbdd = new bdd();
    localbdd.ReqType = paramInt;
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    localbdd.GzP = new com.tencent.mm.bx.b(arrayOfByte);
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    localbdd.GzQ = new com.tencent.mm.bx.b(paramArrayOfByte1);
    paramArrayOfByte1 = new bde();
    paramArrayOfByte1.setBaseResponse(new BaseResponse());
    paramArrayOfByte1.getBaseResponse().ErrMsg = new cwt();
    paramArrayOfByte2 = new b.a();
    paramArrayOfByte2.c((com.tencent.mm.bx.a)localbdd);
    paramArrayOfByte2.d((com.tencent.mm.bx.a)paramArrayOfByte1);
    paramArrayOfByte2.Dl("/cgi-bin/micromsg-bin/getlenslist");
    paramArrayOfByte2.oP(3847);
    c(paramArrayOfByte2.aDC());
    AppMethodBeat.o(105982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.c.b
 * JD-Core Version:    0.7.0.1
 */