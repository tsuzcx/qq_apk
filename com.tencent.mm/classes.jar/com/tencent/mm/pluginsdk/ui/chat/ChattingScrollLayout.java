package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.support.v4.view.b.b;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.ChattingAnimFrame;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChattingScrollLayout
  extends LinearLayout
{
  private Runnable KmR;
  private int KmS;
  private int KmT;
  private int KmU;
  private int KmV;
  private int KmW;
  private View KmX;
  MMChattingListView KmY;
  private final List<ChattingScrollLayout.a> listeners;
  private View qdl;
  private OverScroller rW;
  
  public ChattingScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChattingScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31733);
    this.KmS = 0;
    this.KmT = 0;
    this.KmU = 0;
    this.KmV = 0;
    this.listeners = new LinkedList();
    this.rW = new OverScroller(getContext(), new b());
    AppMethodBeat.o(31733);
  }
  
  private int getInterTranslationY()
  {
    if (this.KmU != 0) {
      return (int)(1.0D * this.KmS / this.KmU * this.KmW);
    }
    return 0;
  }
  
  private void grs()
  {
    AppMethodBeat.i(31738);
    int i = this.KmY.getBottomSpace();
    if (i > 0) {
      f1 = this.qdl.getTranslationY();
    }
    for (float f1 = i + f1;; f1 = this.qdl.getTranslationY())
    {
      float f2 = f1 + getInterTranslationY();
      f1 = f2;
      if (f2 > 0.0F) {
        f1 = 0.0F;
      }
      this.KmY.setTranslationY(f1);
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext())
      {
        ChattingScrollLayout.a locala = (ChattingScrollLayout.a)localIterator.next();
        this.rW.isFinished();
        locala.gru();
      }
    }
    AppMethodBeat.o(31738);
  }
  
  private void grt()
  {
    AppMethodBeat.i(31740);
    Object localObject = (ChattingAnimFrame)findViewById(2131298317);
    if (localObject == null)
    {
      localObject = findViewById(2131309873);
      Log.i("MicroMsg.ChattingScrollLayout", "resizeChatAnimFrame: use view stub");
    }
    for (;;)
    {
      if (localObject != null)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        if (localMarginLayoutParams != null)
        {
          localMarginLayoutParams.bottomMargin = this.KmT;
          ((View)localObject).setLayoutParams(localMarginLayoutParams);
        }
      }
      AppMethodBeat.o(31740);
      return;
      Log.i("MicroMsg.ChattingScrollLayout", "resizeChatAnimFrame: use view");
    }
  }
  
  public final void a(ChattingScrollLayout.a parama)
  {
    AppMethodBeat.i(232331);
    if ((parama != null) && (!this.listeners.contains(parama))) {
      this.listeners.add(parama);
    }
    AppMethodBeat.o(232331);
  }
  
  public final void c(int paramInt1, final boolean paramBoolean, final int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185854);
    Log.i("MicroMsg.ChattingScrollLayout", "scrollContentTo: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (this.KmT == paramInt1)
    {
      AppMethodBeat.o(185854);
      return;
    }
    this.KmT = paramInt1;
    if (this.KmT != 0) {
      this.KmU = this.KmT;
    }
    this.KmW = paramInt3;
    grt();
    this.rW.forceFinished(true);
    removeCallbacks(this.KmR);
    this.KmR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(31732);
        Log.i("MicroMsg.ChattingScrollLayout", "scrollContentTo: in runnable");
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
          u.X(ChattingScrollLayout.this);
          AppMethodBeat.o(31732);
          return;
          i = 175;
          break;
          label107:
          i = 0;
        }
      }
    };
    post(this.KmR);
    AppMethodBeat.o(185854);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(31737);
    if (this.rW.computeScrollOffset())
    {
      this.KmS = this.rW.getCurrY();
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView != this.KmX) {
          localView.setTranslationY(-this.KmS);
        }
        i += 1;
      }
      grs();
      u.X(this);
    }
    AppMethodBeat.o(31737);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(31739);
    if (paramMotionEvent.getActionMasked() == 0) {}
    for (this.KmV = this.KmS;; this.KmV = 0) {
      do
      {
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(31739);
        return bool;
        paramMotionEvent.offsetLocation(0.0F, this.KmV - this.KmS);
      } while ((paramMotionEvent.getActionMasked() != 1) && (paramMotionEvent.getActionMasked() != 3));
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(31734);
    super.onFinishInflate();
    this.qdl = findViewById(2131305225);
    this.KmX = findViewById(2131298413);
    this.KmY = ((MMChattingListView)findViewById(2131298453));
    AppMethodBeat.o(31734);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31736);
    Log.i("MicroMsg.ChattingScrollLayout", "onLayout: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.KmR != null)
    {
      removeCallbacks(this.KmR);
      post(this.KmR);
    }
    if ((this.rW != null) && (this.rW.isFinished())) {
      grs();
    }
    AppMethodBeat.o(31736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChattingScrollLayout
 * JD-Core Version:    0.7.0.1
 */