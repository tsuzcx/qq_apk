package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Point;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ak;

public final class b
{
  public static final int mvA = a.fromDPToPix(ae.getContext(), 26);
  public static final int mvB = a.fromDPToPix(ae.getContext(), 32);
  public static final int mvC = a.fromDPToPix(ae.getContext(), 96);
  public static final int mvD = a.fromDPToPix(ae.getContext(), 76);
  public static final int mvE = a.fromDPToPix(ae.getContext(), 230);
  private static int mvF = 0;
  public static final int mvu = a.fromDPToPix(ae.getContext(), 3);
  public static final int mvv = a.fromDPToPix(ae.getContext(), 4);
  public static final int mvw = a.fromDPToPix(ae.getContext(), 8);
  public static final int mvx = a.fromDPToPix(ae.getContext(), 10);
  public static final int mvy = a.fromDPToPix(ae.getContext(), 14);
  public static final int mvz = a.fromDPToPix(ae.getContext(), 30);
  
  public static int dS(Context paramContext)
  {
    if (mvF <= 0)
    {
      paramContext = ak.gx(paramContext);
      mvF = paramContext.y - mvE;
      y.i("MicroMsg.MultiTalkDimensUtil", "getMultiTalkAvatarBoardHeight, displaySize: %s, MultiTalkAvatarBoardHeight: %s", new Object[] { paramContext, Integer.valueOf(mvF) });
    }
    return mvF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */