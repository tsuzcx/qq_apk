package com.tencent.mm.plugin.textstatus.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.loader.f.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/download/TextStatusLoader;", "", "()V", "AVATAR_MAX_WIDTH", "", "defaultOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "imageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/plugin/textstatus/download/TextStatusImage;", "Landroid/graphics/Bitmap;", "instance", "Lcom/tencent/mm/loader/Loader;", "getInstance", "()Lcom/tencent/mm/loader/Loader;", "plugin-textstatus_release"})
public final class d
{
  public static final d MAU;
  private static final com.tencent.mm.loader.d<b> zuJ;
  private static final com.tencent.mm.loader.c.e zuk;
  private static final com.tencent.mm.loader.c.d<b, Bitmap> zux;
  
  static
  {
    AppMethodBeat.i(232326);
    MAU = new d();
    Object localObject = new e.a();
    ((e.a)localObject).kOp = true;
    ((e.a)localObject).kOo = true;
    ((e.a)localObject).kOs = 1080;
    ((e.a)localObject).kOt = 1080;
    zuk = ((e.a)localObject).aRT();
    zux = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new a()).a((com.tencent.mm.loader.d.b)new c()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(zuk).aRE();
    localObject = com.tencent.mm.loader.e.kMy;
    zuJ = com.tencent.mm.loader.e.a(zux);
    AppMethodBeat.o(232326);
  }
  
  public static com.tencent.mm.loader.d<b> dJe()
  {
    return zuJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.c.d
 * JD-Core Version:    0.7.0.1
 */