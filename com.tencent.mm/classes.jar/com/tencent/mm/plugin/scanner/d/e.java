package com.tencent.mm.plugin.scanner.d;

import android.content.Context;
import android.os.Bundle;
import com.tencent.scanlib.ui.ScanView;

public abstract class e
{
  protected Context context;
  protected int mode;
  protected ScanView xbg;
  protected e.b xbh;
  
  public abstract void c(long paramLong, Bundle paramBundle);
  
  public abstract void destroy();
  
  public void y(long paramLong, boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract void s(int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.d.e
 * JD-Core Version:    0.7.0.1
 */