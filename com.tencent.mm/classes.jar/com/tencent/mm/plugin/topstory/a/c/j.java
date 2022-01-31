package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends m
  implements k
{
  private f callback;
  private b rr;
  public ckw tfp;
  
  public j(ckw paramckw)
  {
    AppMethodBeat.i(96400);
    a(paramckw, 0, 0, "");
    AppMethodBeat.o(96400);
  }
  
  public j(ckw paramckw, int paramInt, String paramString)
  {
    AppMethodBeat.i(96401);
    a(paramckw, paramInt, 1, paramString);
    AppMethodBeat.o(96401);
  }
  
  private void a(ckw paramckw, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(96402);
    ab.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "Create NetSceneTopStory Video %s", new Object[] { paramckw.xUt, paramckw.hng });
    this.tfp = paramckw;
    Object localObject1 = new b.a();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject1).fsX = new cyg();
    ((b.a)localObject1).fsY = new cyh();
    this.rr = ((b.a)localObject1).ado();
    localObject1 = (cyg)this.rr.fsV.fta;
    ((cyg)localObject1).wzS = paramckw.offset;
    ((cyg)localObject1).xqT = aa.Jf(1);
    ((cyg)localObject1).wXt = paramckw.cnv;
    ((cyg)localObject1).xqU = aa.acv();
    ((cyg)localObject1).Scene = paramckw.scene;
    ((cyg)localObject1).wBZ = paramckw.hng;
    ((cyg)localObject1).yel.addAll(paramckw.uIO);
    if (!bo.isNullOrNil(paramString))
    {
      Object localObject2 = ((cyg)localObject1).yel.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        up localup = (up)((Iterator)localObject2).next();
        if (localup.key.equals("relevant_vid")) {
          localup.wMN = paramString;
        }
      }
      localObject2 = new up();
      ((up)localObject2).key = "relevant_vid";
      ((up)localObject2).wMN = paramString;
      ((cyg)localObject1).yel.add(localObject2);
    }
    ((cyg)localObject1).xTB = ((int)paramckw.xUO);
    ((cyg)localObject1).xIl = paramInt1;
    ((cyg)localObject1).jKs = paramInt2;
    paramckw = new up();
    paramckw.key = "client_system_version";
    paramckw.wMM = Build.VERSION.SDK_INT;
    ((cyg)localObject1).yel.add(paramckw);
    paramckw = new up();
    paramckw.key = "netType";
    paramckw.wMN = aa.bXn();
    ((cyg)localObject1).yel.add(paramckw);
    paramckw = new up();
    paramckw.key = "client_request_time";
    paramckw.wMN = String.valueOf(System.currentTimeMillis());
    ((cyg)localObject1).yel.add(paramckw);
    paramckw = ((cyg)localObject1).yel.iterator();
    while (paramckw.hasNext())
    {
      paramString = (up)paramckw.next();
      ab.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "key: %s unit_value %s text_value %s", new Object[] { paramString.key, Long.valueOf(paramString.wMM), paramString.wMN });
    }
    AppMethodBeat.o(96402);
  }
  
  public final cyh cID()
  {
    return (cyh)this.rr.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(96403);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(96403);
    return i;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96404);
    ab.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(96404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.j
 * JD-Core Version:    0.7.0.1
 */