package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.mf.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
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
    m.a(this.wAi, true);
    Object localObject1 = this.wAi.dwa();
    ArrayList localArrayList = new ArrayList();
    ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper.MusicType:%d", new Object[] { Integer.valueOf(((com.tencent.mm.ay.f)localObject1).ijX) });
    int i;
    label118:
    Object localObject2;
    switch (((com.tencent.mm.ay.f)localObject1).ijX)
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
      localObject2 = (com.tencent.mm.ay.f)((List)localObject1).get(i);
      if (localObject2 == null) {
        ae.e("MicroMsg.Music.MusicWechatPrivateLogic", "wrapper is null, continue");
      }
      break;
    }
    for (;;)
    {
      i += 1;
      break label118;
      localObject1 = new gx();
      ((gx)localObject1).dub.type = 18;
      a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((gx)localObject1).duc.dup;
      break;
      localObject1 = new mf();
      ((mf)localObject1).dAH.action = -4;
      a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((mf)localObject1).dAI.dup;
      break;
      localObject1 = new mf();
      ((mf)localObject1).dAH.action = -5;
      a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((mf)localObject1).dAI.dup;
      break;
      localObject2 = new mf();
      ((mf)localObject2).dAH.action = -6;
      ((mf)localObject2).dAH.dAJ = ((com.tencent.mm.ay.f)localObject1);
      a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
      localObject1 = ((mf)localObject2).dAI.dup;
      break;
      com.tencent.mm.plugin.music.model.f.dwu().B((com.tencent.mm.ay.f)localObject2);
      localArrayList.add(com.tencent.mm.plugin.music.h.b.O((com.tencent.mm.ay.f)localObject2));
    }
    label360:
    ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask run time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    m.a(this.wAi, false);
    localObject1 = new m.b(this.wAi, (byte)0);
    ((m.b)localObject1).wAj = localArrayList;
    ar.f((Runnable)localObject1);
    AppMethodBeat.o(62964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m.a
 * JD-Core Version:    0.7.0.1
 */