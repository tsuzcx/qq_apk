package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.d.e;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.af;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a.aq;
import com.tencent.pb.talkroom.sdk.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.j.c;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "contentView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "avatarChecker", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;", "getAvatarChecker", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;", "setAvatarChecker", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;)V", "getContentView", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "setContentView", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "subscribeVideoCacheList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "waitingRenderList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "checkRenderUserTalking", "", "userName", "checkSpeakerHasVideo", "engineDoMemberSelectForView", "memberIdList", "engineEncodeList", "", "getLargeRenderTarget", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "ori", "getNormalRenderTarget", "wxUserName", "getRandomNum", "maxSize", "onScreenFrame", "onTimeSecondCallback", "randomPeakUser", "randomPeakUserWhileTalking", "list", "", "refreshAvatar", "speakers", "release", "updateVideoSubscribe", "Companion", "plugin-multitalk_release"})
public final class i
  implements g
{
  public static final i.a FCj;
  private q FCh;
  j FCi;
  private a Fwg;
  private ArrayList<Integer> Fzv;
  
  static
  {
    AppMethodBeat.i(203739);
    FCj = new i.a((byte)0);
    AppMethodBeat.o(203739);
  }
  
  public i(j paramj, a parama)
  {
    AppMethodBeat.i(203738);
    this.FCi = paramj;
    this.Fwg = parama;
    paramj = ad.eYc();
    kotlin.g.b.p.j(paramj, "SubCoreMultiTalk.getMultiTalkManager()");
    paramj.eXp().a((g)this);
    this.FCh = new q(this.Fwg);
    paramj = this.FCh;
    if (paramj != null)
    {
      parama = paramj.FrD;
      if (parama != null) {
        parama.stopTimer();
      }
      parama = paramj.FrD;
      if (parama != null) {
        parama.quitSafely();
      }
      parama = paramj.FrD;
      if (parama != null) {
        parama.removeCallbacksAndMessages(null);
      }
      paramj.FrD = new MTimerHandler((MTimerHandler.CallBack)new q.a(paramj), true);
      paramj = paramj.FrD;
      if (paramj != null) {
        paramj.startTimer(20L);
      }
    }
    this.Fzv = new ArrayList();
    AppMethodBeat.o(203738);
  }
  
  private final void aI(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(203713);
    if (this.Fzv.isEmpty())
    {
      this.Fzv.addAll((Collection)paramArrayList);
      AppMethodBeat.o(203713);
      return;
    }
    Object localObject = paramArrayList;
    if (paramArrayList.size() < 2 - this.Fzv.size())
    {
      localObject = new ArrayList();
      Iterator localIterator = ((Iterable)this.Fzv).iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(Integer.valueOf(((Number)localIterator.next()).intValue()));
      }
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        int i = ((Number)paramArrayList.next()).intValue();
        if (!((ArrayList)localObject).contains(Integer.valueOf(i))) {
          ((ArrayList)localObject).add(Integer.valueOf(i));
        }
      }
    }
    this.Fzv = ((ArrayList)localObject);
    AppMethodBeat.o(203713);
  }
  
  private static int aJ(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(203717);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      AppMethodBeat.o(203717);
      return -1;
    }
    int j = paramArrayList.size();
    Object localObject1 = new int[j];
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = paramArrayList.get(i);
      kotlin.g.b.p.j(localObject2, "memberIdList[i]");
      int k = ((Number)localObject2).intValue();
      localStringBuilder.append(k).append(",");
      localObject1[i] = k;
      i += 1;
    }
    Log.i("MicroMsg.ScreenProjectAvatarManager", "steve: engineDoMemberSelectForView: selected id list: %s", new Object[] { localStringBuilder.toString() });
    paramArrayList = ByteBuffer.allocate(j * 4);
    paramArrayList.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put((int[])localObject1);
    paramArrayList = paramArrayList.array();
    localObject1 = ad.eYb();
    kotlin.g.b.p.j(localObject1, "SubCoreMultiTalk.getMultiEngine()");
    i = ((com.tencent.mm.plugin.multitalk.model.o)localObject1).eWv().setAppCmd(23, paramArrayList, j);
    if (i < 0)
    {
      Log.e("MicroMsg.ScreenProjectAvatarManager", "steve:engineDoMemberSelectForView failed!!");
      com.tencent.mm.plugin.multitalk.model.p.eWO();
      AppMethodBeat.o(203717);
      return -1;
    }
    AppMethodBeat.o(203717);
    return i;
  }
  
  private final void eZn()
  {
    AppMethodBeat.i(203729);
    Object localObject1 = ad.eYb();
    if (localObject1 != null)
    {
      Object localObject2 = ((com.tencent.mm.plugin.multitalk.model.o)localObject1).eWy();
      localObject1 = new ArrayList();
      Object localObject3 = (Collection)localObject2;
      if ((localObject3 == null) || (((Collection)localObject3).isEmpty()))
      {
        i = 1;
        if ((i == 0) && (((ArrayList)localObject2).size() - 1 > 0))
        {
          localObject2 = ((ArrayList)localObject2).subList(1, ((ArrayList)localObject2).size());
          kotlin.g.b.p.j(localObject2, "speakers.subList(startIndex,speakers.size)");
          localObject2 = ((Iterable)localObject2).iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label189;
          }
          localObject3 = (String)((Iterator)localObject2).next();
          com.tencent.mm.plugin.multitalk.model.q localq = ad.eYc();
          kotlin.g.b.p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
          if ((localq.eXE()) && (ad.eYc().aQi((String)localObject3)))
          {
            ((ArrayList)localObject1).add(Integer.valueOf(e.aQT((String)localObject3)));
            continue;
            i = 0;
            break;
          }
          Log.e("MicroMsg.ScreenProjectAvatarManager", "screen big are not allow to refresh decode");
        }
      }
      label189:
      if (((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i != 0) {
          break label432;
        }
        aI((ArrayList)localObject1);
        localObject2 = ad.eYc();
        kotlin.g.b.p.j(localObject2, "SubCoreMultiTalk.getMultiTalkManager()");
        boolean bool = ((com.tencent.mm.plugin.multitalk.model.q)localObject2).eXg();
        if (!bool) {
          aJ(this.Fzv);
        }
        if (!bool) {
          break label339;
        }
        if (this.Fzv.size() != 1) {
          break label326;
        }
        com.tencent.mm.plugin.multitalk.b.o.Fne.s((Integer)kotlin.a.j.lo((List)this.Fzv));
      }
      for (;;)
      {
        Log.i("MicroMsg.ScreenProjectAvatarManager", "ilink subscribeByUserMids ok, mids:" + localObject1 + " and subscribe one is " + this.Fzv);
        AppMethodBeat.o(203729);
        return;
        i = 0;
        break;
        label326:
        com.tencent.mm.plugin.multitalk.b.o.Fne.aG(this.Fzv);
      }
      label339:
      int j = this.Fzv.size();
      localObject1 = (List)new ArrayList();
      int i = 0;
      while (i < j)
      {
        localObject2 = new a.aq();
        localObject3 = this.Fzv.get(i);
        kotlin.g.b.p.j(localObject3, "subscribeVideoCacheList[i]");
        ((a.aq)localObject2).tQm = ((Number)localObject3).intValue();
        ((List)localObject1).add(localObject2);
        i += 1;
      }
      ad.eYc().gd((List)localObject1);
      label432:
      AppMethodBeat.o(203729);
      return;
    }
    AppMethodBeat.o(203729);
  }
  
  static String ge(List<String> paramList)
  {
    AppMethodBeat.i(203730);
    paramList = (String)paramList.get(kotlin.k.i.a(kotlin.k.i.ou(0, paramList.size()), (c)c.aaBL));
    AppMethodBeat.o(203730);
    return paramList;
  }
  
  public final f Xq(int paramInt)
  {
    return null;
  }
  
  public final f aPM(String paramString)
  {
    AppMethodBeat.i(203732);
    kotlin.g.b.p.k(paramString, "wxUserName");
    j localj = this.FCi;
    int i;
    if ((TextUtils.isEmpty((CharSequence)localj.getUsername())) || (kotlin.g.b.p.h(localj.getUsername(), paramString)))
    {
      i = 1;
      if (i == 0) {
        break label68;
      }
    }
    label68:
    for (paramString = localj;; paramString = null)
    {
      paramString = (f)paramString;
      AppMethodBeat.o(203732);
      return paramString;
      i = 0;
      break;
    }
  }
  
  public final void eIY()
  {
    AppMethodBeat.i(203723);
    String str = this.FCi.getRendererSpeaker();
    int i;
    if (!n.ba((CharSequence)str))
    {
      i = 1;
      if (i != 0)
      {
        Object localObject = this.FCi.getLastRenderSwitchTick();
        if (localObject != null)
        {
          if (Util.ticksToNow(((Number)localObject).longValue()) >= 3000L)
          {
            localObject = ad.eYc();
            kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
            if (!((com.tencent.mm.plugin.multitalk.model.q)localObject).eVE().contains(str)) {
              break label159;
            }
            this.FCi.vh(true);
            this.FCi.aQP(str);
          }
          this.FCi.aQO(str);
          i = 0;
          label108:
          localObject = ad.eYc();
          kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
          if ((!((com.tencent.mm.plugin.multitalk.model.q)localObject).eVE().contains(str)) || (i != 0)) {
            break label190;
          }
          this.FCi.vi(true);
        }
      }
    }
    for (;;)
    {
      eZn();
      AppMethodBeat.o(203723);
      return;
      i = 0;
      break;
      label159:
      a.b.a(this.Fwg, a.c.FBd);
      this.FCi.vh(false);
      this.FCi.aQP(null);
      i = 1;
      break label108;
      label190:
      this.FCi.vi(false);
    }
  }
  
  public final void eVR() {}
  
  public final void release()
  {
    AppMethodBeat.i(203733);
    Object localObject = this.FCh;
    if (localObject != null)
    {
      MTimerHandler localMTimerHandler = ((q)localObject).FrD;
      if (localMTimerHandler != null) {
        localMTimerHandler.removeCallbacksAndMessages(null);
      }
      localMTimerHandler = ((q)localObject).FrD;
      if (localMTimerHandler != null) {
        localMTimerHandler.stopTimer();
      }
      localObject = ((q)localObject).FrD;
      if (localObject != null) {
        ((MTimerHandler)localObject).quitSafely();
      }
    }
    localObject = ad.eYc();
    kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    ((com.tencent.mm.plugin.multitalk.model.q)localObject).eXp().b((g)this);
    AppMethodBeat.o(203733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.i
 * JD-Core Version:    0.7.0.1
 */