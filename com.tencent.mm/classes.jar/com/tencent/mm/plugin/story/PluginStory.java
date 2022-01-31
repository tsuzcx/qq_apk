package com.tencent.mm.plugin.story;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aw;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.media.g.d.a;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.story.api.k.c;
import com.tencent.mm.plugin.story.f.g.a;
import com.tencent.mm.plugin.story.g.c.a;
import com.tencent.mm.plugin.story.model.d;
import com.tencent.mm.plugin.story.model.f.a;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/PluginStory;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/story/api/IPluginStory;", "()V", "STORAGE_STORY", "", "STORAGE_STORY_TEMP", "addStoryPostListener", "", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "addStoryStatusNotifyListener", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "canPostStory", "", "checkPost", "checkReportFromChatting", "clickScene", "", "user", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "enterGallery", "unreadList", "", "execute", "getAccStoryCachePath", "getAccStoryPath", "getAccStoryTmpPath", "getContactFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "getFavourUserChecker", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "getStoryBasicConfig", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "getStoryStateFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "getStoryUIFactory", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "getStoryUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "hasNewStory", "username", "isShowStoryCheck", "isStoryExist", "userName", "isStoryUnread", "loadStory", "roomId", "name", "preLoadVideoViewMgr", "preloadForSnsUser", "isEnter", "removeStoryPostListener", "removeStoryStatusNotifyListener", "reportWaitPlayList", "userList", "scene", "", "setPreviewEnterScene", "showStoryEntranceDialog", "context", "Landroid/content/Context;", "sessionId", "exposeOrder", "storyComment", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "updateStoryUserInfo", "userInfo", "Companion", "StoryCleanListener", "StorySynclistener", "plugin-story_release"})
public final class PluginStory
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.story.api.e
{
  private static final String TAG = "MicroMsg.PluginStory";
  public static final PluginStory.a sqE;
  private final String sqC;
  private final String sqD;
  
  static
  {
    AppMethodBeat.i(108938);
    sqE = new PluginStory.a((byte)0);
    TAG = "MicroMsg.PluginStory";
    AppMethodBeat.o(108938);
  }
  
  public PluginStory()
  {
    AppMethodBeat.i(155287);
    this.sqC = "oneday/";
    this.sqD = "oneday/temp/";
    AppMethodBeat.o(155287);
  }
  
  public final void addStoryPostListener(com.tencent.mm.plugin.story.api.j paramj)
  {
    AppMethodBeat.i(108921);
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAI().a(paramj);
    AppMethodBeat.o(108921);
  }
  
  public final void addStoryStatusNotifyListener(com.tencent.mm.plugin.story.api.l paraml)
  {
    AppMethodBeat.i(108923);
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    localObject = j.b.cAC();
    if ((paraml != null) && (!((com.tencent.mm.plugin.story.h.g)localObject).sGA.contains(paraml))) {
      ((com.tencent.mm.plugin.story.h.g)localObject).sGA.add(paraml);
    }
    AppMethodBeat.o(108923);
  }
  
  public final boolean canPostStory()
  {
    AppMethodBeat.i(108928);
    d locald = d.sut;
    boolean bool = d.canPostStory();
    AppMethodBeat.o(108928);
    return bool;
  }
  
  public final void checkPost()
  {
    AppMethodBeat.i(108926);
    if (!isShowStoryCheck())
    {
      AppMethodBeat.o(108926);
      return;
    }
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAI().checkPost();
    AppMethodBeat.o(108926);
  }
  
  public final boolean checkReportFromChatting(int paramInt, String paramString)
  {
    AppMethodBeat.i(108929);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(108929);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    com.tencent.mm.plugin.story.h.g localg = j.b.cAC();
    if (paramString == null) {}
    label135:
    label296:
    label444:
    for (localObject = "";; localObject = paramString)
    {
      localObject = localg.acU((String)localObject);
      boolean bool2 = ((com.tencent.mm.plugin.story.h.f)localObject).cEU();
      int i;
      if (((com.tencent.mm.plugin.story.h.f)localObject).cES() > 0L)
      {
        i = 1;
        localObject = com.tencent.mm.plugin.story.g.c.sEl;
        com.tencent.mm.plugin.story.g.c.clean();
        localObject = com.tencent.mm.plugin.story.g.b.sDR;
        com.tencent.mm.plugin.story.g.b.clean();
        localObject = com.tencent.mm.plugin.story.g.b.sDR;
        if (paramString != null) {
          break label450;
        }
      }
      label320:
      label450:
      for (localObject = "";; localObject = paramString)
      {
        a.f.b.j.q(localObject, "user");
        com.tencent.mm.plugin.story.g.b.FS(paramInt);
        com.tencent.mm.plugin.story.g.b.clean();
        com.tencent.mm.plugin.story.g.b.sDK = bo.aoy();
        boolean bool1;
        if ((NetStatusUtil.isWifi(ah.getContext())) || (NetStatusUtil.is4G(ah.getContext())))
        {
          bool1 = true;
          com.tencent.mm.plugin.story.g.b.muY = bool1;
          if (bool1)
          {
            ab.i("MicroMsg.StoryBrowseDetailIDKeyStat", "chattingRight " + (String)localObject + " isWifi:" + com.tencent.mm.plugin.story.g.b.muY);
            com.tencent.mm.plugin.story.g.b.k(com.tencent.mm.plugin.story.g.b.ltw, 1L, 1L);
          }
          if (paramInt != 1) {
            break label320;
          }
          localObject = com.tencent.mm.plugin.story.g.c.sEl;
          if (paramString != null) {
            break label444;
          }
        }
        for (localObject = "";; localObject = paramString)
        {
          a.f.b.j.q(localObject, "user");
          com.tencent.mm.plugin.story.g.c.clean();
          com.tencent.mm.plugin.story.g.c.sEh = false;
          com.tencent.mm.plugin.story.g.c.sEc = new c.a((String)localObject, 1);
          ab.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRight ".concat(String.valueOf(localObject)));
          com.tencent.mm.plugin.report.service.h.qsU.j(988L, 1L, 1L);
          if (bool2)
          {
            if (i == 0) {
              break label296;
            }
            paramString = com.tencent.mm.plugin.story.g.c.sEl;
            com.tencent.mm.plugin.story.g.c.cCD();
          }
          do
          {
            for (;;)
            {
              AppMethodBeat.o(108929);
              return true;
              i = 0;
              break;
              bool1 = false;
              break label135;
              localObject = com.tencent.mm.plugin.story.g.c.sEl;
              localObject = paramString;
              if (paramString == null) {
                localObject = "";
              }
              com.tencent.mm.plugin.story.g.c.ads((String)localObject);
            }
          } while (paramInt != 2);
          localObject = com.tencent.mm.plugin.story.g.c.sEl;
          if (paramString == null) {}
          for (localObject = "";; localObject = paramString)
          {
            a.f.b.j.q(localObject, "user");
            com.tencent.mm.plugin.story.g.c.clean();
            com.tencent.mm.plugin.story.g.c.sEh = true;
            com.tencent.mm.plugin.story.g.c.sEc = new c.a((String)localObject, 2);
            ab.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheck ".concat(String.valueOf(localObject)));
            com.tencent.mm.plugin.report.service.h.qsU.j(988L, 2L, 1L);
            if (!bool2) {
              break;
            }
            if (i != 0)
            {
              paramString = com.tencent.mm.plugin.story.g.c.sEl;
              com.tencent.mm.plugin.story.g.c.cCE();
              break;
            }
            localObject = com.tencent.mm.plugin.story.g.c.sEl;
            localObject = paramString;
            if (paramString == null) {
              localObject = "";
            }
            com.tencent.mm.plugin.story.g.c.adt((String)localObject);
            break;
          }
        }
      }
    }
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(108916);
    if ((paramg != null) && (paramg.SD()))
    {
      ab.i(TAG, "PluginStory configure");
      pin((com.tencent.mm.kernel.b.c)new q(com.tencent.mm.plugin.story.model.j.class));
    }
    AppMethodBeat.o(108916);
  }
  
  public final void enterGallery(List<String> paramList)
  {
    AppMethodBeat.i(108930);
    a.f.b.j.q(paramList, "unreadList");
    Object localObject = com.tencent.mm.plugin.story.g.c.sEl;
    com.tencent.mm.plugin.story.g.c.dE(paramList);
    localObject = com.tencent.mm.plugin.story.g.b.sDR;
    com.tencent.mm.plugin.story.g.b.dE(paramList);
    AppMethodBeat.o(108930);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(108915);
    com.tencent.mm.media.g.d.eWu = (d.a)new com.tencent.mm.media.g.i();
    AppMethodBeat.o(108915);
  }
  
  public final String getAccStoryCachePath()
  {
    AppMethodBeat.i(108914);
    String str = ah.getContext().getCacheDir().getAbsolutePath() + "/" + this.sqC;
    AppMethodBeat.o(108914);
    return str;
  }
  
  public final String getAccStoryPath()
  {
    AppMethodBeat.i(108912);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.RL();
    a.f.b.j.p(locale, "storage()");
    localObject = locale.getAccPath() + this.sqC;
    AppMethodBeat.o(108912);
    return localObject;
  }
  
  public final String getAccStoryTmpPath()
  {
    AppMethodBeat.i(108913);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.RL();
    a.f.b.j.p(locale, "storage()");
    localObject = locale.getAccPath() + this.sqD;
    AppMethodBeat.o(108913);
    return localObject;
  }
  
  public final k.c getContactFetcher()
  {
    return (k.c)com.tencent.mm.plugin.story.model.f.a.szc;
  }
  
  public final com.tencent.mm.plugin.story.api.b getFavourUserChecker()
  {
    return (com.tencent.mm.plugin.story.api.b)com.tencent.mm.plugin.story.model.b.sun;
  }
  
  public final com.tencent.mm.plugin.story.api.f getStoryBasicConfig()
  {
    return (com.tencent.mm.plugin.story.api.f)com.tencent.mm.plugin.story.c.a.a.srz;
  }
  
  public final com.tencent.mm.plugin.story.api.k getStoryStateFetcher(String paramString)
  {
    AppMethodBeat.i(108920);
    com.tencent.mm.plugin.story.model.f.e locale = com.tencent.mm.plugin.story.model.f.e.szO;
    paramString = com.tencent.mm.plugin.story.model.f.e.adr(paramString);
    AppMethodBeat.o(108920);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.story.api.m getStoryUIFactory()
  {
    return (com.tencent.mm.plugin.story.api.m)com.tencent.mm.plugin.story.model.r.swh;
  }
  
  public final cid getStoryUserInfo()
  {
    AppMethodBeat.i(108936);
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    localObject1 = j.b.cAC();
    Object localObject2 = com.tencent.mm.plugin.story.model.j.svi;
    localObject2 = ((com.tencent.mm.plugin.story.h.g)localObject1).acU(j.b.coK()).cET();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new cid();
    }
    AppMethodBeat.o(108936);
    return localObject1;
  }
  
  public final boolean hasNewStory(String paramString)
  {
    AppMethodBeat.i(108927);
    if (!com.tencent.mm.plugin.story.api.n.isShowStoryCheck())
    {
      AppMethodBeat.o(108927);
      return false;
    }
    com.tencent.mm.plugin.story.model.k localk = com.tencent.mm.plugin.story.model.k.svr;
    boolean bool = com.tencent.mm.plugin.story.model.k.acV(paramString);
    AppMethodBeat.o(108927);
    return bool;
  }
  
  public final boolean isShowStoryCheck()
  {
    AppMethodBeat.i(108925);
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    boolean bool = j.b.cAO();
    AppMethodBeat.o(108925);
    return bool;
  }
  
  public final boolean isStoryExist(String paramString)
  {
    AppMethodBeat.i(108918);
    if (!com.tencent.mm.plugin.story.api.n.isShowStoryCheck())
    {
      AppMethodBeat.o(108918);
      return false;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(108918);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    boolean bool1;
    if ((a.f.b.j.e(paramString, j.b.coK()) ^ true))
    {
      localObject = com.tencent.mm.plugin.story.model.j.svi;
      bool2 = j.b.cAC().acU(paramString).isValid();
      bool1 = bool2;
      if (bool2)
      {
        ab.i(TAG, "ret1 has story!");
        AppMethodBeat.o(108918);
        return true;
      }
    }
    else
    {
      bool1 = false;
    }
    localObject = com.tencent.mm.plugin.story.model.n.svx;
    int i = cb.abr();
    localObject = com.tencent.mm.plugin.story.model.i.suJ;
    boolean bool2 = n.a.dx(paramString, i - com.tencent.mm.plugin.story.model.i.cAp());
    if (bool2) {
      ab.i(TAG, "ret2 has story!");
    }
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(108918);
      return true;
    }
    AppMethodBeat.o(108918);
    return false;
  }
  
  public final boolean isStoryUnread(String paramString)
  {
    AppMethodBeat.i(108917);
    f.a locala = com.tencent.mm.plugin.story.model.f.suC;
    boolean bool = f.a.isStoryUnread(paramString);
    AppMethodBeat.o(108917);
    return bool;
  }
  
  public final void loadStory(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108919);
    if (paramString1 == null)
    {
      AppMethodBeat.o(108919);
      return;
    }
    if (!com.tencent.mm.plugin.story.api.n.isShowStoryCheck())
    {
      AppMethodBeat.o(108919);
      return;
    }
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    boolean bool = bo.isEqual(paramString1, j.b.coK());
    if ((!bool) && (!com.tencent.mm.plugin.story.api.n.czB()))
    {
      localObject = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject).YA().arw(paramString1);
      if (localObject == null)
      {
        AppMethodBeat.o(108919);
        return;
      }
      if (!((ad)localObject).NT())
      {
        ab.i(TAG, "filter by isOpenStrangerUserPage close ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(108919);
        return;
      }
    }
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    paramString1 = new com.tencent.mm.plugin.story.model.a.j(paramString1, bool, (String)localObject);
    paramString2 = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(paramString2, "MMKernel.network()");
    paramString2.Rc().b((com.tencent.mm.ai.m)paramString1);
    AppMethodBeat.o(108919);
  }
  
  public final String name()
  {
    return "plugin-story";
  }
  
  public final boolean preLoadVideoViewMgr(String paramString)
  {
    AppMethodBeat.i(108932);
    Object localObject = com.tencent.mm.plugin.story.ui.view.gallery.r.sVJ;
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    com.tencent.mm.plugin.story.ui.view.gallery.r.adM((String)localObject);
    AppMethodBeat.o(108932);
    return true;
  }
  
  public final void preloadForSnsUser(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(108933);
    if (paramString == null)
    {
      AppMethodBeat.o(108933);
      return;
    }
    if (paramBoolean) {}
    for (int i = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSd, 1);; i = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSf, 0))
    {
      ab.i(TAG, "preloadForSnsUser: " + i + " isEnter: " + paramBoolean + " username " + paramString + ' ' + bo.dtY());
      if (i != 1) {
        break;
      }
      Object localObject = com.tencent.mm.plugin.story.f.g.sBI;
      paramString = g.a.bz(paramString, false);
      if (paramString == null) {
        break;
      }
      localObject = com.tencent.mm.plugin.story.ui.view.gallery.p.sUH;
      com.tencent.mm.plugin.story.ui.view.gallery.p.dO(a.a.j.listOf(paramString.syr));
      AppMethodBeat.o(108933);
      return;
    }
    AppMethodBeat.o(108933);
  }
  
  public final void removeStoryPostListener(com.tencent.mm.plugin.story.api.j paramj)
  {
    AppMethodBeat.i(108922);
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAI().b(paramj);
    AppMethodBeat.o(108922);
  }
  
  public final void removeStoryStatusNotifyListener(com.tencent.mm.plugin.story.api.l paraml)
  {
    AppMethodBeat.i(108924);
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    localObject = j.b.cAC();
    if (paraml != null) {
      ((com.tencent.mm.plugin.story.h.g)localObject).sGA.remove(paraml);
    }
    AppMethodBeat.o(108924);
  }
  
  public final void reportWaitPlayList(List<String> paramList, long paramLong)
  {
    AppMethodBeat.i(108934);
    a.f.b.j.q(paramList, "userList");
    com.tencent.mm.plugin.story.model.k localk = com.tencent.mm.plugin.story.model.k.svr;
    com.tencent.mm.plugin.story.model.k.reportWaitPlayList(paramList, paramLong);
    AppMethodBeat.o(108934);
  }
  
  public final void setPreviewEnterScene(long paramLong)
  {
    AppMethodBeat.i(108931);
    com.tencent.mm.plugin.story.g.i locali = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDo().cE(paramLong);
    AppMethodBeat.o(108931);
  }
  
  public final boolean showStoryEntranceDialog(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(108935);
    a.f.b.j.q(paramContext, "context");
    a.f.b.j.q(paramString, "sessionId");
    com.tencent.mm.plugin.story.g.i locali = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDM().gj(paramString);
    paramString = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDM().gD((int)System.currentTimeMillis());
    paramString = com.tencent.mm.plugin.story.g.i.sFa;
    paramString = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.FX(com.tencent.mm.plugin.story.g.i.cDM().Fz());
    paramString = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDM().gE(paramInt);
    paramString = new com.tencent.mm.plugin.story.ui.sns.b(paramContext);
    paramString.setContentView((View)new com.tencent.mm.plugin.story.ui.sns.c(paramContext, (View.OnClickListener)new PluginStory.d(paramString)));
    paramString.show();
    AppMethodBeat.o(108935);
    return true;
  }
  
  public final com.tencent.mm.plugin.story.api.h storyComment()
  {
    return (com.tencent.mm.plugin.story.api.h)com.tencent.mm.plugin.story.model.b.b.sxN;
  }
  
  public final void updateStoryUserInfo(String paramString, cid paramcid)
  {
    AppMethodBeat.i(108937);
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    localObject = j.b.cAC();
    if ((paramString == null) || (paramcid == null))
    {
      AppMethodBeat.o(108937);
      return;
    }
    com.tencent.mm.plugin.story.h.f localf = ((com.tencent.mm.plugin.story.h.g)localObject).acU(paramString);
    if (paramcid != null) {}
    for (paramString = paramcid.toByteArray();; paramString = null)
    {
      localf.field_userInfo = paramString;
      ((com.tencent.mm.plugin.story.h.g)localObject).b(localf);
      AppMethodBeat.o(108937);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.PluginStory
 * JD-Core Version:    0.7.0.1
 */