package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.alg;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.auu;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private final b rr;
  private alh tXG;
  private f.a tXH;
  
  public f()
  {
    AppMethodBeat.i(142368);
    b.a locala = new b.a();
    locala.fsX = new alg();
    locala.fsY = new alh();
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/gethbrefundconfig";
    locala.funcId = 1477;
    this.rr = locala.ado();
    AppMethodBeat.o(142368);
  }
  
  public final f.a cSn()
  {
    AppMethodBeat.i(142371);
    if (this.tXH == null)
    {
      this.tXH = new f.a();
      this.tXH.cnK = this.tXG.cnK;
      this.tXH.tXI = this.tXG.tXI;
      this.tXH.tXJ = this.tXG.tXJ;
      this.tXH.tXK = this.tXG.tXK;
      this.tXH.tXL = this.tXG.tXL;
      this.tXH.tXM = this.tXG.tXM;
      this.tXH.tXN = this.tXG.tXN;
      this.tXH.tXO = this.tXG.tXO;
      this.tXH.tXP = this.tXG.tXP;
      this.tXH.tXR = this.tXG.tXR;
      this.tXH.tXQ = new ArrayList();
      localObject = this.tXG.xce.iterator();
      while (((Iterator)localObject).hasNext())
      {
        auu localauu = (auu)((Iterator)localObject).next();
        this.tXH.tXQ.add(new f.b(localauu.title, localauu.desc, localauu.ffD, localauu.tXS));
      }
    }
    Object localObject = this.tXH;
    AppMethodBeat.o(142371);
    return localObject;
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(142369);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(142369);
    return i;
  }
  
  public final int getType()
  {
    return 1477;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(142370);
    ab.w("MicroMsg.NetSceneGetHbRefundConfig", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.tXG = ((alh)((b)paramq).fsW.fta);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(142370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.f
 * JD-Core Version:    0.7.0.1
 */