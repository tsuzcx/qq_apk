package com.tencent.mm.plugin.priority.model.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.a.a;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  extends a
{
  public d(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(87865);
    ae.i("MicroMsg.Priority.C2CMsgImgUsageStorage", "Create ImgUsageStorage");
    AppMethodBeat.o(87865);
  }
  
  public final long dCD()
  {
    return 17L;
  }
  
  public final String getTableName()
  {
    return "C2CMsgImgUsage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.c.d
 * JD-Core Version:    0.7.0.1
 */