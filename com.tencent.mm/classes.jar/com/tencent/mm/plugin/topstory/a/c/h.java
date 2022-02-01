package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.protocal.protobuf.ght;
import com.tencent.mm.protocal.protobuf.ghu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends p
  implements m
{
  private foe TIY;
  public foh TIZ;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public h(foe paramfoe, int paramInt, foh paramfoh, long paramLong)
  {
    AppMethodBeat.i(91017);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "Create NetSceneTopStoryVideo %s %s %s", new Object[] { paramfoe.zIO, paramfoe.mpa, Long.valueOf(paramLong) });
    this.TIY = paramfoe;
    this.TIZ = paramfoh;
    Object localObject1 = new c.a();
    ((c.a)localObject1).funcId = getType();
    ((c.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((c.a)localObject1).otE = new ght();
    ((c.a)localObject1).otF = new ghu();
    this.rr = ((c.a)localObject1).bEF();
    localObject1 = (ght)c.b.b(this.rr.otB);
    ((ght)localObject1).YYs = paramfoe.offset;
    ((ght)localObject1).aayc = aj.asY(1);
    ((ght)localObject1).aakp = paramfoe.hAB;
    ((ght)localObject1).aaLr = aj.dch();
    ((ght)localObject1).IJG = paramfoe.scene;
    ((ght)localObject1).YYr = paramfoe.mpa;
    ((ght)localObject1).accs.addAll(paramfoe.Wol);
    Object localObject2 = ((ght)localObject1).accs.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      aem localaem = (aem)((Iterator)localObject2).next();
      if (localaem.key.equals("relevant_vid")) {
        localaem.Zmy = paramfoh.Ido;
      }
    }
    localObject2 = new aem();
    ((aem)localObject2).key = "relevant_vid";
    ((aem)localObject2).Zmy = paramfoh.Ido;
    ((ght)localObject1).accs.add(localObject2);
    ((ght)localObject1).abMl = ((int)paramfoe.abOj);
    ((ght)localObject1).aceh = paramInt;
    ((ght)localObject1).vhJ = 1;
    paramfoe = new aem();
    paramfoe.key = "client_system_version";
    paramfoe.Zmx = Build.VERSION.SDK_INT;
    ((ght)localObject1).accs.add(paramfoe);
    paramfoe = new aem();
    paramfoe.key = "netType";
    paramfoe.Zmy = aj.gtA();
    ((ght)localObject1).accs.add(paramfoe);
    paramfoe = new aem();
    paramfoe.key = "client_request_time";
    paramfoe.Zmy = String.valueOf(System.currentTimeMillis());
    ((ght)localObject1).accs.add(paramfoe);
    paramfoe = new aem();
    paramfoe.key = "relevant_play_time";
    paramfoe.Zmy = String.valueOf(paramLong);
    paramfoe.Zmx = paramLong;
    ((ght)localObject1).accs.add(paramfoe);
    paramfoe = ((ght)localObject1).accs.iterator();
    while (paramfoe.hasNext())
    {
      paramfoh = (aem)paramfoe.next();
      Log.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "key: %s unit_value %s text_value %s", new Object[] { paramfoh.key, Long.valueOf(paramfoh.Zmx), paramfoh.Zmy });
    }
    AppMethodBeat.o(91017);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(91018);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(91018);
    return i;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final ghu hMQ()
  {
    AppMethodBeat.i(271659);
    ghu localghu = (ghu)c.c.b(this.rr.otC);
    AppMethodBeat.o(271659);
    return localghu;
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