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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.lang.reflect.Field;
import junit.framework.Assert;

public final class WalletFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private int Gfn;
  private c IfS;
  public TenpaySecureEditText IfT;
  private LinearLayout IfU;
  private a IfV;
  private com.tencent.mm.wallet_core.ui.formview.a.a IfW;
  private com.tencent.mm.wallet_core.ui.formview.a.b IfX;
  private int IfY;
  private int IfZ;
  private int Iga;
  private int Igb;
  private int Igc;
  private boolean Igd;
  @Deprecated
  private int Ige;
  private int Igf;
  private int Igg;
  private int Igh;
  private TextView kEu;
  private boolean uZA;
  private boolean uZB;
  private boolean uZC;
  private int uZD;
  private int uZE;
  private int uZF;
  private TextView uZb;
  private WalletIconImageView uZd;
  private TextView uZe;
  private View.OnFocusChangeListener uZg;
  private View.OnClickListener uZh;
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
  private TextView vzi;
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73147);
    this.kEu = null;
    this.uZb = null;
    this.IfT = null;
    this.uZd = null;
    this.uZe = null;
    this.IfV = null;
    this.uZg = null;
    this.uZh = null;
    this.IfW = null;
    this.IfX = null;
    this.uZk = -1;
    this.IfY = this.uZk;
    this.IfZ = 100;
    this.uZl = "";
    this.uZm = 0;
    this.uZn = "";
    this.uZo = 8;
    this.uZp = -1;
    this.Iga = -1;
    this.uZq = 4;
    this.uZr = "";
    this.uZs = 8;
    this.uZt = "";
    this.Igb = -1;
    this.uZu = 19;
    this.uZv = 2131100711;
    this.uZw = "";
    this.Igc = 0;
    this.uZx = 2147483647;
    this.uZy = 1;
    this.uZz = 2131233299;
    this.uZA = true;
    this.uZB = false;
    this.uZC = true;
    this.Igd = false;
    this.uZD = 1;
    this.uZE = 5;
    this.uZF = 2131100551;
    this.Ige = 0;
    this.Igf = 0;
    this.Igg = 0;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WalletFormAttrs, paramInt, 0);
    this.uZk = paramAttributeSet.getResourceId(23, this.uZk);
    paramInt = paramAttributeSet.getResourceId(30, 0);
    if (paramInt != 0) {
      this.uZl = paramContext.getString(paramInt);
    }
    this.Gfn = paramAttributeSet.getDimensionPixelSize(32, -1);
    this.uZp = paramAttributeSet.getResourceId(20, this.uZp);
    this.Iga = paramAttributeSet.getColor(19, this.Iga);
    paramInt = paramAttributeSet.getResourceId(28, 0);
    if (paramInt != 0) {
      this.uZr = paramContext.getString(paramInt);
    }
    this.uZq = paramAttributeSet.getInteger(21, this.uZq);
    this.uZm = paramAttributeSet.getInteger(31, this.uZm);
    this.uZs = paramAttributeSet.getInteger(29, this.uZs);
    this.uZo = paramAttributeSet.getInteger(27, this.uZo);
    paramInt = paramAttributeSet.getResourceId(25, 0);
    if (paramInt != 0) {
      this.uZn = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(11, 0);
    if (paramInt != 0) {
      this.uZt = paramContext.getString(paramInt);
    }
    this.Igb = paramAttributeSet.getDimensionPixelSize(12, -1);
    this.uZu = paramAttributeSet.getInteger(10, this.uZu);
    this.uZv = paramAttributeSet.getColor(17, this.uZv);
    paramInt = paramAttributeSet.getResourceId(16, 0);
    if (paramInt != 0) {
      this.uZw = paramContext.getString(paramInt);
    }
    this.Igc = paramAttributeSet.getInt(9, this.Igc);
    this.uZx = paramAttributeSet.getInteger(14, this.uZx);
    this.uZy = paramAttributeSet.getInteger(15, this.uZy);
    this.uZz = paramAttributeSet.getResourceId(5, this.uZz);
    this.uZA = paramAttributeSet.getBoolean(7, this.uZA);
    this.uZB = paramAttributeSet.getBoolean(6, this.uZB);
    this.uZC = paramAttributeSet.getBoolean(7, this.uZC);
    this.uZD = paramAttributeSet.getInteger(0, this.uZD);
    this.uZE = paramAttributeSet.getInteger(1, this.uZE);
    this.IfZ = paramAttributeSet.getInteger(18, this.IfZ);
    this.uZF = paramAttributeSet.getInteger(13, this.uZF);
    this.IfY = paramAttributeSet.getResourceId(24, this.IfY);
    this.Ige = paramAttributeSet.getInteger(33, 0);
    this.Igf = paramAttributeSet.getInteger(34, -1);
    if ((this.Ige == 1) && (this.Igf == -1)) {
      this.Igf = 4;
    }
    this.Igg = paramAttributeSet.getResourceId(2, 0);
    paramAttributeSet.recycle();
    if (this.uZk > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    if ((!bt.isNullOrNil(this.uZl)) && (this.uZl.length() > 6)) {
      inflate(paramContext, this.IfY, this);
    }
    for (;;)
    {
      this.kEu = ((TextView)findViewById(2131306836));
      this.uZb = ((TextView)findViewById(2131306818));
      this.IfT = ((TenpaySecureEditText)findViewById(2131306718));
      this.uZd = ((WalletIconImageView)findViewById(2131306746));
      this.uZe = ((TextView)findViewById(2131306835));
      this.IfU = ((LinearLayout)findViewById(2131306753));
      this.vzi = ((TextView)findViewById(2131306756));
      AppMethodBeat.o(73147);
      return;
      inflate(paramContext, this.uZk, this);
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
    a(paramEditText, paramString, aS(paramString, paramInt1, paramInt2));
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
    if (bt.kU(paramString1, paramString2))
    {
      AppMethodBeat.o(73185);
      return;
    }
    aq.f(new WalletFormView.4(paramEditText, paramString2));
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
  
  public static String aS(String paramString, int paramInt1, int paramInt2)
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
    paramString = bt.by(str, "") + bt.by(paramString, "");
    AppMethodBeat.o(73184);
    return paramString;
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(73172);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (eg(paramView).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
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
  
  private void dfY()
  {
    AppMethodBeat.i(73160);
    if ((this.uZd != null) && (!bt.isNullOrNil(getText())) && (this.IfT != null) && (this.IfT.isEnabled()) && (this.IfT.isClickable()) && (this.IfT.isFocusable()) && (this.IfT.isFocused()))
    {
      this.uZd.setToClearState(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73144);
          WalletFormView.this.dga();
          AppMethodBeat.o(73144);
        }
      });
      AppMethodBeat.o(73160);
      return;
    }
    if (this.uZd != null)
    {
      this.uZd.eBb();
      AppMethodBeat.o(73160);
      return;
    }
    ad.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(73160);
  }
  
  private Rect eg(View paramView)
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
  
  private void fkG()
  {
    AppMethodBeat.i(73174);
    if (getTitleTv() != null)
    {
      getTitleTv().setText(this.uZl);
      getTitleTv().setVisibility(this.uZm);
      setTitleWidth(this.Gfn);
    }
    AppMethodBeat.o(73174);
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
  
  public final void a(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(73182);
    if (this.IfT != null) {
      this.IfT.addTextChangedListener(paramTextWatcher);
    }
    AppMethodBeat.o(73182);
  }
  
  public final boolean aKX()
  {
    AppMethodBeat.i(73189);
    if (this.IfT != null)
    {
      int i = this.IfT.getInputLength();
      if ((i > this.uZx) || (i < this.uZy))
      {
        AppMethodBeat.o(73189);
        return false;
      }
      if (this.IfX != null)
      {
        boolean bool = this.IfX.a(this);
        AppMethodBeat.o(73189);
        return bool;
      }
      AppMethodBeat.o(73189);
      return true;
    }
    ad.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
    AppMethodBeat.o(73189);
    return true;
  }
  
  public final void d(WalletBaseUI paramWalletBaseUI)
  {
    AppMethodBeat.i(73196);
    if (this.IfT != null)
    {
      this.IfT.setFocusable(true);
      this.IfT.requestFocus();
      paramWalletBaseUI.showTenpayKB();
    }
    AppMethodBeat.o(73196);
  }
  
  public final void dfZ()
  {
    AppMethodBeat.i(73191);
    if (this.IfT != null) {
      this.IfT.clearFocus();
    }
    AppMethodBeat.o(73191);
  }
  
  public final void dga()
  {
    AppMethodBeat.i(73190);
    if (this.IfT != null) {
      this.IfT.ClearInput();
    }
    AppMethodBeat.o(73190);
  }
  
  public final boolean fkF()
  {
    AppMethodBeat.i(73161);
    if (this.IfT != null)
    {
      boolean bool = this.IfT.isFocusable();
      AppMethodBeat.o(73161);
      return bool;
    }
    AppMethodBeat.o(73161);
    return false;
  }
  
  public final void fkH()
  {
    AppMethodBeat.i(73183);
    if (this.IfT != null) {
      this.IfT.addTextChangedListener(new TextWatcher()
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
          if ((this.Igj >= 0) && (k >= 0) && (m - k > this.Igj))
          {
            paramAnonymousEditable = WalletFormView.aS(str, this.Igj + k + 1, m);
            i = 1;
          }
          for (;;)
          {
            int j = i;
            Object localObject = paramAnonymousEditable;
            int n;
            if (this.Igk >= 0)
            {
              n = WalletFormView.j(WalletFormView.this).getSelectionStart();
              if (k <= this.Igk) {
                break label236;
              }
              j = i;
              localObject = paramAnonymousEditable;
              if (!bt.iY(n, -1))
              {
                j = i;
                localObject = paramAnonymousEditable;
                if (k - this.Igk > 0)
                {
                  j = i;
                  localObject = paramAnonymousEditable;
                  if (n - (k - this.Igk) >= 0)
                  {
                    localObject = WalletFormView.aS(paramAnonymousEditable, n - (k - 7), n);
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
              if (bt.iY(k, -1))
              {
                j = i;
                localObject = paramAnonymousEditable;
                if (m > this.Igk)
                {
                  j = i;
                  localObject = paramAnonymousEditable;
                  if (n >= 0)
                  {
                    j = i;
                    localObject = paramAnonymousEditable;
                    if (n - (m - this.Igk) >= 0)
                    {
                      localObject = WalletFormView.aS(paramAnonymousEditable, n - (m - this.Igk), n);
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
  
  public final void fkI()
  {
    AppMethodBeat.i(73195);
    if (this.IfT != null)
    {
      this.IfT.setFocusable(true);
      this.IfT.requestFocus();
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.IfT, 0);
    }
    AppMethodBeat.o(73195);
  }
  
  public final boolean gF(View paramView)
  {
    AppMethodBeat.i(73192);
    if (getVisibility() == 0)
    {
      if (bt.isNullOrNil(getText()))
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.kEu != null) {
          this.kEu.setEnabled(true);
        }
        AppMethodBeat.o(73192);
        return false;
      }
      if (aKX())
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.kEu != null) {
          this.kEu.setEnabled(true);
        }
        AppMethodBeat.o(73192);
        return true;
      }
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      if (this.kEu != null) {
        this.kEu.setEnabled(false);
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
    return this.IfT;
  }
  
  public final int getEncrptType()
  {
    return this.IfZ;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.a getEventDelegate()
  {
    return this.IfW;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.uZd;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(73194);
    if (this.IfT != null)
    {
      int i = this.IfT.getInputLength();
      AppMethodBeat.o(73194);
      return i;
    }
    AppMethodBeat.o(73194);
    return 0;
  }
  
  public final a getInputValidChangeListener()
  {
    return this.IfV;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(73177);
    if (this.IfT != null)
    {
      KeyListener localKeyListener = this.IfT.getKeyListener();
      AppMethodBeat.o(73177);
      return localKeyListener;
    }
    ad.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(73177);
    return null;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.b getLogicDelegate()
  {
    return this.IfX;
  }
  
  public final String getMD5Value()
  {
    AppMethodBeat.i(73152);
    String str2 = bt.nullAsNil(this.IfT.getText().toString());
    String str1 = str2;
    if (this.IfX != null)
    {
      str1 = str2;
      if (this.IfX.dfX()) {
        str1 = this.IfX.c(this, str2);
      }
    }
    str1 = ai.du(str1);
    AppMethodBeat.o(73152);
    return str1;
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
  
  public final int getSelectionStart()
  {
    AppMethodBeat.i(73157);
    if (this.IfT != null)
    {
      int i = this.IfT.getSelectionStart();
      AppMethodBeat.o(73157);
      return i;
    }
    AppMethodBeat.o(73157);
    return -1;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(73176);
    if (this.IfT != null)
    {
      String str = c.a.a(this.IfZ, this.IfT);
      if ((this.IfX != null) && (this.IfX.dfX()))
      {
        str = this.IfX.c(this, str);
        AppMethodBeat.o(73176);
        return str;
      }
      AppMethodBeat.o(73176);
      return str;
    }
    ad.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
    AppMethodBeat.o(73176);
    return "";
  }
  
  public final TextView getTipsTv()
  {
    return this.uZe;
  }
  
  public final float getTitleMeasuredWidth()
  {
    AppMethodBeat.i(182538);
    float f = this.kEu.getPaint().measureText(this.kEu.getText(), 0, this.kEu.getText().length());
    AppMethodBeat.o(182538);
    return f;
  }
  
  public final TextView getTitleTv()
  {
    return this.kEu;
  }
  
  public final boolean isPhoneNum()
  {
    AppMethodBeat.i(73181);
    if (this.IfT == null)
    {
      AppMethodBeat.o(73181);
      return false;
    }
    boolean bool = this.IfT.isPhoneNum();
    AppMethodBeat.o(73181);
    return bool;
  }
  
  public final int m(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73149);
    if (this.Igh == 0)
    {
      int i = this.kEu.getLeft();
      this.Igh = (this.IfT.getLeft() - i + this.IfT.getPaddingLeft());
      ad.d("MicroMsg.WalletFormView", "mMaxUnitLeftOriginWidth:%s", new Object[] { Integer.valueOf(this.Igh) });
    }
    if (!bt.kU(paramCharSequence.toString(), ""))
    {
      if (paramInt2 == 1) {}
      for (float f1 = this.IfT.getPaint().measureText("1");; f1 = this.IfT.getPaint().measureText("2"))
      {
        float f2 = this.Igh;
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
    fkG();
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.uZn);
      getPrefilledTv().setVisibility(this.uZo);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.uZp);
      getInfoIv().setVisibility(this.uZq);
      if (this.Iga != -1) {
        getInfoIv().setmUserSetImageIconColor(this.Iga);
      }
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.uZr);
      getTipsTv().setVisibility(this.uZs);
    }
    Object localObject = getContext();
    String str;
    if (this.IfT != null) {
      if (this.Igf >= 0) {
        str = e.abw(this.Igf);
      }
    }
    try
    {
      this.IfT.setTypeface(Typeface.createFromAsset(((Context)localObject).getAssets(), str));
      if (this.Igb == -1)
      {
        this.IfT.setHint(this.uZt);
        this.IfT.setGravity(this.uZu);
        this.IfT.setTextColor(this.uZv);
        setText(this.uZw);
        b.a(this.IfT, this.Igc);
        this.IfT.setBackgroundResource(this.uZz);
        this.IfT.setEnabled(this.uZA);
        this.IfT.setFocusable(this.uZC);
        this.IfT.setClickable(this.uZB);
        this.IfT.setHintTextColor(this.uZF);
        setImeOptions(this.uZE);
        setInputType(this.uZD);
        this.IfT.addTextChangedListener(new TextWatcher()
        {
          private boolean uZH = false;
          
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(73143);
            String str = paramAnonymousEditable.toString();
            if (str.startsWith(".")) {
              paramAnonymousEditable.insert(0, "0");
            }
            while ((!WalletFormView.i(WalletFormView.this)) || (!WalletFormView.a(str, WalletFormView.j(WalletFormView.this))))
            {
              boolean bool = WalletFormView.this.aKX();
              if (WalletFormView.k(WalletFormView.this) != null)
              {
                if (bool != this.uZH)
                {
                  WalletFormView.k(WalletFormView.this).onInputValidChange(bool);
                  this.uZH = WalletFormView.this.aKX();
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
        this.IfT.setOnFocusChangeListener(this);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (!bt.iY(this.Igg, 0))
          {
            localObject = TextView.class.getDeclaredField("mCursorDrawableRes");
            ((Field)localObject).setAccessible(true);
            ((Field)localObject).set(this.IfT, Integer.valueOf(this.Igg));
          }
          dfY();
          if (this.IfT != null)
          {
            if (this.uZD != 2) {
              break;
            }
            this.IfT.setKeyListener(new NumberKeyListener()
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
            if (this.uZx != -1) {
              this.IfT.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.uZx) });
            }
          }
          AppMethodBeat.o(73164);
          return;
          localException1 = localException1;
          ad.e("MicroMsg.WalletFormView", "setTypeface() Exception:%s %s", new Object[] { localException1.getClass().getSimpleName(), localException1.getMessage() });
        }
        SpannableString localSpannableString = new SpannableString(this.uZt + "  ");
        localSpannableString.setSpan(new com.tencent.mm.ch.a(this.Igb), 0, localSpannableString.length() - 2, 33);
        localSpannableString.setSpan(new AbsoluteSizeSpan((int)this.IfT.getTextSize(), false), localSpannableString.length() - 2, localSpannableString.length(), 33);
        this.IfT.setHint(new SpannedString(localSpannableString));
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.e("MicroMsg.WalletFormView", "set textCursorDrawable fail!!");
          continue;
          if (this.uZD == 4)
          {
            this.IfT.setKeyListener(new NumberKeyListener()
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
            this.IfT.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.IfT.setKeyListener(new NumberKeyListener()
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
            this.IfT.setRawInputType(18);
          }
          else if (this.uZD == 3)
          {
            this.IfT.setKeyListener(new NumberKeyListener()
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
            this.IfT.setInputType(this.uZD);
          }
        }
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(73198);
    if (this.uZg != null) {
      this.uZg.onFocusChange(this, paramBoolean);
    }
    if (this.IfV != null) {
      this.IfV.onInputValidChange(aKX());
    }
    if (!aKX()) {
      if (this.kEu != null) {
        this.kEu.setEnabled(false);
      }
    }
    for (;;)
    {
      dfY();
      AppMethodBeat.o(73198);
      return;
      if (this.kEu != null) {
        this.kEu.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(73171);
    if ((this.IfW == null) || (!this.IfW.fkK()))
    {
      if ((this.IfT != null) && (b(this.IfT, paramMotionEvent)) && (!this.IfT.isClickable()))
      {
        ad.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(73171);
        return true;
      }
      if ((this.uZd != null) && (this.uZd.isClickable()) && (b(this.uZd, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        ad.d("MicroMsg.WalletFormView", "hy: click on info iv");
        dfY();
        this.uZd.performClick();
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
    if ((this.IfW == null) || (!this.IfW.fkJ())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(73170);
  }
  
  public final void set3DesToView(String paramString)
  {
    AppMethodBeat.i(73199);
    if (this.IfT != null) {
      this.IfT.set3DesEncrptData(paramString);
    }
    AppMethodBeat.o(73199);
  }
  
  public final void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(73151);
    if ((this.IfT != null) && ((this.IfX == null) || (!this.IfX.b(this, paramString))))
    {
      this.IfT.set3DesEncrptData(paramString);
      setSelection(getInputLength());
    }
    AppMethodBeat.o(73151);
  }
  
  public final void setBankcardTail(String paramString)
  {
    AppMethodBeat.i(73178);
    if (this.IfT != null) {
      this.IfT.setBankcardTailNum(paramString);
    }
    AppMethodBeat.o(73178);
  }
  
  public final void setContentClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(73166);
    if (this.IfT != null) {
      this.IfT.setClickable(paramBoolean);
    }
    AppMethodBeat.o(73166);
  }
  
  public final void setContentEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(73168);
    if (this.IfT != null) {
      this.IfT.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(73168);
  }
  
  public final void setContentFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(73167);
    if (this.IfT != null) {
      this.IfT.setFocusable(paramBoolean);
    }
    AppMethodBeat.o(73167);
  }
  
  public final void setContentPadding$3b4dfe4b(int paramInt)
  {
    AppMethodBeat.i(163889);
    if (this.IfT != null) {
      this.IfT.setPadding(paramInt, 0, 0, 0);
    }
    AppMethodBeat.o(163889);
  }
  
  public final void setContentTextColor(int paramInt)
  {
    AppMethodBeat.i(73159);
    if (this.IfT != null) {
      this.IfT.setTextColor(paramInt);
    }
    AppMethodBeat.o(73159);
  }
  
  @SuppressLint({"ResourceType"})
  public final void setContentTextColorRes(int paramInt)
  {
    AppMethodBeat.i(73158);
    this.uZv = paramInt;
    if (this.IfT != null) {
      this.IfT.setTextColor(getResources().getColor(this.uZv));
    }
    AppMethodBeat.o(73158);
  }
  
  public final void setEncryptType(int paramInt)
  {
    this.IfZ = paramInt;
  }
  
  public final void setEventDelegate(com.tencent.mm.wallet_core.ui.formview.a.a parama)
  {
    this.IfW = parama;
  }
  
  public final void setFilterChar(char[] paramArrayOfChar) {}
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(73193);
    if (this.IfT != null) {
      this.IfT.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(73193);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(73165);
    if (this.IfT != null)
    {
      if (this.Igb == -1)
      {
        this.IfT.setHint(paramCharSequence);
        AppMethodBeat.o(73165);
        return;
      }
      paramCharSequence = new SpannableString(paramCharSequence);
      paramCharSequence.setSpan(new AbsoluteSizeSpan(this.Igb, false), 0, paramCharSequence.length(), 33);
      this.IfT.setHint(new SpannedString(paramCharSequence));
    }
    AppMethodBeat.o(73165);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(73153);
    if (this.IfT != null) {
      this.IfT.setImeOptions(paramInt);
    }
    AppMethodBeat.o(73153);
  }
  
  public final void setInputEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(73156);
    if (this.IfT != null) {
      this.IfT.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(73156);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(73154);
    if (this.IfT != null) {
      this.IfT.setInputType(paramInt);
    }
    AppMethodBeat.o(73154);
  }
  
  public final void setIsSecretAnswer(boolean paramBoolean)
  {
    AppMethodBeat.i(73197);
    if (this.IfT != null) {
      this.IfT.setIsSecurityAnswerFormat(paramBoolean);
    }
    AppMethodBeat.o(73197);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(73188);
    if (this.IfT != null) {
      this.IfT.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(73188);
  }
  
  public final void setLogicDelegate(com.tencent.mm.wallet_core.ui.formview.a.b paramb)
  {
    this.IfX = paramb;
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
    AppMethodBeat.i(73179);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(73179);
  }
  
  public final void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(73169);
    this.IfT.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(73169);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.uZg = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(73180);
    this.uZh = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.uZh);
    }
    AppMethodBeat.o(73180);
  }
  
  public final void setOnInputValidChangeListener(a parama)
  {
    this.IfV = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(73175);
    if (this.IfT != null) {
      this.IfT.setSelection(paramInt);
    }
    AppMethodBeat.o(73175);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(73155);
    if ((this.IfT != null) && ((this.IfX == null) || (!this.IfX.a(this, paramString))))
    {
      this.IfT.setText(paramString);
      this.IfT.setSelection(getInputLength());
    }
    AppMethodBeat.o(73155);
  }
  
  public final void setTitleText(String paramString)
  {
    AppMethodBeat.i(73148);
    this.uZl = paramString;
    fkG();
    AppMethodBeat.o(73148);
  }
  
  public final void setTitleWidth(int paramInt)
  {
    AppMethodBeat.i(182539);
    this.Gfn = paramInt;
    if (this.Gfn > 0)
    {
      ViewGroup.LayoutParams localLayoutParams = this.kEu.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = this.Gfn;
        this.kEu.setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(182539);
  }
  
  public final void setmContentAbnormalMoneyCheck(boolean paramBoolean)
  {
    this.Igd = paramBoolean;
  }
  
  public final void setmWalletFormViewListener(c paramc)
  {
    this.IfS = paramc;
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