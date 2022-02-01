package com.tencent.mm.plugin.sns.statistics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
public final class h$a$b
  extends u
  implements a<Object>
{
  public h$a$b(String paramString)
  {
    super(0);
  }
  
  public final Object invoke()
  {
    AppMethodBeat.i(306501);
    String str = g.getMD5(this.obz);
    s.s(str, "getMD5(videoPath)");
    AppMethodBeat.o(306501);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.statistics.h.a.b
 * JD-Core Version:    0.7.0.1
 */