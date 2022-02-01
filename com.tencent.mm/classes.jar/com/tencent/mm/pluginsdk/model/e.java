package com.tencent.mm.pluginsdk.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  private static int QUS = 0;
  private static int QUT = 1;
  private static String TAG = "MicroMsg.C2CTransferConfig";
  
  public static boolean lS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216608);
    int i = ((b)h.ae(b.class)).a(b.a.vGc, QUS);
    String str2 = Build.MODEL.toLowerCase();
    String str3 = TAG;
    String str1;
    if (i == QUT)
    {
      str1 = "mediaCodec";
      Log.i(str3, "transferType:%s model:%s select %s mode", new Object[] { Integer.valueOf(i), str2, str1 });
      if (i != QUT) {
        break label101;
      }
    }
    label101:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label106;
      }
      AppMethodBeat.o(216608);
      return true;
      str1 = "x264";
      break;
    }
    label106:
    i = ((b)h.ae(b.class)).a(b.a.vGb, 3000);
    Log.i(TAG, "rawWidth %d rawHeight:%d limit:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    if (Math.max(paramInt2, paramInt1) >= i)
    {
      AppMethodBeat.o(216608);
      return true;
    }
    AppMethodBeat.o(216608);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.e
 * JD-Core Version:    0.7.0.1
 */