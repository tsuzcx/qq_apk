package com.tencent.mm.plugin.walletlock.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;

public abstract interface b
  extends a
{
  public abstract void AZ(int paramInt);
  
  public abstract void P(Activity paramActivity);
  
  public abstract void a(Activity paramActivity, Intent paramIntent);
  
  public abstract void a(Activity paramActivity, b.b paramb);
  
  public abstract void a(Activity paramActivity, b.b paramb, b.a parama);
  
  public abstract void b(Activity paramActivity, int paramInt1, int paramInt2);
  
  public abstract void b(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract b.b bXL();
  
  public abstract boolean bXM();
  
  public abstract boolean bXN();
  
  public abstract void g(Activity paramActivity, int paramInt);
  
  public abstract void h(Activity paramActivity, int paramInt);
  
  public abstract void init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.a.b
 * JD-Core Version:    0.7.0.1
 */