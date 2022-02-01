package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectorTalkingUtil;", "", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "mCurrentSpeakerList", "Ljava/util/HashMap;", "", "", "getMCurrentSpeakerList", "()Ljava/util/HashMap;", "setMCurrentSpeakerList", "(Ljava/util/HashMap;)V", "remoteSpeakerSpeakerMuteChecker", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "checkHistorySpeakerList", "", "checkRemoteSpeakerIsSpeaking", "", "startProjectorSpeakerChecker", "stopProjectorSpeakerChecker", "plugin-multitalk_release"})
public final class q
{
  MTimerHandler zMk;
  private volatile HashMap<String, Integer> zMl;
  private a zQD;
  
  public q(a parama)
  {
    AppMethodBeat.i(240059);
    this.zQD = parama;
    this.zMl = new HashMap();
    AppMethodBeat.o(240059);
  }
  
  final void epJ()
  {
    try
    {
      AppMethodBeat.i(240058);
      ArrayList localArrayList = new ArrayList();
      localObject3 = ((Map)this.zMl).entrySet().iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList.add((String)((Map.Entry)((Iterator)localObject3).next()).getKey());
      }
      localObject2 = (List)localObject1;
    }
    finally {}
    Object localObject2;
    HashMap localHashMap = new HashMap();
    Object localObject3 = new ArrayList();
    Object localObject4 = ac.eom();
    p.g(localObject4, "SubCoreMultiTalk.getMultiTalkManager()");
    localObject4 = ((com.tencent.mm.plugin.multitalk.model.q)localObject4).elR();
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
          p.g(str, "tempSpeaker");
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
          localObject2 = (Integer)this.zMl.get(str);
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
      if ((Integer)this.zMl.get(str) == null) {
        break;
      }
      ((Map)localHashMap).put(str, Integer.valueOf(0));
      break;
      this.zMl = localHashMap;
      if ((i != 0) && (!this.zQD.eph()))
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putStringArrayList("avatar_available_speaker", (ArrayList)localObject3);
        this.zQD.a(a.c.zVs, (Bundle)localObject2);
      }
      AppMethodBeat.o(240058);
      for (;;)
      {
        return;
        AppMethodBeat.o(240058);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements MTimerHandler.CallBack
  {
    a(q paramq) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(240057);
      this.zYb.epJ();
      AppMethodBeat.o(240057);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.q
 * JD-Core Version:    0.7.0.1
 */