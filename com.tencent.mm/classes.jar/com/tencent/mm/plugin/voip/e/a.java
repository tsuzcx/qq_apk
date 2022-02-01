package com.tencent.mm.plugin.voip.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/status/IVoIPWidgetEvent;", "", "statusChange", "", "status", "Lcom/tencent/mm/plugin/voip/status/IVoIPWidgetEvent$VoIPWidgetStatus;", "param", "Landroid/os/Bundle;", "Companion", "VoIPWidgetStatus", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public static final a UHF = a.UHG;
  
  public abstract void a(a.c paramc, Bundle paramBundle);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/status/IVoIPWidgetEvent$Companion;", "", "()V", "PARAMS_MUTE_STATE", "", "PARAMS_SPEAKER_STATE", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(292219);
      UHG = new a();
      AppMethodBeat.o(292219);
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.e.a
 * JD-Core Version:    0.7.0.1
 */