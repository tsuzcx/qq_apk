package com.tencent.wcdb;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface IContentObserver
  extends IInterface
{
  public abstract void onChange(boolean paramBoolean, Uri paramUri);
  
  public static abstract class Stub
    extends Binder
    implements IContentObserver
  {
    private static final String DESCRIPTOR = "com.tencent.wcdb.IContentObserver";
    static final int TRANSACTION_onChange = 1;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.wcdb.IContentObserver");
    }
    
    public static IContentObserver asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.wcdb.IContentObserver");
      if ((localIInterface != null) && ((localIInterface instanceof IContentObserver))) {
        return (IContentObserver)localIInterface;
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
        paramParcel2.writeString("com.tencent.wcdb.IContentObserver");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.wcdb.IContentObserver");
      boolean bool;
      if (paramParcel1.readInt() != 0)
      {
        bool = true;
        if (paramParcel1.readInt() == 0) {
          break label97;
        }
      }
      label97:
      for (paramParcel1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        onChange(bool, paramParcel1);
        return true;
        bool = false;
        break;
      }
    }
    
    static class Proxy
      implements IContentObserver
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
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.wcdb.IContentObserver";
      }
      
      /* Error */
      public void onChange(boolean paramBoolean, Uri paramUri)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: sipush 2854
        //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: invokestatic 40	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 4
        //   13: aload 4
        //   15: ldc 26
        //   17: invokevirtual 44	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: iload_1
        //   21: ifeq +53 -> 74
        //   24: aload 4
        //   26: iload_3
        //   27: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   30: aload_2
        //   31: ifnull +48 -> 79
        //   34: aload 4
        //   36: iconst_1
        //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   40: aload_2
        //   41: aload 4
        //   43: iconst_0
        //   44: invokevirtual 53	android/net/Uri:writeToParcel	(Landroid/os/Parcel;I)V
        //   47: aload_0
        //   48: getfield 19	com/tencent/wcdb/IContentObserver$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   51: iconst_1
        //   52: aload 4
        //   54: aconst_null
        //   55: iconst_1
        //   56: invokeinterface 59 5 0
        //   61: pop
        //   62: aload 4
        //   64: invokevirtual 62	android/os/Parcel:recycle	()V
        //   67: sipush 2854
        //   70: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   73: return
        //   74: iconst_0
        //   75: istore_3
        //   76: goto -52 -> 24
        //   79: aload 4
        //   81: iconst_0
        //   82: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   85: goto -38 -> 47
        //   88: astore_2
        //   89: aload 4
        //   91: invokevirtual 62	android/os/Parcel:recycle	()V
        //   94: sipush 2854
        //   97: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   100: aload_2
        //   101: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	102	0	this	Proxy
        //   0	102	1	paramBoolean	boolean
        //   0	102	2	paramUri	Uri
        //   1	75	3	i	int
        //   11	79	4	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	20	88	finally
        //   24	30	88	finally
        //   34	47	88	finally
        //   47	62	88	finally
        //   79	85	88	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.IContentObserver
 * JD-Core Version:    0.7.0.1
 */