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
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  public dox BJa;
  private f callback;
  private b rr;
  
  public k(dox paramdox)
  {
    AppMethodBeat.i(91025);
    ae.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "Create NetSceneTopStory Video contextId:%s searchId:%s", new Object[] { paramdox.rfA, paramdox.kid });
    this.BJa = paramdox;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject).hQF = new ega();
    ((b.a)localObject).hQG = new egb();
    this.rr = ((b.a)localObject).aDS();
    localObject = (ega)this.rr.hQD.hQJ;
    ((ega)localObject).GeT = paramdox.offset;
    ((ega)localObject).GWA = ad.WL(1);
    ((ega)localObject).GLP = paramdox.dmf;
    ((ega)localObject).HkU = ad.bOD();
    ((ega)localObject).Scene = paramdox.scene;
    ((ega)localObject).GeS = paramdox.kid;
    ((ega)localObject).Iiw.addAll(paramdox.DTg);
    ((ega)localObject).HUi = ((int)paramdox.HVS);
    paramdox = new aaj();
    paramdox.key = "client_system_version";
    paramdox.GrE = Build.VERSION.SDK_INT;
    ((ega)localObject).Iiw.add(paramdox);
    paramdox = new aaj();
    paramdox.key = "netType";
    paramdox.GrF = ad.UD();
    ((ega)localObject).Iiw.add(paramdox);
    paramdox = new aaj();
    paramdox.key = "client_request_time";
    paramdox.GrF = String.valueOf(System.currentTimeMillis());
    ((ega)localObject).Iiw.add(paramdox);
    paramdox = ((ega)localObject).Iiw.iterator();
    while (paramdox.hasNext())
    {
      localObject = (aaj)paramdox.next();
      ae.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "key: %s unit_value %s text_value %s", new Object[] { ((aaj)localObject).key, Long.valueOf(((aaj)localObject).GrE), ((aaj)localObject).GrF });
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
    AppMethodBeat.i(91027);
    ae.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.k
 * JD-Core Version:    0.7.0.1
 */