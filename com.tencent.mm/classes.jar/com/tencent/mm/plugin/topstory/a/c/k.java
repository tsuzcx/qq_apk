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
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private b rr;
  public dil zZP;
  
  public k(dil paramdil)
  {
    AppMethodBeat.i(91025);
    ac.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "Create NetSceneTopStory Video contextId:%s searchId:%s", new Object[] { paramdil.qox, paramdil.jKB });
    this.zZP = paramdil;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject).hvt = new dyj();
    ((b.a)localObject).hvu = new dyk();
    this.rr = ((b.a)localObject).aAz();
    localObject = (dyj)this.rr.hvr.hvw;
    ((dyj)localObject).EfV = paramdil.offset;
    ((dyj)localObject).FhS = z.Ul(1);
    ((dyj)localObject).EJp = paramdil.cZL;
    ((dyj)localObject).FhT = z.bJn();
    ((dyj)localObject).Scene = paramdil.scene;
    ((dyj)localObject).EfU = paramdil.jKB;
    ((dyj)localObject).Gdj.addAll(paramdil.BYq);
    ((dyj)localObject).FPQ = ((int)paramdil.FRz);
    paramdil = new yh();
    paramdil.key = "client_system_version";
    paramdil.ErV = Build.VERSION.SDK_INT;
    ((dyj)localObject).Gdj.add(paramdil);
    paramdil = new yh();
    paramdil.key = "netType";
    paramdil.ErW = z.dkv();
    ((dyj)localObject).Gdj.add(paramdil);
    paramdil = new yh();
    paramdil.key = "client_request_time";
    paramdil.ErW = String.valueOf(System.currentTimeMillis());
    ((dyj)localObject).Gdj.add(paramdil);
    paramdil = ((dyj)localObject).Gdj.iterator();
    while (paramdil.hasNext())
    {
      localObject = (yh)paramdil.next();
      ac.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "key: %s unit_value %s text_value %s", new Object[] { ((yh)localObject).key, Long.valueOf(((yh)localObject).ErV), ((yh)localObject).ErW });
    }
    AppMethodBeat.o(91025);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(91026);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(91026);
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
    AppMethodBeat.i(91027);
    ac.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.k
 * JD-Core Version:    0.7.0.1
 */