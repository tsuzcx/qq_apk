package com.tencent.mm.plugin.recharge.ui.form;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import junit.framework.Assert;

public final class MallFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private TextView kEu;
  private boolean uZA;
  private boolean uZB;
  private boolean uZC;
  private int uZD;
  private int uZE;
  private int uZF;
  public boolean uZG;
  private TextView uZb;
  public EditText uZc;
  private WalletIconImageView uZd;
  private TextView uZe;
  private a uZf;
  private View.OnFocusChangeListener uZg;
  private View.OnClickListener uZh;
  private a uZi;
  private b uZj;
  private int uZk;
  private String uZl;
  private int uZm;
  private String uZn;
  private int uZo;
  private int uZp;
  private int uZq;
  private String uZr;
  private int uZs;
  private String uZt;
  private int uZu;
  private int uZv;
  private String uZw;
  private int uZx;
  private int uZy;
  private int uZz;
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67287);
    this.kEu = null;
    this.uZb = null;
    this.uZc = null;
    this.uZd = null;
    this.uZe = null;
    this.uZf = null;
    this.uZg = null;
    this.uZh = null;
    this.uZi = null;
    this.uZj = null;
    this.uZk = -1;
    this.uZl = "";
    this.uZm = 0;
    this.uZn = "";
    this.uZo = 8;
    this.uZp = -1;
    this.uZq = 4;
    this.uZr = "";
    this.uZs = 8;
    this.uZt = "";
    this.uZu = 19;
    this.uZv = 2131100711;
    this.uZw = "";
    this.uZx = 2147483647;
    this.uZy = 1;
    this.uZz = 2131233299;
    this.uZA = true;
    this.uZB = false;
    this.uZC = true;
    this.uZD = 1;
    this.uZE = 5;
    this.uZF = 2131100551;
    this.uZG = true;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MallFormAttrs, paramInt, 0);
    this.uZk = paramAttributeSet.getResourceId(17, this.uZk);
    paramInt = paramAttributeSet.getResourceId(23, 0);
    if (paramInt != 0) {
      this.uZl = paramContext.getString(paramInt);
    }
    this.uZp = paramAttributeSet.getResourceId(14, this.uZp);
    paramInt = paramAttributeSet.getResourceId(21, 0);
    if (paramInt != 0) {
      this.uZr = paramContext.getString(paramInt);
    }
    this.uZq = paramAttributeSet.getInteger(15, this.uZq);
    this.uZm = paramAttributeSet.getInteger(25, this.uZm);
    this.uZs = paramAttributeSet.getInteger(22, this.uZs);
    this.uZo = paramAttributeSet.getInteger(20, this.uZo);
    paramInt = paramAttributeSet.getResourceId(18, 0);
    if (paramInt != 0) {
      this.uZn = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(8, 0);
    if (paramInt != 0) {
      this.uZt = paramContext.getString(paramInt);
    }
    this.uZu = paramAttributeSet.getInteger(7, this.uZu);
    this.uZv = paramAttributeSet.getColor(13, this.uZv);
    paramInt = paramAttributeSet.getResourceId(12, 0);
    if (paramInt != 0) {
      this.uZw = paramContext.getString(paramInt);
    }
    this.uZx = paramAttributeSet.getInteger(10, this.uZx);
    this.uZy = paramAttributeSet.getInteger(11, this.uZy);
    this.uZz = paramAttributeSet.getResourceId(2, this.uZz);
    this.uZA = paramAttributeSet.getBoolean(4, this.uZA);
    this.uZB = paramAttributeSet.getBoolean(3, this.uZB);
    this.uZC = paramAttributeSet.getBoolean(4, this.uZC);
    this.uZD = paramAttributeSet.getInteger(0, this.uZD);
    this.uZE = paramAttributeSet.getInteger(1, this.uZE);
    this.uZF = paramAttributeSet.getInteger(9, this.uZF);
    paramAttributeSet.recycle();
    if (this.uZk > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    inflate(paramContext, this.uZk, this);
    this.kEu = ((TextView)findViewById(2131302142));
    this.uZb = ((TextView)findViewById(2131302084));
    this.uZc = ((EditText)findViewById(2131302008));
    this.uZd = ((WalletIconImageView)findViewById(2131302020));
    this.uZe = ((TextView)findViewById(2131302141));
    AppMethodBeat.o(67287);
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67299);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (eg(paramView).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        AppMethodBeat.o(67299);
        return true;
      }
      AppMethodBeat.o(67299);
      return false;
    }
    AppMethodBeat.o(67299);
    return false;
  }
  
  private Rect eg(View paramView)
  {
    AppMethodBeat.i(67300);
    if (paramView != null)
    {
      Rect localRect = new Rect();
      paramView.getHitRect(localRect);
      paramView = k(paramView, localRect);
      AppMethodBeat.o(67300);
      return paramView;
    }
    AppMethodBeat.o(67300);
    return null;
  }
  
  private Rect k(View paramView, Rect paramRect)
  {
    if (paramView == this.uZd)
    {
      paramRect.left -= 50;
      paramRect.right += 50;
      paramRect.top -= 25;
      paramRect.bottom += 25;
    }
    return paramRect;
  }
  
  public final boolean aKX()
  {
    AppMethodBeat.i(67308);
    if (this.uZc != null)
    {
      if (this.uZc.getText() == null) {}
      for (int i = 0; (i > this.uZx) || (i < this.uZy); i = this.uZc.getText().length())
      {
        AppMethodBeat.o(67308);
        return false;
      }
      if (this.uZj != null)
      {
        boolean bool = this.uZj.a(this);
        AppMethodBeat.o(67308);
        return bool;
      }
      AppMethodBeat.o(67308);
      return true;
    }
    ad.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
    AppMethodBeat.o(67308);
    return true;
  }
  
  public final void dfY()
  {
    AppMethodBeat.i(67291);
    if ((this.uZd != null) && (!bt.isNullOrNil(getText())) && (this.uZc != null) && (this.uZc.isEnabled()) && (this.uZc.isClickable()) && (this.uZc.isFocusable()) && (this.uZc.isFocused()))
    {
      this.uZd.setToClearState(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67286);
          MallFormView.this.dga();
          AppMethodBeat.o(67286);
        }
      });
      AppMethodBeat.o(67291);
      return;
    }
    if (this.uZd != null)
    {
      this.uZd.eBb();
      AppMethodBeat.o(67291);
      return;
    }
    ad.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(67291);
  }
  
  public final void dfZ()
  {
    AppMethodBeat.i(67301);
    ad.d("MicroMsg.WalletFormView", "shouldClearFocus: %s", new Object[] { Boolean.valueOf(this.uZG) });
    if (this.uZG)
    {
      getContentEditText().clearFocus();
      AppMethodBeat.o(67301);
      return;
    }
    this.uZG = true;
    AppMethodBeat.o(67301);
  }
  
  public final void dga()
  {
    AppMethodBeat.i(67309);
    if (this.uZc != null) {
      this.uZc.setText("");
    }
    AppMethodBeat.o(67309);
  }
  
  public final EditText getContentEditText()
  {
    return this.uZc;
  }
  
  public final a getEventDelegate()
  {
    return this.uZi;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.uZd;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(67311);
    if (this.uZc != null)
    {
      int i = this.uZc.getText().length();
      AppMethodBeat.o(67311);
      return i;
    }
    AppMethodBeat.o(67311);
    return 0;
  }
  
  public final a getInputValidChangeListener()
  {
    return this.uZf;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(67304);
    if (this.uZc != null)
    {
      KeyListener localKeyListener = this.uZc.getKeyListener();
      AppMethodBeat.o(67304);
      return localKeyListener;
    }
    ad.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(67304);
    return null;
  }
  
  public final b getLogicDelegate()
  {
    return this.uZj;
  }
  
  public final int getMaxInputLength()
  {
    return this.uZx;
  }
  
  public final int getMinInputLength()
  {
    return this.uZy;
  }
  
  public final TextView getPrefilledTv()
  {
    return this.uZb;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(67303);
    if (this.uZc != null)
    {
      String str = this.uZc.getText().toString();
      if ((this.uZj != null) && (this.uZj.dfX()))
      {
        str = this.uZj.alr(str);
        AppMethodBeat.o(67303);
        return str;
      }
      AppMethodBeat.o(67303);
      return str;
    }
    ad.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
    AppMethodBeat.o(67303);
    return "";
  }
  
  public final TextView getTipsTv()
  {
    return this.uZe;
  }
  
  public final TextView getTitleTv()
  {
    return this.kEu;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(67292);
    super.onAttachedToWindow();
    AppMethodBeat.o(67292);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(67293);
    super.onDetachedFromWindow();
    AppMethodBeat.o(67293);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(67294);
    super.onFinishInflate();
    if (getTitleTv() != null)
    {
      getTitleTv().setText(this.uZl);
      getTitleTv().setVisibility(this.uZm);
    }
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.uZn);
      getPrefilledTv().setVisibility(this.uZo);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.uZp);
      getInfoIv().setVisibility(this.uZq);
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.uZr);
      getTipsTv().setVisibility(this.uZs);
    }
    getContext();
    if (this.uZc != null)
    {
      this.uZc.setHint(this.uZt);
      this.uZc.setGravity(this.uZu);
      this.uZc.setTextColor(this.uZv);
      setText(this.uZw);
      this.uZc.setBackgroundResource(this.uZz);
      this.uZc.setEnabled(this.uZA);
      this.uZc.setFocusable(this.uZC);
      this.uZc.setClickable(this.uZB);
      this.uZc.setHintTextColor(this.uZF);
      setImeOptions(this.uZE);
      setInputType(this.uZD);
      this.uZc.addTextChangedListener(new TextWatcher()
      {
        private boolean uZH = false;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(67285);
          if (MallFormView.this.aKX() != this.uZH)
          {
            if (MallFormView.c(MallFormView.this) != null) {
              MallFormView.c(MallFormView.this).onInputValidChange(MallFormView.this.aKX());
            }
            this.uZH = MallFormView.this.aKX();
          }
          MallFormView.this.dfY();
          AppMethodBeat.o(67285);
        }
      });
      this.uZc.setOnFocusChangeListener(this);
    }
    dfY();
    if (this.uZc != null)
    {
      if (this.uZD != 2) {
        break label347;
      }
      this.uZc.setKeyListener(new NumberKeyListener()
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
      if (this.uZx != -1) {
        this.uZc.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.uZx) });
      }
      AppMethodBeat.o(67294);
      return;
      label347:
      if (this.uZD == 4)
      {
        this.uZc.setKeyListener(new NumberKeyListener()
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
      else if (this.uZD == 128)
      {
        this.uZc.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.uZc.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48 };
          }
          
          public final int getInputType()
          {
            return 18;
          }
        });
        this.uZc.setRawInputType(18);
      }
      else if (this.uZD == 3)
      {
        this.uZc.setKeyListener(new NumberKeyListener()
        {
          protected final char[] getAcceptedChars()
          {
            return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 45 };
          }
          
          public final int getInputType()
          {
            return 3;
          }
        });
      }
      else
      {
        this.uZc.setInputType(this.uZD);
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(67312);
    if (this.uZg != null) {
      this.uZg.onFocusChange(this, paramBoolean);
    }
    if (!aKX()) {
      if (this.kEu != null) {
        this.kEu.setEnabled(false);
      }
    }
    for (;;)
    {
      dfY();
      AppMethodBeat.o(67312);
      return;
      if (this.kEu != null) {
        this.kEu.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67298);
    if ((this.uZi == null) || (!this.uZi.dfW()))
    {
      if ((this.uZc != null) && (b(this.uZc, paramMotionEvent)) && (!this.uZc.isClickable()))
      {
        ad.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(67298);
        return true;
      }
      if ((b(this.uZd, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        ad.d("MicroMsg.WalletFormView", "hy: click on info iv");
        this.uZd.performClick();
        AppMethodBeat.o(67298);
        return true;
      }
      AppMethodBeat.o(67298);
      return false;
    }
    AppMethodBeat.o(67298);
    return true;
  }
  
  @SuppressLint({"WrongCall"})
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67297);
    if ((this.uZi == null) || (!this.uZi.dfV())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(67297);
  }
  
  public final void setEventDelegate(a parama)
  {
    this.uZi = parama;
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(67310);
    if (this.uZc != null) {
      this.uZc.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(67310);
  }
  
  public final void setHint(String paramString)
  {
    AppMethodBeat.i(67295);
    if (this.uZc != null) {
      this.uZc.setHint(paramString);
    }
    AppMethodBeat.o(67295);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(67288);
    if (this.uZc != null) {
      this.uZc.setImeOptions(paramInt);
    }
    AppMethodBeat.o(67288);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(67289);
    if (this.uZc != null) {
      this.uZc.setInputType(paramInt);
    }
    AppMethodBeat.o(67289);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(67307);
    if (this.uZc != null) {
      this.uZc.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(67307);
  }
  
  public final void setLogicDelegate(b paramb)
  {
    this.uZj = paramb;
  }
  
  public final void setMaxInputLength(int paramInt)
  {
    this.uZx = paramInt;
  }
  
  public final void setMinInputLength(int paramInt)
  {
    this.uZy = paramInt;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67305);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(67305);
  }
  
  public final void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(67296);
    this.uZc.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(67296);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.uZg = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67306);
    this.uZh = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.uZh);
    }
    AppMethodBeat.o(67306);
  }
  
  public final void setOnInputValidChangeListener(a parama)
  {
    this.uZf = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(67302);
    if (this.uZc != null) {
      this.uZc.setSelection(paramInt);
    }
    AppMethodBeat.o(67302);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(67290);
    if (this.uZc != null)
    {
      this.uZc.setText(paramString);
      this.uZc.setSelection(getInputLength());
    }
    AppMethodBeat.o(67290);
  }
  
  public static abstract interface a
  {
    public abstract void onInputValidChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.MallFormView
 * JD-Core Version:    0.7.0.1
 */