package com.tencent.mm.storagebase;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storagebase.a.a;
import com.tencent.mm.storagebase.a.f.a;
import java.util.HashMap;

public final class d
  implements Cursor, com.tencent.mm.storagebase.a.d
{
  private static Cursor IOC;
  
  public static Cursor ftG()
  {
    AppMethodBeat.i(133330);
    if (IOC == null) {
      IOC = new d();
    }
    Cursor localCursor = IOC;
    AppMethodBeat.o(133330);
    return localCursor;
  }
  
  public final void a(f.a parama) {}
  
  public final boolean a(Object paramObject, a parama)
  {
    return false;
  }
  
  public final boolean abi(int paramInt)
  {
    return false;
  }
  
  public final a abj(int paramInt)
  {
    return null;
  }
  
  public final void abk(int paramInt) {}
  
  public final void close() {}
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final boolean dX(Object paramObject)
  {
    return false;
  }
  
  public final a dY(Object paramObject)
  {
    return null;
  }
  
  public final void deactivate() {}
  
  public final SparseArray[] ftH()
  {
    return null;
  }
  
  public final HashMap ftI()
  {
    return null;
  }
  
  public final boolean ftJ()
  {
    return false;
  }
  
  public final byte[] getBlob(int paramInt)
  {
    return null;
  }
  
  public final int getColumnCount()
  {
    return 0;
  }
  
  public final int getColumnIndex(String paramString)
  {
    return 0;
  }
  
  public final int getColumnIndexOrThrow(String paramString)
  {
    return 0;
  }
  
  public final String getColumnName(int paramInt)
  {
    return null;
  }
  
  public final String[] getColumnNames()
  {
    return null;
  }
  
  public final int getCount()
  {
    return 0;
  }
  
  public final double getDouble(int paramInt)
  {
    return 0.0D;
  }
  
  public final Bundle getExtras()
  {
    return null;
  }
  
  public final float getFloat(int paramInt)
  {
    return 0.0F;
  }
  
  public final int getInt(int paramInt)
  {
    return 0;
  }
  
  public final long getLong(int paramInt)
  {
    return 0L;
  }
  
  public final Uri getNotificationUri()
  {
    return null;
  }
  
  public final int getPosition()
  {
    return 0;
  }
  
  public final short getShort(int paramInt)
  {
    return 0;
  }
  
  public final String getString(int paramInt)
  {
    return null;
  }
  
  public final int getType(int paramInt)
  {
    return 0;
  }
  
  public final boolean getWantsAllOnMoveCalls()
  {
    return false;
  }
  
  public final boolean isAfterLast()
  {
    return true;
  }
  
  public final boolean isBeforeFirst()
  {
    return false;
  }
  
  public final boolean isClosed()
  {
    return false;
  }
  
  public final boolean isFirst()
  {
    return false;
  }
  
  public final boolean isLast()
  {
    return false;
  }
  
  public final boolean isNull(int paramInt)
  {
    return false;
  }
  
  public final boolean move(int paramInt)
  {
    return false;
  }
  
  public final boolean moveToFirst()
  {
    return false;
  }
  
  public final boolean moveToLast()
  {
    return false;
  }
  
  public final boolean moveToNext()
  {
    return false;
  }
  
  public final boolean moveToPosition(int paramInt)
  {
    return false;
  }
  
  public final boolean moveToPrevious()
  {
    return false;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public final boolean requery()
  {
    return false;
  }
  
  public final Bundle respond(Bundle paramBundle)
  {
    return null;
  }
  
  public final void setExtras(Bundle paramBundle) {}
  
  public final void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri) {}
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public final void wS(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.d
 * JD-Core Version:    0.7.0.1
 */