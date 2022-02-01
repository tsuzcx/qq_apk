package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class c$a
  extends Binder
  implements c
{
  public c$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
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
      z(paramInt1, paramInt2, bool);
      paramParcel2.writeNoException();
      return true;
    }
  }
  
  static final class a
    implements c
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
    public final void z(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 4
      //   3: sipush 29383
      //   6: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   12: astore 5
      //   14: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   17: astore 6
      //   19: aload 5
      //   21: ldc 37
      //   23: invokevirtual 41	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   26: aload 5
      //   28: iload_1
      //   29: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   32: aload 5
      //   34: iload_2
      //   35: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   38: iload_3
      //   39: ifeq +50 -> 89
      //   42: iload 4
      //   44: istore_1
      //   45: aload 5
      //   47: iload_1
      //   48: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   51: aload_0
      //   52: getfield 18	com/tencent/mm/plugin/talkroom/component/c$a$a:mRemote	Landroid/os/IBinder;
      //   55: iconst_1
      //   56: aload 5
      //   58: aload 6
      //   60: iconst_0
      //   61: invokeinterface 50 5 0
      //   66: pop
      //   67: aload 6
      //   69: invokevirtual 53	android/os/Parcel:readException	()V
      //   72: aload 6
      //   74: invokevirtual 56	android/os/Parcel:recycle	()V
      //   77: aload 5
      //   79: invokevirtual 56	android/os/Parcel:recycle	()V
      //   82: sipush 29383
      //   85: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   88: return
      //   89: iconst_0
      //   90: istore_1
      //   91: goto -46 -> 45
      //   94: astore 7
      //   96: aload 6
      //   98: invokevirtual 56	android/os/Parcel:recycle	()V
      //   101: aload 5
      //   103: invokevirtual 56	android/os/Parcel:recycle	()V
      //   106: sipush 29383
      //   109: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   112: aload 7
      //   114: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	115	0	this	a
      //   0	115	1	paramInt1	int
      //   0	115	2	paramInt2	int
      //   0	115	3	paramBoolean	boolean
      //   1	42	4	i	int
      //   12	90	5	localParcel1	Parcel
      //   17	80	6	localParcel2	Parcel
      //   94	19	7	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   19	38	94	finally
      //   45	72	94	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.c.a
 * JD-Core Version:    0.7.0.1
 */