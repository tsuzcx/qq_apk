package com.tencent.mm.plugin.textstatus.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/download/TextStatusDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/textstatus/download/TextStatusImage;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.loader.cache.a.a<b>
{
  public final boolean a(com.tencent.mm.loader.g.a.a<b> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(289663);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    AppMethodBeat.o(289663);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.g.a.a<b> parama, com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(289656);
    s.u(parama, "url");
    s.u(paramf, "httpResponse");
    s.u(parame, "opts");
    s.u(paramf1, "reaper");
    AppMethodBeat.o(289656);
    return true;
  }
  
  public final com.tencent.mm.loader.g.b.a b(com.tencent.mm.loader.g.a.a<b> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(289670);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    String str = c(parama, parame, paramf);
    boolean bool = y.ZC(str);
    Log.d("MicroMsg.TextStatus.TextStatusLoader", "get() called with: ret = " + bool + " url = " + parama + ", opts = " + parame + ", reaper = " + paramf);
    if (bool)
    {
      parama = com.tencent.mm.loader.g.b.a.GJ(str);
      AppMethodBeat.o(289670);
      return parama;
    }
    AppMethodBeat.o(289670);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.g.a.a<b> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(289666);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    parame = com.tencent.mm.plugin.textstatus.util.e.TAU;
    parama = ((b)parama.bmg()).toString();
    s.u(parama, "url");
    parame = s.X(com.tencent.mm.plugin.textstatus.util.e.hKl(), "icon");
    if (!y.ZC(parame)) {
      y.bDX(parame);
    }
    parame = new StringBuilder().append(parame).append('/');
    parama = parama.getBytes(d.UTF_8);
    s.s(parama, "(this as java.lang.String).getBytes(charset)");
    parama = g.getMessageDigest(parama);
    AppMethodBeat.o(289666);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.c.a
 * JD-Core Version:    0.7.0.1
 */