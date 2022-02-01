package com.tencent.mm.sensitive.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.pk;
import com.tencent.mm.autogen.mmdata.rpt.qi;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sensitive.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/report/SettingPermissionReporter;", "", "()V", "report", "", "action", "", "reportDialogAction", "privacyType", "bizType", "fullStatus", "", "(JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b acvJ;
  
  static
  {
    AppMethodBeat.i(240996);
    acvJ = new b();
    AppMethodBeat.o(240996);
  }
  
  public static void a(long paramLong, Long paramLong1, Long paramLong2, Boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(240984);
    pk localpk = new pk();
    localpk.ikE = paramLong;
    if ((paramLong1 != null) && (paramLong1.equals(Long.valueOf(-1L)) == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localpk.jlU = paramLong1.longValue();
      }
      i = j;
      if (paramLong2 != null)
      {
        i = j;
        if (paramLong2.equals(Long.valueOf(-1L)) == true) {
          i = 1;
        }
      }
      if (i != 0) {
        localpk.jlV = paramLong2.longValue();
      }
      localpk.jlW = localpk.F("DeviceID", q.getAndroidId(), true);
      if (s.p(paramBoolean, Boolean.TRUE)) {
        localpk.jlX = localpk.F("CurrentPrivacyFullStatus", ((d)h.az(d.class)).dumpSwitchStatus(), true);
      }
      localpk.bMH();
      AppMethodBeat.o(240984);
      return;
    }
  }
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(240976);
    qi localqi = new qi();
    localqi.ikE = paramLong;
    localqi.jlW = localqi.F("DeviceID", q.getAndroidId(), true);
    localqi.jlX = localqi.F("CurrentPrivacyFullStatus", ((d)h.az(d.class)).dumpSwitchStatus(), true);
    localqi.bMH();
    AppMethodBeat.o(240976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sensitive.d.b
 * JD-Core Version:    0.7.0.1
 */