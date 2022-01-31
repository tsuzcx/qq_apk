package com.tencent.mm.plugin.story.model;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/FavourUserChecker;", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "()V", "TAG", "", "mFavourUserList", "", "kotlin.jvm.PlatformType", "", "mIsChecking", "", "mListeners", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/story/api/IFavourUserNotifyListener;", "mStoryStatus", "", "mValidUserList", "addNotifyListener", "", "listener", "checkFavourUserStory", "getStoryStatus", "getValidUserList", "isStoryExist", "username", "setFavourStoryRead", "updateFavourUserList", "userList", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.api.b
{
  private static final String TAG = "MicroMsg.FavourUserChecker";
  private static final List<WeakReference<c>> fv;
  private static final List<String> suj;
  private static final List<String> suk;
  private static int sul;
  private static boolean sum;
  public static final b sun;
  
  static
  {
    AppMethodBeat.i(109008);
    sun = new b();
    TAG = "MicroMsg.FavourUserChecker";
    fv = Collections.synchronizedList((List)new ArrayList());
    suj = Collections.synchronizedList((List)new ArrayList());
    suk = Collections.synchronizedList((List)new ArrayList());
    AppMethodBeat.o(109008);
  }
  
  public static void czZ()
  {
    AppMethodBeat.i(109003);
    d.post((Runnable)b.a.suo, "FavourUserChecker_StoryStateChecker");
    AppMethodBeat.o(109003);
  }
  
  public final void b(WeakReference<c> paramWeakReference)
  {
    AppMethodBeat.i(109007);
    if (!fv.contains(paramWeakReference)) {
      fv.add(paramWeakReference);
    }
    AppMethodBeat.o(109007);
  }
  
  public final int czn()
  {
    return sul;
  }
  
  public final void czo()
  {
    AppMethodBeat.i(109005);
    ab.i(TAG, "setFavourStoryRead:%s", new Object[] { Integer.valueOf(sul) });
    if (sul != 0) {
      sul = 2;
    }
    AppMethodBeat.o(109005);
  }
  
  public final List<String> czp()
  {
    AppMethodBeat.i(109006);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)suk);
    localObject = (List)localObject;
    AppMethodBeat.o(109006);
    return localObject;
  }
  
  public final void dA(List<String> paramList)
  {
    AppMethodBeat.i(109004);
    suj.clear();
    suj.addAll((Collection)paramList);
    czZ();
    AppMethodBeat.o(109004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.b
 * JD-Core Version:    0.7.0.1
 */