package com.tencent.mm.plugin.music.d;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.v;
import com.tencent.mm.av.e;
import com.tencent.mm.h.a.jy;
import com.tencent.mm.h.a.jy.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;

public final class a$c
  implements a.b
{
  public a$c(a parama) {}
  
  public final void bmQ()
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
    if (this.myP.myB != null) {
      this.myP.z(this.myP.myB);
    }
    if (this.myP.startTime > 0)
    {
      y.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", new Object[] { Integer.valueOf(this.myP.startTime) });
      this.myP.iV(this.myP.startTime);
    }
    if ((this.myP.startTime == 0) && (!this.myP.myE.kE()))
    {
      y.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
      this.myP.myE.at(true);
    }
  }
  
  public final void bmR()
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
    if (this.myP.myB != null) {
      this.myP.A(this.myP.myB);
    }
  }
  
  public final void bmS()
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
    if ((this.myP.myB != null) && (!this.myP.myE.kE())) {
      this.myP.C(this.myP.myB);
    }
  }
  
  public final void bmT()
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
    if (this.myP.myB != null) {
      this.myP.D(this.myP.myB);
    }
  }
  
  public final void bmU()
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
    if (this.myP.myB != null) {
      this.myP.E(this.myP.myB);
    }
    if ((this.myP.startTime > 0) && (this.myP.myE != null) && (!this.myP.myE.kE()))
    {
      y.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete, stay play hls");
      this.myP.startTime = 0;
      this.myP.myE.at(true);
    }
  }
  
  public final void bmV()
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
    if (this.myP.myB != null) {
      this.myP.G(this.myP.myB);
    }
    this.myP.mxr = false;
    this.myP.gmh.removeMessages(100);
  }
  
  public final void dq(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject2;
    Object localObject3;
    Object localObject1;
    int i;
    if (this.myP.myB != null)
    {
      localObject2 = this.myP;
      localObject3 = this.myP.myB;
      y.i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      ((a)localObject2).mAt = "error";
      localObject1 = new jy();
      ((jy)localObject1).bSA.action = 4;
      ((jy)localObject1).bSA.bSu = ((e)localObject3);
      ((jy)localObject1).bSA.state = "error";
      ((jy)localObject1).bSA.duration = ((a)localObject2).getDuration();
      ((jy)localObject1).bSA.bSC = true;
      localObject2 = ((jy)localObject1).bSA;
      y.i("MicroMsg.Music.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", new Object[] { Integer.valueOf(paramInt1) });
      switch (paramInt1)
      {
      default: 
        i = 0;
        ((jy.a)localObject2).errCode = i;
        localObject2 = ((jy)localObject1).bSA;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("errCode:" + paramInt2 + ", err:");
        switch (paramInt2)
        {
        }
        break;
      }
    }
    for (;;)
    {
      ((jy.a)localObject2).aox = ((StringBuilder)localObject3).toString();
      com.tencent.mm.sdk.b.a.udP.a((b)localObject1, Looper.getMainLooper());
      if (this.myP.myE != null)
      {
        this.myP.myE.at(false);
        this.myP.myE.stop();
      }
      this.myP.mxr = false;
      this.myP.gmh.removeMessages(100);
      localObject1 = this.myP;
      ((a)localObject1).aRY += 1;
      if (this.myP.aRY == 1) {
        this.myP.a(this.myP.myB, paramInt1, paramInt2);
      }
      return;
      i = 10002;
      break;
      i = 10004;
      break;
      i = 10001;
      break;
      i = -1;
      break;
      ((StringBuilder)localObject3).append(" no network");
      continue;
      ((StringBuilder)localObject3).append("connect fail");
      continue;
      ((StringBuilder)localObject3).append(" network respCode 403");
      continue;
      ((StringBuilder)localObject3).append(" network respCode 404");
      continue;
      ((StringBuilder)localObject3).append(" network respCode 500");
      continue;
      ((StringBuilder)localObject3).append(" network respCode 502");
      continue;
      ((StringBuilder)localObject3).append(" network error");
      continue;
      ((StringBuilder)localObject3).append("UnrecognizedInputFormatException");
      continue;
      ((StringBuilder)localObject3).append("illegal state exception");
      continue;
      ((StringBuilder)localObject3).append("MediaCodec decoder init exception");
      continue;
      ((StringBuilder)localObject3).append("load error");
      continue;
      ((StringBuilder)localObject3).append("prepare error");
      continue;
      ((StringBuilder)localObject3).append("stop error");
      continue;
      ((StringBuilder)localObject3).append("error url format");
      continue;
      ((StringBuilder)localObject3).append("unknow exception");
    }
  }
  
  public final void uI(int paramInt)
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a.c
 * JD-Core Version:    0.7.0.1
 */