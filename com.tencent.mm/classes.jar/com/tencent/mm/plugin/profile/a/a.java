package com.tencent.mm.plugin.profile.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aq;
import com.tencent.mm.protocal.protobuf.cox;
import com.tencent.mm.protocal.protobuf.coy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends p
  implements m
{
  public coy MUM;
  private h callback;
  public String errMsg;
  public final c rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(26901);
    Log.i("MicroMsg.NetSceneGetOpenUrl", "NetSceneGetOpenUrl username:%s ticket:%s climsgid:%s content:%s ", new Object[] { paramString1, paramString2, paramString3, Util.secPrint(paramString4) });
    Object localObject = new c.a();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenurl";
    ((c.a)localObject).funcId = 913;
    ((c.a)localObject).otE = new cox();
    ((c.a)localObject).otF = new coy();
    this.rr = ((c.a)localObject).bEF();
    localObject = (cox)c.b.b(this.rr.otB);
    ((cox)localObject).scene = 1;
    aq localaq = new aq();
    localaq.username = paramString1;
    localaq.hFb = paramString2;
    localaq.MUO = paramString3;
    localaq.content = paramString4;
    ((cox)localObject).aavP = localaq;
    AppMethodBeat.o(26901);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(26902);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(26902);
    return i;
  }
  
  public final int getType()
  {
    return 913;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26903);
    Log.d("MicroMsg.NetSceneGetOpenUrl", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(26903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a
 * JD-Core Version:    0.7.0.1
 */