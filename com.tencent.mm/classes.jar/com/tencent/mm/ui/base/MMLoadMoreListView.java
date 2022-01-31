package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMLoadMoreListView
  extends ListView
{
  private View llk;
  private a zkR;
  private boolean zkS;
  private TextView zkT;
  private boolean zkU;
  
  public MMLoadMoreListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106688);
    this.llk = null;
    this.zkR = null;
    this.zkS = false;
    this.zkU = false;
    init();
    AppMethodBeat.o(106688);
  }
  
  public MMLoadMoreListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106689);
    this.llk = null;
    this.zkR = null;
    this.zkS = false;
    this.zkU = false;
    init();
    AppMethodBeat.o(106689);
  }
  
  private void dDW()
  {
    AppMethodBeat.i(106690);
    this.llk = View.inflate(getContext(), 2130970164, null);
    this.zkT = ((TextView)this.llk.findViewById(2131826176));
    this.llk.setVisibility(8);
    AppMethodBeat.o(106690);
  }
  
  private void init()
  {
    AppMethodBeat.i(106691);
    if (this.llk == null)
    {
      dDW();
      addFooterView(this.llk);
      this.llk.setVisibility(8);
    }
    AppMethodBeat.o(106691);
  }
  
  public final void dDX()
  {
    AppMethodBeat.i(106692);
    if (this.llk == null) {
      dDW();
    }
    try
    {
      removeFooterView(this.llk);
      addFooterView(this.llk);
      AppMethodBeat.o(106692);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(106692);
    }
  }
  
  public final void dDY()
  {
    AppMethodBeat.i(106693);
    this.zkS = true;
    setOnScrollListener(new MMLoadMoreListView.1(this));
    AppMethodBeat.o(106693);
  }
  
  public final void dDZ()
  {
    AppMethodBeat.i(106696);
    if (this.llk != null)
    {
      this.zkT.setVisibility(8);
      this.llk.setVisibility(8);
    }
    AppMethodBeat.o(106696);
  }
  
  public final void dEa()
  {
    AppMethodBeat.i(106697);
    if (this.llk.getParent() == null) {
      dDX();
    }
    this.zkT.setVisibility(0);
    this.llk.setVisibility(0);
    AppMethodBeat.o(106697);
  }
  
  public final void dEb()
  {
    AppMethodBeat.i(106698);
    removeFooterView(this.llk);
    AppMethodBeat.o(106698);
  }
  
  public boolean getScroll2Top()
  {
    return this.zkU;
  }
  
  public void setFooterTips(String paramString)
  {
    AppMethodBeat.i(106695);
    this.zkT.setText(paramString);
    AppMethodBeat.o(106695);
  }
  
  public void setOnFootrClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(106694);
    this.zkT.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(106694);
  }
  
  public void setOnLoadMoreListener(a parama)
  {
    this.zkR = parama;
  }
  
  public static abstract interface a
  {
    public abstract void Kt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMLoadMoreListView
 * JD-Core Version:    0.7.0.1
 */