package com.tencent.mm.plugin.scanner.api.a;

import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.scanner.api.d;
import com.tencent.mm.plugin.scanner.api.e;

public abstract interface a
{
  public abstract long a(e parame, d paramd, c paramc);
  
  public abstract boolean gPD();
  
  public abstract void iT(View paramView);
  
  public abstract void iU(View paramView);
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract boolean onDoubleTap(MotionEvent paramMotionEvent);
  
  public abstract void release();
  
  public abstract boolean tP(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.api.a.a
 * JD-Core Version:    0.7.0.1
 */