package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bn;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class d
  extends bn
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(105049);
    info = bn.aJm();
    AppMethodBeat.o(105049);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return null;
  }
  
  public final String getMd5()
  {
    if (this.field_md5 == null) {
      return "";
    }
    return this.field_md5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.d
 * JD-Core Version:    0.7.0.1
 */