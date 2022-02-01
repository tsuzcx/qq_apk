package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.loader.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/loader/StickerThumbLoader;", "", "()V", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/sticker/loader/LensIconData;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h acCW;
  private static final com.tencent.mm.loader.d<a> mgk;
  
  static
  {
    AppMethodBeat.i(105950);
    acCW = new h();
    Object localObject1 = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.c.b)new c()).a((com.tencent.mm.loader.cache.a.d)new b());
    Object localObject2 = new e.a();
    ((e.a)localObject2).nqd = true;
    localObject1 = ((com.tencent.mm.loader.b.b)localObject1).b(((e.a)localObject2).blI()).blt();
    localObject2 = e.noo;
    mgk = e.a((com.tencent.mm.loader.b.d)localObject1);
    AppMethodBeat.o(105950);
  }
  
  public static com.tencent.mm.loader.d<a> getLoader()
  {
    return mgk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.h
 * JD-Core Version:    0.7.0.1
 */