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
  public abstract boolean Tj(int paramInt);
  
  public abstract boolean a(d paramd);
  
  public abstract boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean);
  
  public abstract void axu(String paramString);
  
  public abstract void ay(Bundle paramBundle);
  
  public abstract void az(Bundle paramBundle);
  
  public abstract String dvR();
  
  public abstract void e(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void ekt();
  
  public abstract void eku();
  
  public abstract String ene();
  
  public abstract int enf();
  
  public abstract String eng();
  
  public abstract Bundle ev(String paramString1, String paramString2);
  
  public abstract boolean f(int paramInt, Bundle paramBundle);
  
  public abstract String getCurrentUrl();
  
  public abstract Bundle j(int paramInt, Bundle paramBundle);
  
  public abstract void kd(String paramString1, String paramString2);
  
  public abstract void ke(String paramString1, String paramString2);
  
  public abstract void t(int paramInt, Bundle paramBundle);
  
  public abstract void to(boolean paramBoolean);
  
  public abstract void tp(boolean paramBoolean);
  
  public abstract void tq(boolean paramBoolean);
  
  public static abstract class a
    extends Binder
    implements f
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
    }
    
    public static f H(IBinder paramIBinder)
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
        bool1 = Tj(paramParcel1.readInt());
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
        bool1 = f(paramInt1, (Bundle)localObject1);
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
        paramParcel1 = ene();
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
        paramParcel1 = dvR();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        paramParcel1 = eng();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        paramInt1 = enf();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        to(bool1);
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        bool1 = bool2;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        tp(bool1);
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        paramInt1 = paramParcel1.readInt();
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        t(paramInt1, (Bundle)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        eku();
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        localObject1 = localObject3;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        ay((Bundle)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        axu(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        kd(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        ekt();
        paramParcel2.writeNoException();
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        e(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        paramInt1 = paramParcel1.readInt();
        localObject1 = localObject4;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = j(paramInt1, (Bundle)localObject1);
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
        az((Bundle)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        bool1 = bool3;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        tq(bool1);
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        ke(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      paramParcel1 = ev(paramParcel1.readString(), paramParcel1.readString());
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
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public final boolean Tj(int paramInt)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: ldc 22
        //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_3
        //   11: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   14: astore 4
        //   16: aload_3
        //   17: ldc 36
        //   19: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload_3
        //   23: iload_1
        //   24: invokevirtual 43	android/os/Parcel:writeInt	(I)V
        //   27: aload_0
        //   28: getfield 18	com/tencent/mm/plugin/webview/stub/f$a$a:mRemote	Landroid/os/IBinder;
        //   31: iconst_1
        //   32: aload_3
        //   33: aload 4
        //   35: iconst_0
        //   36: invokeinterface 49 5 0
        //   41: pop
        //   42: aload 4
        //   44: invokevirtual 52	android/os/Parcel:readException	()V
        //   47: aload 4
        //   49: invokevirtual 56	android/os/Parcel:readInt	()I
        //   52: istore_1
        //   53: iload_1
        //   54: ifeq +19 -> 73
        //   57: aload 4
        //   59: invokevirtual 59	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 59	android/os/Parcel:recycle	()V
        //   66: ldc 22
        //   68: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   71: iload_2
        //   72: ireturn
        //   73: iconst_0
        //   74: istore_2
        //   75: goto -18 -> 57
        //   78: astore 5
        //   80: aload 4
        //   82: invokevirtual 59	android/os/Parcel:recycle	()V
        //   85: aload_3
        //   86: invokevirtual 59	android/os/Parcel:recycle	()V
        //   89: ldc 22
        //   91: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   94: aload 5
        //   96: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	a
        //   0	97	1	paramInt	int
        //   1	74	2	bool	boolean
        //   10	76	3	localParcel1	Parcel
        //   14	67	4	localParcel2	Parcel
        //   78	17	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   16	53	78	finally
      }
      
      /* Error */
      public final boolean a(d paramd)
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_3
        //   2: ldc 64
        //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 4
        //   12: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   15: astore 5
        //   17: aload 4
        //   19: ldc 36
        //   21: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   24: aload_1
        //   25: ifnull +66 -> 91
        //   28: aload_1
        //   29: invokeinterface 70 1 0
        //   34: astore_1
        //   35: aload 4
        //   37: aload_1
        //   38: invokevirtual 73	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   41: aload_0
        //   42: getfield 18	com/tencent/mm/plugin/webview/stub/f$a$a:mRemote	Landroid/os/IBinder;
        //   45: iconst_3
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 49 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 52	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 56	android/os/Parcel:readInt	()I
        //   67: istore_2
        //   68: iload_2
        //   69: ifeq +5 -> 74
        //   72: iconst_1
        //   73: istore_3
        //   74: aload 5
        //   76: invokevirtual 59	android/os/Parcel:recycle	()V
        //   79: aload 4
        //   81: invokevirtual 59	android/os/Parcel:recycle	()V
        //   84: ldc 64
        //   86: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   89: iload_3
        //   90: ireturn
        //   91: aconst_null
        //   92: astore_1
        //   93: goto -58 -> 35
        //   96: astore_1
        //   97: aload 5
        //   99: invokevirtual 59	android/os/Parcel:recycle	()V
        //   102: aload 4
        //   104: invokevirtual 59	android/os/Parcel:recycle	()V
        //   107: ldc 64
        //   109: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   112: aload_1
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	a
        //   0	114	1	paramd	d
        //   67	2	2	i	int
        //   1	89	3	bool	boolean
        //   10	93	4	localParcel1	Parcel
        //   15	83	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   17	24	96	finally
        //   28	35	96	finally
        //   35	68	96	finally
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
              break label158;
              localParcel1.writeInt(i);
              this.mRemote.transact(4, localParcel1, localParcel2, 0);
              localParcel2.readException();
              i = localParcel2.readInt();
              if (i != 0)
              {
                paramBoolean = bool;
                label101:
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
          label158:
          do
          {
            i = 0;
            break;
            paramBoolean = false;
            break label101;
          } while (!paramBoolean);
          int i = 1;
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void axu(String paramString)
      {
        AppMethodBeat.i(79520);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public final void ay(Bundle paramBundle)
      {
        // Byte code:
        //   0: ldc 89
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 36
        //   16: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +47 -> 67
        //   23: aload_2
        //   24: iconst_1
        //   25: invokevirtual 43	android/os/Parcel:writeInt	(I)V
        //   28: aload_1
        //   29: aload_2
        //   30: iconst_0
        //   31: invokevirtual 84	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload_0
        //   35: getfield 18	com/tencent/mm/plugin/webview/stub/f$a$a:mRemote	Landroid/os/IBinder;
        //   38: bipush 14
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokeinterface 49 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 52	android/os/Parcel:readException	()V
        //   53: aload_3
        //   54: invokevirtual 59	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 59	android/os/Parcel:recycle	()V
        //   61: ldc 89
        //   63: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   66: return
        //   67: aload_2
        //   68: iconst_0
        //   69: invokevirtual 43	android/os/Parcel:writeInt	(I)V
        //   72: goto -38 -> 34
        //   75: astore_1
        //   76: aload_3
        //   77: invokevirtual 59	android/os/Parcel:recycle	()V
        //   80: aload_2
        //   81: invokevirtual 59	android/os/Parcel:recycle	()V
        //   84: ldc 89
        //   86: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   89: aload_1
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	a
        //   0	91	1	paramBundle	Bundle
        //   8	73	2	localParcel1	Parcel
        //   12	65	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	75	finally
        //   23	34	75	finally
        //   34	53	75	finally
        //   67	72	75	finally
      }
      
      /* Error */
      public final void az(Bundle paramBundle)
      {
        // Byte code:
        //   0: ldc 91
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 36
        //   16: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +47 -> 67
        //   23: aload_2
        //   24: iconst_1
        //   25: invokevirtual 43	android/os/Parcel:writeInt	(I)V
        //   28: aload_1
        //   29: aload_2
        //   30: iconst_0
        //   31: invokevirtual 84	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload_0
        //   35: getfield 18	com/tencent/mm/plugin/webview/stub/f$a$a:mRemote	Landroid/os/IBinder;
        //   38: bipush 20
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokeinterface 49 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 52	android/os/Parcel:readException	()V
        //   53: aload_3
        //   54: invokevirtual 59	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 59	android/os/Parcel:recycle	()V
        //   61: ldc 91
        //   63: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   66: return
        //   67: aload_2
        //   68: iconst_0
        //   69: invokevirtual 43	android/os/Parcel:writeInt	(I)V
        //   72: goto -38 -> 34
        //   75: astore_1
        //   76: aload_3
        //   77: invokevirtual 59	android/os/Parcel:recycle	()V
        //   80: aload_2
        //   81: invokevirtual 59	android/os/Parcel:recycle	()V
        //   84: ldc 91
        //   86: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   89: aload_1
        //   90: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	a
        //   0	91	1	paramBundle	Bundle
        //   8	73	2	localParcel1	Parcel
        //   12	65	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	75	finally
        //   23	34	75	finally
        //   34	53	75	finally
        //   67	72	75	finally
      }
      
      public final String dvR()
      {
        AppMethodBeat.i(189768);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(189768);
        }
      }
      
      public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
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
          this.mRemote.transact(18, localParcel1, localParcel2, 0);
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
      
      public final void ekt()
      {
        AppMethodBeat.i(79522);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          this.mRemote.transact(17, localParcel1, localParcel2, 0);
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
      
      public final void eku()
      {
        AppMethodBeat.i(79518);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
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
      
      public final String ene()
      {
        AppMethodBeat.i(79511);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
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
      
      public final int enf()
      {
        AppMethodBeat.i(79514);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
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
      
      public final String eng()
      {
        AppMethodBeat.i(79513);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public final Bundle ev(String paramString1, String paramString2)
      {
        // Byte code:
        //   0: ldc 113
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 36
        //   17: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: aload_1
        //   22: invokevirtual 78	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   25: aload_3
        //   26: aload_2
        //   27: invokevirtual 78	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   30: aload_0
        //   31: getfield 18	com/tencent/mm/plugin/webview/stub/f$a$a:mRemote	Landroid/os/IBinder;
        //   34: bipush 23
        //   36: aload_3
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 49 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 52	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 56	android/os/Parcel:readInt	()I
        //   56: ifeq +33 -> 89
        //   59: getstatic 117	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   62: aload 4
        //   64: invokeinterface 123 2 0
        //   69: checkcast 80	android/os/Bundle
        //   72: astore_1
        //   73: aload 4
        //   75: invokevirtual 59	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: invokevirtual 59	android/os/Parcel:recycle	()V
        //   82: ldc 113
        //   84: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   87: aload_1
        //   88: areturn
        //   89: aconst_null
        //   90: astore_1
        //   91: goto -18 -> 73
        //   94: astore_1
        //   95: aload 4
        //   97: invokevirtual 59	android/os/Parcel:recycle	()V
        //   100: aload_3
        //   101: invokevirtual 59	android/os/Parcel:recycle	()V
        //   104: ldc 113
        //   106: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   109: aload_1
        //   110: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	111	0	this	a
        //   0	111	1	paramString1	String
        //   0	111	2	paramString2	String
        //   8	93	3	localParcel1	Parcel
        //   12	84	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	73	94	finally
      }
      
      public final boolean f(int paramInt, Bundle paramBundle)
      {
        boolean bool = true;
        AppMethodBeat.i(79508);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
            localParcel1.writeInt(paramInt);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(2, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                if (localParcel2.readInt() != 0) {
                  paramBundle.readFromParcel(localParcel2);
                }
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
            AppMethodBeat.o(79508);
          }
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
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
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
      
      public final Bundle j(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(79524);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
            localParcel1.writeInt(paramInt);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(19, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramBundle;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramBundle = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
            AppMethodBeat.o(79524);
          }
        }
      }
      
      public final void kd(String paramString1, String paramString2)
      {
        AppMethodBeat.i(79521);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
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
      
      public final void ke(String paramString1, String paramString2)
      {
        AppMethodBeat.i(79527);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(22, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public final void t(int paramInt, Bundle paramBundle)
      {
        // Byte code:
        //   0: ldc 143
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
        //   25: aload_2
        //   26: ifnull +50 -> 76
        //   29: aload_3
        //   30: iconst_1
        //   31: invokevirtual 43	android/os/Parcel:writeInt	(I)V
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokevirtual 84	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   40: aload_0
        //   41: getfield 18	com/tencent/mm/plugin/webview/stub/f$a$a:mRemote	Landroid/os/IBinder;
        //   44: bipush 12
        //   46: aload_3
        //   47: aload 4
        //   49: iconst_0
        //   50: invokeinterface 49 5 0
        //   55: pop
        //   56: aload 4
        //   58: invokevirtual 52	android/os/Parcel:readException	()V
        //   61: aload 4
        //   63: invokevirtual 59	android/os/Parcel:recycle	()V
        //   66: aload_3
        //   67: invokevirtual 59	android/os/Parcel:recycle	()V
        //   70: ldc 143
        //   72: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: return
        //   76: aload_3
        //   77: iconst_0
        //   78: invokevirtual 43	android/os/Parcel:writeInt	(I)V
        //   81: goto -41 -> 40
        //   84: astore_2
        //   85: aload 4
        //   87: invokevirtual 59	android/os/Parcel:recycle	()V
        //   90: aload_3
        //   91: invokevirtual 59	android/os/Parcel:recycle	()V
        //   94: ldc 143
        //   96: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   99: aload_2
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	a
        //   0	101	1	paramInt	int
        //   0	101	2	paramBundle	Bundle
        //   8	83	3	localParcel1	Parcel
        //   12	74	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	25	84	finally
        //   29	40	84	finally
        //   40	61	84	finally
        //   76	81	84	finally
      }
      
      public final void to(boolean paramBoolean)
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
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
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
      
      public final void tp(boolean paramBoolean)
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
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
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
      
      public final void tq(boolean paramBoolean)
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
          this.mRemote.transact(21, localParcel1, localParcel2, 0);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.f
 * JD-Core Version:    0.7.0.1
 */