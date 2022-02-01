package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hp;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class ag
  extends hp
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(306528);
    info = hp.aJm();
    AppMethodBeat.o(306528);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.ag
 * JD-Core Version:    0.7.0.1
 */