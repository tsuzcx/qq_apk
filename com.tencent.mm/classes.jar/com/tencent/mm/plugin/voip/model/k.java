package com.tencent.mm.plugin.voip.model;

import android.os.Debug.MemoryInfo;
import com.tencent.matrix.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/model/VoipBeautyPerfStat;", "", "()V", "Kv_VoipBeautyRenderPerfStat", "", "STAT_ID", "", "TAG", "", "roomId", "doPerfStat", "", "v2protocal", "Lcom/tencent/mm/plugin/voip/model/v2protocal;", "beautyCmd", "setRoomId", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k Uyp;
  private static int roomId;
  
  static
  {
    AppMethodBeat.i(184118);
    Uyp = new k();
    AppMethodBeat.o(184118);
  }
  
  public static void a(v2protocal paramv2protocal, int paramInt)
  {
    AppMethodBeat.i(184117);
    s.u(paramv2protocal, "v2protocal");
    Debug.MemoryInfo localMemoryInfo = a.cm(MMApplicationContext.getContext());
    int i;
    long l1;
    long l2;
    long l3;
    if (paramv2protocal.UFP > 0)
    {
      i = paramv2protocal.UFP;
      l1 = i;
      l2 = localMemoryInfo.nativePss;
      l3 = localMemoryInfo.dalvikPss;
      Log.i("MicroMsg.VoipBeautyPerfStat", "doPerfIdKeyStat, beautyCmd:" + paramInt + ", captureFps:" + l1 + ", nativePss:" + l2 + ", dalvikPss:" + l3 + ", roomId:" + roomId);
      if ((l1 > 0L) && (roomId > 0) && (l2 > 0L) && (l3 > 0L))
      {
        if (paramInt != 0) {
          break label351;
        }
        h.OAn.p(1336L, 0L, l1);
        h.OAn.p(1336L, 1L, 1L);
        h.OAn.p(1336L, 5L, l3);
        h.OAn.p(1336L, 6L, 1L);
        h.OAn.p(1336L, 10L, l2);
        h.OAn.p(1336L, 11L, 1L);
        switch (paramInt)
        {
        }
      }
    }
    for (;;)
    {
      h.OAn.b(19454, new Object[] { Integer.valueOf(roomId), Integer.valueOf(paramInt), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      roomId = 0;
      AppMethodBeat.o(184117);
      return;
      if (paramv2protocal.field_videoDuration == 0)
      {
        i = 0;
        break;
      }
      i = paramv2protocal.UFx / paramv2protocal.field_videoDuration;
      break;
      switch (paramInt)
      {
      case 2: 
      case 4: 
      case 6: 
      default: 
        break;
      case 1: 
        h.OAn.p(1336L, 36L, l1);
        h.OAn.p(1336L, 37L, 1L);
        h.OAn.p(1336L, 40L, l3);
        h.OAn.p(1336L, 41L, 1L);
        h.OAn.p(1336L, 44L, l2);
        h.OAn.p(1336L, 45L, 1L);
        break;
      case 3: 
        h.OAn.p(1336L, 48L, l1);
        h.OAn.p(1336L, 49L, 1L);
        h.OAn.p(1336L, 52L, l3);
        h.OAn.p(1336L, 53L, 1L);
        h.OAn.p(1336L, 56L, l2);
        h.OAn.p(1336L, 57L, 1L);
        break;
      case 5: 
        h.OAn.p(1336L, 60L, l1);
        h.OAn.p(1336L, 61L, 1L);
        h.OAn.p(1336L, 64L, l3);
        h.OAn.p(1336L, 65L, 1L);
        h.OAn.p(1336L, 68L, l2);
        h.OAn.p(1336L, 69L, 1L);
        break;
      case 7: 
        label351:
        h.OAn.p(1336L, 72L, l1);
        h.OAn.p(1336L, 73L, 1L);
        h.OAn.p(1336L, 76L, l3);
        h.OAn.p(1336L, 77L, 1L);
        h.OAn.p(1336L, 80L, l2);
        h.OAn.p(1336L, 81L, 1L);
        break;
        h.OAn.p(1336L, 30L, 1L);
        continue;
        h.OAn.p(1336L, 31L, 1L);
        continue;
        h.OAn.p(1336L, 32L, 1L);
        continue;
        h.OAn.p(1336L, 33L, 1L);
        continue;
        h.OAn.p(1336L, 34L, 1L);
      }
    }
  }
  
  public static void setRoomId(int paramInt)
  {
    AppMethodBeat.i(184116);
    Log.i("MicroMsg.VoipBeautyPerfStat", s.X("setRoomId:", Integer.valueOf(paramInt)));
    roomId = paramInt;
    AppMethodBeat.o(184116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.k
 * JD-Core Version:    0.7.0.1
 */