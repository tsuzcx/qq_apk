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
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.CustomFitTextView;

public class WalletPayUSecurityQuestionView
  extends LinearLayout
{
  private Context mContext;
  private TextView uEf;
  private CustomFitTextView uEg;
  private String uEh;
  
  public WalletPayUSecurityQuestionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletPayUSecurityQuestionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(48594);
    this.mContext = paramContext;
    paramContext = "";
    Object localObject = "";
    boolean bool;
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = this.mContext.obtainStyledAttributes(paramAttributeSet, a.a.EditHintView, -1, 0);
      paramInt = localTypedArray.getResourceId(7, 0);
      if (paramInt != 0) {
        paramContext = this.mContext.getString(paramInt);
      }
      paramInt = localTypedArray.getResourceId(6, 0);
      paramAttributeSet = (AttributeSet)localObject;
      if (paramInt != 0) {
        paramAttributeSet = this.mContext.getString(paramInt);
      }
      bool = localTypedArray.getBoolean(2, false);
      localTypedArray.recycle();
    }
    for (;;)
    {
      localObject = LayoutInflater.from(this.mContext).inflate(2130970415, this, true);
      this.uEf = ((TextView)((View)localObject).findViewById(2131821071));
      this.uEg = ((CustomFitTextView)((View)localObject).findViewById(2131823494));
      this.uEf.setText(paramContext);
      paramContext = this.uEg;
      paramContext.a(paramAttributeSet, paramContext.maxLines, paramContext.ArF, paramContext.ArD, paramContext.getResources().getColor(2131690168));
      if (!bool)
      {
        this.uEg.setEnabled(false);
        this.uEg.setFocusable(false);
        this.uEg.setClickable(false);
        this.uEg.setBackgroundResource(2130840999);
        setBackgroundResource(2130839276);
        AppMethodBeat.o(48594);
        return;
      }
      this.uEg.setEnabled(false);
      this.uEg.setTextColor(getResources().getColor(2131690796));
      this.uEg.setFocusable(false);
      this.uEg.setClickable(false);
      this.uEg.setBackgroundResource(2130840999);
      setBackgroundResource(2130838445);
      AppMethodBeat.o(48594);
      return;
      bool = false;
      paramContext = "";
      paramAttributeSet = (AttributeSet)localObject;
    }
  }
  
  public final boolean asv()
  {
    AppMethodBeat.i(48597);
    if (!bo.isNullOrNil(this.uEh))
    {
      AppMethodBeat.o(48597);
      return true;
    }
    AppMethodBeat.o(48597);
    return false;
  }
  
  public String getCurrentQuestion()
  {
    return this.uEh;
  }
  
  public void setQuestionText(String paramString)
  {
    AppMethodBeat.i(48595);
    this.uEh = paramString;
    KeyListener localKeyListener = this.uEg.getKeyListener();
    this.uEg.setInputType(1);
    this.uEg.setKeyListener(null);
    setValStr(paramString);
    this.uEg.setKeyListener(localKeyListener);
    AppMethodBeat.o(48595);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(48596);
    CustomFitTextView localCustomFitTextView = this.uEg;
    localCustomFitTextView.a(paramString, 3, false, -1, localCustomFitTextView.getCurrentTextColor());
    AppMethodBeat.o(48596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionView
 * JD-Core Version:    0.7.0.1
 */