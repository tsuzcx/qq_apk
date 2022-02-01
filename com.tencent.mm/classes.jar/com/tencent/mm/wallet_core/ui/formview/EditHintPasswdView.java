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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.wallet_core.ui.g;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class EditHintPasswdView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private static final int YXs = a.e.edit_passwd_shape_bg;
  private static final int YXt = a.e.edit_passwd_shape_dark_bg;
  private int Ftx;
  private int YXu;
  private int YXv;
  private int YXw;
  private int YXx;
  private a YXy;
  public TenpaySecureEditText mEditText;
  private View.OnFocusChangeListener nly;
  
  public EditHintPasswdView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(73117);
    this.mEditText = null;
    this.YXu = 6;
    this.Ftx = 1;
    this.YXv = YXs;
    this.YXw = 1;
    this.YXy = null;
    this.nly = null;
    bv(paramContext);
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
    this.YXu = 6;
    this.Ftx = 1;
    this.YXv = YXs;
    this.YXw = 1;
    this.YXy = null;
    this.nly = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.PwdAttr, paramInt, 0);
    this.Ftx = paramAttributeSet.getInteger(a.k.PwdAttr_format, 1);
    this.YXv = paramAttributeSet.getResourceId(a.k.PwdAttr_EditTextBg, YXs);
    this.YXw = paramAttributeSet.getInteger(a.k.PwdAttr_PwdEncryptType, 1);
    this.YXx = paramAttributeSet.getInteger(a.k.PwdAttr_PwdMode, 1);
    paramAttributeSet.recycle();
    bv(paramContext);
    TenpaySecureEditText.setSalt(g.ijw());
    AppMethodBeat.o(73116);
  }
  
  private boolean bAz()
  {
    AppMethodBeat.i(73120);
    if ((this.mEditText != null) && (this.mEditText.getInputLength() == this.YXu))
    {
      AppMethodBeat.o(73120);
      return true;
    }
    AppMethodBeat.o(73120);
    return false;
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(73119);
    this.mEditText = ((TenpaySecureEditText)ad.kS(paramContext).inflate(a.g.hint_view_passwd, this, true).findViewById(a.f.wallet_content));
    if ((this.YXv == YXs) && (ar.isDarkMode())) {
      this.YXv = YXt;
    }
    if (this.YXx == 1) {
      this.YXv = a.c.transparent;
    }
    paramContext = this.mEditText;
    int i = this.Ftx;
    if (this.YXx == 1) {}
    for (boolean bool = true;; bool = false)
    {
      b.a(paramContext, i, bool);
      this.YXu = getNumberSize();
      if (this.mEditText == null) {
        break;
      }
      this.mEditText.setBackgroundResource(this.YXv);
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
  
  private int getNumberSize()
  {
    AppMethodBeat.i(73121);
    switch (this.Ftx)
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
  
  public final void azM(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(199615);
    this.YXx = paramInt;
    TenpaySecureEditText localTenpaySecureEditText;
    if (this.YXx == 1)
    {
      this.YXv = a.c.transparent;
      this.mEditText.setBackgroundResource(this.YXv);
      localTenpaySecureEditText = this.mEditText;
      paramInt = this.Ftx;
      if (this.YXx != 1) {
        break label94;
      }
    }
    for (;;)
    {
      b.a(localTenpaySecureEditText, paramInt, bool);
      AppMethodBeat.o(199615);
      return;
      if (ar.isDarkMode())
      {
        this.YXv = YXt;
        break;
      }
      this.YXv = YXs;
      break;
      label94:
      bool = false;
    }
  }
  
  public final void fuo()
  {
    AppMethodBeat.i(73126);
    if (this.mEditText != null) {
      this.mEditText.ClearInput();
    }
    AppMethodBeat.o(73126);
  }
  
  public final int getEncrType()
  {
    return this.YXw;
  }
  
  public final int getFormat()
  {
    return this.Ftx;
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
    return this.YXy;
  }
  
  public final View.OnFocusChangeListener getOnFocusChangeListener()
  {
    return this.nly;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(73125);
    if (this.mEditText != null)
    {
      String str = c.a.a(this.YXw, this.mEditText);
      AppMethodBeat.o(73125);
      return str;
    }
    Log.w("MicroMsg.EditHintPasswdView", "hy: no edit view");
    AppMethodBeat.o(73125);
    return "";
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(73128);
    if (this.nly != null) {
      this.nly.onFocusChange(this, paramBoolean);
    }
    if (this.YXy != null) {
      this.YXy.onInputValidChange(bAz());
    }
    AppMethodBeat.o(73128);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73127);
    setMeasuredDimension(getDefaultSize(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 720.0F), paramInt2));
    int j;
    int i;
    if (this.YXx == 0)
    {
      j = getMeasuredWidth();
      if (this.YXu == 0)
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
      paramInt1 = j / this.YXu;
      break;
      j = getMeasuredWidth();
      i = getMeasuredHeight();
      paramInt2 = (j - a.fromDPToPix(getContext(), 8) * (this.YXu - 1)) / this.YXu;
      paramInt1 = i;
      if (i < paramInt2) {
        paramInt1 = paramInt2;
      }
      i = View.MeasureSpec.makeMeasureSpec(j + 1, 1073741824);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      setMeasuredDimension(getDefaultSize(j, i), getDefaultSize(paramInt2, paramInt1));
      paramInt2 = i;
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
    this.YXw = paramInt;
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.nly = paramOnFocusChangeListener;
  }
  
  public final void setOnInputValidListener(a parama)
  {
    this.YXy = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onInputValidChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView
 * JD-Core Version:    0.7.0.1
 */