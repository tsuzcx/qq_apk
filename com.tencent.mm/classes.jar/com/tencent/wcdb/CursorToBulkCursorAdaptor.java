package com.tencent.wcdb;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CursorToBulkCursorAdaptor
  extends BulkCursorNative
  implements IBinder.DeathRecipient
{
  private static final String TAG = "Cursor";
  private CrossProcessCursor mCursor;
  private CursorWindow mFilledWindow;
  private final Object mLock;
  private ContentObserverProxy mObserver;
  private final String mProviderName;
  
  public CursorToBulkCursorAdaptor(Cursor arg1, IContentObserver paramIContentObserver, String paramString)
  {
    AppMethodBeat.i(2687);
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
        AppMethodBeat.o(2687);
        return;
        this.mCursor = new CrossProcessCursorWrapper(???);
      }
    }
  }
  
  private void closeFilledWindowLocked()
  {
    AppMethodBeat.i(2688);
    if (this.mFilledWindow != null)
    {
      this.mFilledWindow.close();
      this.mFilledWindow = null;
    }
    AppMethodBeat.o(2688);
  }
  
  private void createAndRegisterObserverProxyLocked(IContentObserver paramIContentObserver)
  {
    AppMethodBeat.i(2698);
    if (this.mObserver != null)
    {
      paramIContentObserver = new IllegalStateException("an observer is already registered");
      AppMethodBeat.o(2698);
      throw paramIContentObserver;
    }
    this.mObserver = new ContentObserverProxy(paramIContentObserver, this);
    this.mCursor.registerContentObserver(this.mObserver);
    AppMethodBeat.o(2698);
  }
  
  private void disposeLocked()
  {
    AppMethodBeat.i(2689);
    if (this.mCursor != null)
    {
      unregisterObserverProxyLocked();
      this.mCursor.close();
      this.mCursor = null;
    }
    closeFilledWindowLocked();
    AppMethodBeat.o(2689);
  }
  
  private void throwIfCursorIsClosed()
  {
    AppMethodBeat.i(2690);
    if (this.mCursor == null)
    {
      StaleDataException localStaleDataException = new StaleDataException("Attempted to access a cursor after it has been closed.");
      AppMethodBeat.o(2690);
      throw localStaleDataException;
    }
    AppMethodBeat.o(2690);
  }
  
  private void unregisterObserverProxyLocked()
  {
    AppMethodBeat.i(2699);
    if (this.mObserver != null)
    {
      this.mCursor.unregisterContentObserver(this.mObserver);
      this.mObserver.unlinkToDeath(this);
      this.mObserver = null;
    }
    AppMethodBeat.o(2699);
  }
  
  public final void binderDied()
  {
    AppMethodBeat.i(2691);
    synchronized (this.mLock)
    {
      disposeLocked();
      AppMethodBeat.o(2691);
      return;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(2696);
    synchronized (this.mLock)
    {
      disposeLocked();
      AppMethodBeat.o(2696);
      return;
    }
  }
  
  public final void deactivate()
  {
    AppMethodBeat.i(2695);
    synchronized (this.mLock)
    {
      if (this.mCursor != null)
      {
        unregisterObserverProxyLocked();
        this.mCursor.deactivate();
      }
      closeFilledWindowLocked();
      AppMethodBeat.o(2695);
      return;
    }
  }
  
  public final BulkCursorDescriptor getBulkCursorDescriptor()
  {
    AppMethodBeat.i(2692);
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
      AppMethodBeat.o(2692);
      return localBulkCursorDescriptor;
    }
  }
  
  public final Bundle getExtras()
  {
    AppMethodBeat.i(2700);
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      Bundle localBundle = this.mCursor.getExtras();
      AppMethodBeat.o(2700);
      return localBundle;
    }
  }
  
  public final CursorWindow getWindow(int paramInt)
  {
    AppMethodBeat.i(2693);
    for (;;)
    {
      CursorWindow localCursorWindow2;
      synchronized (this.mLock)
      {
        throwIfCursorIsClosed();
        if (!this.mCursor.moveToPosition(paramInt))
        {
          closeFilledWindowLocked();
          AppMethodBeat.o(2693);
          return null;
        }
        CursorWindow localCursorWindow1 = this.mCursor.getWindow();
        if (localCursorWindow1 != null)
        {
          closeFilledWindowLocked();
          if (localCursorWindow1 != null) {
            localCursorWindow1.acquireReference();
          }
          AppMethodBeat.o(2693);
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
    AppMethodBeat.i(2694);
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      this.mCursor.onMove(this.mCursor.getPosition(), paramInt);
      AppMethodBeat.o(2694);
      return;
    }
  }
  
  public final int requery(IContentObserver paramIContentObserver)
  {
    AppMethodBeat.i(2697);
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      closeFilledWindowLocked();
      try
      {
        boolean bool = this.mCursor.requery();
        if (!bool)
        {
          AppMethodBeat.o(2697);
          return -1;
        }
      }
      catch (IllegalStateException paramIContentObserver)
      {
        paramIContentObserver = new IllegalStateException(this.mProviderName + " Requery misuse db, mCursor isClosed:" + this.mCursor.isClosed(), paramIContentObserver);
        AppMethodBeat.o(2697);
        throw paramIContentObserver;
      }
    }
    unregisterObserverProxyLocked();
    createAndRegisterObserverProxyLocked(paramIContentObserver);
    int i = this.mCursor.getCount();
    AppMethodBeat.o(2697);
    return i;
  }
  
  public final Bundle respond(Bundle paramBundle)
  {
    AppMethodBeat.i(2701);
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      paramBundle = this.mCursor.respond(paramBundle);
      AppMethodBeat.o(2701);
      return paramBundle;
    }
  }
  
  static final class ContentObserverProxy
    extends ContentObserver
  {
    protected IContentObserver mRemote;
    
    public ContentObserverProxy(IContentObserver paramIContentObserver, IBinder.DeathRecipient paramDeathRecipient)
    {
      super();
      AppMethodBeat.i(2684);
      this.mRemote = paramIContentObserver;
      try
      {
        paramIContentObserver.asBinder().linkToDeath(paramDeathRecipient, 0);
        AppMethodBeat.o(2684);
        return;
      }
      catch (RemoteException paramIContentObserver)
      {
        AppMethodBeat.o(2684);
      }
    }
    
    public final boolean deliverSelfNotifications()
    {
      return false;
    }
    
    public final void onChange(boolean paramBoolean, Uri paramUri)
    {
      AppMethodBeat.i(2686);
      try
      {
        this.mRemote.onChange(paramBoolean, paramUri);
        AppMethodBeat.o(2686);
        return;
      }
      catch (RemoteException paramUri)
      {
        AppMethodBeat.o(2686);
      }
    }
    
    public final boolean unlinkToDeath(IBinder.DeathRecipient paramDeathRecipient)
    {
      AppMethodBeat.i(2685);
      boolean bool = this.mRemote.asBinder().unlinkToDeath(paramDeathRecipient, 0);
      AppMethodBeat.o(2685);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wcdb.CursorToBulkCursorAdaptor
 * JD-Core Version:    0.7.0.1
 */