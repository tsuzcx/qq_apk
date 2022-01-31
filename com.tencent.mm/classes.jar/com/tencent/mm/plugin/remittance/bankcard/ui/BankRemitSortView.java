package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

public class BankRemitSortView
  extends BaseSortView
{
  private final String TAG = "MicroMsg.BankcardSortView";
  private ListView jVf;
  
  public BankRemitSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(String paramString, d paramd)
  {
    return false;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(44702);
    BankRemitSortView.1 local1 = new BankRemitSortView.1(this);
    AppMethodBeat.o(44702);
    return local1;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(44701);
    this.jVf = ((ListView)findViewById(2131821736));
    ListView localListView = this.jVf;
    AppMethodBeat.o(44701);
    return localListView;
  }
  
  public View getNoResultView()
  {
    return null;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(44700);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(2131821737);
    AppMethodBeat.o(44700);
    return localVerticalScrollBar;
  }
  
  public final View inflate()
  {
    AppMethodBeat.i(44699);
    View localView = View.inflate(getContext(), 2130968835, this);
    AppMethodBeat.o(44699);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSortView
 * JD-Core Version:    0.7.0.1
 */