package com.tencent.mm.plugin.radar.b;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.bv.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.protocal.c.bip;
import com.tencent.mm.protocal.c.biq;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends m
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.NetSceneRadarSearch";
  public static final b.a nkt = new b.a((byte)0);
  final int bMC;
  private final float bRt;
  private final float bTc;
  private final int bTd;
  private final int bTe;
  private final String bTf;
  private final String bTg;
  com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public b(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    this.bMC = paramInt1;
    this.bRt = paramFloat1;
    this.bTc = paramFloat2;
    this.bTd = paramInt2;
    this.bTe = paramInt3;
    this.bTf = paramString1;
    this.bTg = paramString2;
    if (this.bMC == 0) {
      y.e(TAG, "opcode is wrong!");
    }
  }
  
  public final int a(e parame, f paramf)
  {
    a.d.b.g.k(parame, "dispatcher");
    a.d.b.g.k(paramf, "callback");
    this.dmL = paramf;
    paramf = new com.tencent.mm.ah.b.a();
    paramf.a((a)new bip());
    paramf.b((a)new biq());
    paramf.kr("/cgi-bin/micromsg-bin/mmradarsearch");
    paramf.ig(425);
    paramf.Kr();
    paramf.Ks();
    this.dmK = paramf.Kt();
    paramf = this.dmK;
    if (paramf == null) {
      a.d.b.g.cUk();
    }
    paramf = paramf.Kn();
    if (paramf == null) {
      throw new a.k("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
    }
    paramf = (bip)paramf;
    paramf.ssq = this.bMC;
    paramf.sUp = this.bTg;
    paramf.sUq = this.bTe;
    paramf.sGK = this.bRt;
    paramf.sGJ = this.bTc;
    paramf.sUo = this.bTf;
    paramf.sUn = this.bTd;
    return a(parame, (q)this.dmK, (com.tencent.mm.network.k)this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d(TAG, "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((this.bMC == 1) && (paramInt2 == 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramq = this.dmK;
      if (paramq != null) {}
      for (paramq = paramq.Ko();; paramq = null)
      {
        paramArrayOfByte = paramq;
        if (!(paramq instanceof biq)) {
          paramArrayOfByte = null;
        }
        paramq = (biq)paramArrayOfByte;
        if (paramq == null) {
          break;
        }
        paramq = paramq.svo;
        if (paramq == null) {
          break;
        }
        paramq = ((Iterable)paramq).iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = (bio)paramq.next();
          h localh = new h();
          com.tencent.mm.plugin.radar.ui.g localg = com.tencent.mm.plugin.radar.ui.g.nnt;
          a.d.b.g.j(paramArrayOfByte, "member");
          localh.setUsername(com.tencent.mm.plugin.radar.ui.g.b(paramArrayOfByte));
          localh.ko(paramArrayOfByte.sRZ);
          localh.bK(true);
          localArrayList.add(localh);
        }
      }
      o.Kh().Q((List)localArrayList);
    }
    paramq = this.dmL;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (m)this);
    }
  }
  
  public final int buw()
  {
    Object localObject = this.dmK;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.ah.b)localObject).Ko();; localObject = null)
    {
      localObject = (biq)localObject;
      if (localObject == null) {
        break;
      }
      return ((biq)localObject).dne;
    }
    return 0;
  }
  
  public final int getType()
  {
    return 425;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.b
 * JD-Core Version:    0.7.0.1
 */