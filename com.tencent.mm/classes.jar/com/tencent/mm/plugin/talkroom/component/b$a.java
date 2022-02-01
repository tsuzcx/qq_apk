package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class b$a
  extends Binder
  implements b
{
  public b$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
  }
  
  public static b hCi()
  {
    return a.SMs;
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
    paramInt1 = paramParcel1.readInt();
    paramInt2 = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      P(paramInt1, paramInt2, bool);
      paramParcel2.writeNoException();
      return true;
    }
  }
  
  static final class a
    implements b
  {
    public static b SMs;
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final void P(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int i = 1;
      AppMethodBeat.i(29383);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        if (paramBoolean) {}
        for (;;)
        {
          localParcel1.writeInt(i);
          if ((this.mRemote.transact(1, localParcel1, localParcel2, 0)) || (b.a.hCi() == null)) {
            break;
          }
          b.a.hCi().P(paramInt1, paramInt2, paramBoolean);
          return;
          i = 0;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(29383);
      }
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.b.a
 * JD-Core Version:    0.7.0.1
 */