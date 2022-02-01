package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PatTipWrapView
  extends FrameLayout
{
  private View wVN;
  
  public PatTipWrapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public PatTipWrapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220389);
    this.wVN = View.inflate(getContext(), 2131496417, null);
    AppMethodBeat.o(220389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.PatTipWrapView
 * JD-Core Version:    0.7.0.1
 */