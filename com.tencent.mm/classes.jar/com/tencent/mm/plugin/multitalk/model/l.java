package com.tencent.mm.plugin.multitalk.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.pb.talkroom.sdk.d;

public final class l
{
  boolean isStart;
  final Object wTX;
  f.a wTZ;
  com.tencent.mm.plugin.voip.model.c wTy;
  
  public l()
  {
    AppMethodBeat.i(114414);
    this.wTy = null;
    this.wTX = new Object();
    this.isStart = false;
    this.wTZ = new f.a();
    AppMethodBeat.o(114414);
  }
  
  public final int a(com.tencent.mm.plugin.voip.model.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114415);
    synchronized (this.wTX)
    {
      if (this.isStart)
      {
        Log.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(114415);
        return -1;
      }
      Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.wTy == null)
      {
        byte[] arrayOfByte = new byte[1];
        int i = af.lXZ.lSv;
        int j = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zif, -1);
        Log.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_s = %d", new Object[] { Integer.valueOf(i) });
        Log.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_x = %d", new Object[] { Integer.valueOf(j) });
        this.wTy = new com.tencent.mm.plugin.voip.model.c();
        arrayOfByte[0] = 0;
        if ((i > 0) && (j > 0))
        {
          arrayOfByte[0] = 1;
          this.wTy.ac(paramInt1, 2, paramInt2, 0);
          ac.ggR().LnJ.setAppCmd(448, arrayOfByte, 1);
        }
      }
      else
      {
        this.wTy.R(MMApplicationContext.getContext(), false);
        this.wTy.UvX = paramb;
        if (ac.ggS().LoD != null)
        {
          ac.ggS().LoD.aER();
          ac.ggS().LoD.Lir = this.wTy;
        }
        Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "set start play");
        this.isStart = true;
        this.wTZ.lYS = SystemClock.elapsedRealtime();
        paramInt1 = this.wTy.hVD();
        Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlaying cost: " + this.wTZ.aPY());
        Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(114415);
        return paramInt1;
      }
      this.wTy.ac(paramInt1, 1, paramInt2, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.l
 * JD-Core Version:    0.7.0.1
 */