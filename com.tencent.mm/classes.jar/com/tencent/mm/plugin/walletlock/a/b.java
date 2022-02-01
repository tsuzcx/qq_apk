package com.tencent.mm.plugin.walletlock.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;

public abstract interface b
  extends a
{
  public abstract void a(Activity paramActivity, b paramb, a parama);
  
  public abstract boolean a(Activity paramActivity, b paramb);
  
  public abstract void aQ(Activity paramActivity);
  
  public abstract void aeZ(int paramInt);
  
  public abstract void b(Activity paramActivity, int paramInt1, int paramInt2);
  
  public abstract void c(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract b fUE();
  
  public abstract boolean fUF();
  
  public abstract boolean fUG();
  
  public abstract void init();
  
  public abstract void j(Activity paramActivity, Intent paramIntent);
  
  public abstract void l(Activity paramActivity, int paramInt);
  
  public abstract void m(Activity paramActivity, int paramInt);
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract boolean aR(Activity paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.a.b
 * JD-Core Version:    0.7.0.1
 */