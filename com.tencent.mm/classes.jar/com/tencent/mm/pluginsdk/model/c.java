package com.tencent.mm.pluginsdk.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  private static int JUK = 0;
  private static int JUL = 1;
  private static String TAG = "MicroMsg.C2CTransferConfig";
  
  public static boolean kz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240890);
    int i = ((b)g.af(b.class)).a(b.a.rZf, JUK);
    String str2 = Build.MODEL.toLowerCase();
    String str3 = TAG;
    String str1;
    if (i == JUL)
    {
      str1 = "mediaCodec";
      Log.i(str3, "transferType:%s model:%s select %s mode", new Object[] { Integer.valueOf(i), str2, str1 });
      if (i != JUL) {
        break label101;
      }
    }
    label101:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label106;
      }
      AppMethodBeat.o(240890);
      return true;
      str1 = "x264";
      break;
    }
    label106:
    i = ((b)g.af(b.class)).a(b.a.rZe, 3000);
    Log.i(TAG, "rawWidth %d rawHeight:%d limit:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    if (Math.max(paramInt2, paramInt1) >= i)
    {
      AppMethodBeat.o(240890);
      return true;
    }
    AppMethodBeat.o(240890);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.c
 * JD-Core Version:    0.7.0.1
 */