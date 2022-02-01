package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.fal;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends q
  implements m
{
  private eit GjJ;
  public eiw GjK;
  private i callback;
  private d rr;
  
  public h(eit parameit, int paramInt, eiw parameiw, long paramLong)
  {
    AppMethodBeat.i(91017);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "Create NetSceneTopStoryVideo %s %s %s", new Object[] { parameit.sGQ, parameit.hes, Long.valueOf(paramLong) });
    this.GjJ = parameit;
    this.GjK = parameiw;
    Object localObject1 = new d.a();
    ((d.a)localObject1).funcId = getType();
    ((d.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((d.a)localObject1).iLN = new fal();
    ((d.a)localObject1).iLO = new fam();
    this.rr = ((d.a)localObject1).aXF();
    localObject1 = (fal)this.rr.iLK.iLR;
    ((fal)localObject1).KZk = parameit.offset;
    ((fal)localObject1).MaY = ai.aft(1);
    ((fal)localObject1).LPT = parameit.dDv;
    ((fal)localObject1).MlQ = ai.clJ();
    ((fal)localObject1).Scene = parameit.scene;
    ((fal)localObject1).KZj = parameit.hes;
    ((fal)localObject1).Nva.addAll(parameit.IDO);
    Object localObject2 = ((fal)localObject1).Nva.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      aca localaca = (aca)((Iterator)localObject2).next();
      if (localaca.key.equals("relevant_vid")) {
        localaca.LmD = parameiw.psI;
      }
    }
    localObject2 = new aca();
    ((aca)localObject2).key = "relevant_vid";
    ((aca)localObject2).LmD = parameiw.psI;
    ((fal)localObject1).Nva.add(localObject2);
    ((fal)localObject1).NgA = ((int)parameit.Nib);
    ((fal)localObject1).MRy = paramInt;
    ((fal)localObject1).oUv = 1;
    parameit = new aca();
    parameit.key = "client_system_version";
    parameit.LmC = Build.VERSION.SDK_INT;
    ((fal)localObject1).Nva.add(parameit);
    parameit = new aca();
    parameit.key = "netType";
    parameit.LmD = ai.ait();
    ((fal)localObject1).Nva.add(parameit);
    parameit = new aca();
    parameit.key = "client_request_time";
    parameit.LmD = String.valueOf(System.currentTimeMillis());
    ((fal)localObject1).Nva.add(parameit);
    parameit = new aca();
    parameit.key = "relevant_play_time";
    parameit.LmD = String.valueOf(paramLong);
    parameit.LmC = paramLong;
    ((fal)localObject1).Nva.add(parameit);
    parameit = ((fal)localObject1).Nva.iterator();
    while (parameit.hasNext())
    {
      parameiw = (aca)parameit.next();
      Log.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "key: %s unit_value %s text_value %s", new Object[] { parameiw.key, Long.valueOf(parameiw.LmC), parameiw.LmD });
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
  
  public final fam fxZ()
  {
    return (fam)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91019);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.h
 * JD-Core Version:    0.7.0.1
 */