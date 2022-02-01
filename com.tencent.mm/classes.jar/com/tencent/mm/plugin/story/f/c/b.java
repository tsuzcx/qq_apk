package com.tencent.mm.plugin.story.f.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/download/StoryDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-story_release"})
public final class b
  extends com.tencent.mm.loader.b.a.a<d>
{
  public final boolean a(com.tencent.mm.loader.h.a.a<d> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(118892);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    AppMethodBeat.o(118892);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<d> parama, com.tencent.mm.loader.h.f<?> paramf, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(118891);
    p.h(parama, "url");
    p.h(paramf, "httpResponse");
    p.h(parame, "opts");
    p.h(paramf1, "reaper");
    AppMethodBeat.o(118891);
    return true;
  }
  
  public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<d> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(118894);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    parame = c(parama, parame, paramf);
    boolean bool = o.fB(parame);
    ae.i(g.getTAG(), "url " + parama + " and path " + parame + " ret " + bool);
    if (bool)
    {
      parama = com.tencent.mm.loader.h.b.a.yL(parame);
      AppMethodBeat.o(118894);
      return parama;
    }
    paramf = com.tencent.mm.plugin.story.f.l.BbR;
    paramf = com.tencent.mm.plugin.story.f.l.aCZ(((d)parama.value()).BdM.Id);
    bool = o.fB(paramf);
    ae.i(g.getTAG(), "thumb url " + parama + " and path " + parame + " ret " + bool);
    if (bool)
    {
      parama = com.tencent.mm.loader.h.b.a.yL(paramf);
      AppMethodBeat.o(118894);
      return parama;
    }
    AppMethodBeat.o(118894);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.h.a.a<d> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(118893);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    parame = com.tencent.mm.plugin.story.f.l.BbR;
    parama = com.tencent.mm.plugin.story.f.l.kj(((d)parama.value()).BdM.Id, ((d)parama.value()).username);
    parame = com.tencent.mm.plugin.story.f.l.BbR;
    com.tencent.mm.plugin.story.f.l.axq(parama);
    AppMethodBeat.o(118893);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.b
 * JD-Core Version:    0.7.0.1
 */