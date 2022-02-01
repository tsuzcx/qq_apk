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
  private a IKO;
  float IKP;
  private RecyclerView.l IKQ;
  int mode;
  
  public JsonRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public JsonRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38910);
    this.IKQ = new RecyclerView.l()
    {
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(196951);
        switch (paramAnonymousMotionEvent.getAction() & paramAnonymousMotionEvent.getActionMasked())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(196951);
          return false;
          JsonRecyclerView.this.mode = 1;
          continue;
          JsonRecyclerView.this.mode = 0;
          continue;
          paramAnonymousRecyclerView = JsonRecyclerView.this;
          paramAnonymousRecyclerView.mode -= 1;
          continue;
          JsonRecyclerView.this.IKP = JsonRecyclerView.ad(paramAnonymousMotionEvent);
          paramAnonymousRecyclerView = JsonRecyclerView.this;
          paramAnonymousRecyclerView.mode += 1;
          continue;
          if (JsonRecyclerView.this.mode >= 2)
          {
            float f = JsonRecyclerView.ad(paramAnonymousMotionEvent);
            if (Math.abs(f - JsonRecyclerView.this.IKP) > 0.5F)
            {
              JsonRecyclerView.a(JsonRecyclerView.this, f / JsonRecyclerView.this.IKP);
              JsonRecyclerView.this.IKP = f;
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
  
  private void v(View paramView, float paramFloat)
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
        v(paramView.getChildAt(i), paramFloat);
        i += 1;
      }
    }
    AppMethodBeat.o(38913);
  }
  
  public void setBracesColor(int paramInt)
  {
    a.IKI = paramInt;
  }
  
  public void setKeyColor(int paramInt)
  {
    a.IKC = paramInt;
  }
  
  public void setScaleEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(38912);
    if (paramBoolean)
    {
      a(this.IKQ);
      AppMethodBeat.o(38912);
      return;
    }
    b(this.IKQ);
    AppMethodBeat.o(38912);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(38911);
    float f;
    if (paramFloat < 10.0F) {
      f = 10.0F;
    }
    while (a.IKJ != f)
    {
      a.IKJ = f;
      if (this.IKO == null) {
        break;
      }
      RecyclerView.i locali = getLayoutManager();
      int j = locali.getChildCount();
      int i = 0;
      while (i < j)
      {
        v(locali.getChildAt(i), f);
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
    a.IKF = paramInt;
  }
  
  public void setValueNullColor(int paramInt)
  {
    a.IKE = paramInt;
  }
  
  public void setValueNumberColor(int paramInt)
  {
    a.IKE = paramInt;
  }
  
  public void setValueTextColor(int paramInt)
  {
    a.IKD = paramInt;
  }
  
  public void setValueUrlColor(int paramInt)
  {
    a.IKG = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.recyclerview.JsonRecyclerView
 * JD-Core Version:    0.7.0.1
 */