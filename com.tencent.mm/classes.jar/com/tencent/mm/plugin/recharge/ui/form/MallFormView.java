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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class MallFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private TextView iJG;
  private String pXA;
  private int pXB;
  private int pXC;
  private String pXD;
  private int pXE;
  private int pXF;
  private int pXG;
  private boolean pXH;
  private boolean pXI;
  private boolean pXJ;
  private int pXK;
  private int pXL;
  private int pXM;
  public boolean pXN;
  private TextView pXi;
  public EditText pXj;
  private WalletIconImageView pXk;
  private TextView pXl;
  private MallFormView.a pXm;
  private View.OnFocusChangeListener pXn;
  private View.OnClickListener pXo;
  private a pXp;
  private b pXq;
  private int pXr;
  private String pXs;
  private int pXt;
  private String pXu;
  private int pXv;
  private int pXw;
  private int pXx;
  private String pXy;
  private int pXz;
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MallFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(44377);
    this.iJG = null;
    this.pXi = null;
    this.pXj = null;
    this.pXk = null;
    this.pXl = null;
    this.pXm = null;
    this.pXn = null;
    this.pXo = null;
    this.pXp = null;
    this.pXq = null;
    this.pXr = -1;
    this.pXs = "";
    this.pXt = 0;
    this.pXu = "";
    this.pXv = 8;
    this.pXw = -1;
    this.pXx = 4;
    this.pXy = "";
    this.pXz = 8;
    this.pXA = "";
    this.pXB = 19;
    this.pXC = 2131690322;
    this.pXD = "";
    this.pXE = 2147483647;
    this.pXF = 1;
    this.pXG = 2130839676;
    this.pXH = true;
    this.pXI = false;
    this.pXJ = true;
    this.pXK = 1;
    this.pXL = 5;
    this.pXM = 2131690217;
    this.pXN = true;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MallFormAttrs, paramInt, 0);
    this.pXr = paramAttributeSet.getResourceId(2, this.pXr);
    paramInt = paramAttributeSet.getResourceId(3, 0);
    if (paramInt != 0) {
      this.pXs = paramContext.getString(paramInt);
    }
    this.pXw = paramAttributeSet.getResourceId(4, this.pXw);
    paramInt = paramAttributeSet.getResourceId(5, 0);
    if (paramInt != 0) {
      this.pXy = paramContext.getString(paramInt);
    }
    this.pXx = paramAttributeSet.getInteger(8, this.pXx);
    this.pXt = paramAttributeSet.getInteger(9, this.pXt);
    this.pXz = paramAttributeSet.getInteger(10, this.pXz);
    this.pXv = paramAttributeSet.getInteger(11, this.pXv);
    paramInt = paramAttributeSet.getResourceId(12, 0);
    if (paramInt != 0) {
      this.pXu = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(13, 0);
    if (paramInt != 0) {
      this.pXA = paramContext.getString(paramInt);
    }
    this.pXB = paramAttributeSet.getInteger(14, this.pXB);
    this.pXC = paramAttributeSet.getColor(15, this.pXC);
    paramInt = paramAttributeSet.getResourceId(16, 0);
    if (paramInt != 0) {
      this.pXD = paramContext.getString(paramInt);
    }
    this.pXE = paramAttributeSet.getInteger(18, this.pXE);
    this.pXF = paramAttributeSet.getInteger(19, this.pXF);
    this.pXG = paramAttributeSet.getResourceId(20, this.pXG);
    this.pXH = paramAttributeSet.getBoolean(21, this.pXH);
    this.pXI = paramAttributeSet.getBoolean(23, this.pXI);
    this.pXJ = paramAttributeSet.getBoolean(21, this.pXJ);
    this.pXK = paramAttributeSet.getInteger(0, this.pXK);
    this.pXL = paramAttributeSet.getInteger(1, this.pXL);
    this.pXM = paramAttributeSet.getInteger(24, this.pXM);
    paramAttributeSet.recycle();
    if (this.pXr > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    inflate(paramContext, this.pXr, this);
    this.iJG = ((TextView)findViewById(2131820644));
    this.pXi = ((TextView)findViewById(2131820642));
    this.pXj = ((EditText)findViewById(2131820640));
    this.pXk = ((WalletIconImageView)findViewById(2131820641));
    this.pXl = ((TextView)findViewById(2131820643));
    AppMethodBeat.o(44377);
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(44389);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (dw(paramView).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        AppMethodBeat.o(44389);
        return true;
      }
      AppMethodBeat.o(44389);
      return false;
    }
    AppMethodBeat.o(44389);
    return false;
  }
  
  private Rect dw(View paramView)
  {
    AppMethodBeat.i(44390);
    if (paramView != null)
    {
      Rect localRect = new Rect();
      paramView.getHitRect(localRect);
      paramView = l(paramView, localRect);
      AppMethodBeat.o(44390);
      return paramView;
    }
    AppMethodBeat.o(44390);
    return null;
  }
  
  private Rect l(View paramView, Rect paramRect)
  {
    if (paramView == this.pXk)
    {
      paramRect.left -= 50;
      paramRect.right += 50;
      paramRect.top -= 25;
      paramRect.bottom += 25;
    }
    return paramRect;
  }
  
  public final boolean asv()
  {
    AppMethodBeat.i(44398);
    if (this.pXj != null)
    {
      if (this.pXj.getText() == null) {}
      for (int i = 0; (i > this.pXE) || (i < this.pXF); i = this.pXj.getText().length())
      {
        AppMethodBeat.o(44398);
        return false;
      }
      if (this.pXq != null)
      {
        boolean bool = this.pXq.a(this);
        AppMethodBeat.o(44398);
        return bool;
      }
      AppMethodBeat.o(44398);
      return true;
    }
    ab.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
    AppMethodBeat.o(44398);
    return true;
  }
  
  public final void cfI()
  {
    AppMethodBeat.i(44381);
    if ((this.pXk != null) && (!bo.isNullOrNil(getText())) && (this.pXj != null) && (this.pXj.isEnabled()) && (this.pXj.isClickable()) && (this.pXj.isFocusable()) && (this.pXj.isFocused()))
    {
      this.pXk.setToClearState(new MallFormView.2(this));
      AppMethodBeat.o(44381);
      return;
    }
    if (this.pXk != null)
    {
      this.pXk.dpM();
      AppMethodBeat.o(44381);
      return;
    }
    ab.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(44381);
  }
  
  public final void cfJ()
  {
    AppMethodBeat.i(44391);
    ab.d("MicroMsg.WalletFormView", "shouldClearFocus: %s", new Object[] { Boolean.valueOf(this.pXN) });
    if (this.pXN)
    {
      getContentEditText().clearFocus();
      AppMethodBeat.o(44391);
      return;
    }
    this.pXN = true;
    AppMethodBeat.o(44391);
  }
  
  public final void cfK()
  {
    AppMethodBeat.i(44399);
    if (this.pXj != null) {
      this.pXj.setText("");
    }
    AppMethodBeat.o(44399);
  }
  
  public final EditText getContentEditText()
  {
    return this.pXj;
  }
  
  public final a getEventDelegate()
  {
    return this.pXp;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.pXk;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(44401);
    if (this.pXj != null)
    {
      int i = this.pXj.getText().length();
      AppMethodBeat.o(44401);
      return i;
    }
    AppMethodBeat.o(44401);
    return 0;
  }
  
  public final MallFormView.a getInputValidChangeListener()
  {
    return this.pXm;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(44394);
    if (this.pXj != null)
    {
      KeyListener localKeyListener = this.pXj.getKeyListener();
      AppMethodBeat.o(44394);
      return localKeyListener;
    }
    ab.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(44394);
    return null;
  }
  
  public final b getLogicDelegate()
  {
    return this.pXq;
  }
  
  public final int getMaxInputLength()
  {
    return this.pXE;
  }
  
  public final int getMinInputLength()
  {
    return this.pXF;
  }
  
  public final TextView getPrefilledTv()
  {
    return this.pXi;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(44393);
    if (this.pXj != null)
    {
      String str = this.pXj.getText().toString();
      if ((this.pXq != null) && (this.pXq.cfH()))
      {
        str = this.pXq.XQ(str);
        AppMethodBeat.o(44393);
        return str;
      }
      AppMethodBeat.o(44393);
      return str;
    }
    ab.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
    AppMethodBeat.o(44393);
    return "";
  }
  
  public final TextView getTipsTv()
  {
    return this.pXl;
  }
  
  public final TextView getTitleTv()
  {
    return this.iJG;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(44382);
    super.onAttachedToWindow();
    AppMethodBeat.o(44382);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(44383);
    super.onDetachedFromWindow();
    AppMethodBeat.o(44383);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(44384);
    super.onFinishInflate();
    if (getTitleTv() != null)
    {
      getTitleTv().setText(this.pXs);
      getTitleTv().setVisibility(this.pXt);
    }
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.pXu);
      getPrefilledTv().setVisibility(this.pXv);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.pXw);
      getInfoIv().setVisibility(this.pXx);
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.pXy);
      getTipsTv().setVisibility(this.pXz);
    }
    getContext();
    if (this.pXj != null)
    {
      this.pXj.setHint(this.pXA);
      this.pXj.setGravity(this.pXB);
      this.pXj.setTextColor(this.pXC);
      setText(this.pXD);
      this.pXj.setBackgroundResource(this.pXG);
      this.pXj.setEnabled(this.pXH);
      this.pXj.setFocusable(this.pXJ);
      this.pXj.setClickable(this.pXI);
      this.pXj.setHintTextColor(this.pXM);
      setImeOptions(this.pXL);
      setInputType(this.pXK);
      this.pXj.addTextChangedListener(new MallFormView.1(this));
      this.pXj.setOnFocusChangeListener(this);
    }
    cfI();
    if (this.pXj != null)
    {
      if (this.pXK != 2) {
        break label347;
      }
      this.pXj.setKeyListener(new NumberKeyListener()
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
      if (this.pXE != -1) {
        this.pXj.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.pXE) });
      }
      AppMethodBeat.o(44384);
      return;
      label347:
      if (this.pXK == 4)
      {
        this.pXj.setKeyListener(new MallFormView.4(this));
      }
      else if (this.pXK == 128)
      {
        this.pXj.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.pXj.setKeyListener(new MallFormView.5(this));
        this.pXj.setRawInputType(18);
      }
      else if (this.pXK == 3)
      {
        this.pXj.setKeyListener(new MallFormView.6(this));
      }
      else
      {
        this.pXj.setInputType(this.pXK);
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(44402);
    if (this.pXn != null) {
      this.pXn.onFocusChange(this, paramBoolean);
    }
    if (!asv()) {
      if (this.iJG != null) {
        this.iJG.setEnabled(false);
      }
    }
    for (;;)
    {
      cfI();
      AppMethodBeat.o(44402);
      return;
      if (this.iJG != null) {
        this.iJG.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(44388);
    if ((this.pXp == null) || (!this.pXp.cfG()))
    {
      if ((this.pXj != null) && (b(this.pXj, paramMotionEvent)) && (!this.pXj.isClickable()))
      {
        ab.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(44388);
        return true;
      }
      if ((b(this.pXk, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        ab.d("MicroMsg.WalletFormView", "hy: click on info iv");
        this.pXk.performClick();
        AppMethodBeat.o(44388);
        return true;
      }
      AppMethodBeat.o(44388);
      return false;
    }
    AppMethodBeat.o(44388);
    return true;
  }
  
  @SuppressLint({"WrongCall"})
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44387);
    if ((this.pXp == null) || (!this.pXp.cfF())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(44387);
  }
  
  public final void setEventDelegate(a parama)
  {
    this.pXp = parama;
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(44400);
    if (this.pXj != null) {
      this.pXj.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(44400);
  }
  
  public final void setHint(String paramString)
  {
    AppMethodBeat.i(44385);
    if (this.pXj != null) {
      this.pXj.setHint(paramString);
    }
    AppMethodBeat.o(44385);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(44378);
    if (this.pXj != null) {
      this.pXj.setImeOptions(paramInt);
    }
    AppMethodBeat.o(44378);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(44379);
    if (this.pXj != null) {
      this.pXj.setInputType(paramInt);
    }
    AppMethodBeat.o(44379);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(44397);
    if (this.pXj != null) {
      this.pXj.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(44397);
  }
  
  public final void setLogicDelegate(b paramb)
  {
    this.pXq = paramb;
  }
  
  public final void setMaxInputLength(int paramInt)
  {
    this.pXE = paramInt;
  }
  
  public final void setMinInputLength(int paramInt)
  {
    this.pXF = paramInt;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(44395);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(44395);
  }
  
  public final void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(44386);
    this.pXj.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(44386);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.pXn = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(44396);
    this.pXo = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.pXo);
    }
    AppMethodBeat.o(44396);
  }
  
  public final void setOnInputValidChangeListener(MallFormView.a parama)
  {
    this.pXm = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(44392);
    if (this.pXj != null) {
      this.pXj.setSelection(paramInt);
    }
    AppMethodBeat.o(44392);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(44380);
    if (this.pXj != null)
    {
      this.pXj.setText(paramString);
      this.pXj.setSelection(getInputLength());
    }
    AppMethodBeat.o(44380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.MallFormView
 * JD-Core Version:    0.7.0.1
 */