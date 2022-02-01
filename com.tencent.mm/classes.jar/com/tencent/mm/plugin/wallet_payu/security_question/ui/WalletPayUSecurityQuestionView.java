package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.CustomFitTextView;

public class WalletPayUSecurityQuestionView
  extends LinearLayout
{
  private TextView PnC;
  private CustomFitTextView PnD;
  private String PnE;
  private Context mContext;
  
  public WalletPayUSecurityQuestionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletPayUSecurityQuestionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72235);
    this.mContext = paramContext;
    paramContext = "";
    Object localObject = "";
    boolean bool;
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = this.mContext.obtainStyledAttributes(paramAttributeSet, a.k.EditHintView, -1, 0);
      paramInt = localTypedArray.getResourceId(a.k.EditHintView_tipmsg, 0);
      if (paramInt != 0) {
        paramContext = this.mContext.getString(paramInt);
      }
      paramInt = localTypedArray.getResourceId(a.k.EditHintView_hint, 0);
      paramAttributeSet = (AttributeSet)localObject;
      if (paramInt != 0) {
        paramAttributeSet = this.mContext.getString(paramInt);
      }
      bool = localTypedArray.getBoolean(a.k.EditHintView_android_clickable, false);
      localTypedArray.recycle();
    }
    for (;;)
    {
      localObject = LayoutInflater.from(this.mContext).inflate(a.g.payu_view_secret_question, this, true);
      this.PnC = ((TextView)((View)localObject).findViewById(a.f.tip_tv));
      this.PnD = ((CustomFitTextView)((View)localObject).findViewById(a.f.pre_filled_tv));
      this.PnC.setText(paramContext);
      paramContext = this.PnD;
      paramContext.b(paramAttributeSet, paramContext.maxLines, paramContext.XOH, paramContext.XOF, paramContext.getResources().getColor(a.d.hint_text_color));
      if (!bool)
      {
        this.PnD.setEnabled(false);
        this.PnD.setFocusable(false);
        this.PnD.setClickable(false);
        this.PnD.setBackgroundResource(a.e.transparent_background);
        setBackgroundResource(a.e.list_item_normal);
        AppMethodBeat.o(72235);
        return;
      }
      this.PnD.setEnabled(false);
      this.PnD.setTextColor(getResources().getColor(a.c.wallet_common_clickable_text_color));
      this.PnD.setFocusable(false);
      this.PnD.setClickable(false);
      this.PnD.setBackgroundResource(a.e.transparent_background);
      setBackgroundResource(a.e.comm_list_item_selector);
      AppMethodBeat.o(72235);
      return;
      bool = false;
      paramContext = "";
      paramAttributeSet = (AttributeSet)localObject;
    }
  }
  
  public final boolean bAz()
  {
    AppMethodBeat.i(72238);
    if (!Util.isNullOrNil(this.PnE))
    {
      AppMethodBeat.o(72238);
      return true;
    }
    AppMethodBeat.o(72238);
    return false;
  }
  
  public String getCurrentQuestion()
  {
    return this.PnE;
  }
  
  public void setQuestionText(String paramString)
  {
    AppMethodBeat.i(72236);
    this.PnE = paramString;
    KeyListener localKeyListener = this.PnD.getKeyListener();
    this.PnD.setInputType(1);
    this.PnD.setKeyListener(null);
    setValStr(paramString);
    this.PnD.setKeyListener(localKeyListener);
    AppMethodBeat.o(72236);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(72237);
    CustomFitTextView localCustomFitTextView = this.PnD;
    localCustomFitTextView.b(paramString, 3, false, -1, localCustomFitTextView.getCurrentTextColor());
    AppMethodBeat.o(72237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionView
 * JD-Core Version:    0.7.0.1
 */