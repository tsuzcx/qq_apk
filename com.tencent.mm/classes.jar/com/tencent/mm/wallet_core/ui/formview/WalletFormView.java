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
  private int JsT;
  private a LAA;
  private com.tencent.mm.wallet_core.ui.formview.a.a LAB;
  private com.tencent.mm.wallet_core.ui.formview.a.b LAC;
  private int LAD;
  private int LAE;
  private int LAF;
  private int LAG;
  private int LAH;
  private boolean LAI;
  @Deprecated
  private int LAJ;
  private int LAK;
  private int LAL;
  private int LAM;
  private c LAx;
  public TenpaySecureEditText LAy;
  private LinearLayout LAz;
  private TextView lCL;
  private String uZe;
  private TextView xWU;
  private WalletIconImageView xpB;
  private TextView xpC;
  private View.OnFocusChangeListener xpE;
  private View.OnClickListener xpF;
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
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73147);
    this.lCL = null;
    this.xpz = null;
    this.LAy = null;
    this.xpB = null;
    this.xpC = null;
    this.LAA = null;
    this.xpE = null;
    this.xpF = null;
    this.LAB = null;
    this.LAC = null;
    this.xpI = -1;
    this.LAD = this.xpI;
    this.LAE = 100;
    this.uZe = "";
    this.xpJ = 0;
    this.xpK = "";
    this.xpL = 8;
    this.xpM = -1;
    this.LAF = -1;
    this.xpN = 4;
    this.xpO = "";
    this.xpP = 8;
    this.xpQ = "";
    this.LAG = -1;
    this.xpR = 19;
    this.xpS = 2131100711;
    this.xpT = "";
    this.LAH = 0;
    this.xpU = 2147483647;
    this.xpV = 1;
    this.xpW = 2131233299;
    this.xpX = true;
    this.xpY = false;
    this.xpZ = true;
    this.LAI = false;
    this.xqa = 1;
    this.xqb = 5;
    this.xqc = 2131100551;
    this.LAJ = 0;
    this.LAK = 0;
    this.LAL = 0;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WalletFormAttrs, paramInt, 0);
    this.xpI = paramAttributeSet.getResourceId(23, this.xpI);
    paramInt = paramAttributeSet.getResourceId(30, 0);
    if (paramInt != 0) {
      this.uZe = paramContext.getString(paramInt);
    }
    this.JsT = paramAttributeSet.getDimensionPixelSize(32, -1);
    this.xpM = paramAttributeSet.getResourceId(20, this.xpM);
    this.LAF = paramAttributeSet.getColor(19, this.LAF);
    paramInt = paramAttributeSet.getResourceId(28, 0);
    if (paramInt != 0) {
      this.xpO = paramContext.getString(paramInt);
    }
    this.xpN = paramAttributeSet.getInteger(21, this.xpN);
    this.xpJ = paramAttributeSet.getInteger(31, this.xpJ);
    this.xpP = paramAttributeSet.getInteger(29, this.xpP);
    this.xpL = paramAttributeSet.getInteger(27, this.xpL);
    paramInt = paramAttributeSet.getResourceId(25, 0);
    if (paramInt != 0) {
      this.xpK = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(11, 0);
    if (paramInt != 0) {
      this.xpQ = paramContext.getString(paramInt);
    }
    this.LAG = paramAttributeSet.getDimensionPixelSize(12, -1);
    this.xpR = paramAttributeSet.getInteger(10, this.xpR);
    this.xpS = paramAttributeSet.getColor(17, this.xpS);
    paramInt = paramAttributeSet.getResourceId(16, 0);
    if (paramInt != 0) {
      this.xpT = paramContext.getString(paramInt);
    }
    this.LAH = paramAttributeSet.getInt(9, this.LAH);
    this.xpU = paramAttributeSet.getInteger(14, this.xpU);
    this.xpV = paramAttributeSet.getInteger(15, this.xpV);
    this.xpW = paramAttributeSet.getResourceId(5, this.xpW);
    this.xpX = paramAttributeSet.getBoolean(7, this.xpX);
    this.xpY = paramAttributeSet.getBoolean(6, this.xpY);
    this.xpZ = paramAttributeSet.getBoolean(7, this.xpZ);
    this.xqa = paramAttributeSet.getInteger(0, this.xqa);
    this.xqb = paramAttributeSet.getInteger(1, this.xqb);
    this.LAE = paramAttributeSet.getInteger(18, this.LAE);
    this.xqc = paramAttributeSet.getInteger(13, this.xqc);
    this.LAD = paramAttributeSet.getResourceId(24, this.LAD);
    this.LAJ = paramAttributeSet.getInteger(33, 0);
    this.LAK = paramAttributeSet.getInteger(34, -1);
    if ((this.LAJ == 1) && (this.LAK == -1)) {
      this.LAK = 4;
    }
    this.LAL = paramAttributeSet.getResourceId(2, 0);
    paramAttributeSet.recycle();
    if (this.xpI > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    if ((!bt.isNullOrNil(this.uZe)) && (this.uZe.length() > 6)) {
      inflate(paramContext, this.LAD, this);
    }
    for (;;)
    {
      this.lCL = ((TextView)findViewById(2131306836));
      this.xpz = ((TextView)findViewById(2131306818));
      this.LAy = ((TenpaySecureEditText)findViewById(2131306718));
      this.xpB = ((WalletIconImageView)findViewById(2131306746));
      this.xpC = ((TextView)findViewById(2131306835));
      this.LAz = ((LinearLayout)findViewById(2131306753));
      this.xWU = ((TextView)findViewById(2131306756));
      AppMethodBeat.o(73147);
      return;
      inflate(paramContext, this.xpI, this);
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
    a(paramEditText, paramString, aZ(paramString, paramInt1, paramInt2));
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
    if (bt.lQ(paramString1, paramString2))
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
    int i = 0;
    int j = -1;
    while ((i < paramString.length()) && ('0' == paramString.charAt(i)))
    {
      j = i;
      i += 1;
    }
    if ((j == 0) && (paramString.length() > 1) && (paramString.charAt(j + 1) != '.'))
    {
      a(paramEditText, paramString, 0, j + 1);
      AppMethodBeat.o(73186);
      return true;
    }
    if (j > 0)
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
    AppMethodBeat.o(73186);
    return false;
  }
  
  public static String aZ(String paramString, int paramInt1, int paramInt2)
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
    paramString = bt.bI(str, "") + bt.bI(paramString, "");
    AppMethodBeat.o(73184);
    return paramString;
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(73172);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (eB(paramView).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
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
  
  private void dEc()
  {
    AppMethodBeat.i(73160);
    if ((this.xpB != null) && (!bt.isNullOrNil(getText())) && (this.LAy != null) && (this.LAy.isEnabled()) && (this.LAy.isClickable()) && (this.LAy.isFocusable()) && (this.LAy.isFocused()))
    {
      this.xpB.setToClearState(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73144);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/formview/WalletFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          WalletFormView.this.dEe();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/formview/WalletFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(73144);
        }
      });
      AppMethodBeat.o(73160);
      return;
    }
    if (this.xpB != null)
    {
      this.xpB.ffz();
      AppMethodBeat.o(73160);
      return;
    }
    ad.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(73160);
  }
  
  private Rect eB(View paramView)
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
  
  private void fSg()
  {
    AppMethodBeat.i(73174);
    if (getTitleTv() != null)
    {
      getTitleTv().setText(this.uZe);
      getTitleTv().setVisibility(this.xpJ);
      setTitleWidth(this.JsT);
    }
    AppMethodBeat.o(73174);
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
  
  public final void a(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(73182);
    if (this.LAy != null) {
      this.LAy.addTextChangedListener(paramTextWatcher);
    }
    AppMethodBeat.o(73182);
  }
  
  public final boolean aVa()
  {
    AppMethodBeat.i(73189);
    if (this.LAy != null)
    {
      int i = this.LAy.getInputLength();
      if ((i > this.xpU) || (i < this.xpV))
      {
        AppMethodBeat.o(73189);
        return false;
      }
      if (this.LAC != null)
      {
        boolean bool = this.LAC.a(this);
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
    if (this.LAy != null)
    {
      this.LAy.setFocusable(true);
      this.LAy.requestFocus();
      paramWalletBaseUI.showTenpayKB();
    }
    AppMethodBeat.o(73196);
  }
  
  public final void dEd()
  {
    AppMethodBeat.i(73191);
    if (this.LAy != null) {
      this.LAy.clearFocus();
    }
    AppMethodBeat.o(73191);
  }
  
  public final void dEe()
  {
    AppMethodBeat.i(73190);
    if (this.LAy != null) {
      this.LAy.ClearInput();
    }
    AppMethodBeat.o(73190);
  }
  
  public final boolean fSf()
  {
    AppMethodBeat.i(73161);
    if (this.LAy != null)
    {
      boolean bool = this.LAy.isFocusable();
      AppMethodBeat.o(73161);
      return bool;
    }
    AppMethodBeat.o(73161);
    return false;
  }
  
  public final void fSh()
  {
    AppMethodBeat.i(73183);
    if (this.LAy != null) {
      this.LAy.addTextChangedListener(new TextWatcher()
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
          if ((this.LAO >= 0) && (k >= 0) && (m - k > this.LAO))
          {
            paramAnonymousEditable = WalletFormView.aZ(str, this.LAO + k + 1, m);
            i = 1;
          }
          for (;;)
          {
            int j = i;
            Object localObject = paramAnonymousEditable;
            int n;
            if (this.LAP >= 0)
            {
              n = WalletFormView.j(WalletFormView.this).getSelectionStart();
              if (k <= this.LAP) {
                break label236;
              }
              j = i;
              localObject = paramAnonymousEditable;
              if (!bt.jx(n, -1))
              {
                j = i;
                localObject = paramAnonymousEditable;
                if (k - this.LAP > 0)
                {
                  j = i;
                  localObject = paramAnonymousEditable;
                  if (n - (k - this.LAP) >= 0)
                  {
                    localObject = WalletFormView.aZ(paramAnonymousEditable, n - (k - 7), n);
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
              if (bt.jx(k, -1))
              {
                j = i;
                localObject = paramAnonymousEditable;
                if (m > this.LAP)
                {
                  j = i;
                  localObject = paramAnonymousEditable;
                  if (n >= 0)
                  {
                    j = i;
                    localObject = paramAnonymousEditable;
                    if (n - (m - this.LAP) >= 0)
                    {
                      localObject = WalletFormView.aZ(paramAnonymousEditable, n - (m - this.LAP), n);
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
  
  public final void fSi()
  {
    AppMethodBeat.i(73195);
    if (this.LAy != null)
    {
      this.LAy.setFocusable(true);
      this.LAy.requestFocus();
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.LAy, 0);
    }
    AppMethodBeat.o(73195);
  }
  
  public final EditText getContentEt()
  {
    return this.LAy;
  }
  
  public final int getEncrptType()
  {
    return this.LAE;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.a getEventDelegate()
  {
    return this.LAB;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.xpB;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(73194);
    if (this.LAy != null)
    {
      int i = this.LAy.getInputLength();
      AppMethodBeat.o(73194);
      return i;
    }
    AppMethodBeat.o(73194);
    return 0;
  }
  
  public final a getInputValidChangeListener()
  {
    return this.LAA;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(73177);
    if (this.LAy != null)
    {
      KeyListener localKeyListener = this.LAy.getKeyListener();
      AppMethodBeat.o(73177);
      return localKeyListener;
    }
    ad.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(73177);
    return null;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.b getLogicDelegate()
  {
    return this.LAC;
  }
  
  public final String getMD5Value()
  {
    AppMethodBeat.i(73152);
    String str2 = bt.nullAsNil(this.LAy.getText().toString());
    String str1 = str2;
    if (this.LAC != null)
    {
      str1 = str2;
      if (this.LAC.dEb()) {
        str1 = this.LAC.c(this, str2);
      }
    }
    str1 = ai.ee(str1);
    AppMethodBeat.o(73152);
    return str1;
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
  
  public final int getSelectionStart()
  {
    AppMethodBeat.i(73157);
    if (this.LAy != null)
    {
      int i = this.LAy.getSelectionStart();
      AppMethodBeat.o(73157);
      return i;
    }
    AppMethodBeat.o(73157);
    return -1;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(73176);
    if (this.LAy != null)
    {
      String str = c.a.a(this.LAE, this.LAy);
      if ((this.LAC != null) && (this.LAC.dEb()))
      {
        str = this.LAC.c(this, str);
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
    return this.xpC;
  }
  
  public final float getTitleMeasuredWidth()
  {
    AppMethodBeat.i(182538);
    float f = this.lCL.getPaint().measureText(this.lCL.getText(), 0, this.lCL.getText().length());
    AppMethodBeat.o(182538);
    return f;
  }
  
  public final TextView getTitleTv()
  {
    return this.lCL;
  }
  
  public final boolean ho(View paramView)
  {
    AppMethodBeat.i(73192);
    if (getVisibility() == 0)
    {
      if (bt.isNullOrNil(getText()))
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.lCL != null) {
          this.lCL.setEnabled(true);
        }
        AppMethodBeat.o(73192);
        return false;
      }
      if (aVa())
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.lCL != null) {
          this.lCL.setEnabled(true);
        }
        AppMethodBeat.o(73192);
        return true;
      }
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      if (this.lCL != null) {
        this.lCL.setEnabled(false);
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
  
  public final boolean isPhoneNum()
  {
    AppMethodBeat.i(73181);
    if (this.LAy == null)
    {
      AppMethodBeat.o(73181);
      return false;
    }
    boolean bool = this.LAy.isPhoneNum();
    AppMethodBeat.o(73181);
    return bool;
  }
  
  public final int j(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73149);
    if (this.LAM == 0)
    {
      int i = this.lCL.getLeft();
      this.LAM = (this.LAy.getLeft() - i + this.LAy.getPaddingLeft());
      ad.d("MicroMsg.WalletFormView", "mMaxUnitLeftOriginWidth:%s", new Object[] { Integer.valueOf(this.LAM) });
    }
    if (!bt.lQ(paramCharSequence.toString(), ""))
    {
      if (paramInt2 == 1) {}
      for (float f1 = this.LAy.getPaint().measureText("1");; f1 = this.LAy.getPaint().measureText("2"))
      {
        float f2 = this.LAM;
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
    fSg();
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.xpK);
      getPrefilledTv().setVisibility(this.xpL);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.xpM);
      getInfoIv().setVisibility(this.xpN);
      if (this.LAF != -1) {
        getInfoIv().setmUserSetImageIconColor(this.LAF);
      }
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.xpO);
      getTipsTv().setVisibility(this.xpP);
    }
    Object localObject = getContext();
    String str;
    if (this.LAy != null) {
      if (this.LAK >= 0) {
        str = e.agp(this.LAK);
      }
    }
    try
    {
      this.LAy.setTypeface(Typeface.createFromAsset(((Context)localObject).getAssets(), str));
      if (this.LAG == -1)
      {
        this.LAy.setHint(this.xpQ);
        this.LAy.setGravity(this.xpR);
        this.LAy.setTextColor(this.xpS);
        setText(this.xpT);
        b.a(this.LAy, this.LAH);
        this.LAy.setBackgroundResource(this.xpW);
        this.LAy.setEnabled(this.xpX);
        this.LAy.setFocusable(this.xpZ);
        this.LAy.setClickable(this.xpY);
        this.LAy.setHintTextColor(this.xqc);
        setImeOptions(this.xqb);
        setInputType(this.xqa);
        this.LAy.addTextChangedListener(new TextWatcher()
        {
          private boolean xqe = false;
          
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(73143);
            String str = paramAnonymousEditable.toString();
            if (str.startsWith(".")) {
              paramAnonymousEditable.insert(0, "0");
            }
            while ((!WalletFormView.i(WalletFormView.this)) || (!WalletFormView.a(str, WalletFormView.j(WalletFormView.this))))
            {
              boolean bool = WalletFormView.this.aVa();
              if (WalletFormView.k(WalletFormView.this) != null)
              {
                if (bool != this.xqe)
                {
                  WalletFormView.k(WalletFormView.this).onInputValidChange(bool);
                  this.xqe = WalletFormView.this.aVa();
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
        this.LAy.setOnFocusChangeListener(this);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (!bt.jx(this.LAL, 0))
          {
            localObject = TextView.class.getDeclaredField("mCursorDrawableRes");
            ((Field)localObject).setAccessible(true);
            ((Field)localObject).set(this.LAy, Integer.valueOf(this.LAL));
          }
          dEc();
          if (this.LAy != null)
          {
            if (this.xqa != 2) {
              break;
            }
            this.LAy.setKeyListener(new NumberKeyListener()
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
            if (this.xpU != -1) {
              this.LAy.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.xpU) });
            }
          }
          AppMethodBeat.o(73164);
          return;
          localException1 = localException1;
          ad.e("MicroMsg.WalletFormView", "setTypeface() Exception:%s %s", new Object[] { localException1.getClass().getSimpleName(), localException1.getMessage() });
        }
        SpannableString localSpannableString = new SpannableString(this.xpQ + "  ");
        localSpannableString.setSpan(new com.tencent.mm.cg.a(this.LAG), 0, localSpannableString.length() - 2, 33);
        localSpannableString.setSpan(new AbsoluteSizeSpan((int)this.LAy.getTextSize(), false), localSpannableString.length() - 2, localSpannableString.length(), 33);
        this.LAy.setHint(new SpannedString(localSpannableString));
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.e("MicroMsg.WalletFormView", "set textCursorDrawable fail!!");
          continue;
          if (this.xqa == 4)
          {
            this.LAy.setKeyListener(new NumberKeyListener()
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
            this.LAy.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.LAy.setKeyListener(new NumberKeyListener()
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
            this.LAy.setRawInputType(18);
          }
          else if (this.xqa == 3)
          {
            this.LAy.setKeyListener(new NumberKeyListener()
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
            this.LAy.setInputType(this.xqa);
          }
        }
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(73198);
    if (this.xpE != null) {
      this.xpE.onFocusChange(this, paramBoolean);
    }
    if (this.LAA != null) {
      this.LAA.onInputValidChange(aVa());
    }
    if (!aVa()) {
      if (this.lCL != null) {
        this.lCL.setEnabled(false);
      }
    }
    for (;;)
    {
      dEc();
      AppMethodBeat.o(73198);
      return;
      if (this.lCL != null) {
        this.lCL.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(73171);
    if ((this.LAB == null) || (!this.LAB.fSk()))
    {
      if ((this.LAy != null) && (b(this.LAy, paramMotionEvent)) && (!this.LAy.isClickable()))
      {
        ad.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(73171);
        return true;
      }
      if ((this.xpB != null) && (this.xpB.isClickable()) && (b(this.xpB, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        ad.d("MicroMsg.WalletFormView", "hy: click on info iv");
        dEc();
        this.xpB.performClick();
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
    if ((this.LAB == null) || (!this.LAB.fSj())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(73170);
  }
  
  public final void set3DesToView(String paramString)
  {
    AppMethodBeat.i(73199);
    if (this.LAy != null) {
      this.LAy.set3DesEncrptData(paramString);
    }
    AppMethodBeat.o(73199);
  }
  
  public final void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(73151);
    if ((this.LAy != null) && ((this.LAC == null) || (!this.LAC.b(this, paramString))))
    {
      this.LAy.set3DesEncrptData(paramString);
      setSelection(getInputLength());
    }
    AppMethodBeat.o(73151);
  }
  
  public final void setBankcardTail(String paramString)
  {
    AppMethodBeat.i(73178);
    if (this.LAy != null) {
      this.LAy.setBankcardTailNum(paramString);
    }
    AppMethodBeat.o(73178);
  }
  
  public final void setContentClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(73166);
    if (this.LAy != null) {
      this.LAy.setClickable(paramBoolean);
    }
    AppMethodBeat.o(73166);
  }
  
  public final void setContentEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(73168);
    if (this.LAy != null) {
      this.LAy.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(73168);
  }
  
  public final void setContentFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(73167);
    if (this.LAy != null) {
      this.LAy.setFocusable(paramBoolean);
    }
    AppMethodBeat.o(73167);
  }
  
  public final void setContentPadding$3b4dfe4b(int paramInt)
  {
    AppMethodBeat.i(163889);
    if (this.LAy != null) {
      this.LAy.setPadding(paramInt, 0, 0, 0);
    }
    AppMethodBeat.o(163889);
  }
  
  public final void setContentTextColor(int paramInt)
  {
    AppMethodBeat.i(73159);
    if (this.LAy != null) {
      this.LAy.setTextColor(paramInt);
    }
    AppMethodBeat.o(73159);
  }
  
  @SuppressLint({"ResourceType"})
  public final void setContentTextColorRes(int paramInt)
  {
    AppMethodBeat.i(73158);
    this.xpS = paramInt;
    if (this.LAy != null) {
      this.LAy.setTextColor(getResources().getColor(this.xpS));
    }
    AppMethodBeat.o(73158);
  }
  
  public final void setEncryptType(int paramInt)
  {
    this.LAE = paramInt;
  }
  
  public final void setEventDelegate(com.tencent.mm.wallet_core.ui.formview.a.a parama)
  {
    this.LAB = parama;
  }
  
  public final void setFilterChar(char[] paramArrayOfChar) {}
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(73193);
    if (this.LAy != null) {
      this.LAy.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(73193);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(73165);
    if (this.LAy != null)
    {
      if (this.LAG == -1)
      {
        this.LAy.setHint(paramCharSequence);
        AppMethodBeat.o(73165);
        return;
      }
      paramCharSequence = new SpannableString(paramCharSequence);
      paramCharSequence.setSpan(new AbsoluteSizeSpan(this.LAG, false), 0, paramCharSequence.length(), 33);
      this.LAy.setHint(new SpannedString(paramCharSequence));
    }
    AppMethodBeat.o(73165);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(73153);
    if (this.LAy != null) {
      this.LAy.setImeOptions(paramInt);
    }
    AppMethodBeat.o(73153);
  }
  
  public final void setInputEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(73156);
    if (this.LAy != null) {
      this.LAy.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(73156);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(73154);
    if (this.LAy != null) {
      this.LAy.setInputType(paramInt);
    }
    AppMethodBeat.o(73154);
  }
  
  public final void setIsSecretAnswer(boolean paramBoolean)
  {
    AppMethodBeat.i(73197);
    if (this.LAy != null) {
      this.LAy.setIsSecurityAnswerFormat(paramBoolean);
    }
    AppMethodBeat.o(73197);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(73188);
    if (this.LAy != null) {
      this.LAy.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(73188);
  }
  
  public final void setLogicDelegate(com.tencent.mm.wallet_core.ui.formview.a.b paramb)
  {
    this.LAC = paramb;
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
    AppMethodBeat.i(73179);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(73179);
  }
  
  public final void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(73169);
    this.LAy.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(73169);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.xpE = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(73180);
    this.xpF = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.xpF);
    }
    AppMethodBeat.o(73180);
  }
  
  public final void setOnInputValidChangeListener(a parama)
  {
    this.LAA = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(73175);
    if (this.LAy != null) {
      this.LAy.setSelection(paramInt);
    }
    AppMethodBeat.o(73175);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(73155);
    if ((this.LAy != null) && ((this.LAC == null) || (!this.LAC.a(this, paramString))))
    {
      this.LAy.setText(paramString);
      this.LAy.setSelection(getInputLength());
    }
    AppMethodBeat.o(73155);
  }
  
  public final void setTitleText(String paramString)
  {
    AppMethodBeat.i(73148);
    this.uZe = paramString;
    fSg();
    AppMethodBeat.o(73148);
  }
  
  public final void setTitleWidth(int paramInt)
  {
    AppMethodBeat.i(182539);
    this.JsT = paramInt;
    if (this.JsT > 0)
    {
      ViewGroup.LayoutParams localLayoutParams = this.lCL.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = this.JsT;
        this.lCL.setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(182539);
  }
  
  public final void setmContentAbnormalMoneyCheck(boolean paramBoolean)
  {
    this.LAI = paramBoolean;
  }
  
  public final void setmWalletFormViewListener(c paramc)
  {
    this.LAx = paramc;
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