package com.tencent.mm.plugin.thumbplayer.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/downloader/CdnImageLoader;", "", "()V", "defaultOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "imageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/ImageLoadData;", "Landroid/graphics/Bitmap;", "instance", "Lcom/tencent/mm/loader/Loader;", "getInstance", "()Lcom/tencent/mm/loader/Loader;", "plugin-thumbplayer_release"})
public final class b
{
  public static final b MPE;
  private static final com.tencent.mm.loader.d<g> zuJ;
  private static final com.tencent.mm.loader.c.e zuk;
  private static final com.tencent.mm.loader.c.d<g, Bitmap> zux;
  
  static
  {
    AppMethodBeat.i(189956);
    MPE = new b();
    Object localObject = new e.a();
    ((e.a)localObject).kOp = true;
    ((e.a)localObject).kOo = true;
    zuk = ((e.a)localObject).aRT();
    zux = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new f()).a((com.tencent.mm.loader.d.b)new a()).a((com.tencent.mm.loader.f.g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(zuk).aRE();
    localObject = com.tencent.mm.loader.e.kMy;
    zuJ = com.tencent.mm.loader.e.a(zux);
    AppMethodBeat.o(189956);
  }
  
  public static com.tencent.mm.loader.d<g> dJe()
  {
    return zuJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.b
 * JD-Core Version:    0.7.0.1
 */