package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.k.a;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.audio.b.j.a;
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
  private static k BDt = null;
  public com.tencent.mm.plugin.wenote.model.b.a BDu;
  public l BDv;
  public long duration;
  public b hDB;
  public final ap olW;
  public boolean omf;
  public long omg;
  public boolean omh;
  public long omi;
  private Toast omj;
  public j omk;
  public m oml;
  public String omm;
  public TextView omo;
  public int omp;
  private final ap oms;
  public final av omt;
  public String path;
  
  private k()
  {
    AppMethodBeat.i(30362);
    this.omi = -1L;
    this.omm = "";
    this.path = "";
    this.omp = 0;
    this.BDv = null;
    this.oms = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30359);
        super.handleMessage(paramAnonymousMessage);
        k.b(k.this);
        AppMethodBeat.o(30359);
      }
    };
    this.olW = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30360);
        if (k.c(k.this).omT.booleanValue())
        {
          k.d(k.this).bSk();
          k.c(k.this).omT = Boolean.FALSE;
        }
        k.c(k.this).omL = ((int)com.tencent.mm.bm.a.mI(k.e(k.this)));
        sendEmptyMessageDelayed(4096, 250L);
        AppMethodBeat.o(30360);
      }
    };
    this.omt = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30361);
        if (k.f(k.this) == -1L) {
          k.a(k.this, bt.GC());
        }
        long l = bt.aS(k.f(k.this));
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
            k.d(k.this).bSj();
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
    this.hDB = new b(aj.getContext());
    AppMethodBeat.o(30362);
  }
  
  private void bSe()
  {
    AppMethodBeat.i(30367);
    if (!this.omf)
    {
      AppMethodBeat.o(30367);
      return;
    }
    this.olW.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.omt.stopTimer();
      if (i != 0)
      {
        bSg();
        bSf();
      }
      this.omf = false;
      AppMethodBeat.o(30367);
      return;
    }
  }
  
  private void bSf()
  {
    AppMethodBeat.i(30368);
    this.oms.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(30368);
  }
  
  private void bSg()
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
    BDt = null;
  }
  
  public static k esA()
  {
    AppMethodBeat.i(30363);
    if (BDt == null) {
      BDt = new k();
    }
    k localk = BDt;
    AppMethodBeat.o(30363);
    return localk;
  }
  
  public static k esB()
  {
    return BDt;
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(30369);
    if (this.omg == 0L)
    {
      AppMethodBeat.o(30369);
      return 0L;
    }
    long l = bt.aS(this.omg);
    AppMethodBeat.o(30369);
    return l;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(30366);
    if (this.omm.equals("speex")) {
      this.oml.Ob();
    }
    for (;;)
    {
      if (this.hDB != null) {
        this.hDB.XF();
      }
      AppMethodBeat.o(30366);
      return;
      this.omk.Ob();
    }
  }
  
  public final void bSc()
  {
    AppMethodBeat.i(30364);
    if (!this.omf)
    {
      AppMethodBeat.o(30364);
      return;
    }
    if (!this.omh) {
      bSe();
    }
    AppMethodBeat.o(30364);
  }
  
  public final String bSd()
  {
    AppMethodBeat.i(30365);
    if (i.eK(this.path))
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