package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/GalleryMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cleanTask", "Lcom/tencent/mm/plugin/story/model/CleanVideoTask;", "list", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getList", "()Ljava/util/LinkedList;", "register", "", "ui", "unregister", "plugin-story_release"})
public final class c
{
  private static a BaP;
  public static final c BaQ;
  private static final String TAG = "MicroMsg.GalleryMgr";
  private static final LinkedList<WeakReference<StoryGalleryView>> fXm;
  
  static
  {
    AppMethodBeat.i(118642);
    BaQ = new c();
    TAG = "MicroMsg.GalleryMgr";
    fXm = new LinkedList();
    AppMethodBeat.o(118642);
  }
  
  public static void a(StoryGalleryView paramStoryGalleryView)
  {
    AppMethodBeat.i(118640);
    p.h(paramStoryGalleryView, "ui");
    ae.i(TAG, "GalleryMgr register ".concat(String.valueOf(paramStoryGalleryView)));
    Iterator localIterator = ((Iterable)fXm).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.i(paramStoryGalleryView, (StoryGalleryView)((WeakReference)localObject).get()));
    for (;;)
    {
      if ((WeakReference)localObject == null) {
        fXm.add(new WeakReference(paramStoryGalleryView));
      }
      if (fXm.size() <= 0) {
        break;
      }
      paramStoryGalleryView = BaP;
      if (paramStoryGalleryView == null) {
        break;
      }
      ae.i(paramStoryGalleryView.TAG, "cancel");
      paramStoryGalleryView.zwA = false;
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
    Iterator localIterator = ((Iterable)fXm).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.i(paramStoryGalleryView, (StoryGalleryView)((WeakReference)localObject).get()));
    for (;;)
    {
      localObject = (WeakReference)localObject;
      if (localObject != null) {
        fXm.remove(localObject);
      }
      ae.i(TAG, "GalleryMgr unregister " + paramStoryGalleryView + ' ' + fXm.size());
      if (fXm.size() > 1) {
        break;
      }
      paramStoryGalleryView = new a();
      BaP = paramStoryGalleryView;
      com.tencent.mm.ac.c.b("cleanCacheFiles", (d.g.a.a)new a.b(paramStoryGalleryView));
      AppMethodBeat.o(118641);
      return;
      localObject = null;
    }
    AppMethodBeat.o(118641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c
 * JD-Core Version:    0.7.0.1
 */