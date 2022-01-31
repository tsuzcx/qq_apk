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
import com.tencent.mm.sdk.platformtools.bo;

public class SwitchPhoneItemView
  extends RelativeLayout
{
  private TextView uwC;
  private TextView uwD;
  ImageView uwE;
  private int uwF;
  
  public SwitchPhoneItemView(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public SwitchPhoneItemView(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(47884);
    this.uwF = 0;
    this.uwF = paramInt;
    aA(paramContext);
    AppMethodBeat.o(47884);
  }
  
  public SwitchPhoneItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(47885);
    this.uwF = 0;
    aA(paramContext);
    AppMethodBeat.o(47885);
  }
  
  public SwitchPhoneItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(47886);
    this.uwF = 0;
    aA(paramContext);
    AppMethodBeat.o(47886);
  }
  
  private void aA(Context paramContext)
  {
    AppMethodBeat.i(47887);
    if (this.uwF > 0) {}
    for (paramContext = inflate(paramContext, this.uwF, this);; paramContext = inflate(paramContext, 2130971256, this))
    {
      this.uwC = ((TextView)paramContext.findViewById(2131829405));
      this.uwD = ((TextView)paramContext.findViewById(2131829406));
      this.uwE = ((ImageView)paramContext.findViewById(2131829407));
      AppMethodBeat.o(47887);
      return;
    }
  }
  
  public final void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(47888);
    if (!bo.aa(paramCharSequence1)) {
      this.uwC.setText(paramCharSequence1);
    }
    while (!bo.aa(paramCharSequence2))
    {
      this.uwD.setMaxLines(2);
      this.uwD.setSelected(true);
      this.uwD.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      this.uwD.setText(paramCharSequence2);
      this.uwD.setMovementMethod(LinkMovementMethod.getInstance());
      AppMethodBeat.o(47888);
      return;
      this.uwC.setVisibility(8);
    }
    this.uwD.setVisibility(8);
    AppMethodBeat.o(47888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView
 * JD-Core Version:    0.7.0.1
 */