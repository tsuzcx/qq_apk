package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.avt;
import com.tencent.mm.protocal.protobuf.avu;
import com.tencent.mm.protocal.protobuf.cmf;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/task/CgiGetLensList;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "type", "", "pageBuff", "", "lensCtx", "(I[B[B)V", "plugin-sticker_release"})
public final class b
  extends c<avu>
{
  public b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(105982);
    avt localavt = new avt();
    localavt.ReqType = paramInt;
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    localavt.Dvp = new com.tencent.mm.bx.b(arrayOfByte);
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    localavt.Dvq = new com.tencent.mm.bx.b(paramArrayOfByte1);
    paramArrayOfByte1 = new avu();
    paramArrayOfByte1.setBaseResponse(new BaseResponse());
    paramArrayOfByte1.getBaseResponse().ErrMsg = new cmf();
    paramArrayOfByte2 = new b.a();
    paramArrayOfByte2.c((a)localavt);
    paramArrayOfByte2.d((a)paramArrayOfByte1);
    paramArrayOfByte2.wg("/cgi-bin/micromsg-bin/getlenslist");
    paramArrayOfByte2.nB(3847);
    c(paramArrayOfByte2.atI());
    AppMethodBeat.o(105982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.c.b
 * JD-Core Version:    0.7.0.1
 */