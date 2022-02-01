package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private g callback;
  private b rr;
  private dil zZP;
  public dio zZQ;
  
  public h(dil paramdil, int paramInt, dio paramdio, long paramLong)
  {
    AppMethodBeat.i(91017);
    ac.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "Create NetSceneTopStoryVideo %s %s %s", new Object[] { paramdil.qox, paramdil.jKB, Long.valueOf(paramLong) });
    this.zZP = paramdil;
    this.zZQ = paramdio;
    Object localObject1 = new b.a();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject1).hvt = new dyj();
    ((b.a)localObject1).hvu = new dyk();
    this.rr = ((b.a)localObject1).aAz();
    localObject1 = (dyj)this.rr.hvr.hvw;
    ((dyj)localObject1).EfV = paramdil.offset;
    ((dyj)localObject1).FhS = z.Ul(1);
    ((dyj)localObject1).EJp = paramdil.cZL;
    ((dyj)localObject1).FhT = z.bJn();
    ((dyj)localObject1).Scene = paramdil.scene;
    ((dyj)localObject1).EfU = paramdil.jKB;
    ((dyj)localObject1).Gdj.addAll(paramdil.BYq);
    Object localObject2 = ((dyj)localObject1).Gdj.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      yh localyh = (yh)((Iterator)localObject2).next();
      if (localyh.key.equals("relevant_vid")) {
        localyh.ErW = paramdio.sVF;
      }
    }
    localObject2 = new yh();
    ((yh)localObject2).key = "relevant_vid";
    ((yh)localObject2).ErW = paramdio.sVF;
    ((dyj)localObject1).Gdj.add(localObject2);
    ((dyj)localObject1).FPQ = ((int)paramdil.FRz);
    ((dyj)localObject1).FCz = paramInt;
    ((dyj)localObject1).ndI = 1;
    paramdil = new yh();
    paramdil.key = "client_system_version";
    paramdil.ErV = Build.VERSION.SDK_INT;
    ((dyj)localObject1).Gdj.add(paramdil);
    paramdil = new yh();
    paramdil.key = "netType";
    paramdil.ErW = z.dkv();
    ((dyj)localObject1).Gdj.add(paramdil);
    paramdil = new yh();
    paramdil.key = "client_request_time";
    paramdil.ErW = String.valueOf(System.currentTimeMillis());
    ((dyj)localObject1).Gdj.add(paramdil);
    paramdil = new yh();
    paramdil.key = "relevant_play_time";
    paramdil.ErW = String.valueOf(paramLong);
    paramdil.ErV = paramLong;
    ((dyj)localObject1).Gdj.add(paramdil);
    paramdil = ((dyj)localObject1).Gdj.iterator();
    while (paramdil.hasNext())
    {
      paramdio = (yh)paramdil.next();
      ac.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "key: %s unit_value %s text_value %s", new Object[] { paramdio.key, Long.valueOf(paramdio.ErV), paramdio.ErW });
    }
    AppMethodBeat.o(91017);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(91018);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91018);
    return i;
  }
  
  public final dyk ecD()
  {
    return (dyk)this.rr.hvs.hvw;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91019);
    ac.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.h
 * JD-Core Version:    0.7.0.1
 */