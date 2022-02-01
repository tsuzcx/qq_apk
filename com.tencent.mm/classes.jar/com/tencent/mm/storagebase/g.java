package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;

public final class g
  implements ISQLiteDatabase
{
  private static String adnE = "";
  public int field_MARK_CURSOR_CHECK_IGNORE;
  
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133389);
    "Not Attach Mem Storage:".concat(String.valueOf(paramString1));
    AppMethodBeat.o(133389);
    throw null;
  }
  
  public final boolean execSQL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133390);
    "Not Attach Mem Storage:".concat(String.valueOf(paramString1));
    AppMethodBeat.o(133390);
    throw null;
  }
  
  public final long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(133391);
    "Not Attach Mem Storage:".concat(String.valueOf(paramString1));
    AppMethodBeat.o(133391);
    throw null;
  }
  
  public final long insertOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return -2L;
  }
  
  public final boolean isClose()
  {
    AppMethodBeat.i(133387);
    AppMethodBeat.o(133387);
    throw null;
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(133394);
    AppMethodBeat.o(133394);
    throw null;
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(133395);
    AppMethodBeat.o(133395);
    throw null;
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    throw null;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133396);
    AppMethodBeat.o(133396);
    throw null;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(133397);
    AppMethodBeat.o(133397);
    throw null;
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(133392);
    "Not Attach Mem Storage:".concat(String.valueOf(paramString1));
    AppMethodBeat.o(133392);
    throw null;
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133393);
    "Not Attach Mem Storage:".concat(String.valueOf(paramString1));
    AppMethodBeat.o(133393);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.g
 * JD-Core Version:    0.7.0.1
 */