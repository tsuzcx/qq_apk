package com.tencent.mm.plugin.whatsnew.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.b;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/whatsnew/ui/LegacyCircleIndicator;", "Landroid/view/View;", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapterCount", "dotSize", "dotSpacing", "dotsCount", "normalColor", "paint", "Landroid/graphics/Paint;", "scrollPosition", "scrollRatio", "", "value", "selected", "setSelected", "(I)V", "selectedColor", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "ratio", "pixels", "onPageSelected", "setupViewPager", "viewPager", "Lcom/tencent/mm/ui/mogic/WxViewPager;", "app_release"})
public final class LegacyCircleIndicator
  extends View
  implements ViewPager.OnPageChangeListener
{
  private int JOY;
  private int JOZ;
  private final int JPa;
  private final int JPb;
  private int UZ;
  private final int ddP;
  private final Paint paint;
  private final int ruC;
  private int selected;
  private float zRB;
  
  public LegacyCircleIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public LegacyCircleIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(230967);
    this.paint = new Paint(1);
    this.ruC = b.n(paramContext, 2131099678);
    this.ddP = b.n(paramContext, 2131099676);
    this.JPa = a.fromDPToPix(paramContext, 6);
    this.JPb = a.fromDPToPix(paramContext, 8);
    AppMethodBeat.o(230967);
  }
  
  private final void setSelected(int paramInt)
  {
    AppMethodBeat.i(230961);
    this.selected = Math.min(this.JOY - 1, paramInt);
    invalidate();
    AppMethodBeat.o(230961);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(230966);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Iterator localIterator = ((Iterable)j.mY(0, this.JOY)).iterator();
    if (localIterator.hasNext())
    {
      int i = ((ab)localIterator).nextInt();
      if (i == this.selected) {
        this.paint.setColor(this.ruC);
      }
      for (;;)
      {
        paramCanvas.drawCircle(i * (this.JPa + this.JPb) + this.JPa / 2.0F, this.JPa / 2.0F, this.JPa / 2.0F, this.paint);
        break;
        this.paint.setColor(this.ddP);
      }
    }
    AppMethodBeat.o(230966);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230965);
    paramInt1 = 0;
    paramInt2 = this.JPa;
    if (this.JOY > 0) {
      paramInt1 = this.JPa * this.JOY + this.JPb * (this.JOY - 1);
    }
    setMeasuredDimension(paramInt1, paramInt2);
    AppMethodBeat.o(230965);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(230964);
    if (paramInt == 2) {
      if (this.zRB >= 0.5F) {
        break label36;
      }
    }
    label36:
    for (paramInt = this.UZ;; paramInt = this.UZ + 1)
    {
      setSelected(paramInt);
      AppMethodBeat.o(230964);
      return;
    }
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.UZ = paramInt1;
    this.zRB = paramFloat;
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(230963);
    setSelected(paramInt);
    this.UZ = paramInt;
    this.zRB = 0.0F;
    AppMethodBeat.o(230963);
  }
  
  public final void setupViewPager(WxViewPager paramWxViewPager)
  {
    AppMethodBeat.i(230962);
    p.h(paramWxViewPager, "viewPager");
    q localq = paramWxViewPager.getAdapter();
    if (localq == null)
    {
      paramWxViewPager = (Throwable)new IllegalStateException("adapter of viewPager is null".toString());
      AppMethodBeat.o(230962);
      throw paramWxViewPager;
    }
    this.JOZ = localq.getCount();
    this.JOY = (localq.getCount() - 1);
    setSelected(Math.max(paramWxViewPager.getCurrentItem(), 0));
    requestLayout();
    AppMethodBeat.o(230962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.whatsnew.ui.LegacyCircleIndicator
 * JD-Core Version:    0.7.0.1
 */