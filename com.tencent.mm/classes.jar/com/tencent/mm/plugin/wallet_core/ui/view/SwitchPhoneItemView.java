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
import com.tencent.mm.sdk.platformtools.Util;

public class SwitchPhoneItemView
  extends RelativeLayout
{
  private TextView ImZ;
  private TextView Ina;
  ImageView Inb;
  private int Inc;
  
  public SwitchPhoneItemView(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public SwitchPhoneItemView(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(71489);
    this.Inc = 0;
    this.Inc = paramInt;
    bh(paramContext);
    AppMethodBeat.o(71489);
  }
  
  public SwitchPhoneItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71490);
    this.Inc = 0;
    bh(paramContext);
    AppMethodBeat.o(71490);
  }
  
  public SwitchPhoneItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71491);
    this.Inc = 0;
    bh(paramContext);
    AppMethodBeat.o(71491);
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(71492);
    if (this.Inc > 0) {}
    for (paramContext = inflate(paramContext, this.Inc, this);; paramContext = inflate(paramContext, 2131497013, this))
    {
      this.ImZ = ((TextView)paramContext.findViewById(2131305902));
      this.Ina = ((TextView)paramContext.findViewById(2131305877));
      this.Inb = ((ImageView)paramContext.findViewById(2131305876));
      AppMethodBeat.o(71492);
      return;
    }
  }
  
  public final void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(71493);
    if (!Util.isNullOrNil(paramCharSequence1)) {
      this.ImZ.setText(paramCharSequence1);
    }
    while (!Util.isNullOrNil(paramCharSequence2))
    {
      this.Ina.setMaxLines(2);
      this.Ina.setSelected(true);
      this.Ina.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      this.Ina.setText(paramCharSequence2);
      this.Ina.setMovementMethod(LinkMovementMethod.getInstance());
      AppMethodBeat.o(71493);
      return;
      this.ImZ.setVisibility(8);
    }
    this.Ina.setVisibility(8);
    AppMethodBeat.o(71493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView
 * JD-Core Version:    0.7.0.1
 */