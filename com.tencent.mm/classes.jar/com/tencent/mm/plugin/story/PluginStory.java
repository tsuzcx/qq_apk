package com.tencent.mm.plugin.story;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.os;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.story.api.k;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.m.a;
import com.tencent.mm.plugin.story.model.q;
import com.tencent.mm.protocal.protobuf.fjk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.vfs.af;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/PluginStory;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/story/api/IPluginStory;", "()V", "STORAGE_STORY", "", "STORAGE_STORY_TEMP", "StoryMaxStorageSize", "", "addStoryPostListener", "", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "addStoryStatusNotifyListener", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "canPostStory", "", "checkPost", "checkReportFromChatting", "clickScene", "", "user", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "enterGallery", "unreadList", "", "execute", "getAccStoryCachePath", "getAccStoryPath", "getAccStoryTmpPath", "getContactFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "getFavourUserChecker", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "getStoryBasicConfig", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "getStoryNewFeatureConfig", "Lcom/tencent/mm/plugin/story/api/IStoryNewFeatureConfig;", "getStoryStateFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "getStoryUIFactory", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "getStoryUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "hasNewStory", "username", "isShowStoryCheck", "isStoryExist", "userName", "isStoryUnread", "loadStory", "roomId", "name", "preLoadVideoViewMgr", "preloadForSnsUser", "isEnter", "removeStoryPostListener", "removeStoryStatusNotifyListener", "reportWaitPlayList", "userList", "scene", "setPreviewEnterScene", "showStoryEntranceDialog", "context", "Landroid/content/Context;", "sessionId", "exposeOrder", "startStoryCapture", "jumpPageFrom", "videoObjectId", "startStoryCaptureForResult", "requestCode", "storyComment", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "updateStoryUserInfo", "userInfo", "Companion", "StoryCleanListener", "StorySynclistener", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginStory
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.story.api.e
{
  public static final PluginStory.a ScJ;
  private static final String TAG;
  private final long ScK = 536870912L;
  private final String ScL = "oneday/";
  private final String ScM = "oneday/temp/";
  
  static
  {
    AppMethodBeat.i(118565);
    ScJ = new PluginStory.a((byte)0);
    TAG = "MicroMsg.PluginStory";
    AppMethodBeat.o(118565);
  }
  
  private static final void showStoryEntranceDialog$lambda-1(com.tencent.mm.plugin.story.ui.sns.c paramc, View paramView)
  {
    AppMethodBeat.i(366930);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/PluginStory", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "$dialog");
    paramc.cancel();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/PluginStory", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(366930);
  }
  
  public final void addStoryPostListener(k paramk)
  {
    AppMethodBeat.i(118546);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.hvX().a(paramk);
    AppMethodBeat.o(118546);
  }
  
  public final void addStoryStatusNotifyListener(com.tencent.mm.plugin.story.api.m paramm)
  {
    AppMethodBeat.i(118548);
    Object localObject = StoryCore.SjP;
    localObject = StoryCore.b.hvS();
    if ((paramm != null) && (!((com.tencent.mm.plugin.story.h.g)localObject).SsX.contains(paramm))) {
      ((com.tencent.mm.plugin.story.h.g)localObject).SsX.add(paramm);
    }
    AppMethodBeat.o(118548);
  }
  
  public final boolean canPostStory()
  {
    AppMethodBeat.i(118553);
    com.tencent.mm.plugin.story.model.d locald = com.tencent.mm.plugin.story.model.d.Sjy;
    boolean bool = com.tencent.mm.plugin.story.model.d.canPostStory();
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
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.hvX().checkPost();
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
    Object localObject = StoryCore.SjP;
    com.tencent.mm.plugin.story.h.g localg = StoryCore.b.hvS();
    boolean bool2;
    int i;
    label66:
    label96:
    boolean bool1;
    if (paramString == null)
    {
      localObject = "";
      localObject = localg.bbJ((String)localObject);
      bool2 = ((com.tencent.mm.plugin.story.h.f)localObject).hzn();
      if (((com.tencent.mm.plugin.story.h.f)localObject).hzl() <= 0L) {
        break label229;
      }
      i = 1;
      localObject = com.tencent.mm.plugin.story.g.c.SqL;
      com.tencent.mm.plugin.story.g.c.clean();
      localObject = com.tencent.mm.plugin.story.g.b.Sqn;
      com.tencent.mm.plugin.story.g.b.clean();
      localObject = com.tencent.mm.plugin.story.g.b.Sqn;
      if (paramString != null) {
        break label234;
      }
      localObject = "";
      kotlin.g.b.s.u(localObject, "user");
      com.tencent.mm.plugin.story.g.b.anm(paramInt);
      com.tencent.mm.plugin.story.g.b.clean();
      com.tencent.mm.plugin.story.g.b.Sqv = Util.nowMilliSecond();
      if ((!NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (!NetStatusUtil.is4G(MMApplicationContext.getContext()))) {
        break label240;
      }
      bool1 = true;
      label138:
      com.tencent.mm.plugin.story.g.b.Aey = bool1;
      if (bool1)
      {
        Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "chattingRight " + (String)localObject + " isWifi:" + com.tencent.mm.plugin.story.g.b.Aey);
        com.tencent.mm.plugin.story.g.b.q(com.tencent.mm.plugin.story.g.b.ID, 1L, 1L);
      }
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(118554);
      return true;
      localObject = paramString;
      break;
      label229:
      i = 0;
      break label66;
      label234:
      localObject = paramString;
      break label96;
      label240:
      bool1 = false;
      break label138;
      localObject = com.tencent.mm.plugin.story.g.c.SqL;
      if (paramString == null) {}
      for (localObject = "";; localObject = paramString)
      {
        kotlin.g.b.s.u(localObject, "user");
        com.tencent.mm.plugin.story.g.c.clean();
        com.tencent.mm.plugin.story.g.c.SqR = false;
        com.tencent.mm.plugin.story.g.c.SqM = new com.tencent.mm.plugin.story.g.c.a((String)localObject, 1);
        Log.i("MicroMsg.StoryBrowseIDKeyStat", kotlin.g.b.s.X("chattingRight ", localObject));
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 1L, 1L);
        if (!bool2) {
          break;
        }
        if (i == 0) {
          break label338;
        }
        paramString = com.tencent.mm.plugin.story.g.c.SqL;
        com.tencent.mm.plugin.story.g.c.hxD();
        break;
      }
      label338:
      localObject = com.tencent.mm.plugin.story.g.c.SqL;
      localObject = paramString;
      if (paramString == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.story.g.c.bcb((String)localObject);
      continue;
      localObject = com.tencent.mm.plugin.story.g.c.SqL;
      if (paramString == null) {}
      for (localObject = "";; localObject = paramString)
      {
        kotlin.g.b.s.u(localObject, "user");
        com.tencent.mm.plugin.story.g.c.clean();
        com.tencent.mm.plugin.story.g.c.SqR = true;
        com.tencent.mm.plugin.story.g.c.SqM = new com.tencent.mm.plugin.story.g.c.a((String)localObject, 2);
        Log.i("MicroMsg.StoryBrowseIDKeyStat", kotlin.g.b.s.X("chattingDoubleCheck ", localObject));
        com.tencent.mm.plugin.report.service.h.OAn.p(988L, 2L, 1L);
        if (!bool2) {
          break;
        }
        if (i == 0) {
          break label457;
        }
        paramString = com.tencent.mm.plugin.story.g.c.SqL;
        com.tencent.mm.plugin.story.g.c.hxE();
        break;
      }
      label457:
      localObject = com.tencent.mm.plugin.story.g.c.SqL;
      localObject = paramString;
      if (paramString == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.story.g.c.bcc((String)localObject);
    }
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(118541);
    if ((paramg != null) && (paramg.bbA()))
    {
      Log.i(TAG, "PluginStory configure");
      pin((com.tencent.mm.kernel.b.c)new y(StoryCore.class));
      af.b("oneday", "oneday", this.ScK, 7776000000L, 1);
      af.a("onedayCache", "oneday", 604800000L, 102);
    }
    AppMethodBeat.o(118541);
  }
  
  public final void enterGallery(List<String> paramList)
  {
    AppMethodBeat.i(118555);
    kotlin.g.b.s.u(paramList, "unreadList");
    Object localObject = com.tencent.mm.plugin.story.g.c.SqL;
    com.tencent.mm.plugin.story.g.c.lk(paramList);
    localObject = com.tencent.mm.plugin.story.g.b.Sqn;
    com.tencent.mm.plugin.story.g.b.lk(paramList);
    AppMethodBeat.o(118555);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    com.tencent.mm.media.i.c.nBL = (com.tencent.mm.media.i.c.a)com.tencent.mm.media.i.g.nDb;
  }
  
  public final String getAccStoryCachePath()
  {
    AppMethodBeat.i(118540);
    String str = MMApplicationContext.getContext().getCacheDir().getAbsolutePath() + '/' + this.ScL;
    AppMethodBeat.o(118540);
    return str;
  }
  
  public final String getAccStoryPath()
  {
    AppMethodBeat.i(118538);
    String str = kotlin.g.b.s.X(com.tencent.mm.kernel.h.baE().mCJ, this.ScL);
    AppMethodBeat.o(118538);
    return str;
  }
  
  public final String getAccStoryTmpPath()
  {
    AppMethodBeat.i(118539);
    String str = kotlin.g.b.s.X(com.tencent.mm.kernel.h.baE().mCJ, this.ScM);
    AppMethodBeat.o(118539);
    return str;
  }
  
  public final l.c getContactFetcher()
  {
    return (l.c)com.tencent.mm.plugin.story.model.sync.a.SmO;
  }
  
  public final com.tencent.mm.plugin.story.api.b getFavourUserChecker()
  {
    return (com.tencent.mm.plugin.story.api.b)com.tencent.mm.plugin.story.model.b.Sjr;
  }
  
  public final com.tencent.mm.plugin.story.api.f getStoryBasicConfig()
  {
    return (com.tencent.mm.plugin.story.api.f)com.tencent.mm.plugin.story.c.a.a.SiJ;
  }
  
  public final com.tencent.mm.plugin.story.api.j getStoryNewFeatureConfig()
  {
    return (com.tencent.mm.plugin.story.api.j)com.tencent.mm.plugin.story.c.a.e.Sjb;
  }
  
  public final com.tencent.mm.plugin.story.api.l getStoryStateFetcher(String paramString)
  {
    AppMethodBeat.i(118545);
    com.tencent.mm.plugin.story.model.sync.e locale = com.tencent.mm.plugin.story.model.sync.e.SnJ;
    paramString = com.tencent.mm.plugin.story.model.sync.e.bca(paramString);
    AppMethodBeat.o(118545);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.story.api.n getStoryUIFactory()
  {
    return (com.tencent.mm.plugin.story.api.n)q.SkV;
  }
  
  public final fjk getStoryUserInfo()
  {
    AppMethodBeat.i(118561);
    Object localObject = StoryCore.SjP;
    localObject = StoryCore.b.hvS();
    StoryCore.b localb = StoryCore.SjP;
    localObject = ((com.tencent.mm.plugin.story.h.g)localObject).bbJ(StoryCore.b.hgg()).hzm();
    if (localObject == null)
    {
      localObject = new fjk();
      AppMethodBeat.o(118561);
      return localObject;
    }
    AppMethodBeat.o(118561);
    return localObject;
  }
  
  public final boolean hasNewStory(String paramString)
  {
    AppMethodBeat.i(118552);
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118552);
      return false;
    }
    com.tencent.mm.plugin.story.model.j localj = com.tencent.mm.plugin.story.model.j.Skm;
    boolean bool = com.tencent.mm.plugin.story.model.j.bbK(paramString);
    AppMethodBeat.o(118552);
    return bool;
  }
  
  public final boolean isShowStoryCheck()
  {
    AppMethodBeat.i(118550);
    StoryCore.b localb = StoryCore.SjP;
    boolean bool = StoryCore.b.hwd();
    AppMethodBeat.o(118550);
    return bool;
  }
  
  public final boolean isStoryExist(String paramString)
  {
    AppMethodBeat.i(118543);
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118543);
      return false;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(118543);
      return false;
    }
    Object localObject = StoryCore.SjP;
    boolean bool1;
    if (!kotlin.g.b.s.p(paramString, StoryCore.b.hgg()))
    {
      localObject = StoryCore.SjP;
      bool2 = StoryCore.b.hvS().bbJ(paramString).isValid();
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
    localObject = com.tencent.mm.plugin.story.model.m.Sks;
    int i = cn.getSyncServerTimeSecond();
    localObject = com.tencent.mm.plugin.story.model.i.SjL;
    boolean bool2 = m.a.hk(paramString, i - com.tencent.mm.plugin.story.model.i.hvz());
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
    com.tencent.mm.plugin.story.model.f.a locala = com.tencent.mm.plugin.story.model.f.SjJ;
    boolean bool = com.tencent.mm.plugin.story.model.f.a.isStoryUnread(paramString);
    AppMethodBeat.o(118542);
    return bool;
  }
  
  public final void loadStory(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(118544);
    if (paramString1 == null)
    {
      AppMethodBeat.o(118544);
      return;
    }
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(118544);
      return;
    }
    Object localObject = StoryCore.SjP;
    boolean bool2 = Util.isEqual(paramString1, StoryCore.b.hgg());
    if (!bool2)
    {
      boolean bool1;
      if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("StoryOpenStrangerUserPage", 1) == 2)
      {
        bool1 = true;
        Log.i("LaunchStory", "isOpenRoomSync %s", new Object[] { Boolean.valueOf(bool1) });
        if (bool1) {
          break label149;
        }
      }
      for (;;)
      {
        if (i == 0)
        {
          localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString1);
          if (localObject == null)
          {
            AppMethodBeat.o(118544);
            return;
            bool1 = false;
            break;
            label149:
            i = 0;
            continue;
          }
          if (!com.tencent.mm.contact.d.rs(((az)localObject).field_type))
          {
            Log.i(TAG, kotlin.g.b.s.X("filter by isOpenStrangerUserPage close ", paramString1));
            AppMethodBeat.o(118544);
            return;
          }
        }
      }
    }
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    paramString1 = new com.tencent.mm.plugin.story.model.a.i(paramString1, bool2, (String)localObject);
    com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)paramString1, 0);
    AppMethodBeat.o(118544);
  }
  
  public final String name()
  {
    return "plugin-story";
  }
  
  public final boolean preLoadVideoViewMgr(String paramString)
  {
    AppMethodBeat.i(118557);
    Object localObject = com.tencent.mm.plugin.story.ui.view.gallery.l.SDE;
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    com.tencent.mm.plugin.story.ui.view.gallery.l.bcx((String)localObject);
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
    for (int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yIE, 1);; i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yIG, 0))
    {
      Log.i(TAG, "preloadForSnsUser: " + i + " isEnter: " + paramBoolean + " username " + paramString + ' ' + Util.getStack());
      if (i == 1)
      {
        com.tencent.mm.plugin.story.f.f.a locala = com.tencent.mm.plugin.story.f.f.SoU;
        paramString = com.tencent.mm.plugin.story.f.f.a.dn(paramString, false);
        if (paramString != null) {
          com.tencent.mm.plugin.story.ui.view.gallery.j.a(com.tencent.mm.plugin.story.ui.view.gallery.j.SCD, kotlin.a.p.listOf(paramString.Smr));
        }
      }
      AppMethodBeat.o(118558);
      return;
    }
  }
  
  public final void removeStoryPostListener(k paramk)
  {
    AppMethodBeat.i(118547);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.hvX().b(paramk);
    AppMethodBeat.o(118547);
  }
  
  public final void removeStoryStatusNotifyListener(com.tencent.mm.plugin.story.api.m paramm)
  {
    AppMethodBeat.i(118549);
    Object localObject = StoryCore.SjP;
    localObject = StoryCore.b.hvS();
    if (paramm != null) {
      ((com.tencent.mm.plugin.story.h.g)localObject).SsX.remove(paramm);
    }
    AppMethodBeat.o(118549);
  }
  
  public final void reportWaitPlayList(List<String> paramList, long paramLong)
  {
    AppMethodBeat.i(118559);
    kotlin.g.b.s.u(paramList, "userList");
    com.tencent.mm.plugin.story.model.j localj = com.tencent.mm.plugin.story.model.j.Skm;
    com.tencent.mm.plugin.story.model.j.reportWaitPlayList(paramList, paramLong);
    AppMethodBeat.o(118559);
  }
  
  public final void setPreviewEnterScene(long paramLong)
  {
    AppMethodBeat.i(118556);
    com.tencent.mm.plugin.story.g.h localh = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxW().jjn = paramLong;
    AppMethodBeat.o(118556);
  }
  
  public final boolean showStoryEntranceDialog(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(118560);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "sessionId");
    com.tencent.mm.plugin.story.g.h localh = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hys().ww(paramString);
    paramString = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hys().jjY = ((int)System.currentTimeMillis());
    paramString = com.tencent.mm.plugin.story.g.h.SqZ;
    paramString = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.anr(com.tencent.mm.plugin.story.g.h.hys().jjY);
    paramString = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hys().jjZ = paramInt;
    paramString = new com.tencent.mm.plugin.story.ui.sns.c(paramContext);
    paramString.setContentView((View)new com.tencent.mm.plugin.story.ui.sns.d(paramContext, new PluginStory..ExternalSyntheticLambda0(paramString)));
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
    com.tencent.mm.plugin.story.model.e.a.SmE.startStoryCapture(paramContext, paramInt1, paramLong);
    AppMethodBeat.o(118564);
  }
  
  public final com.tencent.mm.plugin.story.api.h storyComment()
  {
    return (com.tencent.mm.plugin.story.api.h)com.tencent.mm.plugin.story.model.b.b.SlF;
  }
  
  public final void updateStoryUserInfo(String paramString, fjk paramfjk)
  {
    AppMethodBeat.i(118562);
    Object localObject = StoryCore.SjP;
    localObject = StoryCore.b.hvS();
    if ((paramString == null) || (paramfjk == null))
    {
      AppMethodBeat.o(118562);
      return;
    }
    com.tencent.mm.plugin.story.h.f localf = ((com.tencent.mm.plugin.story.h.g)localObject).bbJ(paramString);
    if (paramfjk == null) {}
    for (paramString = null;; paramString = paramfjk.toByteArray())
    {
      localf.field_userInfo = paramString;
      ((com.tencent.mm.plugin.story.h.g)localObject).b(localf);
      AppMethodBeat.o(118562);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.PluginStory
 * JD-Core Version:    0.7.0.1
 */