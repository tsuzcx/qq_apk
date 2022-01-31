package com.tenpay.bankcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.b;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpayUtil;
import com.tenpay.ndk.Encrypt;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TenpaySegmentEditText
  extends LinearLayout
{
  private static String mTimeStamp;
  private final int BG_LINE_COLOR = -11615450;
  private final int BG_LINE_HEIGHT = 9;
  private final int BG_LINE_SIZE = 4;
  private final String TAG = "MyTag";
  private Context mContext = null;
  private List<EditText> mEditArray = new ArrayList();
  TenpaySegmentEditText.EditState mEditState = TenpaySegmentEditText.EditState.DEFAULT;
  private MyKeyboardWindow mKeyboard = null;
  private boolean mNoFocus = true;
  private View.OnClickListener mOnClickListener = null;
  private Paint mPaintBg;
  private Paint mPaintSplit;
  
  public TenpaySegmentEditText(Context paramContext)
  {
    this(paramContext, null);
    this.mContext = paramContext;
    init();
  }
  
  public TenpaySegmentEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  private void drawBackgroundLine(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    float f2 = j - 4;
    paramCanvas.drawRect(0.0F, f2, i, j, this.mPaintBg);
    float f3 = f2 - 9.0F;
    int k = this.mEditArray.size();
    paramCanvas.drawRect(0.0F, f3, 4.0F, f2, this.mPaintBg);
    i = 0;
    float f1 = 0.0F;
    if (i < k) {
      if (i != k - 1) {
        break label150;
      }
    }
    label150:
    for (j = -4;; j = -2)
    {
      f1 += ((EditText)this.mEditArray.get(i)).getWidth() + j;
      paramCanvas.drawRect(f1, f3, f1 + 4.0F, f2, this.mPaintBg);
      float f4 = j;
      i += 1;
      f1 -= f4;
      break;
      return;
    }
  }
  
  private String getInputText()
  {
    Object localObject = new StringBuffer();
    int i = 0;
    while (i < this.mEditArray.size())
    {
      ((StringBuffer)localObject).append(((EditText)this.mEditArray.get(i)).getText().toString());
      i += 1;
    }
    localObject = ((StringBuffer)localObject).toString();
    if ((localObject == null) || (((String)localObject).length() == 0)) {
      return null;
    }
    ((String)localObject).trim().replaceAll(" ", "");
    return localObject;
  }
  
  private void init()
  {
    setBackgroundColor(-1);
    setOrientation(0);
    setIsBankcardFormat(true);
    this.mPaintSplit = new Paint();
    this.mPaintSplit.setStrokeWidth(0.0F);
    this.mPaintSplit.setColor(-7829368);
    this.mPaintBg = new Paint();
    this.mPaintBg.setColor(-11615450);
    this.mPaintBg.setStyle(Paint.Style.FILL);
  }
  
  private boolean isMatchPattern(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (paramString2 != null) {}
    try
    {
      bool = Pattern.compile(paramString2).matcher(paramString1).matches();
      return bool;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  public static void setNoSystemInputOnEditText(EditText paramEditText)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      paramEditText.setInputType(0);
      return;
    }
    try
    {
      Method localMethod1 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { Boolean.TYPE });
      localMethod1.setAccessible(true);
      localMethod1.invoke(paramEditText, new Object[] { Boolean.valueOf(false) });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
        localMethod2.setAccessible(true);
        localMethod2.invoke(paramEditText, new Object[] { Boolean.valueOf(false) });
        return;
      }
      catch (Exception localException)
      {
        paramEditText.setInputType(0);
        return;
      }
    }
    catch (Exception paramEditText) {}
  }
  
  public static void setSalt(String paramString)
  {
    mTimeStamp = paramString;
  }
  
  public final void ClearInput() {}
  
  public final String get3DesEncrptData()
  {
    String str = getInputText();
    if ((str == null) || (str.length() == 0)) {
      return null;
    }
    Encrypt localEncrypt = new Encrypt();
    return localEncrypt.desedeEncode(str, localEncrypt.getRandomKey());
  }
  
  public final String getEncryptDataWithHash(boolean paramBoolean)
  {
    Object localObject2 = getInputText();
    if ((localObject2 == null) || (((String)localObject2).length() == 0)) {
      return null;
    }
    Object localObject1 = localObject2;
    if (paramBoolean) {
      localObject1 = TenpayUtil.md5HexDigest((String)localObject2);
    }
    localObject2 = new Encrypt();
    if (mTimeStamp != null) {
      ((Encrypt)localObject2).setTimeStamp(mTimeStamp);
    }
    b.cMj();
    if (b.cMk()) {
      return ((Encrypt)localObject2).encryptPasswdWithRSA2048((String)localObject1);
    }
    return ((Encrypt)localObject2).encryptPasswd((String)localObject1);
  }
  
  public final int getInputLength()
  {
    String str = getInputText();
    if (str == null) {
      return 0;
    }
    return str.length();
  }
  
  public final boolean isMatchPattern(String paramString)
  {
    boolean bool = false;
    if (paramString != null) {}
    try
    {
      String str = getInputText();
      bool = Pattern.compile(paramString).matcher(str).matches();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    drawBackgroundLine(paramCanvas);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    LogUtil.d("MyTag", new Object[] { "setFocusable " + paramBoolean });
    int i = 0;
    while (i < this.mEditArray.size())
    {
      EditText localEditText = (EditText)this.mEditArray.get(i);
      localEditText.setFocusable(paramBoolean);
      localEditText.setFocusableInTouchMode(paramBoolean);
      i += 1;
    }
  }
  
  public final void setIsBankcardFormat(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mEditState = TenpaySegmentEditText.EditState.BANKCARD;
    }
    while (TenpaySegmentEditText.EditState.BANKCARD != this.mEditState) {
      return;
    }
    this.mEditState = TenpaySegmentEditText.EditState.DEFAULT;
  }
  
  public final void setKeyboard(MyKeyboardWindow paramMyKeyboardWindow)
  {
    this.mKeyboard = paramMyKeyboardWindow;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public final void setText(String paramString)
  {
    setText(paramString, null);
  }
  
  public final void setText(String paramString1, String paramString2)
  {
    Encrypt localEncrypt = new Encrypt();
    String str = paramString2;
    if (bk.bl(paramString2)) {
      str = localEncrypt.getRandomKey();
    }
    paramString1 = localEncrypt.desedeDecode(paramString1, str).split("-");
    removeAllViews();
    this.mNoFocus = true;
    this.mEditArray.clear();
    int i = 0;
    while (i < paramString1.length)
    {
      paramString2 = new EditText(this.mContext);
      paramString2.setText(paramString1[i]);
      paramString2.setMaxLines(1);
      paramString2.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramString1[i].length()) });
      paramString2.setGravity(17);
      paramString2.setInputType(2);
      paramString2.setBackgroundColor(0);
      paramString2.setSelectAllOnFocus(true);
      paramString2.setOnClickListener(new TenpaySegmentEditText.1(this, paramString2));
      setNoSystemInputOnEditText(paramString2);
      ((InputMethodManager)this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(paramString2.getWindowToken(), 2);
      paramString2.setOnFocusChangeListener(new TenpaySegmentEditText.2(this, paramString2));
      addView(paramString2, new LinearLayout.LayoutParams(-2, -1, paramString1[i].length()));
      this.mEditArray.add(paramString2);
      i += 1;
    }
    setFocusable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tenpay.bankcard.TenpaySegmentEditText
 * JD-Core Version:    0.7.0.1
 */