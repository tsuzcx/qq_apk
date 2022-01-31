package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;

public class WalletBalanceFetchResultItemView
  extends LinearLayout
{
  private TextView iJG;
  private TextView kPB;
  private boolean qhq;
  
  public WalletBalanceFetchResultItemView(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(45342);
    this.qhq = false;
    init();
    AppMethodBeat.o(45342);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(45343);
    this.qhq = false;
    init();
    AppMethodBeat.o(45343);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(45341);
    this.qhq = false;
    this.qhq = paramBoolean;
    init();
    AppMethodBeat.o(45341);
  }
  
  private void init()
  {
    AppMethodBeat.i(45344);
    if (this.qhq) {
      inflate(getContext(), 2130968820, this);
    }
    for (;;)
    {
      this.iJG = ((TextView)findViewById(2131821678));
      this.kPB = ((TextView)findViewById(2131821679));
      AppMethodBeat.o(45344);
      return;
      inflate(getContext(), 2130968819, this);
    }
  }
  
  public final void a(String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(45345);
    this.iJG.setText(paramString1);
    if (!bo.isNullOrNil(paramString2)) {
      this.iJG.setTextColor(Color.parseColor(paramString2));
    }
    if (paramBoolean) {
      this.kPB.setText(j.b(getContext(), paramCharSequence, this.kPB.getTextSize()));
    }
    for (;;)
    {
      if (!bo.isNullOrNil(paramString3)) {
        this.kPB.setTextColor(Color.parseColor(paramString3));
      }
      AppMethodBeat.o(45345);
      return;
      this.kPB.setText(paramCharSequence);
    }
  }
  
  public final void b(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(45346);
    a(getContext().getString(paramInt), paramCharSequence, "", "", false);
    AppMethodBeat.o(45346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView
 * JD-Core Version:    0.7.0.1
 */