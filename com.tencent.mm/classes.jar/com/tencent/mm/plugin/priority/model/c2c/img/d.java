package com.tencent.mm.plugin.priority.model.c2c.img;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.model.b;
import com.tencent.mm.plugin.priority.model.c2c.a;
import com.tencent.mm.sdk.platformtools.Log;

public class d
  extends a
{
  public d(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(87865);
    Log.i("MicroMsg.Priority.C2CMsgImgUsageStorage", "Create ImgUsageStorage");
    AppMethodBeat.o(87865);
  }
  
  public final String getTableName()
  {
    return "C2CMsgImgUsage";
  }
  
  public final long gzR()
  {
    return 17L;
  }
  
  public final long gzS()
  {
    return 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.c2c.img.d
 * JD-Core Version:    0.7.0.1
 */