package com.tencent.mm.sticker.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/loader/LensIconDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/sticker/loader/LensIconData;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-sticker_release"})
public final class b
  extends com.tencent.mm.loader.b.a.a<a>
{
  public final boolean a(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105914);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    AppMethodBeat.o(105914);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(105913);
    p.k(parama, "url");
    p.k(paramf, "httpResponse");
    p.k(parame, "opts");
    p.k(paramf1, "reaper");
    AppMethodBeat.o(105913);
    return true;
  }
  
  public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105916);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    parama = c(parama, parame, paramf);
    if (u.agG(parama))
    {
      parama = com.tencent.mm.loader.h.b.a.Ov(parama);
      AppMethodBeat.o(105916);
      return parama;
    }
    AppMethodBeat.o(105916);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105915);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    parame = e.Vbx;
    u.bBD(e.hva());
    parame = new StringBuilder();
    paramf = e.Vbx;
    parama = e.hva() + ((a)parama.aSr()).Vat.LensId;
    AppMethodBeat.o(105915);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.b
 * JD-Core Version:    0.7.0.1
 */