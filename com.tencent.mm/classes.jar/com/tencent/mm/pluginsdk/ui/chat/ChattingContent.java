package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class ChattingContent
  extends FrameLayout
{
  private int Fdw = -1;
  private int Fdx = 0;
  
  public ChattingContent(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ChattingContent(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31730);
    ad.d("MicroMsg.ChattingContent", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(31730);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31729);
    ad.d("MicroMsg.ChattingContent", "jacks onMeasure  width:%d, height:%d", new Object[] { Integer.valueOf(View.MeasureSpec.getSize(paramInt1)), Integer.valueOf(View.MeasureSpec.getSize(paramInt2)) });
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(31729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChattingContent
 * JD-Core Version:    0.7.0.1
 */