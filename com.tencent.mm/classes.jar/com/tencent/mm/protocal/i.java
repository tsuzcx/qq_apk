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
  
  public abstract byte[] aFB();
  
  public abstract String aFC();
  
  public abstract String aFD();
  
  public abstract int aFE();
  
  public abstract byte[] aFl();
  
  public abstract byte[] aFn();
  
  public abstract String aFo();
  
  public abstract byte[] getAuthResponse();
  
  public abstract int getCmdId();
  
  public abstract String getErrMsg();
  
  public abstract int getHeadExtFlags();
  
  public abstract int getRetCode();
  
  public abstract int getUin();
  
  public abstract byte[] mR(int paramInt);
  
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
    
    public static i K(IBinder paramIBinder)
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
        paramParcel1 = aFl();
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
        paramParcel1 = mR(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramParcel1 = aFB();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramParcel1 = aFn();
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
        paramParcel1 = aFo();
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
        paramParcel1 = aFC();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramParcel1 = aFD();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
        paramInt1 = aFE();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
      paramParcel1 = getAuthResponse();
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    }
    
    static final class a
      implements i
    {
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
        //   3: ldc 21
        //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   16: astore 8
        //   18: aload 7
        //   20: ldc 35
        //   22: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   25: aload 7
        //   27: iload_1
        //   28: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   31: aload 7
        //   33: aload_2
        //   34: invokevirtual 46	android/os/Parcel:writeByteArray	([B)V
        //   37: aload 7
        //   39: aload_3
        //   40: invokevirtual 46	android/os/Parcel:writeByteArray	([B)V
        //   43: aload 7
        //   45: lload 4
        //   47: invokevirtual 50	android/os/Parcel:writeLong	(J)V
        //   50: aload_0
        //   51: getfield 18	com/tencent/mm/protocal/i$a$a:mRemote	Landroid/os/IBinder;
        //   54: iconst_1
        //   55: aload 7
        //   57: aload 8
        //   59: iconst_0
        //   60: invokeinterface 56 5 0
        //   65: pop
        //   66: aload 8
        //   68: invokevirtual 59	android/os/Parcel:readException	()V
        //   71: aload 8
        //   73: invokevirtual 63	android/os/Parcel:readInt	()I
        //   76: istore_1
        //   77: iload_1
        //   78: ifeq +21 -> 99
        //   81: aload 8
        //   83: invokevirtual 66	android/os/Parcel:recycle	()V
        //   86: aload 7
        //   88: invokevirtual 66	android/os/Parcel:recycle	()V
        //   91: ldc 21
        //   93: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   96: iload 6
        //   98: ireturn
        //   99: iconst_0
        //   100: istore 6
        //   102: goto -21 -> 81
        //   105: astore_2
        //   106: aload 8
        //   108: invokevirtual 66	android/os/Parcel:recycle	()V
        //   111: aload 7
        //   113: invokevirtual 66	android/os/Parcel:recycle	()V
        //   116: ldc 21
        //   118: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   121: aload_2
        //   122: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	123	0	this	a
        //   0	123	1	paramInt	int
        //   0	123	2	paramArrayOfByte1	byte[]
        //   0	123	3	paramArrayOfByte2	byte[]
        //   0	123	4	paramLong	long
        //   1	100	6	bool	boolean
        //   11	101	7	localParcel1	Parcel
        //   16	91	8	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   18	77	105	finally
      }
      
      public final byte[] aFB()
      {
        AppMethodBeat.i(133078);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
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
      
      public final String aFC()
      {
        AppMethodBeat.i(133083);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
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
      
      public final String aFD()
      {
        AppMethodBeat.i(133084);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
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
      
      public final int aFE()
      {
        AppMethodBeat.i(133085);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
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
      
      public final byte[] aFl()
      {
        AppMethodBeat.i(133071);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
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
      
      public final byte[] aFn()
      {
        AppMethodBeat.i(133079);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
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
      
      public final String aFo()
      {
        AppMethodBeat.i(133081);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
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
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final byte[] getAuthResponse()
      {
        AppMethodBeat.i(133086);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          this.mRemote.transact(17, localParcel1, localParcel2, 0);
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
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
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
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
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
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
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
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
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
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
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
      
      public final byte[] mR(int paramInt)
      {
        AppMethodBeat.i(133077);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
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
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
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
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.i
 * JD-Core Version:    0.7.0.1
 */