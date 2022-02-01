package com.tencent.mm.ui.matrix.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.k;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public class JsonRecyclerView
  extends RecyclerView
{
  private a Qnj;
  float Qnk;
  private RecyclerView.k Qnl;
  int mode;
  
  public JsonRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public JsonRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38910);
    this.Qnl = new RecyclerView.k()
    {
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(234461);
        switch (paramAnonymousMotionEvent.getAction() & paramAnonymousMotionEvent.getActionMasked())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(234461);
          return false;
          JsonRecyclerView.this.mode = 1;
          continue;
          JsonRecyclerView.this.mode = 0;
          continue;
          paramAnonymousRecyclerView = JsonRecyclerView.this;
          paramAnonymousRecyclerView.mode -= 1;
          continue;
          JsonRecyclerView.this.Qnk = JsonRecyclerView.ak(paramAnonymousMotionEvent);
          paramAnonymousRecyclerView = JsonRecyclerView.this;
          paramAnonymousRecyclerView.mode += 1;
          continue;
          if (JsonRecyclerView.this.mode >= 2)
          {
            float f = JsonRecyclerView.ak(paramAnonymousMotionEvent);
            if (Math.abs(f - JsonRecyclerView.this.Qnk) > 0.5F)
            {
              JsonRecyclerView.a(JsonRecyclerView.this, f / JsonRecyclerView.this.Qnk);
              JsonRecyclerView.this.Qnk = f;
            }
          }
        }
      }
      
      public final void ah(boolean paramAnonymousBoolean) {}
      
      public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(234462);
        b localb = new b();
        localb.bm(paramAnonymousRecyclerView);
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/matrix/recyclerview/JsonRecyclerView$1", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/matrix/recyclerview/JsonRecyclerView$1", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(234462);
      }
    };
    getContext();
    setLayoutManager(new LinearLayoutManager());
    AppMethodBeat.o(38910);
  }
  
  private void C(View paramView, float paramFloat)
  {
    AppMethodBeat.i(38913);
    if ((paramView instanceof JsonItemView))
    {
      paramView = (JsonItemView)paramView;
      paramView.setTextSize(paramFloat);
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        C(paramView.getChildAt(i), paramFloat);
        i += 1;
      }
    }
    AppMethodBeat.o(38913);
  }
  
  public void setBracesColor(int paramInt)
  {
    a.Qnd = paramInt;
  }
  
  public void setKeyColor(int paramInt)
  {
    a.QmX = paramInt;
  }
  
  public void setScaleEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(38912);
    if (paramBoolean)
    {
      a(this.Qnl);
      AppMethodBeat.o(38912);
      return;
    }
    b(this.Qnl);
    AppMethodBeat.o(38912);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(38911);
    float f;
    if (paramFloat < 10.0F) {
      f = 10.0F;
    }
    while (a.Qne != f)
    {
      a.Qne = f;
      if (this.Qnj == null) {
        break;
      }
      RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
      int j = localLayoutManager.getChildCount();
      int i = 0;
      while (i < j)
      {
        C(localLayoutManager.getChildAt(i), f);
        i += 1;
      }
      f = paramFloat;
      if (paramFloat > 30.0F) {
        f = 30.0F;
      }
    }
    AppMethodBeat.o(38911);
  }
  
  public void setValueBooleanColor(int paramInt)
  {
    a.Qna = paramInt;
  }
  
  public void setValueNullColor(int paramInt)
  {
    a.QmZ = paramInt;
  }
  
  public void setValueNumberColor(int paramInt)
  {
    a.QmZ = paramInt;
  }
  
  public void setValueTextColor(int paramInt)
  {
    a.QmY = paramInt;
  }
  
  public void setValueUrlColor(int paramInt)
  {
    a.Qnb = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.recyclerview.JsonRecyclerView
 * JD-Core Version:    0.7.0.1
 */