package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.sdk.platformtools.Log;

public class MMLoadMoreListView
  extends ListView
{
  private TextView CVT;
  private a adRS;
  private boolean adRT;
  private boolean adRU;
  private View xRF;
  
  public MMLoadMoreListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142039);
    this.xRF = null;
    this.adRS = null;
    this.adRT = false;
    this.adRU = false;
    init();
    AppMethodBeat.o(142039);
  }
  
  public MMLoadMoreListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142040);
    this.xRF = null;
    this.adRS = null;
    this.adRT = false;
    this.adRU = false;
    init();
    AppMethodBeat.o(142040);
  }
  
  private void init()
  {
    AppMethodBeat.i(142042);
    if (this.xRF == null)
    {
      jmr();
      addFooterView(this.xRF);
      this.xRF.setVisibility(8);
    }
    AppMethodBeat.o(142042);
  }
  
  private void jmr()
  {
    AppMethodBeat.i(142041);
    this.xRF = View.inflate(getContext(), a.h.mm_footerview, null);
    this.CVT = ((TextView)this.xRF.findViewById(a.g.footer_tips));
    this.xRF.setVisibility(8);
    AppMethodBeat.o(142041);
  }
  
  public final void cPA()
  {
    AppMethodBeat.i(142043);
    if (this.xRF == null) {
      jmr();
    }
    try
    {
      removeFooterView(this.xRF);
      addFooterView(this.xRF);
      AppMethodBeat.o(142043);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(142043);
    }
  }
  
  public boolean getScroll2Top()
  {
    AppMethodBeat.i(142045);
    if ((getFirstVisiblePosition() == 0) && (getChildAt(0) != null) && (getChildAt(0).getTop() == getPaddingTop()))
    {
      AppMethodBeat.o(142045);
      return true;
    }
    AppMethodBeat.o(142045);
    return false;
  }
  
  public final void jms()
  {
    AppMethodBeat.i(142044);
    this.adRT = true;
    setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(142038);
        if ((paramAnonymousInt1 == 0) && (MMLoadMoreListView.this.getChildAt(0) != null) && (MMLoadMoreListView.this.getChildAt(0).getTop() == MMLoadMoreListView.this.getPaddingTop())) {
          MMLoadMoreListView.a(MMLoadMoreListView.this, true);
        }
        for (;;)
        {
          Log.d("MMLoadMoreListView", "newpoi scroll2Top %s", new Object[] { MMLoadMoreListView.b(MMLoadMoreListView.this) });
          AppMethodBeat.o(142038);
          return;
          MMLoadMoreListView.a(MMLoadMoreListView.this, false);
        }
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(142037);
        if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (MMLoadMoreListView.a(MMLoadMoreListView.this) != null)) {
          MMLoadMoreListView.a(MMLoadMoreListView.this).onLoadMore();
        }
        AppMethodBeat.o(142037);
      }
    });
    AppMethodBeat.o(142044);
  }
  
  public final void jmt()
  {
    AppMethodBeat.i(142048);
    if (this.xRF != null)
    {
      this.CVT.setVisibility(8);
      this.xRF.setVisibility(8);
    }
    AppMethodBeat.o(142048);
  }
  
  public final void jmu()
  {
    AppMethodBeat.i(142049);
    if (this.xRF.getParent() == null) {
      cPA();
    }
    this.CVT.setVisibility(0);
    this.xRF.setVisibility(0);
    AppMethodBeat.o(142049);
  }
  
  public final void jmv()
  {
    AppMethodBeat.i(142050);
    removeFooterView(this.xRF);
    AppMethodBeat.o(142050);
  }
  
  public void setFooterTips(String paramString)
  {
    AppMethodBeat.i(142047);
    this.CVT.setText(paramString);
    AppMethodBeat.o(142047);
  }
  
  public void setOnFootrClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(142046);
    this.CVT.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(142046);
  }
  
  public void setOnLoadMoreListener(a parama)
  {
    this.adRS = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onLoadMore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMLoadMoreListView
 * JD-Core Version:    0.7.0.1
 */