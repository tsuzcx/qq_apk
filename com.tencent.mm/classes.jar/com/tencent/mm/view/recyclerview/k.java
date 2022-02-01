package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.view.View;
import androidx.core.content.a;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/VerticalItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "dividerType", "Lcom/tencent/mm/view/recyclerview/ImeDividerType;", "dividerColors", "", "backgroundPaint", "Landroid/graphics/Paint;", "dividerHeight", "", "mRightMarginSpan", "mLeftMarginSpan", "(Lcom/tencent/mm/view/recyclerview/ImeDividerType;[ILandroid/graphics/Paint;III)V", "getMLeftMarginSpan", "()I", "getMRightMarginSpan", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "Builder", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends RecyclerView.h
{
  private final e agOl;
  private final int[] agOm;
  private final int agOn;
  private final int agOo;
  private final int lCp;
  private final Paint lDC;
  
  public k(e parame, int[] paramArrayOfInt, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(234926);
    this.agOl = parame;
    this.agOm = paramArrayOfInt;
    this.lDC = paramPaint;
    this.lCp = paramInt1;
    this.agOn = paramInt2;
    this.agOo = paramInt3;
    AppMethodBeat.o(234926);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(234932);
    s.u(paramCanvas, "c");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    super.a(paramCanvas, paramRecyclerView, params);
    int k = paramRecyclerView.getChildCount();
    int m = paramRecyclerView.getPaddingLeft();
    int n = m + this.agOo;
    int i1 = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight() - this.agOn;
    int i = 0;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      params = paramRecyclerView.getChildAt(i);
      float f1 = params.getBottom();
      float f2 = params.getBottom() + this.lCp;
      if (i == k - 1) {
        paramCanvas.drawRect(m, f1, i1, f2, this.lDC);
      }
      while (j >= k)
      {
        AppMethodBeat.o(234932);
        return;
        params = this.agOl;
        switch (b.$EnumSwitchMapping$0[params.ordinal()])
        {
        default: 
          break;
        case 1: 
          params = new Paint();
          params.setColor(this.agOm[0]);
          paramCanvas.drawRect(n, f1, i1, f2, params);
          break;
        case 2: 
          params = new Paint();
          float f3 = n;
          float f4 = i1;
          int[] arrayOfInt = this.agOm;
          Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
          params.setShader((Shader)new LinearGradient(f3, 0.0F, f4, 0.0F, arrayOfInt, new float[] { 0.0F, 0.5F, 1.0F }, localTileMode));
          params.setAlpha(255);
          paramCanvas.drawRect(new RectF(n, f1, i1, f2), params);
        }
      }
      i = j;
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(234939);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramRect.bottom = this.lCp;
    AppMethodBeat.o(234939);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/VerticalItemDecoration$Builder;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBackgroundColor", "", "mDividerColors", "", "mDividerHeight", "mDividerType", "Lcom/tencent/mm/view/recyclerview/ImeDividerType;", "mLeftMarginSpan", "mResources", "Landroid/content/res/Resources;", "mRightMarginSpan", "build", "Lcom/tencent/mm/view/recyclerview/VerticalItemDecoration;", "setBackgroundColor", "resource", "setDividerColor", "setDividerHeight", "vertical", "setDividerLinearGradient", "dividerColor", "setDividerType", "dividerType", "setLeftMargin", "setLeftRightMargin", "setRightMargin", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public int agOn;
    public int agOo;
    private e agOp;
    private int[] agOq;
    private final Context mContext;
    public final Resources mResources;
    private int tR;
    private int uyB;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(234922);
      this.mContext = paramContext;
      paramContext = this.mContext.getResources();
      s.s(paramContext, "mContext.resources");
      this.mResources = paramContext;
      this.agOp = e.agNS;
      this.agOq = new int[1];
      this.agOn = 0;
      this.agOo = 0;
      this.tR = 0;
      this.agOq[0] = -1;
      this.uyB = -1;
      AppMethodBeat.o(234922);
    }
    
    public final a a(e parame)
    {
      AppMethodBeat.i(234927);
      s.u(parame, "dividerType");
      this.agOp = parame;
      AppMethodBeat.o(234927);
      return this;
    }
    
    public final a aGh(int paramInt)
    {
      AppMethodBeat.i(234930);
      this.tR = this.mResources.getDimensionPixelSize(paramInt);
      AppMethodBeat.o(234930);
      return this;
    }
    
    public final a aGi(int paramInt)
    {
      AppMethodBeat.i(234933);
      this.agOq[0] = a.w(this.mContext, paramInt);
      AppMethodBeat.o(234933);
      return this;
    }
    
    public final a aGj(int paramInt)
    {
      AppMethodBeat.i(234944);
      this.uyB = a.w(this.mContext, paramInt);
      AppMethodBeat.o(234944);
      return this;
    }
    
    public final k jNn()
    {
      AppMethodBeat.i(234954);
      Object localObject = new Paint();
      ((Paint)localObject).setColor(this.uyB);
      localObject = new k(this.agOp, this.agOq, (Paint)localObject, this.tR, this.agOn, this.agOo);
      AppMethodBeat.o(234954);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.k
 * JD-Core Version:    0.7.0.1
 */