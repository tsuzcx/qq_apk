package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;

public class WalletBalanceFetchResultItemView
  extends LinearLayout
{
  private TextView kEu;
  private TextView kFd;
  private boolean vvO;
  
  public WalletBalanceFetchResultItemView(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(68564);
    this.vvO = false;
    init();
    AppMethodBeat.o(68564);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(68565);
    this.vvO = false;
    init();
    AppMethodBeat.o(68565);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(68563);
    this.vvO = false;
    this.vvO = paramBoolean;
    init();
    AppMethodBeat.o(68563);
  }
  
  private void init()
  {
    AppMethodBeat.i(68566);
    if (this.vvO) {
      inflate(getContext(), 2131493152, this);
    }
    for (;;)
    {
      this.kEu = ((TextView)findViewById(2131297519));
      this.kFd = ((TextView)findViewById(2131297518));
      AppMethodBeat.o(68566);
      return;
      inflate(getContext(), 2131493151, this);
    }
  }
  
  public final void a(String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(68567);
    this.kEu.setText(paramString1);
    if (!bt.isNullOrNil(paramString2)) {
      this.kEu.setTextColor(g.bW(paramString2, true));
    }
    if (paramBoolean) {
      this.kFd.setText(k.b(getContext(), paramCharSequence, this.kFd.getTextSize()));
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramString3)) {
        this.kFd.setTextColor(g.bW(paramString3, true));
      }
      AppMethodBeat.o(68567);
      return;
      this.kFd.setText(paramCharSequence);
    }
  }
  
  public final void b(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(68568);
    a(getContext().getString(paramInt), paramCharSequence, "", "", false);
    AppMethodBeat.o(68568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView
 * JD-Core Version:    0.7.0.1
 */