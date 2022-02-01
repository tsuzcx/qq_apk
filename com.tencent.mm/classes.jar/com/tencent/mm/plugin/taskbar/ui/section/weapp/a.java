package com.tencent.mm.plugin.taskbar.ui.section.weapp;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.a;
import com.tencent.mm.plugin.taskbar.d.a;
import com.tencent.mm.plugin.taskbar.d.d;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.ui.section.b.a;
import com.tencent.mm.ui.ar;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionMyWeAppView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "adjustedMaskView", "", "isInArea", "starMaskBgView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "starMaskContent", "Landroid/widget/LinearLayout;", "starMaskTextView", "Landroid/widget/TextView;", "starMaskView", "Landroid/widget/FrameLayout;", "vibrator", "Landroid/os/Vibrator;", "adjustMaskViewIfNeeded", "", "createRecyclerView", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView;", "notifyDragStateChange", "drag", "notifyItemInserted", "pos", "newItem", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "notifyViewDragTo", "x", "", "y", "onClickMore", "onWeAppMarginUpdate", "margin", "titleName", "", "Companion", "plugin-taskbar_release"})
@SuppressLint({"ViewConstructor"})
public final class a
  extends d
{
  public static final a.a MrB;
  public boolean MrA;
  public final FrameLayout Mrv;
  private final RelativeLayout Mrw;
  private final TextView Mrx;
  public final LinearLayout Mry;
  private boolean Mrz;
  private HashMap _$_findViewCache;
  private final Vibrator rqC;
  
  static
  {
    AppMethodBeat.i(215457);
    MrB = new a.a((byte)0);
    AppMethodBeat.o(215457);
  }
  
  private a(Context paramContext, b.a parama, int paramInt)
  {
    super(paramContext, parama, paramInt, null, 0);
    AppMethodBeat.i(215454);
    this.Mrv = ((FrameLayout)getRoot().findViewById(d.d.Mmx));
    this.Mrw = ((RelativeLayout)getRoot().findViewById(d.d.Mmy));
    this.Mrx = ((TextView)getRoot().findViewById(d.d.MmA));
    this.Mry = ((LinearLayout)getRoot().findViewById(d.d.Mmz));
    this.rqC = ((Vibrator)paramContext.getSystemService("vibrator"));
    paramContext = this.Mrw;
    if (ar.isDarkMode()) {}
    for (paramInt = d.a.Mmi;; paramInt = d.a.Mmh)
    {
      paramContext.setBackgroundResource(paramInt);
      AppMethodBeat.o(215454);
      return;
    }
  }
  
  public a(Context paramContext, b.a parama, int paramInt, char paramChar)
  {
    this(paramContext, parama, paramInt, (byte)0);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(215460);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(215460);
    return localView1;
  }
  
  public final void a(AppBrandDesktopView.a parama)
  {
    AppMethodBeat.i(215446);
    p.k(parama, "newItem");
    TaskBarSectionWeAppRecyclerView localTaskBarSectionWeAppRecyclerView = getRecyclerView();
    if (localTaskBarSectionWeAppRecyclerView == null)
    {
      parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionMyWeAppRecyclerView");
      AppMethodBeat.o(215446);
      throw parama;
    }
    ((TaskBarSectionMyWeAppRecyclerView)localTaskBarSectionWeAppRecyclerView).a(parama);
    gkp();
    AppMethodBeat.o(215446);
  }
  
  @SuppressLint({"MissingPermission"})
  public final boolean as(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(215449);
    Object localObject = new Rect();
    this.Mrv.getGlobalVisibleRect((Rect)localObject);
    boolean bool = ((Rect)localObject).contains((int)paramFloat1, (int)paramFloat2);
    if ((!this.Mrz) && (bool))
    {
      localObject = this.rqC;
      if (localObject != null) {
        ((Vibrator)localObject).vibrate(10L);
      }
    }
    this.Mrz = bool;
    localObject = this.Mrx;
    int i;
    if (bool)
    {
      i = d.g.MmL;
      ((TextView)localObject).setText(i);
      localObject = this.Mrw;
      if (!bool) {
        break label142;
      }
      if (!ar.isDarkMode()) {
        break label135;
      }
      i = d.a.Mmg;
    }
    for (;;)
    {
      ((RelativeLayout)localObject).setBackgroundResource(i);
      AppMethodBeat.o(215449);
      return bool;
      i = d.g.MmK;
      break;
      label135:
      i = d.a.Mmf;
      continue;
      label142:
      if (ar.isDarkMode()) {
        i = d.a.Mmi;
      } else {
        i = d.a.Mmh;
      }
    }
  }
  
  public final void cm(float paramFloat)
  {
    AppMethodBeat.i(215451);
    Object localObject = this.Mrv;
    p.j(localObject, "starMaskView");
    localObject = ((FrameLayout)localObject).getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(215451);
      throw ((Throwable)localObject);
    }
    ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)paramFloat);
    localObject = this.Mrv;
    p.j(localObject, "starMaskView");
    localObject = ((FrameLayout)localObject).getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(215451);
      throw ((Throwable)localObject);
    }
    ((FrameLayout.LayoutParams)localObject).rightMargin = ((int)paramFloat);
    AppMethodBeat.o(215451);
  }
  
  public final String gkg()
  {
    AppMethodBeat.i(215440);
    String str = getContext().getString(d.g.MmO);
    p.j(str, "context.getString(R.stri…p_brand_taskbar_my_weapp)");
    AppMethodBeat.o(215440);
    return str;
  }
  
  public final TaskBarSectionWeAppRecyclerView gkl()
  {
    AppMethodBeat.i(215438);
    TaskBarSectionWeAppRecyclerView localTaskBarSectionWeAppRecyclerView = (TaskBarSectionWeAppRecyclerView)new TaskBarSectionMyWeAppRecyclerView(getContext());
    AppMethodBeat.o(215438);
    return localTaskBarSectionWeAppRecyclerView;
  }
  
  public final void gkm()
  {
    AppMethodBeat.i(215442);
    TaskBarSectionWeAppRecyclerView.b localb = getWeAppCallback();
    if (localb != null)
    {
      localb.gjK();
      AppMethodBeat.o(215442);
      return;
    }
    AppMethodBeat.o(215442);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionMyWeAppView$notifyDragStateChange$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-taskbar_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(214243);
      paramAnimator = a.a(this.MrC);
      p.j(paramAnimator, "starMaskView");
      paramAnimator.setVisibility(4);
      AppMethodBeat.o(214243);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.weapp.a
 * JD-Core Version:    0.7.0.1
 */