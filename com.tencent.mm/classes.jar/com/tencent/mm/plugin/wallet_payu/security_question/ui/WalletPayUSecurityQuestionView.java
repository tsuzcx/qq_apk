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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.tools.CustomFitTextView;

public class WalletPayUSecurityQuestionView
  extends LinearLayout
{
  private TextView DtZ;
  private CustomFitTextView Dua;
  private String Dub;
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
      localObject = LayoutInflater.from(this.mContext).inflate(2131495079, this, true);
      this.DtZ = ((TextView)((View)localObject).findViewById(2131305880));
      this.Dua = ((CustomFitTextView)((View)localObject).findViewById(2131303372));
      this.DtZ.setText(paramContext);
      paramContext = this.Dua;
      paramContext.a(paramAttributeSet, paramContext.maxLines, paramContext.KEZ, paramContext.KEX, paramContext.getResources().getColor(2131100490));
      if (!bool)
      {
        this.Dua.setEnabled(false);
        this.Dua.setFocusable(false);
        this.Dua.setClickable(false);
        this.Dua.setBackgroundResource(2131234429);
        setBackgroundResource(2131232867);
        AppMethodBeat.o(72235);
        return;
      }
      this.Dua.setEnabled(false);
      this.Dua.setTextColor(getResources().getColor(2131101104));
      this.Dua.setFocusable(false);
      this.Dua.setClickable(false);
      this.Dua.setBackgroundResource(2131234429);
      setBackgroundResource(2131231818);
      AppMethodBeat.o(72235);
      return;
      bool = false;
      paramContext = "";
      paramAttributeSet = (AttributeSet)localObject;
    }
  }
  
  public final boolean aVa()
  {
    AppMethodBeat.i(72238);
    if (!bt.isNullOrNil(this.Dub))
    {
      AppMethodBeat.o(72238);
      return true;
    }
    AppMethodBeat.o(72238);
    return false;
  }
  
  public String getCurrentQuestion()
  {
    return this.Dub;
  }
  
  public void setQuestionText(String paramString)
  {
    AppMethodBeat.i(72236);
    this.Dub = paramString;
    KeyListener localKeyListener = this.Dua.getKeyListener();
    this.Dua.setInputType(1);
    this.Dua.setKeyListener(null);
    setValStr(paramString);
    this.Dua.setKeyListener(localKeyListener);
    AppMethodBeat.o(72236);
  }
  
  public void setValStr(String paramString)
  {
    AppMethodBeat.i(72237);
    CustomFitTextView localCustomFitTextView = this.Dua;
    localCustomFitTextView.a(paramString, 3, false, -1, localCustomFitTextView.getCurrentTextColor());
    AppMethodBeat.o(72237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionView
 * JD-Core Version:    0.7.0.1
 */