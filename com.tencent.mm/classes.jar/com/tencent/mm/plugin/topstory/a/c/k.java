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
import com.tencent.mm.protocal.protobuf.fal;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends q
  implements m
{
  public eit GjJ;
  private i callback;
  private d rr;
  
  public k(eit parameit)
  {
    AppMethodBeat.i(91025);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "Create NetSceneTopStory Video contextId:%s searchId:%s", new Object[] { parameit.sGQ, parameit.hes });
    this.GjJ = parameit;
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((d.a)localObject).iLN = new fal();
    ((d.a)localObject).iLO = new fam();
    this.rr = ((d.a)localObject).aXF();
    localObject = (fal)this.rr.iLK.iLR;
    ((fal)localObject).KZk = parameit.offset;
    ((fal)localObject).MaY = ai.aft(1);
    ((fal)localObject).LPT = parameit.dDv;
    ((fal)localObject).MlQ = ai.clJ();
    ((fal)localObject).Scene = parameit.scene;
    ((fal)localObject).KZj = parameit.hes;
    ((fal)localObject).Nva.addAll(parameit.IDO);
    ((fal)localObject).NgA = ((int)parameit.Nib);
    parameit = new aca();
    parameit.key = "client_system_version";
    parameit.LmC = Build.VERSION.SDK_INT;
    ((fal)localObject).Nva.add(parameit);
    parameit = new aca();
    parameit.key = "netType";
    parameit.LmD = ai.ait();
    ((fal)localObject).Nva.add(parameit);
    parameit = new aca();
    parameit.key = "client_request_time";
    parameit.LmD = String.valueOf(System.currentTimeMillis());
    ((fal)localObject).Nva.add(parameit);
    parameit = ((fal)localObject).Nva.iterator();
    while (parameit.hasNext())
    {
      localObject = (aca)parameit.next();
      Log.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "key: %s unit_value %s text_value %s", new Object[] { ((aca)localObject).key, Long.valueOf(((aca)localObject).LmC), ((aca)localObject).LmD });
    }
    AppMethodBeat.o(91025);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(91026);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(91026);
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
    AppMethodBeat.i(91027);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.k
 * JD-Core Version:    0.7.0.1
 */