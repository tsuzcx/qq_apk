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
    AppMethodBeat.i(2738);
    this.mCursor.close();
    AppMethodBeat.o(2738);
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    AppMethodBeat.i(2755);
    this.mCursor.copyStringToBuffer(paramInt, paramCharArrayBuffer);
    AppMethodBeat.o(2755);
  }
  
  public void deactivate()
  {
    AppMethodBeat.i(2741);
    this.mCursor.deactivate();
    AppMethodBeat.o(2741);
  }
  
  public byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(2756);
    byte[] arrayOfByte = this.mCursor.getBlob(paramInt);
    AppMethodBeat.o(2756);
    return arrayOfByte;
  }
  
  public int getColumnCount()
  {
    AppMethodBeat.i(2743);
    int i = this.mCursor.getColumnCount();
    AppMethodBeat.o(2743);
    return i;
  }
  
  public int getColumnIndex(String paramString)
  {
    AppMethodBeat.i(2744);
    int i = this.mCursor.getColumnIndex(paramString);
    AppMethodBeat.o(2744);
    return i;
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    AppMethodBeat.i(2745);
    int i = this.mCursor.getColumnIndexOrThrow(paramString);
    AppMethodBeat.o(2745);
    return i;
  }
  
  public String getColumnName(int paramInt)
  {
    AppMethodBeat.i(2746);
    String str = this.mCursor.getColumnName(paramInt);
    AppMethodBeat.o(2746);
    return str;
  }
  
  public String[] getColumnNames()
  {
    AppMethodBeat.i(2747);
    String[] arrayOfString = this.mCursor.getColumnNames();
    AppMethodBeat.o(2747);
    return arrayOfString;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(2740);
    int i = this.mCursor.getCount();
    AppMethodBeat.o(2740);
    return i;
  }
  
  public double getDouble(int paramInt)
  {
    AppMethodBeat.i(2748);
    double d = this.mCursor.getDouble(paramInt);
    AppMethodBeat.o(2748);
    return d;
  }
  
  public Bundle getExtras()
  {
    AppMethodBeat.i(2749);
    Bundle localBundle = this.mCursor.getExtras();
    AppMethodBeat.o(2749);
    return localBundle;
  }
  
  public float getFloat(int paramInt)
  {
    AppMethodBeat.i(2750);
    float f = this.mCursor.getFloat(paramInt);
    AppMethodBeat.o(2750);
    return f;
  }
  
  public int getInt(int paramInt)
  {
    AppMethodBeat.i(2751);
    paramInt = this.mCursor.getInt(paramInt);
    AppMethodBeat.o(2751);
    return paramInt;
  }
  
  public long getLong(int paramInt)
  {
    AppMethodBeat.i(2752);
    long l = this.mCursor.getLong(paramInt);
    AppMethodBeat.o(2752);
    return l;
  }
  
  public Uri getNotificationUri()
  {
    return null;
  }
  
  public int getPosition()
  {
    AppMethodBeat.i(2768);
    int i = this.mCursor.getPosition();
    AppMethodBeat.o(2768);
    return i;
  }
  
  public short getShort(int paramInt)
  {
    AppMethodBeat.i(2753);
    short s = this.mCursor.getShort(paramInt);
    AppMethodBeat.o(2753);
    return s;
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(2754);
    String str = this.mCursor.getString(paramInt);
    AppMethodBeat.o(2754);
    return str;
  }
  
  public int getType(int paramInt)
  {
    AppMethodBeat.i(2762);
    paramInt = this.mCursor.getType(paramInt);
    AppMethodBeat.o(2762);
    return paramInt;
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    AppMethodBeat.i(2757);
    boolean bool = this.mCursor.getWantsAllOnMoveCalls();
    AppMethodBeat.o(2757);
    return bool;
  }
  
  public Cursor getWrappedCursor()
  {
    return this.mCursor;
  }
  
  public boolean isAfterLast()
  {
    AppMethodBeat.i(2758);
    boolean bool = this.mCursor.isAfterLast();
    AppMethodBeat.o(2758);
    return bool;
  }
  
  public boolean isBeforeFirst()
  {
    AppMethodBeat.i(2759);
    boolean bool = this.mCursor.isBeforeFirst();
    AppMethodBeat.o(2759);
    return bool;
  }
  
  public boolean isClosed()
  {
    AppMethodBeat.i(2739);
    boolean bool = this.mCursor.isClosed();
    AppMethodBeat.o(2739);
    return bool;
  }
  
  public boolean isFirst()
  {
    AppMethodBeat.i(2760);
    boolean bool = this.mCursor.isFirst();
    AppMethodBeat.o(2760);
    return bool;
  }
  
  public boolean isLast()
  {
    AppMethodBeat.i(2761);
    boolean bool = this.mCursor.isLast();
    AppMethodBeat.o(2761);
    return bool;
  }
  
  public boolean isNull(int paramInt)
  {
    AppMethodBeat.i(2763);
    boolean bool = this.mCursor.isNull(paramInt);
    AppMethodBeat.o(2763);
    return bool;
  }
  
  public boolean move(int paramInt)
  {
    AppMethodBeat.i(2765);
    boolean bool = this.mCursor.move(paramInt);
    AppMethodBeat.o(2765);
    return bool;
  }
  
  public boolean moveToFirst()
  {
    AppMethodBeat.i(2742);
    boolean bool = this.mCursor.moveToFirst();
    AppMethodBeat.o(2742);
    return bool;
  }
  
  public boolean moveToLast()
  {
    AppMethodBeat.i(2764);
    boolean bool = this.mCursor.moveToLast();
    AppMethodBeat.o(2764);
    return bool;
  }
  
  public boolean moveToNext()
  {
    AppMethodBeat.i(2767);
    boolean bool = this.mCursor.moveToNext();
    AppMethodBeat.o(2767);
    return bool;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    AppMethodBeat.i(2766);
    boolean bool = this.mCursor.moveToPosition(paramInt);
    AppMethodBeat.o(2766);
    return bool;
  }
  
  public boolean moveToPrevious()
  {
    AppMethodBeat.i(2769);
    boolean bool = this.mCursor.moveToPrevious();
    AppMethodBeat.o(2769);
    return bool;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(2770);
    this.mCursor.registerContentObserver(paramContentObserver);
    AppMethodBeat.o(2770);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(2771);
    this.mCursor.registerDataSetObserver(paramDataSetObserver);
    AppMethodBeat.o(2771);
  }
  
  public boolean requery()
  {
    AppMethodBeat.i(2772);
    boolean bool = this.mCursor.requery();
    AppMethodBeat.o(2772);
    return bool;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    AppMethodBeat.i(2773);
    paramBundle = this.mCursor.respond(paramBundle);
    AppMethodBeat.o(2773);
    return paramBundle;
  }
  
  public void setExtras(Bundle paramBundle) {}
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    AppMethodBeat.i(2774);
    this.mCursor.setNotificationUri(paramContentResolver, paramUri);
    AppMethodBeat.o(2774);
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(2775);
    this.mCursor.unregisterContentObserver(paramContentObserver);
    AppMethodBeat.o(2775);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(2776);
    this.mCursor.unregisterDataSetObserver(paramDataSetObserver);
    AppMethodBeat.o(2776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.CursorWrapper
 * JD-Core Version:    0.7.0.1
 */