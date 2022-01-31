package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n<css, cst>
{
  public g(List<String> paramList, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(4717);
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new css();
    ((b.a)localObject1).fsY = new cst();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipinvite";
    ((b.a)localObject1).funcId = 170;
    ((b.a)localObject1).reqCmdId = 63;
    ((b.a)localObject1).respCmdId = 1000000063;
    this.rr = ((b.a)localObject1).ado();
    localObject1 = (css)this.rr.fsV.fta;
    Object localObject2 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      ((LinkedList)localObject2).add(new bwc().aoF((String)paramList.get(i)));
      i += 1;
    }
    ((css)localObject1).xCG = r.Zn();
    ((css)localObject1).ybj = ((LinkedList)localObject2);
    ((css)localObject1).ybi = ((LinkedList)localObject2).size();
    ((css)localObject1).wLO = paramInt1;
    ((css)localObject1).xQo = 0;
    ((css)localObject1).yaX = paramInt2;
    ((css)localObject1).xCk = paramInt3;
    paramList = new cta();
    paramList.jKs = 2;
    localObject2 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramArrayOfByte1);
    paramList.wtq = ((SKBuiltinBuffer_t)localObject2);
    ((css)localObject1).xZX = paramList;
    paramList = new cta();
    paramList.jKs = 3;
    paramArrayOfByte1 = new SKBuiltinBuffer_t();
    paramArrayOfByte1.setBuffer(paramArrayOfByte2);
    paramList.wtq = paramArrayOfByte1;
    ((css)localObject1).xZY = paramList;
    ((css)localObject1).yab = System.currentTimeMillis();
    paramInt1 = ((a)com.tencent.mm.kernel.g.E(a.class)).yW(2);
    ab.i("MicroMsg.NetSceneVoipInvite", "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((css)localObject1).yac = paramInt1;
      AppMethodBeat.o(4717);
      return;
      if (paramInt1 == 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
    }
  }
  
  public final f cOp()
  {
    AppMethodBeat.i(4718);
    g.1 local1 = new g.1(this);
    AppMethodBeat.o(4718);
    return local1;
  }
  
  public final int getType()
  {
    return 170;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.g
 * JD-Core Version:    0.7.0.1
 */