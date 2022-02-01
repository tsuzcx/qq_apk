package com.tencent.mm.plugin.setting.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ak;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/report/CareModeReport;", "", "()V", "reportCareModeSwitch", "", "enable", "", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Poq;
  
  static
  {
    AppMethodBeat.i(298507);
    Poq = new a();
    AppMethodBeat.o(298507);
  }
  
  public static final void CE(boolean paramBoolean)
  {
    AppMethodBeat.i(298501);
    ak localak = new ak();
    if (paramBoolean) {}
    for (long l = 1L;; l = 0L)
    {
      localak.ikE = l;
      localak.bMH();
      AppMethodBeat.o(298501);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.a.a
 * JD-Core Version:    0.7.0.1
 */