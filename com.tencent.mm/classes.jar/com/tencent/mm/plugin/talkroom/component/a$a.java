package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class a$a
  extends Binder
  implements a
{
  public a$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
  }
  
  public static a C(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
    if ((localIInterface != null) && ((localIInterface instanceof a))) {
      return (a)localIInterface;
    }
    return new a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      paramInt1 = ebh();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      paramInt1 = uninitLive();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      localObject = paramParcel1.readStrongBinder();
      if (localObject == null) {
        localObject = null;
      }
      for (;;)
      {
        paramInt1 = a((b)localObject, paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readLong(), paramParcel1.createIntArray(), paramParcel1.createIntArray(), paramParcel1.readInt(), paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
        IInterface localIInterface = ((IBinder)localObject).queryLocalInterface("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
        if ((localIInterface != null) && ((localIInterface instanceof b))) {
          localObject = (b)localIInterface;
        } else {
          localObject = new b.a.a((IBinder)localObject);
        }
      }
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      paramInt1 = SetCurrentMicId(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      paramInt1 = Close();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      paramInt1 = paramParcel1.readInt();
      if (paramInt1 < 0) {}
      for (localObject = null;; localObject = new int[paramInt1])
      {
        paramParcel1 = d((int[])localObject, paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        paramParcel2.writeIntArray((int[])localObject);
        return true;
      }
    case 7: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = null;
        paramParcel1 = a(paramParcel1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label455;
        }
      }
      label455:
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
        localObject = paramParcel1.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
        if ((localObject != null) && ((localObject instanceof c)))
        {
          paramParcel1 = (c)localObject;
          break;
        }
        paramParcel1 = new c.a.a(paramParcel1);
        break;
      }
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
    paramParcel1 = ebi();
    paramParcel2.writeNoException();
    if (paramParcel1 != null) {}
    for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
    {
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
  }
  
  static final class a
    implements a
  {
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final int Close()
    {
      AppMethodBeat.i(29377);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
        this.mRemote.transact(5, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(29377);
      }
    }
    
    public final int SetCurrentMicId(int paramInt)
    {
      AppMethodBeat.i(29376);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
        localParcel1.writeInt(paramInt);
        this.mRemote.transact(4, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramInt = localParcel2.readInt();
        return paramInt;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(29376);
      }
    }
    
    /* Error */
    public final int a(b paramb, int paramInt1, int paramInt2, int paramInt3, long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt4, java.lang.String[] paramArrayOfString)
    {
      // Byte code:
      //   0: sipush 29375
      //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   9: astore 11
      //   11: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   14: astore 12
      //   16: aload 11
      //   18: ldc 35
      //   20: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   23: aload_1
      //   24: ifnull +115 -> 139
      //   27: aload_1
      //   28: invokeinterface 69 1 0
      //   33: astore_1
      //   34: aload 11
      //   36: aload_1
      //   37: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   40: aload 11
      //   42: iload_2
      //   43: invokevirtual 62	android/os/Parcel:writeInt	(I)V
      //   46: aload 11
      //   48: iload_3
      //   49: invokevirtual 62	android/os/Parcel:writeInt	(I)V
      //   52: aload 11
      //   54: iload 4
      //   56: invokevirtual 62	android/os/Parcel:writeInt	(I)V
      //   59: aload 11
      //   61: lload 5
      //   63: invokevirtual 76	android/os/Parcel:writeLong	(J)V
      //   66: aload 11
      //   68: aload 7
      //   70: invokevirtual 80	android/os/Parcel:writeIntArray	([I)V
      //   73: aload 11
      //   75: aload 8
      //   77: invokevirtual 80	android/os/Parcel:writeIntArray	([I)V
      //   80: aload 11
      //   82: iload 9
      //   84: invokevirtual 62	android/os/Parcel:writeInt	(I)V
      //   87: aload 11
      //   89: aload 10
      //   91: invokevirtual 84	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
      //   94: aload_0
      //   95: getfield 18	com/tencent/mm/plugin/talkroom/component/a$a$a:mRemote	Landroid/os/IBinder;
      //   98: iconst_3
      //   99: aload 11
      //   101: aload 12
      //   103: iconst_0
      //   104: invokeinterface 45 5 0
      //   109: pop
      //   110: aload 12
      //   112: invokevirtual 48	android/os/Parcel:readException	()V
      //   115: aload 12
      //   117: invokevirtual 51	android/os/Parcel:readInt	()I
      //   120: istore_2
      //   121: aload 12
      //   123: invokevirtual 54	android/os/Parcel:recycle	()V
      //   126: aload 11
      //   128: invokevirtual 54	android/os/Parcel:recycle	()V
      //   131: sipush 29375
      //   134: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   137: iload_2
      //   138: ireturn
      //   139: aconst_null
      //   140: astore_1
      //   141: goto -107 -> 34
      //   144: astore_1
      //   145: aload 12
      //   147: invokevirtual 54	android/os/Parcel:recycle	()V
      //   150: aload 11
      //   152: invokevirtual 54	android/os/Parcel:recycle	()V
      //   155: sipush 29375
      //   158: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   161: aload_1
      //   162: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	163	0	this	a
      //   0	163	1	paramb	b
      //   0	163	2	paramInt1	int
      //   0	163	3	paramInt2	int
      //   0	163	4	paramInt3	int
      //   0	163	5	paramLong	long
      //   0	163	7	paramArrayOfInt1	int[]
      //   0	163	8	paramArrayOfInt2	int[]
      //   0	163	9	paramInt4	int
      //   0	163	10	paramArrayOfString	java.lang.String[]
      //   9	142	11	localParcel1	Parcel
      //   14	132	12	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   16	23	144	finally
      //   27	34	144	finally
      //   34	121	144	finally
    }
    
    /* Error */
    public final e a(c paramc)
    {
      // Byte code:
      //   0: sipush 29379
      //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   9: astore_2
      //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   13: astore_3
      //   14: aload_2
      //   15: ldc 35
      //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   20: aload_1
      //   21: ifnull +58 -> 79
      //   24: aload_1
      //   25: invokeinterface 88 1 0
      //   30: astore_1
      //   31: aload_2
      //   32: aload_1
      //   33: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   36: aload_0
      //   37: getfield 18	com/tencent/mm/plugin/talkroom/component/a$a$a:mRemote	Landroid/os/IBinder;
      //   40: bipush 7
      //   42: aload_2
      //   43: aload_3
      //   44: iconst_0
      //   45: invokeinterface 45 5 0
      //   50: pop
      //   51: aload_3
      //   52: invokevirtual 48	android/os/Parcel:readException	()V
      //   55: aload_3
      //   56: invokevirtual 91	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
      //   59: invokestatic 97	com/tencent/mm/plugin/talkroom/component/e$a:E	(Landroid/os/IBinder;)Lcom/tencent/mm/plugin/talkroom/component/e;
      //   62: astore_1
      //   63: aload_3
      //   64: invokevirtual 54	android/os/Parcel:recycle	()V
      //   67: aload_2
      //   68: invokevirtual 54	android/os/Parcel:recycle	()V
      //   71: sipush 29379
      //   74: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   77: aload_1
      //   78: areturn
      //   79: aconst_null
      //   80: astore_1
      //   81: goto -50 -> 31
      //   84: astore_1
      //   85: aload_3
      //   86: invokevirtual 54	android/os/Parcel:recycle	()V
      //   89: aload_2
      //   90: invokevirtual 54	android/os/Parcel:recycle	()V
      //   93: sipush 29379
      //   96: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   99: aload_1
      //   100: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	this	a
      //   0	101	1	paramc	c
      //   9	81	2	localParcel1	Parcel
      //   13	73	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   14	20	84	finally
      //   24	31	84	finally
      //   31	63	84	finally
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    /* Error */
    public final byte[] d(int[] paramArrayOfInt, java.lang.String paramString)
    {
      // Byte code:
      //   0: sipush 29378
      //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   9: astore_3
      //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   13: astore 4
      //   15: aload_3
      //   16: ldc 35
      //   18: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   21: aload_1
      //   22: ifnonnull +63 -> 85
      //   25: aload_3
      //   26: iconst_m1
      //   27: invokevirtual 62	android/os/Parcel:writeInt	(I)V
      //   30: aload_3
      //   31: aload_2
      //   32: invokevirtual 102	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   35: aload_0
      //   36: getfield 18	com/tencent/mm/plugin/talkroom/component/a$a$a:mRemote	Landroid/os/IBinder;
      //   39: bipush 6
      //   41: aload_3
      //   42: aload 4
      //   44: iconst_0
      //   45: invokeinterface 45 5 0
      //   50: pop
      //   51: aload 4
      //   53: invokevirtual 48	android/os/Parcel:readException	()V
      //   56: aload 4
      //   58: invokevirtual 106	android/os/Parcel:createByteArray	()[B
      //   61: astore_2
      //   62: aload 4
      //   64: aload_1
      //   65: invokevirtual 109	android/os/Parcel:readIntArray	([I)V
      //   68: aload 4
      //   70: invokevirtual 54	android/os/Parcel:recycle	()V
      //   73: aload_3
      //   74: invokevirtual 54	android/os/Parcel:recycle	()V
      //   77: sipush 29378
      //   80: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   83: aload_2
      //   84: areturn
      //   85: aload_3
      //   86: aload_1
      //   87: arraylength
      //   88: invokevirtual 62	android/os/Parcel:writeInt	(I)V
      //   91: goto -61 -> 30
      //   94: astore_1
      //   95: aload 4
      //   97: invokevirtual 54	android/os/Parcel:recycle	()V
      //   100: aload_3
      //   101: invokevirtual 54	android/os/Parcel:recycle	()V
      //   104: sipush 29378
      //   107: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   110: aload_1
      //   111: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	112	0	this	a
      //   0	112	1	paramArrayOfInt	int[]
      //   0	112	2	paramString	java.lang.String
      //   9	92	3	localParcel1	Parcel
      //   13	83	4	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   15	21	94	finally
      //   25	30	94	finally
      //   30	68	94	finally
      //   85	91	94	finally
    }
    
    public final int ebh()
    {
      AppMethodBeat.i(29373);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
        this.mRemote.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(29373);
      }
    }
    
    public final d ebi()
    {
      AppMethodBeat.i(29380);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
        this.mRemote.transact(8, localParcel1, localParcel2, 0);
        localParcel2.readException();
        d locald = d.a.D(localParcel2.readStrongBinder());
        return locald;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(29380);
      }
    }
    
    public final int uninitLive()
    {
      AppMethodBeat.i(29374);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
        this.mRemote.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(29374);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.a.a
 * JD-Core Version:    0.7.0.1
 */