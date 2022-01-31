package com.tenpay.android.wechat;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class MyKeyboardWindow$1
  implements View.OnClickListener
{
  MyKeyboardWindow$1(MyKeyboardWindow paramMyKeyboardWindow) {}
  
  public void onClick(View paramView)
  {
    if (MyKeyboardWindow.access$000(this.this$0) == null) {
      return;
    }
    if (paramView.getId() == this.this$0.getId("tenpay_keyboard_x"))
    {
      switch (MyKeyboardWindow.access$100(this.this$0))
      {
      case 0: 
      default: 
        return;
      case 1: 
        MyKeyboardWindow.access$000(this.this$0).dispatchKeyEvent(new KeyEvent(0, 59));
        MyKeyboardWindow.access$000(this.this$0).dispatchKeyEvent(new KeyEvent(0, 52));
        MyKeyboardWindow.access$000(this.this$0).dispatchKeyEvent(new KeyEvent(1, 59));
        return;
      }
      MyKeyboardWindow.access$000(this.this$0).dispatchKeyEvent(new KeyEvent(0, 56));
      return;
    }
    int i;
    if (paramView.getId() == this.this$0.getId("tenpay_keyboard_1")) {
      i = 8;
    }
    for (;;)
    {
      MyKeyboardWindow.access$000(this.this$0).dispatchKeyEvent(new KeyEvent(0, i));
      MyKeyboardWindow.access$000(this.this$0).dispatchKeyEvent(new KeyEvent(1, i));
      return;
      if (paramView.getId() == this.this$0.getId("tenpay_keyboard_2")) {
        i = 9;
      } else if (paramView.getId() == this.this$0.getId("tenpay_keyboard_3")) {
        i = 10;
      } else if (paramView.getId() == this.this$0.getId("tenpay_keyboard_4")) {
        i = 11;
      } else if (paramView.getId() == this.this$0.getId("tenpay_keyboard_5")) {
        i = 12;
      } else if (paramView.getId() == this.this$0.getId("tenpay_keyboard_6")) {
        i = 13;
      } else if (paramView.getId() == this.this$0.getId("tenpay_keyboard_7")) {
        i = 14;
      } else if (paramView.getId() == this.this$0.getId("tenpay_keyboard_8")) {
        i = 15;
      } else if (paramView.getId() == this.this$0.getId("tenpay_keyboard_9")) {
        i = 16;
      } else if (paramView.getId() == this.this$0.getId("tenpay_keyboard_0")) {
        i = 7;
      } else if (paramView.getId() == this.this$0.getId("tenpay_keyboard_d")) {
        i = 67;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tenpay.android.wechat.MyKeyboardWindow.1
 * JD-Core Version:    0.7.0.1
 */