package com.tencent.mm.plugin.story.f.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/download/StoryDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-story_release"})
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
    boolean bool = i.fv(parame);
    ad.i(g.getTAG(), "url " + parama + " and path " + parame + " ret " + bool);
    if (bool)
    {
      parama = com.tencent.mm.loader.h.b.a.yb(parame);
      AppMethodBeat.o(118894);
      return parama;
    }
    paramf = com.tencent.mm.plugin.story.f.l.AKo;
    paramf = com.tencent.mm.plugin.story.f.l.aBG(((d)parama.value()).AMk.Id);
    bool = i.fv(paramf);
    ad.i(g.getTAG(), "thumb url " + parama + " and path " + parame + " ret " + bool);
    if (bool)
    {
      parama = com.tencent.mm.loader.h.b.a.yb(paramf);
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
    parame = com.tencent.mm.plugin.story.f.l.AKo;
    parama = com.tencent.mm.plugin.story.f.l.kc(((d)parama.value()).AMk.Id, ((d)parama.value()).username);
    parame = com.tencent.mm.plugin.story.f.l.AKo;
    com.tencent.mm.plugin.story.f.l.awb(parama);
    AppMethodBeat.o(118893);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.b
 * JD-Core Version:    0.7.0.1
 */