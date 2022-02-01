package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.audio.b.j.a;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public final class k
{
  private static k CVz = null;
  public com.tencent.mm.plugin.wenote.model.b.a CVA;
  public l CVB;
  public long duration;
  public b ied;
  public boolean oPF;
  public long oPG;
  public boolean oPH;
  public long oPI;
  private Toast oPJ;
  public j oPK;
  public m oPL;
  public String oPM;
  public TextView oPO;
  public int oPP;
  private final ao oPS;
  public final au oPT;
  public final ao oPw;
  public String path;
  
  private k()
  {
    AppMethodBeat.i(30362);
    this.oPI = -1L;
    this.oPM = "";
    this.path = "";
    this.oPP = 0;
    this.CVB = null;
    this.oPS = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30359);
        super.handleMessage(paramAnonymousMessage);
        k.b(k.this);
        AppMethodBeat.o(30359);
      }
    };
    this.oPw = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30360);
        if (k.c(k.this).oQt.booleanValue())
        {
          k.d(k.this).bZz();
          k.c(k.this).oQt = Boolean.FALSE;
        }
        k.c(k.this).oQl = ((int)com.tencent.mm.bl.a.qw(k.e(k.this)));
        sendEmptyMessageDelayed(4096, 250L);
        AppMethodBeat.o(30360);
      }
    };
    this.oPT = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30361);
        if (k.f(k.this) == -1L) {
          k.a(k.this, bs.Gn());
        }
        long l = bs.aO(k.f(k.this));
        if ((l >= 3590000L) && (l <= 3600000L))
        {
          if (k.g(k.this) != null) {
            break label181;
          }
          k.a(k.this, Toast.makeText(ai.getContext(), ai.getContext().getString(2131758842, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
        }
        for (;;)
        {
          k.g(k.this).show();
          if (l < 3600000L) {
            break;
          }
          ac.v("MicroMsg.WNNoteVoiceLogic", "record stop on countdown");
          k.h(k.this);
          k.i(k.this);
          if (k.d(k.this) != null) {
            k.d(k.this).bZy();
          }
          AppMethodBeat.o(30361);
          return false;
          label181:
          k.g(k.this).setText(ai.getContext().getString(2131758842, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
        }
        AppMethodBeat.o(30361);
        return true;
      }
    }, true);
    this.ied = new b(ai.getContext());
    AppMethodBeat.o(30362);
  }
  
  private void bZt()
  {
    AppMethodBeat.i(30367);
    if (!this.oPF)
    {
      AppMethodBeat.o(30367);
      return;
    }
    this.oPw.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.oPT.stopTimer();
      if (i != 0)
      {
        bZv();
        bZu();
      }
      this.oPF = false;
      AppMethodBeat.o(30367);
      return;
    }
  }
  
  private void bZu()
  {
    AppMethodBeat.i(30368);
    this.oPS.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(30368);
  }
  
  private void bZv()
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
    CVz = null;
  }
  
  public static k eHT()
  {
    AppMethodBeat.i(30363);
    if (CVz == null) {
      CVz = new k();
    }
    k localk = CVz;
    AppMethodBeat.o(30363);
    return localk;
  }
  
  public static k eHU()
  {
    return CVz;
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(30369);
    if (this.oPG == 0L)
    {
      AppMethodBeat.o(30369);
      return 0L;
    }
    long l = bs.aO(this.oPG);
    AppMethodBeat.o(30369);
    return l;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(30366);
    if (this.oPM.equals("speex")) {
      this.oPL.NX();
    }
    for (;;)
    {
      if (this.ied != null) {
        this.ied.YC();
      }
      AppMethodBeat.o(30366);
      return;
      this.oPK.NX();
    }
  }
  
  public final void bZr()
  {
    AppMethodBeat.i(30364);
    if (!this.oPF)
    {
      AppMethodBeat.o(30364);
      return;
    }
    if (!this.oPH) {
      bZt();
    }
    AppMethodBeat.o(30364);
  }
  
  public final String bZs()
  {
    AppMethodBeat.i(30365);
    if (i.eA(this.path))
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