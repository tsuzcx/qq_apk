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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.CustomViewPager;
import java.util.ArrayList;
import java.util.List;

public class MultiTabView
  extends LinearLayout
  implements n
{
  private List<View> LoU;
  private View LoV;
  private GridLayout LoW;
  private CustomViewPager LoX;
  private o LoY;
  private a LoZ;
  private int bxN;
  private q uI;
  
  public MultiTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MultiTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164227);
    this.LoU = new ArrayList();
    this.LoY = new o(this);
    this.bxN = -1;
    this.LoW = new GridLayout(getContext());
    this.LoW.setRowCount(1);
    setOrientation(1);
    this.LoX = new CustomViewPager(getContext());
    this.uI = new MultiTabView.1(this, getContext());
    this.LoX.setAdapter(this.uI);
    this.LoX.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
    addView(this.LoW, new LinearLayout.LayoutParams(-1, -2));
    addView(this.LoX, new LinearLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(164227);
  }
  
  private void afI(int paramInt)
  {
    AppMethodBeat.i(164231);
    ViewGroup.LayoutParams localLayoutParams = this.LoX.getLayoutParams();
    if (localLayoutParams.height == -2) {}
    for (localLayoutParams.height = (this.LoX.getHeight() + paramInt);; localLayoutParams.height += paramInt)
    {
      this.LoX.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(164231);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(164232);
    if (this.LoV != null)
    {
      Rect localRect = new Rect();
      this.LoV.getLocalVisibleRect(localRect);
      if (Math.abs(paramInt1) - Math.abs(paramInt2) > 0)
      {
        paramArrayOfInt[1] = paramInt2;
        AppMethodBeat.o(164232);
        return;
      }
      if ((paramInt2 > 0) && (!paramView.canScrollVertically(-1)) && (localRect.bottom > 0))
      {
        ae.d("MicroMsg.MultiTabView", "scrollUp topBar, dy %d topBar visible rect %s", new Object[] { Integer.valueOf(paramInt2), localRect });
        paramArrayOfInt[1] = Math.min(paramInt2, localRect.height());
        afI(paramArrayOfInt[1]);
        scrollBy(0, paramArrayOfInt[1]);
      }
      if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1)) && (localRect.top != 0))
      {
        ae.d("MicroMsg.MultiTabView", "scrollDown topBar, dy %d topBar visible rect %s", new Object[] { Integer.valueOf(paramInt2), localRect });
        paramArrayOfInt[1] = Math.max(paramInt2, -Math.abs(localRect.top));
        afI(paramArrayOfInt[1]);
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
    this.LoY.PP = paramInt1;
  }
  
  public int getSelectedIndex()
  {
    return this.bxN;
  }
  
  public final void j(View paramView, int paramInt)
  {
    this.LoY.PP = 0;
  }
  
  public void setTabListener(a parama)
  {
    this.LoZ = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MultiTabView
 * JD-Core Version:    0.7.0.1
 */