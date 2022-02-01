package com.tencent.mm.plugin.story.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "", "()V", "fileNameCreator", "Lcom/tencent/mm/loader/impr/DefaultFileNameCreator;", "mOptionsCommon", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mOptionsForAlbum", "mStoryLoader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loader", "options", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "plugin-story_release"})
public final class e
{
  public com.tencent.mm.loader.d<d> AMl;
  private final com.tencent.mm.loader.e.a AMm;
  public final com.tencent.mm.loader.c.e AMn;
  public final com.tencent.mm.loader.c.e AMo;
  
  public e()
  {
    AppMethodBeat.i(118905);
    this.AMm = new com.tencent.mm.loader.e.a();
    Object localObject = new e.a();
    ((e.a)localObject).heb = true;
    ((e.a)localObject).hea = true;
    this.AMn = ((e.a)localObject).arf();
    localObject = new e.a();
    ((e.a)localObject).heb = true;
    ((e.a)localObject).hea = true;
    localObject = ((e.a)localObject).w((Drawable)new ColorDrawable(aj.getContext().getResources().getColor(2131099651)));
    ((e.a)localObject).hef = ((a.a)com.tencent.mm.plugin.story.c.a.a.AIv.ate()).xxV;
    ((e.a)localObject).hee = ((a.a)com.tencent.mm.plugin.story.c.a.a.AIv.ate()).xxW;
    this.AMo = ((e.a)localObject).arf();
    localObject = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new b()).a((com.tencent.mm.loader.d.b)new c()).a((g)this.AMm).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(this.AMn).aqQ();
    com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.hcm;
    this.AMl = com.tencent.mm.loader.e.a((com.tencent.mm.loader.c.d)localObject);
    AppMethodBeat.o(118905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.e
 * JD-Core Version:    0.7.0.1
 */