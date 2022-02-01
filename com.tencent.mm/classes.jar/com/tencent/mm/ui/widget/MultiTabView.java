package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.CustomViewPager;
import java.util.ArrayList;
import java.util.List;

public class MultiTabView
  extends LinearLayout
  implements n
{
  private List<View> QEd;
  private View QEe;
  private GridLayout QEf;
  private a QEg;
  private int bxP;
  private q uP;
  private o wqs;
  private CustomViewPager xYa;
  
  public MultiTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MultiTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164227);
    this.QEd = new ArrayList();
    this.wqs = new o(this);
    this.bxP = -1;
    this.QEf = new GridLayout(getContext());
    this.QEf.setRowCount(1);
    setOrientation(1);
    this.xYa = new CustomViewPager(getContext());
    this.uP = new MultiTabView.1(this, getContext());
    this.xYa.setAdapter(this.uP);
    this.xYa.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(164226);
        if (paramAnonymousInt != MultiTabView.b(MultiTabView.this))
        {
          if (MultiTabView.c(MultiTabView.this) != null) {
            MultiTabView.c(MultiTabView.this);
          }
          MultiTabView.a(MultiTabView.this, paramAnonymousInt);
        }
        AppMethodBeat.o(164226);
      }
    });
    addView(this.QEf, new LinearLayout.LayoutParams(-1, -2));
    addView(this.xYa, new LinearLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(164227);
  }
  
  private void aov(int paramInt)
  {
    AppMethodBeat.i(164231);
    ViewGroup.LayoutParams localLayoutParams = this.xYa.getLayoutParams();
    if (localLayoutParams.height == -2) {}
    for (localLayoutParams.height = (this.xYa.getHeight() + paramInt);; localLayoutParams.height += paramInt)
    {
      this.xYa.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(164231);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(164232);
    if (this.QEe != null)
    {
      Rect localRect = new Rect();
      this.QEe.getLocalVisibleRect(localRect);
      if (Math.abs(paramInt1) - Math.abs(paramInt2) > 0)
      {
        paramArrayOfInt[1] = paramInt2;
        AppMethodBeat.o(164232);
        return;
      }
      if ((paramInt2 > 0) && (!paramView.canScrollVertically(-1)) && (localRect.bottom > 0))
      {
        Log.d("MicroMsg.MultiTabView", "scrollUp topBar, dy %d topBar visible rect %s", new Object[] { Integer.valueOf(paramInt2), localRect });
        paramArrayOfInt[1] = Math.min(paramInt2, localRect.height());
        aov(paramArrayOfInt[1]);
        scrollBy(0, paramArrayOfInt[1]);
      }
      if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1)) && (localRect.top != 0))
      {
        Log.d("MicroMsg.MultiTabView", "scrollDown topBar, dy %d topBar visible rect %s", new Object[] { Integer.valueOf(paramInt2), localRect });
        paramArrayOfInt[1] = Math.max(paramInt2, -Math.abs(localRect.top));
        aov(paramArrayOfInt[1]);
        scrollBy(0, paramArrayOfInt[1]);
      }
    }
    AppMethodBeat.o(164232);
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    this.wqs.Qb = paramInt1;
  }
  
  public int getSelectedIndex()
  {
    return this.bxP;
  }
  
  public final void k(View paramView, int paramInt)
  {
    this.wqs.Qb = 0;
  }
  
  public void setTabListener(a parama)
  {
    this.QEg = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MultiTabView
 * JD-Core Version:    0.7.0.1
 */