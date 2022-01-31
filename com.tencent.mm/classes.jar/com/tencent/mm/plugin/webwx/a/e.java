package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ws;
import com.tencent.mm.protocal.c.wt;

public final class e
  extends m
  implements k
{
  private f dmL;
  public final b esv;
  public boolean rDF;
  
  public e(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.rDF = paramBoolean;
    b.a locala = new b.a();
    ws localws = new ws();
    wt localwt = new wt();
    locala.ecH = localws;
    locala.ecI = localwt;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
    locala.ecG = 972;
    locala.ecJ = 0;
    locala.ecK = 0;
    localws.sTn = paramString1;
    localws.sTy = paramString2;
    localws.sTA = paramBoolean;
    this.esv = locala.Kt();
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 972;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.e
 * JD-Core Version:    0.7.0.1
 */