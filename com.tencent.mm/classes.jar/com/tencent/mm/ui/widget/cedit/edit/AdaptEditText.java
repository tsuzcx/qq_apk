package com.tencent.mm.ui.widget.cedit.edit;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class AdaptEditText
  extends AppCompatEditText
{
  public AdaptEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdaptEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AdaptEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean hasFocus()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.AdaptEditText
 * JD-Core Version:    0.7.0.1
 */