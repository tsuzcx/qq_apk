package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e$a$a
  implements e
{
  private IBinder mRemote;
  
  e$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  /* Error */
  public final boolean Cl(int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: aload_3
    //   12: ldc 29
    //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_3
    //   18: iload_1
    //   19: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   22: aload_0
    //   23: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
    //   26: iconst_1
    //   27: aload_3
    //   28: aload 4
    //   30: iconst_0
    //   31: invokeinterface 43 5 0
    //   36: pop
    //   37: aload 4
    //   39: invokevirtual 46	android/os/Parcel:readException	()V
    //   42: aload 4
    //   44: invokevirtual 50	android/os/Parcel:readInt	()I
    //   47: istore_1
    //   48: iload_1
    //   49: ifeq +14 -> 63
    //   52: aload 4
    //   54: invokevirtual 53	android/os/Parcel:recycle	()V
    //   57: aload_3
    //   58: invokevirtual 53	android/os/Parcel:recycle	()V
    //   61: iload_2
    //   62: ireturn
    //   63: iconst_0
    //   64: istore_2
    //   65: goto -13 -> 52
    //   68: astore 5
    //   70: aload 4
    //   72: invokevirtual 53	android/os/Parcel:recycle	()V
    //   75: aload_3
    //   76: invokevirtual 53	android/os/Parcel:recycle	()V
    //   79: aload 5
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	a
    //   0	82	1	paramInt	int
    //   1	64	2	bool	boolean
    //   5	71	3	localParcel1	Parcel
    //   9	62	4	localParcel2	Parcel
    //   68	12	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	48	68	finally
  }
  
  /* Error */
  public final void N(Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 29
    //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 61	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
    //   33: bipush 13
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 43 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 46	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 53	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 53	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 53	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 53	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	a
    //   0	76	1	paramBundle	Bundle
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
  
  /* Error */
  public final void O(Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 29
    //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 61	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
    //   33: bipush 19
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 43 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 46	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 53	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 53	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 53	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 53	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	a
    //   0	76	1	paramBundle	Bundle
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
  
  public final void SJ(String paramString)
  {
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
    }
  }
  
  /* Error */
  public final boolean a(c paramc)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 29
    //   16: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnull +61 -> 81
    //   23: aload_1
    //   24: invokeinterface 73 1 0
    //   29: astore_1
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 76	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
    //   40: iconst_3
    //   41: aload 4
    //   43: aload 5
    //   45: iconst_0
    //   46: invokeinterface 43 5 0
    //   51: pop
    //   52: aload 5
    //   54: invokevirtual 46	android/os/Parcel:readException	()V
    //   57: aload 5
    //   59: invokevirtual 50	android/os/Parcel:readInt	()I
    //   62: istore_2
    //   63: iload_2
    //   64: ifeq +5 -> 69
    //   67: iconst_1
    //   68: istore_3
    //   69: aload 5
    //   71: invokevirtual 53	android/os/Parcel:recycle	()V
    //   74: aload 4
    //   76: invokevirtual 53	android/os/Parcel:recycle	()V
    //   79: iload_3
    //   80: ireturn
    //   81: aconst_null
    //   82: astore_1
    //   83: goto -53 -> 30
    //   86: astore_1
    //   87: aload 5
    //   89: invokevirtual 53	android/os/Parcel:recycle	()V
    //   92: aload 4
    //   94: invokevirtual 53	android/os/Parcel:recycle	()V
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	a
    //   0	99	1	paramc	c
    //   62	2	2	i	int
    //   1	79	3	bool	boolean
    //   5	88	4	localParcel1	Parcel
    //   10	78	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   12	19	86	finally
    //   23	30	86	finally
    //   30	63	86	finally
  }
  
  public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    boolean bool = true;
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
          break label143;
          localParcel1.writeInt(i);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          i = localParcel2.readInt();
          if (i != 0)
          {
            paramBoolean = bool;
            label96:
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
      }
      label143:
      do
      {
        i = 0;
        break;
        paramBoolean = false;
        break label96;
      } while (!paramBoolean);
      int i = 1;
    }
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public final boolean b(int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
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
      }
    }
  }
  
  public final String cdb()
  {
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
    }
  }
  
  public final String cdc()
  {
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
    }
  }
  
  public final int cdd()
  {
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
    }
  }
  
  public final void cde()
  {
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
    }
  }
  
  public final void cdf()
  {
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
    }
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
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
    }
  }
  
  public final Bundle f(int paramInt, Bundle paramBundle)
  {
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
      }
    }
  }
  
  public final void fx(String paramString1, String paramString2)
  {
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
    }
  }
  
  public final void fy(String paramString1, String paramString2)
  {
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
    }
  }
  
  public final String getCurrentUrl()
  {
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
    }
  }
  
  public final void le(boolean paramBoolean)
  {
    int i = 0;
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
    }
  }
  
  public final void lf(boolean paramBoolean)
  {
    int i = 0;
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
    }
  }
  
  public final void lg(boolean paramBoolean)
  {
    int i = 0;
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
    }
  }
  
  /* Error */
  public final void p(int paramInt, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 29
    //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: iload_1
    //   17: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   20: aload_2
    //   21: ifnull +45 -> 66
    //   24: aload_3
    //   25: iconst_1
    //   26: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokevirtual 61	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 18	com/tencent/mm/plugin/webview/stub/e$a$a:mRemote	Landroid/os/IBinder;
    //   39: bipush 11
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 43 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 46	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 53	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 53	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aload_3
    //   67: iconst_0
    //   68: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   71: goto -36 -> 35
    //   74: astore_2
    //   75: aload 4
    //   77: invokevirtual 53	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: invokevirtual 53	android/os/Parcel:recycle	()V
    //   84: aload_2
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	a
    //   0	86	1	paramInt	int
    //   0	86	2	paramBundle	Bundle
    //   3	78	3	localParcel1	Parcel
    //   7	69	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	74	finally
    //   24	35	74	finally
    //   35	56	74	finally
    //   66	71	74	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.e.a.a
 * JD-Core Version:    0.7.0.1
 */