package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/GalleryMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cleanTask", "Lcom/tencent/mm/plugin/story/model/CleanVideoTask;", "list", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getList", "()Ljava/util/LinkedList;", "register", "", "ui", "unregister", "plugin-story_release"})
public final class c
{
  private static final String TAG = "MicroMsg.GalleryMgr";
  private static final LinkedList<WeakReference<StoryGalleryView>> fBS;
  private static a zrs;
  public static final c zrt;
  
  static
  {
    AppMethodBeat.i(118642);
    zrt = new c();
    TAG = "MicroMsg.GalleryMgr";
    fBS = new LinkedList();
    AppMethodBeat.o(118642);
  }
  
  public static void a(StoryGalleryView paramStoryGalleryView)
  {
    AppMethodBeat.i(118640);
    k.h(paramStoryGalleryView, "ui");
    ac.i(TAG, "GalleryMgr register ".concat(String.valueOf(paramStoryGalleryView)));
    Iterator localIterator = ((Iterable)fBS).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!k.g(paramStoryGalleryView, (StoryGalleryView)((WeakReference)localObject).get()));
    for (;;)
    {
      if ((WeakReference)localObject == null) {
        fBS.add(new WeakReference(paramStoryGalleryView));
      }
      if (fBS.size() <= 0) {
        break;
      }
      paramStoryGalleryView = zrs;
      if (paramStoryGalleryView == null) {
        break;
      }
      ac.i(paramStoryGalleryView.TAG, "cancel");
      paramStoryGalleryView.xPQ = false;
      AppMethodBeat.o(118640);
      return;
      localObject = null;
    }
    AppMethodBeat.o(118640);
  }
  
  public static void b(StoryGalleryView paramStoryGalleryView)
  {
    AppMethodBeat.i(118641);
    k.h(paramStoryGalleryView, "ui");
    Iterator localIterator = ((Iterable)fBS).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!k.g(paramStoryGalleryView, (StoryGalleryView)((WeakReference)localObject).get()));
    for (;;)
    {
      localObject = (WeakReference)localObject;
      if (localObject != null) {
        fBS.remove(localObject);
      }
      ac.i(TAG, "GalleryMgr unregister " + paramStoryGalleryView + ' ' + fBS.size());
      if (fBS.size() > 1) {
        break;
      }
      paramStoryGalleryView = new a();
      zrs = paramStoryGalleryView;
      com.tencent.mm.ac.c.b("cleanCacheFiles", (d.g.a.a)new a.b(paramStoryGalleryView));
      AppMethodBeat.o(118641);
      return;
      localObject = null;
    }
    AppMethodBeat.o(118641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c
 * JD-Core Version:    0.7.0.1
 */