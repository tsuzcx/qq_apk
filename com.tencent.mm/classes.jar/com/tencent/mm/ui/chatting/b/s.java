package com.tencent.mm.ui.chatting.b;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.AbsListView;
import com.tencent.mm.ah.m;
import com.tencent.mm.as.b;
import com.tencent.mm.as.d;
import com.tencent.mm.as.d.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.lt;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.chatting.b.b.p;
import com.tencent.mm.ui.chatting.gallery.g.a;
import java.util.LinkedList;

@com.tencent.mm.ui.chatting.b.a.a(cFA=p.class)
public class s
  extends a
  implements d.a, x.a, p
{
  private com.tencent.mm.sdk.b.c vqD = new s.1(this);
  private am vqE = new am(new s.2(this), false);
  private com.tencent.mm.ui.chatting.gallery.g vqF = g.a.vvC;
  
  private void stopTimer()
  {
    if (au.DK()) {
      o.OK().a(this);
    }
    this.vqE.stopTimer();
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    com.tencent.mm.modelcontrol.c.Ni();
    if (!com.tencent.mm.modelcontrol.c.Nj()) {
      o.OK().a(this);
    }
    if ((paramInt3 == 0) && (paramInt4 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      o.OL();
      b.a(paramLong1, paramLong2, bool);
      au.Hx();
      paramObject = com.tencent.mm.model.c.Fy().fd(paramLong2);
      ((com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).a(paramLong2, paramObject, bool);
      return;
    }
  }
  
  public final void cDC()
  {
    super.cDC();
    stopTimer();
  }
  
  public final void cyN() {}
  
  public final void cyO()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.vqD);
  }
  
  public final void cyP()
  {
    lt locallt = new lt();
    locallt.bUN.bUO = true;
    com.tencent.mm.sdk.b.a.udP.a(locallt, Looper.getMainLooper());
    x.b(this);
  }
  
  public final void cyQ()
  {
    lt locallt = new lt();
    locallt.bUN.bUO = false;
    com.tencent.mm.sdk.b.a.udP.a(locallt, Looper.getMainLooper());
    x.c(this);
    stopTimer();
  }
  
  public final void cyR()
  {
    stopTimer();
    com.tencent.mm.sdk.b.a.udP.d(this.vqD);
    com.tencent.mm.ui.chatting.gallery.g localg = this.vqF;
    localg.kJv.clear();
    localg.aXQ();
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if ((bk.bl(paramString)) || (paramBitmap == null) || (this.byx == null)) {
      return;
    }
    com.tencent.mm.ui.chatting.c.a.cFG().post(new s.3(this));
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    o.ON().bR(paramInt);
    if (paramInt == 0) {
      startTimer();
    }
    while (paramInt != 2) {
      return;
    }
    stopTimer();
  }
  
  public final void startTimer()
  {
    this.vqE.stopTimer();
    this.vqE.S(1000L, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.s
 * JD-Core Version:    0.7.0.1
 */