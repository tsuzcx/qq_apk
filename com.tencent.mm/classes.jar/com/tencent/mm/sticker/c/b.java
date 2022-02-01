package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.bxb;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/task/CgiGetLensList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "type", "", "pageBuff", "", "lensCtx", "(I[B[B)V", "plugin-sticker_release"})
public final class b
  extends c<bxc>
{
  public b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(105982);
    bxb localbxb = new bxb();
    localbxb.lpw = paramInt;
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    localbxb.TgS = new com.tencent.mm.cd.b(arrayOfByte);
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    localbxb.TgT = new com.tencent.mm.cd.b(paramArrayOfByte1);
    paramArrayOfByte1 = new bxc();
    paramArrayOfByte1.setBaseResponse(new jh());
    paramArrayOfByte1.getBaseResponse().Tef = new eaf();
    paramArrayOfByte2 = new d.a();
    paramArrayOfByte2.c((a)localbxb);
    paramArrayOfByte2.d((a)paramArrayOfByte1);
    paramArrayOfByte2.TW("/cgi-bin/micromsg-bin/getlenslist");
    paramArrayOfByte2.vD(3847);
    c(paramArrayOfByte2.bgN());
    AppMethodBeat.o(105982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.c.b
 * JD-Core Version:    0.7.0.1
 */