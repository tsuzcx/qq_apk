package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.loader.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/loader/StickerThumbLoader;", "", "()V", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/sticker/loader/LensIconData;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "plugin-sticker_release"})
public final class h
{
  public static final h IHc;
  private static final com.tencent.mm.loader.d<a> gkL;
  
  static
  {
    AppMethodBeat.i(105950);
    IHc = new h();
    Object localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.d.b)new c()).a((com.tencent.mm.loader.b.a.d)new b());
    Object localObject2 = new e.a();
    ((e.a)localObject2).hgP = true;
    localObject1 = ((com.tencent.mm.loader.c.b)localObject1).b(((e.a)localObject2).aru()).arf();
    localObject2 = e.hfa;
    gkL = e.a((com.tencent.mm.loader.c.d)localObject1);
    AppMethodBeat.o(105950);
  }
  
  public static com.tencent.mm.loader.d<a> getLoader()
  {
    return gkL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.h
 * JD-Core Version:    0.7.0.1
 */