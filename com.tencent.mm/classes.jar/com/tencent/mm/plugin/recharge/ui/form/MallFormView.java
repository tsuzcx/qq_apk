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
  private TextView lCL;
  private String uZe;
  public EditText xpA;
  private WalletIconImageView xpB;
  private TextView xpC;
  private a xpD;
  private View.OnFocusChangeListener xpE;
  private View.OnClickListener xpF;
  private a xpG;
  private b xpH;
  private int xpI;
  private int xpJ;
  private String xpK;
  private int xpL;
  private int xpM;
  private int xpN;
  private String xpO;
  private int xpP;
  private String xpQ;
  private int xpR;
  private int xpS;
  private String xpT;
  private int xpU;
  private int xpV;
  private int xpW;
  private boolean xpX;
  private boolean xpY;
  private boolean xpZ;
  private TextView xpz;
  private int xqa;
  private int xqb;
  private int xqc;
  public boolean xqd;
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67287);
    this.lCL = null;
    this.xpz = null;
    this.xpA = null;
    this.xpB = null;
    this.xpC = null;
    this.xpD = null;
    this.xpE = null;
    this.xpF = null;
    this.xpG = null;
    this.xpH = null;
    this.xpI = -1;
    this.uZe = "";
    this.xpJ = 0;
    this.xpK = "";
    this.xpL = 8;
    this.xpM = -1;
    this.xpN = 4;
    this.xpO = "";
    this.xpP = 8;
    this.xpQ = "";
    this.xpR = 19;
    this.xpS = 2131100711;
    this.xpT = "";
    this.xpU = 2147483647;
    this.xpV = 1;
    this.xpW = 2131233299;
    this.xpX = true;
    this.xpY = false;
    this.xpZ = true;
    this.xqa = 1;
    this.xqb = 5;
    this.xqc = 2131100551;
    this.xqd = true;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MallFormAttrs, paramInt, 0);
    this.xpI = paramAttributeSet.getResourceId(17, this.xpI);
    paramInt = paramAttributeSet.getResourceId(23, 0);
    if (paramInt != 0) {
      this.uZe = paramContext.getString(paramInt);
    }
    this.xpM = paramAttributeSet.getResourceId(14, this.xpM);
    paramInt = paramAttributeSet.getResourceId(21, 0);
    if (paramInt != 0) {
      this.xpO = paramContext.getString(paramInt);
    }
    this.xpN = paramAttributeSet.getInteger(15, this.xpN);
    this.xpJ = paramAttributeSet.getInteger(25, this.xpJ);
    this.xpP = paramAttributeSet.getInteger(22, this.xpP);
    this.xpL = paramAttributeSet.getInteger(20, this.xpL);
    paramInt = paramAttributeSet.getResourceId(18, 0);
    if (paramInt != 0) {
      this.xpK = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(8, 0);
    if (paramInt != 0) {
      this.xpQ = paramContext.getString(paramInt);
    }
    this.xpR = paramAttributeSet.getInteger(7, this.xpR);
    this.xpS = paramAttributeSet.getColor(13, this.xpS);
    paramInt = paramAttributeSet.getResourceId(12, 0);
    if (paramInt != 0) {
      this.xpT = paramContext.getString(paramInt);
    }
    this.xpU = paramAttributeSet.getInteger(10, this.xpU);
    this.xpV = paramAttributeSet.getInteger(11, this.xpV);
    this.xpW = paramAttributeSet.getResourceId(2, this.xpW);
    this.xpX = paramAttributeSet.getBoolean(4, this.xpX);
    this.xpY = paramAttributeSet.getBoolean(3, this.xpY);
    this.xpZ = paramAttributeSet.getBoolean(4, this.xpZ);
    this.xqa = paramAttributeSet.getInteger(0, this.xqa);
    this.xqb = paramAttributeSet.getInteger(1, this.xqb);
    this.xqc = paramAttributeSet.getInteger(9, this.xqc);
    paramAttributeSet.recycle();
    if (this.xpI > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    inflate(paramContext, this.xpI, this);
    this.lCL = ((TextView)findViewById(2131302142));
    this.xpz = ((TextView)findViewById(2131302084));
    this.xpA = ((EditText)findViewById(2131302008));
    this.xpB = ((WalletIconImageView)findViewById(2131302020));
    this.xpC = ((TextView)findViewById(2131302141));
    AppMethodBeat.o(67287);
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67299);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (eB(paramView).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
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
  
  private Rect eB(View paramView)
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
    if (paramView == this.xpB)
    {
      paramRect.left -= 50;
      paramRect.right += 50;
      paramRect.top -= 25;
      paramRect.bottom += 25;
    }
    return paramRect;
  }
  
  public final boolean aVa()
  {
    AppMethodBeat.i(67308);
    if (this.xpA != null)
    {
      if (this.xpA.getText() == null) {}
      for (int i = 0; (i > this.xpU) || (i < this.xpV); i = this.xpA.getText().length())
      {
        AppMethodBeat.o(67308);
        return false;
      }
      if (this.xpH != null)
      {
        boolean bool = this.xpH.a(this);
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
  
  public final void dEc()
  {
    AppMethodBeat.i(67291);
    if ((this.xpB != null) && (!bt.isNullOrNil(getText())) && (this.xpA != null) && (this.xpA.isEnabled()) && (this.xpA.isClickable()) && (this.xpA.isFocusable()) && (this.xpA.isFocused()))
    {
      this.xpB.setToClearState(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67286);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MallFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          MallFormView.this.dEe();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MallFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67286);
        }
      });
      AppMethodBeat.o(67291);
      return;
    }
    if (this.xpB != null)
    {
      this.xpB.ffz();
      AppMethodBeat.o(67291);
      return;
    }
    ad.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(67291);
  }
  
  public final void dEd()
  {
    AppMethodBeat.i(67301);
    ad.d("MicroMsg.WalletFormView", "shouldClearFocus: %s", new Object[] { Boolean.valueOf(this.xqd) });
    if (this.xqd)
    {
      getContentEditText().clearFocus();
      AppMethodBeat.o(67301);
      return;
    }
    this.xqd = true;
    AppMethodBeat.o(67301);
  }
  
  public final void dEe()
  {
    AppMethodBeat.i(67309);
    if (this.xpA != null) {
      this.xpA.setText("");
    }
    AppMethodBeat.o(67309);
  }
  
  public final EditText getContentEditText()
  {
    return this.xpA;
  }
  
  public final a getEventDelegate()
  {
    return this.xpG;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.xpB;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(67311);
    if (this.xpA != null)
    {
      int i = this.xpA.getText().length();
      AppMethodBeat.o(67311);
      return i;
    }
    AppMethodBeat.o(67311);
    return 0;
  }
  
  public final a getInputValidChangeListener()
  {
    return this.xpD;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(67304);
    if (this.xpA != null)
    {
      KeyListener localKeyListener = this.xpA.getKeyListener();
      AppMethodBeat.o(67304);
      return localKeyListener;
    }
    ad.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(67304);
    return null;
  }
  
  public final b getLogicDelegate()
  {
    return this.xpH;
  }
  
  public final int getMaxInputLength()
  {
    return this.xpU;
  }
  
  public final int getMinInputLength()
  {
    return this.xpV;
  }
  
  public final TextView getPrefilledTv()
  {
    return this.xpz;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(67303);
    if (this.xpA != null)
    {
      String str = this.xpA.getText().toString();
      if ((this.xpH != null) && (this.xpH.dEb()))
      {
        str = this.xpH.avp(str);
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
    return this.xpC;
  }
  
  public final TextView getTitleTv()
  {
    return this.lCL;
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
      getTitleTv().setText(this.uZe);
      getTitleTv().setVisibility(this.xpJ);
    }
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.xpK);
      getPrefilledTv().setVisibility(this.xpL);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.xpM);
      getInfoIv().setVisibility(this.xpN);
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.xpO);
      getTipsTv().setVisibility(this.xpP);
    }
    getContext();
    if (this.xpA != null)
    {
      this.xpA.setHint(this.xpQ);
      this.xpA.setGravity(this.xpR);
      this.xpA.setTextColor(this.xpS);
      setText(this.xpT);
      this.xpA.setBackgroundResource(this.xpW);
      this.xpA.setEnabled(this.xpX);
      this.xpA.setFocusable(this.xpZ);
      this.xpA.setClickable(this.xpY);
      this.xpA.setHintTextColor(this.xqc);
      setImeOptions(this.xqb);
      setInputType(this.xqa);
      this.xpA.addTextChangedListener(new TextWatcher()
      {
        private boolean xqe = false;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(67285);
          if (MallFormView.this.aVa() != this.xqe)
          {
            if (MallFormView.c(MallFormView.this) != null) {
              MallFormView.c(MallFormView.this).onInputValidChange(MallFormView.this.aVa());
            }
            this.xqe = MallFormView.this.aVa();
          }
          MallFormView.this.dEc();
          AppMethodBeat.o(67285);
        }
      });
      this.xpA.setOnFocusChangeListener(this);
    }
    dEc();
    if (this.xpA != null)
    {
      if (this.xqa != 2) {
        break label347;
      }
      this.xpA.setKeyListener(new NumberKeyListener()
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
      if (this.xpU != -1) {
        this.xpA.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.xpU) });
      }
      AppMethodBeat.o(67294);
      return;
      label347:
      if (this.xqa == 4)
      {
        this.xpA.setKeyListener(new NumberKeyListener()
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
      else if (this.xqa == 128)
      {
        this.xpA.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.xpA.setKeyListener(new NumberKeyListener()
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
        this.xpA.setRawInputType(18);
      }
      else if (this.xqa == 3)
      {
        this.xpA.setKeyListener(new NumberKeyListener()
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
        this.xpA.setInputType(this.xqa);
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(67312);
    if (this.xpE != null) {
      this.xpE.onFocusChange(this, paramBoolean);
    }
    if (!aVa()) {
      if (this.lCL != null) {
        this.lCL.setEnabled(false);
      }
    }
    for (;;)
    {
      dEc();
      AppMethodBeat.o(67312);
      return;
      if (this.lCL != null) {
        this.lCL.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67298);
    if ((this.xpG == null) || (!this.xpG.dEa()))
    {
      if ((this.xpA != null) && (b(this.xpA, paramMotionEvent)) && (!this.xpA.isClickable()))
      {
        ad.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(67298);
        return true;
      }
      if ((b(this.xpB, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        ad.d("MicroMsg.WalletFormView", "hy: click on info iv");
        this.xpB.performClick();
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
    if ((this.xpG == null) || (!this.xpG.dDZ())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(67297);
  }
  
  public final void setEventDelegate(a parama)
  {
    this.xpG = parama;
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(67310);
    if (this.xpA != null) {
      this.xpA.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(67310);
  }
  
  public final void setHint(String paramString)
  {
    AppMethodBeat.i(67295);
    if (this.xpA != null) {
      this.xpA.setHint(paramString);
    }
    AppMethodBeat.o(67295);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(67288);
    if (this.xpA != null) {
      this.xpA.setImeOptions(paramInt);
    }
    AppMethodBeat.o(67288);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(67289);
    if (this.xpA != null) {
      this.xpA.setInputType(paramInt);
    }
    AppMethodBeat.o(67289);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(67307);
    if (this.xpA != null) {
      this.xpA.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(67307);
  }
  
  public final void setLogicDelegate(b paramb)
  {
    this.xpH = paramb;
  }
  
  public final void setMaxInputLength(int paramInt)
  {
    this.xpU = paramInt;
  }
  
  public final void setMinInputLength(int paramInt)
  {
    this.xpV = paramInt;
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
    this.xpA.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(67296);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.xpE = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67306);
    this.xpF = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.xpF);
    }
    AppMethodBeat.o(67306);
  }
  
  public final void setOnInputValidChangeListener(a parama)
  {
    this.xpD = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(67302);
    if (this.xpA != null) {
      this.xpA.setSelection(paramInt);
    }
    AppMethodBeat.o(67302);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(67290);
    if (this.xpA != null)
    {
      this.xpA.setText(paramString);
      this.xpA.setSelection(getInputLength());
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