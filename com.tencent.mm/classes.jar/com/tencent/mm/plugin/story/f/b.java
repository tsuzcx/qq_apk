package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/FavourUserChecker;", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "()V", "TAG", "", "mFavourUserList", "", "kotlin.jvm.PlatformType", "", "mIsChecking", "", "mListeners", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/api/IFavourUserNotifyListener;", "mStoryStatus", "", "mValidUserList", "addNotifyListener", "", "listener", "checkFavourUserStory", "getStoryStatus", "getValidUserList", "isStoryExist", "username", "setFavourStoryRead", "updateFavourUserList", "userList", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.b
{
  private static final List<String> BaJ;
  private static final List<String> BaK;
  private static int BaL = 0;
  private static boolean BaM = false;
  public static final b BaN;
  private static final String TAG = "MicroMsg.FavourUserChecker";
  private static final List<WeakReference<c>> mListeners;
  
  static
  {
    AppMethodBeat.i(118638);
    BaN = new b();
    TAG = "MicroMsg.FavourUserChecker";
    mListeners = Collections.synchronizedList((List)new ArrayList());
    BaJ = Collections.synchronizedList((List)new ArrayList());
    BaK = Collections.synchronizedList((List)new ArrayList());
    AppMethodBeat.o(118638);
  }
  
  public static void elc()
  {
    AppMethodBeat.i(118633);
    com.tencent.mm.sdk.g.b.c((Runnable)a.BaO, "FavourUserChecker_StoryStateChecker");
    AppMethodBeat.o(118633);
  }
  
  public final void ekA()
  {
    AppMethodBeat.i(118635);
    ae.i(TAG, "setFavourStoryRead:%s", new Object[] { Integer.valueOf(BaL) });
    if (BaL != 0) {
      BaL = 2;
    }
    AppMethodBeat.o(118635);
  }
  
  public final List<String> ekB()
  {
    AppMethodBeat.i(118636);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)BaK);
    localObject = (List)localObject;
    AppMethodBeat.o(118636);
    return localObject;
  }
  
  public final int ekz()
  {
    return BaL;
  }
  
  public final void g(WeakReference<c> paramWeakReference)
  {
    AppMethodBeat.i(118637);
    if (!mListeners.contains(paramWeakReference)) {
      mListeners.add(paramWeakReference);
    }
    AppMethodBeat.o(118637);
  }
  
  public final void gt(List<String> paramList)
  {
    AppMethodBeat.i(118634);
    List localList = BaJ;
    p.g(localList, "mFavourUserList");
    try
    {
      BaJ.clear();
      BaJ.addAll((Collection)paramList);
      paramList = z.Nhr;
      elc();
      AppMethodBeat.o(118634);
      return;
    }
    finally
    {
      AppMethodBeat.o(118634);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a BaO;
    
    static
    {
      AppMethodBeat.i(118632);
      BaO = new a();
      AppMethodBeat.o(118632);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118631);
      Object localObject1 = b.BaN;
      if (b.eld())
      {
        AppMethodBeat.o(118631);
        return;
      }
      localObject1 = b.BaN;
      b.sr(true);
      localObject1 = b.BaN;
      b.ele().clear();
      localObject1 = new ArrayList();
      ??? = new ArrayList();
      ??? = b.BaN;
      ??? = b.elf();
      p.g(???, "mFavourUserList");
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
          localObject9 = f.Bbc;
          if (f.a.isStoryUnread((String)localObject8))
          {
            localObject9 = b.BaN;
            ae.d(b.elg(), "%s has new story", new Object[] { localObject8 });
            i |= 0x1;
            ((ArrayList)???).add(localObject8);
          }
        }
        Object localObject9 = b.BaN;
        p.g(localObject8, "username");
        int j = i;
        if (b.aCT((String)localObject8))
        {
          localObject9 = b.BaN;
          ae.d(b.elg(), "%s has story", new Object[] { localObject8 });
          j = i | 0x2;
          localObject2.add(localObject8);
          break label513;
          label237:
          localObject7 = z.Nhr;
          ??? = b.BaN;
          if (b.elh() != i)
          {
            ??? = b.BaN;
            b.SJ(i);
          }
          ??? = b.BaN;
          b.ele().addAll((Collection)???);
          ??? = b.BaN;
          b.ele().addAll((Collection)localObject2);
          ArrayList localArrayList = new ArrayList();
          ??? = b.BaN;
          ??? = b.eli();
          p.g(???, "mListeners");
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
              localObject8 = b.BaN;
              ((c)localObject7).SH(b.elh());
            }
          }
          ??? = z.Nhr;
          ??? = b.BaN;
          b.eli().removeAll((Collection)localObject3);
          Object localObject4 = b.BaN;
          b.sr(false);
          localObject4 = b.BaN;
          localObject4 = b.elg();
          ??? = b.BaN;
          ae.i((String)localObject4, "checkStoryStatus:%s nowState:%s", new Object[] { Integer.valueOf(b.elh()), Integer.valueOf(i) });
          AppMethodBeat.o(118631);
          return;
        }
        label513:
        int i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b
 * JD-Core Version:    0.7.0.1
 */