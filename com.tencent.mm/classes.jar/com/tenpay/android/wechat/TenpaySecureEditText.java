package com.tenpay.android.wechat;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ao;
import com.tenpay.ndk.Encrypt;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TenpaySecureEditText
  extends EditText
{
  public static final int AREA_ID_CARD_TYPE_HUIXIANG = 5;
  public static final int AREA_ID_CARD_TYPE_SHENFEN = 1;
  public static final int AREA_ID_CARD_TYPE_TAIBAO = 9;
  private static int BANK_CARD_LENGTH_LIMIT = 14;
  private static int CARD_TAIL_SPACE = 15;
  private static int CVV_4_PAYMENT_LENGTH;
  private static int CVV_PAYMENT_LENGTH;
  private static int PASSWD_BLACK_DOT_SIZE = 7;
  private static int PASSWD_LEFT_PADDING = -1500000;
  private static int PASSWD_LENGTH = 6;
  private static int VALID_THRU_LEN = 4;
  private static String mTimeStamp;
  private String mCardTailNum;
  private Drawable mClearBtnImg;
  private float mDensity;
  EditState mEditState;
  private char[] mFilterChar;
  private String mFixedHeaderText;
  private Paint mIDCardPaint;
  private ISecureEncrypt mIEncrypt;
  private boolean mIsCardTailNumCanDisplay;
  private boolean mIsSelfSet;
  private boolean mIsUseOfKinda;
  private IKindaEditTextCallBackListener mKindaEditTextCallBackListener;
  private boolean mNewPwdStyle;
  private Paint mPaintBackground;
  private Paint mPasswdBgPaint;
  private OnPasswdInputListener mPasswdListener;
  private Paint mPasswdSeparedPaint;
  private Paint mTitlePaint;
  
  static
  {
    CVV_PAYMENT_LENGTH = 3;
    CVV_4_PAYMENT_LENGTH = 4;
  }
  
  public TenpaySecureEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TenpaySecureEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73210);
    this.mEditState = EditState.DEFAULT;
    this.mNewPwdStyle = true;
    this.mIEncrypt = new TenpaySecureEncrypt();
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(73210);
  }
  
  public TenpaySecureEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73211);
    this.mEditState = EditState.DEFAULT;
    this.mNewPwdStyle = true;
    this.mIEncrypt = new TenpaySecureEncrypt();
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(73211);
  }
  
  private void drawCardTailNum(Canvas paramCanvas)
  {
    AppMethodBeat.i(73228);
    if ((EditState.BANKCARD_WITH_TAILNUM == this.mEditState) && (this.mIsCardTailNumCanDisplay))
    {
      int j = getBaseline();
      int i = j;
      if (j == -1) {
        i = 44;
      }
      paramCanvas.drawText(this.mCardTailNum, CARD_TAIL_SPACE * this.mDensity + getPaint().measureText(getText().toString()), i, this.mTitlePaint);
    }
    AppMethodBeat.o(73228);
  }
  
  private void drawCvv4PaymentDot(Canvas paramCanvas)
  {
    AppMethodBeat.i(73227);
    if ((EditState.CVV_4_PAYMENT == this.mEditState) && (this.mPaintBackground != null))
    {
      int i = getWidth();
      int j = getHeight();
      int k = i / CVV_4_PAYMENT_LENGTH;
      int m = getText().length();
      i = 0;
      while (i < m)
      {
        paramCanvas.drawCircle(k / 2 + i * k, j / 2, PASSWD_BLACK_DOT_SIZE * this.mDensity, this.mPaintBackground);
        i += 1;
      }
    }
    AppMethodBeat.o(73227);
  }
  
  private void drawCvvPaymentDot(Canvas paramCanvas)
  {
    AppMethodBeat.i(73226);
    if ((EditState.CVV_PAYMENT == this.mEditState) && (this.mPaintBackground != null))
    {
      int i = getWidth();
      int j = getHeight();
      int k = i / CVV_PAYMENT_LENGTH;
      int m = getText().length();
      i = 0;
      while (i < m)
      {
        paramCanvas.drawCircle(k / 2 + i * k, j / 2, PASSWD_BLACK_DOT_SIZE * this.mDensity, this.mPaintBackground);
        i += 1;
      }
    }
    AppMethodBeat.o(73226);
  }
  
  private void drawIdCardTail(Canvas paramCanvas)
  {
    AppMethodBeat.i(73224);
    if ((EditState.IDCARD_TAIL == this.mEditState) && (this.mIDCardPaint != null))
    {
      int j = getWidth() / 4;
      String str = getText().toString();
      int k = str.length();
      this.mIDCardPaint.setTextSize(getTextSize());
      int i = 0;
      while (i < k)
      {
        paramCanvas.drawText(str.substring(i, i + 1), j / 2 + i * j, getBaseline(), this.mIDCardPaint);
        i += 1;
      }
    }
    AppMethodBeat.o(73224);
  }
  
  private void drawPasswdDot(Canvas paramCanvas)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(73225);
    if ((EditState.PASSWORD == this.mEditState) && (this.mPaintBackground != null))
    {
      int m = getWidth();
      int k = getHeight();
      m /= PASSWD_LENGTH;
      int n = getText().length();
      if (!this.mNewPwdStyle)
      {
        i = j;
        while (i < n)
        {
          paramCanvas.drawCircle(m / 2 + i * m, k / 2, PASSWD_BLACK_DOT_SIZE * this.mDensity, this.mPaintBackground);
          i += 1;
        }
        i = 1;
        while (i < PASSWD_LENGTH)
        {
          paramCanvas.drawLine(m * i, 0.0F, m * i, k, this.mPasswdSeparedPaint);
          i += 1;
        }
        AppMethodBeat.o(73225);
        return;
      }
      j = a.fromDPToPix(getContext(), 8);
      while (i < PASSWD_LENGTH)
      {
        float f1 = (k + j) * i;
        float f2 = k + f1;
        RectF localRectF = new RectF(f1, 0.0F, f2, k);
        float f3 = a.fromDPToPix(getContext(), 4);
        paramCanvas.drawRoundRect(localRectF, f3, f3, this.mPasswdBgPaint);
        if (i < n) {
          paramCanvas.drawCircle((f1 + f2) / 2.0F, k / 2.0F, PASSWD_BLACK_DOT_SIZE * this.mDensity, this.mPaintBackground);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(73225);
  }
  
  private String getInputText()
  {
    AppMethodBeat.i(73232);
    if (this.mEditState == EditState.SECURITY_ANSWER) {}
    for (String str2 = getText().toString(); (str2 == null) || (str2.length() == 0); str2 = getText().toString().trim())
    {
      AppMethodBeat.o(73232);
      return null;
    }
    String str1 = str2;
    switch (6.$SwitchMap$com$tenpay$android$wechat$TenpaySecureEditText$EditState[this.mEditState.ordinal()])
    {
    default: 
      str1 = str2.replaceAll(" ", "").replaceAll("x", "X");
    }
    for (;;)
    {
      AppMethodBeat.o(73232);
      return str1;
      str1 = str2.replaceAll(" ", "");
      continue;
      str2 = str2.replaceAll(" ", "");
      str1 = str2;
      if (this.mCardTailNum != null)
      {
        str1 = str2;
        if (this.mCardTailNum.length() > 0)
        {
          str1 = str2 + this.mCardTailNum;
          continue;
          str2 = str2.replaceAll("/", "");
          str1 = str2;
          if (str2 != null)
          {
            str1 = str2;
            if (str2.length() == VALID_THRU_LEN)
            {
              str1 = str2.substring(0, 2);
              str2 = str2.substring(2);
              str1 = str2 + str1;
            }
          }
        }
      }
    }
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(73212);
    this.mDensity = getResources().getDisplayMetrics().density;
    if (paramAttributeSet != null)
    {
      int[] arrayOfInt = TenpayUtil.getResourceDeclareStyleableIntArray(paramContext, "TenpaySecureEditText");
      if (arrayOfInt != null)
      {
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
        if (paramAttributeSet != null)
        {
          setIsPasswordFormat(paramAttributeSet.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(paramContext, "TenpaySecureEditText_isPassword"), false), true);
          setIsBankcardFormat(paramAttributeSet.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(paramContext, "TenpaySecureEditText_isBankcard"), false));
          setIsValidThru(paramAttributeSet.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(paramContext, "TenpaySecureEditText_isValidThru"), false));
          setBankcardTailNum(paramAttributeSet.getString(TenpayUtil.getResourceDeclareStyleableIndex(paramContext, "TenpaySecureEditText_bankcardTailNum")));
          int i = paramAttributeSet.getResourceId(TenpayUtil.getResourceDeclareStyleableIndex(paramContext, "TenpaySecureEditText_rightClearDrawable"), 0);
          if (i != 0) {
            setClearBtnDrawableId(i);
          }
          paramAttributeSet.recycle();
        }
      }
    }
    addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    AppMethodBeat.o(73212);
  }
  
  private boolean isMatchPattern(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73246);
    if (paramString2 != null) {
      try
      {
        boolean bool = Pattern.compile(paramString2).matcher(paramString1).matches();
        AppMethodBeat.o(73246);
        return bool;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(73246);
        return false;
      }
    }
    AppMethodBeat.o(73246);
    return false;
  }
  
  public static void setSalt(String paramString)
  {
    AppMethodBeat.i(73231);
    ad.i("TenpaySecureEditText", "check salt: %s", new Object[] { paramString });
    if ((Integer.decode(h.glW).intValue() & 0xFF) < 48) {
      ad.i("TenpaySecureEditText", "check salt stack: %s", new Object[] { bt.eGN() });
    }
    mTimeStamp = paramString;
    AppMethodBeat.o(73231);
  }
  
  public final void ClearInput()
  {
    AppMethodBeat.i(73247);
    setText("");
    AppMethodBeat.o(73247);
  }
  
  public final String get3DesEncrptData()
  {
    AppMethodBeat.i(73235);
    String str = getInputText();
    if ((str == null) || (str.length() == 0))
    {
      AppMethodBeat.o(73235);
      return null;
    }
    if (this.mIEncrypt != null)
    {
      str = this.mIEncrypt.desedeEncode(str, mTimeStamp);
      AppMethodBeat.o(73235);
      return str;
    }
    str = new Encrypt().desedeEncode(str);
    AppMethodBeat.o(73235);
    return str;
  }
  
  public final String get3DesEncrptData(String paramString)
  {
    AppMethodBeat.i(73236);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(73236);
      return null;
    }
    if (this.mIEncrypt != null)
    {
      paramString = this.mIEncrypt.desedeEncode(paramString, mTimeStamp);
      AppMethodBeat.o(73236);
      return paramString;
    }
    paramString = new Encrypt().desedeEncode(paramString);
    AppMethodBeat.o(73236);
    return paramString;
  }
  
  public final String get3DesVerifyCode()
  {
    AppMethodBeat.i(73238);
    String str = getInputText();
    if ((str == null) || (str.length() == 0))
    {
      AppMethodBeat.o(73238);
      return null;
    }
    if (this.mIEncrypt != null)
    {
      str = this.mIEncrypt.desedeVerifyCode(str, mTimeStamp);
      AppMethodBeat.o(73238);
      return str;
    }
    str = new Encrypt().desedeVerifyCode(str);
    AppMethodBeat.o(73238);
    return str;
  }
  
  public final Drawable getClearBtnDrawable()
  {
    return this.mClearBtnImg;
  }
  
  public final EditState getEditState()
  {
    return this.mEditState;
  }
  
  public final String getEncryptDataWithHash(boolean paramBoolean)
  {
    AppMethodBeat.i(73233);
    String str = getEncryptDataWithHash(paramBoolean, false);
    AppMethodBeat.o(73233);
    return str;
  }
  
  public final String getEncryptDataWithHash(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(73234);
    Object localObject2 = getInputText();
    if ((localObject2 == null) || (((String)localObject2).length() == 0))
    {
      AppMethodBeat.o(73234);
      return null;
    }
    ad.i("TenpaySecureEditText", "timestamp: %s, 2048: %s", new Object[] { mTimeStamp, Boolean.valueOf(paramBoolean2) });
    if (this.mIEncrypt != null)
    {
      if (paramBoolean2)
      {
        localObject1 = this.mIEncrypt.encryptPasswdWithRSA2048(paramBoolean1, (String)localObject2, mTimeStamp);
        AppMethodBeat.o(73234);
        return localObject1;
      }
      localObject1 = this.mIEncrypt.encryptPasswd(paramBoolean1, (String)localObject2, mTimeStamp);
      AppMethodBeat.o(73234);
      return localObject1;
    }
    Object localObject1 = localObject2;
    if (paramBoolean1) {
      localObject1 = TenpayUtil.md5HexDigest((String)localObject2);
    }
    localObject2 = new Encrypt();
    if (mTimeStamp != null) {
      ((Encrypt)localObject2).setTimeStamp(mTimeStamp);
    }
    if (paramBoolean2)
    {
      localObject1 = ((Encrypt)localObject2).encryptPasswdWithRSA2048((String)localObject1);
      AppMethodBeat.o(73234);
      return localObject1;
    }
    localObject1 = ((Encrypt)localObject2).encryptPasswd((String)localObject1);
    AppMethodBeat.o(73234);
    return localObject1;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(73248);
    String str = getInputText();
    if (str == null)
    {
      AppMethodBeat.o(73248);
      return 0;
    }
    int i = str.length();
    AppMethodBeat.o(73248);
    return i;
  }
  
  public final boolean isAreaIDCardNum(int paramInt)
  {
    AppMethodBeat.i(73244);
    String str = getText().toString().trim();
    if ((str == null) || (str.length() == 0))
    {
      AppMethodBeat.o(73244);
      return false;
    }
    str.replaceAll(" ", "");
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(73244);
      return true;
    }
    boolean bool = isUserIdNum();
    AppMethodBeat.o(73244);
    return bool;
  }
  
  public final boolean isBankcardNum()
  {
    AppMethodBeat.i(73240);
    if ((getInputLength() >= BANK_CARD_LENGTH_LIMIT) || (getText().toString().contains("**")))
    {
      AppMethodBeat.o(73240);
      return true;
    }
    AppMethodBeat.o(73240);
    return false;
  }
  
  public final boolean isMatchPattern(String paramString)
  {
    AppMethodBeat.i(73245);
    if (paramString != null) {
      try
      {
        String str = getInputText();
        boolean bool = Pattern.compile(paramString).matcher(str).matches();
        AppMethodBeat.o(73245);
        return bool;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(73245);
        return false;
      }
    }
    AppMethodBeat.o(73245);
    return false;
  }
  
  public final boolean isMoneyAmount()
  {
    AppMethodBeat.i(73241);
    boolean bool = isMatchPattern("^\\d+(\\.\\d{0,2})?$");
    AppMethodBeat.o(73241);
    return bool;
  }
  
  public final boolean isPhoneNum()
  {
    AppMethodBeat.i(73239);
    if (getText().toString().trim().length() == 11)
    {
      AppMethodBeat.o(73239);
      return true;
    }
    if (getText().toString().contains("**"))
    {
      AppMethodBeat.o(73239);
      return true;
    }
    AppMethodBeat.o(73239);
    return false;
  }
  
  public final boolean isUserIdNum()
  {
    AppMethodBeat.i(73242);
    String str = getText().toString().trim();
    if (getInputLength() == 15)
    {
      bool = isMatchPattern("^\\d{15}$");
      AppMethodBeat.o(73242);
      return bool;
    }
    boolean bool = TenpayUtil.invalidateID(str);
    AppMethodBeat.o(73242);
    return bool;
  }
  
  public final boolean isValidThru()
  {
    AppMethodBeat.i(73243);
    boolean bool = isMatchPattern("[1-9][0-9]0[1-9]$|[1-9][0-9]1[0-2]$");
    AppMethodBeat.o(73243);
    return bool;
  }
  
  protected final void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    AppMethodBeat.i(73230);
    if (((getInputType() & 0x80) <= 0) && (EditState.PASSWORD != this.mEditState) && (EditState.CVV_PAYMENT != this.mEditState) && (EditState.CVV_4_PAYMENT != this.mEditState)) {
      super.onCreateContextMenu(paramContextMenu);
    }
    AppMethodBeat.o(73230);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(73223);
    if (this.mEditState == EditState.IDCARD_TAIL) {
      drawIdCardTail(paramCanvas);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.mFixedHeaderText)) {
        paramCanvas.drawText(this.mFixedHeaderText, 0.0F, (getMeasuredHeight() - getTextSize()) / 2.0F + getTextSize(), getPaint());
      }
      AppMethodBeat.o(73223);
      return;
      if ((this.mEditState != EditState.PASSWORD) && (this.mEditState != EditState.CVV_PAYMENT) && (this.mEditState != EditState.CVV_4_PAYMENT))
      {
        super.onDraw(paramCanvas);
        drawCardTailNum(paramCanvas);
      }
      else
      {
        drawPasswdDot(paramCanvas);
        drawCvvPaymentDot(paramCanvas);
        drawCvv4PaymentDot(paramCanvas);
      }
    }
  }
  
  protected final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 0;
    AppMethodBeat.i(73249);
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    int i;
    if ((this.mFilterChar != null) && (!TextUtils.isEmpty(paramCharSequence)))
    {
      i = paramInt1;
      while (i < paramInt1 + paramInt3)
      {
        localObject1 = this.mFilterChar;
        int m = localObject1.length;
        int j = 0;
        while (j < m)
        {
          if (localObject1[j] == paramCharSequence.charAt(i))
          {
            paramCharSequence = paramCharSequence.toString();
            setText(paramCharSequence.substring(0, i) + paramCharSequence.substring(i + 1));
            setSelection(i);
            AppMethodBeat.o(73249);
            return;
          }
          j += 1;
        }
        i += 1;
      }
    }
    Object localObject1 = getText().toString();
    boolean bool;
    if ((localObject1 != null) && (((String)localObject1).length() > 0))
    {
      bool = true;
      this.mIsCardTailNumCanDisplay = bool;
      if ((isFocused()) && (this.mClearBtnImg != null) && (EditState.PASSWORD != this.mEditState) && (EditState.CVV_PAYMENT != this.mEditState) && (EditState.CVV_4_PAYMENT != this.mEditState))
      {
        if (!getText().toString().equals("")) {
          break label345;
        }
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
      }
      label268:
      if (this.mEditState == null) {
        break label409;
      }
    }
    label345:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            i = 6.$SwitchMap$com$tenpay$android$wechat$TenpaySecureEditText$EditState[this.mEditState.ordinal()];
            switch (i)
            {
            case 4: 
            default: 
              AppMethodBeat.o(73249);
              return;
            }
          }
          catch (Exception paramCharSequence) {}
          bool = false;
          break;
          setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.mClearBtnImg, getCompoundDrawables()[3]);
          break label268;
          if ((((String)localObject1).length() == PASSWD_LENGTH) && (this.mPasswdListener != null))
          {
            this.mPasswdListener.onDone();
            AppMethodBeat.o(73249);
            return;
          }
        }
        AppMethodBeat.o(73249);
        return;
      } while ((((String)localObject1).length() != CVV_PAYMENT_LENGTH) || (this.mPasswdListener == null));
      this.mPasswdListener.onDone();
      AppMethodBeat.o(73249);
      return;
    } while ((((String)localObject1).length() != CVV_4_PAYMENT_LENGTH) || (this.mPasswdListener == null));
    label409:
    this.mPasswdListener.onDone();
    AppMethodBeat.o(73249);
    return;
    Object localObject2;
    if (!this.mIsSelfSet)
    {
      paramInt3 = paramInt1 + paramInt3;
      if (((String)localObject1).length() > 0)
      {
        if (paramInt3 > ((String)localObject1).length()) {
          break label932;
        }
        paramCharSequence = ((String)localObject1).substring(0, paramInt3);
        localObject2 = paramCharSequence.replaceAll(" ", "");
        paramInt1 = paramCharSequence.length() - ((String)localObject2).length();
        label547:
        paramCharSequence = ((String)localObject1).replaceAll(" ", "");
        localObject1 = new StringBuffer();
        i = paramCharSequence.length();
        paramInt2 = k;
        while (paramInt2 + 4 < i)
        {
          ((StringBuffer)localObject1).append(paramCharSequence.substring(paramInt2, paramInt2 + 4));
          ((StringBuffer)localObject1).append(" ");
          paramInt2 += 4;
        }
        ((StringBuffer)localObject1).append(paramCharSequence.substring(paramInt2));
        paramCharSequence = ((StringBuffer)localObject1).toString();
        if (paramInt3 > paramCharSequence.length()) {
          break label702;
        }
        localObject1 = paramCharSequence.substring(0, paramInt3);
        localObject2 = ((String)localObject1).replaceAll(" ", "");
      }
      for (paramInt2 = ((String)localObject1).length() - ((String)localObject2).length();; paramInt2 = paramCharSequence.length() - ((String)localObject1).length())
      {
        this.mIsSelfSet = true;
        setText(paramCharSequence);
        setSelection(paramInt2 + paramInt3 - paramInt1);
        AppMethodBeat.o(73249);
        return;
        label702:
        localObject1 = paramCharSequence.replaceAll(" ", "");
      }
    }
    else
    {
      this.mIsSelfSet = false;
      AppMethodBeat.o(73249);
      return;
      if (!this.mIsSelfSet)
      {
        paramInt1 = ((String)localObject1).length();
        if ((paramInt1 == 0) || (paramInt1 == 1))
        {
          AppMethodBeat.o(73249);
          return;
        }
        paramCharSequence = ((String)localObject1).replace("/", "");
        if ((paramInt1 == 2) && (((String)localObject1).contains("/"))) {}
        for (;;)
        {
          i = getSelectionStart();
          this.mIsSelfSet = true;
          setText(paramCharSequence);
          if (paramInt1 != 2) {
            break;
          }
          if (!((String)localObject1).contains("/")) {
            break label937;
          }
          setSelection(1);
          AppMethodBeat.o(73249);
          return;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramCharSequence.substring(0, 2));
          ((StringBuilder)localObject2).append("/");
          if (paramCharSequence.length() > 2) {
            ((StringBuilder)localObject2).append(paramCharSequence.substring(2));
          }
          paramCharSequence = ((StringBuilder)localObject2).toString();
        }
      }
    }
    for (;;)
    {
      setSelection(paramInt1);
      AppMethodBeat.o(73249);
      return;
      setSelection(i);
      label932:
      label937:
      do
      {
        AppMethodBeat.o(73249);
        return;
        this.mIsSelfSet = false;
        break;
        paramInt1 = 0;
        break label547;
      } while (i != 2);
      if (paramInt3 > paramInt2) {
        paramInt1 = 3;
      } else {
        paramInt1 = 2;
      }
    }
  }
  
  public final boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(73229);
    if (((getInputType() & 0x80) > 0) || (EditState.PASSWORD == this.mEditState) || (EditState.CVV_PAYMENT == this.mEditState) || (EditState.CVV_4_PAYMENT == this.mEditState) || (this.mEditState == EditState.IDCARD_TAIL))
    {
      AppMethodBeat.o(73229);
      return true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(73229);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(73215);
    if ((paramMotionEvent.getAction() == 0) && (this.mIsUseOfKinda)) {
      clearFocus();
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(73215);
    return bool;
  }
  
  public final void set3DesEncrptData(String paramString)
  {
    AppMethodBeat.i(73237);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(73237);
      return;
    }
    Encrypt localEncrypt = new Encrypt();
    setText(localEncrypt.desedeDecode(paramString, localEncrypt.getRandomKey()));
    AppMethodBeat.o(73237);
  }
  
  public final void setBankcardTailNum(String paramString)
  {
    AppMethodBeat.i(73221);
    this.mCardTailNum = paramString;
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.mEditState = EditState.BANKCARD_WITH_TAILNUM;
      this.mTitlePaint = new Paint();
      this.mTitlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      this.mTitlePaint.setAntiAlias(true);
      this.mTitlePaint.setTextSize(getTextSize());
      this.mIDCardPaint.setColor(getResources().getColor(2131100018));
    }
    AppMethodBeat.o(73221);
  }
  
  public final void setClearBtnDrawableId(int paramInt)
  {
    AppMethodBeat.i(73213);
    setClearBtnDrawableId(paramInt, 0);
    AppMethodBeat.o(73213);
  }
  
  public final void setClearBtnDrawableId(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73214);
    setClearBtnDrawableId(paramInt1, paramInt2, 0, 0);
    AppMethodBeat.o(73214);
  }
  
  public final void setClearBtnDrawableId(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(174540);
    try
    {
      this.mClearBtnImg = getResources().getDrawable(paramInt1);
      if (paramInt2 != 0) {
        this.mClearBtnImg.setColorFilter(paramInt2, PorterDuff.Mode.SRC_ATOP);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.mClearBtnImg = null;
        continue;
        this.mClearBtnImg.setBounds(0, 0, this.mClearBtnImg.getIntrinsicWidth(), this.mClearBtnImg.getIntrinsicHeight());
      }
      setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean) {}
      });
      setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return false;
        }
      });
      AppMethodBeat.o(174540);
    }
    if (this.mClearBtnImg != null) {
      if ((paramInt3 != 0) && (paramInt4 != 0))
      {
        this.mClearBtnImg.setBounds(0, 0, ao.fromDPToPix(getContext(), paramInt3), ao.fromDPToPix(getContext(), paramInt4));
        setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(73204);
            if (!paramAnonymousBoolean)
            {
              TenpaySecureEditText.this.setCompoundDrawables(TenpaySecureEditText.this.getCompoundDrawables()[0], TenpaySecureEditText.this.getCompoundDrawables()[1], null, TenpaySecureEditText.this.getCompoundDrawables()[3]);
              AppMethodBeat.o(73204);
              return;
            }
            if ((!TenpaySecureEditText.this.getText().toString().equals("")) && (TenpaySecureEditText.EditState.PASSWORD != TenpaySecureEditText.this.mEditState) && (TenpaySecureEditText.EditState.CVV_PAYMENT != TenpaySecureEditText.this.mEditState) && (TenpaySecureEditText.EditState.CVV_4_PAYMENT != TenpaySecureEditText.this.mEditState)) {
              TenpaySecureEditText.this.setCompoundDrawables(TenpaySecureEditText.this.getCompoundDrawables()[0], TenpaySecureEditText.this.getCompoundDrawables()[1], TenpaySecureEditText.this.mClearBtnImg, TenpaySecureEditText.this.getCompoundDrawables()[3]);
            }
            AppMethodBeat.o(73204);
          }
        });
        setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(73205);
            if ((TenpaySecureEditText.EditState.PASSWORD != TenpaySecureEditText.this.mEditState) && (TenpaySecureEditText.EditState.CVV_PAYMENT != TenpaySecureEditText.this.mEditState) && (TenpaySecureEditText.EditState.CVV_4_PAYMENT != TenpaySecureEditText.this.mEditState))
            {
              paramAnonymousView = TenpaySecureEditText.this;
              if ((paramAnonymousMotionEvent.getAction() == 1) && (!paramAnonymousView.isFocused()) && (TenpaySecureEditText.this.mKindaEditTextCallBackListener != null)) {
                TenpaySecureEditText.this.mKindaEditTextCallBackListener.onCallBackKinda();
              }
              if (paramAnonymousView.getCompoundDrawables()[2] == null)
              {
                AppMethodBeat.o(73205);
                return false;
              }
              if (paramAnonymousMotionEvent.getAction() != 1)
              {
                AppMethodBeat.o(73205);
                return false;
              }
              if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - TenpaySecureEditText.this.mClearBtnImg.getIntrinsicWidth()) {
                paramAnonymousView.setText("");
              }
            }
            AppMethodBeat.o(73205);
            return false;
          }
        });
        AppMethodBeat.o(174540);
        return;
      }
    }
  }
  
  public final void setCursorStyle(int paramInt)
  {
    AppMethodBeat.i(174541);
    if (paramInt == -1)
    {
      AppMethodBeat.o(174541);
      return;
    }
    try
    {
      Field localField = TextView.class.getDeclaredField("mCursorDrawableRes");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      AppMethodBeat.o(174541);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(174541);
    }
  }
  
  public final void setFilterChar(char[] paramArrayOfChar)
  {
    this.mFilterChar = paramArrayOfChar;
  }
  
  public final void setFixedHeaderText(String paramString)
  {
    AppMethodBeat.i(73222);
    this.mFixedHeaderText = paramString;
    setPadding((int)getPaint().measureText(this.mFixedHeaderText) + getPaddingLeft(), getPaddingTop(), getPaddingBottom(), getPaddingRight());
    invalidate();
    AppMethodBeat.o(73222);
  }
  
  public final void setIsBankcardFormat(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mEditState = EditState.BANKCARD;
    }
    while (EditState.BANKCARD != this.mEditState) {
      return;
    }
    this.mEditState = EditState.DEFAULT;
  }
  
  public final void setIsCvv4PaymentFormat(boolean paramBoolean)
  {
    AppMethodBeat.i(73219);
    if (paramBoolean)
    {
      setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      this.mPaintBackground = new Paint(1);
      this.mPaintBackground.setStyle(Paint.Style.FILL);
      this.mIDCardPaint.setColor(getResources().getColor(2131100018));
      this.mEditState = EditState.CVV_4_PAYMENT;
      AppMethodBeat.o(73219);
      return;
    }
    this.mPaintBackground = null;
    if (EditState.CVV_4_PAYMENT == this.mEditState) {
      this.mEditState = EditState.DEFAULT;
    }
    AppMethodBeat.o(73219);
  }
  
  public final void setIsCvvPaymentFormat(boolean paramBoolean)
  {
    AppMethodBeat.i(73218);
    if (paramBoolean)
    {
      setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      this.mPaintBackground = new Paint(1);
      this.mPaintBackground.setStyle(Paint.Style.FILL);
      this.mIDCardPaint.setColor(getResources().getColor(2131100018));
      this.mEditState = EditState.CVV_PAYMENT;
      AppMethodBeat.o(73218);
      return;
    }
    this.mPaintBackground = null;
    if (EditState.CVV_PAYMENT == this.mEditState) {
      this.mEditState = EditState.DEFAULT;
    }
    AppMethodBeat.o(73218);
  }
  
  public final void setIsIdCardTailFormat(boolean paramBoolean)
  {
    AppMethodBeat.i(73217);
    if (paramBoolean)
    {
      setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      this.mEditState = EditState.IDCARD_TAIL;
      this.mIDCardPaint = new Paint();
      this.mIDCardPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      this.mIDCardPaint.setTextAlign(Paint.Align.CENTER);
      this.mIDCardPaint.setAntiAlias(true);
      this.mIDCardPaint.setTextSize(getTextSize());
      this.mIDCardPaint.setColor(getResources().getColor(2131100018));
      AppMethodBeat.o(73217);
      return;
    }
    this.mEditState = EditState.DEFAULT;
    AppMethodBeat.o(73217);
  }
  
  public final void setIsMoneyAmountFormat(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mEditState = EditState.MONEY_AMOUNT;
    }
    while (EditState.MONEY_AMOUNT != this.mEditState) {
      return;
    }
    this.mEditState = EditState.DEFAULT;
  }
  
  public final void setIsPasswordFormat(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(187201);
    if (paramBoolean1)
    {
      this.mNewPwdStyle = paramBoolean2;
      setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      this.mPaintBackground = new Paint(1);
      this.mPaintBackground.setStyle(Paint.Style.FILL);
      if (ai.Eq())
      {
        this.mPaintBackground.setColor(getResources().getColor(2131099673));
        this.mEditState = EditState.PASSWORD;
        this.mPasswdSeparedPaint = new Paint(1);
        this.mPasswdSeparedPaint.setStyle(Paint.Style.STROKE);
        this.mPasswdSeparedPaint.setStrokeWidth(1.5F);
        if (!ai.Eq()) {
          break label213;
        }
        this.mPasswdSeparedPaint.setColor(getResources().getColor(2131099737));
      }
      for (;;)
      {
        this.mPasswdBgPaint = new Paint(1);
        this.mPasswdBgPaint.setStyle(Paint.Style.FILL);
        if (!ai.Eq()) {
          break label233;
        }
        this.mPasswdBgPaint.setColor(getResources().getColor(2131099648));
        AppMethodBeat.o(187201);
        return;
        this.mPaintBackground.setColor(getResources().getColor(2131099654));
        break;
        label213:
        this.mPasswdSeparedPaint.setColor(getResources().getColor(2131099736));
      }
      label233:
      this.mPasswdBgPaint.setColor(getResources().getColor(2131099648));
      AppMethodBeat.o(187201);
      return;
    }
    this.mPaintBackground = null;
    if (EditState.PASSWORD == this.mEditState) {
      this.mEditState = EditState.DEFAULT;
    }
    AppMethodBeat.o(187201);
  }
  
  public final void setIsSecurityAnswerFormat(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mEditState = EditState.SECURITY_ANSWER;
      return;
    }
    this.mEditState = EditState.DEFAULT;
  }
  
  public final void setIsValidThru(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mEditState = EditState.VALID_THRU;
    }
    while (EditState.VALID_THRU != this.mEditState) {
      return;
    }
    this.mEditState = EditState.DEFAULT;
  }
  
  public final void setKindaEditTextCallBackListener(IKindaEditTextCallBackListener paramIKindaEditTextCallBackListener)
  {
    this.mKindaEditTextCallBackListener = paramIKindaEditTextCallBackListener;
  }
  
  public final void setOnPasswdInputListener(OnPasswdInputListener paramOnPasswdInputListener)
  {
    this.mPasswdListener = paramOnPasswdInputListener;
  }
  
  public final void setSecureEncrypt(ISecureEncrypt paramISecureEncrypt)
  {
    this.mIEncrypt = paramISecureEncrypt;
  }
  
  public final void setUseOfKinda(boolean paramBoolean)
  {
    this.mIsUseOfKinda = paramBoolean;
  }
  
  public final void setValidThru(String paramString)
  {
    AppMethodBeat.i(73220);
    if ((paramString != null) && (paramString.length() == VALID_THRU_LEN))
    {
      setText(paramString);
      this.mEditState = EditState.VALID_THRU;
    }
    AppMethodBeat.o(73220);
  }
  
  public static enum EditState
  {
    static
    {
      AppMethodBeat.i(73209);
      DEFAULT = new EditState("DEFAULT", 0);
      PASSWORD = new EditState("PASSWORD", 1);
      BANKCARD = new EditState("BANKCARD", 2);
      BANKCARD_WITH_TAILNUM = new EditState("BANKCARD_WITH_TAILNUM", 3);
      VALID_THRU = new EditState("VALID_THRU", 4);
      MONEY_AMOUNT = new EditState("MONEY_AMOUNT", 5);
      CVV_PAYMENT = new EditState("CVV_PAYMENT", 6);
      CVV_4_PAYMENT = new EditState("CVV_4_PAYMENT", 7);
      SECURITY_ANSWER = new EditState("SECURITY_ANSWER", 8);
      IDCARD_TAIL = new EditState("IDCARD_TAIL", 9);
      $VALUES = new EditState[] { DEFAULT, PASSWORD, BANKCARD, BANKCARD_WITH_TAILNUM, VALID_THRU, MONEY_AMOUNT, CVV_PAYMENT, CVV_4_PAYMENT, SECURITY_ANSWER, IDCARD_TAIL };
      AppMethodBeat.o(73209);
    }
    
    private EditState() {}
  }
  
  public static abstract interface IKindaEditTextCallBackListener
  {
    public abstract void onCallBackKinda();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tenpay.android.wechat.TenpaySecureEditText
 * JD-Core Version:    0.7.0.1
 */