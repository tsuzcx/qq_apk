package com.tenpay.bankcard;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tenpay.android.wechat.MyKeyboardWindow;

class TenpaySegmentEditText$2
  implements View.OnFocusChangeListener
{
  TenpaySegmentEditText$2(TenpaySegmentEditText paramTenpaySegmentEditText, EditText paramEditText) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    LogUtil.d("MyTag", new Object[] { "edit onFocusChange hasFocus=" + paramBoolean });
    if (paramBoolean)
    {
      if (TenpaySegmentEditText.access$000(this.this$0) != null) {
        TenpaySegmentEditText.access$000(this.this$0).onClick(paramView);
      }
      if (TenpaySegmentEditText.access$200(this.this$0) != null)
      {
        LogUtil.d("MyTag", new Object[] { "keyboard is not null" });
        TenpaySegmentEditText.access$200(this.this$0).setXMode(0);
        TenpaySegmentEditText.access$200(this.this$0).setInputEditText(this.val$edit);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tenpay.bankcard.TenpaySegmentEditText.2
 * JD-Core Version:    0.7.0.1
 */