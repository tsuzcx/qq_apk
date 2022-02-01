package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bp;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class h
  extends bp
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(105105);
    info = aJm();
    AppMethodBeat.o(105105);
  }
  
  public h() {}
  
  public h(String paramString1, String paramString2)
  {
    this.field_groupID = paramString1;
    this.field_desc = paramString2;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.h
 * JD-Core Version:    0.7.0.1
 */