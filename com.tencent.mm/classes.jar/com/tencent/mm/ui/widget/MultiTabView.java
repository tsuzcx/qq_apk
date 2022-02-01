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
  private List<View> HAS;
  private View HAT;
  private GridLayout HAU;
  private CustomViewPager HAV;
  private o HAW;
  private a HAX;
  private int boX;
  private q rO;
  
  public MultiTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MultiTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164227);
    this.HAS = new ArrayList();
    this.HAW = new o(this);
    this.boX = -1;
    this.HAU = new GridLayout(getContext());
    this.HAU.setRowCount(1);
    setOrientation(1);
    this.HAV = new CustomViewPager(getContext());
    this.rO = new d(getContext())
    {
      public final void Ib(int paramAnonymousInt) {}
      
      public final View a(View paramAnonymousView, ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(164223);
        paramAnonymousView = (View)MultiTabView.a(MultiTabView.this).get(paramAnonymousInt);
        AppMethodBeat.o(164223);
        return paramAnonymousView;
      }
      
      public final int cVP()
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
    this.HAV.setAdapter(this.rO);
    this.HAV.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
    addView(this.HAU, new LinearLayout.LayoutParams(-1, -2));
    addView(this.HAV, new LinearLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(164227);
  }
  
  private void aar(int paramInt)
  {
    AppMethodBeat.i(164231);
    ViewGroup.LayoutParams localLayoutParams = this.HAV.getLayoutParams();
    if (localLayoutParams.height == -2) {}
    for (localLayoutParams.height = (this.HAV.getHeight() + paramInt);; localLayoutParams.height += paramInt)
    {
      this.HAV.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(164231);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(164232);
    if (this.HAT != null)
    {
      Rect localRect = new Rect();
      this.HAT.getLocalVisibleRect(localRect);
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
        aar(paramArrayOfInt[1]);
        scrollBy(0, paramArrayOfInt[1]);
      }
      if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1)) && (localRect.top != 0))
      {
        ad.d("MicroMsg.MultiTabView", "scrollDown topBar, dy %d topBar visible rect %s", new Object[] { Integer.valueOf(paramInt2), localRect });
        paramArrayOfInt[1] = Math.max(paramInt2, -Math.abs(localRect.top));
        aar(paramArrayOfInt[1]);
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
    this.HAW.Nd = paramInt1;
  }
  
  public int getSelectedIndex()
  {
    return this.boX;
  }
  
  public final void j(View paramView, int paramInt)
  {
    this.HAW.Nd = 0;
  }
  
  public void setTabListener(a parama)
  {
    this.HAX = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MultiTabView
 * JD-Core Version:    0.7.0.1
 */