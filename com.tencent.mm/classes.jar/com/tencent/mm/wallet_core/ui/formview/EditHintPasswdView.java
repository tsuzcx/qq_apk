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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class EditHintPasswdView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private static final int agVx = a.e.edit_passwd_shape_bg;
  private static final int agVy = a.e.edit_passwd_shape_dark_bg;
  private int LpR;
  private int agVA;
  private int agVB;
  private int agVC;
  private a agVD;
  private int agVz;
  public TenpaySecureEditText mEditText;
  public String pwdNonce;
  private long pwdTimestamp;
  private View.OnFocusChangeListener qiH;
  
  public EditHintPasswdView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(73117);
    this.mEditText = null;
    this.agVz = 6;
    this.LpR = 1;
    this.agVA = agVx;
    this.agVB = 1;
    this.agVD = null;
    this.qiH = null;
    this.pwdNonce = "";
    this.pwdTimestamp = 0L;
    ci(paramContext);
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
    this.agVz = 6;
    this.LpR = 1;
    this.agVA = agVx;
    this.agVB = 1;
    this.agVD = null;
    this.qiH = null;
    this.pwdNonce = "";
    this.pwdTimestamp = 0L;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.PwdAttr, paramInt, 0);
    this.LpR = paramAttributeSet.getInteger(a.k.PwdAttr_format, 1);
    this.agVA = paramAttributeSet.getResourceId(a.k.PwdAttr_EditTextBg, agVx);
    this.agVB = paramAttributeSet.getInteger(a.k.PwdAttr_PwdEncryptType, 1);
    this.agVC = paramAttributeSet.getInteger(a.k.PwdAttr_PwdMode, 1);
    paramAttributeSet.recycle();
    ci(paramContext);
    TenpaySecureEditText.setSalt(i.jPu());
    AppMethodBeat.o(73116);
  }
  
  private boolean bZp()
  {
    AppMethodBeat.i(73120);
    if ((this.mEditText != null) && (this.mEditText.getInputLength() == this.agVz))
    {
      AppMethodBeat.o(73120);
      return true;
    }
    AppMethodBeat.o(73120);
    return false;
  }
  
  private void ci(final Context paramContext)
  {
    AppMethodBeat.i(73119);
    this.mEditText = ((TenpaySecureEditText)af.mU(paramContext).inflate(a.g.hint_view_passwd, this, true).findViewById(a.f.wallet_content));
    if ((this.agVA == agVx) && (aw.isDarkMode())) {
      this.agVA = agVy;
    }
    if (this.agVC == 1) {
      this.agVA = a.c.transparent;
    }
    TenpaySecureEditText localTenpaySecureEditText = this.mEditText;
    int i = this.LpR;
    boolean bool;
    if (this.agVC == 1)
    {
      bool = true;
      b.a(localTenpaySecureEditText, i, bool);
      this.agVz = getNumberSize();
      if (this.mEditText == null) {
        break label230;
      }
      this.mEditText.setBackgroundResource(this.agVA);
      this.mEditText.setImeOptions(6);
      this.mEditText.setInputType(128);
      this.mEditText.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(73115);
          paramAnonymousEditable = EditHintPasswdView.b(EditHintPasswdView.this).getText().toString();
          EditHintPasswdView.this.setContentDescription(paramContext.getString(a.i.wc_pay_accessbility_pwd_view, new Object[] { paramAnonymousEditable.length() }));
          if (EditHintPasswdView.c(EditHintPasswdView.this) != null) {
            EditHintPasswdView.c(EditHintPasswdView.this).onInputValidChange(EditHintPasswdView.d(EditHintPasswdView.this));
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
    }
    for (;;)
    {
      setContentDescription(paramContext.getString(a.i.wc_pay_accessbility_pwd_view, new Object[] { "0" }));
      this.mEditText.setImportantForAccessibility(2);
      AppMethodBeat.o(73119);
      return;
      bool = false;
      break;
      label230:
      Log.e("MicroMsg.EditHintPasswdView", "hy: no edit text view");
    }
  }
  
  private int getNumberSize()
  {
    AppMethodBeat.i(73121);
    switch (this.LpR)
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
  
  public final void aGC(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(242245);
    this.agVC = paramInt;
    TenpaySecureEditText localTenpaySecureEditText;
    if (this.agVC == 1)
    {
      this.agVA = a.c.transparent;
      this.mEditText.setBackgroundResource(this.agVA);
      localTenpaySecureEditText = this.mEditText;
      paramInt = this.LpR;
      if (this.agVC != 1) {
        break label96;
      }
    }
    for (;;)
    {
      b.a(localTenpaySecureEditText, paramInt, bool);
      AppMethodBeat.o(242245);
      return;
      if (aw.isDarkMode())
      {
        this.agVA = agVy;
        break;
      }
      this.agVA = agVx;
      break;
      label96:
      bool = false;
    }
  }
  
  public final void gGd()
  {
    AppMethodBeat.i(73126);
    if (this.mEditText != null) {
      this.mEditText.ClearInput();
    }
    AppMethodBeat.o(73126);
  }
  
  public final TenpaySecureEditText getEditText()
  {
    return this.mEditText;
  }
  
  public final int getEncrType()
  {
    return this.agVB;
  }
  
  public final int getFormat()
  {
    return this.LpR;
  }
  
  public final String getMd5Value()
  {
    AppMethodBeat.i(73118);
    if (this.mEditText != null)
    {
      String str = this.mEditText.getPasswordHash();
      AppMethodBeat.o(73118);
      return str;
    }
    Log.w("MicroMsg.EditHintPasswdView", "hy: edit view is null");
    AppMethodBeat.o(73118);
    return "";
  }
  
  public final a getOnEditInputValidListener()
  {
    return this.agVD;
  }
  
  public final View.OnFocusChangeListener getOnFocusChangeListener()
  {
    return this.qiH;
  }
  
  public final String getPwdNonce()
  {
    return this.pwdNonce;
  }
  
  public final long getPwdTimestamp()
  {
    return this.pwdTimestamp;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(73125);
    if (this.mEditText != null)
    {
      String str = c.a.a(this.agVB, this.mEditText, this.pwdTimestamp, this.pwdNonce);
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
    if (this.qiH != null) {
      this.qiH.onFocusChange(this, paramBoolean);
    }
    if (this.agVD != null) {
      this.agVD.onInputValidChange(bZp());
    }
    AppMethodBeat.o(73128);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73127);
    setMeasuredDimension(getDefaultSize(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 720.0F), paramInt2));
    int j;
    int i;
    if (this.agVC == 0)
    {
      j = getMeasuredWidth();
      if (this.agVz == 0)
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
      paramInt1 = j / this.agVz;
      break;
      j = getMeasuredWidth();
      i = getMeasuredHeight();
      paramInt2 = (j - a.fromDPToPix(getContext(), 8) * (this.agVz - 1)) / this.agVz;
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
    this.agVB = paramInt;
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.qiH = paramOnFocusChangeListener;
  }
  
  public final void setOnInputValidListener(a parama)
  {
    this.agVD = parama;
  }
  
  public final void setPwdNonce(String paramString)
  {
    this.pwdNonce = paramString;
  }
  
  public final void setPwdTimestamp(long paramLong)
  {
    this.pwdTimestamp = paramLong;
  }
  
  public static abstract interface a
  {
    public abstract void onInputValidChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView
 * JD-Core Version:    0.7.0.1
 */