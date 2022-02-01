package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;

public final class k
{
  b uXw;
  private ao uYf;
  public a uYg;
  
  public k(b paramb)
  {
    AppMethodBeat.i(114593);
    this.uYg = new a((byte)0);
    this.uXw = paramb;
    AppMethodBeat.o(114593);
  }
  
  public final void start()
  {
    AppMethodBeat.i(114594);
    ac.i("MicroMsg.MT.MultiTalkVideoNativeReceiver", "start native drawer handler");
    this.uYf = new ao("MultiTalkVideoTaskManager_native_drawer");
    AppMethodBeat.o(114594);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(114595);
    this.uXw = null;
    this.uYg.fYC = false;
    this.uYg.uYj = null;
    if (this.uYf != null)
    {
      this.uYf.removeCallbacksAndMessages(null);
      this.uYf.getSerial().quit();
      this.uYf = null;
    }
    AppMethodBeat.o(114595);
  }
  
  public final class a
  {
    public int angle;
    public boolean fYC;
    public int h;
    public int mirror;
    public Bitmap sRG;
    public int uYi;
    public int[] uYj;
    public int w;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.k
 * JD-Core Version:    0.7.0.1
 */