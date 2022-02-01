package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.a.me.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;
import java.util.List;

final class m$a
  implements Runnable
{
  private m$a(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(62964);
    long l = System.currentTimeMillis();
    m.a(this.wkz, true);
    Object localObject1 = this.wkz.dsL();
    ArrayList localArrayList = new ArrayList();
    ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper.MusicType:%d", new Object[] { Integer.valueOf(((com.tencent.mm.az.f)localObject1).ihe) });
    int i;
    label118:
    Object localObject2;
    switch (((com.tencent.mm.az.f)localObject1).ihe)
    {
    case 2: 
    case 3: 
    case 5: 
    case 7: 
    default: 
      localObject1 = null;
      if (localObject1 == null) {
        break label360;
      }
      i = 0;
      if (i >= ((List)localObject1).size()) {
        break label360;
      }
      localObject2 = (com.tencent.mm.az.f)((List)localObject1).get(i);
      if (localObject2 == null) {
        ad.e("MicroMsg.Music.MusicWechatPrivateLogic", "wrapper is null, continue");
      }
      break;
    }
    for (;;)
    {
      i += 1;
      break label118;
      localObject1 = new gw();
      ((gw)localObject1).dsV.type = 18;
      a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((gw)localObject1).dsW.dtj;
      break;
      localObject1 = new me();
      ((me)localObject1).dzC.action = -4;
      a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((me)localObject1).dzD.dtj;
      break;
      localObject1 = new me();
      ((me)localObject1).dzC.action = -5;
      a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((me)localObject1).dzD.dtj;
      break;
      localObject2 = new me();
      ((me)localObject2).dzC.action = -6;
      ((me)localObject2).dzC.dzE = ((com.tencent.mm.az.f)localObject1);
      a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
      localObject1 = ((me)localObject2).dzD.dtj;
      break;
      com.tencent.mm.plugin.music.model.f.dtf().B((com.tencent.mm.az.f)localObject2);
      localArrayList.add(com.tencent.mm.plugin.music.h.b.O((com.tencent.mm.az.f)localObject2));
    }
    label360:
    ad.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask run time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    m.a(this.wkz, false);
    localObject1 = new m.b(this.wkz, (byte)0);
    ((m.b)localObject1).wkA = localArrayList;
    aq.f((Runnable)localObject1);
    AppMethodBeat.o(62964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m.a
 * JD-Core Version:    0.7.0.1
 */