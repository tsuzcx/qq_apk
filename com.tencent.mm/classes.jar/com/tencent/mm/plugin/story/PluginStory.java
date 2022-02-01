package com.tencent.mm.plugin.story;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.g.b.a.ft;
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.media.i.d.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.f.r;
import com.tencent.mm.plugin.story.h.c.a;
import com.tencent.mm.protocal.protobuf.dkd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import d.g.b.p;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/PluginStory;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/story/api/IPluginStory;", "()V", "STORAGE_STORY", "", "STORAGE_STORY_TEMP", "StoryMaxStorageSize", "", "addStoryPostListener", "", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "addStoryStatusNotifyListener", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "canPostStory", "", "checkPost", "checkReportFromChatting", "clickScene", "", "user", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "enterGallery", "unreadList", "", "execute", "getAccStoryCachePath", "getAccStoryPath", "getAccStoryTmpPath", "getContactFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "getFavourUserChecker", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "getStoryBasicConfig", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "getStoryNewFeatureConfig", "Lcom/tencent/mm/plugin/story/api/IStoryNewFeatureConfig;", "getStoryStateFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "getStoryUIFactory", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "getStoryUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "hasNewStory", "username", "isShowStoryCheck", "isStoryExist", "userName", "isStoryUnread", "loadStory", "roomId", "name", "preLoadVideoViewMgr", "preloadForSnsUser", "isEnter", "removeStoryPostListener", "removeStoryStatusNotifyListener", "reportWaitPlayList", "userList", "scene", "setPreviewEnterScene", "showStoryEntranceDialog", "context", "Landroid/content/Context;", "sessionId", "exposeOrder", "startStoryCapture", "jumpPageFrom", "videoObjectId", "startStoryCaptureForResult", "requestCode", "storyComment", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "updateStoryUserInfo", "userInfo", "Companion", "StoryCleanListener", "StorySynclistener", "plugin-story_release"})
public final class PluginStory
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.story.api.e
{
  public static final PluginStory.a AHM;
  private static final String TAG = "MicroMsg.PluginStory";
  private final long AHJ = 536870912L;
  private final String AHK = "oneday/";
  private final String AHL = "oneday/temp/";
  
  static
  {
    AppMethodBeat.i(118565);
    AHM = new PluginStory.a((byte)0);
    TAG = "MicroMsg.PluginStory";
    AppMethodBeat.o(118565);
  }
  
  public final void addStoryPostListener(com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(118546);
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.ehZ().a(paramk);
    AppMethodBeat.o(118546);
  }
  
  public final void addStoryStatusNotifyListener(com.tencent.mm.plugin.story.api.m paramm)
  {
    AppMethodBeat.i(118548);
    Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
    localObject = j.b.ehU();
    if ((paramm != null) && (!((com.tencent.mm.plugin.story.i.g)localObject).ATS.contains(paramm))) {
      ((com.tencent.mm.plugin.story.i.g)localObject).ATS.add(paramm);
    }
    AppMethodBeat.o(118548);
  }
  
  public final boolean canPostStory()
  {
    AppMethodBeat.i(118553);
    com.tencent.mm.plugin.story.f.d locald = com.tencent.mm.plugin.story.f.d.AJq;
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
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.ehZ().checkPost();
    AppMethodBeat.o(118551);
  }
  
  public final boolean checkReportFromChatting(int paramInt, String paramString)
  {
    AppMethodBeat.i(118554);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(118554);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
    com.tencent.mm.plugin.story.i.g localg = j.b.ehU();
    if (paramString == null) {}
    label135:
    label296:
    label444:
    for (localObject = "";; localObject = paramString)
    {
      localObject = localg.aBD((String)localObject);
      boolean bool2 = ((com.tencent.mm.plugin.story.i.f)localObject).elr();
      int i;
      if (((com.tencent.mm.plugin.story.i.f)localObject).elp() > 0L)
      {
        i = 1;
        localObject = com.tencent.mm.plugin.story.h.c.ARR;
        com.tencent.mm.plugin.story.h.c.clean();
        localObject = com.tencent.mm.plugin.story.h.b.ARx;
        com.tencent.mm.plugin.story.h.b.clean();
        localObject = com.tencent.mm.plugin.story.h.b.ARx;
        if (paramString != null) {
          break label450;
        }
      }
      label320:
      label450:
      for (localObject = "";; localObject = paramString)
      {
        p.h(localObject, "user");
        com.tencent.mm.plugin.story.h.b.So(paramInt);
        com.tencent.mm.plugin.story.h.b.clean();
        com.tencent.mm.plugin.story.h.b.ARq = bt.flT();
        boolean bool1;
        if ((NetStatusUtil.isWifi(aj.getContext())) || (NetStatusUtil.is4G(aj.getContext())))
        {
          bool1 = true;
          com.tencent.mm.plugin.story.h.b.ruo = bool1;
          if (bool1)
          {
            ad.i("MicroMsg.StoryBrowseDetailIDKeyStat", "chattingRight " + (String)localObject + " isWifi:" + com.tencent.mm.plugin.story.h.b.ruo);
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pQX, 1L, 1L);
          }
          if (paramInt != 1) {
            break label320;
          }
          localObject = com.tencent.mm.plugin.story.h.c.ARR;
          if (paramString != null) {
            break label444;
          }
        }
        for (localObject = "";; localObject = paramString)
        {
          p.h(localObject, "user");
          com.tencent.mm.plugin.story.h.c.clean();
          com.tencent.mm.plugin.story.h.c.ARN = false;
          com.tencent.mm.plugin.story.h.c.ARI = new c.a((String)localObject, 1);
          ad.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRight ".concat(String.valueOf(localObject)));
          com.tencent.mm.plugin.report.service.g.yhR.n(988L, 1L, 1L);
          if (bool2)
          {
            if (i == 0) {
              break label296;
            }
            paramString = com.tencent.mm.plugin.story.h.c.ARR;
            com.tencent.mm.plugin.story.h.c.ejG();
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
              localObject = com.tencent.mm.plugin.story.h.c.ARR;
              localObject = paramString;
              if (paramString == null) {
                localObject = "";
              }
              com.tencent.mm.plugin.story.h.c.aBW((String)localObject);
            }
          } while (paramInt != 2);
          localObject = com.tencent.mm.plugin.story.h.c.ARR;
          if (paramString == null) {}
          for (localObject = "";; localObject = paramString)
          {
            p.h(localObject, "user");
            com.tencent.mm.plugin.story.h.c.clean();
            com.tencent.mm.plugin.story.h.c.ARN = true;
            com.tencent.mm.plugin.story.h.c.ARI = new c.a((String)localObject, 2);
            ad.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheck ".concat(String.valueOf(localObject)));
            com.tencent.mm.plugin.report.service.g.yhR.n(988L, 2L, 1L);
            if (!bool2) {
              break;
            }
            if (i != 0)
            {
              paramString = com.tencent.mm.plugin.story.h.c.ARR;
              com.tencent.mm.plugin.story.h.c.ejH();
              break;
            }
            localObject = com.tencent.mm.plugin.story.h.c.ARR;
            localObject = paramString;
            if (paramString == null) {
              localObject = "";
            }
            com.tencent.mm.plugin.story.h.c.aBX((String)localObject);
            break;
          }
        }
      }
    }
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(118541);
    if ((paramg != null) && (paramg.akw()))
    {
      ad.i(TAG, "PluginStory configure");
      pin((com.tencent.mm.kernel.b.c)new t(com.tencent.mm.plugin.story.f.j.class));
      com.tencent.mm.vfs.o.a("oneday", "oneday", this.AHJ, 3);
    }
    AppMethodBeat.o(118541);
  }
  
  public final void enterGallery(List<String> paramList)
  {
    AppMethodBeat.i(118555);
    p.h(paramList, "unreadList");
    Object localObject = com.tencent.mm.plugin.story.h.c.ARR;
    com.tencent.mm.plugin.story.h.c.gp(paramList);
    localObject = com.tencent.mm.plugin.story.h.b.ARx;
    com.tencent.mm.plugin.story.h.b.gp(paramList);
    AppMethodBeat.o(118555);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    com.tencent.mm.media.i.d.hlw = (d.a)com.tencent.mm.media.i.h.hmY;
  }
  
  public final String getAccStoryCachePath()
  {
    AppMethodBeat.i(118540);
    String str = aj.getContext().getCacheDir().getAbsolutePath() + "/" + this.AHK;
    AppMethodBeat.o(118540);
    return str;
  }
  
  public final String getAccStoryPath()
  {
    AppMethodBeat.i(118538);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "storage()");
    localObject = locale.getAccPath() + this.AHK;
    AppMethodBeat.o(118538);
    return localObject;
  }
  
  public final String getAccStoryTmpPath()
  {
    AppMethodBeat.i(118539);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "storage()");
    localObject = locale.getAccPath() + this.AHL;
    AppMethodBeat.o(118539);
    return localObject;
  }
  
  public final l.c getContactFetcher()
  {
    return (l.c)com.tencent.mm.plugin.story.f.f.a.ANj;
  }
  
  public final com.tencent.mm.plugin.story.api.b getFavourUserChecker()
  {
    return (com.tencent.mm.plugin.story.api.b)com.tencent.mm.plugin.story.f.b.AJk;
  }
  
  public final com.tencent.mm.plugin.story.api.f getStoryBasicConfig()
  {
    return (com.tencent.mm.plugin.story.api.f)com.tencent.mm.plugin.story.c.a.a.AIv;
  }
  
  public final com.tencent.mm.plugin.story.api.j getStoryNewFeatureConfig()
  {
    return (com.tencent.mm.plugin.story.api.j)com.tencent.mm.plugin.story.c.a.e.AIM;
  }
  
  public final com.tencent.mm.plugin.story.api.l getStoryStateFetcher(String paramString)
  {
    AppMethodBeat.i(118545);
    com.tencent.mm.plugin.story.f.f.e locale = com.tencent.mm.plugin.story.f.f.e.ANX;
    paramString = com.tencent.mm.plugin.story.f.f.e.aBV(paramString);
    AppMethodBeat.o(118545);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.story.api.n getStoryUIFactory()
  {
    return (com.tencent.mm.plugin.story.api.n)r.ALa;
  }
  
  public final dkd getStoryUserInfo()
  {
    AppMethodBeat.i(118561);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
    localObject1 = j.b.ehU();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
    localObject2 = ((com.tencent.mm.plugin.story.i.g)localObject1).aBD(j.b.dTJ()).elq();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new dkd();
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
    com.tencent.mm.plugin.story.f.k localk = com.tencent.mm.plugin.story.f.k.AKk;
    boolean bool = com.tencent.mm.plugin.story.f.k.aBE(paramString);
    AppMethodBeat.o(118552);
    return bool;
  }
  
  public final boolean isShowStoryCheck()
  {
    AppMethodBeat.i(118550);
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    boolean bool = j.b.eif();
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
    Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
    boolean bool1;
    if ((p.i(paramString, j.b.dTJ()) ^ true))
    {
      localObject = com.tencent.mm.plugin.story.f.j.AKb;
      bool2 = j.b.ehU().aBD(paramString).isValid();
      bool1 = bool2;
      if (bool2)
      {
        ad.i(TAG, "ret1 has story!");
        AppMethodBeat.o(118543);
        return true;
      }
    }
    else
    {
      bool1 = false;
    }
    localObject = com.tencent.mm.plugin.story.f.n.AKq;
    int i = cf.aCN();
    localObject = com.tencent.mm.plugin.story.f.i.AJE;
    boolean bool2 = n.a.ff(paramString, i - com.tencent.mm.plugin.story.f.i.ehK());
    if (bool2) {
      ad.i(TAG, "ret2 has story!");
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
    com.tencent.mm.plugin.story.f.f.a locala = com.tencent.mm.plugin.story.f.f.AJz;
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
    Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
    boolean bool = bt.lQ(paramString1, j.b.dTJ());
    if ((!bool) && (!com.tencent.mm.plugin.story.api.o.ehi()))
    {
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp().Bf(paramString1);
      if (localObject == null)
      {
        AppMethodBeat.o(118544);
        return;
      }
      if (!((am)localObject).adh())
      {
        ad.i(TAG, "filter by isOpenStrangerUserPage close ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(118544);
        return;
      }
    }
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    paramString1 = new com.tencent.mm.plugin.story.f.a.i(paramString1, bool, (String)localObject);
    paramString2 = com.tencent.mm.kernel.g.ajB();
    p.g(paramString2, "MMKernel.network()");
    paramString2.aiU().b((com.tencent.mm.al.n)paramString1);
    AppMethodBeat.o(118544);
  }
  
  public final String name()
  {
    return "plugin-story";
  }
  
  public final boolean preLoadVideoViewMgr(String paramString)
  {
    AppMethodBeat.i(118557);
    Object localObject = com.tencent.mm.plugin.story.ui.view.gallery.o.Bgi;
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    com.tencent.mm.plugin.story.ui.view.gallery.o.aCt((String)localObject);
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
    for (int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqL, 1);; i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqN, 0))
    {
      ad.i(TAG, "preloadForSnsUser: " + i + " isEnter: " + paramBoolean + " username " + paramString + ' ' + bt.flS());
      if (i != 1) {
        break;
      }
      Object localObject = com.tencent.mm.plugin.story.g.f.APr;
      paramString = com.tencent.mm.plugin.story.g.f.a.bX(paramString, false);
      if (paramString == null) {
        break;
      }
      localObject = com.tencent.mm.plugin.story.ui.view.gallery.m.Bfs;
      com.tencent.mm.plugin.story.ui.view.gallery.m.gw(d.a.j.listOf(paramString.AMA));
      AppMethodBeat.o(118558);
      return;
    }
    AppMethodBeat.o(118558);
  }
  
  public final void removeStoryPostListener(com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(118547);
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.ehZ().b(paramk);
    AppMethodBeat.o(118547);
  }
  
  public final void removeStoryStatusNotifyListener(com.tencent.mm.plugin.story.api.m paramm)
  {
    AppMethodBeat.i(118549);
    Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
    localObject = j.b.ehU();
    if (paramm != null) {
      ((com.tencent.mm.plugin.story.i.g)localObject).ATS.remove(paramm);
    }
    AppMethodBeat.o(118549);
  }
  
  public final void reportWaitPlayList(List<String> paramList, long paramLong)
  {
    AppMethodBeat.i(118559);
    p.h(paramList, "userList");
    com.tencent.mm.plugin.story.f.k localk = com.tencent.mm.plugin.story.f.k.AKk;
    com.tencent.mm.plugin.story.f.k.reportWaitPlayList(paramList, paramLong);
    AppMethodBeat.o(118559);
  }
  
  public final void setPreviewEnterScene(long paramLong)
  {
    AppMethodBeat.i(118556);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ASt;
    com.tencent.mm.plugin.story.h.h.ejZ().kY(paramLong);
    AppMethodBeat.o(118556);
  }
  
  public final boolean showStoryEntranceDialog(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(118560);
    p.h(paramContext, "context");
    p.h(paramString, "sessionId");
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ASt;
    com.tencent.mm.plugin.story.h.h.ekv().oJ(paramString);
    paramString = com.tencent.mm.plugin.story.h.h.ASt;
    com.tencent.mm.plugin.story.h.h.ekv().iE((int)System.currentTimeMillis());
    paramString = com.tencent.mm.plugin.story.h.h.ASt;
    paramString = com.tencent.mm.plugin.story.h.h.ASt;
    com.tencent.mm.plugin.story.h.h.St(com.tencent.mm.plugin.story.h.h.ekv().Tw());
    paramString = com.tencent.mm.plugin.story.h.h.ASt;
    com.tencent.mm.plugin.story.h.h.ekv().iF(paramInt);
    paramString = new com.tencent.mm.plugin.story.ui.sns.c(paramContext);
    paramString.setContentView((View)new com.tencent.mm.plugin.story.ui.sns.d(paramContext, (View.OnClickListener)new PluginStory.d(paramString)));
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
    com.tencent.mm.plugin.story.f.e.a.AMT.startStoryCapture(paramContext, paramInt1, paramLong);
    AppMethodBeat.o(118564);
  }
  
  public final com.tencent.mm.plugin.story.api.h storyComment()
  {
    return (com.tencent.mm.plugin.story.api.h)com.tencent.mm.plugin.story.f.b.b.ALT;
  }
  
  public final void updateStoryUserInfo(String paramString, dkd paramdkd)
  {
    AppMethodBeat.i(118562);
    Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
    localObject = j.b.ehU();
    if ((paramString == null) || (paramdkd == null))
    {
      AppMethodBeat.o(118562);
      return;
    }
    com.tencent.mm.plugin.story.i.f localf = ((com.tencent.mm.plugin.story.i.g)localObject).aBD(paramString);
    if (paramdkd != null) {}
    for (paramString = paramdkd.toByteArray();; paramString = null)
    {
      localf.field_userInfo = paramString;
      ((com.tencent.mm.plugin.story.i.g)localObject).b(localf);
      AppMethodBeat.o(118562);
      return;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StoryFileCleanTaskEvent;", "()V", "callback", "", "event", "plugin-story_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<vy>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.PluginStory
 * JD-Core Version:    0.7.0.1
 */