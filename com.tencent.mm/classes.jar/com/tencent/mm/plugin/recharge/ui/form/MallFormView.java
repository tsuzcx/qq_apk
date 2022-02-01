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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import junit.framework.Assert;

public final class MallFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private TextView lHk;
  private String vli;
  private a xFA;
  private View.OnFocusChangeListener xFB;
  private View.OnClickListener xFC;
  private a xFD;
  private b xFE;
  private int xFF;
  private int xFG;
  private String xFH;
  private int xFI;
  private int xFJ;
  private int xFK;
  private String xFL;
  private int xFM;
  private String xFN;
  private int xFO;
  private int xFP;
  private String xFQ;
  private int xFR;
  private int xFS;
  private int xFT;
  private boolean xFU;
  private boolean xFV;
  private boolean xFW;
  private int xFX;
  private int xFY;
  private int xFZ;
  private TextView xFw;
  public EditText xFx;
  private WalletIconImageView xFy;
  private TextView xFz;
  public boolean xGa;
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67287);
    this.lHk = null;
    this.xFw = null;
    this.xFx = null;
    this.xFy = null;
    this.xFz = null;
    this.xFA = null;
    this.xFB = null;
    this.xFC = null;
    this.xFD = null;
    this.xFE = null;
    this.xFF = -1;
    this.vli = "";
    this.xFG = 0;
    this.xFH = "";
    this.xFI = 8;
    this.xFJ = -1;
    this.xFK = 4;
    this.xFL = "";
    this.xFM = 8;
    this.xFN = "";
    this.xFO = 19;
    this.xFP = 2131100711;
    this.xFQ = "";
    this.xFR = 2147483647;
    this.xFS = 1;
    this.xFT = 2131233299;
    this.xFU = true;
    this.xFV = false;
    this.xFW = true;
    this.xFX = 1;
    this.xFY = 5;
    this.xFZ = 2131100551;
    this.xGa = true;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MallFormAttrs, paramInt, 0);
    this.xFF = paramAttributeSet.getResourceId(17, this.xFF);
    paramInt = paramAttributeSet.getResourceId(23, 0);
    if (paramInt != 0) {
      this.vli = paramContext.getString(paramInt);
    }
    this.xFJ = paramAttributeSet.getResourceId(14, this.xFJ);
    paramInt = paramAttributeSet.getResourceId(21, 0);
    if (paramInt != 0) {
      this.xFL = paramContext.getString(paramInt);
    }
    this.xFK = paramAttributeSet.getInteger(15, this.xFK);
    this.xFG = paramAttributeSet.getInteger(25, this.xFG);
    this.xFM = paramAttributeSet.getInteger(22, this.xFM);
    this.xFI = paramAttributeSet.getInteger(20, this.xFI);
    paramInt = paramAttributeSet.getResourceId(18, 0);
    if (paramInt != 0) {
      this.xFH = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(8, 0);
    if (paramInt != 0) {
      this.xFN = paramContext.getString(paramInt);
    }
    this.xFO = paramAttributeSet.getInteger(7, this.xFO);
    this.xFP = paramAttributeSet.getColor(13, this.xFP);
    paramInt = paramAttributeSet.getResourceId(12, 0);
    if (paramInt != 0) {
      this.xFQ = paramContext.getString(paramInt);
    }
    this.xFR = paramAttributeSet.getInteger(10, this.xFR);
    this.xFS = paramAttributeSet.getInteger(11, this.xFS);
    this.xFT = paramAttributeSet.getResourceId(2, this.xFT);
    this.xFU = paramAttributeSet.getBoolean(4, this.xFU);
    this.xFV = paramAttributeSet.getBoolean(3, this.xFV);
    this.xFW = paramAttributeSet.getBoolean(4, this.xFW);
    this.xFX = paramAttributeSet.getInteger(0, this.xFX);
    this.xFY = paramAttributeSet.getInteger(1, this.xFY);
    this.xFZ = paramAttributeSet.getInteger(9, this.xFZ);
    paramAttributeSet.recycle();
    if (this.xFF > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    inflate(paramContext, this.xFF, this);
    this.lHk = ((TextView)findViewById(2131302142));
    this.xFw = ((TextView)findViewById(2131302084));
    this.xFx = ((EditText)findViewById(2131302008));
    this.xFy = ((WalletIconImageView)findViewById(2131302020));
    this.xFz = ((TextView)findViewById(2131302141));
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
    if (paramView == this.xFy)
    {
      paramRect.left -= 50;
      paramRect.right += 50;
      paramRect.top -= 25;
      paramRect.bottom += 25;
    }
    return paramRect;
  }
  
  public final boolean aVz()
  {
    AppMethodBeat.i(67308);
    if (this.xFx != null)
    {
      if (this.xFx.getText() == null) {}
      for (int i = 0; (i > this.xFR) || (i < this.xFS); i = this.xFx.getText().length())
      {
        AppMethodBeat.o(67308);
        return false;
      }
      if (this.xFE != null)
      {
        boolean bool = this.xFE.a(this);
        AppMethodBeat.o(67308);
        return bool;
      }
      AppMethodBeat.o(67308);
      return true;
    }
    ae.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
    AppMethodBeat.o(67308);
    return true;
  }
  
  public final void dHt()
  {
    AppMethodBeat.i(67291);
    if ((this.xFy != null) && (!bu.isNullOrNil(getText())) && (this.xFx != null) && (this.xFx.isEnabled()) && (this.xFx.isClickable()) && (this.xFx.isFocusable()) && (this.xFx.isFocused()))
    {
      this.xFy.setToClearState(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67286);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MallFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          MallFormView.this.dHv();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MallFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67286);
        }
      });
      AppMethodBeat.o(67291);
      return;
    }
    if (this.xFy != null)
    {
      this.xFy.fjp();
      AppMethodBeat.o(67291);
      return;
    }
    ae.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(67291);
  }
  
  public final void dHu()
  {
    AppMethodBeat.i(67301);
    ae.d("MicroMsg.WalletFormView", "shouldClearFocus: %s", new Object[] { Boolean.valueOf(this.xGa) });
    if (this.xGa)
    {
      getContentEditText().clearFocus();
      AppMethodBeat.o(67301);
      return;
    }
    this.xGa = true;
    AppMethodBeat.o(67301);
  }
  
  public final void dHv()
  {
    AppMethodBeat.i(67309);
    if (this.xFx != null) {
      this.xFx.setText("");
    }
    AppMethodBeat.o(67309);
  }
  
  public final EditText getContentEditText()
  {
    return this.xFx;
  }
  
  public final a getEventDelegate()
  {
    return this.xFD;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.xFy;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(67311);
    if (this.xFx != null)
    {
      int i = this.xFx.getText().length();
      AppMethodBeat.o(67311);
      return i;
    }
    AppMethodBeat.o(67311);
    return 0;
  }
  
  public final a getInputValidChangeListener()
  {
    return this.xFA;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(67304);
    if (this.xFx != null)
    {
      KeyListener localKeyListener = this.xFx.getKeyListener();
      AppMethodBeat.o(67304);
      return localKeyListener;
    }
    ae.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(67304);
    return null;
  }
  
  public final b getLogicDelegate()
  {
    return this.xFE;
  }
  
  public final int getMaxInputLength()
  {
    return this.xFR;
  }
  
  public final int getMinInputLength()
  {
    return this.xFS;
  }
  
  public final TextView getPrefilledTv()
  {
    return this.xFw;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(67303);
    if (this.xFx != null)
    {
      String str = this.xFx.getText().toString();
      if ((this.xFE != null) && (this.xFE.dHs()))
      {
        str = this.xFE.awE(str);
        AppMethodBeat.o(67303);
        return str;
      }
      AppMethodBeat.o(67303);
      return str;
    }
    ae.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
    AppMethodBeat.o(67303);
    return "";
  }
  
  public final TextView getTipsTv()
  {
    return this.xFz;
  }
  
  public final TextView getTitleTv()
  {
    return this.lHk;
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
      getTitleTv().setText(this.vli);
      getTitleTv().setVisibility(this.xFG);
    }
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.xFH);
      getPrefilledTv().setVisibility(this.xFI);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.xFJ);
      getInfoIv().setVisibility(this.xFK);
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.xFL);
      getTipsTv().setVisibility(this.xFM);
    }
    getContext();
    if (this.xFx != null)
    {
      this.xFx.setHint(this.xFN);
      this.xFx.setGravity(this.xFO);
      this.xFx.setTextColor(this.xFP);
      setText(this.xFQ);
      this.xFx.setBackgroundResource(this.xFT);
      this.xFx.setEnabled(this.xFU);
      this.xFx.setFocusable(this.xFW);
      this.xFx.setClickable(this.xFV);
      this.xFx.setHintTextColor(this.xFZ);
      setImeOptions(this.xFY);
      setInputType(this.xFX);
      this.xFx.addTextChangedListener(new TextWatcher()
      {
        private boolean xGb = false;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(67285);
          if (MallFormView.this.aVz() != this.xGb)
          {
            if (MallFormView.c(MallFormView.this) != null) {
              MallFormView.c(MallFormView.this).onInputValidChange(MallFormView.this.aVz());
            }
            this.xGb = MallFormView.this.aVz();
          }
          MallFormView.this.dHt();
          AppMethodBeat.o(67285);
        }
      });
      this.xFx.setOnFocusChangeListener(this);
    }
    dHt();
    if (this.xFx != null)
    {
      if (this.xFX != 2) {
        break label347;
      }
      this.xFx.setKeyListener(new NumberKeyListener()
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
      if (this.xFR != -1) {
        this.xFx.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.xFR) });
      }
      AppMethodBeat.o(67294);
      return;
      label347:
      if (this.xFX == 4)
      {
        this.xFx.setKeyListener(new NumberKeyListener()
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
      else if (this.xFX == 128)
      {
        this.xFx.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.xFx.setKeyListener(new NumberKeyListener()
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
        this.xFx.setRawInputType(18);
      }
      else if (this.xFX == 3)
      {
        this.xFx.setKeyListener(new NumberKeyListener()
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
        this.xFx.setInputType(this.xFX);
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(67312);
    if (this.xFB != null) {
      this.xFB.onFocusChange(this, paramBoolean);
    }
    if (!aVz()) {
      if (this.lHk != null) {
        this.lHk.setEnabled(false);
      }
    }
    for (;;)
    {
      dHt();
      AppMethodBeat.o(67312);
      return;
      if (this.lHk != null) {
        this.lHk.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67298);
    if ((this.xFD == null) || (!this.xFD.dHr()))
    {
      if ((this.xFx != null) && (b(this.xFx, paramMotionEvent)) && (!this.xFx.isClickable()))
      {
        ae.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(67298);
        return true;
      }
      if ((b(this.xFy, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        ae.d("MicroMsg.WalletFormView", "hy: click on info iv");
        this.xFy.performClick();
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
    if ((this.xFD == null) || (!this.xFD.dHq())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(67297);
  }
  
  public final void setEventDelegate(a parama)
  {
    this.xFD = parama;
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(67310);
    if (this.xFx != null) {
      this.xFx.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(67310);
  }
  
  public final void setHint(String paramString)
  {
    AppMethodBeat.i(67295);
    if (this.xFx != null) {
      this.xFx.setHint(paramString);
    }
    AppMethodBeat.o(67295);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(67288);
    if (this.xFx != null) {
      this.xFx.setImeOptions(paramInt);
    }
    AppMethodBeat.o(67288);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(67289);
    if (this.xFx != null) {
      this.xFx.setInputType(paramInt);
    }
    AppMethodBeat.o(67289);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(67307);
    if (this.xFx != null) {
      this.xFx.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(67307);
  }
  
  public final void setLogicDelegate(b paramb)
  {
    this.xFE = paramb;
  }
  
  public final void setMaxInputLength(int paramInt)
  {
    this.xFR = paramInt;
  }
  
  public final void setMinInputLength(int paramInt)
  {
    this.xFS = paramInt;
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
    this.xFx.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(67296);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.xFB = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67306);
    this.xFC = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.xFC);
    }
    AppMethodBeat.o(67306);
  }
  
  public final void setOnInputValidChangeListener(a parama)
  {
    this.xFA = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(67302);
    if (this.xFx != null) {
      this.xFx.setSelection(paramInt);
    }
    AppMethodBeat.o(67302);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(67290);
    if (this.xFx != null)
    {
      this.xFx.setText(paramString);
      this.xFx.setSelection(getInputLength());
    }
    AppMethodBeat.o(67290);
  }
  
  public static abstract interface a
  {
    public abstract void onInputValidChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.MallFormView
 * JD-Core Version:    0.7.0.1
 */