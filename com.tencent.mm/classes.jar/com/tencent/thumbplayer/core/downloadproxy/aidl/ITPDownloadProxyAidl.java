package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public abstract interface ITPDownloadProxyAidl
  extends IInterface
{
  public abstract String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract String getNativeInfo(int paramInt);
  
  public abstract String getPlayErrorCodeStr(int paramInt);
  
  public abstract String getPlayUrl(int paramInt1, int paramInt2);
  
  public abstract int init(String paramString);
  
  public abstract int pauseDownload(int paramInt);
  
  public abstract void pushEvent(int paramInt);
  
  public abstract int resumeDownload(int paramInt);
  
  public abstract boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParamAidl paramTPDownloadParamAidl);
  
  public abstract void setMaxStorageSizeMB(long paramLong);
  
  public abstract void setPlayState(int paramInt1, int paramInt2);
  
  public abstract void setUserData(Map paramMap);
  
  public abstract int startClipPlay(String paramString, int paramInt, ITPPlayListenerAidl paramITPPlayListenerAidl);
  
  public abstract int startPlay(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPlayListenerAidl paramITPPlayListenerAidl);
  
  public abstract int startPreload(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPreLoadListenerAidl paramITPPreLoadListenerAidl);
  
  public abstract void stopPlay(int paramInt);
  
  public abstract void stopPreload(int paramInt);
  
  public static abstract class Stub
    extends Binder
    implements ITPDownloadProxyAidl
  {
    private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl";
    static final int TRANSACTION_getClipPlayUrl = 6;
    static final int TRANSACTION_getNativeInfo = 14;
    static final int TRANSACTION_getPlayErrorCodeStr = 7;
    static final int TRANSACTION_getPlayUrl = 5;
    static final int TRANSACTION_init = 1;
    static final int TRANSACTION_pauseDownload = 9;
    static final int TRANSACTION_pushEvent = 15;
    static final int TRANSACTION_resumeDownload = 10;
    static final int TRANSACTION_setClipInfo = 4;
    static final int TRANSACTION_setMaxStorageSizeMB = 17;
    static final int TRANSACTION_setPlayState = 16;
    static final int TRANSACTION_setUserData = 13;
    static final int TRANSACTION_startClipPlay = 3;
    static final int TRANSACTION_startPlay = 2;
    static final int TRANSACTION_startPreload = 11;
    static final int TRANSACTION_stopPlay = 8;
    static final int TRANSACTION_stopPreload = 12;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
    }
    
    public static ITPDownloadProxyAidl asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      if ((localIInterface != null) && ((localIInterface instanceof ITPDownloadProxyAidl))) {
        return (ITPDownloadProxyAidl)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      String str1 = null;
      String str2 = null;
      Object localObject = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramInt1 = init(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject = (TPDownloadParamAidl)TPDownloadParamAidl.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = startPlay(str1, (TPDownloadParamAidl)localObject, ITPPlayListenerAidl.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramInt1 = startClipPlay(paramParcel1.readString(), paramParcel1.readInt(), ITPPlayListenerAidl.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        str2 = paramParcel1.readString();
        localObject = str1;
        if (paramParcel1.readInt() != 0) {
          localObject = (TPDownloadParamAidl)TPDownloadParamAidl.CREATOR.createFromParcel(paramParcel1);
        }
        boolean bool = setClipInfo(paramInt1, paramInt2, str2, (TPDownloadParamAidl)localObject);
        paramParcel2.writeNoException();
        if (bool) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 5: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramParcel1 = getPlayUrl(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramParcel1 = getClipPlayUrl(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramParcel1 = getPlayErrorCodeStr(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        stopPlay(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramInt1 = pauseDownload(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramInt1 = resumeDownload(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        str1 = paramParcel1.readString();
        localObject = str2;
        if (paramParcel1.readInt() != 0) {
          localObject = (TPDownloadParamAidl)TPDownloadParamAidl.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = startPreload(str1, (TPDownloadParamAidl)localObject, ITPPreLoadListenerAidl.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        stopPreload(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        setUserData(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        paramParcel1 = getNativeInfo(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        pushEvent(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        setPlayState(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      setMaxStorageSizeMB(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    }
    
    static class Proxy
      implements ITPDownloadProxyAidl
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
      
      public String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3)
      {
        AppMethodBeat.i(228269);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(228269);
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl";
      }
      
      public String getNativeInfo(int paramInt)
      {
        AppMethodBeat.i(228347);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(228347);
        }
      }
      
      public String getPlayErrorCodeStr(int paramInt)
      {
        AppMethodBeat.i(228281);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(228281);
        }
      }
      
      public String getPlayUrl(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(228262);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(228262);
        }
      }
      
      public int init(String paramString)
      {
        AppMethodBeat.i(228228);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeString(paramString);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(228228);
        }
      }
      
      public int pauseDownload(int paramInt)
      {
        AppMethodBeat.i(228302);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(228302);
        }
      }
      
      public void pushEvent(int paramInt)
      {
        AppMethodBeat.i(228357);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(228357);
        }
      }
      
      public int resumeDownload(int paramInt)
      {
        AppMethodBeat.i(228311);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(228311);
        }
      }
      
      public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParamAidl paramTPDownloadParamAidl)
      {
        boolean bool = true;
        AppMethodBeat.i(228251);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeString(paramString);
            if (paramTPDownloadParamAidl != null)
            {
              localParcel1.writeInt(1);
              paramTPDownloadParamAidl.writeToParcel(localParcel1, 0);
              this.mRemote.transact(4, localParcel1, localParcel2, 0);
              localParcel2.readException();
              paramInt1 = localParcel2.readInt();
              if (paramInt1 != 0) {
                return bool;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            bool = false;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
            AppMethodBeat.o(228251);
          }
        }
      }
      
      public void setMaxStorageSizeMB(long paramLong)
      {
        AppMethodBeat.i(228369);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(228369);
        }
      }
      
      public void setPlayState(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(228363);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(228363);
        }
      }
      
      public void setUserData(Map paramMap)
      {
        AppMethodBeat.i(228341);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeMap(paramMap);
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(228341);
        }
      }
      
      /* Error */
      public int startClipPlay(String paramString, int paramInt, ITPPlayListenerAidl paramITPPlayListenerAidl)
      {
        // Byte code:
        //   0: ldc 118
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 4
        //   10: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 5
        //   15: aload 4
        //   17: ldc 39
        //   19: invokevirtual 43	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload 4
        //   24: aload_1
        //   25: invokevirtual 80	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   28: aload 4
        //   30: iload_2
        //   31: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   34: aload_3
        //   35: ifnull +60 -> 95
        //   38: aload_3
        //   39: invokeinterface 122 1 0
        //   44: astore_1
        //   45: aload 4
        //   47: aload_1
        //   48: invokevirtual 125	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   51: aload_0
        //   52: getfield 19	com/tencent/thumbplayer/core/downloadproxy/aidl/ITPDownloadProxyAidl$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   55: iconst_3
        //   56: aload 4
        //   58: aload 5
        //   60: iconst_0
        //   61: invokeinterface 52 5 0
        //   66: pop
        //   67: aload 5
        //   69: invokevirtual 55	android/os/Parcel:readException	()V
        //   72: aload 5
        //   74: invokevirtual 84	android/os/Parcel:readInt	()I
        //   77: istore_2
        //   78: aload 5
        //   80: invokevirtual 62	android/os/Parcel:recycle	()V
        //   83: aload 4
        //   85: invokevirtual 62	android/os/Parcel:recycle	()V
        //   88: ldc 118
        //   90: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   93: iload_2
        //   94: ireturn
        //   95: aconst_null
        //   96: astore_1
        //   97: goto -52 -> 45
        //   100: astore_1
        //   101: aload 5
        //   103: invokevirtual 62	android/os/Parcel:recycle	()V
        //   106: aload 4
        //   108: invokevirtual 62	android/os/Parcel:recycle	()V
        //   111: ldc 118
        //   113: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   116: aload_1
        //   117: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	118	0	this	Proxy
        //   0	118	1	paramString	String
        //   0	118	2	paramInt	int
        //   0	118	3	paramITPPlayListenerAidl	ITPPlayListenerAidl
        //   8	99	4	localParcel1	Parcel
        //   13	89	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	34	100	finally
        //   38	45	100	finally
        //   45	78	100	finally
      }
      
      public int startPlay(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPlayListenerAidl paramITPPlayListenerAidl)
      {
        AppMethodBeat.i(228237);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
            localParcel1.writeString(paramString);
            if (paramTPDownloadParamAidl != null)
            {
              localParcel1.writeInt(1);
              paramTPDownloadParamAidl.writeToParcel(localParcel1, 0);
              if (paramITPPlayListenerAidl != null)
              {
                paramString = paramITPPlayListenerAidl.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.mRemote.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
            AppMethodBeat.o(228237);
          }
        }
      }
      
      public int startPreload(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPreLoadListenerAidl paramITPPreLoadListenerAidl)
      {
        AppMethodBeat.i(228322);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
            localParcel1.writeString(paramString);
            if (paramTPDownloadParamAidl != null)
            {
              localParcel1.writeInt(1);
              paramTPDownloadParamAidl.writeToParcel(localParcel1, 0);
              if (paramITPPreLoadListenerAidl != null)
              {
                paramString = paramITPPreLoadListenerAidl.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.mRemote.transact(11, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
            AppMethodBeat.o(228322);
          }
        }
      }
      
      public void stopPlay(int paramInt)
      {
        AppMethodBeat.i(228292);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(228292);
        }
      }
      
      public void stopPreload(int paramInt)
      {
        AppMethodBeat.i(228332);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(228332);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
 * JD-Core Version:    0.7.0.1
 */