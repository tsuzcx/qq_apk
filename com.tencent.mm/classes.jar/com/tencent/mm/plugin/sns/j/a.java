package com.tencent.mm.plugin.sns.j;

import android.database.Cursor;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class a
  extends com.tencent.mm.vending.app.a
  implements f
{
  String hcm;
  boolean oPz;
  String peN;
  boolean peO;
  int peP;
  public volatile av pgx;
  protected volatile am.a pjv;
  private h.a prt;
  
  static c.b bKD()
  {
    c.b localb = new c.b();
    Object localObject4 = af.bDK().bGp();
    int j = ((Cursor)localObject4).getCount();
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (j > 0)
    {
      ((Cursor)localObject4).moveToFirst();
      localObject1 = new j();
      ((j)localObject1).d((Cursor)localObject4);
    }
    Object localObject2;
    try
    {
      localObject1 = ((bsx)new bsx().aH(((j)localObject1).field_curActionBuf)).tAY;
      ((Cursor)localObject4).close();
      localObject3 = ((String)g.DP().Dz().get(ac.a.uzy, "")).split("&");
      localObject4 = new ArrayList();
      int i = 2;
      while (i < localObject3.length)
      {
        long l = bk.getLong(localObject3[i], 0L);
        if (l != 0L) {
          ((List)localObject4).add(Long.valueOf(l));
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.SnsTimelineInteractor", localException, "", new Object[0]);
        localObject2 = localObject3;
      }
      Collections.reverse((List)localObject4);
      if (((List)localObject4).size() <= 0) {}
    }
    for (localObject3 = (Long)((List)localObject4).get(0);; localObject3 = null)
    {
      i.i((Long)localObject3);
      localb.prA = j;
      localb.prz = localObject2;
      localb.prB = ((List)localObject4);
      return localb;
    }
  }
  
  public final void a(h.a parama)
  {
    this.pjv = af.bDv();
    c.a locala = (c.a)ad(c.a.class);
    this.prt = parama;
    this.pjv.a(1, locala.hcm, this.prt);
  }
  
  public final am.a bDv()
  {
    return this.pjv;
  }
  
  public final void f(String paramString, boolean paramBoolean, int paramInt)
  {
    this.pjv.a(1, paramString, paramBoolean, paramInt);
  }
  
  public final void g(String paramString, boolean paramBoolean, int paramInt)
  {
    this.pjv.b(1, paramString, paramBoolean, paramInt);
  }
  
  protected final void onCreate()
  {
    super.onCreate();
    a(c.b.class, new a.1(this));
    a(c.a.class, new a.2(this));
    y.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onCreate %s", new Object[] { this });
    b localb = af.bDA();
    synchronized (localb.dIn)
    {
      localb.ooH.clear();
      af.bDA();
      b.bCI();
      return;
    }
  }
  
  protected final void onDestroy()
  {
    y.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onDestroy %s", new Object[] { this });
    g.DQ();
    if ((g.DN().Dc()) && (this.pjv != null) && (this.prt != null)) {
      this.pjv.a(this.prt, 1);
    }
    super.onDestroy();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onSceneEnd  errType %d %d %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.a
 * JD-Core Version:    0.7.0.1
 */