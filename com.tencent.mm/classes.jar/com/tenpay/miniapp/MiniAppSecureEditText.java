package com.tenpay.miniapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import androidx.appcompat.widget.AppCompatEditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.ndk.FitScUtil;

public final class MiniAppSecureEditText
  extends AppCompatEditText
{
  private static int DEFAULT_PASSWD_LENGTH = 6;
  private static int PASSWD_BLACK_DOT_SIZE = 7;
  private static int PASSWD_LEFT_PADDING = -1500000;
  private String certPem;
  private byte[] customHash;
  private FitScUtil fitScUtil;
  private boolean isFixedInputLength;
  private char[] mBlackListChar;
  private Drawable mClearBtnImg;
  private float mDensity;
  private Paint mPaintBackground;
  private OnPasswdInputListener mPasswdListener;
  private char[] mWhiteListChar;
  private int maxInputLength;
  private int minInputLength;
  private long nonce;
  private String salt;
  private long timeStamp;
  
  public MiniAppSecureEditText(Context paramContext)
  {
    super(paramContext, null);
    this.minInputLength = DEFAULT_PASSWD_LENGTH;
    this.maxInputLength = DEFAULT_PASSWD_LENGTH;
    this.isFixedInputLength = true;
  }
  
  public MiniAppSecureEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(231294);
    this.minInputLength = DEFAULT_PASSWD_LENGTH;
    this.maxInputLength = DEFAULT_PASSWD_LENGTH;
    this.isFixedInputLength = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(231294);
  }
  
  public MiniAppSecureEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(231296);
    this.minInputLength = DEFAULT_PASSWD_LENGTH;
    this.maxInputLength = DEFAULT_PASSWD_LENGTH;
    this.isFixedInputLength = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(231296);
  }
  
  private static String bytesToHex(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(231328);
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      AppMethodBeat.o(231328);
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str.toLowerCase());
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(231328);
    return paramArrayOfByte;
  }
  
  private void drawPasswdDot(Canvas paramCanvas)
  {
    AppMethodBeat.i(231307);
    int i = getWidth();
    int j = getHeight();
    int k = i / this.maxInputLength;
    int m = getInputText().length();
    i = 0;
    while (i < m)
    {
      paramCanvas.drawCircle(k / 2 + i * k, j / 2, PASSWD_BLACK_DOT_SIZE * this.mDensity, this.mPaintBackground);
      i += 1;
    }
    AppMethodBeat.o(231307);
  }
  
  private String getInputText()
  {
    AppMethodBeat.i(231313);
    String str = super.getText().toString().trim();
    AppMethodBeat.o(231313);
    return str;
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(231297);
    this.mDensity = getResources().getDisplayMetrics().density;
    setIsPasswordFormat(true);
    addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (Build.VERSION.SDK_INT >= 14) {
      setAccessibilityDelegate(new TenpayAccessibilityDelegate());
    }
    AppMethodBeat.o(231297);
  }
  
  private boolean isValidChar(char paramChar)
  {
    char[] arrayOfChar;
    int j;
    if (this.mWhiteListChar != null)
    {
      arrayOfChar = this.mWhiteListChar;
      j = arrayOfChar.length;
      i = 0;
      if (i >= j) {
        break label88;
      }
      if (arrayOfChar[i] != paramChar) {}
    }
    label86:
    label88:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        return false;
        i += 1;
        break;
      }
      if (this.mBlackListChar != null)
      {
        arrayOfChar = this.mWhiteListChar;
        j = arrayOfChar.length;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label86;
          }
          if (arrayOfChar[i] == paramChar) {
            break;
          }
          i += 1;
        }
      }
      return true;
    }
  }
  
  private void setBlackListChar(char[] paramArrayOfChar)
  {
    this.mBlackListChar = paramArrayOfChar;
  }
  
  private void setClearBtnDrawableId(int paramInt)
  {
    AppMethodBeat.i(231298);
    try
    {
      this.mClearBtnImg = getResources().getDrawable(paramInt);
      if (this.mClearBtnImg != null)
      {
        this.mClearBtnImg.setBounds(0, 0, this.mClearBtnImg.getIntrinsicWidth(), this.mClearBtnImg.getIntrinsicHeight());
        setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(231289);
            if (!paramAnonymousBoolean) {
              MiniAppSecureEditText.this.setCompoundDrawables(MiniAppSecureEditText.this.getCompoundDrawables()[0], MiniAppSecureEditText.this.getCompoundDrawables()[1], null, MiniAppSecureEditText.this.getCompoundDrawables()[3]);
            }
            AppMethodBeat.o(231289);
          }
        });
        setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return false;
          }
        });
        AppMethodBeat.o(231298);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.mClearBtnImg = null;
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
      AppMethodBeat.o(231298);
    }
  }
  
  private void setIsPasswordFormat(boolean paramBoolean)
  {
    AppMethodBeat.i(231300);
    if (paramBoolean)
    {
      setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      this.mPaintBackground = new Paint(1);
      this.mPaintBackground.setStyle(Paint.Style.FILL);
      this.mPaintBackground.setColor(-16777216);
      setInputType(2);
      setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.maxInputLength) });
      AppMethodBeat.o(231300);
      return;
    }
    this.mPaintBackground = null;
    AppMethodBeat.o(231300);
  }
  
  private void setWhiteListChar(char[] paramArrayOfChar)
  {
    this.mWhiteListChar = paramArrayOfChar;
  }
  
  public final void beginCustomHash()
  {
    AppMethodBeat.i(231331);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(231331);
      return;
    }
    this.customHash = getInputText().getBytes();
    AppMethodBeat.o(231331);
  }
  
  public final void customAppendSalt(String paramString)
  {
    AppMethodBeat.i(231347);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(231347);
      return;
    }
    byte[] arrayOfByte = new byte[this.customHash.length + paramString.length()];
    System.arraycopy(this.customHash, 0, arrayOfByte, 0, this.customHash.length);
    System.arraycopy(paramString.getBytes(), 0, arrayOfByte, this.customHash.length, paramString.length());
    this.customHash = arrayOfByte;
    AppMethodBeat.o(231347);
  }
  
  public final void customInsertSalt(String paramString)
  {
    AppMethodBeat.i(231345);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(231345);
      return;
    }
    byte[] arrayOfByte = new byte[this.customHash.length + paramString.length()];
    System.arraycopy(paramString.getBytes(), 0, arrayOfByte, 0, paramString.length());
    System.arraycopy(this.customHash, 0, arrayOfByte, paramString.length(), this.customHash.length);
    this.customHash = arrayOfByte;
    AppMethodBeat.o(231345);
  }
  
  public final void customPasswdMd5()
  {
    AppMethodBeat.i(231342);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(231342);
      return;
    }
    this.customHash = this.fitScUtil.md5(this.customHash);
    AppMethodBeat.o(231342);
  }
  
  public final void customPasswdSha1()
  {
    AppMethodBeat.i(231339);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(231339);
      return;
    }
    this.customHash = this.fitScUtil.sha1(this.customHash);
    AppMethodBeat.o(231339);
  }
  
  public final void customPasswdSha256()
  {
    AppMethodBeat.i(231338);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(231338);
      return;
    }
    this.customHash = this.fitScUtil.sha256(this.customHash);
    AppMethodBeat.o(231338);
  }
  
  public final void customPasswdSm3()
  {
    AppMethodBeat.i(231334);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(231334);
      return;
    }
    this.customHash = this.fitScUtil.sm3(this.customHash);
    AppMethodBeat.o(231334);
  }
  
  public final String endCustomHashAndEncrypt(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(231349);
    String str = getInputText();
    if ((TextUtils.isEmpty(str)) || (str.length() < this.minInputLength) || (this.fitScUtil == null) || (this.customHash == null) || (paramLong1 == 0L) || (paramLong2 == 0L))
    {
      AppMethodBeat.o(231349);
      return null;
    }
    str = bytesToHex(this.customHash);
    str = this.fitScUtil.encryptPass(this.certPem, str.getBytes(), null, paramLong1, paramLong2, 0);
    this.customHash = null;
    AppMethodBeat.o(231349);
    return str;
  }
  
  public final String getEncryptedData()
  {
    AppMethodBeat.i(231324);
    String str = getInputText();
    if ((TextUtils.isEmpty(str)) || (str.length() < this.minInputLength) || (this.salt == null) || (this.timeStamp == 0L) || (this.nonce == 0L))
    {
      AppMethodBeat.o(231324);
      return null;
    }
    new StringBuilder("certPem = ").append(this.certPem);
    new StringBuilder("certPem.length() = ").append(this.certPem.length());
    new StringBuilder("salt = ").append(this.salt);
    new StringBuilder("timeStamp = ").append(this.timeStamp);
    new StringBuilder("nonce = ").append(this.nonce);
    str = this.fitScUtil.encryptPass(this.certPem, str.getBytes(), this.salt.getBytes(), this.timeStamp, this.nonce, 7);
    AppMethodBeat.o(231324);
    return str;
  }
  
  public final int getLastError()
  {
    AppMethodBeat.i(231322);
    int i = this.fitScUtil.getLastError();
    AppMethodBeat.o(231322);
    return i;
  }
  
  public final String getVersion()
  {
    AppMethodBeat.i(231321);
    String str = this.fitScUtil.getVersion();
    AppMethodBeat.o(231321);
    return str;
  }
  
  protected final void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    AppMethodBeat.i(231311);
    if ((getInputType() & 0x80) <= 0) {
      super.onCreateContextMenu(paramContextMenu);
    }
    AppMethodBeat.o(231311);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(231317);
    if (this.fitScUtil != null) {
      this.fitScUtil.release();
    }
    super.onDetachedFromWindow();
    AppMethodBeat.o(231317);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(231306);
    drawPasswdDot(paramCanvas);
    AppMethodBeat.o(231306);
  }
  
  protected final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(231316);
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      AppMethodBeat.o(231316);
      return;
    }
    paramInt2 = paramInt1;
    while (paramInt2 < paramInt1 + paramInt3)
    {
      if (!isValidChar(paramCharSequence.charAt(paramInt2)))
      {
        paramCharSequence = paramCharSequence.toString();
        setText(paramCharSequence.substring(0, paramInt2) + paramCharSequence.substring(paramInt2 + 1));
        setSelection(paramInt2);
        AppMethodBeat.o(231316);
        return;
      }
      paramInt2 += 1;
    }
    if ((this.isFixedInputLength) && (paramCharSequence.length() == this.maxInputLength) && (this.mPasswdListener != null)) {
      this.mPasswdListener.onDone();
    }
    AppMethodBeat.o(231316);
  }
  
  public final boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(231309);
    if ((getInputType() & 0x80) > 0)
    {
      AppMethodBeat.o(231309);
      return true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(231309);
    return bool;
  }
  
  public final boolean setCertContext(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(231319);
    this.fitScUtil = new FitScUtil();
    this.certPem = paramString1;
    boolean bool = this.fitScUtil.init(paramString2, paramString3, null, null);
    AppMethodBeat.o(231319);
    return bool;
  }
  
  public final void setInputLength(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(231301);
    this.minInputLength = paramInt1;
    this.maxInputLength = paramInt2;
    setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt2) });
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      this.isFixedInputLength = bool;
      AppMethodBeat.o(231301);
      return;
      bool = false;
    }
  }
  
  public final void setNonce(long paramLong)
  {
    this.nonce = paramLong;
  }
  
  public final void setOnPasswdInputListener(OnPasswdInputListener paramOnPasswdInputListener)
  {
    this.mPasswdListener = paramOnPasswdInputListener;
  }
  
  public final void setSalt(String paramString)
  {
    this.salt = paramString;
  }
  
  public final void setTimeStamp(long paramLong)
  {
    this.timeStamp = paramLong;
  }
  
  public static abstract interface OnPasswdInputListener
  {
    public abstract void onDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tenpay.miniapp.MiniAppSecureEditText
 * JD-Core Version:    0.7.0.1
 */