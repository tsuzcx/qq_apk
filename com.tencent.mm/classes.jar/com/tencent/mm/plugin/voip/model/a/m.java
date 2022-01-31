package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cey;
import com.tencent.mm.protocal.c.cgb;
import com.tencent.mm.protocal.c.cgc;
import com.tencent.mm.sdk.platformtools.y;

public final class m
  extends n<cgb, cgc>
{
  public m(int paramInt1, cey paramcey, byte[] paramArrayOfByte, long paramLong, int paramInt2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cgb();
    ((b.a)localObject).ecI = new cgc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipsync";
    ((b.a)localObject).ecG = 174;
    ((b.a)localObject).ecJ = 62;
    ((b.a)localObject).ecK = 1000000062;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cgb)this.dmK.ecE.ecN;
    ((cgb)localObject).sST = paramInt1;
    ((cgb)localObject).tVl = paramcey;
    ((cgb)localObject).sSU = paramLong;
    ((cgb)localObject).tAY = q.Gj();
    ((cgb)localObject).sIh = paramInt2;
    ((cgb)localObject).sIi = new bmk().bs(paramArrayOfByte);
    ((cgb)localObject).tSJ = System.currentTimeMillis();
    y.i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + ((cgb)localObject).tSJ);
  }
  
  public final int bRA()
  {
    return ((cgb)this.dmK.ecE.ecN).sIh;
  }
  
  public final f bRy()
  {
    return new m.1(this);
  }
  
  public final int getType()
  {
    return 174;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m
 * JD-Core Version:    0.7.0.1
 */