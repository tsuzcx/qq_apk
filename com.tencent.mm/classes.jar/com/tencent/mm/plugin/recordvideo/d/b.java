package com.tencent.mm.plugin.recordvideo.d;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil;", "", "()V", "TAG", "", "checkConfigProviderParam", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "plugin-recordvideo_release"})
public final class b
{
  public static final b qfA;
  
  static
  {
    AppMethodBeat.i(155507);
    qfA = new b();
    AppMethodBeat.o(155507);
  }
  
  public static void e(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(155506);
    j.q(paramRecordConfigProvider, "configProvider");
    if (paramRecordConfigProvider.qbq == null) {
      switch (paramRecordConfigProvider.scene)
      {
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.MediaRecordParamUtil", "checkConfigProviderParam " + paramRecordConfigProvider.qbq);
      AppMethodBeat.o(155506);
      return;
      d locald = d.afW();
      j.p(locald, "SubCoreVideoControl.getCore()");
      paramRecordConfigProvider.qbq = locald.afZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.b
 * JD-Core Version:    0.7.0.1
 */