package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.threadpool.i.d;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public final class f
  extends a
{
  private static boolean TSl;
  TimerTask TSj = null;
  c TSk;
  d<?> pen = null;
  boolean started;
  
  static
  {
    AppMethodBeat.i(260754);
    TSl = false;
    com.tencent.mm.plugin.ball.service.c.cYC().a(0, new f.1());
    AppMethodBeat.o(260754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.f
 * JD-Core Version:    0.7.0.1
 */