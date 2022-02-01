package com.tencent.mm.plugin.story.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "", "()V", "fileNameCreator", "Lcom/tencent/mm/loader/impr/DefaultFileNameCreator;", "mOptionsCommon", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mOptionsForAlbum", "mStoryLoader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loader", "options", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "plugin-story_release"})
public final class e
{
  public com.tencent.mm.loader.d<d> FoE;
  private final com.tencent.mm.loader.e.a FoF;
  public final com.tencent.mm.loader.c.e FoG;
  public final com.tencent.mm.loader.c.e FoH;
  
  public e()
  {
    AppMethodBeat.i(118905);
    this.FoF = new com.tencent.mm.loader.e.a();
    Object localObject = new e.a();
    ((e.a)localObject).hZJ = true;
    ((e.a)localObject).hZI = true;
    this.FoG = ((e.a)localObject).aJT();
    localObject = new e.a();
    ((e.a)localObject).hZJ = true;
    ((e.a)localObject).hZI = true;
    localObject = ((e.a)localObject).w((Drawable)new ColorDrawable(MMApplicationContext.getContext().getResources().getColor(2131099651)));
    ((e.a)localObject).hZN = ((a.a)com.tencent.mm.plugin.story.c.a.a.FkW.aLT()).BNY;
    ((e.a)localObject).hZM = ((a.a)com.tencent.mm.plugin.story.c.a.a.FkW.aLT()).BNZ;
    this.FoH = ((e.a)localObject).aJT();
    localObject = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new b()).a((com.tencent.mm.loader.d.b)new c()).a((g)this.FoF).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(this.FoG).aJE();
    com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.hXU;
    this.FoE = com.tencent.mm.loader.e.a((com.tencent.mm.loader.c.d)localObject);
    AppMethodBeat.o(118905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.e
 * JD-Core Version:    0.7.0.1
 */