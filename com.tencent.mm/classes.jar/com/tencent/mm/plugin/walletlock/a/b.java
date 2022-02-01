package com.tencent.mm.plugin.walletlock.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;

public abstract interface b
  extends a
{
  public abstract void a(Activity paramActivity, b paramb, a parama);
  
  public abstract boolean a(Activity paramActivity, b paramb);
  
  public abstract void asE(int paramInt);
  
  public abstract void bA(Activity paramActivity);
  
  public abstract void c(Activity paramActivity, int paramInt1, int paramInt2);
  
  public abstract void h(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract boolean imA();
  
  public abstract boolean imB();
  
  public abstract b imz();
  
  public abstract void init();
  
  public abstract void o(Activity paramActivity, int paramInt);
  
  public abstract void p(Activity paramActivity, int paramInt);
  
  public abstract void t(Activity paramActivity, Intent paramIntent);
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract boolean bB(Activity paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.a.b
 * JD-Core Version:    0.7.0.1
 */