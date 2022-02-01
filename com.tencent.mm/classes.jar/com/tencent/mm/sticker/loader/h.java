package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.loader.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/loader/StickerThumbLoader;", "", "()V", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/sticker/loader/LensIconData;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "plugin-sticker_release"})
public final class h
{
  public static final h VbF;
  private static final com.tencent.mm.loader.d<a> jGC;
  
  static
  {
    AppMethodBeat.i(105950);
    VbF = new h();
    Object localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.d.b)new c()).a((com.tencent.mm.loader.b.a.d)new b());
    Object localObject2 = new e.a();
    ((e.a)localObject2).kOp = true;
    localObject1 = ((com.tencent.mm.loader.c.b)localObject1).b(((e.a)localObject2).aRT()).aRE();
    localObject2 = e.kMy;
    jGC = e.a((com.tencent.mm.loader.c.d)localObject1);
    AppMethodBeat.o(105950);
  }
  
  public static com.tencent.mm.loader.d<a> getLoader()
  {
    return jGC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.h
 * JD-Core Version:    0.7.0.1
 */