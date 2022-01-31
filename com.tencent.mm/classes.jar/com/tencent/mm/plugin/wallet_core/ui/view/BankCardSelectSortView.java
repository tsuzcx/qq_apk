package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

public class BankCardSelectSortView
  extends BaseSortView
{
  private ListView ier;
  
  public BankCardSelectSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(String paramString, d paramd)
  {
    return ((a)paramd.data).mOX.toUpperCase().contains(paramString.toUpperCase());
  }
  
  public c.a getItemViewCreator()
  {
    return new BankCardSelectSortView.1(this);
  }
  
  public ListView getListView()
  {
    this.ier = ((ListView)findViewById(a.f.listview));
    return this.ier;
  }
  
  public View getNoResultView()
  {
    return findViewById(a.f.bankcard_no_result_tv);
  }
  
  public VerticalScrollBar getScrollBar()
  {
    return (VerticalScrollBar)findViewById(a.f.sidrbar);
  }
  
  public final View inflate()
  {
    return View.inflate(getContext(), a.g.bank_remit_sort_view, this);
  }
  
  public static final class a
  {
    public String bVO;
    public String mOX;
    public String ndQ;
    public String qHC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView
 * JD-Core Version:    0.7.0.1
 */