package com.tencent.wcdb;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CursorToBulkCursorAdaptor$ContentObserverProxy
  extends ContentObserver
{
  protected IContentObserver mRemote;
  
  public CursorToBulkCursorAdaptor$ContentObserverProxy(IContentObserver paramIContentObserver, IBinder.DeathRecipient paramDeathRecipient)
  {
    super(null);
    AppMethodBeat.i(12003);
    this.mRemote = paramIContentObserver;
    try
    {
      paramIContentObserver.asBinder().linkToDeath(paramDeathRecipient, 0);
      AppMethodBeat.o(12003);
      return;
    }
    catch (RemoteException paramIContentObserver)
    {
      AppMethodBeat.o(12003);
    }
  }
  
  public final boolean deliverSelfNotifications()
  {
    return false;
  }
  
  public final void onChange(boolean paramBoolean, Uri paramUri)
  {
    AppMethodBeat.i(12005);
    try
    {
      this.mRemote.onChange(paramBoolean, paramUri);
      AppMethodBeat.o(12005);
      return;
    }
    catch (RemoteException paramUri)
    {
      AppMethodBeat.o(12005);
    }
  }
  
  public final boolean unlinkToDeath(IBinder.DeathRecipient paramDeathRecipient)
  {
    AppMethodBeat.i(12004);
    boolean bool = this.mRemote.asBinder().unlinkToDeath(paramDeathRecipient, 0);
    AppMethodBeat.o(12004);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wcdb.CursorToBulkCursorAdaptor.ContentObserverProxy
 * JD-Core Version:    0.7.0.1
 */