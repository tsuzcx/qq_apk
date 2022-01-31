package com.tencent.mm.plugin.radar.b;

import a.d.b.g;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  private static final String TAG = "MicroMsg.Radar.NetSceneRadarRelationChain";
  public static final a.a nks = new a.a((byte)0);
  final b dmK;
  private f dmL;
  
  public final int a(e parame, f paramf)
  {
    g.k(parame, "dispatcher");
    g.k(paramf, "callback");
    this.dmL = paramf;
    return a(parame, (q)this.dmK, (k)this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d(TAG, "netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.dmL;
    if (paramq != null) {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (m)this);
    }
  }
  
  public final int getType()
  {
    return 602;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.a
 * JD-Core Version:    0.7.0.1
 */