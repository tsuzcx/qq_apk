package org.chromium.base.process_launcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface ICallbackInt
  extends IInterface
{
  public abstract void call(int paramInt);
  
  public abstract void invokeMiscMethod(String paramString, Bundle paramBundle);
  
  public static abstract class Stub
    extends Binder
    implements ICallbackInt
  {
    private static final String DESCRIPTOR = "org.chromium.base.process_launcher.ICallbackInt";
    static final int TRANSACTION_call = 1;
    static final int TRANSACTION_invokeMiscMethod = 2;
    
    public Stub()
    {
      attachInterface(this, "org.chromium.base.process_launcher.ICallbackInt");
    }
    
    public static ICallbackInt asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("org.chromium.base.process_launcher.ICallbackInt");
      if ((localIInterface != null) && ((localIInterface instanceof ICallbackInt))) {
        return (ICallbackInt)localIInterface;
      }
      return new Proxy(paramIBinder);
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
        paramParcel2.writeString("org.chromium.base.process_launcher.ICallbackInt");
        return true;
      case 1: 
        paramParcel1.enforceInterface("org.chromium.base.process_launcher.ICallbackInt");
        call(paramParcel1.readInt());
        return true;
      }
      paramParcel1.enforceInterface("org.chromium.base.process_launcher.ICallbackInt");
      paramParcel2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        invokeMiscMethod(paramParcel2, paramParcel1);
        return true;
      }
    }
    
    static class Proxy
      implements ICallbackInt
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void call(int paramInt)
      {
        AppMethodBeat.i(53740);
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("org.chromium.base.process_launcher.ICallbackInt");
          localParcel.writeInt(paramInt);
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
          AppMethodBeat.o(53740);
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "org.chromium.base.process_launcher.ICallbackInt";
      }
      
      /* Error */
      public void invokeMiscMethod(String paramString, Bundle paramBundle)
      {
        // Byte code:
        //   0: ldc 62
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload_3
        //   10: ldc 38
        //   12: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: aload_1
        //   17: invokevirtual 65	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   20: aload_2
        //   21: ifnull +38 -> 59
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 71	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 19	org/chromium/base/process_launcher/ICallbackInt$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   39: iconst_2
        //   40: aload_3
        //   41: aconst_null
        //   42: iconst_1
        //   43: invokeinterface 51 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 54	android/os/Parcel:recycle	()V
        //   53: ldc 62
        //   55: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   58: return
        //   59: aload_3
        //   60: iconst_0
        //   61: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   64: goto -29 -> 35
        //   67: astore_1
        //   68: aload_3
        //   69: invokevirtual 54	android/os/Parcel:recycle	()V
        //   72: ldc 62
        //   74: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   77: aload_1
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	Proxy
        //   0	79	1	paramString	String
        //   0	79	2	paramBundle	Bundle
        //   8	61	3	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	20	67	finally
        //   24	35	67	finally
        //   35	49	67	finally
        //   59	64	67	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.chromium.base.process_launcher.ICallbackInt
 * JD-Core Version:    0.7.0.1
 */