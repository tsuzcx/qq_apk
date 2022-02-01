package com.tencent.mm.ui.chatting.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/view/FoldableCellLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "OnBackgroundCardClickListener", "Landroid/view/View$OnClickListener;", "getOnBackgroundCardClickListener", "()Landroid/view/View$OnClickListener;", "setOnBackgroundCardClickListener", "(Landroid/view/View$OnClickListener;)V", "TAG", "", "mAnimDurationAbove5", "", "mAnimDurationUnder5", "mBackgroundStubViewLayout", "mBackgroundViewCache", "", "Landroid/view/View;", "mBottomCardMaskColorInt", "mElevationViews", "mForegroundPaddingBottom", "mForegroundPaddingLeft", "mForegroundPaddingRight", "mForegroundPaddingTop", "mIsExcutingAnim", "", "mIsExported", "mItemElevation", "", "mItemGap", "mMatchParentChildren", "Ljava/util/ArrayList;", "mMaxBackGroundCacheSize", "mMeasureAllChildren", "mMiddleCardMaskColorInt", "mShadowViews", "addContentItemView", "", "contentView", "params", "Landroid/widget/FrameLayout$LayoutParams;", "changeCardShadow", "rootView", "color", "getPaddingBottomWithForeground", "getPaddingLeftWithForeground", "getPaddingRightWithForeground", "getPaddingTopWithForeground", "isForegroundInsidePadding", "layoutChildWithFolderMargin", "child", "left", "top", "right", "bottom", "marginVertical", "forceLeftGravity", "layoutChildren", "measureWithFolderMargin", "widthMeasureSpec", "heightMeasureSpec", "marginHorizontal", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "onMeasure", "pullDownContent", "cardActionListener", "Lkotlin/Function0;", "setBackgroundCardLayout", "layoutId", "setBackgroundFillCardNum", "num", "setElevation", "show", "setHeightForAnim", "height", "setTintMode", "tintMode", "Landroid/graphics/PorterDuff$Mode;", "ViewWrapperForAnim", "app_release"})
public final class FoldableCellLayout
  extends FrameLayout
{
  public final String TAG;
  public final long Xbc;
  public final long Xbd;
  private final int Xbe;
  public boolean Xbf;
  public boolean Xbg;
  public int Xbh;
  public float Xbi;
  private int Xbj;
  private int Xbk;
  private final List<View> Xbl;
  private final List<View> Xbm;
  private final List<View> Xbn;
  private boolean Xbo;
  private final ArrayList<View> Xbp;
  private int Xbq;
  private int Xbr;
  private int Xbs;
  private int Xbt;
  private int Xbu;
  private View.OnClickListener Xbv;
  
  public FoldableCellLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(286843);
    this.TAG = "MicroMsg.CardCellLayout";
    this.Xbc = 150L;
    this.Xbd = 200L;
    this.Xbe = 2;
    this.Xbl = ((List)new ArrayList());
    this.Xbm = ((List)new ArrayList());
    this.Xbn = ((List)new ArrayList());
    this.Xbp = new ArrayList(1);
    setForegroundGravity(1);
    paramContext = getContext();
    p.j(paramContext, "context");
    this.Xbh = paramContext.getResources().getDimensionPixelOffset(R.f.SmallPadding);
    this.Xbi = com.tencent.mm.ci.a.aZ(getContext(), R.f.dlp);
    paramContext = getContext();
    p.j(paramContext, "context");
    this.Xbj = paramContext.getResources().getColor(R.e.dki);
    paramContext = getContext();
    p.j(paramContext, "context");
    this.Xbk = paramContext.getResources().getColor(R.e.dkh);
    AppMethodBeat.o(286843);
  }
  
  public FoldableCellLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(286844);
    this.TAG = "MicroMsg.CardCellLayout";
    this.Xbc = 150L;
    this.Xbd = 200L;
    this.Xbe = 2;
    this.Xbl = ((List)new ArrayList());
    this.Xbm = ((List)new ArrayList());
    this.Xbn = ((List)new ArrayList());
    this.Xbp = new ArrayList(1);
    setForegroundGravity(1);
    paramContext = getContext();
    p.j(paramContext, "context");
    this.Xbh = paramContext.getResources().getDimensionPixelOffset(R.f.SmallPadding);
    this.Xbi = com.tencent.mm.ci.a.aZ(getContext(), R.f.dlp);
    paramContext = getContext();
    p.j(paramContext, "context");
    this.Xbj = paramContext.getResources().getColor(R.e.dki);
    paramContext = getContext();
    p.j(paramContext, "context");
    this.Xbk = paramContext.getResources().getColor(R.e.dkh);
    AppMethodBeat.o(286844);
  }
  
  private static boolean H(View paramView, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(286839);
    paramView = paramView.findViewById(R.h.dyn);
    if (paramView == null)
    {
      AppMethodBeat.o(286839);
      return false;
    }
    if (paramBoolean) {}
    for (;;)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(286839);
      return true;
      i = 8;
    }
  }
  
  private final boolean aS(View paramView, int paramInt)
  {
    AppMethodBeat.i(286840);
    paramView = paramView.findViewById(R.h.dym);
    if (paramView == null)
    {
      AppMethodBeat.o(286840);
      return false;
    }
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null)
    {
      localDrawable.setTintMode(PorterDuff.Mode.MULTIPLY);
      localDrawable.setTint(paramInt);
    }
    this.Xbm.add(paramView);
    AppMethodBeat.o(286840);
    return true;
  }
  
  public static void b(View paramView, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(286842);
    p.k(paramView, "$this$setTintMode");
    p.k(paramMode, "tintMode");
    paramView = paramView.getBackground();
    if (paramView != null)
    {
      paramView.setTintMode(paramMode);
      AppMethodBeat.o(286842);
      return;
    }
    AppMethodBeat.o(286842);
  }
  
  private final void f(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(286830);
    int k = getPaddingLeftWithForeground();
    paramInt1 = paramInt2 - paramInt1 - getPaddingRightWithForeground();
    int j = getPaddingTopWithForeground();
    getPaddingBottomWithForeground();
    Object localObject;
    int i;
    if (paramView.getVisibility() != 8)
    {
      localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(286830);
        throw paramView;
      }
      localObject = (FrameLayout.LayoutParams)localObject;
      paramInt2 = paramView.getMeasuredWidth();
      i = paramView.getMeasuredHeight();
      switch (Gravity.getAbsoluteGravity(1, getLayoutDirection()) & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        paramInt1 = k + ((FrameLayout.LayoutParams)localObject).leftMargin;
      }
    }
    for (;;)
    {
      paramInt3 = ((FrameLayout.LayoutParams)localObject).topMargin + j + paramInt3;
      paramView.layout(paramInt1, paramInt3, paramInt1 + paramInt2, paramInt3 + i);
      AppMethodBeat.o(286830);
      return;
      paramInt1 = k + (paramInt1 - k - paramInt2) / 2 + ((FrameLayout.LayoutParams)localObject).leftMargin - ((FrameLayout.LayoutParams)localObject).rightMargin;
      continue;
      paramInt1 = paramInt1 - paramInt2 - ((FrameLayout.LayoutParams)localObject).rightMargin;
      continue;
      paramInt1 = k + ((FrameLayout.LayoutParams)localObject).leftMargin;
    }
  }
  
  private final int getPaddingBottomWithForeground()
  {
    AppMethodBeat.i(286834);
    int i = i.ov(getPaddingBottom(), this.Xbu);
    AppMethodBeat.o(286834);
    return i;
  }
  
  private final int getPaddingLeftWithForeground()
  {
    AppMethodBeat.i(286831);
    int i = i.ov(getPaddingLeft(), this.Xbr);
    AppMethodBeat.o(286831);
    return i;
  }
  
  private final int getPaddingRightWithForeground()
  {
    AppMethodBeat.i(286832);
    int i = i.ov(getPaddingRight(), this.Xbt);
    AppMethodBeat.o(286832);
    return i;
  }
  
  private final int getPaddingTopWithForeground()
  {
    AppMethodBeat.i(286833);
    int i = i.ov(getPaddingTop(), this.Xbs);
    AppMethodBeat.o(286833);
    return i;
  }
  
  private final void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(286829);
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      paramView = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(286829);
      throw paramView;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    if (((ViewGroup.MarginLayoutParams)localObject).width == -1)
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(i.ov(0, getMeasuredWidth() - getPaddingLeftWithForeground() - getPaddingRightWithForeground() - ((ViewGroup.MarginLayoutParams)localObject).leftMargin - paramInt3 - ((ViewGroup.MarginLayoutParams)localObject).rightMargin - paramInt3), 1073741824);
      if (((ViewGroup.MarginLayoutParams)localObject).height != -1) {
        break label197;
      }
    }
    label197:
    for (paramInt2 = View.MeasureSpec.makeMeasureSpec(i.ov(0, getMeasuredHeight() - getPaddingTopWithForeground() - getPaddingBottomWithForeground() - ((ViewGroup.MarginLayoutParams)localObject).topMargin - ((ViewGroup.MarginLayoutParams)localObject).bottomMargin - paramInt4), 1073741824);; paramInt2 = ViewGroup.getChildMeasureSpec(paramInt2, getPaddingTopWithForeground() + getPaddingBottomWithForeground() + ((ViewGroup.MarginLayoutParams)localObject).topMargin + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin + paramInt4, ((ViewGroup.MarginLayoutParams)localObject).height))
    {
      paramView.measure(paramInt1, paramInt2);
      AppMethodBeat.o(286829);
      return;
      paramInt1 = ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeftWithForeground() + getPaddingRightWithForeground() + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + paramInt3 + ((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt3, ((ViewGroup.MarginLayoutParams)localObject).width);
      break;
    }
  }
  
  public final void b(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(286835);
    p.k(paramView, "contentView");
    p.k(paramLayoutParams, "params");
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.addView(View.inflate(localFrameLayout.getContext(), this.Xbq, null), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, this.Xbh * 2 + (int)this.Xbi));
    paramLayoutParams.topMargin = ((int)this.Xbi);
    localFrameLayout.addView(paramView, (ViewGroup.LayoutParams)paramLayoutParams);
    localFrameLayout.setTag(paramView.getTag());
    localFrameLayout.setId(R.h.dzn);
    addView((View)localFrameLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
    AppMethodBeat.o(286835);
  }
  
  public final View.OnClickListener getOnBackgroundCardClickListener()
  {
    return this.Xbv;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(286826);
    super.onAttachedToWindow();
    this.Xbn.clear();
    AppMethodBeat.o(286826);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(286827);
    super.onDetachedFromWindow();
    this.Xbn.clear();
    AppMethodBeat.o(286827);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = 2;
    AppMethodBeat.i(286825);
    View localView;
    if (getChildCount() > 2)
    {
      localView = getChildAt(0);
      p.j(localView, "this");
      f(localView, paramInt1, paramInt3, 0);
      localView = getChildAt(1);
      p.j(localView, "this");
      f(localView, paramInt1, paramInt3, this.Xbh);
      paramInt4 = getChildCount();
      while (paramInt2 < paramInt4)
      {
        localView = getChildAt(paramInt2);
        p.j(localView, "this");
        f(localView, paramInt1, paramInt3, this.Xbh * 2);
        paramInt2 += 1;
      }
    }
    if (getChildCount() > 1)
    {
      localView = getChildAt(0);
      p.j(localView, "this");
      f(localView, paramInt1, paramInt3, 0);
      localView = getChildAt(1);
      p.j(localView, "this");
      f(localView, paramInt1, paramInt3, this.Xbh);
    }
    AppMethodBeat.o(286825);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(286824);
    if ((this.Xbf) || (this.Xbg))
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(286824);
      return;
    }
    int i1 = getChildCount();
    Object localObject1;
    if (i1 > 2)
    {
      localObject1 = getChildAt(0);
      p.j(localObject1, "this");
      aS((View)localObject1, this.Xbk);
      H((View)localObject1, false);
      localObject1 = getChildAt(1);
      p.j(localObject1, "this");
      aS((View)localObject1, this.Xbj);
      H((View)localObject1, true);
      localObject1 = getChildAt(i1 - 1);
      p.j(localObject1, "this");
      H((View)localObject1, true);
      if ((View.MeasureSpec.getMode(paramInt1) == 1073741824) && (View.MeasureSpec.getMode(paramInt2) == 1073741824)) {
        break label332;
      }
    }
    int n;
    label332:
    for (int m = 1;; m = 0)
    {
      this.Xbp.clear();
      j = 0;
      k = 0;
      i = 0;
      n = 0;
      if (n >= i1) {
        break label457;
      }
      localObject1 = getChildAt(n);
      if (!this.Xbo)
      {
        p.j(localObject1, "child");
        if (((View)localObject1).getVisibility() == 8) {
          break label768;
        }
      }
      measureChildWithMargins((View)localObject1, paramInt1, 0, paramInt2, 0);
      p.j(localObject1, "child");
      localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 != null) {
        break label338;
      }
      localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(286824);
      throw ((Throwable)localObject1);
      if (i1 <= 1) {
        break;
      }
      localObject1 = getChildAt(0);
      p.j(localObject1, "this");
      aS((View)localObject1, this.Xbj);
      H((View)localObject1, false);
      localObject1 = getChildAt(1);
      p.j(localObject1, "this");
      H((View)localObject1, true);
      break;
    }
    label338:
    Object localObject2 = (FrameLayout.LayoutParams)localObject2;
    int k = i.ov(k, ((View)localObject1).getMeasuredWidth() + ((FrameLayout.LayoutParams)localObject2).leftMargin + ((FrameLayout.LayoutParams)localObject2).rightMargin);
    int j = i.ov(j, ((View)localObject1).getMeasuredHeight() + ((FrameLayout.LayoutParams)localObject2).topMargin + ((FrameLayout.LayoutParams)localObject2).bottomMargin + this.Xbh * i.ow(2, n));
    int i = View.combineMeasuredStates(i, ((View)localObject1).getMeasuredState());
    if ((m != 0) && ((((FrameLayout.LayoutParams)localObject2).width == -1) || (((FrameLayout.LayoutParams)localObject2).height == -1))) {
      this.Xbp.add(localObject1);
    }
    label768:
    for (;;)
    {
      n += 1;
      break;
      label457:
      n = getPaddingLeftWithForeground();
      int i2 = getPaddingRightWithForeground();
      m = Math.max(getPaddingTopWithForeground() + getPaddingBottomWithForeground() + j, getSuggestedMinimumHeight());
      n = Math.max(n + i2 + k, getSuggestedMinimumWidth());
      localObject1 = getForeground();
      k = n;
      j = m;
      if (localObject1 != null)
      {
        j = i.ov(m, ((Drawable)localObject1).getMinimumHeight());
        k = i.ov(n, ((Drawable)localObject1).getMinimumWidth());
      }
      setMeasuredDimension(View.resolveSizeAndState(k, paramInt1, i), View.resolveSizeAndState(j, paramInt2, i << 16));
      if (i1 > 2)
      {
        localObject1 = getChildAt(0);
        p.j(localObject1, "this");
        m((View)localObject1, paramInt1, paramInt2, this.Xbh * 2, (int)this.Xbi);
        localObject1 = getChildAt(1);
        p.j(localObject1, "this");
        m((View)localObject1, paramInt1, paramInt2, this.Xbh, (int)this.Xbi);
        i = 2;
        while (i < i1)
        {
          localObject1 = getChildAt(i);
          p.j(localObject1, "this");
          m((View)localObject1, paramInt1, paramInt2, 0, 0);
          if (i != i1 - 1) {
            ((View)localObject1).setVisibility(8);
          }
          i += 1;
        }
      }
      if (i1 > 1)
      {
        localObject1 = getChildAt(0);
        p.j(localObject1, "this");
        m((View)localObject1, paramInt1, paramInt2, this.Xbh, (int)this.Xbi);
        localObject1 = getChildAt(1);
        p.j(localObject1, "this");
        m((View)localObject1, paramInt1, paramInt2, 0, 0);
      }
      AppMethodBeat.o(286824);
      return;
    }
  }
  
  public final void setBackgroundCardLayout(int paramInt)
  {
    AppMethodBeat.i(286838);
    this.Xbq = paramInt;
    if (this.Xbn.isEmpty())
    {
      View localView = View.inflate(getContext(), this.Xbq, null);
      localView.setLayoutParams(new ViewGroup.LayoutParams(-1, this.Xbh * 2));
      localView.setOnClickListener(this.Xbv);
      List localList = this.Xbn;
      p.j(localView, "this");
      localList.add(localView);
    }
    AppMethodBeat.o(286838);
  }
  
  public final void setBackgroundFillCardNum(int paramInt)
  {
    AppMethodBeat.i(286837);
    int i = i.ow(this.Xbe, paramInt);
    if ((this.Xbg) || (this.Xbf))
    {
      removeAllViews();
      getLayoutParams().height = -2;
      this.Xbn.clear();
    }
    int j = i + 1;
    int k = getChildCount();
    paramInt = 0;
    Object localObject;
    while (paramInt < k - 1)
    {
      localObject = getChildAt(paramInt);
      p.j(localObject, "getChildAt(i)");
      ((View)localObject).setVisibility(0);
      paramInt += 1;
    }
    if (k < j)
    {
      if (findViewById(R.h.dzn) == null)
      {
        paramInt = i - k;
        i = 0;
        label122:
        if (i >= paramInt) {
          break label376;
        }
        if (((Collection)this.Xbn).isEmpty()) {
          break label222;
        }
        j = 1;
        label144:
        if (j == 0) {
          break label227;
        }
        localObject = (View)this.Xbn.remove(0);
        ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, this.Xbh * 2 + (int)this.Xbi));
        ((View)localObject).setOnClickListener(this.Xbv);
        addView((View)localObject, 0);
      }
      for (;;)
      {
        i += 1;
        break label122;
        paramInt = j - k;
        break;
        label222:
        j = 0;
        break label144;
        label227:
        localObject = View.inflate(getContext(), this.Xbq, null);
        ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, this.Xbh * 2 + (int)this.Xbi));
        ((View)localObject).setOnClickListener(this.Xbv);
        addView((View)localObject, 0);
      }
    }
    else if (k > j)
    {
      if (findViewById(R.h.dzn) == null) {
        paramInt = i;
      }
      while (paramInt < k)
      {
        if (this.Xbn.size() < this.Xbe)
        {
          localObject = this.Xbn;
          View localView = getChildAt(0);
          p.j(localView, "getChildAt(0)");
          ((List)localObject).add(localView);
        }
        removeViewAt(0);
        paramInt += 1;
        continue;
        paramInt = j;
      }
    }
    label376:
    this.Xbg = false;
    this.Xbf = false;
    AppMethodBeat.o(286837);
  }
  
  @Keep
  public final void setHeightForAnim(int paramInt)
  {
    AppMethodBeat.i(286841);
    getLayoutParams().height = paramInt;
    requestLayout();
    AppMethodBeat.o(286841);
  }
  
  public final void setOnBackgroundCardClickListener(View.OnClickListener paramOnClickListener)
  {
    this.Xbv = paramOnClickListener;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/view/FoldableCellLayout$pullDownContent$5", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_release"})
  public static final class a
    implements Animator.AnimatorListener
  {
    public a(kotlin.g.a.a parama, AnimatorSet paramAnimatorSet) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(291193);
      Log.i(FoldableCellLayout.a(this.Xbw), "onAnimationCancel");
      FoldableCellLayout.a(this.Xbw, false);
      FoldableCellLayout.b(this.Xbw, true);
      AppMethodBeat.o(291193);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(291192);
      Log.i(FoldableCellLayout.a(this.Xbw), "onAnimationEnd");
      FoldableCellLayout.b(this.Xbw).clear();
      FoldableCellLayout.c(this.Xbw).clear();
      FoldableCellLayout.a(this.Xbw, false);
      FoldableCellLayout.b(this.Xbw, true);
      paramAnimator = this.Xbx;
      if (paramAnimator != null)
      {
        paramAnimator.invoke();
        AppMethodBeat.o(291192);
        return;
      }
      AppMethodBeat.o(291192);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(291195);
      Log.i(FoldableCellLayout.a(this.Xbw), "onAnimationStart");
      paramAnimator = FoldableCellLayout.c(this.Xbw).iterator();
      while (paramAnimator.hasNext()) {
        FoldableCellLayout.b((View)paramAnimator.next(), PorterDuff.Mode.DST);
      }
      FoldableCellLayout.a(this.Xbw, true);
      FoldableCellLayout.b(this.Xbw, false);
      this.Xbw.postDelayed((Runnable)new a(this), this.Xby.getDuration() + 100L);
      AppMethodBeat.o(291195);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FoldableCellLayout.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(269973);
        if ((FoldableCellLayout.d(this.Xbz.Xbw)) && (!FoldableCellLayout.e(this.Xbz.Xbw)))
        {
          Log.i(FoldableCellLayout.a(this.Xbz.Xbw), "reset anim params by post delay");
          FoldableCellLayout.b(this.Xbz.Xbw).clear();
          FoldableCellLayout.c(this.Xbz.Xbw).clear();
          FoldableCellLayout.a(this.Xbz.Xbw, false);
          FoldableCellLayout.b(this.Xbz.Xbw, true);
          kotlin.g.a.a locala = this.Xbz.Xbx;
          if (locala != null)
          {
            locala.invoke();
            AppMethodBeat.o(269973);
            return;
          }
        }
        AppMethodBeat.o(269973);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.FoldableCellLayout
 * JD-Core Version:    0.7.0.1
 */