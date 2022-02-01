package com.tencent.soter.soterserver;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
  extends IInterface
{
  public abstract SoterSignResult Bf(long paramLong);
  
  public abstract int aHf(int paramInt);
  
  public abstract SoterExportResult aHg(int paramInt);
  
  public abstract boolean aHh(int paramInt);
  
  public abstract int aHi(int paramInt);
  
  public abstract SoterSessionResult ai(int paramInt, String paramString1, String paramString2);
  
  public abstract int en(int paramInt, String paramString);
  
  public abstract int eo(int paramInt, String paramString);
  
  public abstract SoterExportResult ep(int paramInt, String paramString);
  
  public abstract boolean eq(int paramInt, String paramString);
  
  public abstract int getVersion();
  
  public abstract SoterDeviceResult jYn();
  
  public static abstract class a
    extends Binder
    implements a
  {
    public static a Z(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.soter.soterserver.ISoterService");
      if ((localIInterface != null) && ((localIInterface instanceof a))) {
        return (a)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static a jYo()
    {
      return a.ahxF;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      int j = 0;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.soter.soterserver.ISoterService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramInt1 = aHf(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramParcel1 = aHg(paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        bool = aHh(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramInt1 = en(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramInt1 = eo(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramParcel1 = ep(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramInt1 = aHi(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        bool = eq(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramParcel1 = ai(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramParcel1 = Bf(paramParcel1.readLong());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramParcel1 = jYn();
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
      paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
      paramInt1 = getVersion();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    static final class a
      implements a
    {
      public static a ahxF;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public final SoterSignResult Bf(long paramLong)
      {
        // Byte code:
        //   0: ldc 24
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 4
        //   10: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 5
        //   15: aload 4
        //   17: ldc 38
        //   19: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload 4
        //   24: lload_1
        //   25: invokevirtual 46	android/os/Parcel:writeLong	(J)V
        //   28: aload_0
        //   29: getfield 20	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
        //   32: bipush 10
        //   34: aload 4
        //   36: aload 5
        //   38: iconst_0
        //   39: invokeinterface 52 5 0
        //   44: ifne +36 -> 80
        //   47: invokestatic 56	com/tencent/soter/soterserver/a$a:jYo	()Lcom/tencent/soter/soterserver/a;
        //   50: ifnull +30 -> 80
        //   53: invokestatic 56	com/tencent/soter/soterserver/a$a:jYo	()Lcom/tencent/soter/soterserver/a;
        //   56: lload_1
        //   57: invokeinterface 58 3 0
        //   62: astore_3
        //   63: aload 5
        //   65: invokevirtual 61	android/os/Parcel:recycle	()V
        //   68: aload 4
        //   70: invokevirtual 61	android/os/Parcel:recycle	()V
        //   73: ldc 24
        //   75: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   78: aload_3
        //   79: areturn
        //   80: aload 5
        //   82: invokevirtual 67	android/os/Parcel:readException	()V
        //   85: aload 5
        //   87: invokevirtual 71	android/os/Parcel:readInt	()I
        //   90: ifeq +34 -> 124
        //   93: getstatic 77	com/tencent/soter/soterserver/SoterSignResult:CREATOR	Landroid/os/Parcelable$Creator;
        //   96: aload 5
        //   98: invokeinterface 83 2 0
        //   103: checkcast 73	com/tencent/soter/soterserver/SoterSignResult
        //   106: astore_3
        //   107: aload 5
        //   109: invokevirtual 61	android/os/Parcel:recycle	()V
        //   112: aload 4
        //   114: invokevirtual 61	android/os/Parcel:recycle	()V
        //   117: ldc 24
        //   119: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   122: aload_3
        //   123: areturn
        //   124: aconst_null
        //   125: astore_3
        //   126: goto -19 -> 107
        //   129: astore_3
        //   130: aload 5
        //   132: invokevirtual 61	android/os/Parcel:recycle	()V
        //   135: aload 4
        //   137: invokevirtual 61	android/os/Parcel:recycle	()V
        //   140: ldc 24
        //   142: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   145: aload_3
        //   146: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	147	0	this	a
        //   0	147	1	paramLong	long
        //   62	64	3	localSoterSignResult	SoterSignResult
        //   129	17	3	localObject	Object
        //   8	128	4	localParcel1	Parcel
        //   13	118	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	63	129	finally
        //   80	107	129	finally
      }
      
      public final int aHf(int paramInt)
      {
        AppMethodBeat.i(88727);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (a.a.jYo() != null))
          {
            paramInt = a.a.jYo().aHf(paramInt);
            return paramInt;
          }
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(88727);
        }
      }
      
      /* Error */
      public final SoterExportResult aHg(int paramInt)
      {
        // Byte code:
        //   0: ldc 94
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 38
        //   17: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: iload_1
        //   22: invokevirtual 89	android/os/Parcel:writeInt	(I)V
        //   25: aload_0
        //   26: getfield 20	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
        //   29: iconst_2
        //   30: aload_3
        //   31: aload 4
        //   33: iconst_0
        //   34: invokeinterface 52 5 0
        //   39: ifne +35 -> 74
        //   42: invokestatic 56	com/tencent/soter/soterserver/a$a:jYo	()Lcom/tencent/soter/soterserver/a;
        //   45: ifnull +29 -> 74
        //   48: invokestatic 56	com/tencent/soter/soterserver/a$a:jYo	()Lcom/tencent/soter/soterserver/a;
        //   51: iload_1
        //   52: invokeinterface 96 2 0
        //   57: astore_2
        //   58: aload 4
        //   60: invokevirtual 61	android/os/Parcel:recycle	()V
        //   63: aload_3
        //   64: invokevirtual 61	android/os/Parcel:recycle	()V
        //   67: ldc 94
        //   69: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   72: aload_2
        //   73: areturn
        //   74: aload 4
        //   76: invokevirtual 67	android/os/Parcel:readException	()V
        //   79: aload 4
        //   81: invokevirtual 71	android/os/Parcel:readInt	()I
        //   84: ifeq +33 -> 117
        //   87: getstatic 99	com/tencent/soter/soterserver/SoterExportResult:CREATOR	Landroid/os/Parcelable$Creator;
        //   90: aload 4
        //   92: invokeinterface 83 2 0
        //   97: checkcast 98	com/tencent/soter/soterserver/SoterExportResult
        //   100: astore_2
        //   101: aload 4
        //   103: invokevirtual 61	android/os/Parcel:recycle	()V
        //   106: aload_3
        //   107: invokevirtual 61	android/os/Parcel:recycle	()V
        //   110: ldc 94
        //   112: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   115: aload_2
        //   116: areturn
        //   117: aconst_null
        //   118: astore_2
        //   119: goto -18 -> 101
        //   122: astore_2
        //   123: aload 4
        //   125: invokevirtual 61	android/os/Parcel:recycle	()V
        //   128: aload_3
        //   129: invokevirtual 61	android/os/Parcel:recycle	()V
        //   132: ldc 94
        //   134: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   137: aload_2
        //   138: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	139	0	this	a
        //   0	139	1	paramInt	int
        //   57	62	2	localSoterExportResult	SoterExportResult
        //   122	16	2	localObject	Object
        //   8	121	3	localParcel1	Parcel
        //   12	112	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	58	122	finally
        //   74	101	122	finally
      }
      
      public final boolean aHh(int paramInt)
      {
        boolean bool = false;
        AppMethodBeat.i(88729);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (a.a.jYo() != null))
          {
            bool = a.a.jYo().aHh(paramInt);
            return bool;
          }
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
          AppMethodBeat.o(88729);
        }
      }
      
      public final int aHi(int paramInt)
      {
        AppMethodBeat.i(88733);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (a.a.jYo() != null))
          {
            paramInt = a.a.jYo().aHi(paramInt);
            return paramInt;
          }
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(88733);
        }
      }
      
      /* Error */
      public final SoterSessionResult ai(int paramInt, String paramString1, String paramString2)
      {
        // Byte code:
        //   0: ldc 111
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 4
        //   10: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 5
        //   15: aload 4
        //   17: ldc 38
        //   19: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload 4
        //   24: iload_1
        //   25: invokevirtual 89	android/os/Parcel:writeInt	(I)V
        //   28: aload 4
        //   30: aload_2
        //   31: invokevirtual 114	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   34: aload 4
        //   36: aload_3
        //   37: invokevirtual 114	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   40: aload_0
        //   41: getfield 20	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
        //   44: bipush 9
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 52 5 0
        //   56: ifne +38 -> 94
        //   59: invokestatic 56	com/tencent/soter/soterserver/a$a:jYo	()Lcom/tencent/soter/soterserver/a;
        //   62: ifnull +32 -> 94
        //   65: invokestatic 56	com/tencent/soter/soterserver/a$a:jYo	()Lcom/tencent/soter/soterserver/a;
        //   68: iload_1
        //   69: aload_2
        //   70: aload_3
        //   71: invokeinterface 116 4 0
        //   76: astore_2
        //   77: aload 5
        //   79: invokevirtual 61	android/os/Parcel:recycle	()V
        //   82: aload 4
        //   84: invokevirtual 61	android/os/Parcel:recycle	()V
        //   87: ldc 111
        //   89: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   92: aload_2
        //   93: areturn
        //   94: aload 5
        //   96: invokevirtual 67	android/os/Parcel:readException	()V
        //   99: aload 5
        //   101: invokevirtual 71	android/os/Parcel:readInt	()I
        //   104: ifeq +34 -> 138
        //   107: getstatic 119	com/tencent/soter/soterserver/SoterSessionResult:CREATOR	Landroid/os/Parcelable$Creator;
        //   110: aload 5
        //   112: invokeinterface 83 2 0
        //   117: checkcast 118	com/tencent/soter/soterserver/SoterSessionResult
        //   120: astore_2
        //   121: aload 5
        //   123: invokevirtual 61	android/os/Parcel:recycle	()V
        //   126: aload 4
        //   128: invokevirtual 61	android/os/Parcel:recycle	()V
        //   131: ldc 111
        //   133: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   136: aload_2
        //   137: areturn
        //   138: aconst_null
        //   139: astore_2
        //   140: goto -19 -> 121
        //   143: astore_2
        //   144: aload 5
        //   146: invokevirtual 61	android/os/Parcel:recycle	()V
        //   149: aload 4
        //   151: invokevirtual 61	android/os/Parcel:recycle	()V
        //   154: ldc 111
        //   156: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   159: aload_2
        //   160: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	161	0	this	a
        //   0	161	1	paramInt	int
        //   0	161	2	paramString1	String
        //   0	161	3	paramString2	String
        //   8	142	4	localParcel1	Parcel
        //   13	132	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	77	143	finally
        //   94	121	143	finally
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final int en(int paramInt, String paramString)
      {
        AppMethodBeat.i(88730);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (a.a.jYo() != null))
          {
            paramInt = a.a.jYo().en(paramInt, paramString);
            return paramInt;
          }
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(88730);
        }
      }
      
      public final int eo(int paramInt, String paramString)
      {
        AppMethodBeat.i(88731);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (a.a.jYo() != null))
          {
            paramInt = a.a.jYo().eo(paramInt, paramString);
            return paramInt;
          }
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(88731);
        }
      }
      
      /* Error */
      public final SoterExportResult ep(int paramInt, String paramString)
      {
        // Byte code:
        //   0: ldc 133
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 38
        //   17: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: iload_1
        //   22: invokevirtual 89	android/os/Parcel:writeInt	(I)V
        //   25: aload_3
        //   26: aload_2
        //   27: invokevirtual 114	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   30: aload_0
        //   31: getfield 20	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
        //   34: bipush 6
        //   36: aload_3
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 52 5 0
        //   45: ifne +36 -> 81
        //   48: invokestatic 56	com/tencent/soter/soterserver/a$a:jYo	()Lcom/tencent/soter/soterserver/a;
        //   51: ifnull +30 -> 81
        //   54: invokestatic 56	com/tencent/soter/soterserver/a$a:jYo	()Lcom/tencent/soter/soterserver/a;
        //   57: iload_1
        //   58: aload_2
        //   59: invokeinterface 135 3 0
        //   64: astore_2
        //   65: aload 4
        //   67: invokevirtual 61	android/os/Parcel:recycle	()V
        //   70: aload_3
        //   71: invokevirtual 61	android/os/Parcel:recycle	()V
        //   74: ldc 133
        //   76: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   79: aload_2
        //   80: areturn
        //   81: aload 4
        //   83: invokevirtual 67	android/os/Parcel:readException	()V
        //   86: aload 4
        //   88: invokevirtual 71	android/os/Parcel:readInt	()I
        //   91: ifeq +33 -> 124
        //   94: getstatic 99	com/tencent/soter/soterserver/SoterExportResult:CREATOR	Landroid/os/Parcelable$Creator;
        //   97: aload 4
        //   99: invokeinterface 83 2 0
        //   104: checkcast 98	com/tencent/soter/soterserver/SoterExportResult
        //   107: astore_2
        //   108: aload 4
        //   110: invokevirtual 61	android/os/Parcel:recycle	()V
        //   113: aload_3
        //   114: invokevirtual 61	android/os/Parcel:recycle	()V
        //   117: ldc 133
        //   119: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   122: aload_2
        //   123: areturn
        //   124: aconst_null
        //   125: astore_2
        //   126: goto -18 -> 108
        //   129: astore_2
        //   130: aload 4
        //   132: invokevirtual 61	android/os/Parcel:recycle	()V
        //   135: aload_3
        //   136: invokevirtual 61	android/os/Parcel:recycle	()V
        //   139: ldc 133
        //   141: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   144: aload_2
        //   145: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	a
        //   0	146	1	paramInt	int
        //   0	146	2	paramString	String
        //   8	128	3	localParcel1	Parcel
        //   12	119	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	65	129	finally
        //   81	108	129	finally
      }
      
      public final boolean eq(int paramInt, String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(88734);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (a.a.jYo() != null))
          {
            bool = a.a.jYo().eq(paramInt, paramString);
            return bool;
          }
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
          AppMethodBeat.o(88734);
        }
      }
      
      public final int getVersion()
      {
        AppMethodBeat.i(88738);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
          if ((!this.mRemote.transact(12, localParcel1, localParcel2, 0)) && (a.a.jYo() != null))
          {
            i = a.a.jYo().getVersion();
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
          AppMethodBeat.o(88738);
        }
      }
      
      /* Error */
      public final SoterDeviceResult jYn()
      {
        // Byte code:
        //   0: ldc 147
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 38
        //   16: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 20	com/tencent/soter/soterserver/a$a$a:mRemote	Landroid/os/IBinder;
        //   23: bipush 11
        //   25: aload_2
        //   26: aload_3
        //   27: iconst_0
        //   28: invokeinterface 52 5 0
        //   33: ifne +33 -> 66
        //   36: invokestatic 56	com/tencent/soter/soterserver/a$a:jYo	()Lcom/tencent/soter/soterserver/a;
        //   39: ifnull +27 -> 66
        //   42: invokestatic 56	com/tencent/soter/soterserver/a$a:jYo	()Lcom/tencent/soter/soterserver/a;
        //   45: invokeinterface 149 1 0
        //   50: astore_1
        //   51: aload_3
        //   52: invokevirtual 61	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 61	android/os/Parcel:recycle	()V
        //   59: ldc 147
        //   61: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   64: aload_1
        //   65: areturn
        //   66: aload_3
        //   67: invokevirtual 67	android/os/Parcel:readException	()V
        //   70: aload_3
        //   71: invokevirtual 71	android/os/Parcel:readInt	()I
        //   74: ifeq +31 -> 105
        //   77: getstatic 152	com/tencent/soter/soterserver/SoterDeviceResult:CREATOR	Landroid/os/Parcelable$Creator;
        //   80: aload_3
        //   81: invokeinterface 83 2 0
        //   86: checkcast 151	com/tencent/soter/soterserver/SoterDeviceResult
        //   89: astore_1
        //   90: aload_3
        //   91: invokevirtual 61	android/os/Parcel:recycle	()V
        //   94: aload_2
        //   95: invokevirtual 61	android/os/Parcel:recycle	()V
        //   98: ldc 147
        //   100: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   103: aload_1
        //   104: areturn
        //   105: aconst_null
        //   106: astore_1
        //   107: goto -17 -> 90
        //   110: astore_1
        //   111: aload_3
        //   112: invokevirtual 61	android/os/Parcel:recycle	()V
        //   115: aload_2
        //   116: invokevirtual 61	android/os/Parcel:recycle	()V
        //   119: ldc 147
        //   121: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   124: aload_1
        //   125: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	126	0	this	a
        //   50	57	1	localSoterDeviceResult	SoterDeviceResult
        //   110	15	1	localObject	Object
        //   8	108	2	localParcel1	Parcel
        //   12	100	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	51	110	finally
        //   66	90	110	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.soter.soterserver.a
 * JD-Core Version:    0.7.0.1
 */