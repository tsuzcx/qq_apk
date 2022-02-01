package com.tencent.mm.plugin.multitask.e;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper;", "", "()V", "MULTITASK_FIRST_ADD_FLAG", "", "MULTITASK_FIRST_ADD_TIME", "MULTITASK_FIRST_ENTER", "MULTITASK_PANEL_ENTER_DRAG_FLAG", "MULTITASK_PANEL_EXIT_DRAG_FLAG", "MULTITASK_TIPS_CONFIG", "MULTITASK_TIPS_SHOW", "TAG", "enterDragFlag", "", "getMultiTaskFirstAddTime", "isMultiTaskFirstAdd", "", "isMultiTaskFirstEnter", "isMultiTaskPanelEnterDrag", "isMultiTaskPanelExitDrag", "setMultiTaskFirstAddFlag", "", "firstAddDone", "setMultiTaskFirstAddTime", "firstTime", "setMultiTaskFirstEnterFlag", "firstEnter", "setMultiTaskPanelEnterDragFlag", "dragFlag", "setMultiTaskPanelExitDragFlag", "showBottomSheet", "activity", "Landroid/app/Activity;", "callback", "Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$MultiTaskTipCallback;", "showTips", "MultiTaskTipCallback", "plugin-multitask_release"})
public final class b
{
  private static long FHR;
  public static final b FHS;
  
  static
  {
    AppMethodBeat.i(249136);
    FHS = new b();
    FHR = -1L;
    AppMethodBeat.o(249136);
  }
  
  public static void OC(long paramLong)
  {
    AppMethodBeat.i(249131);
    Log.i("MicroMsg.MultiTaskTipsHelper", "setMultiTaskFirstAddTime, time: ".concat(String.valueOf(paramLong)));
    MultiProcessMMKV.getMMKV("multitask_tips_config").putLong("multitask_first_add_time", paramLong);
    AppMethodBeat.o(249131);
  }
  
  public static void a(Activity paramActivity, final a parama)
  {
    AppMethodBeat.i(249124);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("multitask_tips_config");
    boolean bool = localMultiProcessMMKV.getBoolean("multitask_tips_show", false);
    Log.i("MicroMsg.MultiTaskTipsHelper", "showTips, flag: ".concat(String.valueOf(bool)));
    if (!bool)
    {
      localMultiProcessMMKV.putBoolean("multitask_tips_show", true);
      d.a(0L, (Runnable)new d(paramActivity, parama));
      AppMethodBeat.o(249124);
      return;
    }
    parama.fbb();
    AppMethodBeat.o(249124);
  }
  
  public static boolean fbg()
  {
    AppMethodBeat.i(249125);
    boolean bool = MultiProcessMMKV.getMMKV("multitask_tips_config").getBoolean("multitask_panel_exit_drag_flag", false);
    Log.i("MicroMsg.MultiTaskTipsHelper", "isMultiTaskPanelExitDrag, flag: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(249125);
    return bool;
  }
  
  public static void fbh()
  {
    AppMethodBeat.i(249126);
    Log.i("MicroMsg.MultiTaskTipsHelper", "setMultiTaskPaneExitDragFlag, flag: true");
    MultiProcessMMKV.getMMKV("multitask_tips_config").putBoolean("multitask_panel_exit_drag_flag", true);
    AppMethodBeat.o(249126);
  }
  
  public static boolean fbi()
  {
    AppMethodBeat.i(249127);
    if (FHR == -1L)
    {
      FHR = MultiProcessMMKV.getMMKV("multitask_tips_config").getLong("multitask_panel_enter_drag_flag", 0L);
      Log.i("MicroMsg.MultiTaskTipsHelper", "isMultiTaskPanelEnterDrag, flag: " + FHR);
    }
    if (FHR == 1L)
    {
      AppMethodBeat.o(249127);
      return true;
    }
    AppMethodBeat.o(249127);
    return false;
  }
  
  public static void fbj()
  {
    AppMethodBeat.i(249128);
    Log.i("MicroMsg.MultiTaskTipsHelper", "setMultiTaskPanelEnterDragFlag, flag: true");
    MultiProcessMMKV.getMMKV("multitask_tips_config").putBoolean("multitask_panel_enter_drag_flag", true);
    FHR = 1L;
    AppMethodBeat.o(249128);
  }
  
  public static boolean fbk()
  {
    AppMethodBeat.i(249129);
    boolean bool = MultiProcessMMKV.getMMKV("multitask_tips_config").getBoolean("multitask_first_add_flag", false);
    Log.i("MicroMsg.MultiTaskTipsHelper", "isMultiTaskFirstAdd, flag: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(249129);
    return bool;
  }
  
  public static long fbl()
  {
    AppMethodBeat.i(249132);
    long l = MultiProcessMMKV.getMMKV("multitask_tips_config").getLong("multitask_first_add_time", System.currentTimeMillis());
    Log.i("MicroMsg.MultiTaskTipsHelper", "setMultiTaskFirstAddTime, time: ".concat(String.valueOf(l)));
    AppMethodBeat.o(249132);
    return l;
  }
  
  public static void fbm()
  {
    AppMethodBeat.i(249134);
    Log.i("MicroMsg.MultiTaskTipsHelper", "setMultiTaskFirstEnter, time: true");
    MultiProcessMMKV.getMMKV("multitask_tips_config").putBoolean("multitask_first_enter", true);
    AppMethodBeat.o(249134);
  }
  
  public static boolean fbn()
  {
    AppMethodBeat.i(249135);
    boolean bool = MultiProcessMMKV.getMMKV("multitask_tips_config").getBoolean("multitask_first_enter", false);
    Log.i("MicroMsg.MultiTaskTipsHelper", "isMultiTaskFirstEnter, flag: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(249135);
    return bool;
  }
  
  public static void vn(boolean paramBoolean)
  {
    AppMethodBeat.i(249130);
    Log.i("MicroMsg.MultiTaskTipsHelper", "setMultiTaskFirstAdd, flag: ".concat(String.valueOf(paramBoolean)));
    MultiProcessMMKV.getMMKV("multitask_tips_config").putBoolean("multitask_first_add_flag", paramBoolean);
    AppMethodBeat.o(249130);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$MultiTaskTipCallback;", "", "onTipCancel", "", "onTipHide", "onTipShow", "plugin-multitask_release"})
  public static abstract interface a
  {
    public abstract void fbb();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$showBottomSheet$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama, b.a parama1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248238);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.FHT.bYF();
      paramView = this.FHU;
      if (paramView != null) {
        paramView.fbb();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248238);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$showBottomSheet$1$2"})
  static final class c
    implements a.a
  {
    c(a parama, b.a parama1) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(248388);
      b.a locala = this.FHU;
      if (locala != null)
      {
        locala.fbb();
        AppMethodBeat.o(248388);
        return;
      }
      AppMethodBeat.o(248388);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(Activity paramActivity, b.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(248276);
      b localb = b.FHS;
      b.b(this.otc, parama);
      AppMethodBeat.o(248276);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.e.b
 * JD-Core Version:    0.7.0.1
 */