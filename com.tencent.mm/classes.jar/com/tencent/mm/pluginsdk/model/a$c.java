package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/pluginsdk/model/BizImageBlankReporter$ImageLoadCountInfo;", "", "()V", "fromFileCount", "", "getFromFileCount", "()I", "setFromFileCount", "(I)V", "fromMemoryCount", "getFromMemoryCount", "setFromMemoryCount", "fromNetCount", "getFromNetCount", "setFromNetCount", "totalCount", "getTotalCount", "setTotalCount", "reset", "", "toString", "", "plugin-biz_release"})
public final class a$c
{
  int BOr;
  int BOs;
  int BOt;
  int fwP;
  
  public final String toString()
  {
    AppMethodBeat.i(124801);
    Object localObject = z.Jhz;
    localObject = String.format("totalCount: %d, fromNetCount: %d, fromFileCount: %d, fromMemoryCount: %d", Arrays.copyOf(new Object[] { Integer.valueOf(this.fwP), Integer.valueOf(this.BOr), Integer.valueOf(this.BOs), Integer.valueOf(this.BOt) }, 4));
    k.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(124801);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.a.c
 * JD-Core Version:    0.7.0.1
 */