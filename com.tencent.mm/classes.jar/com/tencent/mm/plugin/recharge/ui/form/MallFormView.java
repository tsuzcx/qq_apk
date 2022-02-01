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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class MallFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private View.OnClickListener BFA;
  private a BFB;
  private b BFC;
  private int BFD;
  private String BFE;
  private int BFF;
  private String BFG;
  private int BFH;
  private int BFI;
  private int BFJ;
  private String BFK;
  private int BFL;
  private String BFM;
  private int BFN;
  private int BFO;
  private String BFP;
  private int BFQ;
  private int BFR;
  private int BFS;
  private boolean BFT;
  private boolean BFU;
  private boolean BFV;
  private int BFW;
  private int BFX;
  private int BFY;
  public boolean BFZ;
  private TextView BFu;
  public EditText BFv;
  private WalletIconImageView BFw;
  private TextView BFx;
  private a BFy;
  private View.OnFocusChangeListener BFz;
  private TextView mPa;
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67287);
    this.mPa = null;
    this.BFu = null;
    this.BFv = null;
    this.BFw = null;
    this.BFx = null;
    this.BFy = null;
    this.BFz = null;
    this.BFA = null;
    this.BFB = null;
    this.BFC = null;
    this.BFD = -1;
    this.BFE = "";
    this.BFF = 0;
    this.BFG = "";
    this.BFH = 8;
    this.BFI = -1;
    this.BFJ = 4;
    this.BFK = "";
    this.BFL = 8;
    this.BFM = "";
    this.BFN = 19;
    this.BFO = 2131100904;
    this.BFP = "";
    this.BFQ = 2147483647;
    this.BFR = 1;
    this.BFS = 2131233974;
    this.BFT = true;
    this.BFU = false;
    this.BFV = true;
    this.BFW = 1;
    this.BFX = 5;
    this.BFY = 2131100690;
    this.BFZ = true;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MallFormAttrs, paramInt, 0);
    this.BFD = paramAttributeSet.getResourceId(17, this.BFD);
    paramInt = paramAttributeSet.getResourceId(23, 0);
    if (paramInt != 0) {
      this.BFE = paramContext.getString(paramInt);
    }
    this.BFI = paramAttributeSet.getResourceId(14, this.BFI);
    paramInt = paramAttributeSet.getResourceId(21, 0);
    if (paramInt != 0) {
      this.BFK = paramContext.getString(paramInt);
    }
    this.BFJ = paramAttributeSet.getInteger(15, this.BFJ);
    this.BFF = paramAttributeSet.getInteger(25, this.BFF);
    this.BFL = paramAttributeSet.getInteger(22, this.BFL);
    this.BFH = paramAttributeSet.getInteger(20, this.BFH);
    paramInt = paramAttributeSet.getResourceId(18, 0);
    if (paramInt != 0) {
      this.BFG = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(8, 0);
    if (paramInt != 0) {
      this.BFM = paramContext.getString(paramInt);
    }
    this.BFN = paramAttributeSet.getInteger(7, this.BFN);
    this.BFO = paramAttributeSet.getColor(13, this.BFO);
    paramInt = paramAttributeSet.getResourceId(12, 0);
    if (paramInt != 0) {
      this.BFP = paramContext.getString(paramInt);
    }
    this.BFQ = paramAttributeSet.getInteger(10, this.BFQ);
    this.BFR = paramAttributeSet.getInteger(11, this.BFR);
    this.BFS = paramAttributeSet.getResourceId(2, this.BFS);
    this.BFT = paramAttributeSet.getBoolean(4, this.BFT);
    this.BFU = paramAttributeSet.getBoolean(3, this.BFU);
    this.BFV = paramAttributeSet.getBoolean(4, this.BFV);
    this.BFW = paramAttributeSet.getInteger(0, this.BFW);
    this.BFX = paramAttributeSet.getInteger(1, this.BFX);
    this.BFY = paramAttributeSet.getInteger(9, this.BFY);
    paramAttributeSet.recycle();
    if (this.BFD > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    inflate(paramContext, this.BFD, this);
    this.mPa = ((TextView)findViewById(2131304481));
    this.BFu = ((TextView)findViewById(2131304423));
    this.BFv = ((EditText)findViewById(2131304347));
    this.BFw = ((WalletIconImageView)findViewById(2131304359));
    this.BFx = ((TextView)findViewById(2131304480));
    AppMethodBeat.o(67287);
  }
  
  private boolean c(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67299);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (eJ(paramView).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
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
  
  private Rect eJ(View paramView)
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
    if (paramView == this.BFw)
    {
      paramRect.left -= 50;
      paramRect.right += 50;
      paramRect.top -= 25;
      paramRect.bottom += 25;
    }
    return paramRect;
  }
  
  public final boolean bql()
  {
    AppMethodBeat.i(67308);
    if (this.BFv != null)
    {
      if (this.BFv.getText() == null) {}
      for (int i = 0; (i > this.BFQ) || (i < this.BFR); i = this.BFv.getText().length())
      {
        AppMethodBeat.o(67308);
        return false;
      }
      if (this.BFC != null)
      {
        boolean bool = this.BFC.a(this);
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
  
  public final void eIh()
  {
    AppMethodBeat.i(67291);
    if ((this.BFw != null) && (!Util.isNullOrNil(getText())) && (this.BFv != null) && (this.BFv.isEnabled()) && (this.BFv.isClickable()) && (this.BFv.isFocusable()) && (this.BFv.isFocused()))
    {
      this.BFw.setToClearState(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67286);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MallFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          MallFormView.this.eIj();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MallFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67286);
        }
      });
      AppMethodBeat.o(67291);
      return;
    }
    if (this.BFw != null)
    {
      this.BFw.gsP();
      AppMethodBeat.o(67291);
      return;
    }
    Log.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(67291);
  }
  
  public final void eIi()
  {
    AppMethodBeat.i(67301);
    Log.d("MicroMsg.WalletFormView", "shouldClearFocus: %s", new Object[] { Boolean.valueOf(this.BFZ) });
    if (this.BFZ)
    {
      getContentEditText().clearFocus();
      AppMethodBeat.o(67301);
      return;
    }
    this.BFZ = true;
    AppMethodBeat.o(67301);
  }
  
  public final void eIj()
  {
    AppMethodBeat.i(67309);
    if (this.BFv != null) {
      this.BFv.setText("");
    }
    AppMethodBeat.o(67309);
  }
  
  public final EditText getContentEditText()
  {
    return this.BFv;
  }
  
  public final a getEventDelegate()
  {
    return this.BFB;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.BFw;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(67311);
    if (this.BFv != null)
    {
      int i = this.BFv.getText().length();
      AppMethodBeat.o(67311);
      return i;
    }
    AppMethodBeat.o(67311);
    return 0;
  }
  
  public final a getInputValidChangeListener()
  {
    return this.BFy;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(67304);
    if (this.BFv != null)
    {
      KeyListener localKeyListener = this.BFv.getKeyListener();
      AppMethodBeat.o(67304);
      return localKeyListener;
    }
    Log.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(67304);
    return null;
  }
  
  public final b getLogicDelegate()
  {
    return this.BFC;
  }
  
  public final int getMaxInputLength()
  {
    return this.BFQ;
  }
  
  public final int getMinInputLength()
  {
    return this.BFR;
  }
  
  public final TextView getPrefilledTv()
  {
    return this.BFu;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(67303);
    if (this.BFv != null)
    {
      String str = this.BFv.getText().toString();
      if ((this.BFC != null) && (this.BFC.eIg()))
      {
        str = this.BFC.aKW(str);
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
    return this.BFx;
  }
  
  public final TextView getTitleTv()
  {
    return this.mPa;
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
      getTitleTv().setText(this.BFE);
      getTitleTv().setVisibility(this.BFF);
    }
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.BFG);
      getPrefilledTv().setVisibility(this.BFH);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.BFI);
      getInfoIv().setVisibility(this.BFJ);
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.BFK);
      getTipsTv().setVisibility(this.BFL);
    }
    getContext();
    if (this.BFv != null)
    {
      this.BFv.setHint(this.BFM);
      this.BFv.setGravity(this.BFN);
      this.BFv.setTextColor(this.BFO);
      setText(this.BFP);
      this.BFv.setBackgroundResource(this.BFS);
      this.BFv.setEnabled(this.BFT);
      this.BFv.setFocusable(this.BFV);
      this.BFv.setClickable(this.BFU);
      this.BFv.setHintTextColor(this.BFY);
      setImeOptions(this.BFX);
      setInputType(this.BFW);
      this.BFv.addTextChangedListener(new TextWatcher()
      {
        private boolean BGa = false;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(67285);
          if (MallFormView.this.bql() != this.BGa)
          {
            if (MallFormView.c(MallFormView.this) != null) {
              MallFormView.c(MallFormView.this).onInputValidChange(MallFormView.this.bql());
            }
            this.BGa = MallFormView.this.bql();
          }
          MallFormView.this.eIh();
          AppMethodBeat.o(67285);
        }
      });
      this.BFv.setOnFocusChangeListener(this);
    }
    eIh();
    if (this.BFv != null)
    {
      if (this.BFW != 2) {
        break label347;
      }
      this.BFv.setKeyListener(new NumberKeyListener()
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
      if (this.BFQ != -1) {
        this.BFv.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.BFQ) });
      }
      AppMethodBeat.o(67294);
      return;
      label347:
      if (this.BFW == 4)
      {
        this.BFv.setKeyListener(new NumberKeyListener()
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
      else if (this.BFW == 128)
      {
        this.BFv.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.BFv.setKeyListener(new NumberKeyListener()
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
        this.BFv.setRawInputType(18);
      }
      else if (this.BFW == 3)
      {
        this.BFv.setKeyListener(new NumberKeyListener()
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
        this.BFv.setInputType(this.BFW);
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(67312);
    if (this.BFz != null) {
      this.BFz.onFocusChange(this, paramBoolean);
    }
    if (!bql()) {
      if (this.mPa != null) {
        this.mPa.setEnabled(false);
      }
    }
    for (;;)
    {
      eIh();
      AppMethodBeat.o(67312);
      return;
      if (this.mPa != null) {
        this.mPa.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67298);
    if ((this.BFB == null) || (!this.BFB.eIf()))
    {
      if ((this.BFv != null) && (c(this.BFv, paramMotionEvent)) && (!this.BFv.isClickable()))
      {
        Log.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(67298);
        return true;
      }
      if ((c(this.BFw, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        Log.d("MicroMsg.WalletFormView", "hy: click on info iv");
        this.BFw.performClick();
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
    if ((this.BFB == null) || (!this.BFB.eIe())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(67297);
  }
  
  public final void setEventDelegate(a parama)
  {
    this.BFB = parama;
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(67310);
    if (this.BFv != null) {
      this.BFv.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(67310);
  }
  
  public final void setHint(String paramString)
  {
    AppMethodBeat.i(67295);
    if (this.BFv != null) {
      this.BFv.setHint(paramString);
    }
    AppMethodBeat.o(67295);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(67288);
    if (this.BFv != null) {
      this.BFv.setImeOptions(paramInt);
    }
    AppMethodBeat.o(67288);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(67289);
    if (this.BFv != null) {
      this.BFv.setInputType(paramInt);
    }
    AppMethodBeat.o(67289);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(67307);
    if (this.BFv != null) {
      this.BFv.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(67307);
  }
  
  public final void setLogicDelegate(b paramb)
  {
    this.BFC = paramb;
  }
  
  public final void setMaxInputLength(int paramInt)
  {
    this.BFQ = paramInt;
  }
  
  public final void setMinInputLength(int paramInt)
  {
    this.BFR = paramInt;
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
    this.BFv.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(67296);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.BFz = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(67306);
    this.BFA = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.BFA);
    }
    AppMethodBeat.o(67306);
  }
  
  public final void setOnInputValidChangeListener(a parama)
  {
    this.BFy = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(67302);
    if (this.BFv != null) {
      this.BFv.setSelection(paramInt);
    }
    AppMethodBeat.o(67302);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(67290);
    if (this.BFv != null)
    {
      this.BFv.setText(paramString);
      this.BFv.setSelection(getInputLength());
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