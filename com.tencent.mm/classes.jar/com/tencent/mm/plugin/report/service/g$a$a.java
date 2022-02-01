package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.g;
import java.util.regex.Pattern;

final class g$a$a
  implements g
{
  public final boolean accept(e parame)
  {
    AppMethodBeat.i(176169);
    if (Pattern.matches("cpu[0-9]", parame.getName()))
    {
      AppMethodBeat.o(176169);
      return true;
    }
    AppMethodBeat.o(176169);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.g.a.a
 * JD-Core Version:    0.7.0.1
 */