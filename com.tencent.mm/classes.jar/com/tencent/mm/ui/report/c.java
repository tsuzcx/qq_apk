package com.tencent.mm.ui.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.qv;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/report/Report25041;", "", "()V", "REPORT_ACTION_TYPE_CONTINUE_PLAY_CONTINUE_PLAY", "", "REPORT_ACTION_TYPE_CONTINUE_PLAY_EXPOSE", "REPORT_ACTION_TYPE_CONTINUE_PLAY_REPLAY", "REPORT_SCENE_C2C", "", "REPORT_SCENE_GROUP", "REPORT_SCENE_OTHER", "REPORT_STOP_REASON_CLICK_PAUSE", "REPORT_STOP_REASON_INTERRUPT", "REPORT_STOP_REASON_SYSTEM", "TAG", "", "report", "", "isNormalChar", "", "isC2C", "actionType", "voiceId", "totalTime", "stopReason", "playTime", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c afBT;
  
  static
  {
    AppMethodBeat.i(249531);
    afBT = new c();
    AppMethodBeat.o(249531);
  }
  
  public static final void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(249523);
    s.u(paramString, "voiceId");
    Log.i("Report25041", "report() called with: isC2C = " + paramBoolean2 + ", actionType = " + paramLong1 + ", voiceId = " + paramString + ", totalTime = " + paramLong2 + ", stopReason = 0, playTime = " + paramLong3);
    qv localqv = new qv();
    long l;
    if (!paramBoolean1) {
      l = 0L;
    }
    for (;;)
    {
      localqv.iqr = l;
      localqv.ioV = paramLong1;
      localqv.iwX = localqv.F("ActionResult", "0", true);
      localqv.jtS = localqv.F("VoiceId", paramString, true);
      localqv.iPP = paramLong2;
      localqv.jtT = 0L;
      localqv.iLV = paramLong3;
      localqv.bMH();
      AppMethodBeat.o(249523);
      return;
      if (paramBoolean2) {
        l = 1L;
      } else {
        l = 2L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.report.c
 * JD-Core Version:    0.7.0.1
 */