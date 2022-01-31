package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ccm;
import com.tencent.mm.protocal.c.ccn;
import com.tencent.mm.sdk.platformtools.y;

public final class ab
  extends m
  implements k
{
  private f dmL;
  public final b esv;
  
  public ab(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ccm();
    ((b.a)localObject).ecI = new ccn();
    ((b.a)localObject).uri = "/cgi-bin/mmo2o-bin/verifybeaconjspermission";
    ((b.a)localObject).ecG = 1702;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.esv = ((b.a)localObject).Kt();
    localObject = (ccm)this.esv.ecE.ecN;
    ((ccm)localObject).kSC = paramString1;
    ((ccm)localObject).bOL = paramString2;
    ((ccm)localObject).bJY = paramString3;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      y.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end ok");
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      y.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end not ok");
    }
  }
  
  public final int getType()
  {
    return 1702;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ab
 * JD-Core Version:    0.7.0.1
 */