package org.chromium.base.process_launcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public abstract interface IChildProcessService
  extends IInterface
{
  public abstract boolean bindToCaller();
  
  public abstract void crashIntentionallyForTesting();
  
  public abstract void invokeMiscMethod(String paramString, Bundle paramBundle);
  
  public abstract void setupConnection(Bundle paramBundle, ICallbackInt paramICallbackInt, List<IBinder> paramList);
  
  public static abstract class Stub
    extends Binder
    implements IChildProcessService
  {
    private static final String DESCRIPTOR = "org.chromium.base.process_launcher.IChildProcessService";
    static final int TRANSACTION_bindToCaller = 1;
    static final int TRANSACTION_crashIntentionallyForTesting = 3;
    static final int TRANSACTION_invokeMiscMethod = 4;
    static final int TRANSACTION_setupConnection = 2;
    
    public Stub()
    {
      attachInterface(this, "org.chromium.base.process_launcher.IChildProcessService");
    }
    
    public static IChildProcessService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("org.chromium.base.process_launcher.IChildProcessService");
      if ((localIInterface != null) && ((localIInterface instanceof IChildProcessService))) {
        return (IChildProcessService)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      Object localObject = null;
      String str = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("org.chromium.base.process_launcher.IChildProcessService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("org.chromium.base.process_launcher.IChildProcessService");
        boolean bool = bindToCaller();
        paramParcel2.writeNoException();
        if (bool) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("org.chromium.base.process_launcher.IChildProcessService");
        paramParcel2 = str;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        setupConnection(paramParcel2, ICallbackInt.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.createBinderArrayList());
        return true;
      case 3: 
        paramParcel1.enforceInterface("org.chromium.base.process_launcher.IChildProcessService");
        crashIntentionallyForTesting();
        return true;
      }
      paramParcel1.enforceInterface("org.chromium.base.process_launcher.IChildProcessService");
      str = paramParcel1.readString();
      paramParcel2 = localObject;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      invokeMiscMethod(str, paramParcel2);
      return true;
    }
    
    static class Proxy
      implements IChildProcessService
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
      
      /* Error */
      public boolean bindToCaller()
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: ldc 25
        //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_3
        //   11: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   14: astore 4
        //   16: aload_3
        //   17: ldc 39
        //   19: invokevirtual 43	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload_0
        //   23: getfield 19	org/chromium/base/process_launcher/IChildProcessService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   26: iconst_1
        //   27: aload_3
        //   28: aload 4
        //   30: iconst_0
        //   31: invokeinterface 49 5 0
        //   36: pop
        //   37: aload 4
        //   39: invokevirtual 52	android/os/Parcel:readException	()V
        //   42: aload 4
        //   44: invokevirtual 56	android/os/Parcel:readInt	()I
        //   47: istore_1
        //   48: iload_1
        //   49: ifeq +19 -> 68
        //   52: aload 4
        //   54: invokevirtual 59	android/os/Parcel:recycle	()V
        //   57: aload_3
        //   58: invokevirtual 59	android/os/Parcel:recycle	()V
        //   61: ldc 25
        //   63: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   66: iload_2
        //   67: ireturn
        //   68: iconst_0
        //   69: istore_2
        //   70: goto -18 -> 52
        //   73: astore 5
        //   75: aload 4
        //   77: invokevirtual 59	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: invokevirtual 59	android/os/Parcel:recycle	()V
        //   84: ldc 25
        //   86: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   89: aload 5
        //   91: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	92	0	this	Proxy
        //   47	2	1	i	int
        //   1	69	2	bool	boolean
        //   10	71	3	localParcel1	Parcel
        //   14	62	4	localParcel2	Parcel
        //   73	17	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   16	48	73	finally
      }
      
      public void crashIntentionallyForTesting()
      {
        AppMethodBeat.i(53744);
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("org.chromium.base.process_launcher.IChildProcessService");
          this.mRemote.transact(3, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
          AppMethodBeat.o(53744);
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "org.chromium.base.process_launcher.IChildProcessService";
      }
      
      /* Error */
      public void invokeMiscMethod(String paramString, Bundle paramBundle)
      {
        // Byte code:
        //   0: ldc 69
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload_3
        //   10: ldc 39
        //   12: invokevirtual 43	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: aload_1
        //   17: invokevirtual 72	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   20: aload_2
        //   21: ifnull +38 -> 59
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 75	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 81	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 19	org/chromium/base/process_launcher/IChildProcessService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   39: iconst_4
        //   40: aload_3
        //   41: aconst_null
        //   42: iconst_1
        //   43: invokeinterface 49 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 59	android/os/Parcel:recycle	()V
        //   53: ldc 69
        //   55: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   58: return
        //   59: aload_3
        //   60: iconst_0
        //   61: invokevirtual 75	android/os/Parcel:writeInt	(I)V
        //   64: goto -29 -> 35
        //   67: astore_1
        //   68: aload_3
        //   69: invokevirtual 59	android/os/Parcel:recycle	()V
        //   72: ldc 69
        //   74: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      
      /* Error */
      public void setupConnection(Bundle paramBundle, ICallbackInt paramICallbackInt, List<IBinder> paramList)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: ldc 84
        //   5: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 5
        //   15: ldc 39
        //   17: invokevirtual 43	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +68 -> 89
        //   24: aload 5
        //   26: iconst_1
        //   27: invokevirtual 75	android/os/Parcel:writeInt	(I)V
        //   30: aload_1
        //   31: aload 5
        //   33: iconst_0
        //   34: invokevirtual 81	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   37: aload 4
        //   39: astore_1
        //   40: aload_2
        //   41: ifnull +10 -> 51
        //   44: aload_2
        //   45: invokeinterface 88 1 0
        //   50: astore_1
        //   51: aload 5
        //   53: aload_1
        //   54: invokevirtual 91	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   57: aload 5
        //   59: aload_3
        //   60: invokevirtual 95	android/os/Parcel:writeBinderList	(Ljava/util/List;)V
        //   63: aload_0
        //   64: getfield 19	org/chromium/base/process_launcher/IChildProcessService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   67: iconst_2
        //   68: aload 5
        //   70: aconst_null
        //   71: iconst_1
        //   72: invokeinterface 49 5 0
        //   77: pop
        //   78: aload 5
        //   80: invokevirtual 59	android/os/Parcel:recycle	()V
        //   83: ldc 84
        //   85: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   88: return
        //   89: aload 5
        //   91: iconst_0
        //   92: invokevirtual 75	android/os/Parcel:writeInt	(I)V
        //   95: goto -58 -> 37
        //   98: astore_1
        //   99: aload 5
        //   101: invokevirtual 59	android/os/Parcel:recycle	()V
        //   104: ldc 84
        //   106: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   109: aload_1
        //   110: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	111	0	this	Proxy
        //   0	111	1	paramBundle	Bundle
        //   0	111	2	paramICallbackInt	ICallbackInt
        //   0	111	3	paramList	List<IBinder>
        //   1	37	4	localObject	Object
        //   11	89	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	20	98	finally
        //   24	37	98	finally
        //   44	51	98	finally
        //   51	78	98	finally
        //   89	95	98	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.chromium.base.process_launcher.IChildProcessService
 * JD-Core Version:    0.7.0.1
 */