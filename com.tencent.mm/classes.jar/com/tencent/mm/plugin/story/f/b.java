package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/FavourUserChecker;", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "()V", "TAG", "", "mFavourUserList", "", "kotlin.jvm.PlatformType", "", "mIsChecking", "", "mListeners", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/api/IFavourUserNotifyListener;", "mStoryStatus", "", "mValidUserList", "addNotifyListener", "", "listener", "checkFavourUserStory", "getStoryStatus", "getValidUserList", "isStoryExist", "username", "setFavourStoryRead", "updateFavourUserList", "userList", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.b
{
  private static final List<String> LFF;
  private static final List<String> LFG;
  private static int LFH = 0;
  private static boolean LFI = false;
  public static final b LFJ;
  private static final String TAG = "MicroMsg.FavourUserChecker";
  private static final List<WeakReference<c>> mListeners;
  
  static
  {
    AppMethodBeat.i(118638);
    LFJ = new b();
    TAG = "MicroMsg.FavourUserChecker";
    mListeners = Collections.synchronizedList((List)new ArrayList());
    LFF = Collections.synchronizedList((List)new ArrayList());
    LFG = Collections.synchronizedList((List)new ArrayList());
    AppMethodBeat.o(118638);
  }
  
  public static void gbX()
  {
    AppMethodBeat.i(118633);
    ThreadPool.post((Runnable)a.LFK, "FavourUserChecker_StoryStateChecker");
    AppMethodBeat.o(118633);
  }
  
  public final void g(WeakReference<c> paramWeakReference)
  {
    AppMethodBeat.i(118637);
    if (!mListeners.contains(paramWeakReference)) {
      mListeners.add(paramWeakReference);
    }
    AppMethodBeat.o(118637);
  }
  
  public final int gbt()
  {
    return LFH;
  }
  
  public final void gbu()
  {
    AppMethodBeat.i(118635);
    Log.i(TAG, "setFavourStoryRead:%s", new Object[] { Integer.valueOf(LFH) });
    if (LFH != 0) {
      LFH = 2;
    }
    AppMethodBeat.o(118635);
  }
  
  public final List<String> gbv()
  {
    AppMethodBeat.i(118636);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)LFG);
    localObject = (List)localObject;
    AppMethodBeat.o(118636);
    return localObject;
  }
  
  public final void hY(List<String> paramList)
  {
    AppMethodBeat.i(118634);
    List localList = LFF;
    p.j(localList, "mFavourUserList");
    try
    {
      LFF.clear();
      LFF.addAll((Collection)paramList);
      paramList = x.aazN;
      gbX();
      AppMethodBeat.o(118634);
      return;
    }
    finally
    {
      AppMethodBeat.o(118634);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a LFK;
    
    static
    {
      AppMethodBeat.i(118632);
      LFK = new a();
      AppMethodBeat.o(118632);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118631);
      Object localObject1 = b.LFJ;
      if (b.gbY())
      {
        AppMethodBeat.o(118631);
        return;
      }
      localObject1 = b.LFJ;
      b.zq(true);
      localObject1 = b.LFJ;
      b.gbZ().clear();
      localObject1 = new ArrayList();
      ??? = new ArrayList();
      ??? = b.LFJ;
      ??? = b.gca();
      p.j(???, "mFavourUserList");
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
          localObject9 = f.LFY;
          if (f.a.isStoryUnread((String)localObject8))
          {
            localObject9 = b.LFJ;
            Log.d(b.gcb(), "%s has new story", new Object[] { localObject8 });
            i |= 0x1;
            ((ArrayList)???).add(localObject8);
          }
        }
        Object localObject9 = b.LFJ;
        p.j(localObject8, "username");
        int j = i;
        if (b.bcT((String)localObject8))
        {
          localObject9 = b.LFJ;
          Log.d(b.gcb(), "%s has story", new Object[] { localObject8 });
          j = i | 0x2;
          localObject2.add(localObject8);
          break label513;
          label237:
          localObject7 = x.aazN;
          ??? = b.LFJ;
          if (b.gcc() != i)
          {
            ??? = b.LFJ;
            b.aia(i);
          }
          ??? = b.LFJ;
          b.gbZ().addAll((Collection)???);
          ??? = b.LFJ;
          b.gbZ().addAll((Collection)localObject2);
          ArrayList localArrayList = new ArrayList();
          ??? = b.LFJ;
          ??? = b.gcd();
          p.j(???, "mListeners");
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
              localObject8 = b.LFJ;
              ((c)localObject7).ahY(b.gcc());
            }
          }
          ??? = x.aazN;
          ??? = b.LFJ;
          b.gcd().removeAll((Collection)localObject3);
          Object localObject4 = b.LFJ;
          b.zq(false);
          localObject4 = b.LFJ;
          localObject4 = b.gcb();
          ??? = b.LFJ;
          Log.i((String)localObject4, "checkStoryStatus:%s nowState:%s", new Object[] { Integer.valueOf(b.gcc()), Integer.valueOf(i) });
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