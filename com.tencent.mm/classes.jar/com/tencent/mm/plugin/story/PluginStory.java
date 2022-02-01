package com.tencent.mm.plugin.story;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.g.b.a.jj;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.media.i.d.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.f.r;
import com.tencent.mm.plugin.story.h.c.a;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/PluginStory;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/story/api/IPluginStory;", "()V", "STORAGE_STORY", "", "STORAGE_STORY_TEMP", "StoryMaxStorageSize", "", "addStoryPostListener", "", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "addStoryStatusNotifyListener", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "canPostStory", "", "checkPost", "checkReportFromChatting", "clickScene", "", "user", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "enterGallery", "unreadList", "", "execute", "getAccStoryCachePath", "getAccStoryPath", "getAccStoryTmpPath", "getContactFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "getFavourUserChecker", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "getStoryBasicConfig", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "getStoryNewFeatureConfig", "Lcom/tencent/mm/plugin/story/api/IStoryNewFeatureConfig;", "getStoryStateFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "getStoryUIFactory", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "getStoryUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "hasNewStory", "username", "isShowStoryCheck", "isStoryExist", "userName", "isStoryUnread", "loadStory", "roomId", "name", "preLoadVideoViewMgr", "preloadForSnsUser", "isEnter", "removeStoryPostListener", "removeStoryStatusNotifyListener", "reportWaitPlayList", "userList", "scene", "setPreviewEnterScene", "showStoryEntranceDialog", "context", "Landroid/content/Context;", "sessionId", "exposeOrder", "startStoryCapture", "jumpPageFrom", "videoObjectId", "startStoryCaptureForResult", "requestCode", "storyComment", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "updateStoryUserInfo", "userInfo", "Companion", "StoryCleanListener", "StorySynclistener", "plugin-story_release"})
public final class PluginStory
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.story.api.e
{
  public static final a Fkn;
  private static final String TAG = "MicroMsg.PluginStory";
  private final long Fkk = 536870912L;
  private final String Fkl = "oneday/";
  private final String Fkm = "oneday/temp/";
  
  static
  {
    AppMethodBeat.i(118565);
    Fkn = new a((byte)0);
    TAG = "MicroMsg.PluginStory";
    AppMethodBeat.o(118565);
  }
  
  public final void addStoryPostListener(com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(118546);
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.foi().a(paramk);
    AppMethodBeat.o(118546);
  }
  
  public final void addStoryStatusNotifyListener(com.tencent.mm.plugin.story.api.m paramm)
  {
    AppMethodBeat.i(118548);
    Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject = j.b.fod();
    if ((paramm != null) && (!((com.tencent.mm.plugin.story.i.g)localObject).Fwg.contains(paramm))) {
      ((com.tencent.mm.plugin.story.i.g)localObject).Fwg.add(paramm);
    }
    AppMethodBeat.o(118548);
  }
  
  public final boolean canPostStory()
  {
    AppMethodBeat.i(118553);
    com.tencent.mm.plugin.story.f.d locald = com.tencent.mm.plugin.story.f.d.FlN;
    boolean bool = com.tencent.mm.plugin.story.f.d.canPostStory();
    AppMethodBeat.o(118553);
    return bool;
  }
  
  public final void checkPost()
  {
    AppMethodBeat.i(118551);
    if (!isShowStoryCheck())
    {
      AppMethodBeat.o(118551);
      return;
    }
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.foi().checkPost();
    AppMethodBeat.o(118551);
  }
  
  public final boolean checkReportFromChatting(int paramInt, String paramString)
  {
    AppMethodBeat.i(118554);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(118554);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    com.tencent.mm.plugin.story.i.g localg = j.b.fod();
    if (paramString == null) {}
    label135:
    label296:
    label444:
    for (localObject = "";; localObject = paramString)
    {
      localObject = localg.aRS((String)localObject);
      boolean bool2 = ((com.tencent.mm.plugin.story.i.f)localObject).frA();
      int i;
      if (((com.tencent.mm.plugin.story.i.f)localObject).fry() > 0L)
      {
        i = 1;
        localObject = com.tencent.mm.plugin.story.h.c.Fuf;
        com.tencent.mm.plugin.story.h.c.clean();
        localObject = com.tencent.mm.plugin.story.h.b.FtL;
        com.tencent.mm.plugin.story.h.b.clean();
        localObject = com.tencent.mm.plugin.story.h.b.FtL;
        if (paramString != null) {
          break label450;
        }
      }
      label320:
      label450:
      for (localObject = "";; localObject = paramString)
      {
        p.h(localObject, "user");
        com.tencent.mm.plugin.story.h.b.aaR(paramInt);
        com.tencent.mm.plugin.story.h.b.clean();
        com.tencent.mm.plugin.story.h.b.FtE = Util.nowMilliSecond();
        boolean bool1;
        if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext())))
        {
          bool1 = true;
          com.tencent.mm.plugin.story.h.b.tcf = bool1;
          if (bool1)
          {
            Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "chattingRight " + (String)localObject + " isWifi:" + com.tencent.mm.plugin.story.h.b.tcf);
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 1L, 1L);
          }
          if (paramInt != 1) {
            break label320;
          }
          localObject = com.tencent.mm.plugin.story.h.c.Fuf;
          if (paramString != null) {
            break label444;
          }
        }
        for (localObject = "";; localObject = paramString)
        {
          p.h(localObject, "user");
          com.tencent.mm.plugin.story.h.c.clean();
          com.tencent.mm.plugin.story.h.c.Fub = false;
          com.tencent.mm.plugin.story.h.c.FtW = new c.a((String)localObject, 1);
          Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRight ".concat(String.valueOf(localObject)));
          com.tencent.mm.plugin.report.service.h.CyF.n(988L, 1L, 1L);
          if (bool2)
          {
            if (i == 0) {
              break label296;
            }
            paramString = com.tencent.mm.plugin.story.h.c.Fuf;
            com.tencent.mm.plugin.story.h.c.fpP();
          }
          do
          {
            for (;;)
            {
              AppMethodBeat.o(118554);
              return true;
              i = 0;
              break;
              bool1 = false;
              break label135;
              localObject = com.tencent.mm.plugin.story.h.c.Fuf;
              localObject = paramString;
              if (paramString == null) {
                localObject = "";
              }
              com.tencent.mm.plugin.story.h.c.aSk((String)localObject);
            }
          } while (paramInt != 2);
          localObject = com.tencent.mm.plugin.story.h.c.Fuf;
          if (paramString == null) {}
          for (localObject = "";; localObject = paramString)
          {
            p.h(localObject, "user");
            com.tencent.mm.plugin.story.h.c.clean();
            com.tencent.mm.plugin.story.h.c.Fub = true;
            com.tencent.mm.plugin.story.h.c.FtW = new c.a((String)localObject, 2);
            Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheck ".concat(String.valueOf(localObject)));
            com.tencent.mm.plugin.report.service.h.CyF.n(988L, 2L, 1L);
            if (!bool2) {
              break;
            }
            if (i != 0)
            {
              paramString = com.tencent.mm.plugin.story.h.c.Fuf;
              com.tencent.mm.plugin.story.h.c.fpQ();
              break;
            }
            localObject = com.tencent.mm.plugin.story.h.c.Fuf;
            localObject = paramString;
            if (paramString == null) {
              localObject = "";
            }
            com.tencent.mm.plugin.story.h.c.aSl((String)localObject);
            break;
          }
        }
      }
    }
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(118541);
    if ((paramg != null) && (paramg.aBb()))
    {
      Log.i(TAG, "PluginStory configure");
      pin((com.tencent.mm.kernel.b.c)new com.tencent.mm.model.y(com.tencent.mm.plugin.story.f.j.class));
      com.tencent.mm.vfs.y.a("oneday", "oneday", this.Fkk, 3);
    }
    AppMethodBeat.o(118541);
  }
  
  public final void enterGallery(List<String> paramList)
  {
    AppMethodBeat.i(118555);
    p.h(paramList, "unreadList");
    Object localObject = com.tencent.mm.plugin.story.h.c.Fuf;
    com.tencent.mm.plugin.story.h.c.hv(paramList);
    localObject = com.tencent.mm.plugin.story.h.b.FtL;
    com.tencent.mm.plugin.story.h.b.hv(paramList);
    AppMethodBeat.o(118555);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    com.tencent.mm.media.i.d.ihF = (d.a)com.tencent.mm.media.i.h.ijh;
  }
  
  public final String getAccStoryCachePath()
  {
    AppMethodBeat.i(118540);
    String str = MMApplicationContext.getContext().getCacheDir().getAbsolutePath() + "/" + this.Fkl;
    AppMethodBeat.o(118540);
    return str;
  }
  
  public final String getAccStoryPath()
  {
    AppMethodBeat.i(118538);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "storage()");
    localObject = locale.getAccPath() + this.Fkl;
    AppMethodBeat.o(118538);
    return localObject;
  }
  
  public final String getAccStoryTmpPath()
  {
    AppMethodBeat.i(118539);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "storage()");
    localObject = locale.getAccPath() + this.Fkm;
    AppMethodBeat.o(118539);
    return localObject;
  }
  
  public final l.c getContactFetcher()
  {
    return (l.c)com.tencent.mm.plugin.story.f.f.a.FpB;
  }
  
  public final com.tencent.mm.plugin.story.api.b getFavourUserChecker()
  {
    return (com.tencent.mm.plugin.story.api.b)com.tencent.mm.plugin.story.f.b.FlH;
  }
  
  public final com.tencent.mm.plugin.story.api.f getStoryBasicConfig()
  {
    return (com.tencent.mm.plugin.story.api.f)com.tencent.mm.plugin.story.c.a.a.FkW;
  }
  
  public final com.tencent.mm.plugin.story.api.j getStoryNewFeatureConfig()
  {
    return (com.tencent.mm.plugin.story.api.j)com.tencent.mm.plugin.story.c.a.e.Fln;
  }
  
  public final com.tencent.mm.plugin.story.api.l getStoryStateFetcher(String paramString)
  {
    AppMethodBeat.i(118545);
    com.tencent.mm.plugin.story.f.f.e locale = com.tencent.mm.plugin.story.f.f.e.Fqp;
    paramString = com.tencent.mm.plugin.story.f.f.e.aSj(paramString);
    AppMethodBeat.o(118545);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.story.api.n getStoryUIFactory()
  {
    return (com.tencent.mm.plugin.story.api.n)r.Fnv;
  }
  
  public final eel getStoryUserInfo()
  {
    AppMethodBeat.i(118561);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject1 = j.b.fod();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject2 = ((com.tencent.mm.plugin.story.i.g)localObject1).aRS(j.b.fau()).frz();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new eel();
    }
    AppMethodBeat.o(118561);
    return localObject1;
  }
  
  public final boolean hasNewStory(String paramString)
  {
    AppMethodBeat.i(118552);
    if (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck())
    {
      AppMethodBeat.o(118552);
      return false;
    }
    com.tencent.mm.plugin.story.f.k localk = com.tencent.mm.plugin.story.f.k.FmH;
    boolean bool = com.tencent.mm.plugin.story.f.k.aRT(paramString);
    AppMethodBeat.o(118552);
    return bool;
  }
  
  public final boolean isShowStoryCheck()
  {
    AppMethodBeat.i(118550);
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    boolean bool = j.b.foo();
    AppMethodBeat.o(118550);
    return bool;
  }
  
  public final boolean isStoryExist(String paramString)
  {
    AppMethodBeat.i(118543);
    if (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck())
    {
      AppMethodBeat.o(118543);
      return false;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(118543);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    boolean bool1;
    if ((p.j(paramString, j.b.fau()) ^ true))
    {
      localObject = com.tencent.mm.plugin.story.f.j.Fmy;
      bool2 = j.b.fod().aRS(paramString).isValid();
      bool1 = bool2;
      if (bool2)
      {
        Log.i(TAG, "ret1 has story!");
        AppMethodBeat.o(118543);
        return true;
      }
    }
    else
    {
      bool1 = false;
    }
    localObject = com.tencent.mm.plugin.story.f.n.FmM;
    int i = cl.aWB();
    localObject = com.tencent.mm.plugin.story.f.i.Fmb;
    boolean bool2 = n.a.fM(paramString, i - com.tencent.mm.plugin.story.f.i.fnT());
    if (bool2) {
      Log.i(TAG, "ret2 has story!");
    }
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(118543);
      return true;
    }
    AppMethodBeat.o(118543);
    return false;
  }
  
  public final boolean isStoryUnread(String paramString)
  {
    AppMethodBeat.i(118542);
    com.tencent.mm.plugin.story.f.f.a locala = com.tencent.mm.plugin.story.f.f.FlW;
    boolean bool = com.tencent.mm.plugin.story.f.f.a.isStoryUnread(paramString);
    AppMethodBeat.o(118542);
    return bool;
  }
  
  public final void loadStory(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118544);
    if (paramString1 == null)
    {
      AppMethodBeat.o(118544);
      return;
    }
    if (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck())
    {
      AppMethodBeat.o(118544);
      return;
    }
    Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    boolean bool = Util.isEqual(paramString1, j.b.fau());
    if ((!bool) && (!com.tencent.mm.plugin.story.api.o.fnr()))
    {
      localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().Kn(paramString1);
      if (localObject == null)
      {
        AppMethodBeat.o(118544);
        return;
      }
      if (!((as)localObject).arv())
      {
        Log.i(TAG, "filter by isOpenStrangerUserPage close ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(118544);
        return;
      }
    }
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    paramString1 = new com.tencent.mm.plugin.story.f.a.i(paramString1, bool, (String)localObject);
    paramString2 = com.tencent.mm.kernel.g.aAg();
    p.g(paramString2, "MMKernel.network()");
    paramString2.azz().b((q)paramString1);
    AppMethodBeat.o(118544);
  }
  
  public final String name()
  {
    return "plugin-story";
  }
  
  public final boolean preLoadVideoViewMgr(String paramString)
  {
    AppMethodBeat.i(118557);
    Object localObject = com.tencent.mm.plugin.story.ui.view.gallery.o.FIq;
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    com.tencent.mm.plugin.story.ui.view.gallery.o.aSH((String)localObject);
    AppMethodBeat.o(118557);
    return true;
  }
  
  public final void preloadForSnsUser(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(118558);
    if (paramString == null)
    {
      AppMethodBeat.o(118558);
      return;
    }
    if (paramBoolean) {}
    for (int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPq, 1);; i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPs, 0))
    {
      Log.i(TAG, "preloadForSnsUser: " + i + " isEnter: " + paramBoolean + " username " + paramString + ' ' + Util.getStack());
      if (i != 1) {
        break;
      }
      com.tencent.mm.plugin.story.g.f.a locala = com.tencent.mm.plugin.story.g.f.FrJ;
      paramString = com.tencent.mm.plugin.story.g.f.a.ct(paramString, false);
      if (paramString == null) {
        break;
      }
      com.tencent.mm.plugin.story.ui.view.gallery.m.a(com.tencent.mm.plugin.story.ui.view.gallery.m.FHB, kotlin.a.j.listOf(paramString.FoT));
      AppMethodBeat.o(118558);
      return;
    }
    AppMethodBeat.o(118558);
  }
  
  public final void removeStoryPostListener(com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(118547);
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.foi().b(paramk);
    AppMethodBeat.o(118547);
  }
  
  public final void removeStoryStatusNotifyListener(com.tencent.mm.plugin.story.api.m paramm)
  {
    AppMethodBeat.i(118549);
    Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject = j.b.fod();
    if (paramm != null) {
      ((com.tencent.mm.plugin.story.i.g)localObject).Fwg.remove(paramm);
    }
    AppMethodBeat.o(118549);
  }
  
  public final void reportWaitPlayList(List<String> paramList, long paramLong)
  {
    AppMethodBeat.i(118559);
    p.h(paramList, "userList");
    com.tencent.mm.plugin.story.f.k localk = com.tencent.mm.plugin.story.f.k.FmH;
    com.tencent.mm.plugin.story.f.k.reportWaitPlayList(paramList, paramLong);
    AppMethodBeat.o(118559);
  }
  
  public final void setPreviewEnterScene(long paramLong)
  {
    AppMethodBeat.i(118556);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqi().sl(paramLong);
    AppMethodBeat.o(118556);
  }
  
  public final boolean showStoryEntranceDialog(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(118560);
    p.h(paramContext, "context");
    p.h(paramString, "sessionId");
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqE().wN(paramString);
    paramString = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqE().lG((int)System.currentTimeMillis());
    paramString = com.tencent.mm.plugin.story.h.h.FuH;
    paramString = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.aaW(com.tencent.mm.plugin.story.h.h.fqE().ahr());
    paramString = com.tencent.mm.plugin.story.h.h.FuH;
    com.tencent.mm.plugin.story.h.h.fqE().lH(paramInt);
    paramString = new com.tencent.mm.plugin.story.ui.sns.c(paramContext);
    paramString.setContentView((View)new com.tencent.mm.plugin.story.ui.sns.d(paramContext, (View.OnClickListener)new d(paramString)));
    paramString.show();
    AppMethodBeat.o(118560);
    return true;
  }
  
  public final void startStoryCapture(Context paramContext, int paramInt, long paramLong)
  {
    AppMethodBeat.i(118563);
    startStoryCaptureForResult(paramContext, paramInt, paramLong, -1);
    AppMethodBeat.o(118563);
  }
  
  public final void startStoryCaptureForResult(Context paramContext, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(118564);
    com.tencent.mm.plugin.story.f.e.a.Fpl.startStoryCapture(paramContext, paramInt1, paramLong);
    AppMethodBeat.o(118564);
  }
  
  public final com.tencent.mm.plugin.story.api.h storyComment()
  {
    return (com.tencent.mm.plugin.story.api.h)com.tencent.mm.plugin.story.f.b.b.Fom;
  }
  
  public final void updateStoryUserInfo(String paramString, eel parameel)
  {
    AppMethodBeat.i(118562);
    Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject = j.b.fod();
    if ((paramString == null) || (parameel == null))
    {
      AppMethodBeat.o(118562);
      return;
    }
    com.tencent.mm.plugin.story.i.f localf = ((com.tencent.mm.plugin.story.i.g)localObject).aRS(paramString);
    if (parameel != null) {}
    for (paramString = parameel.toByteArray();; paramString = null)
    {
      localf.field_userInfo = paramString;
      ((com.tencent.mm.plugin.story.i.g)localObject).b(localf);
      AppMethodBeat.o(118562);
      return;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/PluginStory$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StoryFileCleanTaskEvent;", "()V", "callback", "", "event", "plugin-story_release"})
  public static final class b
    extends IListener<xc>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(com.tencent.mm.plugin.story.ui.sns.c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(118537);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/PluginStory$showStoryEntranceDialog$entranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.Fko.cancel();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/PluginStory$showStoryEntranceDialog$entranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(118537);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.PluginStory
 * JD-Core Version:    0.7.0.1
 */