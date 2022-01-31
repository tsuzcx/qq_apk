package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.af;

public final class b
{
  public static final int oVm;
  public static final int oVn;
  public static final int oVo;
  public static final int oVp;
  public static final int oVq;
  public static final int oVr;
  public static final int oVs;
  public static final int oVt;
  public static final int oVu;
  public static final int oVv;
  public static final int oVw;
  private static int oVx;
  
  static
  {
    AppMethodBeat.i(54187);
    oVm = a.fromDPToPix(ah.getContext(), 3);
    oVn = a.fromDPToPix(ah.getContext(), 4);
    oVo = a.fromDPToPix(ah.getContext(), 8);
    oVp = a.fromDPToPix(ah.getContext(), 10);
    oVq = a.fromDPToPix(ah.getContext(), 14);
    oVr = a.fromDPToPix(ah.getContext(), 30);
    oVs = a.fromDPToPix(ah.getContext(), 26);
    oVt = a.fromDPToPix(ah.getContext(), 32);
    oVu = a.fromDPToPix(ah.getContext(), 96);
    oVv = a.fromDPToPix(ah.getContext(), 76);
    oVw = a.fromDPToPix(ah.getContext(), 230);
    oVx = 0;
    AppMethodBeat.o(54187);
  }
  
  public static int eF(Context paramContext)
  {
    AppMethodBeat.i(54186);
    if (oVx <= 0)
    {
      paramContext = af.hQ(paramContext);
      oVx = paramContext.y - oVw;
      ab.i("MicroMsg.MultiTalkDimensUtil", "getMultiTalkAvatarBoardHeight, displaySize: %s, MultiTalkAvatarBoardHeight: %s", new Object[] { paramContext, Integer.valueOf(oVx) });
    }
    int i = oVx;
    AppMethodBeat.o(54186);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */