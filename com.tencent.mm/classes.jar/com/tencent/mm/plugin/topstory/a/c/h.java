package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends q
  implements m
{
  private esv MWu;
  public esy MWv;
  private i callback;
  private d rr;
  
  public h(esv paramesv, int paramInt, esy paramesy, long paramLong)
  {
    AppMethodBeat.i(91017);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "Create NetSceneTopStoryVideo %s %s %s", new Object[] { paramesv.wmL, paramesv.jQi, Long.valueOf(paramLong) });
    this.MWu = paramesv;
    this.MWv = paramesy;
    Object localObject1 = new d.a();
    ((d.a)localObject1).funcId = getType();
    ((d.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((d.a)localObject1).lBU = new fle();
    ((d.a)localObject1).lBV = new flf();
    this.rr = ((d.a)localObject1).bgN();
    localObject1 = (fle)d.b.b(this.rr.lBR);
    ((fle)localObject1).Sat = paramesv.offset;
    ((fle)localObject1).Tkv = ai.anh(1);
    ((fle)localObject1).SYn = paramesv.fwe;
    ((fle)localObject1).TwK = ai.czn();
    ((fle)localObject1).CPw = paramesv.scene;
    ((fle)localObject1).Sas = paramesv.jQi;
    ((fle)localObject1).UIj.addAll(paramesv.Pye);
    Object localObject2 = ((fle)localObject1).UIj.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      aci localaci = (aci)((Iterator)localObject2).next();
      if (localaci.key.equals("relevant_vid")) {
        localaci.SnW = paramesy.Crh;
      }
    }
    localObject2 = new aci();
    ((aci)localObject2).key = "relevant_vid";
    ((aci)localObject2).SnW = paramesy.Crh;
    ((fle)localObject1).UIj.add(localObject2);
    ((fle)localObject1).Ute = ((int)paramesv.UuH);
    ((fle)localObject1).UdE = paramInt;
    ((fle)localObject1).rWu = 1;
    paramesv = new aci();
    paramesv.key = "client_system_version";
    paramesv.SnV = Build.VERSION.SDK_INT;
    ((fle)localObject1).UIj.add(paramesv);
    paramesv = new aci();
    paramesv.key = "netType";
    paramesv.SnW = ai.anV();
    ((fle)localObject1).UIj.add(paramesv);
    paramesv = new aci();
    paramesv.key = "client_request_time";
    paramesv.SnW = String.valueOf(System.currentTimeMillis());
    ((fle)localObject1).UIj.add(paramesv);
    paramesv = new aci();
    paramesv.key = "relevant_play_time";
    paramesv.SnW = String.valueOf(paramLong);
    paramesv.SnV = paramLong;
    ((fle)localObject1).UIj.add(paramesv);
    paramesv = ((fle)localObject1).UIj.iterator();
    while (paramesv.hasNext())
    {
      paramesy = (aci)paramesv.next();
      Log.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "key: %s unit_value %s text_value %s", new Object[] { paramesy.key, Long.valueOf(paramesy.SnV), paramesy.SnW });
    }
    AppMethodBeat.o(91017);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(91018);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(91018);
    return i;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final flf gpU()
  {
    AppMethodBeat.i(190899);
    flf localflf = (flf)d.c.b(this.rr.lBS);
    AppMethodBeat.o(190899);
    return localflf;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91019);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.h
 * JD-Core Version:    0.7.0.1
 */