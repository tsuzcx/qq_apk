package com.tencent.mm.plugin.story.model.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.e;
import com.tencent.mm.plugin.story.model.k;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/download/StoryDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.loader.cache.a.a<d>
{
  public final boolean a(com.tencent.mm.loader.g.a.a<d> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(118892);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    AppMethodBeat.o(118892);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.g.a.a<d> parama, com.tencent.mm.loader.g.f<?> paramf, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(118891);
    s.u(parama, "url");
    s.u(paramf, "httpResponse");
    s.u(parame, "opts");
    s.u(paramf1, "reaper");
    AppMethodBeat.o(118891);
    return true;
  }
  
  public final com.tencent.mm.loader.g.b.a b(com.tencent.mm.loader.g.a.a<d> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(118894);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    parame = c(parama, parame, paramf);
    boolean bool = y.ZC(parame);
    Log.i(f.getTAG(), "url " + parama + " and path " + parame + " ret " + bool);
    if (bool)
    {
      parama = com.tencent.mm.loader.g.b.a.GJ(parame);
      AppMethodBeat.o(118894);
      return parama;
    }
    paramf = k.Skq;
    paramf = k.bbM(((d)parama.bmg()).SlY.Id);
    bool = y.ZC(paramf);
    Log.i(f.getTAG(), "thumb url " + parama + " and path " + parame + " ret " + bool);
    if (bool)
    {
      parama = com.tencent.mm.loader.g.b.a.GJ(paramf);
      AppMethodBeat.o(118894);
      return parama;
    }
    AppMethodBeat.o(118894);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.g.a.a<d> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(118893);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    parama = k.Skq.nc(((d)parama.bmg()).SlY.Id, ((d)parama.bmg()).username);
    parame = k.Skq;
    k.aTB(parama);
    AppMethodBeat.o(118893);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.c.b
 * JD-Core Version:    0.7.0.1
 */