package com.tencent.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class d$18
  implements Runnable
{
  d$18(WXTRTCCloud paramWXTRTCCloud, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(14294);
    Object localObject1 = new ArrayList();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((this.IIR == null) || (this.IIR.size() == 0))
    {
      if (WXTRTCCloud.access$100(this.IIM).size() > 0)
      {
        localObject2 = WXTRTCCloud.access$100(this.IIM).keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = new TRTCCloudDef.TRTCVolumeInfo();
          ((TRTCCloudDef.TRTCVolumeInfo)localObject4).userId = ((String)localObject3);
          ((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume = 0;
          ((ArrayList)localObject1).add(localObject4);
        }
        WXTRTCCloud.access$100(this.IIM).clear();
      }
      localObject2 = ((ArrayList)localObject1).iterator();
    }
    label131:
    label497:
    for (;;)
    {
      int i;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (TRTCCloudDef.TRTCVolumeInfo)((Iterator)localObject2).next();
        localObject3 = ((TRTCCloudDef.TRTCVolumeInfo)localObject1).userId;
        i = ((TRTCCloudDef.TRTCVolumeInfo)localObject1).volume;
        if (!WXTRTCCloud.access$000(this.IIM).keySet().contains(localObject3)) {
          continue;
        }
        localObject1 = (d.b)WXTRTCCloud.access$000(this.IIM).get(localObject3);
        if ((localObject1 == null) || (i == ((d.b)localObject1).a)) {
          continue;
        }
        ((d.b)localObject1).a = i;
        if (((d.b)localObject1).IIV != null) {
          localObject1 = (WXTRTCCloud.ITXAudioVolumeEvaluationListener)((d.b)localObject1).IIV.get();
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label497;
        }
        ((WXTRTCCloud.ITXAudioVolumeEvaluationListener)localObject1).onAudioVolumeEvaluationNotify(i);
        break label131;
        localObject3 = this.IIR;
        Collections.sort((List)localObject3, new Comparator() {});
        localObject2 = new HashMap();
        localObject3 = ((ArrayList)localObject3).iterator();
        int j;
        for (i = 0; ((Iterator)localObject3).hasNext(); i = j)
        {
          localObject4 = (TRTCCloudDef.TRTCVolumeInfo)((Iterator)localObject3).next();
          if (i >= 10) {
            break;
          }
          j = i;
          if (((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume > 10)
          {
            j = i + 1;
            ((HashMap)localObject2).put(((TRTCCloudDef.TRTCVolumeInfo)localObject4).userId, Integer.valueOf(((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume));
            ((ArrayList)localObject1).add(localObject4);
          }
        }
        localObject3 = WXTRTCCloud.access$100(this.IIM).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          if (!((HashMap)localObject2).containsKey(localObject4))
          {
            TRTCCloudDef.TRTCVolumeInfo localTRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
            localTRTCVolumeInfo.userId = ((String)localObject4);
            localTRTCVolumeInfo.volume = 0;
            ((ArrayList)localObject1).add(localTRTCVolumeInfo);
          }
        }
        WXTRTCCloud.access$100(this.IIM).clear();
        WXTRTCCloud.access$100(this.IIM).putAll((Map)localObject2);
        break;
        if (((d.b)localObject1).c != null)
        {
          localObject1 = (WXTRTCCloud.ITXAudioVolumeEvaluationListener)((d.b)localObject1).c.get();
          continue;
          AppMethodBeat.o(14294);
        }
        else
        {
          localObject1 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.18
 * JD-Core Version:    0.7.0.1
 */