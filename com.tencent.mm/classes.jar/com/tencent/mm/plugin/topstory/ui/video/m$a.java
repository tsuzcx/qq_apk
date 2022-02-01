package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class m$a
  implements Runnable
{
  private String Cap;
  
  m$a(m paramm, String paramString)
  {
    this.Cap = paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(126112);
    Object localObject1 = new q(this.Cap);
    Object localObject2;
    if (((q)localObject1).ifE())
    {
      localObject1 = ((q)localObject1).ifJ();
      int j = this.Nap.Nao.size();
      int k = this.Nap.Nan.size();
      if (localObject1 != null) {}
      for (int i = localObject1.length;; i = 0)
      {
        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask preloadSize: %d cacheSize: %d folderSize: %d folderPath: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), this.Cap });
        if ((localObject1 == null) || (localObject1.length <= 10)) {
          break label448;
        }
        localObject2 = new ArrayList(localObject1.length);
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          ((List)localObject2).add(localObject1[i]);
          i += 1;
        }
      }
      Collections.sort((List)localObject2, new Comparator() {});
      Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "First: %s Last: %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", ((q)((List)localObject2).get(0)).lastModified() / 1000L), f.formatTime("yyyy-MM-dd HH:mm:ss", ((q)((List)localObject2).get(((List)localObject2).size() - 1)).lastModified() / 1000L) });
      localObject2 = ((List)localObject2).subList(10, ((List)localObject2).size());
      if (this.Nap.MYE == null) {
        break label478;
      }
      localObject1 = this.Nap.MYE.gqC().MWv;
      if (localObject1 == null) {
        break label478;
      }
    }
    label448:
    label478:
    for (localObject1 = d.bz(((esy)localObject1).Crh, ((esy)localObject1).UuV);; localObject1 = "")
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        q localq = (q)((Iterator)localObject2).next();
        String str = localq.getName().split("\\.")[0];
        if ((!str.equals(localObject1)) && (!this.Nap.Nao.contains(str)))
        {
          Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Delete cache video %s %s", new Object[] { localq.getName(), f.formatTime("yyyy-MM-dd HH:mm:ss", localq.lastModified() / 1000L) });
          this.Nap.Nan.remove(str);
          localq.cFq();
        }
      }
      AppMethodBeat.o(126112);
      return;
      Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask folder %s not exist", new Object[] { this.Cap });
      AppMethodBeat.o(126112);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m.a
 * JD-Core Version:    0.7.0.1
 */