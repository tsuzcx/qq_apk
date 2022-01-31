package com.tencent.mm.ui;

import com.tencent.mm.blink.b;
import com.tencent.mm.h.a.pa;
import com.tencent.mm.h.a.sj;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.y.a.a;

public final class aa
  implements m.b
{
  MMFragmentActivity uJA;
  com.tencent.mm.sdk.b.c<pa> uJa = new aa.6(this);
  com.tencent.mm.sdk.b.c uJb = new aa.5(this);
  LauncherUI.c uOY;
  c uOZ;
  boolean uPa;
  Runnable uPb = new aa.1(this);
  a.a uPc = new aa.12(this);
  m.b uPd = new aa.2(this);
  com.tencent.mm.sdk.b.c uPe = new com.tencent.mm.sdk.b.c() {};
  
  public final void Ga(int paramInt)
  {
    if (this.uOZ != null)
    {
      this.uOZ.FH(paramInt);
      this.uOY.cyI();
    }
  }
  
  public final void Gb(int paramInt)
  {
    if (this.uOZ != null) {
      this.uOZ.setTo(paramInt);
    }
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String))) {
      y.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    }
    do
    {
      do
      {
        return;
        au.Hx();
      } while (paramm != com.tencent.mm.model.c.FB());
      y.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
    } while (!ad.hd((String)paramObject));
    czO();
  }
  
  protected final void czM()
  {
    b.vG().k(new aa.10(this));
  }
  
  protected final void czN()
  {
    if (this.uPa)
    {
      y.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
      czR();
    }
  }
  
  protected final void czO()
  {
    b.vG().k(new aa.9(this));
  }
  
  protected final void czR()
  {
    b.vG().k(new aa.8(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.aa
 * JD-Core Version:    0.7.0.1
 */