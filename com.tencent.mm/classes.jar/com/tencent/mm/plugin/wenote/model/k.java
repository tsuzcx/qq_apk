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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class k
{
  private static k ERS = null;
  public com.tencent.mm.plugin.wenote.model.b.a ERT;
  public l ERU;
  public long duration;
  public b iAr;
  public String pAa;
  public TextView pAc;
  public int pAd;
  private final aq pAg;
  public final aw pAh;
  public String path;
  public final aq pzK;
  public boolean pzT;
  public long pzU;
  public boolean pzV;
  public long pzW;
  private Toast pzX;
  public j pzY;
  public m pzZ;
  
  private k()
  {
    AppMethodBeat.i(30362);
    this.pzW = -1L;
    this.pAa = "";
    this.path = "";
    this.pAd = 0;
    this.ERU = null;
    this.pAg = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30359);
        super.handleMessage(paramAnonymousMessage);
        k.b(k.this);
        AppMethodBeat.o(30359);
      }
    };
    this.pzK = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30360);
        if (k.c(k.this).pAH.booleanValue())
        {
          k.d(k.this).cfs();
          k.c(k.this).pAH = Boolean.FALSE;
        }
        k.c(k.this).pAz = ((int)com.tencent.mm.bl.a.sI(k.e(k.this)));
        sendEmptyMessageDelayed(4096, 250L);
        AppMethodBeat.o(30360);
      }
    };
    this.pAh = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30361);
        if (k.f(k.this) == -1L) {
          k.a(k.this, bu.HQ());
        }
        long l = bu.aO(k.f(k.this));
        if ((l >= 3590000L) && (l <= 3600000L))
        {
          if (k.g(k.this) != null) {
            break label181;
          }
          k.a(k.this, Toast.makeText(ak.getContext(), ak.getContext().getString(2131758842, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
        }
        for (;;)
        {
          k.g(k.this).show();
          if (l < 3600000L) {
            break;
          }
          ae.v("MicroMsg.WNNoteVoiceLogic", "record stop on countdown");
          k.h(k.this);
          k.i(k.this);
          if (k.d(k.this) != null) {
            k.d(k.this).cfr();
          }
          AppMethodBeat.o(30361);
          return false;
          label181:
          k.g(k.this).setText(ak.getContext().getString(2131758842, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
        }
        AppMethodBeat.o(30361);
        return true;
      }
    }, true);
    this.iAr = new b(ak.getContext());
    AppMethodBeat.o(30362);
  }
  
  private void cfm()
  {
    AppMethodBeat.i(30367);
    if (!this.pzT)
    {
      AppMethodBeat.o(30367);
      return;
    }
    this.pzK.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.pAh.stopTimer();
      if (i != 0)
      {
        cfo();
        cfn();
      }
      this.pzT = false;
      AppMethodBeat.o(30367);
      return;
    }
  }
  
  private void cfn()
  {
    AppMethodBeat.i(30368);
    this.pAg.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(30368);
  }
  
  private void cfo()
  {
    AppMethodBeat.i(30370);
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(this.path);
    if (localk.exists()) {
      localk.delete();
    }
    AppMethodBeat.o(30370);
  }
  
  public static void destroy()
  {
    ERS = null;
  }
  
  public static k fay()
  {
    AppMethodBeat.i(30363);
    if (ERS == null) {
      ERS = new k();
    }
    k localk = ERS;
    AppMethodBeat.o(30363);
    return localk;
  }
  
  public static k faz()
  {
    return ERS;
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(30369);
    if (this.pzU == 0L)
    {
      AppMethodBeat.o(30369);
      return 0L;
    }
    long l = bu.aO(this.pzU);
    AppMethodBeat.o(30369);
    return l;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(30366);
    if (this.pAa.equals("speex")) {
      this.pzZ.PF();
    }
    for (;;)
    {
      if (this.iAr != null) {
        this.iAr.abn();
      }
      AppMethodBeat.o(30366);
      return;
      this.pzY.PF();
    }
  }
  
  public final void cfk()
  {
    AppMethodBeat.i(30364);
    if (!this.pzT)
    {
      AppMethodBeat.o(30364);
      return;
    }
    if (!this.pzV) {
      cfm();
    }
    AppMethodBeat.o(30364);
  }
  
  public final String cfl()
  {
    AppMethodBeat.i(30365);
    if (o.fB(this.path))
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