package com.tencent.mm.plugin.wenote.model;

import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class k
{
  private static k vwQ = null;
  public long duration;
  public com.tencent.mm.compatible.util.b gaP;
  public long lvI;
  public boolean mwK;
  public boolean mwL;
  public long mwM;
  private Toast mwN;
  public j mwV;
  private final ak mwX;
  public final ap mwY;
  public TextView myn;
  public String path;
  public m vwO;
  public String vwP;
  public int vwR;
  public a vwS;
  public l vwT;
  public final ak vwU;
  
  private k()
  {
    AppMethodBeat.i(26669);
    this.mwM = -1L;
    this.vwP = "";
    this.path = "";
    this.vwR = 0;
    this.vwT = null;
    this.mwX = new ak()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26666);
        super.handleMessage(paramAnonymousMessage);
        k.b(k.this);
        AppMethodBeat.o(26666);
      }
    };
    this.vwU = new k.4(this);
    this.mwY = new ap(new k.5(this), true);
    this.gaP = new com.tencent.mm.compatible.util.b(ah.getContext());
    AppMethodBeat.o(26669);
  }
  
  private void bxx()
  {
    AppMethodBeat.i(26674);
    if (!this.mwK)
    {
      AppMethodBeat.o(26674);
      return;
    }
    this.vwU.removeMessages(4096);
    stopRecord();
    this.duration = getDuration();
    if (this.duration < 800L) {}
    for (int i = 1;; i = 0)
    {
      this.mwY.stopTimer();
      if (i != 0)
      {
        bxz();
        dhO();
      }
      this.mwK = false;
      AppMethodBeat.o(26674);
      return;
    }
  }
  
  private void bxz()
  {
    AppMethodBeat.i(26677);
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(this.path);
    if (localb.exists()) {
      localb.delete();
    }
    AppMethodBeat.o(26677);
  }
  
  public static void destroy()
  {
    vwQ = null;
  }
  
  public static k dhL()
  {
    AppMethodBeat.i(26670);
    if (vwQ == null) {
      vwQ = new k();
    }
    k localk = vwQ;
    AppMethodBeat.o(26670);
    return localk;
  }
  
  private void dhO()
  {
    AppMethodBeat.i(26675);
    this.mwX.sendEmptyMessageDelayed(0, 500L);
    AppMethodBeat.o(26675);
  }
  
  public static k dhP()
  {
    return vwQ;
  }
  
  private long getDuration()
  {
    AppMethodBeat.i(26676);
    if (this.lvI == 0L)
    {
      AppMethodBeat.o(26676);
      return 0L;
    }
    long l = bo.av(this.lvI);
    AppMethodBeat.o(26676);
    return l;
  }
  
  private void stopRecord()
  {
    AppMethodBeat.i(26673);
    if (this.vwP.equals("speex")) {
      this.vwO.Et();
    }
    for (;;)
    {
      if (this.gaP != null) {
        this.gaP.Mh();
      }
      AppMethodBeat.o(26673);
      return;
      this.mwV.Et();
    }
  }
  
  public final void dhM()
  {
    AppMethodBeat.i(26671);
    if (!this.mwK)
    {
      AppMethodBeat.o(26671);
      return;
    }
    if (!this.mwL) {
      bxx();
    }
    AppMethodBeat.o(26671);
  }
  
  public final String dhN()
  {
    AppMethodBeat.i(26672);
    if (e.cN(this.path))
    {
      String str = this.path;
      AppMethodBeat.o(26672);
      return str;
    }
    AppMethodBeat.o(26672);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.k
 * JD-Core Version:    0.7.0.1
 */