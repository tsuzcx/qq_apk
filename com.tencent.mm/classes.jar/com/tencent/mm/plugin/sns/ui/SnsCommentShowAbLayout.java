package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsCommentShowAbLayout
  extends AbsoluteLayout
{
  public SnsCommentShowAbLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public SnsCommentShowAbLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SnsCommentShowAbLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void buildDrawingCache(boolean paramBoolean)
  {
    AppMethodBeat.i(38913);
    super.buildDrawingCache(paramBoolean);
    AppMethodBeat.o(38913);
  }
  
  public void destroyDrawingCache()
  {
    AppMethodBeat.i(38914);
    super.destroyDrawingCache();
    AppMethodBeat.o(38914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentShowAbLayout
 * JD-Core Version:    0.7.0.1
 */