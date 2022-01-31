package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.support.v4.view.b.b;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public class ChattingScrollLayout
  extends LinearLayout
{
  private View kxi;
  private int vYA;
  private int vYB;
  private int vYC;
  private View vYD;
  private MMChattingListView vYE;
  private OverScroller vYy;
  private Runnable vYz;
  
  public ChattingScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChattingScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(153741);
    this.vYA = 0;
    this.vYB = 0;
    this.vYC = 0;
    this.vYy = new OverScroller(getContext(), new b());
    AppMethodBeat.o(153741);
  }
  
  private void doS()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(153745);
    int i = this.vYE.getBottomSpace();
    float f1;
    if (i > 0)
    {
      f1 = this.kxi.getTranslationY();
      f1 = i + f1;
      if (f1 <= 0.0F) {
        break label83;
      }
      f1 = f2;
    }
    label83:
    for (;;)
    {
      ab.i("MicroMsg.ChattingScrollLayout", "updateListContent: %s", new Object[] { Float.valueOf(f1) });
      this.vYE.setTranslationY(f1);
      AppMethodBeat.o(153745);
      return;
      f1 = this.kxi.getTranslationY();
      break;
    }
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(153744);
    if (this.vYy.computeScrollOffset())
    {
      this.vYA = this.vYy.getCurrY();
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView != this.vYD) {
          localView.setTranslationY(-this.vYA);
        }
        i += 1;
      }
      doS();
      t.R(this);
    }
    AppMethodBeat.o(153744);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(156097);
    if (paramMotionEvent.getActionMasked() == 0) {}
    for (this.vYC = this.vYA;; this.vYC = 0) {
      do
      {
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(156097);
        return bool;
        paramMotionEvent.offsetLocation(0.0F, this.vYC - this.vYA);
      } while ((paramMotionEvent.getActionMasked() != 1) && (paramMotionEvent.getActionMasked() != 3));
    }
  }
  
  public final void h(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(156707);
    ab.i("MicroMsg.ChattingScrollLayout", "scrollContentTo: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (this.vYB == paramInt1)
    {
      AppMethodBeat.o(156707);
      return;
    }
    this.vYB = paramInt1;
    this.vYy.forceFinished(true);
    removeCallbacks(this.vYz);
    this.vYz = new ChattingScrollLayout.1(this, paramInt2, paramBoolean);
    post(this.vYz);
    AppMethodBeat.o(156707);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(153742);
    super.onFinishInflate();
    this.kxi = findViewById(2131822454);
    this.vYD = findViewById(2131822440);
    this.vYE = ((MMChattingListView)findViewById(2131822441));
    AppMethodBeat.o(153742);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(153743);
    ab.i("MicroMsg.ChattingScrollLayout", "onLayout: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.vYz != null)
    {
      removeCallbacks(this.vYz);
      post(this.vYz);
    }
    if ((this.vYy != null) && (this.vYy.isFinished())) {
      doS();
    }
    AppMethodBeat.o(153743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChattingScrollLayout
 * JD-Core Version:    0.7.0.1
 */