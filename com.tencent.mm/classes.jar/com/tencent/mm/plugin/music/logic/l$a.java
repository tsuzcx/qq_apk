package com.tencent.mm.plugin.music.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.autogen.a.ov;
import com.tencent.mm.autogen.a.ov.b;
import com.tencent.mm.aw.f;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.List;

final class l$a
  implements Runnable
{
  private l$a(l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(62964);
    long l = System.currentTimeMillis();
    l.a(this.LLM, true);
    Object localObject1 = this.LLM.gng();
    ArrayList localArrayList = new ArrayList();
    Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper.MusicType:%d", new Object[] { Integer.valueOf(((f)localObject1).oOt) });
    int i;
    label118:
    Object localObject2;
    switch (((f)localObject1).oOt)
    {
    case 2: 
    case 3: 
    case 5: 
    case 7: 
    default: 
      localObject1 = null;
      if (localObject1 == null) {
        break label348;
      }
      i = 0;
      if (i >= ((List)localObject1).size()) {
        break label348;
      }
      localObject2 = (f)((List)localObject1).get(i);
      if (localObject2 == null) {
        Log.e("MicroMsg.Music.MusicWechatPrivateLogic", "wrapper is null, continue");
      }
      break;
    }
    for (;;)
    {
      i += 1;
      break label118;
      localObject1 = new ht();
      ((ht)localObject1).hIR.type = 18;
      ((ht)localObject1).publish();
      localObject1 = ((ht)localObject1).hIS.hJf;
      break;
      localObject1 = new ov();
      ((ov)localObject1).hRE.action = -4;
      ((ov)localObject1).publish();
      localObject1 = ((ov)localObject1).hRF.hJf;
      break;
      localObject1 = new ov();
      ((ov)localObject1).hRE.action = -5;
      ((ov)localObject1).publish();
      localObject1 = ((ov)localObject1).hRF.hJf;
      break;
      localObject2 = new ov();
      ((ov)localObject2).hRE.action = -6;
      ((ov)localObject2).hRE.hRG = ((f)localObject1);
      ((ov)localObject2).publish();
      localObject1 = ((ov)localObject2).hRF.hJf;
      break;
      o.god().K((f)localObject2);
      localArrayList.add(com.tencent.mm.plugin.music.h.b.Y((f)localObject2));
    }
    label348:
    Log.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask run time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l.a(this.LLM, false);
    localObject1 = new l.c(this.LLM, (byte)0);
    ((l.c)localObject1).LLN = localArrayList;
    MMHandlerThread.postToMainThread((Runnable)localObject1);
    AppMethodBeat.o(62964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.logic.l.a
 * JD-Core Version:    0.7.0.1
 */