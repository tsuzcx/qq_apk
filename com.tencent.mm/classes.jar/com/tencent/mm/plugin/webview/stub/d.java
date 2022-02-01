package com.tencent.mm.plugin.webview.stub;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface d
  extends IInterface
{
  public abstract Bundle getData();
  
  public abstract int getErrCode();
  
  public abstract String getErrMsg();
  
  public abstract int getErrType();
  
  public abstract int getType();
  
  public static abstract class a
    extends Binder
    implements d
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
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
        paramParcel2.writeString("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
        paramInt1 = getType();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
        paramInt1 = getErrType();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
        paramInt1 = getErrCode();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
        paramParcel1 = getErrMsg();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
      paramParcel1 = getData();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }
    
    static final class a
      implements d
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public final Bundle getData()
      {
        // Byte code:
        //   0: ldc 24
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 38
        //   16: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 18	com/tencent/mm/plugin/webview/stub/d$a$a:mRemote	Landroid/os/IBinder;
        //   23: iconst_5
        //   24: aload_2
        //   25: aload_3
        //   26: iconst_0
        //   27: invokeinterface 48 5 0
        //   32: pop
        //   33: aload_3
        //   34: invokevirtual 51	android/os/Parcel:readException	()V
        //   37: aload_3
        //   38: invokevirtual 55	android/os/Parcel:readInt	()I
        //   41: ifeq +31 -> 72
        //   44: getstatic 61	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   47: aload_3
        //   48: invokeinterface 67 2 0
        //   53: checkcast 57	android/os/Bundle
        //   56: astore_1
        //   57: aload_3
        //   58: invokevirtual 70	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 70	android/os/Parcel:recycle	()V
        //   65: ldc 24
        //   67: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   70: aload_1
        //   71: areturn
        //   72: aconst_null
        //   73: astore_1
        //   74: goto -17 -> 57
        //   77: astore_1
        //   78: aload_3
        //   79: invokevirtual 70	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: invokevirtual 70	android/os/Parcel:recycle	()V
        //   86: ldc 24
        //   88: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   91: aload_1
        //   92: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	93	0	this	a
        //   56	18	1	localBundle	Bundle
        //   77	15	1	localObject	Object
        //   8	75	2	localParcel1	Parcel
        //   12	67	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	57	77	finally
      }
      
      public final int getErrCode()
      {
        AppMethodBeat.i(79254);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79254);
        }
      }
      
      public final String getErrMsg()
      {
        AppMethodBeat.i(79255);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79255);
        }
      }
      
      public final int getErrType()
      {
        AppMethodBeat.i(79253);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79253);
        }
      }
      
      public final int getType()
      {
        AppMethodBeat.i(79252);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79252);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.d
 * JD-Core Version:    0.7.0.1
 */