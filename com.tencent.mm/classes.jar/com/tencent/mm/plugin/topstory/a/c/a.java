package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.c.byb;
import com.tencent.mm.protocal.c.ckr;
import com.tencent.mm.protocal.c.cks;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends m
  implements k
{
  public byb cbF;
  private b dmK;
  private f dmL;
  private long pDA;
  
  public a(byb parambyb)
  {
    y.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStory Home %s %s", new Object[] { parambyb.tNY, parambyb.bIB });
    this.pDA = System.currentTimeMillis();
    this.cbF = parambyb;
    Object localObject = new b.a();
    ((b.a)localObject).ecG = 1943;
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject).ecH = new ckr();
    ((b.a)localObject).ecI = new cks();
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ckr)this.dmK.ecE.ecN;
    ((ckr)localObject).sDT = parambyb.offset;
    ((ckr)localObject).tqS = aa.Bs(1);
    ((ckr)localObject).sYZ = parambyb.bGm;
    ((ckr)localObject).tqT = aa.Jx();
    ((ckr)localObject).pyo = parambyb.scene;
    ((ckr)localObject).sFF = parambyb.fTF;
    ((ckr)localObject).tXV.addAll(parambyb.qTG);
    ((ckr)localObject).tNf = parambyb.bvj;
    ((ckr)localObject).tXW = parambyb.qTP;
    ((ckr)localObject).tOe = parambyb.tOe;
    parambyb = new rb();
    parambyb.key = "client_system_version";
    parambyb.sOI = Build.VERSION.SDK_INT;
    ((ckr)localObject).tXV.add(parambyb);
    parambyb = new rb();
    parambyb.key = "netType";
    parambyb.sOJ = aa.boM();
    ((ckr)localObject).tXV.add(parambyb);
    parambyb = new rb();
    parambyb.key = "client_request_time";
    parambyb.sOJ = String.valueOf(System.currentTimeMillis());
    ((ckr)localObject).tXV.add(parambyb);
    parambyb = ((ckr)localObject).tXV.iterator();
    while (parambyb.hasNext())
    {
      rb localrb = (rb)parambyb.next();
      y.i("MicroMsg.TopStory.NetSceneTopStory", "key: %s unit_value %s text_value %s", new Object[] { localrb.key, Long.valueOf(localrb.sOI), localrb.sOJ });
    }
    y.i("MicroMsg.TopStory.NetSceneTopStory", "request params offset %d h5Version %d CheckDocListSize: %d", new Object[] { Integer.valueOf(((ckr)localObject).sDT), Integer.valueOf(((ckr)localObject).tqS), Integer.valueOf(((ckr)localObject).tOe.size()) });
  }
  
  public final int a(e parame, f paramf)
  {
    ao.reportIdKey649ForLook(this.cbF.scene, 2);
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.pDA) });
    if (paramInt3 == -1) {
      ao.reportIdKey649ForLook(this.cbF.scene, 4);
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        ao.reportIdKey649ForLook(this.cbF.scene, 8);
      } else {
        ao.reportIdKey649ForLook(this.cbF.scene, 3);
      }
    }
  }
  
  public final cks bNh()
  {
    return (cks)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 1943;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.a
 * JD-Core Version:    0.7.0.1
 */