package com.tencent.xweb.xwalk;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import org.xwalk.core.XWalkEnvironment;

final class a$38
  implements TextWatcher
{
  a$38(a parama, EditText paramEditText) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.xlw.getText().toString();
    int i = 0;
    try
    {
      int j = Integer.parseInt(paramEditable);
      i = j;
    }
    catch (Exception paramEditable)
    {
      label20:
      break label20;
    }
    XWalkEnvironment.setGrayValueForTest(i);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.38
 * JD-Core Version:    0.7.0.1
 */