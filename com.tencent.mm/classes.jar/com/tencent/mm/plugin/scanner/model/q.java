package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.po;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class q
  extends p
  implements m
{
  private h callback;
  public c rr;
  
  public q(String paramString1, LinkedList<String> paramLinkedList, int paramInt, String paramString2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(51617);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new po();
    ((c.a)localObject).otF = new pp();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
    ((c.a)localObject).funcId = 1068;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (po)c.b.b(this.rr.otB);
    ((po)localObject).ProductID = paramString1;
    ((po)localObject).IJG = paramInt;
    ((po)localObject).YTb = paramString2;
    ((po)localObject).YTa = paramLinkedList;
    ((po)localObject).YTd = paramDouble2;
    ((po)localObject).YTc = paramDouble1;
    AppMethodBeat.o(51617);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(51619);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(51619);
    return i;
  }
  
  public final int getType()
  {
    return 1068;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51618);
    Log.i("MicroMsg.NetSceneGetActionInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.q
 * JD-Core Version:    0.7.0.1
 */