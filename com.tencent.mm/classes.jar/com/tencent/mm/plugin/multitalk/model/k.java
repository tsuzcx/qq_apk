package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public final class k
{
  b tOU;
  private ap tPE;
  public a tPF;
  
  public k(b paramb)
  {
    AppMethodBeat.i(114593);
    this.tPF = new a((byte)0);
    this.tOU = paramb;
    AppMethodBeat.o(114593);
  }
  
  public final void start()
  {
    AppMethodBeat.i(114594);
    ad.i("MicroMsg.MT.MultiTalkVideoNativeReceiver", "start native drawer handler");
    this.tPE = new ap("MultiTalkVideoTaskManager_native_drawer");
    AppMethodBeat.o(114594);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(114595);
    this.tOU = null;
    this.tPF.fUH = false;
    this.tPF.tPJ = null;
    if (this.tPE != null)
    {
      this.tPE.removeCallbacksAndMessages(null);
      this.tPE.getSerial().quit();
      this.tPE = null;
    }
    AppMethodBeat.o(114595);
  }
  
  public final class a
  {
    public int angle;
    public boolean fUH;
    public int h;
    public int mirror;
    public Bitmap rJR;
    public int tPH;
    public int[] tPJ;
    public int w;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.k
 * JD-Core Version:    0.7.0.1
 */