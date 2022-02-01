package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

public class BankRemitSortView
  extends BaseSortView
{
  private final String TAG = "MicroMsg.BankcardSortView";
  private ListView mVP;
  
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
          localView = LayoutInflater.from((Context)localObject).inflate(2131493166, null);
          paramAnonymousView = new BankRemitSortView.a(BankRemitSortView.this, (byte)0);
          paramAnonymousView.vxj = ((TextView)localView.findViewById(2131297925));
          paramAnonymousView.vuM = ((TextView)localView.findViewById(2131297564));
          paramAnonymousView.vuK = ((CdnImageView)localView.findViewById(2131297563));
          localView.setTag(paramAnonymousView);
        }
        paramAnonymousView = (BankRemitSortView.a)localView.getTag();
        localObject = (ig)paramAnonymousd.data;
        if (localObject != null) {
          if ((BankRemitSortView.this.Ggu) && (paramAnonymousBoolean1)) {
            if (paramAnonymousd.GgC.equals("☆"))
            {
              paramAnonymousView.vxj.setText(2131756396);
              paramAnonymousView.vxj.setVisibility(0);
              label162:
              paramAnonymousView.vuK.setUseSdcardCache(true);
              paramAnonymousView.vuK.kC(((ig)localObject).vur, b.akx(((ig)localObject).vur));
              paramAnonymousView.vuM.setText(((ig)localObject).szi);
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(67611);
          return localView;
          paramAnonymousView.vxj.setText(paramAnonymousd.GgC);
          break;
          paramAnonymousView.vxj.setVisibility(8);
          break label162;
          ad.w("MicroMsg.BankcardSortView", "elem is null: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
      }
    };
    AppMethodBeat.o(67615);
    return local1;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(67614);
    this.mVP = ((ListView)findViewById(2131301457));
    ListView localListView = this.mVP;
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
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(2131304800);
    AppMethodBeat.o(67613);
    return localVerticalScrollBar;
  }
  
  public final View inflate()
  {
    AppMethodBeat.i(67612);
    View localView = View.inflate(getContext(), 2131493167, this);
    AppMethodBeat.o(67612);
    return localView;
  }
  
  final class a
  {
    CdnImageView vuK;
    TextView vuM;
    TextView vxj;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSortView
 * JD-Core Version:    0.7.0.1
 */