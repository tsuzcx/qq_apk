package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.patmsg.d.e;

public class PatTipWrapView
  extends FrameLayout
{
  private View MHV;
  
  public PatTipWrapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public PatTipWrapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(266434);
    this.MHV = View.inflate(getContext(), d.e.pat_tips_view, null);
    AppMethodBeat.o(266434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.PatTipWrapView
 * JD-Core Version:    0.7.0.1
 */