package com.tencent.mm.protocal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface i
  extends IInterface
{
  public abstract boolean a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong);
  
  public abstract void ay(byte[] paramArrayOfByte);
  
  public abstract byte[] bFZ();
  
  public abstract byte[] bGb();
  
  public abstract String bGc();
  
  public abstract byte[] bGs();
  
  public abstract String bGt();
  
  public abstract String bGu();
  
  public abstract int bGv();
  
  public abstract byte[] getAuthResponse();
  
  public abstract int getCmdId();
  
  public abstract String getErrMsg();
  
  public abstract int getHeadExtFlags();
  
  public abstract int getRetCode();
  
  public abstract int getUin();
  
  public abstract byte[] sA(int paramInt);
  
  public abstract void setErrMsg(String paramString);
  
  public abstract void setRetCode(int paramInt);
  
  public static abstract class a
    extends Binder
    implements i
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.protocal.IMMBaseResp_AIDL");
    }
    
    public static i T(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof i))) {
        return (i)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static i iPU()
    {
      return a.YxE;
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
        paramParcel2.writeString("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        boolean bool = a(paramParcel1.readInt(), paramParcel1.createByteArray(), paramParcel1.createByteArray(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        if (bool) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramParcel1 = bFZ();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        setRetCode(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramInt1 = getRetCode();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramInt1 = getHeadExtFlags();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramParcel1 = getErrMsg();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        setErrMsg(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramParcel1 = sA(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramParcel1 = bGs();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramParcel1 = bGb();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramInt1 = getUin();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramParcel1 = bGc();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramInt1 = getCmdId();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramParcel1 = bGt();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramParcel1 = bGu();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramInt1 = bGv();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramParcel1 = getAuthResponse();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
      ay(paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements i
    {
      public static i YxE;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public final boolean a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 6
        //   3: ldc 23
        //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   16: astore 8
        //   18: aload 7
        //   20: ldc 37
        //   22: invokevirtual 41	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   25: aload 7
        //   27: iload_1
        //   28: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   31: aload 7
        //   33: aload_2
        //   34: invokevirtual 48	android/os/Parcel:writeByteArray	([B)V
        //   37: aload 7
        //   39: aload_3
        //   40: invokevirtual 48	android/os/Parcel:writeByteArray	([B)V
        //   43: aload 7
        //   45: lload 4
        //   47: invokevirtual 52	android/os/Parcel:writeLong	(J)V
        //   50: aload_0
        //   51: getfield 20	com/tencent/mm/protocal/i$a$a:mRemote	Landroid/os/IBinder;
        //   54: iconst_1
        //   55: aload 7
        //   57: aload 8
        //   59: iconst_0
        //   60: invokeinterface 58 5 0
        //   65: ifne +42 -> 107
        //   68: invokestatic 62	com/tencent/mm/protocal/i$a:iPU	()Lcom/tencent/mm/protocal/i;
        //   71: ifnull +36 -> 107
        //   74: invokestatic 62	com/tencent/mm/protocal/i$a:iPU	()Lcom/tencent/mm/protocal/i;
        //   77: iload_1
        //   78: aload_2
        //   79: aload_3
        //   80: lload 4
        //   82: invokeinterface 64 6 0
        //   87: istore 6
        //   89: aload 8
        //   91: invokevirtual 67	android/os/Parcel:recycle	()V
        //   94: aload 7
        //   96: invokevirtual 67	android/os/Parcel:recycle	()V
        //   99: ldc 23
        //   101: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   104: iload 6
        //   106: ireturn
        //   107: aload 8
        //   109: invokevirtual 73	android/os/Parcel:readException	()V
        //   112: aload 8
        //   114: invokevirtual 77	android/os/Parcel:readInt	()I
        //   117: istore_1
        //   118: iload_1
        //   119: ifeq +21 -> 140
        //   122: aload 8
        //   124: invokevirtual 67	android/os/Parcel:recycle	()V
        //   127: aload 7
        //   129: invokevirtual 67	android/os/Parcel:recycle	()V
        //   132: ldc 23
        //   134: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   137: iload 6
        //   139: ireturn
        //   140: iconst_0
        //   141: istore 6
        //   143: goto -21 -> 122
        //   146: astore_2
        //   147: aload 8
        //   149: invokevirtual 67	android/os/Parcel:recycle	()V
        //   152: aload 7
        //   154: invokevirtual 67	android/os/Parcel:recycle	()V
        //   157: ldc 23
        //   159: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   162: aload_2
        //   163: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	164	0	this	a
        //   0	164	1	paramInt	int
        //   0	164	2	paramArrayOfByte1	byte[]
        //   0	164	3	paramArrayOfByte2	byte[]
        //   0	164	4	paramLong	long
        //   1	141	6	bool	boolean
        //   11	142	7	localParcel1	Parcel
        //   16	132	8	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   18	89	146	finally
        //   107	118	146	finally
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void ay(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(257317);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          if ((!this.mRemote.transact(18, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            i.a.iPU().ay(paramArrayOfByte);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(257317);
        }
      }
      
      public final byte[] bFZ()
      {
        AppMethodBeat.i(133071);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            arrayOfByte = i.a.iPU().bFZ();
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
          AppMethodBeat.o(133071);
        }
      }
      
      public final byte[] bGb()
      {
        AppMethodBeat.i(133079);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          if ((!this.mRemote.transact(10, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            arrayOfByte = i.a.iPU().bGb();
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
          AppMethodBeat.o(133079);
        }
      }
      
      public final String bGc()
      {
        AppMethodBeat.i(133081);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          if ((!this.mRemote.transact(12, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            str = i.a.iPU().bGc();
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
          AppMethodBeat.o(133081);
        }
      }
      
      public final byte[] bGs()
      {
        AppMethodBeat.i(133078);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            arrayOfByte = i.a.iPU().bGs();
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
          AppMethodBeat.o(133078);
        }
      }
      
      public final String bGt()
      {
        AppMethodBeat.i(133083);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          if ((!this.mRemote.transact(14, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            str = i.a.iPU().bGt();
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
          AppMethodBeat.o(133083);
        }
      }
      
      public final String bGu()
      {
        AppMethodBeat.i(133084);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          if ((!this.mRemote.transact(15, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            str = i.a.iPU().bGu();
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
          AppMethodBeat.o(133084);
        }
      }
      
      public final int bGv()
      {
        AppMethodBeat.i(133085);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          if ((!this.mRemote.transact(16, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            i = i.a.iPU().bGv();
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
          AppMethodBeat.o(133085);
        }
      }
      
      public final byte[] getAuthResponse()
      {
        AppMethodBeat.i(133086);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          if ((!this.mRemote.transact(17, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            arrayOfByte = i.a.iPU().getAuthResponse();
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
          AppMethodBeat.o(133086);
        }
      }
      
      public final int getCmdId()
      {
        AppMethodBeat.i(133082);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          if ((!this.mRemote.transact(13, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            i = i.a.iPU().getCmdId();
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
          AppMethodBeat.o(133082);
        }
      }
      
      public final String getErrMsg()
      {
        AppMethodBeat.i(133075);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            str = i.a.iPU().getErrMsg();
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
          AppMethodBeat.o(133075);
        }
      }
      
      public final int getHeadExtFlags()
      {
        AppMethodBeat.i(133074);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            i = i.a.iPU().getHeadExtFlags();
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
          AppMethodBeat.o(133074);
        }
      }
      
      public final int getRetCode()
      {
        AppMethodBeat.i(133073);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            i = i.a.iPU().getRetCode();
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
          AppMethodBeat.o(133073);
        }
      }
      
      public final int getUin()
      {
        AppMethodBeat.i(133080);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          if ((!this.mRemote.transact(11, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            i = i.a.iPU().getUin();
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
          AppMethodBeat.o(133080);
        }
      }
      
      public final byte[] sA(int paramInt)
      {
        AppMethodBeat.i(133077);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            arrayOfByte = i.a.iPU().sA(paramInt);
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
          AppMethodBeat.o(133077);
        }
      }
      
      public final void setErrMsg(String paramString)
      {
        AppMethodBeat.i(133076);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            i.a.iPU().setErrMsg(paramString);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133076);
        }
      }
      
      public final void setRetCode(int paramInt)
      {
        AppMethodBeat.i(133072);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (i.a.iPU() != null))
          {
            i.a.iPU().setRetCode(paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(133072);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.i
 * JD-Core Version:    0.7.0.1
 */