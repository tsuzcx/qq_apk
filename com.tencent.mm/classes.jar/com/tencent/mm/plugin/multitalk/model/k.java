package com.tencent.mm.plugin.multitalk.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak;

public final class k
{
  b oTC;
  public ak oUj;
  public k.a oUk;
  
  public k(b paramb)
  {
    AppMethodBeat.i(54062);
    this.oUk = new k.a(this, (byte)0);
    this.oTC = paramb;
    AppMethodBeat.o(54062);
  }
  
  public final void start()
  {
    AppMethodBeat.i(54063);
    d.a(new k.1(this), "MultiTalkVideoTaskManager_native_drawer_handler", 1).start();
    AppMethodBeat.o(54063);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(54064);
    this.oTC = null;
    this.oUk.ezJ = false;
    this.oUk.oUo = null;
    if (this.oUj != null)
    {
      this.oUj.removeCallbacksAndMessages(null);
      this.oUj.getLooper().quit();
      this.oUj = null;
    }
    AppMethodBeat.o(54064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.k
 * JD-Core Version:    0.7.0.1
 */