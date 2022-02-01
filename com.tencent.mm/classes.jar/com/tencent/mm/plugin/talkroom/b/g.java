package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.flz;
import com.tencent.mm.protocal.protobuf.fma;
import com.tencent.mm.protocal.protobuf.fmb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class g
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public g(LinkedList<flz> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(29567);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fma();
    ((c.a)localObject).otF = new fmb();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/talkstatreport";
    ((c.a)localObject).funcId = 373;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fma)c.b.b(this.rr.otB);
    ((fma)localObject).abMq = paramLinkedList.size();
    ((fma)localObject).abMr = paramLinkedList;
    ((fma)localObject).IJG = paramInt;
    AppMethodBeat.o(29567);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(29568);
    Log.d("MicroMsg.NetSceneTalkStatReport", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(29568);
    return i;
  }
  
  public final int getType()
  {
    return 373;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29569);
    Log.d("MicroMsg.NetSceneTalkStatReport", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29569);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(29569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.b.g
 * JD-Core Version:    0.7.0.1
 */