package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private dox BJa;
  public dpa BJb;
  private f callback;
  private b rr;
  
  public h(dox paramdox, int paramInt, dpa paramdpa, long paramLong)
  {
    AppMethodBeat.i(91017);
    ae.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "Create NetSceneTopStoryVideo %s %s %s", new Object[] { paramdox.rfA, paramdox.kid, Long.valueOf(paramLong) });
    this.BJa = paramdox;
    this.BJb = paramdpa;
    Object localObject1 = new b.a();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject1).hQF = new ega();
    ((b.a)localObject1).hQG = new egb();
    this.rr = ((b.a)localObject1).aDS();
    localObject1 = (ega)this.rr.hQD.hQJ;
    ((ega)localObject1).GeT = paramdox.offset;
    ((ega)localObject1).GWA = ad.WL(1);
    ((ega)localObject1).GLP = paramdox.dmf;
    ((ega)localObject1).HkU = ad.bOD();
    ((ega)localObject1).Scene = paramdox.scene;
    ((ega)localObject1).GeS = paramdox.kid;
    ((ega)localObject1).Iiw.addAll(paramdox.DTg);
    Object localObject2 = ((ega)localObject1).Iiw.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      aaj localaaj = (aaj)((Iterator)localObject2).next();
      if (localaaj.key.equals("relevant_vid")) {
        localaaj.GrF = paramdpa.udb;
      }
    }
    localObject2 = new aaj();
    ((aaj)localObject2).key = "relevant_vid";
    ((aaj)localObject2).GrF = paramdpa.udb;
    ((ega)localObject1).Iiw.add(localObject2);
    ((ega)localObject1).HUi = ((int)paramdox.HVS);
    ((ega)localObject1).HGo = paramInt;
    ((ega)localObject1).nJA = 1;
    paramdox = new aaj();
    paramdox.key = "client_system_version";
    paramdox.GrE = Build.VERSION.SDK_INT;
    ((ega)localObject1).Iiw.add(paramdox);
    paramdox = new aaj();
    paramdox.key = "netType";
    paramdox.GrF = ad.UD();
    ((ega)localObject1).Iiw.add(paramdox);
    paramdox = new aaj();
    paramdox.key = "client_request_time";
    paramdox.GrF = String.valueOf(System.currentTimeMillis());
    ((ega)localObject1).Iiw.add(paramdox);
    paramdox = new aaj();
    paramdox.key = "relevant_play_time";
    paramdox.GrF = String.valueOf(paramLong);
    paramdox.GrE = paramLong;
    ((ega)localObject1).Iiw.add(paramdox);
    paramdox = ((ega)localObject1).Iiw.iterator();
    while (paramdox.hasNext())
    {
      paramdpa = (aaj)paramdox.next();
      ae.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "key: %s unit_value %s text_value %s", new Object[] { paramdpa.key, Long.valueOf(paramdpa.GrE), paramdpa.GrF });
    }
    AppMethodBeat.o(91017);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(91018);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91018);
    return i;
  }
  
  public final egb esB()
  {
    return (egb)this.rr.hQE.hQJ;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91019);
    ae.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.h
 * JD-Core Version:    0.7.0.1
 */