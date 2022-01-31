package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.wm;
import com.tencent.mm.protocal.c.wn;

public final class c
  extends m
  implements k
{
  private f dmL;
  private final b esv;
  
  public c(String paramString)
  {
    b.a locala = new b.a();
    wm localwm = new wm();
    wn localwn = new wn();
    locala.ecH = localwm;
    locala.ecI = localwn;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
    locala.ecG = 973;
    locala.ecJ = 0;
    locala.ecK = 0;
    localwm.sTn = paramString;
    this.esv = locala.Kt();
  }
  
  public final int a(e parame, f paramf)
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
    return 973;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.c
 * JD-Core Version:    0.7.0.1
 */