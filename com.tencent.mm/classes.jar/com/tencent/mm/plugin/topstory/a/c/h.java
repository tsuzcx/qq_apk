package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private g callback;
  private b rr;
  private dcy yLX;
  public ddb yLY;
  
  public h(dcy paramdcy, int paramInt, ddb paramddb, long paramLong)
  {
    AppMethodBeat.i(91017);
    ad.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "Create NetSceneTopStoryVideo %s %s %s", new Object[] { paramdcy.qwV, paramdcy.jko, Long.valueOf(paramLong) });
    this.yLX = paramdcy;
    this.yLY = paramddb;
    Object localObject1 = new b.a();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject1).gUU = new dss();
    ((b.a)localObject1).gUV = new dst();
    this.rr = ((b.a)localObject1).atI();
    localObject1 = (dss)this.rr.gUS.gUX;
    ((dss)localObject1).CNt = paramdcy.offset;
    ((dss)localObject1).DLD = aa.Sb(1);
    ((dss)localObject1).Dop = paramdcy.dcm;
    ((dss)localObject1).DLE = aa.bCk();
    ((dss)localObject1).Scene = paramdcy.scene;
    ((dss)localObject1).CNs = paramdcy.jko;
    ((dss)localObject1).EFX.addAll(paramdcy.AFX);
    Object localObject2 = ((dss)localObject1).EFX.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      xp localxp = (xp)((Iterator)localObject2).next();
      if (localxp.key.equals("relevant_vid")) {
        localxp.CZj = paramddb.rNP;
      }
    }
    localObject2 = new xp();
    ((xp)localObject2).key = "relevant_vid";
    ((xp)localObject2).CZj = paramddb.rNP;
    ((dss)localObject1).EFX.add(localObject2);
    ((dss)localObject1).EsO = ((int)paramdcy.Euy);
    ((dss)localObject1).Efz = paramInt;
    ((dss)localObject1).mBH = 1;
    paramdcy = new xp();
    paramdcy.key = "client_system_version";
    paramdcy.CZi = Build.VERSION.SDK_INT;
    ((dss)localObject1).EFX.add(paramdcy);
    paramdcy = new xp();
    paramdcy.key = "netType";
    paramdcy.CZj = aa.cWN();
    ((dss)localObject1).EFX.add(paramdcy);
    paramdcy = new xp();
    paramdcy.key = "client_request_time";
    paramdcy.CZj = String.valueOf(System.currentTimeMillis());
    ((dss)localObject1).EFX.add(paramdcy);
    paramdcy = new xp();
    paramdcy.key = "relevant_play_time";
    paramdcy.CZj = String.valueOf(paramLong);
    paramdcy.CZi = paramLong;
    ((dss)localObject1).EFX.add(paramdcy);
    paramdcy = ((dss)localObject1).EFX.iterator();
    while (paramdcy.hasNext())
    {
      paramddb = (xp)paramdcy.next();
      ad.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "key: %s unit_value %s text_value %s", new Object[] { paramddb.key, Long.valueOf(paramddb.CZi), paramddb.CZj });
    }
    AppMethodBeat.o(91017);
  }
  
  public final dst dOd()
  {
    return (dst)this.rr.gUT.gUX;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(91018);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91018);
    return i;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91019);
    ad.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.h
 * JD-Core Version:    0.7.0.1
 */