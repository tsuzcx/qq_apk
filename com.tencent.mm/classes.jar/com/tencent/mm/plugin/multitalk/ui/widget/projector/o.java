package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;", "", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "mCurrentSpeakerList", "Ljava/util/HashMap;", "", "", "getMCurrentSpeakerList", "()Ljava/util/HashMap;", "setMCurrentSpeakerList", "(Ljava/util/HashMap;)V", "remoteSpeakerSpeakerMuteChecker", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "checkHistorySpeakerList", "", "checkRemoteSpeakerIsSpeaking", "", "startProjectorSpeakerChecker", "stopProjectorSpeakerChecker", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  MTimerHandler LnQ;
  private volatile HashMap<String, Integer> LnR;
  private a Lsq;
  
  public o(a parama)
  {
    AppMethodBeat.i(285639);
    this.Lsq = parama;
    this.LnR = new HashMap();
    AppMethodBeat.o(285639);
  }
  
  private static final boolean a(o paramo)
  {
    AppMethodBeat.i(285657);
    s.u(paramo, "this$0");
    paramo.gix();
    AppMethodBeat.o(285657);
    return true;
  }
  
  private final void gix()
  {
    int i = 0;
    try
    {
      AppMethodBeat.i(285650);
      ArrayList localArrayList = new ArrayList();
      localObject3 = ((Map)this.LnR).entrySet().iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList.add((String)((Map.Entry)((Iterator)localObject3).next()).getKey());
      }
      localObject2 = (List)localObject1;
    }
    finally {}
    Object localObject2;
    HashMap localHashMap = new HashMap();
    Object localObject3 = new ArrayList();
    List localList = ac.ggS().gew();
    String str;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!((List)localObject2).contains(str))
        {
          Map localMap = (Map)localHashMap;
          s.s(str, "tempSpeaker");
          localMap.put(str, Integer.valueOf(0));
        }
      }
      s.checkNotNull(localObject2);
      localIterator = ((List)localObject2).iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (localList.contains(str))
        {
          localObject2 = (Integer)this.LnR.get(str);
          if (localObject2 != null) {
            break label396;
          }
          localObject2 = Integer.valueOf(0);
        }
      }
    }
    label396:
    for (;;)
    {
      if (((Integer)localObject2).intValue() > 30)
      {
        ((ArrayList)localObject3).add(str);
        i = 1;
        break;
      }
      ((Map)localHashMap).put(str, Integer.valueOf(((Integer)localObject2).intValue() + 1));
      break;
      if ((Integer)this.LnR.get(str) == null) {
        break;
      }
      ((Map)localHashMap).put(str, Integer.valueOf(0));
      break;
      s.u(localHashMap, "<set-?>");
      this.LnR = localHashMap;
      if ((i != 0) && (!this.Lsq.ghW()))
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putStringArrayList("avatar_available_speaker", (ArrayList)localObject3);
        this.Lsq.a(a.c.Lxe, (Bundle)localObject2);
      }
      AppMethodBeat.o(285650);
      return;
    }
  }
  
  public final void giw()
  {
    AppMethodBeat.i(285671);
    MTimerHandler localMTimerHandler = this.LnQ;
    if (localMTimerHandler != null) {
      localMTimerHandler.stopTimer();
    }
    localMTimerHandler = this.LnQ;
    if (localMTimerHandler != null) {
      localMTimerHandler.quitSafely();
    }
    localMTimerHandler = this.LnQ;
    if (localMTimerHandler != null) {
      localMTimerHandler.removeCallbacksAndMessages(null);
    }
    this.LnQ = new MTimerHandler(new o..ExternalSyntheticLambda0(this), true);
    localMTimerHandler = this.LnQ;
    if (localMTimerHandler != null) {
      localMTimerHandler.startTimer(20L);
    }
    AppMethodBeat.o(285671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.o
 * JD-Core Version:    0.7.0.1
 */