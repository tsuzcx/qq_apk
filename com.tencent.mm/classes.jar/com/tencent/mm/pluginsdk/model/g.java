package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
{
  private static String TAG = "MicroMsg.C2CTransferConfig";
  private static int XQN = 0;
  private static int XQO = 1;
  
  public static boolean nG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(244720);
    int i = ((c)h.ax(c.class)).a(c.a.yVI, XQN);
    String str2 = q.aPo().toLowerCase();
    String str3 = TAG;
    String str1;
    if (i == XQO)
    {
      str1 = "mediaCodec";
      Log.i(str3, "transferType:%s model:%s select %s mode", new Object[] { Integer.valueOf(i), str2, str1 });
      if (i != XQO) {
        break label101;
      }
    }
    label101:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label106;
      }
      AppMethodBeat.o(244720);
      return true;
      str1 = "x264";
      break;
    }
    label106:
    i = ((c)h.ax(c.class)).a(c.a.yVG, 3000);
    Log.i(TAG, "rawWidth %d rawHeight:%d limit:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    if (Math.max(paramInt2, paramInt1) >= i)
    {
      AppMethodBeat.o(244720);
      return true;
    }
    AppMethodBeat.o(244720);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.g
 * JD-Core Version:    0.7.0.1
 */