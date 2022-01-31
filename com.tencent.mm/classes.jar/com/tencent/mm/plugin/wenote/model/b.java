package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.yh;
import com.tencent.mm.protocal.c.yn;
import com.tencent.mm.protocal.c.yo;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class b
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL = null;
  public int rEZ = 1;
  private String rFa = "";
  private yh rFb = null;
  private LinkedList<yh> rFc = new LinkedList();
  public int rFd = 0;
  
  public b(int paramInt1, int paramInt2, String paramString, LinkedList<yh> paramLinkedList, yh paramyh)
  {
    this.rFc = paramLinkedList;
    this.rFb = paramyh;
    this.rFa = paramString;
    this.rEZ = paramInt2;
    this.rFd = paramInt1;
    paramString = new b.a();
    paramString.ecH = new yn();
    paramString.ecI = new yo();
    paramString.uri = "/cgi-bin/micromsg-bin/favsecurity ";
    paramString.ecG = 921;
    paramString.ecJ = 0;
    paramString.ecK = 0;
    this.dmK = paramString.Kt();
  }
  
  public final int a(e parame, f paramf)
  {
    yn localyn = (yn)this.dmK.ecE.ecN;
    localyn.kTS = this.rEZ;
    localyn.sXh = this.rFb;
    localyn.sXg = this.rFc;
    localyn.sRA = this.rFa;
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneCheckNoteSecurity", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (yo)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if (paramInt2 != 0)
    {
      y.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,errType:%d,fail", new Object[] { Integer.valueOf(paramInt2) });
      this.dmL.onSceneEnd(paramInt2, -1, paramString, this);
      return;
    }
    if ((paramq == null) || (paramq.tFx == null))
    {
      y.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,response == null,ok");
      this.dmL.onSceneEnd(paramInt2, 0, paramString, this);
      return;
    }
    if (paramq.tFx.sze != 0)
    {
      y.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,baseresponse.ret != 0,ok");
      this.dmL.onSceneEnd(paramInt2, 0, paramString, this);
      return;
    }
    if (paramq.sXi > 0)
    {
      y.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult > 0,fail");
      this.dmL.onSceneEnd(paramInt2, -1, paramString, this);
      return;
    }
    y.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult = 0,fail");
    this.dmL.onSceneEnd(paramInt2, 0, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 921;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.b
 * JD-Core Version:    0.7.0.1
 */