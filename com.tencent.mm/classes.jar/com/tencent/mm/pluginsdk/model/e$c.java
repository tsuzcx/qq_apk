package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "", "()V", "fromFileCount", "", "getFromFileCount", "()I", "setFromFileCount", "(I)V", "fromMemoryCount", "getFromMemoryCount", "setFromMemoryCount", "fromNetCount", "getFromNetCount", "setFromNetCount", "totalCount", "getTotalCount", "setTotalCount", "reset", "", "toString", "", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$c
{
  int XQJ;
  int XQK;
  int XQL;
  int lNX;
  
  public final String toString()
  {
    AppMethodBeat.i(124801);
    Object localObject = am.aixg;
    localObject = String.format("totalCount: %d, fromNetCount: %d, fromFileCount: %d, fromMemoryCount: %d", Arrays.copyOf(new Object[] { Integer.valueOf(this.lNX), Integer.valueOf(this.XQJ), Integer.valueOf(this.XQK), Integer.valueOf(this.XQL) }, 4));
    s.s(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(124801);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.e.c
 * JD-Core Version:    0.7.0.1
 */