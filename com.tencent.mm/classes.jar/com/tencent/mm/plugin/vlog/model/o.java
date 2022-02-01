package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/TAVKitLog;", "", "()V", "TAG", "", "setUp", "", "plugin-vlog_release"})
public final class o
{
  public static final o AnM;
  private static final String TAG = "MicroMsg.TAVKit";
  
  static
  {
    AppMethodBeat.i(207560);
    AnM = new o();
    TAG = "MicroMsg.TAVKit";
    AppMethodBeat.o(207560);
  }
  
  public static void cZj()
  {
    AppMethodBeat.i(207559);
    Logger.setLogger((ILog)new o.a());
    AppMethodBeat.o(207559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.o
 * JD-Core Version:    0.7.0.1
 */