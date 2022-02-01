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
import com.tencent.mm.sdk.platformtools.bu;

public class SwitchPhoneItemView
  extends RelativeLayout
{
  private TextView DDN;
  private TextView DDO;
  ImageView DDP;
  private int DDQ;
  
  public SwitchPhoneItemView(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public SwitchPhoneItemView(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(71489);
    this.DDQ = 0;
    this.DDQ = paramInt;
    aN(paramContext);
    AppMethodBeat.o(71489);
  }
  
  public SwitchPhoneItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71490);
    this.DDQ = 0;
    aN(paramContext);
    AppMethodBeat.o(71490);
  }
  
  public SwitchPhoneItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71491);
    this.DDQ = 0;
    aN(paramContext);
    AppMethodBeat.o(71491);
  }
  
  private void aN(Context paramContext)
  {
    AppMethodBeat.i(71492);
    if (this.DDQ > 0) {}
    for (paramContext = inflate(paramContext, this.DDQ, this);; paramContext = inflate(paramContext, 2131496033, this))
    {
      this.DDN = ((TextView)paramContext.findViewById(2131303234));
      this.DDO = ((TextView)paramContext.findViewById(2131303209));
      this.DDP = ((ImageView)paramContext.findViewById(2131303208));
      AppMethodBeat.o(71492);
      return;
    }
  }
  
  public final void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(71493);
    if (!bu.ah(paramCharSequence1)) {
      this.DDN.setText(paramCharSequence1);
    }
    while (!bu.ah(paramCharSequence2))
    {
      this.DDO.setMaxLines(2);
      this.DDO.setSelected(true);
      this.DDO.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      this.DDO.setText(paramCharSequence2);
      this.DDO.setMovementMethod(LinkMovementMethod.getInstance());
      AppMethodBeat.o(71493);
      return;
      this.DDN.setVisibility(8);
    }
    this.DDO.setVisibility(8);
    AppMethodBeat.o(71493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView
 * JD-Core Version:    0.7.0.1
 */