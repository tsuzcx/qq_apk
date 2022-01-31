package com.tencent.wcdb;

import android.os.Bundle;
import android.os.IBinder.DeathRecipient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CursorToBulkCursorAdaptor
  extends BulkCursorNative
  implements IBinder.DeathRecipient
{
  private static final String TAG = "Cursor";
  private CrossProcessCursor mCursor;
  private CursorWindow mFilledWindow;
  private final Object mLock;
  private CursorToBulkCursorAdaptor.ContentObserverProxy mObserver;
  private final String mProviderName;
  
  public CursorToBulkCursorAdaptor(Cursor arg1, IContentObserver paramIContentObserver, String paramString)
  {
    AppMethodBeat.i(12006);
    this.mLock = new Object();
    if ((??? instanceof CrossProcessCursor)) {
      this.mCursor = ((CrossProcessCursor)???);
    }
    for (;;)
    {
      this.mProviderName = paramString;
      synchronized (this.mLock)
      {
        createAndRegisterObserverProxyLocked(paramIContentObserver);
        AppMethodBeat.o(12006);
        return;
        this.mCursor = new CrossProcessCursorWrapper(???);
      }
    }
  }
  
  private void closeFilledWindowLocked()
  {
    AppMethodBeat.i(12007);
    if (this.mFilledWindow != null)
    {
      this.mFilledWindow.close();
      this.mFilledWindow = null;
    }
    AppMethodBeat.o(12007);
  }
  
  private void createAndRegisterObserverProxyLocked(IContentObserver paramIContentObserver)
  {
    AppMethodBeat.i(12017);
    if (this.mObserver != null)
    {
      paramIContentObserver = new IllegalStateException("an observer is already registered");
      AppMethodBeat.o(12017);
      throw paramIContentObserver;
    }
    this.mObserver = new CursorToBulkCursorAdaptor.ContentObserverProxy(paramIContentObserver, this);
    this.mCursor.registerContentObserver(this.mObserver);
    AppMethodBeat.o(12017);
  }
  
  private void disposeLocked()
  {
    AppMethodBeat.i(12008);
    if (this.mCursor != null)
    {
      unregisterObserverProxyLocked();
      this.mCursor.close();
      this.mCursor = null;
    }
    closeFilledWindowLocked();
    AppMethodBeat.o(12008);
  }
  
  private void throwIfCursorIsClosed()
  {
    AppMethodBeat.i(12009);
    if (this.mCursor == null)
    {
      StaleDataException localStaleDataException = new StaleDataException("Attempted to access a cursor after it has been closed.");
      AppMethodBeat.o(12009);
      throw localStaleDataException;
    }
    AppMethodBeat.o(12009);
  }
  
  private void unregisterObserverProxyLocked()
  {
    AppMethodBeat.i(12018);
    if (this.mObserver != null)
    {
      this.mCursor.unregisterContentObserver(this.mObserver);
      this.mObserver.unlinkToDeath(this);
      this.mObserver = null;
    }
    AppMethodBeat.o(12018);
  }
  
  public final void binderDied()
  {
    AppMethodBeat.i(12010);
    synchronized (this.mLock)
    {
      disposeLocked();
      AppMethodBeat.o(12010);
      return;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(12015);
    synchronized (this.mLock)
    {
      disposeLocked();
      AppMethodBeat.o(12015);
      return;
    }
  }
  
  public final void deactivate()
  {
    AppMethodBeat.i(12014);
    synchronized (this.mLock)
    {
      if (this.mCursor != null)
      {
        unregisterObserverProxyLocked();
        this.mCursor.deactivate();
      }
      closeFilledWindowLocked();
      AppMethodBeat.o(12014);
      return;
    }
  }
  
  public final BulkCursorDescriptor getBulkCursorDescriptor()
  {
    AppMethodBeat.i(12011);
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      BulkCursorDescriptor localBulkCursorDescriptor = new BulkCursorDescriptor();
      localBulkCursorDescriptor.cursor = this;
      localBulkCursorDescriptor.columnNames = this.mCursor.getColumnNames();
      localBulkCursorDescriptor.wantsAllOnMoveCalls = this.mCursor.getWantsAllOnMoveCalls();
      localBulkCursorDescriptor.count = this.mCursor.getCount();
      localBulkCursorDescriptor.window = this.mCursor.getWindow();
      if (localBulkCursorDescriptor.window != null) {
        localBulkCursorDescriptor.window.acquireReference();
      }
      AppMethodBeat.o(12011);
      return localBulkCursorDescriptor;
    }
  }
  
  public final Bundle getExtras()
  {
    AppMethodBeat.i(12019);
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      Bundle localBundle = this.mCursor.getExtras();
      AppMethodBeat.o(12019);
      return localBundle;
    }
  }
  
  public final CursorWindow getWindow(int paramInt)
  {
    AppMethodBeat.i(12012);
    for (;;)
    {
      CursorWindow localCursorWindow2;
      synchronized (this.mLock)
      {
        throwIfCursorIsClosed();
        if (!this.mCursor.moveToPosition(paramInt))
        {
          closeFilledWindowLocked();
          AppMethodBeat.o(12012);
          return null;
        }
        CursorWindow localCursorWindow1 = this.mCursor.getWindow();
        if (localCursorWindow1 != null)
        {
          closeFilledWindowLocked();
          if (localCursorWindow1 != null) {
            localCursorWindow1.acquireReference();
          }
          AppMethodBeat.o(12012);
          return localCursorWindow1;
        }
        localCursorWindow2 = this.mFilledWindow;
        if (localCursorWindow2 == null)
        {
          this.mFilledWindow = new CursorWindow(this.mProviderName);
          localCursorWindow1 = this.mFilledWindow;
          this.mCursor.fillWindow(paramInt, localCursorWindow1);
        }
      }
      Object localObject2;
      if (paramInt >= localCursorWindow2.getStartPosition())
      {
        localObject2 = localCursorWindow2;
        if (paramInt < localCursorWindow2.getStartPosition() + localCursorWindow2.getNumRows()) {}
      }
      else
      {
        localCursorWindow2.clear();
        localObject2 = localCursorWindow2;
      }
    }
  }
  
  public final void onMove(int paramInt)
  {
    AppMethodBeat.i(12013);
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      this.mCursor.onMove(this.mCursor.getPosition(), paramInt);
      AppMethodBeat.o(12013);
      return;
    }
  }
  
  public final int requery(IContentObserver paramIContentObserver)
  {
    AppMethodBeat.i(12016);
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      closeFilledWindowLocked();
      try
      {
        boolean bool = this.mCursor.requery();
        if (!bool)
        {
          AppMethodBeat.o(12016);
          return -1;
        }
      }
      catch (IllegalStateException paramIContentObserver)
      {
        paramIContentObserver = new IllegalStateException(this.mProviderName + " Requery misuse db, mCursor isClosed:" + this.mCursor.isClosed(), paramIContentObserver);
        AppMethodBeat.o(12016);
        throw paramIContentObserver;
      }
    }
    unregisterObserverProxyLocked();
    createAndRegisterObserverProxyLocked(paramIContentObserver);
    int i = this.mCursor.getCount();
    AppMethodBeat.o(12016);
    return i;
  }
  
  public final Bundle respond(Bundle paramBundle)
  {
    AppMethodBeat.i(12020);
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      paramBundle = this.mCursor.respond(paramBundle);
      AppMethodBeat.o(12020);
      return paramBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.CursorToBulkCursorAdaptor
 * JD-Core Version:    0.7.0.1
 */