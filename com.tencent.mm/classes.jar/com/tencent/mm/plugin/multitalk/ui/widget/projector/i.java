package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.ae;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.g;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.g.b.p;
import kotlin.j.c;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarManager;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTargetContainer;", "contentView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "avatarChecker", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;", "getAvatarChecker", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;", "setAvatarChecker", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;)V", "getContentView", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "setContentView", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "waitingRenderList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "checkRenderUserTalking", "", "userName", "checkSpeakerHasVideo", "getLargeRenderTarget", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "ori", "", "getNormalRenderTarget", "wxUserName", "getRandomNum", "maxSize", "onScreenFrame", "", "onTimeSecondCallback", "randomPeakUser", "randomPeakUserWhileTalking", "list", "", "refreshAvatar", "speakers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "release", "Companion", "plugin-multitalk_release"})
public final class i
  implements g
{
  public static final i.a zWB;
  private a zQD;
  j zWA;
  private q zWz;
  
  static
  {
    AppMethodBeat.i(239995);
    zWB = new i.a((byte)0);
    AppMethodBeat.o(239995);
  }
  
  public i(j paramj, a parama)
  {
    AppMethodBeat.i(239994);
    this.zWA = paramj;
    this.zQD = parama;
    paramj = ac.eom();
    p.g(paramj, "SubCoreMultiTalk.getMultiTalkManager()");
    paramj.enz().a((g)this);
    this.zWz = new q(this.zQD);
    paramj = this.zWz;
    if (paramj != null)
    {
      parama = paramj.zMk;
      if (parama != null) {
        parama.stopTimer();
      }
      parama = paramj.zMk;
      if (parama != null) {
        parama.quitSafely();
      }
      parama = paramj.zMk;
      if (parama != null) {
        parama.removeCallbacksAndMessages(null);
      }
      paramj.zMk = new MTimerHandler((MTimerHandler.CallBack)new q.a(paramj), true);
      paramj = paramj.zMk;
      if (paramj != null)
      {
        paramj.startTimer(20L);
        AppMethodBeat.o(239994);
        return;
      }
      AppMethodBeat.o(239994);
      return;
    }
    AppMethodBeat.o(239994);
  }
  
  static String fC(List<String> paramList)
  {
    AppMethodBeat.i(239991);
    paramList = (String)paramList.get(kotlin.k.j.a(kotlin.k.j.mY(0, paramList.size()), (c)c.SYP));
    AppMethodBeat.o(239991);
    return paramList;
  }
  
  public final f Rc(int paramInt)
  {
    return null;
  }
  
  public final f aFB(String paramString)
  {
    AppMethodBeat.i(239992);
    p.h(paramString, "wxUserName");
    j localj = this.zWA;
    int i;
    if ((TextUtils.isEmpty((CharSequence)localj.getUsername())) || (p.j(localj.getUsername(), paramString)))
    {
      i = 1;
      if (i == 0) {
        break label65;
      }
    }
    label65:
    for (paramString = localj;; paramString = null)
    {
      paramString = (f)paramString;
      AppMethodBeat.o(239992);
      return paramString;
      i = 0;
      break;
    }
  }
  
  public final void eaa()
  {
    AppMethodBeat.i(239990);
    String str = this.zWA.getRendererSpeaker();
    int i;
    Object localObject;
    if (!n.aL((CharSequence)str))
    {
      i = 1;
      if (i == 0) {
        break label182;
      }
      localObject = this.zWA.getLastRenderSwitchTick();
      if (localObject == null) {
        break label182;
      }
      if (Util.ticksToNow(((Number)localObject).longValue()) >= 3000L)
      {
        localObject = ac.eom();
        p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        if (!((com.tencent.mm.plugin.multitalk.model.q)localObject).elR().contains(str)) {
          break label139;
        }
        this.zWA.sf(true);
      }
      this.zWA.aGz(str);
    }
    for (;;)
    {
      localObject = ac.eom();
      p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
      if (!((com.tencent.mm.plugin.multitalk.model.q)localObject).elR().contains(str)) {
        break label168;
      }
      this.zWA.sg(true);
      AppMethodBeat.o(239990);
      return;
      i = 0;
      break;
      label139:
      a.b.a(this.zQD, a.c.zVt);
      this.zWA.sf(false);
      this.zWA.aGA(null);
    }
    label168:
    this.zWA.sg(false);
    AppMethodBeat.o(239990);
    return;
    label182:
    AppMethodBeat.o(239990);
  }
  
  public final void emc() {}
  
  public final void release()
  {
    AppMethodBeat.i(239993);
    Object localObject = this.zWz;
    if (localObject != null)
    {
      MTimerHandler localMTimerHandler = ((q)localObject).zMk;
      if (localMTimerHandler != null) {
        localMTimerHandler.removeCallbacksAndMessages(null);
      }
      localMTimerHandler = ((q)localObject).zMk;
      if (localMTimerHandler != null) {
        localMTimerHandler.stopTimer();
      }
      localObject = ((q)localObject).zMk;
      if (localObject != null) {
        ((MTimerHandler)localObject).quitSafely();
      }
    }
    localObject = ac.eom();
    p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    ((com.tencent.mm.plugin.multitalk.model.q)localObject).enz().b((g)this);
    AppMethodBeat.o(239993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.i
 * JD-Core Version:    0.7.0.1
 */