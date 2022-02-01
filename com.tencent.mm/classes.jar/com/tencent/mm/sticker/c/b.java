package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ayz;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.crm;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/task/CgiGetLensList;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "type", "", "pageBuff", "", "lensCtx", "(I[B[B)V", "plugin-sticker_release"})
public final class b
  extends c<aza>
{
  public b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(105982);
    ayz localayz = new ayz();
    localayz.ReqType = paramInt;
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    localayz.EQy = new com.tencent.mm.bw.b(arrayOfByte);
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    localayz.EQz = new com.tencent.mm.bw.b(paramArrayOfByte1);
    paramArrayOfByte1 = new aza();
    paramArrayOfByte1.setBaseResponse(new BaseResponse());
    paramArrayOfByte1.getBaseResponse().ErrMsg = new crm();
    paramArrayOfByte2 = new b.a();
    paramArrayOfByte2.c((a)localayz);
    paramArrayOfByte2.d((a)paramArrayOfByte1);
    paramArrayOfByte2.Am("/cgi-bin/micromsg-bin/getlenslist");
    paramArrayOfByte2.op(3847);
    c(paramArrayOfByte2.aAz());
    AppMethodBeat.o(105982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.c.b
 * JD-Core Version:    0.7.0.1
 */