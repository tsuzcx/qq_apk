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
import com.tencent.mm.sdk.platformtools.Log;

public class MMLoadMoreListView
  extends ListView
{
  private boolean ORA;
  private boolean ORB;
  private a ORz;
  private View rfF;
  private TextView unG;
  
  public MMLoadMoreListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142039);
    this.rfF = null;
    this.ORz = null;
    this.ORA = false;
    this.ORB = false;
    init();
    AppMethodBeat.o(142039);
  }
  
  public MMLoadMoreListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142040);
    this.rfF = null;
    this.ORz = null;
    this.ORA = false;
    this.ORB = false;
    init();
    AppMethodBeat.o(142040);
  }
  
  private void gKK()
  {
    AppMethodBeat.i(142041);
    this.rfF = View.inflate(getContext(), 2131495522, null);
    this.unG = ((TextView)this.rfF.findViewById(2131301681));
    this.rfF.setVisibility(8);
    AppMethodBeat.o(142041);
  }
  
  private void init()
  {
    AppMethodBeat.i(142042);
    if (this.rfF == null)
    {
      gKK();
      addFooterView(this.rfF);
      this.rfF.setVisibility(8);
    }
    AppMethodBeat.o(142042);
  }
  
  public final void gKL()
  {
    AppMethodBeat.i(142043);
    if (this.rfF == null) {
      gKK();
    }
    try
    {
      removeFooterView(this.rfF);
      addFooterView(this.rfF);
      AppMethodBeat.o(142043);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(142043);
    }
  }
  
  public final void gKM()
  {
    AppMethodBeat.i(142044);
    this.ORA = true;
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
  
  public final void gKN()
  {
    AppMethodBeat.i(142048);
    if (this.rfF != null)
    {
      this.unG.setVisibility(8);
      this.rfF.setVisibility(8);
    }
    AppMethodBeat.o(142048);
  }
  
  public final void gKO()
  {
    AppMethodBeat.i(142049);
    if (this.rfF.getParent() == null) {
      gKL();
    }
    this.unG.setVisibility(0);
    this.rfF.setVisibility(0);
    AppMethodBeat.o(142049);
  }
  
  public final void gKP()
  {
    AppMethodBeat.i(142050);
    removeFooterView(this.rfF);
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
    this.unG.setText(paramString);
    AppMethodBeat.o(142047);
  }
  
  public void setOnFootrClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(142046);
    this.unG.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(142046);
  }
  
  public void setOnLoadMoreListener(a parama)
  {
    this.ORz = parama;
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