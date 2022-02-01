package com.tencent.mm.plugin.textstatus.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/download/TextStatusDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/textstatus/download/TextStatusImage;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-textstatus_release"})
public final class a
  extends com.tencent.mm.loader.b.a.a<b>
{
  public final boolean a(com.tencent.mm.loader.h.a.a<b> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(232991);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    AppMethodBeat.o(232991);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<b> parama, com.tencent.mm.loader.h.f<?> paramf, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(232989);
    p.k(parama, "url");
    p.k(paramf, "httpResponse");
    p.k(parame, "opts");
    p.k(paramf1, "reaper");
    AppMethodBeat.o(232989);
    return true;
  }
  
  public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<b> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(232994);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    String str = c(parama, parame, paramf);
    boolean bool = u.agG(str);
    Log.d("TextStatusLoader", "get() called with: ret = " + bool + " url = " + parama + ", opts = " + parame + ", reaper = " + paramf);
    if (bool)
    {
      parama = com.tencent.mm.loader.h.b.a.Ov(str);
      AppMethodBeat.o(232994);
      return parama;
    }
    AppMethodBeat.o(232994);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.h.a.a<b> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(232993);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    parame = com.tencent.mm.plugin.textstatus.k.f.MOw;
    parama = ((b)parama.aSr()).toString();
    p.k(parama, "url");
    parame = com.tencent.mm.plugin.textstatus.k.f.gnC() + "icon";
    if (!u.agG(parame)) {
      u.bBD(parame);
    }
    parame = new StringBuilder().append(parame).append("/");
    parama = parama.getBytes(d.UTF_8);
    p.j(parama, "(this as java.lang.String).getBytes(charset)");
    parama = g.getMessageDigest(parama);
    AppMethodBeat.o(232993);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.c.a
 * JD-Core Version:    0.7.0.1
 */