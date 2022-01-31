package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.b;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "startTick", "", "(J)V", "onPreloadCompleted", "", "mediaId", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-story_release"})
final class p$d
  implements g.b
{
  private final long ewN;
  
  public p$d(long paramLong)
  {
    this.ewN = paramLong;
  }
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(110878);
    ab.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", sceneResult:" + paramd);
    if ((paramd != null) && (paramd.field_retCode == -21112))
    {
      ab.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + paramString + ", video source change!");
      paramd = p.sUH;
      p.adJ(paramString);
      AppMethodBeat.o(110878);
      return;
    }
    if ((paramString != null) && (paramd != null))
    {
      Object localObject = p.sUH;
      if (p.cGm().containsKey(paramString))
      {
        localObject = p.sUH;
        localObject = (i)p.cGm().get(paramString);
        if (localObject != null)
        {
          if ((paramd.field_recvedBytes > 0) && (paramd.field_fileLength > 0))
          {
            s locals = s.swk;
            localObject = s.a((i)localObject);
            ((n)localObject).field_cacheSize = paramd.field_recvedBytes;
            ((n)localObject).field_totalSize = paramd.field_fileLength;
            paramd = j.svi;
            j.b.cAF().b((n)localObject);
            paramd = p.sUH;
            p.cGn().add(paramString);
            ab.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted update cacheSize:" + ((n)localObject).field_cacheSize + ", totalSize:" + ((n)localObject).field_totalSize + ", preloadCost:" + bo.av(this.ewN));
            b.b((a)new p.d.a(paramString));
            AppMethodBeat.o(110878);
            return;
          }
          ab.e("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted error, recvedBytes:" + paramd.field_recvedBytes + ", fileLength:" + paramd.field_fileLength);
        }
      }
    }
    AppMethodBeat.o(110878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.p.d
 * JD-Core Version:    0.7.0.1
 */