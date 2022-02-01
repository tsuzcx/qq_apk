package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.topstory.a.d;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.fnt;
import com.tencent.mm.protocal.protobuf.fob;
import com.tencent.mm.protocal.protobuf.ght;
import com.tencent.mm.protocal.protobuf.ghu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private long hlB;
  public fnt ieC;
  private com.tencent.mm.am.c rr;
  
  public b(fnt paramfnt, int paramInt)
  {
    AppMethodBeat.i(271658);
    Log.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStory Home channelId:%s, %s %s %s", new Object[] { Integer.valueOf(paramfnt.channelId), Integer.valueOf(paramInt), paramfnt.zIO, paramfnt.sessionId });
    this.hlB = System.currentTimeMillis();
    this.ieC = paramfnt;
    Object localObject = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject).funcId = getType();
    ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((com.tencent.mm.am.c.a)localObject).otE = new ght();
    ((com.tencent.mm.am.c.a)localObject).otF = new ghu();
    this.rr = ((com.tencent.mm.am.c.a)localObject).bEF();
    ght localght = (ght)c.b.b(this.rr.otB);
    localght.YYs = paramfnt.offset;
    localght.aayc = aj.asY(1);
    localght.aakp = paramfnt.hAB;
    localght.aaLr = aj.dch();
    localght.IJG = paramfnt.scene;
    localght.YYr = paramfnt.mpa;
    localght.accs.addAll(paramfnt.Wol);
    localght.abMl = paramfnt.channelId;
    localght.acei = paramInt;
    localght.acej = paramfnt.abNI;
    localght.acee = paramfnt.sessionId;
    String str = paramfnt.abNJ;
    if (Util.isNullOrNil(str)) {
      str = paramfnt.abNK;
    }
    for (;;)
    {
      fob localfob;
      if (com.tencent.mm.plugin.topstory.a.g.aoK(paramfnt.channelId))
      {
        localfob = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hLZ();
        localObject = str;
        if (localfob != null) {
          localObject = localfob.msgId;
        }
      }
      for (;;)
      {
        localght.abqY = ((String)localObject);
        localght.acef = paramfnt.Wot;
        localght.aceg = paramfnt.abNH;
        paramfnt = new aem();
        paramfnt.key = "client_system_version";
        paramfnt.Zmx = Build.VERSION.SDK_INT;
        localght.accs.add(paramfnt);
        paramfnt = new aem();
        paramfnt.key = "netType";
        paramfnt.Zmy = aj.gtA();
        localght.accs.add(paramfnt);
        paramfnt = new aem();
        paramfnt.key = "client_request_time";
        paramfnt.Zmy = String.valueOf(System.currentTimeMillis());
        localght.accs.add(paramfnt);
        paramfnt = new aem();
        paramfnt.key = "clicfg_topstory_top_tab_params";
        paramfnt.Zmy = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yLJ, "{\"tabs\":[{\"wording\":\"在看\",\"wording_cn\":\"在看\",\"wording_en\":\"Wow\",\"wording_hk\":\"在看\",\"wording_tw\":\"在看\",\"category\":700,\"showWhenRedDot\":1,\"tabInfo\":\"{\\\"category\\\":700}\",\"bypass\":\"700\"},{\"wording\":\"热点\",\"wording_cn\":\"热点\",\"wording_en\":\"Top\",\"wording_hk\":\"熱點\",\"wording_tw\":\"熱點\",\"category\":100,\"showWhenRedDot\":0,\"tabInfo\":\"{\\\"category\\\":100}\"}]}");
        localght.accs.add(paramfnt);
        paramfnt = localght.accs.iterator();
        while (paramfnt.hasNext())
        {
          localObject = (aem)paramfnt.next();
          Log.i("MicroMsg.TopStory.NetSceneTopStory", "key: %s unit_value %s text_value %s", new Object[] { ((aem)localObject).key, Long.valueOf(((aem)localObject).Zmx), ((aem)localObject).Zmy });
        }
        if (com.tencent.mm.plugin.topstory.a.g.aoJ(paramfnt.channelId))
        {
          localfob = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hLV();
          localObject = str;
          if (localfob != null) {
            localObject = localfob.msgId;
          }
        }
        else
        {
          localObject = str;
          if (com.tencent.mm.plugin.topstory.a.g.aoL(paramfnt.channelId))
          {
            localfob = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMc();
            localObject = str;
            if (localfob != null) {
              localObject = localfob.msgId;
            }
          }
        }
      }
      Log.i("MicroMsg.TopStory.NetSceneTopStory", "request params offset %d h5Version %d CheckDocListSize: %d", new Object[] { Integer.valueOf(localght.YYs), Integer.valueOf(localght.aayc), Integer.valueOf(localght.aceg.size()) });
      AppMethodBeat.o(271658);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(91006);
    as.nb(this.ieC.scene, 2);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(91006);
    return i;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final ghu hMQ()
  {
    AppMethodBeat.i(271668);
    ghu localghu = (ghu)c.c.b(this.rr.otC);
    AppMethodBeat.o(271668);
    return localghu;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91007);
    Log.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.hlB) });
    if (paramInt3 == -1) {
      as.nb(this.ieC.scene, 4);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(91007);
      return;
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        as.nb(this.ieC.scene, 8);
      } else {
        as.nb(this.ieC.scene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.b
 * JD-Core Version:    0.7.0.1
 */