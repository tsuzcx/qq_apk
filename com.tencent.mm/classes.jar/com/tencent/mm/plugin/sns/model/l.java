package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cf;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.protocal.protobuf.co;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class l
  extends p
  implements m
{
  private LinkedList<co> POF;
  public h callback;
  private c rr;
  
  public l(LinkedList<co> paramLinkedList)
  {
    AppMethodBeat.i(95567);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cf();
    ((c.a)localObject).otF = new cg();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/addatareport";
    ((c.a)localObject).funcId = 1295;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cf)c.b.b(this.rr.otB);
    ((cf)localObject).YEu = paramLinkedList;
    this.POF = paramLinkedList;
    Log.i("MicroMsg.NetSceneSnsAdDataReport", "report %d ads", new Object[] { Integer.valueOf(((cf)localObject).YEu.size()) });
    AppMethodBeat.o(95567);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(95568);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95568);
    return i;
  }
  
  public final int getType()
  {
    return 1295;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95569);
    Log.d("MicroMsg.NetSceneSnsAdDataReport", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(95569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.l
 * JD-Core Version:    0.7.0.1
 */