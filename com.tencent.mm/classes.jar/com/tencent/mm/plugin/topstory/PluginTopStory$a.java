package com.tencent.mm.plugin.topstory;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;

final class PluginTopStory$a
  implements Runnable
{
  private PluginTopStory$a(PluginTopStory paramPluginTopStory) {}
  
  public final void run()
  {
    AppMethodBeat.i(88409);
    ad.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard ftsrecommendVideo folder %b", new Object[] { Boolean.valueOf(i.cZ(b.arU() + "ftsrecommendVideo/", true)) });
    ad.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard topstory folder %b", new Object[] { Boolean.valueOf(i.cZ(b.arU() + "topstory/", true)) });
    ad.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard cache topstory folder %b", new Object[] { Boolean.valueOf(i.cZ(aj.getContext().getCacheDir() + "topstory/", true)) });
    Object localObject1 = new e(h.eoJ());
    if (((e)localObject1).exists())
    {
      localObject1 = ((e)localObject1).fOM();
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          boolean bool = i.cZ(q.B(localObject2.fOK()), true);
          ad.i("MicroMsg.TopStory.PluginTopStory", "Delete Cache File %s %b", new Object[] { q.B(localObject2.fOK()), Boolean.valueOf(bool) });
          i += 1;
        }
      }
      i.aYg(h.eoJ() + ".nomedia/");
      AppMethodBeat.o(88409);
      return;
    }
    i.aYg(h.eoJ());
    i.aYg(h.eoJ() + ".nomedia/");
    ad.i("MicroMsg.TopStory.PluginTopStory", "Create TopStoryCacheFolder");
    AppMethodBeat.o(88409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.PluginTopStory.a
 * JD-Core Version:    0.7.0.1
 */