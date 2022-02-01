package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public class SwitchPhoneItemView
  extends RelativeLayout
{
  private TextView BLR;
  private TextView BLS;
  ImageView BLT;
  private int BLU;
  
  public SwitchPhoneItemView(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public SwitchPhoneItemView(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(71489);
    this.BLU = 0;
    this.BLU = paramInt;
    aM(paramContext);
    AppMethodBeat.o(71489);
  }
  
  public SwitchPhoneItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71490);
    this.BLU = 0;
    aM(paramContext);
    AppMethodBeat.o(71490);
  }
  
  public SwitchPhoneItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71491);
    this.BLU = 0;
    aM(paramContext);
    AppMethodBeat.o(71491);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(71492);
    if (this.BLU > 0) {}
    for (paramContext = inflate(paramContext, this.BLU, this);; paramContext = inflate(paramContext, 2131496033, this))
    {
      this.BLR = ((TextView)paramContext.findViewById(2131303234));
      this.BLS = ((TextView)paramContext.findViewById(2131303209));
      this.BLT = ((ImageView)paramContext.findViewById(2131303208));
      AppMethodBeat.o(71492);
      return;
    }
  }
  
  public final void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(71493);
    if (!bs.aj(paramCharSequence1)) {
      this.BLR.setText(paramCharSequence1);
    }
    while (!bs.aj(paramCharSequence2))
    {
      this.BLS.setMaxLines(2);
      this.BLS.setSelected(true);
      this.BLS.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      this.BLS.setText(paramCharSequence2);
      this.BLS.setMovementMethod(LinkMovementMethod.getInstance());
      AppMethodBeat.o(71493);
      return;
      this.BLR.setVisibility(8);
    }
    this.BLS.setVisibility(8);
    AppMethodBeat.o(71493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView
 * JD-Core Version:    0.7.0.1
 */