package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;

public class WalletBalanceFetchResultItemView
  extends LinearLayout
{
  private boolean OdQ;
  private TextView pJi;
  private TextView sUt;
  
  public WalletBalanceFetchResultItemView(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(68564);
    this.OdQ = false;
    init();
    AppMethodBeat.o(68564);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(68565);
    this.OdQ = false;
    init();
    AppMethodBeat.o(68565);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(68563);
    this.OdQ = false;
    this.OdQ = paramBoolean;
    init();
    AppMethodBeat.o(68563);
  }
  
  private void init()
  {
    AppMethodBeat.i(68566);
    if (this.OdQ) {
      inflate(getContext(), a.g.bank_remit_detail_item_money_layout, this);
    }
    for (;;)
    {
      this.sUt = ((TextView)findViewById(a.f.brdi_title_tv));
      this.pJi = ((TextView)findViewById(a.f.brdi_desc_tv));
      AppMethodBeat.o(68566);
      return;
      inflate(getContext(), a.g.bank_remit_detail_item_comm_layout, this);
    }
  }
  
  public final void a(String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(316334);
    a(paramString, paramCharSequence, "", "", false);
    AppMethodBeat.o(316334);
  }
  
  public final void a(String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(68567);
    this.sUt.setText(paramString1);
    if (!Util.isNullOrNil(paramString2)) {
      this.sUt.setTextColor(n.dE(paramString2, true));
    }
    if (paramBoolean) {
      this.pJi.setText(p.b(getContext(), paramCharSequence, this.pJi.getTextSize()));
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString3)) {
        this.pJi.setTextColor(n.dE(paramString3, true));
      }
      AppMethodBeat.o(68567);
      return;
      this.pJi.setText(paramCharSequence);
    }
  }
  
  public final void b(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(68568);
    a(getContext().getString(paramInt), paramCharSequence);
    AppMethodBeat.o(68568);
  }
  
  public final void b(String paramString, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(316340);
    this.sUt.setText(paramString);
    this.pJi.setText(paramCharSequence);
    if (paramInt != -1) {
      this.pJi.setTextColor(paramInt);
    }
    AppMethodBeat.o(316340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView
 * JD-Core Version:    0.7.0.1
 */