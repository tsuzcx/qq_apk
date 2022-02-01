package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public dcn dBe;
  private com.tencent.mm.al.b rr;
  private long yLW;
  
  public b(dcn paramdcn, int paramInt, String paramString)
  {
    AppMethodBeat.i(91005);
    ad.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStory Home channelId:%s, %s %s %s", new Object[] { Integer.valueOf(paramdcn.cJR), Integer.valueOf(paramInt), paramdcn.qwV, paramdcn.sessionId });
    this.yLW = System.currentTimeMillis();
    this.dBe = paramdcn;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject).gUU = new dss();
    ((b.a)localObject).gUV = new dst();
    this.rr = ((b.a)localObject).atI();
    localObject = (dss)this.rr.gUS.gUX;
    ((dss)localObject).CNt = paramdcn.offset;
    ((dss)localObject).DLD = aa.Sb(1);
    ((dss)localObject).Dop = paramdcn.dcm;
    ((dss)localObject).DLE = aa.bCk();
    ((dss)localObject).Scene = paramdcn.scene;
    ((dss)localObject).CNs = paramdcn.jko;
    ((dss)localObject).EFX.addAll(paramdcn.AFX);
    ((dss)localObject).EsO = paramdcn.cJR;
    ((dss)localObject).EHm = paramInt;
    ((dss)localObject).EHn = paramdcn.EtY;
    if (((dss)localObject).EsO == 110)
    {
      paramString = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().dNt();
      if (paramString != null) {
        ((dss)localObject).EcN = paramString.dvT;
      }
    }
    for (;;)
    {
      ((dss)localObject).EHk = paramdcn.AGg;
      ((dss)localObject).EHl = paramdcn.EtX;
      paramdcn = new xp();
      paramdcn.key = "client_system_version";
      paramdcn.CZi = Build.VERSION.SDK_INT;
      ((dss)localObject).EFX.add(paramdcn);
      paramdcn = new xp();
      paramdcn.key = "netType";
      paramdcn.CZj = aa.cWN();
      ((dss)localObject).EFX.add(paramdcn);
      paramdcn = new xp();
      paramdcn.key = "client_request_time";
      paramdcn.CZj = String.valueOf(System.currentTimeMillis());
      ((dss)localObject).EFX.add(paramdcn);
      paramdcn = ((dss)localObject).EFX.iterator();
      while (paramdcn.hasNext())
      {
        paramString = (xp)paramdcn.next();
        ad.i("MicroMsg.TopStory.NetSceneTopStory", "key: %s unit_value %s text_value %s", new Object[] { paramString.key, Long.valueOf(paramString.CZi), paramString.CZj });
      }
      if (((dss)localObject).EsO == 100) {
        ((dss)localObject).EcN = paramString;
      } else {
        ((dss)localObject).EcN = "";
      }
    }
    ad.i("MicroMsg.TopStory.NetSceneTopStory", "request params offset %d h5Version %d CheckDocListSize: %d", new Object[] { Integer.valueOf(((dss)localObject).CNt), Integer.valueOf(((dss)localObject).DLD), Integer.valueOf(((dss)localObject).EHl.size()) });
    AppMethodBeat.o(91005);
  }
  
  public final dst dOd()
  {
    return (dst)this.rr.gUT.gUX;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(91006);
    ak.ip(this.dBe.scene, 2);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91006);
    return i;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91007);
    ad.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.yLW) });
    if (paramInt3 == -1) {
      ak.ip(this.dBe.scene, 4);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(91007);
      return;
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        ak.ip(this.dBe.scene, 8);
      } else {
        ak.ip(this.dBe.scene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.b
 * JD-Core Version:    0.7.0.1
 */