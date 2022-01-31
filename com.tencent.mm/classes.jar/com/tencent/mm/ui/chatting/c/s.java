package com.tencent.mm.ui.chatting.c;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.d;
import com.tencent.mm.at.d.a;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.chatting.gallery.g.a;
import java.util.LinkedList;

@com.tencent.mm.ui.chatting.c.a.a(dJy=q.class)
public class s
  extends a
  implements d.a, x.a, q
{
  private com.tencent.mm.sdk.b.c kFH;
  private ap zGj;
  private com.tencent.mm.ui.chatting.gallery.g zGk;
  
  public s()
  {
    AppMethodBeat.i(31458);
    this.kFH = new s.1(this);
    this.zGj = new ap(new s.2(this), false);
    this.zGk = g.a.zLE;
    AppMethodBeat.o(31458);
  }
  
  private void dnu()
  {
    AppMethodBeat.i(31461);
    stopTimer();
    com.tencent.mm.sdk.b.a.ymk.d(this.kFH);
    com.tencent.mm.ui.chatting.gallery.g localg = this.zGk;
    localg.nfT.clear();
    localg.bEy();
    AppMethodBeat.o(31461);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(31460);
    if (aw.RG()) {
      o.ahD().a(this);
    }
    this.zGj.stopTimer();
    AppMethodBeat.o(31460);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(31463);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    AppMethodBeat.o(31463);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    AppMethodBeat.i(31462);
    if (!com.tencent.mm.plugin.priority.a.a.a.a.caM()) {
      o.ahD().a(this);
    }
    boolean bool;
    if ((paramInt3 == 0) && (paramInt4 == 0))
    {
      bool = true;
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, bool, false);
      if (!com.tencent.mm.plugin.priority.a.a.a.caL()) {
        break label117;
      }
      o.ahE();
      com.tencent.mm.at.b.a(paramLong1, paramLong2, bool);
    }
    for (;;)
    {
      aw.aaz();
      paramObject = com.tencent.mm.model.c.YC().kB(paramLong2);
      ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).a(paramLong2, paramObject, bool);
      AppMethodBeat.o(31462);
      return;
      bool = false;
      break;
      label117:
      ((com.tencent.mm.plugin.priority.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.priority.a.a.class)).getC2CImgAutoDownloader().b(paramLong1, paramLong2, bool);
    }
  }
  
  public final void dBZ() {}
  
  public final void dCa()
  {
    AppMethodBeat.i(31467);
    com.tencent.mm.sdk.b.a.ymk.c(this.kFH);
    AppMethodBeat.o(31467);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(31468);
    mj localmj = new mj();
    localmj.cCu.cCv = true;
    localmj.cCu.talker = this.caz.txj.field_username;
    com.tencent.mm.sdk.b.a.ymk.a(localmj, Looper.getMainLooper());
    x.b(this);
    AppMethodBeat.o(31468);
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31469);
    mj localmj = new mj();
    localmj.cCu.cCv = false;
    localmj.cCu.talker = this.caz.txj.field_username;
    com.tencent.mm.sdk.b.a.ymk.a(localmj, Looper.getMainLooper());
    x.c(this);
    stopTimer();
    AppMethodBeat.o(31469);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31470);
    dnu();
    AppMethodBeat.o(31470);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31466);
    super.dHq();
    dnu();
    AppMethodBeat.o(31466);
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(31464);
    if ((bo.isNullOrNil(paramString)) || (paramBitmap == null) || (this.caz == null))
    {
      AppMethodBeat.o(31464);
      return;
    }
    com.tencent.mm.ui.chatting.d.a.dJI().post(new s.3(this));
    AppMethodBeat.o(31464);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(31465);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    o.ahG().bX(paramInt);
    if (paramInt == 0)
    {
      startTimer();
      AppMethodBeat.o(31465);
      return;
    }
    if (paramInt == 2) {
      stopTimer();
    }
    AppMethodBeat.o(31465);
  }
  
  public final void startTimer()
  {
    AppMethodBeat.i(31459);
    this.zGj.stopTimer();
    this.zGj.ag(1000L, 1000L);
    AppMethodBeat.o(31459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.s
 * JD-Core Version:    0.7.0.1
 */