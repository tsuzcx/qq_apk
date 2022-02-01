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
  
  public abstract byte[] aZm();
  
  public abstract String aZn();
  
  public abstract void an(byte[] paramArrayOfByte);
  
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
  
  public abstract boolean isAxAuth();
  
  public abstract void sL(int paramInt);
  
  public abstract void setClientVersion(int paramInt);
  
  public abstract void setDeviceID(String paramString);
  
  public abstract void setDeviceType(String paramString);
  
  public abstract void setPassKey(byte[] paramArrayOfByte);
  
  public abstract void setSceneStatus(int paramInt);
  
  public abstract void setSessionKey(byte[] paramArrayOfByte);
  
  public abstract void setUin(int paramInt);
  
  public abstract void setUseAxsession(boolean paramBoolean);
  
  public abstract boolean useAxSession();
  
  public static abstract class a
    extends Binder
    implements h
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.protocal.IMMBaseReq_AIDL");
    }
    
    public static h J(IBinder paramIBinder)
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
    
    public static h gtJ()
    {
      return a.Kzk;
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      int j = 0;
      int k = 0;
      boolean bool = false;
      int m = 0;
      int i = 0;
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
        paramParcel1 = aZm();
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
        paramParcel1 = aZn();
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
      case 22: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        long l = getECDHEngine();
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        bool = isAxAuth();
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        if (paramParcel1.readInt() != 0) {
          bool = true;
        }
        setUseAxsession(bool);
        paramParcel2.writeNoException();
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        bool = useAxSession();
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
        sL(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
      an(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements h
    {
      public static h Kzk;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public final boolean a(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, boolean paramBoolean)
      {
        // Byte code:
        //   0: ldc 23
        //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 9
        //   10: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 10
        //   15: aload 9
        //   17: ldc 37
        //   19: invokevirtual 41	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload 9
        //   24: iload_1
        //   25: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   28: aload 9
        //   30: aload_2
        //   31: invokevirtual 48	android/os/Parcel:writeByteArray	([B)V
        //   34: aload 9
        //   36: iload_3
        //   37: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   40: aload 9
        //   42: aload 4
        //   44: invokevirtual 48	android/os/Parcel:writeByteArray	([B)V
        //   47: aload 9
        //   49: aload 5
        //   51: invokevirtual 48	android/os/Parcel:writeByteArray	([B)V
        //   54: aload 9
        //   56: iload 6
        //   58: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   61: iload 7
        //   63: ifeq +76 -> 139
        //   66: iconst_1
        //   67: istore 8
        //   69: aload 9
        //   71: iload 8
        //   73: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   76: aload_0
        //   77: getfield 20	com/tencent/mm/protocal/h$a$a:mRemote	Landroid/os/IBinder;
        //   80: iconst_1
        //   81: aload 9
        //   83: aload 10
        //   85: iconst_0
        //   86: invokeinterface 54 5 0
        //   91: ifne +54 -> 145
        //   94: invokestatic 58	com/tencent/mm/protocal/h$a:gtJ	()Lcom/tencent/mm/protocal/h;
        //   97: ifnull +48 -> 145
        //   100: invokestatic 58	com/tencent/mm/protocal/h$a:gtJ	()Lcom/tencent/mm/protocal/h;
        //   103: iload_1
        //   104: aload_2
        //   105: iload_3
        //   106: aload 4
        //   108: aload 5
        //   110: iload 6
        //   112: iload 7
        //   114: invokeinterface 60 8 0
        //   119: istore 7
        //   121: aload 10
        //   123: invokevirtual 63	android/os/Parcel:recycle	()V
        //   126: aload 9
        //   128: invokevirtual 63	android/os/Parcel:recycle	()V
        //   131: ldc 23
        //   133: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   136: iload 7
        //   138: ireturn
        //   139: iconst_0
        //   140: istore 8
        //   142: goto -73 -> 69
        //   145: aload 10
        //   147: invokevirtual 69	android/os/Parcel:readException	()V
        //   150: aload 10
        //   152: invokevirtual 73	android/os/Parcel:readInt	()I
        //   155: istore_1
        //   156: iload_1
        //   157: ifeq +24 -> 181
        //   160: iconst_1
        //   161: istore 7
        //   163: aload 10
        //   165: invokevirtual 63	android/os/Parcel:recycle	()V
        //   168: aload 9
        //   170: invokevirtual 63	android/os/Parcel:recycle	()V
        //   173: ldc 23
        //   175: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   178: iload 7
        //   180: ireturn
        //   181: iconst_0
        //   182: istore 7
        //   184: goto -21 -> 163
        //   187: astore_2
        //   188: aload 10
        //   190: invokevirtual 63	android/os/Parcel:recycle	()V
        //   193: aload 9
        //   195: invokevirtual 63	android/os/Parcel:recycle	()V
        //   198: ldc 23
        //   200: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   203: aload_2
        //   204: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	205	0	this	a
        //   0	205	1	paramInt1	int
        //   0	205	2	paramArrayOfByte1	byte[]
        //   0	205	3	paramInt2	int
        //   0	205	4	paramArrayOfByte2	byte[]
        //   0	205	5	paramArrayOfByte3	byte[]
        //   0	205	6	paramInt3	int
        //   0	205	7	paramBoolean	boolean
        //   67	74	8	i	int
        //   8	186	9	localParcel1	Parcel
        //   13	176	10	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	61	187	finally
        //   69	121	187	finally
        //   145	156	187	finally
      }
      
      public final byte[] aZm()
      {
        AppMethodBeat.i(133046);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            arrayOfByte = h.a.gtJ().aZm();
            return arrayOfByte;
          }
          localParcel2.readException();
          byte[] arrayOfByte = localParcel2.createByteArray();
          return arrayOfByte;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133046);
        }
      }
      
      public final String aZn()
      {
        AppMethodBeat.i(133063);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(19, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            str = h.a.gtJ().aZn();
            return str;
          }
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133063);
        }
      }
      
      public final void an(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(197126);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          if ((!this.mRemote.transact(27, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            h.a.gtJ().an(paramArrayOfByte);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(197126);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final int getClientVersion()
      {
        AppMethodBeat.i(133052);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            i = h.a.gtJ().getClientVersion();
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
          AppMethodBeat.o(133052);
        }
      }
      
      public final int getCmdId()
      {
        AppMethodBeat.i(133064);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(20, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            i = h.a.gtJ().getCmdId();
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
          AppMethodBeat.o(133064);
        }
      }
      
      public final String getDeviceID()
      {
        AppMethodBeat.i(133055);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(11, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            str = h.a.gtJ().getDeviceID();
            return str;
          }
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133055);
        }
      }
      
      public final String getDeviceType()
      {
        AppMethodBeat.i(133054);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(10, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            str = h.a.gtJ().getDeviceType();
            return str;
          }
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133054);
        }
      }
      
      public final long getECDHEngine()
      {
        AppMethodBeat.i(133066);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(22, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            l = h.a.gtJ().getECDHEngine();
            return l;
          }
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133066);
        }
      }
      
      public final byte[] getPassKey()
      {
        AppMethodBeat.i(133059);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(15, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            arrayOfByte = h.a.gtJ().getPassKey();
            return arrayOfByte;
          }
          localParcel2.readException();
          byte[] arrayOfByte = localParcel2.createByteArray();
          return arrayOfByte;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133059);
        }
      }
      
      public final String getPassword()
      {
        AppMethodBeat.i(133062);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(18, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            str = h.a.gtJ().getPassword();
            return str;
          }
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133062);
        }
      }
      
      public final int getSceneStatus()
      {
        AppMethodBeat.i(133058);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(14, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            i = h.a.gtJ().getSceneStatus();
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
          AppMethodBeat.o(133058);
        }
      }
      
      public final byte[] getSessionKey()
      {
        AppMethodBeat.i(133048);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            arrayOfByte = h.a.gtJ().getSessionKey();
            return arrayOfByte;
          }
          localParcel2.readException();
          byte[] arrayOfByte = localParcel2.createByteArray();
          return arrayOfByte;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133048);
        }
      }
      
      public final boolean getShortSupport()
      {
        boolean bool = false;
        AppMethodBeat.i(133065);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(21, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            bool = h.a.gtJ().getShortSupport();
            return bool;
          }
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
          AppMethodBeat.o(133065);
        }
      }
      
      public final int getUin()
      {
        AppMethodBeat.i(133050);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            i = h.a.gtJ().getUin();
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
          AppMethodBeat.o(133050);
        }
      }
      
      public final String getUserName()
      {
        AppMethodBeat.i(133061);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(17, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            str = h.a.gtJ().getUserName();
            return str;
          }
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133061);
        }
      }
      
      public final boolean isAxAuth()
      {
        boolean bool = false;
        AppMethodBeat.i(133067);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(23, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            bool = h.a.gtJ().isAxAuth();
            return bool;
          }
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
          AppMethodBeat.o(133067);
        }
      }
      
      public final void sL(int paramInt)
      {
        AppMethodBeat.i(197125);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(26, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            h.a.gtJ().sL(paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(197125);
        }
      }
      
      public final void setClientVersion(int paramInt)
      {
        AppMethodBeat.i(133051);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            h.a.gtJ().setClientVersion(paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133051);
        }
      }
      
      public final void setDeviceID(String paramString)
      {
        AppMethodBeat.i(133056);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(12, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            h.a.gtJ().setDeviceID(paramString);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133056);
        }
      }
      
      public final void setDeviceType(String paramString)
      {
        AppMethodBeat.i(133053);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            h.a.gtJ().setDeviceType(paramString);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133053);
        }
      }
      
      public final void setPassKey(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(133060);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          if ((!this.mRemote.transact(16, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            h.a.gtJ().setPassKey(paramArrayOfByte);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133060);
        }
      }
      
      public final void setSceneStatus(int paramInt)
      {
        AppMethodBeat.i(133057);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(13, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            h.a.gtJ().setSceneStatus(paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133057);
        }
      }
      
      public final void setSessionKey(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(133047);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            h.a.gtJ().setSessionKey(paramArrayOfByte);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133047);
        }
      }
      
      public final void setUin(int paramInt)
      {
        AppMethodBeat.i(133049);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            h.a.gtJ().setUin(paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133049);
        }
      }
      
      public final void setUseAxsession(boolean paramBoolean)
      {
        int i = 0;
        AppMethodBeat.i(133068);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          if ((!this.mRemote.transact(24, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            h.a.gtJ().setUseAxsession(paramBoolean);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133068);
        }
      }
      
      public final boolean useAxSession()
      {
        boolean bool = false;
        AppMethodBeat.i(133069);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
          if ((!this.mRemote.transact(25, localParcel1, localParcel2, 0)) && (h.a.gtJ() != null))
          {
            bool = h.a.gtJ().useAxSession();
            return bool;
          }
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
          AppMethodBeat.o(133069);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.h
 * JD-Core Version:    0.7.0.1
 */