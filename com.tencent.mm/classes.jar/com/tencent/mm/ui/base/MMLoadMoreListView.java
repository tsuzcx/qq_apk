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
import com.tencent.mm.sdk.platformtools.ae;

public class MMLoadMoreListView
  extends ListView
{
  private a JGH;
  private boolean JGI;
  private boolean JGJ;
  private TextView JGK;
  private View pPh;
  
  public MMLoadMoreListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142039);
    this.pPh = null;
    this.JGH = null;
    this.JGI = false;
    this.JGJ = false;
    init();
    AppMethodBeat.o(142039);
  }
  
  public MMLoadMoreListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142040);
    this.pPh = null;
    this.JGH = null;
    this.JGI = false;
    this.JGJ = false;
    init();
    AppMethodBeat.o(142040);
  }
  
  private void fCL()
  {
    AppMethodBeat.i(142041);
    this.pPh = View.inflate(getContext(), 2131494788, null);
    this.JGK = ((TextView)this.pPh.findViewById(2131300212));
    this.pPh.setVisibility(8);
    AppMethodBeat.o(142041);
  }
  
  private void init()
  {
    AppMethodBeat.i(142042);
    if (this.pPh == null)
    {
      fCL();
      addFooterView(this.pPh);
      this.pPh.setVisibility(8);
    }
    AppMethodBeat.o(142042);
  }
  
  public final void fCM()
  {
    AppMethodBeat.i(142043);
    if (this.pPh == null) {
      fCL();
    }
    try
    {
      removeFooterView(this.pPh);
      addFooterView(this.pPh);
      AppMethodBeat.o(142043);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(142043);
    }
  }
  
  public final void fCN()
  {
    AppMethodBeat.i(142044);
    this.JGI = true;
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
          ae.d("MMLoadMoreListView", "newpoi scroll2Top %s", new Object[] { MMLoadMoreListView.b(MMLoadMoreListView.this) });
          AppMethodBeat.o(142038);
          return;
          MMLoadMoreListView.a(MMLoadMoreListView.this, false);
        }
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(142037);
        if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (MMLoadMoreListView.a(MMLoadMoreListView.this) != null)) {
          MMLoadMoreListView.a(MMLoadMoreListView.this).ZC();
        }
        AppMethodBeat.o(142037);
      }
    });
    AppMethodBeat.o(142044);
  }
  
  public final void fCO()
  {
    AppMethodBeat.i(142048);
    if (this.pPh != null)
    {
      this.JGK.setVisibility(8);
      this.pPh.setVisibility(8);
    }
    AppMethodBeat.o(142048);
  }
  
  public final void fCP()
  {
    AppMethodBeat.i(142049);
    if (this.pPh.getParent() == null) {
      fCM();
    }
    this.JGK.setVisibility(0);
    this.pPh.setVisibility(0);
    AppMethodBeat.o(142049);
  }
  
  public final void fCQ()
  {
    AppMethodBeat.i(142050);
    removeFooterView(this.pPh);
    AppMethodBeat.o(142050);
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
  
  public void setFooterTips(String paramString)
  {
    AppMethodBeat.i(142047);
    this.JGK.setText(paramString);
    AppMethodBeat.o(142047);
  }
  
  public void setOnFootrClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(142046);
    this.JGK.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(142046);
  }
  
  public void setOnLoadMoreListener(a parama)
  {
    this.JGH = parama;
  }
  
  public static abstract interface a
  {
    public abstract void ZC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMLoadMoreListView
 * JD-Core Version:    0.7.0.1
 */