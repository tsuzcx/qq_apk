package com.tenpay.android.wechat;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class MyKeyboardWindow
  extends LinearLayout
{
  public static final int X_MODE_CHARACTER = 1;
  public static final int X_MODE_DOT = 2;
  public static final int X_MODE_NONE = 0;
  private Context mContext;
  private EditText mInputEditText;
  private Button mKey0;
  private Button mKey1;
  private Button mKey2;
  private Button mKey3;
  private Button mKey4;
  private Button mKey5;
  private Button mKey6;
  private Button mKey7;
  private Button mKey8;
  private Button mKey9;
  private RelativeLayout mKeyD;
  private Button mKeyX;
  private int mXMode;
  
  public MyKeyboardWindow(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(130947);
    this.mXMode = 0;
    init(paramContext);
    AppMethodBeat.o(130947);
  }
  
  public MyKeyboardWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(130948);
    this.mXMode = 0;
    init(paramContext);
    AppMethodBeat.o(130948);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(130949);
    this.mContext = paramContext.getApplicationContext();
    TenpayTTSUtil.init(paramContext);
    paramContext = LayoutInflater.from(paramContext).inflate(this.mContext.getResources().getIdentifier("tenpay_number_keyboard", "layout", this.mContext.getPackageName()), this, true);
    this.mKey1 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_1")));
    this.mKey2 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_2")));
    this.mKey3 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_3")));
    this.mKey4 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_4")));
    this.mKey5 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_5")));
    this.mKey6 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_6")));
    this.mKey7 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_7")));
    this.mKey8 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_8")));
    this.mKey9 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_9")));
    this.mKeyX = ((Button)paramContext.findViewById(getId("tenpay_keyboard_x")));
    this.mKey0 = ((Button)paramContext.findViewById(getId("tenpay_keyboard_0")));
    this.mKeyD = ((RelativeLayout)paramContext.findViewById(getId("tenpay_keyboard_d")));
    paramContext = new View.OnClickListener()
    {
      private byte _hellAccFlag_;
      
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130946);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tenpay/android/wechat/MyKeyboardWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (MyKeyboardWindow.this.mInputEditText == null)
        {
          a.a(this, "com/tenpay/android/wechat/MyKeyboardWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130946);
          return;
        }
        if (paramAnonymousView.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_x"))
        {
          switch (MyKeyboardWindow.this.mXMode)
          {
          }
          for (;;)
          {
            a.a(this, "com/tenpay/android/wechat/MyKeyboardWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(130946);
            return;
            MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 59));
            MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 52));
            MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, 59));
            continue;
            MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 56));
          }
        }
        int i;
        if (paramAnonymousView.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_1")) {
          i = 8;
        }
        for (;;)
        {
          MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, i));
          MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, i));
          a.a(this, "com/tenpay/android/wechat/MyKeyboardWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130946);
          return;
          if (paramAnonymousView.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_2")) {
            i = 9;
          } else if (paramAnonymousView.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_3")) {
            i = 10;
          } else if (paramAnonymousView.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_4")) {
            i = 11;
          } else if (paramAnonymousView.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_5")) {
            i = 12;
          } else if (paramAnonymousView.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_6")) {
            i = 13;
          } else if (paramAnonymousView.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_7")) {
            i = 14;
          } else if (paramAnonymousView.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_8")) {
            i = 15;
          } else if (paramAnonymousView.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_9")) {
            i = 16;
          } else if (paramAnonymousView.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_0")) {
            i = 7;
          } else if (paramAnonymousView.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_d")) {
            i = 67;
          } else {
            i = 0;
          }
        }
      }
    };
    if (Build.VERSION.SDK_INT >= 14)
    {
      this.mKey1.setContentDescription("1");
      this.mKey2.setContentDescription("2");
      this.mKey3.setContentDescription("3");
      this.mKey4.setContentDescription("4");
      this.mKey5.setContentDescription("5");
      this.mKey6.setContentDescription("6");
      this.mKey7.setContentDescription("7");
      this.mKey8.setContentDescription("8");
      this.mKey9.setContentDescription("9");
      this.mKey0.setContentDescription("0");
      this.mKeyX.setContentDescription("字母X");
      this.mKeyD.setContentDescription("删除");
    }
    this.mKey1.setOnClickListener(paramContext);
    this.mKey2.setOnClickListener(paramContext);
    this.mKey3.setOnClickListener(paramContext);
    this.mKey4.setOnClickListener(paramContext);
    this.mKey5.setOnClickListener(paramContext);
    this.mKey6.setOnClickListener(paramContext);
    this.mKey7.setOnClickListener(paramContext);
    this.mKey8.setOnClickListener(paramContext);
    this.mKey9.setOnClickListener(paramContext);
    this.mKeyX.setOnClickListener(paramContext);
    this.mKey0.setOnClickListener(paramContext);
    this.mKeyD.setOnClickListener(paramContext);
    AppMethodBeat.o(130949);
  }
  
  protected int getDrawableId(String paramString)
  {
    AppMethodBeat.i(130955);
    int i = this.mContext.getResources().getIdentifier(paramString, "drawable", this.mContext.getPackageName());
    AppMethodBeat.o(130955);
    return i;
  }
  
  protected int getId(String paramString)
  {
    AppMethodBeat.i(130954);
    int i = this.mContext.getResources().getIdentifier(paramString, "id", this.mContext.getPackageName());
    AppMethodBeat.o(130954);
    return i;
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(130956);
    super.onDetachedFromWindow();
    TenpayTTSUtil.destroy();
    AppMethodBeat.o(130956);
  }
  
  public void resetSecureAccessibility()
  {
    AppMethodBeat.i(130951);
    this.mKey0.setAccessibilityDelegate(null);
    this.mKey1.setAccessibilityDelegate(null);
    this.mKey2.setAccessibilityDelegate(null);
    this.mKey3.setAccessibilityDelegate(null);
    this.mKey4.setAccessibilityDelegate(null);
    this.mKey5.setAccessibilityDelegate(null);
    this.mKey6.setAccessibilityDelegate(null);
    this.mKey7.setAccessibilityDelegate(null);
    this.mKey8.setAccessibilityDelegate(null);
    this.mKey9.setAccessibilityDelegate(null);
    this.mKeyX.setAccessibilityDelegate(null);
    this.mKeyD.setAccessibilityDelegate(null);
    AppMethodBeat.o(130951);
  }
  
  public void setInputEditText(EditText paramEditText)
  {
    AppMethodBeat.i(130952);
    if (paramEditText != null)
    {
      this.mInputEditText = paramEditText;
      int i = this.mInputEditText.getImeOptions();
      paramEditText = this.mInputEditText.getImeActionLabel();
      if (!TextUtils.isEmpty(paramEditText)) {
        this.mKeyX.setText(paramEditText);
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(130952);
      return;
      this.mXMode = 0;
      if (TextUtils.isEmpty(paramEditText)) {
        this.mKeyX.setText("");
      }
    }
  }
  
  public void setSecureAccessibility(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    AppMethodBeat.i(130950);
    this.mKey0.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey1.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey2.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey3.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey4.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey5.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey6.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey7.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey8.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKey9.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKeyX.setAccessibilityDelegate(paramAccessibilityDelegate);
    this.mKeyD.setAccessibilityDelegate(paramAccessibilityDelegate);
    AppMethodBeat.o(130950);
  }
  
  public void setXMode(int paramInt)
  {
    AppMethodBeat.i(130953);
    this.mXMode = paramInt;
    switch (paramInt)
    {
    default: 
      this.mXMode = 0;
      AppMethodBeat.o(130953);
      return;
    case 0: 
      this.mKeyX.setText("");
      this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom_new"));
      AppMethodBeat.o(130953);
      return;
    case 1: 
      this.mKeyX.setText("X");
      this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom_new"));
      AppMethodBeat.o(130953);
      return;
    }
    this.mKeyX.setText(".");
    this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom_new"));
    AppMethodBeat.o(130953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tenpay.android.wechat.MyKeyboardWindow
 * JD-Core Version:    0.7.0.1
 */