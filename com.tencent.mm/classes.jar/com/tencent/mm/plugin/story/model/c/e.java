package com.tencent.mm.plugin.story.model.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.loader.cache.memory.DefaultBitmapMemoryCache;
import com.tencent.mm.loader.e.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "", "()V", "fileNameCreator", "Lcom/tencent/mm/loader/impr/DefaultFileNameCreator;", "mOptionsCommon", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mOptionsForAlbum", "mStoryLoader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loader", "options", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public com.tencent.mm.loader.d<d> SlZ;
  private final com.tencent.mm.loader.d.a Sma;
  public final com.tencent.mm.loader.b.e Smb;
  public final com.tencent.mm.loader.b.e Smc;
  
  public e()
  {
    AppMethodBeat.i(118905);
    this.Sma = new com.tencent.mm.loader.d.a();
    Object localObject = new e.a();
    ((e.a)localObject).nqd = true;
    ((e.a)localObject).nqc = true;
    this.Smb = ((e.a)localObject).blI();
    localObject = new e.a();
    ((e.a)localObject).nqd = true;
    ((e.a)localObject).nqc = true;
    localObject = ((e.a)localObject).L((Drawable)new ColorDrawable(MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.story.a.a.BG_3)));
    ((e.a)localObject).nqh = ((com.tencent.mm.plugin.story.c.a.a.a)com.tencent.mm.plugin.story.c.a.a.SiJ.boF()).NHv;
    ((e.a)localObject).nqg = ((com.tencent.mm.plugin.story.c.a.a.a)com.tencent.mm.plugin.story.c.a.a.SiJ.boF()).NHw;
    this.Smc = ((e.a)localObject).blI();
    localObject = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new b()).a((com.tencent.mm.loader.c.b)new c()).a((g)this.Sma).a((com.tencent.mm.loader.cache.memory.d)new DefaultBitmapMemoryCache()).b(this.Smb).blt();
    com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.noo;
    this.SlZ = com.tencent.mm.loader.e.a((com.tencent.mm.loader.b.d)localObject);
    AppMethodBeat.o(118905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.c.e
 * JD-Core Version:    0.7.0.1
 */