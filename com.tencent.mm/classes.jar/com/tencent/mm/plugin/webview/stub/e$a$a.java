package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$a$a
  implements e
{
  private IBinder mRemote;
  
  e$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  /* Error */
  public final boolean Ke(int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: sipush 7312
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore_3
    //   12: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   15: astore 4
    //   17: aload_3
    //   18: ldc 35
    //   20: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   23: aload_3
    //   24: iload_1
    //   25: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   28: aload_0
    //   29: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
    //   32: iconst_1
    //   33: aload_3
    //   34: aload 4
    //   36: iconst_0
    //   37: invokeinterface 48 5 0
    //   42: pop
    //   43: aload 4
    //   45: invokevirtual 51	android/os/Parcel:readException	()V
    //   48: aload 4
    //   50: invokevirtual 55	android/os/Parcel:readInt	()I
    //   53: istore_1
    //   54: iload_1
    //   55: ifeq +20 -> 75
    //   58: aload 4
    //   60: invokevirtual 58	android/os/Parcel:recycle	()V
    //   63: aload_3
    //   64: invokevirtual 58	android/os/Parcel:recycle	()V
    //   67: sipush 7312
    //   70: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: iload_2
    //   74: ireturn
    //   75: iconst_0
    //   76: istore_2
    //   77: goto -19 -> 58
    //   80: astore 5
    //   82: aload 4
    //   84: invokevirtual 58	android/os/Parcel:recycle	()V
    //   87: aload_3
    //   88: invokevirtual 58	android/os/Parcel:recycle	()V
    //   91: sipush 7312
    //   94: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload 5
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	a
    //   0	100	1	paramInt	int
    //   1	76	2	bool	boolean
    //   11	77	3	localParcel1	Parcel
    //   15	68	4	localParcel2	Parcel
    //   80	18	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	54	80	finally
  }
  
  /* Error */
  public final boolean a(c paramc)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: sipush 7314
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 4
    //   13: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   16: astore 5
    //   18: aload 4
    //   20: ldc 35
    //   22: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   25: aload_1
    //   26: ifnull +67 -> 93
    //   29: aload_1
    //   30: invokeinterface 68 1 0
    //   35: astore_1
    //   36: aload 4
    //   38: aload_1
    //   39: invokevirtual 71	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   42: aload_0
    //   43: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
    //   46: iconst_3
    //   47: aload 4
    //   49: aload 5
    //   51: iconst_0
    //   52: invokeinterface 48 5 0
    //   57: pop
    //   58: aload 5
    //   60: invokevirtual 51	android/os/Parcel:readException	()V
    //   63: aload 5
    //   65: invokevirtual 55	android/os/Parcel:readInt	()I
    //   68: istore_2
    //   69: iload_2
    //   70: ifeq +5 -> 75
    //   73: iconst_1
    //   74: istore_3
    //   75: aload 5
    //   77: invokevirtual 58	android/os/Parcel:recycle	()V
    //   80: aload 4
    //   82: invokevirtual 58	android/os/Parcel:recycle	()V
    //   85: sipush 7314
    //   88: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: iload_3
    //   92: ireturn
    //   93: aconst_null
    //   94: astore_1
    //   95: goto -59 -> 36
    //   98: astore_1
    //   99: aload 5
    //   101: invokevirtual 58	android/os/Parcel:recycle	()V
    //   104: aload 4
    //   106: invokevirtual 58	android/os/Parcel:recycle	()V
    //   109: sipush 7314
    //   112: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	a
    //   0	117	1	paramc	c
    //   68	2	2	i	int
    //   1	91	3	bool	boolean
    //   11	94	4	localParcel1	Parcel
    //   16	84	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   18	25	98	finally
    //   29	36	98	finally
    //   36	69	98	finally
  }
  
  public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(7315);
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
          break label161;
          localParcel1.writeInt(i);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          i = localParcel2.readInt();
          if (i != 0)
          {
            paramBoolean = bool;
            label102:
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
        AppMethodBeat.o(7315);
      }
      label161:
      do
      {
        i = 0;
        break;
        paramBoolean = false;
        break label102;
      } while (!paramBoolean);
      int i = 1;
    }
  }
  
  /* Error */
  public final void af(Bundle paramBundle)
  {
    // Byte code:
    //   0: sipush 7324
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_2
    //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore_3
    //   14: aload_2
    //   15: ldc 35
    //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: ifnull +48 -> 69
    //   24: aload_2
    //   25: iconst_1
    //   26: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   29: aload_1
    //   30: aload_2
    //   31: iconst_0
    //   32: invokevirtual 81	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
    //   39: bipush 13
    //   41: aload_2
    //   42: aload_3
    //   43: iconst_0
    //   44: invokeinterface 48 5 0
    //   49: pop
    //   50: aload_3
    //   51: invokevirtual 51	android/os/Parcel:readException	()V
    //   54: aload_3
    //   55: invokevirtual 58	android/os/Parcel:recycle	()V
    //   58: aload_2
    //   59: invokevirtual 58	android/os/Parcel:recycle	()V
    //   62: sipush 7324
    //   65: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: return
    //   69: aload_2
    //   70: iconst_0
    //   71: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   74: goto -39 -> 35
    //   77: astore_1
    //   78: aload_3
    //   79: invokevirtual 58	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 58	android/os/Parcel:recycle	()V
    //   86: sipush 7324
    //   89: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	a
    //   0	94	1	paramBundle	Bundle
    //   9	74	2	localParcel1	Parcel
    //   13	66	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   14	20	77	finally
    //   24	35	77	finally
    //   35	54	77	finally
    //   69	74	77	finally
  }
  
  /* Error */
  public final void ag(Bundle paramBundle)
  {
    // Byte code:
    //   0: sipush 7330
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_2
    //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore_3
    //   14: aload_2
    //   15: ldc 35
    //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: ifnull +48 -> 69
    //   24: aload_2
    //   25: iconst_1
    //   26: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   29: aload_1
    //   30: aload_2
    //   31: iconst_0
    //   32: invokevirtual 81	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
    //   39: bipush 19
    //   41: aload_2
    //   42: aload_3
    //   43: iconst_0
    //   44: invokeinterface 48 5 0
    //   49: pop
    //   50: aload_3
    //   51: invokevirtual 51	android/os/Parcel:readException	()V
    //   54: aload_3
    //   55: invokevirtual 58	android/os/Parcel:recycle	()V
    //   58: aload_2
    //   59: invokevirtual 58	android/os/Parcel:recycle	()V
    //   62: sipush 7330
    //   65: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: return
    //   69: aload_2
    //   70: iconst_0
    //   71: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   74: goto -39 -> 35
    //   77: astore_1
    //   78: aload_3
    //   79: invokevirtual 58	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 58	android/os/Parcel:recycle	()V
    //   86: sipush 7330
    //   89: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	a
    //   0	94	1	paramBundle	Bundle
    //   9	74	2	localParcel1	Parcel
    //   13	66	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   14	20	77	finally
    //   24	35	77	finally
    //   35	54	77	finally
    //   69	74	77	finally
  }
  
  public final void ahL(String paramString)
  {
    AppMethodBeat.i(7325);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(14, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7325);
    }
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public final String dcW()
  {
    AppMethodBeat.i(7316);
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
      AppMethodBeat.o(7316);
    }
  }
  
  public final String dcX()
  {
    AppMethodBeat.i(7318);
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
      AppMethodBeat.o(7318);
    }
  }
  
  public final int dcY()
  {
    AppMethodBeat.i(7319);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      this.mRemote.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7319);
    }
  }
  
  public final void dcZ()
  {
    AppMethodBeat.i(7323);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      this.mRemote.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7323);
    }
  }
  
  public final void dda()
  {
    AppMethodBeat.i(7327);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      this.mRemote.transact(16, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7327);
    }
  }
  
  /* Error */
  public final Bundle dm(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 7333
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_3
    //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore 4
    //   15: aload_3
    //   16: ldc 35
    //   18: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   21: aload_3
    //   22: aload_1
    //   23: invokevirtual 75	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   26: aload_3
    //   27: aload_2
    //   28: invokevirtual 75	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
    //   35: bipush 22
    //   37: aload_3
    //   38: aload 4
    //   40: iconst_0
    //   41: invokeinterface 48 5 0
    //   46: pop
    //   47: aload 4
    //   49: invokevirtual 51	android/os/Parcel:readException	()V
    //   52: aload 4
    //   54: invokevirtual 55	android/os/Parcel:readInt	()I
    //   57: ifeq +34 -> 91
    //   60: getstatic 100	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
    //   63: aload 4
    //   65: invokeinterface 106 2 0
    //   70: checkcast 77	android/os/Bundle
    //   73: astore_1
    //   74: aload 4
    //   76: invokevirtual 58	android/os/Parcel:recycle	()V
    //   79: aload_3
    //   80: invokevirtual 58	android/os/Parcel:recycle	()V
    //   83: sipush 7333
    //   86: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_1
    //   90: areturn
    //   91: aconst_null
    //   92: astore_1
    //   93: goto -19 -> 74
    //   96: astore_1
    //   97: aload 4
    //   99: invokevirtual 58	android/os/Parcel:recycle	()V
    //   102: aload_3
    //   103: invokevirtual 58	android/os/Parcel:recycle	()V
    //   106: sipush 7333
    //   109: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	a
    //   0	114	1	paramString1	String
    //   0	114	2	paramString2	String
    //   9	94	3	localParcel1	Parcel
    //   13	85	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   15	74	96	finally
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7328);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      this.mRemote.transact(17, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7328);
    }
  }
  
  public final boolean e(int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(7313);
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
        AppMethodBeat.o(7313);
      }
    }
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(7317);
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
      AppMethodBeat.o(7317);
    }
  }
  
  public final void hu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7326);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.mRemote.transact(15, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7326);
    }
  }
  
  public final void hv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7332);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.mRemote.transact(21, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7332);
    }
  }
  
  public final Bundle i(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(7329);
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
          this.mRemote.transact(18, localParcel1, localParcel2, 0);
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
        AppMethodBeat.o(7329);
      }
    }
  }
  
  public final void om(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(7320);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.mRemote.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7320);
    }
  }
  
  public final void on(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(7321);
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
      AppMethodBeat.o(7321);
    }
  }
  
  public final void oo(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(7331);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.mRemote.transact(20, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7331);
    }
  }
  
  /* Error */
  public final void t(int paramInt, Bundle paramBundle)
  {
    // Byte code:
    //   0: sipush 7322
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_3
    //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore 4
    //   15: aload_3
    //   16: ldc 35
    //   18: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   21: aload_3
    //   22: iload_1
    //   23: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   26: aload_2
    //   27: ifnull +51 -> 78
    //   30: aload_3
    //   31: iconst_1
    //   32: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokevirtual 81	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   41: aload_0
    //   42: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
    //   45: bipush 11
    //   47: aload_3
    //   48: aload 4
    //   50: iconst_0
    //   51: invokeinterface 48 5 0
    //   56: pop
    //   57: aload 4
    //   59: invokevirtual 51	android/os/Parcel:readException	()V
    //   62: aload 4
    //   64: invokevirtual 58	android/os/Parcel:recycle	()V
    //   67: aload_3
    //   68: invokevirtual 58	android/os/Parcel:recycle	()V
    //   71: sipush 7322
    //   74: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: return
    //   78: aload_3
    //   79: iconst_0
    //   80: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   83: goto -42 -> 41
    //   86: astore_2
    //   87: aload 4
    //   89: invokevirtual 58	android/os/Parcel:recycle	()V
    //   92: aload_3
    //   93: invokevirtual 58	android/os/Parcel:recycle	()V
    //   96: sipush 7322
    //   99: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_2
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	a
    //   0	104	1	paramInt	int
    //   0	104	2	paramBundle	Bundle
    //   9	84	3	localParcel1	Parcel
    //   13	75	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   15	26	86	finally
    //   30	41	86	finally
    //   41	62	86	finally
    //   78	83	86	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.e.a.a
 * JD-Core Version:    0.7.0.1
 */