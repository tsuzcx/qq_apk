package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/GalleryMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cleanTask", "Lcom/tencent/mm/plugin/story/model/CleanVideoTask;", "list", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getList", "()Ljava/util/LinkedList;", "register", "", "ui", "unregister", "plugin-story_release"})
public final class c
{
  private static final String TAG = "MicroMsg.GalleryMgr";
  private static final LinkedList<WeakReference<StoryGalleryView>> elu;
  private static a sup;
  public static final c suq;
  
  static
  {
    AppMethodBeat.i(109012);
    suq = new c();
    TAG = "MicroMsg.GalleryMgr";
    elu = new LinkedList();
    AppMethodBeat.o(109012);
  }
  
  public static void a(StoryGalleryView paramStoryGalleryView)
  {
    AppMethodBeat.i(109010);
    j.q(paramStoryGalleryView, "ui");
    ab.i(TAG, "GalleryMgr register ".concat(String.valueOf(paramStoryGalleryView)));
    Iterator localIterator = ((Iterable)elu).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!j.e(paramStoryGalleryView, (StoryGalleryView)((WeakReference)localObject).get()));
    for (;;)
    {
      if ((WeakReference)localObject == null) {
        elu.add(new WeakReference(paramStoryGalleryView));
      }
      if (elu.size() <= 0) {
        break;
      }
      paramStoryGalleryView = sup;
      if (paramStoryGalleryView == null) {
        break;
      }
      ab.i(paramStoryGalleryView.TAG, "cancel");
      paramStoryGalleryView.rdd = false;
      AppMethodBeat.o(109010);
      return;
      localObject = null;
    }
    AppMethodBeat.o(109010);
  }
  
  public static void b(StoryGalleryView paramStoryGalleryView)
  {
    AppMethodBeat.i(109011);
    j.q(paramStoryGalleryView, "ui");
    Iterator localIterator = ((Iterable)elu).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!j.e(paramStoryGalleryView, (StoryGalleryView)((WeakReference)localObject).get()));
    for (;;)
    {
      localObject = (WeakReference)localObject;
      if (localObject != null) {
        elu.remove(localObject);
      }
      ab.i(TAG, "GalleryMgr unregister " + paramStoryGalleryView + ' ' + elu.size());
      if (elu.size() > 1) {
        break;
      }
      paramStoryGalleryView = new a();
      sup = paramStoryGalleryView;
      b.a("cleanCacheFiles", (a.f.a.a)new a.b(paramStoryGalleryView));
      AppMethodBeat.o(109011);
      return;
      localObject = null;
    }
    AppMethodBeat.o(109011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.c
 * JD-Core Version:    0.7.0.1
 */