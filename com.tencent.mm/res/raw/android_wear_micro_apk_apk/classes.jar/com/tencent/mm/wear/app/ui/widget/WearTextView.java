package com.tencent.mm.wear.app.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.wear.app.emoji.e;
import com.tencent.mm.wear.app.ui.i;

public class WearTextView
  extends TextView
{
  public WearTextView(Context paramContext)
  {
    super(paramContext);
    setTypeface(i.afr);
  }
  
  public WearTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setTypeface(i.afr);
  }
  
  public WearTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setTypeface(i.afr);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Object localObject = paramCharSequence;
    if ((paramCharSequence instanceof String))
    {
      e.mB();
      localObject = e.a(getContext(), paramCharSequence, (int)getTextSize());
    }
    super.setText((CharSequence)localObject, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.WearTextView
 * JD-Core Version:    0.7.0.1
 */