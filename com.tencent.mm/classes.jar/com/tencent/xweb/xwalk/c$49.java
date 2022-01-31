package com.tencent.xweb.xwalk;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

final class c$49
  implements TextWatcher
{
  c$49(c paramc, EditText paramEditText) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(85172);
    paramEditable = this.BJj.getText().toString();
    int i = 0;
    try
    {
      int j = Integer.parseInt(paramEditable);
      i = j;
    }
    catch (Exception paramEditable)
    {
      label25:
      break label25;
    }
    XWalkEnvironment.setGrayValueForTest(i);
    AppMethodBeat.o(85172);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.49
 * JD-Core Version:    0.7.0.1
 */