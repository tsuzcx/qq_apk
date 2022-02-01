package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

public class BankCardSelectSortView
  extends BaseSortView
{
  private ListView nyo;
  
  public BankCardSelectSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(String paramString, d paramd)
  {
    AppMethodBeat.i(71473);
    boolean bool = ((a)paramd.data).vxj.toUpperCase().contains(paramString.toUpperCase());
    AppMethodBeat.o(71473);
    return bool;
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
          localView = LayoutInflater.from(localContext).inflate(2131493166, null);
          paramAnonymousView = new BankCardSelectSortView.b((byte)0);
          paramAnonymousView.wHo = ((TextView)localView.findViewById(2131297925));
          paramAnonymousView.wER = ((TextView)localView.findViewById(2131297564));
          paramAnonymousView.wEP = ((CdnImageView)localView.findViewById(2131297563));
          localView.setTag(paramAnonymousView);
        }
        paramAnonymousView = (BankCardSelectSortView.b)localView.getTag();
        if ((BankCardSelectSortView.this.HGk) && (paramAnonymousBoolean1))
        {
          paramAnonymousView.wHo.setText(paramAnonymousd.HGs);
          paramAnonymousView.wHo.setVisibility(0);
          paramAnonymousd = (BankCardSelectSortView.a)paramAnonymousd.data;
          paramAnonymousView.wER.setText(paramAnonymousd.vxj);
          if (bs.isNullOrNil(paramAnonymousd.drM)) {
            break label206;
          }
          paramAnonymousView.wEP.setUseSdcardCache(true);
          paramAnonymousView.wEP.kZ(paramAnonymousd.drM, paramAnonymousd.BLD);
        }
        for (;;)
        {
          AppMethodBeat.o(71468);
          return localView;
          paramAnonymousView.wHo.setVisibility(8);
          break;
          label206:
          paramAnonymousView.wEP.setImageBitmap(null);
        }
      }
    };
    AppMethodBeat.o(71474);
    return local1;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(71471);
    this.nyo = ((ListView)findViewById(2131301457));
    ListView localListView = this.nyo;
    AppMethodBeat.o(71471);
    return localListView;
  }
  
  public View getNoResultView()
  {
    AppMethodBeat.i(71472);
    View localView = findViewById(2131297170);
    AppMethodBeat.o(71472);
    return localView;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(71470);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(2131304800);
    AppMethodBeat.o(71470);
    return localVerticalScrollBar;
  }
  
  public final View inflate()
  {
    AppMethodBeat.i(71469);
    View localView = View.inflate(getContext(), 2131493167, this);
    AppMethodBeat.o(71469);
    return localView;
  }
  
  public static final class a
  {
    public String BLD;
    public String drM;
    public String pinyin;
    public String vxj;
  }
  
  static final class b
  {
    CdnImageView wEP;
    TextView wER;
    TextView wHo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView
 * JD-Core Version:    0.7.0.1
 */