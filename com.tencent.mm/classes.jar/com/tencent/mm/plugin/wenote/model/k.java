package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.m.a;
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
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;

public final class k
{
  private static k QGX = null;
  public com.tencent.mm.plugin.wenote.model.b.a QGY;
  public l QGZ;
  public long duration;
  public b mlj;
  public String path;
  public int urA;
  private final MMHandler urD;
  public final MTimerHandler urE;
  public final MMHandler urf;
  public boolean urq;
  public long urr;
  public boolean urs;
  public long urt;
  private Toast uru;
  public j urv;
  public m urw;
  public String urx;
  public TextView urz;
  
  private k()
  {
    AppMethodBeat.i(30362);
    this.urt = -1L;
    this.urx = "";
    this.path = "";
    this.urA = 0;
    this.QGZ = null;
    this.urD = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30359);
        super.handleMessage(paramAnonymousMessage);
        k.b(k.this);
        AppMethodBeat.o(30359);
      }
    };
    this.urf = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30360);
        if (k.c(k.this).use.booleanValue())
        {
          k.d(k.this).cRN();
          k.c(k.this).use = Boolean.FALSE;
        }
        k.c(k.this).urW = ((int)com.tencent.mm.bn.a.GW(k.e(k.this)));
        sendEmptyMessageDelayed(4096, 250L);
        AppMethodBeat.o(30360);
      }
    };
    this.urE = new MTimerHandler(new MTimerHandler.CallBack()
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
            k.d(k.this).cRM();
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
    this.mlj = new b(MMApplicationContext.getContext());
    AppMethodBeat.o(30362);
  }
  
  private void cRH()
  {
    AppMethodBeat.i(30367);
    if (!this.urq)
    {
      AppMethodBeat.o(30367);
      return;
    }
    this.urf.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.urE.stopTimer();
      if (i != 0)
      {
        cRJ();
        cRI();
      }
      this.urq = false;
      AppMethodBeat.o(30367);
      return;
    }
  }
  
  private void cRI()
  {
    AppMethodBeat.i(30368);
    this.urD.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(30368);
  }
  
  private void cRJ()
  {
    AppMethodBeat.i(30370);
    q localq = new q(this.path);
    if (localq.ifE()) {
      localq.cFq();
    }
    AppMethodBeat.o(30370);
  }
  
  public static void destroy()
  {
    QGX = null;
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(30369);
    if (this.urr == 0L)
    {
      AppMethodBeat.o(30369);
      return 0L;
    }
    long l = Util.ticksToNow(this.urr);
    AppMethodBeat.o(30369);
    return l;
  }
  
  public static k hdr()
  {
    AppMethodBeat.i(30363);
    if (QGX == null) {
      QGX = new k();
    }
    k localk = QGX;
    AppMethodBeat.o(30363);
    return localk;
  }
  
  public static k hds()
  {
    return QGX;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(30366);
    if (this.urx.equals("speex")) {
      this.urw.aeJ();
    }
    for (;;)
    {
      if (this.mlj != null) {
        this.mlj.avz();
      }
      AppMethodBeat.o(30366);
      return;
      this.urv.aeJ();
    }
  }
  
  public final void cRF()
  {
    AppMethodBeat.i(30364);
    if (!this.urq)
    {
      AppMethodBeat.o(30364);
      return;
    }
    if (!this.urs) {
      cRH();
    }
    AppMethodBeat.o(30364);
  }
  
  public final String cRG()
  {
    AppMethodBeat.i(30365);
    if (u.agG(this.path))
    {
      String str = this.path;
      AppMethodBeat.o(30365);
      return str;
    }
    AppMethodBeat.o(30365);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.k
 * JD-Core Version:    0.7.0.1
 */