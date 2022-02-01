package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.esk;
import com.tencent.mm.protocal.protobuf.ess;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends q
  implements m
{
  private i callback;
  public esk fYA;
  private long fhq;
  private d rr;
  
  public b(esk paramesk, int paramInt, String paramString)
  {
    AppMethodBeat.i(91005);
    Log.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStory Home channelId:%s, %s %s %s", new Object[] { Integer.valueOf(paramesk.channelId), Integer.valueOf(paramInt), paramesk.wmL, paramesk.sessionId });
    this.fhq = System.currentTimeMillis();
    this.fYA = paramesk;
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((d.a)localObject).lBU = new fle();
    ((d.a)localObject).lBV = new flf();
    this.rr = ((d.a)localObject).bgN();
    localObject = (fle)d.b.b(this.rr.lBR);
    ((fle)localObject).Sat = paramesk.offset;
    ((fle)localObject).Tkv = ai.anh(1);
    ((fle)localObject).SYn = paramesk.fwe;
    ((fle)localObject).TwK = ai.czn();
    ((fle)localObject).CPw = paramesk.scene;
    ((fle)localObject).Sas = paramesk.jQi;
    ((fle)localObject).UIj.addAll(paramesk.Pye);
    ((fle)localObject).Ute = paramesk.channelId;
    ((fle)localObject).UKa = paramInt;
    ((fle)localObject).UKb = paramesk.Uui;
    if ((((fle)localObject).Ute == 110) || (((fle)localObject).Ute == 700))
    {
      paramString = ((com.tencent.mm.plugin.topstory.a.b)h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().gpj();
      if (paramString != null) {
        ((fle)localObject).Uab = paramString.msgId;
      }
    }
    for (;;)
    {
      ((fle)localObject).UJY = paramesk.Pym;
      ((fle)localObject).UJZ = paramesk.Uuh;
      paramesk = new aci();
      paramesk.key = "client_system_version";
      paramesk.SnV = Build.VERSION.SDK_INT;
      ((fle)localObject).UIj.add(paramesk);
      paramesk = new aci();
      paramesk.key = "netType";
      paramesk.SnW = ai.anV();
      ((fle)localObject).UIj.add(paramesk);
      paramesk = new aci();
      paramesk.key = "client_request_time";
      paramesk.SnW = String.valueOf(System.currentTimeMillis());
      ((fle)localObject).UIj.add(paramesk);
      paramesk = new aci();
      paramesk.key = "clicfg_topstory_top_tab_params";
      paramesk.SnW = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyi, "{\"tabs\":[{\"wording\":\"朋友在看\",\"wording_cn\":\"朋友在看\",\"wording_en\":\"Wow\",\"wording_hk\":\"朋友在看\",\"wording_tw\":\"朋友在看\",\"category\":110,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":110}\"},{\"wording\":\"热点广场\",\"wording_cn\":\"热点广场\",\"wording_en\":\"Top\",\"wording_hk\":\"熱點廣場\",\"wording_tw\":\"熱點廣場\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
      ((fle)localObject).UIj.add(paramesk);
      paramesk = ((fle)localObject).UIj.iterator();
      while (paramesk.hasNext())
      {
        paramString = (aci)paramesk.next();
        Log.i("MicroMsg.TopStory.NetSceneTopStory", "key: %s unit_value %s text_value %s", new Object[] { paramString.key, Long.valueOf(paramString.SnV), paramString.SnW });
      }
      if (((fle)localObject).Ute == 100) {
        ((fle)localObject).Uab = paramString;
      } else {
        ((fle)localObject).Uab = "";
      }
    }
    Log.i("MicroMsg.TopStory.NetSceneTopStory", "request params offset %d h5Version %d CheckDocListSize: %d", new Object[] { Integer.valueOf(((fle)localObject).Sat), Integer.valueOf(((fle)localObject).Tkv), Integer.valueOf(((fle)localObject).UJZ.size()) });
    AppMethodBeat.o(91005);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(91006);
    ar.lr(this.fYA.scene, 2);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(91006);
    return i;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final flf gpU()
  {
    AppMethodBeat.i(191042);
    flf localflf = (flf)d.c.b(this.rr.lBS);
    AppMethodBeat.o(191042);
    return localflf;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91007);
    Log.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.fhq) });
    if (paramInt3 == -1) {
      ar.lr(this.fYA.scene, 4);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(91007);
      return;
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        ar.lr(this.fYA.scene, 8);
      } else {
        ar.lr(this.fYA.scene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.b
 * JD-Core Version:    0.7.0.1
 */