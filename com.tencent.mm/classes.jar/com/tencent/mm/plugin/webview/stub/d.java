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
  public abstract Bundle fqx();
  
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
    
    public static d iwT()
    {
      return a.WRm;
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
      paramParcel1 = fqx();
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
      public static d WRm;
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
      public final Bundle fqx()
      {
        // Byte code:
        //   0: ldc 26
        //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 38	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 38	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 40
        //   16: invokevirtual 44	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 20	com/tencent/mm/plugin/webview/stub/d$a$a:mRemote	Landroid/os/IBinder;
        //   23: iconst_5
        //   24: aload_2
        //   25: aload_3
        //   26: iconst_0
        //   27: invokeinterface 50 5 0
        //   32: ifne +33 -> 65
        //   35: invokestatic 54	com/tencent/mm/plugin/webview/stub/d$a:iwT	()Lcom/tencent/mm/plugin/webview/stub/d;
        //   38: ifnull +27 -> 65
        //   41: invokestatic 54	com/tencent/mm/plugin/webview/stub/d$a:iwT	()Lcom/tencent/mm/plugin/webview/stub/d;
        //   44: invokeinterface 56 1 0
        //   49: astore_1
        //   50: aload_3
        //   51: invokevirtual 59	android/os/Parcel:recycle	()V
        //   54: aload_2
        //   55: invokevirtual 59	android/os/Parcel:recycle	()V
        //   58: ldc 26
        //   60: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   63: aload_1
        //   64: areturn
        //   65: aload_3
        //   66: invokevirtual 65	android/os/Parcel:readException	()V
        //   69: aload_3
        //   70: invokevirtual 69	android/os/Parcel:readInt	()I
        //   73: ifeq +31 -> 104
        //   76: getstatic 75	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   79: aload_3
        //   80: invokeinterface 81 2 0
        //   85: checkcast 71	android/os/Bundle
        //   88: astore_1
        //   89: aload_3
        //   90: invokevirtual 59	android/os/Parcel:recycle	()V
        //   93: aload_2
        //   94: invokevirtual 59	android/os/Parcel:recycle	()V
        //   97: ldc 26
        //   99: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   102: aload_1
        //   103: areturn
        //   104: aconst_null
        //   105: astore_1
        //   106: goto -17 -> 89
        //   109: astore_1
        //   110: aload_3
        //   111: invokevirtual 59	android/os/Parcel:recycle	()V
        //   114: aload_2
        //   115: invokevirtual 59	android/os/Parcel:recycle	()V
        //   118: ldc 26
        //   120: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   123: aload_1
        //   124: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	125	0	this	a
        //   49	57	1	localBundle	Bundle
        //   109	15	1	localObject	Object
        //   8	107	2	localParcel1	Parcel
        //   12	99	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	50	109	finally
        //   65	89	109	finally
      }
      
      public final int getErrCode()
      {
        AppMethodBeat.i(79254);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (d.a.iwT() != null))
          {
            i = d.a.iwT().getErrCode();
            return i;
          }
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
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (d.a.iwT() != null))
          {
            str = d.a.iwT().getErrMsg();
            return str;
          }
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
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (d.a.iwT() != null))
          {
            i = d.a.iwT().getErrType();
            return i;
          }
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
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (d.a.iwT() != null))
          {
            i = d.a.iwT().getType();
            return i;
          }
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