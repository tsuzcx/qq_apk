package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/FavourUserChecker;", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "()V", "TAG", "", "mFavourUserList", "", "kotlin.jvm.PlatformType", "", "mIsChecking", "", "mListeners", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/api/IFavourUserNotifyListener;", "mStoryStatus", "", "mValidUserList", "addNotifyListener", "", "listener", "checkFavourUserStory", "getStoryStatus", "getValidUserList", "isStoryExist", "username", "setFavourStoryRead", "updateFavourUserList", "userList", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.b
{
  private static final String TAG = "MicroMsg.FavourUserChecker";
  private static final List<WeakReference<c>> mListeners;
  private static final List<String> zrm;
  private static final List<String> zrn;
  private static int zro;
  private static boolean zrp;
  public static final b zrq;
  
  static
  {
    AppMethodBeat.i(118638);
    zrq = new b();
    TAG = "MicroMsg.FavourUserChecker";
    mListeners = Collections.synchronizedList((List)new ArrayList());
    zrm = Collections.synchronizedList((List)new ArrayList());
    zrn = Collections.synchronizedList((List)new ArrayList());
    AppMethodBeat.o(118638);
  }
  
  public static void dVf()
  {
    AppMethodBeat.i(118633);
    com.tencent.mm.sdk.g.b.c((Runnable)a.zrr, "FavourUserChecker_StoryStateChecker");
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
  
  public final int dUD()
  {
    return zro;
  }
  
  public final void dUE()
  {
    AppMethodBeat.i(118635);
    ac.i(TAG, "setFavourStoryRead:%s", new Object[] { Integer.valueOf(zro) });
    if (zro != 0) {
      zro = 2;
    }
    AppMethodBeat.o(118635);
  }
  
  public final List<String> dUF()
  {
    AppMethodBeat.i(118636);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)zrn);
    localObject = (List)localObject;
    AppMethodBeat.o(118636);
    return localObject;
  }
  
  public final void fZ(List<String> paramList)
  {
    AppMethodBeat.i(118634);
    List localList = zrm;
    k.g(localList, "mFavourUserList");
    try
    {
      zrm.clear();
      zrm.addAll((Collection)paramList);
      paramList = y.KTp;
      dVf();
      AppMethodBeat.o(118634);
      return;
    }
    finally
    {
      AppMethodBeat.o(118634);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a zrr;
    
    static
    {
      AppMethodBeat.i(118632);
      zrr = new a();
      AppMethodBeat.o(118632);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118631);
      Object localObject1 = b.zrq;
      if (b.dVg())
      {
        AppMethodBeat.o(118631);
        return;
      }
      localObject1 = b.zrq;
      b.rE(true);
      localObject1 = b.zrq;
      b.dVh().clear();
      localObject1 = new ArrayList();
      ??? = new ArrayList();
      ??? = b.zrq;
      ??? = b.dVi();
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
          localObject9 = f.zrF;
          if (f.a.isStoryUnread((String)localObject8))
          {
            localObject9 = b.zrq;
            ac.d(b.dVj(), "%s has new story", new Object[] { localObject8 });
            i |= 0x1;
            ((ArrayList)???).add(localObject8);
          }
        }
        Object localObject9 = b.zrq;
        k.g(localObject8, "username");
        int j = i;
        if (b.awv((String)localObject8))
        {
          localObject9 = b.zrq;
          ac.d(b.dVj(), "%s has story", new Object[] { localObject8 });
          j = i | 0x2;
          localObject2.add(localObject8);
          break label513;
          label237:
          localObject7 = y.KTp;
          ??? = b.zrq;
          if (b.dVk() != i)
          {
            ??? = b.zrq;
            b.Qt(i);
          }
          ??? = b.zrq;
          b.dVh().addAll((Collection)???);
          ??? = b.zrq;
          b.dVh().addAll((Collection)localObject2);
          ArrayList localArrayList = new ArrayList();
          ??? = b.zrq;
          ??? = b.dVl();
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
              localObject8 = b.zrq;
              ((c)localObject7).Qr(b.dVk());
            }
          }
          ??? = y.KTp;
          ??? = b.zrq;
          b.dVl().removeAll((Collection)localObject3);
          Object localObject4 = b.zrq;
          b.rE(false);
          localObject4 = b.zrq;
          localObject4 = b.dVj();
          ??? = b.zrq;
          ac.i((String)localObject4, "checkStoryStatus:%s nowState:%s", new Object[] { Integer.valueOf(b.dVk()), Integer.valueOf(i) });
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