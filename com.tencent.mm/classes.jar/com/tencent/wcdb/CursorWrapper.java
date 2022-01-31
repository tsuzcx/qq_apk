package com.tencent.wcdb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CursorWrapper
  implements Cursor
{
  protected final Cursor mCursor;
  
  public CursorWrapper(Cursor paramCursor)
  {
    this.mCursor = paramCursor;
  }
  
  public void close()
  {
    AppMethodBeat.i(12057);
    this.mCursor.close();
    AppMethodBeat.o(12057);
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    AppMethodBeat.i(12074);
    this.mCursor.copyStringToBuffer(paramInt, paramCharArrayBuffer);
    AppMethodBeat.o(12074);
  }
  
  public void deactivate()
  {
    AppMethodBeat.i(12060);
    this.mCursor.deactivate();
    AppMethodBeat.o(12060);
  }
  
  public byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(12075);
    byte[] arrayOfByte = this.mCursor.getBlob(paramInt);
    AppMethodBeat.o(12075);
    return arrayOfByte;
  }
  
  public int getColumnCount()
  {
    AppMethodBeat.i(12062);
    int i = this.mCursor.getColumnCount();
    AppMethodBeat.o(12062);
    return i;
  }
  
  public int getColumnIndex(String paramString)
  {
    AppMethodBeat.i(12063);
    int i = this.mCursor.getColumnIndex(paramString);
    AppMethodBeat.o(12063);
    return i;
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    AppMethodBeat.i(12064);
    int i = this.mCursor.getColumnIndexOrThrow(paramString);
    AppMethodBeat.o(12064);
    return i;
  }
  
  public String getColumnName(int paramInt)
  {
    AppMethodBeat.i(12065);
    String str = this.mCursor.getColumnName(paramInt);
    AppMethodBeat.o(12065);
    return str;
  }
  
  public String[] getColumnNames()
  {
    AppMethodBeat.i(12066);
    String[] arrayOfString = this.mCursor.getColumnNames();
    AppMethodBeat.o(12066);
    return arrayOfString;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(12059);
    int i = this.mCursor.getCount();
    AppMethodBeat.o(12059);
    return i;
  }
  
  public double getDouble(int paramInt)
  {
    AppMethodBeat.i(12067);
    double d = this.mCursor.getDouble(paramInt);
    AppMethodBeat.o(12067);
    return d;
  }
  
  public Bundle getExtras()
  {
    AppMethodBeat.i(12068);
    Bundle localBundle = this.mCursor.getExtras();
    AppMethodBeat.o(12068);
    return localBundle;
  }
  
  public float getFloat(int paramInt)
  {
    AppMethodBeat.i(12069);
    float f = this.mCursor.getFloat(paramInt);
    AppMethodBeat.o(12069);
    return f;
  }
  
  public int getInt(int paramInt)
  {
    AppMethodBeat.i(12070);
    paramInt = this.mCursor.getInt(paramInt);
    AppMethodBeat.o(12070);
    return paramInt;
  }
  
  public long getLong(int paramInt)
  {
    AppMethodBeat.i(12071);
    long l = this.mCursor.getLong(paramInt);
    AppMethodBeat.o(12071);
    return l;
  }
  
  public Uri getNotificationUri()
  {
    return null;
  }
  
  public int getPosition()
  {
    AppMethodBeat.i(12087);
    int i = this.mCursor.getPosition();
    AppMethodBeat.o(12087);
    return i;
  }
  
  public short getShort(int paramInt)
  {
    AppMethodBeat.i(12072);
    short s = this.mCursor.getShort(paramInt);
    AppMethodBeat.o(12072);
    return s;
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(12073);
    String str = this.mCursor.getString(paramInt);
    AppMethodBeat.o(12073);
    return str;
  }
  
  public int getType(int paramInt)
  {
    AppMethodBeat.i(12081);
    paramInt = this.mCursor.getType(paramInt);
    AppMethodBeat.o(12081);
    return paramInt;
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    AppMethodBeat.i(12076);
    boolean bool = this.mCursor.getWantsAllOnMoveCalls();
    AppMethodBeat.o(12076);
    return bool;
  }
  
  public Cursor getWrappedCursor()
  {
    return this.mCursor;
  }
  
  public boolean isAfterLast()
  {
    AppMethodBeat.i(12077);
    boolean bool = this.mCursor.isAfterLast();
    AppMethodBeat.o(12077);
    return bool;
  }
  
  public boolean isBeforeFirst()
  {
    AppMethodBeat.i(12078);
    boolean bool = this.mCursor.isBeforeFirst();
    AppMethodBeat.o(12078);
    return bool;
  }
  
  public boolean isClosed()
  {
    AppMethodBeat.i(12058);
    boolean bool = this.mCursor.isClosed();
    AppMethodBeat.o(12058);
    return bool;
  }
  
  public boolean isFirst()
  {
    AppMethodBeat.i(12079);
    boolean bool = this.mCursor.isFirst();
    AppMethodBeat.o(12079);
    return bool;
  }
  
  public boolean isLast()
  {
    AppMethodBeat.i(12080);
    boolean bool = this.mCursor.isLast();
    AppMethodBeat.o(12080);
    return bool;
  }
  
  public boolean isNull(int paramInt)
  {
    AppMethodBeat.i(12082);
    boolean bool = this.mCursor.isNull(paramInt);
    AppMethodBeat.o(12082);
    return bool;
  }
  
  public boolean move(int paramInt)
  {
    AppMethodBeat.i(12084);
    boolean bool = this.mCursor.move(paramInt);
    AppMethodBeat.o(12084);
    return bool;
  }
  
  public boolean moveToFirst()
  {
    AppMethodBeat.i(12061);
    boolean bool = this.mCursor.moveToFirst();
    AppMethodBeat.o(12061);
    return bool;
  }
  
  public boolean moveToLast()
  {
    AppMethodBeat.i(12083);
    boolean bool = this.mCursor.moveToLast();
    AppMethodBeat.o(12083);
    return bool;
  }
  
  public boolean moveToNext()
  {
    AppMethodBeat.i(12086);
    boolean bool = this.mCursor.moveToNext();
    AppMethodBeat.o(12086);
    return bool;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    AppMethodBeat.i(12085);
    boolean bool = this.mCursor.moveToPosition(paramInt);
    AppMethodBeat.o(12085);
    return bool;
  }
  
  public boolean moveToPrevious()
  {
    AppMethodBeat.i(12088);
    boolean bool = this.mCursor.moveToPrevious();
    AppMethodBeat.o(12088);
    return bool;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(12089);
    this.mCursor.registerContentObserver(paramContentObserver);
    AppMethodBeat.o(12089);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(12090);
    this.mCursor.registerDataSetObserver(paramDataSetObserver);
    AppMethodBeat.o(12090);
  }
  
  public boolean requery()
  {
    AppMethodBeat.i(12091);
    boolean bool = this.mCursor.requery();
    AppMethodBeat.o(12091);
    return bool;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    AppMethodBeat.i(12092);
    paramBundle = this.mCursor.respond(paramBundle);
    AppMethodBeat.o(12092);
    return paramBundle;
  }
  
  public void setExtras(Bundle paramBundle) {}
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    AppMethodBeat.i(12093);
    this.mCursor.setNotificationUri(paramContentResolver, paramUri);
    AppMethodBeat.o(12093);
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(12094);
    this.mCursor.unregisterContentObserver(paramContentObserver);
    AppMethodBeat.o(12094);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(12095);
    this.mCursor.unregisterDataSetObserver(paramDataSetObserver);
    AppMethodBeat.o(12095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.CursorWrapper
 * JD-Core Version:    0.7.0.1
 */