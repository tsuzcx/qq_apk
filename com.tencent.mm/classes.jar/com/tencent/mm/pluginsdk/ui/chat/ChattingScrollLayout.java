package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.core.g.w;
import androidx.f.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.ChattingAnimFrame;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChattingScrollLayout
  extends LinearLayout
{
  private Runnable RnD;
  private int RnE;
  private int RnF;
  private int RnG;
  private int RnH;
  private int RnI;
  private View RnJ;
  MMChattingListView RnK;
  private OverScroller bvD;
  private final List<ChattingScrollLayout.a> listeners;
  private View tzi;
  
  public ChattingScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChattingScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31733);
    this.RnE = 0;
    this.RnF = 0;
    this.RnG = 0;
    this.RnH = 0;
    this.listeners = new LinkedList();
    this.bvD = new OverScroller(getContext(), new b());
    AppMethodBeat.o(31733);
  }
  
  private int getInterTranslationY()
  {
    if (this.RnG != 0) {
      return (int)(1.0D * this.RnE / this.RnG * this.RnI);
    }
    return 0;
  }
  
  private void hmr()
  {
    AppMethodBeat.i(31738);
    int i = this.RnK.getBottomSpace();
    if (i > 0) {
      f1 = this.tzi.getTranslationY();
    }
    for (float f1 = i + f1;; f1 = this.tzi.getTranslationY())
    {
      float f2 = f1 + getInterTranslationY();
      f1 = f2;
      if (f2 > 0.0F) {
        f1 = 0.0F;
      }
      this.RnK.setTranslationY(f1);
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext())
      {
        ChattingScrollLayout.a locala = (ChattingScrollLayout.a)localIterator.next();
        this.bvD.isFinished();
        locala.hmt();
      }
    }
    AppMethodBeat.o(31738);
  }
  
  private void hms()
  {
    AppMethodBeat.i(31740);
    Object localObject = (ChattingAnimFrame)findViewById(R.h.dvt);
    if (localObject == null)
    {
      localObject = findViewById(R.h.dZj);
      Log.i("MicroMsg.ChattingScrollLayout", "resizeChatAnimFrame: use view stub");
    }
    for (;;)
    {
      if (localObject != null)
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        if (localMarginLayoutParams != null)
        {
          localMarginLayoutParams.bottomMargin = this.RnF;
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
    AppMethodBeat.i(275136);
    if ((parama != null) && (!this.listeners.contains(parama))) {
      this.listeners.add(parama);
    }
    AppMethodBeat.o(275136);
  }
  
  public final void c(int paramInt1, final boolean paramBoolean, final int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(185854);
    Log.i("MicroMsg.ChattingScrollLayout", "scrollContentTo: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (this.RnF == paramInt1)
    {
      AppMethodBeat.o(185854);
      return;
    }
    this.RnF = paramInt1;
    if (this.RnF != 0) {
      this.RnG = this.RnF;
    }
    this.RnI = paramInt3;
    hms();
    this.bvD.forceFinished(true);
    removeCallbacks(this.RnD);
    this.RnD = new Runnable()
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
          w.G(ChattingScrollLayout.this);
          AppMethodBeat.o(31732);
          return;
          i = 175;
          break;
          label107:
          i = 0;
        }
      }
    };
    post(this.RnD);
    AppMethodBeat.o(185854);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(31737);
    if (this.bvD.computeScrollOffset())
    {
      this.RnE = this.bvD.getCurrY();
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView != this.RnJ) {
          localView.setTranslationY(-this.RnE);
        }
        i += 1;
      }
      hmr();
      w.G(this);
    }
    AppMethodBeat.o(31737);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(31739);
    if (paramMotionEvent.getActionMasked() == 0) {}
    for (this.RnH = this.RnE;; this.RnH = 0) {
      do
      {
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(31739);
        return bool;
        paramMotionEvent.offsetLocation(0.0F, this.RnH - this.RnE);
      } while ((paramMotionEvent.getActionMasked() != 1) && (paramMotionEvent.getActionMasked() != 3));
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(31734);
    super.onFinishInflate();
    this.tzi = findViewById(R.h.dNf);
    this.RnJ = findViewById(R.h.dxb);
    this.RnK = ((MMChattingListView)findViewById(R.h.dxL));
    AppMethodBeat.o(31734);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(31736);
    Log.i("MicroMsg.ChattingScrollLayout", "onLayout: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.RnD != null)
    {
      removeCallbacks(this.RnD);
      post(this.RnD);
    }
    if ((this.bvD != null) && (this.bvD.isFinished())) {
      hmr();
    }
    AppMethodBeat.o(31736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChattingScrollLayout
 * JD-Core Version:    0.7.0.1
 */