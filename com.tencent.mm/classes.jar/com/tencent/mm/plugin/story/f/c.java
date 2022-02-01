package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/GalleryMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cleanTask", "Lcom/tencent/mm/plugin/story/model/CleanVideoTask;", "list", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getList", "()Ljava/util/LinkedList;", "register", "", "ui", "unregister", "plugin-story_release"})
public final class c
{
  private static a FlJ;
  public static final c FlK;
  private static final String TAG = "MicroMsg.GalleryMgr";
  private static final LinkedList<WeakReference<StoryGalleryView>> gCs;
  
  static
  {
    AppMethodBeat.i(118642);
    FlK = new c();
    TAG = "MicroMsg.GalleryMgr";
    gCs = new LinkedList();
    AppMethodBeat.o(118642);
  }
  
  public static void a(StoryGalleryView paramStoryGalleryView)
  {
    AppMethodBeat.i(118640);
    p.h(paramStoryGalleryView, "ui");
    Log.i(TAG, "GalleryMgr register ".concat(String.valueOf(paramStoryGalleryView)));
    Iterator localIterator = ((Iterable)gCs).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.j(paramStoryGalleryView, (StoryGalleryView)((WeakReference)localObject).get()));
    for (;;)
    {
      if ((WeakReference)localObject == null) {
        gCs.add(new WeakReference(paramStoryGalleryView));
      }
      if (gCs.size() <= 0) {
        break;
      }
      paramStoryGalleryView = FlJ;
      if (paramStoryGalleryView == null) {
        break;
      }
      Log.i(paramStoryGalleryView.TAG, "cancel");
      paramStoryGalleryView.DGJ = false;
      AppMethodBeat.o(118640);
      return;
      localObject = null;
    }
    AppMethodBeat.o(118640);
  }
  
  public static void b(StoryGalleryView paramStoryGalleryView)
  {
    AppMethodBeat.i(118641);
    p.h(paramStoryGalleryView, "ui");
    Iterator localIterator = ((Iterable)gCs).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.j(paramStoryGalleryView, (StoryGalleryView)((WeakReference)localObject).get()));
    for (;;)
    {
      localObject = (WeakReference)localObject;
      if (localObject != null) {
        gCs.remove(localObject);
      }
      Log.i(TAG, "GalleryMgr unregister " + paramStoryGalleryView + ' ' + gCs.size());
      if (gCs.size() > 1) {
        break;
      }
      paramStoryGalleryView = new a();
      FlJ = paramStoryGalleryView;
      d.b("cleanCacheFiles", (kotlin.g.a.a)new a.b(paramStoryGalleryView));
      AppMethodBeat.o(118641);
      return;
      localObject = null;
    }
    AppMethodBeat.o(118641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c
 * JD-Core Version:    0.7.0.1
 */