package com.tenpay.bankcard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
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
    AppMethodBeat.i(73272);
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(73272);
  }
  
  public TenpaySegmentEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73273);
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
    AppMethodBeat.o(73273);
  }
  
  private void drawBackgroundLine(Canvas paramCanvas)
  {
    AppMethodBeat.i(73279);
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
      AppMethodBeat.o(73279);
      return;
    }
  }
  
  private String getInputText()
  {
    AppMethodBeat.i(73280);
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
      AppMethodBeat.o(73280);
      return null;
    }
    ((String)localObject).trim().replaceAll(" ", "");
    AppMethodBeat.o(73280);
    return localObject;
  }
  
  private void init()
  {
    AppMethodBeat.i(73274);
    setBackgroundColor(getResources().getColor(2131101179));
    setOrientation(0);
    setIsBankcardFormat(true);
    this.mPaintSplit = new Paint();
    this.mPaintSplit.setStrokeWidth(0.0F);
    this.mPaintSplit.setColor(-7829368);
    this.mPaintBg = new Paint();
    this.mPaintBg.setColor(-11615450);
    this.mPaintBg.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(73274);
  }
  
  private boolean isMatchPattern(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73284);
    if (paramString2 != null) {
      try
      {
        boolean bool = Pattern.compile(paramString2).matcher(paramString1).matches();
        AppMethodBeat.o(73284);
        return bool;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(73284);
        return false;
      }
    }
    AppMethodBeat.o(73284);
    return false;
  }
  
  public static void setNoSystemInputOnEditText(EditText paramEditText)
  {
    AppMethodBeat.i(73286);
    if (Build.VERSION.SDK_INT < 11)
    {
      paramEditText.setInputType(0);
      AppMethodBeat.o(73286);
      return;
    }
    try
    {
      Method localMethod1 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { Boolean.TYPE });
      localMethod1.setAccessible(true);
      localMethod1.invoke(paramEditText, new Object[] { Boolean.FALSE });
      AppMethodBeat.o(73286);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
        localMethod2.setAccessible(true);
        localMethod2.invoke(paramEditText, new Object[] { Boolean.FALSE });
        AppMethodBeat.o(73286);
        return;
      }
      catch (Exception localException)
      {
        paramEditText.setInputType(0);
        AppMethodBeat.o(73286);
        return;
      }
    }
    catch (Exception paramEditText)
    {
      AppMethodBeat.o(73286);
    }
  }
  
  public static void setSalt(String paramString)
  {
    mTimeStamp = paramString;
  }
  
  public final void ClearInput() {}
  
  public final String get3DesEncrptData()
  {
    AppMethodBeat.i(73282);
    String str = getInputText();
    if ((str == null) || (str.length() == 0))
    {
      AppMethodBeat.o(73282);
      return null;
    }
    Encrypt localEncrypt = new Encrypt();
    str = localEncrypt.desedeEncode(str, localEncrypt.getRandomKey());
    AppMethodBeat.o(73282);
    return str;
  }
  
  public final String getEncryptDataWithHash(boolean paramBoolean)
  {
    AppMethodBeat.i(73281);
    Object localObject2 = getInputText();
    if ((localObject2 == null) || (((String)localObject2).length() == 0))
    {
      AppMethodBeat.o(73281);
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
    b.fjk();
    if (b.fjl())
    {
      localObject1 = ((Encrypt)localObject2).encryptPasswdWithRSA2048((String)localObject1);
      AppMethodBeat.o(73281);
      return localObject1;
    }
    localObject1 = ((Encrypt)localObject2).encryptPasswd((String)localObject1);
    AppMethodBeat.o(73281);
    return localObject1;
  }
  
  public final int getInputLength()
  {
    AppMethodBeat.i(73285);
    String str = getInputText();
    if (str == null)
    {
      AppMethodBeat.o(73285);
      return 0;
    }
    int i = str.length();
    AppMethodBeat.o(73285);
    return i;
  }
  
  public final boolean isMatchPattern(String paramString)
  {
    AppMethodBeat.i(73283);
    if (paramString != null) {
      try
      {
        String str = getInputText();
        boolean bool = Pattern.compile(paramString).matcher(str).matches();
        AppMethodBeat.o(73283);
        return bool;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(73283);
        return false;
      }
    }
    AppMethodBeat.o(73283);
    return false;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(73278);
    super.onDraw(paramCanvas);
    drawBackgroundLine(paramCanvas);
    AppMethodBeat.o(73278);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(73277);
    LogUtil.d("MyTag", new Object[] { "setFocusable ".concat(String.valueOf(paramBoolean)) });
    int i = 0;
    while (i < this.mEditArray.size())
    {
      EditText localEditText = (EditText)this.mEditArray.get(i);
      localEditText.setFocusable(paramBoolean);
      localEditText.setFocusableInTouchMode(paramBoolean);
      i += 1;
    }
    AppMethodBeat.o(73277);
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
    AppMethodBeat.i(73275);
    setText(paramString, null);
    AppMethodBeat.o(73275);
  }
  
  public final void setText(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(73276);
    Encrypt localEncrypt = new Encrypt();
    String str = paramString2;
    if (bt.isNullOrNil(paramString2)) {
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
      paramString2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73267);
          if (TenpaySegmentEditText.this.mOnClickListener != null) {
            TenpaySegmentEditText.this.mOnClickListener.onClick(paramAnonymousView);
          }
          if (TenpaySegmentEditText.this.mNoFocus)
          {
            TenpaySegmentEditText.this.setFocusable(true);
            paramString2.requestFocus();
            TenpaySegmentEditText.access$102(TenpaySegmentEditText.this, false);
          }
          AppMethodBeat.o(73267);
        }
      });
      setNoSystemInputOnEditText(paramString2);
      ((InputMethodManager)this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(paramString2.getWindowToken(), 2);
      paramString2.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(73268);
          LogUtil.d("MyTag", new Object[] { "edit onFocusChange hasFocus=".concat(String.valueOf(paramAnonymousBoolean)) });
          if (paramAnonymousBoolean)
          {
            if (TenpaySegmentEditText.this.mOnClickListener != null) {
              TenpaySegmentEditText.this.mOnClickListener.onClick(paramAnonymousView);
            }
            if (TenpaySegmentEditText.this.mKeyboard != null)
            {
              LogUtil.d("MyTag", new Object[] { "keyboard is not null" });
              TenpaySegmentEditText.this.mKeyboard.setXMode(0);
              TenpaySegmentEditText.this.mKeyboard.setInputEditText(paramString2);
            }
          }
          AppMethodBeat.o(73268);
        }
      });
      addView(paramString2, new LinearLayout.LayoutParams(-2, -1, paramString1[i].length()));
      this.mEditArray.add(paramString2);
      i += 1;
    }
    setFocusable(false);
    AppMethodBeat.o(73276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tenpay.bankcard.TenpaySegmentEditText
 * JD-Core Version:    0.7.0.1
 */