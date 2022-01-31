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
import android.text.TextPaint;
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
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.lang.reflect.Field;
import junit.framework.Assert;

public final class WalletFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private WalletFormView.c AZd;
  public TenpaySecureEditText AZe;
  private LinearLayout AZf;
  private WalletFormView.a AZg;
  private com.tencent.mm.wallet_core.ui.formview.a.a AZh;
  private com.tencent.mm.wallet_core.ui.formview.a.b AZi;
  private int AZj;
  private int AZk;
  private int AZl;
  private int AZm;
  @Deprecated
  private int AZn;
  private int AZo;
  private int AZp;
  private int AZq;
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
  private TextView pXi;
  private WalletIconImageView pXk;
  private TextView pXl;
  private View.OnFocusChangeListener pXn;
  private View.OnClickListener pXo;
  private int pXr;
  private String pXs;
  private int pXt;
  private String pXu;
  private int pXv;
  private int pXw;
  private int pXx;
  private String pXy;
  private int pXz;
  private TextView qnH;
  private int zrB;
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49412);
    this.iJG = null;
    this.pXi = null;
    this.AZe = null;
    this.pXk = null;
    this.pXl = null;
    this.AZg = null;
    this.pXn = null;
    this.pXo = null;
    this.AZh = null;
    this.AZi = null;
    this.pXr = -1;
    this.AZj = this.pXr;
    this.AZk = 100;
    this.pXs = "";
    this.pXt = 0;
    this.pXu = "";
    this.pXv = 8;
    this.pXw = -1;
    this.pXx = 4;
    this.pXy = "";
    this.pXz = 8;
    this.pXA = "";
    this.AZl = -1;
    this.pXB = 19;
    this.pXC = 2131690322;
    this.pXD = "";
    this.AZm = 0;
    this.pXE = 2147483647;
    this.pXF = 1;
    this.pXG = 2130839676;
    this.pXH = true;
    this.pXI = false;
    this.pXJ = true;
    this.pXK = 1;
    this.pXL = 5;
    this.pXM = 2131690217;
    this.AZn = 0;
    this.AZo = 0;
    this.AZp = 0;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WalletFormAttrs, paramInt, 0);
    this.pXr = paramAttributeSet.getResourceId(4, this.pXr);
    paramInt = paramAttributeSet.getResourceId(6, 0);
    if (paramInt != 0) {
      this.pXs = paramContext.getString(paramInt);
    }
    this.zrB = paramAttributeSet.getDimensionPixelSize(7, -1);
    this.pXw = paramAttributeSet.getResourceId(8, this.pXw);
    paramInt = paramAttributeSet.getResourceId(9, 0);
    if (paramInt != 0) {
      this.pXy = paramContext.getString(paramInt);
    }
    this.pXx = paramAttributeSet.getInteger(11, this.pXx);
    this.pXt = paramAttributeSet.getInteger(12, this.pXt);
    this.pXz = paramAttributeSet.getInteger(13, this.pXz);
    this.pXv = paramAttributeSet.getInteger(14, this.pXv);
    paramInt = paramAttributeSet.getResourceId(15, 0);
    if (paramInt != 0) {
      this.pXu = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(16, 0);
    if (paramInt != 0) {
      this.pXA = paramContext.getString(paramInt);
    }
    this.AZl = paramAttributeSet.getDimensionPixelSize(17, -1);
    this.pXB = paramAttributeSet.getInteger(18, this.pXB);
    this.pXC = paramAttributeSet.getColor(19, this.pXC);
    paramInt = paramAttributeSet.getResourceId(20, 0);
    if (paramInt != 0) {
      this.pXD = paramContext.getString(paramInt);
    }
    this.AZm = paramAttributeSet.getInt(21, this.AZm);
    this.pXE = paramAttributeSet.getInteger(22, this.pXE);
    this.pXF = paramAttributeSet.getInteger(23, this.pXF);
    this.pXG = paramAttributeSet.getResourceId(24, this.pXG);
    this.pXH = paramAttributeSet.getBoolean(25, this.pXH);
    this.pXI = paramAttributeSet.getBoolean(27, this.pXI);
    this.pXJ = paramAttributeSet.getBoolean(25, this.pXJ);
    this.pXK = paramAttributeSet.getInteger(0, this.pXK);
    this.pXL = paramAttributeSet.getInteger(1, this.pXL);
    this.AZk = paramAttributeSet.getInteger(29, this.AZk);
    this.pXM = paramAttributeSet.getInteger(28, this.pXM);
    this.AZj = paramAttributeSet.getResourceId(5, this.AZj);
    this.AZn = paramAttributeSet.getInteger(31, 0);
    this.AZo = paramAttributeSet.getInteger(3, -1);
    if ((this.AZn == 1) && (this.AZo == -1)) {
      this.AZo = 4;
    }
    this.AZp = paramAttributeSet.getResourceId(2, 0);
    paramAttributeSet.recycle();
    if (this.pXr > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    if ((!bo.isNullOrNil(this.pXs)) && (this.pXs.length() > 6)) {
      inflate(paramContext, this.AZj, this);
    }
    for (;;)
    {
      this.iJG = ((TextView)findViewById(2131820696));
      this.pXi = ((TextView)findViewById(2131820694));
      this.AZe = ((TenpaySecureEditText)findViewById(2131820689));
      this.pXk = ((WalletIconImageView)findViewById(2131820693));
      this.pXl = ((TextView)findViewById(2131820695));
      this.AZf = ((LinearLayout)findViewById(2131827224));
      this.qnH = ((TextView)findViewById(2131827225));
      AppMethodBeat.o(49412);
      return;
      inflate(paramContext, this.pXr, this);
    }
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49435);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (dw(paramView).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        AppMethodBeat.o(49435);
        return true;
      }
      AppMethodBeat.o(49435);
      return false;
    }
    AppMethodBeat.o(49435);
    return false;
  }
  
  private void cfI()
  {
    AppMethodBeat.i(49423);
    if ((this.pXk != null) && (!bo.isNullOrNil(getText())) && (this.AZe != null) && (this.AZe.isEnabled()) && (this.AZe.isClickable()) && (this.AZe.isFocusable()) && (this.AZe.isFocused()))
    {
      this.pXk.setToClearState(new WalletFormView.2(this));
      AppMethodBeat.o(49423);
      return;
    }
    if (this.pXk != null)
    {
      this.pXk.dpM();
      AppMethodBeat.o(49423);
      return;
    }
    ab.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(49423);
  }
  
  private void dTa()
  {
    AppMethodBeat.i(49437);
    if (getTitleTv() != null)
    {
      getTitleTv().setText(this.pXs);
      getTitleTv().setVisibility(this.pXt);
      if (this.zrB > 0)
      {
        ViewGroup.LayoutParams localLayoutParams = getTitleTv().getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.width = this.zrB;
          getTitleTv().setLayoutParams(localLayoutParams);
        }
      }
    }
    AppMethodBeat.o(49437);
  }
  
  private Rect dw(View paramView)
  {
    AppMethodBeat.i(49436);
    if (paramView != null)
    {
      Rect localRect = new Rect();
      paramView.getHitRect(localRect);
      paramView = l(paramView, localRect);
      AppMethodBeat.o(49436);
      return paramView;
    }
    AppMethodBeat.o(49436);
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
  
  public final void a(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(49445);
    if (this.AZe != null) {
      this.AZe.addTextChangedListener(paramTextWatcher);
    }
    AppMethodBeat.o(49445);
  }
  
  public final boolean asv()
  {
    AppMethodBeat.i(49447);
    if (this.AZe != null)
    {
      int i = this.AZe.getInputLength();
      if ((i > this.pXE) || (i < this.pXF))
      {
        AppMethodBeat.o(49447);
        return false;
      }
      if (this.AZi != null)
      {
        boolean bool = this.AZi.a(this);
        AppMethodBeat.o(49447);
        return bool;
      }
      AppMethodBeat.o(49447);
      return true;
    }
    ab.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
    AppMethodBeat.o(49447);
    return true;
  }
  
  public final void cfJ()
  {
    AppMethodBeat.i(49449);
    if (this.AZe != null) {
      this.AZe.clearFocus();
    }
    AppMethodBeat.o(49449);
  }
  
  public final void cfK()
  {
    AppMethodBeat.i(49448);
    if (this.AZe != null) {
      this.AZe.ClearInput();
    }
    AppMethodBeat.o(49448);
  }
  
  public final void d(WalletBaseUI paramWalletBaseUI)
  {
    AppMethodBeat.i(49454);
    if (this.AZe != null)
    {
      this.AZe.setFocusable(true);
      this.AZe.requestFocus();
      paramWalletBaseUI.showTenpayKB();
    }
    AppMethodBeat.o(49454);
  }
  
  public final void dSY()
  {
    AppMethodBeat.i(49414);
    if (this.AZe != null) {
      this.AZe.setPadding(0, 0, 0, 0);
    }
    AppMethodBeat.o(49414);
  }
  
  public final boolean dSZ()
  {
    AppMethodBeat.i(49424);
    if (this.AZe != null)
    {
      boolean bool = this.AZe.isFocusable();
      AppMethodBeat.o(49424);
      return bool;
    }
    AppMethodBeat.o(49424);
    return false;
  }
  
  public final void dTb()
  {
    AppMethodBeat.i(142684);
    if (this.AZe != null) {
      this.AZe.addTextChangedListener(new WalletFormView.3(this));
    }
    AppMethodBeat.o(142684);
  }
  
  public final void dTc()
  {
    AppMethodBeat.i(49453);
    if (this.AZe != null)
    {
      this.AZe.setFocusable(true);
      this.AZe.requestFocus();
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.AZe, 0);
    }
    AppMethodBeat.o(49453);
  }
  
  public final boolean fE(View paramView)
  {
    AppMethodBeat.i(49450);
    if (getVisibility() == 0)
    {
      if (bo.isNullOrNil(getText()))
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.iJG != null) {
          this.iJG.setEnabled(true);
        }
        AppMethodBeat.o(49450);
        return false;
      }
      if (asv())
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.iJG != null) {
          this.iJG.setEnabled(true);
        }
        AppMethodBeat.o(49450);
        return true;
      }
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      if (this.iJG != null) {
        this.iJG.setEnabled(false);
      }
      AppMethodBeat.o(49450);
      return false;
    }
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    AppMethodBeat.o(49450);
    return true;
  }
  
  public final EditText getContentEt()
  {
    return this.AZe;
  }
  
  public final int getEncrptType()
  {
    return this.AZk;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.a getEventDelegate()
  {
    return this.AZh;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.pXk;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(49452);
    if (this.AZe != null)
    {
      int i = this.AZe.getInputLength();
      AppMethodBeat.o(49452);
      return i;
    }
    AppMethodBeat.o(49452);
    return 0;
  }
  
  public final WalletFormView.a getInputValidChangeListener()
  {
    return this.AZg;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(49440);
    if (this.AZe != null)
    {
      KeyListener localKeyListener = this.AZe.getKeyListener();
      AppMethodBeat.o(49440);
      return localKeyListener;
    }
    ab.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(49440);
    return null;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.b getLogicDelegate()
  {
    return this.AZi;
  }
  
  public final String getMD5Value()
  {
    AppMethodBeat.i(49416);
    String str2 = bo.nullAsNil(this.AZe.getText().toString());
    String str1 = str2;
    if (this.AZi != null)
    {
      str1 = str2;
      if (this.AZi.cfH()) {
        str1 = this.AZi.e(this, str2);
      }
    }
    str1 = ag.cE(str1);
    AppMethodBeat.o(49416);
    return str1;
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
  
  public final int getSelectionStart()
  {
    AppMethodBeat.i(142683);
    if (this.AZe != null)
    {
      int i = this.AZe.getSelectionStart();
      AppMethodBeat.o(142683);
      return i;
    }
    AppMethodBeat.o(142683);
    return -1;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(49439);
    if (this.AZe != null)
    {
      String str = c.a.a(this.AZk, this.AZe);
      if ((this.AZi != null) && (this.AZi.cfH()))
      {
        str = this.AZi.e(this, str);
        AppMethodBeat.o(49439);
        return str;
      }
      AppMethodBeat.o(49439);
      return str;
    }
    ab.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
    AppMethodBeat.o(49439);
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
  
  public final boolean isPhoneNum()
  {
    AppMethodBeat.i(49444);
    if (this.AZe == null)
    {
      AppMethodBeat.o(49444);
      return false;
    }
    boolean bool = this.AZe.isPhoneNum();
    AppMethodBeat.o(49444);
    return bool;
  }
  
  public final int l(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142682);
    if (this.AZq == 0)
    {
      int i = this.iJG.getLeft();
      this.AZq = (this.AZe.getLeft() - i + this.AZe.getPaddingLeft());
      ab.d("MicroMsg.WalletFormView", "mMaxUnitLeftOriginWidth:%s", new Object[] { Integer.valueOf(this.AZq) });
    }
    if (!bo.isEqual(paramCharSequence.toString(), ""))
    {
      if (paramInt2 == 1) {}
      for (float f1 = this.AZe.getPaint().measureText("1");; f1 = this.AZe.getPaint().measureText("2"))
      {
        float f2 = this.AZq;
        paramInt1 = (int)(f1 / 2.0F + f2 - paramInt1 / 2);
        AppMethodBeat.o(142682);
        return paramInt1;
      }
    }
    AppMethodBeat.o(142682);
    return 0;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(49425);
    super.onAttachedToWindow();
    AppMethodBeat.o(49425);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(49426);
    super.onDetachedFromWindow();
    AppMethodBeat.o(49426);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(49427);
    super.onFinishInflate();
    dTa();
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
    Object localObject = getContext();
    if (this.AZe != null)
    {
      if (this.AZo >= 0)
      {
        String str = e.RV(this.AZo);
        this.AZe.setTypeface(Typeface.createFromAsset(((Context)localObject).getAssets(), str));
      }
      if (this.AZl != -1) {
        break label411;
      }
      this.AZe.setHint(this.pXA);
    }
    for (;;)
    {
      this.AZe.setGravity(this.pXB);
      this.AZe.setTextColor(this.pXC);
      setText(this.pXD);
      b.a(this.AZe, this.AZm);
      this.AZe.setBackgroundResource(this.pXG);
      this.AZe.setEnabled(this.pXH);
      this.AZe.setFocusable(this.pXJ);
      this.AZe.setClickable(this.pXI);
      this.AZe.setHintTextColor(this.pXM);
      setImeOptions(this.pXL);
      setInputType(this.pXK);
      this.AZe.addTextChangedListener(new WalletFormView.1(this));
      this.AZe.setOnFocusChangeListener(this);
      try
      {
        if (!bo.hl(this.AZp, 0))
        {
          localObject = TextView.class.getDeclaredField("mCursorDrawableRes");
          ((Field)localObject).setAccessible(true);
          ((Field)localObject).set(this.AZe, Integer.valueOf(this.AZp));
        }
        cfI();
        if (this.AZe != null)
        {
          if (this.pXK != 2) {
            break label529;
          }
          this.AZe.setKeyListener(new WalletFormView.4(this));
          if (this.pXE != -1) {
            this.AZe.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.pXE) });
          }
        }
        AppMethodBeat.o(49427);
        return;
        label411:
        localObject = new SpannableString(this.pXA + "  ");
        ((SpannableString)localObject).setSpan(new com.tencent.mm.ce.a(this.AZl), 0, ((SpannableString)localObject).length() - 2, 33);
        ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan((int)this.AZe.getTextSize(), false), ((SpannableString)localObject).length() - 2, ((SpannableString)localObject).length(), 33);
        this.AZe.setHint(new SpannedString((CharSequence)localObject));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.WalletFormView", "set textCursorDrawable fail!!");
          continue;
          label529:
          if (this.pXK == 4)
          {
            this.AZe.setKeyListener(new WalletFormView.5(this));
          }
          else if (this.pXK == 128)
          {
            this.AZe.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.AZe.setKeyListener(new WalletFormView.6(this));
            this.AZe.setRawInputType(18);
          }
          else if (this.pXK == 3)
          {
            this.AZe.setKeyListener(new NumberKeyListener()
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
            this.AZe.setInputType(this.pXK);
          }
        }
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(49456);
    if (this.pXn != null) {
      this.pXn.onFocusChange(this, paramBoolean);
    }
    if (this.AZg != null) {
      this.AZg.onInputValidChange(asv());
    }
    if (!asv()) {
      if (this.iJG != null) {
        this.iJG.setEnabled(false);
      }
    }
    for (;;)
    {
      cfI();
      AppMethodBeat.o(49456);
      return;
      if (this.iJG != null) {
        this.iJG.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49434);
    if ((this.AZh == null) || (!this.AZh.dTe()))
    {
      if ((this.AZe != null) && (b(this.AZe, paramMotionEvent)) && (!this.AZe.isClickable()))
      {
        ab.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(49434);
        return true;
      }
      if ((this.pXk != null) && (this.pXk.isClickable()) && (b(this.pXk, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        ab.d("MicroMsg.WalletFormView", "hy: click on info iv");
        cfI();
        this.pXk.performClick();
        AppMethodBeat.o(49434);
        return true;
      }
      AppMethodBeat.o(49434);
      return false;
    }
    AppMethodBeat.o(49434);
    return true;
  }
  
  @SuppressLint({"WrongCall"})
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49433);
    if ((this.AZh == null) || (!this.AZh.dTd())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(49433);
  }
  
  public final void set3DesToView(String paramString)
  {
    AppMethodBeat.i(49457);
    if (this.AZe != null) {
      this.AZe.set3DesEncrptData(paramString);
    }
    AppMethodBeat.o(49457);
  }
  
  public final void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(49415);
    if ((this.AZe != null) && ((this.AZi == null) || (!this.AZi.d(this, paramString))))
    {
      this.AZe.set3DesEncrptData(paramString);
      setSelection(getInputLength());
    }
    AppMethodBeat.o(49415);
  }
  
  public final void setBankcardTail(String paramString)
  {
    AppMethodBeat.i(49441);
    if (this.AZe != null) {
      this.AZe.setBankcardTailNum(paramString);
    }
    AppMethodBeat.o(49441);
  }
  
  public final void setContentClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(49429);
    if (this.AZe != null) {
      this.AZe.setClickable(paramBoolean);
    }
    AppMethodBeat.o(49429);
  }
  
  public final void setContentEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(49431);
    if (this.AZe != null) {
      this.AZe.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(49431);
  }
  
  public final void setContentFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(49430);
    if (this.AZe != null) {
      this.AZe.setFocusable(paramBoolean);
    }
    AppMethodBeat.o(49430);
  }
  
  public final void setContentTextColor(int paramInt)
  {
    AppMethodBeat.i(49422);
    if (this.AZe != null) {
      this.AZe.setTextColor(paramInt);
    }
    AppMethodBeat.o(49422);
  }
  
  @SuppressLint({"ResourceType"})
  public final void setContentTextColorRes(int paramInt)
  {
    AppMethodBeat.i(49421);
    this.pXC = paramInt;
    if (this.AZe != null) {
      this.AZe.setTextColor(getResources().getColor(this.pXC));
    }
    AppMethodBeat.o(49421);
  }
  
  public final void setEncryptType(int paramInt)
  {
    this.AZk = paramInt;
  }
  
  public final void setEventDelegate(com.tencent.mm.wallet_core.ui.formview.a.a parama)
  {
    this.AZh = parama;
  }
  
  public final void setFilterChar(char[] paramArrayOfChar) {}
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(49451);
    if (this.AZe != null) {
      this.AZe.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(49451);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(49428);
    if (this.AZe != null)
    {
      if (this.AZl == -1)
      {
        this.AZe.setHint(paramCharSequence);
        AppMethodBeat.o(49428);
        return;
      }
      paramCharSequence = new SpannableString(paramCharSequence);
      paramCharSequence.setSpan(new AbsoluteSizeSpan(this.AZl, false), 0, paramCharSequence.length(), 33);
      this.AZe.setHint(new SpannedString(paramCharSequence));
    }
    AppMethodBeat.o(49428);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(49417);
    if (this.AZe != null) {
      this.AZe.setImeOptions(paramInt);
    }
    AppMethodBeat.o(49417);
  }
  
  public final void setInputEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(49420);
    if (this.AZe != null) {
      this.AZe.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(49420);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(49418);
    if (this.AZe != null) {
      this.AZe.setInputType(paramInt);
    }
    AppMethodBeat.o(49418);
  }
  
  public final void setIsSecretAnswer(boolean paramBoolean)
  {
    AppMethodBeat.i(49455);
    if (this.AZe != null) {
      this.AZe.setIsSecurityAnswerFormat(paramBoolean);
    }
    AppMethodBeat.o(49455);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(49446);
    if (this.AZe != null) {
      this.AZe.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(49446);
  }
  
  public final void setLogicDelegate(com.tencent.mm.wallet_core.ui.formview.a.b paramb)
  {
    this.AZi = paramb;
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
    AppMethodBeat.i(49442);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(49442);
  }
  
  public final void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(49432);
    this.AZe.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(49432);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.pXn = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(49443);
    this.pXo = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.pXo);
    }
    AppMethodBeat.o(49443);
  }
  
  public final void setOnInputValidChangeListener(WalletFormView.a parama)
  {
    this.AZg = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(49438);
    if (this.AZe != null) {
      this.AZe.setSelection(paramInt);
    }
    AppMethodBeat.o(49438);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(49419);
    if ((this.AZe != null) && ((this.AZi == null) || (!this.AZi.c(this, paramString))))
    {
      this.AZe.setText(paramString);
      this.AZe.setSelection(getInputLength());
    }
    AppMethodBeat.o(49419);
  }
  
  public final void setTitleText(String paramString)
  {
    AppMethodBeat.i(49413);
    this.pXs = paramString;
    dTa();
    AppMethodBeat.o(49413);
  }
  
  public final void setmWalletFormViewListener(WalletFormView.c paramc)
  {
    this.AZd = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.WalletFormView
 * JD-Core Version:    0.7.0.1
 */