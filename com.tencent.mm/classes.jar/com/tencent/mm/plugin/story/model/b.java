package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/FavourUserChecker;", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "()V", "TAG", "", "mFavourUserList", "", "kotlin.jvm.PlatformType", "", "mIsChecking", "", "mListeners", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/api/IFavourUserNotifyListener;", "mStoryStatus", "", "mValidUserList", "addNotifyListener", "", "listener", "checkFavourUserStory", "getStoryStatus", "getValidUserList", "isStoryExist", "username", "setFavourStoryRead", "updateFavourUserList", "userList", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.story.api.b
{
  public static final b Sjr;
  private static final List<String> Sjs;
  private static final List<String> Sjt;
  private static int Sju;
  private static boolean Sjv;
  private static final String TAG;
  private static final List<WeakReference<c>> mListeners;
  
  static
  {
    AppMethodBeat.i(118638);
    Sjr = new b();
    TAG = "MicroMsg.FavourUserChecker";
    mListeners = Collections.synchronizedList((List)new ArrayList());
    Sjs = Collections.synchronizedList((List)new ArrayList());
    Sjt = Collections.synchronizedList((List)new ArrayList());
    AppMethodBeat.o(118638);
  }
  
  public static void hvo()
  {
    AppMethodBeat.i(118633);
    ThreadPool.post(b..ExternalSyntheticLambda0.INSTANCE, "FavourUserChecker_StoryStateChecker");
    AppMethodBeat.o(118633);
  }
  
  private static final void hvp()
  {
    AppMethodBeat.i(367102);
    if (Sjv)
    {
      AppMethodBeat.o(367102);
      return;
    }
    Sjv = true;
    Sjt.clear();
    ArrayList localArrayList1 = new ArrayList();
    ??? = new ArrayList();
    ??? = Sjs;
    s.s(???, "mFavourUserList");
    for (;;)
    {
      Object localObject5;
      String str;
      synchronized ((Iterable)???)
      {
        localObject5 = ((Iterable)???).iterator();
        i = 0;
        if (!((Iterator)localObject5).hasNext()) {
          break label203;
        }
        str = (String)((Iterator)localObject5).next();
        f.a locala = f.SjJ;
        if (f.a.isStoryUnread(str))
        {
          Log.d(TAG, "%s has new story", new Object[] { str });
          i |= 0x1;
          ((ArrayList)???).add(str);
        }
      }
      s.s(str, "username");
      int j = i;
      if (isStoryExist(str))
      {
        Log.d(TAG, "%s has story", new Object[] { str });
        j = i | 0x2;
        localObject1.add(str);
        break label420;
        label203:
        localObject5 = ah.aiuX;
        if (Sju != i) {
          Sju = i;
        }
        Sjt.addAll((Collection)???);
        Sjt.addAll((Collection)localObject1);
        ArrayList localArrayList2 = new ArrayList();
        ??? = mListeners;
        s.s(???, "mListeners");
        for (;;)
        {
          synchronized ((Iterable)???)
          {
            ??? = ((Iterable)???).iterator();
            if (!((Iterator)???).hasNext()) {
              break;
            }
            localObject5 = (WeakReference)((Iterator)???).next();
            if ((c)((WeakReference)localObject5).get() == null) {
              localArrayList2.add(localObject5);
            }
          }
          localObject5 = (c)((WeakReference)localObject5).get();
          if (localObject5 != null) {
            ((c)localObject5).amZ(Sju);
          }
        }
        ??? = ah.aiuX;
        mListeners.removeAll((Collection)localObject2);
        Sjv = false;
        Log.i(TAG, "checkStoryStatus:%s nowState:%s", new Object[] { Integer.valueOf(Sju), Integer.valueOf(i) });
        AppMethodBeat.o(367102);
        return;
      }
      label420:
      int i = j;
    }
  }
  
  private static boolean isStoryExist(String paramString)
  {
    AppMethodBeat.i(367099);
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(367099);
      return false;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(367099);
      return false;
    }
    Object localObject = m.Sks;
    int i = (int)Util.nowSecond();
    localObject = i.SjL;
    boolean bool = m.a.hk(paramString, i - i.hvz());
    AppMethodBeat.o(367099);
    return bool;
  }
  
  public final int huM()
  {
    return Sju;
  }
  
  public final void huN()
  {
    AppMethodBeat.i(118635);
    Log.i(TAG, "setFavourStoryRead:%s", new Object[] { Integer.valueOf(Sju) });
    if (Sju != 0) {
      Sju = 2;
    }
    AppMethodBeat.o(118635);
  }
  
  public final List<String> huO()
  {
    AppMethodBeat.i(118636);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)Sjt);
    localObject = (List)localObject;
    AppMethodBeat.o(118636);
    return localObject;
  }
  
  public final void i(WeakReference<c> paramWeakReference)
  {
    AppMethodBeat.i(118637);
    if (!mListeners.contains(paramWeakReference)) {
      mListeners.add(paramWeakReference);
    }
    AppMethodBeat.o(118637);
  }
  
  public final void ld(List<String> paramList)
  {
    AppMethodBeat.i(118634);
    List localList = Sjs;
    s.s(localList, "mFavourUserList");
    try
    {
      Sjs.clear();
      Sjs.addAll((Collection)paramList);
      paramList = ah.aiuX;
      hvo();
      AppMethodBeat.o(118634);
      return;
    }
    finally
    {
      AppMethodBeat.o(118634);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.b
 * JD-Core Version:    0.7.0.1
 */