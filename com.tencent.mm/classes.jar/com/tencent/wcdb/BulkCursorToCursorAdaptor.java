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
    AppMethodBeat.i(2655);
    this.mObserverBridge = new AbstractCursor.SelfContentObserver(this);
    AppMethodBeat.o(2655);
  }
  
  private void throwIfCursorIsClosed()
  {
    AppMethodBeat.i(2658);
    if (this.mBulkCursor == null)
    {
      StaleDataException localStaleDataException = new StaleDataException("Attempted to access a cursor after it has been closed.");
      AppMethodBeat.o(2658);
      throw localStaleDataException;
    }
    AppMethodBeat.o(2658);
  }
  
  public final void close()
  {
    AppMethodBeat.i(2662);
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
        AppMethodBeat.o(2662);
      }
    }
    AppMethodBeat.o(2662);
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final void deactivate()
  {
    AppMethodBeat.i(2661);
    super.deactivate();
    if (this.mBulkCursor != null) {
      try
      {
        this.mBulkCursor.deactivate();
        AppMethodBeat.o(2661);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("BulkCursor", "Remote process exception when deactivating");
      }
    }
    AppMethodBeat.o(2661);
  }
  
  public final String[] getColumnNames()
  {
    AppMethodBeat.i(2664);
    throwIfCursorIsClosed();
    String[] arrayOfString = this.mColumns;
    AppMethodBeat.o(2664);
    return arrayOfString;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(2659);
    throwIfCursorIsClosed();
    int i = this.mCount;
    AppMethodBeat.o(2659);
    return i;
  }
  
  public final Bundle getExtras()
  {
    AppMethodBeat.i(2665);
    throwIfCursorIsClosed();
    try
    {
      Bundle localBundle = this.mBulkCursor.getExtras();
      AppMethodBeat.o(2665);
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      RuntimeException localRuntimeException = new RuntimeException(localRemoteException);
      AppMethodBeat.o(2665);
      throw localRuntimeException;
    }
  }
  
  public final IContentObserver getObserver()
  {
    AppMethodBeat.i(2657);
    try
    {
      IContentObserver localIContentObserver = (IContentObserver)this.mObserverBridge.getClass().getMethod("getContentObserver", new Class[0]).invoke(this.mObserverBridge, new Object[0]);
      AppMethodBeat.o(2657);
      return localIContentObserver;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(2657);
    }
    return null;
  }
  
  public final void initialize(BulkCursorDescriptor paramBulkCursorDescriptor)
  {
    AppMethodBeat.i(2656);
    this.mBulkCursor = paramBulkCursorDescriptor.cursor;
    this.mColumns = paramBulkCursorDescriptor.columnNames;
    this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
    this.mWantsAllOnMoveCalls = paramBulkCursorDescriptor.wantsAllOnMoveCalls;
    this.mCount = paramBulkCursorDescriptor.count;
    if (paramBulkCursorDescriptor.window != null) {
      setWindow(paramBulkCursorDescriptor.window);
    }
    AppMethodBeat.o(2656);
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2660);
    throwIfCursorIsClosed();
    try
    {
      if ((this.mWindow == null) || (paramInt2 < this.mWindow.getStartPosition()) || (paramInt2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows())) {
        setWindow(this.mBulkCursor.getWindow(paramInt2));
      }
      while (this.mWindow == null)
      {
        AppMethodBeat.o(2660);
        return false;
        if (this.mWantsAllOnMoveCalls) {
          this.mBulkCursor.onMove(paramInt2);
        }
      }
      AppMethodBeat.o(2660);
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("BulkCursor", "Unable to get window because the remote process is dead");
      AppMethodBeat.o(2660);
      return false;
    }
    return true;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public final boolean requery()
  {
    AppMethodBeat.i(2663);
    throwIfCursorIsClosed();
    try
    {
      this.mCount = this.mBulkCursor.requery(getObserver());
      if (this.mCount != -1)
      {
        this.mPos = -1;
        closeWindow();
        super.requery();
        AppMethodBeat.o(2663);
        return true;
      }
      deactivate();
      AppMethodBeat.o(2663);
      return false;
    }
    catch (Exception localException)
    {
      Log.e("BulkCursor", "Unable to requery because the remote process exception " + localException.getMessage());
      deactivate();
      AppMethodBeat.o(2663);
    }
    return false;
  }
  
  public final Bundle respond(Bundle paramBundle)
  {
    AppMethodBeat.i(2666);
    throwIfCursorIsClosed();
    try
    {
      paramBundle = this.mBulkCursor.respond(paramBundle);
      AppMethodBeat.o(2666);
      return paramBundle;
    }
    catch (RemoteException paramBundle)
    {
      Log.w("BulkCursor", "respond() threw RemoteException, returning an empty bundle.", new Object[] { paramBundle });
      paramBundle = Bundle.EMPTY;
      AppMethodBeat.o(2666);
    }
    return paramBundle;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.BulkCursorToCursorAdaptor
 * JD-Core Version:    0.7.0.1
 */