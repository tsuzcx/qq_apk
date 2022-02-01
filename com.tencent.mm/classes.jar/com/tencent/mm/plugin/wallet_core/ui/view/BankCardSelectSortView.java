package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

public class BankCardSelectSortView
  extends BaseSortView
{
  private ListView vEX;
  
  public BankCardSelectSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(String paramString, d paramd)
  {
    AppMethodBeat.i(71473);
    boolean bool = ((a)paramd.cpt).MEo.toUpperCase().contains(paramString.toUpperCase());
    AppMethodBeat.o(71473);
    return bool;
  }
  
  public final View fF()
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
      public final View createView(d paramAnonymousd, View paramAnonymousView, ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(301329);
        Object localObject = BankCardSelectSortView.this.getContext();
        paramAnonymousViewGroup = paramAnonymousView;
        if (paramAnonymousView == null)
        {
          paramAnonymousViewGroup = LayoutInflater.from((Context)localObject).inflate(a.g.bank_remit_sort_item, null);
          paramAnonymousViewGroup.setImportantForAccessibility(2);
          paramAnonymousView = new BankCardSelectSortView.b((byte)0);
          paramAnonymousView.Ofs = ((TextView)paramAnonymousViewGroup.findViewById(a.f.catalogTV));
          paramAnonymousView.OcK = ((TextView)paramAnonymousViewGroup.findViewById(a.f.brsb_item_title));
          paramAnonymousView.OcI = ((CdnImageView)paramAnonymousViewGroup.findViewById(a.f.brsb_item_icon));
          paramAnonymousViewGroup.setTag(paramAnonymousView);
        }
        paramAnonymousView = (BankCardSelectSortView.b)paramAnonymousViewGroup.getTag();
        localObject = BankCardSelectSortView.this;
        if ((((BaseSortView)localObject).aeaD) && (paramAnonymousBoolean1))
        {
          paramAnonymousView.Ofs.setText(paramAnonymousd.aeaK);
          paramAnonymousView.Ofs.setContentDescription(((BankCardSelectSortView)localObject).getContext().getString(a.i.wallet_bankcard_select_title_accessibility, new Object[] { paramAnonymousd.aeaK }));
          paramAnonymousView.Ofs.setVisibility(0);
          paramAnonymousd = (BankCardSelectSortView.a)paramAnonymousd.cpt;
          paramAnonymousView.OcK.setText(paramAnonymousd.MEo);
          if (Util.isNullOrNil(paramAnonymousd.icon)) {
            break label240;
          }
          paramAnonymousView.OcI.setUseSdcardCache(true);
          paramAnonymousView.OcI.pm(paramAnonymousd.icon, paramAnonymousd.VVL);
        }
        for (;;)
        {
          AppMethodBeat.o(301329);
          return paramAnonymousViewGroup;
          paramAnonymousView.Ofs.setVisibility(8);
          break;
          label240:
          paramAnonymousView.OcI.setImageBitmap(null);
        }
      }
    };
    AppMethodBeat.o(71474);
    return local1;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(71471);
    this.vEX = ((ListView)findViewById(a.f.listview));
    ListView localListView = this.vEX;
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
    public String MEo;
    public String VVL;
    public String icon;
    public String pinyin;
  }
  
  static final class b
  {
    CdnImageView OcI;
    TextView OcK;
    TextView Ofs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView
 * JD-Core Version:    0.7.0.1
 */