package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.m;
import java.util.regex.Pattern;

final class f$a$a
  implements m
{
  public final boolean accept(k paramk)
  {
    AppMethodBeat.i(176169);
    if (Pattern.matches("cpu[0-9]", paramk.getName()))
    {
      AppMethodBeat.o(176169);
      return true;
    }
    AppMethodBeat.o(176169);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.f.a.a
 * JD-Core Version:    0.7.0.1
 */