package com.tencent.mm.plugin.taskbar.ui.section.weapp;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.a;
import com.tencent.mm.plugin.taskbar.d.a;
import com.tencent.mm.plugin.taskbar.d.d;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.ui.section.b.a;
import com.tencent.mm.ui.aw;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionMyWeAppView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "adjustedMaskView", "", "isInArea", "starMaskBgView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "starMaskContent", "Landroid/widget/LinearLayout;", "starMaskTextView", "Landroid/widget/TextView;", "starMaskView", "Landroid/widget/FrameLayout;", "vibrator", "Landroid/os/Vibrator;", "adjustMaskViewIfNeeded", "", "createRecyclerView", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView;", "lastDataListAppItem", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "notifyDragStateChange", "drag", "notifyItemInserted", "pos", "newItem", "notifyViewDragTo", "x", "", "y", "onClickMore", "onWeAppMarginUpdate", "margin", "titleName", "", "Companion", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends d
{
  public static final a.a SUs;
  public final FrameLayout SUt;
  private final RelativeLayout SUu;
  private final TextView SUv;
  public final LinearLayout SUw;
  boolean SUx;
  public boolean SUy;
  private final Vibrator uAL;
  
  static
  {
    AppMethodBeat.i(264449);
    SUs = new a.a((byte)0);
    AppMethodBeat.o(264449);
  }
  
  private a(Context paramContext, b.a parama, int paramInt)
  {
    super(paramContext, parama, paramInt, null, 0);
    AppMethodBeat.i(264418);
    this.SUt = ((FrameLayout)getRoot().findViewById(d.d.SPN));
    this.SUu = ((RelativeLayout)getRoot().findViewById(d.d.SPO));
    this.SUv = ((TextView)getRoot().findViewById(d.d.SPQ));
    this.SUw = ((LinearLayout)getRoot().findViewById(d.d.SPP));
    this.uAL = ((Vibrator)paramContext.getSystemService("vibrator"));
    paramContext = this.SUu;
    if (aw.isDarkMode()) {}
    for (paramInt = d.a.SPy;; paramInt = d.a.SPx)
    {
      paramContext.setBackgroundResource(paramInt);
      getRecyclerView().setId(d.d.SPR);
      if (Build.VERSION.SDK_INT >= 22) {
        getMoreView().setAccessibilityTraversalBefore(getRecyclerView().getId());
      }
      AppMethodBeat.o(264418);
      return;
    }
  }
  
  public a(Context paramContext, b.a parama, int paramInt, char paramChar)
  {
    this(paramContext, parama, paramInt, (byte)0);
    AppMethodBeat.i(264432);
    AppMethodBeat.o(264432);
  }
  
  public final boolean aY(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(264496);
    Object localObject = new Rect();
    this.SUt.getGlobalVisibleRect((Rect)localObject);
    boolean bool = ((Rect)localObject).contains((int)paramFloat1, (int)paramFloat2);
    if ((!this.SUx) && (bool))
    {
      announceForAccessibility((CharSequence)getContext().getString(d.g.app_brand_desktop_accessibility_long_add));
      localObject = this.uAL;
      if (localObject != null) {
        ((Vibrator)localObject).vibrate(10L);
      }
    }
    this.SUx = bool;
    localObject = this.SUv;
    int i;
    if (bool)
    {
      i = d.g.SQd;
      ((TextView)localObject).setText(i);
      localObject = this.SUu;
      if (!bool) {
        break label159;
      }
      if (!aw.isDarkMode()) {
        break label152;
      }
      i = d.a.SPw;
    }
    for (;;)
    {
      ((RelativeLayout)localObject).setBackgroundResource(i);
      AppMethodBeat.o(264496);
      return bool;
      i = d.g.SQc;
      break;
      label152:
      i = d.a.SPv;
      continue;
      label159:
      if (aw.isDarkMode()) {
        i = d.a.SPy;
      } else {
        i = d.a.SPx;
      }
    }
  }
  
  public final void b(int paramInt, AppBrandDesktopView.a parama)
  {
    AppMethodBeat.i(264486);
    s.u(parama, "newItem");
    ((TaskBarSectionMyWeAppRecyclerView)getRecyclerView()).b(paramInt, parama);
    hEn();
    if (((TaskBarSectionMyWeAppRecyclerView)getRecyclerView()).getDataList().size() > 8)
    {
      parama = getCallback();
      List localList = ((TaskBarSectionMyWeAppRecyclerView)getRecyclerView()).getDataList();
      s.s(localList, "recyclerView.dataList");
      parama.bdj(((AppBrandDesktopView.a)p.oM(localList)).uAl.appId);
    }
    AppMethodBeat.o(264486);
  }
  
  public final void dy(float paramFloat)
  {
    AppMethodBeat.i(264502);
    Object localObject = this.SUt.getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(264502);
      throw ((Throwable)localObject);
    }
    ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)paramFloat);
    localObject = this.SUt.getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(264502);
      throw ((Throwable)localObject);
    }
    ((FrameLayout.LayoutParams)localObject).rightMargin = ((int)paramFloat);
    AppMethodBeat.o(264502);
  }
  
  public final void esl()
  {
    AppMethodBeat.i(264470);
    TaskBarSectionWeAppRecyclerView.b localb = getWeAppCallback();
    if (localb != null) {
      localb.hDK();
    }
    AppMethodBeat.o(264470);
  }
  
  public final String hEf()
  {
    AppMethodBeat.i(264462);
    String str = getContext().getString(d.g.SQh);
    s.s(str, "context.getString(R.stri…p_brand_taskbar_my_weapp)");
    AppMethodBeat.o(264462);
    return str;
  }
  
  public final TaskBarSectionWeAppRecyclerView hEj()
  {
    AppMethodBeat.i(264457);
    TaskBarSectionWeAppRecyclerView localTaskBarSectionWeAppRecyclerView = (TaskBarSectionWeAppRecyclerView)new TaskBarSectionMyWeAppRecyclerView(getContext());
    AppMethodBeat.o(264457);
    return localTaskBarSectionWeAppRecyclerView;
  }
  
  public final AppBrandDesktopView.a hEk()
  {
    AppMethodBeat.i(264476);
    if (getRecyclerView() == null)
    {
      AppMethodBeat.o(264476);
      return null;
    }
    if (getRecyclerView().getDataList() == null)
    {
      AppMethodBeat.o(264476);
      return null;
    }
    if (getRecyclerView().getDataList().size() == 0)
    {
      AppMethodBeat.o(264476);
      return null;
    }
    Object localObject = getRecyclerView().getDataList();
    s.s(localObject, "recyclerView.dataList");
    localObject = (AppBrandDesktopView.a)p.oM((List)localObject);
    AppMethodBeat.o(264476);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionMyWeAppView$notifyDragStateChange$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    public b(a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(264348);
      a.a(this.SUz).setVisibility(4);
      AppMethodBeat.o(264348);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.weapp.a
 * JD-Core Version:    0.7.0.1
 */