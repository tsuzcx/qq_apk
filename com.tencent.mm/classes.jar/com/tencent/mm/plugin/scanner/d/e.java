package com.tencent.mm.plugin.scanner.d;

import android.content.Context;
import android.os.Bundle;
import com.tencent.scanlib.ui.ScanView;

public abstract class e
{
  protected Context context;
  protected int mode;
  protected ScanView yFe;
  protected b yFf;
  
  public abstract void c(long paramLong, Bundle paramBundle);
  
  public abstract void destroy();
  
  public void z(long paramLong, boolean paramBoolean) {}
  
  public static abstract interface a
  {
    public abstract void t(int paramInt, Bundle paramBundle);
  }
  
  public static abstract interface b
  {
    public abstract void bXx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.d.e
 * JD-Core Version:    0.7.0.1
 */