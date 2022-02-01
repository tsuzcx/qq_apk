package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import com.tencent.mm.ay.c;
import com.tencent.mm.g.a.y;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class i
  implements j, d
{
  protected boolean AhH;
  protected d.a AhI;
  protected e Ahw = null;
  
  public final void St(int paramInt)
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    y localy = new y();
    localy.dCW.action = 4;
    localy.dCW.state = "error";
    localy.dCW.errCode = com.tencent.mm.plugin.music.f.a.e.Tc(paramInt);
    localy.dCW.errMsg = com.tencent.mm.plugin.music.f.a.e.yw(paramInt);
    localy.dCW.dtX = esX();
    localy.dCW.appId = getAppId();
    EventCenter.instance.asyncPublish(localy, Looper.getMainLooper());
    if (this.Ahw != null) {
      this.Ahw.onError(esX());
    }
  }
  
  public final void a(e parame)
  {
    this.Ahw = parame;
  }
  
  public final void a(d.a parama)
  {
    this.AhI = parama;
  }
  
  public final boolean bed()
  {
    return false;
  }
  
  public final void esU() {}
  
  public boolean esV()
  {
    return false;
  }
  
  public final c esW()
  {
    return null;
  }
  
  public abstract String esX();
  
  public final void esY()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent");
    y localy = new y();
    localy.dCW.action = 7;
    localy.dCW.state = "canplay";
    localy.dCW.duration = getDuration();
    localy.dCW.dtX = esX();
    localy.dCW.appId = getAppId();
    EventCenter.instance.asyncPublish(localy, Looper.getMainLooper());
  }
  
  public final void esZ()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(bec()) });
    y localy = new y();
    localy.dCW.action = 0;
    localy.dCW.state = "play";
    localy.dCW.dtX = esX();
    localy.dCW.appId = getAppId();
    EventCenter.instance.asyncPublish(localy, Looper.getMainLooper());
    if (this.Ahw != null) {
      this.Ahw.onStart(esX());
    }
  }
  
  public final void eta()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
    y localy = new y();
    localy.dCW.action = 1;
    localy.dCW.state = "play";
    localy.dCW.dtX = esX();
    localy.dCW.appId = getAppId();
    EventCenter.instance.asyncPublish(localy, Looper.getMainLooper());
    if (this.Ahw != null) {
      this.Ahw.onStart(esX());
    }
  }
  
  public final void etb()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
    y localy = new y();
    localy.dCW.action = 2;
    localy.dCW.state = "pause";
    localy.dCW.dtX = esX();
    localy.dCW.appId = getAppId();
    EventCenter.instance.asyncPublish(localy, Looper.getMainLooper());
    if (this.Ahw != null) {
      this.Ahw.aGS(esX());
    }
  }
  
  public final void etc()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    y localy = new y();
    localy.dCW.action = 3;
    localy.dCW.state = "stop";
    localy.dCW.dtX = esX();
    localy.dCW.appId = getAppId();
    EventCenter.instance.asyncPublish(localy, Looper.getMainLooper());
    if (this.Ahw != null) {
      this.Ahw.arD(esX());
    }
  }
  
  public final void etd()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
    y localy = new y();
    localy.dCW.action = 6;
    localy.dCW.state = "seeked";
    localy.dCW.dtX = esX();
    localy.dCW.appId = getAppId();
    EventCenter.instance.asyncPublish(localy, Looper.getMainLooper());
  }
  
  public final void ete()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onCompleteEvent");
    y localy = new y();
    localy.dCW.action = 5;
    localy.dCW.state = "ended";
    localy.dCW.dtX = esX();
    localy.dCW.appId = getAppId();
    EventCenter.instance.asyncPublish(localy, Looper.getMainLooper());
    if (this.Ahw != null) {
      this.Ahw.gY(esX());
    }
  }
  
  public final void etf()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
    St(-1);
  }
  
  public abstract String getAppId();
  
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
      } while (!this.AhH);
      this.AhH = false;
      resume();
      return;
    } while (!bec());
    this.AhH = true;
    pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.i
 * JD-Core Version:    0.7.0.1
 */