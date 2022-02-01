package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public final class k
{
  private static k Ezw = null;
  public com.tencent.mm.plugin.wenote.model.b.a Ezx;
  public l Ezy;
  public long duration;
  public b ixy;
  public String path;
  private final ap ptC;
  public final av ptD;
  public final ap pte;
  public boolean ptn;
  public long pto;
  public boolean ptp;
  public long ptq;
  private Toast ptt;
  public j ptu;
  public m ptv;
  public String ptw;
  public TextView pty;
  public int ptz;
  
  private k()
  {
    AppMethodBeat.i(30362);
    this.ptq = -1L;
    this.ptw = "";
    this.path = "";
    this.ptz = 0;
    this.Ezy = null;
    this.ptC = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30359);
        super.handleMessage(paramAnonymousMessage);
        k.b(k.this);
        AppMethodBeat.o(30359);
      }
    };
    this.pte = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30360);
        if (k.c(k.this).pud.booleanValue())
        {
          k.d(k.this).ced();
          k.c(k.this).pud = Boolean.FALSE;
        }
        k.c(k.this).ptV = ((int)com.tencent.mm.bm.a.sv(k.e(k.this)));
        sendEmptyMessageDelayed(4096, 250L);
        AppMethodBeat.o(30360);
      }
    };
    this.ptD = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30361);
        if (k.f(k.this) == -1L) {
          k.a(k.this, bt.HI());
        }
        long l = bt.aO(k.f(k.this));
        if ((l >= 3590000L) && (l <= 3600000L))
        {
          if (k.g(k.this) != null) {
            break label181;
          }
          k.a(k.this, Toast.makeText(aj.getContext(), aj.getContext().getString(2131758842, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
        }
        for (;;)
        {
          k.g(k.this).show();
          if (l < 3600000L) {
            break;
          }
          ad.v("MicroMsg.WNNoteVoiceLogic", "record stop on countdown");
          k.h(k.this);
          k.i(k.this);
          if (k.d(k.this) != null) {
            k.d(k.this).cec();
          }
          AppMethodBeat.o(30361);
          return false;
          label181:
          k.g(k.this).setText(aj.getContext().getString(2131758842, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
        }
        AppMethodBeat.o(30361);
        return true;
      }
    }, true);
    this.ixy = new b(aj.getContext());
    AppMethodBeat.o(30362);
  }
  
  private void cdX()
  {
    AppMethodBeat.i(30367);
    if (!this.ptn)
    {
      AppMethodBeat.o(30367);
      return;
    }
    this.pte.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.ptD.stopTimer();
      if (i != 0)
      {
        cdZ();
        cdY();
      }
      this.ptn = false;
      AppMethodBeat.o(30367);
      return;
    }
  }
  
  private void cdY()
  {
    AppMethodBeat.i(30368);
    this.ptC.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(30368);
  }
  
  private void cdZ()
  {
    AppMethodBeat.i(30370);
    e locale = new e(this.path);
    if (locale.exists()) {
      locale.delete();
    }
    AppMethodBeat.o(30370);
  }
  
  public static void destroy()
  {
    Ezw = null;
  }
  
  public static k eWM()
  {
    AppMethodBeat.i(30363);
    if (Ezw == null) {
      Ezw = new k();
    }
    k localk = Ezw;
    AppMethodBeat.o(30363);
    return localk;
  }
  
  public static k eWN()
  {
    return Ezw;
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(30369);
    if (this.pto == 0L)
    {
      AppMethodBeat.o(30369);
      return 0L;
    }
    long l = bt.aO(this.pto);
    AppMethodBeat.o(30369);
    return l;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(30366);
    if (this.ptw.equals("speex")) {
      this.ptv.PG();
    }
    for (;;)
    {
      if (this.ixy != null) {
        this.ixy.abe();
      }
      AppMethodBeat.o(30366);
      return;
      this.ptu.PG();
    }
  }
  
  public final void cdV()
  {
    AppMethodBeat.i(30364);
    if (!this.ptn)
    {
      AppMethodBeat.o(30364);
      return;
    }
    if (!this.ptp) {
      cdX();
    }
    AppMethodBeat.o(30364);
  }
  
  public final String cdW()
  {
    AppMethodBeat.i(30365);
    if (i.fv(this.path))
    {
      String str = this.path;
      AppMethodBeat.o(30365);
      return str;
    }
    AppMethodBeat.o(30365);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.k
 * JD-Core Version:    0.7.0.1
 */