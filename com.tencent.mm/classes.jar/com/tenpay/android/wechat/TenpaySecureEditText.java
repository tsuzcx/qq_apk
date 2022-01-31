package com.tenpay.android.wechat;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
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
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.ndk.Encrypt;
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
  TenpaySecureEditText.EditState mEditState;
  private char[] mFilterChar;
  private String mFixedHeaderText;
  private Paint mIDCardPaint;
  private ISecureEncrypt mIEncrypt;
  private boolean mIsCardTailNumCanDisplay;
  private boolean mIsSelfSet;
  private boolean mIsUseOfKinda;
  private Paint mPaintBackground;
  private OnPasswdInputListener mPasswdListener;
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
    AppMethodBeat.i(49467);
    this.mEditState = TenpaySecureEditText.EditState.DEFAULT;
    this.mIEncrypt = new TenpaySecureEncrypt();
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(49467);
  }
  
  public TenpaySecureEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49468);
    this.mEditState = TenpaySecureEditText.EditState.DEFAULT;
    this.mIEncrypt = new TenpaySecureEncrypt();
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(49468);
  }
  
  private void drawCardTailNum(Canvas paramCanvas)
  {
    AppMethodBeat.i(49483);
    if ((TenpaySecureEditText.EditState.BANKCARD_WITH_TAILNUM == this.mEditState) && (this.mIsCardTailNumCanDisplay))
    {
      int j = getBaseline();
      int i = j;
      if (j == -1) {
        i = 44;
      }
      paramCanvas.drawText(this.mCardTailNum, CARD_TAIL_SPACE * this.mDensity + getPaint().measureText(getText().toString()), i, this.mTitlePaint);
    }
    AppMethodBeat.o(49483);
  }
  
  private void drawCvv4PaymentDot(Canvas paramCanvas)
  {
    AppMethodBeat.i(49482);
    if ((TenpaySecureEditText.EditState.CVV_4_PAYMENT == this.mEditState) && (this.mPaintBackground != null))
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
    AppMethodBeat.o(49482);
  }
  
  private void drawCvvPaymentDot(Canvas paramCanvas)
  {
    AppMethodBeat.i(49481);
    if ((TenpaySecureEditText.EditState.CVV_PAYMENT == this.mEditState) && (this.mPaintBackground != null))
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
    AppMethodBeat.o(49481);
  }
  
  private void drawIdCardTail(Canvas paramCanvas)
  {
    AppMethodBeat.i(49479);
    if ((TenpaySecureEditText.EditState.IDCARD_TAIL == this.mEditState) && (this.mIDCardPaint != null))
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
    AppMethodBeat.o(49479);
  }
  
  private void drawPasswdDot(Canvas paramCanvas)
  {
    AppMethodBeat.i(49480);
    if ((TenpaySecureEditText.EditState.PASSWORD == this.mEditState) && (this.mPaintBackground != null))
    {
      int i = getWidth();
      int j = getHeight();
      int k = i / PASSWD_LENGTH;
      int m = getText().length();
      i = 0;
      while (i < m)
      {
        paramCanvas.drawCircle(k / 2 + i * k, j / 2, PASSWD_BLACK_DOT_SIZE * this.mDensity, this.mPaintBackground);
        i += 1;
      }
    }
    AppMethodBeat.o(49480);
  }
  
  private String getInputText()
  {
    AppMethodBeat.i(49486);
    if (this.mEditState == TenpaySecureEditText.EditState.SECURITY_ANSWER) {}
    for (String str2 = getText().toString(); (str2 == null) || (str2.length() == 0); str2 = getText().toString().trim())
    {
      AppMethodBeat.o(49486);
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
      AppMethodBeat.o(49486);
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
    AppMethodBeat.i(49469);
    this.mDensity = getResources().getDisplayMetrics().density;
    if (paramAttributeSet != null)
    {
      int[] arrayOfInt = TenpayUtil.getResourceDeclareStyleableIntArray(paramContext, "TenpaySecureEditText");
      if (arrayOfInt != null)
      {
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
        if (paramAttributeSet != null)
        {
          setIsPasswordFormat(paramAttributeSet.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(paramContext, "TenpaySecureEditText_isPassword"), false));
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
    AppMethodBeat.o(49469);
  }
  
  private boolean isMatchPattern(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49499);
    if (paramString2 != null) {
      try
      {
        boolean bool = Pattern.compile(paramString2).matcher(paramString1).matches();
        AppMethodBeat.o(49499);
        return bool;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(49499);
        return false;
      }
    }
    AppMethodBeat.o(49499);
    return false;
  }
  
  public static void setSalt(String paramString)
  {
    mTimeStamp = paramString;
  }
  
  public final void ClearInput()
  {
    AppMethodBeat.i(49500);
    setText("");
    AppMethodBeat.o(49500);
  }
  
  public final String get3DesEncrptData()
  {
    AppMethodBeat.i(49489);
    String str = getInputText();
    if ((str == null) || (str.length() == 0))
    {
      AppMethodBeat.o(49489);
      return null;
    }
    if (this.mIEncrypt != null)
    {
      str = this.mIEncrypt.desedeEncode(str, mTimeStamp);
      AppMethodBeat.o(49489);
      return str;
    }
    str = new Encrypt().desedeEncode(str);
    AppMethodBeat.o(49489);
    return str;
  }
  
  public final String get3DesVerifyCode()
  {
    AppMethodBeat.i(49491);
    String str = getInputText();
    if ((str == null) || (str.length() == 0))
    {
      AppMethodBeat.o(49491);
      return null;
    }
    if (this.mIEncrypt != null)
    {
      str = this.mIEncrypt.desedeVerifyCode(str, mTimeStamp);
      AppMethodBeat.o(49491);
      return str;
    }
    str = new Encrypt().desedeVerifyCode(str);
    AppMethodBeat.o(49491);
    return str;
  }
  
  public final TenpaySecureEditText.EditState getEditState()
  {
    return this.mEditState;
  }
  
  public final String getEncryptDataWithHash(boolean paramBoolean)
  {
    AppMethodBeat.i(49487);
    String str = getEncryptDataWithHash(paramBoolean, false);
    AppMethodBeat.o(49487);
    return str;
  }
  
  public final String getEncryptDataWithHash(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(49488);
    Object localObject2 = getInputText();
    if ((localObject2 == null) || (((String)localObject2).length() == 0))
    {
      AppMethodBeat.o(49488);
      return null;
    }
    if (this.mIEncrypt != null)
    {
      if (paramBoolean2)
      {
        localObject1 = this.mIEncrypt.encryptPasswdWithRSA2048(paramBoolean1, (String)localObject2, mTimeStamp);
        AppMethodBeat.o(49488);
        return localObject1;
      }
      localObject1 = this.mIEncrypt.encryptPasswd(paramBoolean1, (String)localObject2, mTimeStamp);
      AppMethodBeat.o(49488);
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
      AppMethodBeat.o(49488);
      return localObject1;
    }
    localObject1 = ((Encrypt)localObject2).encryptPasswd((String)localObject1);
    AppMethodBeat.o(49488);
    return localObject1;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(49501);
    String str = getInputText();
    if (str == null)
    {
      AppMethodBeat.o(49501);
      return 0;
    }
    int i = str.length();
    AppMethodBeat.o(49501);
    return i;
  }
  
  public final boolean isAreaIDCardNum(int paramInt)
  {
    AppMethodBeat.i(49497);
    String str = getText().toString().trim();
    if ((str == null) || (str.length() == 0))
    {
      AppMethodBeat.o(49497);
      return false;
    }
    str.replaceAll(" ", "");
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(49497);
      return true;
    }
    boolean bool = isUserIdNum();
    AppMethodBeat.o(49497);
    return bool;
  }
  
  public final boolean isBankcardNum()
  {
    AppMethodBeat.i(49493);
    if ((getInputLength() >= BANK_CARD_LENGTH_LIMIT) || (getText().toString().contains("**")))
    {
      AppMethodBeat.o(49493);
      return true;
    }
    AppMethodBeat.o(49493);
    return false;
  }
  
  public final boolean isMatchPattern(String paramString)
  {
    AppMethodBeat.i(49498);
    if (paramString != null) {
      try
      {
        String str = getInputText();
        boolean bool = Pattern.compile(paramString).matcher(str).matches();
        AppMethodBeat.o(49498);
        return bool;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(49498);
        return false;
      }
    }
    AppMethodBeat.o(49498);
    return false;
  }
  
  public final boolean isMoneyAmount()
  {
    AppMethodBeat.i(49494);
    boolean bool = isMatchPattern("^\\d+(\\.\\d{0,2})?$");
    AppMethodBeat.o(49494);
    return bool;
  }
  
  public final boolean isPhoneNum()
  {
    AppMethodBeat.i(49492);
    if (getText().toString().trim().length() == 11)
    {
      AppMethodBeat.o(49492);
      return true;
    }
    if (getText().toString().contains("**"))
    {
      AppMethodBeat.o(49492);
      return true;
    }
    AppMethodBeat.o(49492);
    return false;
  }
  
  public final boolean isUserIdNum()
  {
    AppMethodBeat.i(49495);
    String str = getText().toString().trim();
    if (getInputLength() == 15)
    {
      bool = isMatchPattern("^\\d{15}$");
      AppMethodBeat.o(49495);
      return bool;
    }
    boolean bool = TenpayUtil.invalidateID(str);
    AppMethodBeat.o(49495);
    return bool;
  }
  
  public final boolean isValidThru()
  {
    AppMethodBeat.i(49496);
    boolean bool = isMatchPattern("[1-9][0-9]0[1-9]$|[1-9][0-9]1[0-2]$");
    AppMethodBeat.o(49496);
    return bool;
  }
  
  protected final void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    AppMethodBeat.i(49485);
    if (((getInputType() & 0x80) <= 0) && (TenpaySecureEditText.EditState.PASSWORD != this.mEditState) && (TenpaySecureEditText.EditState.CVV_PAYMENT != this.mEditState) && (TenpaySecureEditText.EditState.CVV_4_PAYMENT != this.mEditState)) {
      super.onCreateContextMenu(paramContextMenu);
    }
    AppMethodBeat.o(49485);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(49478);
    if (this.mEditState == TenpaySecureEditText.EditState.IDCARD_TAIL) {
      drawIdCardTail(paramCanvas);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.mFixedHeaderText)) {
        paramCanvas.drawText(this.mFixedHeaderText, 0.0F, (getMeasuredHeight() - getTextSize()) / 2.0F + getTextSize(), getPaint());
      }
      AppMethodBeat.o(49478);
      return;
      if ((this.mEditState != TenpaySecureEditText.EditState.PASSWORD) && (this.mEditState != TenpaySecureEditText.EditState.CVV_PAYMENT) && (this.mEditState != TenpaySecureEditText.EditState.CVV_4_PAYMENT))
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
    AppMethodBeat.i(49502);
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
            AppMethodBeat.o(49502);
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
      if ((isFocused()) && (this.mClearBtnImg != null) && (TenpaySecureEditText.EditState.PASSWORD != this.mEditState) && (TenpaySecureEditText.EditState.CVV_PAYMENT != this.mEditState) && (TenpaySecureEditText.EditState.CVV_4_PAYMENT != this.mEditState))
      {
        if (!getText().toString().equals("")) {
          break label345;
        }
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
      }
      label267:
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
              AppMethodBeat.o(49502);
              return;
            }
          }
          catch (Exception paramCharSequence) {}
          bool = false;
          break;
          setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.mClearBtnImg, getCompoundDrawables()[3]);
          break label267;
          if ((((String)localObject1).length() == PASSWD_LENGTH) && (this.mPasswdListener != null))
          {
            this.mPasswdListener.onDone();
            AppMethodBeat.o(49502);
            return;
          }
        }
        AppMethodBeat.o(49502);
        return;
      } while ((((String)localObject1).length() != CVV_PAYMENT_LENGTH) || (this.mPasswdListener == null));
      this.mPasswdListener.onDone();
      AppMethodBeat.o(49502);
      return;
    } while ((((String)localObject1).length() != CVV_4_PAYMENT_LENGTH) || (this.mPasswdListener == null));
    label409:
    this.mPasswdListener.onDone();
    AppMethodBeat.o(49502);
    return;
    Object localObject2;
    if (!this.mIsSelfSet)
    {
      paramInt3 = paramInt1 + paramInt3;
      if (((String)localObject1).length() > 0)
      {
        if (paramInt3 > ((String)localObject1).length()) {
          break label918;
        }
        paramCharSequence = ((String)localObject1).substring(0, paramInt3);
        localObject2 = paramCharSequence.replaceAll(" ", "");
        paramInt1 = paramCharSequence.length() - ((String)localObject2).length();
        label545:
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
          break label695;
        }
        localObject1 = paramCharSequence.substring(0, paramInt3);
        localObject2 = ((String)localObject1).replaceAll(" ", "");
      }
      for (paramInt2 = ((String)localObject1).length() - ((String)localObject2).length();; paramInt2 = paramCharSequence.length() - ((String)localObject1).length())
      {
        this.mIsSelfSet = true;
        setText(paramCharSequence);
        setSelection(paramInt2 + paramInt3 - paramInt1);
        AppMethodBeat.o(49502);
        return;
        label695:
        localObject1 = paramCharSequence.replaceAll(" ", "");
      }
    }
    else
    {
      this.mIsSelfSet = false;
      AppMethodBeat.o(49502);
      return;
      if (!this.mIsSelfSet)
      {
        paramInt1 = ((String)localObject1).length();
        if ((paramInt1 == 0) || (paramInt1 == 1))
        {
          AppMethodBeat.o(49502);
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
            break label923;
          }
          setSelection(1);
          AppMethodBeat.o(49502);
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
      AppMethodBeat.o(49502);
      return;
      setSelection(i);
      label918:
      label923:
      do
      {
        AppMethodBeat.o(49502);
        return;
        this.mIsSelfSet = false;
        break;
        paramInt1 = 0;
        break label545;
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
    AppMethodBeat.i(49484);
    if (((getInputType() & 0x80) > 0) || (TenpaySecureEditText.EditState.PASSWORD == this.mEditState) || (TenpaySecureEditText.EditState.CVV_PAYMENT == this.mEditState) || (TenpaySecureEditText.EditState.CVV_4_PAYMENT == this.mEditState) || (this.mEditState == TenpaySecureEditText.EditState.IDCARD_TAIL))
    {
      AppMethodBeat.o(49484);
      return true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(49484);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(155104);
    if ((paramMotionEvent.getAction() == 0) && (this.mIsUseOfKinda)) {
      clearFocus();
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(155104);
    return bool;
  }
  
  public final void set3DesEncrptData(String paramString)
  {
    AppMethodBeat.i(49490);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(49490);
      return;
    }
    Encrypt localEncrypt = new Encrypt();
    setText(localEncrypt.desedeDecode(paramString, localEncrypt.getRandomKey()));
    AppMethodBeat.o(49490);
  }
  
  public final void setBankcardTailNum(String paramString)
  {
    AppMethodBeat.i(49476);
    this.mCardTailNum = paramString;
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.mEditState = TenpaySecureEditText.EditState.BANKCARD_WITH_TAILNUM;
      this.mTitlePaint = new Paint();
      this.mTitlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      this.mTitlePaint.setAntiAlias(true);
      this.mTitlePaint.setTextSize(getTextSize());
      this.mTitlePaint.setColor(-16777216);
    }
    AppMethodBeat.o(49476);
  }
  
  public final void setClearBtnDrawableId(int paramInt)
  {
    AppMethodBeat.i(49470);
    try
    {
      this.mClearBtnImg = getResources().getDrawable(paramInt);
      if (this.mClearBtnImg != null)
      {
        this.mClearBtnImg.setBounds(0, 0, this.mClearBtnImg.getIntrinsicWidth(), this.mClearBtnImg.getIntrinsicHeight());
        setOnFocusChangeListener(new TenpaySecureEditText.2(this));
        setOnTouchListener(new TenpaySecureEditText.3(this));
        AppMethodBeat.o(49470);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.mClearBtnImg = null;
      }
      setOnFocusChangeListener(new TenpaySecureEditText.4(this));
      setOnTouchListener(new TenpaySecureEditText.5(this));
      AppMethodBeat.o(49470);
    }
  }
  
  public final void setFilterChar(char[] paramArrayOfChar)
  {
    this.mFilterChar = paramArrayOfChar;
  }
  
  public final void setFixedHeaderText(String paramString)
  {
    AppMethodBeat.i(49477);
    this.mFixedHeaderText = paramString;
    setPadding((int)getPaint().measureText(this.mFixedHeaderText) + getPaddingLeft(), getPaddingTop(), getPaddingBottom(), getPaddingRight());
    invalidate();
    AppMethodBeat.o(49477);
  }
  
  public final void setIsBankcardFormat(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mEditState = TenpaySecureEditText.EditState.BANKCARD;
    }
    while (TenpaySecureEditText.EditState.BANKCARD != this.mEditState) {
      return;
    }
    this.mEditState = TenpaySecureEditText.EditState.DEFAULT;
  }
  
  public final void setIsCvv4PaymentFormat(boolean paramBoolean)
  {
    AppMethodBeat.i(49474);
    if (paramBoolean)
    {
      setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      this.mPaintBackground = new Paint(1);
      this.mPaintBackground.setStyle(Paint.Style.FILL);
      this.mPaintBackground.setColor(-16777216);
      this.mEditState = TenpaySecureEditText.EditState.CVV_4_PAYMENT;
      AppMethodBeat.o(49474);
      return;
    }
    this.mPaintBackground = null;
    if (TenpaySecureEditText.EditState.CVV_4_PAYMENT == this.mEditState) {
      this.mEditState = TenpaySecureEditText.EditState.DEFAULT;
    }
    AppMethodBeat.o(49474);
  }
  
  public final void setIsCvvPaymentFormat(boolean paramBoolean)
  {
    AppMethodBeat.i(49473);
    if (paramBoolean)
    {
      setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      this.mPaintBackground = new Paint(1);
      this.mPaintBackground.setStyle(Paint.Style.FILL);
      this.mPaintBackground.setColor(-16777216);
      this.mEditState = TenpaySecureEditText.EditState.CVV_PAYMENT;
      AppMethodBeat.o(49473);
      return;
    }
    this.mPaintBackground = null;
    if (TenpaySecureEditText.EditState.CVV_PAYMENT == this.mEditState) {
      this.mEditState = TenpaySecureEditText.EditState.DEFAULT;
    }
    AppMethodBeat.o(49473);
  }
  
  public final void setIsIdCardTailFormat(boolean paramBoolean)
  {
    AppMethodBeat.i(49472);
    if (paramBoolean)
    {
      setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      this.mEditState = TenpaySecureEditText.EditState.IDCARD_TAIL;
      this.mIDCardPaint = new Paint();
      this.mIDCardPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      this.mIDCardPaint.setTextAlign(Paint.Align.CENTER);
      this.mIDCardPaint.setAntiAlias(true);
      this.mIDCardPaint.setTextSize(getTextSize());
      this.mIDCardPaint.setColor(-16777216);
      AppMethodBeat.o(49472);
      return;
    }
    this.mEditState = TenpaySecureEditText.EditState.DEFAULT;
    AppMethodBeat.o(49472);
  }
  
  public final void setIsMoneyAmountFormat(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mEditState = TenpaySecureEditText.EditState.MONEY_AMOUNT;
    }
    while (TenpaySecureEditText.EditState.MONEY_AMOUNT != this.mEditState) {
      return;
    }
    this.mEditState = TenpaySecureEditText.EditState.DEFAULT;
  }
  
  public final void setIsPasswordFormat(boolean paramBoolean)
  {
    AppMethodBeat.i(49471);
    if (paramBoolean)
    {
      setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      this.mPaintBackground = new Paint(1);
      this.mPaintBackground.setStyle(Paint.Style.FILL);
      this.mPaintBackground.setColor(-16777216);
      this.mEditState = TenpaySecureEditText.EditState.PASSWORD;
      AppMethodBeat.o(49471);
      return;
    }
    this.mPaintBackground = null;
    if (TenpaySecureEditText.EditState.PASSWORD == this.mEditState) {
      this.mEditState = TenpaySecureEditText.EditState.DEFAULT;
    }
    AppMethodBeat.o(49471);
  }
  
  public final void setIsSecurityAnswerFormat(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mEditState = TenpaySecureEditText.EditState.SECURITY_ANSWER;
      return;
    }
    this.mEditState = TenpaySecureEditText.EditState.DEFAULT;
  }
  
  public final void setIsValidThru(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mEditState = TenpaySecureEditText.EditState.VALID_THRU;
    }
    while (TenpaySecureEditText.EditState.VALID_THRU != this.mEditState) {
      return;
    }
    this.mEditState = TenpaySecureEditText.EditState.DEFAULT;
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
    AppMethodBeat.i(49475);
    if ((paramString != null) && (paramString.length() == VALID_THRU_LEN))
    {
      setText(paramString);
      this.mEditState = TenpaySecureEditText.EditState.VALID_THRU;
    }
    AppMethodBeat.o(49475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tenpay.android.wechat.TenpaySecureEditText
 * JD-Core Version:    0.7.0.1
 */