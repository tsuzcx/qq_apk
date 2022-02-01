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
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.CustomFitTextView;

public class WalletPayUSecurityQuestionView
  extends LinearLayout
{
  private TextView IuT;
  private CustomFitTextView IuU;
  private String IuV;
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
      TypedArray localTypedArray = this.mContext.obtainStyledAttributes(paramAttributeSet, a.a.EditHintView, -1, 0);
      paramInt = localTypedArray.getResourceId(13, 0);
      if (paramInt != 0) {
        paramContext = this.mContext.getString(paramInt);
      }
      paramInt = localTypedArray.getResourceId(8, 0);
      paramAttributeSet = (AttributeSet)localObject;
      if (paramInt != 0) {
        paramAttributeSet = this.mContext.getString(paramInt);
      }
      bool = localTypedArray.getBoolean(2, false);
      localTypedArray.recycle();
    }
    for (;;)
    {
      localObject = LayoutInflater.from(this.mContext).inflate(2131495916, this, true);
      this.IuT = ((TextView)((View)localObject).findViewById(2131309163));
      this.IuU = ((CustomFitTextView)((View)localObject).findViewById(2131306085));
      this.IuT.setText(paramContext);
      paramContext = this.IuU;
      paramContext.a(paramAttributeSet, paramContext.maxLines, paramContext.Qqu, paramContext.Qqs, paramContext.getResources().getColor(2131100594));
      if (!bool)
      {
        this.IuU.setEnabled(false);
        this.IuU.setFocusable(false);
        this.IuU.setClickable(false);
        this.IuU.setBackgroundResource(2131235359);
        setBackgroundResource(2131233327);
        AppMethodBeat.o(72235);
        return;
      }
      this.IuU.setEnabled(false);
      this.IuU.setTextColor(getResources().getColor(2131101347));
      this.IuU.setFocusable(false);
      this.IuU.setClickable(false);
      this.IuU.setBackgroundResource(2131235359);
      setBackgroundResource(2131231898);
      AppMethodBeat.o(72235);
      return;
      bool = false;
      paramContext = "";
      paramAttributeSet = (AttributeSet)localObject;
    }
  }
  
  public final boolean bql()
  {
    AppMethodBeat.i(72238);
    if (!Util.isNullOrNil(this.IuV))
    {
      AppMethodBeat.o(72238);
      return true;
    }
    AppMethodBeat.o(72238);
    return false;
  }
  
  public String getCurrentQuestion()
  {
    return this.IuV;
  }
  
  public void setQuestionText(String paramString)
  {
    AppMethodBeat.i(72236);
    this.IuV = paramString;
    KeyListener localKeyListener = this.IuU.getKeyListener();
    this.IuU.setInputType(1);
    this.IuU.setKeyListener(null);
    setValStr(paramString);
    this.IuU.setKeyListener(localKeyListener);
    AppMethodBeat.o(72236);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(72237);
    CustomFitTextView localCustomFitTextView = this.IuU;
    localCustomFitTextView.a(paramString, 3, false, -1, localCustomFitTextView.getCurrentTextColor());
    AppMethodBeat.o(72237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionView
 * JD-Core Version:    0.7.0.1
 */