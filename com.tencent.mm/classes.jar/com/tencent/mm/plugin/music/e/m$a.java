package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.g.a.kh.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.List;

final class m$a
  implements Runnable
{
  private m$a(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(104838);
    long l = System.currentTimeMillis();
    m.a(this.oZo, true);
    Object localObject1 = this.oZo.bVs();
    ArrayList localArrayList = new ArrayList();
    ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper.MusicType:%d", new Object[] { Integer.valueOf(((com.tencent.mm.aw.e)localObject1).fKh) });
    int i;
    label118:
    Object localObject2;
    switch (((com.tencent.mm.aw.e)localObject1).fKh)
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
      localObject2 = (com.tencent.mm.aw.e)((List)localObject1).get(i);
      if (localObject2 == null) {
        ab.e("MicroMsg.Music.MusicWechatPrivateLogic", "wrapper is null, continue");
      }
      break;
    }
    for (;;)
    {
      i += 1;
      break label118;
      localObject1 = new gi();
      ((gi)localObject1).cuX.type = 18;
      a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((gi)localObject1).cuY.cvl;
      break;
      localObject1 = new kh();
      ((kh)localObject1).czU.action = -4;
      a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((kh)localObject1).czV.cvl;
      break;
      localObject1 = new kh();
      ((kh)localObject1).czU.action = -5;
      a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((kh)localObject1).czV.cvl;
      break;
      localObject2 = new kh();
      ((kh)localObject2).czU.action = -6;
      ((kh)localObject2).czU.czW = ((com.tencent.mm.aw.e)localObject1);
      a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
      localObject1 = ((kh)localObject2).czV.cvl;
      break;
      com.tencent.mm.plugin.music.model.e.bVM().x((com.tencent.mm.aw.e)localObject2);
      localArrayList.add(com.tencent.mm.plugin.music.h.b.K((com.tencent.mm.aw.e)localObject2));
    }
    label360:
    ab.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask run time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    m.a(this.oZo, false);
    localObject1 = new m.b(this.oZo, (byte)0);
    ((m.b)localObject1).oZp = localArrayList;
    al.d((Runnable)localObject1);
    AppMethodBeat.o(104838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m.a
 * JD-Core Version:    0.7.0.1
 */