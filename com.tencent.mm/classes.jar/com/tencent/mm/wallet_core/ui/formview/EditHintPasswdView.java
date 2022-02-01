package com.tencent.mm.wallet_core.ui.formview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class EditHintPasswdView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private static final int RvS = 2131232058;
  private static final int RvT = 2131232059;
  private int RvU;
  private int RvV;
  private int RvW;
  private int RvX;
  private a RvY;
  private View.OnFocusChangeListener ktK;
  public TenpaySecureEditText mEditText;
  private int zOa;
  
  public EditHintPasswdView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(73117);
    this.mEditText = null;
    this.RvU = 6;
    this.zOa = 1;
    this.RvV = RvS;
    this.RvW = 1;
    this.RvY = null;
    this.ktK = null;
    bh(paramContext);
    AppMethodBeat.o(73117);
  }
  
  public EditHintPasswdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public EditHintPasswdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73116);
    this.mEditText = null;
    this.RvU = 6;
    this.zOa = 1;
    this.RvV = RvS;
    this.RvW = 1;
    this.RvY = null;
    this.ktK = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.PwdAttr, paramInt, 0);
    this.zOa = paramAttributeSet.getInteger(3, 1);
    this.RvV = paramAttributeSet.getResourceId(0, RvS);
    this.RvW = paramAttributeSet.getInteger(1, 1);
    this.RvX = paramAttributeSet.getInteger(2, 1);
    paramAttributeSet.recycle();
    bh(paramContext);
    TenpaySecureEditText.setSalt(f.hhV());
    AppMethodBeat.o(73116);
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(73119);
    this.mEditText = ((TenpaySecureEditText)aa.jQ(paramContext).inflate(2131495014, this, true).findViewById(2131310180));
    if ((this.RvV == RvS) && (ao.isDarkMode())) {
      this.RvV = RvT;
    }
    if (this.RvX == 1) {
      this.RvV = 2131101287;
    }
    paramContext = this.mEditText;
    int i = this.zOa;
    if (this.RvX == 1) {}
    for (boolean bool = true;; bool = false)
    {
      b.a(paramContext, i, bool);
      this.RvU = getNumberSize();
      if (this.mEditText == null) {
        break;
      }
      this.mEditText.setBackgroundResource(this.RvV);
      this.mEditText.setImeOptions(6);
      this.mEditText.setInputType(128);
      this.mEditText.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(73115);
          if (EditHintPasswdView.b(EditHintPasswdView.this) != null) {
            EditHintPasswdView.b(EditHintPasswdView.this).onInputValidChange(EditHintPasswdView.c(EditHintPasswdView.this));
          }
          AppMethodBeat.o(73115);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.mEditText.setOnFocusChangeListener(this);
      this.mEditText.setClickable(false);
      this.mEditText.setLongClickable(false);
      super.setEnabled(true);
      super.setClickable(true);
      AppMethodBeat.o(73119);
      return;
    }
    Log.e("MicroMsg.EditHintPasswdView", "hy: no edit text view");
    AppMethodBeat.o(73119);
  }
  
  private boolean bql()
  {
    AppMethodBeat.i(73120);
    if ((this.mEditText != null) && (this.mEditText.getInputLength() == this.RvU))
    {
      AppMethodBeat.o(73120);
      return true;
    }
    AppMethodBeat.o(73120);
    return false;
  }
  
  private int getNumberSize()
  {
    AppMethodBeat.i(73121);
    switch (this.zOa)
    {
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      Log.i("MicroMsg.EditHintPasswdView", "hy: error or not set format. use default");
      AppMethodBeat.o(73121);
      return 6;
    case 1: 
      AppMethodBeat.o(73121);
      return 6;
    case 3: 
      AppMethodBeat.o(73121);
      return 3;
    case 4: 
      AppMethodBeat.o(73121);
      return 4;
    }
    AppMethodBeat.o(73121);
    return 4;
  }
  
  public final void aqo(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(214344);
    this.RvX = paramInt;
    TenpaySecureEditText localTenpaySecureEditText;
    if (this.RvX == 1)
    {
      this.RvV = 2131101287;
      this.mEditText.setBackgroundResource(this.RvV);
      localTenpaySecureEditText = this.mEditText;
      paramInt = this.zOa;
      if (this.RvX != 1) {
        break label93;
      }
    }
    for (;;)
    {
      b.a(localTenpaySecureEditText, paramInt, bool);
      AppMethodBeat.o(214344);
      return;
      if (ao.isDarkMode())
      {
        this.RvV = RvT;
        break;
      }
      this.RvV = RvS;
      break;
      label93:
      bool = false;
    }
  }
  
  public final void eIj()
  {
    AppMethodBeat.i(73126);
    if (this.mEditText != null) {
      this.mEditText.ClearInput();
    }
    AppMethodBeat.o(73126);
  }
  
  public final int getEncrType()
  {
    return this.RvW;
  }
  
  public final int getFormat()
  {
    return this.zOa;
  }
  
  public final String getMd5Value()
  {
    AppMethodBeat.i(73118);
    if (this.mEditText != null)
    {
      String str = MD5Util.getMD5String(this.mEditText.getText().toString());
      AppMethodBeat.o(73118);
      return str;
    }
    Log.w("MicroMsg.EditHintPasswdView", "hy: edit view is null");
    AppMethodBeat.o(73118);
    return "";
  }
  
  public final a getOnEditInputValidListener()
  {
    return this.RvY;
  }
  
  public final View.OnFocusChangeListener getOnFocusChangeListener()
  {
    return this.ktK;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(73125);
    if (this.mEditText != null)
    {
      String str = c.a.a(this.RvW, this.mEditText);
      AppMethodBeat.o(73125);
      return str;
    }
    Log.w("MicroMsg.EditHintPasswdView", "hy: no edit view");
    AppMethodBeat.o(73125);
    return "";
  }
  
  public final void hhY()
  {
    AppMethodBeat.i(73122);
    this.mEditText.requestFocus();
    AppMethodBeat.o(73122);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(73128);
    if (this.ktK != null) {
      this.ktK.onFocusChange(this, paramBoolean);
    }
    if (this.RvY != null) {
      this.RvY.onInputValidChange(bql());
    }
    AppMethodBeat.o(73128);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73127);
    setMeasuredDimension(getDefaultSize(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 720.0F), paramInt2));
    int j;
    int i;
    if (this.RvX == 0)
    {
      j = getMeasuredWidth();
      if (this.RvU == 0)
      {
        paramInt1 = j / 6;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
        i = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        setMeasuredDimension(getDefaultSize(j, paramInt2), getDefaultSize(paramInt1, i));
        paramInt1 = i;
      }
    }
    for (;;)
    {
      super.onMeasure(paramInt2, paramInt1);
      AppMethodBeat.o(73127);
      return;
      paramInt1 = j / this.RvU;
      break;
      i = getMeasuredWidth();
      j = (i - a.fromDPToPix(getContext(), 8) * (this.RvU - 1)) / this.RvU;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i + 1, 1073741824);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
      setMeasuredDimension(getDefaultSize(i, paramInt2), getDefaultSize(j, paramInt1));
    }
  }
  
  public final void setEditTextMaxLength(int paramInt)
  {
    AppMethodBeat.i(73124);
    if (this.mEditText != null)
    {
      InputFilter[] arrayOfInputFilter1 = this.mEditText.getFilters();
      InputFilter[] arrayOfInputFilter2 = new InputFilter[arrayOfInputFilter1.length + 1];
      int i = 0;
      while (i < arrayOfInputFilter1.length)
      {
        arrayOfInputFilter2[i] = arrayOfInputFilter1[i];
        i += 1;
      }
      arrayOfInputFilter2[(arrayOfInputFilter2.length - 1)] = new InputFilter.LengthFilter(paramInt);
      this.mEditText.setFilters(arrayOfInputFilter2);
    }
    AppMethodBeat.o(73124);
  }
  
  public final void setEditTextSize(float paramFloat)
  {
    AppMethodBeat.i(73123);
    if (this.mEditText != null) {
      this.mEditText.setTextSize(paramFloat);
    }
    AppMethodBeat.o(73123);
  }
  
  public final void setEncrType(int paramInt)
  {
    this.RvW = paramInt;
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.ktK = paramOnFocusChangeListener;
  }
  
  public final void setOnInputValidListener(a parama)
  {
    this.RvY = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onInputValidChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView
 * JD-Core Version:    0.7.0.1
 */