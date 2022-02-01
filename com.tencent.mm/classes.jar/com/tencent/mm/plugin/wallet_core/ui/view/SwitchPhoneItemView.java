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
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Util;

public class SwitchPhoneItemView
  extends RelativeLayout
{
  private TextView Pfr;
  private TextView Pfs;
  ImageView Pft;
  private int Pfu;
  
  public SwitchPhoneItemView(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public SwitchPhoneItemView(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(71489);
    this.Pfu = 0;
    this.Pfu = paramInt;
    bv(paramContext);
    AppMethodBeat.o(71489);
  }
  
  public SwitchPhoneItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71490);
    this.Pfu = 0;
    bv(paramContext);
    AppMethodBeat.o(71490);
  }
  
  public SwitchPhoneItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71491);
    this.Pfu = 0;
    bv(paramContext);
    AppMethodBeat.o(71491);
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(71492);
    if (this.Pfu > 0) {}
    for (paramContext = inflate(paramContext, this.Pfu, this);; paramContext = inflate(paramContext, a.g.wallet_switch_verify_phone_item, this))
    {
      this.Pfr = ((TextView)paramContext.findViewById(a.f.phone_number_tv));
      this.Pfs = ((TextView)paramContext.findViewById(a.f.phone_desc_tv));
      this.Pft = ((ImageView)paramContext.findViewById(a.f.phone_check_iv));
      AppMethodBeat.o(71492);
      return;
    }
  }
  
  public final void c(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(71493);
    if (!Util.isNullOrNil(paramCharSequence1)) {
      this.Pfr.setText(paramCharSequence1);
    }
    while (!Util.isNullOrNil(paramCharSequence2))
    {
      this.Pfs.setMaxLines(2);
      this.Pfs.setSelected(true);
      this.Pfs.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      this.Pfs.setText(paramCharSequence2);
      this.Pfs.setMovementMethod(LinkMovementMethod.getInstance());
      AppMethodBeat.o(71493);
      return;
      this.Pfr.setVisibility(8);
    }
    this.Pfs.setVisibility(8);
    AppMethodBeat.o(71493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView
 * JD-Core Version:    0.7.0.1
 */