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
import android.util.Base64;
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
    AppMethodBeat.i(208602);
    this.minInputLength = DEFAULT_PASSWD_LENGTH;
    this.maxInputLength = DEFAULT_PASSWD_LENGTH;
    this.isFixedInputLength = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(208602);
  }
  
  public MiniAppSecureEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208610);
    this.minInputLength = DEFAULT_PASSWD_LENGTH;
    this.maxInputLength = DEFAULT_PASSWD_LENGTH;
    this.isFixedInputLength = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(208610);
  }
  
  private static String bytesToHex(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(208647);
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      AppMethodBeat.o(208647);
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
    AppMethodBeat.o(208647);
    return paramArrayOfByte;
  }
  
  private void drawPasswdDot(Canvas paramCanvas)
  {
    AppMethodBeat.i(208641);
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
    AppMethodBeat.o(208641);
  }
  
  private String getInputText()
  {
    AppMethodBeat.i(208644);
    String str = super.getText().toString().trim();
    AppMethodBeat.o(208644);
    return str;
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(208616);
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
    AppMethodBeat.o(208616);
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
    AppMethodBeat.i(208621);
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
            AppMethodBeat.i(208577);
            if (!paramAnonymousBoolean) {
              MiniAppSecureEditText.this.setCompoundDrawables(MiniAppSecureEditText.this.getCompoundDrawables()[0], MiniAppSecureEditText.this.getCompoundDrawables()[1], null, MiniAppSecureEditText.this.getCompoundDrawables()[3]);
            }
            AppMethodBeat.o(208577);
          }
        });
        setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return false;
          }
        });
        AppMethodBeat.o(208621);
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
      AppMethodBeat.o(208621);
    }
  }
  
  private void setIsPasswordFormat(boolean paramBoolean)
  {
    AppMethodBeat.i(208627);
    if (paramBoolean)
    {
      setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      this.mPaintBackground = new Paint(1);
      this.mPaintBackground.setStyle(Paint.Style.FILL);
      this.mPaintBackground.setColor(-16777216);
      setInputType(2);
      setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.maxInputLength) });
      AppMethodBeat.o(208627);
      return;
    }
    this.mPaintBackground = null;
    AppMethodBeat.o(208627);
  }
  
  private void setWhiteListChar(char[] paramArrayOfChar)
  {
    this.mWhiteListChar = paramArrayOfChar;
  }
  
  public final void beginCustomHash()
  {
    AppMethodBeat.i(208690);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(208690);
      return;
    }
    this.customHash = getInputText().getBytes();
    AppMethodBeat.o(208690);
  }
  
  public final void customAppendSalt(String paramString)
  {
    AppMethodBeat.i(208699);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(208699);
      return;
    }
    byte[] arrayOfByte = new byte[this.customHash.length + paramString.length()];
    System.arraycopy(this.customHash, 0, arrayOfByte, 0, this.customHash.length);
    System.arraycopy(paramString.getBytes(), 0, arrayOfByte, this.customHash.length, paramString.length());
    this.customHash = arrayOfByte;
    AppMethodBeat.o(208699);
  }
  
  public final void customInsertSalt(String paramString)
  {
    AppMethodBeat.i(208698);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(208698);
      return;
    }
    byte[] arrayOfByte = new byte[this.customHash.length + paramString.length()];
    System.arraycopy(paramString.getBytes(), 0, arrayOfByte, 0, paramString.length());
    System.arraycopy(this.customHash, 0, arrayOfByte, paramString.length(), this.customHash.length);
    this.customHash = arrayOfByte;
    AppMethodBeat.o(208698);
  }
  
  public final void customPasswdEncode(EEncodeType paramEEncodeType)
  {
    AppMethodBeat.i(208697);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(208697);
      return;
    }
    switch (6.$SwitchMap$com$tenpay$miniapp$MiniAppSecureEditText$EEncodeType[paramEEncodeType.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208697);
      return;
      this.customHash = Base64.encode(this.customHash, 0);
      AppMethodBeat.o(208697);
      return;
      this.customHash = bytesToHex(this.customHash).getBytes();
      AppMethodBeat.o(208697);
      return;
      this.customHash = bytesToHex(this.customHash).toUpperCase().getBytes();
    }
  }
  
  public final void customPasswdMd5()
  {
    AppMethodBeat.i(208696);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(208696);
      return;
    }
    this.customHash = this.fitScUtil.md5(this.customHash);
    AppMethodBeat.o(208696);
  }
  
  public final void customPasswdSha1()
  {
    AppMethodBeat.i(208695);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(208695);
      return;
    }
    this.customHash = this.fitScUtil.sha1(this.customHash);
    AppMethodBeat.o(208695);
  }
  
  public final void customPasswdSha256()
  {
    AppMethodBeat.i(208693);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(208693);
      return;
    }
    this.customHash = this.fitScUtil.sha256(this.customHash);
    AppMethodBeat.o(208693);
  }
  
  public final void customPasswdSm3()
  {
    AppMethodBeat.i(208691);
    if (TextUtils.isEmpty(getInputText()))
    {
      AppMethodBeat.o(208691);
      return;
    }
    this.customHash = this.fitScUtil.sm3(this.customHash);
    AppMethodBeat.o(208691);
  }
  
  public final String endCustomHashAndEncrypt(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(208703);
    String str = getInputText();
    if ((TextUtils.isEmpty(str)) || (str.length() < this.minInputLength) || (this.fitScUtil == null) || (this.customHash == null) || (paramLong1 == 0L) || (paramLong2 == 0L))
    {
      AppMethodBeat.o(208703);
      return null;
    }
    str = bytesToHex(this.customHash);
    str = this.fitScUtil.encryptPass(this.certPem, str.getBytes(), null, paramLong1, String.valueOf(paramLong2), 0);
    this.customHash = null;
    AppMethodBeat.o(208703);
    return str;
  }
  
  public final String getEncryptedData()
  {
    AppMethodBeat.i(208689);
    String str = getInputText();
    if ((TextUtils.isEmpty(str)) || (str.length() < this.minInputLength) || (this.salt == null) || (this.timeStamp == 0L) || (this.nonce == 0L))
    {
      AppMethodBeat.o(208689);
      return null;
    }
    str = this.fitScUtil.encryptPass(this.certPem, str.getBytes(), this.salt.getBytes(), this.timeStamp, String.valueOf(this.nonce), 7);
    AppMethodBeat.o(208689);
    return str;
  }
  
  public final int getLastError()
  {
    AppMethodBeat.i(208681);
    int i = this.fitScUtil.getLastError();
    AppMethodBeat.o(208681);
    return i;
  }
  
  public final String getVersion()
  {
    AppMethodBeat.i(208677);
    String str = this.fitScUtil.getVersion();
    AppMethodBeat.o(208677);
    return str;
  }
  
  protected final void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    AppMethodBeat.i(208664);
    if ((getInputType() & 0x80) <= 0) {
      super.onCreateContextMenu(paramContextMenu);
    }
    AppMethodBeat.o(208664);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(208671);
    if (this.fitScUtil != null) {
      this.fitScUtil.release();
    }
    super.onDetachedFromWindow();
    AppMethodBeat.o(208671);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(208659);
    drawPasswdDot(paramCanvas);
    AppMethodBeat.o(208659);
  }
  
  protected final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(208667);
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      AppMethodBeat.o(208667);
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
        AppMethodBeat.o(208667);
        return;
      }
      paramInt2 += 1;
    }
    if ((this.isFixedInputLength) && (paramCharSequence.length() == this.maxInputLength) && (this.mPasswdListener != null)) {
      this.mPasswdListener.onDone();
    }
    AppMethodBeat.o(208667);
  }
  
  public final boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(208662);
    if ((getInputType() & 0x80) > 0)
    {
      AppMethodBeat.o(208662);
      return true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(208662);
    return bool;
  }
  
  public final boolean setCertContext(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(208675);
    this.fitScUtil = new FitScUtil();
    this.certPem = paramString1;
    boolean bool = this.fitScUtil.init(paramString2, paramString3, null, null);
    AppMethodBeat.o(208675);
    return bool;
  }
  
  public final void setInputLength(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    AppMethodBeat.i(208656);
    this.minInputLength = paramInt1;
    this.maxInputLength = paramInt2;
    setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt2) });
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      this.isFixedInputLength = bool;
      AppMethodBeat.o(208656);
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
  
  public static enum EEncodeType
  {
    static
    {
      AppMethodBeat.i(208587);
      THexLowerCase = new EEncodeType("THexLowerCase", 0);
      THexUpperCase = new EEncodeType("THexUpperCase", 1);
      TBase64 = new EEncodeType("TBase64", 2);
      $VALUES = new EEncodeType[] { THexLowerCase, THexUpperCase, TBase64 };
      AppMethodBeat.o(208587);
    }
    
    private EEncodeType() {}
  }
  
  public static abstract interface OnPasswdInputListener
  {
    public abstract void onDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tenpay.miniapp.MiniAppSecureEditText
 * JD-Core Version:    0.7.0.1
 */