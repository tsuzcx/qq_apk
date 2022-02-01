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
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.eej;
import com.tencent.mm.protocal.protobuf.eek;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  public doa BrB;
  private f callback;
  private b rr;
  
  public k(doa paramdoa)
  {
    AppMethodBeat.i(91025);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "Create NetSceneTopStory Video contextId:%s searchId:%s", new Object[] { paramdoa.qXu, paramdoa.keN });
    this.BrB = paramdoa;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject).hNM = new eej();
    ((b.a)localObject).hNN = new eek();
    this.rr = ((b.a)localObject).aDC();
    localObject = (eej)this.rr.hNK.hNQ;
    ((eej)localObject).FMu = paramdoa.offset;
    ((eej)localObject).GDa = com.tencent.mm.plugin.websearch.api.ad.We(1);
    ((eej)localObject).Gsr = paramdoa.dld;
    ((eej)localObject).GRt = com.tencent.mm.plugin.websearch.api.ad.bNG();
    ((eej)localObject).Scene = paramdoa.scene;
    ((eej)localObject).FMt = paramdoa.keN;
    ((eej)localObject).HOp.addAll(paramdoa.DBj);
    ((eej)localObject).HAv = ((int)paramdoa.HCf);
    paramdoa = new aag();
    paramdoa.key = "client_system_version";
    paramdoa.FZe = Build.VERSION.SDK_INT;
    ((eej)localObject).HOp.add(paramdoa);
    paramdoa = new aag();
    paramdoa.key = "netType";
    paramdoa.FZf = com.tencent.mm.plugin.websearch.api.ad.Ux();
    ((eej)localObject).HOp.add(paramdoa);
    paramdoa = new aag();
    paramdoa.key = "client_request_time";
    paramdoa.FZf = String.valueOf(System.currentTimeMillis());
    ((eej)localObject).HOp.add(paramdoa);
    paramdoa = ((eej)localObject).HOp.iterator();
    while (paramdoa.hasNext())
    {
      localObject = (aag)paramdoa.next();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "key: %s unit_value %s text_value %s", new Object[] { ((aag)localObject).key, Long.valueOf(((aag)localObject).FZe), ((aag)localObject).FZf });
    }
    AppMethodBeat.o(91025);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(91026);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91026);
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
    AppMethodBeat.i(91027);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.k
 * JD-Core Version:    0.7.0.1
 */