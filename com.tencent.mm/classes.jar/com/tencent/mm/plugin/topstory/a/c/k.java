package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.ght;
import com.tencent.mm.protocal.protobuf.ghu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends p
  implements m
{
  public foe TIY;
  private h callback;
  private c rr;
  
  public k(foe paramfoe)
  {
    AppMethodBeat.i(91025);
    Log.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "Create NetSceneTopStory Video contextId:%s searchId:%s", new Object[] { paramfoe.zIO, paramfoe.mpa });
    this.TIY = paramfoe;
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((c.a)localObject).otE = new ght();
    ((c.a)localObject).otF = new ghu();
    this.rr = ((c.a)localObject).bEF();
    localObject = (ght)c.b.b(this.rr.otB);
    ((ght)localObject).YYs = paramfoe.offset;
    ((ght)localObject).aayc = aj.asY(1);
    ((ght)localObject).aakp = paramfoe.hAB;
    ((ght)localObject).aaLr = aj.dch();
    ((ght)localObject).IJG = paramfoe.scene;
    ((ght)localObject).YYr = paramfoe.mpa;
    ((ght)localObject).accs.addAll(paramfoe.Wol);
    ((ght)localObject).abMl = ((int)paramfoe.abOj);
    paramfoe = new aem();
    paramfoe.key = "client_system_version";
    paramfoe.Zmx = Build.VERSION.SDK_INT;
    ((ght)localObject).accs.add(paramfoe);
    paramfoe = new aem();
    paramfoe.key = "netType";
    paramfoe.Zmy = aj.gtA();
    ((ght)localObject).accs.add(paramfoe);
    paramfoe = new aem();
    paramfoe.key = "client_request_time";
    paramfoe.Zmy = String.valueOf(System.currentTimeMillis());
    ((ght)localObject).accs.add(paramfoe);
    paramfoe = ((ght)localObject).accs.iterator();
    while (paramfoe.hasNext())
    {
      localObject = (aem)paramfoe.next();
      Log.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "key: %s unit_value %s text_value %s", new Object[] { ((aem)localObject).key, Long.valueOf(((aem)localObject).Zmx), ((aem)localObject).Zmy });
    }
    AppMethodBeat.o(91025);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(91026);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(91026);
    return i;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final ghu hMQ()
  {
    AppMethodBeat.i(271671);
    ghu localghu = (ghu)c.c.b(this.rr.otC);
    AppMethodBeat.o(271671);
    return localghu;
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