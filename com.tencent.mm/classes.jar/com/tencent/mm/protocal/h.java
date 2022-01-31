package com.tencent.mm.protocal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface h
  extends IInterface
{
  public abstract boolean a(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, boolean paramBoolean);
  
  public abstract byte[] adM();
  
  public abstract String adN();
  
  public abstract int getClientVersion();
  
  public abstract int getCmdId();
  
  public abstract String getDeviceID();
  
  public abstract String getDeviceType();
  
  public abstract long getECDHEngine();
  
  public abstract byte[] getPassKey();
  
  public abstract String getPassword();
  
  public abstract int getSceneStatus();
  
  public abstract byte[] getSessionKey();
  
  public abstract boolean getShortSupport();
  
  public abstract int getUin();
  
  public abstract String getUserName();
  
  public abstract void setClientVersion(int paramInt);
  
  public abstract void setDeviceID(String paramString);
  
  public abstract void setDeviceType(String paramString);
  
  public abstract void setPassKey(byte[] paramArrayOfByte);
  
  public abstract void setSceneStatus(int paramInt);
  
  public abstract void setSessionKey(byte[] paramArrayOfByte);
  
  public abstract void setUin(int paramInt);
  
  public static abstract class a
    extends Binder
    implements h
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.protocal.IMMBaseReq_AIDL");
    }
    
    public static h I(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof h))) {
        return (h)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
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
        paramParcel2.writeString("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        paramInt1 = paramParcel1.readInt();
        byte[] arrayOfByte1 = paramParcel1.createByteArray();
        paramInt2 = paramParcel1.readInt();
        byte[] arrayOfByte2 = paramParcel1.createByteArray();
        byte[] arrayOfByte3 = paramParcel1.createByteArray();
        j = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (bool = true;; bool = false)
        {
          bool = a(paramInt1, arrayOfByte1, paramInt2, arrayOfByte2, arrayOfByte3, j, bool);
          paramParcel2.writeNoException();
          paramInt1 = i;
          if (bool) {
            paramInt1 = 1;
          }
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        paramParcel1 = adM();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        setSessionKey(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        paramParcel1 = getSessionKey();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        setUin(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        paramInt1 = getUin();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        setClientVersion(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        paramInt1 = getClientVersion();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        setDeviceType(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        paramParcel1 = getDeviceType();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        paramParcel1 = getDeviceID();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        setDeviceID(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        setSceneStatus(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        paramInt1 = getSceneStatus();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        paramParcel1 = getPassKey();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        setPassKey(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        paramParcel1 = getUserName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        paramParcel1 = getPassword();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        paramParcel1 = adN();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        paramInt1 = getCmdId();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        bool = getShortSupport();
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
      long l = getECDHEngine();
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    }
    
    static final class a
      implements h
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public final boolean a(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, boolean paramBoolean)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 8
        //   3: ldc 21
        //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 9
        //   13: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   16: astore 10
        //   18: aload 9
        //   20: ldc 35
        //   22: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   25: aload 9
        //   27: iload_1
        //   28: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   31: aload 9
        //   33: aload_2
        //   34: invokevirtual 46	android/os/Parcel:writeByteArray	([B)V
        //   37: aload 9
        //   39: iload_3
        //   40: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   43: aload 9
        //   45: aload 4
        //   47: invokevirtual 46	android/os/Parcel:writeByteArray	([B)V
        //   50: aload 9
        //   52: aload 5
        //   54: invokevirtual 46	android/os/Parcel:writeByteArray	([B)V
        //   57: aload 9
        //   59: iload 6
        //   61: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   64: iload 7
        //   66: ifeq +64 -> 130
        //   69: iconst_1
        //   70: istore_1
        //   71: aload 9
        //   73: iload_1
        //   74: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   77: aload_0
        //   78: getfield 18	com/tencent/mm/protocal/h$a$a:mRemote	Landroid/os/IBinder;
        //   81: iconst_1
        //   82: aload 9
        //   84: aload 10
        //   86: iconst_0
        //   87: invokeinterface 52 5 0
        //   92: pop
        //   93: aload 10
        //   95: invokevirtual 55	android/os/Parcel:readException	()V
        //   98: aload 10
        //   100: invokevirtual 59	android/os/Parcel:readInt	()I
        //   103: istore_1
        //   104: iload_1
        //   105: ifeq +30 -> 135
        //   108: iload 8
        //   110: istore 7
        //   112: aload 10
        //   114: invokevirtual 62	android/os/Parcel:recycle	()V
        //   117: aload 9
        //   119: invokevirtual 62	android/os/Parcel:recycle	()V
        //   122: ldc 21
        //   124: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   127: iload 7
        //   129: ireturn
        //   130: iconst_0
        //   131: istore_1
        //   132: goto -61 -> 71
        //   135: iconst_0
        //   136: istore 7
        //   138: goto -26 -> 112
        //   141: astore_2
        //   142: aload 10
        //   144: invokevirtual 62	android/os/Parcel:recycle	()V
        //   147: aload 9
        //   149: invokevirtual 62	android/os/Parcel:recycle	()V
        //   152: ldc 21
        //   154: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   157: aload_2
        //   158: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	159	0	this	a
        //   0	159	1	paramInt1	int
        //   0	159	2	paramArrayOfByte1	byte[]
        //   0	159	3	paramInt2	int
        //   0	159	4	paramArrayOfByte2	byte[]
        //   0	159	5	paramArrayOfByte3	byte[]
        //   0	159	6	paramInt3	int
        //   0	159	7	paramBoolean	boolean
        //   1	108	8	bool	boolean
        //   11	137	9	localParcel1	Parcel
        //   16	127	10	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   18	64	141	finally
        //   71	104	141	finally
      }
      
      public final byte[] adM()
      {
        AppMethodBeat.i(58796);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          byte[] arrayOfByte = localParcel2.createByteArray();
          return arrayOfByte;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58796);
        }
      }
      
      public final String adN()
      {
        AppMethodBeat.i(58813);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          this.mRemote.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58813);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final int getClientVersion()
      {
        AppMethodBeat.i(58802);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58802);
        }
      }
      
      public final int getCmdId()
      {
        AppMethodBeat.i(58814);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          this.mRemote.transact(20, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58814);
        }
      }
      
      public final String getDeviceID()
      {
        AppMethodBeat.i(58805);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58805);
        }
      }
      
      public final String getDeviceType()
      {
        AppMethodBeat.i(58804);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58804);
        }
      }
      
      public final long getECDHEngine()
      {
        AppMethodBeat.i(58816);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          this.mRemote.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58816);
        }
      }
      
      public final byte[] getPassKey()
      {
        AppMethodBeat.i(58809);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          byte[] arrayOfByte = localParcel2.createByteArray();
          return arrayOfByte;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58809);
        }
      }
      
      public final String getPassword()
      {
        AppMethodBeat.i(58812);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          this.mRemote.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58812);
        }
      }
      
      public final int getSceneStatus()
      {
        AppMethodBeat.i(58808);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58808);
        }
      }
      
      public final byte[] getSessionKey()
      {
        AppMethodBeat.i(58798);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          byte[] arrayOfByte = localParcel2.createByteArray();
          return arrayOfByte;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58798);
        }
      }
      
      public final boolean getShortSupport()
      {
        boolean bool = false;
        AppMethodBeat.i(58815);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          this.mRemote.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58815);
        }
      }
      
      public final int getUin()
      {
        AppMethodBeat.i(58800);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58800);
        }
      }
      
      public final String getUserName()
      {
        AppMethodBeat.i(58811);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          this.mRemote.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58811);
        }
      }
      
      public final void setClientVersion(int paramInt)
      {
        AppMethodBeat.i(58801);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58801);
        }
      }
      
      public final void setDeviceID(String paramString)
      {
        AppMethodBeat.i(58806);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58806);
        }
      }
      
      public final void setDeviceType(String paramString)
      {
        AppMethodBeat.i(58803);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58803);
        }
      }
      
      public final void setPassKey(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(58810);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58810);
        }
      }
      
      public final void setSceneStatus(int paramInt)
      {
        AppMethodBeat.i(58807);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58807);
        }
      }
      
      public final void setSessionKey(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(58797);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58797);
        }
      }
      
      public final void setUin(int paramInt)
      {
        AppMethodBeat.i(58799);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58799);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.h
 * JD-Core Version:    0.7.0.1
 */