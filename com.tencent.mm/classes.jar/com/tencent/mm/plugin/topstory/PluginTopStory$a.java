package com.tencent.mm.plugin.topstory;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

final class PluginTopStory$a
  implements Runnable
{
  private PluginTopStory$a(PluginTopStory paramPluginTopStory) {}
  
  public final void run()
  {
    AppMethodBeat.i(88409);
    Log.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard ftsrecommendVideo folder %b", new Object[] { Boolean.valueOf(s.dy(b.aKJ() + "ftsrecommendVideo/", true)) });
    Log.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard topstory folder %b", new Object[] { Boolean.valueOf(s.dy(b.aKJ() + "topstory/", true)) });
    Log.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard cache topstory folder %b", new Object[] { Boolean.valueOf(s.dy(MMApplicationContext.getContext().getCacheDir() + "topstory/", true)) });
    Object localObject1 = new o(h.fxQ());
    if (((o)localObject1).exists())
    {
      localObject1 = ((o)localObject1).het();
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          boolean bool = s.dy(aa.z(localObject2.her()), true);
          Log.i("MicroMsg.TopStory.PluginTopStory", "Delete Cache File %s %b", new Object[] { aa.z(localObject2.her()), Boolean.valueOf(bool) });
          i += 1;
        }
      }
      s.boN(h.fxQ() + ".nomedia/");
      AppMethodBeat.o(88409);
      return;
    }
    s.boN(h.fxQ());
    s.boN(h.fxQ() + ".nomedia/");
    Log.i("MicroMsg.TopStory.PluginTopStory", "Create TopStoryCacheFolder");
    AppMethodBeat.o(88409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.PluginTopStory.a
 * JD-Core Version:    0.7.0.1
 */