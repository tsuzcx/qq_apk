package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.dv;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class r
  extends dv
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(105127);
    info = dv.aJm();
    AppMethodBeat.o(105127);
  }
  
  public r(Cursor paramCursor)
  {
    AppMethodBeat.i(105126);
    if (paramCursor == null)
    {
      AppMethodBeat.o(105126);
      return;
    }
    convertFrom(paramCursor);
    AppMethodBeat.o(105126);
  }
  
  public r(String paramString, byte[] paramArrayOfByte)
  {
    this.field_reqType = paramString;
    this.field_cache = paramArrayOfByte;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.r
 * JD-Core Version:    0.7.0.1
 */