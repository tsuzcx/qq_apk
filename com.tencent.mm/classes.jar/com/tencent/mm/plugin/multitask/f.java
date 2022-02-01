package com.tencent.mm.plugin.multitask;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/MultiTaskFBViewConstants;", "", "()V", "DECODE_BITMAP_SCALE", "", "DURATION_ENTER_TRANSFORMATION", "", "DURATION_EXIT_TRANSFORMATION", "DURATION_FOR_PAGE_TRANSFORMATION", "FLOAT_BALL_DEFAULT_POSITION_X", "FLOAT_BALL_DEFAULT_POSITION_Y", "FLOAT_BALL_MARGIN_LEFT", "FLOAT_BALL_MARGIN_TOP", "FLOAT_BALL_MAX_X", "getFLOAT_BALL_MAX_X", "()I", "FLOAT_BALL_MAX_Y", "FLOAT_BALL_MIN_X", "FLOAT_BALL_MIN_Y", "FLOAT_BALL_OUTER_MARGIN", "getFLOAT_BALL_OUTER_MARGIN", "FLOAT_BALL_SHADOW_BOTTOM", "FLOAT_BALL_SHADOW_HORIZONTAL", "FLOAT_BALL_SHADOW_TOP", "FLOAT_BALL_VIEW_SIZE", "FLOAT_CORNER_SCALE_SIZE", "FLOAT_CORNER_SIZE", "FLOAT_CORNER_ZOOM_OUT_FACTOR", "INVALID_ICON_RES_ID", "NAVIGATION_BAR_HEIGHT", "SHOW_INDICATOR_VIEW_ANIMATION_DURATION", "STATUS_BAR_HEIGHT", "getSTATUS_BAR_HEIGHT", "TAG", "", "getNavigationBarHeight", "context", "Landroid/content/Context;", "updateNavigationBarHeight", "", "BallPosition", "plugin-multitask_release"})
public final class f
{
  public static final int FEU;
  public static final int FEV;
  public static final f FEW;
  private static final int saJ;
  private static final int saK;
  public static final int saL;
  public static final int saM;
  public static final int saN;
  public static final int saO;
  public static final int saP;
  public static final int saQ;
  public static final float saR;
  private static final int saS;
  public static final int saT;
  public static final int saU;
  public static int saV;
  public static final int saX;
  
  static
  {
    AppMethodBeat.i(249007);
    FEW = new f();
    saJ = ax.getStatusBarHeight(MMApplicationContext.getContext());
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    saK = localContext.getResources().getDimensionPixelSize(j.c.float_ball_outer_margin);
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    saL = localContext.getResources().getDimensionPixelSize(j.c.float_ball_size);
    saM = a.aZ(MMApplicationContext.getContext(), j.c.float_ball_shadow_top);
    FEU = a.aZ(MMApplicationContext.getContext(), j.c.float_ball_margin_left);
    FEV = a.aZ(MMApplicationContext.getContext(), j.c.float_ball_margin_top);
    saN = a.aZ(MMApplicationContext.getContext(), j.c.float_ball_shadow_bottom);
    saO = a.aZ(MMApplicationContext.getContext(), j.c.float_ball_shadow_horizontal);
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    saP = localContext.getResources().getDimensionPixelSize(j.c.float_corner_view_size);
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    int i = localContext.getResources().getDimensionPixelSize(j.c.float_corner_view_scale_size);
    saQ = i;
    saR = i / saP;
    saS = a.kr(MMApplicationContext.getContext()) - (saL + saO);
    saT = saK + saJ;
    saU = a.ks(MMApplicationContext.getContext()) - saK - (saL + saM + saN);
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    saV = aB(localContext);
    saX = saJ;
    AppMethodBeat.o(249007);
  }
  
  private static int aB(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(249005);
    try
    {
      int j = ax.aB(paramContext);
      i = j;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.FloatBallViewConstants", "getNavigationBarHeight exception:%s", new Object[] { paramContext });
      }
    }
    AppMethodBeat.o(249005);
    return i;
  }
  
  public static final void eJ(Context paramContext)
  {
    AppMethodBeat.i(249006);
    p.k(paramContext, "context");
    saV = aB(paramContext);
    AppMethodBeat.o(249006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.f
 * JD-Core Version:    0.7.0.1
 */