package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cn;
import com.tencent.mm.protocal.protobuf.co;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.ak.i heq;
  public final d rr;
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78865);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cn();
    ((d.a)localObject).iLO = new co();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
    ((d.a)localObject).funcId = 2500;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cn)this.rr.iLK.iLR;
    ((cn)localObject).dNI = paramString1;
    ((cn)localObject).nickname = paramString2;
    ((cn)localObject).fileid = paramString3;
    ((cn)localObject).KGI = 1;
    AppMethodBeat.o(78865);
  }
  
  public i(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78864);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cn();
    ((d.a)localObject).iLO = new co();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
    ((d.a)localObject).funcId = 2500;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cn)this.rr.iLK.iLR;
    ((cn)localObject).dNI = paramString1;
    ((cn)localObject).nickname = paramString2;
    ((cn)localObject).KGH = new b(paramArrayOfByte);
    ((cn)localObject).KGI = 0;
    AppMethodBeat.o(78864);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(78867);
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78867);
    return i;
  }
  
  public final int getType()
  {
    return 2500;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78866);
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.i
 * JD-Core Version:    0.7.0.1
 */