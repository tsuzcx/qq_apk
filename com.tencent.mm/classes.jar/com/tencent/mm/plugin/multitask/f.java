package com.tencent.mm.plugin.multitask;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/MultiTaskFBViewConstants;", "", "()V", "DECODE_BITMAP_SCALE", "", "DURATION_ENTER_TRANSFORMATION", "", "DURATION_EXIT_TRANSFORMATION", "DURATION_FOR_PAGE_TRANSFORMATION", "FLOAT_BALL_DEFAULT_POSITION_X", "FLOAT_BALL_DEFAULT_POSITION_Y", "FLOAT_BALL_MARGIN_LEFT", "FLOAT_BALL_MARGIN_TOP", "FLOAT_BALL_MAX_X", "getFLOAT_BALL_MAX_X", "()I", "FLOAT_BALL_MAX_Y", "FLOAT_BALL_MIN_X", "FLOAT_BALL_MIN_Y", "FLOAT_BALL_OUTER_MARGIN", "getFLOAT_BALL_OUTER_MARGIN", "FLOAT_BALL_SHADOW_BOTTOM", "FLOAT_BALL_SHADOW_HORIZONTAL", "FLOAT_BALL_SHADOW_TOP", "FLOAT_BALL_VIEW_SIZE", "FLOAT_CORNER_SCALE_SIZE", "FLOAT_CORNER_SIZE", "FLOAT_CORNER_ZOOM_OUT_FACTOR", "INVALID_ICON_RES_ID", "NAVIGATION_BAR_HEIGHT", "SHOW_INDICATOR_VIEW_ANIMATION_DURATION", "STATUS_BAR_HEIGHT", "getSTATUS_BAR_HEIGHT", "TAG", "", "getNavigationBarHeight", "context", "Landroid/content/Context;", "updateNavigationBarHeight", "", "BallPosition", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f LAW;
  public static final int LAY;
  public static final int LAZ;
  private static final int vmb;
  private static final int vmc;
  public static final int vmd;
  public static final int vme;
  public static final int vmf;
  public static final int vmg;
  public static final int vmh;
  public static final int vmi;
  public static final float vmj;
  private static final int vmk;
  public static final int vml;
  public static final int vmm;
  public static int vmn;
  public static final int vmp;
  
  static
  {
    AppMethodBeat.i(303752);
    LAW = new f();
    vmb = bf.getStatusBarHeight(MMApplicationContext.getContext());
    vmc = MMApplicationContext.getContext().getResources().getDimensionPixelSize(j.c.float_ball_outer_margin);
    vmd = MMApplicationContext.getContext().getResources().getDimensionPixelSize(j.c.float_ball_size);
    vme = a.bs(MMApplicationContext.getContext(), j.c.float_ball_shadow_top);
    LAY = a.bs(MMApplicationContext.getContext(), j.c.float_ball_margin_left);
    LAZ = a.bs(MMApplicationContext.getContext(), j.c.float_ball_margin_top);
    vmf = a.bs(MMApplicationContext.getContext(), j.c.float_ball_shadow_bottom);
    vmg = a.bs(MMApplicationContext.getContext(), j.c.float_ball_shadow_horizontal);
    vmh = MMApplicationContext.getContext().getResources().getDimensionPixelSize(j.c.float_corner_view_size);
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(j.c.float_corner_view_scale_size);
    vmi = i;
    vmj = i / vmh;
    vmk = a.ms(MMApplicationContext.getContext()) - (vmd + vmg);
    vml = vmc + vmb;
    vmm = a.mt(MMApplicationContext.getContext()) - vmc - (vmd + vme + vmf);
    Context localContext = MMApplicationContext.getContext();
    s.s(localContext, "getContext()");
    vmn = bk(localContext);
    vmp = vmb;
    AppMethodBeat.o(303752);
  }
  
  private static int bk(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(303727);
    try
    {
      int j = bf.bk(paramContext);
      i = j;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.FloatBallViewConstants", "getNavigationBarHeight exception:%s", new Object[] { paramContext });
      }
    }
    AppMethodBeat.o(303727);
    return i;
  }
  
  public static final void fE(Context paramContext)
  {
    AppMethodBeat.i(303737);
    s.u(paramContext, "context");
    vmn = bk(paramContext);
    AppMethodBeat.o(303737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.f
 * JD-Core Version:    0.7.0.1
 */