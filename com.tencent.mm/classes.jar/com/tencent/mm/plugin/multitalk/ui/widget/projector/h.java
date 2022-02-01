package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.ae;
import com.tencent.mm.plugin.multitalk.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
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
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j.c;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "contentView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "avatarChecker", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;", "getAvatarChecker", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;", "setAvatarChecker", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;)V", "getContentView", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "setContentView", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "subscribeVideoCacheList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "waitingRenderList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "checkRenderUserTalking", "", "userName", "checkSpeakerHasVideo", "engineDoMemberSelectForView", "memberIdList", "engineEncodeList", "", "getLargeRenderTarget", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "ori", "getNormalRenderTarget", "wxUserName", "getRandomNum", "maxSize", "onScreenFrame", "onTimeSecondCallback", "randomPeakUser", "randomPeakUserWhileTalking", "list", "", "refreshAvatar", "speakers", "release", "updateVideoSubscribe", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements g
{
  public static final h.a Lye;
  private a Lsq;
  private ArrayList<Integer> LvD;
  i Lyf;
  private o Lyg;
  
  static
  {
    AppMethodBeat.i(285739);
    Lye = new h.a((byte)0);
    AppMethodBeat.o(285739);
  }
  
  public h(i parami, a parama)
  {
    AppMethodBeat.i(285680);
    this.Lyf = parami;
    this.Lsq = parama;
    ac.ggS().ggf().a((g)this);
    this.Lyg = new o(this.Lsq);
    parami = this.Lyg;
    if (parami != null) {
      parami.giw();
    }
    this.LvD = new ArrayList();
    AppMethodBeat.o(285680);
  }
  
  private final void bc(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(285691);
    if (this.LvD.isEmpty())
    {
      this.LvD.addAll((Collection)paramArrayList);
      AppMethodBeat.o(285691);
      return;
    }
    Object localObject = paramArrayList;
    if (paramArrayList.size() < 2 - this.LvD.size())
    {
      localObject = new ArrayList();
      Iterator localIterator = ((Iterable)this.LvD).iterator();
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
    this.LvD = ((ArrayList)localObject);
    AppMethodBeat.o(285691);
  }
  
  private static int bd(ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(285704);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      AppMethodBeat.o(285704);
      return -1;
    }
    int k = paramArrayList.size();
    int[] arrayOfInt = new int[k];
    StringBuilder localStringBuilder = new StringBuilder();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject = paramArrayList.get(i);
      s.s(localObject, "memberIdList[i]");
      int m = ((Number)localObject).intValue();
      localStringBuilder.append(m).append(",");
      arrayOfInt[i] = m;
      if (j >= k)
      {
        Log.i("MicroMsg.ScreenProjectAvatarManager", "steve: engineDoMemberSelectForView: selected id list: %s", new Object[] { localStringBuilder.toString() });
        paramArrayList = ByteBuffer.allocate(k * 4);
        paramArrayList.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(arrayOfInt);
        paramArrayList = paramArrayList.array();
        i = ac.ggR().LnJ.setAppCmd(23, paramArrayList, k);
        if (i < 0)
        {
          Log.e("MicroMsg.ScreenProjectAvatarManager", "steve:engineDoMemberSelectForView failed!!");
          com.tencent.mm.plugin.multitalk.model.o.gfI();
          AppMethodBeat.o(285704);
          return -1;
        }
        AppMethodBeat.o(285704);
        return i;
      }
    }
  }
  
  private final void gim()
  {
    AppMethodBeat.i(285719);
    Object localObject1 = ac.ggR();
    Object localObject2;
    Object localObject3;
    label178:
    label307:
    label320:
    int k;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.multitalk.model.n)localObject1).gfr();
      localObject1 = new ArrayList();
      localObject3 = (Collection)localObject2;
      if ((localObject3 == null) || (((Collection)localObject3).isEmpty()))
      {
        i = 1;
        if ((i == 0) && (((ArrayList)localObject2).size() - 1 > 0))
        {
          localObject2 = ((ArrayList)localObject2).subList(1, ((ArrayList)localObject2).size());
          s.s(localObject2, "speakers.subList(startIndex,speakers.size)");
          localObject2 = ((Iterable)localObject2).iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label178;
          }
          localObject3 = (String)((Iterator)localObject2).next();
          if ((ac.ggS().Loz) && (ac.ggS().aNd((String)localObject3)))
          {
            ((ArrayList)localObject1).add(Integer.valueOf(com.tencent.mm.plugin.multitalk.e.f.aNL((String)localObject3)));
            continue;
            i = 0;
            break;
          }
          Log.e("MicroMsg.ScreenProjectAvatarManager", "screen big are not allow to refresh decode");
        }
      }
      if (((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i != 0) {
          break label414;
        }
        bc((ArrayList)localObject1);
        boolean bool = ac.ggS().gfV();
        if (!bool) {
          bd(this.LvD);
        }
        if (!bool) {
          break label320;
        }
        if (this.LvD.size() != 1) {
          break label307;
        }
        com.tencent.mm.plugin.multitalk.c.o.Ljn.z((Integer)kotlin.a.p.oK((List)this.LvD));
      }
      for (;;)
      {
        Log.i("MicroMsg.ScreenProjectAvatarManager", "ilink subscribeByUserMids ok, mids:" + localObject1 + " and subscribe one is " + this.LvD);
        AppMethodBeat.o(285719);
        return;
        i = 0;
        break;
        com.tencent.mm.plugin.multitalk.c.o.Ljn.ba(this.LvD);
      }
      k = this.LvD.size();
      localObject1 = (List)new ArrayList();
      if (k <= 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localObject2 = new a.aq();
      localObject3 = this.LvD.get(i);
      s.s(localObject3, "subscribeVideoCacheList[i]");
      ((a.aq)localObject2).wTC = ((Number)localObject3).intValue();
      ((List)localObject1).add(localObject2);
      if (j >= k)
      {
        ac.ggS().ja((List)localObject1);
        label414:
        AppMethodBeat.o(285719);
        return;
      }
    }
  }
  
  static String jc(List<String> paramList)
  {
    AppMethodBeat.i(285731);
    paramList = (String)paramList.get(k.a(k.qt(0, paramList.size()), (c)c.aixl));
    AppMethodBeat.o(285731);
    return paramList;
  }
  
  public final com.tencent.mm.plugin.multitalk.model.f aMH(String paramString)
  {
    AppMethodBeat.i(285770);
    s.u(paramString, "wxUserName");
    i locali = this.Lyf;
    int i;
    if ((TextUtils.isEmpty((CharSequence)locali.getUsername())) || (s.p(locali.getUsername(), paramString)))
    {
      i = 1;
      if (i == 0) {
        break label68;
      }
    }
    label68:
    for (paramString = locali;; paramString = null)
    {
      paramString = (com.tencent.mm.plugin.multitalk.model.f)paramString;
      AppMethodBeat.o(285770);
      return paramString;
      i = 0;
      break;
    }
  }
  
  public final com.tencent.mm.plugin.multitalk.model.f abB(int paramInt)
  {
    return null;
  }
  
  public final void fQZ()
  {
    AppMethodBeat.i(285752);
    String str = this.Lyf.getRendererSpeaker();
    int i;
    if (!kotlin.n.n.bp((CharSequence)str))
    {
      i = 1;
      if (i != 0)
      {
        Long localLong = this.Lyf.getLastRenderSwitchTick();
        if (localLong != null)
        {
          if (Util.ticksToNow(((Number)localLong).longValue()) >= 3000L)
          {
            if (!ac.ggS().gew().contains(str)) {
              break label143;
            }
            this.Lyf.zv(true);
            this.Lyf.aNH(str);
          }
          this.Lyf.aNG(str);
          i = 0;
          label100:
          if ((!ac.ggS().gew().contains(str)) || (i != 0)) {
            break label174;
          }
          this.Lyf.zw(true);
        }
      }
    }
    for (;;)
    {
      gim();
      AppMethodBeat.o(285752);
      return;
      i = 0;
      break;
      label143:
      a.b.a(this.Lsq, a.c.Lxf);
      this.Lyf.zv(false);
      this.Lyf.aNH(null);
      i = 1;
      break label100;
      label174:
      this.Lyf.zw(false);
    }
  }
  
  public final void geI() {}
  
  public final void release()
  {
    AppMethodBeat.i(285785);
    Object localObject = this.Lyg;
    if (localObject != null)
    {
      MTimerHandler localMTimerHandler = ((o)localObject).LnQ;
      if (localMTimerHandler != null) {
        localMTimerHandler.removeCallbacksAndMessages(null);
      }
      localMTimerHandler = ((o)localObject).LnQ;
      if (localMTimerHandler != null) {
        localMTimerHandler.stopTimer();
      }
      localObject = ((o)localObject).LnQ;
      if (localObject != null) {
        ((MTimerHandler)localObject).quitSafely();
      }
    }
    ac.ggS().ggf().b((g)this);
    AppMethodBeat.o(285785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.h
 * JD-Core Version:    0.7.0.1
 */