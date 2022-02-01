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
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends q
  implements m
{
  public esv MWu;
  private i callback;
  private d rr;
  
  public k(esv paramesv)
  {
    AppMethodBeat.i(91025);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "Create NetSceneTopStory Video contextId:%s searchId:%s", new Object[] { paramesv.wmL, paramesv.jQi });
    this.MWu = paramesv;
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((d.a)localObject).lBU = new fle();
    ((d.a)localObject).lBV = new flf();
    this.rr = ((d.a)localObject).bgN();
    localObject = (fle)d.b.b(this.rr.lBR);
    ((fle)localObject).Sat = paramesv.offset;
    ((fle)localObject).Tkv = ai.anh(1);
    ((fle)localObject).SYn = paramesv.fwe;
    ((fle)localObject).TwK = ai.czn();
    ((fle)localObject).CPw = paramesv.scene;
    ((fle)localObject).Sas = paramesv.jQi;
    ((fle)localObject).UIj.addAll(paramesv.Pye);
    ((fle)localObject).Ute = ((int)paramesv.UuH);
    paramesv = new aci();
    paramesv.key = "client_system_version";
    paramesv.SnV = Build.VERSION.SDK_INT;
    ((fle)localObject).UIj.add(paramesv);
    paramesv = new aci();
    paramesv.key = "netType";
    paramesv.SnW = ai.anV();
    ((fle)localObject).UIj.add(paramesv);
    paramesv = new aci();
    paramesv.key = "client_request_time";
    paramesv.SnW = String.valueOf(System.currentTimeMillis());
    ((fle)localObject).UIj.add(paramesv);
    paramesv = ((fle)localObject).UIj.iterator();
    while (paramesv.hasNext())
    {
      localObject = (aci)paramesv.next();
      Log.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "key: %s unit_value %s text_value %s", new Object[] { ((aci)localObject).key, Long.valueOf(((aci)localObject).SnV), ((aci)localObject).SnW });
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
  
  public final int getType()
  {
    return 1943;
  }
  
  public final flf gpU()
  {
    AppMethodBeat.i(191140);
    flf localflf = (flf)d.c.b(this.rr.lBS);
    AppMethodBeat.o(191140);
    return localflf;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91027);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(91027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.k
 * JD-Core Version:    0.7.0.1
 */