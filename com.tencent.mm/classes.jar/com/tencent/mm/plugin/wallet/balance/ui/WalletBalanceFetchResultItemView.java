package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;

public class WalletBalanceFetchResultItemView
  extends LinearLayout
{
  private boolean Cku;
  private TextView jVn;
  private TextView mPa;
  
  public WalletBalanceFetchResultItemView(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(68564);
    this.Cku = false;
    init();
    AppMethodBeat.o(68564);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(68565);
    this.Cku = false;
    init();
    AppMethodBeat.o(68565);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(68563);
    this.Cku = false;
    this.Cku = paramBoolean;
    init();
    AppMethodBeat.o(68563);
  }
  
  private void init()
  {
    AppMethodBeat.i(68566);
    if (this.Cku) {
      inflate(getContext(), 2131493198, this);
    }
    for (;;)
    {
      this.mPa = ((TextView)findViewById(2131297745));
      this.jVn = ((TextView)findViewById(2131297744));
      AppMethodBeat.o(68566);
      return;
      inflate(getContext(), 2131493197, this);
    }
  }
  
  public final void a(String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(68567);
    this.mPa.setText(paramString1);
    if (!Util.isNullOrNil(paramString2)) {
      this.mPa.setTextColor(g.cI(paramString2, true));
    }
    if (paramBoolean) {
      this.jVn.setText(l.b(getContext(), paramCharSequence, this.jVn.getTextSize()));
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString3)) {
        this.jVn.setTextColor(g.cI(paramString3, true));
      }
      AppMethodBeat.o(68567);
      return;
      this.jVn.setText(paramCharSequence);
    }
  }
  
  public final void b(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(68568);
    a(getContext().getString(paramInt), paramCharSequence, "", "", false);
    AppMethodBeat.o(68568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView
 * JD-Core Version:    0.7.0.1
 */