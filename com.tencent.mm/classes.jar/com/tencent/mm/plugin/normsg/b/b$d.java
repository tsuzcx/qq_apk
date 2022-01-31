package com.tencent.mm.plugin.normsg.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;

class b$d
  extends Binder
{
  protected final IBinder phS;
  
  b$d(b paramb, IBinder paramIBinder)
  {
    this.phS = paramIBinder;
  }
  
  public void dump(FileDescriptor paramFileDescriptor, String[] paramArrayOfString)
  {
    AppMethodBeat.i(10405);
    try
    {
      this.phS.dump(paramFileDescriptor, paramArrayOfString);
      AppMethodBeat.o(10405);
      return;
    }
    catch (RemoteException paramFileDescriptor)
    {
      AppMethodBeat.o(10405);
    }
  }
  
  public void dumpAsync(FileDescriptor paramFileDescriptor, String[] paramArrayOfString)
  {
    AppMethodBeat.i(10406);
    try
    {
      this.phS.dumpAsync(paramFileDescriptor, paramArrayOfString);
      AppMethodBeat.o(10406);
      return;
    }
    catch (RemoteException paramFileDescriptor)
    {
      AppMethodBeat.o(10406);
    }
  }
  
  public String getInterfaceDescriptor()
  {
    AppMethodBeat.i(10402);
    try
    {
      String str = this.phS.getInterfaceDescriptor();
      AppMethodBeat.o(10402);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(10402);
    }
    return "<failure>";
  }
  
  public boolean isBinderAlive()
  {
    AppMethodBeat.i(10404);
    boolean bool = this.phS.isBinderAlive();
    AppMethodBeat.o(10404);
    return bool;
  }
  
  public void linkToDeath(IBinder.DeathRecipient paramDeathRecipient, int paramInt)
  {
    AppMethodBeat.i(10408);
    try
    {
      this.phS.linkToDeath(paramDeathRecipient, paramInt);
      AppMethodBeat.o(10408);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      paramDeathRecipient.binderDied();
      AppMethodBeat.o(10408);
    }
  }
  
  protected boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    AppMethodBeat.i(10407);
    try
    {
      if (this.phS.isBinderAlive())
      {
        boolean bool = this.phS.transact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        AppMethodBeat.o(10407);
        return bool;
      }
      AppMethodBeat.o(10407);
      return false;
    }
    catch (RemoteException paramParcel1)
    {
      AppMethodBeat.o(10407);
      throw paramParcel1;
    }
    catch (Throwable paramParcel1)
    {
      b.a(this.phI, paramParcel1);
      AppMethodBeat.o(10407);
    }
    return false;
  }
  
  public boolean pingBinder()
  {
    AppMethodBeat.i(10403);
    boolean bool = this.phS.pingBinder();
    AppMethodBeat.o(10403);
    return bool;
  }
  
  public IInterface queryLocalInterface(String paramString)
  {
    return null;
  }
  
  public boolean unlinkToDeath(IBinder.DeathRecipient paramDeathRecipient, int paramInt)
  {
    AppMethodBeat.i(10409);
    boolean bool = this.phS.unlinkToDeath(paramDeathRecipient, paramInt);
    AppMethodBeat.o(10409);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.d
 * JD-Core Version:    0.7.0.1
 */