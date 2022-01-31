package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cro;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends n<cro, crp>
{
  String TAG;
  
  public b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(4699);
    this.TAG = "MicroMsg.NetSceneVoipAnswer";
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new cro();
    ((b.a)localObject1).fsY = new crp();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipanswer";
    ((b.a)localObject1).funcId = 172;
    ((b.a)localObject1).reqCmdId = 65;
    ((b.a)localObject1).respCmdId = 1000000065;
    this.rr = ((b.a)localObject1).ado();
    localObject1 = (cro)this.rr.fsV.fta;
    ((cro)localObject1).yam = paramInt1;
    ((cro)localObject1).wQP = paramInt3;
    ((cro)localObject1).wLO = paramInt2;
    Object localObject2 = new cta();
    ((cta)localObject2).jKs = 2;
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramArrayOfByte1);
    ((cta)localObject2).wtq = localSKBuiltinBuffer_t;
    ((cro)localObject1).xZX = ((cta)localObject2);
    paramArrayOfByte1 = new cta();
    paramArrayOfByte1.jKs = 3;
    localObject2 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramArrayOfByte2);
    paramArrayOfByte1.wtq = ((SKBuiltinBuffer_t)localObject2);
    ((cro)localObject1).xZY = paramArrayOfByte1;
    ((cro)localObject1).wQQ = paramLong;
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        paramInt1 = 1;
        ((cro)localObject1).yan = paramInt1;
      }
    }
    else
    {
      ((cro)localObject1).yab = System.currentTimeMillis();
      paramInt1 = ((a)g.E(a.class)).yW(2);
      ab.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 0) {
        break label304;
      }
      paramInt1 = 0;
    }
    for (;;)
    {
      ((cro)localObject1).yac = paramInt1;
      AppMethodBeat.o(4699);
      return;
      paramInt1 = 0;
      break;
      label304:
      if (paramInt1 == 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
    }
  }
  
  public final f cOp()
  {
    AppMethodBeat.i(4700);
    b.1 local1 = new b.1(this);
    AppMethodBeat.o(4700);
    return local1;
  }
  
  public final int getType()
  {
    return 172;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.b
 * JD-Core Version:    0.7.0.1
 */