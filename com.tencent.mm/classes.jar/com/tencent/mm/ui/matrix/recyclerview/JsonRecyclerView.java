package com.tencent.mm.ui.matrix.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public class JsonRecyclerView
  extends RecyclerView
{
  private a XLi;
  float XLj;
  private RecyclerView.k XLk;
  int mode;
  
  public JsonRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public JsonRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38910);
    this.XLk = new RecyclerView.k()
    {
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(203893);
        switch (paramAnonymousMotionEvent.getAction() & paramAnonymousMotionEvent.getActionMasked())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(203893);
          return false;
          JsonRecyclerView.this.mode = 1;
          continue;
          JsonRecyclerView.this.mode = 0;
          continue;
          paramAnonymousRecyclerView = JsonRecyclerView.this;
          paramAnonymousRecyclerView.mode -= 1;
          continue;
          JsonRecyclerView.this.XLj = JsonRecyclerView.as(paramAnonymousMotionEvent);
          paramAnonymousRecyclerView = JsonRecyclerView.this;
          paramAnonymousRecyclerView.mode += 1;
          continue;
          if (JsonRecyclerView.this.mode >= 2)
          {
            float f = JsonRecyclerView.as(paramAnonymousMotionEvent);
            if (Math.abs(f - JsonRecyclerView.this.XLj) > 0.5F)
            {
              JsonRecyclerView.a(JsonRecyclerView.this, f / JsonRecyclerView.this.XLj);
              JsonRecyclerView.this.XLj = f;
            }
          }
        }
      }
      
      public final void ao(boolean paramAnonymousBoolean) {}
      
      public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(203894);
        b localb = new b();
        localb.bn(paramAnonymousRecyclerView);
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/matrix/recyclerview/JsonRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aFi());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/matrix/recyclerview/JsonRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(203894);
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
    a.XLc = paramInt;
  }
  
  public void setKeyColor(int paramInt)
  {
    a.XKW = paramInt;
  }
  
  public void setScaleEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(38912);
    if (paramBoolean)
    {
      a(this.XLk);
      AppMethodBeat.o(38912);
      return;
    }
    b(this.XLk);
    AppMethodBeat.o(38912);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(38911);
    float f;
    if (paramFloat < 10.0F) {
      f = 10.0F;
    }
    while (a.XLd != f)
    {
      a.XLd = f;
      if (this.XLi == null) {
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
    a.XKZ = paramInt;
  }
  
  public void setValueNullColor(int paramInt)
  {
    a.XKY = paramInt;
  }
  
  public void setValueNumberColor(int paramInt)
  {
    a.XKY = paramInt;
  }
  
  public void setValueTextColor(int paramInt)
  {
    a.XKX = paramInt;
  }
  
  public void setValueUrlColor(int paramInt)
  {
    a.XLa = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.recyclerview.JsonRecyclerView
 * JD-Core Version:    0.7.0.1
 */