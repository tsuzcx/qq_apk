package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

public class BankCardSelectSortView
  extends BaseSortView
{
  private ListView szs;
  
  public BankCardSelectSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(String paramString, d paramd)
  {
    AppMethodBeat.i(71473);
    boolean bool = ((a)paramd.bnW).GHx.toUpperCase().contains(paramString.toUpperCase());
    AppMethodBeat.o(71473);
    return bool;
  }
  
  public final View eI()
  {
    AppMethodBeat.i(71469);
    View localView = View.inflate(getContext(), a.g.bank_remit_sort_view, this);
    AppMethodBeat.o(71469);
    return localView;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(71474);
    c.a local1 = new c.a()
    {
      public final View a(d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(71468);
        Context localContext = BankCardSelectSortView.this.getContext();
        View localView = paramAnonymousView;
        if (paramAnonymousView == null)
        {
          localView = LayoutInflater.from(localContext).inflate(a.g.bank_remit_sort_item, null);
          paramAnonymousView = new BankCardSelectSortView.b((byte)0);
          paramAnonymousView.IiH = ((TextView)localView.findViewById(a.f.catalogTV));
          paramAnonymousView.Igl = ((TextView)localView.findViewById(a.f.brsb_item_title));
          paramAnonymousView.Igj = ((CdnImageView)localView.findViewById(a.f.brsb_item_icon));
          localView.setTag(paramAnonymousView);
        }
        paramAnonymousView = (BankCardSelectSortView.b)localView.getTag();
        if ((BankCardSelectSortView.this.Wtj) && (paramAnonymousBoolean1))
        {
          paramAnonymousView.IiH.setText(paramAnonymousd.Wtr);
          paramAnonymousView.IiH.setVisibility(0);
          paramAnonymousd = (BankCardSelectSortView.a)paramAnonymousd.bnW;
          paramAnonymousView.Igl.setText(paramAnonymousd.GHx);
          if (Util.isNullOrNil(paramAnonymousd.icon)) {
            break label210;
          }
          paramAnonymousView.Igj.setUseSdcardCache(true);
          paramAnonymousView.Igj.nr(paramAnonymousd.icon, paramAnonymousd.Pfd);
        }
        for (;;)
        {
          AppMethodBeat.o(71468);
          return localView;
          paramAnonymousView.IiH.setVisibility(8);
          break;
          label210:
          paramAnonymousView.Igj.setImageBitmap(null);
        }
      }
    };
    AppMethodBeat.o(71474);
    return local1;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(71471);
    this.szs = ((ListView)findViewById(a.f.listview));
    ListView localListView = this.szs;
    AppMethodBeat.o(71471);
    return localListView;
  }
  
  public View getNoResultView()
  {
    AppMethodBeat.i(71472);
    View localView = findViewById(a.f.bankcard_no_result_tv);
    AppMethodBeat.o(71472);
    return localView;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(71470);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(a.f.sidrbar);
    AppMethodBeat.o(71470);
    return localVerticalScrollBar;
  }
  
  public static final class a
  {
    public String GHx;
    public String Pfd;
    public String icon;
    public String pinyin;
  }
  
  static final class b
  {
    CdnImageView Igj;
    TextView Igl;
    TextView IiH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView
 * JD-Core Version:    0.7.0.1
 */