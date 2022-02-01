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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import junit.framework.Assert;

public final class MallFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private TextView lfN;
  private String tWv;
  private TextView whQ;
  public EditText whR;
  private WalletIconImageView whS;
  private TextView whT;
  private a whU;
  private View.OnFocusChangeListener whV;
  private View.OnClickListener whW;
  private a whX;
  private b whY;
  private int whZ;
  private int wia;
  private String wib;
  private int wic;
  private int wid;
  private int wie;
  private String wif;
  private int wig;
  private String wih;
  private int wii;
  private int wij;
  private String wik;
  private int wil;
  private int wim;
  private int win;
  private boolean wio;
  private boolean wip;
  private boolean wiq;
  private int wir;
  private int wis;
  private int wit;
  public boolean wiu;
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67287);
    this.lfN = null;
    this.whQ = null;
    this.whR = null;
    this.whS = null;
    this.whT = null;
    this.whU = null;
    this.whV = null;
    this.whW = null;
    this.whX = null;
    this.whY = null;
    this.whZ = -1;
    this.tWv = "";
    this.wia = 0;
    this.wib = "";
    this.wic = 8;
    this.wid = -1;
    this.wie = 4;
    this.wif = "";
    this.wig = 8;
    this.wih = "";
    this.wii = 19;
    this.wij = 2131100711;
    this.wik = "";
    this.wil = 2147483647;
    this.wim = 1;
    this.win = 2131233299;
    this.wio = true;
    this.wip = false;
    this.wiq = true;
    this.wir = 1;
    this.wis = 5;
    this.wit = 2131100551;
    this.wiu = true;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MallFormAttrs, paramInt, 0);
    this.whZ = paramAttributeSet.getResourceId(17, this.whZ);
    paramInt = paramAttributeSet.getResourceId(23, 0);
    if (paramInt != 0) {
      this.tWv = paramContext.getString(paramInt);
    }
    this.wid = paramAttributeSet.getResourceId(14, this.wid);
    paramInt = paramAttributeSet.getResourceId(21, 0);
    if (paramInt != 0) {
      this.wif = paramContext.getString(paramInt);
    }
    this.wie = paramAttributeSet.getInteger(15, this.wie);
    this.wia = paramAttributeSet.getInteger(25, this.wia);
    this.wig = paramAttributeSet.getInteger(22, this.wig);
    this.wic = paramAttributeSet.getInteger(20, this.wic);
    paramInt = paramAttributeSet.getResourceId(18, 0);
    if (paramInt != 0) {
      this.wib = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(8, 0);
    if (paramInt != 0) {
      this.wih = paramContext.getString(paramInt);
    }
    this.wii = paramAttributeSet.getInteger(7, this.wii);
    this.wij = paramAttributeSet.getColor(13, this.wij);
    paramInt = paramAttributeSet.getResourceId(12, 0);
    if (paramInt != 0) {
      this.wik = paramContext.getString(paramInt);
    }
    this.wil = paramAttributeSet.getInteger(10, this.wil);
    this.wim = paramAttributeSet.getInteger(11, this.wim);
    this.win = paramAttributeSet.getResourceId(2, this.win);
    this.wio = paramAttributeSet.getBoolean(4, this.wio);
    this.wip = paramAttributeSet.getBoolean(3, this.wip);
    this.wiq = paramAttributeSet.getBoolean(4, this.wiq);
    this.wir = paramAttributeSet.getInteger(0, this.wir);
    this.wis = paramAttributeSet.getInteger(1, this.wis);
    this.wit = paramAttributeSet.getInteger(9, this.wit);
    paramAttributeSet.recycle();
    if (this.whZ > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    inflate(paramContext, this.whZ, this);
    this.lfN = ((TextView)findViewById(2131302142));
    this.whQ = ((TextView)findViewById(2131302084));
    this.whR = ((EditText)findViewById(2131302008));
    this.whS = ((WalletIconImageView)findViewById(2131302020));
    this.whT = ((TextView)findViewById(2131302141));
    AppMethodBeat.o(67287);
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67299);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (ep(paramView).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
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
  
  private Rect ep(View paramView)
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
    if (paramView == this.whS)
    {
      paramRect.left -= 50;
      paramRect.right += 50;
      paramRect.top -= 25;
      paramRect.bottom += 25;
    }
    return paramRect;
  }
  
  public final boolean aRO()
  {
    AppMethodBeat.i(67308);
    if (this.whR != null)
    {
      if (this.whR.getText() == null) {}
      for (int i = 0; (i > this.wil) || (i < this.wim); i = this.whR.getText().length())
      {
        AppMethodBeat.o(67308);
        return false;
      }
      if (this.whY != null)
      {
        boolean bool = this.whY.a(this);
        AppMethodBeat.o(67308);
        return bool;
      }
      AppMethodBeat.o(67308);
      return true;
    }
    ac.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
    AppMethodBeat.o(67308);
    return true;
  }
  
  public final void dtF()
  {
    AppMethodBeat.i(67291);
    if ((this.whS != null) && (!bs.isNullOrNil(getText())) && (this.whR != null) && (this.whR.isEnabled()) && (this.whR.isClickable()) && (this.whR.isFocusable()) && (this.whR.isFocused()))
    {
      this.whS.setToClearState(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67286);
          MallFormView.this.dtH();
          AppMethodBeat.o(67286);
        }
      });
      AppMethodBeat.o(67291);
      return;
    }
    if (this.whS != null)
    {
      this.whS.eQv();
      AppMethodBeat.o(67291);
      return;
    }
    ac.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(67291);
  }
  
  public final void dtG()
  {
    AppMethodBeat.i(67301);
    ac.d("MicroMsg.WalletFormView", "shouldClearFocus: %s", new Object[] { Boolean.valueOf(this.wiu) });
    if (this.wiu)
    {
      getContentEditText().clearFocus();
      AppMethodBeat.o(67301);
      return;
    }
    this.wiu = true;
    AppMethodBeat.o(67301);
  }
  
  public final void dtH()
  {
    AppMethodBeat.i(67309);
    if (this.whR != null) {
      this.whR.setText("");
    }
    AppMethodBeat.o(67309);
  }
  
  public final EditText getContentEditText()
  {
    return this.whR;
  }
  
  public final a getEventDelegate()
  {
    return this.whX;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.whS;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(67311);
    if (this.whR != null)
    {
      int i = this.whR.getText().length();
      AppMethodBeat.o(67311);
      return i;
    }
    AppMethodBeat.o(67311);
    return 0;
  }
  
  public final a getInputValidChangeListener()
  {
    return this.whU;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(67304);
    if (this.whR != null)
    {
      KeyListener localKeyListener = this.whR.getKeyListener();
      AppMethodBeat.o(67304);
      return localKeyListener;
    }
    ac.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(67304);
    return null;
  }
  
  public final b getLogicDelegate()
  {
    return this.whY;
  }
  
  public final int getMaxInputLength()
  {
    return this.wil;
  }
  
  public final int getMinInputLength()
  {
    return this.wim;
  }
  
  public final TextView getPrefilledTv()
  {
    return this.whQ;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(67303);
    if (this.whR != null)
    {
      String str = this.whR.getText().toString();
      if ((this.whY != null) && (this.whY.dtE()))
      {
        str = this.whY.aqq(str);
        AppMethodBeat.o(67303);
        return str;
      }
      AppMethodBeat.o(67303);
      return str;
    }
    ac.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
    AppMethodBeat.o(67303);
    return "";
  }
  
  public final TextView getTipsTv()
  {
    return this.whT;
  }
  
  public final TextView getTitleTv()
  {
    return this.lfN;
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
      getTitleTv().setText(this.tWv);
      getTitleTv().setVisibility(this.wia);
    }
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.wib);
      getPrefilledTv().setVisibility(this.wic);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.wid);
      getInfoIv().setVisibility(this.wie);
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.wif);
      getTipsTv().setVisibility(this.wig);
    }
    getContext();
    if (this.whR != null)
    {
      this.whR.setHint(this.wih);
      this.whR.setGravity(this.wii);
      this.whR.setTextColor(this.wij);
      setText(this.wik);
      this.whR.setBackgroundResource(this.win);
      this.whR.setEnabled(this.wio);
      this.whR.setFocusable(this.wiq);
      this.whR.setClickable(this.wip);
      this.whR.setHintTextColor(this.wit);
      setImeOptions(this.wis);
      setInputType(this.wir);
      this.whR.addTextChangedListener(new TextWatcher()
      {
        private boolean wiv = false;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(67285);
          if (MallFormView.this.aRO() != this.wiv)
          {
            if (MallFormView.c(MallFormView.this) != null) {
              MallFormView.c(MallFormView.this).onInputValidChange(MallFormView.this.aRO());
            }
            this.wiv = MallFormView.this.aRO();
          }
          MallFormView.this.dtF();
          AppMethodBeat.o(67285);
        }
      });
      this.whR.setOnFocusChangeListener(this);
    }
    dtF();
    if (this.whR != null)
    {
      if (this.wir != 2) {
        break label347;
      }
      this.whR.setKeyListener(new NumberKeyListener()
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
      if (this.wil != -1) {
        this.whR.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.wil) });
      }
      AppMethodBeat.o(67294);
      return;
      label347:
      if (this.wir == 4)
      {
        this.whR.setKeyListener(new NumberKeyListener()
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
      else if (this.wir == 128)
      {
        this.whR.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.whR.setKeyListener(new NumberKeyListener()
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
        this.whR.setRawInputType(18);
      }
      else if (this.wir == 3)
      {
        this.whR.setKeyListener(new NumberKeyListener()
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
        this.whR.setInputType(this.wir);
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(67312);
    if (this.whV != null) {
      this.whV.onFocusChange(this, paramBoolean);
    }
    if (!aRO()) {
      if (this.lfN != null) {
        this.lfN.setEnabled(false);
      }
    }
    for (;;)
    {
      dtF();
      AppMethodBeat.o(67312);
      return;
      if (this.lfN != null) {
        this.lfN.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67298);
    if ((this.whX == null) || (!this.whX.dtD()))
    {
      if ((this.whR != null) && (b(this.whR, paramMotionEvent)) && (!this.whR.isClickable()))
      {
        ac.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(67298);
        return true;
      }
      if ((b(this.whS, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        ac.d("MicroMsg.WalletFormView", "hy: click on info iv");
        this.whS.performClick();
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
    if ((this.whX == null) || (!this.whX.dtC())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(67297);
  }
  
  public final void setEventDelegate(a parama)
  {
    this.whX = parama;
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(67310);
    if (this.whR != null) {
      this.whR.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(67310);
  }
  
  public final void setHint(String paramString)
  {
    AppMethodBeat.i(67295);
    if (this.whR != null) {
      this.whR.setHint(paramString);
    }
    AppMethodBeat.o(67295);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(67288);
    if (this.whR != null) {
      this.whR.setImeOptions(paramInt);
    }
    AppMethodBeat.o(67288);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(67289);
    if (this.whR != null) {
      this.whR.setInputType(paramInt);
    }
    AppMethodBeat.o(67289);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(67307);
    if (this.whR != null) {
      this.whR.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(67307);
  }
  
  public final void setLogicDelegate(b paramb)
  {
    this.whY = paramb;
  }
  
  public final void setMaxInputLength(int paramInt)
  {
    this.wil = paramInt;
  }
  
  public final void setMinInputLength(int paramInt)
  {
    this.wim = paramInt;
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
    this.whR.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(67296);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.whV = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67306);
    this.whW = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.whW);
    }
    AppMethodBeat.o(67306);
  }
  
  public final void setOnInputValidChangeListener(a parama)
  {
    this.whU = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(67302);
    if (this.whR != null) {
      this.whR.setSelection(paramInt);
    }
    AppMethodBeat.o(67302);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(67290);
    if (this.whR != null)
    {
      this.whR.setText(paramString);
      this.whR.setSelection(getInputLength());
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