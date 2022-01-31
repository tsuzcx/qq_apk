package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ats;
import com.tencent.mm.protocal.c.att;
import com.tencent.mm.protocal.c.atu;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends m
  implements k
{
  final b dmK;
  private f dmL;
  
  public e(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new att();
    locala.ecI = new atu();
    locala.uri = "/cgi-bin/micromsg-bin/getroommember";
    locala.ecG = 377;
    locala.ecJ = 184;
    locala.ecK = 1000000184;
    this.dmK = locala.Kt();
    ((att)this.dmK.ecE.ecN).evE = paramString;
    y.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:" + paramString);
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneLbsRoomGetMember", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (atu)this.dmK.ecF.ecN;
    if (paramInt2 != 0)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramq.svo.size())
    {
      h localh = new h();
      localh.username = ((ats)paramq.svo.get(paramInt1)).hPY;
      localh.ebT = ((ats)paramq.svo.get(paramInt1)).sLD;
      localh.ebS = ((ats)paramq.svo.get(paramInt1)).sLE;
      localh.bK(true);
      paramArrayOfByte.add(localh);
      paramInt1 += 1;
    }
    o.Kh().Q(paramArrayOfByte);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 377;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.e
 * JD-Core Version:    0.7.0.1
 */