package com.tencent.soter.soterserver;

import android.os.IBinder;
import android.os.Parcel;

final class a$a$a
  implements a
{
  private IBinder mRemote;
  
  a$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  /* Error */
  public final SoterSessionResult E(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 29
    //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 4
    //   19: iload_1
    //   20: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   23: aload 4
    //   25: aload_2
    //   26: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   29: aload 4
    //   31: aload_3
    //   32: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 18	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
    //   39: bipush 9
    //   41: aload 4
    //   43: aload 5
    //   45: iconst_0
    //   46: invokeinterface 46 5 0
    //   51: pop
    //   52: aload 5
    //   54: invokevirtual 49	android/os/Parcel:readException	()V
    //   57: aload 5
    //   59: invokevirtual 53	android/os/Parcel:readInt	()I
    //   62: ifeq +29 -> 91
    //   65: getstatic 59	com/tencent/soter/soterserver/SoterSessionResult:CREATOR	Landroid/os/Parcelable$Creator;
    //   68: aload 5
    //   70: invokeinterface 65 2 0
    //   75: checkcast 55	com/tencent/soter/soterserver/SoterSessionResult
    //   78: astore_2
    //   79: aload 5
    //   81: invokevirtual 68	android/os/Parcel:recycle	()V
    //   84: aload 4
    //   86: invokevirtual 68	android/os/Parcel:recycle	()V
    //   89: aload_2
    //   90: areturn
    //   91: aconst_null
    //   92: astore_2
    //   93: goto -14 -> 79
    //   96: astore_2
    //   97: aload 5
    //   99: invokevirtual 68	android/os/Parcel:recycle	()V
    //   102: aload 4
    //   104: invokevirtual 68	android/os/Parcel:recycle	()V
    //   107: aload_2
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	a
    //   0	109	1	paramInt	int
    //   0	109	2	paramString1	String
    //   0	109	3	paramString2	String
    //   3	100	4	localParcel1	Parcel
    //   8	90	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	79	96	finally
  }
  
  public final int Jn(int paramInt)
  {
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
    }
  }
  
  /* Error */
  public final SoterExportResult Jo(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 29
    //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: iload_1
    //   17: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   20: aload_0
    //   21: getfield 18	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
    //   24: iconst_2
    //   25: aload_3
    //   26: aload 4
    //   28: iconst_0
    //   29: invokeinterface 46 5 0
    //   34: pop
    //   35: aload 4
    //   37: invokevirtual 49	android/os/Parcel:readException	()V
    //   40: aload 4
    //   42: invokevirtual 53	android/os/Parcel:readInt	()I
    //   45: ifeq +28 -> 73
    //   48: getstatic 75	com/tencent/soter/soterserver/SoterExportResult:CREATOR	Landroid/os/Parcelable$Creator;
    //   51: aload 4
    //   53: invokeinterface 65 2 0
    //   58: checkcast 74	com/tencent/soter/soterserver/SoterExportResult
    //   61: astore_2
    //   62: aload 4
    //   64: invokevirtual 68	android/os/Parcel:recycle	()V
    //   67: aload_3
    //   68: invokevirtual 68	android/os/Parcel:recycle	()V
    //   71: aload_2
    //   72: areturn
    //   73: aconst_null
    //   74: astore_2
    //   75: goto -13 -> 62
    //   78: astore_2
    //   79: aload 4
    //   81: invokevirtual 68	android/os/Parcel:recycle	()V
    //   84: aload_3
    //   85: invokevirtual 68	android/os/Parcel:recycle	()V
    //   88: aload_2
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	a
    //   0	90	1	paramInt	int
    //   61	14	2	localSoterExportResult	SoterExportResult
    //   78	11	2	localObject	Object
    //   3	82	3	localParcel1	Parcel
    //   7	73	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	62	78	finally
  }
  
  public final boolean Jp(int paramInt)
  {
    boolean bool = false;
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
    }
  }
  
  public final int Jq(int paramInt)
  {
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
    }
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public final int bl(int paramInt, String paramString)
  {
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
    }
  }
  
  public final int bm(int paramInt, String paramString)
  {
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
    }
  }
  
  /* Error */
  public final SoterExportResult bn(int paramInt, String paramString)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 29
    //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: iload_1
    //   17: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   20: aload_3
    //   21: aload_2
    //   22: invokevirtual 40	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 18	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
    //   29: bipush 6
    //   31: aload_3
    //   32: aload 4
    //   34: iconst_0
    //   35: invokeinterface 46 5 0
    //   40: pop
    //   41: aload 4
    //   43: invokevirtual 49	android/os/Parcel:readException	()V
    //   46: aload 4
    //   48: invokevirtual 53	android/os/Parcel:readInt	()I
    //   51: ifeq +28 -> 79
    //   54: getstatic 75	com/tencent/soter/soterserver/SoterExportResult:CREATOR	Landroid/os/Parcelable$Creator;
    //   57: aload 4
    //   59: invokeinterface 65 2 0
    //   64: checkcast 74	com/tencent/soter/soterserver/SoterExportResult
    //   67: astore_2
    //   68: aload 4
    //   70: invokevirtual 68	android/os/Parcel:recycle	()V
    //   73: aload_3
    //   74: invokevirtual 68	android/os/Parcel:recycle	()V
    //   77: aload_2
    //   78: areturn
    //   79: aconst_null
    //   80: astore_2
    //   81: goto -13 -> 68
    //   84: astore_2
    //   85: aload 4
    //   87: invokevirtual 68	android/os/Parcel:recycle	()V
    //   90: aload_3
    //   91: invokevirtual 68	android/os/Parcel:recycle	()V
    //   94: aload_2
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	a
    //   0	96	1	paramInt	int
    //   0	96	2	paramString	String
    //   3	88	3	localParcel1	Parcel
    //   7	79	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	68	84	finally
  }
  
  public final boolean bo(int paramInt, String paramString)
  {
    boolean bool = false;
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
    }
  }
  
  /* Error */
  public final SoterDeviceResult cPv()
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 29
    //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 18	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
    //   18: bipush 11
    //   20: aload_2
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface 46 5 0
    //   28: pop
    //   29: aload_3
    //   30: invokevirtual 49	android/os/Parcel:readException	()V
    //   33: aload_3
    //   34: invokevirtual 53	android/os/Parcel:readInt	()I
    //   37: ifeq +26 -> 63
    //   40: getstatic 92	com/tencent/soter/soterserver/SoterDeviceResult:CREATOR	Landroid/os/Parcelable$Creator;
    //   43: aload_3
    //   44: invokeinterface 65 2 0
    //   49: checkcast 91	com/tencent/soter/soterserver/SoterDeviceResult
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 68	android/os/Parcel:recycle	()V
    //   57: aload_2
    //   58: invokevirtual 68	android/os/Parcel:recycle	()V
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 68	android/os/Parcel:recycle	()V
    //   73: aload_2
    //   74: invokevirtual 68	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   52	13	1	localSoterDeviceResult	SoterDeviceResult
    //   68	10	1	localObject	Object
    //   3	71	2	localParcel1	Parcel
    //   7	63	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	53	68	finally
  }
  
  public final int getVersion()
  {
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
    }
  }
  
  /* Error */
  public final SoterSignResult io(long paramLong)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 29
    //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 4
    //   19: lload_1
    //   20: invokevirtual 99	android/os/Parcel:writeLong	(J)V
    //   23: aload_0
    //   24: getfield 18	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
    //   27: bipush 10
    //   29: aload 4
    //   31: aload 5
    //   33: iconst_0
    //   34: invokeinterface 46 5 0
    //   39: pop
    //   40: aload 5
    //   42: invokevirtual 49	android/os/Parcel:readException	()V
    //   45: aload 5
    //   47: invokevirtual 53	android/os/Parcel:readInt	()I
    //   50: ifeq +29 -> 79
    //   53: getstatic 102	com/tencent/soter/soterserver/SoterSignResult:CREATOR	Landroid/os/Parcelable$Creator;
    //   56: aload 5
    //   58: invokeinterface 65 2 0
    //   63: checkcast 101	com/tencent/soter/soterserver/SoterSignResult
    //   66: astore_3
    //   67: aload 5
    //   69: invokevirtual 68	android/os/Parcel:recycle	()V
    //   72: aload 4
    //   74: invokevirtual 68	android/os/Parcel:recycle	()V
    //   77: aload_3
    //   78: areturn
    //   79: aconst_null
    //   80: astore_3
    //   81: goto -14 -> 67
    //   84: astore_3
    //   85: aload 5
    //   87: invokevirtual 68	android/os/Parcel:recycle	()V
    //   90: aload 4
    //   92: invokevirtual 68	android/os/Parcel:recycle	()V
    //   95: aload_3
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	a
    //   0	97	1	paramLong	long
    //   66	15	3	localSoterSignResult	SoterSignResult
    //   84	12	3	localObject	Object
    //   3	88	4	localParcel1	Parcel
    //   8	78	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	67	84	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.soter.soterserver.a.a.a
 * JD-Core Version:    0.7.0.1
 */