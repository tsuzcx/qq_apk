package com.tencent.soter.soterserver;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a$a
  implements a
{
  private IBinder mRemote;
  
  a$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  /* Error */
  public final SoterSessionResult M(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 22
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 4
    //   10: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore 5
    //   15: aload 4
    //   17: ldc 36
    //   19: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   22: aload 4
    //   24: iload_1
    //   25: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   28: aload 4
    //   30: aload_2
    //   31: invokevirtual 46	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   34: aload 4
    //   36: aload_3
    //   37: invokevirtual 46	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 18	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
    //   44: bipush 9
    //   46: aload 4
    //   48: aload 5
    //   50: iconst_0
    //   51: invokeinterface 52 5 0
    //   56: pop
    //   57: aload 5
    //   59: invokevirtual 55	android/os/Parcel:readException	()V
    //   62: aload 5
    //   64: invokevirtual 59	android/os/Parcel:readInt	()I
    //   67: ifeq +34 -> 101
    //   70: getstatic 65	com/tencent/soter/soterserver/SoterSessionResult:CREATOR	Landroid/os/Parcelable$Creator;
    //   73: aload 5
    //   75: invokeinterface 71 2 0
    //   80: checkcast 61	com/tencent/soter/soterserver/SoterSessionResult
    //   83: astore_2
    //   84: aload 5
    //   86: invokevirtual 74	android/os/Parcel:recycle	()V
    //   89: aload 4
    //   91: invokevirtual 74	android/os/Parcel:recycle	()V
    //   94: ldc 22
    //   96: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_2
    //   100: areturn
    //   101: aconst_null
    //   102: astore_2
    //   103: goto -19 -> 84
    //   106: astore_2
    //   107: aload 5
    //   109: invokevirtual 74	android/os/Parcel:recycle	()V
    //   112: aload 4
    //   114: invokevirtual 74	android/os/Parcel:recycle	()V
    //   117: ldc 22
    //   119: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_2
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	a
    //   0	124	1	paramInt	int
    //   0	124	2	paramString1	String
    //   0	124	3	paramString2	String
    //   8	105	4	localParcel1	Parcel
    //   13	95	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   15	84	106	finally
  }
  
  public final int Sj(int paramInt)
  {
    AppMethodBeat.i(73091);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(73091);
    }
  }
  
  /* Error */
  public final SoterExportResult Sk(int paramInt)
  {
    // Byte code:
    //   0: ldc 83
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore_3
    //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   12: astore 4
    //   14: aload_3
    //   15: ldc 36
    //   17: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_3
    //   21: iload_1
    //   22: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   25: aload_0
    //   26: getfield 18	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
    //   29: iconst_2
    //   30: aload_3
    //   31: aload 4
    //   33: iconst_0
    //   34: invokeinterface 52 5 0
    //   39: pop
    //   40: aload 4
    //   42: invokevirtual 55	android/os/Parcel:readException	()V
    //   45: aload 4
    //   47: invokevirtual 59	android/os/Parcel:readInt	()I
    //   50: ifeq +33 -> 83
    //   53: getstatic 86	com/tencent/soter/soterserver/SoterExportResult:CREATOR	Landroid/os/Parcelable$Creator;
    //   56: aload 4
    //   58: invokeinterface 71 2 0
    //   63: checkcast 85	com/tencent/soter/soterserver/SoterExportResult
    //   66: astore_2
    //   67: aload 4
    //   69: invokevirtual 74	android/os/Parcel:recycle	()V
    //   72: aload_3
    //   73: invokevirtual 74	android/os/Parcel:recycle	()V
    //   76: ldc 83
    //   78: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_2
    //   82: areturn
    //   83: aconst_null
    //   84: astore_2
    //   85: goto -18 -> 67
    //   88: astore_2
    //   89: aload 4
    //   91: invokevirtual 74	android/os/Parcel:recycle	()V
    //   94: aload_3
    //   95: invokevirtual 74	android/os/Parcel:recycle	()V
    //   98: ldc 83
    //   100: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_2
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	a
    //   0	105	1	paramInt	int
    //   66	19	2	localSoterExportResult	SoterExportResult
    //   88	16	2	localObject	Object
    //   8	87	3	localParcel1	Parcel
    //   12	78	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   14	67	88	finally
  }
  
  public final boolean Sl(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(73093);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      if (paramInt != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(73093);
    }
  }
  
  public final int Sm(int paramInt)
  {
    AppMethodBeat.i(73097);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(73097);
    }
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public final int bR(int paramInt, String paramString)
  {
    AppMethodBeat.i(73094);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
      localParcel1.writeInt(paramInt);
      localParcel1.writeString(paramString);
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(73094);
    }
  }
  
  public final int bS(int paramInt, String paramString)
  {
    AppMethodBeat.i(73095);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
      localParcel1.writeInt(paramInt);
      localParcel1.writeString(paramString);
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(73095);
    }
  }
  
  /* Error */
  public final SoterExportResult bT(int paramInt, String paramString)
  {
    // Byte code:
    //   0: ldc 101
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore_3
    //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   12: astore 4
    //   14: aload_3
    //   15: ldc 36
    //   17: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_3
    //   21: iload_1
    //   22: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   25: aload_3
    //   26: aload_2
    //   27: invokevirtual 46	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 18	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
    //   34: bipush 6
    //   36: aload_3
    //   37: aload 4
    //   39: iconst_0
    //   40: invokeinterface 52 5 0
    //   45: pop
    //   46: aload 4
    //   48: invokevirtual 55	android/os/Parcel:readException	()V
    //   51: aload 4
    //   53: invokevirtual 59	android/os/Parcel:readInt	()I
    //   56: ifeq +33 -> 89
    //   59: getstatic 86	com/tencent/soter/soterserver/SoterExportResult:CREATOR	Landroid/os/Parcelable$Creator;
    //   62: aload 4
    //   64: invokeinterface 71 2 0
    //   69: checkcast 85	com/tencent/soter/soterserver/SoterExportResult
    //   72: astore_2
    //   73: aload 4
    //   75: invokevirtual 74	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: invokevirtual 74	android/os/Parcel:recycle	()V
    //   82: ldc 101
    //   84: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_2
    //   88: areturn
    //   89: aconst_null
    //   90: astore_2
    //   91: goto -18 -> 73
    //   94: astore_2
    //   95: aload 4
    //   97: invokevirtual 74	android/os/Parcel:recycle	()V
    //   100: aload_3
    //   101: invokevirtual 74	android/os/Parcel:recycle	()V
    //   104: ldc 101
    //   106: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_2
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	a
    //   0	111	1	paramInt	int
    //   0	111	2	paramString	String
    //   8	93	3	localParcel1	Parcel
    //   12	84	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   14	73	94	finally
  }
  
  public final boolean bU(int paramInt, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(73098);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
      localParcel1.writeInt(paramInt);
      localParcel1.writeString(paramString);
      this.mRemote.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      if (paramInt != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(73098);
    }
  }
  
  /* Error */
  public final SoterDeviceResult dVr()
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore_2
    //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   12: astore_3
    //   13: aload_2
    //   14: ldc 36
    //   16: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 18	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
    //   23: bipush 11
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: invokeinterface 52 5 0
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual 55	android/os/Parcel:readException	()V
    //   38: aload_3
    //   39: invokevirtual 59	android/os/Parcel:readInt	()I
    //   42: ifeq +31 -> 73
    //   45: getstatic 110	com/tencent/soter/soterserver/SoterDeviceResult:CREATOR	Landroid/os/Parcelable$Creator;
    //   48: aload_3
    //   49: invokeinterface 71 2 0
    //   54: checkcast 109	com/tencent/soter/soterserver/SoterDeviceResult
    //   57: astore_1
    //   58: aload_3
    //   59: invokevirtual 74	android/os/Parcel:recycle	()V
    //   62: aload_2
    //   63: invokevirtual 74	android/os/Parcel:recycle	()V
    //   66: ldc 107
    //   68: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_1
    //   72: areturn
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -17 -> 58
    //   78: astore_1
    //   79: aload_3
    //   80: invokevirtual 74	android/os/Parcel:recycle	()V
    //   83: aload_2
    //   84: invokevirtual 74	android/os/Parcel:recycle	()V
    //   87: ldc 107
    //   89: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	a
    //   57	18	1	localSoterDeviceResult	SoterDeviceResult
    //   78	15	1	localObject	Object
    //   8	76	2	localParcel1	Parcel
    //   12	68	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	58	78	finally
  }
  
  public final int getVersion()
  {
    AppMethodBeat.i(73102);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
      this.mRemote.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(73102);
    }
  }
  
  /* Error */
  public final SoterSignResult pa(long paramLong)
  {
    // Byte code:
    //   0: ldc 115
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 4
    //   10: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore 5
    //   15: aload 4
    //   17: ldc 36
    //   19: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   22: aload 4
    //   24: lload_1
    //   25: invokevirtual 119	android/os/Parcel:writeLong	(J)V
    //   28: aload_0
    //   29: getfield 18	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
    //   32: bipush 10
    //   34: aload 4
    //   36: aload 5
    //   38: iconst_0
    //   39: invokeinterface 52 5 0
    //   44: pop
    //   45: aload 5
    //   47: invokevirtual 55	android/os/Parcel:readException	()V
    //   50: aload 5
    //   52: invokevirtual 59	android/os/Parcel:readInt	()I
    //   55: ifeq +34 -> 89
    //   58: getstatic 122	com/tencent/soter/soterserver/SoterSignResult:CREATOR	Landroid/os/Parcelable$Creator;
    //   61: aload 5
    //   63: invokeinterface 71 2 0
    //   68: checkcast 121	com/tencent/soter/soterserver/SoterSignResult
    //   71: astore_3
    //   72: aload 5
    //   74: invokevirtual 74	android/os/Parcel:recycle	()V
    //   77: aload 4
    //   79: invokevirtual 74	android/os/Parcel:recycle	()V
    //   82: ldc 115
    //   84: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_3
    //   88: areturn
    //   89: aconst_null
    //   90: astore_3
    //   91: goto -19 -> 72
    //   94: astore_3
    //   95: aload 5
    //   97: invokevirtual 74	android/os/Parcel:recycle	()V
    //   100: aload 4
    //   102: invokevirtual 74	android/os/Parcel:recycle	()V
    //   105: ldc 115
    //   107: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_3
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	a
    //   0	112	1	paramLong	long
    //   71	20	3	localSoterSignResult	SoterSignResult
    //   94	17	3	localObject	Object
    //   8	93	4	localParcel1	Parcel
    //   13	83	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   15	72	94	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.soter.soterserver.a.a.a
 * JD-Core Version:    0.7.0.1
 */