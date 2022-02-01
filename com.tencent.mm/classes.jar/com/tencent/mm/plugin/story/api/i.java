package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;

public abstract interface i
{
  public abstract void a(Canvas paramCanvas, boolean paramBoolean, int paramInt);
  
  public abstract void aZ(View paramView);
  
  public abstract View.OnClickListener ekD();
  
  public abstract void fn(String paramString, int paramInt);
  
  public abstract void setOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setShowStoryHint(boolean paramBoolean);
  
  public abstract void setWeakContext(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.i
 * JD-Core Version:    0.7.0.1
 */