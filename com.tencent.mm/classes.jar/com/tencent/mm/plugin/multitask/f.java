package com.tencent.mm.plugin.multitask;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/MultiTaskFBViewConstants;", "", "()V", "DECODE_BITMAP_SCALE", "", "DURATION_ENTER_TRANSFORMATION", "", "DURATION_EXIT_TRANSFORMATION", "DURATION_FOR_PAGE_TRANSFORMATION", "FLOAT_BALL_DEFAULT_POSITION_X", "FLOAT_BALL_DEFAULT_POSITION_Y", "FLOAT_BALL_MARGIN_LEFT", "FLOAT_BALL_MARGIN_TOP", "FLOAT_BALL_MAX_X", "getFLOAT_BALL_MAX_X", "()I", "FLOAT_BALL_MAX_Y", "FLOAT_BALL_MIN_X", "FLOAT_BALL_MIN_Y", "FLOAT_BALL_OUTER_MARGIN", "getFLOAT_BALL_OUTER_MARGIN", "FLOAT_BALL_SHADOW_BOTTOM", "FLOAT_BALL_SHADOW_HORIZONTAL", "FLOAT_BALL_SHADOW_TOP", "FLOAT_BALL_VIEW_SIZE", "FLOAT_CORNER_SCALE_SIZE", "FLOAT_CORNER_SIZE", "FLOAT_CORNER_ZOOM_OUT_FACTOR", "INVALID_ICON_RES_ID", "NAVIGATION_BAR_HEIGHT", "SHOW_INDICATOR_VIEW_ANIMATION_DURATION", "STATUS_BAR_HEIGHT", "getSTATUS_BAR_HEIGHT", "TAG", "", "getNavigationBarHeight", "context", "Landroid/content/Context;", "updateNavigationBarHeight", "", "BallPosition", "plugin-multitask_release"})
public final class f
{
  public static final int Iaf;
  public static final int Iag;
  private static final int oYI;
  private static final int oYJ;
  public static final int oYK;
  public static final int oYL;
  public static final int oYM;
  public static final int oYN;
  public static final int oYO;
  public static final int oYP;
  public static final float oYQ;
  private static final int oYR;
  public static final int oYS;
  public static final int oYT;
  public static int oYU;
  public static final int oYW;
  public static final f zZi;
  
  static
  {
    AppMethodBeat.i(200289);
    zZi = new f();
    oYI = au.getStatusBarHeight(MMApplicationContext.getContext());
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    oYJ = localContext.getResources().getDimensionPixelSize(2131166414);
    localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    oYK = localContext.getResources().getDimensionPixelSize(2131166419);
    oYL = a.aH(MMApplicationContext.getContext(), 2131166418);
    Iaf = a.aH(MMApplicationContext.getContext(), 2131167187);
    Iag = a.aH(MMApplicationContext.getContext(), 2131167188);
    oYM = a.aH(MMApplicationContext.getContext(), 2131166415);
    oYN = a.aH(MMApplicationContext.getContext(), 2131166416);
    localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    oYO = localContext.getResources().getDimensionPixelSize(2131166453);
    localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    int i = localContext.getResources().getDimensionPixelSize(2131166452);
    oYP = i;
    oYQ = i / oYO;
    oYR = a.jn(MMApplicationContext.getContext()) - (oYK + oYN);
    oYS = oYJ + oYI;
    oYT = a.jo(MMApplicationContext.getContext()) - oYJ - (oYK + oYL + oYM);
    localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    oYU = aD(localContext);
    oYW = oYI;
    AppMethodBeat.o(200289);
  }
  
  private static int aD(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(200287);
    try
    {
      int j = au.aD(paramContext);
      i = j;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.FloatBallViewConstants", "getNavigationBarHeight exception:%s", new Object[] { paramContext });
      }
    }
    AppMethodBeat.o(200287);
    return i;
  }
  
  public static final void eG(Context paramContext)
  {
    AppMethodBeat.i(200288);
    p.h(paramContext, "context");
    oYU = aD(paramContext);
    AppMethodBeat.o(200288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.f
 * JD-Core Version:    0.7.0.1
 */