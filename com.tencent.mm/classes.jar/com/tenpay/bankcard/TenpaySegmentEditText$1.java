package com.tenpay.bankcard;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TenpaySegmentEditText$1
  implements View.OnClickListener
{
  TenpaySegmentEditText$1(TenpaySegmentEditText paramTenpaySegmentEditText, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(49519);
    if (TenpaySegmentEditText.access$000(this.this$0) != null) {
      TenpaySegmentEditText.access$000(this.this$0).onClick(paramView);
    }
    if (TenpaySegmentEditText.access$100(this.this$0))
    {
      this.this$0.setFocusable(true);
      this.val$edit.requestFocus();
      TenpaySegmentEditText.access$102(this.this$0, false);
    }
    AppMethodBeat.o(49519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tenpay.bankcard.TenpaySegmentEditText.1
 * JD-Core Version:    0.7.0.1
 */