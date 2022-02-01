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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/FavourUserChecker;", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "()V", "TAG", "", "mFavourUserList", "", "kotlin.jvm.PlatformType", "", "mIsChecking", "", "mListeners", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/api/IFavourUserNotifyListener;", "mStoryStatus", "", "mValidUserList", "addNotifyListener", "", "listener", "checkFavourUserStory", "getStoryStatus", "getValidUserList", "isStoryExist", "username", "setFavourStoryRead", "updateFavourUserList", "userList", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.b
{
  private static final List<String> FlD;
  private static final List<String> FlE;
  private static int FlF = 0;
  private static boolean FlG = false;
  public static final b FlH;
  private static final String TAG = "MicroMsg.FavourUserChecker";
  private static final List<WeakReference<c>> mListeners;
  
  static
  {
    AppMethodBeat.i(118638);
    FlH = new b();
    TAG = "MicroMsg.FavourUserChecker";
    mListeners = Collections.synchronizedList((List)new ArrayList());
    FlD = Collections.synchronizedList((List)new ArrayList());
    FlE = Collections.synchronizedList((List)new ArrayList());
    AppMethodBeat.o(118638);
  }
  
  public static void fnD()
  {
    AppMethodBeat.i(118633);
    ThreadPool.post((Runnable)a.FlI, "FavourUserChecker_StoryStateChecker");
    AppMethodBeat.o(118633);
  }
  
  public final int fna()
  {
    return FlF;
  }
  
  public final void fnb()
  {
    AppMethodBeat.i(118635);
    Log.i(TAG, "setFavourStoryRead:%s", new Object[] { Integer.valueOf(FlF) });
    if (FlF != 0) {
      FlF = 2;
    }
    AppMethodBeat.o(118635);
  }
  
  public final List<String> fnc()
  {
    AppMethodBeat.i(118636);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)FlE);
    localObject = (List)localObject;
    AppMethodBeat.o(118636);
    return localObject;
  }
  
  public final void h(WeakReference<c> paramWeakReference)
  {
    AppMethodBeat.i(118637);
    if (!mListeners.contains(paramWeakReference)) {
      mListeners.add(paramWeakReference);
    }
    AppMethodBeat.o(118637);
  }
  
  public final void hp(List<String> paramList)
  {
    AppMethodBeat.i(118634);
    List localList = FlD;
    p.g(localList, "mFavourUserList");
    try
    {
      FlD.clear();
      FlD.addAll((Collection)paramList);
      paramList = x.SXb;
      fnD();
      AppMethodBeat.o(118634);
      return;
    }
    finally
    {
      AppMethodBeat.o(118634);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a FlI;
    
    static
    {
      AppMethodBeat.i(118632);
      FlI = new a();
      AppMethodBeat.o(118632);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118631);
      Object localObject1 = b.FlH;
      if (b.fnE())
      {
        AppMethodBeat.o(118631);
        return;
      }
      localObject1 = b.FlH;
      b.vM(true);
      localObject1 = b.FlH;
      b.fnF().clear();
      localObject1 = new ArrayList();
      ??? = new ArrayList();
      ??? = b.FlH;
      ??? = b.fnG();
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
          localObject9 = f.FlW;
          if (f.a.isStoryUnread((String)localObject8))
          {
            localObject9 = b.FlH;
            Log.d(b.fnH(), "%s has new story", new Object[] { localObject8 });
            i |= 0x1;
            ((ArrayList)???).add(localObject8);
          }
        }
        Object localObject9 = b.FlH;
        p.g(localObject8, "username");
        int j = i;
        if (b.aRP((String)localObject8))
        {
          localObject9 = b.FlH;
          Log.d(b.fnH(), "%s has story", new Object[] { localObject8 });
          j = i | 0x2;
          localObject2.add(localObject8);
          break label513;
          label237:
          localObject7 = x.SXb;
          ??? = b.FlH;
          if (b.fnI() != i)
          {
            ??? = b.FlH;
            b.aaF(i);
          }
          ??? = b.FlH;
          b.fnF().addAll((Collection)???);
          ??? = b.FlH;
          b.fnF().addAll((Collection)localObject2);
          ArrayList localArrayList = new ArrayList();
          ??? = b.FlH;
          ??? = b.fnJ();
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
              localObject8 = b.FlH;
              ((c)localObject7).aaD(b.fnI());
            }
          }
          ??? = x.SXb;
          ??? = b.FlH;
          b.fnJ().removeAll((Collection)localObject3);
          Object localObject4 = b.FlH;
          b.vM(false);
          localObject4 = b.FlH;
          localObject4 = b.fnH();
          ??? = b.FlH;
          Log.i((String)localObject4, "checkStoryStatus:%s nowState:%s", new Object[] { Integer.valueOf(b.fnI()), Integer.valueOf(i) });
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