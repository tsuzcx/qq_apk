package com.tencent.mm.plugin.multitalk.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.pb.talkroom.sdk.d;

public final class l
{
  boolean isStart;
  final Object qrY;
  c qrz;
  f.a qsa;
  
  public l()
  {
    AppMethodBeat.i(114414);
    this.qrz = null;
    this.qrY = new Object();
    this.isStart = false;
    this.qsa = new f.a();
    AppMethodBeat.o(114414);
  }
  
  public final int a(com.tencent.mm.plugin.voip.model.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114415);
    synchronized (this.qrY)
    {
      if (this.isStart)
      {
        Log.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(114415);
        return -1;
      }
      Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.qrz == null)
      {
        byte[] arrayOfByte = new byte[1];
        int i = ae.gKu.gFd;
        int j = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sfK, -1);
        Log.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_s = %d", new Object[] { Integer.valueOf(i) });
        Log.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_x = %d", new Object[] { Integer.valueOf(j) });
        this.qrz = new c();
        arrayOfByte[0] = 0;
        if ((i > 0) && (j > 0))
        {
          arrayOfByte[0] = 1;
          this.qrz.N(paramInt1, 2, paramInt2, 0);
          ac.eol().zMd.setAppCmd(448, arrayOfByte, 1);
        }
      }
      else
      {
        this.qrz.F(MMApplicationContext.getContext(), false);
        this.qrz.GTi = paramb;
        if (ac.eom().zMV != null)
        {
          ac.eom().zMV.Yl();
          ac.eom().zMV.zHb = this.qrz;
        }
        Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "set start play");
        this.isStart = true;
        this.qsa.gLm = SystemClock.elapsedRealtime();
        paramInt1 = this.qrz.fFp();
        Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlaying cost: " + this.qsa.apr());
        Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(114415);
        return paramInt1;
      }
      this.qrz.N(paramInt1, 1, paramInt2, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.l
 * JD-Core Version:    0.7.0.1
 */