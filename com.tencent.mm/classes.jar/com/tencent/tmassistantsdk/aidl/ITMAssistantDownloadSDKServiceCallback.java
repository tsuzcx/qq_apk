package com.tencent.tmassistantsdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface ITMAssistantDownloadSDKServiceCallback
  extends IInterface
{
  public abstract void OnDownloadSDKServiceTaskProgressChanged(String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public abstract void OnDownloadSDKServiceTaskStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean1, boolean paramBoolean2);
  
  public static abstract class Stub
    extends Binder
    implements ITMAssistantDownloadSDKServiceCallback
  {
    private static final String DESCRIPTOR = "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback";
    static final int TRANSACTION_OnDownloadSDKServiceTaskProgressChanged = 2;
    static final int TRANSACTION_OnDownloadSDKServiceTaskStateChanged = 1;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
    }
    
    public static ITMAssistantDownloadSDKServiceCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
      if ((localIInterface != null) && ((localIInterface instanceof ITMAssistantDownloadSDKServiceCallback))) {
        return (ITMAssistantDownloadSDKServiceCallback)localIInterface;
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
        paramParcel2.writeString("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
        String str1 = paramParcel1.readString();
        String str2 = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        String str3 = paramParcel1.readString();
        boolean bool1;
        if (paramParcel1.readInt() != 0)
        {
          bool1 = true;
          if (paramParcel1.readInt() == 0) {
            break label138;
          }
        }
        label138:
        for (boolean bool2 = true;; bool2 = false)
        {
          OnDownloadSDKServiceTaskStateChanged(str1, str2, paramInt1, paramInt2, str3, bool1, bool2);
          paramParcel2.writeNoException();
          return true;
          bool1 = false;
          break;
        }
      }
      paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
      OnDownloadSDKServiceTaskProgressChanged(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    }
    
    static class Proxy
      implements ITMAssistantDownloadSDKServiceCallback
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void OnDownloadSDKServiceTaskProgressChanged(String paramString1, String paramString2, long paramLong1, long paramLong2)
      {
        AppMethodBeat.i(101841);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeLong(paramLong1);
          localParcel1.writeLong(paramLong2);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(101841);
        }
      }
      
      /* Error */
      public void OnDownloadSDKServiceTaskStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 8
        //   3: ldc 66
        //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 9
        //   13: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   16: astore 10
        //   18: aload 9
        //   20: ldc 37
        //   22: invokevirtual 41	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   25: aload 9
        //   27: aload_1
        //   28: invokevirtual 44	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   31: aload 9
        //   33: aload_2
        //   34: invokevirtual 44	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   37: aload 9
        //   39: iload_3
        //   40: invokevirtual 69	android/os/Parcel:writeInt	(I)V
        //   43: aload 9
        //   45: iload 4
        //   47: invokevirtual 69	android/os/Parcel:writeInt	(I)V
        //   50: aload 9
        //   52: aload 5
        //   54: invokevirtual 44	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   57: iload 6
        //   59: ifeq +62 -> 121
        //   62: iconst_1
        //   63: istore_3
        //   64: aload 9
        //   66: iload_3
        //   67: invokevirtual 69	android/os/Parcel:writeInt	(I)V
        //   70: iload 7
        //   72: ifeq +54 -> 126
        //   75: iload 8
        //   77: istore_3
        //   78: aload 9
        //   80: iload_3
        //   81: invokevirtual 69	android/os/Parcel:writeInt	(I)V
        //   84: aload_0
        //   85: getfield 19	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceCallback$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   88: iconst_1
        //   89: aload 9
        //   91: aload 10
        //   93: iconst_0
        //   94: invokeinterface 54 5 0
        //   99: pop
        //   100: aload 10
        //   102: invokevirtual 57	android/os/Parcel:readException	()V
        //   105: aload 10
        //   107: invokevirtual 60	android/os/Parcel:recycle	()V
        //   110: aload 9
        //   112: invokevirtual 60	android/os/Parcel:recycle	()V
        //   115: ldc 66
        //   117: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   120: return
        //   121: iconst_0
        //   122: istore_3
        //   123: goto -59 -> 64
        //   126: iconst_0
        //   127: istore_3
        //   128: goto -50 -> 78
        //   131: astore_1
        //   132: aload 10
        //   134: invokevirtual 60	android/os/Parcel:recycle	()V
        //   137: aload 9
        //   139: invokevirtual 60	android/os/Parcel:recycle	()V
        //   142: ldc 66
        //   144: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   147: aload_1
        //   148: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	149	0	this	Proxy
        //   0	149	1	paramString1	String
        //   0	149	2	paramString2	String
        //   0	149	3	paramInt1	int
        //   0	149	4	paramInt2	int
        //   0	149	5	paramString3	String
        //   0	149	6	paramBoolean1	boolean
        //   0	149	7	paramBoolean2	boolean
        //   1	75	8	i	int
        //   11	127	9	localParcel1	Parcel
        //   16	117	10	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   18	57	131	finally
        //   64	70	131	finally
        //   78	105	131	finally
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback
 * JD-Core Version:    0.7.0.1
 */