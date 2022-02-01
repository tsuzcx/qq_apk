package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.d;
import java.util.ArrayList;
import java.util.List;

public class MultiTabView
  extends LinearLayout
  implements n
{
  private o KSA;
  private a KSB;
  private List<View> KSw;
  private View KSx;
  private GridLayout KSy;
  private CustomViewPager KSz;
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
    this.KSw = new ArrayList();
    this.KSA = new o(this);
    this.bxN = -1;
    this.KSy = new GridLayout(getContext());
    this.KSy.setRowCount(1);
    setOrientation(1);
    this.KSz = new CustomViewPager(getContext());
    this.uI = new d(getContext())
    {
      public final void LC(int paramAnonymousInt) {}
      
      public final View a(View paramAnonymousView, ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(164223);
        paramAnonymousView = (View)MultiTabView.a(MultiTabView.this).get(paramAnonymousInt);
        AppMethodBeat.o(164223);
        return paramAnonymousView;
      }
      
      public final int dtJ()
      {
        AppMethodBeat.i(164224);
        int i = MultiTabView.a(MultiTabView.this).size();
        AppMethodBeat.o(164224);
        return i;
      }
      
      public final int getCount()
      {
        AppMethodBeat.i(164225);
        int i = MultiTabView.a(MultiTabView.this).size();
        AppMethodBeat.o(164225);
        return i;
      }
    };
    this.KSz.setAdapter(this.uI);
    this.KSz.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
    addView(this.KSy, new LinearLayout.LayoutParams(-1, -2));
    addView(this.KSz, new LinearLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(164227);
  }
  
  private void aeZ(int paramInt)
  {
    AppMethodBeat.i(164231);
    ViewGroup.LayoutParams localLayoutParams = this.KSz.getLayoutParams();
    if (localLayoutParams.height == -2) {}
    for (localLayoutParams.height = (this.KSz.getHeight() + paramInt);; localLayoutParams.height += paramInt)
    {
      this.KSz.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(164231);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(164232);
    if (this.KSx != null)
    {
      Rect localRect = new Rect();
      this.KSx.getLocalVisibleRect(localRect);
      if (Math.abs(paramInt1) - Math.abs(paramInt2) > 0)
      {
        paramArrayOfInt[1] = paramInt2;
        AppMethodBeat.o(164232);
        return;
      }
      if ((paramInt2 > 0) && (!paramView.canScrollVertically(-1)) && (localRect.bottom > 0))
      {
        ad.d("MicroMsg.MultiTabView", "scrollUp topBar, dy %d topBar visible rect %s", new Object[] { Integer.valueOf(paramInt2), localRect });
        paramArrayOfInt[1] = Math.min(paramInt2, localRect.height());
        aeZ(paramArrayOfInt[1]);
        scrollBy(0, paramArrayOfInt[1]);
      }
      if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1)) && (localRect.top != 0))
      {
        ad.d("MicroMsg.MultiTabView", "scrollDown topBar, dy %d topBar visible rect %s", new Object[] { Integer.valueOf(paramInt2), localRect });
        paramArrayOfInt[1] = Math.max(paramInt2, -Math.abs(localRect.top));
        aeZ(paramArrayOfInt[1]);
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
    this.KSA.PP = paramInt1;
  }
  
  public int getSelectedIndex()
  {
    return this.bxN;
  }
  
  public final void j(View paramView, int paramInt)
  {
    this.KSA.PP = 0;
  }
  
  public void setTabListener(a parama)
  {
    this.KSB = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MultiTabView
 * JD-Core Version:    0.7.0.1
 */