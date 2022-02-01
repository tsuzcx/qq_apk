package com.tencent.mm.plugin.thumbplayer.downloader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.loader.cache.memory.DefaultBitmapMemoryCache;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/downloader/CdnImageLoader;", "", "()V", "defaultOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "imageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/ImageLoadData;", "Landroid/graphics/Bitmap;", "instance", "Lcom/tencent/mm/loader/Loader;", "getInstance", "()Lcom/tencent/mm/loader/Loader;", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final com.tencent.mm.loader.d<g> EyH;
  private static final com.tencent.mm.loader.b.e Eyd;
  private static final com.tencent.mm.loader.b.d<g, Bitmap> Eyq;
  public static final b TCf;
  
  static
  {
    AppMethodBeat.i(272189);
    TCf = new b();
    Object localObject = new e.a();
    ((e.a)localObject).nqd = true;
    ((e.a)localObject).nqc = true;
    Eyd = ((e.a)localObject).blI();
    Eyq = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new f()).a((com.tencent.mm.loader.c.b)new a()).a((com.tencent.mm.loader.e.g)new com.tencent.mm.loader.d.a()).a((com.tencent.mm.loader.cache.memory.d)new DefaultBitmapMemoryCache()).b(Eyd).blt();
    localObject = com.tencent.mm.loader.e.noo;
    EyH = com.tencent.mm.loader.e.a(Eyq);
    AppMethodBeat.o(272189);
  }
  
  public static com.tencent.mm.loader.d<g> eCl()
  {
    return EyH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.downloader.b
 * JD-Core Version:    0.7.0.1
 */