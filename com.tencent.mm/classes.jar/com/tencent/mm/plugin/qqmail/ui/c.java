package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.jz;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;

public final class c
  implements f
{
  private static long niW = 0L;
  private Activity bMV;
  private c.a niX;
  
  public c(Activity paramActivity)
  {
    g.DO().dJT.a(138, this);
    this.bMV = paramActivity;
  }
  
  public final void a(c.a parama)
  {
    this.niX = parama;
    parama = new jz();
    parama.bSE.bMV = this.bMV;
    parama.bSE.bSG = new c.1(this, parama);
    a.udP.a(parama, Looper.myLooper());
  }
  
  protected final void finalize()
  {
    release();
    super.finalize();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.niX != null)
      {
        this.niX.btI();
        this.niX = null;
      }
    }
    for (;;)
    {
      niW = System.currentTimeMillis();
      return;
      if (this.niX != null)
      {
        this.niX.btJ();
        this.niX = null;
      }
    }
  }
  
  public final void release()
  {
    g.DO().dJT.b(138, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.c
 * JD-Core Version:    0.7.0.1
 */