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
  private TextView Web;
  private CustomFitTextView Wec;
  private String Wed;
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
      this.Web = ((TextView)((View)localObject).findViewById(a.f.tip_tv));
      this.Wec = ((CustomFitTextView)((View)localObject).findViewById(a.f.pre_filled_tv));
      this.Web.setText(paramContext);
      paramContext = this.Wec;
      paramContext.b(paramAttributeSet, paramContext.maxLines, paramContext.afEV, paramContext.afET, paramContext.getResources().getColor(a.d.hint_text_color));
      if (!bool)
      {
        this.Wec.setEnabled(false);
        this.Wec.setFocusable(false);
        this.Wec.setClickable(false);
        this.Wec.setBackgroundResource(a.e.transparent_background);
        setBackgroundResource(a.e.list_item_normal);
        AppMethodBeat.o(72235);
        return;
      }
      this.Wec.setEnabled(false);
      this.Wec.setTextColor(getResources().getColor(a.c.wallet_common_clickable_text_color));
      this.Wec.setFocusable(false);
      this.Wec.setClickable(false);
      this.Wec.setBackgroundResource(a.e.transparent_background);
      setBackgroundResource(a.e.comm_list_item_selector);
      AppMethodBeat.o(72235);
      return;
      bool = false;
      paramContext = "";
      paramAttributeSet = (AttributeSet)localObject;
    }
  }
  
  public final boolean bZp()
  {
    AppMethodBeat.i(72238);
    if (!Util.isNullOrNil(this.Wed))
    {
      AppMethodBeat.o(72238);
      return true;
    }
    AppMethodBeat.o(72238);
    return false;
  }
  
  public String getCurrentQuestion()
  {
    return this.Wed;
  }
  
  public void setQuestionText(String paramString)
  {
    AppMethodBeat.i(72236);
    this.Wed = paramString;
    KeyListener localKeyListener = this.Wec.getKeyListener();
    this.Wec.setInputType(1);
    this.Wec.setKeyListener(null);
    setValStr(paramString);
    this.Wec.setKeyListener(localKeyListener);
    AppMethodBeat.o(72236);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(72237);
    CustomFitTextView localCustomFitTextView = this.Wec;
    localCustomFitTextView.b(paramString, 3, false, -1, localCustomFitTextView.getCurrentTextColor());
    AppMethodBeat.o(72237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionView
 * JD-Core Version:    0.7.0.1
 */