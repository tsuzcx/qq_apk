package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;

public class WalletBalanceFetchResultItemView
  extends LinearLayout
{
  private boolean Ihn;
  private TextView mMA;
  private TextView pPT;
  
  public WalletBalanceFetchResultItemView(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(68564);
    this.Ihn = false;
    init();
    AppMethodBeat.o(68564);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(68565);
    this.Ihn = false;
    init();
    AppMethodBeat.o(68565);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(68563);
    this.Ihn = false;
    this.Ihn = paramBoolean;
    init();
    AppMethodBeat.o(68563);
  }
  
  private void init()
  {
    AppMethodBeat.i(68566);
    if (this.Ihn) {
      inflate(getContext(), a.g.bank_remit_detail_item_money_layout, this);
    }
    for (;;)
    {
      this.pPT = ((TextView)findViewById(a.f.brdi_title_tv));
      this.mMA = ((TextView)findViewById(a.f.brdi_desc_tv));
      AppMethodBeat.o(68566);
      return;
      inflate(getContext(), a.g.bank_remit_detail_item_comm_layout, this);
    }
  }
  
  public final void a(String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(68567);
    this.pPT.setText(paramString1);
    if (!Util.isNullOrNil(paramString2)) {
      this.pPT.setTextColor(k.cW(paramString2, true));
    }
    if (paramBoolean) {
      this.mMA.setText(l.b(getContext(), paramCharSequence, this.mMA.getTextSize()));
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString3)) {
        this.mMA.setTextColor(k.cW(paramString3, true));
      }
      AppMethodBeat.o(68567);
      return;
      this.mMA.setText(paramCharSequence);
    }
  }
  
  public final void b(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(68568);
    a(getContext().getString(paramInt), paramCharSequence, "", "", false);
    AppMethodBeat.o(68568);
  }
  
  public final void b(String paramString, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(274650);
    this.pPT.setText(paramString);
    this.mMA.setText(paramCharSequence);
    if (paramInt != -1) {
      this.mMA.setTextColor(paramInt);
    }
    AppMethodBeat.o(274650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView
 * JD-Core Version:    0.7.0.1
 */