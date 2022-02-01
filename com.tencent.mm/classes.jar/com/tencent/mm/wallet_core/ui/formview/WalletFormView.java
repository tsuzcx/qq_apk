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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.lang.reflect.Field;
import junit.framework.Assert;

public final class WalletFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private View.OnClickListener BFA;
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
  private TextView BFu;
  private WalletIconImageView BFw;
  private TextView BFx;
  private View.OnFocusChangeListener BFz;
  private int OYK;
  private c Rwd;
  public TenpaySecureEditText Rwe;
  private LinearLayout Rwf;
  private a Rwg;
  private com.tencent.mm.wallet_core.ui.formview.a.a Rwh;
  private com.tencent.mm.wallet_core.ui.formview.a.b Rwi;
  private int Rwj;
  private int Rwk;
  private int Rwl;
  private int Rwm;
  private int Rwn;
  private boolean Rwo;
  @Deprecated
  private int Rwp;
  private int Rwq;
  private int Rwr;
  private int Rws;
  private TextView jVl;
  private TextView mPa;
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73147);
    this.mPa = null;
    this.BFu = null;
    this.Rwe = null;
    this.BFw = null;
    this.BFx = null;
    this.Rwg = null;
    this.BFz = null;
    this.BFA = null;
    this.Rwh = null;
    this.Rwi = null;
    this.BFD = -1;
    this.Rwj = this.BFD;
    this.Rwk = 100;
    this.BFE = "";
    this.BFF = 0;
    this.BFG = "";
    this.BFH = 8;
    this.BFI = -1;
    this.Rwl = -1;
    this.BFJ = 4;
    this.BFK = "";
    this.BFL = 8;
    this.BFM = "";
    this.Rwm = -1;
    this.BFN = 19;
    this.BFO = 2131100904;
    this.BFP = "";
    this.Rwn = 0;
    this.BFQ = 2147483647;
    this.BFR = 1;
    this.BFS = 2131233974;
    this.BFT = true;
    this.BFU = false;
    this.BFV = true;
    this.Rwo = false;
    this.BFW = 1;
    this.BFX = 5;
    this.BFY = 2131100690;
    this.Rwp = 0;
    this.Rwq = 0;
    this.Rwr = 0;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WalletFormAttrs, paramInt, 0);
    this.BFD = paramAttributeSet.getResourceId(23, this.BFD);
    paramInt = paramAttributeSet.getResourceId(30, 0);
    if (paramInt != 0) {
      this.BFE = paramContext.getString(paramInt);
    }
    this.OYK = paramAttributeSet.getDimensionPixelSize(32, -1);
    this.BFI = paramAttributeSet.getResourceId(20, this.BFI);
    this.Rwl = paramAttributeSet.getColor(19, this.Rwl);
    paramInt = paramAttributeSet.getResourceId(28, 0);
    if (paramInt != 0) {
      this.BFK = paramContext.getString(paramInt);
    }
    this.BFJ = paramAttributeSet.getInteger(21, this.BFJ);
    this.BFF = paramAttributeSet.getInteger(31, this.BFF);
    this.BFL = paramAttributeSet.getInteger(29, this.BFL);
    this.BFH = paramAttributeSet.getInteger(27, this.BFH);
    paramInt = paramAttributeSet.getResourceId(25, 0);
    if (paramInt != 0) {
      this.BFG = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(11, 0);
    if (paramInt != 0) {
      this.BFM = paramContext.getString(paramInt);
    }
    this.Rwm = paramAttributeSet.getDimensionPixelSize(12, -1);
    this.BFN = paramAttributeSet.getInteger(10, this.BFN);
    this.BFO = paramAttributeSet.getColor(17, this.BFO);
    paramInt = paramAttributeSet.getResourceId(16, 0);
    if (paramInt != 0) {
      this.BFP = paramContext.getString(paramInt);
    }
    this.Rwn = paramAttributeSet.getInt(9, this.Rwn);
    this.BFQ = paramAttributeSet.getInteger(14, this.BFQ);
    this.BFR = paramAttributeSet.getInteger(15, this.BFR);
    this.BFS = paramAttributeSet.getResourceId(5, this.BFS);
    this.BFT = paramAttributeSet.getBoolean(7, this.BFT);
    this.BFU = paramAttributeSet.getBoolean(6, this.BFU);
    this.BFV = paramAttributeSet.getBoolean(7, this.BFV);
    this.BFW = paramAttributeSet.getInteger(0, this.BFW);
    this.BFX = paramAttributeSet.getInteger(1, this.BFX);
    this.Rwk = paramAttributeSet.getInteger(18, this.Rwk);
    this.BFY = paramAttributeSet.getInteger(13, this.BFY);
    this.Rwj = paramAttributeSet.getResourceId(24, this.Rwj);
    this.Rwp = paramAttributeSet.getInteger(33, 0);
    this.Rwq = paramAttributeSet.getInteger(34, -1);
    if ((this.Rwp == 1) && (this.Rwq == -1)) {
      this.Rwq = 4;
    }
    this.Rwr = paramAttributeSet.getResourceId(2, 0);
    paramAttributeSet.recycle();
    if (this.BFD > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    if ((!Util.isNullOrNil(this.BFE)) && (this.BFE.length() > 6)) {
      inflate(paramContext, this.Rwj, this);
    }
    for (;;)
    {
      this.mPa = ((TextView)findViewById(2131310298));
      this.BFu = ((TextView)findViewById(2131310279));
      this.Rwe = ((TenpaySecureEditText)findViewById(2131310180));
      this.BFw = ((WalletIconImageView)findViewById(2131310207));
      this.BFx = ((TextView)findViewById(2131310297));
      this.Rwf = ((LinearLayout)findViewById(2131310214));
      this.jVl = ((TextView)findViewById(2131310217));
      AppMethodBeat.o(73147);
      return;
      inflate(paramContext, this.BFD, this);
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
    a(paramEditText, paramString, aX(paramString, paramInt1, paramInt2));
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
    if (Util.isEqual(paramString1, paramString2))
    {
      AppMethodBeat.o(73185);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(73146);
        int j = this.val$editText.getSelectionStart();
        int k = this.val$editText.getSelectionEnd();
        if (Util.isNullOrNil(paramString2))
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
  
  public static String aX(String paramString, int paramInt1, int paramInt2)
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
    paramString = Util.nullAs(str, "") + Util.nullAs(paramString, "");
    AppMethodBeat.o(73184);
    return paramString;
  }
  
  private boolean c(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(73172);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (eJ(paramView).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
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
  
  private void eIh()
  {
    AppMethodBeat.i(73160);
    if ((this.BFw != null) && (!Util.isNullOrNil(getText())) && (this.Rwe != null) && (this.Rwe.isEnabled()) && (this.Rwe.isClickable()) && (this.Rwe.isFocusable()) && (this.Rwe.isFocused()))
    {
      this.BFw.setToClearState(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73144);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/formview/WalletFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          WalletFormView.this.eIj();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/formview/WalletFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(73144);
        }
      });
      AppMethodBeat.o(73160);
      return;
    }
    if (this.BFw != null)
    {
      this.BFw.gsP();
      AppMethodBeat.o(73160);
      return;
    }
    Log.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(73160);
  }
  
  private Rect eJ(View paramView)
  {
    AppMethodBeat.i(73173);
    if (paramView != null)
    {
      Rect localRect = new Rect();
      paramView.getHitRect(localRect);
      paramView = g(paramView, localRect);
      AppMethodBeat.o(73173);
      return paramView;
    }
    AppMethodBeat.o(73173);
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
  
  private void hia()
  {
    AppMethodBeat.i(73174);
    if (getTitleTv() != null)
    {
      getTitleTv().setText(this.BFE);
      getTitleTv().setVisibility(this.BFF);
      setTitleWidth(this.OYK);
    }
    AppMethodBeat.o(73174);
  }
  
  public final void a(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(73182);
    if (this.Rwe != null) {
      this.Rwe.addTextChangedListener(paramTextWatcher);
    }
    AppMethodBeat.o(73182);
  }
  
  public final boolean bql()
  {
    AppMethodBeat.i(73189);
    if (this.Rwe != null)
    {
      int i = this.Rwe.getInputLength();
      if ((i > this.BFQ) || (i < this.BFR))
      {
        AppMethodBeat.o(73189);
        return false;
      }
      if (this.Rwi != null)
      {
        boolean bool = this.Rwi.a(this);
        AppMethodBeat.o(73189);
        return bool;
      }
      AppMethodBeat.o(73189);
      return true;
    }
    Log.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
    AppMethodBeat.o(73189);
    return true;
  }
  
  public final void d(WalletBaseUI paramWalletBaseUI)
  {
    AppMethodBeat.i(73196);
    if (this.Rwe != null)
    {
      this.Rwe.setFocusable(true);
      this.Rwe.requestFocus();
      paramWalletBaseUI.showTenpayKB();
    }
    AppMethodBeat.o(73196);
  }
  
  public final void eIi()
  {
    AppMethodBeat.i(73191);
    if (this.Rwe != null) {
      this.Rwe.clearFocus();
    }
    AppMethodBeat.o(73191);
  }
  
  public final void eIj()
  {
    AppMethodBeat.i(73190);
    if (this.Rwe != null) {
      this.Rwe.ClearInput();
    }
    AppMethodBeat.o(73190);
  }
  
  public final EditText getContentEt()
  {
    return this.Rwe;
  }
  
  public final int getEncrptType()
  {
    return this.Rwk;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.a getEventDelegate()
  {
    return this.Rwh;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.BFw;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(73194);
    if (this.Rwe != null)
    {
      int i = this.Rwe.getInputLength();
      AppMethodBeat.o(73194);
      return i;
    }
    AppMethodBeat.o(73194);
    return 0;
  }
  
  public final a getInputValidChangeListener()
  {
    return this.Rwg;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(73177);
    if (this.Rwe != null)
    {
      KeyListener localKeyListener = this.Rwe.getKeyListener();
      AppMethodBeat.o(73177);
      return localKeyListener;
    }
    Log.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(73177);
    return null;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.b getLogicDelegate()
  {
    return this.Rwi;
  }
  
  public final String getMD5Value()
  {
    AppMethodBeat.i(73152);
    String str2 = Util.nullAsNil(this.Rwe.getText().toString());
    String str1 = str2;
    if (this.Rwi != null)
    {
      str1 = str2;
      if (this.Rwi.eIg()) {
        str1 = this.Rwi.c(this, str2);
      }
    }
    str1 = MD5Util.getMD5String(str1);
    AppMethodBeat.o(73152);
    return str1;
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
  
  public final int getSelectionStart()
  {
    AppMethodBeat.i(73157);
    if (this.Rwe != null)
    {
      int i = this.Rwe.getSelectionStart();
      AppMethodBeat.o(73157);
      return i;
    }
    AppMethodBeat.o(73157);
    return -1;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(73176);
    if (this.Rwe != null)
    {
      String str = c.a.a(this.Rwk, this.Rwe);
      if ((this.Rwi != null) && (this.Rwi.eIg()))
      {
        str = this.Rwi.c(this, str);
        AppMethodBeat.o(73176);
        return str;
      }
      AppMethodBeat.o(73176);
      return str;
    }
    Log.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
    AppMethodBeat.o(73176);
    return "";
  }
  
  public final TextView getTipsTv()
  {
    return this.BFx;
  }
  
  public final float getTitleMeasuredWidth()
  {
    AppMethodBeat.i(182538);
    float f = this.mPa.getPaint().measureText(this.mPa.getText(), 0, this.mPa.getText().length());
    AppMethodBeat.o(182538);
    return f;
  }
  
  public final TextView getTitleTv()
  {
    return this.mPa;
  }
  
  public final boolean hK(View paramView)
  {
    AppMethodBeat.i(73192);
    if (getVisibility() == 0)
    {
      if (Util.isNullOrNil(getText()))
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.mPa != null) {
          this.mPa.setEnabled(true);
        }
        AppMethodBeat.o(73192);
        return false;
      }
      if (bql())
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.mPa != null) {
          this.mPa.setEnabled(true);
        }
        AppMethodBeat.o(73192);
        return true;
      }
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      if (this.mPa != null) {
        this.mPa.setEnabled(false);
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
  
  public final boolean hhZ()
  {
    AppMethodBeat.i(73161);
    if (this.Rwe != null)
    {
      boolean bool = this.Rwe.isFocusable();
      AppMethodBeat.o(73161);
      return bool;
    }
    AppMethodBeat.o(73161);
    return false;
  }
  
  public final void hib()
  {
    AppMethodBeat.i(73183);
    if (this.Rwe != null) {
      this.Rwe.addTextChangedListener(new TextWatcher()
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
          if ((this.Rwu >= 0) && (k >= 0) && (m - k > this.Rwu))
          {
            paramAnonymousEditable = WalletFormView.aX(str, this.Rwu + k + 1, m);
            i = 1;
          }
          for (;;)
          {
            int j = i;
            Object localObject = paramAnonymousEditable;
            int n;
            if (this.Rwv >= 0)
            {
              n = WalletFormView.j(WalletFormView.this).getSelectionStart();
              if (k <= this.Rwv) {
                break label236;
              }
              j = i;
              localObject = paramAnonymousEditable;
              if (!Util.isEqual(n, -1))
              {
                j = i;
                localObject = paramAnonymousEditable;
                if (k - this.Rwv > 0)
                {
                  j = i;
                  localObject = paramAnonymousEditable;
                  if (n - (k - this.Rwv) >= 0)
                  {
                    localObject = WalletFormView.aX(paramAnonymousEditable, n - (k - 7), n);
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
              if (Util.isEqual(k, -1))
              {
                j = i;
                localObject = paramAnonymousEditable;
                if (m > this.Rwv)
                {
                  j = i;
                  localObject = paramAnonymousEditable;
                  if (n >= 0)
                  {
                    j = i;
                    localObject = paramAnonymousEditable;
                    if (n - (m - this.Rwv) >= 0)
                    {
                      localObject = WalletFormView.aX(paramAnonymousEditable, n - (m - this.Rwv), n);
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
  
  public final void hic()
  {
    AppMethodBeat.i(73195);
    if (this.Rwe != null)
    {
      this.Rwe.setFocusable(true);
      this.Rwe.requestFocus();
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.Rwe, 0);
    }
    AppMethodBeat.o(73195);
  }
  
  public final boolean isPhoneNum()
  {
    AppMethodBeat.i(73181);
    if (this.Rwe == null)
    {
      AppMethodBeat.o(73181);
      return false;
    }
    boolean bool = this.Rwe.isPhoneNum();
    AppMethodBeat.o(73181);
    return bool;
  }
  
  public final int k(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73149);
    if (this.Rws == 0)
    {
      int i = this.mPa.getLeft();
      this.Rws = (this.Rwe.getLeft() - i + this.Rwe.getPaddingLeft());
      Log.d("MicroMsg.WalletFormView", "mMaxUnitLeftOriginWidth:%s", new Object[] { Integer.valueOf(this.Rws) });
    }
    if (!Util.isEqual(paramCharSequence.toString(), ""))
    {
      if (paramInt2 == 1) {}
      for (float f1 = this.Rwe.getPaint().measureText("1");; f1 = this.Rwe.getPaint().measureText("2"))
      {
        float f2 = this.Rws;
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
    hia();
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.BFG);
      getPrefilledTv().setVisibility(this.BFH);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.BFI);
      getInfoIv().setVisibility(this.BFJ);
      if (this.Rwl != -1) {
        getInfoIv().setmUserSetImageIconColor(this.Rwl);
      }
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.BFK);
      getTipsTv().setVisibility(this.BFL);
    }
    Object localObject = getContext();
    String str;
    if (this.Rwe != null) {
      if (this.Rwq >= 0) {
        str = f.aqk(this.Rwq);
      }
    }
    try
    {
      this.Rwe.setTypeface(Typeface.createFromAsset(((Context)localObject).getAssets(), str));
      if (this.Rwm == -1)
      {
        this.Rwe.setHint(this.BFM);
        this.Rwe.setGravity(this.BFN);
        this.Rwe.setTextColor(this.BFO);
        setText(this.BFP);
        b.a(this.Rwe, this.Rwn);
        this.Rwe.setBackgroundResource(this.BFS);
        this.Rwe.setEnabled(this.BFT);
        this.Rwe.setFocusable(this.BFV);
        this.Rwe.setClickable(this.BFU);
        this.Rwe.setHintTextColor(this.BFY);
        setImeOptions(this.BFX);
        setInputType(this.BFW);
        this.Rwe.addTextChangedListener(new TextWatcher()
        {
          private boolean BGa = false;
          
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(73143);
            String str = paramAnonymousEditable.toString();
            if (str.startsWith(".")) {
              paramAnonymousEditable.insert(0, "0");
            }
            while ((!WalletFormView.i(WalletFormView.this)) || (!WalletFormView.a(str, WalletFormView.j(WalletFormView.this))))
            {
              boolean bool = WalletFormView.this.bql();
              if (WalletFormView.k(WalletFormView.this) != null)
              {
                if (bool != this.BGa)
                {
                  WalletFormView.k(WalletFormView.this).onInputValidChange(bool);
                  this.BGa = WalletFormView.this.bql();
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
        this.Rwe.setOnFocusChangeListener(this);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (!Util.isEqual(this.Rwr, 0))
          {
            localObject = TextView.class.getDeclaredField("mCursorDrawableRes");
            ((Field)localObject).setAccessible(true);
            ((Field)localObject).set(this.Rwe, Integer.valueOf(this.Rwr));
          }
          eIh();
          if (this.Rwe != null)
          {
            if (this.BFW != 2) {
              break;
            }
            this.Rwe.setKeyListener(new NumberKeyListener()
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
            if (this.BFQ != -1) {
              this.Rwe.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.BFQ) });
            }
          }
          AppMethodBeat.o(73164);
          return;
          localException1 = localException1;
          Log.e("MicroMsg.WalletFormView", "setTypeface() Exception:%s %s", new Object[] { localException1.getClass().getSimpleName(), localException1.getMessage() });
        }
        SpannableString localSpannableString = new SpannableString(this.BFM + "  ");
        localSpannableString.setSpan(new com.tencent.mm.cf.a(this.Rwm), 0, localSpannableString.length() - 2, 33);
        localSpannableString.setSpan(new AbsoluteSizeSpan((int)this.Rwe.getTextSize(), false), localSpannableString.length() - 2, localSpannableString.length(), 33);
        this.Rwe.setHint(new SpannedString(localSpannableString));
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.WalletFormView", "set textCursorDrawable fail!!");
          continue;
          if (this.BFW == 4)
          {
            this.Rwe.setKeyListener(new NumberKeyListener()
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
            this.Rwe.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.Rwe.setKeyListener(new NumberKeyListener()
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
            this.Rwe.setRawInputType(18);
          }
          else if (this.BFW == 3)
          {
            this.Rwe.setKeyListener(new NumberKeyListener()
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
            this.Rwe.setInputType(this.BFW);
          }
        }
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(73198);
    if (this.BFz != null) {
      this.BFz.onFocusChange(this, paramBoolean);
    }
    if (this.Rwg != null) {
      this.Rwg.onInputValidChange(bql());
    }
    if (!bql()) {
      if (this.mPa != null) {
        this.mPa.setEnabled(false);
      }
    }
    for (;;)
    {
      eIh();
      AppMethodBeat.o(73198);
      return;
      if (this.mPa != null) {
        this.mPa.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(73171);
    if ((this.Rwh == null) || (!this.Rwh.hie()))
    {
      if ((this.Rwe != null) && (c(this.Rwe, paramMotionEvent)) && (!this.Rwe.isClickable()))
      {
        Log.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(73171);
        return true;
      }
      if ((this.BFw != null) && (this.BFw.isClickable()) && (c(this.BFw, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        Log.d("MicroMsg.WalletFormView", "hy: click on info iv");
        eIh();
        this.BFw.performClick();
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
    if ((this.Rwh == null) || (!this.Rwh.hid())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(73170);
  }
  
  public final void set3DesToView(String paramString)
  {
    AppMethodBeat.i(73199);
    if (this.Rwe != null) {
      this.Rwe.set3DesEncrptData(paramString);
    }
    AppMethodBeat.o(73199);
  }
  
  public final void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(73151);
    if ((this.Rwe != null) && ((this.Rwi == null) || (!this.Rwi.b(this, paramString))))
    {
      this.Rwe.set3DesEncrptData(paramString);
      setSelection(getInputLength());
    }
    AppMethodBeat.o(73151);
  }
  
  public final void setBankcardTail(String paramString)
  {
    AppMethodBeat.i(73178);
    if (this.Rwe != null) {
      this.Rwe.setBankcardTailNum(paramString);
    }
    AppMethodBeat.o(73178);
  }
  
  public final void setContentClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(73166);
    if (this.Rwe != null) {
      this.Rwe.setClickable(paramBoolean);
    }
    AppMethodBeat.o(73166);
  }
  
  public final void setContentEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(73168);
    if (this.Rwe != null) {
      this.Rwe.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(73168);
  }
  
  public final void setContentFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(73167);
    if (this.Rwe != null) {
      this.Rwe.setFocusable(paramBoolean);
    }
    AppMethodBeat.o(73167);
  }
  
  public final void setContentPadding$3b4dfe4b(int paramInt)
  {
    AppMethodBeat.i(163889);
    if (this.Rwe != null) {
      this.Rwe.setPadding(paramInt, 0, 0, 0);
    }
    AppMethodBeat.o(163889);
  }
  
  public final void setContentTextColor(int paramInt)
  {
    AppMethodBeat.i(73159);
    if (this.Rwe != null) {
      this.Rwe.setTextColor(paramInt);
    }
    AppMethodBeat.o(73159);
  }
  
  @SuppressLint({"ResourceType"})
  public final void setContentTextColorRes(int paramInt)
  {
    AppMethodBeat.i(73158);
    this.BFO = paramInt;
    if (this.Rwe != null) {
      this.Rwe.setTextColor(getResources().getColor(this.BFO));
    }
    AppMethodBeat.o(73158);
  }
  
  public final void setEncryptType(int paramInt)
  {
    this.Rwk = paramInt;
  }
  
  public final void setEventDelegate(com.tencent.mm.wallet_core.ui.formview.a.a parama)
  {
    this.Rwh = parama;
  }
  
  public final void setFilterChar(char[] paramArrayOfChar) {}
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(73193);
    if (this.Rwe != null) {
      this.Rwe.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(73193);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(73165);
    if (this.Rwe != null)
    {
      if (this.Rwm == -1)
      {
        this.Rwe.setHint(paramCharSequence);
        AppMethodBeat.o(73165);
        return;
      }
      paramCharSequence = new SpannableString(paramCharSequence);
      paramCharSequence.setSpan(new AbsoluteSizeSpan(this.Rwm, false), 0, paramCharSequence.length(), 33);
      this.Rwe.setHint(new SpannedString(paramCharSequence));
    }
    AppMethodBeat.o(73165);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(73153);
    if (this.Rwe != null) {
      this.Rwe.setImeOptions(paramInt);
    }
    AppMethodBeat.o(73153);
  }
  
  public final void setInputEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(73156);
    if (this.Rwe != null) {
      this.Rwe.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(73156);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(73154);
    if (this.Rwe != null) {
      this.Rwe.setInputType(paramInt);
    }
    AppMethodBeat.o(73154);
  }
  
  public final void setIsSecretAnswer(boolean paramBoolean)
  {
    AppMethodBeat.i(73197);
    if (this.Rwe != null) {
      this.Rwe.setIsSecurityAnswerFormat(paramBoolean);
    }
    AppMethodBeat.o(73197);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(73188);
    if (this.Rwe != null) {
      this.Rwe.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(73188);
  }
  
  public final void setLogicDelegate(com.tencent.mm.wallet_core.ui.formview.a.b paramb)
  {
    this.Rwi = paramb;
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
    AppMethodBeat.i(73179);
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(73179);
  }
  
  public final void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(73169);
    this.Rwe.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(73169);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.BFz = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(73180);
    this.BFA = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.BFA);
    }
    AppMethodBeat.o(73180);
  }
  
  public final void setOnInputValidChangeListener(a parama)
  {
    this.Rwg = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(73175);
    if (this.Rwe != null) {
      this.Rwe.setSelection(paramInt);
    }
    AppMethodBeat.o(73175);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(73155);
    if ((this.Rwe != null) && ((this.Rwi == null) || (!this.Rwi.a(this, paramString))))
    {
      this.Rwe.setText(paramString);
      this.Rwe.setSelection(getInputLength());
    }
    AppMethodBeat.o(73155);
  }
  
  public final void setTitleText(String paramString)
  {
    AppMethodBeat.i(73148);
    this.BFE = paramString;
    hia();
    AppMethodBeat.o(73148);
  }
  
  public final void setTitleWidth(int paramInt)
  {
    AppMethodBeat.i(182539);
    this.OYK = paramInt;
    if (this.OYK > 0)
    {
      ViewGroup.LayoutParams localLayoutParams = this.mPa.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = this.OYK;
        this.mPa.setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(182539);
  }
  
  public final void setmContentAbnormalMoneyCheck(boolean paramBoolean)
  {
    this.Rwo = paramBoolean;
  }
  
  public final void setmWalletFormViewListener(c paramc)
  {
    this.Rwd = paramc;
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