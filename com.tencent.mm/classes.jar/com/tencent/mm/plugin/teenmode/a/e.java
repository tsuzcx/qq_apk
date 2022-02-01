package com.tencent.mm.plugin.teenmode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.teenmode.b.a.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class e
  extends a
{
  public static IAutoDBItem.MAutoDBInfo dbInfo;
  
  static
  {
    AppMethodBeat.i(278937);
    dbInfo = aJm();
    AppMethodBeat.o(278937);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return dbInfo;
  }
  
  public final boolean hEw()
  {
    return this.field_time > 0L;
  }
  
  public final boolean hEx()
  {
    AppMethodBeat.i(278957);
    boolean bool = ((d)h.ax(d.class)).aoj(this.field_businessType).aE(this.field_time, cn.bDu());
    AppMethodBeat.o(278957);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.a.e
 * JD-Core Version:    0.7.0.1
 */