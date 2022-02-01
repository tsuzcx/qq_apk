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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.chatting.ChattingAnimFrame;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public class ChattingScrollLayout
  extends LinearLayout
{
  private int FdA;
  private int FdB;
  private int FdC;
  private int FdD;
  private View FdE;
  MMChattingListView FdF;
  private Runnable Fdy;
  private int Fdz;
  private View oIV;
  private OverScroller rT;
  
  public ChattingScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChattingScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31733);
    this.Fdz = 0;
    this.FdA = 0;
    this.FdB = 0;
    this.FdC = 0;
    this.rT = new OverScroller(getContext(), new b());
    AppMethodBeat.o(31733);
  }
  
  private void fer()
  {
    AppMethodBeat.i(31738);
    int i = this.FdF.getBottomSpace();
    if (i > 0) {
      f1 = this.oIV.getTranslationY();
    }
    for (float f1 = i + f1;; f1 = this.oIV.getTranslationY())
    {
      float f2 = f1 + getInterTranslationY();
      f1 = f2;
      if (f2 > 0.0F) {
        f1 = 0.0F;
      }
      this.FdF.setTranslationY(f1);
      AppMethodBeat.o(31738);
      return;
    }
  }
  
  private void fes()
  {
    AppMethodBeat.i(31740);
    Object localObject = (ChattingAnimFrame)findViewById(2131297976);
    if (localObject == null)
    {
      localObject = findViewById(2131306439);
      ad.i("MicroMsg.ChattingScrollLayout", "resizeChatAnimFrame: use view stub");
    }
    for (;;)
    {
      if (localObject != null)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        if (localMarginLayoutParams != null)
        {
          localMarginLayoutParams.bottomMargin = this.FdA;
          ((View)localObject).setLayoutParams(localMarginLayoutParams);
        }
      }
      AppMethodBeat.o(31740);
      return;
      ad.i("MicroMsg.ChattingScrollLayout", "resizeChatAnimFrame: use view");
    }
  }
  
  private int getInterTranslationY()
  {
    if (this.FdB != 0) {
      return (int)(1.0D * this.Fdz / this.FdB * this.FdD);
    }
    return 0;
  }
  
  public final void c(int paramInt1, final boolean paramBoolean, final int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185854);
    ad.i("MicroMsg.ChattingScrollLayout", "scrollContentTo: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (this.FdA == paramInt1)
    {
      AppMethodBeat.o(185854);
      return;
    }
    this.FdA = paramInt1;
    if (this.FdA != 0) {
      this.FdB = this.FdA;
    }
    this.FdD = paramInt3;
    fes();
    this.rT.forceFinished(true);
    removeCallbacks(this.Fdy);
    this.Fdy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31732);
        ad.i("MicroMsg.ChattingScrollLayout", "scrollContentTo: in runnable");
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
    post(this.Fdy);
    AppMethodBeat.o(185854);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(31737);
    if (this.rT.computeScrollOffset())
    {
      this.Fdz = this.rT.getCurrY();
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView != this.FdE) {
          localView.setTranslationY(-this.Fdz);
        }
        i += 1;
      }
      fer();
      t.W(this);
    }
    AppMethodBeat.o(31737);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(31739);
    if (paramMotionEvent.getActionMasked() == 0) {}
    for (this.FdC = this.Fdz;; this.FdC = 0) {
      do
      {
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(31739);
        return bool;
        paramMotionEvent.offsetLocation(0.0F, this.FdC - this.Fdz);
      } while ((paramMotionEvent.getActionMasked() != 1) && (paramMotionEvent.getActionMasked() != 3));
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(31734);
    super.onFinishInflate();
    this.oIV = findViewById(2131302672);
    this.FdE = findViewById(2131298070);
    this.FdF = ((MMChattingListView)findViewById(2131298103));
    AppMethodBeat.o(31734);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31736);
    ad.i("MicroMsg.ChattingScrollLayout", "onLayout: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.Fdy != null)
    {
      removeCallbacks(this.Fdy);
      post(this.Fdy);
    }
    if ((this.rT != null) && (this.rT.isFinished())) {
      fer();
    }
    AppMethodBeat.o(31736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChattingScrollLayout
 * JD-Core Version:    0.7.0.1
 */