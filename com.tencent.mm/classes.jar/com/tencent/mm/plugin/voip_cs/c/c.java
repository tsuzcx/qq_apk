package com.tencent.mm.plugin.voip_cs.c;

import android.content.Context;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
{
  public static final int mvB = a.fromDPToPix(ae.getContext(), 32);
  public static final int mvC = a.fromDPToPix(ae.getContext(), 96);
  public static final int mvD = a.fromDPToPix(ae.getContext(), 76);
  public static final int mvE = a.fromDPToPix(ae.getContext(), 230);
  public static final int mvu = a.fromDPToPix(ae.getContext(), 3);
  public static final int mvv = a.fromDPToPix(ae.getContext(), 4);
  public static final int mvw = a.fromDPToPix(ae.getContext(), 8);
  public static final int mvx = a.fromDPToPix(ae.getContext(), 10);
  public static final int mvy = a.fromDPToPix(ae.getContext(), 14);
  public static final int mvz = a.fromDPToPix(ae.getContext(), 30);
  private static int qfe = 0;
  
  public static int es(Context paramContext)
  {
    if (qfe == 0) {
      qfe = a.fk(paramContext);
    }
    return qfe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c
 * JD-Core Version:    0.7.0.1
 */