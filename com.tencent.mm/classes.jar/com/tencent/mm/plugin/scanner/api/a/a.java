package com.tencent.mm.plugin.scanner.api.a;

import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.scanner.api.d;
import com.tencent.mm.plugin.scanner.api.e;

public abstract interface a
{
  public abstract boolean It(long paramLong);
  
  public abstract long a(e parame, d paramd, c paramc);
  
  public abstract void eN(View paramView);
  
  public abstract void eO(View paramView);
  
  public abstract boolean eOV();
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract boolean onDoubleTap(MotionEvent paramMotionEvent);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.api.a.a
 * JD-Core Version:    0.7.0.1
 */