package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;

public abstract interface i
{
  public abstract void a(Canvas paramCanvas, boolean paramBoolean, int paramInt);
  
  public abstract void aT(View paramView);
  
  public abstract View.OnClickListener czr();
  
  public abstract void dw(String paramString, int paramInt);
  
  public abstract void setOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setOnDoubleClickListener(a parama);
  
  public abstract void setShowStoryHint(boolean paramBoolean);
  
  public abstract void setWeakContext(Context paramContext);
  
  public static abstract interface a
  {
    public abstract boolean eg(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.i
 * JD-Core Version:    0.7.0.1
 */