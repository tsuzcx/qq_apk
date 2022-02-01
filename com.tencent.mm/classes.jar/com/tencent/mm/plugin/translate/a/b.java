package com.tencent.mm.plugin.translate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bey;
import com.tencent.mm.protocal.protobuf.bez;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dki;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  public LinkedList<dki> Aju;
  private g callback;
  private final com.tencent.mm.ak.b rr;
  
  public b(LinkedList<dkh> paramLinkedList)
  {
    AppMethodBeat.i(29739);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bey();
    ((b.a)localObject).hvu = new bez();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/gettranstext";
    ((b.a)localObject).funcId = 631;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bey)this.rr.hvr.hvw;
    ((bey)localObject).EUr = paramLinkedList;
    ((bey)localObject).ncK = paramLinkedList.size();
    AppMethodBeat.o(29739);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(29740);
    this.callback = paramg;
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
    this.Aju = ((bez)this.rr.hvs.hvw).EUr;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.b
 * JD-Core Version:    0.7.0.1
 */