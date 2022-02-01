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
  private a WkL;
  private boolean WkM;
  private boolean WkN;
  private View uIP;
  private TextView ynb;
  
  public MMLoadMoreListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142039);
    this.uIP = null;
    this.WkL = null;
    this.WkM = false;
    this.WkN = false;
    init();
    AppMethodBeat.o(142039);
  }
  
  public MMLoadMoreListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142040);
    this.uIP = null;
    this.WkL = null;
    this.WkM = false;
    this.WkN = false;
    init();
    AppMethodBeat.o(142040);
  }
  
  private void hJJ()
  {
    AppMethodBeat.i(142041);
    this.uIP = View.inflate(getContext(), a.h.mm_footerview, null);
    this.ynb = ((TextView)this.uIP.findViewById(a.g.footer_tips));
    this.uIP.setVisibility(8);
    AppMethodBeat.o(142041);
  }
  
  private void init()
  {
    AppMethodBeat.i(142042);
    if (this.uIP == null)
    {
      hJJ();
      addFooterView(this.uIP);
      this.uIP.setVisibility(8);
    }
    AppMethodBeat.o(142042);
  }
  
  public final void cnx()
  {
    AppMethodBeat.i(142043);
    if (this.uIP == null) {
      hJJ();
    }
    try
    {
      removeFooterView(this.uIP);
      addFooterView(this.uIP);
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
  
  public final void hJK()
  {
    AppMethodBeat.i(142044);
    this.WkM = true;
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
  
  public final void hJL()
  {
    AppMethodBeat.i(142048);
    if (this.uIP != null)
    {
      this.ynb.setVisibility(8);
      this.uIP.setVisibility(8);
    }
    AppMethodBeat.o(142048);
  }
  
  public final void hJM()
  {
    AppMethodBeat.i(142049);
    if (this.uIP.getParent() == null) {
      cnx();
    }
    this.ynb.setVisibility(0);
    this.uIP.setVisibility(0);
    AppMethodBeat.o(142049);
  }
  
  public final void hJN()
  {
    AppMethodBeat.i(142050);
    removeFooterView(this.uIP);
    AppMethodBeat.o(142050);
  }
  
  public void setFooterTips(String paramString)
  {
    AppMethodBeat.i(142047);
    this.ynb.setText(paramString);
    AppMethodBeat.o(142047);
  }
  
  public void setOnFootrClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(142046);
    this.ynb.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(142046);
  }
  
  public void setOnLoadMoreListener(a parama)
  {
    this.WkL = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onLoadMore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMLoadMoreListView
 * JD-Core Version:    0.7.0.1
 */