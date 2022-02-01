package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.eej;
import com.tencent.mm.protocal.protobuf.eek;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private doa BrB;
  public dod BrC;
  private f callback;
  private b rr;
  
  public h(doa paramdoa, int paramInt, dod paramdod, long paramLong)
  {
    AppMethodBeat.i(91017);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "Create NetSceneTopStoryVideo %s %s %s", new Object[] { paramdoa.qXu, paramdoa.keN, Long.valueOf(paramLong) });
    this.BrB = paramdoa;
    this.BrC = paramdod;
    Object localObject1 = new b.a();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject1).hNM = new eej();
    ((b.a)localObject1).hNN = new eek();
    this.rr = ((b.a)localObject1).aDC();
    localObject1 = (eej)this.rr.hNK.hNQ;
    ((eej)localObject1).FMu = paramdoa.offset;
    ((eej)localObject1).GDa = com.tencent.mm.plugin.websearch.api.ad.We(1);
    ((eej)localObject1).Gsr = paramdoa.dld;
    ((eej)localObject1).GRt = com.tencent.mm.plugin.websearch.api.ad.bNG();
    ((eej)localObject1).Scene = paramdoa.scene;
    ((eej)localObject1).FMt = paramdoa.keN;
    ((eej)localObject1).HOp.addAll(paramdoa.DBj);
    Object localObject2 = ((eej)localObject1).HOp.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      aag localaag = (aag)((Iterator)localObject2).next();
      if (localaag.key.equals("relevant_vid")) {
        localaag.FZf = paramdod.tSk;
      }
    }
    localObject2 = new aag();
    ((aag)localObject2).key = "relevant_vid";
    ((aag)localObject2).FZf = paramdod.tSk;
    ((eej)localObject1).HOp.add(localObject2);
    ((eej)localObject1).HAv = ((int)paramdoa.HCf);
    ((eej)localObject1).HmO = paramInt;
    ((eej)localObject1).nEf = 1;
    paramdoa = new aag();
    paramdoa.key = "client_system_version";
    paramdoa.FZe = Build.VERSION.SDK_INT;
    ((eej)localObject1).HOp.add(paramdoa);
    paramdoa = new aag();
    paramdoa.key = "netType";
    paramdoa.FZf = com.tencent.mm.plugin.websearch.api.ad.Ux();
    ((eej)localObject1).HOp.add(paramdoa);
    paramdoa = new aag();
    paramdoa.key = "client_request_time";
    paramdoa.FZf = String.valueOf(System.currentTimeMillis());
    ((eej)localObject1).HOp.add(paramdoa);
    paramdoa = new aag();
    paramdoa.key = "relevant_play_time";
    paramdoa.FZf = String.valueOf(paramLong);
    paramdoa.FZe = paramLong;
    ((eej)localObject1).HOp.add(paramdoa);
    paramdoa = ((eej)localObject1).HOp.iterator();
    while (paramdoa.hasNext())
    {
      paramdod = (aag)paramdoa.next();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "key: %s unit_value %s text_value %s", new Object[] { paramdod.key, Long.valueOf(paramdod.FZe), paramdod.FZf });
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
  
  public final eek eoU()
  {
    return (eek)this.rr.hNL.hNQ;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91019);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.h
 * JD-Core Version:    0.7.0.1
 */