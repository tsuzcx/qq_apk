package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.b;
import com.tencent.mm.protocal.protobuf.cky;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class m$c
  implements g.b
{
  private m$c(m paramm) {}
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(1749);
    if (this.tjs.tjq.containsKey(paramString))
    {
      cky localcky = (cky)this.tjs.tjq.get(paramString);
      localcky.xVt = paramd.field_recvedBytes;
      localcky.xVu = m.ac(localcky.xVt, paramd.field_fileLength);
      localcky.xVi = paramd.field_fileLength;
      this.tjs.tjq.put(paramString, localcky);
      ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "VideoPreloadCallback onFinish %s %d %s", new Object[] { paramString, Long.valueOf(localcky.xVu), bo.b(localcky.xVt, 100.0D) });
    }
    AppMethodBeat.o(1749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m.c
 * JD-Core Version:    0.7.0.1
 */