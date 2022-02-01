package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.iv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

public class BankRemitSortView
  extends BaseSortView
{
  private final String TAG = "MicroMsg.BankcardSortView";
  private ListView szs;
  
  public BankRemitSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(String paramString, d paramd)
  {
    return false;
  }
  
  public final View eI()
  {
    AppMethodBeat.i(67612);
    View localView = View.inflate(getContext(), a.g.bank_remit_sort_view, this);
    AppMethodBeat.o(67612);
    return localView;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(67615);
    c.a local1 = new c.a()
    {
      public final View a(d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(67611);
        Object localObject = BankRemitSortView.this.getContext();
        View localView = paramAnonymousView;
        if (paramAnonymousView == null)
        {
          localView = LayoutInflater.from((Context)localObject).inflate(a.g.bank_remit_sort_item, null);
          paramAnonymousView = new BankRemitSortView.a(BankRemitSortView.this, (byte)0);
          paramAnonymousView.IiH = ((TextView)localView.findViewById(a.f.catalogTV));
          paramAnonymousView.Igl = ((TextView)localView.findViewById(a.f.brsb_item_title));
          paramAnonymousView.Igj = ((CdnImageView)localView.findViewById(a.f.brsb_item_icon));
          localView.setTag(paramAnonymousView);
        }
        paramAnonymousView = (BankRemitSortView.a)localView.getTag();
        localObject = (iv)paramAnonymousd.bnW;
        if (localObject != null) {
          if ((BankRemitSortView.this.Wtj) && (paramAnonymousBoolean1)) {
            if (paramAnonymousd.Wtr.equals("☆"))
            {
              paramAnonymousView.IiH.setText(a.i.bank_remit_select_bank_freq_bank_title);
              paramAnonymousView.IiH.setVisibility(0);
              label167:
              paramAnonymousView.Igj.setUseSdcardCache(true);
              paramAnonymousView.Igj.nr(((iv)localObject).IfQ, b.aUH(((iv)localObject).IfQ));
              paramAnonymousView.Igl.setText(((iv)localObject).DNV);
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(67611);
          return localView;
          paramAnonymousView.IiH.setText(paramAnonymousd.Wtr);
          break;
          paramAnonymousView.IiH.setVisibility(8);
          break label167;
          Log.w("MicroMsg.BankcardSortView", "elem is null: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
      }
    };
    AppMethodBeat.o(67615);
    return local1;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(67614);
    this.szs = ((ListView)findViewById(a.f.listview));
    ListView localListView = this.szs;
    AppMethodBeat.o(67614);
    return localListView;
  }
  
  public View getNoResultView()
  {
    return null;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(67613);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(a.f.sidrbar);
    AppMethodBeat.o(67613);
    return localVerticalScrollBar;
  }
  
  final class a
  {
    CdnImageView Igj;
    TextView Igl;
    TextView IiH;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSortView
 * JD-Core Version:    0.7.0.1
 */