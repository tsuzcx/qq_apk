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
import com.tencent.mm.wallet_core.ui.g;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.lang.reflect.Field;
import junit.framework.Assert;

public final class WalletFormView
  extends LinearLayout
  implements View.OnFocusChangeListener
{
  private WalletIconImageView HBA;
  private TextView HBB;
  private View.OnFocusChangeListener HBD;
  private View.OnClickListener HBE;
  private int HBH;
  private String HBI;
  private int HBJ;
  private String HBK;
  private int HBL;
  private int HBM;
  private int HBN;
  private String HBO;
  private int HBP;
  private String HBQ;
  private int HBR;
  private int HBS;
  private String HBT;
  private int HBU;
  private int HBV;
  private int HBW;
  private boolean HBX;
  private boolean HBY;
  private boolean HBZ;
  private TextView HBy;
  private int HCa;
  private int HCb;
  private int HCc;
  private int WrT;
  private c YXD;
  public TenpaySecureEditText YXE;
  private LinearLayout YXF;
  private WalletFormView.a YXG;
  private com.tencent.mm.wallet_core.ui.formview.a.a YXH;
  private com.tencent.mm.wallet_core.ui.formview.a.b YXI;
  private int YXJ;
  private int YXK;
  private int YXL;
  private int YXM;
  private int YXN;
  private boolean YXO;
  @Deprecated
  private int YXP;
  private int YXQ;
  private int YXR;
  private int YXS;
  private TextView mMy;
  private TextView pPT;
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletFormView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73147);
    this.pPT = null;
    this.HBy = null;
    this.YXE = null;
    this.HBA = null;
    this.HBB = null;
    this.YXG = null;
    this.HBD = null;
    this.HBE = null;
    this.YXH = null;
    this.YXI = null;
    this.HBH = -1;
    this.YXJ = this.HBH;
    this.YXK = 100;
    this.HBI = "";
    this.HBJ = 0;
    this.HBK = "";
    this.HBL = 8;
    this.HBM = -1;
    this.YXL = -1;
    this.HBN = 4;
    this.HBO = "";
    this.HBP = 8;
    this.HBQ = "";
    this.YXM = -1;
    this.HBR = 19;
    this.HBS = a.c.normal_text_color;
    this.HBT = "";
    this.YXN = 0;
    this.HBU = 2147483647;
    this.HBV = 1;
    this.HBW = a.e.mm_trans;
    this.HBX = true;
    this.HBY = false;
    this.HBZ = true;
    this.YXO = false;
    this.HCa = 1;
    this.HCb = 5;
    this.HCc = a.c.list_devider_color;
    this.YXP = 0;
    this.YXQ = 0;
    this.YXR = 0;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.WalletFormAttrs, paramInt, 0);
    this.HBH = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_layoutRes, this.HBH);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_titleText, 0);
    if (paramInt != 0) {
      this.HBI = paramContext.getString(paramInt);
    }
    this.WrT = paramAttributeSet.getDimensionPixelSize(a.k.WalletFormAttrs_titleWidth, -1);
    this.HBM = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_infoIvRes, this.HBM);
    this.YXL = paramAttributeSet.getColor(a.k.WalletFormAttrs_infoIvColorRes, this.YXL);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_tipsText, 0);
    if (paramInt != 0) {
      this.HBO = paramContext.getString(paramInt);
    }
    this.HBN = paramAttributeSet.getInteger(a.k.WalletFormAttrs_infoIvVisibility, this.HBN);
    this.HBJ = paramAttributeSet.getInteger(a.k.WalletFormAttrs_titleTvVisibility, this.HBJ);
    this.HBP = paramAttributeSet.getInteger(a.k.WalletFormAttrs_tipsTvVisibility, this.HBP);
    this.HBL = paramAttributeSet.getInteger(a.k.WalletFormAttrs_prefilledTvVisibility, this.HBL);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_prefilledText, 0);
    if (paramInt != 0) {
      this.HBK = paramContext.getString(paramInt);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_contentHint, 0);
    if (paramInt != 0) {
      this.HBQ = paramContext.getString(paramInt);
    }
    this.YXM = paramAttributeSet.getDimensionPixelSize(a.k.WalletFormAttrs_contentHintSize, -1);
    this.HBR = paramAttributeSet.getInteger(a.k.WalletFormAttrs_contentGravity, this.HBR);
    this.HBS = paramAttributeSet.getColor(a.k.WalletFormAttrs_contentTextColor, this.HBS);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_contentText, 0);
    if (paramInt != 0) {
      this.HBT = paramContext.getString(paramInt);
    }
    this.YXN = paramAttributeSet.getInt(a.k.WalletFormAttrs_contentFormat, this.YXN);
    this.HBU = paramAttributeSet.getInteger(a.k.WalletFormAttrs_contentMaxSize, this.HBU);
    this.HBV = paramAttributeSet.getInteger(a.k.WalletFormAttrs_contentMinSize, this.HBV);
    this.HBW = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_contentBackground, this.HBW);
    this.HBX = paramAttributeSet.getBoolean(a.k.WalletFormAttrs_contentEnabled, this.HBX);
    this.HBY = paramAttributeSet.getBoolean(a.k.WalletFormAttrs_contentClickable, this.HBY);
    this.HBZ = paramAttributeSet.getBoolean(a.k.WalletFormAttrs_contentEnabled, this.HBZ);
    this.HCa = paramAttributeSet.getInteger(a.k.WalletFormAttrs_android_inputType, this.HCa);
    this.HCb = paramAttributeSet.getInteger(a.k.WalletFormAttrs_android_imeOptions, this.HCb);
    this.YXK = paramAttributeSet.getInteger(a.k.WalletFormAttrs_encryptType, this.YXK);
    this.HCc = paramAttributeSet.getInteger(a.k.WalletFormAttrs_contentHintTextColor, this.HCc);
    this.YXJ = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_longTitleLayoutRes, this.YXJ);
    this.YXP = paramAttributeSet.getInteger(a.k.WalletFormAttrs_typeface, 0);
    this.YXQ = paramAttributeSet.getInteger(a.k.WalletFormAttrs_walletTypeFace, -1);
    if ((this.YXP == 1) && (this.YXQ == -1)) {
      this.YXQ = 4;
    }
    this.YXR = paramAttributeSet.getResourceId(a.k.WalletFormAttrs_android_textCursorDrawable, 0);
    paramAttributeSet.recycle();
    if (this.HBH > 0) {
      bool = true;
    }
    Assert.assertTrue(bool);
    setOrientation(1);
    if ((!Util.isNullOrNil(this.HBI)) && (this.HBI.length() > 6)) {
      inflate(paramContext, this.YXJ, this);
    }
    for (;;)
    {
      this.pPT = ((TextView)findViewById(a.f.wallet_title));
      this.HBy = ((TextView)findViewById(a.f.wallet_prefilled));
      this.YXE = ((TenpaySecureEditText)findViewById(a.f.wallet_content));
      this.HBA = ((WalletIconImageView)findViewById(a.f.wallet_info));
      this.HBB = ((TextView)findViewById(a.f.wallet_tips_msg));
      this.YXF = ((LinearLayout)findViewById(a.f.wallet_max_unit_layout));
      this.mMy = ((TextView)findViewById(a.f.wallet_max_unit_tv));
      AppMethodBeat.o(73147);
      return;
      inflate(paramContext, this.HBH, this);
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
    if (Util.isEqual(paramString1, paramString2))
    {
      AppMethodBeat.o(73185);
      return;
    }
    MMHandlerThread.postToMainThread(new WalletFormView.4(paramEditText, paramString2));
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
    paramString = Util.nullAs(str, "") + Util.nullAs(paramString, "");
    AppMethodBeat.o(73184);
    return paramString;
  }
  
  private boolean d(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(73172);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      if (fN(paramView).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
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
  
  private Rect fN(View paramView)
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
  
  private void fum()
  {
    AppMethodBeat.i(73160);
    if ((this.HBA != null) && (!Util.isNullOrNil(getText())) && (this.YXE != null) && (this.YXE.isEnabled()) && (this.YXE.isClickable()) && (this.YXE.isFocusable()) && (this.YXE.isFocused()))
    {
      this.HBA.setToClearState(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73144);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/wallet_core/ui/formview/WalletFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          WalletFormView.this.fuo();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/formview/WalletFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(73144);
        }
      });
      AppMethodBeat.o(73160);
      return;
    }
    if (this.HBA != null)
    {
      this.HBA.hoc();
      AppMethodBeat.o(73160);
      return;
    }
    Log.v("MicroMsg.WalletFormView", "hy: no info iv");
    AppMethodBeat.o(73160);
  }
  
  private Rect g(View paramView, Rect paramRect)
  {
    if (paramView == this.HBA)
    {
      paramRect.left -= 50;
      paramRect.right += 50;
      paramRect.top -= 25;
      paramRect.bottom += 25;
    }
    return paramRect;
  }
  
  private void ijC()
  {
    AppMethodBeat.i(73174);
    if (getTitleTv() != null)
    {
      getTitleTv().setText(this.HBI);
      getTitleTv().setVisibility(this.HBJ);
      setTitleWidth(this.WrT);
    }
    AppMethodBeat.o(73174);
  }
  
  public final void a(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(73182);
    if (this.YXE != null) {
      this.YXE.addTextChangedListener(paramTextWatcher);
    }
    AppMethodBeat.o(73182);
  }
  
  public final void azN(int paramInt)
  {
    AppMethodBeat.i(163889);
    if (this.YXE != null) {
      this.YXE.setPadding(paramInt, 0, 0, 0);
    }
    AppMethodBeat.o(163889);
  }
  
  public final boolean bAz()
  {
    AppMethodBeat.i(73189);
    if (this.YXE != null)
    {
      int i = this.YXE.getInputLength();
      if ((i > this.HBU) || (i < this.HBV))
      {
        AppMethodBeat.o(73189);
        return false;
      }
      if (this.YXI != null)
      {
        boolean bool = this.YXI.a(this);
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
    if (this.YXE != null)
    {
      this.YXE.setFocusable(true);
      this.YXE.requestFocus();
      paramWalletBaseUI.showTenpayKB();
    }
    AppMethodBeat.o(73196);
  }
  
  public final void fun()
  {
    AppMethodBeat.i(73191);
    if (this.YXE != null) {
      this.YXE.clearFocus();
    }
    AppMethodBeat.o(73191);
  }
  
  public final void fuo()
  {
    AppMethodBeat.i(73190);
    if (this.YXE != null) {
      this.YXE.ClearInput();
    }
    AppMethodBeat.o(73190);
  }
  
  public final EditText getContentEt()
  {
    return this.YXE;
  }
  
  public final int getEncrptType()
  {
    return this.YXK;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.a getEventDelegate()
  {
    return this.YXH;
  }
  
  public final WalletIconImageView getInfoIv()
  {
    return this.HBA;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(73194);
    if (this.YXE != null)
    {
      int i = this.YXE.getInputLength();
      AppMethodBeat.o(73194);
      return i;
    }
    AppMethodBeat.o(73194);
    return 0;
  }
  
  public final WalletFormView.a getInputValidChangeListener()
  {
    return this.YXG;
  }
  
  public final KeyListener getKeyListener()
  {
    AppMethodBeat.i(73177);
    if (this.YXE != null)
    {
      KeyListener localKeyListener = this.YXE.getKeyListener();
      AppMethodBeat.o(73177);
      return localKeyListener;
    }
    Log.w("MicroMsg.WalletFormView", "hy: no content et");
    AppMethodBeat.o(73177);
    return null;
  }
  
  public final com.tencent.mm.wallet_core.ui.formview.a.b getLogicDelegate()
  {
    return this.YXI;
  }
  
  public final String getMD5Value()
  {
    AppMethodBeat.i(73152);
    String str2 = Util.nullAsNil(this.YXE.getText().toString());
    String str1 = str2;
    if (this.YXI != null)
    {
      str1 = str2;
      if (this.YXI.ful()) {
        str1 = this.YXI.c(this, str2);
      }
    }
    str1 = MD5Util.getMD5String(str1);
    AppMethodBeat.o(73152);
    return str1;
  }
  
  public final int getMaxInputLength()
  {
    return this.HBU;
  }
  
  public final int getMinInputLength()
  {
    return this.HBV;
  }
  
  public final TextView getPrefilledTv()
  {
    return this.HBy;
  }
  
  public final int getSelectionStart()
  {
    AppMethodBeat.i(73157);
    if (this.YXE != null)
    {
      int i = this.YXE.getSelectionStart();
      AppMethodBeat.o(73157);
      return i;
    }
    AppMethodBeat.o(73157);
    return -1;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(73176);
    if (this.YXE != null)
    {
      String str = c.a.a(this.YXK, this.YXE);
      if ((this.YXI != null) && (this.YXI.ful()))
      {
        str = this.YXI.c(this, str);
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
    return this.HBB;
  }
  
  public final float getTitleMeasuredWidth()
  {
    AppMethodBeat.i(182538);
    float f = this.pPT.getPaint().measureText(this.pPT.getText(), 0, this.pPT.getText().length());
    AppMethodBeat.o(182538);
    return f;
  }
  
  public final TextView getTitleTv()
  {
    return this.pPT;
  }
  
  public final boolean ijB()
  {
    AppMethodBeat.i(73161);
    if (this.YXE != null)
    {
      boolean bool = this.YXE.isFocusable();
      AppMethodBeat.o(73161);
      return bool;
    }
    AppMethodBeat.o(73161);
    return false;
  }
  
  public final void ijD()
  {
    AppMethodBeat.i(73183);
    if (this.YXE != null) {
      this.YXE.addTextChangedListener(new TextWatcher()
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
          if ((this.YXU >= 0) && (k >= 0) && (m - k > this.YXU))
          {
            paramAnonymousEditable = WalletFormView.aZ(str, this.YXU + k + 1, m);
            i = 1;
          }
          for (;;)
          {
            int j = i;
            Object localObject = paramAnonymousEditable;
            int n;
            if (this.YXV >= 0)
            {
              n = WalletFormView.j(WalletFormView.this).getSelectionStart();
              if (k <= this.YXV) {
                break label236;
              }
              j = i;
              localObject = paramAnonymousEditable;
              if (!Util.isEqual(n, -1))
              {
                j = i;
                localObject = paramAnonymousEditable;
                if (k - this.YXV > 0)
                {
                  j = i;
                  localObject = paramAnonymousEditable;
                  if (n - (k - this.YXV) >= 0)
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
              if (Util.isEqual(k, -1))
              {
                j = i;
                localObject = paramAnonymousEditable;
                if (m > this.YXV)
                {
                  j = i;
                  localObject = paramAnonymousEditable;
                  if (n >= 0)
                  {
                    j = i;
                    localObject = paramAnonymousEditable;
                    if (n - (m - this.YXV) >= 0)
                    {
                      localObject = WalletFormView.aZ(paramAnonymousEditable, n - (m - this.YXV), n);
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
  
  public final void ijE()
  {
    AppMethodBeat.i(73195);
    if (this.YXE != null)
    {
      this.YXE.setFocusable(true);
      this.YXE.requestFocus();
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.YXE, 0);
    }
    AppMethodBeat.o(73195);
  }
  
  public final boolean isPhoneNum()
  {
    AppMethodBeat.i(73181);
    if (this.YXE == null)
    {
      AppMethodBeat.o(73181);
      return false;
    }
    boolean bool = this.YXE.isPhoneNum();
    AppMethodBeat.o(73181);
    return bool;
  }
  
  public final boolean jf(View paramView)
  {
    AppMethodBeat.i(73192);
    if (getVisibility() == 0)
    {
      if (Util.isNullOrNil(getText()))
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.pPT != null) {
          this.pPT.setEnabled(true);
        }
        AppMethodBeat.o(73192);
        return false;
      }
      if (bAz())
      {
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        if (this.pPT != null) {
          this.pPT.setEnabled(true);
        }
        AppMethodBeat.o(73192);
        return true;
      }
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      if (this.pPT != null) {
        this.pPT.setEnabled(false);
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
  
  public final int k(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73149);
    if (this.YXS == 0)
    {
      int i = this.pPT.getLeft();
      this.YXS = (this.YXE.getLeft() - i + this.YXE.getPaddingLeft());
      Log.d("MicroMsg.WalletFormView", "mMaxUnitLeftOriginWidth:%s", new Object[] { Integer.valueOf(this.YXS) });
    }
    if (!Util.isEqual(paramCharSequence.toString(), ""))
    {
      if (paramInt2 == 1) {}
      for (float f1 = this.YXE.getPaint().measureText("1");; f1 = this.YXE.getPaint().measureText("2"))
      {
        float f2 = this.YXS;
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
    ijC();
    if (getPrefilledTv() != null)
    {
      getPrefilledTv().setText(this.HBK);
      getPrefilledTv().setVisibility(this.HBL);
    }
    if (getInfoIv() != null)
    {
      getInfoIv().setImageResource(this.HBM);
      getInfoIv().setVisibility(this.HBN);
      if (this.YXL != -1) {
        getInfoIv().setmUserSetImageIconColor(this.YXL);
      }
    }
    if (getTipsTv() != null)
    {
      getTipsTv().setText(this.HBO);
      getTipsTv().setVisibility(this.HBP);
    }
    Object localObject = getContext();
    String str;
    if (this.YXE != null) {
      if (this.YXQ >= 0) {
        str = g.azI(this.YXQ);
      }
    }
    try
    {
      this.YXE.setTypeface(Typeface.createFromAsset(((Context)localObject).getAssets(), str));
      if (this.YXM == -1)
      {
        this.YXE.setHint(this.HBQ);
        this.YXE.setGravity(this.HBR);
        this.YXE.setTextColor(this.HBS);
        setText(this.HBT);
        b.a(this.YXE, this.YXN);
        this.YXE.setBackgroundResource(this.HBW);
        this.YXE.setEnabled(this.HBX);
        this.YXE.setFocusable(this.HBZ);
        this.YXE.setClickable(this.HBY);
        this.YXE.setHintTextColor(this.HCc);
        setImeOptions(this.HCb);
        setInputType(this.HCa);
        this.YXE.addTextChangedListener(new TextWatcher()
        {
          private boolean HCe = false;
          
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(73143);
            String str = paramAnonymousEditable.toString();
            if (str.startsWith(".")) {
              paramAnonymousEditable.insert(0, "0");
            }
            while ((!WalletFormView.i(WalletFormView.this)) || (!WalletFormView.a(str, WalletFormView.j(WalletFormView.this))))
            {
              boolean bool = WalletFormView.this.bAz();
              if (WalletFormView.k(WalletFormView.this) != null)
              {
                if (bool != this.HCe)
                {
                  WalletFormView.k(WalletFormView.this).onInputValidChange(bool);
                  this.HCe = WalletFormView.this.bAz();
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
        this.YXE.setOnFocusChangeListener(this);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (!Util.isEqual(this.YXR, 0))
          {
            localObject = TextView.class.getDeclaredField("mCursorDrawableRes");
            ((Field)localObject).setAccessible(true);
            ((Field)localObject).set(this.YXE, Integer.valueOf(this.YXR));
          }
          fum();
          if (this.YXE != null)
          {
            if (this.HCa != 2) {
              break;
            }
            this.YXE.setKeyListener(new NumberKeyListener()
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
            if (this.HBU != -1) {
              this.YXE.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.HBU) });
            }
          }
          AppMethodBeat.o(73164);
          return;
          localException1 = localException1;
          Log.e("MicroMsg.WalletFormView", "setTypeface() Exception:%s %s", new Object[] { localException1.getClass().getSimpleName(), localException1.getMessage() });
        }
        SpannableString localSpannableString = new SpannableString(this.HBQ + "  ");
        localSpannableString.setSpan(new com.tencent.mm.cm.a(this.YXM), 0, localSpannableString.length() - 2, 33);
        localSpannableString.setSpan(new AbsoluteSizeSpan((int)this.YXE.getTextSize(), false), localSpannableString.length() - 2, localSpannableString.length(), 33);
        this.YXE.setHint(new SpannedString(localSpannableString));
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.WalletFormView", "set textCursorDrawable fail!!");
          continue;
          if (this.HCa == 4)
          {
            this.YXE.setKeyListener(new NumberKeyListener()
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
          else if (this.HCa == 128)
          {
            this.YXE.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.YXE.setKeyListener(new NumberKeyListener()
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
            this.YXE.setRawInputType(18);
          }
          else if (this.HCa == 3)
          {
            this.YXE.setKeyListener(new NumberKeyListener()
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
            this.YXE.setInputType(this.HCa);
          }
        }
      }
    }
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(73198);
    if (this.HBD != null) {
      this.HBD.onFocusChange(this, paramBoolean);
    }
    if (this.YXG != null) {
      this.YXG.onInputValidChange(bAz());
    }
    if (!bAz()) {
      if (this.pPT != null) {
        this.pPT.setEnabled(false);
      }
    }
    for (;;)
    {
      fum();
      AppMethodBeat.o(73198);
      return;
      if (this.pPT != null) {
        this.pPT.setEnabled(true);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(73171);
    if ((this.YXH == null) || (!this.YXH.ijG()))
    {
      if ((this.YXE != null) && (d(this.YXE, paramMotionEvent)) && (!this.YXE.isClickable()))
      {
        Log.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
        AppMethodBeat.o(73171);
        return true;
      }
      if ((this.HBA != null) && (this.HBA.isClickable()) && (d(this.HBA, paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      {
        Log.d("MicroMsg.WalletFormView", "hy: click on info iv");
        fum();
        this.HBA.performClick();
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
    if ((this.YXH == null) || (!this.YXH.ijF())) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(73170);
  }
  
  public final void set3DesToView(String paramString)
  {
    AppMethodBeat.i(73199);
    if (this.YXE != null) {
      this.YXE.set3DesEncrptData(paramString);
    }
    AppMethodBeat.o(73199);
  }
  
  public final void set3DesValStr(String paramString)
  {
    AppMethodBeat.i(73151);
    if ((this.YXE != null) && ((this.YXI == null) || (!this.YXI.b(this, paramString))))
    {
      this.YXE.set3DesEncrptData(paramString);
      setSelection(getInputLength());
    }
    AppMethodBeat.o(73151);
  }
  
  public final void setBankcardTail(String paramString)
  {
    AppMethodBeat.i(73178);
    if (this.YXE != null) {
      this.YXE.setBankcardTailNum(paramString);
    }
    AppMethodBeat.o(73178);
  }
  
  public final void setContentClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(73166);
    if (this.YXE != null) {
      this.YXE.setClickable(paramBoolean);
    }
    AppMethodBeat.o(73166);
  }
  
  public final void setContentEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(73168);
    if (this.YXE != null) {
      this.YXE.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(73168);
  }
  
  public final void setContentFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(73167);
    if (this.YXE != null) {
      this.YXE.setFocusable(paramBoolean);
    }
    AppMethodBeat.o(73167);
  }
  
  public final void setContentTextColor(int paramInt)
  {
    AppMethodBeat.i(73159);
    if (this.YXE != null) {
      this.YXE.setTextColor(paramInt);
    }
    AppMethodBeat.o(73159);
  }
  
  @SuppressLint({"ResourceType"})
  public final void setContentTextColorRes(int paramInt)
  {
    AppMethodBeat.i(73158);
    this.HBS = paramInt;
    if (this.YXE != null) {
      this.YXE.setTextColor(getResources().getColor(this.HBS));
    }
    AppMethodBeat.o(73158);
  }
  
  public final void setEncryptType(int paramInt)
  {
    this.YXK = paramInt;
  }
  
  public final void setEventDelegate(com.tencent.mm.wallet_core.ui.formview.a.a parama)
  {
    this.YXH = parama;
  }
  
  public final void setFilterChar(char[] paramArrayOfChar) {}
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(73193);
    if (this.YXE != null) {
      this.YXE.setFilters(paramArrayOfInputFilter);
    }
    AppMethodBeat.o(73193);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(73165);
    if (this.YXE != null)
    {
      if (this.YXM == -1)
      {
        this.YXE.setHint(paramCharSequence);
        AppMethodBeat.o(73165);
        return;
      }
      paramCharSequence = new SpannableString(paramCharSequence);
      paramCharSequence.setSpan(new AbsoluteSizeSpan(this.YXM, false), 0, paramCharSequence.length(), 33);
      this.YXE.setHint(new SpannedString(paramCharSequence));
    }
    AppMethodBeat.o(73165);
  }
  
  public final void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(73153);
    if (this.YXE != null) {
      this.YXE.setImeOptions(paramInt);
    }
    AppMethodBeat.o(73153);
  }
  
  public final void setInputEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(73156);
    if (this.YXE != null) {
      this.YXE.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(73156);
  }
  
  public final void setInputType(int paramInt)
  {
    AppMethodBeat.i(73154);
    if (this.YXE != null) {
      this.YXE.setInputType(paramInt);
    }
    AppMethodBeat.o(73154);
  }
  
  public final void setIsSecretAnswer(boolean paramBoolean)
  {
    AppMethodBeat.i(73197);
    if (this.YXE != null) {
      this.YXE.setIsSecurityAnswerFormat(paramBoolean);
    }
    AppMethodBeat.o(73197);
  }
  
  public final void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(73188);
    if (this.YXE != null) {
      this.YXE.setKeyListener(paramKeyListener);
    }
    AppMethodBeat.o(73188);
  }
  
  public final void setLogicDelegate(com.tencent.mm.wallet_core.ui.formview.a.b paramb)
  {
    this.YXI = paramb;
  }
  
  public final void setMaxInputLength(int paramInt)
  {
    this.HBU = paramInt;
  }
  
  public final void setMinInputLength(int paramInt)
  {
    this.HBV = paramInt;
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
    this.YXE.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(73169);
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.HBD = paramOnFocusChangeListener;
  }
  
  public final void setOnInfoIvClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(73180);
    this.HBE = paramOnClickListener;
    if (getInfoIv() != null) {
      getInfoIv().setOnClickListener(this.HBE);
    }
    AppMethodBeat.o(73180);
  }
  
  public final void setOnInputValidChangeListener(WalletFormView.a parama)
  {
    this.YXG = parama;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(73175);
    if (this.YXE != null) {
      this.YXE.setSelection(paramInt);
    }
    AppMethodBeat.o(73175);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(73155);
    if ((this.YXE != null) && ((this.YXI == null) || (!this.YXI.a(this, paramString))))
    {
      this.YXE.setText(paramString);
      this.YXE.setSelection(getInputLength());
    }
    AppMethodBeat.o(73155);
  }
  
  public final void setTitleText(String paramString)
  {
    AppMethodBeat.i(73148);
    this.HBI = paramString;
    ijC();
    AppMethodBeat.o(73148);
  }
  
  public final void setTitleWidth(int paramInt)
  {
    AppMethodBeat.i(182539);
    this.WrT = paramInt;
    if (this.WrT > 0)
    {
      ViewGroup.LayoutParams localLayoutParams = this.pPT.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = this.WrT;
        this.pPT.setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(182539);
  }
  
  public final void setmContentAbnormalMoneyCheck(boolean paramBoolean)
  {
    this.YXO = paramBoolean;
  }
  
  public final void setmWalletFormViewListener(c paramc)
  {
    this.YXD = paramc;
  }
  
  public static abstract interface b
    extends WalletFormView.a
  {}
  
  public static abstract interface c
  {
    public abstract void f(CharSequence paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.WalletFormView
 * JD-Core Version:    0.7.0.1
 */