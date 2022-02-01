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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.lang.reflect.Field;
import junit.framework.Assert;

public final class WalletFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private int JNI;
  private int LXA;
  private int LXB;
  private int LXC;
  private c LXn;
  public TenpaySecureEditText LXo;
  private LinearLayout LXp;
  private a LXq;
  private com.tencent.mm.wallet_core.ui.formview.a.a LXr;
  private com.tencent.mm.wallet_core.ui.formview.a.b LXs;
  private int LXt;
  private int LXu;
  private int LXv;
  private int LXw;
  private int LXx;
  private boolean LXy;
  @Deprecated
  private int LXz;
  private TextView lHk;
  private String vli;
  private View.OnFocusChangeListener xFB;
  private View.OnClickListener xFC;
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
  private WalletIconImageView xFy;
  private TextView xFz;
  private TextView ymN;
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73147);
    this.lHk = null;
    this.xFw = null;
    this.LXo = null;
    this.xFy = null;
    this.xFz = null;
    this.LXq = null;
    this.xFB = null;
    this.xFC = null;
    this.LXr = null;
    this.LXs = null;
    this.xFF = -1;
    this.LXt = this.xFF;
    this.LXu = 100;
    this.vli = "";
    this.xFG = 0;
    this.xFH = "";
    this.xFI = 8;
    this.xFJ = -1;
    this.LXv = -1;
    this.xFK = 4;
    this.xFL = "";
    this.xFM = 8;
    this.xFN = "";
    this.LXw = -1;
    this.xFO = 19;
    this.xFP = 2131100711;
    this.xFQ = "";
    this.LXx = 0;
    this.xFR = 2147483647;
    this.xFS = 1;
    this.xFT = 2131233299;
    this.xFU = true;
    this.xFV = false;
    this.xFW = true;
    this.LXy = false;
    this.xFX = 1;
    this.xFY = 5;
    this.xFZ = 2131100551;
    this.LXz = 0;
    this.LXA = 0;
    this.LXB = 0;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WalletFormAttrs, paramInt, 0);
    this.xFF = paramAttributeSet.getResourceId(23, this.xFF);
    paramInt = paramAttributeSet.getResourceId(30, 0);
    if (paramInt != 0) {
      this.vli = paramContext.getString(paramInt);
    }
    this.JNI = paramAttributeSet.getDimensionPixelSize(32, -1);
    this.xFJ = paramAttributeSet.getResourceId(20, this.xFJ);
    this.LXv = paramAttributeSet.getColor(19, this.LXv);
    paramInt = paramAttributeSet.getResourceId(28, 0);
    if (paramInt != 0) {
      this.xFL = paramContext.getString(paramInt);
    }
    this.xFK = paramAttributeSet.getInteger(21, this.xFK);
    this.xFG = paramAttributeSet.getInteger(31, this.xFG);
    this.xFM = paramAttributeSet.getInteger(29, this.xFM);
    this.xFI = paramAttributeSet.getInteger(27, this.xFI);
    paramInt = paramAttributeSet.getResourceId(25, 0);
    if (paramInt != 0) {
      this.xFH = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(11, 0);
    if (paramInt != 0) {
      this.xFN = paramContext.getString(paramInt);
    }
    this.LXw = paramAttributeSet.getDimensionPixelSize(12, -1);
    this.xFO = paramAttributeSet.getInteger(10, this.xFO);
    this.xFP = paramAttributeSet.getColor(17, this.xFP);
    paramInt = paramAttributeSet.getResourceId(16, 0);
    if (paramInt != 0) {
      this.xFQ = paramContext.getString(paramInt);
    }
    this.LXx = paramAttributeSet.getInt(9, this.LXx);
    this.xFR = paramAttributeSet.getInteger(14, this.xFR);
    this.xFS = paramAttributeSet.getInteger(15, this.xFS);
    this.xFT = paramAttributeSet.getResourceId(5, this.xFT);
    this.xFU = paramAttributeSet.getBoolean(7, this.xFU);
    this.xFV = paramAttributeSet.getBoolean(6, this.xFV);
    this.xFW = paramAttributeSet.getBoolean(7, this.xFW);
    this.xFX = paramAttributeSet.getInteger(0, this.xFX);
    this.xFY = paramAttributeSet.getInteger(1, this.xFY);
    this.LXu = paramAttributeSet.getInteger(18, this.LXu);
    this.xFZ = paramAttributeSet.getInteger(13, this.xFZ);
    this.LXt = paramAttributeSet.getResourceId(24, this.LXt);
    this.LXz = paramAttributeSet.getInteger(33, 0);
    this.LXA = paramAttributeSet.getInteger(34, -1);
    if ((this.LXz == 1) && (this.LXA == -1)) {
      this.LXA = 4;
    }
    this.LXB = paramAttributeSet.getResourceId(2, 0);
    paramAttributeSet.recycle();
    if (this.xFF > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    if ((!bu.isNullOrNil(this.vli)) && (this.vli.length() > 6)) {
      inflate(paramContext, this.LXt, this);
    }
    for (;;)
    {
      this.lHk = ((TextView)findViewById(2131306836));
      this.xFw = ((TextView)findViewById(2131306818));
      this.LXo = ((TenpaySecureEditText)findViewById(2131306718));
      this.xFy = ((WalletIconImageView)findViewById(2131306746));
      this.xFz = ((TextView)findViewById(2131306835));
      this.LXp = ((LinearLayout)findViewById(2131306753));
      this.ymN = ((TextView)findViewById(2131306756));
      AppMethodBeat.o(73147);
      return;
      inflate(paramContext, this.xFF, this);
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
    a(paramEditText, paramString, bc(paramString, paramInt1, paramInt2));
    AppMethodBeat.o(73187);
  }
  
  public static void a(EditText paramEditText, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(73185);
    if (paramEditText == null)
    {
      AppMethodBeat.o(73185);
      return;
    }
    if (bu.lX(paramString1, paramString2))
    {
      AppMethodBeat.o(73185);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(73146);
        int j = this.val$editText.getSelectionStart();
        int k = this.val$editText.getSelectionEnd();
        if (bu.isNullOrNil(paramString2))
        {
          this.val$editText.setText("");
          AppMethodBeat.o(73146);
          return;
        }
        this.val$editText.setText(paramString2);
        EditText localEditText = this.val$editText;
        int i = j;
        if (j > paramString2.length()) {
          i = paramString2.length();
        }
        j = k;
        if (k > paramString2.length()) {
          j = paramString2.length();
        }
        localEditText.setSelection(i, j);
        AppMethodBeat.o(73146);
      }
    });
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
  
  public static String bc(String paramString, int paramInt1, int paramInt2)
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
    paramString = bu.bI(str, "") + bu.bI(paramString, "");
    AppMethodBeat.o(73184);
    return paramString;
  }
  
  private void dHt()
  {
    AppMethodBeat.i(73160);
    if ((this.xFy != null) && (!bu.isNullOrNil(getText())) && (this.LXo != null) && (this.LXo.isEnabled()) && (this.LXo.isClickable()) && (this.LXo.isFocusable()) && (this.LXo.isFocused()))
    {
      this.xFy.setToClearState(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73144);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/formview/WalletFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          WalletFormView.this.dHv();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/formview/WalletFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(73144);
        }
      });
      AppMethodBeat.o(73160);
      return;
    }
    if (this.xFy != null)
    {
      this.xFy.fjp();
      AppMethodBeat.o(73160);
      return;
    }
    ae.v("MicroMsg.WalletFormView", "hy: no info iv");
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
  
  private void fWC()
  {
    AppMethodBeat.i(73174);
    if (getTitleTv() != null)
    {
      getTitleTv().setText(this.vli);
      getTitleTv().setVisibility(this.xFG);
      setTitleWidth(this.JNI);
    }
    AppMethodBeat.o(73174);
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
  
  public final void a(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(73182);
    if (this.LXo != null) {
      this.LXo.addTextChangedListener(paramTextWatcher);
    }
    AppMethodBeat.o(73182);
  }
  
  public final boolean aVz()
  {
    AppMethodBeat.i(73189);
    if (this.LXo != null)
    {
      int i = this.LXo.getInputLength();
      if ((i > this.xFR) || (i < this.xFS))
      {
        AppMethodBeat.o(73189);
        return false;
      }
      if (this.LXs != null)
      {
        boolean bool = this.LXs.a(this);
        AppMethodBeat.o(73189);
        return bool;
      }
      AppMethodBeat.o(73189);
      return true;
    }
    ae.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
    AppMethodBeat.o(73189);
    return true;
  }
  
  public final void d(WalletBaseUI paramWalletBaseUI)
  {
    AppMethodBeat.i(73196);
    if (this.LXo != null)
    {
      this.LXo.setFocusable(true);
      this.LXo.requestFocus();
      paramWalletBaseUI.showTenpayKB();
    }
    AppMethodBeat.o(73196);
  }
  
  public final void dHu()
  {
    AppMethodBeat.i(73191);
    if (this.LXo != null) {
      this.LXo.clearFocus();
    }
    AppMethodBeat.o(73191);
  }
  
  public final void dHv()
  {
    AppMethodBeat.i(73190);
    if (this.LXo != null) {
      this.LXo.ClearInput();
    }
    AppMethodBeat.o(73190);
  }
  
  public final boolean fWB()
  {
    AppMethodBeat.i(73161);
    if (this.LXo != null)
    {
      boolean bool = this.LXo.isFocusable();
      AppMethodBeat.o(73161);
      return bool;
    }
    AppMethodBeat.o(73161);
    return false;
  }
  
  public final void fWD()
  {
    AppMethodBeat.i(73183);
    if (this.LXo != null) {
      this.LXo.addTextChangedListener(new TextWatcher()
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
          if ((this.LXE >= 0) && (k >= 0) && (m - k > this.LXE))
          {
            paramAnonymousEditable = WalletFormView.bc(str, this.LXE + k + 1, m);
            i = 1;
          }
          for (;;)
          {
            int j = i;
            Object localObject = paramAnonymousEditable;
            int n;
            if (this.LXF >= 0)
            {
              n = WalletFormView.j(WalletFormView.this).getSelectionStart();
              if (k <= this.LXF) {
                break label236;
              }
              j = i;
              localObject = paramAnonymousEditable;
              if (!bu.jB(n, -1))
              {
                j = i;
                localObject = paramAnonymousEditable;
                if (k - this.LXF > 0)
                {
                  j = i;
                  localObject = paramAnonymousEditable;
                  if (n - (k - this.LXF) >= 0)
                  {
                    localObject = WalletFormView.bc(paramAnonymousEditable, n - (k - 7), n);
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
              if (bu.jB(k, -1))
              {
                j = i;
                localObject = paramAnonymousEditable;
                if (m > this.LXF)
                {
                  j = i;
                  localObject = paramAnonymousEditable;
                  if (n >= 0)
                  {
                    j = i;
                    localObject = paramAnonymousEditable;
                    if (n - (m - this.LXF) >= 0)
                    {
                      localObject = WalletFormView.bc(paramAnonymousEditable, n - (m - this.LXF), n);
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
  
  public final void fWE()
  {
    AppMethodBeat.i(73195);
    if (this.LXo != null)
    {
      this.LXo.setFocusable(true);
      this.LXo.requestFocus();
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.LXo, 0);
    }
    AppMethodBeat.o(73195);
  }
  
  public final EditText getContentEt()
  {
    return this.LXo;
  }
  
  public final int getEncrptType()
  {
    return this.LXu;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.a getEventDelegate()
  {
    return this.LXr;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.xFy;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(73194);
    if (this.LXo != null)
    {
      int i = this.LXo.getInputLength();
      AppMethodBeat.o(73194);
      return i;
    }
    AppMethodBeat.o(73194);
    return 0;
  }
  
  public final a getInputValidChangeListener()
  {
    return this.LXq;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(73177);
    if (this.LXo != null)
    {
      KeyListener localKeyListener = this.LXo.getKeyListener();
      AppMethodBeat.o(73177);
      return localKeyListener;
    }
    ae.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(73177);
    return null;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.b getLogicDelegate()
  {
    return this.LXs;
  }
  
  public final String getMD5Value()
  {
    AppMethodBeat.i(73152);
    String str2 = bu.nullAsNil(this.LXo.getText().toString());
    String str1 = str2;
    if (this.LXs != null)
    {
      str1 = str2;
      if (this.LXs.dHs()) {
        str1 = this.LXs.c(this, str2);
      }
    }
    str1 = aj.ej(str1);
    AppMethodBeat.o(73152);
    return str1;
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
  
  public final int getSelectionStart()
  {
    AppMethodBeat.i(73157);
    if (this.LXo != null)
    {
      int i = this.LXo.getSelectionStart();
      AppMethodBeat.o(73157);
      return i;
    }
    AppMethodBeat.o(73157);
    return -1;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(73176);
    if (this.LXo != null)
    {
      String str = c.a.a(this.LXu, this.LXo);
      if ((this.LXs != null) && (this.LXs.dHs()))
      {
        str = this.LXs.c(this, str);
        AppMethodBeat.o(73176);
        return str;
      }
      AppMethodBeat.o(73176);
      return str;
    }
    ae.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
    AppMethodBeat.o(73176);
    return "";
  }
  
  public final TextView getTipsTv()
  {
    return this.xFz;
  }
  
  public final float getTitleMeasuredWidth()
  {
    AppMethodBeat.i(182538);
    float f = this.lHk.getPaint().measureText(this.lHk.getText(), 0, this.lHk.getText().length());
    AppMethodBeat.o(182538);
    return f;
  }
  
  public final TextView getTitleTv()
  {
    return this.lHk;
  }
  
  public final boolean ht(View paramView)
  {
    AppMethodBeat.i(73192);
    if (getVisibility() == 0)
    {
      if (bu.isNullOrNil(getText()))
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.lHk != null) {
          this.lHk.setEnabled(true);
        }
        AppMethodBeat.o(73192);
        return false;
      }
      if (aVz())
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.lHk != null) {
          this.lHk.setEnabled(true);
        }
        AppMethodBeat.o(73192);
        return true;
      }
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      if (this.lHk != null) {
        this.lHk.setEnabled(false);
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
    if (this.LXo == null)
    {
      AppMethodBeat.o(73181);
      return false;
    }
    boolean bool = this.LXo.isPhoneNum();
    AppMethodBeat.o(73181);
    return bool;
  }
  
  public final int j(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73149);
    if (this.LXC == 0)
    {
      int i = this.lHk.getLeft();
      this.LXC = (this.LXo.getLeft() - i + this.LXo.getPaddingLeft());
      ae.d("MicroMsg.WalletFormView", "mMaxUnitLeftOriginWidth:%s", new Object[] { Integer.valueOf(this.LXC) });
    }
    if (!bu.lX(paramCharSequence.toString(), ""))
    {
      if (paramInt2 == 1) {}
      for (float f1 = this.LXo.getPaint().measureText("1");; f1 = this.LXo.getPaint().measureText("2"))
      {
        float f2 = this.LXC;
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
    fWC();
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.xFH);
      getPrefilledTv().setVisibility(this.xFI);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.xFJ);
      getInfoIv().setVisibility(this.xFK);
      if (this.LXv != -1) {
        getInfoIv().setmUserSetImageIconColor(this.LXv);
      }
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.xFL);
      getTipsTv().setVisibility(this.xFM);
    }
    Object localObject = getContext();
    String str;
    if (this.LXo != null) {
      if (this.LXA >= 0) {
        str = f.agY(this.LXA);
      }
    }
    try
    {
      this.LXo.setTypeface(Typeface.createFromAsset(((Context)localObject).getAssets(), str));
      if (this.LXw == -1)
      {
        this.LXo.setHint(this.xFN);
        this.LXo.setGravity(this.xFO);
        this.LXo.setTextColor(this.xFP);
        setText(this.xFQ);
        b.a(this.LXo, this.LXx);
        this.LXo.setBackgroundResource(this.xFT);
        this.LXo.setEnabled(this.xFU);
        this.LXo.setFocusable(this.xFW);
        this.LXo.setClickable(this.xFV);
        this.LXo.setHintTextColor(this.xFZ);
        setImeOptions(this.xFY);
        setInputType(this.xFX);
        this.LXo.addTextChangedListener(new TextWatcher()
        {
          private boolean xGb = false;
          
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(73143);
            String str = paramAnonymousEditable.toString();
            if (str.startsWith(".")) {
              paramAnonymousEditable.insert(0, "0");
            }
            while ((!WalletFormView.i(WalletFormView.this)) || (!WalletFormView.a(str, WalletFormView.j(WalletFormView.this))))
            {
              boolean bool = WalletFormView.this.aVz();
              if (WalletFormView.k(WalletFormView.this) != null)
              {
                if (bool != this.xGb)
                {
                  WalletFormView.k(WalletFormView.this).onInputValidChange(bool);
                  this.xGb = WalletFormView.this.aVz();
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
        this.LXo.setOnFocusChangeListener(this);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (!bu.jB(this.LXB, 0))
          {
            localObject = TextView.class.getDeclaredField("mCursorDrawableRes");
            ((Field)localObject).setAccessible(true);
            ((Field)localObject).set(this.LXo, Integer.valueOf(this.LXB));
          }
          dHt();
          if (this.LXo != null)
          {
            if (this.xFX != 2) {
              break;
            }
            this.LXo.setKeyListener(new NumberKeyListener()
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
            if (this.xFR != -1) {
              this.LXo.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.xFR) });
            }
          }
          AppMethodBeat.o(73164);
          return;
          localException1 = localException1;
          ae.e("MicroMsg.WalletFormView", "setTypeface() Exception:%s %s", new Object[] { localException1.getClass().getSimpleName(), localException1.getMessage() });
        }
        SpannableString localSpannableString = new SpannableString(this.xFN + "  ");
        localSpannableString.setSpan(new com.tencent.mm.cf.a(this.LXw), 0, localSpannableString.length() - 2, 33);
        localSpannableString.setSpan(new AbsoluteSizeSpan((int)this.LXo.getTextSize(), false), localSpannableString.length() - 2, localSpannableString.length(), 33);
        this.LXo.setHint(new SpannedString(localSpannableString));
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.e("MicroMsg.WalletFormView", "set textCursorDrawable fail!!");
          continue;
          if (this.xFX == 4)
          {
            this.LXo.setKeyListener(new NumberKeyListener()
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
            this.LXo.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.LXo.setKeyListener(new NumberKeyListener()
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
            this.LXo.setRawInputType(18);
          }
          else if (this.xFX == 3)
          {
            this.LXo.setKeyListener(new NumberKeyListener()
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
            this.LXo.setInputType(this.xFX);
          }
        }
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(73198);
    if (this.xFB != null) {
      this.xFB.onFocusChange(this, paramBoolean);
    }
    if (this.LXq != null) {
      this.LXq.onInputValidChange(aVz());
    }
    if (!aVz()) {
      if (this.lHk != null) {
        this.lHk.setEnabled(false);
      }
    }
    for (;;)
    {
      dHt();
      AppMethodBeat.o(73198);
      return;
      if (this.lHk != null) {
        this.lHk.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(73171);
    if ((this.LXr == null) || (!this.LXr.fWG()))
    {
      if ((this.LXo != null) && (b(this.LXo, paramMotionEvent)) && (!this.LXo.isClickable()))
      {
        ae.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(73171);
        return true;
      }
      if ((this.xFy != null) && (this.xFy.isClickable()) && (b(this.xFy, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        ae.d("MicroMsg.WalletFormView", "hy: click on info iv");
        dHt();
        this.xFy.performClick();
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
    if ((this.LXr == null) || (!this.LXr.fWF())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(73170);
  }
  
  public final void set3DesToView(String paramString)
  {
    AppMethodBeat.i(73199);
    if (this.LXo != null) {
      this.LXo.set3DesEncrptData(paramString);
    }
    AppMethodBeat.o(73199);
  }
  
  public final void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(73151);
    if ((this.LXo != null) && ((this.LXs == null) || (!this.LXs.b(this, paramString))))
    {
      this.LXo.set3DesEncrptData(paramString);
      setSelection(getInputLength());
    }
    AppMethodBeat.o(73151);
  }
  
  public final void setBankcardTail(String paramString)
  {
    AppMethodBeat.i(73178);
    if (this.LXo != null) {
      this.LXo.setBankcardTailNum(paramString);
    }
    AppMethodBeat.o(73178);
  }
  
  public final void setContentClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(73166);
    if (this.LXo != null) {
      this.LXo.setClickable(paramBoolean);
    }
    AppMethodBeat.o(73166);
  }
  
  public final void setContentEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(73168);
    if (this.LXo != null) {
      this.LXo.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(73168);
  }
  
  public final void setContentFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(73167);
    if (this.LXo != null) {
      this.LXo.setFocusable(paramBoolean);
    }
    AppMethodBeat.o(73167);
  }
  
  public final void setContentPadding$3b4dfe4b(int paramInt)
  {
    AppMethodBeat.i(163889);
    if (this.LXo != null) {
      this.LXo.setPadding(paramInt, 0, 0, 0);
    }
    AppMethodBeat.o(163889);
  }
  
  public final void setContentTextColor(int paramInt)
  {
    AppMethodBeat.i(73159);
    if (this.LXo != null) {
      this.LXo.setTextColor(paramInt);
    }
    AppMethodBeat.o(73159);
  }
  
  @SuppressLint({"ResourceType"})
  public final void setContentTextColorRes(int paramInt)
  {
    AppMethodBeat.i(73158);
    this.xFP = paramInt;
    if (this.LXo != null) {
      this.LXo.setTextColor(getResources().getColor(this.xFP));
    }
    AppMethodBeat.o(73158);
  }
  
  public final void setEncryptType(int paramInt)
  {
    this.LXu = paramInt;
  }
  
  public final void setEventDelegate(com.tencent.mm.wallet_core.ui.formview.a.a parama)
  {
    this.LXr = parama;
  }
  
  public final void setFilterChar(char[] paramArrayOfChar) {}
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(73193);
    if (this.LXo != null) {
      this.LXo.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(73193);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(73165);
    if (this.LXo != null)
    {
      if (this.LXw == -1)
      {
        this.LXo.setHint(paramCharSequence);
        AppMethodBeat.o(73165);
        return;
      }
      paramCharSequence = new SpannableString(paramCharSequence);
      paramCharSequence.setSpan(new AbsoluteSizeSpan(this.LXw, false), 0, paramCharSequence.length(), 33);
      this.LXo.setHint(new SpannedString(paramCharSequence));
    }
    AppMethodBeat.o(73165);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(73153);
    if (this.LXo != null) {
      this.LXo.setImeOptions(paramInt);
    }
    AppMethodBeat.o(73153);
  }
  
  public final void setInputEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(73156);
    if (this.LXo != null) {
      this.LXo.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(73156);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(73154);
    if (this.LXo != null) {
      this.LXo.setInputType(paramInt);
    }
    AppMethodBeat.o(73154);
  }
  
  public final void setIsSecretAnswer(boolean paramBoolean)
  {
    AppMethodBeat.i(73197);
    if (this.LXo != null) {
      this.LXo.setIsSecurityAnswerFormat(paramBoolean);
    }
    AppMethodBeat.o(73197);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(73188);
    if (this.LXo != null) {
      this.LXo.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(73188);
  }
  
  public final void setLogicDelegate(com.tencent.mm.wallet_core.ui.formview.a.b paramb)
  {
    this.LXs = paramb;
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
    AppMethodBeat.i(73179);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(73179);
  }
  
  public final void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(73169);
    this.LXo.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(73169);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.xFB = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(73180);
    this.xFC = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.xFC);
    }
    AppMethodBeat.o(73180);
  }
  
  public final void setOnInputValidChangeListener(a parama)
  {
    this.LXq = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(73175);
    if (this.LXo != null) {
      this.LXo.setSelection(paramInt);
    }
    AppMethodBeat.o(73175);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(73155);
    if ((this.LXo != null) && ((this.LXs == null) || (!this.LXs.a(this, paramString))))
    {
      this.LXo.setText(paramString);
      this.LXo.setSelection(getInputLength());
    }
    AppMethodBeat.o(73155);
  }
  
  public final void setTitleText(String paramString)
  {
    AppMethodBeat.i(73148);
    this.vli = paramString;
    fWC();
    AppMethodBeat.o(73148);
  }
  
  public final void setTitleWidth(int paramInt)
  {
    AppMethodBeat.i(182539);
    this.JNI = paramInt;
    if (this.JNI > 0)
    {
      ViewGroup.LayoutParams localLayoutParams = this.lHk.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = this.JNI;
        this.lHk.setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(182539);
  }
  
  public final void setmContentAbnormalMoneyCheck(boolean paramBoolean)
  {
    this.LXy = paramBoolean;
  }
  
  public final void setmWalletFormViewListener(c paramc)
  {
    this.LXn = paramc;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.WalletFormView
 * JD-Core Version:    0.7.0.1
 */