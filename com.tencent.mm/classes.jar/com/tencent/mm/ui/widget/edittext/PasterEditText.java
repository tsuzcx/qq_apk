package com.tencent.mm.ui.widget.edittext;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.widget.EditText;

public class PasterEditText
  extends EditText
{
  private Context context;
  private ClipboardManager oYb = null;
  private int oYc = 0;
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    init();
  }
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.oYb = ((ClipboardManager)this.context.getSystemService("clipboard"));
  }
  
  public int getPasterLen()
  {
    return this.oYc;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    if (paramInt == 16908322)
    {
      if ((this.oYb != null) && (this.oYb.getText() != null) && ((this.oYb.getText() instanceof String)) && (this.oYb.getText() != null) && (this.oYb.getText().length() > 0)) {
        this.oYc += this.oYb.getText().length();
      }
      return super.onTextContextMenuItem(paramInt);
    }
    return super.onTextContextMenuItem(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.PasterEditText
 * JD-Core Version:    0.7.0.1
 */