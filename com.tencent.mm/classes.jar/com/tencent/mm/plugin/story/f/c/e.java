package com.tencent.mm.plugin.story.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "", "()V", "fileNameCreator", "Lcom/tencent/mm/loader/impr/DefaultFileNameCreator;", "mOptionsCommon", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mOptionsForAlbum", "mStoryLoader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loader", "options", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "plugin-story_release"})
public final class e
{
  public com.tencent.mm.loader.d<d> LIG;
  private final com.tencent.mm.loader.e.a LIH;
  public final com.tencent.mm.loader.c.e LII;
  public final com.tencent.mm.loader.c.e LIJ;
  
  public e()
  {
    AppMethodBeat.i(118905);
    this.LIH = new com.tencent.mm.loader.e.a();
    Object localObject = new e.a();
    ((e.a)localObject).kOp = true;
    ((e.a)localObject).kOo = true;
    this.LII = ((e.a)localObject).aRT();
    localObject = new e.a();
    ((e.a)localObject).kOp = true;
    ((e.a)localObject).kOo = true;
    localObject = ((e.a)localObject).B((Drawable)new ColorDrawable(MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.story.a.a.BG_3)));
    ((e.a)localObject).kOt = ((com.tencent.mm.plugin.story.c.a.a.a)com.tencent.mm.plugin.story.c.a.a.LEY.aUb()).HKG;
    ((e.a)localObject).kOs = ((com.tencent.mm.plugin.story.c.a.a.a)com.tencent.mm.plugin.story.c.a.a.LEY.aUb()).HKH;
    this.LIJ = ((e.a)localObject).aRT();
    localObject = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new b()).a((com.tencent.mm.loader.d.b)new c()).a((g)this.LIH).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(this.LII).aRE();
    com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.kMy;
    this.LIG = com.tencent.mm.loader.e.a((com.tencent.mm.loader.c.d)localObject);
    AppMethodBeat.o(118905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.e
 * JD-Core Version:    0.7.0.1
 */