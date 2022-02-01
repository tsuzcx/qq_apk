package com.tencent.mm.plugin.walletlock.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;

public abstract interface b
  extends a
{
  public abstract void Wt(int paramInt);
  
  public abstract void a(Activity paramActivity, b paramb, a parama);
  
  public abstract boolean a(Activity paramActivity, b paramb);
  
  public abstract void aK(Activity paramActivity);
  
  public abstract void b(Activity paramActivity, int paramInt1, int paramInt2);
  
  public abstract void c(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void e(Activity paramActivity, Intent paramIntent);
  
  public abstract b eMV();
  
  public abstract boolean eMW();
  
  public abstract boolean eMX();
  
  public abstract void init();
  
  public abstract void l(Activity paramActivity, int paramInt);
  
  public abstract void m(Activity paramActivity, int paramInt);
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract boolean aL(Activity paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.a.b
 * JD-Core Version:    0.7.0.1
 */