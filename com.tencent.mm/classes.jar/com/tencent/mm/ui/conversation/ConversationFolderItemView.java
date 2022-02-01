package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ConversationFolderItemView
  extends LinearLayout
{
  public ConversationFolderItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ConversationFolderItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256787);
    if ((getTag() instanceof k.f))
    {
      k.f localf = (k.f)getTag();
      if (localf.afoP == 0)
      {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(localf.afoO, 1073741824));
        AppMethodBeat.o(256787);
        return;
      }
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(256787);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(256787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationFolderItemView
 * JD-Core Version:    0.7.0.1
 */