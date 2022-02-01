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
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private b rr;
  public dcy yLX;
  
  public k(dcy paramdcy)
  {
    AppMethodBeat.i(91025);
    ad.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "Create NetSceneTopStory Video contextId:%s searchId:%s", new Object[] { paramdcy.qwV, paramdcy.jko });
    this.yLX = paramdcy;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject).gUU = new dss();
    ((b.a)localObject).gUV = new dst();
    this.rr = ((b.a)localObject).atI();
    localObject = (dss)this.rr.gUS.gUX;
    ((dss)localObject).CNt = paramdcy.offset;
    ((dss)localObject).DLD = aa.Sb(1);
    ((dss)localObject).Dop = paramdcy.dcm;
    ((dss)localObject).DLE = aa.bCk();
    ((dss)localObject).Scene = paramdcy.scene;
    ((dss)localObject).CNs = paramdcy.jko;
    ((dss)localObject).EFX.addAll(paramdcy.AFX);
    ((dss)localObject).EsO = ((int)paramdcy.Euy);
    paramdcy = new xp();
    paramdcy.key = "client_system_version";
    paramdcy.CZi = Build.VERSION.SDK_INT;
    ((dss)localObject).EFX.add(paramdcy);
    paramdcy = new xp();
    paramdcy.key = "netType";
    paramdcy.CZj = aa.cWN();
    ((dss)localObject).EFX.add(paramdcy);
    paramdcy = new xp();
    paramdcy.key = "client_request_time";
    paramdcy.CZj = String.valueOf(System.currentTimeMillis());
    ((dss)localObject).EFX.add(paramdcy);
    paramdcy = ((dss)localObject).EFX.iterator();
    while (paramdcy.hasNext())
    {
      localObject = (xp)paramdcy.next();
      ad.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "key: %s unit_value %s text_value %s", new Object[] { ((xp)localObject).key, Long.valueOf(((xp)localObject).CZi), ((xp)localObject).CZj });
    }
    AppMethodBeat.o(91025);
  }
  
  public final dst dOd()
  {
    return (dst)this.rr.gUT.gUX;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(91026);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91026);
    return i;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91027);
    ad.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.k
 * JD-Core Version:    0.7.0.1
 */