package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/FavourUserChecker;", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "()V", "TAG", "", "mFavourUserList", "", "kotlin.jvm.PlatformType", "", "mIsChecking", "", "mListeners", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/api/IFavourUserNotifyListener;", "mStoryStatus", "", "mValidUserList", "addNotifyListener", "", "listener", "checkFavourUserStory", "getStoryStatus", "getValidUserList", "isStoryExist", "username", "setFavourStoryRead", "updateFavourUserList", "userList", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.b
{
  private static final List<String> AJg;
  private static final List<String> AJh;
  private static int AJi = 0;
  private static boolean AJj = false;
  public static final b AJk;
  private static final String TAG = "MicroMsg.FavourUserChecker";
  private static final List<WeakReference<c>> mListeners;
  
  static
  {
    AppMethodBeat.i(118638);
    AJk = new b();
    TAG = "MicroMsg.FavourUserChecker";
    mListeners = Collections.synchronizedList((List)new ArrayList());
    AJg = Collections.synchronizedList((List)new ArrayList());
    AJh = Collections.synchronizedList((List)new ArrayList());
    AppMethodBeat.o(118638);
  }
  
  public static void ehu()
  {
    AppMethodBeat.i(118633);
    com.tencent.mm.sdk.g.b.c((Runnable)a.AJl, "FavourUserChecker_StoryStateChecker");
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
  
  public final int egR()
  {
    return AJi;
  }
  
  public final void egS()
  {
    AppMethodBeat.i(118635);
    ad.i(TAG, "setFavourStoryRead:%s", new Object[] { Integer.valueOf(AJi) });
    if (AJi != 0) {
      AJi = 2;
    }
    AppMethodBeat.o(118635);
  }
  
  public final List<String> egT()
  {
    AppMethodBeat.i(118636);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)AJh);
    localObject = (List)localObject;
    AppMethodBeat.o(118636);
    return localObject;
  }
  
  public final void gk(List<String> paramList)
  {
    AppMethodBeat.i(118634);
    List localList = AJg;
    p.g(localList, "mFavourUserList");
    try
    {
      AJg.clear();
      AJg.addAll((Collection)paramList);
      paramList = z.MKo;
      ehu();
      AppMethodBeat.o(118634);
      return;
    }
    finally
    {
      AppMethodBeat.o(118634);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a AJl;
    
    static
    {
      AppMethodBeat.i(118632);
      AJl = new a();
      AppMethodBeat.o(118632);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118631);
      Object localObject1 = b.AJk;
      if (b.ehv())
      {
        AppMethodBeat.o(118631);
        return;
      }
      localObject1 = b.AJk;
      b.sk(true);
      localObject1 = b.AJk;
      b.ehw().clear();
      localObject1 = new ArrayList();
      ??? = new ArrayList();
      ??? = b.AJk;
      ??? = b.ehx();
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
          localObject9 = f.AJz;
          if (f.a.isStoryUnread((String)localObject8))
          {
            localObject9 = b.AJk;
            ad.d(b.ehy(), "%s has new story", new Object[] { localObject8 });
            i |= 0x1;
            ((ArrayList)???).add(localObject8);
          }
        }
        Object localObject9 = b.AJk;
        p.g(localObject8, "username");
        int j = i;
        if (b.aBA((String)localObject8))
        {
          localObject9 = b.AJk;
          ad.d(b.ehy(), "%s has story", new Object[] { localObject8 });
          j = i | 0x2;
          localObject2.add(localObject8);
          break label513;
          label237:
          localObject7 = z.MKo;
          ??? = b.AJk;
          if (b.ehz() != i)
          {
            ??? = b.AJk;
            b.Sc(i);
          }
          ??? = b.AJk;
          b.ehw().addAll((Collection)???);
          ??? = b.AJk;
          b.ehw().addAll((Collection)localObject2);
          ArrayList localArrayList = new ArrayList();
          ??? = b.AJk;
          ??? = b.ehA();
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
              localObject8 = b.AJk;
              ((c)localObject7).Sa(b.ehz());
            }
          }
          ??? = z.MKo;
          ??? = b.AJk;
          b.ehA().removeAll((Collection)localObject3);
          Object localObject4 = b.AJk;
          b.sk(false);
          localObject4 = b.AJk;
          localObject4 = b.ehy();
          ??? = b.AJk;
          ad.i((String)localObject4, "checkStoryStatus:%s nowState:%s", new Object[] { Integer.valueOf(b.ehz()), Integer.valueOf(i) });
          AppMethodBeat.o(118631);
          return;
        }
        label513:
        int i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b
 * JD-Core Version:    0.7.0.1
 */