package com.tencent.mm.view.ratio;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/ratio/RatioLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "adapter", "Lcom/tencent/mm/view/ratio/RatioLayoutAdapter;", "layoutManager", "Lcom/tencent/mm/view/ratio/RatioLayoutManager;", "checkLayoutParams", "", "p", "Landroid/view/ViewGroup$LayoutParams;", "generateDefaultLayoutParams", "generateLayoutParams", "getAdapter", "getDefaultPosition", "Lkotlin/Pair;", "index", "count", "width", "height", "getDefaultSize", "getLayoutManager", "onLayout", "", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "printLog", "str", "setAdapter", "setLayoutManager", "LayoutInfo", "LayoutParams", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class RatioLayout
  extends ViewGroup
{
  private final String TAG;
  private b agNC;
  private a<?> agND;
  
  public RatioLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(234834);
    this.TAG = "MicroMsg.MultiAreaLayout";
    AppMethodBeat.o(234834);
  }
  
  public RatioLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(234841);
    this.TAG = "MicroMsg.MultiAreaLayout";
    AppMethodBeat.o(234841);
  }
  
  private final void bEB(String paramString)
  {
    AppMethodBeat.i(234846);
    Log.i(this.TAG, paramString);
    AppMethodBeat.o(234846);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(234902);
    ViewGroup.LayoutParams localLayoutParams = (ViewGroup.LayoutParams)new LayoutParams(-2);
    AppMethodBeat.o(234902);
    return localLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(234900);
    s.u(paramAttributeSet, "attrs");
    Object localObject = getContext().obtainStyledAttributes(paramAttributeSet, a.m.RatioLayout);
    s.s(localObject, "context.obtainStyledAttr… R.styleable.RatioLayout)");
    float f1 = ((TypedArray)localObject).getFloat(a.m.RatioLayout_xRatio, 0.0F);
    float f2 = ((TypedArray)localObject).getFloat(a.m.RatioLayout_yRatio, 0.0F);
    float f3 = ((TypedArray)localObject).getFloat(a.m.RatioLayout_wRatio, 0.0F);
    float f4 = ((TypedArray)localObject).getFloat(a.m.RatioLayout_hRatio, 0.0F);
    ((TypedArray)localObject).recycle();
    localObject = getContext();
    s.s(localObject, "context");
    paramAttributeSet = new LayoutParams((Context)localObject, paramAttributeSet);
    paramAttributeSet.agNI = new a(f1, f2, f3, f4);
    paramAttributeSet = (ViewGroup.LayoutParams)paramAttributeSet;
    AppMethodBeat.o(234900);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(234897);
    s.u(paramLayoutParams, "p");
    paramLayoutParams = (ViewGroup.LayoutParams)new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(234897);
    return paramLayoutParams;
  }
  
  public final a<?> getAdapter()
  {
    AppMethodBeat.i(234861);
    a locala = this.agND;
    if (locala == null)
    {
      s.bIx("adapter");
      AppMethodBeat.o(234861);
      return null;
    }
    AppMethodBeat.o(234861);
    return locala;
  }
  
  public final b getLayoutManager()
  {
    AppMethodBeat.i(234850);
    b localb = this.agNC;
    if (localb == null)
    {
      s.bIx("layoutManager");
      AppMethodBeat.o(234850);
      return null;
    }
    AppMethodBeat.o(234850);
    return localb;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(234889);
    paramInt3 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    paramInt4 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i = getChildCount();
    bEB("onLayout, width:" + paramInt3 + ", height:" + paramInt4 + ", count:" + i + ", paddingLeft:" + getPaddingLeft() + ", paddingRight:" + getPaddingRight() + ", paddingTop:" + getPaddingTop() + ", paddingBottom:" + getPaddingBottom());
    paramInt1 = 0;
    int j = getChildCount();
    if (j > 0) {}
    for (;;)
    {
      paramInt2 = paramInt1 + 1;
      View localView = getChildAt(paramInt1);
      RatioLayout localRatioLayout;
      if (localView.getVisibility() != 8)
      {
        localObject = localView.getLayoutParams();
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.ratio.RatioLayout.LayoutParams");
          AppMethodBeat.o(234889);
          throw ((Throwable)localObject);
        }
        localObject = ((LayoutParams)localObject).agNI;
        if (localObject != null) {
          break label447;
        }
        localObject = null;
        if (localObject == null)
        {
          localRatioLayout = (RatioLayout)this;
          if (i != 1) {
            break label635;
          }
        }
      }
      label447:
      label635:
      for (Object localObject = new r(Integer.valueOf(0), Integer.valueOf(0));; localObject = new r(Integer.valueOf(paramInt3 / i), Integer.valueOf(paramInt4 / i)))
      {
        paramInt1 = ((Number)((r)localObject).bsC).intValue();
        int k = ((Number)((r)localObject).bsD).intValue();
        int m = localRatioLayout.getPaddingLeft() + paramInt1;
        int n = localRatioLayout.getPaddingTop() + k;
        localView.layout(m, n, localView.getMeasuredWidth() + m, localView.getMeasuredHeight() + n);
        localRatioLayout.bEB("onLayout case2, childLayoutParams:" + localView.getMeasuredWidth() + ',' + localView.getMeasuredHeight() + "x:" + paramInt1 + ", y:" + k + ", left:" + m + ", top:" + n + ", right:" + (m + localView.getMeasuredWidth()) + ", bottom:" + (localView.getMeasuredHeight() + n));
        if (paramInt2 < j) {
          break label663;
        }
        AppMethodBeat.o(234889);
        return;
        paramInt1 = (int)(((a)localObject).agNE * paramInt3);
        k = (int)(((a)localObject).agNF * paramInt4);
        m = getPaddingLeft() + paramInt1;
        n = getPaddingTop() + k;
        localView.layout(m, n, localView.getMeasuredWidth() + m, localView.getMeasuredHeight() + n);
        bEB("onLayout case1, childLayoutParams:" + localView.getMeasuredWidth() + ',' + localView.getMeasuredHeight() + "x:" + paramInt1 + ", y:" + k + ", left:" + m + ", top:" + n + ", right:" + (localView.getMeasuredWidth() + m) + ", bottom:" + (localView.getMeasuredHeight() + n));
        localObject = ah.aiuX;
        break;
      }
      label663:
      paramInt1 = paramInt2;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234878);
    super.onMeasure(paramInt1, paramInt2);
    int i = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    int j = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int k = getChildCount();
    bEB("onMeasure, width:" + i + ", height:" + j + ", count:" + k);
    int m = getChildCount();
    if (m > 0) {}
    for (paramInt1 = 0;; paramInt1 = paramInt2)
    {
      paramInt2 = paramInt1 + 1;
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        localObject = localView.getLayoutParams();
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.ratio.RatioLayout.LayoutParams");
          AppMethodBeat.o(234878);
          throw ((Throwable)localObject);
        }
        localObject = ((LayoutParams)localObject).agNI;
        if (localObject != null) {
          break label323;
        }
      }
      for (Object localObject = null;; localObject = ah.aiuX)
      {
        if (localObject == null)
        {
          localObject = (RatioLayout)this;
          r localr = new r(Integer.valueOf(i / k), Integer.valueOf(j / k));
          localView.measure(View.MeasureSpec.makeMeasureSpec(((Number)localr.bsC).intValue(), 1073741824), View.MeasureSpec.makeMeasureSpec(((Number)localr.bsD).intValue(), 1073741824));
          ((RatioLayout)localObject).bEB("onMeasure case2, index:" + paramInt1 + ", width:" + ((Number)localr.bsC).intValue() + ", height:" + ((Number)localr.bsD).intValue());
        }
        if (paramInt2 < m) {
          break;
        }
        AppMethodBeat.o(234878);
        return;
        label323:
        localView.measure(View.MeasureSpec.makeMeasureSpec((int)(((a)localObject).agNG * i), 1073741824), View.MeasureSpec.makeMeasureSpec((int)(((a)localObject).agNH * j), 1073741824));
        bEB("onMeasure case1, index:" + paramInt1 + ", width:" + (int)(((a)localObject).agNG * i) + ", height:" + (int)(((a)localObject).agNH * j));
      }
    }
  }
  
  public final void setAdapter(a<?> parama)
  {
    AppMethodBeat.i(234869);
    s.u(parama, "adapter");
    this.agND = parama;
    a locala = this.agND;
    parama = locala;
    if (locala == null)
    {
      s.bIx("adapter");
      parama = null;
    }
    s.u(this, "<set-?>");
    parama.agNJ = this;
    AppMethodBeat.o(234869);
  }
  
  public final void setLayoutManager(b paramb)
  {
    AppMethodBeat.i(234857);
    s.u(paramb, "layoutManager");
    this.agNC = paramb;
    b localb = this.agNC;
    paramb = localb;
    if (localb == null)
    {
      s.bIx("layoutManager");
      paramb = null;
    }
    s.u(this, "<set-?>");
    paramb.agNJ = this;
    AppMethodBeat.o(234857);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/ratio/RatioLayout$LayoutParams;", "Landroid/view/ViewGroup$LayoutParams;", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "width", "", "height", "(II)V", "source", "(Landroid/view/ViewGroup$LayoutParams;)V", "layoutInfo", "Lcom/tencent/mm/view/ratio/RatioLayout$LayoutInfo;", "getLayoutInfo", "()Lcom/tencent/mm/view/ratio/RatioLayout$LayoutInfo;", "setLayoutInfo", "(Lcom/tencent/mm/view/ratio/RatioLayout$LayoutInfo;)V", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class LayoutParams
    extends ViewGroup.LayoutParams
  {
    RatioLayout.a agNI;
    
    public LayoutParams(int paramInt)
    {
      super(paramInt);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(234830);
      AppMethodBeat.o(234830);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super(paramLayoutParams.height);
      AppMethodBeat.i(234839);
      AppMethodBeat.o(234839);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/ratio/RatioLayout$LayoutInfo;", "", "xRatio", "", "yRatio", "wRatio", "hRatio", "(FFFF)V", "getHRatio", "()F", "setHRatio", "(F)V", "getWRatio", "setWRatio", "getXRatio", "setXRatio", "getYRatio", "setYRatio", "toString", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    float agNE;
    float agNF;
    float agNG;
    float agNH;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.agNE = paramFloat1;
      this.agNF = paramFloat2;
      this.agNG = paramFloat3;
      this.agNH = paramFloat4;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(234833);
      String str = "x:" + this.agNE + ", y:" + this.agNF + ", w:" + this.agNG + ", h:" + this.agNH;
      AppMethodBeat.o(234833);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.ratio.RatioLayout
 * JD-Core Version:    0.7.0.1
 */