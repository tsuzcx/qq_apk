package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

public class BankRemitSortView
  extends BaseSortView
{
  private final String TAG = "MicroMsg.BankcardSortView";
  private ListView vEX;
  
  public BankRemitSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(String paramString, d paramd)
  {
    return false;
  }
  
  public final View fF()
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
      public final View createView(d paramAnonymousd, View paramAnonymousView, ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(288750);
        Object localObject = BankRemitSortView.this.getContext();
        paramAnonymousViewGroup = paramAnonymousView;
        if (paramAnonymousView == null)
        {
          paramAnonymousViewGroup = LayoutInflater.from((Context)localObject).inflate(a.g.bank_remit_sort_item, null);
          paramAnonymousView = new BankRemitSortView.a(BankRemitSortView.this, (byte)0);
          paramAnonymousView.Ofs = ((TextView)paramAnonymousViewGroup.findViewById(a.f.catalogTV));
          paramAnonymousView.OcK = ((TextView)paramAnonymousViewGroup.findViewById(a.f.brsb_item_title));
          paramAnonymousView.OcI = ((CdnImageView)paramAnonymousViewGroup.findViewById(a.f.brsb_item_icon));
          paramAnonymousViewGroup.setTag(paramAnonymousView);
        }
        paramAnonymousView = (BankRemitSortView.a)paramAnonymousViewGroup.getTag();
        localObject = (jr)paramAnonymousd.cpt;
        if (localObject != null) {
          if ((BankRemitSortView.this.aeaD) && (paramAnonymousBoolean1)) {
            if (paramAnonymousd.aeaK.equals("☆"))
            {
              paramAnonymousView.Ofs.setText(a.i.bank_remit_select_bank_freq_bank_title);
              paramAnonymousView.Ofs.setVisibility(0);
              label160:
              paramAnonymousView.OcI.setUseSdcardCache(true);
              paramAnonymousView.OcI.pm(((jr)localObject).Ocp, b.aRP(((jr)localObject).Ocp));
              paramAnonymousView.OcK.setText(((jr)localObject).JFk);
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(288750);
          return paramAnonymousViewGroup;
          paramAnonymousView.Ofs.setText(paramAnonymousd.aeaK);
          break;
          paramAnonymousView.Ofs.setVisibility(8);
          break label160;
          Log.w("MicroMsg.BankcardSortView", "elem is null: %s", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        }
      }
    };
    AppMethodBeat.o(67615);
    return local1;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(67614);
    this.vEX = ((ListView)findViewById(a.f.listview));
    ListView localListView = this.vEX;
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
    CdnImageView OcI;
    TextView OcK;
    TextView Ofs;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSortView
 * JD-Core Version:    0.7.0.1
 */