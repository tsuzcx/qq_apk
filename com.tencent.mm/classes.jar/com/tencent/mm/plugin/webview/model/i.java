package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.cn;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.an.i jQg;
  public final d rr;
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78865);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cm();
    ((d.a)localObject).lBV = new cn();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
    ((d.a)localObject).funcId = 2500;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cm)d.b.b(this.rr.lBR);
    ((cm)localObject).appid = paramString1;
    ((cm)localObject).nickname = paramString2;
    ((cm)localObject).fileid = paramString3;
    ((cm)localObject).RIc = 1;
    AppMethodBeat.o(78865);
  }
  
  public i(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78864);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cm();
    ((d.a)localObject).lBV = new cn();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
    ((d.a)localObject).funcId = 2500;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cm)d.b.b(this.rr.lBR);
    ((cm)localObject).appid = paramString1;
    ((cm)localObject).nickname = paramString2;
    ((cm)localObject).RIb = new b(paramArrayOfByte);
    ((cm)localObject).RIc = 0;
    AppMethodBeat.o(78864);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(78867);
    this.jQg = parami;
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
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.i
 * JD-Core Version:    0.7.0.1
 */