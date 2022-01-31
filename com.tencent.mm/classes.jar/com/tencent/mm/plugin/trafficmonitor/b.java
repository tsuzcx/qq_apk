package com.tencent.mm.plugin.trafficmonitor;

import java.util.Timer;
import java.util.TimerTask;

public final class b
  extends c
{
  public final String TAG = "MicroMsg.FileTrafficStatsInspector";
  private Timer bzx = null;
  private TimerTask pJS = null;
  private boolean started;
  
  public final void bOQ()
  {
    if (this.started) {
      return;
    }
    this.currentIndex = 0;
    a.init(this.id);
    a.reset(this.id);
    a.update(this.id);
    this.pJS = new b.1(this);
    this.bzx = new Timer();
    this.bzx.schedule(this.pJS, 0L, this.dFf);
    this.started = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.b
 * JD-Core Version:    0.7.0.1
 */