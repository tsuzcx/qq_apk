package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.protocal.protobuf.dou;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  private f callback;
  public dom dMt;
  private com.tencent.mm.ak.b rr;
  private long szi;
  
  public b(dom paramdom, int paramInt, String paramString)
  {
    AppMethodBeat.i(91005);
    ae.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStory Home channelId:%s, %s %s %s", new Object[] { Integer.valueOf(paramdom.cSM), Integer.valueOf(paramInt), paramdom.rfA, paramdom.sessionId });
    this.szi = System.currentTimeMillis();
    this.dMt = paramdom;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject).hQF = new ega();
    ((b.a)localObject).hQG = new egb();
    this.rr = ((b.a)localObject).aDS();
    localObject = (ega)this.rr.hQD.hQJ;
    ((ega)localObject).GeT = paramdom.offset;
    ((ega)localObject).GWA = ad.WL(1);
    ((ega)localObject).GLP = paramdom.dmf;
    ((ega)localObject).HkU = ad.bOD();
    ((ega)localObject).Scene = paramdom.scene;
    ((ega)localObject).GeS = paramdom.kid;
    ((ega)localObject).Iiw.addAll(paramdom.DTg);
    ((ega)localObject).HUi = paramdom.cSM;
    ((ega)localObject).IjL = paramInt;
    ((ega)localObject).IjM = paramdom.HVs;
    if (((ega)localObject).HUi == 110)
    {
      paramString = ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().erR();
      if (paramString != null) {
        ((ega)localObject).HDq = paramString.msgId;
      }
    }
    for (;;)
    {
      ((ega)localObject).IjJ = paramdom.DTo;
      ((ega)localObject).IjK = paramdom.HVr;
      paramdom = new aaj();
      paramdom.key = "client_system_version";
      paramdom.GrE = Build.VERSION.SDK_INT;
      ((ega)localObject).Iiw.add(paramdom);
      paramdom = new aaj();
      paramdom.key = "netType";
      paramdom.GrF = ad.UD();
      ((ega)localObject).Iiw.add(paramdom);
      paramdom = new aaj();
      paramdom.key = "client_request_time";
      paramdom.GrF = String.valueOf(System.currentTimeMillis());
      ((ega)localObject).Iiw.add(paramdom);
      paramdom = ((ega)localObject).Iiw.iterator();
      while (paramdom.hasNext())
      {
        paramString = (aaj)paramdom.next();
        ae.i("MicroMsg.TopStory.NetSceneTopStory", "key: %s unit_value %s text_value %s", new Object[] { paramString.key, Long.valueOf(paramString.GrE), paramString.GrF });
      }
      if (((ega)localObject).HUi == 100) {
        ((ega)localObject).HDq = paramString;
      } else {
        ((ega)localObject).HDq = "";
      }
    }
    ae.i("MicroMsg.TopStory.NetSceneTopStory", "request params offset %d h5Version %d CheckDocListSize: %d", new Object[] { Integer.valueOf(((ega)localObject).GeT), Integer.valueOf(((ega)localObject).GWA), Integer.valueOf(((ega)localObject).IjK.size()) });
    AppMethodBeat.o(91005);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(91006);
    am.iV(this.dMt.scene, 2);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91006);
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
    AppMethodBeat.i(91007);
    ae.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.szi) });
    if (paramInt3 == -1) {
      am.iV(this.dMt.scene, 4);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(91007);
      return;
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        am.iV(this.dMt.scene, 8);
      } else {
        am.iV(this.dMt.scene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.b
 * JD-Core Version:    0.7.0.1
 */