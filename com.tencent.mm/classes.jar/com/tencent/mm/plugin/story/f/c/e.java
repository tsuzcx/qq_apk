package com.tencent.mm.plugin.story.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.loader.f.f;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.sdk.platformtools.ai;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "", "()V", "fileNameCreator", "Lcom/tencent/mm/loader/impr/DefaultFileNameCreator;", "mOptionsCommon", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mOptionsForAlbum", "mStoryLoader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loader", "options", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "plugin-story_release"})
public final class e
{
  public com.tencent.mm.loader.d<d> zuq;
  private final com.tencent.mm.loader.e.a zur;
  public final com.tencent.mm.loader.c.e zus;
  public final com.tencent.mm.loader.c.e zut;
  
  public e()
  {
    AppMethodBeat.i(118905);
    this.zur = new com.tencent.mm.loader.e.a();
    Object localObject = new e.a();
    ((e.a)localObject).gKq = true;
    ((e.a)localObject).gKp = true;
    this.zus = ((e.a)localObject).aot();
    localObject = new e.a();
    ((e.a)localObject).gKq = true;
    ((e.a)localObject).gKp = true;
    localObject = ((e.a)localObject).w((Drawable)new ColorDrawable(ai.getContext().getResources().getColor(2131099651)));
    ((e.a)localObject).gKu = ((a.a)com.tencent.mm.plugin.story.c.a.a.zqB.aqp()).wqf;
    ((e.a)localObject).gKt = ((a.a)com.tencent.mm.plugin.story.c.a.a.zqB.aqp()).wqg;
    this.zut = ((e.a)localObject).aot();
    localObject = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new b()).a((com.tencent.mm.loader.d.b)new c()).a((f)this.zur).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(this.zus).aod();
    com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.gIC;
    this.zuq = com.tencent.mm.loader.e.a((com.tencent.mm.loader.c.d)localObject);
    AppMethodBeat.o(118905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.e
 * JD-Core Version:    0.7.0.1
 */