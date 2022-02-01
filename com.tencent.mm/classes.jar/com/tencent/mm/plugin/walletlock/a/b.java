package com.tencent.mm.plugin.walletlock.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;

public abstract interface b
  extends a
{
  public abstract void a(Activity paramActivity, b.b paramb, a parama);
  
  public abstract boolean a(Activity paramActivity, b.b paramb);
  
  public abstract void aV(Activity paramActivity);
  
  public abstract void amN(int paramInt);
  
  public abstract void b(Activity paramActivity, int paramInt1, int paramInt2);
  
  public abstract void e(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract b.b gNk();
  
  public abstract boolean gNl();
  
  public abstract boolean gNm();
  
  public abstract void init();
  
  public abstract void m(Activity paramActivity, int paramInt);
  
  public abstract void n(Activity paramActivity, int paramInt);
  
  public abstract void n(Activity paramActivity, Intent paramIntent);
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.a.b
 * JD-Core Version:    0.7.0.1
 */