package com.tencent.mm.plugin.story.model.c;

import a.f.b.j;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/download/StoryDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-story_release"})
public final class b
  extends com.tencent.mm.loader.b.a.a<d>
{
  public final String a(com.tencent.mm.loader.h.a.a<d> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(109290);
    j.q(parama, "url");
    j.q(parame, "opts");
    j.q(paramf, "reaper");
    parame = com.tencent.mm.plugin.story.model.l.svv;
    parama = com.tencent.mm.plugin.story.model.l.gM(((d)parama.value()).syh.Id, ((d)parama.value()).username);
    parame = com.tencent.mm.plugin.story.model.l.svv;
    com.tencent.mm.plugin.story.model.l.adc(parama);
    AppMethodBeat.o(109290);
    return parama;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<d> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(109288);
    j.q(parama, "url");
    j.q(paramf, "httpResponse");
    j.q(parame, "opts");
    j.q(paramf1, "reaper");
    AppMethodBeat.o(109288);
    return true;
  }
  
  public final boolean b(com.tencent.mm.loader.h.a.a<d> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(109289);
    j.q(parama, "url");
    j.q(parame, "opts");
    j.q(paramf, "reaper");
    AppMethodBeat.o(109289);
    return true;
  }
  
  public final com.tencent.mm.loader.h.b.a c(com.tencent.mm.loader.h.a.a<d> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(109291);
    j.q(parama, "url");
    j.q(parame, "opts");
    j.q(paramf, "reaper");
    parame = a(parama, parame, paramf);
    boolean bool = com.tencent.mm.vfs.e.cN(parame);
    ab.i(g.getTAG(), "url " + parama + " and path " + parame + " ret " + bool);
    if (bool)
    {
      parama = com.tencent.mm.loader.h.b.a.mM(parame);
      AppMethodBeat.o(109291);
      return parama;
    }
    paramf = com.tencent.mm.plugin.story.model.l.svv;
    paramf = com.tencent.mm.plugin.story.model.l.acX(((d)parama.value()).syh.Id);
    bool = com.tencent.mm.vfs.e.cN(paramf);
    ab.i(g.getTAG(), "thumb url " + parama + " and path " + parame + " ret " + bool);
    if (bool)
    {
      parama = com.tencent.mm.loader.h.b.a.mM(paramf);
      AppMethodBeat.o(109291);
      return parama;
    }
    AppMethodBeat.o(109291);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.c.b
 * JD-Core Version:    0.7.0.1
 */