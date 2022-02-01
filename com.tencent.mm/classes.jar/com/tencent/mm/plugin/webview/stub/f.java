package com.tencent.mm.plugin.webview.stub;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface f
  extends IInterface
{
  public abstract void Il(boolean paramBoolean);
  
  public abstract void Im(boolean paramBoolean);
  
  public abstract void In(boolean paramBoolean);
  
  public abstract boolean a(d paramd);
  
  public abstract boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean);
  
  public abstract void aF(Bundle paramBundle);
  
  public abstract boolean asR(int paramInt);
  
  public abstract void bif(String paramString);
  
  public abstract void bk(Bundle paramBundle);
  
  public abstract String cxY();
  
  public abstract void f(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract String getCurrentUrl();
  
  public abstract boolean i(int paramInt, Bundle paramBundle);
  
  public abstract void ioZ();
  
  public abstract String ipa();
  
  public abstract String ipb();
  
  public abstract int ipc();
  
  public abstract void ipd();
  
  public abstract Bundle m(int paramInt, Bundle paramBundle);
  
  public abstract Bundle nK(String paramString1, String paramString2);
  
  public abstract void nL(String paramString1, String paramString2);
  
  public abstract void nM(String paramString1, String paramString2);
  
  public abstract void y(int paramInt, Bundle paramBundle);
  
  public static abstract class a
    extends Binder
    implements f
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
    }
    
    public static f R(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof f))) {
        return (f)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static f ixk()
    {
      return a.WRS;
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      String str1 = null;
      Object localObject1 = null;
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = null;
      String str2 = null;
      int j = 0;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = false;
      int i = 0;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        bool1 = asR(paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (bool1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        paramInt1 = paramParcel1.readInt();
        localObject1 = str2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        bool1 = i(paramInt1, (Bundle)localObject1);
        paramParcel2.writeNoException();
        if (bool1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          if (localObject1 == null) {
            break;
          }
          paramParcel2.writeInt(1);
          ((Bundle)localObject1).writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 == null) {
          paramParcel1 = str1;
        }
        for (;;)
        {
          bool1 = a(paramParcel1);
          paramParcel2.writeNoException();
          paramInt1 = i;
          if (bool1) {
            paramInt1 = 1;
          }
          paramParcel2.writeInt(paramInt1);
          return true;
          localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
          if ((localObject1 != null) && ((localObject1 instanceof d))) {
            paramParcel1 = (d)localObject1;
          } else {
            paramParcel1 = new d.a.a(paramParcel1);
          }
        }
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        str1 = paramParcel1.readString();
        str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {}
        for (bool1 = true;; bool1 = false)
        {
          bool1 = a(str1, str2, (Bundle)localObject1, bool1);
          paramParcel2.writeNoException();
          paramInt1 = j;
          if (bool1) {
            paramInt1 = 1;
          }
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        paramParcel1 = ipa();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        paramParcel1 = getCurrentUrl();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        paramParcel1 = cxY();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        paramParcel1 = ipb();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        paramInt1 = ipc();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        Il(bool1);
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        bool1 = bool2;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        Im(bool1);
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        paramInt1 = paramParcel1.readInt();
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        y(paramInt1, (Bundle)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        ioZ();
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        localObject1 = localObject3;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        aF((Bundle)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        bif(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        nL(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        ipd();
        paramParcel2.writeNoException();
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        f(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        paramInt1 = paramParcel1.readInt();
        localObject1 = localObject4;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = m(paramInt1, (Bundle)localObject1);
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        localObject1 = localObject5;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        bk((Bundle)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        bool1 = bool3;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        In(bool1);
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        nM(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      paramParcel1 = nK(paramParcel1.readString(), paramParcel1.readString());
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
    
    static final class a
      implements f
    {
      public static f WRS;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void Il(boolean paramBoolean)
      {
        int i = 0;
        AppMethodBeat.i(79515);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          if ((!this.mRemote.transact(10, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            f.a.ixk().Il(paramBoolean);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79515);
        }
      }
      
      public final void Im(boolean paramBoolean)
      {
        int i = 0;
        AppMethodBeat.i(79516);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          if ((!this.mRemote.transact(11, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            f.a.ixk().Im(paramBoolean);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79516);
        }
      }
      
      public final void In(boolean paramBoolean)
      {
        int i = 0;
        AppMethodBeat.i(79526);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          if ((!this.mRemote.transact(21, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            f.a.ixk().In(paramBoolean);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79526);
        }
      }
      
      public final boolean a(d paramd)
      {
        boolean bool = false;
        AppMethodBeat.i(79509);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          if (paramd != null) {}
          for (IBinder localIBinder = paramd.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(3, localParcel1, localParcel2, 0)) || (f.a.ixk() == null)) {
              break;
            }
            bool = f.a.ixk().a(paramd);
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
          AppMethodBeat.o(79509);
        }
      }
      
      public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
      {
        boolean bool = true;
        AppMethodBeat.i(79510);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              break label199;
              localParcel1.writeInt(i);
              if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
              {
                paramBoolean = f.a.ixk().a(paramString1, paramString2, paramBundle, paramBoolean);
                return paramBoolean;
              }
            }
            else
            {
              localParcel1.writeInt(0);
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
            AppMethodBeat.o(79510);
          }
          label199:
          do
          {
            i = 0;
            break;
            localParcel2.readException();
            i = localParcel2.readInt();
            if (i != 0) {}
            for (paramBoolean = bool;; paramBoolean = false)
            {
              localParcel2.recycle();
              localParcel1.recycle();
              AppMethodBeat.o(79510);
              return paramBoolean;
            }
          } while (!paramBoolean);
          int i = 1;
        }
      }
      
      public final void aF(Bundle paramBundle)
      {
        AppMethodBeat.i(79519);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(14, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            f.a.ixk().aF(paramBundle);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79519);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(79519);
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public final boolean asR(int paramInt)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: ldc 112
        //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_3
        //   11: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   14: astore 4
        //   16: aload_3
        //   17: ldc 38
        //   19: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload_3
        //   23: iload_1
        //   24: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   27: aload_0
        //   28: getfield 20	com/tencent/mm/plugin/webview/stub/f$a$a:mRemote	Landroid/os/IBinder;
        //   31: iconst_1
        //   32: aload_3
        //   33: aload 4
        //   35: iconst_0
        //   36: invokeinterface 51 5 0
        //   41: ifne +35 -> 76
        //   44: invokestatic 55	com/tencent/mm/plugin/webview/stub/f$a:ixk	()Lcom/tencent/mm/plugin/webview/stub/f;
        //   47: ifnull +29 -> 76
        //   50: invokestatic 55	com/tencent/mm/plugin/webview/stub/f$a:ixk	()Lcom/tencent/mm/plugin/webview/stub/f;
        //   53: iload_1
        //   54: invokeinterface 114 2 0
        //   59: istore_2
        //   60: aload 4
        //   62: invokevirtual 60	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 60	android/os/Parcel:recycle	()V
        //   69: ldc 112
        //   71: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   74: iload_2
        //   75: ireturn
        //   76: aload 4
        //   78: invokevirtual 66	android/os/Parcel:readException	()V
        //   81: aload 4
        //   83: invokevirtual 91	android/os/Parcel:readInt	()I
        //   86: istore_1
        //   87: iload_1
        //   88: ifeq +19 -> 107
        //   91: aload 4
        //   93: invokevirtual 60	android/os/Parcel:recycle	()V
        //   96: aload_3
        //   97: invokevirtual 60	android/os/Parcel:recycle	()V
        //   100: ldc 112
        //   102: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   105: iload_2
        //   106: ireturn
        //   107: iconst_0
        //   108: istore_2
        //   109: goto -18 -> 91
        //   112: astore 5
        //   114: aload 4
        //   116: invokevirtual 60	android/os/Parcel:recycle	()V
        //   119: aload_3
        //   120: invokevirtual 60	android/os/Parcel:recycle	()V
        //   123: ldc 112
        //   125: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   128: aload 5
        //   130: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	131	0	this	a
        //   0	131	1	paramInt	int
        //   1	108	2	bool	boolean
        //   10	110	3	localParcel1	Parcel
        //   14	101	4	localParcel2	Parcel
        //   112	17	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   16	60	112	finally
        //   76	87	112	finally
      }
      
      public final void bif(String paramString)
      {
        AppMethodBeat.i(79520);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(15, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            f.a.ixk().bif(paramString);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79520);
        }
      }
      
      public final void bk(Bundle paramBundle)
      {
        AppMethodBeat.i(79525);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(20, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            f.a.ixk().bk(paramBundle);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79525);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(79525);
      }
      
      public final String cxY()
      {
        AppMethodBeat.i(298464);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            str = f.a.ixk().cxY();
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
          AppMethodBeat.o(298464);
        }
      }
      
      public final void f(String paramString1, String paramString2, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(79523);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          if ((!this.mRemote.transact(18, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            f.a.ixk().f(paramString1, paramString2, paramInt1, paramInt2);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79523);
        }
      }
      
      public final String getCurrentUrl()
      {
        AppMethodBeat.i(79512);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            str = f.a.ixk().getCurrentUrl();
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
          AppMethodBeat.o(79512);
        }
      }
      
      public final boolean i(int paramInt, Bundle paramBundle)
      {
        boolean bool = true;
        AppMethodBeat.i(79508);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          localParcel1.writeInt(paramInt);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            bool = f.a.ixk().i(paramInt, paramBundle);
            return bool;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79508);
        }
        if (localParcel2.readInt() != 0) {}
        for (;;)
        {
          if (localParcel2.readInt() != 0) {
            paramBundle.readFromParcel(localParcel2);
          }
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79508);
          return bool;
          bool = false;
        }
      }
      
      public final void ioZ()
      {
        AppMethodBeat.i(79518);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          if ((!this.mRemote.transact(13, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            f.a.ixk().ioZ();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79518);
        }
      }
      
      public final String ipa()
      {
        AppMethodBeat.i(79511);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            str = f.a.ixk().ipa();
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
          AppMethodBeat.o(79511);
        }
      }
      
      public final String ipb()
      {
        AppMethodBeat.i(79513);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            str = f.a.ixk().ipb();
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
          AppMethodBeat.o(79513);
        }
      }
      
      public final int ipc()
      {
        AppMethodBeat.i(79514);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            i = f.a.ixk().ipc();
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
          AppMethodBeat.o(79514);
        }
      }
      
      public final void ipd()
      {
        AppMethodBeat.i(79522);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          if ((!this.mRemote.transact(17, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            f.a.ixk().ipd();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79522);
        }
      }
      
      public final Bundle m(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(79524);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          localParcel1.writeInt(paramInt);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(19, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            paramBundle = f.a.ixk().m(paramInt, paramBundle);
            return paramBundle;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79524);
        }
        if (localParcel2.readInt() != 0) {}
        for (paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);; paramBundle = null)
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79524);
          return paramBundle;
        }
      }
      
      /* Error */
      public final Bundle nK(String paramString1, String paramString2)
      {
        // Byte code:
        //   0: ldc 185
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 38
        //   17: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: aload_1
        //   22: invokevirtual 96	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   25: aload_3
        //   26: aload_2
        //   27: invokevirtual 96	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   30: aload_0
        //   31: getfield 20	com/tencent/mm/plugin/webview/stub/f$a$a:mRemote	Landroid/os/IBinder;
        //   34: bipush 23
        //   36: aload_3
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 51 5 0
        //   45: ifne +36 -> 81
        //   48: invokestatic 55	com/tencent/mm/plugin/webview/stub/f$a:ixk	()Lcom/tencent/mm/plugin/webview/stub/f;
        //   51: ifnull +30 -> 81
        //   54: invokestatic 55	com/tencent/mm/plugin/webview/stub/f$a:ixk	()Lcom/tencent/mm/plugin/webview/stub/f;
        //   57: aload_1
        //   58: aload_2
        //   59: invokeinterface 187 3 0
        //   64: astore_1
        //   65: aload 4
        //   67: invokevirtual 60	android/os/Parcel:recycle	()V
        //   70: aload_3
        //   71: invokevirtual 60	android/os/Parcel:recycle	()V
        //   74: ldc 185
        //   76: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   79: aload_1
        //   80: areturn
        //   81: aload 4
        //   83: invokevirtual 66	android/os/Parcel:readException	()V
        //   86: aload 4
        //   88: invokevirtual 91	android/os/Parcel:readInt	()I
        //   91: ifeq +33 -> 124
        //   94: getstatic 176	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   97: aload 4
        //   99: invokeinterface 182 2 0
        //   104: checkcast 98	android/os/Bundle
        //   107: astore_1
        //   108: aload 4
        //   110: invokevirtual 60	android/os/Parcel:recycle	()V
        //   113: aload_3
        //   114: invokevirtual 60	android/os/Parcel:recycle	()V
        //   117: ldc 185
        //   119: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   122: aload_1
        //   123: areturn
        //   124: aconst_null
        //   125: astore_1
        //   126: goto -18 -> 108
        //   129: astore_1
        //   130: aload 4
        //   132: invokevirtual 60	android/os/Parcel:recycle	()V
        //   135: aload_3
        //   136: invokevirtual 60	android/os/Parcel:recycle	()V
        //   139: ldc 185
        //   141: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   144: aload_1
        //   145: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	a
        //   0	146	1	paramString1	String
        //   0	146	2	paramString2	String
        //   8	128	3	localParcel1	Parcel
        //   12	119	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	65	129	finally
        //   81	108	129	finally
      }
      
      public final void nL(String paramString1, String paramString2)
      {
        AppMethodBeat.i(79521);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if ((!this.mRemote.transact(16, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            f.a.ixk().nL(paramString1, paramString2);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79521);
        }
      }
      
      public final void nM(String paramString1, String paramString2)
      {
        AppMethodBeat.i(79527);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if ((!this.mRemote.transact(22, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            f.a.ixk().nM(paramString1, paramString2);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79527);
        }
      }
      
      public final void y(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(79517);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          localParcel1.writeInt(paramInt);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(12, localParcel1, localParcel2, 0)) && (f.a.ixk() != null))
          {
            f.a.ixk().y(paramInt, paramBundle);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(79517);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(79517);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.f
 * JD-Core Version:    0.7.0.1
 */