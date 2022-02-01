package com.tencent.mm.sticker.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/loader/LensIconDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/sticker/loader/LensIconData;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.loader.cache.a.a<a>
{
  public final boolean a(com.tencent.mm.loader.g.a.a<a> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105914);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    AppMethodBeat.o(105914);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.g.a.a<a> parama, com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(105913);
    s.u(parama, "url");
    s.u(paramf, "httpResponse");
    s.u(parame, "opts");
    s.u(paramf1, "reaper");
    AppMethodBeat.o(105913);
    return true;
  }
  
  public final com.tencent.mm.loader.g.b.a b(com.tencent.mm.loader.g.a.a<a> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105916);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    parama = c(parama, parame, paramf);
    if (y.ZC(parama))
    {
      parama = com.tencent.mm.loader.g.b.a.GJ(parama);
      AppMethodBeat.o(105916);
      return parama;
    }
    AppMethodBeat.o(105916);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.g.a.a<a> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(105915);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    parame = e.acCJ;
    y.bDX(e.iWC());
    parame = e.acCJ;
    parama = s.X(e.iWC(), ((a)parama.bmg()).acBO.LensId);
    AppMethodBeat.o(105915);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.b
 * JD-Core Version:    0.7.0.1
 */