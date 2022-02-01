package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.b;
import com.tencent.mm.protocal.protobuf.esz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

final class m$c
  implements g.b
{
  private m$c(m paramm) {}
  
  public final void b(String paramString, d paramd)
  {
    AppMethodBeat.i(126114);
    if (this.Nap.Nan.containsKey(paramString))
    {
      esz localesz = (esz)this.Nap.Nan.get(paramString);
      localesz.Uvp = paramd.field_recvedBytes;
      localesz.Uvq = m.aJ(localesz.Uvp, (int)paramd.field_fileLength);
      localesz.Uvb = ((int)paramd.field_fileLength);
      this.Nap.Nan.put(paramString, localesz);
      Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "VideoPreloadCallback onFinish %s %d %s", new Object[] { paramString, Long.valueOf(localesz.Uvq), Util.getSizeMB(localesz.Uvp, 100.0D) });
    }
    AppMethodBeat.o(126114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m.c
 * JD-Core Version:    0.7.0.1
 */