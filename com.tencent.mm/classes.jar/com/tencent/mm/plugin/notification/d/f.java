package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.al;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f
  implements ar
{
  private static f mJa = null;
  com.tencent.mm.plugin.notification.c.c mJb = null;
  com.tencent.mm.plugin.notification.c.c mJc = null;
  private com.tencent.mm.plugin.notification.a.a mJd = null;
  private boolean mJe = false;
  private com.tencent.mm.sdk.b.c mJf = new f.1(this);
  private com.tencent.mm.sdk.b.c mJg = new f.2(this);
  private com.tencent.mm.sdk.b.c mJh = new f.3(this);
  private com.tencent.mm.sdk.b.c mJi = new f.4(this);
  private com.tencent.mm.sdk.b.c mJj = new f.5(this);
  private com.tencent.mm.sdk.b.c mJk = new f.6(this);
  
  private f()
  {
    b.init();
    if (this.mJc == null) {
      this.mJc = new e();
    }
    if (this.mJb == null) {
      this.mJb = new d();
    }
  }
  
  public static ArrayList<Long> X(bi parambi)
  {
    if (parambi == null) {
      return null;
    }
    au.Hx();
    com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
    Object localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().bhZ();
    parambi = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      parambi.add(Long.valueOf(((bi)((Iterator)localObject).next()).field_msgId));
    }
    return parambi;
  }
  
  public static f bpH()
  {
    if (mJa == null)
    {
      mJa = new f();
      au.Hq().a("plugin.notification", mJa);
    }
    return mJa;
  }
  
  public static boolean bpI()
  {
    return bpH().mJe;
  }
  
  public static FailSendMsgNotification vx(int paramInt)
  {
    if ((paramInt == 2) && (bpH().mJc != null))
    {
      y.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
      return bpH().mJc.bpt();
    }
    if ((paramInt == 1) && (bpH().mJb != null))
    {
      y.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
      return bpH().mJb.bpt();
    }
    return null;
  }
  
  public final void bh(boolean paramBoolean)
  {
    this.mJb.bpC();
    this.mJb.bpD();
    this.mJc.bpC();
    this.mJc.bpD();
    if (this.mJd == null) {
      this.mJd = new com.tencent.mm.plugin.notification.a.a();
    }
    com.tencent.mm.plugin.notification.a.a locala = this.mJd;
    if (!au.DK()) {
      y.e("MicroMsg.NotificationObserver", "account not ready!");
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.udP.c(this.mJf);
      com.tencent.mm.sdk.b.a.udP.c(this.mJg);
      com.tencent.mm.sdk.b.a.udP.c(this.mJh);
      com.tencent.mm.sdk.b.a.udP.c(this.mJi);
      com.tencent.mm.sdk.b.a.udP.c(this.mJj);
      com.tencent.mm.sdk.b.a.udP.c(this.mJk);
      com.tencent.mm.m.f.Au();
      au.getNotification().fT(com.tencent.mm.m.f.Ax());
      au.getNotification().bd(false);
      y.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
      return;
      y.d("MicroMsg.NotificationObserver", "added");
      try
      {
        au.Hx();
        com.tencent.mm.model.c.FB().a(locala);
        locala.mIk = true;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.NotificationObserver", "exception:%s", new Object[] { bk.j(localException) });
      }
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    this.mJb.bpE();
    this.mJb.bpF();
    this.mJc.bpE();
    this.mJc.bpF();
    com.tencent.mm.plugin.notification.a.a locala;
    if (this.mJd != null)
    {
      locala = this.mJd;
      if (!au.DK()) {}
    }
    try
    {
      au.Hx();
      com.tencent.mm.model.c.FB().b(locala);
      com.tencent.mm.sdk.b.a.udP.d(this.mJf);
      com.tencent.mm.sdk.b.a.udP.d(this.mJg);
      com.tencent.mm.sdk.b.a.udP.d(this.mJh);
      com.tencent.mm.sdk.b.a.udP.d(this.mJi);
      com.tencent.mm.sdk.b.a.udP.d(this.mJj);
      com.tencent.mm.sdk.b.a.udP.d(this.mJk);
      au.getNotification().fT(0);
      au.getNotification().bd(true);
      y.d("MicroMsg.SubCoreNotification", "onAccountRelease");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.NotificationObserver", "exception:%s", new Object[] { bk.j(localException) });
      }
    }
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.f
 * JD-Core Version:    0.7.0.1
 */