package com.tencent.mm.ui.matrix.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.l;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class JsonRecyclerView
  extends RecyclerView
{
  private a Hkv;
  float Hkw;
  private RecyclerView.l Hkx;
  int mode;
  
  public JsonRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public JsonRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38910);
    this.Hkx = new RecyclerView.l()
    {
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(204985);
        switch (paramAnonymousMotionEvent.getAction() & paramAnonymousMotionEvent.getActionMasked())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(204985);
          return false;
          JsonRecyclerView.this.mode = 1;
          continue;
          JsonRecyclerView.this.mode = 0;
          continue;
          paramAnonymousRecyclerView = JsonRecyclerView.this;
          paramAnonymousRecyclerView.mode -= 1;
          continue;
          JsonRecyclerView.this.Hkw = JsonRecyclerView.ad(paramAnonymousMotionEvent);
          paramAnonymousRecyclerView = JsonRecyclerView.this;
          paramAnonymousRecyclerView.mode += 1;
          continue;
          if (JsonRecyclerView.this.mode >= 2)
          {
            float f = JsonRecyclerView.ad(paramAnonymousMotionEvent);
            if (Math.abs(f - JsonRecyclerView.this.Hkw) > 0.5F)
            {
              JsonRecyclerView.a(JsonRecyclerView.this, f / JsonRecyclerView.this.Hkw);
              JsonRecyclerView.this.Hkw = f;
            }
          }
        }
      }
      
      public final void ai(boolean paramAnonymousBoolean) {}
      
      public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent) {}
    };
    getContext();
    setLayoutManager(new LinearLayoutManager());
    AppMethodBeat.o(38910);
  }
  
  private void u(View paramView, float paramFloat)
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
        u(paramView.getChildAt(i), paramFloat);
        i += 1;
      }
    }
    AppMethodBeat.o(38913);
  }
  
  public void setBracesColor(int paramInt)
  {
    a.Hkp = paramInt;
  }
  
  public void setKeyColor(int paramInt)
  {
    a.Hkj = paramInt;
  }
  
  public void setScaleEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(38912);
    if (paramBoolean)
    {
      a(this.Hkx);
      AppMethodBeat.o(38912);
      return;
    }
    b(this.Hkx);
    AppMethodBeat.o(38912);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(38911);
    float f;
    if (paramFloat < 10.0F) {
      f = 10.0F;
    }
    while (a.Hkq != f)
    {
      a.Hkq = f;
      if (this.Hkv == null) {
        break;
      }
      RecyclerView.i locali = getLayoutManager();
      int j = locali.getChildCount();
      int i = 0;
      while (i < j)
      {
        u(locali.getChildAt(i), f);
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
    a.Hkm = paramInt;
  }
  
  public void setValueNullColor(int paramInt)
  {
    a.Hkl = paramInt;
  }
  
  public void setValueNumberColor(int paramInt)
  {
    a.Hkl = paramInt;
  }
  
  public void setValueTextColor(int paramInt)
  {
    a.Hkk = paramInt;
  }
  
  public void setValueUrlColor(int paramInt)
  {
    a.Hkn = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.recyclerview.JsonRecyclerView
 * JD-Core Version:    0.7.0.1
 */