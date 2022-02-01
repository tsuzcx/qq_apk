package com.tencent.mm.plugin.story.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.sdk.platformtools.ak;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "", "()V", "fileNameCreator", "Lcom/tencent/mm/loader/impr/DefaultFileNameCreator;", "mOptionsCommon", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mOptionsForAlbum", "mStoryLoader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loader", "options", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "plugin-story_release"})
public final class e
{
  public com.tencent.mm.loader.d<d> BdN;
  private final com.tencent.mm.loader.e.a BdO;
  public final com.tencent.mm.loader.c.e BdP;
  public final com.tencent.mm.loader.c.e BdQ;
  
  public e()
  {
    AppMethodBeat.i(118905);
    this.BdO = new com.tencent.mm.loader.e.a();
    Object localObject = new e.a();
    ((e.a)localObject).hgP = true;
    ((e.a)localObject).hgO = true;
    this.BdP = ((e.a)localObject).aru();
    localObject = new e.a();
    ((e.a)localObject).hgP = true;
    ((e.a)localObject).hgO = true;
    localObject = ((e.a)localObject).w((Drawable)new ColorDrawable(ak.getContext().getResources().getColor(2131099651)));
    ((e.a)localObject).hgT = ((a.a)com.tencent.mm.plugin.story.c.a.a.AZY.att()).xNS;
    ((e.a)localObject).hgS = ((a.a)com.tencent.mm.plugin.story.c.a.a.AZY.att()).xNT;
    this.BdQ = ((e.a)localObject).aru();
    localObject = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new b()).a((com.tencent.mm.loader.d.b)new c()).a((g)this.BdO).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(this.BdP).arf();
    com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.hfa;
    this.BdN = com.tencent.mm.loader.e.a((com.tencent.mm.loader.c.d)localObject);
    AppMethodBeat.o(118905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.e
 * JD-Core Version:    0.7.0.1
 */