package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.arc;
import com.tencent.mm.protocal.c.ard;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  extends m
  implements k
{
  private f dIJ;
  public final b dmK;
  
  public o(String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new arc();
    ((b.a)localObject).ecI = new ard();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibggetuseropenid";
    ((b.a)localObject).ecG = 1566;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (arc)this.dmK.ecE.ecN;
    ((arc)localObject).hPY = paramString2;
    ((arc)localObject).euK = paramString1;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.NetSceneGetUserOpenId", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1566;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.o
 * JD-Core Version:    0.7.0.1
 */