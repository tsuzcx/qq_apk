package com.tencent.mm.plugin.recharge.ui.form;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class MallFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private TextView haW = null;
  private TextView nrU = null;
  public EditText nrV = null;
  private WalletIconImageView nrW = null;
  private TextView nrX = null;
  private MallFormView.a nrY = null;
  private View.OnFocusChangeListener nrZ = null;
  private View.OnClickListener nsa = null;
  private a nsb = null;
  private b nsc = null;
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
  public boolean nsz = true;
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MallFormAttrs, paramInt, 0);
    this.nsd = paramAttributeSet.getResourceId(a.k.MallFormAttrs_malllayoutRes, this.nsd);
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_malltitleText, 0);
    if (paramInt != 0) {
      this.nse = paramContext.getString(paramInt);
    }
    this.nsi = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallinfoIvRes, this.nsi);
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_malltipsText, 0);
    if (paramInt != 0) {
      this.nsk = paramContext.getString(paramInt);
    }
    this.nsj = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallinfoIvVisibility, this.nsj);
    this.nsf = paramAttributeSet.getInteger(a.k.MallFormAttrs_malltitleTvVisibility, this.nsf);
    this.nsl = paramAttributeSet.getInteger(a.k.MallFormAttrs_malltipsTvVisibility, this.nsl);
    this.nsh = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallprefilledTvVisibility, this.nsh);
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallprefilledText, 0);
    if (paramInt != 0) {
      this.nsg = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallcontentHint, 0);
    if (paramInt != 0) {
      this.nsm = paramContext.getString(paramInt);
    }
    this.nsn = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallcontentGravity, this.nsn);
    this.nso = paramAttributeSet.getColor(a.k.MallFormAttrs_mallcontentTextColor, this.nso);
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallcontentText, 0);
    if (paramInt != 0) {
      this.nsp = paramContext.getString(paramInt);
    }
    this.nsq = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallcontentMaxSize, this.nsq);
    this.nsr = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallcontentMinSize, this.nsr);
    this.nss = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallcontentBackground, this.nss);
    this.nst = paramAttributeSet.getBoolean(a.k.MallFormAttrs_mallcontentEnabled, this.nst);
    this.nsu = paramAttributeSet.getBoolean(a.k.MallFormAttrs_mallcontentClickable, this.nsu);
    this.nsv = paramAttributeSet.getBoolean(a.k.MallFormAttrs_mallcontentEnabled, this.nsv);
    this.nsw = paramAttributeSet.getInteger(a.k.MallFormAttrs_android_inputType, this.nsw);
    this.nsx = paramAttributeSet.getInteger(a.k.MallFormAttrs_android_imeOptions, this.nsx);
    this.nsy = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallcontentHintTextColor, this.nsy);
    paramAttributeSet.recycle();
    if (this.nsd > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    inflate(paramContext, this.nsd, this);
    this.haW = ((TextView)findViewById(a.f.mall_title));
    this.nrU = ((TextView)findViewById(a.f.mall_prefilled));
    this.nrV = ((EditText)findViewById(a.f.mall_content));
    this.nrW = ((WalletIconImageView)findViewById(a.f.mall_info));
    this.nrX = ((TextView)findViewById(a.f.mall_tips_msg));
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
  
  public final boolean YL()
  {
    if (this.nrV != null)
    {
      if (this.nrV.getText() == null) {}
      for (int i = 0; (i > this.nsq) || (i < this.nsr); i = this.nrV.getText().length()) {
        return false;
      }
      if (this.nsc != null) {
        return this.nsc.a(this);
      }
      return true;
    }
    y.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
    return true;
  }
  
  public final void bvp()
  {
    if ((this.nrW != null) && (!bk.bl(getText())) && (this.nrV != null) && (this.nrV.isEnabled()) && (this.nrV.isClickable()) && (this.nrV.isFocusable()) && (this.nrV.isFocused()))
    {
      this.nrW.setToClearState(new MallFormView.2(this));
      return;
    }
    if (this.nrW != null)
    {
      this.nrW.cov();
      return;
    }
    y.v("MicroMsg.WalletFormView", "hy: no info iv");
  }
  
  public final void bvq()
  {
    y.d("MicroMsg.WalletFormView", "shouldClearFocus: %s", new Object[] { Boolean.valueOf(this.nsz) });
    if (this.nsz)
    {
      getContentEditText().clearFocus();
      return;
    }
    this.nsz = true;
  }
  
  public final void bvr()
  {
    if (this.nrV != null) {
      this.nrV.setText("");
    }
  }
  
  public final EditText getContentEditText()
  {
    return this.nrV;
  }
  
  public final a getEventDelegate()
  {
    return this.nsb;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.nrW;
  }
  
  public final int getInputLength()
  {
    if (this.nrV != null) {
      return this.nrV.getText().length();
    }
    return 0;
  }
  
  public final MallFormView.a getInputValidChangeListener()
  {
    return this.nrY;
  }
  
  public final KeyListener getKeyListener()
  {
    if (this.nrV != null) {
      return this.nrV.getKeyListener();
    }
    y.w("MicroMsg.WalletFormView", "hy: no content et");
    return null;
  }
  
  public final b getLogicDelegate()
  {
    return this.nsc;
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
    if (this.nrV != null)
    {
      String str2 = this.nrV.getText().toString();
      String str1 = str2;
      if (this.nsc != null)
      {
        str1 = str2;
        if (this.nsc.bvo()) {
          str1 = this.nsc.LF(str2);
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
    if (getTitleTv() != null)
    {
      getTitleTv().setText(this.nse);
      getTitleTv().setVisibility(this.nsf);
    }
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
    getContext();
    if (this.nrV != null)
    {
      this.nrV.setHint(this.nsm);
      this.nrV.setGravity(this.nsn);
      this.nrV.setTextColor(this.nso);
      setText(this.nsp);
      this.nrV.setBackgroundResource(this.nss);
      this.nrV.setEnabled(this.nst);
      this.nrV.setFocusable(this.nsv);
      this.nrV.setClickable(this.nsu);
      this.nrV.setHintTextColor(this.nsy);
      setImeOptions(this.nsx);
      setInputType(this.nsw);
      this.nrV.addTextChangedListener(new MallFormView.1(this));
      this.nrV.setOnFocusChangeListener(this);
    }
    bvp();
    if (this.nrV != null)
    {
      if (this.nsw != 2) {
        break label335;
      }
      this.nrV.setKeyListener(new NumberKeyListener()
      {
        protected final char[] getAcceptedChars()
        {
          return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48 };
        }
        
        public final int getInputType()
        {
          return 3;
        }
      });
    }
    for (;;)
    {
      if (this.nsq != -1) {
        this.nrV.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.nsq) });
      }
      return;
      label335:
      if (this.nsw == 4)
      {
        this.nrV.setKeyListener(new MallFormView.4(this));
      }
      else if (this.nsw == 128)
      {
        this.nrV.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.nrV.setKeyListener(new MallFormView.5(this));
        this.nrV.setRawInputType(18);
      }
      else if (this.nsw == 3)
      {
        this.nrV.setKeyListener(new MallFormView.6(this));
      }
      else
      {
        this.nrV.setInputType(this.nsw);
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.nrZ != null) {
      this.nrZ.onFocusChange(this, paramBoolean);
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
    if ((this.nsb == null) || (!this.nsb.bvn()))
    {
      if ((this.nrV != null) && (b(this.nrV, paramMotionEvent)) && (!this.nrV.isClickable())) {
        y.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
      }
    }
    else {
      return true;
    }
    if ((b(this.nrW, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
    {
      y.d("MicroMsg.WalletFormView", "hy: click on info iv");
      this.nrW.performClick();
      return true;
    }
    return false;
  }
  
  @SuppressLint({"WrongCall"})
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.nsb == null) || (!this.nsb.bvm())) {
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  public final void setEventDelegate(a parama)
  {
    this.nsb = parama;
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    if (this.nrV != null) {
      this.nrV.setFilters(paramArrayOfInputFilter);
    }
  }
  
  public final void setHint(String paramString)
  {
    if (this.nrV != null) {
      this.nrV.setHint(paramString);
    }
  }
  
  public final void setImeOptions(int paramInt)
  {
    if (this.nrV != null) {
      this.nrV.setImeOptions(paramInt);
    }
  }
  
  public final void setInputType(int paramInt)
  {
    if (this.nrV != null) {
      this.nrV.setInputType(paramInt);
    }
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    if (this.nrV != null) {
      this.nrV.setKeyListener(paramKeyListener);
    }
  }
  
  public final void setLogicDelegate(b paramb)
  {
    this.nsc = paramb;
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
    this.nrV.setOnEditorActionListener(paramOnEditorActionListener);
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
  
  public final void setOnInputValidChangeListener(MallFormView.a parama)
  {
    this.nrY = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    if (this.nrV != null) {
      this.nrV.setSelection(paramInt);
    }
  }
  
  public final void setText(String paramString)
  {
    if (this.nrV != null)
    {
      this.nrV.setText(paramString);
      this.nrV.setSelection(getInputLength());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.MallFormView
 * JD-Core Version:    0.7.0.1
 */