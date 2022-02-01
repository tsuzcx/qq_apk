package org.chromium.content.common;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.chromium.base.UnguessableToken;

public abstract interface IGpuProcessCallback
  extends IInterface
{
  public abstract void forwardSurfaceForSurfaceRequest(UnguessableToken paramUnguessableToken, Surface paramSurface);
  
  public abstract SurfaceWrapper getViewSurface(int paramInt);
  
  public abstract void invokeMiscMethod(String paramString, Bundle paramBundle);
  
  public static abstract class Stub
    extends Binder
    implements IGpuProcessCallback
  {
    private static final String DESCRIPTOR = "org.chromium.content.common.IGpuProcessCallback";
    static final int TRANSACTION_forwardSurfaceForSurfaceRequest = 1;
    static final int TRANSACTION_getViewSurface = 2;
    static final int TRANSACTION_invokeMiscMethod = 3;
    
    public Stub()
    {
      attachInterface(this, "org.chromium.content.common.IGpuProcessCallback");
    }
    
    public static IGpuProcessCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("org.chromium.content.common.IGpuProcessCallback");
      if ((localIInterface != null) && ((localIInterface instanceof IGpuProcessCallback))) {
        return (IGpuProcessCallback)localIInterface;
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
        paramParcel2.writeString("org.chromium.content.common.IGpuProcessCallback");
        return true;
      case 1: 
        paramParcel1.enforceInterface("org.chromium.content.common.IGpuProcessCallback");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = (UnguessableToken)UnguessableToken.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label121;
          }
        }
        for (paramParcel1 = (Surface)Surface.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          forwardSurfaceForSurfaceRequest(paramParcel2, paramParcel1);
          return true;
          paramParcel2 = null;
          break;
        }
      case 2: 
        label121:
        paramParcel1.enforceInterface("org.chromium.content.common.IGpuProcessCallback");
        paramParcel1 = getViewSurface(paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      }
      paramParcel1.enforceInterface("org.chromium.content.common.IGpuProcessCallback");
      paramParcel2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        invokeMiscMethod(paramParcel2, paramParcel1);
        return true;
      }
    }
    
    static class Proxy
      implements IGpuProcessCallback
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
      
      public void forwardSurfaceForSurfaceRequest(UnguessableToken paramUnguessableToken, Surface paramSurface)
      {
        AppMethodBeat.i(53752);
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("org.chromium.content.common.IGpuProcessCallback");
            if (paramUnguessableToken != null)
            {
              localParcel.writeInt(1);
              paramUnguessableToken.writeToParcel(localParcel, 0);
              if (paramSurface != null)
              {
                localParcel.writeInt(1);
                paramSurface.writeToParcel(localParcel, 0);
                this.mRemote.transact(1, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
            AppMethodBeat.o(53752);
          }
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "org.chromium.content.common.IGpuProcessCallback";
      }
      
      /* Error */
      public SurfaceWrapper getViewSurface(int paramInt)
      {
        // Byte code:
        //   0: ldc 72
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 39
        //   17: invokevirtual 43	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: iload_1
        //   22: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   25: aload_0
        //   26: getfield 19	org/chromium/content/common/IGpuProcessCallback$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   29: iconst_2
        //   30: aload_3
        //   31: aload 4
        //   33: iconst_0
        //   34: invokeinterface 61 5 0
        //   39: pop
        //   40: aload 4
        //   42: invokevirtual 75	android/os/Parcel:readException	()V
        //   45: aload 4
        //   47: invokevirtual 79	android/os/Parcel:readInt	()I
        //   50: ifeq +33 -> 83
        //   53: getstatic 85	org/chromium/content/common/SurfaceWrapper:CREATOR	Landroid/os/Parcelable$Creator;
        //   56: aload 4
        //   58: invokeinterface 91 2 0
        //   63: checkcast 81	org/chromium/content/common/SurfaceWrapper
        //   66: astore_2
        //   67: aload 4
        //   69: invokevirtual 64	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 64	android/os/Parcel:recycle	()V
        //   76: ldc 72
        //   78: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   81: aload_2
        //   82: areturn
        //   83: aconst_null
        //   84: astore_2
        //   85: goto -18 -> 67
        //   88: astore_2
        //   89: aload 4
        //   91: invokevirtual 64	android/os/Parcel:recycle	()V
        //   94: aload_3
        //   95: invokevirtual 64	android/os/Parcel:recycle	()V
        //   98: ldc 72
        //   100: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   103: aload_2
        //   104: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	105	0	this	Proxy
        //   0	105	1	paramInt	int
        //   66	19	2	localSurfaceWrapper	SurfaceWrapper
        //   88	16	2	localObject	Object
        //   8	87	3	localParcel1	Parcel
        //   12	78	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	67	88	finally
      }
      
      /* Error */
      public void invokeMiscMethod(String paramString, Bundle paramBundle)
      {
        // Byte code:
        //   0: ldc 94
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload_3
        //   10: ldc 39
        //   12: invokevirtual 43	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: aload_1
        //   17: invokevirtual 97	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   20: aload_2
        //   21: ifnull +38 -> 59
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 100	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 19	org/chromium/content/common/IGpuProcessCallback$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   39: iconst_3
        //   40: aload_3
        //   41: aconst_null
        //   42: iconst_1
        //   43: invokeinterface 61 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 64	android/os/Parcel:recycle	()V
        //   53: ldc 94
        //   55: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   58: return
        //   59: aload_3
        //   60: iconst_0
        //   61: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   64: goto -29 -> 35
        //   67: astore_1
        //   68: aload_3
        //   69: invokevirtual 64	android/os/Parcel:recycle	()V
        //   72: ldc 94
        //   74: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.chromium.content.common.IGpuProcessCallback
 * JD-Core Version:    0.7.0.1
 */