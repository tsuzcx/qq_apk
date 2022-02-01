package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface c
  extends IInterface
{
  public abstract void E(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static abstract class a
    extends Binder
    implements c
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
    }
    
    public static c ftH()
    {
      return a.FOV;
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
        E(paramInt1, paramInt2, bool);
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    static final class a
      implements c
    {
      public static c FOV;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void E(int paramInt1, int paramInt2, boolean paramBoolean)
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
            if ((this.mRemote.transact(1, localParcel1, localParcel2, 0)) || (c.a.ftH() == null)) {
              break;
            }
            c.a.ftH().E(paramInt1, paramInt2, paramBoolean);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.c
 * JD-Core Version:    0.7.0.1
 */