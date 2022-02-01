package com.tencent.mm.plugin.textstatus.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.loader.cache.memory.DefaultBitmapMemoryCache;
import com.tencent.mm.loader.e.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/download/TextStatusLoader;", "", "()V", "AVATAR_MAX_WIDTH", "", "defaultOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "imageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/plugin/textstatus/download/TextStatusImage;", "Landroid/graphics/Bitmap;", "instance", "Lcom/tencent/mm/loader/Loader;", "getInstance", "()Lcom/tencent/mm/loader/Loader;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final com.tencent.mm.loader.d<b> EyH;
  private static final com.tencent.mm.loader.b.e Eyd;
  private static final com.tencent.mm.loader.b.d<b, Bitmap> Eyq;
  public static final d TkB;
  
  static
  {
    AppMethodBeat.i(289660);
    TkB = new d();
    Object localObject = new e.a();
    ((e.a)localObject).nqd = true;
    ((e.a)localObject).nqc = true;
    ((e.a)localObject).nqg = 1080;
    ((e.a)localObject).nqh = 1080;
    Eyd = ((e.a)localObject).blI();
    Eyq = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new a()).a((com.tencent.mm.loader.c.b)new c()).a((g)new com.tencent.mm.loader.d.a()).a((com.tencent.mm.loader.cache.memory.d)new DefaultBitmapMemoryCache()).b(Eyd).blt();
    localObject = com.tencent.mm.loader.e.noo;
    EyH = com.tencent.mm.loader.e.a(Eyq);
    AppMethodBeat.o(289660);
  }
  
  public static com.tencent.mm.loader.d<b> eCl()
  {
    return EyH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.c.d
 * JD-Core Version:    0.7.0.1
 */