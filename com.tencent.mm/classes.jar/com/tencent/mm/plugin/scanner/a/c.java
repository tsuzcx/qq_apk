package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.protocal.c.iy;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class c
  extends m
  implements k
{
  public b dmK;
  private f dmL;
  
  public c(String paramString1, LinkedList<String> paramLinkedList, int paramInt, String paramString2, double paramDouble1, double paramDouble2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ix();
    ((b.a)localObject).ecI = new iy();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
    ((b.a)localObject).ecG = 1068;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ix)this.dmK.ecE.ecN;
    ((ix)localObject).syc = paramString1;
    ((ix)localObject).pyo = paramInt;
    ((ix)localObject).sDl = paramString2;
    ((ix)localObject).sDk = paramLinkedList;
    ((ix)localObject).sDn = paramDouble2;
    ((ix)localObject).sDm = paramDouble1;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetActionInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1068;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.c
 * JD-Core Version:    0.7.0.1
 */