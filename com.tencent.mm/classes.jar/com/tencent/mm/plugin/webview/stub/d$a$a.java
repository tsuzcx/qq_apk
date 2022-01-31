package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class d$a$a
  implements d
{
  private IBinder mRemote;
  
  d$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public final void I(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(7306);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeInt(paramInt);
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.mRemote.transact(72, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7306);
    }
  }
  
  /* Error */
  public final Bundle Kf(int paramInt)
  {
    // Byte code:
    //   0: sipush 7267
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
    //   26: aload_0
    //   27: getfield 18	com/tencent/mm/plugin/webview/stub/d$a$a:mRemote	Landroid/os/IBinder;
    //   30: bipush 33
    //   32: aload_3
    //   33: aload 4
    //   35: iconst_0
    //   36: invokeinterface 51 5 0
    //   41: pop
    //   42: aload 4
    //   44: invokevirtual 54	android/os/Parcel:readException	()V
    //   47: aload 4
    //   49: invokevirtual 66	android/os/Parcel:readInt	()I
    //   52: ifeq +34 -> 86
    //   55: getstatic 72	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
    //   58: aload 4
    //   60: invokeinterface 78 2 0
    //   65: checkcast 68	android/os/Bundle
    //   68: astore_2
    //   69: aload 4
    //   71: invokevirtual 57	android/os/Parcel:recycle	()V
    //   74: aload_3
    //   75: invokevirtual 57	android/os/Parcel:recycle	()V
    //   78: sipush 7267
    //   81: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_2
    //   85: areturn
    //   86: aconst_null
    //   87: astore_2
    //   88: goto -19 -> 69
    //   91: astore_2
    //   92: aload 4
    //   94: invokevirtual 57	android/os/Parcel:recycle	()V
    //   97: aload_3
    //   98: invokevirtual 57	android/os/Parcel:recycle	()V
    //   101: sipush 7267
    //   104: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_2
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	a
    //   0	109	1	paramInt	int
    //   68	20	2	localBundle	Bundle
    //   91	17	2	localObject	Object
    //   9	89	3	localParcel1	Parcel
    //   13	80	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   15	69	91	finally
  }
  
  public final boolean Kg(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(7268);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(34, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7268);
    }
  }
  
  public final void Kh(int paramInt)
  {
    AppMethodBeat.i(7276);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(42, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7276);
    }
  }
  
  public final void Ki(int paramInt)
  {
    AppMethodBeat.i(7294);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(60, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7294);
    }
  }
  
  public final void Kj(int paramInt)
  {
    AppMethodBeat.i(7292);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(58, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7292);
    }
  }
  
  public final void Kk(int paramInt)
  {
    AppMethodBeat.i(7293);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(59, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7293);
    }
  }
  
  public final boolean Mi()
  {
    boolean bool = false;
    AppMethodBeat.i(7241);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(7, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7241);
    }
  }
  
  public final void Q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(7270);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(36, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7270);
    }
  }
  
  public final boolean ZT()
  {
    boolean bool = false;
    AppMethodBeat.i(7244);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(10, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7244);
    }
  }
  
  /* Error */
  public final void a(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    // Byte code:
    //   0: sipush 7248
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   14: astore 5
    //   16: aload 4
    //   18: ldc 35
    //   20: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   23: aload 4
    //   25: iload_1
    //   26: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: ifnull +61 -> 91
    //   33: aload 4
    //   35: iconst_1
    //   36: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   39: aload_2
    //   40: aload 4
    //   42: iconst_0
    //   43: invokevirtual 94	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload 4
    //   48: iload_3
    //   49: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   52: aload_0
    //   53: getfield 18	com/tencent/mm/plugin/webview/stub/d$a$a:mRemote	Landroid/os/IBinder;
    //   56: bipush 14
    //   58: aload 4
    //   60: aload 5
    //   62: iconst_0
    //   63: invokeinterface 51 5 0
    //   68: pop
    //   69: aload 5
    //   71: invokevirtual 54	android/os/Parcel:readException	()V
    //   74: aload 5
    //   76: invokevirtual 57	android/os/Parcel:recycle	()V
    //   79: aload 4
    //   81: invokevirtual 57	android/os/Parcel:recycle	()V
    //   84: sipush 7248
    //   87: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: return
    //   91: aload 4
    //   93: iconst_0
    //   94: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   97: goto -51 -> 46
    //   100: astore_2
    //   101: aload 5
    //   103: invokevirtual 57	android/os/Parcel:recycle	()V
    //   106: aload 4
    //   108: invokevirtual 57	android/os/Parcel:recycle	()V
    //   111: sipush 7248
    //   114: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	a
    //   0	119	1	paramInt1	int
    //   0	119	2	paramBundle	Bundle
    //   0	119	3	paramInt2	int
    //   9	98	4	localParcel1	Parcel
    //   14	88	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   16	29	100	finally
    //   33	46	100	finally
    //   46	74	100	finally
    //   91	97	100	finally
  }
  
  /* Error */
  public final void a(Bundle paramBundle, int paramInt)
  {
    // Byte code:
    //   0: sipush 7308
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_3
    //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore 4
    //   15: aload_3
    //   16: ldc 35
    //   18: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: ifnull +56 -> 78
    //   25: aload_3
    //   26: iconst_1
    //   27: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   30: aload_1
    //   31: aload_3
    //   32: iconst_0
    //   33: invokevirtual 94	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   36: aload_3
    //   37: iload_2
    //   38: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   41: aload_0
    //   42: getfield 18	com/tencent/mm/plugin/webview/stub/d$a$a:mRemote	Landroid/os/IBinder;
    //   45: bipush 74
    //   47: aload_3
    //   48: aload 4
    //   50: iconst_0
    //   51: invokeinterface 51 5 0
    //   56: pop
    //   57: aload 4
    //   59: invokevirtual 54	android/os/Parcel:readException	()V
    //   62: aload 4
    //   64: invokevirtual 57	android/os/Parcel:recycle	()V
    //   67: aload_3
    //   68: invokevirtual 57	android/os/Parcel:recycle	()V
    //   71: sipush 7308
    //   74: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: return
    //   78: aload_3
    //   79: iconst_0
    //   80: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   83: goto -47 -> 36
    //   86: astore_1
    //   87: aload 4
    //   89: invokevirtual 57	android/os/Parcel:recycle	()V
    //   92: aload_3
    //   93: invokevirtual 57	android/os/Parcel:recycle	()V
    //   96: sipush 7308
    //   99: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	a
    //   0	104	1	paramBundle	Bundle
    //   0	104	2	paramInt	int
    //   9	84	3	localParcel1	Parcel
    //   13	75	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   15	21	86	finally
    //   25	36	86	finally
    //   36	62	86	finally
    //   78	83	86	finally
  }
  
  /* Error */
  public final void a(e parame, int paramInt)
  {
    // Byte code:
    //   0: sipush 7275
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_3
    //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore 4
    //   15: aload_3
    //   16: ldc 35
    //   18: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: ifnull +57 -> 79
    //   25: aload_1
    //   26: invokeinterface 102 1 0
    //   31: astore_1
    //   32: aload_3
    //   33: aload_1
    //   34: invokevirtual 105	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   37: aload_3
    //   38: iload_2
    //   39: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   42: aload_0
    //   43: getfield 18	com/tencent/mm/plugin/webview/stub/d$a$a:mRemote	Landroid/os/IBinder;
    //   46: bipush 41
    //   48: aload_3
    //   49: aload 4
    //   51: iconst_0
    //   52: invokeinterface 51 5 0
    //   57: pop
    //   58: aload 4
    //   60: invokevirtual 54	android/os/Parcel:readException	()V
    //   63: aload 4
    //   65: invokevirtual 57	android/os/Parcel:recycle	()V
    //   68: aload_3
    //   69: invokevirtual 57	android/os/Parcel:recycle	()V
    //   72: sipush 7275
    //   75: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -49 -> 32
    //   84: astore_1
    //   85: aload 4
    //   87: invokevirtual 57	android/os/Parcel:recycle	()V
    //   90: aload_3
    //   91: invokevirtual 57	android/os/Parcel:recycle	()V
    //   94: sipush 7275
    //   97: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	a
    //   0	102	1	parame	e
    //   0	102	2	paramInt	int
    //   9	82	3	localParcel1	Parcel
    //   13	73	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   15	21	84	finally
    //   25	32	84	finally
    //   32	63	84	finally
  }
  
  /* Error */
  public final void a(String paramString, Bundle paramBundle, int paramInt)
  {
    // Byte code:
    //   0: sipush 7271
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   14: astore 5
    //   16: aload 4
    //   18: ldc 35
    //   20: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   23: aload 4
    //   25: aload_1
    //   26: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   29: aload_2
    //   30: ifnull +61 -> 91
    //   33: aload 4
    //   35: iconst_1
    //   36: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   39: aload_2
    //   40: aload 4
    //   42: iconst_0
    //   43: invokevirtual 94	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload 4
    //   48: iload_3
    //   49: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   52: aload_0
    //   53: getfield 18	com/tencent/mm/plugin/webview/stub/d$a$a:mRemote	Landroid/os/IBinder;
    //   56: bipush 37
    //   58: aload 4
    //   60: aload 5
    //   62: iconst_0
    //   63: invokeinterface 51 5 0
    //   68: pop
    //   69: aload 5
    //   71: invokevirtual 54	android/os/Parcel:readException	()V
    //   74: aload 5
    //   76: invokevirtual 57	android/os/Parcel:recycle	()V
    //   79: aload 4
    //   81: invokevirtual 57	android/os/Parcel:recycle	()V
    //   84: sipush 7271
    //   87: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: return
    //   91: aload 4
    //   93: iconst_0
    //   94: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   97: goto -51 -> 46
    //   100: astore_1
    //   101: aload 5
    //   103: invokevirtual 57	android/os/Parcel:recycle	()V
    //   106: aload 4
    //   108: invokevirtual 57	android/os/Parcel:recycle	()V
    //   111: sipush 7271
    //   114: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_1
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	a
    //   0	119	1	paramString	String
    //   0	119	2	paramBundle	Bundle
    //   0	119	3	paramInt	int
    //   9	98	4	localParcel1	Parcel
    //   14	88	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   16	29	100	finally
    //   33	46	100	finally
    //   46	74	100	finally
    //   91	97	100	finally
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    // Byte code:
    //   0: sipush 7303
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 7
    //   11: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   14: astore 8
    //   16: aload 7
    //   18: ldc 35
    //   20: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   23: aload 7
    //   25: aload_1
    //   26: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   29: aload 7
    //   31: aload_2
    //   32: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   35: aload 7
    //   37: aload_3
    //   38: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   41: aload 7
    //   43: iload 4
    //   45: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   48: aload 7
    //   50: iload 5
    //   52: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   55: aload 6
    //   57: ifnull +56 -> 113
    //   60: aload 7
    //   62: iconst_1
    //   63: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   66: aload 6
    //   68: aload 7
    //   70: iconst_0
    //   71: invokevirtual 94	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   74: aload_0
    //   75: getfield 18	com/tencent/mm/plugin/webview/stub/d$a$a:mRemote	Landroid/os/IBinder;
    //   78: bipush 69
    //   80: aload 7
    //   82: aload 8
    //   84: iconst_0
    //   85: invokeinterface 51 5 0
    //   90: pop
    //   91: aload 8
    //   93: invokevirtual 54	android/os/Parcel:readException	()V
    //   96: aload 8
    //   98: invokevirtual 57	android/os/Parcel:recycle	()V
    //   101: aload 7
    //   103: invokevirtual 57	android/os/Parcel:recycle	()V
    //   106: sipush 7303
    //   109: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: return
    //   113: aload 7
    //   115: iconst_0
    //   116: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   119: goto -45 -> 74
    //   122: astore_1
    //   123: aload 8
    //   125: invokevirtual 57	android/os/Parcel:recycle	()V
    //   128: aload 7
    //   130: invokevirtual 57	android/os/Parcel:recycle	()V
    //   133: sipush 7303
    //   136: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	a
    //   0	141	1	paramString1	String
    //   0	141	2	paramString2	String
    //   0	141	3	paramString3	String
    //   0	141	4	paramInt1	int
    //   0	141	5	paramInt2	int
    //   0	141	6	paramBundle	Bundle
    //   9	120	7	localParcel1	Parcel
    //   14	110	8	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   16	55	122	finally
    //   60	74	122	finally
    //   74	96	122	finally
    //   113	119	122	finally
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7301);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      localParcel1.writeIntArray(paramArrayOfInt);
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      this.mRemote.transact(67, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7301);
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, Bundle paramBundle1, Bundle paramBundle2, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(7269);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeString(paramString3);
        if (paramBundle1 != null)
        {
          localParcel1.writeInt(1);
          paramBundle1.writeToParcel(localParcel1, 0);
          if (paramBundle2 != null)
          {
            localParcel1.writeInt(1);
            paramBundle2.writeToParcel(localParcel1, 0);
            localParcel1.writeInt(paramInt);
            this.mRemote.transact(35, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramInt = localParcel2.readInt();
            if (paramInt == 0) {
              break label179;
            }
            return bool;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(7269);
      }
      continue;
      label179:
      bool = false;
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(7259);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    label152:
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        localParcel1.writeString(paramString);
        int i;
        if (paramBoolean)
        {
          i = 1;
          localParcel1.writeInt(i);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.mRemote.transact(25, localParcel1, localParcel2, 0);
            localParcel2.readException();
            i = localParcel2.readInt();
            if (i == 0) {
              break label152;
            }
            paramBoolean = bool;
            return paramBoolean;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        localParcel1.writeInt(0);
        continue;
        paramBoolean = false;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(7259);
      }
    }
  }
  
  /* Error */
  public final void aA(android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: sipush 7305
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
    //   32: invokevirtual 119	android/content/Intent:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 18	com/tencent/mm/plugin/webview/stub/d$a$a:mRemote	Landroid/os/IBinder;
    //   39: bipush 71
    //   41: aload_2
    //   42: aload_3
    //   43: iconst_0
    //   44: invokeinterface 51 5 0
    //   49: pop
    //   50: aload_3
    //   51: invokevirtual 54	android/os/Parcel:readException	()V
    //   54: aload_3
    //   55: invokevirtual 57	android/os/Parcel:recycle	()V
    //   58: aload_2
    //   59: invokevirtual 57	android/os/Parcel:recycle	()V
    //   62: sipush 7305
    //   65: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: return
    //   69: aload_2
    //   70: iconst_0
    //   71: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   74: goto -39 -> 35
    //   77: astore_1
    //   78: aload_3
    //   79: invokevirtual 57	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 57	android/os/Parcel:recycle	()V
    //   86: sipush 7305
    //   89: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	a
    //   0	94	1	paramIntent	android.content.Intent
    //   9	74	2	localParcel1	Parcel
    //   13	66	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   14	20	77	finally
    //   24	35	77	finally
    //   35	54	77	finally
    //   69	74	77	finally
  }
  
  public final List<String> aeT()
  {
    AppMethodBeat.i(7257);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(23, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ArrayList localArrayList = localParcel2.createStringArrayList();
      return localArrayList;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7257);
    }
  }
  
  public final boolean aeU()
  {
    boolean bool = false;
    AppMethodBeat.i(7256);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(22, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7256);
    }
  }
  
  public final String agU(String paramString)
  {
    AppMethodBeat.i(7279);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(45, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7279);
    }
  }
  
  public final String ahN(String paramString)
  {
    AppMethodBeat.i(7240);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7240);
    }
  }
  
  public final String ahO(String paramString)
  {
    AppMethodBeat.i(7260);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(26, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7260);
    }
  }
  
  public final void ahP(String paramString)
  {
    AppMethodBeat.i(7272);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(38, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7272);
    }
  }
  
  public final String ahQ(String paramString)
  {
    AppMethodBeat.i(7273);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(39, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7273);
    }
  }
  
  /* Error */
  public final boolean ahR(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: sipush 7235
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 4
    //   13: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   16: astore 5
    //   18: aload 4
    //   20: ldc 35
    //   22: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   25: aload 4
    //   27: aload_1
    //   28: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 18	com/tencent/mm/plugin/webview/stub/d$a$a:mRemote	Landroid/os/IBinder;
    //   35: iconst_1
    //   36: aload 4
    //   38: aload 5
    //   40: iconst_0
    //   41: invokeinterface 51 5 0
    //   46: pop
    //   47: aload 5
    //   49: invokevirtual 54	android/os/Parcel:readException	()V
    //   52: aload 5
    //   54: invokevirtual 66	android/os/Parcel:readInt	()I
    //   57: istore_2
    //   58: iload_2
    //   59: ifeq +21 -> 80
    //   62: aload 5
    //   64: invokevirtual 57	android/os/Parcel:recycle	()V
    //   67: aload 4
    //   69: invokevirtual 57	android/os/Parcel:recycle	()V
    //   72: sipush 7235
    //   75: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iload_3
    //   79: ireturn
    //   80: iconst_0
    //   81: istore_3
    //   82: goto -20 -> 62
    //   85: astore_1
    //   86: aload 5
    //   88: invokevirtual 57	android/os/Parcel:recycle	()V
    //   91: aload 4
    //   93: invokevirtual 57	android/os/Parcel:recycle	()V
    //   96: sipush 7235
    //   99: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	a
    //   0	104	1	paramString	String
    //   57	2	2	i	int
    //   1	81	3	bool	boolean
    //   11	81	4	localParcel1	Parcel
    //   16	71	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   18	58	85	finally
  }
  
  public final String ahS(String paramString)
  {
    AppMethodBeat.i(7281);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(47, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7281);
    }
  }
  
  public final void ahT(String paramString)
  {
    AppMethodBeat.i(7284);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(50, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7284);
    }
  }
  
  public final int ahU(String paramString)
  {
    AppMethodBeat.i(7251);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(17, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7251);
    }
  }
  
  public final void ahV(String paramString)
  {
    AppMethodBeat.i(7255);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(21, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7255);
    }
  }
  
  public final void ahW(String paramString)
  {
    AppMethodBeat.i(7302);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(68, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7302);
    }
  }
  
  public final String ahX(String paramString)
  {
    AppMethodBeat.i(7297);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(63, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7297);
    }
  }
  
  /* Error */
  public final b ai(Bundle paramBundle)
  {
    // Byte code:
    //   0: sipush 7249
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_2
    //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore_3
    //   14: aload_2
    //   15: ldc 35
    //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: ifnull +57 -> 78
    //   24: aload_2
    //   25: iconst_1
    //   26: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   29: aload_1
    //   30: aload_2
    //   31: iconst_0
    //   32: invokevirtual 94	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 18	com/tencent/mm/plugin/webview/stub/d$a$a:mRemote	Landroid/os/IBinder;
    //   39: bipush 15
    //   41: aload_2
    //   42: aload_3
    //   43: iconst_0
    //   44: invokeinterface 51 5 0
    //   49: pop
    //   50: aload_3
    //   51: invokevirtual 54	android/os/Parcel:readException	()V
    //   54: aload_3
    //   55: invokevirtual 152	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   58: invokestatic 158	com/tencent/mm/plugin/webview/stub/b$a:E	(Landroid/os/IBinder;)Lcom/tencent/mm/plugin/webview/stub/b;
    //   61: astore_1
    //   62: aload_3
    //   63: invokevirtual 57	android/os/Parcel:recycle	()V
    //   66: aload_2
    //   67: invokevirtual 57	android/os/Parcel:recycle	()V
    //   70: sipush 7249
    //   73: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_1
    //   77: areturn
    //   78: aload_2
    //   79: iconst_0
    //   80: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   83: goto -48 -> 35
    //   86: astore_1
    //   87: aload_3
    //   88: invokevirtual 57	android/os/Parcel:recycle	()V
    //   91: aload_2
    //   92: invokevirtual 57	android/os/Parcel:recycle	()V
    //   95: sipush 7249
    //   98: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	a
    //   0	103	1	paramBundle	Bundle
    //   9	83	2	localParcel1	Parcel
    //   13	75	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   14	20	86	finally
    //   24	35	86	finally
    //   35	62	86	finally
    //   78	83	86	finally
  }
  
  public final boolean aj(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(7250);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
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
        AppMethodBeat.o(7250);
      }
    }
  }
  
  public final void an(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(7274);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      localParcel1.writeInt(paramInt3);
      this.mRemote.transact(40, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7274);
    }
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public final String bF(int paramInt, String paramString)
  {
    AppMethodBeat.i(7247);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeInt(paramInt);
      localParcel1.writeString(paramString);
      this.mRemote.transact(13, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7247);
    }
  }
  
  public final void bN(String paramString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(7262);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.mRemote.transact(28, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7262);
    }
  }
  
  public final boolean dM(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(7263);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(29, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7263);
    }
  }
  
  public final void dO(String paramString, int paramInt)
  {
    AppMethodBeat.i(7261);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(27, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7261);
    }
  }
  
  public final String dP(String paramString, int paramInt)
  {
    AppMethodBeat.i(7285);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(51, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7285);
    }
  }
  
  public final void dQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(7295);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(61, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7295);
    }
  }
  
  public final boolean ddb()
  {
    boolean bool = false;
    AppMethodBeat.i(7243);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(9, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7243);
    }
  }
  
  public final String[] ddc()
  {
    AppMethodBeat.i(7277);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(43, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String[] arrayOfString = localParcel2.createStringArray();
      return arrayOfString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7277);
    }
  }
  
  public final String ddd()
  {
    AppMethodBeat.i(7278);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(44, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7278);
    }
  }
  
  public final String dde()
  {
    AppMethodBeat.i(7280);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(46, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7280);
    }
  }
  
  public final String ddf()
  {
    AppMethodBeat.i(7287);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(53, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7287);
    }
  }
  
  public final Map ddg()
  {
    AppMethodBeat.i(7282);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(48, localParcel1, localParcel2, 0);
      localParcel2.readException();
      HashMap localHashMap = localParcel2.readHashMap(getClass().getClassLoader());
      return localHashMap;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7282);
    }
  }
  
  public final int ddh()
  {
    AppMethodBeat.i(7288);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(54, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7288);
    }
  }
  
  public final int ddi()
  {
    AppMethodBeat.i(7289);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(55, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7289);
    }
  }
  
  public final void ddj()
  {
    AppMethodBeat.i(7290);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(56, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7290);
    }
  }
  
  public final void ddk()
  {
    AppMethodBeat.i(7291);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(57, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7291);
    }
  }
  
  public final boolean ddl()
  {
    boolean bool = false;
    AppMethodBeat.i(7296);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(62, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7296);
    }
  }
  
  public final boolean ddm()
  {
    boolean bool = false;
    AppMethodBeat.i(7299);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(65, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7299);
    }
  }
  
  public final boolean ddn()
  {
    boolean bool = false;
    AppMethodBeat.i(7298);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(64, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7298);
    }
  }
  
  public final List<String> ddo()
  {
    AppMethodBeat.i(7307);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(73, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ArrayList localArrayList = localParcel2.createStringArrayList();
      return localArrayList;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7307);
    }
  }
  
  public final int ddp()
  {
    AppMethodBeat.i(7309);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(75, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7309);
    }
  }
  
  public final boolean ddq()
  {
    boolean bool = false;
    AppMethodBeat.i(7300);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(66, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7300);
    }
  }
  
  public final String[] ddr()
  {
    AppMethodBeat.i(7310);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(76, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String[] arrayOfString = localParcel2.createStringArray();
      return arrayOfString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7310);
    }
  }
  
  public final void favEditTag()
  {
    AppMethodBeat.i(7252);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(18, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7252);
    }
  }
  
  public final int gM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7245);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      this.mRemote.transact(11, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt1 = localParcel2.readInt();
      return paramInt1;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7245);
    }
  }
  
  public final void gN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7246);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      this.mRemote.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7246);
    }
  }
  
  public final String getLanguage()
  {
    AppMethodBeat.i(7286);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(52, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7286);
    }
  }
  
  public final String hw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7283);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.mRemote.transact(49, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString1 = localParcel2.readString();
      return paramString1;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7283);
    }
  }
  
  public final Bundle i(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(7304);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        localParcel1.writeInt(paramInt);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          this.mRemote.transact(70, localParcel1, localParcel2, 0);
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
        AppMethodBeat.o(7304);
      }
    }
  }
  
  public final boolean isSDCardAvailable()
  {
    boolean bool = false;
    AppMethodBeat.i(7242);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      this.mRemote.transact(8, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7242);
    }
  }
  
  public final void j(String paramString, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(7266);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(32, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7266);
    }
  }
  
  public final void k(int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(7258);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeInt(paramInt);
      localParcel1.writeStringList(paramList);
      this.mRemote.transact(24, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7258);
    }
  }
  
  public final String nE(String paramString)
  {
    AppMethodBeat.i(7236);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7236);
    }
  }
  
  public final boolean nT(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(7237);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7237);
    }
  }
  
  public final boolean nU(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(7239);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7239);
    }
  }
  
  public final boolean oD(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(7238);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeString(paramString);
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7238);
    }
  }
  
  public final Bundle r(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(153173);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        localParcel1.writeInt(paramInt);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          this.mRemote.transact(30, localParcel1, localParcel2, 0);
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
        AppMethodBeat.o(153173);
      }
    }
  }
  
  public final Bundle s(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(7265);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        localParcel1.writeInt(paramInt);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          this.mRemote.transact(31, localParcel1, localParcel2, 0);
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
        AppMethodBeat.o(7265);
      }
    }
  }
  
  /* Error */
  public final void u(int paramInt, Bundle paramBundle)
  {
    // Byte code:
    //   0: sipush 7311
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
    //   38: invokevirtual 94	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   41: aload_0
    //   42: getfield 18	com/tencent/mm/plugin/webview/stub/d$a$a:mRemote	Landroid/os/IBinder;
    //   45: bipush 77
    //   47: aload_3
    //   48: aload 4
    //   50: iconst_0
    //   51: invokeinterface 51 5 0
    //   56: pop
    //   57: aload 4
    //   59: invokevirtual 54	android/os/Parcel:readException	()V
    //   62: aload 4
    //   64: invokevirtual 57	android/os/Parcel:recycle	()V
    //   67: aload_3
    //   68: invokevirtual 57	android/os/Parcel:recycle	()V
    //   71: sipush 7311
    //   74: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: return
    //   78: aload_3
    //   79: iconst_0
    //   80: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   83: goto -42 -> 41
    //   86: astore_2
    //   87: aload 4
    //   89: invokevirtual 57	android/os/Parcel:recycle	()V
    //   92: aload_3
    //   93: invokevirtual 57	android/os/Parcel:recycle	()V
    //   96: sipush 7311
    //   99: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final boolean v(int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(7253);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        localParcel1.writeInt(paramInt);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          this.mRemote.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
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
        AppMethodBeat.o(7253);
      }
    }
  }
  
  public final boolean y(long paramLong, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(7254);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
      localParcel1.writeLong(paramLong);
      localParcel1.writeString(paramString);
      this.mRemote.transact(20, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(7254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.d.a.a
 * JD-Core Version:    0.7.0.1
 */