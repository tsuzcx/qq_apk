package com.tencent.mm.plugin.ringtone.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/params/RingtoneConstant$Action;", "", "(Ljava/lang/String;I)V", "PAUSE_ACTION", "PLAY_ACTION", "START_ACTION", "RESOURCE_LOAD_ACTION", "STOP_ACTION", "REPLACE_ACTION", "CONTINUE_ACTION", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b$a
{
  static
  {
    AppMethodBeat.i(272853);
    OCZ = new a("PAUSE_ACTION", 0);
    ODa = new a("PLAY_ACTION", 1);
    ODb = new a("START_ACTION", 2);
    ODc = new a("RESOURCE_LOAD_ACTION", 3);
    ODd = new a("STOP_ACTION", 4);
    ODe = new a("REPLACE_ACTION", 5);
    ODf = new a("CONTINUE_ACTION", 6);
    ODg = new a[] { OCZ, ODa, ODb, ODc, ODd, ODe, ODf };
    AppMethodBeat.o(272853);
  }
  
  private b$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.g.b.a
 * JD-Core Version:    0.7.0.1
 */