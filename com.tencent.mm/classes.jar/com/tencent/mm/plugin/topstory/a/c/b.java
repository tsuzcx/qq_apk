package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public dia dyS;
  private com.tencent.mm.ak.b rr;
  private long rxC;
  
  public b(dia paramdia, int paramInt, String paramString)
  {
    AppMethodBeat.i(91005);
    ac.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStory Home channelId:%s, %s %s %s", new Object[] { Integer.valueOf(paramdia.cGY), Integer.valueOf(paramInt), paramdia.qox, paramdia.sessionId });
    this.rxC = System.currentTimeMillis();
    this.dyS = paramdia;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject).hvt = new dyj();
    ((b.a)localObject).hvu = new dyk();
    this.rr = ((b.a)localObject).aAz();
    localObject = (dyj)this.rr.hvr.hvw;
    ((dyj)localObject).EfV = paramdia.offset;
    ((dyj)localObject).FhS = z.Ul(1);
    ((dyj)localObject).EJp = paramdia.cZL;
    ((dyj)localObject).FhT = z.bJn();
    ((dyj)localObject).Scene = paramdia.scene;
    ((dyj)localObject).EfU = paramdia.jKB;
    ((dyj)localObject).Gdj.addAll(paramdia.BYq);
    ((dyj)localObject).FPQ = paramdia.cGY;
    ((dyj)localObject).Gey = paramInt;
    ((dyj)localObject).Gez = paramdia.FQZ;
    if (((dyj)localObject).FPQ == 110)
    {
      paramString = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ebT();
      if (paramString != null) {
        ((dyj)localObject).FzI = paramString.dtG;
      }
    }
    for (;;)
    {
      ((dyj)localObject).Gew = paramdia.BYy;
      ((dyj)localObject).Gex = paramdia.FQY;
      paramdia = new yh();
      paramdia.key = "client_system_version";
      paramdia.ErV = Build.VERSION.SDK_INT;
      ((dyj)localObject).Gdj.add(paramdia);
      paramdia = new yh();
      paramdia.key = "netType";
      paramdia.ErW = z.dkv();
      ((dyj)localObject).Gdj.add(paramdia);
      paramdia = new yh();
      paramdia.key = "client_request_time";
      paramdia.ErW = String.valueOf(System.currentTimeMillis());
      ((dyj)localObject).Gdj.add(paramdia);
      paramdia = ((dyj)localObject).Gdj.iterator();
      while (paramdia.hasNext())
      {
        paramString = (yh)paramdia.next();
        ac.i("MicroMsg.TopStory.NetSceneTopStory", "key: %s unit_value %s text_value %s", new Object[] { paramString.key, Long.valueOf(paramString.ErV), paramString.ErW });
      }
      if (((dyj)localObject).FPQ == 100) {
        ((dyj)localObject).FzI = paramString;
      } else {
        ((dyj)localObject).FzI = "";
      }
    }
    ac.i("MicroMsg.TopStory.NetSceneTopStory", "request params offset %d h5Version %d CheckDocListSize: %d", new Object[] { Integer.valueOf(((dyj)localObject).EfV), Integer.valueOf(((dyj)localObject).FhS), Integer.valueOf(((dyj)localObject).Gex.size()) });
    AppMethodBeat.o(91005);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(91006);
    ai.iE(this.dyS.scene, 2);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91006);
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
    AppMethodBeat.i(91007);
    ac.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.rxC) });
    if (paramInt3 == -1) {
      ai.iE(this.dyS.scene, 4);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(91007);
      return;
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        ai.iE(this.dyS.scene, 8);
      } else {
        ai.iE(this.dyS.scene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.b
 * JD-Core Version:    0.7.0.1
 */