package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.core.g.z;
import androidx.g.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.ChattingAnimFrame;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChattingScrollLayout
  extends LinearLayout
{
  private Runnable YjT;
  private int YjU;
  private int YjV;
  private int YjW;
  private int YjX;
  private int YjY;
  private View YjZ;
  MMChattingListView Yka;
  float Ykb;
  private OverScroller doG;
  private final List<a> listeners;
  private View uiF;
  
  public ChattingScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChattingScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31733);
    this.YjU = 0;
    this.YjV = 0;
    this.YjW = 0;
    this.YjX = 0;
    this.listeners = new LinkedList();
    this.Ykb = 0.0F;
    this.doG = new OverScroller(getContext(), new b());
    AppMethodBeat.o(31733);
  }
  
  private void Kf(boolean paramBoolean)
  {
    AppMethodBeat.i(245324);
    int i = this.Yka.getBottomSpace();
    float f1;
    if (i > 0)
    {
      f1 = this.uiF.getTranslationY();
      f1 = i + f1;
      float f2 = f1 + getInterTranslationY();
      f1 = f2;
      if (f2 > 0.0F) {
        f1 = 0.0F;
      }
      if (this.Ykb != f1)
      {
        if ((!paramBoolean) || (!this.doG.isFinished()) || (this.YjV <= 0) || (f1 >= this.Yka.getTranslationY()) || (!d.rb(24))) {
          break label188;
        }
        this.Yka.animate().translationY(f1).setDuration(100L).start();
      }
    }
    for (;;)
    {
      this.Ykb = f1;
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        this.doG.isFinished();
        locala.iNk();
      }
      f1 = this.uiF.getTranslationY();
      break;
      label188:
      this.Yka.setTranslationY(f1);
    }
    AppMethodBeat.o(245324);
  }
  
  private int getInterTranslationY()
  {
    if (this.YjW != 0) {
      return (int)(1.0D * this.YjU / this.YjW * this.YjY);
    }
    return 0;
  }
  
  private void iNj()
  {
    AppMethodBeat.i(31740);
    Object localObject = (ChattingAnimFrame)findViewById(R.h.fvK);
    if (localObject == null)
    {
      localObject = findViewById(R.h.gcd);
      Log.i("MicroMsg.ChattingScrollLayout", "resizeChatAnimFrame: use view stub");
    }
    for (;;)
    {
      if (localObject != null)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        if (localMarginLayoutParams != null)
        {
          localMarginLayoutParams.bottomMargin = this.YjV;
          ((View)localObject).setLayoutParams(localMarginLayoutParams);
        }
      }
      AppMethodBeat.o(31740);
      return;
      Log.i("MicroMsg.ChattingScrollLayout", "resizeChatAnimFrame: use view");
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(245339);
    if ((parama != null) && (!this.listeners.contains(parama))) {
      this.listeners.add(parama);
    }
    AppMethodBeat.o(245339);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(31737);
    if (this.doG.computeScrollOffset())
    {
      this.YjU = this.doG.getCurrY();
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView != this.YjZ) {
          localView.setTranslationY(-this.YjU);
        }
        i += 1;
      }
      Kf(false);
      z.Q(this);
    }
    AppMethodBeat.o(31737);
  }
  
  public final void d(int paramInt1, final boolean paramBoolean, final int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185854);
    Log.i("MicroMsg.ChattingScrollLayout", "scrollContentTo: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (this.YjV == paramInt1)
    {
      AppMethodBeat.o(185854);
      return;
    }
    this.YjV = paramInt1;
    if (this.YjV != 0) {
      this.YjW = this.YjV;
    }
    this.YjY = paramInt3;
    iNj();
    this.doG.forceFinished(true);
    removeCallbacks(this.YjT);
    this.YjT = new Runnable()
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
          z.Q(ChattingScrollLayout.this);
          AppMethodBeat.o(31732);
          return;
          i = 175;
          break;
          label107:
          i = 0;
        }
      }
    };
    post(this.YjT);
    AppMethodBeat.o(185854);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(31739);
    if (paramMotionEvent.getActionMasked() == 0) {}
    for (this.YjX = this.YjU;; this.YjX = 0) {
      do
      {
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(31739);
        return bool;
        paramMotionEvent.offsetLocation(0.0F, this.YjX - this.YjU);
      } while ((paramMotionEvent.getActionMasked() != 1) && (paramMotionEvent.getActionMasked() != 3));
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(31734);
    super.onFinishInflate();
    this.uiF = findViewById(R.h.fOZ);
    this.YjZ = findViewById(R.h.fxv);
    this.Yka = ((MMChattingListView)findViewById(R.h.fyt));
    AppMethodBeat.o(31734);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31736);
    Log.i("MicroMsg.ChattingScrollLayout", "onLayout: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.YjT != null)
    {
      removeCallbacks(this.YjT);
      post(this.YjT);
    }
    if ((this.doG != null) && (this.doG.isFinished())) {
      Kf(true);
    }
    AppMethodBeat.o(31736);
  }
  
  public static abstract interface a
  {
    public abstract void iNk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChattingScrollLayout
 * JD-Core Version:    0.7.0.1
 */