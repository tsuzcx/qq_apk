package com.tencent.mm.plugin.voip.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/util/VoIPEncoderInfo;", "", "()V", "ENCODER_DEFAULT", "", "ENCODER_HW", "ENCODER_SOFT", "TAG", "", "encodeH", "encodeW", "encoderReady", "", "encoderType", "useGpuCrop", "getUseGpuCrop", "()Z", "setUseGpuCrop", "(Z)V", "checkStartEncoding", "clear", "", "parseEncodeSize", "setEncoderReady", "isReady", "setType", "isSoft", "setWH", "w", "h", "plugin-voip_release"})
public final class c
{
  private static boolean NUs;
  public static int NXB;
  public static int NXC;
  public static int NXD;
  public static boolean NXE;
  public static final c NXF;
  
  static
  {
    AppMethodBeat.i(244139);
    NXF = new c();
    g localg = g.NXO;
    NUs = g.gCI();
    AppMethodBeat.o(244139);
  }
  
  public static void Bj(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      NXD = 1;
      return;
    }
    NXD = 2;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(244138);
    NXD = 0;
    NXB = 0;
    NXC = 0;
    g localg = g.NXO;
    NUs = g.gCI();
    AppMethodBeat.o(244138);
  }
  
  public static void eA(int paramInt1, int paramInt2)
  {
    String str = null;
    AppMethodBeat.i(244130);
    if ((paramInt1 != NXB) || (paramInt2 != NXC)) {
      Log.i("MicroMsg.VoIPEncoderInfo", "set encode size:[" + paramInt1 + ',' + paramInt2 + ']');
    }
    NXB = paramInt1;
    NXC = paramInt2;
    Object localObject = a.NTi;
    ArrayList localArrayList = a.gBD();
    int i;
    if (j.lr((List)localArrayList) != null)
    {
      localObject = (o)j.lr((List)localArrayList);
      if (localObject != null)
      {
        localObject = (String)((o)localObject).Mx;
        if (!(p.h(localObject, paramInt1 + ':' + paramInt2) ^ true)) {
          break label235;
        }
      }
    }
    else
    {
      i = 1;
      label149:
      localObject = str;
      if (i != 0) {
        localObject = localArrayList;
      }
      if (localObject == null) {
        break label253;
      }
      str = paramInt1 + ':' + paramInt2;
      if (com.tencent.mm.plugin.voip.c.gxs().NKx != 0L) {
        break label240;
      }
    }
    label235:
    label240:
    for (long l = 0L;; l = Util.secondsToNow(com.tencent.mm.plugin.voip.c.gxs().NKx))
    {
      ((ArrayList)localObject).add(new o(str, Long.valueOf(l)));
      AppMethodBeat.o(244130);
      return;
      localObject = null;
      break;
      i = 0;
      break label149;
    }
    label253:
    AppMethodBeat.o(244130);
  }
  
  public static String gCm()
  {
    AppMethodBeat.i(244133);
    String str = NXB + ':' + NXC;
    AppMethodBeat.o(244133);
    return str;
  }
  
  public static void gCn()
  {
    NXE = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.c
 * JD-Core Version:    0.7.0.1
 */