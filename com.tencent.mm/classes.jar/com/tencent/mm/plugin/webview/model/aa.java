package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.k.b;
import com.tencent.mm.protocal.protobuf.ejg;
import com.tencent.mm.protocal.protobuf.ejh;
import java.util.LinkedList;

public final class aa
  extends p
  implements m
{
  private h mAY;
  private final c rr;
  private long startTime;
  
  public aa(int paramInt1, String paramString, LinkedList<String> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(78924);
    this.startTime = 0L;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ejg();
    ((c.a)localObject).otF = new ejh();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize_confirm";
    ((c.a)localObject).funcId = 1137;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ejg)c.b.b(this.rr.otB);
    ((ejg)localObject).abaP = paramInt1;
    ((ejg)localObject).abaO = paramString;
    ((ejg)localObject).abaQ = paramLinkedList;
    ((ejg)localObject).ZqK = paramInt2;
    AppMethodBeat.o(78924);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78926);
    this.startTime = System.currentTimeMillis();
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78926);
    return i;
  }
  
  public final int getType()
  {
    return 1137;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78925);
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    b.XsD.bt(4, (int)(System.currentTimeMillis() - this.startTime), paramInt3);
    AppMethodBeat.o(78925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aa
 * JD-Core Version:    0.7.0.1
 */