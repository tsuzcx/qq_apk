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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
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
  private final int BG_LINE_COLOR;
  private final int BG_LINE_HEIGHT;
  private final int BG_LINE_SIZE;
  private final String TAG;
  private Context mContext;
  private List<EditText> mEditArray;
  TenpaySegmentEditText.EditState mEditState;
  private MyKeyboardWindow mKeyboard;
  private boolean mNoFocus;
  private View.OnClickListener mOnClickListener;
  private Paint mPaintBg;
  private Paint mPaintSplit;
  
  public TenpaySegmentEditText(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(49524);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(49524);
  }
  
  public TenpaySegmentEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49525);
    this.TAG = "MyTag";
    this.BG_LINE_COLOR = -11615450;
    this.BG_LINE_SIZE = 4;
    this.BG_LINE_HEIGHT = 9;
    this.mOnClickListener = null;
    this.mNoFocus = true;
    this.mEditState = TenpaySegmentEditText.EditState.DEFAULT;
    this.mContext = null;
    this.mEditArray = new ArrayList();
    this.mKeyboard = null;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(49525);
  }
  
  private void drawBackgroundLine(Canvas paramCanvas)
  {
    AppMethodBeat.i(49531);
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
        break label160;
      }
    }
    label160:
    for (j = -4;; j = -2)
    {
      f1 += ((EditText)this.mEditArray.get(i)).getWidth() + j;
      paramCanvas.drawRect(f1, f3, f1 + 4.0F, f2, this.mPaintBg);
      float f4 = j;
      i += 1;
      f1 -= f4;
      break;
      AppMethodBeat.o(49531);
      return;
    }
  }
  
  private String getInputText()
  {
    AppMethodBeat.i(49532);
    Object localObject = new StringBuffer();
    int i = 0;
    while (i < this.mEditArray.size())
    {
      ((StringBuffer)localObject).append(((EditText)this.mEditArray.get(i)).getText().toString());
      i += 1;
    }
    localObject = ((StringBuffer)localObject).toString();
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      AppMethodBeat.o(49532);
      return null;
    }
    ((String)localObject).trim().replaceAll(" ", "");
    AppMethodBeat.o(49532);
    return localObject;
  }
  
  private void init()
  {
    AppMethodBeat.i(49526);
    setBackgroundColor(-1);
    setOrientation(0);
    setIsBankcardFormat(true);
    this.mPaintSplit = new Paint();
    this.mPaintSplit.setStrokeWidth(0.0F);
    this.mPaintSplit.setColor(-7829368);
    this.mPaintBg = new Paint();
    this.mPaintBg.setColor(-11615450);
    this.mPaintBg.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(49526);
  }
  
  private boolean isMatchPattern(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49536);
    if (paramString2 != null) {
      try
      {
        boolean bool = Pattern.compile(paramString2).matcher(paramString1).matches();
        AppMethodBeat.o(49536);
        return bool;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(49536);
        return false;
      }
    }
    AppMethodBeat.o(49536);
    return false;
  }
  
  public static void setNoSystemInputOnEditText(EditText paramEditText)
  {
    AppMethodBeat.i(49538);
    if (Build.VERSION.SDK_INT < 11)
    {
      paramEditText.setInputType(0);
      AppMethodBeat.o(49538);
      return;
    }
    try
    {
      Method localMethod1 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { Boolean.TYPE });
      localMethod1.setAccessible(true);
      localMethod1.invoke(paramEditText, new Object[] { Boolean.FALSE });
      AppMethodBeat.o(49538);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
        localMethod2.setAccessible(true);
        localMethod2.invoke(paramEditText, new Object[] { Boolean.FALSE });
        AppMethodBeat.o(49538);
        return;
      }
      catch (Exception localException)
      {
        paramEditText.setInputType(0);
        AppMethodBeat.o(49538);
        return;
      }
    }
    catch (Exception paramEditText)
    {
      AppMethodBeat.o(49538);
    }
  }
  
  public static void setSalt(String paramString)
  {
    mTimeStamp = paramString;
  }
  
  public final void ClearInput() {}
  
  public final String get3DesEncrptData()
  {
    AppMethodBeat.i(49534);
    String str = getInputText();
    if ((str == null) || (str.length() == 0))
    {
      AppMethodBeat.o(49534);
      return null;
    }
    Encrypt localEncrypt = new Encrypt();
    str = localEncrypt.desedeEncode(str, localEncrypt.getRandomKey());
    AppMethodBeat.o(49534);
    return str;
  }
  
  public final String getEncryptDataWithHash(boolean paramBoolean)
  {
    AppMethodBeat.i(49533);
    Object localObject2 = getInputText();
    if ((localObject2 == null) || (((String)localObject2).length() == 0))
    {
      AppMethodBeat.o(49533);
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
    b.dRI();
    if (b.dRJ())
    {
      localObject1 = ((Encrypt)localObject2).encryptPasswdWithRSA2048((String)localObject1);
      AppMethodBeat.o(49533);
      return localObject1;
    }
    localObject1 = ((Encrypt)localObject2).encryptPasswd((String)localObject1);
    AppMethodBeat.o(49533);
    return localObject1;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(49537);
    String str = getInputText();
    if (str == null)
    {
      AppMethodBeat.o(49537);
      return 0;
    }
    int i = str.length();
    AppMethodBeat.o(49537);
    return i;
  }
  
  public final boolean isMatchPattern(String paramString)
  {
    AppMethodBeat.i(49535);
    if (paramString != null) {
      try
      {
        String str = getInputText();
        boolean bool = Pattern.compile(paramString).matcher(str).matches();
        AppMethodBeat.o(49535);
        return bool;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(49535);
        return false;
      }
    }
    AppMethodBeat.o(49535);
    return false;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(49530);
    super.onDraw(paramCanvas);
    drawBackgroundLine(paramCanvas);
    AppMethodBeat.o(49530);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(49529);
    LogUtil.d("MyTag", new Object[] { "setFocusable ".concat(String.valueOf(paramBoolean)) });
    int i = 0;
    while (i < this.mEditArray.size())
    {
      EditText localEditText = (EditText)this.mEditArray.get(i);
      localEditText.setFocusable(paramBoolean);
      localEditText.setFocusableInTouchMode(paramBoolean);
      i += 1;
    }
    AppMethodBeat.o(49529);
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
    AppMethodBeat.i(49527);
    setText(paramString, null);
    AppMethodBeat.o(49527);
  }
  
  public final void setText(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49528);
    Encrypt localEncrypt = new Encrypt();
    String str = paramString2;
    if (bo.isNullOrNil(paramString2)) {
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
    AppMethodBeat.o(49528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tenpay.bankcard.TenpaySegmentEditText
 * JD-Core Version:    0.7.0.1
 */