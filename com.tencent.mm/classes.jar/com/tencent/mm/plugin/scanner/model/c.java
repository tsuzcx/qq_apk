package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.kz;
import com.tencent.mm.protocal.protobuf.la;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class c
  extends m
  implements k
{
  private f callback;
  public b rr;
  
  public c(String paramString1, LinkedList<String> paramLinkedList, int paramInt, String paramString2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(80831);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new kz();
    ((b.a)localObject).fsY = new la();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
    ((b.a)localObject).funcId = 1068;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (kz)this.rr.fsV.fta;
    ((kz)localObject).ProductID = paramString1;
    ((kz)localObject).Scene = paramInt;
    ((kz)localObject).wyN = paramString2;
    ((kz)localObject).wyM = paramLinkedList;
    ((kz)localObject).wyP = paramDouble2;
    ((kz)localObject).wyO = paramDouble1;
    AppMethodBeat.o(80831);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(80833);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(80833);
    return i;
  }
  
  public final int getType()
  {
    return 1068;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(80832);
    ab.i("MicroMsg.NetSceneGetActionInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(80832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.c
 * JD-Core Version:    0.7.0.1
 */