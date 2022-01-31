package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.j.d;
import com.tencent.mm.j.f.b;
import com.tencent.mm.protocal.c.byh;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class m$c
  implements f.b
{
  private m$c(m paramm) {}
  
  public final void a(String paramString, d paramd)
  {
    if (this.pFV.pFS.containsKey(paramString))
    {
      byh localbyh = (byh)this.pFV.pFS.get(paramString);
      localbyh.tOL = paramd.field_recvedBytes;
      localbyh.tOM = m.N(localbyh.tOL, paramd.field_fileLength);
      localbyh.tOF = paramd.field_fileLength;
      this.pFV.pFS.put(paramString, localbyh);
      y.i("MicroMsg.TopStory.TopStoryPreloadMgr", "VideoPreloadCallback onFinish %s %d %s", new Object[] { paramString, Long.valueOf(localbyh.tOM), bk.a(localbyh.tOL, 100.0D) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m.c
 * JD-Core Version:    0.7.0.1
 */