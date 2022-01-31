package com.tencent.mm.wallet_core.ui.formview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.a.a;
import com.tenpay.android.wechat.TenpaySecureEditText;
import junit.framework.Assert;

public final class WalletFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private TextView haW = null;
  private TextView nrU = null;
  private WalletIconImageView nrW = null;
  private TextView nrX = null;
  private View.OnFocusChangeListener nrZ = null;
  private View.OnClickListener nsa = null;
  private int nsd = -1;
  private String nse = "";
  private int nsf = 0;
  private String nsg = "";
  private int nsh = 8;
  private int nsi = -1;
  private int nsj = 4;
  private String nsk = "";
  private int nsl = 8;
  private String nsm = "";
  private int nsn = 19;
  private int nso = a.c.normal_text_color;
  private String nsp = "";
  private int nsq = 2147483647;
  private int nsr = 1;
  private int nss = a.e.mm_trans;
  private boolean nst = true;
  private boolean nsu = false;
  private boolean nsv = true;
  private int nsw = 1;
  private int nsx = 5;
  private int nsy = a.c.list_devider_color;
  public TenpaySecureEditText wCS = null;
  private WalletFormView.a wCT = null;
  private a wCU = null;
  private com.tencent.mm.wallet_core.ui.formview.a.b wCV = null;
  private int wCW = this.nsd;
  private int wCX = 100;
  private int wCY = -1;
  private int wCZ = 0;
  @Deprecated
  private int wDa = 0;
  private int wDb = 0;
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.WalletFormAttrs, paramInt, 0);
    this.nsd = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_layoutRes, this.nsd);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_titleText, 0);
    if (paramInt != 0) {
      this.nse = paramContext.getString(paramInt);
    }
    this.nsi = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_infoIvRes, this.nsi);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_tipsText, 0);
    if (paramInt != 0) {
      this.nsk = paramContext.getString(paramInt);
    }
    this.nsj = paramAttributeSet.getInteger(a.k.WalletFormAttrs_infoIvVisibility, this.nsj);
    this.nsf = paramAttributeSet.getInteger(a.k.WalletFormAttrs_titleTvVisibility, this.nsf);
    this.nsl = paramAttributeSet.getInteger(a.k.WalletFormAttrs_tipsTvVisibility, this.nsl);
    this.nsh = paramAttributeSet.getInteger(a.k.WalletFormAttrs_prefilledTvVisibility, this.nsh);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_prefilledText, 0);
    if (paramInt != 0) {
      this.nsg = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_contentHint, 0);
    if (paramInt != 0) {
      this.nsm = paramContext.getString(paramInt);
    }
    this.wCY = paramAttributeSet.getDimensionPixelSize(a.k.WalletFormAttrs_contentHintSize, -1);
    this.nsn = paramAttributeSet.getInteger(a.k.WalletFormAttrs_contentGravity, this.nsn);
    this.nso = paramAttributeSet.getColor(a.k.WalletFormAttrs_contentTextColor, this.nso);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_contentText, 0);
    if (paramInt != 0) {
      this.nsp = paramContext.getString(paramInt);
    }
    this.wCZ = paramAttributeSet.getInt(a.k.WalletFormAttrs_contentFormat, this.wCZ);
    this.nsq = paramAttributeSet.getInteger(a.k.WalletFormAttrs_contentMaxSize, this.nsq);
    this.nsr = paramAttributeSet.getInteger(a.k.WalletFormAttrs_contentMinSize, this.nsr);
    this.nss = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_contentBackground, this.nss);
    this.nst = paramAttributeSet.getBoolean(a.k.WalletFormAttrs_contentEnabled, this.nst);
    this.nsu = paramAttributeSet.getBoolean(a.k.WalletFormAttrs_contentClickable, this.nsu);
    this.nsv = paramAttributeSet.getBoolean(a.k.WalletFormAttrs_contentEnabled, this.nsv);
    this.nsw = paramAttributeSet.getInteger(a.k.WalletFormAttrs_android_inputType, this.nsw);
    this.nsx = paramAttributeSet.getInteger(a.k.WalletFormAttrs_android_imeOptions, this.nsx);
    this.wCX = paramAttributeSet.getInteger(a.k.WalletFormAttrs_encryptType, this.wCX);
    this.nsy = paramAttributeSet.getInteger(a.k.WalletFormAttrs_contentHintTextColor, this.nsy);
    this.wCW = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_longTitleLayoutRes, this.wCW);
    this.wDa = paramAttributeSet.getInteger(a.k.WalletFormAttrs_typeface, 0);
    this.wDb = paramAttributeSet.getInteger(a.k.WalletFormAttrs_walletTypeFace, -1);
    if ((this.wDa == 1) && (this.wDb == -1)) {
      this.wDb = 4;
    }
    paramAttributeSet.recycle();
    if (this.nsd > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    if ((!bk.bl(this.nse)) && (this.nse.length() > 6)) {
      inflate(paramContext, this.wCW, this);
    }
    for (;;)
    {
      this.haW = ((TextView)findViewById(a.f.wallet_title));
      this.nrU = ((TextView)findViewById(a.f.wallet_prefilled));
      this.wCS = ((TenpaySecureEditText)findViewById(a.f.wallet_content));
      this.nrW = ((WalletIconImageView)findViewById(a.f.wallet_info));
      this.nrX = ((TextView)findViewById(a.f.wallet_tips_msg));
      return;
      inflate(paramContext, this.nsd, this);
    }
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      Rect localRect2;
      if (paramView != null)
      {
        localRect2 = new Rect();
        paramView.getHitRect(localRect2);
        localRect1 = localRect2;
        if (paramView == this.nrW)
        {
          localRect2.left -= 50;
          localRect2.right += 50;
          localRect2.top -= 25;
          localRect2.bottom += 25;
        }
      }
      for (Rect localRect1 = localRect2; localRect1.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()); localRect1 = null) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  private void bvp()
  {
    if ((this.nrW != null) && (!bk.bl(getText())) && (this.wCS != null) && (this.wCS.isEnabled()) && (this.wCS.isClickable()) && (this.wCS.isFocusable()) && (this.wCS.isFocused()))
    {
      this.nrW.setToClearState(new WalletFormView.2(this));
      return;
    }
    if (this.nrW != null)
    {
      this.nrW.cov();
      return;
    }
    y.v("MicroMsg.WalletFormView", "hy: no info iv");
  }
  
  private void cNw()
  {
    if (getTitleTv() != null)
    {
      getTitleTv().setText(this.nse);
      getTitleTv().setVisibility(this.nsf);
    }
  }
  
  public final boolean YL()
  {
    boolean bool = true;
    if (this.wCS != null)
    {
      int i = this.wCS.getInputLength();
      if ((i > this.nsq) || (i < this.nsr)) {
        bool = false;
      }
      while (this.wCV == null) {
        return bool;
      }
      return this.wCV.a(this);
    }
    y.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
    return true;
  }
  
  public final void a(TextWatcher paramTextWatcher)
  {
    if (this.wCS != null) {
      this.wCS.addTextChangedListener(paramTextWatcher);
    }
  }
  
  public final void bvq()
  {
    if (this.wCS != null) {
      this.wCS.clearFocus();
    }
  }
  
  public final void bvr()
  {
    if (this.wCS != null) {
      this.wCS.ClearInput();
    }
  }
  
  public final void cNu()
  {
    if (this.wCS != null) {
      this.wCS.setPadding(0, 0, 0, 0);
    }
  }
  
  public final boolean cNv()
  {
    if (this.wCS != null) {
      return this.wCS.isFocusable();
    }
    return false;
  }
  
  public final void cNx()
  {
    if (this.wCS != null)
    {
      this.wCS.setFocusable(true);
      this.wCS.requestFocus();
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.wCS, 0);
    }
  }
  
  public final void d(WalletBaseUI paramWalletBaseUI)
  {
    if (this.wCS != null)
    {
      this.wCS.setFocusable(true);
      this.wCS.requestFocus();
      paramWalletBaseUI.cNi();
    }
  }
  
  public final boolean eq(View paramView)
  {
    if (getVisibility() == 0)
    {
      if (bk.bl(getText()))
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.haW != null) {
          this.haW.setEnabled(true);
        }
      }
      do
      {
        return false;
        if (YL())
        {
          if (paramView != null) {
            paramView.setVisibility(4);
          }
          if (this.haW != null) {
            this.haW.setEnabled(true);
          }
          return true;
        }
        if (paramView != null) {
          paramView.setVisibility(0);
        }
      } while (this.haW == null);
      this.haW.setEnabled(false);
      return false;
    }
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    return true;
  }
  
  public final int getEncrptType()
  {
    return this.wCX;
  }
  
  public final a getEventDelegate()
  {
    return this.wCU;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.nrW;
  }
  
  public final int getInputLength()
  {
    if (this.wCS != null) {
      return this.wCS.getInputLength();
    }
    return 0;
  }
  
  public final WalletFormView.a getInputValidChangeListener()
  {
    return this.wCT;
  }
  
  public final KeyListener getKeyListener()
  {
    if (this.wCS != null) {
      return this.wCS.getKeyListener();
    }
    y.w("MicroMsg.WalletFormView", "hy: no content et");
    return null;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.b getLogicDelegate()
  {
    return this.wCV;
  }
  
  public final String getMD5Value()
  {
    String str2 = bk.pm(this.wCS.getText().toString());
    String str1 = str2;
    if (this.wCV != null)
    {
      str1 = str2;
      if (this.wCV.bvo()) {
        str1 = this.wCV.e(this, str2);
      }
    }
    return ad.bB(str1);
  }
  
  public final int getMaxInputLength()
  {
    return this.nsq;
  }
  
  public final int getMinInputLength()
  {
    return this.nsr;
  }
  
  public final TextView getPrefilledTv()
  {
    return this.nrU;
  }
  
  public final String getText()
  {
    if (this.wCS != null)
    {
      String str2 = c.a.a(this.wCX, this.wCS);
      String str1 = str2;
      if (this.wCV != null)
      {
        str1 = str2;
        if (this.wCV.bvo()) {
          str1 = this.wCV.e(this, str2);
        }
      }
      return str1;
    }
    y.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
    return "";
  }
  
  public final TextView getTipsTv()
  {
    return this.nrX;
  }
  
  public final TextView getTitleTv()
  {
    return this.haW;
  }
  
  public final boolean isPhoneNum()
  {
    if (this.wCS == null) {
      return false;
    }
    return this.wCS.isPhoneNum();
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected final void onFinishInflate()
  {
    super.onFinishInflate();
    cNw();
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.nsg);
      getPrefilledTv().setVisibility(this.nsh);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.nsi);
      getInfoIv().setVisibility(this.nsj);
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.nsk);
      getTipsTv().setVisibility(this.nsl);
    }
    Object localObject = getContext();
    if (this.wCS != null)
    {
      if (this.wDb >= 0)
      {
        String str = e.Ja(this.wDb);
        this.wCS.setTypeface(Typeface.createFromAsset(((Context)localObject).getAssets(), str));
      }
      if (this.wCY == -1)
      {
        this.wCS.setHint(this.nsm);
        this.wCS.setGravity(this.nsn);
        this.wCS.setTextColor(this.nso);
        setText(this.nsp);
        b.a(this.wCS, this.wCZ);
        this.wCS.setBackgroundResource(this.nss);
        this.wCS.setEnabled(this.nst);
        this.wCS.setFocusable(this.nsv);
        this.wCS.setClickable(this.nsu);
        this.wCS.setHintTextColor(this.nsy);
        setImeOptions(this.nsx);
        setInputType(this.nsw);
        this.wCS.addTextChangedListener(new WalletFormView.1(this));
        this.wCS.setOnFocusChangeListener(this);
      }
    }
    else
    {
      bvp();
      if (this.wCS != null)
      {
        if (this.nsw != 2) {
          break label412;
        }
        this.wCS.setKeyListener(new WalletFormView.3(this));
      }
    }
    for (;;)
    {
      if (this.nsq != -1) {
        this.wCS.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.nsq) });
      }
      return;
      localObject = new SpannableString(this.nsm);
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(this.wCY, false), 0, ((SpannableString)localObject).length(), 33);
      this.wCS.setHint(new SpannedString((CharSequence)localObject));
      break;
      label412:
      if (this.nsw == 4)
      {
        this.wCS.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 120, 88 };
          }
          
          public final int getInputType()
          {
            return 1;
          }
        });
      }
      else if (this.nsw == 128)
      {
        this.wCS.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.wCS.setKeyListener(new WalletFormView.5(this));
        this.wCS.setRawInputType(18);
      }
      else if (this.nsw == 3)
      {
        this.wCS.setKeyListener(new WalletFormView.6(this));
      }
      else
      {
        this.wCS.setInputType(this.nsw);
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.nrZ != null) {
      this.nrZ.onFocusChange(this, paramBoolean);
    }
    if (this.wCT != null) {
      this.wCT.gG(YL());
    }
    if (!YL()) {
      if (this.haW != null) {
        this.haW.setEnabled(false);
      }
    }
    for (;;)
    {
      bvp();
      return;
      if (this.haW != null) {
        this.haW.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.wCU == null) || (!this.wCU.cNz()))
    {
      if ((this.wCS != null) && (b(this.wCS, paramMotionEvent)) && (!this.wCS.isClickable())) {
        y.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
      }
    }
    else {
      return true;
    }
    if ((b(this.nrW, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
    {
      y.d("MicroMsg.WalletFormView", "hy: click on info iv");
      bvp();
      this.nrW.performClick();
      return true;
    }
    return false;
  }
  
  @SuppressLint({"WrongCall"})
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.wCU == null) || (!this.wCU.cNy())) {
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  public final void set3DesToView(String paramString)
  {
    if (this.wCS != null) {
      this.wCS.set3DesEncrptData(paramString);
    }
  }
  
  public final void set3DesValStr(String paramString)
  {
    if ((this.wCS != null) && ((this.wCV == null) || (!this.wCV.d(this, paramString))))
    {
      this.wCS.set3DesEncrptData(paramString);
      setSelection(getInputLength());
    }
  }
  
  public final void setBankcardTail(String paramString)
  {
    if (this.wCS != null) {
      this.wCS.setBankcardTailNum(paramString);
    }
  }
  
  public final void setContentClickable(boolean paramBoolean)
  {
    if (this.wCS != null) {
      this.wCS.setClickable(paramBoolean);
    }
  }
  
  public final void setContentEnabled(boolean paramBoolean)
  {
    if (this.wCS != null) {
      this.wCS.setEnabled(paramBoolean);
    }
  }
  
  public final void setContentFocusable(boolean paramBoolean)
  {
    if (this.wCS != null) {
      this.wCS.setFocusable(paramBoolean);
    }
  }
  
  public final void setContentTextColor(int paramInt)
  {
    if (this.wCS != null) {
      this.wCS.setTextColor(paramInt);
    }
  }
  
  @SuppressLint({"ResourceType"})
  public final void setContentTextColorRes(int paramInt)
  {
    this.nso = paramInt;
    if (this.wCS != null) {
      this.wCS.setTextColor(getResources().getColor(this.nso));
    }
  }
  
  public final void setEncryptType(int paramInt)
  {
    this.wCX = paramInt;
  }
  
  public final void setEventDelegate(a parama)
  {
    this.wCU = parama;
  }
  
  public final void setFilterChar(char[] paramArrayOfChar) {}
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    if (this.wCS != null) {
      this.wCS.setFilters(paramArrayOfInputFilter);
    }
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    if (this.wCS != null)
    {
      if (this.wCY == -1) {
        this.wCS.setHint(paramCharSequence);
      }
    }
    else {
      return;
    }
    paramCharSequence = new SpannableString(paramCharSequence);
    paramCharSequence.setSpan(new AbsoluteSizeSpan(this.wCY, false), 0, paramCharSequence.length(), 33);
    this.wCS.setHint(new SpannedString(paramCharSequence));
  }
  
  public final void setImeOptions(int paramInt)
  {
    if (this.wCS != null) {
      this.wCS.setImeOptions(paramInt);
    }
  }
  
  public final void setInputEnable(boolean paramBoolean)
  {
    if (this.wCS != null) {
      this.wCS.setEnabled(paramBoolean);
    }
  }
  
  public final void setInputType(int paramInt)
  {
    if (this.wCS != null) {
      this.wCS.setInputType(paramInt);
    }
  }
  
  public final void setIsSecretAnswer(boolean paramBoolean)
  {
    if (this.wCS != null) {
      this.wCS.setIsSecurityAnswerFormat(paramBoolean);
    }
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    if (this.wCS != null) {
      this.wCS.setKeyListener(paramKeyListener);
    }
  }
  
  public final void setLogicDelegate(com.tencent.mm.wallet_core.ui.formview.a.b paramb)
  {
    this.wCV = paramb;
  }
  
  public final void setMaxInputLength(int paramInt)
  {
    this.nsq = paramInt;
  }
  
  public final void setMinInputLength(int paramInt)
  {
    this.nsr = paramInt;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }
  
  public final void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    this.wCS.setOnEditorActionListener(paramOnEditorActionListener);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.nrZ = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    this.nsa = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.nsa);
    }
  }
  
  public final void setOnInputValidChangeListener(WalletFormView.a parama)
  {
    this.wCT = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    if (this.wCS != null) {
      this.wCS.setSelection(paramInt);
    }
  }
  
  public final void setText(String paramString)
  {
    if ((this.wCS != null) && ((this.wCV == null) || (!this.wCV.c(this, paramString))))
    {
      this.wCS.setText(paramString);
      this.wCS.setSelection(getInputLength());
    }
  }
  
  public final void setTitleText(String paramString)
  {
    this.nse = paramString;
    cNw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.WalletFormView
 * JD-Core Version:    0.7.0.1
 */