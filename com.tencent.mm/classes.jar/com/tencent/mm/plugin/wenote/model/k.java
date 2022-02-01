package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.m.a;
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
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class k
{
  private static k JHF = null;
  public com.tencent.mm.plugin.wenote.model.b.a JHG;
  public l JHH;
  public long duration;
  public b jvG;
  public String path;
  public final MMHandler qPb;
  public boolean qPk;
  public long qPl;
  public boolean qPm;
  public long qPn;
  private Toast qPo;
  public j qPp;
  public m qPq;
  public String qPr;
  public TextView qPt;
  public int qPu;
  private final MMHandler qPx;
  public final MTimerHandler qPy;
  
  private k()
  {
    AppMethodBeat.i(30362);
    this.qPn = -1L;
    this.qPr = "";
    this.path = "";
    this.qPu = 0;
    this.JHH = null;
    this.qPx = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30359);
        super.handleMessage(paramAnonymousMessage);
        k.b(k.this);
        AppMethodBeat.o(30359);
      }
    };
    this.qPb = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30360);
        if (k.c(k.this).qPY.booleanValue())
        {
          k.d(k.this).cDi();
          k.c(k.this).qPY = Boolean.FALSE;
        }
        k.c(k.this).qPQ = ((int)com.tencent.mm.bl.a.AO(k.e(k.this)));
        sendEmptyMessageDelayed(4096, 250L);
        AppMethodBeat.o(30360);
      }
    };
    this.qPy = new MTimerHandler(new MTimerHandler.CallBack()
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
            break label181;
          }
          k.a(k.this, Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131759165, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
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
            k.d(k.this).cDh();
          }
          AppMethodBeat.o(30361);
          return false;
          label181:
          k.g(k.this).setText(MMApplicationContext.getContext().getString(2131759165, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
        }
        AppMethodBeat.o(30361);
        return true;
      }
    }, true);
    this.jvG = new b(MMApplicationContext.getContext());
    AppMethodBeat.o(30362);
  }
  
  private void cDc()
  {
    AppMethodBeat.i(30367);
    if (!this.qPk)
    {
      AppMethodBeat.o(30367);
      return;
    }
    this.qPb.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.qPy.stopTimer();
      if (i != 0)
      {
        cDe();
        cDd();
      }
      this.qPk = false;
      AppMethodBeat.o(30367);
      return;
    }
  }
  
  private void cDd()
  {
    AppMethodBeat.i(30368);
    this.qPx.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(30368);
  }
  
  private void cDe()
  {
    AppMethodBeat.i(30370);
    o localo = new o(this.path);
    if (localo.exists()) {
      localo.delete();
    }
    AppMethodBeat.o(30370);
  }
  
  public static void destroy()
  {
    JHF = null;
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(30369);
    if (this.qPl == 0L)
    {
      AppMethodBeat.o(30369);
      return 0L;
    }
    long l = Util.ticksToNow(this.qPl);
    AppMethodBeat.o(30369);
    return l;
  }
  
  public static k gjD()
  {
    AppMethodBeat.i(30363);
    if (JHF == null) {
      JHF = new k();
    }
    k localk = JHF;
    AppMethodBeat.o(30363);
    return localk;
  }
  
  public static k gjE()
  {
    return JHF;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(30366);
    if (this.qPr.equals("speex")) {
      this.qPq.ZZ();
    }
    for (;;)
    {
      if (this.jvG != null) {
        this.jvG.apm();
      }
      AppMethodBeat.o(30366);
      return;
      this.qPp.ZZ();
    }
  }
  
  public final void cDa()
  {
    AppMethodBeat.i(30364);
    if (!this.qPk)
    {
      AppMethodBeat.o(30364);
      return;
    }
    if (!this.qPm) {
      cDc();
    }
    AppMethodBeat.o(30364);
  }
  
  public final String cDb()
  {
    AppMethodBeat.i(30365);
    if (s.YS(this.path))
    {
      String str = this.path;
      AppMethodBeat.o(30365);
      return str;
    }
    AppMethodBeat.o(30365);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.k
 * JD-Core Version:    0.7.0.1
 */