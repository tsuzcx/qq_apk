package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.il;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class ad
  extends il
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(70432);
    info = aJm();
    AppMethodBeat.o(70432);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(70431);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(70431);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ad
 * JD-Core Version:    0.7.0.1
 */