package com.tencent.mm.plugin.voip.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.d.c;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/util/VoIPEncoderInfo;", "", "()V", "ENCODER_DEFAULT", "", "ENCODER_HW", "ENCODER_SOFT", "TAG", "", "encodeH", "encodeW", "encoderReady", "", "encoderType", "useGpuCrop", "getUseGpuCrop", "()Z", "setUseGpuCrop", "(Z)V", "checkStartEncoding", "clear", "", "parseEncodeSize", "setEncoderReady", "isReady", "setType", "isSoft", "setWH", "w", "h", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static boolean UIy;
  public static final e ULA;
  public static int ULB;
  public static int ULC;
  public static int ULD;
  public static boolean ULE;
  
  static
  {
    AppMethodBeat.i(292677);
    ULA = new e();
    h localh = h.ULL;
    UIy = h.ibC();
    AppMethodBeat.o(292677);
  }
  
  public static void GM(boolean paramBoolean)
  {
    ULE = paramBoolean;
  }
  
  public static void GN(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ULD = 1;
      return;
    }
    ULD = 2;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(292669);
    ULD = 0;
    ULB = 0;
    ULC = 0;
    h localh = h.ULL;
    UIy = h.ibC();
    AppMethodBeat.o(292669);
  }
  
  public static void fu(int paramInt1, int paramInt2)
  {
    String str = null;
    AppMethodBeat.i(292632);
    if ((paramInt1 != ULB) || (paramInt2 != ULC)) {
      Log.i("MicroMsg.VoIPEncoderInfo", "set encode size:[" + paramInt1 + ',' + paramInt2 + ']');
    }
    ULB = paramInt1;
    ULC = paramInt2;
    Object localObject = c.UGb;
    ConcurrentLinkedQueue localConcurrentLinkedQueue = c.hZH();
    int i;
    if (p.h((Iterable)localConcurrentLinkedQueue) != null)
    {
      localObject = (r)p.h((Iterable)localConcurrentLinkedQueue);
      if (localObject == null)
      {
        localObject = null;
        if (s.p(localObject, paramInt1 + ':' + paramInt2)) {
          break label233;
        }
      }
    }
    else
    {
      i = 1;
      label140:
      localObject = str;
      if (i != 0) {
        localObject = localConcurrentLinkedQueue;
      }
      if (localObject != null)
      {
        str = paramInt1 + ':' + paramInt2;
        if (SubCoreVoip.hVp().Uxh != 0L) {
          break label238;
        }
      }
    }
    label233:
    label238:
    for (long l = 0L;; l = Util.secondsToNow(SubCoreVoip.hVp().Uxh))
    {
      ((ConcurrentLinkedQueue)localObject).add(new r(str, Long.valueOf(l)));
      AppMethodBeat.o(292632);
      return;
      localObject = (String)((r)localObject).bsC;
      break;
      i = 0;
      break label140;
    }
  }
  
  public static String ibc()
  {
    AppMethodBeat.i(292640);
    String str = ULB + ':' + ULC;
    AppMethodBeat.o(292640);
    return str;
  }
  
  public static boolean ibd()
  {
    return (ULC != 0) && (ULB != 0) && (ULE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.f.e
 * JD-Core Version:    0.7.0.1
 */