package com.tencent.mm.plugin.story.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.loader.f.f;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "", "()V", "fileNameCreator", "Lcom/tencent/mm/loader/impr/DefaultFileNameCreator;", "mOptionsCommon", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mOptionsForAlbum", "mStoryLoader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loader", "options", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "plugin-story_release"})
public final class e
{
  public com.tencent.mm.loader.d<d> yhq;
  private final com.tencent.mm.loader.e.a yhr;
  public final com.tencent.mm.loader.c.e yhs;
  public final com.tencent.mm.loader.c.e yht;
  
  public e()
  {
    AppMethodBeat.i(118905);
    this.yhr = new com.tencent.mm.loader.e.a();
    Object localObject = new e.a();
    ((e.a)localObject).gjE = true;
    ((e.a)localObject).gjD = true;
    this.yhs = ((e.a)localObject).ahr();
    localObject = new e.a();
    ((e.a)localObject).gjE = true;
    ((e.a)localObject).gjD = true;
    localObject = ((e.a)localObject).w((Drawable)new ColorDrawable(aj.getContext().getResources().getColor(2131099651)));
    ((e.a)localObject).gjI = ((a.a)com.tencent.mm.plugin.story.c.a.a.ydB.ajp()).vht;
    ((e.a)localObject).gjH = ((a.a)com.tencent.mm.plugin.story.c.a.a.ydB.ajp()).vhu;
    this.yht = ((e.a)localObject).ahr();
    localObject = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new b()).a((com.tencent.mm.loader.d.b)new c()).a((f)this.yhr).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(this.yhs).ahb();
    com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.ghT;
    this.yhq = com.tencent.mm.loader.e.a((com.tencent.mm.loader.c.d)localObject);
    AppMethodBeat.o(118905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.e
 * JD-Core Version:    0.7.0.1
 */