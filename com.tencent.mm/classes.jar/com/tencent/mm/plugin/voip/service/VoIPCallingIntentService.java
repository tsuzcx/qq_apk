package com.tencent.mm.plugin.voip.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/service/VoIPCallingIntentService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "plugin-voip_release"})
public final class VoIPCallingIntentService
  extends Service
{
  public final IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(293195);
    p.k(paramIntent, "intent");
    AppMethodBeat.o(293195);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.service.VoIPCallingIntentService
 * JD-Core Version:    0.7.0.1
 */