package com.tencent.mm.plugin.translate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.protocal.protobuf.dpy;
import com.tencent.mm.protocal.protobuf.dpz;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  public LinkedList<dpz> BBg;
  private f callback;
  private final com.tencent.mm.al.b rr;
  
  public b(LinkedList<dpy> paramLinkedList)
  {
    AppMethodBeat.i(29739);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bjg();
    ((b.a)localObject).hNN = new bjh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/gettranstext";
    ((b.a)localObject).funcId = 631;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bjg)this.rr.hNK.hNQ;
    ((bjg)localObject).GDO = paramLinkedList;
    ((bjg)localObject).nDh = paramLinkedList.size();
    AppMethodBeat.o(29739);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(29740);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29740);
    return i;
  }
  
  public final int getType()
  {
    return 631;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29741);
    this.BBg = ((bjh)this.rr.hNL.hNQ).GDO;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.b
 * JD-Core Version:    0.7.0.1
 */