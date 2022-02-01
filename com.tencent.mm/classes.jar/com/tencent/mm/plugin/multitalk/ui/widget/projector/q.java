package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;", "", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "mCurrentSpeakerList", "Ljava/util/HashMap;", "", "", "getMCurrentSpeakerList", "()Ljava/util/HashMap;", "setMCurrentSpeakerList", "(Ljava/util/HashMap;)V", "remoteSpeakerSpeakerMuteChecker", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "checkHistorySpeakerList", "", "checkRemoteSpeakerIsSpeaking", "", "startProjectorSpeakerChecker", "stopProjectorSpeakerChecker", "plugin-multitalk_release"})
public final class q
{
  MTimerHandler FrD;
  private volatile HashMap<String, Integer> FrE;
  private a Fwg;
  
  public q(a parama)
  {
    AppMethodBeat.i(196209);
    this.Fwg = parama;
    this.FrE = new HashMap();
    AppMethodBeat.o(196209);
  }
  
  final void eZx()
  {
    try
    {
      AppMethodBeat.i(196206);
      ArrayList localArrayList = new ArrayList();
      localObject3 = ((Map)this.FrE).entrySet().iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList.add((String)((Map.Entry)((Iterator)localObject3).next()).getKey());
      }
      localObject2 = (List)localObject1;
    }
    finally {}
    Object localObject2;
    HashMap localHashMap = new HashMap();
    Object localObject3 = new ArrayList();
    Object localObject4 = ad.eYc();
    p.j(localObject4, "SubCoreMultiTalk.getMultiTalkManager()");
    localObject4 = ((com.tencent.mm.plugin.multitalk.model.q)localObject4).eVE();
    String str;
    int i;
    if (localObject4 != null)
    {
      Iterator localIterator = ((List)localObject4).iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!((List)localObject2).contains(str))
        {
          Map localMap = (Map)localHashMap;
          p.j(str, "tempSpeaker");
          localMap.put(str, Integer.valueOf(0));
        }
      }
      localIterator = ((List)localObject2).iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (((List)localObject4).contains(str))
        {
          localObject2 = (Integer)this.FrE.get(str);
          if (localObject2 != null) {
            break label404;
          }
          localObject2 = Integer.valueOf(0);
        }
      }
    }
    label404:
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
      if ((Integer)this.FrE.get(str) == null) {
        break;
      }
      ((Map)localHashMap).put(str, Integer.valueOf(0));
      break;
      this.FrE = localHashMap;
      if ((i != 0) && (!this.Fwg.eYX()))
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putStringArrayList("avatar_available_speaker", (ArrayList)localObject3);
        this.Fwg.a(a.c.FBc, (Bundle)localObject2);
      }
      AppMethodBeat.o(196206);
      for (;;)
      {
        return;
        AppMethodBeat.o(196206);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.q
 * JD-Core Version:    0.7.0.1
 */