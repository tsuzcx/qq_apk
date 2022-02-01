package com.tencent.mm.plugin.ringtone.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/params/RingtoneConstant$StateService;", "", "(Ljava/lang/String;I)V", "PREPARE", "PLAY", "PAUSE", "NOT_INIT", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b$c
{
  static
  {
    AppMethodBeat.i(272844);
    ODi = new c("PREPARE", 0);
    ODj = new c("PLAY", 1);
    ODk = new c("PAUSE", 2);
    ODl = new c("NOT_INIT", 3);
    ODm = new c[] { ODi, ODj, ODk, ODl };
    AppMethodBeat.o(272844);
  }
  
  private b$c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.g.b.c
 * JD-Core Version:    0.7.0.1
 */