package com.tencent.mm.plugin.story.model.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.b.a;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.loader.f.f;
import com.tencent.mm.plugin.story.c.a.a.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "", "()V", "fileNameCreator", "Lcom/tencent/mm/loader/impr/DefaultFileNameCreator;", "mOptionsCommon", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mOptionsForAlbum", "mStoryLoader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loader", "options", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "plugin-story_release"})
public final class e
{
  public com.tencent.mm.loader.d<d> syi;
  private final com.tencent.mm.loader.e.a syj;
  public final com.tencent.mm.loader.c.e syk;
  public final com.tencent.mm.loader.c.e syl;
  
  public e()
  {
    AppMethodBeat.i(109302);
    this.syj = new com.tencent.mm.loader.e.a();
    Object localObject1 = new e.a().TG().TF().TI();
    j.p(localObject1, "ImageLoaderOptions.Build…cheInMemory(true).build()");
    this.syk = ((com.tencent.mm.loader.c.e)localObject1);
    localObject1 = new e.a().TG().TF().TH().jW(((a.a)com.tencent.mm.plugin.story.c.a.a.srz.Uw()).srN).jV(((a.a)com.tencent.mm.plugin.story.c.a.a.srz.Uw()).srO).TI();
    j.p(localObject1, "ImageLoaderOptions.Build….albumThumbWidth).build()");
    this.syl = ((com.tencent.mm.loader.c.e)localObject1);
    localObject1 = new com.tencent.mm.loader.c.a();
    Object localObject2 = (com.tencent.mm.loader.b.a.d)new b();
    j.q(localObject2, "cache");
    ((com.tencent.mm.loader.c.b)localObject1).eNy = ((com.tencent.mm.loader.b.a.d)localObject2);
    localObject2 = (com.tencent.mm.loader.d.b)new c();
    j.q(localObject2, "downloader");
    ((com.tencent.mm.loader.c.b)localObject1).eNz = ((com.tencent.mm.loader.d.b)localObject2);
    localObject2 = (f)this.syj;
    j.q(localObject2, "creater");
    ((com.tencent.mm.loader.c.b)localObject1).eNA = ((f)localObject2);
    localObject2 = (com.tencent.mm.loader.b.b.d)new com.tencent.mm.loader.b.b.a();
    j.q(localObject2, "cache");
    ((com.tencent.mm.loader.c.b)localObject1).eNx = ((com.tencent.mm.loader.b.b.d)localObject2);
    localObject2 = this.syk;
    j.q(localObject2, "options");
    ((com.tencent.mm.loader.c.b)localObject1).eNw = ((com.tencent.mm.loader.c.e)localObject2);
    localObject1 = (com.tencent.mm.loader.c.d)new b.a((com.tencent.mm.loader.c.b)localObject1);
    localObject2 = com.tencent.mm.loader.e.eME;
    this.syi = com.tencent.mm.loader.e.a((com.tencent.mm.loader.c.d)localObject1);
    AppMethodBeat.o(109302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.c.e
 * JD-Core Version:    0.7.0.1
 */