package com.tencent.mm.plugin.story;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.b.a.eu;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.media.h.d.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.f.r;
import com.tencent.mm.plugin.story.h.c.a;
import com.tencent.mm.protocal.protobuf.deq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/PluginStory;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/story/api/IPluginStory;", "()V", "STORAGE_STORY", "", "STORAGE_STORY_TEMP", "StoryMaxStorageSize", "", "addStoryPostListener", "", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "addStoryStatusNotifyListener", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "canPostStory", "", "checkPost", "checkReportFromChatting", "clickScene", "", "user", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "enterGallery", "unreadList", "", "execute", "getAccStoryCachePath", "getAccStoryPath", "getAccStoryTmpPath", "getContactFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "getFavourUserChecker", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "getStoryBasicConfig", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "getStoryNewFeatureConfig", "Lcom/tencent/mm/plugin/story/api/IStoryNewFeatureConfig;", "getStoryStateFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "getStoryUIFactory", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "getStoryUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "hasNewStory", "username", "isShowStoryCheck", "isStoryExist", "userName", "isStoryUnread", "loadStory", "roomId", "name", "preLoadVideoViewMgr", "preloadForSnsUser", "isEnter", "removeStoryPostListener", "removeStoryStatusNotifyListener", "reportWaitPlayList", "userList", "scene", "setPreviewEnterScene", "showStoryEntranceDialog", "context", "Landroid/content/Context;", "sessionId", "exposeOrder", "startStoryCapture", "jumpPageFrom", "videoObjectId", "startStoryCaptureForResult", "requestCode", "storyComment", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "updateStoryUserInfo", "userInfo", "Companion", "StoryCleanListener", "StorySynclistener", "plugin-story_release"})
public final class PluginStory
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.story.api.e
{
  private static final String TAG = "MicroMsg.PluginStory";
  public static final PluginStory.a zpS;
  private final long zpP = 536870912L;
  private final String zpQ = "oneday/";
  private final String zpR = "oneday/temp/";
  
  static
  {
    AppMethodBeat.i(118565);
    zpS = new PluginStory.a((byte)0);
    TAG = "MicroMsg.PluginStory";
    AppMethodBeat.o(118565);
  }
  
  public final void addStoryPostListener(com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(118546);
    j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVK().a(paramk);
    AppMethodBeat.o(118546);
  }
  
  public final void addStoryStatusNotifyListener(com.tencent.mm.plugin.story.api.m paramm)
  {
    AppMethodBeat.i(118548);
    Object localObject = com.tencent.mm.plugin.story.f.j.zsh;
    localObject = j.b.dVF();
    if ((paramm != null) && (!((com.tencent.mm.plugin.story.i.g)localObject).zCt.contains(paramm))) {
      ((com.tencent.mm.plugin.story.i.g)localObject).zCt.add(paramm);
    }
    AppMethodBeat.o(118548);
  }
  
  public final boolean canPostStory()
  {
    AppMethodBeat.i(118553);
    com.tencent.mm.plugin.story.f.d locald = com.tencent.mm.plugin.story.f.d.zrw;
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
    j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVK().checkPost();
    AppMethodBeat.o(118551);
  }
  
  public final boolean checkReportFromChatting(int paramInt, String paramString)
  {
    AppMethodBeat.i(118554);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(118554);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.story.f.j.zsh;
    com.tencent.mm.plugin.story.i.g localg = j.b.dVF();
    if (paramString == null) {}
    label135:
    label296:
    label444:
    for (localObject = "";; localObject = paramString)
    {
      localObject = localg.awy((String)localObject);
      boolean bool2 = ((com.tencent.mm.plugin.story.i.f)localObject).dZc();
      int i;
      if (((com.tencent.mm.plugin.story.i.f)localObject).dZa() > 0L)
      {
        i = 1;
        localObject = com.tencent.mm.plugin.story.h.c.zAs;
        com.tencent.mm.plugin.story.h.c.clean();
        localObject = com.tencent.mm.plugin.story.h.b.zzY;
        com.tencent.mm.plugin.story.h.b.clean();
        localObject = com.tencent.mm.plugin.story.h.b.zzY;
        if (paramString != null) {
          break label450;
        }
      }
      label320:
      label450:
      for (localObject = "";; localObject = paramString)
      {
        d.g.b.k.h(localObject, "user");
        com.tencent.mm.plugin.story.h.b.QF(paramInt);
        com.tencent.mm.plugin.story.h.b.clean();
        com.tencent.mm.plugin.story.h.b.zzR = bs.eWj();
        boolean bool1;
        if ((NetStatusUtil.isWifi(com.tencent.mm.sdk.platformtools.ai.getContext())) || (NetStatusUtil.is4G(com.tencent.mm.sdk.platformtools.ai.getContext())))
        {
          bool1 = true;
          com.tencent.mm.plugin.story.h.b.qKm = bool1;
          if (bool1)
          {
            ac.i("MicroMsg.StoryBrowseDetailIDKeyStat", "chattingRight " + (String)localObject + " isWifi:" + com.tencent.mm.plugin.story.h.b.qKm);
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.pnx, 1L, 1L);
          }
          if (paramInt != 1) {
            break label320;
          }
          localObject = com.tencent.mm.plugin.story.h.c.zAs;
          if (paramString != null) {
            break label444;
          }
        }
        for (localObject = "";; localObject = paramString)
        {
          d.g.b.k.h(localObject, "user");
          com.tencent.mm.plugin.story.h.c.clean();
          com.tencent.mm.plugin.story.h.c.zAo = false;
          com.tencent.mm.plugin.story.h.c.zAj = new c.a((String)localObject, 1);
          ac.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRight ".concat(String.valueOf(localObject)));
          com.tencent.mm.plugin.report.service.h.wUl.n(988L, 1L, 1L);
          if (bool2)
          {
            if (i == 0) {
              break label296;
            }
            paramString = com.tencent.mm.plugin.story.h.c.zAs;
            com.tencent.mm.plugin.story.h.c.dXr();
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
              localObject = com.tencent.mm.plugin.story.h.c.zAs;
              localObject = paramString;
              if (paramString == null) {
                localObject = "";
              }
              com.tencent.mm.plugin.story.h.c.awS((String)localObject);
            }
          } while (paramInt != 2);
          localObject = com.tencent.mm.plugin.story.h.c.zAs;
          if (paramString == null) {}
          for (localObject = "";; localObject = paramString)
          {
            d.g.b.k.h(localObject, "user");
            com.tencent.mm.plugin.story.h.c.clean();
            com.tencent.mm.plugin.story.h.c.zAo = true;
            com.tencent.mm.plugin.story.h.c.zAj = new c.a((String)localObject, 2);
            ac.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheck ".concat(String.valueOf(localObject)));
            com.tencent.mm.plugin.report.service.h.wUl.n(988L, 2L, 1L);
            if (!bool2) {
              break;
            }
            if (i != 0)
            {
              paramString = com.tencent.mm.plugin.story.h.c.zAs;
              com.tencent.mm.plugin.story.h.c.dXs();
              break;
            }
            localObject = com.tencent.mm.plugin.story.h.c.zAs;
            localObject = paramString;
            if (paramString == null) {
              localObject = "";
            }
            com.tencent.mm.plugin.story.h.c.awT((String)localObject);
            break;
          }
        }
      }
    }
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(118541);
    if ((paramg != null) && (paramg.ahL()))
    {
      ac.i(TAG, "PluginStory configure");
      pin((com.tencent.mm.kernel.b.c)new t(com.tencent.mm.plugin.story.f.j.class));
      com.tencent.mm.vfs.o.a("oneday", "oneday", this.zpP, 3);
    }
    AppMethodBeat.o(118541);
  }
  
  public final void enterGallery(List<String> paramList)
  {
    AppMethodBeat.i(118555);
    d.g.b.k.h(paramList, "unreadList");
    Object localObject = com.tencent.mm.plugin.story.h.c.zAs;
    com.tencent.mm.plugin.story.h.c.ge(paramList);
    localObject = com.tencent.mm.plugin.story.h.b.zzY;
    com.tencent.mm.plugin.story.h.b.ge(paramList);
    AppMethodBeat.o(118555);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    com.tencent.mm.media.h.d.gTv = (d.a)com.tencent.mm.media.h.h.gUV;
  }
  
  public final String getAccStoryCachePath()
  {
    AppMethodBeat.i(118540);
    String str = com.tencent.mm.sdk.platformtools.ai.getContext().getCacheDir().getAbsolutePath() + "/" + this.zpQ;
    AppMethodBeat.o(118540);
    return str;
  }
  
  public final String getAccStoryPath()
  {
    AppMethodBeat.i(118538);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "storage()");
    localObject = locale.getAccPath() + this.zpQ;
    AppMethodBeat.o(118538);
    return localObject;
  }
  
  public final String getAccStoryTmpPath()
  {
    AppMethodBeat.i(118539);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "storage()");
    localObject = locale.getAccPath() + this.zpR;
    AppMethodBeat.o(118539);
    return localObject;
  }
  
  public final l.c getContactFetcher()
  {
    return (l.c)com.tencent.mm.plugin.story.f.f.a.zvn;
  }
  
  public final com.tencent.mm.plugin.story.api.b getFavourUserChecker()
  {
    return (com.tencent.mm.plugin.story.api.b)com.tencent.mm.plugin.story.f.b.zrq;
  }
  
  public final com.tencent.mm.plugin.story.api.f getStoryBasicConfig()
  {
    return (com.tencent.mm.plugin.story.api.f)com.tencent.mm.plugin.story.c.a.a.zqB;
  }
  
  public final com.tencent.mm.plugin.story.api.j getStoryNewFeatureConfig()
  {
    return (com.tencent.mm.plugin.story.api.j)com.tencent.mm.plugin.story.c.a.e.zqS;
  }
  
  public final com.tencent.mm.plugin.story.api.l getStoryStateFetcher(String paramString)
  {
    AppMethodBeat.i(118545);
    com.tencent.mm.plugin.story.f.f.e locale = com.tencent.mm.plugin.story.f.f.e.zwb;
    paramString = com.tencent.mm.plugin.story.f.f.e.awR(paramString);
    AppMethodBeat.o(118545);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.story.api.n getStoryUIFactory()
  {
    return (com.tencent.mm.plugin.story.api.n)r.ztg;
  }
  
  public final deq getStoryUserInfo()
  {
    AppMethodBeat.i(118561);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
    localObject1 = j.b.dVF();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
    localObject2 = ((com.tencent.mm.plugin.story.i.g)localObject1).awy(j.b.dHx()).dZb();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new deq();
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
    com.tencent.mm.plugin.story.f.k localk = com.tencent.mm.plugin.story.f.k.zsq;
    boolean bool = com.tencent.mm.plugin.story.f.k.awz(paramString);
    AppMethodBeat.o(118552);
    return bool;
  }
  
  public final boolean isShowStoryCheck()
  {
    AppMethodBeat.i(118550);
    j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
    boolean bool = j.b.dVQ();
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
    Object localObject = com.tencent.mm.plugin.story.f.j.zsh;
    boolean bool1;
    if ((d.g.b.k.g(paramString, j.b.dHx()) ^ true))
    {
      localObject = com.tencent.mm.plugin.story.f.j.zsh;
      bool2 = j.b.dVF().awy(paramString).isValid();
      bool1 = bool2;
      if (bool2)
      {
        ac.i(TAG, "ret1 has story!");
        AppMethodBeat.o(118543);
        return true;
      }
    }
    else
    {
      bool1 = false;
    }
    localObject = com.tencent.mm.plugin.story.f.n.zsw;
    int i = ce.azK();
    localObject = com.tencent.mm.plugin.story.f.i.zrK;
    boolean bool2 = n.a.eN(paramString, i - com.tencent.mm.plugin.story.f.i.dVv());
    if (bool2) {
      ac.i(TAG, "ret2 has story!");
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
    com.tencent.mm.plugin.story.f.f.a locala = com.tencent.mm.plugin.story.f.f.zrF;
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
    Object localObject = com.tencent.mm.plugin.story.f.j.zsh;
    boolean bool = bs.lr(paramString1, j.b.dHx());
    if ((!bool) && (!com.tencent.mm.plugin.story.api.o.dUT()))
    {
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().aNt(paramString1);
      if (localObject == null)
      {
        AppMethodBeat.o(118544);
        return;
      }
      if (!((com.tencent.mm.storage.ai)localObject).aaE())
      {
        ac.i(TAG, "filter by isOpenStrangerUserPage close ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(118544);
        return;
      }
    }
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    paramString1 = new com.tencent.mm.plugin.story.f.a.i(paramString1, bool, (String)localObject);
    paramString2 = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(paramString2, "MMKernel.network()");
    paramString2.agi().b((com.tencent.mm.ak.n)paramString1);
    AppMethodBeat.o(118544);
  }
  
  public final String name()
  {
    return "plugin-story";
  }
  
  public final boolean preLoadVideoViewMgr(String paramString)
  {
    AppMethodBeat.i(118557);
    Object localObject = com.tencent.mm.plugin.story.ui.view.gallery.o.zOH;
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    com.tencent.mm.plugin.story.ui.view.gallery.o.axp((String)localObject);
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
    for (int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMO, 1);; i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMQ, 0))
    {
      ac.i(TAG, "preloadForSnsUser: " + i + " isEnter: " + paramBoolean + " username " + paramString + ' ' + bs.eWi());
      if (i != 1) {
        break;
      }
      Object localObject = com.tencent.mm.plugin.story.g.f.zxv;
      paramString = com.tencent.mm.plugin.story.g.f.a.bQ(paramString, false);
      if (paramString == null) {
        break;
      }
      localObject = com.tencent.mm.plugin.story.ui.view.gallery.m.zNR;
      com.tencent.mm.plugin.story.ui.view.gallery.m.gl(d.a.j.listOf(paramString.zuF));
      AppMethodBeat.o(118558);
      return;
    }
    AppMethodBeat.o(118558);
  }
  
  public final void removeStoryPostListener(com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(118547);
    j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVK().b(paramk);
    AppMethodBeat.o(118547);
  }
  
  public final void removeStoryStatusNotifyListener(com.tencent.mm.plugin.story.api.m paramm)
  {
    AppMethodBeat.i(118549);
    Object localObject = com.tencent.mm.plugin.story.f.j.zsh;
    localObject = j.b.dVF();
    if (paramm != null) {
      ((com.tencent.mm.plugin.story.i.g)localObject).zCt.remove(paramm);
    }
    AppMethodBeat.o(118549);
  }
  
  public final void reportWaitPlayList(List<String> paramList, long paramLong)
  {
    AppMethodBeat.i(118559);
    d.g.b.k.h(paramList, "userList");
    com.tencent.mm.plugin.story.f.k localk = com.tencent.mm.plugin.story.f.k.zsq;
    com.tencent.mm.plugin.story.f.k.reportWaitPlayList(paramList, paramLong);
    AppMethodBeat.o(118559);
  }
  
  public final void setPreviewEnterScene(long paramLong)
  {
    AppMethodBeat.i(118556);
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.zAU;
    com.tencent.mm.plugin.story.h.h.dXK().jm(paramLong);
    AppMethodBeat.o(118556);
  }
  
  public final boolean showStoryEntranceDialog(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(118560);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramString, "sessionId");
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.zAU;
    com.tencent.mm.plugin.story.h.h.dYg().mw(paramString);
    paramString = com.tencent.mm.plugin.story.h.h.zAU;
    com.tencent.mm.plugin.story.h.h.dYg().in((int)System.currentTimeMillis());
    paramString = com.tencent.mm.plugin.story.h.h.zAU;
    paramString = com.tencent.mm.plugin.story.h.h.zAU;
    com.tencent.mm.plugin.story.h.h.QK(com.tencent.mm.plugin.story.h.h.dYg().Rp());
    paramString = com.tencent.mm.plugin.story.h.h.zAU;
    com.tencent.mm.plugin.story.h.h.dYg().io(paramInt);
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
    com.tencent.mm.plugin.story.f.e.a.zuX.startStoryCapture(paramContext, paramInt1, paramLong);
    AppMethodBeat.o(118564);
  }
  
  public final com.tencent.mm.plugin.story.api.h storyComment()
  {
    return (com.tencent.mm.plugin.story.api.h)com.tencent.mm.plugin.story.f.b.b.ztY;
  }
  
  public final void updateStoryUserInfo(String paramString, deq paramdeq)
  {
    AppMethodBeat.i(118562);
    Object localObject = com.tencent.mm.plugin.story.f.j.zsh;
    localObject = j.b.dVF();
    if ((paramString == null) || (paramdeq == null))
    {
      AppMethodBeat.o(118562);
      return;
    }
    com.tencent.mm.plugin.story.i.f localf = ((com.tencent.mm.plugin.story.i.g)localObject).awy(paramString);
    if (paramdeq != null) {}
    for (paramString = paramdeq.toByteArray();; paramString = null)
    {
      localf.field_userInfo = paramString;
      ((com.tencent.mm.plugin.story.i.g)localObject).b(localf);
      AppMethodBeat.o(118562);
      return;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StoryFileCleanTaskEvent;", "()V", "callback", "", "event", "plugin-story_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<vf>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(com.tencent.mm.plugin.story.ui.sns.c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(118537);
      this.zpT.cancel();
      AppMethodBeat.o(118537);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.PluginStory
 * JD-Core Version:    0.7.0.1
 */