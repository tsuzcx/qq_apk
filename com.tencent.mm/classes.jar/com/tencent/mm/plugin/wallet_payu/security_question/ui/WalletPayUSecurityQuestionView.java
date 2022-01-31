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
import com.tencent.mm.ac.a.d;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.ui.tools.CustomFitTextView;

public class WalletPayUSecurityQuestionView
  extends LinearLayout
{
  private Context mContext;
  private TextView qOY;
  private CustomFitTextView qOZ;
  String qPa;
  
  public WalletPayUSecurityQuestionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletPayUSecurityQuestionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
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
      this.qOY = ((TextView)((View)localObject).findViewById(a.f.tip_tv));
      this.qOZ = ((CustomFitTextView)((View)localObject).findViewById(a.f.pre_filled_tv));
      this.qOY.setText(paramContext);
      paramContext = this.qOZ;
      paramContext.a(paramAttributeSet, paramContext.maxLines, paramContext.vZs, paramContext.vZq, paramContext.getResources().getColor(a.d.hint_text_color));
      if (!bool)
      {
        this.qOZ.setEnabled(false);
        this.qOZ.setFocusable(false);
        this.qOZ.setClickable(false);
        this.qOZ.setBackgroundResource(a.e.transparent_background);
        setBackgroundResource(a.e.list_item_normal);
        return;
      }
      this.qOZ.setEnabled(false);
      this.qOZ.setTextColor(getResources().getColor(a.c.wallet_common_clickable_text_color));
      this.qOZ.setFocusable(false);
      this.qOZ.setClickable(false);
      this.qOZ.setBackgroundResource(a.e.transparent_background);
      setBackgroundResource(a.e.comm_list_item_selector);
      return;
      bool = false;
      paramContext = "";
      paramAttributeSet = (AttributeSet)localObject;
    }
  }
  
  public String getCurrentQuestion()
  {
    return this.qPa;
  }
  
  public void setQuestionText(String paramString)
  {
    this.qPa = paramString;
    KeyListener localKeyListener = this.qOZ.getKeyListener();
    this.qOZ.setInputType(1);
    this.qOZ.setKeyListener(null);
    setValStr(paramString);
    this.qOZ.setKeyListener(localKeyListener);
  }
  
  public void setValStr(String paramString)
  {
    CustomFitTextView localCustomFitTextView = this.qOZ;
    localCustomFitTextView.a(paramString, 3, false, -1, localCustomFitTextView.getCurrentTextColor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionView
 * JD-Core Version:    0.7.0.1
 */