package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;

final class PluginTopStory$a
  implements Runnable
{
  private PluginTopStory$a(PluginTopStory paramPluginTopStory) {}
  
  public final void run()
  {
    AppMethodBeat.i(65445);
    ab.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard ftsrecommendVideo folder %b", new Object[] { Boolean.valueOf(com.tencent.mm.a.e.cO(com.tencent.mm.compatible.util.e.eQz + "ftsrecommendVideo/")) });
    ab.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard topstory folder %b", new Object[] { Boolean.valueOf(com.tencent.mm.a.e.cO(com.tencent.mm.compatible.util.e.eQz + "topstory/")) });
    Object localObject1 = new File(com.tencent.mm.plugin.topstory.a.g.cIv());
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          boolean bool = com.tencent.mm.a.e.cO(localObject2.getAbsolutePath());
          ab.i("MicroMsg.TopStory.PluginTopStory", "Delete Cache File %s %b", new Object[] { localObject2.getAbsolutePath(), Boolean.valueOf(bool) });
          i += 1;
        }
      }
      com.tencent.mm.vfs.e.um(com.tencent.mm.plugin.topstory.a.g.cIv() + ".nomedia/");
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJK, Long.valueOf(0L));
      AppMethodBeat.o(65445);
      return;
      com.tencent.mm.vfs.e.um(com.tencent.mm.plugin.topstory.a.g.cIv());
      com.tencent.mm.vfs.e.um(com.tencent.mm.plugin.topstory.a.g.cIv() + ".nomedia/");
      ab.i("MicroMsg.TopStory.PluginTopStory", "Create TopStoryCacheFolder");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.PluginTopStory.a
 * JD-Core Version:    0.7.0.1
 */