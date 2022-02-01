package com.tencent.xweb.xwalk;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

final class d$53
  implements TextWatcher
{
  d$53(d paramd, EditText paramEditText) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(154213);
    paramEditable = this.SGL.getText().toString();
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
    AppMethodBeat.o(154213);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.53
 * JD-Core Version:    0.7.0.1
 */