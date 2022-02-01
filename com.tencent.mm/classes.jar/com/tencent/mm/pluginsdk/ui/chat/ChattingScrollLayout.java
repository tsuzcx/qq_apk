package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.support.v4.view.b.b;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.chatting.ChattingAnimFrame;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public class ChattingScrollLayout
  extends LinearLayout
{
  private Runnable Dyp;
  private int Dyq;
  private int Dyr;
  private int Dys;
  private int Dyt;
  private int Dyu;
  private View Dyv;
  private MMChattingListView Dyw;
  private View ofC;
  private OverScroller pZ;
  
  public ChattingScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChattingScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31733);
    this.Dyq = 0;
    this.Dyr = 0;
    this.Dys = 0;
    this.Dyt = 0;
    this.pZ = new OverScroller(getContext(), new b());
    AppMethodBeat.o(31733);
  }
  
  private void ePp()
  {
    AppMethodBeat.i(31738);
    int i = this.Dyw.getBottomSpace();
    if (i > 0) {
      f1 = this.ofC.getTranslationY();
    }
    for (float f1 = i + f1;; f1 = this.ofC.getTranslationY())
    {
      float f2 = f1 + getInterTranslationY();
      f1 = f2;
      if (f2 > 0.0F) {
        f1 = 0.0F;
      }
      this.Dyw.setTranslationY(f1);
      AppMethodBeat.o(31738);
      return;
    }
  }
  
  private void ePq()
  {
    AppMethodBeat.i(31740);
    Object localObject = (ChattingAnimFrame)findViewById(2131297976);
    if (localObject == null)
    {
      localObject = findViewById(2131306439);
      ac.i("MicroMsg.ChattingScrollLayout", "resizeChatAnimFrame: use view stub");
    }
    for (;;)
    {
      if (localObject != null)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        if (localMarginLayoutParams != null)
        {
          localMarginLayoutParams.bottomMargin = this.Dyr;
          ((View)localObject).setLayoutParams(localMarginLayoutParams);
        }
      }
      AppMethodBeat.o(31740);
      return;
      ac.i("MicroMsg.ChattingScrollLayout", "resizeChatAnimFrame: use view");
    }
  }
  
  private int getInterTranslationY()
  {
    if (this.Dys != 0) {
      return (int)(1.0D * this.Dyq / this.Dys * this.Dyu);
    }
    return 0;
  }
  
  public final void c(int paramInt1, final boolean paramBoolean, final int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185854);
    ac.i("MicroMsg.ChattingScrollLayout", "scrollContentTo: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (this.Dyr == paramInt1)
    {
      AppMethodBeat.o(185854);
      return;
    }
    this.Dyr = paramInt1;
    if (this.Dyr != 0) {
      this.Dys = this.Dyr;
    }
    this.Dyu = paramInt3;
    ePq();
    this.pZ.forceFinished(true);
    removeCallbacks(this.Dyp);
    this.Dyp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31732);
        ac.i("MicroMsg.ChattingScrollLayout", "scrollContentTo: in runnable");
        ChattingScrollLayout.a(ChattingScrollLayout.this);
        int j = ChattingScrollLayout.b(ChattingScrollLayout.this);
        int k = ChattingScrollLayout.c(ChattingScrollLayout.this);
        int i;
        OverScroller localOverScroller;
        int m;
        if (paramInt2 == 0)
        {
          i = 350;
          localOverScroller = ChattingScrollLayout.d(ChattingScrollLayout.this);
          m = ChattingScrollLayout.c(ChattingScrollLayout.this);
          if (!paramBoolean) {
            break label107;
          }
        }
        for (;;)
        {
          localOverScroller.startScroll(0, m, 0, j - k, i);
          t.W(ChattingScrollLayout.this);
          AppMethodBeat.o(31732);
          return;
          i = 175;
          break;
          label107:
          i = 0;
        }
      }
    };
    post(this.Dyp);
    AppMethodBeat.o(185854);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(31737);
    if (this.pZ.computeScrollOffset())
    {
      this.Dyq = this.pZ.getCurrY();
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView != this.Dyv) {
          localView.setTranslationY(-this.Dyq);
        }
        i += 1;
      }
      ePp();
      t.W(this);
    }
    AppMethodBeat.o(31737);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(31739);
    if (paramMotionEvent.getActionMasked() == 0) {}
    for (this.Dyt = this.Dyq;; this.Dyt = 0) {
      do
      {
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(31739);
        return bool;
        paramMotionEvent.offsetLocation(0.0F, this.Dyt - this.Dyq);
      } while ((paramMotionEvent.getActionMasked() != 1) && (paramMotionEvent.getActionMasked() != 3));
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(31734);
    super.onFinishInflate();
    this.ofC = findViewById(2131302672);
    this.Dyv = findViewById(2131298070);
    this.Dyw = ((MMChattingListView)findViewById(2131298103));
    AppMethodBeat.o(31734);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31736);
    ac.i("MicroMsg.ChattingScrollLayout", "onLayout: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.Dyp != null)
    {
      removeCallbacks(this.Dyp);
      post(this.Dyp);
    }
    if ((this.pZ != null) && (this.pZ.isFinished())) {
      ePp();
    }
    AppMethodBeat.o(31736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChattingScrollLayout
 * JD-Core Version:    0.7.0.1
 */