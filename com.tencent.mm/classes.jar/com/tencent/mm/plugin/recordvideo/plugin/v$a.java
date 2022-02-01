package com.tencent.mm.plugin.recordvideo.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(k=3, mv={1, 5, 1}, xi=48)
public final class v$a
{
  public static void a(v paramv, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280509);
    s.u(paramv, "this");
    s.u(paramRecordConfigProvider, "configProvider");
    AppMethodBeat.o(280509);
  }
  
  public static void a(v paramv, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280505);
    s.u(paramv, "this");
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(280505);
  }
  
  public static String b(v paramv)
  {
    AppMethodBeat.i(280502);
    s.u(paramv, "this");
    paramv = paramv.getClass().getName();
    AppMethodBeat.o(280502);
    return paramv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.v.a
 * JD-Core Version:    0.7.0.1
 */