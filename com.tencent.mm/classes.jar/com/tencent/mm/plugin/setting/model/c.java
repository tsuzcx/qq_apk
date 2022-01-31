package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cca;
import com.tencent.mm.protocal.c.tk;
import com.tencent.mm.protocal.c.tl;

public final class c
  extends m
  implements k
{
  public final String appId;
  private f dmL;
  private final int scene;
  
  public c(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.scene = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    tk localtk = new tk();
    localtk.bOL = this.appId;
    localtk.bZe = this.scene;
    paramf.ecH = localtk;
    paramf.uri = "/cgi-bin/mmbiz-bin/deluserauth";
    paramf.ecI = new tl();
    paramf.ecG = 1127;
    paramf.ecJ = 0;
    paramf.ecK = 0;
    return a(parame, paramf.Kt(), this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramString = (tl)((b)paramq).ecF.ecN;
    this.dmL.onSceneEnd(paramInt2, paramString.sQB.bLB, paramString.sQB.bLC, this);
  }
  
  public final int getType()
  {
    return 1127;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.c
 * JD-Core Version:    0.7.0.1
 */