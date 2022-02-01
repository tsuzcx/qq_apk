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
import com.tencent.mm.protocal.protobuf.im;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

public class BankRemitSortView
  extends BaseSortView
{
  private final String TAG = "MicroMsg.BankcardSortView";
  private ListView nyo;
  
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
          paramAnonymousView.wHo = ((TextView)localView.findViewById(2131297925));
          paramAnonymousView.wER = ((TextView)localView.findViewById(2131297564));
          paramAnonymousView.wEP = ((CdnImageView)localView.findViewById(2131297563));
          localView.setTag(paramAnonymousView);
        }
        paramAnonymousView = (BankRemitSortView.a)localView.getTag();
        localObject = (im)paramAnonymousd.data;
        if (localObject != null) {
          if ((BankRemitSortView.this.HGk) && (paramAnonymousBoolean1)) {
            if (paramAnonymousd.HGs.equals("☆"))
            {
              paramAnonymousView.wHo.setText(2131756396);
              paramAnonymousView.wHo.setVisibility(0);
              label162:
              paramAnonymousView.wEP.setUseSdcardCache(true);
              paramAnonymousView.wEP.kZ(((im)localObject).wEw, b.apw(((im)localObject).wEw));
              paramAnonymousView.wER.setText(((im)localObject).tGS);
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(67611);
          return localView;
          paramAnonymousView.wHo.setText(paramAnonymousd.HGs);
          break;
          paramAnonymousView.wHo.setVisibility(8);
          break label162;
          ac.w("MicroMsg.BankcardSortView", "elem is null: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
      }
    };
    AppMethodBeat.o(67615);
    return local1;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(67614);
    this.nyo = ((ListView)findViewById(2131301457));
    ListView localListView = this.nyo;
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
    CdnImageView wEP;
    TextView wER;
    TextView wHo;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSortView
 * JD-Core Version:    0.7.0.1
 */