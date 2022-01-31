package com.tencent.wcdb;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.Log;
import java.lang.reflect.Method;

public final class BulkCursorToCursorAdaptor
  extends AbstractWindowedCursor
{
  private static final String TAG = "BulkCursor";
  private IBulkCursor mBulkCursor;
  private String[] mColumns;
  private int mCount;
  private AbstractCursor.SelfContentObserver mObserverBridge;
  private boolean mWantsAllOnMoveCalls;
  
  public BulkCursorToCursorAdaptor()
  {
    AppMethodBeat.i(11974);
    this.mObserverBridge = new AbstractCursor.SelfContentObserver(this);
    AppMethodBeat.o(11974);
  }
  
  private void throwIfCursorIsClosed()
  {
    AppMethodBeat.i(11977);
    if (this.mBulkCursor == null)
    {
      StaleDataException localStaleDataException = new StaleDataException("Attempted to access a cursor after it has been closed.");
      AppMethodBeat.o(11977);
      throw localStaleDataException;
    }
    AppMethodBeat.o(11977);
  }
  
  public final void close()
  {
    AppMethodBeat.i(11981);
    super.close();
    if (this.mBulkCursor != null) {
      try
      {
        this.mBulkCursor.close();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("BulkCursor", "Remote process exception when closing");
        return;
      }
      finally
      {
        this.mBulkCursor = null;
        AppMethodBeat.o(11981);
      }
    }
    AppMethodBeat.o(11981);
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final void deactivate()
  {
    AppMethodBeat.i(11980);
    super.deactivate();
    if (this.mBulkCursor != null) {
      try
      {
        this.mBulkCursor.deactivate();
        AppMethodBeat.o(11980);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("BulkCursor", "Remote process exception when deactivating");
      }
    }
    AppMethodBeat.o(11980);
  }
  
  public final String[] getColumnNames()
  {
    AppMethodBeat.i(11983);
    throwIfCursorIsClosed();
    String[] arrayOfString = this.mColumns;
    AppMethodBeat.o(11983);
    return arrayOfString;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(11978);
    throwIfCursorIsClosed();
    int i = this.mCount;
    AppMethodBeat.o(11978);
    return i;
  }
  
  public final Bundle getExtras()
  {
    AppMethodBeat.i(11984);
    throwIfCursorIsClosed();
    try
    {
      Bundle localBundle = this.mBulkCursor.getExtras();
      AppMethodBeat.o(11984);
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      RuntimeException localRuntimeException = new RuntimeException(localRemoteException);
      AppMethodBeat.o(11984);
      throw localRuntimeException;
    }
  }
  
  public final IContentObserver getObserver()
  {
    AppMethodBeat.i(11976);
    try
    {
      IContentObserver localIContentObserver = (IContentObserver)this.mObserverBridge.getClass().getMethod("getContentObserver", new Class[0]).invoke(this.mObserverBridge, new Object[0]);
      AppMethodBeat.o(11976);
      return localIContentObserver;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(11976);
    }
    return null;
  }
  
  public final void initialize(BulkCursorDescriptor paramBulkCursorDescriptor)
  {
    AppMethodBeat.i(11975);
    this.mBulkCursor = paramBulkCursorDescriptor.cursor;
    this.mColumns = paramBulkCursorDescriptor.columnNames;
    this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
    this.mWantsAllOnMoveCalls = paramBulkCursorDescriptor.wantsAllOnMoveCalls;
    this.mCount = paramBulkCursorDescriptor.count;
    if (paramBulkCursorDescriptor.window != null) {
      setWindow(paramBulkCursorDescriptor.window);
    }
    AppMethodBeat.o(11975);
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11979);
    throwIfCursorIsClosed();
    try
    {
      if ((this.mWindow == null) || (paramInt2 < this.mWindow.getStartPosition()) || (paramInt2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows())) {
        setWindow(this.mBulkCursor.getWindow(paramInt2));
      }
      while (this.mWindow == null)
      {
        AppMethodBeat.o(11979);
        return false;
        if (this.mWantsAllOnMoveCalls) {
          this.mBulkCursor.onMove(paramInt2);
        }
      }
      AppMethodBeat.o(11979);
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("BulkCursor", "Unable to get window because the remote process is dead");
      AppMethodBeat.o(11979);
      return false;
    }
    return true;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public final boolean requery()
  {
    AppMethodBeat.i(11982);
    throwIfCursorIsClosed();
    try
    {
      this.mCount = this.mBulkCursor.requery(getObserver());
      if (this.mCount != -1)
      {
        this.mPos = -1;
        closeWindow();
        super.requery();
        AppMethodBeat.o(11982);
        return true;
      }
      deactivate();
      AppMethodBeat.o(11982);
      return false;
    }
    catch (Exception localException)
    {
      Log.e("BulkCursor", "Unable to requery because the remote process exception " + localException.getMessage());
      deactivate();
      AppMethodBeat.o(11982);
    }
    return false;
  }
  
  public final Bundle respond(Bundle paramBundle)
  {
    AppMethodBeat.i(11985);
    throwIfCursorIsClosed();
    try
    {
      paramBundle = this.mBulkCursor.respond(paramBundle);
      AppMethodBeat.o(11985);
      return paramBundle;
    }
    catch (RemoteException paramBundle)
    {
      Log.w("BulkCursor", "respond() threw RemoteException, returning an empty bundle.", new Object[] { paramBundle });
      paramBundle = Bundle.EMPTY;
      AppMethodBeat.o(11985);
    }
    return paramBundle;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wcdb.BulkCursorToCursorAdaptor
 * JD-Core Version:    0.7.0.1
 */