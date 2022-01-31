package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public class MMCallBackScrollView
  extends ScrollView
{
  private ak mHandler;
  private int mState;
  private int pGT;
  private MMCallBackScrollView.a pGU;
  
  public MMCallBackScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24041);
    this.mState = 0;
    this.mHandler = new MMCallBackScrollView.1(this);
    AppMethodBeat.o(24041);
  }
  
  public MMCallBackScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(24042);
    this.mState = 0;
    this.mHandler = new MMCallBackScrollView.1(this);
    AppMethodBeat.o(24042);
  }
  
  private void BS(int paramInt)
  {
    AppMethodBeat.i(24040);
    if ((this.pGU != null) && (this.mState != paramInt))
    {
      this.mState = paramInt;
      this.pGU.bX(paramInt);
    }
    AppMethodBeat.o(24040);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(24043);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    this.pGT = getScrollY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24043);
      return bool;
      if (this.mHandler != null)
      {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 5L);
        continue;
        BS(1);
      }
    }
  }
  
  public void setMMOnScrollListener(MMCallBackScrollView.a parama)
  {
    this.pGU = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView
 * JD-Core Version:    0.7.0.1
 */