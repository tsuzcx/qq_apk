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
import com.tencent.mm.sdk.platformtools.bt;

public class SwitchPhoneItemView
  extends RelativeLayout
{
  private int AtA;
  private TextView Atx;
  private TextView Aty;
  ImageView Atz;
  
  public SwitchPhoneItemView(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public SwitchPhoneItemView(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(71489);
    this.AtA = 0;
    this.AtA = paramInt;
    aL(paramContext);
    AppMethodBeat.o(71489);
  }
  
  public SwitchPhoneItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71490);
    this.AtA = 0;
    aL(paramContext);
    AppMethodBeat.o(71490);
  }
  
  public SwitchPhoneItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71491);
    this.AtA = 0;
    aL(paramContext);
    AppMethodBeat.o(71491);
  }
  
  private void aL(Context paramContext)
  {
    AppMethodBeat.i(71492);
    if (this.AtA > 0) {}
    for (paramContext = inflate(paramContext, this.AtA, this);; paramContext = inflate(paramContext, 2131496033, this))
    {
      this.Atx = ((TextView)paramContext.findViewById(2131303234));
      this.Aty = ((TextView)paramContext.findViewById(2131303209));
      this.Atz = ((ImageView)paramContext.findViewById(2131303208));
      AppMethodBeat.o(71492);
      return;
    }
  }
  
  public final void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(71493);
    if (!bt.ai(paramCharSequence1)) {
      this.Atx.setText(paramCharSequence1);
    }
    while (!bt.ai(paramCharSequence2))
    {
      this.Aty.setMaxLines(2);
      this.Aty.setSelected(true);
      this.Aty.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      this.Aty.setText(paramCharSequence2);
      this.Aty.setMovementMethod(LinkMovementMethod.getInstance());
      AppMethodBeat.o(71493);
      return;
      this.Atx.setVisibility(8);
    }
    this.Aty.setVisibility(8);
    AppMethodBeat.o(71493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView
 * JD-Core Version:    0.7.0.1
 */