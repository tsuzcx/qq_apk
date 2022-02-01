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
  private WalletIconImageView HBA;
  private TextView HBB;
  private a HBC;
  private View.OnFocusChangeListener HBD;
  private View.OnClickListener HBE;
  private a HBF;
  private b HBG;
  private int HBH;
  private String HBI;
  private int HBJ;
  private String HBK;
  private int HBL;
  private int HBM;
  private int HBN;
  private String HBO;
  private int HBP;
  private String HBQ;
  private int HBR;
  private int HBS;
  private String HBT;
  private int HBU;
  private int HBV;
  private int HBW;
  private boolean HBX;
  private boolean HBY;
  private boolean HBZ;
  private TextView HBy;
  public EditText HBz;
  private int HCa;
  private int HCb;
  private int HCc;
  public boolean HCd;
  private TextView pPT;
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67287);
    this.pPT = null;
    this.HBy = null;
    this.HBz = null;
    this.HBA = null;
    this.HBB = null;
    this.HBC = null;
    this.HBD = null;
    this.HBE = null;
    this.HBF = null;
    this.HBG = null;
    this.HBH = -1;
    this.HBI = "";
    this.HBJ = 0;
    this.HBK = "";
    this.HBL = 8;
    this.HBM = -1;
    this.HBN = 4;
    this.HBO = "";
    this.HBP = 8;
    this.HBQ = "";
    this.HBR = 19;
    this.HBS = a.c.normal_text_color;
    this.HBT = "";
    this.HBU = 2147483647;
    this.HBV = 1;
    this.HBW = a.e.mm_trans;
    this.HBX = true;
    this.HBY = false;
    this.HBZ = true;
    this.HCa = 1;
    this.HCb = 5;
    this.HCc = a.c.list_devider_color;
    this.HCd = true;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MallFormAttrs, paramInt, 0);
    this.HBH = paramAttributeSet.getResourceId(a.k.MallFormAttrs_malllayoutRes, this.HBH);
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_malltitleText, 0);
    if (paramInt != 0) {
      this.HBI = paramContext.getString(paramInt);
    }
    this.HBM = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallinfoIvRes, this.HBM);
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_malltipsText, 0);
    if (paramInt != 0) {
      this.HBO = paramContext.getString(paramInt);
    }
    this.HBN = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallinfoIvVisibility, this.HBN);
    this.HBJ = paramAttributeSet.getInteger(a.k.MallFormAttrs_malltitleTvVisibility, this.HBJ);
    this.HBP = paramAttributeSet.getInteger(a.k.MallFormAttrs_malltipsTvVisibility, this.HBP);
    this.HBL = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallprefilledTvVisibility, this.HBL);
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallprefilledText, 0);
    if (paramInt != 0) {
      this.HBK = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallcontentHint, 0);
    if (paramInt != 0) {
      this.HBQ = paramContext.getString(paramInt);
    }
    this.HBR = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallcontentGravity, this.HBR);
    this.HBS = paramAttributeSet.getColor(a.k.MallFormAttrs_mallcontentTextColor, this.HBS);
    paramInt = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallcontentText, 0);
    if (paramInt != 0) {
      this.HBT = paramContext.getString(paramInt);
    }
    this.HBU = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallcontentMaxSize, this.HBU);
    this.HBV = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallcontentMinSize, this.HBV);
    this.HBW = paramAttributeSet.getResourceId(a.k.MallFormAttrs_mallcontentBackground, this.HBW);
    this.HBX = paramAttributeSet.getBoolean(a.k.MallFormAttrs_mallcontentEnabled, this.HBX);
    this.HBY = paramAttributeSet.getBoolean(a.k.MallFormAttrs_mallcontentClickable, this.HBY);
    this.HBZ = paramAttributeSet.getBoolean(a.k.MallFormAttrs_mallcontentEnabled, this.HBZ);
    this.HCa = paramAttributeSet.getInteger(a.k.MallFormAttrs_android_inputType, this.HCa);
    this.HCb = paramAttributeSet.getInteger(a.k.MallFormAttrs_android_imeOptions, this.HCb);
    this.HCc = paramAttributeSet.getInteger(a.k.MallFormAttrs_mallcontentHintTextColor, this.HCc);
    paramAttributeSet.recycle();
    if (this.HBH > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    inflate(paramContext, this.HBH, this);
    this.pPT = ((TextView)findViewById(a.f.mall_title));
    this.HBy = ((TextView)findViewById(a.f.mall_prefilled));
    this.HBz = ((EditText)findViewById(a.f.mall_content));
    this.HBA = ((WalletIconImageView)findViewById(a.f.mall_info));
    this.HBB = ((TextView)findViewById(a.f.mall_tips_msg));
    AppMethodBeat.o(67287);
  }
  
  private boolean d(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67299);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (fN(paramView).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
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
  
  private Rect fN(View paramView)
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
  
  private Rect g(View paramView, Rect paramRect)
  {
    if (paramView == this.HBA)
    {
      paramRect.left -= 50;
      paramRect.right += 50;
      paramRect.top -= 25;
      paramRect.bottom += 25;
    }
    return paramRect;
  }
  
  public final boolean bAz()
  {
    AppMethodBeat.i(67308);
    if (this.HBz != null)
    {
      if (this.HBz.getText() == null) {}
      for (int i = 0; (i > this.HBU) || (i < this.HBV); i = this.HBz.getText().length())
      {
        AppMethodBeat.o(67308);
        return false;
      }
      if (this.HBG != null)
      {
        boolean bool = this.HBG.a(this);
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
  
  public final void fum()
  {
    AppMethodBeat.i(67291);
    if ((this.HBA != null) && (!Util.isNullOrNil(getText())) && (this.HBz != null) && (this.HBz.isEnabled()) && (this.HBz.isClickable()) && (this.HBz.isFocusable()) && (this.HBz.isFocused()))
    {
      this.HBA.setToClearState(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67286);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recharge/ui/form/MallFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          MallFormView.this.fuo();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MallFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67286);
        }
      });
      AppMethodBeat.o(67291);
      return;
    }
    if (this.HBA != null)
    {
      this.HBA.hoc();
      AppMethodBeat.o(67291);
      return;
    }
    Log.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(67291);
  }
  
  public final void fun()
  {
    AppMethodBeat.i(67301);
    Log.d("MicroMsg.WalletFormView", "shouldClearFocus: %s", new Object[] { Boolean.valueOf(this.HCd) });
    if (this.HCd)
    {
      getContentEditText().clearFocus();
      AppMethodBeat.o(67301);
      return;
    }
    this.HCd = true;
    AppMethodBeat.o(67301);
  }
  
  public final void fuo()
  {
    AppMethodBeat.i(67309);
    if (this.HBz != null) {
      this.HBz.setText("");
    }
    AppMethodBeat.o(67309);
  }
  
  public final EditText getContentEditText()
  {
    return this.HBz;
  }
  
  public final a getEventDelegate()
  {
    return this.HBF;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.HBA;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(67311);
    if (this.HBz != null)
    {
      int i = this.HBz.getText().length();
      AppMethodBeat.o(67311);
      return i;
    }
    AppMethodBeat.o(67311);
    return 0;
  }
  
  public final a getInputValidChangeListener()
  {
    return this.HBC;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(67304);
    if (this.HBz != null)
    {
      KeyListener localKeyListener = this.HBz.getKeyListener();
      AppMethodBeat.o(67304);
      return localKeyListener;
    }
    Log.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(67304);
    return null;
  }
  
  public final b getLogicDelegate()
  {
    return this.HBG;
  }
  
  public final int getMaxInputLength()
  {
    return this.HBU;
  }
  
  public final int getMinInputLength()
  {
    return this.HBV;
  }
  
  public final TextView getPrefilledTv()
  {
    return this.HBy;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(67303);
    if (this.HBz != null)
    {
      String str = this.HBz.getText().toString();
      if ((this.HBG != null) && (this.HBG.ful()))
      {
        str = this.HBG.aVx(str);
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
    return this.HBB;
  }
  
  public final TextView getTitleTv()
  {
    return this.pPT;
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
      getTitleTv().setText(this.HBI);
      getTitleTv().setVisibility(this.HBJ);
    }
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.HBK);
      getPrefilledTv().setVisibility(this.HBL);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.HBM);
      getInfoIv().setVisibility(this.HBN);
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.HBO);
      getTipsTv().setVisibility(this.HBP);
    }
    getContext();
    if (this.HBz != null)
    {
      this.HBz.setHint(this.HBQ);
      this.HBz.setGravity(this.HBR);
      this.HBz.setTextColor(this.HBS);
      setText(this.HBT);
      this.HBz.setBackgroundResource(this.HBW);
      this.HBz.setEnabled(this.HBX);
      this.HBz.setFocusable(this.HBZ);
      this.HBz.setClickable(this.HBY);
      this.HBz.setHintTextColor(this.HCc);
      setImeOptions(this.HCb);
      setInputType(this.HCa);
      this.HBz.addTextChangedListener(new TextWatcher()
      {
        private boolean HCe = false;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(67285);
          if (MallFormView.this.bAz() != this.HCe)
          {
            if (MallFormView.c(MallFormView.this) != null) {
              MallFormView.c(MallFormView.this).onInputValidChange(MallFormView.this.bAz());
            }
            this.HCe = MallFormView.this.bAz();
          }
          MallFormView.this.fum();
          AppMethodBeat.o(67285);
        }
      });
      this.HBz.setOnFocusChangeListener(this);
    }
    fum();
    if (this.HBz != null)
    {
      if (this.HCa != 2) {
        break label347;
      }
      this.HBz.setKeyListener(new NumberKeyListener()
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
      if (this.HBU != -1) {
        this.HBz.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.HBU) });
      }
      AppMethodBeat.o(67294);
      return;
      label347:
      if (this.HCa == 4)
      {
        this.HBz.setKeyListener(new NumberKeyListener()
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
      else if (this.HCa == 128)
      {
        this.HBz.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.HBz.setKeyListener(new NumberKeyListener()
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
        this.HBz.setRawInputType(18);
      }
      else if (this.HCa == 3)
      {
        this.HBz.setKeyListener(new NumberKeyListener()
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
        this.HBz.setInputType(this.HCa);
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(67312);
    if (this.HBD != null) {
      this.HBD.onFocusChange(this, paramBoolean);
    }
    if (!bAz()) {
      if (this.pPT != null) {
        this.pPT.setEnabled(false);
      }
    }
    for (;;)
    {
      fum();
      AppMethodBeat.o(67312);
      return;
      if (this.pPT != null) {
        this.pPT.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67298);
    if ((this.HBF == null) || (!this.HBF.fuk()))
    {
      if ((this.HBz != null) && (d(this.HBz, paramMotionEvent)) && (!this.HBz.isClickable()))
      {
        Log.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(67298);
        return true;
      }
      if ((d(this.HBA, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        Log.d("MicroMsg.WalletFormView", "hy: click on info iv");
        this.HBA.performClick();
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
    if ((this.HBF == null) || (!this.HBF.fuj())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(67297);
  }
  
  public final void setEventDelegate(a parama)
  {
    this.HBF = parama;
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(67310);
    if (this.HBz != null) {
      this.HBz.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(67310);
  }
  
  public final void setHint(String paramString)
  {
    AppMethodBeat.i(67295);
    if (this.HBz != null) {
      this.HBz.setHint(paramString);
    }
    AppMethodBeat.o(67295);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(67288);
    if (this.HBz != null) {
      this.HBz.setImeOptions(paramInt);
    }
    AppMethodBeat.o(67288);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(67289);
    if (this.HBz != null) {
      this.HBz.setInputType(paramInt);
    }
    AppMethodBeat.o(67289);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(67307);
    if (this.HBz != null) {
      this.HBz.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(67307);
  }
  
  public final void setLogicDelegate(b paramb)
  {
    this.HBG = paramb;
  }
  
  public final void setMaxInputLength(int paramInt)
  {
    this.HBU = paramInt;
  }
  
  public final void setMinInputLength(int paramInt)
  {
    this.HBV = paramInt;
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
    this.HBz.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(67296);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.HBD = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67306);
    this.HBE = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.HBE);
    }
    AppMethodBeat.o(67306);
  }
  
  public final void setOnInputValidChangeListener(a parama)
  {
    this.HBC = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(67302);
    if (this.HBz != null) {
      this.HBz.setSelection(paramInt);
    }
    AppMethodBeat.o(67302);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(67290);
    if (this.HBz != null)
    {
      this.HBz.setText(paramString);
      this.HBz.setSelection(getInputLength());
    }
    AppMethodBeat.o(67290);
  }
  
  public static abstract interface a
  {
    public abstract void onInputValidChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.MallFormView
 * JD-Core Version:    0.7.0.1
 */