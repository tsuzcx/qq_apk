package com.tencent.mm.plugin.thumbplayer.downloader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/downloader/ImageDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/ImageLoadData;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "_resource", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.loader.cache.a.a<g>
{
  public final boolean a(com.tencent.mm.loader.g.a.a<g> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(272175);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    AppMethodBeat.o(272175);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.g.a.a<g> parama, com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(272166);
    s.u(parama, "url");
    s.u(paramf, "httpResponse");
    s.u(parame, "opts");
    s.u(paramf1, "reaper");
    AppMethodBeat.o(272166);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.g.a.a<g> parama, com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.g.e<Bitmap> parame1, com.tencent.mm.loader.g.e<Bitmap> parame2, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(272196);
    s.u(parama, "url");
    s.u(paramf, "httpResponse");
    s.u(parame1, "source");
    s.u(parame, "opts");
    s.u(paramf1, "reaper");
    parame2 = c(parama, parame, paramf1);
    Log.printInfoStack(c.aUw(), "save " + parama + " filePath " + parame2 + ' ' + parame1 + ", " + parame1.value, new Object[0]);
    Object localObject = com.tencent.mm.loader.cache.a.c.npb;
    localObject = com.tencent.mm.loader.cache.a.c.GF(parame2);
    if (localObject != null) {
      parame2 = (Closeable)localObject;
    }
    try
    {
      Log.i(c.aUw(), s.X("open stream save ", parama));
      parame1 = parame1.value;
      if (parame1 == null) {
        break label254;
      }
      parame1 = (Bitmap)parame1;
      com.tencent.mm.loader.cache.a.c localc = com.tencent.mm.loader.cache.a.c.npb;
      com.tencent.mm.loader.cache.a.c.a(parame1, (OutputStream)localObject);
      Log.i(c.aUw(), s.X("finished compress to local file: ", parama));
      i = 1;
    }
    finally
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.o(272196);
          throw parama;
        }
        finally
        {
          b.a(parame2, parama);
          AppMethodBeat.o(272196);
        }
        int i = 0;
      }
    }
    if (i == 0) {
      paramf.b((OutputStream)localObject);
    }
    a(parama, parame, paramf1);
    Log.i(c.aUw(), s.X("call onCompleted finished: ", parama));
    parama = ah.aiuX;
    b.a(parame2, null);
    AppMethodBeat.o(272196);
    return true;
  }
  
  public final com.tencent.mm.loader.g.b.a b(com.tencent.mm.loader.g.a.a<g> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(272207);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    parame = c(parama, parame, paramf);
    Log.v(c.aUw(), "url " + parama + " and path " + parame + " fileret " + y.ZC(parame));
    if (y.ZC(parame))
    {
      parama = com.tencent.mm.loader.g.b.a.GJ(parame);
      AppMethodBeat.o(272207);
      return parama;
    }
    AppMethodBeat.o(272207);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.g.a.a<g> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(272185);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    parama = ((g)parama.bmg()).filePath;
    AppMethodBeat.o(272185);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.downloader.f
 * JD-Core Version:    0.7.0.1
 */