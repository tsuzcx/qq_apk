package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.etn;
import com.tencent.mm.protocal.protobuf.euw;
import com.tencent.mm.protocal.protobuf.eux;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends n<euw, eux>
{
  public m(int paramInt1, etn parametn, byte[] paramArrayOfByte, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115256);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new euw();
    ((d.a)localObject).iLO = new eux();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipsync";
    ((d.a)localObject).funcId = 174;
    ((d.a)localObject).iLP = 62;
    ((d.a)localObject).respCmdId = 1000000062;
    this.rr = ((d.a)localObject).aXF();
    localObject = (euw)this.rr.iLK.iLR;
    ((euw)localObject).LsZ = paramInt1;
    ((euw)localObject).NsX = parametn;
    ((euw)localObject).Lta = paramLong;
    ((euw)localObject).MKC = z.aTY();
    ((euw)localObject).Leu = paramInt2;
    ((euw)localObject).Lev = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((euw)localObject).NpN = System.currentTimeMillis();
    Log.i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + ((euw)localObject).NpN);
    AppMethodBeat.o(115256);
  }
  
  public final i fIF()
  {
    AppMethodBeat.i(115257);
    m.1 local1 = new m.1(this);
    AppMethodBeat.o(115257);
    return local1;
  }
  
  public final int fIH()
  {
    return ((euw)this.rr.iLK.iLR).Leu;
  }
  
  public final int getType()
  {
    return 174;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m
 * JD-Core Version:    0.7.0.1
 */