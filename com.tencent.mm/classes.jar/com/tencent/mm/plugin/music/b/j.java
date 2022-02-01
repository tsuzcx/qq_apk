package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import com.tencent.mm.autogen.a.ac;
import com.tencent.mm.aw.c;
import com.tencent.mm.plugin.music.e.a.d;
import com.tencent.mm.plugin.music.e.a.d.a;
import com.tencent.mm.plugin.music.e.a.e;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class j
  implements k, d
{
  protected f LJo = null;
  protected boolean LJy;
  protected d.a LJz;
  
  public final void a(f paramf)
  {
    this.LJo = paramf;
  }
  
  public final void adb(int paramInt)
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    ac localac = new ac();
    localac.hzX.action = 4;
    localac.hzX.state = "error";
    localac.hzX.errCode = e.adK(paramInt);
    localac.hzX.errMsg = e.Cl(paramInt);
    localac.hzX.hqQ = gmk();
    localac.hzX.appId = getAppId();
    localac.asyncPublish(Looper.getMainLooper());
    if (this.LJo != null) {
      this.LJo.onError(gmk());
    }
  }
  
  public final boolean bLl()
  {
    return false;
  }
  
  public abstract String getAppId();
  
  public final void gmh() {}
  
  public boolean gmi()
  {
    return false;
  }
  
  public final c gmj()
  {
    return null;
  }
  
  public abstract String gmk();
  
  public final void gml()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent");
    ac localac = new ac();
    localac.hzX.action = 7;
    localac.hzX.state = "canplay";
    localac.hzX.duration = getDuration();
    localac.hzX.hqQ = gmk();
    localac.hzX.appId = getAppId();
    localac.asyncPublish(Looper.getMainLooper());
  }
  
  public final void gmm()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(bLk()) });
    ac localac = new ac();
    localac.hzX.action = 0;
    localac.hzX.state = "play";
    localac.hzX.hqQ = gmk();
    localac.hzX.appId = getAppId();
    localac.asyncPublish(Looper.getMainLooper());
    if (this.LJo != null) {
      this.LJo.aNZ(gmk());
    }
  }
  
  public final void gmn()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
    ac localac = new ac();
    localac.hzX.action = 1;
    localac.hzX.state = "play";
    localac.hzX.hqQ = gmk();
    localac.hzX.appId = getAppId();
    localac.asyncPublish(Looper.getMainLooper());
    if (this.LJo != null) {
      this.LJo.aNZ(gmk());
    }
  }
  
  public final void gmo()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
    ac localac = new ac();
    localac.hzX.action = 2;
    localac.hzX.state = "pause";
    localac.hzX.hqQ = gmk();
    localac.hzX.appId = getAppId();
    localac.asyncPublish(Looper.getMainLooper());
    if (this.LJo != null) {
      this.LJo.aOa(gmk());
    }
  }
  
  public final void gmp()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    ac localac = new ac();
    localac.hzX.action = 3;
    localac.hzX.state = "stop";
    localac.hzX.hqQ = gmk();
    localac.hzX.appId = getAppId();
    localac.asyncPublish(Looper.getMainLooper());
    if (this.LJo != null) {
      this.LJo.atL(gmk());
    }
  }
  
  public final void gmq()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
    ac localac = new ac();
    localac.hzX.action = 6;
    localac.hzX.state = "seeked";
    localac.hzX.hqQ = gmk();
    localac.hzX.appId = getAppId();
    localac.asyncPublish(Looper.getMainLooper());
  }
  
  public final void gmr()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onCompleteEvent");
    ac localac = new ac();
    localac.hzX.action = 5;
    localac.hzX.state = "ended";
    localac.hzX.hqQ = gmk();
    localac.hzX.appId = getAppId();
    localac.asyncPublish(Looper.getMainLooper());
    if (this.LJo != null) {
      this.LJo.jm(gmk());
    }
  }
  
  public final void gms()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
    adb(-1);
  }
  
  public final void onPhoneCall(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (!this.LJy);
      this.LJy = false;
      resume();
      return;
    } while (!bLk());
    this.LJy = true;
    pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.j
 * JD-Core Version:    0.7.0.1
 */