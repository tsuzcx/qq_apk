package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class ChatFooterBottom
  extends FrameLayout
{
  private boolean eea = false;
  
  public ChatFooterBottom(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ChatFooterBottom(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(31719);
    super.draw(paramCanvas);
    AppMethodBeat.o(31719);
  }
  
  public ViewGroup.LayoutParams getLayoutParams()
  {
    AppMethodBeat.i(31726);
    ViewGroup.LayoutParams localLayoutParams = super.getLayoutParams();
    AppMethodBeat.o(31726);
    return localLayoutParams;
  }
  
  public final boolean grr()
  {
    AppMethodBeat.i(31727);
    if ((this.eea) || (getVisibility() != 0))
    {
      AppMethodBeat.o(31727);
      return true;
    }
    AppMethodBeat.o(31727);
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(31722);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(31722);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31721);
    Log.d("MicroMsg.ChatFooterBottom", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(31721);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31720);
    Log.d("MicroMsg.ChatFooterBottom", "jacks onMeasure  width:%d, height:%d, isHide: %B", new Object[] { Integer.valueOf(View.MeasureSpec.getSize(paramInt1)), Integer.valueOf(View.MeasureSpec.getSize(paramInt2)), Boolean.valueOf(this.eea) });
    if (this.eea)
    {
      setVisibility(8);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(31720);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31723);
    Log.d("MicroMsg.ChatFooterBottom", "jacks onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(31723);
  }
  
  public void setIsHide(boolean paramBoolean)
  {
    this.eea = paramBoolean;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(31725);
    super.setLayoutParams(paramLayoutParams);
    AppMethodBeat.o(31725);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(31724);
    if (paramInt == 0) {
      this.eea = false;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(31724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooterBottom
 * JD-Core Version:    0.7.0.1
 */