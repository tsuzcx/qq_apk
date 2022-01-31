package com.tencent.mm.plugin.normsg.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.FileDescriptor;

class b$d
  extends Binder
{
  protected final IBinder mHM;
  
  b$d(b paramb, IBinder paramIBinder)
  {
    this.mHM = paramIBinder;
  }
  
  public void dump(FileDescriptor paramFileDescriptor, String[] paramArrayOfString)
  {
    try
    {
      this.mHM.dump(paramFileDescriptor, paramArrayOfString);
      return;
    }
    catch (RemoteException paramFileDescriptor) {}
  }
  
  public void dumpAsync(FileDescriptor paramFileDescriptor, String[] paramArrayOfString)
  {
    try
    {
      this.mHM.dumpAsync(paramFileDescriptor, paramArrayOfString);
      return;
    }
    catch (RemoteException paramFileDescriptor) {}
  }
  
  public String getInterfaceDescriptor()
  {
    try
    {
      String str = this.mHM.getInterfaceDescriptor();
      return str;
    }
    catch (RemoteException localRemoteException) {}
    return "<failure>";
  }
  
  public boolean isBinderAlive()
  {
    return this.mHM.isBinderAlive();
  }
  
  public void linkToDeath(IBinder.DeathRecipient paramDeathRecipient, int paramInt)
  {
    try
    {
      this.mHM.linkToDeath(paramDeathRecipient, paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      paramDeathRecipient.binderDied();
    }
  }
  
  protected boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = false;
    try
    {
      if (this.mHM.isBinderAlive()) {
        bool = this.mHM.transact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      return bool;
    }
    catch (RemoteException paramParcel1)
    {
      throw paramParcel1;
    }
    catch (Throwable paramParcel1)
    {
      b.a(this.mHC, paramParcel1);
    }
    return false;
  }
  
  public boolean pingBinder()
  {
    return this.mHM.pingBinder();
  }
  
  public IInterface queryLocalInterface(String paramString)
  {
    return null;
  }
  
  public boolean unlinkToDeath(IBinder.DeathRecipient paramDeathRecipient, int paramInt)
  {
    return this.mHM.unlinkToDeath(paramDeathRecipient, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.d
 * JD-Core Version:    0.7.0.1
 */