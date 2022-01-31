package com.tencent.mm.plugin.music.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.i.a.a.a;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class g$1$2
  implements Runnable
{
  g$1$2(g.1 param1) {}
  
  public final void run()
  {
    if (e.bmM()) {}
    for (boolean bool = ((c)b.Q(c.class)).bmI();; bool = false)
    {
      if (bool) {
        Toast.makeText(ae.getContext(), ae.getContext().getString(a.a.music_file_wrong), 0).show();
      }
      return;
      y.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.g.1.2
 * JD-Core Version:    0.7.0.1
 */