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
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.ckr;
import com.tencent.mm.protocal.c.cks;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  public byf pDB;
  
  public c(byf parambyf)
  {
    a(parambyf, 0, 0);
  }
  
  public c(byf parambyf, int paramInt)
  {
    a(parambyf, paramInt, 1);
  }
  
  private void a(byf parambyf, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "Create NetSceneTopStory Video %s", new Object[] { parambyf.tNY, parambyf.fTF });
    this.pDB = parambyf;
    Object localObject = new b.a();
    ((b.a)localObject).ecG = 1943;
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject).ecH = new ckr();
    ((b.a)localObject).ecI = new cks();
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ckr)this.dmK.ecE.ecN;
    ((ckr)localObject).sDT = parambyf.offset;
    ((ckr)localObject).tqS = aa.Bs(1);
    ((ckr)localObject).sYZ = parambyf.bGm;
    ((ckr)localObject).tqT = aa.Jx();
    ((ckr)localObject).pyo = parambyf.scene;
    ((ckr)localObject).sFF = parambyf.fTF;
    ((ckr)localObject).tXV.addAll(parambyf.qTG);
    ((ckr)localObject).tNf = ((int)parambyf.tOo);
    ((ckr)localObject).tXX = paramInt1;
    ((ckr)localObject).hQR = paramInt2;
    parambyf = new rb();
    parambyf.key = "client_system_version";
    parambyf.sOI = Build.VERSION.SDK_INT;
    ((ckr)localObject).tXV.add(parambyf);
    parambyf = new rb();
    parambyf.key = "netType";
    parambyf.sOJ = aa.boM();
    ((ckr)localObject).tXV.add(parambyf);
    parambyf = new rb();
    parambyf.key = "client_request_time";
    parambyf.sOJ = String.valueOf(System.currentTimeMillis());
    ((ckr)localObject).tXV.add(parambyf);
    parambyf = ((ckr)localObject).tXV.iterator();
    while (parambyf.hasNext())
    {
      localObject = (rb)parambyf.next();
      y.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "key: %s unit_value %s text_value %s", new Object[] { ((rb)localObject).key, Long.valueOf(((rb)localObject).sOI), ((rb)localObject).sOJ });
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.c
 * JD-Core Version:    0.7.0.1
 */