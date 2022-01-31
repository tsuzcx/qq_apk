package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;

public final class us
{
  private boolean a = false;
  private tw b;
  private tn c;
  private Handler d = new Handler();
  private us.a e;
  private float f = 0.0F;
  
  public us(tn paramtn)
  {
    this.c = paramtn;
  }
  
  public final void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a) && (this.b != null)) {
      return;
    }
    if (paramBoolean)
    {
      si localsi = new si();
      localsi.a(uk.a(this.c, ue.a.d)).b(false).a(true).a(0.0F);
      this.b = this.c.g().a(localsi);
      this.e = new us.a(this, 60000);
      this.d.post(this.e);
    }
    for (;;)
    {
      this.a = paramBoolean;
      return;
      if (this.b == null) {
        break;
      }
      this.b.b();
      this.b = null;
      this.e.a(false);
      this.d.removeCallbacks(this.e);
      this.e = null;
    }
  }
  
  public final boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.us
 * JD-Core Version:    0.7.0.1
 */