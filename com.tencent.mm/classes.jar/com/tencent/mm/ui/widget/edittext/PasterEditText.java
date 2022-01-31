package com.tencent.mm.ui.widget.edittext;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PasterEditText
  extends EditText
{
  private Context context;
  private int iNn;
  private ClipboardManager rQu;
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112701);
    this.rQu = null;
    this.iNn = 0;
    this.context = paramContext;
    init();
    AppMethodBeat.o(112701);
  }
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112702);
    this.rQu = null;
    this.iNn = 0;
    init();
    AppMethodBeat.o(112702);
  }
  
  private void init()
  {
    AppMethodBeat.i(112703);
    this.rQu = ((ClipboardManager)this.context.getApplicationContext().getSystemService("clipboard"));
    AppMethodBeat.o(112703);
  }
  
  public int getPasterLen()
  {
    return this.iNn;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(112704);
    if (paramInt == 16908322) {
      if ((this.rQu != null) && (this.rQu.getText() != null) && ((this.rQu.getText() instanceof String)) && (this.rQu.getText() != null) && (this.rQu.getText().length() > 0)) {
        this.iNn += this.rQu.getText().length();
      }
    }
    for (boolean bool = super.onTextContextMenuItem(paramInt);; bool = super.onTextContextMenuItem(paramInt))
    {
      AppMethodBeat.o(112704);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.PasterEditText
 * JD-Core Version:    0.7.0.1
 */