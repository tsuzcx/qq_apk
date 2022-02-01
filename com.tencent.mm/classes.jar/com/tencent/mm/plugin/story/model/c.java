package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/GalleryMgr;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cleanTask", "Lcom/tencent/mm/plugin/story/model/CleanVideoTask;", "list", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getList", "()Ljava/util/LinkedList;", "register", "", "ui", "unregister", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c Sjw;
  private static a Sjx;
  private static final String TAG;
  private static final LinkedList<WeakReference<StoryGalleryView>> lPK;
  
  static
  {
    AppMethodBeat.i(118642);
    Sjw = new c();
    TAG = "MicroMsg.GalleryMgr";
    lPK = new LinkedList();
    AppMethodBeat.o(118642);
  }
  
  public static void a(StoryGalleryView paramStoryGalleryView)
  {
    AppMethodBeat.i(118640);
    s.u(paramStoryGalleryView, "ui");
    Log.i(TAG, s.X("GalleryMgr register ", paramStoryGalleryView));
    Iterator localIterator = ((Iterable)lPK).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p(paramStoryGalleryView, ((WeakReference)localObject).get()));
    for (;;)
    {
      if ((WeakReference)localObject == null) {
        lPK.add(new WeakReference(paramStoryGalleryView));
      }
      if (lPK.size() > 0)
      {
        paramStoryGalleryView = Sjx;
        if (paramStoryGalleryView != null)
        {
          Log.i(paramStoryGalleryView.TAG, "cancel");
          paramStoryGalleryView.QqK = false;
        }
      }
      AppMethodBeat.o(118640);
      return;
      localObject = null;
    }
  }
  
  public static void b(StoryGalleryView paramStoryGalleryView)
  {
    AppMethodBeat.i(118641);
    s.u(paramStoryGalleryView, "ui");
    Iterator localIterator = ((Iterable)lPK).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p(paramStoryGalleryView, ((WeakReference)localObject).get()));
    for (;;)
    {
      localObject = (WeakReference)localObject;
      if (localObject != null) {
        lPK.remove(localObject);
      }
      Log.i(TAG, "GalleryMgr unregister " + paramStoryGalleryView + ' ' + lPK.size());
      if (lPK.size() <= 1)
      {
        paramStoryGalleryView = new a();
        Sjx = paramStoryGalleryView;
        d.d("cleanCacheFiles", (kotlin.g.a.a)new a.b(paramStoryGalleryView));
      }
      AppMethodBeat.o(118641);
      return;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.c
 * JD-Core Version:    0.7.0.1
 */