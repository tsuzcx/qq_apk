package com.tencent.mm.plugin.multitalk.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.pb.talkroom.sdk.d;

public final class l
{
  boolean isStart;
  final Object tQH;
  f.a tQJ;
  c tQh;
  
  public l()
  {
    AppMethodBeat.i(114414);
    this.tQh = null;
    this.tQH = new Object();
    this.isStart = false;
    this.tQJ = new f.a();
    AppMethodBeat.o(114414);
  }
  
  public final int a(com.tencent.mm.plugin.voip.model.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114415);
    synchronized (this.tQH)
    {
      if (this.isStart)
      {
        Log.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(114415);
        return -1;
      }
      Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.tQh == null)
      {
        byte[] arrayOfByte = new byte[1];
        int i = af.juI.jpn;
        int j = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vPA, -1);
        Log.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_s = %d", new Object[] { Integer.valueOf(i) });
        Log.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_x = %d", new Object[] { Integer.valueOf(j) });
        this.tQh = new c();
        arrayOfByte[0] = 0;
        if ((i > 0) && (j > 0))
        {
          arrayOfByte[0] = 1;
          this.tQh.S(paramInt1, 2, paramInt2, 0);
          ad.eYb().Frw.setAppCmd(448, arrayOfByte, 1);
        }
      }
      else
      {
        this.tQh.K(MMApplicationContext.getContext(), false);
        this.tQh.NJt = paramb;
        if (ad.eYc().Fsp != null)
        {
          ad.eYc().Fsp.acR();
          ad.eYc().Fsp.Fmm = this.tQh;
        }
        Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "set start play");
        this.isStart = true;
        this.tQJ.jvB = SystemClock.elapsedRealtime();
        paramInt1 = this.tQh.gxB();
        Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlaying cost: " + this.tQJ.avE());
        Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(114415);
        return paramInt1;
      }
      this.tQh.S(paramInt1, 1, paramInt2, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.l
 * JD-Core Version:    0.7.0.1
 */