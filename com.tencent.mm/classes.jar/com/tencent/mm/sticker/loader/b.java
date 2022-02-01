package com.tencent.mm.sticker.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/loader/LensIconDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/sticker/loader/LensIconData;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-sticker_release"})
public final class b
  extends com.tencent.mm.loader.b.a.a<a>
{
  public final boolean a(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105914);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    AppMethodBeat.o(105914);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(105913);
    p.h(parama, "url");
    p.h(paramf, "httpResponse");
    p.h(parame, "opts");
    p.h(paramf1, "reaper");
    AppMethodBeat.o(105913);
    return true;
  }
  
  public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105916);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    parama = c(parama, parame, paramf);
    if (o.fB(parama))
    {
      parama = com.tencent.mm.loader.h.b.a.yL(parama);
      AppMethodBeat.o(105916);
      return parama;
    }
    AppMethodBeat.o(105916);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105915);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    parame = e.IGU;
    o.aZI(e.frZ());
    parame = new StringBuilder();
    paramf = e.IGU;
    parama = e.frZ() + ((a)parama.value()).IFR.GwI;
    AppMethodBeat.o(105915);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.b
 * JD-Core Version:    0.7.0.1
 */