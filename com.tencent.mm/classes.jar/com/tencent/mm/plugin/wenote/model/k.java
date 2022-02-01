package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.l.a;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.audio.b.j.a;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class k
{
  private static k XAv = null;
  public com.tencent.mm.plugin.wenote.model.b.a XAw;
  public l XAx;
  public long duration;
  public String path;
  public b peV;
  public final MMHandler xxC;
  public boolean xxL;
  public long xxM;
  public boolean xxN;
  public long xxO;
  private Toast xxP;
  public j xxQ;
  public m xxR;
  public String xxS;
  public TextView xxU;
  public int xxV;
  private final MMHandler xxY;
  public final MTimerHandler xxZ;
  
  private k()
  {
    AppMethodBeat.i(30362);
    this.xxO = -1L;
    this.xxS = "";
    this.path = "";
    this.xxV = 0;
    this.XAx = null;
    this.xxY = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30359);
        super.handleMessage(paramAnonymousMessage);
        k.b(k.this);
        AppMethodBeat.o(30359);
      }
    };
    this.xxC = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30360);
        if (k.c(k.this).xyA.booleanValue())
        {
          k.d(k.this).dwg();
          k.c(k.this).xyA = Boolean.FALSE;
        }
        k.c(k.this).xyr = ((int)com.tencent.mm.bf.a.jh(k.e(k.this)));
        sendEmptyMessageDelayed(4096, 250L);
        AppMethodBeat.o(30360);
      }
    };
    this.xxZ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30361);
        if (k.f(k.this) == -1L) {
          k.a(k.this, Util.currentTicks());
        }
        long l = Util.ticksToNow(k.f(k.this));
        if ((l >= 3590000L) && (l <= 3600000L))
        {
          if (k.g(k.this) != null) {
            break label182;
          }
          k.a(k.this, Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.fav_rcd_time_limit, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
        }
        for (;;)
        {
          k.g(k.this).show();
          if (l < 3600000L) {
            break;
          }
          Log.v("MicroMsg.WNNoteVoiceLogic", "record stop on countdown");
          k.h(k.this);
          k.i(k.this);
          if (k.d(k.this) != null) {
            k.d(k.this).dwf();
          }
          AppMethodBeat.o(30361);
          return false;
          label182:
          k.g(k.this).setText(MMApplicationContext.getContext().getString(R.l.fav_rcd_time_limit, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
        }
        AppMethodBeat.o(30361);
        return true;
      }
    }, true);
    this.peV = new b(MMApplicationContext.getContext());
    AppMethodBeat.o(30362);
  }
  
  public static void destroy()
  {
    XAv = null;
  }
  
  private void dwa()
  {
    AppMethodBeat.i(30367);
    if (!this.xxL)
    {
      AppMethodBeat.o(30367);
      return;
    }
    this.xxC.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.xxZ.stopTimer();
      if (i != 0)
      {
        dwc();
        dwb();
      }
      this.xxL = false;
      AppMethodBeat.o(30367);
      return;
    }
  }
  
  private void dwb()
  {
    AppMethodBeat.i(30368);
    this.xxY.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(30368);
  }
  
  private void dwc()
  {
    AppMethodBeat.i(30370);
    u localu = new u(this.path);
    if (localu.jKS()) {
      localu.diJ();
    }
    AppMethodBeat.o(30370);
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(30369);
    if (this.xxM == 0L)
    {
      AppMethodBeat.o(30369);
      return 0L;
    }
    long l = Util.ticksToNow(this.xxM);
    AppMethodBeat.o(30369);
    return l;
  }
  
  public static k iDY()
  {
    AppMethodBeat.i(30363);
    if (XAv == null) {
      XAv = new k();
    }
    k localk = XAv;
    AppMethodBeat.o(30363);
    return localk;
  }
  
  public static k iDZ()
  {
    return XAv;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(30366);
    if (this.xxS.equals("speex")) {
      this.xxR.aGH();
    }
    for (;;)
    {
      if (this.peV != null) {
        this.peV.aPS();
      }
      AppMethodBeat.o(30366);
      return;
      this.xxQ.aGH();
    }
  }
  
  public final void dvY()
  {
    AppMethodBeat.i(30364);
    if (!this.xxL)
    {
      AppMethodBeat.o(30364);
      return;
    }
    if (!this.xxN) {
      dwa();
    }
    AppMethodBeat.o(30364);
  }
  
  public final String dvZ()
  {
    AppMethodBeat.i(30365);
    if (y.ZC(this.path))
    {
      String str = this.path;
      AppMethodBeat.o(30365);
      return str;
    }
    AppMethodBeat.o(30365);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.k
 * JD-Core Version:    0.7.0.1
 */