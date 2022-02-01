package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/FavourUserChecker;", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "()V", "TAG", "", "mFavourUserList", "", "kotlin.jvm.PlatformType", "", "mIsChecking", "", "mListeners", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/api/IFavourUserNotifyListener;", "mStoryStatus", "", "mValidUserList", "addNotifyListener", "", "listener", "checkFavourUserStory", "getStoryStatus", "getValidUserList", "isStoryExist", "username", "setFavourStoryRead", "updateFavourUserList", "userList", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.b
{
  private static final String TAG = "MicroMsg.FavourUserChecker";
  private static final List<WeakReference<c>> mListeners;
  private static final List<String> yem;
  private static final List<String> yen;
  private static int yeo;
  private static boolean yep;
  public static final b yeq;
  
  static
  {
    AppMethodBeat.i(118638);
    yeq = new b();
    TAG = "MicroMsg.FavourUserChecker";
    mListeners = Collections.synchronizedList((List)new ArrayList());
    yem = Collections.synchronizedList((List)new ArrayList());
    yen = Collections.synchronizedList((List)new ArrayList());
    AppMethodBeat.o(118638);
  }
  
  public static void dGE()
  {
    AppMethodBeat.i(118633);
    com.tencent.mm.sdk.g.b.c((Runnable)a.yer, "FavourUserChecker_StoryStateChecker");
    AppMethodBeat.o(118633);
  }
  
  public final void c(WeakReference<c> paramWeakReference)
  {
    AppMethodBeat.i(118637);
    if (!mListeners.contains(paramWeakReference)) {
      mListeners.add(paramWeakReference);
    }
    AppMethodBeat.o(118637);
  }
  
  public final int dGc()
  {
    return yeo;
  }
  
  public final void dGd()
  {
    AppMethodBeat.i(118635);
    ad.i(TAG, "setFavourStoryRead:%s", new Object[] { Integer.valueOf(yeo) });
    if (yeo != 0) {
      yeo = 2;
    }
    AppMethodBeat.o(118635);
  }
  
  public final List<String> dGe()
  {
    AppMethodBeat.i(118636);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)yen);
    localObject = (List)localObject;
    AppMethodBeat.o(118636);
    return localObject;
  }
  
  public final void fR(List<String> paramList)
  {
    AppMethodBeat.i(118634);
    yem.clear();
    yem.addAll((Collection)paramList);
    dGE();
    AppMethodBeat.o(118634);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a yer;
    
    static
    {
      AppMethodBeat.i(118632);
      yer = new a();
      AppMethodBeat.o(118632);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118631);
      Object localObject1 = b.yeq;
      if (b.dGF())
      {
        AppMethodBeat.o(118631);
        return;
      }
      localObject1 = b.yeq;
      b.qG(true);
      localObject1 = b.yeq;
      b.dGG().clear();
      localObject1 = new ArrayList();
      ??? = new ArrayList();
      ??? = b.yeq;
      ??? = b.dGH();
      k.g(???, "mFavourUserList");
      for (;;)
      {
        Object localObject7;
        Object localObject8;
        synchronized ((Iterable)???)
        {
          localObject7 = ((Iterable)???).iterator();
          i = 0;
          if (!((Iterator)localObject7).hasNext()) {
            break label237;
          }
          localObject8 = (String)((Iterator)localObject7).next();
          localObject9 = f.yeF;
          if (f.a.isStoryUnread((String)localObject8))
          {
            localObject9 = b.yeq;
            ad.d(b.dGI(), "%s has new story", new Object[] { localObject8 });
            i |= 0x1;
            ((ArrayList)???).add(localObject8);
          }
        }
        Object localObject9 = b.yeq;
        k.g(localObject8, "username");
        int j = i;
        if (b.arm((String)localObject8))
        {
          localObject9 = b.yeq;
          ad.d(b.dGI(), "%s has story", new Object[] { localObject8 });
          j = i | 0x2;
          localObject2.add(localObject8);
          break label513;
          label237:
          localObject7 = y.JfV;
          ??? = b.yeq;
          if (b.dGJ() != i)
          {
            ??? = b.yeq;
            b.On(i);
          }
          ??? = b.yeq;
          b.dGG().addAll((Collection)???);
          ??? = b.yeq;
          b.dGG().addAll((Collection)localObject2);
          ArrayList localArrayList = new ArrayList();
          ??? = b.yeq;
          ??? = b.dGK();
          k.g(???, "mListeners");
          for (;;)
          {
            synchronized ((Iterable)???)
            {
              ??? = ((Iterable)???).iterator();
              if (!((Iterator)???).hasNext()) {
                break;
              }
              localObject7 = (WeakReference)((Iterator)???).next();
              if ((c)((WeakReference)localObject7).get() == null) {
                localArrayList.add(localObject7);
              }
            }
            localObject7 = (c)((WeakReference)localObject7).get();
            if (localObject7 != null)
            {
              localObject8 = b.yeq;
              ((c)localObject7).Ol(b.dGJ());
            }
          }
          ??? = y.JfV;
          ??? = b.yeq;
          b.dGK().removeAll((Collection)localObject3);
          Object localObject4 = b.yeq;
          b.qG(false);
          localObject4 = b.yeq;
          localObject4 = b.dGI();
          ??? = b.yeq;
          ad.i((String)localObject4, "checkStoryStatus:%s nowState:%s", new Object[] { Integer.valueOf(b.dGJ()), Integer.valueOf(i) });
          AppMethodBeat.o(118631);
          return;
        }
        label513:
        int i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b
 * JD-Core Version:    0.7.0.1
 */