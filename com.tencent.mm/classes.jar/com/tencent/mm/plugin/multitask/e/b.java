package com.tencent.mm.plugin.multitask.e;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.multitask.j.d;
import com.tencent.mm.plugin.multitask.j.e;
import com.tencent.mm.plugin.multitask.j.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper;", "", "()V", "MULTITASK_FIRST_ADD_FLAG", "", "MULTITASK_FIRST_ADD_TIME", "MULTITASK_FIRST_ENTER", "MULTITASK_PANEL_ENTER_DRAG_FLAG", "MULTITASK_PANEL_EXIT_DRAG_FLAG", "MULTITASK_TIPS_CONFIG", "MULTITASK_TIPS_SHOW", "TAG", "enterDragFlag", "", "getMultiTaskFirstAddTime", "isMultiTaskFirstAdd", "", "isMultiTaskFirstEnter", "isMultiTaskPanelEnterDrag", "isMultiTaskPanelExitDrag", "setMultiTaskFirstAddFlag", "", "firstAddDone", "setMultiTaskFirstAddTime", "firstTime", "setMultiTaskFirstEnterFlag", "firstEnter", "setMultiTaskPanelEnterDragFlag", "dragFlag", "setMultiTaskPanelExitDragFlag", "showBottomSheet", "activity", "Landroid/app/Activity;", "callback", "Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$MultiTaskTipCallback;", "showTips", "MultiTaskTipCallback", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b LDn;
  private static long LDo;
  
  static
  {
    AppMethodBeat.i(303845);
    LDn = new b();
    LDo = -1L;
    AppMethodBeat.o(303845);
  }
  
  public static void a(Activity paramActivity, a parama)
  {
    AppMethodBeat.i(303756);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("multitask_tips_config");
    boolean bool = localMultiProcessMMKV.getBoolean("multitask_tips_show", false);
    Log.i("MicroMsg.MultiTaskTipsHelper", s.X("showTips, flag: ", Boolean.valueOf(bool)));
    if (!bool)
    {
      localMultiProcessMMKV.putBoolean("multitask_tips_show", true);
      d.a(0L, new b..ExternalSyntheticLambda2(paramActivity, parama));
      AppMethodBeat.o(303756);
      return;
    }
    parama.gkg();
    AppMethodBeat.o(303756);
  }
  
  private static final void a(a parama, a parama1, View paramView)
  {
    AppMethodBeat.i(303839);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(parama1);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$bottomSheet");
    parama.cyW();
    if (parama1 != null) {
      parama1.gkg();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(303839);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(303842);
    if (parama != null) {
      parama.gkg();
    }
    AppMethodBeat.o(303842);
  }
  
  private static final void b(Activity paramActivity, a parama)
  {
    AppMethodBeat.i(303831);
    Log.i("MicroMsg.MultiTaskTipsHelper", "showBottomSheet");
    paramActivity = new a((Context)paramActivity);
    int i = j.f.multitask_tips_bottom_sheet_layout;
    Object localObject = (LinearLayout)paramActivity.rootView.findViewById(j.e.bottom_sheet_custom_layout);
    LayoutInflater.from(paramActivity.rootView.getContext()).inflate(i, (ViewGroup)localObject, true);
    paramActivity.rootView.findViewById(j.e.multitask_bottom_sheet_ok).setOnClickListener(new b..ExternalSyntheticLambda0(paramActivity, parama));
    ((ImageView)paramActivity.rootView.findViewById(j.e.multitask_bottom_sheet_icon)).setImageResource(j.d.multitask_tips_icon);
    paramActivity.LDl = new b..ExternalSyntheticLambda1(parama);
    paramActivity.sRw = paramActivity.isLandscape();
    paramActivity.sRx = paramActivity.getRotation();
    if (paramActivity.sRs != null)
    {
      ((ViewGroup)paramActivity.rootView.getParent()).setVisibility(0);
      parama = (FrameLayout.LayoutParams)paramActivity.rootView.getLayoutParams();
      if ((paramActivity.sRw) && (paramActivity.mF != null))
      {
        localObject = new Rect();
        paramActivity.mF.getWindowVisibleDisplayFrame((Rect)localObject);
        parama.width = ((Rect)localObject).right;
      }
      paramActivity.rootView.setLayoutParams(parama);
      if (Build.VERSION.SDK_INT >= 21) {
        paramActivity.sRs.getWindow().addFlags(-2147483648);
      }
      if ((paramActivity.GwR) && (Build.VERSION.SDK_INT >= 23) && (paramActivity.sRs != null))
      {
        paramActivity.sRs.getWindow().getDecorView().setSystemUiVisibility(9216);
        paramActivity.sRs.getWindow().setStatusBarColor(0);
      }
      if (!paramActivity.sRz) {
        break label415;
      }
      paramActivity.sRs.getWindow().setFlags(8, 8);
      paramActivity.sRs.getWindow().addFlags(131200);
      paramActivity.sRs.getWindow().getDecorView().setSystemUiVisibility(6);
      if (paramActivity.mF != null) {
        if (paramActivity.mP != null) {
          break label470;
        }
      }
    }
    label415:
    label470:
    for (i = 1;; i = 0)
    {
      paramActivity.mP = paramActivity.mF.getViewTreeObserver();
      if (i != 0) {
        paramActivity.mP.addOnGlobalLayoutListener(paramActivity);
      }
      if (((paramActivity.mContext instanceof Activity)) && (!((Activity)paramActivity.mContext).isFinishing())) {
        paramActivity.sRs.show();
      }
      if (paramActivity.sRv != null) {
        paramActivity.sRv.dqC = false;
      }
      AppMethodBeat.o(303831);
      return;
      paramActivity.sRs.getWindow().clearFlags(8);
      paramActivity.sRs.getWindow().clearFlags(131072);
      paramActivity.sRs.getWindow().clearFlags(128);
      paramActivity.sRs.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public static boolean gkl()
  {
    AppMethodBeat.i(303761);
    boolean bool = MultiProcessMMKV.getMMKV("multitask_tips_config").getBoolean("multitask_panel_exit_drag_flag", false);
    Log.i("MicroMsg.MultiTaskTipsHelper", s.X("isMultiTaskPanelExitDrag, flag: ", Boolean.valueOf(bool)));
    AppMethodBeat.o(303761);
    return bool;
  }
  
  public static void gkm()
  {
    AppMethodBeat.i(303766);
    Log.i("MicroMsg.MultiTaskTipsHelper", s.X("setMultiTaskPaneExitDragFlag, flag: ", Boolean.TRUE));
    MultiProcessMMKV.getMMKV("multitask_tips_config").putBoolean("multitask_panel_exit_drag_flag", true);
    AppMethodBeat.o(303766);
  }
  
  public static boolean gkn()
  {
    AppMethodBeat.i(303771);
    if (LDo == -1L)
    {
      LDo = MultiProcessMMKV.getMMKV("multitask_tips_config").getLong("multitask_panel_enter_drag_flag", 0L);
      Log.i("MicroMsg.MultiTaskTipsHelper", s.X("isMultiTaskPanelEnterDrag, flag: ", Long.valueOf(LDo)));
    }
    if (LDo == 1L)
    {
      AppMethodBeat.o(303771);
      return true;
    }
    AppMethodBeat.o(303771);
    return false;
  }
  
  public static void gko()
  {
    AppMethodBeat.i(303776);
    Log.i("MicroMsg.MultiTaskTipsHelper", s.X("setMultiTaskPanelEnterDragFlag, flag: ", Boolean.TRUE));
    MultiProcessMMKV.getMMKV("multitask_tips_config").putBoolean("multitask_panel_enter_drag_flag", true);
    LDo = 1L;
    AppMethodBeat.o(303776);
  }
  
  public static boolean gkp()
  {
    AppMethodBeat.i(303781);
    boolean bool = MultiProcessMMKV.getMMKV("multitask_tips_config").getBoolean("multitask_first_add_flag", false);
    Log.i("MicroMsg.MultiTaskTipsHelper", s.X("isMultiTaskFirstAdd, flag: ", Boolean.valueOf(bool)));
    AppMethodBeat.o(303781);
    return bool;
  }
  
  public static long gkq()
  {
    AppMethodBeat.i(303802);
    long l = MultiProcessMMKV.getMMKV("multitask_tips_config").getLong("multitask_first_add_time", System.currentTimeMillis());
    Log.i("MicroMsg.MultiTaskTipsHelper", s.X("setMultiTaskFirstAddTime, time: ", Long.valueOf(l)));
    AppMethodBeat.o(303802);
    return l;
  }
  
  public static void gkr()
  {
    AppMethodBeat.i(303808);
    Log.i("MicroMsg.MultiTaskTipsHelper", s.X("setMultiTaskFirstEnter, time: ", Boolean.TRUE));
    MultiProcessMMKV.getMMKV("multitask_tips_config").putBoolean("multitask_first_enter", true);
    AppMethodBeat.o(303808);
  }
  
  public static boolean gks()
  {
    AppMethodBeat.i(303816);
    boolean bool = MultiProcessMMKV.getMMKV("multitask_tips_config").getBoolean("multitask_first_enter", false);
    Log.i("MicroMsg.MultiTaskTipsHelper", s.X("isMultiTaskFirstEnter, flag: ", Boolean.valueOf(bool)));
    AppMethodBeat.o(303816);
    return bool;
  }
  
  public static void sz(long paramLong)
  {
    AppMethodBeat.i(303794);
    Log.i("MicroMsg.MultiTaskTipsHelper", s.X("setMultiTaskFirstAddTime, time: ", Long.valueOf(paramLong)));
    MultiProcessMMKV.getMMKV("multitask_tips_config").putLong("multitask_first_add_time", paramLong);
    AppMethodBeat.o(303794);
  }
  
  public static void zF(boolean paramBoolean)
  {
    AppMethodBeat.i(303786);
    Log.i("MicroMsg.MultiTaskTipsHelper", s.X("setMultiTaskFirstAdd, flag: ", Boolean.valueOf(paramBoolean)));
    MultiProcessMMKV.getMMKV("multitask_tips_config").putBoolean("multitask_first_add_flag", paramBoolean);
    AppMethodBeat.o(303786);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$MultiTaskTipCallback;", "", "onTipCancel", "", "onTipHide", "onTipShow", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void gkg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.e.b
 * JD-Core Version:    0.7.0.1
 */