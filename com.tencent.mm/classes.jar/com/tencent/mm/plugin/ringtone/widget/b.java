package com.tencent.mm.plugin.ringtone.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/widget/RingtoneControlEvent;", "", "statusChange", "", "status", "Lcom/tencent/mm/plugin/ringtone/widget/RingtoneControlEvent$ControlEvent;", "param", "Landroid/os/Bundle;", "ControlEvent", "SwitchRingtoneTip", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public abstract void a(a parama);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/widget/RingtoneControlEvent$ControlEvent;", "", "(Ljava/lang/String;I)V", "PLAY", "SWITCH", "MORE", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(273119);
      OGc = new a("PLAY", 0);
      OGd = new a("SWITCH", 1);
      OGe = new a("MORE", 2);
      OGf = new a[] { OGc, OGd, OGe };
      AppMethodBeat.o(273119);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.widget.b
 * JD-Core Version:    0.7.0.1
 */