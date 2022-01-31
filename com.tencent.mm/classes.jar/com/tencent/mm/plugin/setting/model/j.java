package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bow;
import com.tencent.mm.protocal.c.box;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public j(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, 0);
  }
  
  public j(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bow();
    ((b.a)localObject).ecI = new box();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendfeedback";
    ((b.a)localObject).ecG = 153;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bow)this.dmK.ecE.ecN;
    ((bow)localObject).tHe = paramString1;
    ((bow)localObject).kVs = paramString2;
    ((bow)localObject).toD = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + paramInt2 + " code:" + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 153;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.j
 * JD-Core Version:    0.7.0.1
 */