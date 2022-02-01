package com.tencent.mm.wallet_core.ui.formview;

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
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.lang.reflect.Field;
import junit.framework.Assert;

public final class WalletFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private boolean NzA;
  private boolean NzB;
  private boolean NzC;
  private int NzD;
  private int NzE;
  private int NzF;
  private TextView Nzb;
  private WalletIconImageView Nzd;
  private TextView Nze;
  private View.OnFocusChangeListener Nzg;
  private View.OnClickListener Nzh;
  private int Nzk;
  private String Nzl;
  private int Nzm;
  private String Nzn;
  private int Nzo;
  private int Nzp;
  private int Nzq;
  private String Nzr;
  private int Nzs;
  private String Nzt;
  private int Nzu;
  private int Nzv;
  private String Nzw;
  private int Nzx;
  private int Nzy;
  private int Nzz;
  private int adZj;
  private c agVI;
  public TenpaySecureEditText agVJ;
  private LinearLayout agVK;
  private a agVL;
  private com.tencent.mm.wallet_core.ui.formview.a.a agVM;
  private com.tencent.mm.wallet_core.ui.formview.a.b agVN;
  private int agVO;
  private int agVP;
  private int agVQ;
  private int agVR;
  private int agVS;
  private boolean agVT;
  @Deprecated
  private int agVU;
  private int agVV;
  private int agVW;
  private int agVX;
  private TextView pJg;
  private TextView sUt;
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73147);
    this.sUt = null;
    this.Nzb = null;
    this.agVJ = null;
    this.Nzd = null;
    this.Nze = null;
    this.agVL = null;
    this.Nzg = null;
    this.Nzh = null;
    this.agVM = null;
    this.agVN = null;
    this.Nzk = -1;
    this.agVO = this.Nzk;
    this.agVP = 100;
    this.Nzl = "";
    this.Nzm = 0;
    this.Nzn = "";
    this.Nzo = 8;
    this.Nzp = -1;
    this.agVQ = -1;
    this.Nzq = 4;
    this.Nzr = "";
    this.Nzs = 8;
    this.Nzt = "";
    this.agVR = -1;
    this.Nzu = 19;
    this.Nzv = a.c.normal_text_color;
    this.Nzw = "";
    this.agVS = 0;
    this.Nzx = 2147483647;
    this.Nzy = 1;
    this.Nzz = a.e.mm_trans;
    this.NzA = true;
    this.NzB = false;
    this.NzC = true;
    this.agVT = false;
    this.NzD = 1;
    this.NzE = 5;
    this.NzF = a.c.list_devider_color;
    this.agVU = 0;
    this.agVV = 0;
    this.agVW = 0;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.WalletFormAttrs, paramInt, 0);
    this.Nzk = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_layoutRes, this.Nzk);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_titleText, 0);
    if (paramInt != 0) {
      this.Nzl = paramContext.getString(paramInt);
    }
    this.adZj = paramAttributeSet.getDimensionPixelSize(a.k.WalletFormAttrs_titleWidth, -1);
    this.Nzp = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_infoIvRes, this.Nzp);
    this.agVQ = paramAttributeSet.getColor(a.k.WalletFormAttrs_infoIvColorRes, this.agVQ);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_tipsText, 0);
    if (paramInt != 0) {
      this.Nzr = paramContext.getString(paramInt);
    }
    this.Nzq = paramAttributeSet.getInteger(a.k.WalletFormAttrs_infoIvVisibility, this.Nzq);
    this.Nzm = paramAttributeSet.getInteger(a.k.WalletFormAttrs_titleTvVisibility, this.Nzm);
    this.Nzs = paramAttributeSet.getInteger(a.k.WalletFormAttrs_tipsTvVisibility, this.Nzs);
    this.Nzo = paramAttributeSet.getInteger(a.k.WalletFormAttrs_prefilledTvVisibility, this.Nzo);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_prefilledText, 0);
    if (paramInt != 0) {
      this.Nzn = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_contentHint, 0);
    if (paramInt != 0) {
      this.Nzt = paramContext.getString(paramInt);
    }
    this.agVR = paramAttributeSet.getDimensionPixelSize(a.k.WalletFormAttrs_contentHintSize, -1);
    this.Nzu = paramAttributeSet.getInteger(a.k.WalletFormAttrs_contentGravity, this.Nzu);
    this.Nzv = paramAttributeSet.getColor(a.k.WalletFormAttrs_contentTextColor, this.Nzv);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_contentText, 0);
    if (paramInt != 0) {
      this.Nzw = paramContext.getString(paramInt);
    }
    this.agVS = paramAttributeSet.getInt(a.k.WalletFormAttrs_contentFormat, this.agVS);
    this.Nzx = paramAttributeSet.getInteger(a.k.WalletFormAttrs_contentMaxSize, this.Nzx);
    this.Nzy = paramAttributeSet.getInteger(a.k.WalletFormAttrs_contentMinSize, this.Nzy);
    this.Nzz = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_contentBackground, this.Nzz);
    this.NzA = paramAttributeSet.getBoolean(a.k.WalletFormAttrs_contentEnabled, this.NzA);
    this.NzB = paramAttributeSet.getBoolean(a.k.WalletFormAttrs_contentClickable, this.NzB);
    this.NzC = paramAttributeSet.getBoolean(a.k.WalletFormAttrs_contentEnabled, this.NzC);
    this.NzD = paramAttributeSet.getInteger(a.k.WalletFormAttrs_android_inputType, this.NzD);
    this.NzE = paramAttributeSet.getInteger(a.k.WalletFormAttrs_android_imeOptions, this.NzE);
    this.agVP = paramAttributeSet.getInteger(a.k.WalletFormAttrs_encryptType, this.agVP);
    this.NzF = paramAttributeSet.getInteger(a.k.WalletFormAttrs_contentHintTextColor, this.NzF);
    this.agVO = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_longTitleLayoutRes, this.agVO);
    this.agVU = paramAttributeSet.getInteger(a.k.WalletFormAttrs_typeface, 0);
    this.agVV = paramAttributeSet.getInteger(a.k.WalletFormAttrs_walletTypeFace, -1);
    if ((this.agVU == 1) && (this.agVV == -1)) {
      this.agVV = 4;
    }
    this.agVW = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_android_textCursorDrawable, 0);
    paramAttributeSet.recycle();
    if (this.Nzk > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    if ((!Util.isNullOrNil(this.Nzl)) && (this.Nzl.length() > 6)) {
      inflate(paramContext, this.agVO, this);
    }
    for (;;)
    {
      this.sUt = ((TextView)findViewById(a.f.wallet_title));
      this.Nzb = ((TextView)findViewById(a.f.wallet_prefilled));
      this.agVJ = ((TenpaySecureEditText)findViewById(a.f.wallet_content));
      this.Nzd = ((WalletIconImageView)findViewById(a.f.wallet_info));
      this.Nze = ((TextView)findViewById(a.f.wallet_tips_msg));
      this.agVK = ((LinearLayout)findViewById(a.f.wallet_max_unit_layout));
      this.pJg = ((TextView)findViewById(a.f.wallet_max_unit_tv));
      AppMethodBeat.o(73147);
      return;
      inflate(paramContext, this.Nzk, this);
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
    a(paramEditText, paramString, bj(paramString, paramInt1, paramInt2));
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
        int j = WalletFormView.this.getSelectionStart();
        int k = WalletFormView.this.getSelectionEnd();
        if (Util.isNullOrNil(paramString2))
        {
          WalletFormView.this.setText("");
          AppMethodBeat.o(73146);
          return;
        }
        WalletFormView.this.setText(paramString2);
        EditText localEditText = WalletFormView.this;
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
  
  public static String bj(String paramString, int paramInt1, int paramInt2)
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
  
  private Rect g(View paramView, Rect paramRect)
  {
    if (paramView == this.Nzd)
    {
      paramRect.left -= 50;
      paramRect.right += 50;
      paramRect.top -= 25;
      paramRect.bottom += 25;
    }
    return paramRect;
  }
  
  private void gGb()
  {
    AppMethodBeat.i(73160);
    if ((this.Nzd != null) && (!Util.isNullOrNil(getText())) && (this.agVJ != null) && (this.agVJ.isEnabled()) && (this.agVJ.isClickable()) && (this.agVJ.isFocusable()) && (this.agVJ.isFocused()))
    {
      this.Nzd.setToClearState(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73144);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/wallet_core/ui/formview/WalletFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          WalletFormView.this.gGd();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/formview/WalletFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(73144);
        }
      });
      AppMethodBeat.o(73160);
      return;
    }
    if (this.Nzd != null)
    {
      this.Nzd.iOU();
      AppMethodBeat.o(73160);
      return;
    }
    Log.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(73160);
  }
  
  private Rect iH(View paramView)
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
  
  private void jPC()
  {
    AppMethodBeat.i(73174);
    if (getTitleTv() != null)
    {
      getTitleTv().setText(this.Nzl);
      getTitleTv().setVisibility(this.Nzm);
      setTitleWidth(this.adZj);
    }
    AppMethodBeat.o(73174);
  }
  
  private boolean k(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(73172);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (iH(paramView).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
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
  
  public final void a(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(73182);
    if (this.agVJ != null) {
      this.agVJ.addTextChangedListener(paramTextWatcher);
    }
    AppMethodBeat.o(73182);
  }
  
  public final void aGD(int paramInt)
  {
    AppMethodBeat.i(163889);
    if (this.agVJ != null) {
      this.agVJ.setPadding(paramInt, 0, 0, 0);
    }
    AppMethodBeat.o(163889);
  }
  
  public final boolean bZp()
  {
    AppMethodBeat.i(73189);
    if (this.agVJ != null)
    {
      int i = this.agVJ.getInputLength();
      if ((i > this.Nzx) || (i < this.Nzy))
      {
        AppMethodBeat.o(73189);
        return false;
      }
      if (this.agVN != null)
      {
        boolean bool = this.agVN.a(this);
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
    if (this.agVJ != null)
    {
      this.agVJ.setFocusable(true);
      this.agVJ.requestFocus();
      paramWalletBaseUI.showTenpayKB();
    }
    AppMethodBeat.o(73196);
  }
  
  public final void gGc()
  {
    AppMethodBeat.i(73191);
    if (this.agVJ != null) {
      this.agVJ.clearFocus();
    }
    AppMethodBeat.o(73191);
  }
  
  public final void gGd()
  {
    AppMethodBeat.i(73190);
    if (this.agVJ != null) {
      this.agVJ.ClearInput();
    }
    AppMethodBeat.o(73190);
  }
  
  public final EditText getContentEt()
  {
    return this.agVJ;
  }
  
  public final int getEncrptType()
  {
    return this.agVP;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.a getEventDelegate()
  {
    return this.agVM;
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(242528);
    if (this.agVJ != null)
    {
      String str = this.agVJ.getHint().toString();
      AppMethodBeat.o(242528);
      return str;
    }
    AppMethodBeat.o(242528);
    return "";
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.Nzd;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(73194);
    if (this.agVJ != null)
    {
      int i = this.agVJ.getInputLength();
      AppMethodBeat.o(73194);
      return i;
    }
    AppMethodBeat.o(73194);
    return 0;
  }
  
  public final a getInputValidChangeListener()
  {
    return this.agVL;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(73177);
    if (this.agVJ != null)
    {
      KeyListener localKeyListener = this.agVJ.getKeyListener();
      AppMethodBeat.o(73177);
      return localKeyListener;
    }
    Log.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(73177);
    return null;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.b getLogicDelegate()
  {
    return this.agVN;
  }
  
  public final String getMD5Value()
  {
    AppMethodBeat.i(73152);
    String str2 = Util.nullAsNil(this.agVJ.getText().toString());
    String str1 = str2;
    if (this.agVN != null)
    {
      str1 = str2;
      if (this.agVN.gGa()) {
        str1 = this.agVN.c(this, str2);
      }
    }
    str1 = MD5Util.getMD5String(str1);
    AppMethodBeat.o(73152);
    return str1;
  }
  
  public final int getMaxInputLength()
  {
    return this.Nzx;
  }
  
  public final int getMinInputLength()
  {
    return this.Nzy;
  }
  
  public final TextView getPrefilledTv()
  {
    return this.Nzb;
  }
  
  public final int getSelectionStart()
  {
    AppMethodBeat.i(73157);
    if (this.agVJ != null)
    {
      int i = this.agVJ.getSelectionStart();
      AppMethodBeat.o(73157);
      return i;
    }
    AppMethodBeat.o(73157);
    return -1;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(73176);
    if (this.agVJ != null)
    {
      String str = c.a.a(this.agVP, this.agVJ, 0L, "");
      if ((this.agVN != null) && (this.agVN.gGa()))
      {
        str = this.agVN.c(this, str);
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
    return this.Nze;
  }
  
  public final float getTitleMeasuredWidth()
  {
    AppMethodBeat.i(182538);
    float f = this.sUt.getPaint().measureText(this.sUt.getText(), 0, this.sUt.getText().length());
    AppMethodBeat.o(182538);
    return f;
  }
  
  public final TextView getTitleTv()
  {
    return this.sUt;
  }
  
  public final int i(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73149);
    if (this.agVX == 0)
    {
      int i = this.sUt.getLeft();
      this.agVX = (this.agVJ.getLeft() - i + this.agVJ.getPaddingLeft());
      Log.d("MicroMsg.WalletFormView", "mMaxUnitLeftOriginWidth:%s", new Object[] { Integer.valueOf(this.agVX) });
    }
    if (!Util.isEqual(paramCharSequence.toString(), ""))
    {
      if (paramInt2 == 1) {}
      for (float f1 = this.agVJ.getPaint().measureText("1");; f1 = this.agVJ.getPaint().measureText("2"))
      {
        float f2 = this.agVX;
        paramInt1 = (int)(f1 / 2.0F + f2 - paramInt1 / 2);
        AppMethodBeat.o(73149);
        return paramInt1;
      }
    }
    AppMethodBeat.o(73149);
    return 0;
  }
  
  public final boolean isPhoneNum()
  {
    AppMethodBeat.i(73181);
    if (this.agVJ == null)
    {
      AppMethodBeat.o(73181);
      return false;
    }
    boolean bool = this.agVJ.isPhoneNum();
    AppMethodBeat.o(73181);
    return bool;
  }
  
  public final boolean jPB()
  {
    AppMethodBeat.i(73161);
    if (this.agVJ != null)
    {
      boolean bool = this.agVJ.isFocusable();
      AppMethodBeat.o(73161);
      return bool;
    }
    AppMethodBeat.o(73161);
    return false;
  }
  
  public final void jPD()
  {
    AppMethodBeat.i(73183);
    if (this.agVJ != null) {
      this.agVJ.addTextChangedListener(new TextWatcher()
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
          if ((this.agVZ >= 0) && (k >= 0) && (m - k > this.agVZ))
          {
            paramAnonymousEditable = WalletFormView.bj(str, this.agVZ + k + 1, m);
            i = 1;
          }
          for (;;)
          {
            int j = i;
            Object localObject = paramAnonymousEditable;
            int n;
            if (this.agWa >= 0)
            {
              n = WalletFormView.j(WalletFormView.this).getSelectionStart();
              if (k <= this.agWa) {
                break label236;
              }
              j = i;
              localObject = paramAnonymousEditable;
              if (!Util.isEqual(n, -1))
              {
                j = i;
                localObject = paramAnonymousEditable;
                if (k - this.agWa > 0)
                {
                  j = i;
                  localObject = paramAnonymousEditable;
                  if (n - (k - this.agWa) >= 0)
                  {
                    localObject = WalletFormView.bj(paramAnonymousEditable, n - (k - 7), n);
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
                if (m > this.agWa)
                {
                  j = i;
                  localObject = paramAnonymousEditable;
                  if (n >= 0)
                  {
                    j = i;
                    localObject = paramAnonymousEditable;
                    if (n - (m - this.agWa) >= 0)
                    {
                      localObject = WalletFormView.bj(paramAnonymousEditable, n - (m - this.agWa), n);
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
  
  public final void jPE()
  {
    AppMethodBeat.i(73195);
    if (this.agVJ != null)
    {
      this.agVJ.setFocusable(true);
      this.agVJ.requestFocus();
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.agVJ, 0);
    }
    AppMethodBeat.o(73195);
  }
  
  public final boolean mJ(View paramView)
  {
    AppMethodBeat.i(73192);
    if (getVisibility() == 0)
    {
      if (Util.isNullOrNil(getText()))
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.sUt != null) {
          this.sUt.setEnabled(true);
        }
        AppMethodBeat.o(73192);
        return false;
      }
      if (bZp())
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.sUt != null) {
          this.sUt.setEnabled(true);
        }
        AppMethodBeat.o(73192);
        return true;
      }
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      if (this.sUt != null) {
        this.sUt.setEnabled(false);
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
    jPC();
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.Nzn);
      getPrefilledTv().setVisibility(this.Nzo);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.Nzp);
      getInfoIv().setVisibility(this.Nzq);
      if (this.agVQ != -1) {
        getInfoIv().setmUserSetImageIconColor(this.agVQ);
      }
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.Nzr);
      getTipsTv().setVisibility(this.Nzs);
    }
    Object localObject = getContext();
    String str;
    if (this.agVJ != null) {
      if (this.agVV >= 0) {
        str = i.aGy(this.agVV);
      }
    }
    try
    {
      this.agVJ.setTypeface(Typeface.createFromAsset(((Context)localObject).getAssets(), str));
      if (this.agVR == -1)
      {
        this.agVJ.setHint(this.Nzt);
        this.agVJ.setGravity(this.Nzu);
        this.agVJ.setTextColor(this.Nzv);
        setText(this.Nzw);
        b.a(this.agVJ, this.agVS);
        this.agVJ.setBackgroundResource(this.Nzz);
        this.agVJ.setEnabled(this.NzA);
        this.agVJ.setFocusable(this.NzC);
        this.agVJ.setClickable(this.NzB);
        this.agVJ.setHintTextColor(this.NzF);
        setImeOptions(this.NzE);
        setInputType(this.NzD);
        this.agVJ.addTextChangedListener(new TextWatcher()
        {
          private boolean NzH = false;
          
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(73143);
            String str = paramAnonymousEditable.toString();
            if (str.startsWith(".")) {
              paramAnonymousEditable.insert(0, "0");
            }
            while ((!WalletFormView.i(WalletFormView.this)) || (!WalletFormView.a(str, WalletFormView.j(WalletFormView.this))))
            {
              boolean bool = WalletFormView.this.bZp();
              if (WalletFormView.k(WalletFormView.this) != null)
              {
                if (bool != this.NzH)
                {
                  WalletFormView.k(WalletFormView.this).onInputValidChange(bool);
                  this.NzH = WalletFormView.this.bZp();
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
              WalletFormView.h(WalletFormView.this).f(paramAnonymousCharSequence);
            }
            AppMethodBeat.o(73142);
          }
        });
        this.agVJ.setOnFocusChangeListener(this);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (!Util.isEqual(this.agVW, 0))
          {
            localObject = TextView.class.getDeclaredField("mCursorDrawableRes");
            ((Field)localObject).setAccessible(true);
            ((Field)localObject).set(this.agVJ, Integer.valueOf(this.agVW));
          }
          gGb();
          if (this.agVJ != null)
          {
            if (this.NzD != 2) {
              break;
            }
            this.agVJ.setKeyListener(new NumberKeyListener()
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
            if (this.Nzx != -1) {
              this.agVJ.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.Nzx) });
            }
          }
          AppMethodBeat.o(73164);
          return;
          localException1 = localException1;
          Log.e("MicroMsg.WalletFormView", "setTypeface() Exception:%s %s", new Object[] { localException1.getClass().getSimpleName(), localException1.getMessage() });
        }
        SpannableString localSpannableString = new SpannableString(this.Nzt + "  ");
        localSpannableString.setSpan(new com.tencent.mm.cg.a(this.agVR), 0, localSpannableString.length() - 2, 33);
        localSpannableString.setSpan(new AbsoluteSizeSpan((int)this.agVJ.getTextSize(), false), localSpannableString.length() - 2, localSpannableString.length(), 33);
        this.agVJ.setHint(new SpannedString(localSpannableString));
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.WalletFormView", "set textCursorDrawable fail!!");
          continue;
          if (this.NzD == 4)
          {
            this.agVJ.setKeyListener(new NumberKeyListener()
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
          else if (this.NzD == 128)
          {
            this.agVJ.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.agVJ.setKeyListener(new NumberKeyListener()
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
            this.agVJ.setRawInputType(18);
          }
          else if (this.NzD == 3)
          {
            this.agVJ.setKeyListener(new NumberKeyListener()
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
            this.agVJ.setInputType(this.NzD);
          }
        }
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(73198);
    if (this.Nzg != null) {
      this.Nzg.onFocusChange(this, paramBoolean);
    }
    if (this.agVL != null) {
      this.agVL.onInputValidChange(bZp());
    }
    if (!bZp()) {
      if (this.sUt != null) {
        this.sUt.setEnabled(false);
      }
    }
    for (;;)
    {
      gGb();
      AppMethodBeat.o(73198);
      return;
      if (this.sUt != null) {
        this.sUt.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(73171);
    if ((this.agVM == null) || (!this.agVM.jPG()))
    {
      if ((this.agVJ != null) && (k(this.agVJ, paramMotionEvent)) && (!this.agVJ.isClickable()))
      {
        Log.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(73171);
        return true;
      }
      if ((this.Nzd != null) && (this.Nzd.isClickable()) && (k(this.Nzd, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        Log.d("MicroMsg.WalletFormView", "hy: click on info iv");
        gGb();
        this.Nzd.performClick();
        AppMethodBeat.o(73171);
        return true;
      }
      AppMethodBeat.o(73171);
      return false;
    }
    AppMethodBeat.o(73171);
    return true;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73170);
    if ((this.agVM == null) || (!this.agVM.jPF())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(73170);
  }
  
  public final void set3DesToView(String paramString)
  {
    AppMethodBeat.i(73199);
    if (this.agVJ != null) {
      this.agVJ.set3DesEncrptData(paramString);
    }
    AppMethodBeat.o(73199);
  }
  
  public final void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(73151);
    if ((this.agVJ != null) && ((this.agVN == null) || (!this.agVN.b(this, paramString))))
    {
      this.agVJ.set3DesEncrptData(paramString);
      setSelection(getInputLength());
    }
    AppMethodBeat.o(73151);
  }
  
  public final void setBankcardTail(String paramString)
  {
    AppMethodBeat.i(73178);
    if (this.agVJ != null) {
      this.agVJ.setBankcardTailNum(paramString);
    }
    AppMethodBeat.o(73178);
  }
  
  public final void setContentClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(73166);
    if (this.agVJ != null) {
      this.agVJ.setClickable(paramBoolean);
    }
    AppMethodBeat.o(73166);
  }
  
  public final void setContentEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(73168);
    if (this.agVJ != null) {
      this.agVJ.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(73168);
  }
  
  public final void setContentFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(73167);
    if (this.agVJ != null) {
      this.agVJ.setFocusable(paramBoolean);
    }
    AppMethodBeat.o(73167);
  }
  
  public final void setContentTextColor(int paramInt)
  {
    AppMethodBeat.i(73159);
    if (this.agVJ != null) {
      this.agVJ.setTextColor(paramInt);
    }
    AppMethodBeat.o(73159);
  }
  
  public final void setContentTextColorRes(int paramInt)
  {
    AppMethodBeat.i(73158);
    this.Nzv = paramInt;
    if (this.agVJ != null) {
      this.agVJ.setTextColor(getResources().getColor(this.Nzv));
    }
    AppMethodBeat.o(73158);
  }
  
  public final void setEncryptType(int paramInt)
  {
    this.agVP = paramInt;
  }
  
  public final void setEventDelegate(com.tencent.mm.wallet_core.ui.formview.a.a parama)
  {
    this.agVM = parama;
  }
  
  public final void setFilterChar(char[] paramArrayOfChar) {}
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(73193);
    if (this.agVJ != null) {
      this.agVJ.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(73193);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(73165);
    if (this.agVJ != null)
    {
      if (this.agVR == -1)
      {
        this.agVJ.setHint(paramCharSequence);
        AppMethodBeat.o(73165);
        return;
      }
      paramCharSequence = new SpannableString(paramCharSequence);
      paramCharSequence.setSpan(new AbsoluteSizeSpan(this.agVR, false), 0, paramCharSequence.length(), 33);
      this.agVJ.setHint(new SpannedString(paramCharSequence));
    }
    AppMethodBeat.o(73165);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(73153);
    if (this.agVJ != null) {
      this.agVJ.setImeOptions(paramInt);
    }
    AppMethodBeat.o(73153);
  }
  
  public final void setInputEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(73156);
    if (this.agVJ != null) {
      this.agVJ.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(73156);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(73154);
    if (this.agVJ != null) {
      this.agVJ.setInputType(paramInt);
    }
    AppMethodBeat.o(73154);
  }
  
  public final void setIsSecretAnswer(boolean paramBoolean)
  {
    AppMethodBeat.i(73197);
    if (this.agVJ != null) {
      this.agVJ.setIsSecurityAnswerFormat(paramBoolean);
    }
    AppMethodBeat.o(73197);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(73188);
    if (this.agVJ != null) {
      this.agVJ.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(73188);
  }
  
  public final void setLogicDelegate(com.tencent.mm.wallet_core.ui.formview.a.b paramb)
  {
    this.agVN = paramb;
  }
  
  public final void setMaxInputLength(int paramInt)
  {
    this.Nzx = paramInt;
  }
  
  public final void setMinInputLength(int paramInt)
  {
    this.Nzy = paramInt;
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
    this.agVJ.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(73169);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.Nzg = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(73180);
    this.Nzh = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.Nzh);
    }
    AppMethodBeat.o(73180);
  }
  
  public final void setOnInputValidChangeListener(a parama)
  {
    this.agVL = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(73175);
    if (this.agVJ != null) {
      this.agVJ.setSelection(paramInt);
    }
    AppMethodBeat.o(73175);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(73155);
    if ((this.agVJ != null) && ((this.agVN == null) || (!this.agVN.a(this, paramString))))
    {
      this.agVJ.setText(paramString);
      this.agVJ.setSelection(getInputLength());
    }
    AppMethodBeat.o(73155);
  }
  
  public final void setTitleText(String paramString)
  {
    AppMethodBeat.i(73148);
    this.Nzl = paramString;
    jPC();
    AppMethodBeat.o(73148);
  }
  
  public final void setTitleWidth(int paramInt)
  {
    AppMethodBeat.i(182539);
    this.adZj = paramInt;
    if (this.adZj > 0)
    {
      ViewGroup.LayoutParams localLayoutParams = this.sUt.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = this.adZj;
        this.sUt.setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(182539);
  }
  
  public final void setmContentAbnormalMoneyCheck(boolean paramBoolean)
  {
    this.agVT = paramBoolean;
  }
  
  public final void setmWalletFormViewListener(c paramc)
  {
    this.agVI = paramc;
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
    public abstract void f(CharSequence paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.WalletFormView
 * JD-Core Version:    0.7.0.1
 */