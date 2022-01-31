package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class m$a
  implements Runnable
{
  private String kIi;
  
  m$a(m paramm, String paramString)
  {
    this.kIi = paramString;
  }
  
  public final void run()
  {
    Object localObject1 = new File(this.kIi);
    Object localObject2;
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = this.pFV.pFT.size();
      int k = this.pFV.pFS.size();
      if (localObject1 != null) {}
      for (int i = localObject1.length;; i = 0)
      {
        y.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask preloadSize: %d cacheSize: %d folderSize: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
        if ((localObject1 == null) || (localObject1.length <= 10)) {
          break label454;
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
      Collections.sort((List)localObject2, new m.a.1(this));
      y.i("MicroMsg.TopStory.TopStoryPreloadMgr", "First: %s Last: %s", new Object[] { h.g("yyyy-MM-dd HH:mm:ss", ((File)((List)localObject2).get(0)).lastModified() / 1000L), h.g("yyyy-MM-dd HH:mm:ss", ((File)((List)localObject2).get(((List)localObject2).size() - 1)).lastModified() / 1000L) });
      localObject2 = ((List)localObject2).subList(10, ((List)localObject2).size());
      if (this.pFV.pEp == null) {
        break label455;
      }
      localObject1 = this.pFV.pEp.bNx().pGw;
      if (localObject1 == null) {
        break label455;
      }
    }
    label454:
    label455:
    for (localObject1 = d.an(((byg)localObject1).tOx, ((byg)localObject1).tOy);; localObject1 = "")
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        File localFile = (File)((Iterator)localObject2).next();
        String str = localFile.getName().split("\\.")[0];
        if ((!str.equals(localObject1)) && (!this.pFV.pFT.contains(str)))
        {
          y.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Delete cache video %s %s", new Object[] { localFile.getName(), h.g("yyyy-MM-dd HH:mm:ss", localFile.lastModified() / 1000L) });
          this.pFV.pFS.remove(str);
          localFile.delete();
          continue;
          y.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask folder %s not exist", new Object[] { this.kIi });
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m.a
 * JD-Core Version:    0.7.0.1
 */