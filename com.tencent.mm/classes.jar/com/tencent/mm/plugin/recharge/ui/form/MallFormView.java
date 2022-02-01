package com.tencent.mm.plugin.recharge.ui.form;

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
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class MallFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private boolean NzA;
  private boolean NzB;
  private boolean NzC;
  private int NzD;
  private int NzE;
  private int NzF;
  public boolean NzG;
  private TextView Nzb;
  public EditText Nzc;
  private WalletIconImageView Nzd;
  private TextView Nze;
  private a Nzf;
  private View.OnFocusChangeListener Nzg;
  private View.OnClickListener Nzh;
  private a Nzi;
  private b Nzj;
  private int Nzk;
  private String Nzl;
  private int Nzm;
  private String Nzn;
  private int Nzo;
  private int Nzp;
  private int Nzq;
  private String Nzr;
  private int Nzs;
  private String Nzt;
  private int Nzu;
  private int Nzv;
  private String Nzw;
  private int Nzx;
  private int Nzy;
  private int Nzz;
  private TextView sUt;
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67287);
    this.sUt = null;
    this.Nzb = null;
    this.Nzc = null;
    this.Nzd = null;
    this.Nze = null;
    this.Nzf = null;
    this.Nzg = null;
    this.Nzh = null;
    this.Nzi = null;
    this.Nzj = null;
    this.Nzk = -1;
    this.Nzl = "";
    this.Nzm = 0;
    this.Nzn = "";
    this.Nzo = 8;
    this.Nzp = -1;
    this.Nzq = 4;
    this.Nzr = "";
    this.Nzs = 8;
    this.Nzt = "";
    this.Nzu = 19;
    this.Nzv = a.c.normal_text_color;
    this.Nzw = "";
    this.Nzx = 2147483647;
    this.Nzy = 1;
    this.Nzz = a.e.mm_trans;
    this.NzA = true;
    this.NzB = false;
    this.NzC = true;
    this.NzD = 1;
    this.NzE = 5;
    this.NzF = a.c.list_devider_color;
    this.NzG = true;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MallFormAttrs, paramInt, 0);
    this.Nzk = paramAttributeSet.getResourceId(a.k.MallFormAttrs_malllayoutRes, this.Nzk);
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_malltitleText, 0);
    if (paramInt != 0) {
      this.Nzl = paramContext.getString(paramInt);
    }
    this.Nzp = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallinfoIvRes, this.Nzp);
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_malltipsText, 0);
    if (paramInt != 0) {
      this.Nzr = paramContext.getString(paramInt);
    }
    this.Nzq = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallinfoIvVisibility, this.Nzq);
    this.Nzm = paramAttributeSet.getInteger(a.k.MallFormAttrs_malltitleTvVisibility, this.Nzm);
    this.Nzs = paramAttributeSet.getInteger(a.k.MallFormAttrs_malltipsTvVisibility, this.Nzs);
    this.Nzo = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallprefilledTvVisibility, this.Nzo);
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallprefilledText, 0);
    if (paramInt != 0) {
      this.Nzn = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallcontentHint, 0);
    if (paramInt != 0) {
      this.Nzt = paramContext.getString(paramInt);
    }
    this.Nzu = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallcontentGravity, this.Nzu);
    this.Nzv = paramAttributeSet.getColor(a.k.MallFormAttrs_mallcontentTextColor, this.Nzv);
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallcontentText, 0);
    if (paramInt != 0) {
      this.Nzw = paramContext.getString(paramInt);
    }
    this.Nzx = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallcontentMaxSize, this.Nzx);
    this.Nzy = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallcontentMinSize, this.Nzy);
    this.Nzz = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallcontentBackground, this.Nzz);
    this.NzA = paramAttributeSet.getBoolean(a.k.MallFormAttrs_mallcontentEnabled, this.NzA);
    this.NzB = paramAttributeSet.getBoolean(a.k.MallFormAttrs_mallcontentClickable, this.NzB);
    this.NzC = paramAttributeSet.getBoolean(a.k.MallFormAttrs_mallcontentEnabled, this.NzC);
    this.NzD = paramAttributeSet.getInteger(a.k.MallFormAttrs_android_inputType, this.NzD);
    this.NzE = paramAttributeSet.getInteger(a.k.MallFormAttrs_android_imeOptions, this.NzE);
    this.NzF = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallcontentHintTextColor, this.NzF);
    paramAttributeSet.recycle();
    if (this.Nzk > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    inflate(paramContext, this.Nzk, this);
    this.sUt = ((TextView)findViewById(a.f.mall_title));
    this.Nzb = ((TextView)findViewById(a.f.mall_prefilled));
    this.Nzc = ((EditText)findViewById(a.f.mall_content));
    this.Nzd = ((WalletIconImageView)findViewById(a.f.mall_info));
    this.Nze = ((TextView)findViewById(a.f.mall_tips_msg));
    AppMethodBeat.o(67287);
  }
  
  private Rect g(View paramView, Rect paramRect)
  {
    if (paramView == this.Nzd)
    {
      paramRect.left -= 50;
      paramRect.right += 50;
      paramRect.top -= 25;
      paramRect.bottom += 25;
    }
    return paramRect;
  }
  
  private Rect iH(View paramView)
  {
    AppMethodBeat.i(67300);
    if (paramView != null)
    {
      Rect localRect = new Rect();
      paramView.getHitRect(localRect);
      paramView = g(paramView, localRect);
      AppMethodBeat.o(67300);
      return paramView;
    }
    AppMethodBeat.o(67300);
    return null;
  }
  
  private boolean k(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67299);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (iH(paramView).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
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
  
  public final boolean bZp()
  {
    AppMethodBeat.i(67308);
    if (this.Nzc != null)
    {
      if (this.Nzc.getText() == null) {}
      for (int i = 0; (i > this.Nzx) || (i < this.Nzy); i = this.Nzc.getText().length())
      {
        AppMethodBeat.o(67308);
        return false;
      }
      if (this.Nzj != null)
      {
        boolean bool = this.Nzj.a(this);
        AppMethodBeat.o(67308);
        return bool;
      }
      AppMethodBeat.o(67308);
      return true;
    }
    Log.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
    AppMethodBeat.o(67308);
    return true;
  }
  
  public final void gGb()
  {
    AppMethodBeat.i(67291);
    if ((this.Nzd != null) && (!Util.isNullOrNil(getText())) && (this.Nzc != null) && (this.Nzc.isEnabled()) && (this.Nzc.isClickable()) && (this.Nzc.isFocusable()) && (this.Nzc.isFocused()))
    {
      this.Nzd.setToClearState(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67286);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/form/MallFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          MallFormView.this.gGd();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MallFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67286);
        }
      });
      AppMethodBeat.o(67291);
      return;
    }
    if (this.Nzd != null)
    {
      this.Nzd.iOU();
      AppMethodBeat.o(67291);
      return;
    }
    Log.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(67291);
  }
  
  public final void gGc()
  {
    AppMethodBeat.i(67301);
    Log.d("MicroMsg.WalletFormView", "shouldClearFocus: %s", new Object[] { Boolean.valueOf(this.NzG) });
    if (this.NzG)
    {
      getContentEditText().clearFocus();
      AppMethodBeat.o(67301);
      return;
    }
    this.NzG = true;
    AppMethodBeat.o(67301);
  }
  
  public final void gGd()
  {
    AppMethodBeat.i(67309);
    if (this.Nzc != null) {
      this.Nzc.setText("");
    }
    AppMethodBeat.o(67309);
  }
  
  public final EditText getContentEditText()
  {
    return this.Nzc;
  }
  
  public final a getEventDelegate()
  {
    return this.Nzi;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.Nzd;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(67311);
    if (this.Nzc != null)
    {
      int i = this.Nzc.getText().length();
      AppMethodBeat.o(67311);
      return i;
    }
    AppMethodBeat.o(67311);
    return 0;
  }
  
  public final a getInputValidChangeListener()
  {
    return this.Nzf;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(67304);
    if (this.Nzc != null)
    {
      KeyListener localKeyListener = this.Nzc.getKeyListener();
      AppMethodBeat.o(67304);
      return localKeyListener;
    }
    Log.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(67304);
    return null;
  }
  
  public final b getLogicDelegate()
  {
    return this.Nzj;
  }
  
  public final int getMaxInputLength()
  {
    return this.Nzx;
  }
  
  public final int getMinInputLength()
  {
    return this.Nzy;
  }
  
  public final TextView getPrefilledTv()
  {
    return this.Nzb;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(67303);
    if (this.Nzc != null)
    {
      String str = this.Nzc.getText().toString();
      if ((this.Nzj != null) && (this.Nzj.gGa()))
      {
        str = this.Nzj.aSF(str);
        AppMethodBeat.o(67303);
        return str;
      }
      AppMethodBeat.o(67303);
      return str;
    }
    Log.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
    AppMethodBeat.o(67303);
    return "";
  }
  
  public final TextView getTipsTv()
  {
    return this.Nze;
  }
  
  public final TextView getTitleTv()
  {
    return this.sUt;
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
      getTitleTv().setText(this.Nzl);
      getTitleTv().setVisibility(this.Nzm);
    }
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.Nzn);
      getPrefilledTv().setVisibility(this.Nzo);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.Nzp);
      getInfoIv().setVisibility(this.Nzq);
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.Nzr);
      getTipsTv().setVisibility(this.Nzs);
    }
    getContext();
    if (this.Nzc != null)
    {
      this.Nzc.setHint(this.Nzt);
      this.Nzc.setGravity(this.Nzu);
      this.Nzc.setTextColor(this.Nzv);
      setText(this.Nzw);
      this.Nzc.setBackgroundResource(this.Nzz);
      this.Nzc.setEnabled(this.NzA);
      this.Nzc.setFocusable(this.NzC);
      this.Nzc.setClickable(this.NzB);
      this.Nzc.setHintTextColor(this.NzF);
      setImeOptions(this.NzE);
      setInputType(this.NzD);
      this.Nzc.addTextChangedListener(new TextWatcher()
      {
        private boolean NzH = false;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(67285);
          if (MallFormView.this.bZp() != this.NzH)
          {
            if (MallFormView.c(MallFormView.this) != null) {
              MallFormView.c(MallFormView.this).onInputValidChange(MallFormView.this.bZp());
            }
            this.NzH = MallFormView.this.bZp();
          }
          MallFormView.this.gGb();
          AppMethodBeat.o(67285);
        }
      });
      this.Nzc.setOnFocusChangeListener(this);
    }
    gGb();
    if (this.Nzc != null)
    {
      if (this.NzD != 2) {
        break label347;
      }
      this.Nzc.setKeyListener(new NumberKeyListener()
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
      if (this.Nzx != -1) {
        this.Nzc.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.Nzx) });
      }
      AppMethodBeat.o(67294);
      return;
      label347:
      if (this.NzD == 4)
      {
        this.Nzc.setKeyListener(new NumberKeyListener()
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
      else if (this.NzD == 128)
      {
        this.Nzc.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.Nzc.setKeyListener(new NumberKeyListener()
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
        this.Nzc.setRawInputType(18);
      }
      else if (this.NzD == 3)
      {
        this.Nzc.setKeyListener(new NumberKeyListener()
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
        this.Nzc.setInputType(this.NzD);
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(67312);
    if (this.Nzg != null) {
      this.Nzg.onFocusChange(this, paramBoolean);
    }
    if (!bZp()) {
      if (this.sUt != null) {
        this.sUt.setEnabled(false);
      }
    }
    for (;;)
    {
      gGb();
      AppMethodBeat.o(67312);
      return;
      if (this.sUt != null) {
        this.sUt.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67298);
    if ((this.Nzi == null) || (!this.Nzi.gFY()))
    {
      if ((this.Nzc != null) && (k(this.Nzc, paramMotionEvent)) && (!this.Nzc.isClickable()))
      {
        Log.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(67298);
        return true;
      }
      if ((k(this.Nzd, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        Log.d("MicroMsg.WalletFormView", "hy: click on info iv");
        this.Nzd.performClick();
        AppMethodBeat.o(67298);
        return true;
      }
      AppMethodBeat.o(67298);
      return false;
    }
    AppMethodBeat.o(67298);
    return true;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67297);
    if ((this.Nzi == null) || (!this.Nzi.gFX())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(67297);
  }
  
  public final void setEventDelegate(a parama)
  {
    this.Nzi = parama;
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(67310);
    if (this.Nzc != null) {
      this.Nzc.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(67310);
  }
  
  public final void setHint(String paramString)
  {
    AppMethodBeat.i(67295);
    if (this.Nzc != null) {
      this.Nzc.setHint(paramString);
    }
    AppMethodBeat.o(67295);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(67288);
    if (this.Nzc != null) {
      this.Nzc.setImeOptions(paramInt);
    }
    AppMethodBeat.o(67288);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(67289);
    if (this.Nzc != null) {
      this.Nzc.setInputType(paramInt);
    }
    AppMethodBeat.o(67289);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(67307);
    if (this.Nzc != null) {
      this.Nzc.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(67307);
  }
  
  public final void setLogicDelegate(b paramb)
  {
    this.Nzj = paramb;
  }
  
  public final void setMaxInputLength(int paramInt)
  {
    this.Nzx = paramInt;
  }
  
  public final void setMinInputLength(int paramInt)
  {
    this.Nzy = paramInt;
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
    this.Nzc.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(67296);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.Nzg = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67306);
    this.Nzh = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.Nzh);
    }
    AppMethodBeat.o(67306);
  }
  
  public final void setOnInputValidChangeListener(a parama)
  {
    this.Nzf = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(67302);
    if (this.Nzc != null) {
      this.Nzc.setSelection(paramInt);
    }
    AppMethodBeat.o(67302);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(67290);
    if ((this.Nzc != null) && ((this.Nzj == null) || (!this.Nzj.gFZ())))
    {
      this.Nzc.setText(paramString);
      this.Nzc.setSelection(getInputLength());
    }
    AppMethodBeat.o(67290);
  }
  
  public static abstract interface a
  {
    public abstract void onInputValidChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.MallFormView
 * JD-Core Version:    0.7.0.1
 */