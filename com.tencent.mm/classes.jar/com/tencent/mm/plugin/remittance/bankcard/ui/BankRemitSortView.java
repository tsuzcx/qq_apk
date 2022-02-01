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
import com.tencent.mm.protocal.protobuf.jg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

public class BankRemitSortView
  extends BaseSortView
{
  private final String TAG = "MicroMsg.BankcardSortView";
  private ListView pqt;
  
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
          localView = LayoutInflater.from((Context)localObject).inflate(2131493212, null);
          paramAnonymousView = new BankRemitSortView.a(BankRemitSortView.this, (byte)0);
          paramAnonymousView.ClO = ((TextView)localView.findViewById(2131298244));
          paramAnonymousView.Cjs = ((TextView)localView.findViewById(2131297803));
          paramAnonymousView.Cjq = ((CdnImageView)localView.findViewById(2131297802));
          localView.setTag(paramAnonymousView);
        }
        paramAnonymousView = (BankRemitSortView.a)localView.getTag();
        localObject = (jg)paramAnonymousd.data;
        if (localObject != null) {
          if ((BankRemitSortView.this.OZW) && (paramAnonymousBoolean1)) {
            if (paramAnonymousd.Pae.equals("☆"))
            {
              paramAnonymousView.ClO.setText(2131756531);
              paramAnonymousView.ClO.setVisibility(0);
              label162:
              paramAnonymousView.Cjq.setUseSdcardCache(true);
              paramAnonymousView.Cjq.mB(((jg)localObject).CiX, b.aKj(((jg)localObject).CiX));
              paramAnonymousView.Cjs.setText(((jg)localObject).ynT);
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(67611);
          return localView;
          paramAnonymousView.ClO.setText(paramAnonymousd.Pae);
          break;
          paramAnonymousView.ClO.setVisibility(8);
          break label162;
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
    this.pqt = ((ListView)findViewById(2131303242));
    ListView localListView = this.pqt;
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
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(2131307882);
    AppMethodBeat.o(67613);
    return localVerticalScrollBar;
  }
  
  public final View inflate()
  {
    AppMethodBeat.i(67612);
    View localView = View.inflate(getContext(), 2131493213, this);
    AppMethodBeat.o(67612);
    return localView;
  }
  
  final class a
  {
    CdnImageView Cjq;
    TextView Cjs;
    TextView ClO;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSortView
 * JD-Core Version:    0.7.0.1
 */