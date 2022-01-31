package com.tencent.mm.plugin.talkroom.component;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a$a
  implements d
{
  private IBinder mRemote;
  
  d$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public final void akP()
  {
    AppMethodBeat.i(25704);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(25704);
    }
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public final void cHp()
  {
    AppMethodBeat.i(25703);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(25703);
    }
  }
  
  public final int cHq()
  {
    AppMethodBeat.i(25706);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(25706);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(25705);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(25705);
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(25707);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(25707);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.d.a.a
 * JD-Core Version:    0.7.0.1
 */