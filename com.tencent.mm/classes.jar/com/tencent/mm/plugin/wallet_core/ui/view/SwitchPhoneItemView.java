package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;

public class SwitchPhoneItemView
  extends RelativeLayout
{
  private TextView qHR;
  private TextView qHS;
  ImageView qHT;
  private int qHU = 0;
  
  public SwitchPhoneItemView(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public SwitchPhoneItemView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.qHU = paramInt;
    ca(paramContext);
  }
  
  public SwitchPhoneItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ca(paramContext);
  }
  
  public SwitchPhoneItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ca(paramContext);
  }
  
  private void ca(Context paramContext)
  {
    if (this.qHU > 0) {}
    for (paramContext = inflate(paramContext, this.qHU, this);; paramContext = inflate(paramContext, a.g.wallet_switch_verify_phone_item, this))
    {
      this.qHR = ((TextView)paramContext.findViewById(a.f.phone_number_tv));
      this.qHS = ((TextView)paramContext.findViewById(a.f.phone_desc_tv));
      this.qHT = ((ImageView)paramContext.findViewById(a.f.phone_check_iv));
      return;
    }
  }
  
  public final void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (!bk.L(paramCharSequence1)) {
      this.qHR.setText(paramCharSequence1);
    }
    while (!bk.L(paramCharSequence2))
    {
      this.qHS.setMaxLines(2);
      this.qHS.setSelected(true);
      this.qHS.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      this.qHS.setText(paramCharSequence2);
      this.qHS.setMovementMethod(LinkMovementMethod.getInstance());
      return;
      this.qHR.setVisibility(8);
    }
    this.qHS.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView
 * JD-Core Version:    0.7.0.1
 */