package com.tencent.mm.ui.widget.edittext;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PasterEditText
  extends EditText
{
  private ClipboardManager Aug;
  private Context context;
  private int mHV;
  
  public PasterEditText(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168813);
    this.Aug = null;
    this.mHV = 0;
    this.context = paramContext;
    init();
    AppMethodBeat.o(168813);
  }
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159400);
    this.Aug = null;
    this.mHV = 0;
    this.context = paramContext;
    init();
    AppMethodBeat.o(159400);
  }
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159401);
    this.Aug = null;
    this.mHV = 0;
    init();
    AppMethodBeat.o(159401);
  }
  
  private void init()
  {
    AppMethodBeat.i(159402);
    this.Aug = ((ClipboardManager)this.context.getApplicationContext().getSystemService("clipboard"));
    AppMethodBeat.o(159402);
  }
  
  public int getPasterLen()
  {
    return this.mHV;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(159403);
    if (paramInt == 16908322) {
      if ((this.Aug != null) && (this.Aug.getText() != null) && ((this.Aug.getText() instanceof String)) && (this.Aug.getText() != null) && (this.Aug.getText().length() > 0)) {
        this.mHV += this.Aug.getText().length();
      }
    }
    for (boolean bool = super.onTextContextMenuItem(paramInt);; bool = super.onTextContextMenuItem(paramInt))
    {
      AppMethodBeat.o(159403);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.PasterEditText
 * JD-Core Version:    0.7.0.1
 */