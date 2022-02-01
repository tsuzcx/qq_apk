package com.tenpay.miniapp;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MiniAppKeyboardWindow
  extends LinearLayout
{
  public static final int X_MODE_CHARACTER = 1;
  public static final int X_MODE_DOT = 2;
  public static final int X_MODE_NONE = 0;
  private Context mContext;
  private EditText mInputEditText;
  private RelativeLayout mKeyD;
  private TextView[] mKeys;
  private OnTouchListener mOnTouchListener;
  private int mXMode;
  
  public MiniAppKeyboardWindow(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(208588);
    this.mXMode = 0;
    this.mKeys = new TextView[11];
    init(paramContext);
    AppMethodBeat.o(208588);
  }
  
  public MiniAppKeyboardWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(208598);
    this.mXMode = 0;
    this.mKeys = new TextView[11];
    init(paramContext);
    AppMethodBeat.o(208598);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(208606);
    this.mContext = paramContext.getApplicationContext();
    TenpayTTSUtil.init(paramContext);
    paramContext = LayoutInflater.from(paramContext).inflate(this.mContext.getResources().getIdentifier("tenpay_number_keyboard", "layout", this.mContext.getPackageName()), this, true);
    this.mKeys[1] = ((TextView)paramContext.findViewById(getId("tenpay_keyboard_1")));
    this.mKeys[2] = ((TextView)paramContext.findViewById(getId("tenpay_keyboard_2")));
    this.mKeys[3] = ((TextView)paramContext.findViewById(getId("tenpay_keyboard_3")));
    this.mKeys[4] = ((TextView)paramContext.findViewById(getId("tenpay_keyboard_4")));
    this.mKeys[5] = ((TextView)paramContext.findViewById(getId("tenpay_keyboard_5")));
    this.mKeys[6] = ((TextView)paramContext.findViewById(getId("tenpay_keyboard_6")));
    this.mKeys[7] = ((TextView)paramContext.findViewById(getId("tenpay_keyboard_7")));
    this.mKeys[8] = ((TextView)paramContext.findViewById(getId("tenpay_keyboard_8")));
    this.mKeys[9] = ((TextView)paramContext.findViewById(getId("tenpay_keyboard_9")));
    this.mKeys[10] = ((TextView)paramContext.findViewById(getId("tenpay_keyboard_x")));
    this.mKeys[0] = ((TextView)paramContext.findViewById(getId("tenpay_keyboard_0")));
    this.mKeyD = ((RelativeLayout)paramContext.findViewById(getId("tenpay_keyboard_d")));
    paramContext = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208586);
        if (MiniAppKeyboardWindow.this.mInputEditText == null)
        {
          AppMethodBeat.o(208586);
          return;
        }
        if (paramAnonymousView.getId() == MiniAppKeyboardWindow.this.getId("tenpay_keyboard_x"))
        {
          switch (MiniAppKeyboardWindow.this.mXMode)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(208586);
            return;
            AppMethodBeat.o(208586);
            return;
            MiniAppKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 59));
            MiniAppKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 52));
            MiniAppKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, 59));
            AppMethodBeat.o(208586);
            return;
            MiniAppKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 56));
          }
        }
        int i;
        if (paramAnonymousView.getId() == MiniAppKeyboardWindow.this.getId("tenpay_keyboard_1")) {
          i = 8;
        }
        for (;;)
        {
          MiniAppKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, i));
          MiniAppKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, i));
          AppMethodBeat.o(208586);
          return;
          if (paramAnonymousView.getId() == MiniAppKeyboardWindow.this.getId("tenpay_keyboard_2")) {
            i = 9;
          } else if (paramAnonymousView.getId() == MiniAppKeyboardWindow.this.getId("tenpay_keyboard_3")) {
            i = 10;
          } else if (paramAnonymousView.getId() == MiniAppKeyboardWindow.this.getId("tenpay_keyboard_4")) {
            i = 11;
          } else if (paramAnonymousView.getId() == MiniAppKeyboardWindow.this.getId("tenpay_keyboard_5")) {
            i = 12;
          } else if (paramAnonymousView.getId() == MiniAppKeyboardWindow.this.getId("tenpay_keyboard_6")) {
            i = 13;
          } else if (paramAnonymousView.getId() == MiniAppKeyboardWindow.this.getId("tenpay_keyboard_7")) {
            i = 14;
          } else if (paramAnonymousView.getId() == MiniAppKeyboardWindow.this.getId("tenpay_keyboard_8")) {
            i = 15;
          } else if (paramAnonymousView.getId() == MiniAppKeyboardWindow.this.getId("tenpay_keyboard_9")) {
            i = 16;
          } else if (paramAnonymousView.getId() == MiniAppKeyboardWindow.this.getId("tenpay_keyboard_0")) {
            i = 7;
          } else if (paramAnonymousView.getId() == MiniAppKeyboardWindow.this.getId("tenpay_keyboard_d")) {
            i = 67;
          } else {
            i = 0;
          }
        }
      }
    };
    if (Build.VERSION.SDK_INT >= 14)
    {
      i = 0;
      while (i <= 9)
      {
        this.mKeys[i].setContentDescription(String.valueOf(i));
        i += 1;
      }
      this.mKeys[10].setContentDescription("字母X");
      this.mKeyD.setContentDescription("删除");
    }
    int i = 0;
    while (i < this.mKeys.length)
    {
      this.mKeys[i].setOnClickListener(paramContext);
      i += 1;
    }
    this.mKeyD.setOnClickListener(paramContext);
    AppMethodBeat.o(208606);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(208651);
    try
    {
      if (this.mOnTouchListener != null) {
        this.mOnTouchListener.onTouch(this, paramMotionEvent);
      }
      label24:
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(208651);
      return bool;
    }
    finally
    {
      break label24;
    }
  }
  
  protected int getDrawableId(String paramString)
  {
    AppMethodBeat.i(208645);
    int i = this.mContext.getResources().getIdentifier(paramString, "drawable", this.mContext.getPackageName());
    AppMethodBeat.o(208645);
    return i;
  }
  
  protected int getId(String paramString)
  {
    AppMethodBeat.i(208643);
    int i = this.mContext.getResources().getIdentifier(paramString, "id", this.mContext.getPackageName());
    AppMethodBeat.o(208643);
    return i;
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(208646);
    super.onDetachedFromWindow();
    TenpayTTSUtil.destroy();
    AppMethodBeat.o(208646);
  }
  
  public void resetSecureAccessibility()
  {
    AppMethodBeat.i(208628);
    int i = 0;
    while (i < this.mKeys.length)
    {
      this.mKeys[i].setAccessibilityDelegate(null);
      i += 1;
    }
    this.mKeyD.setAccessibilityDelegate(null);
    AppMethodBeat.o(208628);
  }
  
  public void setInputEditText(EditText paramEditText)
  {
    AppMethodBeat.i(208634);
    if (paramEditText != null)
    {
      this.mInputEditText = paramEditText;
      int i = this.mInputEditText.getImeOptions();
      paramEditText = this.mInputEditText.getImeActionLabel();
      if (!TextUtils.isEmpty(paramEditText)) {
        this.mKeys[10].setText(paramEditText);
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(208634);
      return;
      this.mXMode = 0;
      if (TextUtils.isEmpty(paramEditText)) {
        this.mKeys[10].setText("");
      }
    }
  }
  
  public void setOnTouchListener(OnTouchListener paramOnTouchListener)
  {
    this.mOnTouchListener = paramOnTouchListener;
  }
  
  public void setSecureAccessibility(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    AppMethodBeat.i(208623);
    int i = 0;
    while (i < this.mKeys.length)
    {
      this.mKeys[i].setAccessibilityDelegate(paramAccessibilityDelegate);
      i += 1;
    }
    this.mKeyD.setAccessibilityDelegate(paramAccessibilityDelegate);
    AppMethodBeat.o(208623);
  }
  
  public void setXMode(int paramInt)
  {
    AppMethodBeat.i(208639);
    this.mXMode = paramInt;
    TextView localTextView = this.mKeys[10];
    switch (paramInt)
    {
    default: 
      this.mXMode = 0;
      AppMethodBeat.o(208639);
      return;
    case 0: 
      localTextView.setText("");
      localTextView.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom_new"));
      AppMethodBeat.o(208639);
      return;
    case 1: 
      localTextView.setText("X");
      localTextView.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom_new"));
      AppMethodBeat.o(208639);
      return;
    }
    localTextView.setText(".");
    localTextView.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom_new"));
    AppMethodBeat.o(208639);
  }
  
  public static abstract interface OnTouchListener
  {
    public abstract boolean onTouch(View paramView, MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tenpay.miniapp.MiniAppKeyboardWindow
 * JD-Core Version:    0.7.0.1
 */