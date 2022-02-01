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
import com.tencent.mm.sdk.platformtools.ac;

public class MMLoadMoreListView
  extends ListView
{
  private a Hyd;
  private boolean Hye;
  private boolean Hyf;
  private TextView Hyg;
  private View pfa;
  
  public MMLoadMoreListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142039);
    this.pfa = null;
    this.Hyd = null;
    this.Hye = false;
    this.Hyf = false;
    init();
    AppMethodBeat.o(142039);
  }
  
  public MMLoadMoreListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142040);
    this.pfa = null;
    this.Hyd = null;
    this.Hye = false;
    this.Hyf = false;
    init();
    AppMethodBeat.o(142040);
  }
  
  private void fiu()
  {
    AppMethodBeat.i(142041);
    this.pfa = View.inflate(getContext(), 2131494788, null);
    this.Hyg = ((TextView)this.pfa.findViewById(2131300212));
    this.pfa.setVisibility(8);
    AppMethodBeat.o(142041);
  }
  
  private void init()
  {
    AppMethodBeat.i(142042);
    if (this.pfa == null)
    {
      fiu();
      addFooterView(this.pfa);
      this.pfa.setVisibility(8);
    }
    AppMethodBeat.o(142042);
  }
  
  public final void fiv()
  {
    AppMethodBeat.i(142043);
    if (this.pfa == null) {
      fiu();
    }
    try
    {
      removeFooterView(this.pfa);
      addFooterView(this.pfa);
      AppMethodBeat.o(142043);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(142043);
    }
  }
  
  public final void fiw()
  {
    AppMethodBeat.i(142044);
    this.Hye = true;
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
          ac.d("MMLoadMoreListView", "newpoi scroll2Top %s", new Object[] { MMLoadMoreListView.b(MMLoadMoreListView.this) });
          AppMethodBeat.o(142038);
          return;
          MMLoadMoreListView.a(MMLoadMoreListView.this, false);
        }
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(142037);
        if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (MMLoadMoreListView.a(MMLoadMoreListView.this) != null)) {
          MMLoadMoreListView.a(MMLoadMoreListView.this).Xa();
        }
        AppMethodBeat.o(142037);
      }
    });
    AppMethodBeat.o(142044);
  }
  
  public final void fix()
  {
    AppMethodBeat.i(142048);
    if (this.pfa != null)
    {
      this.Hyg.setVisibility(8);
      this.pfa.setVisibility(8);
    }
    AppMethodBeat.o(142048);
  }
  
  public final void fiy()
  {
    AppMethodBeat.i(142049);
    if (this.pfa.getParent() == null) {
      fiv();
    }
    this.Hyg.setVisibility(0);
    this.pfa.setVisibility(0);
    AppMethodBeat.o(142049);
  }
  
  public final void fiz()
  {
    AppMethodBeat.i(142050);
    removeFooterView(this.pfa);
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
    this.Hyg.setText(paramString);
    AppMethodBeat.o(142047);
  }
  
  public void setOnFootrClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(142046);
    this.Hyg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(142046);
  }
  
  public void setOnLoadMoreListener(a parama)
  {
    this.Hyd = parama;
  }
  
  public static abstract interface a
  {
    public abstract void Xa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMLoadMoreListView
 * JD-Core Version:    0.7.0.1
 */