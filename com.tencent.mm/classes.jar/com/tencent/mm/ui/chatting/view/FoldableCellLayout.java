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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/view/FoldableCellLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "OnBackgroundCardClickListener", "Landroid/view/View$OnClickListener;", "getOnBackgroundCardClickListener", "()Landroid/view/View$OnClickListener;", "setOnBackgroundCardClickListener", "(Landroid/view/View$OnClickListener;)V", "TAG", "", "mAnimDurationAbove5", "", "mAnimDurationUnder5", "mBackgroundStubViewLayout", "mBackgroundViewCache", "", "Landroid/view/View;", "mBottomCardMaskColorInt", "mElevationViews", "mForegroundPaddingBottom", "mForegroundPaddingLeft", "mForegroundPaddingRight", "mForegroundPaddingTop", "mIsExcutingAnim", "", "mIsExported", "mItemElevation", "", "mItemGap", "mMatchParentChildren", "Ljava/util/ArrayList;", "mMaxBackGroundCacheSize", "mMeasureAllChildren", "mMiddleCardMaskColorInt", "mShadowViews", "mTransparentCardMaskColorInt", "addContentItemView", "", "contentView", "params", "Landroid/widget/FrameLayout$LayoutParams;", "changeCardShadow", "rootView", "color", "getPaddingBottomWithForeground", "getPaddingLeftWithForeground", "getPaddingRightWithForeground", "getPaddingTopWithForeground", "isForegroundInsidePadding", "layoutChildWithFolderMargin", "child", "left", "top", "right", "bottom", "marginVertical", "forceLeftGravity", "layoutChildren", "measureWithFolderMargin", "widthMeasureSpec", "heightMeasureSpec", "marginHorizontal", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "onMeasure", "pullDownContent", "cardActionListener", "Lkotlin/Function0;", "setBackgroundCardLayout", "layoutId", "setBackgroundFillCardNum", "num", "setElevation", "show", "setHeightForAnim", "height", "setTintMode", "tintMode", "Landroid/graphics/PorterDuff$Mode;", "ViewWrapperForAnim", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FoldableCellLayout
  extends FrameLayout
{
  public final String TAG;
  public final long aeKJ;
  public final long aeKK;
  private final int aeKL;
  public boolean aeKM;
  public boolean aeKN;
  public int aeKO;
  public float aeKP;
  private int aeKQ;
  private int aeKR;
  private int aeKS;
  private final List<View> aeKT;
  private final List<View> aeKU;
  private final List<View> aeKV;
  private boolean aeKW;
  private final ArrayList<View> aeKX;
  private int aeKY;
  private int aeKZ;
  private int aeLa;
  private int aeLb;
  private int aeLc;
  private View.OnClickListener aeLd;
  
  public FoldableCellLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254306);
    this.TAG = "MicroMsg.CardCellLayout";
    this.aeKJ = 150L;
    this.aeKK = 200L;
    this.aeKL = 2;
    this.aeKT = ((List)new ArrayList());
    this.aeKU = ((List)new ArrayList());
    this.aeKV = ((List)new ArrayList());
    this.aeKX = new ArrayList(1);
    setForegroundGravity(1);
    this.aeKO = getContext().getResources().getDimensionPixelOffset(R.f.SmallPadding);
    this.aeKP = com.tencent.mm.cd.a.bs(getContext(), R.f.flF);
    this.aeKQ = getContext().getResources().getColor(R.e.fkk);
    this.aeKR = getContext().getResources().getColor(R.e.fkj);
    this.aeKS = getContext().getResources().getColor(17170445);
    AppMethodBeat.o(254306);
  }
  
  public FoldableCellLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254308);
    this.TAG = "MicroMsg.CardCellLayout";
    this.aeKJ = 150L;
    this.aeKK = 200L;
    this.aeKL = 2;
    this.aeKT = ((List)new ArrayList());
    this.aeKU = ((List)new ArrayList());
    this.aeKV = ((List)new ArrayList());
    this.aeKX = new ArrayList(1);
    setForegroundGravity(1);
    this.aeKO = getContext().getResources().getDimensionPixelOffset(R.f.SmallPadding);
    this.aeKP = com.tencent.mm.cd.a.bs(getContext(), R.f.flF);
    this.aeKQ = getContext().getResources().getColor(R.e.fkk);
    this.aeKR = getContext().getResources().getColor(R.e.fkj);
    this.aeKS = getContext().getResources().getColor(17170445);
    AppMethodBeat.o(254308);
  }
  
  private static boolean N(View paramView, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(254324);
    paramView = paramView.findViewById(R.h.fyW);
    if (paramView == null)
    {
      AppMethodBeat.o(254324);
      return false;
    }
    if (paramBoolean) {}
    for (;;)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(254324);
      return true;
      i = 8;
    }
  }
  
  public static void b(View paramView, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(254329);
    s.u(paramView, "<this>");
    s.u(paramMode, "tintMode");
    paramView = paramView.getBackground();
    if (paramView != null) {
      paramView.setTintMode(paramMode);
    }
    AppMethodBeat.o(254329);
  }
  
  private final boolean bp(View paramView, int paramInt)
  {
    AppMethodBeat.i(254326);
    paramView = paramView.findViewById(R.h.fyV);
    if (paramView == null)
    {
      AppMethodBeat.o(254326);
      return false;
    }
    if (paramInt == this.aeKS) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      Drawable localDrawable = paramView.getBackground();
      if (localDrawable != null)
      {
        localDrawable.setTintMode(PorterDuff.Mode.MULTIPLY);
        localDrawable.setTint(paramInt);
      }
      this.aeKU.add(paramView);
      AppMethodBeat.o(254326);
      return true;
      paramView.setVisibility(0);
    }
  }
  
  private final void e(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(254315);
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
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(254315);
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
      AppMethodBeat.o(254315);
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
    AppMethodBeat.i(254321);
    int i = k.qu(getPaddingBottom(), this.aeLc);
    AppMethodBeat.o(254321);
    return i;
  }
  
  private final int getPaddingLeftWithForeground()
  {
    AppMethodBeat.i(254317);
    int i = k.qu(getPaddingLeft(), this.aeKZ);
    AppMethodBeat.o(254317);
    return i;
  }
  
  private final int getPaddingRightWithForeground()
  {
    AppMethodBeat.i(254318);
    int i = k.qu(getPaddingRight(), this.aeLb);
    AppMethodBeat.o(254318);
    return i;
  }
  
  private final int getPaddingTopWithForeground()
  {
    AppMethodBeat.i(254320);
    int i = k.qu(getPaddingTop(), this.aeLa);
    AppMethodBeat.o(254320);
    return i;
  }
  
  private final void n(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(254311);
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(254311);
      throw paramView;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    if (((ViewGroup.MarginLayoutParams)localObject).width == -1)
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(k.qu(0, getMeasuredWidth() - getPaddingLeftWithForeground() - getPaddingRightWithForeground() - ((ViewGroup.MarginLayoutParams)localObject).leftMargin - paramInt3 - ((ViewGroup.MarginLayoutParams)localObject).rightMargin - paramInt3), 1073741824);
      if (((ViewGroup.MarginLayoutParams)localObject).height != -1) {
        break label197;
      }
    }
    label197:
    for (paramInt2 = View.MeasureSpec.makeMeasureSpec(k.qu(0, getMeasuredHeight() - getPaddingTopWithForeground() - getPaddingBottomWithForeground() - ((ViewGroup.MarginLayoutParams)localObject).topMargin - ((ViewGroup.MarginLayoutParams)localObject).bottomMargin - paramInt4), 1073741824);; paramInt2 = ViewGroup.getChildMeasureSpec(paramInt2, getPaddingTopWithForeground() + getPaddingBottomWithForeground() + ((ViewGroup.MarginLayoutParams)localObject).topMargin + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin + paramInt4, ((ViewGroup.MarginLayoutParams)localObject).height))
    {
      paramView.measure(paramInt1, paramInt2);
      AppMethodBeat.o(254311);
      return;
      paramInt1 = ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeftWithForeground() + getPaddingRightWithForeground() + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + paramInt3 + ((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt3, ((ViewGroup.MarginLayoutParams)localObject).width);
      break;
    }
  }
  
  public final void c(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(254350);
    s.u(paramView, "contentView");
    s.u(paramLayoutParams, "params");
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.addView(View.inflate(localFrameLayout.getContext(), this.aeKY, null), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, this.aeKO * 2 + (int)this.aeKP));
    paramLayoutParams.topMargin = ((int)this.aeKP);
    localFrameLayout.addView(paramView, (ViewGroup.LayoutParams)paramLayoutParams);
    localFrameLayout.setTag(paramView.getTag());
    localFrameLayout.setId(R.h.fAh);
    addView((View)localFrameLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
    AppMethodBeat.o(254350);
  }
  
  public final View.OnClickListener getOnBackgroundCardClickListener()
  {
    return this.aeLd;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(254348);
    super.onAttachedToWindow();
    this.aeKV.clear();
    AppMethodBeat.o(254348);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(254349);
    super.onDetachedFromWindow();
    this.aeKV.clear();
    AppMethodBeat.o(254349);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = 2;
    AppMethodBeat.i(254346);
    View localView;
    int i;
    if (getChildCount() > 2)
    {
      localView = getChildAt(0);
      s.s(localView, "this");
      e(localView, paramInt1, paramInt3, 0);
      localView = getChildAt(1);
      s.s(localView, "this");
      e(localView, paramInt1, paramInt3, this.aeKO);
      i = getChildCount();
      if (2 >= i) {
        break label191;
      }
    }
    for (;;)
    {
      paramInt4 = paramInt2 + 1;
      localView = getChildAt(paramInt2);
      s.s(localView, "this");
      e(localView, paramInt1, paramInt3, this.aeKO * 2);
      if (paramInt4 >= i)
      {
        AppMethodBeat.o(254346);
        return;
        if (getChildCount() > 1)
        {
          localView = getChildAt(0);
          s.s(localView, "this");
          e(localView, paramInt1, paramInt3, 0);
          localView = getChildAt(1);
          s.s(localView, "this");
          e(localView, paramInt1, paramInt3, this.aeKO);
        }
        label191:
        AppMethodBeat.o(254346);
        return;
      }
      paramInt2 = paramInt4;
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254345);
    if ((this.aeKM) || (this.aeKN))
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(254345);
      return;
    }
    int i3 = getChildCount();
    Object localObject1;
    if (i3 > 2)
    {
      localObject1 = getChildAt(0);
      s.s(localObject1, "this");
      bp((View)localObject1, this.aeKR);
      N((View)localObject1, false);
      localObject1 = getChildAt(1);
      s.s(localObject1, "this");
      bp((View)localObject1, this.aeKQ);
      N((View)localObject1, true);
      localObject1 = getChildAt(i3 - 1);
      s.s(localObject1, "this");
      bp((View)localObject1, this.aeKS);
      N((View)localObject1, true);
      if ((View.MeasureSpec.getMode(paramInt1) == 1073741824) && (View.MeasureSpec.getMode(paramInt2) == 1073741824)) {
        break label345;
      }
    }
    int i1;
    label345:
    for (int m = 1;; m = 0)
    {
      this.aeKX.clear();
      j = 0;
      if (i3 <= 0) {
        break label849;
      }
      n = 0;
      k = 0;
      j = 0;
      i = 0;
      i1 = n + 1;
      localObject1 = getChildAt(n);
      if ((!this.aeKW) && (((View)localObject1).getVisibility() == 8)) {
        break label832;
      }
      measureChildWithMargins((View)localObject1, paramInt1, 0, paramInt2, 0);
      localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 != null) {
        break label351;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(254345);
      throw ((Throwable)localObject1);
      if (i3 <= 1) {
        break;
      }
      localObject1 = getChildAt(0);
      s.s(localObject1, "this");
      bp((View)localObject1, this.aeKQ);
      N((View)localObject1, false);
      localObject1 = getChildAt(1);
      s.s(localObject1, "this");
      bp((View)localObject1, this.aeKS);
      N((View)localObject1, true);
      break;
    }
    label351:
    Object localObject2 = (FrameLayout.LayoutParams)localObject2;
    int k = k.qu(k, ((View)localObject1).getMeasuredWidth() + ((FrameLayout.LayoutParams)localObject2).leftMargin + ((FrameLayout.LayoutParams)localObject2).rightMargin);
    int j = k.qu(j, ((View)localObject1).getMeasuredHeight() + ((FrameLayout.LayoutParams)localObject2).topMargin + ((FrameLayout.LayoutParams)localObject2).bottomMargin + this.aeKO * k.qv(2, n));
    int n = View.combineMeasuredStates(i, ((View)localObject1).getMeasuredState());
    if ((m != 0) && ((((FrameLayout.LayoutParams)localObject2).width == -1) || (((FrameLayout.LayoutParams)localObject2).height == -1))) {
      this.aeKX.add(localObject1);
    }
    int i = k;
    k = j;
    j = n;
    label473:
    if (i1 >= i3) {}
    for (;;)
    {
      n = getPaddingLeftWithForeground();
      i1 = getPaddingRightWithForeground();
      m = Math.max(getPaddingTopWithForeground() + getPaddingBottomWithForeground() + k, getSuggestedMinimumHeight());
      n = Math.max(i + (n + i1), getSuggestedMinimumWidth());
      localObject1 = getForeground();
      k = n;
      i = m;
      if (localObject1 != null)
      {
        i = k.qu(m, ((Drawable)localObject1).getMinimumHeight());
        k = k.qu(n, ((Drawable)localObject1).getMinimumWidth());
      }
      setMeasuredDimension(View.resolveSizeAndState(k, paramInt1, j), View.resolveSizeAndState(i, paramInt2, j << 16));
      if (i3 > 2)
      {
        localObject1 = getChildAt(0);
        s.s(localObject1, "this");
        n((View)localObject1, paramInt1, paramInt2, this.aeKO * 2, (int)this.aeKP);
        localObject1 = getChildAt(1);
        s.s(localObject1, "this");
        n((View)localObject1, paramInt1, paramInt2, this.aeKO, (int)this.aeKP);
        if (2 >= i3) {
          break label794;
        }
      }
      for (i = 2;; i = j)
      {
        j = i + 1;
        localObject1 = getChildAt(i);
        s.s(localObject1, "this");
        n((View)localObject1, paramInt1, paramInt2, 0, 0);
        if (i != i3 - 1) {
          ((View)localObject1).setVisibility(8);
        }
        if (j >= i3)
        {
          AppMethodBeat.o(254345);
          return;
          if (i3 > 1)
          {
            localObject1 = getChildAt(0);
            s.s(localObject1, "this");
            n((View)localObject1, paramInt1, paramInt2, this.aeKO, (int)this.aeKP);
            localObject1 = getChildAt(1);
            s.s(localObject1, "this");
            n((View)localObject1, paramInt1, paramInt2, 0, 0);
          }
          label794:
          AppMethodBeat.o(254345);
          return;
        }
      }
      n = i1;
      i1 = k;
      int i2 = j;
      k = i;
      j = i1;
      i = i2;
      break;
      label832:
      n = i;
      i = k;
      k = j;
      j = n;
      break label473;
      label849:
      i = 0;
      k = 0;
    }
  }
  
  public final void setBackgroundCardLayout(int paramInt)
  {
    AppMethodBeat.i(254353);
    this.aeKY = paramInt;
    if (this.aeKV.isEmpty())
    {
      View localView = View.inflate(getContext(), this.aeKY, null);
      localView.setLayoutParams(new ViewGroup.LayoutParams(-1, this.aeKO * 2));
      localView.setOnClickListener(getOnBackgroundCardClickListener());
      List localList = this.aeKV;
      s.s(localView, "this");
      localList.add(localView);
    }
    AppMethodBeat.o(254353);
  }
  
  public final void setBackgroundFillCardNum(int paramInt)
  {
    AppMethodBeat.i(254352);
    int i = k.qv(this.aeKL, paramInt);
    if ((this.aeKN) || (this.aeKM))
    {
      removeAllViews();
      getLayoutParams().height = -2;
      this.aeKV.clear();
    }
    int j = i + 1;
    int m = getChildCount();
    int n = m - 1;
    if (n > 0) {}
    int k;
    for (paramInt = 0;; paramInt = k)
    {
      k = paramInt + 1;
      getChildAt(paramInt).setVisibility(0);
      if (k >= n)
      {
        if (m < j) {
          if (findViewById(R.h.fAh) == null)
          {
            paramInt = i - m;
            if (paramInt <= 0) {}
          }
        }
        for (i = 0;; i = j)
        {
          j = i + 1;
          label143:
          Object localObject;
          if (!((Collection)this.aeKV).isEmpty())
          {
            i = 1;
            if (i == 0) {
              break label241;
            }
            localObject = (View)this.aeKV.remove(0);
            ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, this.aeKO * 2 + (int)this.aeKP));
            ((View)localObject).setOnClickListener(getOnBackgroundCardClickListener());
            addView((View)localObject, 0);
            label206:
            if (j < paramInt) {
              continue;
            }
          }
          label396:
          for (;;)
          {
            this.aeKN = false;
            this.aeKM = false;
            AppMethodBeat.o(254352);
            return;
            paramInt = j - m;
            break;
            i = 0;
            break label143;
            label241:
            localObject = View.inflate(getContext(), this.aeKY, null);
            ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, this.aeKO * 2 + (int)this.aeKP));
            ((View)localObject).setOnClickListener(getOnBackgroundCardClickListener());
            addView((View)localObject, 0);
            break label206;
            if (m > j)
            {
              if (findViewById(R.h.fAh) == null) {}
              for (paramInt = i;; paramInt = j)
              {
                if (paramInt >= m) {
                  break label396;
                }
                do
                {
                  i = paramInt + 1;
                  if (this.aeKV.size() < this.aeKL)
                  {
                    localObject = this.aeKV;
                    View localView = getChildAt(0);
                    s.s(localView, "getChildAt(0)");
                    ((List)localObject).add(localView);
                  }
                  removeViewAt(0);
                  paramInt = i;
                } while (i < m);
                break;
              }
            }
          }
        }
      }
    }
  }
  
  public final void setHeightForAnim(int paramInt)
  {
    AppMethodBeat.i(254355);
    getLayoutParams().height = paramInt;
    requestLayout();
    AppMethodBeat.o(254355);
  }
  
  public final void setOnBackgroundCardClickListener(View.OnClickListener paramOnClickListener)
  {
    this.aeLd = paramOnClickListener;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/view/FoldableCellLayout$pullDownContent$5", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Animator.AnimatorListener
  {
    public a(FoldableCellLayout paramFoldableCellLayout, kotlin.g.a.a<ah> parama, AnimatorSet paramAnimatorSet) {}
    
    private static final void a(FoldableCellLayout paramFoldableCellLayout, kotlin.g.a.a parama)
    {
      AppMethodBeat.i(254288);
      s.u(paramFoldableCellLayout, "this$0");
      if ((FoldableCellLayout.d(paramFoldableCellLayout)) && (!FoldableCellLayout.e(paramFoldableCellLayout)))
      {
        Log.i(FoldableCellLayout.a(paramFoldableCellLayout), "reset anim params by post delay");
        FoldableCellLayout.b(paramFoldableCellLayout).clear();
        FoldableCellLayout.c(paramFoldableCellLayout).clear();
        FoldableCellLayout.a(paramFoldableCellLayout, false);
        FoldableCellLayout.b(paramFoldableCellLayout, true);
        if (parama != null) {
          parama.invoke();
        }
      }
      AppMethodBeat.o(254288);
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(254309);
      Log.i(FoldableCellLayout.a(this.aeLe), "onAnimationCancel");
      FoldableCellLayout.a(this.aeLe, false);
      FoldableCellLayout.b(this.aeLe, true);
      AppMethodBeat.o(254309);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(254303);
      Log.i(FoldableCellLayout.a(this.aeLe), "onAnimationEnd");
      FoldableCellLayout.b(this.aeLe).clear();
      FoldableCellLayout.c(this.aeLe).clear();
      FoldableCellLayout.a(this.aeLe, false);
      FoldableCellLayout.b(this.aeLe, true);
      paramAnimator = this.aeLf;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(254303);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(254313);
      Log.i(FoldableCellLayout.a(this.aeLe), "onAnimationStart");
      paramAnimator = FoldableCellLayout.c(this.aeLe).iterator();
      while (paramAnimator.hasNext()) {
        FoldableCellLayout.b((View)paramAnimator.next(), PorterDuff.Mode.DST);
      }
      FoldableCellLayout.a(this.aeLe, true);
      FoldableCellLayout.b(this.aeLe, false);
      this.aeLe.postDelayed(new FoldableCellLayout.a..ExternalSyntheticLambda0(this.aeLe, this.aeLf), this.aeLg.getDuration() + 100L);
      AppMethodBeat.o(254313);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.FoldableCellLayout
 * JD-Core Version:    0.7.0.1
 */