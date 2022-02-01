package com.tencent.mm.wallet_core.ui.formview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Editable;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.lang.reflect.Field;
import junit.framework.Assert;

public final class WalletFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private int HFc;
  private int JHA;
  private int JHB;
  private int JHC;
  private int JHD;
  private int JHE;
  private boolean JHF;
  @Deprecated
  private int JHG;
  private int JHH;
  private int JHI;
  private int JHJ;
  private c JHu;
  public TenpaySecureEditText JHv;
  private LinearLayout JHw;
  private a JHx;
  private com.tencent.mm.wallet_core.ui.formview.a.a JHy;
  private com.tencent.mm.wallet_core.ui.formview.a.b JHz;
  private TextView lfN;
  private String tWv;
  private TextView wJn;
  private TextView whQ;
  private WalletIconImageView whS;
  private TextView whT;
  private View.OnFocusChangeListener whV;
  private View.OnClickListener whW;
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
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73147);
    this.lfN = null;
    this.whQ = null;
    this.JHv = null;
    this.whS = null;
    this.whT = null;
    this.JHx = null;
    this.whV = null;
    this.whW = null;
    this.JHy = null;
    this.JHz = null;
    this.whZ = -1;
    this.JHA = this.whZ;
    this.JHB = 100;
    this.tWv = "";
    this.wia = 0;
    this.wib = "";
    this.wic = 8;
    this.wid = -1;
    this.JHC = -1;
    this.wie = 4;
    this.wif = "";
    this.wig = 8;
    this.wih = "";
    this.JHD = -1;
    this.wii = 19;
    this.wij = 2131100711;
    this.wik = "";
    this.JHE = 0;
    this.wil = 2147483647;
    this.wim = 1;
    this.win = 2131233299;
    this.wio = true;
    this.wip = false;
    this.wiq = true;
    this.JHF = false;
    this.wir = 1;
    this.wis = 5;
    this.wit = 2131100551;
    this.JHG = 0;
    this.JHH = 0;
    this.JHI = 0;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WalletFormAttrs, paramInt, 0);
    this.whZ = paramAttributeSet.getResourceId(23, this.whZ);
    paramInt = paramAttributeSet.getResourceId(30, 0);
    if (paramInt != 0) {
      this.tWv = paramContext.getString(paramInt);
    }
    this.HFc = paramAttributeSet.getDimensionPixelSize(32, -1);
    this.wid = paramAttributeSet.getResourceId(20, this.wid);
    this.JHC = paramAttributeSet.getColor(19, this.JHC);
    paramInt = paramAttributeSet.getResourceId(28, 0);
    if (paramInt != 0) {
      this.wif = paramContext.getString(paramInt);
    }
    this.wie = paramAttributeSet.getInteger(21, this.wie);
    this.wia = paramAttributeSet.getInteger(31, this.wia);
    this.wig = paramAttributeSet.getInteger(29, this.wig);
    this.wic = paramAttributeSet.getInteger(27, this.wic);
    paramInt = paramAttributeSet.getResourceId(25, 0);
    if (paramInt != 0) {
      this.wib = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(11, 0);
    if (paramInt != 0) {
      this.wih = paramContext.getString(paramInt);
    }
    this.JHD = paramAttributeSet.getDimensionPixelSize(12, -1);
    this.wii = paramAttributeSet.getInteger(10, this.wii);
    this.wij = paramAttributeSet.getColor(17, this.wij);
    paramInt = paramAttributeSet.getResourceId(16, 0);
    if (paramInt != 0) {
      this.wik = paramContext.getString(paramInt);
    }
    this.JHE = paramAttributeSet.getInt(9, this.JHE);
    this.wil = paramAttributeSet.getInteger(14, this.wil);
    this.wim = paramAttributeSet.getInteger(15, this.wim);
    this.win = paramAttributeSet.getResourceId(5, this.win);
    this.wio = paramAttributeSet.getBoolean(7, this.wio);
    this.wip = paramAttributeSet.getBoolean(6, this.wip);
    this.wiq = paramAttributeSet.getBoolean(7, this.wiq);
    this.wir = paramAttributeSet.getInteger(0, this.wir);
    this.wis = paramAttributeSet.getInteger(1, this.wis);
    this.JHB = paramAttributeSet.getInteger(18, this.JHB);
    this.wit = paramAttributeSet.getInteger(13, this.wit);
    this.JHA = paramAttributeSet.getResourceId(24, this.JHA);
    this.JHG = paramAttributeSet.getInteger(33, 0);
    this.JHH = paramAttributeSet.getInteger(34, -1);
    if ((this.JHG == 1) && (this.JHH == -1)) {
      this.JHH = 4;
    }
    this.JHI = paramAttributeSet.getResourceId(2, 0);
    paramAttributeSet.recycle();
    if (this.whZ > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    if ((!bs.isNullOrNil(this.tWv)) && (this.tWv.length() > 6)) {
      inflate(paramContext, this.JHA, this);
    }
    for (;;)
    {
      this.lfN = ((TextView)findViewById(2131306836));
      this.whQ = ((TextView)findViewById(2131306818));
      this.JHv = ((TenpaySecureEditText)findViewById(2131306718));
      this.whS = ((WalletIconImageView)findViewById(2131306746));
      this.whT = ((TextView)findViewById(2131306835));
      this.JHw = ((LinearLayout)findViewById(2131306753));
      this.wJn = ((TextView)findViewById(2131306756));
      AppMethodBeat.o(73147);
      return;
      inflate(paramContext, this.whZ, this);
    }
  }
  
  public static void a(EditText paramEditText, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73187);
    if (paramEditText == null)
    {
      AppMethodBeat.o(73187);
      return;
    }
    a(paramEditText, paramString, aV(paramString, paramInt1, paramInt2));
    AppMethodBeat.o(73187);
  }
  
  public static void a(EditText paramEditText, String paramString1, String paramString2)
  {
    AppMethodBeat.i(73185);
    if (paramEditText == null)
    {
      AppMethodBeat.o(73185);
      return;
    }
    if (bs.lr(paramString1, paramString2))
    {
      AppMethodBeat.o(73185);
      return;
    }
    ap.f(new WalletFormView.4(paramEditText, paramString2));
    AppMethodBeat.o(73185);
  }
  
  public static boolean a(String paramString, EditText paramEditText)
  {
    AppMethodBeat.i(73186);
    if ((paramString == null) || (paramEditText == null))
    {
      AppMethodBeat.o(73186);
      return false;
    }
    if (paramString.startsWith("0"))
    {
      int i = 0;
      int j = -1;
      while ((i < paramString.length()) && ('0' == paramString.charAt(i)))
      {
        j = i;
        i += 1;
      }
      if (j != -1)
      {
        if (paramString.length() == j + 1) {
          a(paramEditText, paramString, 0, j);
        }
        for (;;)
        {
          AppMethodBeat.o(73186);
          return true;
          if (paramString.charAt(j + 1) == '.') {
            a(paramEditText, paramString, 0, j);
          } else {
            a(paramEditText, paramString, 0, j + 1);
          }
        }
      }
    }
    AppMethodBeat.o(73186);
    return false;
  }
  
  public static String aV(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73184);
    if (paramString == null)
    {
      AppMethodBeat.o(73184);
      return "";
    }
    if ((paramInt1 >= paramString.length()) || (paramInt1 < 0))
    {
      AppMethodBeat.o(73184);
      return paramString;
    }
    if (paramInt2 >= paramString.length())
    {
      paramString = paramString.substring(0, paramInt1);
      AppMethodBeat.o(73184);
      return paramString;
    }
    String str = paramString.substring(0, paramInt1);
    paramString = paramString.substring(paramInt2, paramString.length());
    paramString = bs.bG(str, "") + bs.bG(paramString, "");
    AppMethodBeat.o(73184);
    return paramString;
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(73172);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (ep(paramView).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        AppMethodBeat.o(73172);
        return true;
      }
      AppMethodBeat.o(73172);
      return false;
    }
    AppMethodBeat.o(73172);
    return false;
  }
  
  private void dtF()
  {
    AppMethodBeat.i(73160);
    if ((this.whS != null) && (!bs.isNullOrNil(getText())) && (this.JHv != null) && (this.JHv.isEnabled()) && (this.JHv.isClickable()) && (this.JHv.isFocusable()) && (this.JHv.isFocused()))
    {
      this.whS.setToClearState(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73144);
          WalletFormView.this.dtH();
          AppMethodBeat.o(73144);
        }
      });
      AppMethodBeat.o(73160);
      return;
    }
    if (this.whS != null)
    {
      this.whS.eQv();
      AppMethodBeat.o(73160);
      return;
    }
    ac.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(73160);
  }
  
  private Rect ep(View paramView)
  {
    AppMethodBeat.i(73173);
    if (paramView != null)
    {
      Rect localRect = new Rect();
      paramView.getHitRect(localRect);
      paramView = k(paramView, localRect);
      AppMethodBeat.o(73173);
      return paramView;
    }
    AppMethodBeat.o(73173);
    return null;
  }
  
  private void fAW()
  {
    AppMethodBeat.i(73174);
    if (getTitleTv() != null)
    {
      getTitleTv().setText(this.tWv);
      getTitleTv().setVisibility(this.wia);
      setTitleWidth(this.HFc);
    }
    AppMethodBeat.o(73174);
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
  
  public final void a(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(73182);
    if (this.JHv != null) {
      this.JHv.addTextChangedListener(paramTextWatcher);
    }
    AppMethodBeat.o(73182);
  }
  
  public final boolean aRO()
  {
    AppMethodBeat.i(73189);
    if (this.JHv != null)
    {
      int i = this.JHv.getInputLength();
      if ((i > this.wil) || (i < this.wim))
      {
        AppMethodBeat.o(73189);
        return false;
      }
      if (this.JHz != null)
      {
        boolean bool = this.JHz.a(this);
        AppMethodBeat.o(73189);
        return bool;
      }
      AppMethodBeat.o(73189);
      return true;
    }
    ac.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
    AppMethodBeat.o(73189);
    return true;
  }
  
  public final void d(WalletBaseUI paramWalletBaseUI)
  {
    AppMethodBeat.i(73196);
    if (this.JHv != null)
    {
      this.JHv.setFocusable(true);
      this.JHv.requestFocus();
      paramWalletBaseUI.showTenpayKB();
    }
    AppMethodBeat.o(73196);
  }
  
  public final void dtG()
  {
    AppMethodBeat.i(73191);
    if (this.JHv != null) {
      this.JHv.clearFocus();
    }
    AppMethodBeat.o(73191);
  }
  
  public final void dtH()
  {
    AppMethodBeat.i(73190);
    if (this.JHv != null) {
      this.JHv.ClearInput();
    }
    AppMethodBeat.o(73190);
  }
  
  public final boolean fAV()
  {
    AppMethodBeat.i(73161);
    if (this.JHv != null)
    {
      boolean bool = this.JHv.isFocusable();
      AppMethodBeat.o(73161);
      return bool;
    }
    AppMethodBeat.o(73161);
    return false;
  }
  
  public final void fAX()
  {
    AppMethodBeat.i(73183);
    if (this.JHv != null) {
      this.JHv.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(73145);
          String str = paramAnonymousEditable.toString();
          int k = str.indexOf(".");
          int m = str.length();
          if (k >= 0)
          {
            i = str.indexOf(".", k + 1);
            if (i >= 0)
            {
              WalletFormView.a(WalletFormView.j(WalletFormView.this), str, i, m);
              AppMethodBeat.o(73145);
              return;
            }
          }
          int i = 0;
          if ((this.JHL >= 0) && (k >= 0) && (m - k > this.JHL))
          {
            paramAnonymousEditable = WalletFormView.aV(str, this.JHL + k + 1, m);
            i = 1;
          }
          for (;;)
          {
            int j = i;
            Object localObject = paramAnonymousEditable;
            int n;
            if (this.JHM >= 0)
            {
              n = WalletFormView.j(WalletFormView.this).getSelectionStart();
              if (k <= this.JHM) {
                break label236;
              }
              j = i;
              localObject = paramAnonymousEditable;
              if (!bs.jl(n, -1))
              {
                j = i;
                localObject = paramAnonymousEditable;
                if (k - this.JHM > 0)
                {
                  j = i;
                  localObject = paramAnonymousEditable;
                  if (n - (k - this.JHM) >= 0)
                  {
                    localObject = WalletFormView.aV(paramAnonymousEditable, n - (k - 7), n);
                    j = 1;
                  }
                }
              }
            }
            for (;;)
            {
              if (j != 0) {
                WalletFormView.a(WalletFormView.j(WalletFormView.this), str, (String)localObject);
              }
              AppMethodBeat.o(73145);
              return;
              label236:
              j = i;
              localObject = paramAnonymousEditable;
              if (bs.jl(k, -1))
              {
                j = i;
                localObject = paramAnonymousEditable;
                if (m > this.JHM)
                {
                  j = i;
                  localObject = paramAnonymousEditable;
                  if (n >= 0)
                  {
                    j = i;
                    localObject = paramAnonymousEditable;
                    if (n - (m - this.JHM) >= 0)
                    {
                      localObject = WalletFormView.aV(paramAnonymousEditable, n - (m - this.JHM), n);
                      j = 1;
                    }
                  }
                }
              }
            }
            paramAnonymousEditable = str;
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
    }
    AppMethodBeat.o(73183);
  }
  
  public final void fAY()
  {
    AppMethodBeat.i(73195);
    if (this.JHv != null)
    {
      this.JHv.setFocusable(true);
      this.JHv.requestFocus();
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.JHv, 0);
    }
    AppMethodBeat.o(73195);
  }
  
  public final boolean gX(View paramView)
  {
    AppMethodBeat.i(73192);
    if (getVisibility() == 0)
    {
      if (bs.isNullOrNil(getText()))
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.lfN != null) {
          this.lfN.setEnabled(true);
        }
        AppMethodBeat.o(73192);
        return false;
      }
      if (aRO())
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.lfN != null) {
          this.lfN.setEnabled(true);
        }
        AppMethodBeat.o(73192);
        return true;
      }
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      if (this.lfN != null) {
        this.lfN.setEnabled(false);
      }
      AppMethodBeat.o(73192);
      return false;
    }
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    AppMethodBeat.o(73192);
    return true;
  }
  
  public final EditText getContentEt()
  {
    return this.JHv;
  }
  
  public final int getEncrptType()
  {
    return this.JHB;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.a getEventDelegate()
  {
    return this.JHy;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.whS;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(73194);
    if (this.JHv != null)
    {
      int i = this.JHv.getInputLength();
      AppMethodBeat.o(73194);
      return i;
    }
    AppMethodBeat.o(73194);
    return 0;
  }
  
  public final a getInputValidChangeListener()
  {
    return this.JHx;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(73177);
    if (this.JHv != null)
    {
      KeyListener localKeyListener = this.JHv.getKeyListener();
      AppMethodBeat.o(73177);
      return localKeyListener;
    }
    ac.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(73177);
    return null;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.b getLogicDelegate()
  {
    return this.JHz;
  }
  
  public final String getMD5Value()
  {
    AppMethodBeat.i(73152);
    String str2 = bs.nullAsNil(this.JHv.getText().toString());
    String str1 = str2;
    if (this.JHz != null)
    {
      str1 = str2;
      if (this.JHz.dtE()) {
        str1 = this.JHz.c(this, str2);
      }
    }
    str1 = ah.dg(str1);
    AppMethodBeat.o(73152);
    return str1;
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
  
  public final int getSelectionStart()
  {
    AppMethodBeat.i(73157);
    if (this.JHv != null)
    {
      int i = this.JHv.getSelectionStart();
      AppMethodBeat.o(73157);
      return i;
    }
    AppMethodBeat.o(73157);
    return -1;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(73176);
    if (this.JHv != null)
    {
      String str = c.a.a(this.JHB, this.JHv);
      if ((this.JHz != null) && (this.JHz.dtE()))
      {
        str = this.JHz.c(this, str);
        AppMethodBeat.o(73176);
        return str;
      }
      AppMethodBeat.o(73176);
      return str;
    }
    ac.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
    AppMethodBeat.o(73176);
    return "";
  }
  
  public final TextView getTipsTv()
  {
    return this.whT;
  }
  
  public final float getTitleMeasuredWidth()
  {
    AppMethodBeat.i(182538);
    float f = this.lfN.getPaint().measureText(this.lfN.getText(), 0, this.lfN.getText().length());
    AppMethodBeat.o(182538);
    return f;
  }
  
  public final TextView getTitleTv()
  {
    return this.lfN;
  }
  
  public final boolean isPhoneNum()
  {
    AppMethodBeat.i(73181);
    if (this.JHv == null)
    {
      AppMethodBeat.o(73181);
      return false;
    }
    boolean bool = this.JHv.isPhoneNum();
    AppMethodBeat.o(73181);
    return bool;
  }
  
  public final int n(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73149);
    if (this.JHJ == 0)
    {
      int i = this.lfN.getLeft();
      this.JHJ = (this.JHv.getLeft() - i + this.JHv.getPaddingLeft());
      ac.d("MicroMsg.WalletFormView", "mMaxUnitLeftOriginWidth:%s", new Object[] { Integer.valueOf(this.JHJ) });
    }
    if (!bs.lr(paramCharSequence.toString(), ""))
    {
      if (paramInt2 == 1) {}
      for (float f1 = this.JHv.getPaint().measureText("1");; f1 = this.JHv.getPaint().measureText("2"))
      {
        float f2 = this.JHJ;
        paramInt1 = (int)(f1 / 2.0F + f2 - paramInt1 / 2);
        AppMethodBeat.o(73149);
        return paramInt1;
      }
    }
    AppMethodBeat.o(73149);
    return 0;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(73162);
    super.onAttachedToWindow();
    AppMethodBeat.o(73162);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(73163);
    super.onDetachedFromWindow();
    AppMethodBeat.o(73163);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(73164);
    super.onFinishInflate();
    fAW();
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.wib);
      getPrefilledTv().setVisibility(this.wic);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.wid);
      getInfoIv().setVisibility(this.wie);
      if (this.JHC != -1) {
        getInfoIv().setmUserSetImageIconColor(this.JHC);
      }
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.wif);
      getTipsTv().setVisibility(this.wig);
    }
    Object localObject = getContext();
    String str;
    if (this.JHv != null) {
      if (this.JHH >= 0) {
        str = e.adP(this.JHH);
      }
    }
    try
    {
      this.JHv.setTypeface(Typeface.createFromAsset(((Context)localObject).getAssets(), str));
      if (this.JHD == -1)
      {
        this.JHv.setHint(this.wih);
        this.JHv.setGravity(this.wii);
        this.JHv.setTextColor(this.wij);
        setText(this.wik);
        b.a(this.JHv, this.JHE);
        this.JHv.setBackgroundResource(this.win);
        this.JHv.setEnabled(this.wio);
        this.JHv.setFocusable(this.wiq);
        this.JHv.setClickable(this.wip);
        this.JHv.setHintTextColor(this.wit);
        setImeOptions(this.wis);
        setInputType(this.wir);
        this.JHv.addTextChangedListener(new TextWatcher()
        {
          private boolean wiv = false;
          
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(73143);
            String str = paramAnonymousEditable.toString();
            if (str.startsWith(".")) {
              paramAnonymousEditable.insert(0, "0");
            }
            while ((!WalletFormView.i(WalletFormView.this)) || (!WalletFormView.a(str, WalletFormView.j(WalletFormView.this))))
            {
              boolean bool = WalletFormView.this.aRO();
              if (WalletFormView.k(WalletFormView.this) != null)
              {
                if (bool != this.wiv)
                {
                  WalletFormView.k(WalletFormView.this).onInputValidChange(bool);
                  this.wiv = WalletFormView.this.aRO();
                }
                if (((WalletFormView.k(WalletFormView.this) instanceof WalletFormView.b)) && (bool)) {
                  WalletFormView.k(WalletFormView.this);
                }
              }
              WalletFormView.l(WalletFormView.this);
              AppMethodBeat.o(73143);
              return;
            }
            AppMethodBeat.o(73143);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(73142);
            if (WalletFormView.h(WalletFormView.this) != null) {
              WalletFormView.h(WalletFormView.this).p(paramAnonymousCharSequence);
            }
            AppMethodBeat.o(73142);
          }
        });
        this.JHv.setOnFocusChangeListener(this);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (!bs.jl(this.JHI, 0))
          {
            localObject = TextView.class.getDeclaredField("mCursorDrawableRes");
            ((Field)localObject).setAccessible(true);
            ((Field)localObject).set(this.JHv, Integer.valueOf(this.JHI));
          }
          dtF();
          if (this.JHv != null)
          {
            if (this.wir != 2) {
              break;
            }
            this.JHv.setKeyListener(new NumberKeyListener()
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
            if (this.wil != -1) {
              this.JHv.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.wil) });
            }
          }
          AppMethodBeat.o(73164);
          return;
          localException1 = localException1;
          ac.e("MicroMsg.WalletFormView", "setTypeface() Exception:%s %s", new Object[] { localException1.getClass().getSimpleName(), localException1.getMessage() });
        }
        SpannableString localSpannableString = new SpannableString(this.wih + "  ");
        localSpannableString.setSpan(new com.tencent.mm.cg.a(this.JHD), 0, localSpannableString.length() - 2, 33);
        localSpannableString.setSpan(new AbsoluteSizeSpan((int)this.JHv.getTextSize(), false), localSpannableString.length() - 2, localSpannableString.length(), 33);
        this.JHv.setHint(new SpannedString(localSpannableString));
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.e("MicroMsg.WalletFormView", "set textCursorDrawable fail!!");
          continue;
          if (this.wir == 4)
          {
            this.JHv.setKeyListener(new NumberKeyListener()
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
            this.JHv.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.JHv.setKeyListener(new NumberKeyListener()
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
            this.JHv.setRawInputType(18);
          }
          else if (this.wir == 3)
          {
            this.JHv.setKeyListener(new NumberKeyListener()
            {
              protected final char[] getAcceptedChars()
              {
                return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 45, 43 };
              }
              
              public final int getInputType()
              {
                return 3;
              }
            });
          }
          else
          {
            this.JHv.setInputType(this.wir);
          }
        }
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(73198);
    if (this.whV != null) {
      this.whV.onFocusChange(this, paramBoolean);
    }
    if (this.JHx != null) {
      this.JHx.onInputValidChange(aRO());
    }
    if (!aRO()) {
      if (this.lfN != null) {
        this.lfN.setEnabled(false);
      }
    }
    for (;;)
    {
      dtF();
      AppMethodBeat.o(73198);
      return;
      if (this.lfN != null) {
        this.lfN.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(73171);
    if ((this.JHy == null) || (!this.JHy.fBa()))
    {
      if ((this.JHv != null) && (b(this.JHv, paramMotionEvent)) && (!this.JHv.isClickable()))
      {
        ac.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(73171);
        return true;
      }
      if ((this.whS != null) && (this.whS.isClickable()) && (b(this.whS, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        ac.d("MicroMsg.WalletFormView", "hy: click on info iv");
        dtF();
        this.whS.performClick();
        AppMethodBeat.o(73171);
        return true;
      }
      AppMethodBeat.o(73171);
      return false;
    }
    AppMethodBeat.o(73171);
    return true;
  }
  
  @SuppressLint({"WrongCall"})
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73170);
    if ((this.JHy == null) || (!this.JHy.fAZ())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(73170);
  }
  
  public final void set3DesToView(String paramString)
  {
    AppMethodBeat.i(73199);
    if (this.JHv != null) {
      this.JHv.set3DesEncrptData(paramString);
    }
    AppMethodBeat.o(73199);
  }
  
  public final void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(73151);
    if ((this.JHv != null) && ((this.JHz == null) || (!this.JHz.b(this, paramString))))
    {
      this.JHv.set3DesEncrptData(paramString);
      setSelection(getInputLength());
    }
    AppMethodBeat.o(73151);
  }
  
  public final void setBankcardTail(String paramString)
  {
    AppMethodBeat.i(73178);
    if (this.JHv != null) {
      this.JHv.setBankcardTailNum(paramString);
    }
    AppMethodBeat.o(73178);
  }
  
  public final void setContentClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(73166);
    if (this.JHv != null) {
      this.JHv.setClickable(paramBoolean);
    }
    AppMethodBeat.o(73166);
  }
  
  public final void setContentEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(73168);
    if (this.JHv != null) {
      this.JHv.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(73168);
  }
  
  public final void setContentFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(73167);
    if (this.JHv != null) {
      this.JHv.setFocusable(paramBoolean);
    }
    AppMethodBeat.o(73167);
  }
  
  public final void setContentPadding$3b4dfe4b(int paramInt)
  {
    AppMethodBeat.i(163889);
    if (this.JHv != null) {
      this.JHv.setPadding(paramInt, 0, 0, 0);
    }
    AppMethodBeat.o(163889);
  }
  
  public final void setContentTextColor(int paramInt)
  {
    AppMethodBeat.i(73159);
    if (this.JHv != null) {
      this.JHv.setTextColor(paramInt);
    }
    AppMethodBeat.o(73159);
  }
  
  @SuppressLint({"ResourceType"})
  public final void setContentTextColorRes(int paramInt)
  {
    AppMethodBeat.i(73158);
    this.wij = paramInt;
    if (this.JHv != null) {
      this.JHv.setTextColor(getResources().getColor(this.wij));
    }
    AppMethodBeat.o(73158);
  }
  
  public final void setEncryptType(int paramInt)
  {
    this.JHB = paramInt;
  }
  
  public final void setEventDelegate(com.tencent.mm.wallet_core.ui.formview.a.a parama)
  {
    this.JHy = parama;
  }
  
  public final void setFilterChar(char[] paramArrayOfChar) {}
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(73193);
    if (this.JHv != null) {
      this.JHv.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(73193);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(73165);
    if (this.JHv != null)
    {
      if (this.JHD == -1)
      {
        this.JHv.setHint(paramCharSequence);
        AppMethodBeat.o(73165);
        return;
      }
      paramCharSequence = new SpannableString(paramCharSequence);
      paramCharSequence.setSpan(new AbsoluteSizeSpan(this.JHD, false), 0, paramCharSequence.length(), 33);
      this.JHv.setHint(new SpannedString(paramCharSequence));
    }
    AppMethodBeat.o(73165);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(73153);
    if (this.JHv != null) {
      this.JHv.setImeOptions(paramInt);
    }
    AppMethodBeat.o(73153);
  }
  
  public final void setInputEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(73156);
    if (this.JHv != null) {
      this.JHv.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(73156);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(73154);
    if (this.JHv != null) {
      this.JHv.setInputType(paramInt);
    }
    AppMethodBeat.o(73154);
  }
  
  public final void setIsSecretAnswer(boolean paramBoolean)
  {
    AppMethodBeat.i(73197);
    if (this.JHv != null) {
      this.JHv.setIsSecurityAnswerFormat(paramBoolean);
    }
    AppMethodBeat.o(73197);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(73188);
    if (this.JHv != null) {
      this.JHv.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(73188);
  }
  
  public final void setLogicDelegate(com.tencent.mm.wallet_core.ui.formview.a.b paramb)
  {
    this.JHz = paramb;
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
    AppMethodBeat.i(73179);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(73179);
  }
  
  public final void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(73169);
    this.JHv.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(73169);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.whV = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(73180);
    this.whW = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.whW);
    }
    AppMethodBeat.o(73180);
  }
  
  public final void setOnInputValidChangeListener(a parama)
  {
    this.JHx = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(73175);
    if (this.JHv != null) {
      this.JHv.setSelection(paramInt);
    }
    AppMethodBeat.o(73175);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(73155);
    if ((this.JHv != null) && ((this.JHz == null) || (!this.JHz.a(this, paramString))))
    {
      this.JHv.setText(paramString);
      this.JHv.setSelection(getInputLength());
    }
    AppMethodBeat.o(73155);
  }
  
  public final void setTitleText(String paramString)
  {
    AppMethodBeat.i(73148);
    this.tWv = paramString;
    fAW();
    AppMethodBeat.o(73148);
  }
  
  public final void setTitleWidth(int paramInt)
  {
    AppMethodBeat.i(182539);
    this.HFc = paramInt;
    if (this.HFc > 0)
    {
      ViewGroup.LayoutParams localLayoutParams = this.lfN.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = this.HFc;
        this.lfN.setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(182539);
  }
  
  public final void setmContentAbnormalMoneyCheck(boolean paramBoolean)
  {
    this.JHF = paramBoolean;
  }
  
  public final void setmWalletFormViewListener(c paramc)
  {
    this.JHu = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void onInputValidChange(boolean paramBoolean);
  }
  
  public static abstract interface b
    extends WalletFormView.a
  {}
  
  public static abstract interface c
  {
    public abstract void p(CharSequence paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.WalletFormView
 * JD-Core Version:    0.7.0.1
 */