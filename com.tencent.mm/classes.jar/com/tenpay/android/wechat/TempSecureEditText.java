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
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;
import com.tenpay.R.color;
import com.tenpay.ndk.Encrypt;
import com.tenpay.ndk.FitSmCertUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TempSecureEditText
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
  private static int VALID_THRU_LEN = 4;
  private static String mTimeStamp;
  private int PASSWD_LENGTH;
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
  private String regExFilterInput;
  
  static
  {
    CVV_PAYMENT_LENGTH = 3;
    CVV_4_PAYMENT_LENGTH = 4;
  }
  
  public TempSecureEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TempSecureEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(208539);
    this.mEditState = EditState.DEFAULT;
    this.mNewPwdStyle = true;
    this.PASSWD_LENGTH = 6;
    this.mIEncrypt = new TenpaySecureEncrypt();
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(208539);
  }
  
  public TempSecureEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208541);
    this.mEditState = EditState.DEFAULT;
    this.mNewPwdStyle = true;
    this.PASSWD_LENGTH = 6;
    this.mIEncrypt = new TenpaySecureEncrypt();
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(208541);
  }
  
  private void drawCardTailNum(Canvas paramCanvas)
  {
    AppMethodBeat.i(208569);
    if ((EditState.BANKCARD_WITH_TAILNUM == this.mEditState) && (this.mIsCardTailNumCanDisplay))
    {
      int j = getBaseline();
      int i = j;
      if (j == -1) {
        i = 44;
      }
      paramCanvas.drawText(this.mCardTailNum, CARD_TAIL_SPACE * this.mDensity + getPaint().measureText(getText().toString()), i, this.mTitlePaint);
    }
    AppMethodBeat.o(208569);
  }
  
  private void drawCvv4PaymentDot(Canvas paramCanvas)
  {
    AppMethodBeat.i(208567);
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
    AppMethodBeat.o(208567);
  }
  
  private void drawCvvPaymentDot(Canvas paramCanvas)
  {
    AppMethodBeat.i(208562);
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
    AppMethodBeat.o(208562);
  }
  
  private void drawIdCardTail(Canvas paramCanvas)
  {
    AppMethodBeat.i(208555);
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
    AppMethodBeat.o(208555);
  }
  
  private void drawPasswdDot(Canvas paramCanvas)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(208559);
    if ((EditState.PASSWORD == this.mEditState) && (this.mPaintBackground != null))
    {
      int i1 = getWidth();
      int k = getHeight();
      int n = i1 / this.PASSWD_LENGTH;
      int m = getText().length();
      if (!this.mNewPwdStyle)
      {
        i = j;
        while (i < m)
        {
          paramCanvas.drawCircle(n / 2 + i * n, k / 2, PASSWD_BLACK_DOT_SIZE * this.mDensity, this.mPaintBackground);
          i += 1;
        }
        i = 1;
        while (i < this.PASSWD_LENGTH)
        {
          paramCanvas.drawLine(n * i, 0.0F, n * i, k, this.mPasswdSeparedPaint);
          i += 1;
        }
        AppMethodBeat.o(208559);
        return;
      }
      j = a.fromDPToPix(getContext(), 8);
      n = (i1 - (this.PASSWD_LENGTH - 1) * j) / this.PASSWD_LENGTH;
      k -= n;
      while (i < this.PASSWD_LENGTH)
      {
        float f1 = (n + j) * i;
        float f2 = n + f1;
        RectF localRectF = new RectF(f1, k, f2, n + k);
        float f3 = a.fromDPToPix(getContext(), 4);
        paramCanvas.drawRoundRect(localRectF, f3, f3, this.mPasswdBgPaint);
        if (i < m) {
          paramCanvas.drawCircle((f1 + f2) / 2.0F, n / 2.0F + k, a.fromDPToPix(getContext(), 4), this.mPaintBackground);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(208559);
  }
  
  private String getInputText()
  {
    AppMethodBeat.i(208575);
    if (this.mEditState == EditState.SECURITY_ANSWER) {}
    for (Object localObject2 = getText().toString(); (localObject2 == null) || (((String)localObject2).length() == 0); localObject2 = getText().toString().trim())
    {
      AppMethodBeat.o(208575);
      return null;
    }
    Object localObject1 = localObject2;
    switch (6.$SwitchMap$com$tenpay$android$wechat$TempSecureEditText$EditState[this.mEditState.ordinal()])
    {
    default: 
      localObject1 = ((String)localObject2).replaceAll(" ", "").replaceAll("x", "X");
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!Util.isNullOrNil(this.regExFilterInput))
      {
        localObject2 = Pattern.compile(this.regExFilterInput).matcher((CharSequence)localObject1).replaceAll("").trim();
        Log.i("TempSecureEditText", "use filter");
      }
      AppMethodBeat.o(208575);
      return localObject2;
      localObject1 = ((String)localObject2).replaceAll(" ", "");
      continue;
      localObject2 = ((String)localObject2).replaceAll(" ", "");
      localObject1 = localObject2;
      if (this.mCardTailNum != null)
      {
        localObject1 = localObject2;
        if (this.mCardTailNum.length() > 0)
        {
          localObject1 = (String)localObject2 + this.mCardTailNum;
          continue;
          localObject2 = ((String)localObject2).replaceAll("/", "");
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((String)localObject2).length() == VALID_THRU_LEN)
            {
              localObject1 = ((String)localObject2).substring(0, 2);
              localObject2 = ((String)localObject2).substring(2);
              localObject1 = (String)localObject2 + (String)localObject1;
            }
          }
        }
      }
    }
  }
  
  private String getUniqueID()
  {
    AppMethodBeat.i(208544);
    String str = q.eD(false);
    if (Util.isNullOrNil(str))
    {
      str = q.aPg();
      AppMethodBeat.o(208544);
      return str;
    }
    AppMethodBeat.o(208544);
    return str;
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(208553);
    this.mDensity = getResources().getDisplayMetrics().density;
    initFitSmcCertUtil(paramContext);
    if (paramAttributeSet != null)
    {
      int[] arrayOfInt = TenpayUtil.getResourceDeclareStyleableIntArray(paramContext, "TempSecureEditText");
      if (arrayOfInt != null)
      {
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
        if (paramAttributeSet != null)
        {
          setIsPasswordFormat(paramAttributeSet.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(paramContext, "TempSecureEditText_isPassword"), false), true);
          setIsBankcardFormat(paramAttributeSet.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(paramContext, "TempSecureEditText_isBankcard"), false));
          setIsValidThru(paramAttributeSet.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(paramContext, "TempSecureEditText_isValidThru"), false));
          setBankcardTailNum(paramAttributeSet.getString(TenpayUtil.getResourceDeclareStyleableIndex(paramContext, "TempSecureEditText_bankcardTailNum")));
          int i = paramAttributeSet.getResourceId(TenpayUtil.getResourceDeclareStyleableIndex(paramContext, "TempSecureEditText_rightClearDrawable"), 0);
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
    AppMethodBeat.o(208553);
  }
  
  private void initFitSmcCertUtil(Context paramContext)
  {
    AppMethodBeat.i(208548);
    paramContext = paramContext.getApplicationContext();
    paramContext = paramContext.getFilesDir().getParentFile().getAbsolutePath() + "/smcert";
    FitSmCertUtil localFitSmCertUtil = FitSmCertUtil.getInstance();
    String str = getUniqueID();
    h.baC();
    localFitSmCertUtil.init(paramContext, str, b.aZs());
    AppMethodBeat.o(208548);
  }
  
  private boolean isMatchPattern(String paramString1, String paramString2)
  {
    AppMethodBeat.i(208578);
    if (paramString2 != null) {
      try
      {
        boolean bool = Pattern.compile(paramString2).matcher(paramString1).matches();
        AppMethodBeat.o(208578);
        return bool;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(208578);
        return false;
      }
    }
    AppMethodBeat.o(208578);
    return false;
  }
  
  public static void setSalt(String paramString)
  {
    AppMethodBeat.i(208573);
    Log.i("TempSecureEditText", "check salt: %s", new Object[] { paramString });
    if ((Integer.decode(BuildInfo.CLIENT_VERSION).intValue() & 0xFF) < 48) {
      Log.i("TempSecureEditText", "check salt stack: %s", new Object[] { Util.getStack() });
    }
    mTimeStamp = paramString;
    AppMethodBeat.o(208573);
  }
  
  public final void ClearInput()
  {
    AppMethodBeat.i(208685);
    setText("");
    AppMethodBeat.o(208685);
  }
  
  public final String get3DesEncrptData()
  {
    AppMethodBeat.i(208666);
    String str = getInputText();
    if ((str == null) || (str.length() == 0))
    {
      AppMethodBeat.o(208666);
      return null;
    }
    if (this.mIEncrypt != null)
    {
      str = this.mIEncrypt.desedeEncode(str, mTimeStamp);
      AppMethodBeat.o(208666);
      return str;
    }
    str = new Encrypt().desedeEncode(str);
    AppMethodBeat.o(208666);
    return str;
  }
  
  public final String get3DesEncrptData(String paramString)
  {
    AppMethodBeat.i(208668);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(208668);
      return null;
    }
    if (this.mIEncrypt != null)
    {
      paramString = this.mIEncrypt.desedeEncode(paramString, mTimeStamp);
      AppMethodBeat.o(208668);
      return paramString;
    }
    paramString = new Encrypt().desedeEncode(paramString);
    AppMethodBeat.o(208668);
    return paramString;
  }
  
  public final String get3DesVerifyCode()
  {
    AppMethodBeat.i(208670);
    String str = getInputText();
    if ((str == null) || (str.length() == 0))
    {
      AppMethodBeat.o(208670);
      return null;
    }
    if (this.mIEncrypt != null)
    {
      str = this.mIEncrypt.desedeVerifyCode(str, mTimeStamp);
      AppMethodBeat.o(208670);
      return str;
    }
    str = new Encrypt().desedeVerifyCode(str);
    AppMethodBeat.o(208670);
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
    AppMethodBeat.i(208660);
    String str = getEncryptDataWithHash(paramBoolean, false);
    AppMethodBeat.o(208660);
    return str;
  }
  
  public final String getEncryptDataWithHash(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(208663);
    Object localObject2 = getInputText();
    if ((localObject2 == null) || (((String)localObject2).length() == 0))
    {
      AppMethodBeat.o(208663);
      return null;
    }
    Log.i("TempSecureEditText", "timestamp: %s, 2048: %s", new Object[] { mTimeStamp, Boolean.valueOf(paramBoolean2) });
    if (this.mIEncrypt != null)
    {
      if (paramBoolean2)
      {
        localObject1 = this.mIEncrypt.encryptPasswdWithRSA2048(paramBoolean1, (String)localObject2, mTimeStamp);
        AppMethodBeat.o(208663);
        return localObject1;
      }
      localObject1 = this.mIEncrypt.encryptPasswd(paramBoolean1, (String)localObject2, mTimeStamp);
      AppMethodBeat.o(208663);
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
      AppMethodBeat.o(208663);
      return localObject1;
    }
    localObject1 = ((Encrypt)localObject2).encryptPasswd((String)localObject1);
    AppMethodBeat.o(208663);
    return localObject1;
  }
  
  public final String getEncryptPassword(EncryptMode paramEncryptMode, long paramLong, String paramString)
  {
    AppMethodBeat.i(208665);
    String str = getInputText();
    if ((str == null) || (str.length() == 0))
    {
      AppMethodBeat.o(208665);
      return null;
    }
    str = TenpayUtil.md5HexDigest(str);
    switch (6.$SwitchMap$com$tenpay$android$wechat$TempSecureEditText$EncryptMode[paramEncryptMode.ordinal()])
    {
    default: 
      AppMethodBeat.o(208665);
      return null;
    case 1: 
      paramEncryptMode = new Encrypt();
      if (mTimeStamp != null) {
        paramEncryptMode.setTimeStamp(mTimeStamp);
      }
      paramEncryptMode = paramEncryptMode.encryptPasswd(str);
      AppMethodBeat.o(208665);
      return paramEncryptMode;
    case 2: 
      paramEncryptMode = new Encrypt();
      if (mTimeStamp != null) {
        paramEncryptMode.setTimeStamp(mTimeStamp);
      }
      paramEncryptMode = paramEncryptMode.encryptPasswdWithRSA2048(str);
      AppMethodBeat.o(208665);
      return paramEncryptMode;
    case 3: 
      paramEncryptMode = FitSmCertUtil.getInstance().encryptPassword(str, paramLong, paramString, 6);
      AppMethodBeat.o(208665);
      return paramEncryptMode;
    }
    paramEncryptMode = FitSmCertUtil.getInstance().encryptPassword(str, paramLong, paramString, 7);
    AppMethodBeat.o(208665);
    return paramEncryptMode;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(208686);
    String str = getInputText();
    if (str == null)
    {
      AppMethodBeat.o(208686);
      return 0;
    }
    int i = str.length();
    AppMethodBeat.o(208686);
    return i;
  }
  
  public final boolean isAreaIDCardNum(int paramInt)
  {
    AppMethodBeat.i(208682);
    String str = getText().toString().trim();
    if ((str == null) || (str.length() == 0))
    {
      AppMethodBeat.o(208682);
      return false;
    }
    str.replaceAll(" ", "");
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(208682);
      return true;
    }
    boolean bool = isUserIdNum();
    AppMethodBeat.o(208682);
    return bool;
  }
  
  public final boolean isBankcardNum()
  {
    AppMethodBeat.i(208673);
    if ((getInputLength() >= BANK_CARD_LENGTH_LIMIT) || (getText().toString().contains("**")))
    {
      AppMethodBeat.o(208673);
      return true;
    }
    AppMethodBeat.o(208673);
    return false;
  }
  
  public final boolean isMatchPattern(String paramString)
  {
    AppMethodBeat.i(208684);
    if (paramString != null) {
      try
      {
        String str = getInputText();
        boolean bool = Pattern.compile(paramString).matcher(str).matches();
        AppMethodBeat.o(208684);
        return bool;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(208684);
        return false;
      }
    }
    AppMethodBeat.o(208684);
    return false;
  }
  
  public final boolean isMoneyAmount()
  {
    AppMethodBeat.i(208676);
    boolean bool = isMatchPattern("^\\d+(\\.\\d{0,2})?$");
    AppMethodBeat.o(208676);
    return bool;
  }
  
  public final boolean isPhoneNum()
  {
    AppMethodBeat.i(208672);
    if (getText().toString().trim().length() == 11)
    {
      AppMethodBeat.o(208672);
      return true;
    }
    if (getText().toString().contains("**"))
    {
      AppMethodBeat.o(208672);
      return true;
    }
    AppMethodBeat.o(208672);
    return false;
  }
  
  public final boolean isUserIdNum()
  {
    AppMethodBeat.i(208678);
    String str = getText().toString().trim();
    if (getInputLength() == 15)
    {
      bool = isMatchPattern("^\\d{15}$");
      AppMethodBeat.o(208678);
      return bool;
    }
    boolean bool = TenpayUtil.invalidateID(str);
    AppMethodBeat.o(208678);
    return bool;
  }
  
  public final boolean isValidThru()
  {
    AppMethodBeat.i(208679);
    boolean bool = isMatchPattern("[1-9][0-9]0[1-9]$|[1-9][0-9]1[0-2]$");
    AppMethodBeat.o(208679);
    return bool;
  }
  
  protected final void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    AppMethodBeat.i(208655);
    if (((getInputType() & 0x80) <= 0) && (EditState.PASSWORD != this.mEditState) && (EditState.CVV_PAYMENT != this.mEditState) && (EditState.CVV_4_PAYMENT != this.mEditState)) {
      super.onCreateContextMenu(paramContextMenu);
    }
    AppMethodBeat.o(208655);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(208652);
    if (this.mEditState == EditState.IDCARD_TAIL) {
      drawIdCardTail(paramCanvas);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.mFixedHeaderText)) {
        paramCanvas.drawText(this.mFixedHeaderText, 0.0F, (getMeasuredHeight() - getTextSize()) / 2.0F + getTextSize(), getPaint());
      }
      AppMethodBeat.o(208652);
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
    AppMethodBeat.i(208688);
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
            AppMethodBeat.o(208688);
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
        break label410;
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
            i = 6.$SwitchMap$com$tenpay$android$wechat$TempSecureEditText$EditState[this.mEditState.ordinal()];
            switch (i)
            {
            case 4: 
            default: 
              AppMethodBeat.o(208688);
              return;
            }
          }
          catch (Exception paramCharSequence) {}
          bool = false;
          break;
          setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.mClearBtnImg, getCompoundDrawables()[3]);
          break label268;
          if ((((String)localObject1).length() == this.PASSWD_LENGTH) && (this.mPasswdListener != null))
          {
            this.mPasswdListener.onDone();
            AppMethodBeat.o(208688);
            return;
          }
        }
        AppMethodBeat.o(208688);
        return;
      } while ((((String)localObject1).length() != CVV_PAYMENT_LENGTH) || (this.mPasswdListener == null));
      this.mPasswdListener.onDone();
      AppMethodBeat.o(208688);
      return;
    } while ((((String)localObject1).length() != CVV_4_PAYMENT_LENGTH) || (this.mPasswdListener == null));
    label410:
    this.mPasswdListener.onDone();
    AppMethodBeat.o(208688);
    return;
    Object localObject2;
    if (!this.mIsSelfSet)
    {
      paramInt3 = paramInt1 + paramInt3;
      if (((String)localObject1).length() > 0)
      {
        if (paramInt3 > ((String)localObject1).length()) {
          break label933;
        }
        paramCharSequence = ((String)localObject1).substring(0, paramInt3);
        localObject2 = paramCharSequence.replaceAll(" ", "");
        paramInt1 = paramCharSequence.length() - ((String)localObject2).length();
        label548:
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
          break label703;
        }
        localObject1 = paramCharSequence.substring(0, paramInt3);
        localObject2 = ((String)localObject1).replaceAll(" ", "");
      }
      for (paramInt2 = ((String)localObject1).length() - ((String)localObject2).length();; paramInt2 = paramCharSequence.length() - ((String)localObject1).length())
      {
        this.mIsSelfSet = true;
        setText(paramCharSequence);
        setSelection(paramInt2 + paramInt3 - paramInt1);
        AppMethodBeat.o(208688);
        return;
        label703:
        localObject1 = paramCharSequence.replaceAll(" ", "");
      }
    }
    else
    {
      this.mIsSelfSet = false;
      AppMethodBeat.o(208688);
      return;
      if (!this.mIsSelfSet)
      {
        paramInt1 = ((String)localObject1).length();
        if ((paramInt1 == 0) || (paramInt1 == 1))
        {
          AppMethodBeat.o(208688);
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
            break label938;
          }
          setSelection(1);
          AppMethodBeat.o(208688);
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
      AppMethodBeat.o(208688);
      return;
      setSelection(i);
      label933:
      label938:
      do
      {
        AppMethodBeat.o(208688);
        return;
        this.mIsSelfSet = false;
        break;
        paramInt1 = 0;
        break label548;
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
    AppMethodBeat.i(208654);
    if (((getInputType() & 0x80) > 0) || (EditState.PASSWORD == this.mEditState) || (EditState.CVV_PAYMENT == this.mEditState) || (EditState.CVV_4_PAYMENT == this.mEditState) || (this.mEditState == EditState.IDCARD_TAIL))
    {
      AppMethodBeat.o(208654);
      return true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(208654);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(208614);
    if ((paramMotionEvent.getAction() == 0) && (this.mIsUseOfKinda)) {
      clearFocus();
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(208614);
    return bool;
  }
  
  public final void set3DesEncrptData(String paramString)
  {
    AppMethodBeat.i(208669);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(208669);
      return;
    }
    Encrypt localEncrypt = new Encrypt();
    setText(localEncrypt.desedeDecode(paramString, localEncrypt.getRandomKey()));
    AppMethodBeat.o(208669);
  }
  
  public final void setBankcardTailNum(String paramString)
  {
    AppMethodBeat.i(208642);
    this.mCardTailNum = paramString;
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.mEditState = EditState.BANKCARD_WITH_TAILNUM;
      this.mTitlePaint = new Paint();
      this.mTitlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      this.mTitlePaint.setAntiAlias(true);
      this.mTitlePaint.setTextSize(getTextSize());
      this.mIDCardPaint.setColor(getResources().getColor(R.color.black_color));
    }
    AppMethodBeat.o(208642);
  }
  
  public final void setClearBtnDrawableId(int paramInt)
  {
    AppMethodBeat.i(208589);
    setClearBtnDrawableId(paramInt, 0);
    AppMethodBeat.o(208589);
  }
  
  public final void setClearBtnDrawableId(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208596);
    setClearBtnDrawableId(paramInt1, paramInt2, 0, 0);
    AppMethodBeat.o(208596);
  }
  
  public final void setClearBtnDrawableId(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(208608);
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
      AppMethodBeat.o(208608);
    }
    if (this.mClearBtnImg != null) {
      if ((paramInt3 != 0) && (paramInt4 != 0))
      {
        this.mClearBtnImg.setBounds(0, 0, bd.fromDPToPix(getContext(), paramInt3), bd.fromDPToPix(getContext(), paramInt4));
        setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(208521);
            if (!paramAnonymousBoolean)
            {
              TempSecureEditText.this.setCompoundDrawables(TempSecureEditText.this.getCompoundDrawables()[0], TempSecureEditText.this.getCompoundDrawables()[1], null, TempSecureEditText.this.getCompoundDrawables()[3]);
              AppMethodBeat.o(208521);
              return;
            }
            if ((!TempSecureEditText.this.getText().toString().equals("")) && (TempSecureEditText.EditState.PASSWORD != TempSecureEditText.this.mEditState) && (TempSecureEditText.EditState.CVV_PAYMENT != TempSecureEditText.this.mEditState) && (TempSecureEditText.EditState.CVV_4_PAYMENT != TempSecureEditText.this.mEditState)) {
              TempSecureEditText.this.setCompoundDrawables(TempSecureEditText.this.getCompoundDrawables()[0], TempSecureEditText.this.getCompoundDrawables()[1], TempSecureEditText.this.mClearBtnImg, TempSecureEditText.this.getCompoundDrawables()[3]);
            }
            AppMethodBeat.o(208521);
          }
        });
        setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(208524);
            if ((TempSecureEditText.EditState.PASSWORD != TempSecureEditText.this.mEditState) && (TempSecureEditText.EditState.CVV_PAYMENT != TempSecureEditText.this.mEditState) && (TempSecureEditText.EditState.CVV_4_PAYMENT != TempSecureEditText.this.mEditState))
            {
              paramAnonymousView = TempSecureEditText.this;
              if ((paramAnonymousMotionEvent.getAction() == 1) && (!paramAnonymousView.isFocused()) && (TempSecureEditText.this.mKindaEditTextCallBackListener != null)) {
                TempSecureEditText.this.mKindaEditTextCallBackListener.onCallBackKinda();
              }
              if (paramAnonymousView.getCompoundDrawables()[2] == null)
              {
                AppMethodBeat.o(208524);
                return false;
              }
              if (paramAnonymousMotionEvent.getAction() != 1)
              {
                AppMethodBeat.o(208524);
                return false;
              }
              if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - TempSecureEditText.this.mClearBtnImg.getIntrinsicWidth()) {
                paramAnonymousView.setText("");
              }
            }
            AppMethodBeat.o(208524);
            return false;
          }
        });
        AppMethodBeat.o(208608);
        return;
      }
    }
  }
  
  public final void setCursorStyle(int paramInt)
  {
    AppMethodBeat.i(208692);
    if (paramInt == -1)
    {
      AppMethodBeat.o(208692);
      return;
    }
    try
    {
      Field localField = TextView.class.getDeclaredField("mCursorDrawableRes");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      AppMethodBeat.o(208692);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(208692);
    }
  }
  
  public final void setFilterChar(char[] paramArrayOfChar)
  {
    this.mFilterChar = paramArrayOfChar;
  }
  
  public final void setFixedHeaderText(String paramString)
  {
    AppMethodBeat.i(208650);
    this.mFixedHeaderText = paramString;
    setPadding((int)getPaint().measureText(this.mFixedHeaderText) + getPaddingLeft(), getPaddingTop(), getPaddingBottom(), getPaddingRight());
    invalidate();
    AppMethodBeat.o(208650);
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
    AppMethodBeat.i(208635);
    if (paramBoolean)
    {
      setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      this.mPaintBackground = new Paint(1);
      this.mPaintBackground.setStyle(Paint.Style.FILL);
      this.mIDCardPaint.setColor(getResources().getColor(R.color.black_color));
      this.mEditState = EditState.CVV_4_PAYMENT;
      AppMethodBeat.o(208635);
      return;
    }
    this.mPaintBackground = null;
    if (EditState.CVV_4_PAYMENT == this.mEditState) {
      this.mEditState = EditState.DEFAULT;
    }
    AppMethodBeat.o(208635);
  }
  
  public final void setIsCvvPaymentFormat(boolean paramBoolean)
  {
    AppMethodBeat.i(208632);
    if (paramBoolean)
    {
      setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      this.mPaintBackground = new Paint(1);
      this.mPaintBackground.setStyle(Paint.Style.FILL);
      this.mIDCardPaint.setColor(getResources().getColor(R.color.black_color));
      this.mEditState = EditState.CVV_PAYMENT;
      AppMethodBeat.o(208632);
      return;
    }
    this.mPaintBackground = null;
    if (EditState.CVV_PAYMENT == this.mEditState) {
      this.mEditState = EditState.DEFAULT;
    }
    AppMethodBeat.o(208632);
  }
  
  public final void setIsIdCardTailFormat(boolean paramBoolean)
  {
    AppMethodBeat.i(208629);
    if (paramBoolean)
    {
      setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      this.mEditState = EditState.IDCARD_TAIL;
      this.mIDCardPaint = new Paint();
      this.mIDCardPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      this.mIDCardPaint.setTextAlign(Paint.Align.CENTER);
      this.mIDCardPaint.setAntiAlias(true);
      this.mIDCardPaint.setTextSize(getTextSize());
      this.mIDCardPaint.setColor(getResources().getColor(R.color.black_color));
      AppMethodBeat.o(208629);
      return;
    }
    this.mEditState = EditState.DEFAULT;
    AppMethodBeat.o(208629);
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
    AppMethodBeat.i(208620);
    if (paramBoolean1)
    {
      this.mNewPwdStyle = paramBoolean2;
      setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      this.mPaintBackground = new Paint(1);
      this.mPaintBackground.setStyle(Paint.Style.FILL);
      if (aw.isDarkMode())
      {
        this.mPaintBackground.setColor(getResources().getColor(R.color.BW_100_Alpha_0_8));
        this.mEditState = EditState.PASSWORD;
        this.mPasswdSeparedPaint = new Paint(1);
        this.mPasswdSeparedPaint.setStyle(Paint.Style.STROKE);
        this.mPasswdSeparedPaint.setStrokeWidth(1.5F);
        if (!aw.isDarkMode()) {
          break label206;
        }
        this.mPasswdSeparedPaint.setColor(getResources().getColor(R.color.FG_4));
      }
      for (;;)
      {
        this.mPasswdBgPaint = new Paint(1);
        this.mPasswdBgPaint.setStyle(Paint.Style.FILL);
        if (!aw.isDarkMode()) {
          break label226;
        }
        this.mPasswdBgPaint.setColor(218103807);
        AppMethodBeat.o(208620);
        return;
        this.mPaintBackground.setColor(getResources().getColor(R.color.BW_0));
        break;
        label206:
        this.mPasswdSeparedPaint.setColor(getResources().getColor(R.color.FG_3));
      }
      label226:
      this.mPasswdBgPaint.setColor(getResources().getColor(R.color.BG_0));
      AppMethodBeat.o(208620);
      return;
    }
    this.mPaintBackground = null;
    if (EditState.PASSWORD == this.mEditState) {
      this.mEditState = EditState.DEFAULT;
    }
    AppMethodBeat.o(208620);
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
  
  public final void setPwdLength(int paramInt)
  {
    this.PASSWD_LENGTH = paramInt;
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
    AppMethodBeat.i(208638);
    if ((paramString != null) && (paramString.length() == VALID_THRU_LEN))
    {
      setText(paramString);
      this.mEditState = EditState.VALID_THRU;
    }
    AppMethodBeat.o(208638);
  }
  
  public final void setregExFilterInput(String paramString)
  {
    this.regExFilterInput = paramString;
  }
  
  public static enum EditState
  {
    static
    {
      AppMethodBeat.i(208546);
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
      AppMethodBeat.o(208546);
    }
    
    private EditState() {}
  }
  
  public static enum EncryptMode
  {
    static
    {
      AppMethodBeat.i(208543);
      RSA1024_WITH_MD5 = new EncryptMode("RSA1024_WITH_MD5", 0);
      RSA2048_WITH_MD5 = new EncryptMode("RSA2048_WITH_MD5", 1);
      SM2_WITH_MD5 = new EncryptMode("SM2_WITH_MD5", 2);
      SM2_WITH_PKKDF2 = new EncryptMode("SM2_WITH_PKKDF2", 3);
      $VALUES = new EncryptMode[] { RSA1024_WITH_MD5, RSA2048_WITH_MD5, SM2_WITH_MD5, SM2_WITH_PKKDF2 };
      AppMethodBeat.o(208543);
    }
    
    private EncryptMode() {}
  }
  
  public static abstract interface IKindaEditTextCallBackListener
  {
    public abstract void onCallBackKinda();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tenpay.android.wechat.TempSecureEditText
 * JD-Core Version:    0.7.0.1
 */