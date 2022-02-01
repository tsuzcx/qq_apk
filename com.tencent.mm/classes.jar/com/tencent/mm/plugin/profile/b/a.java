package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aq;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends q
  implements m
{
  public brt BcU;
  private i callback;
  public String errMsg;
  public final d rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(26901);
    Log.i("MicroMsg.NetSceneGetOpenUrl", "NetSceneGetOpenUrl username:%s ticket:%s climsgid:%s content:%s ", new Object[] { paramString1, paramString2, paramString3, Util.secPrint(paramString4) });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenurl";
    ((d.a)localObject).funcId = 913;
    ((d.a)localObject).iLN = new brs();
    ((d.a)localObject).iLO = new brt();
    this.rr = ((d.a)localObject).aXF();
    localObject = (brs)this.rr.iLK.iLR;
    ((brs)localObject).scene = 1;
    aq localaq = new aq();
    localaq.username = paramString1;
    localaq.dHx = paramString2;
    localaq.BcW = paramString3;
    localaq.content = paramString4;
    ((brs)localObject).LYX = localaq;
    AppMethodBeat.o(26901);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26902);
    this.callback = parami;
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
 * Qualified Name:     com.tencent.mm.plugin.profile.b.a
 * JD-Core Version:    0.7.0.1
 */