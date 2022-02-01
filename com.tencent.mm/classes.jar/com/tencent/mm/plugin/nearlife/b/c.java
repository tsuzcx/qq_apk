package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.acj;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class c
  extends n
  implements k
{
  private b hQy;
  private f wFF;
  public String wFG;
  
  public c(String paramString1, String paramString2, String paramString3, bug parambug, int paramInt, LinkedList<cxn> paramLinkedList, String paramString4)
  {
    AppMethodBeat.i(26548);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new acj();
    ((b.a)localObject).hQG = new ack();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/createpoi";
    ((b.a)localObject).funcId = 650;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hQy = ((b.a)localObject).aDS();
    paramString4 = bu.bI(paramString4, "");
    localObject = bu.bI(null, "");
    acj localacj = (acj)this.hQy.hQD.hQJ;
    localacj.Name = paramString1;
    localacj.Guh = paramString2;
    localacj.Guj = parambug;
    localacj.nID = paramInt;
    if (paramLinkedList != null) {
      localacj.Guk = paramLinkedList;
    }
    localacj.Gul = paramString4;
    localacj.Gum = ((String)localObject);
    localacj.Gui = paramString3;
    ae.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", new Object[] { paramString1, paramString2, paramString3, Float.valueOf(parambug.Gha), Float.valueOf(parambug.GgZ), Integer.valueOf(paramInt), paramString4, localObject });
    AppMethodBeat.o(26548);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26549);
    this.wFF = paramf;
    int i = dispatch(parame, this.hQy, this);
    AppMethodBeat.o(26549);
    return i;
  }
  
  public final int getType()
  {
    return 650;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26550);
    ae.d("MicroMsg.NetSceneCreatePoi", "netId:%d, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (ack)this.hQy.hQE.hQJ;
    if (this.hQy.hQE.getRetCode() != 0)
    {
      this.wFF.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26550);
      return;
    }
    this.wFG = paramq.Gun;
    ae.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.wFG);
    this.wFF.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.c
 * JD-Core Version:    0.7.0.1
 */