package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.d;
import com.tencent.mm.model.newabtest.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.Serializable;
import java.util.Map;

public final class c
  extends d
  implements Serializable
{
  protected static IAutoDBItem.MAutoDBInfo info;
  private Map<String, String> acDD = null;
  
  static
  {
    AppMethodBeat.i(153160);
    info = d.aJm();
    AppMethodBeat.o(153160);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final Map<String, String> iWZ()
  {
    AppMethodBeat.i(153159);
    if (this.acDD == null) {
      this.acDD = a.Kz(this.field_rawXML);
    }
    Map localMap = this.acDD;
    AppMethodBeat.o(153159);
    return localMap;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(153158);
    long l = Util.nowSecond();
    if ((l >= this.field_startTime) && (l <= this.field_endTime))
    {
      AppMethodBeat.o(153158);
      return true;
    }
    AppMethodBeat.o(153158);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.c
 * JD-Core Version:    0.7.0.1
 */