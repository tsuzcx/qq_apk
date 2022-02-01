package com.tencent.mm.pluginsdk.permission;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class PermissionHelper
{
  private static final byte[] QYn;
  private static final Map<Integer, d> QYo;
  private static volatile int QYp;
  private static final byte[] QYq;
  private static final Map<Integer, g> QYr;
  private static volatile int QYs;
  private static final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(222598);
    QYn = new byte[0];
    QYo = new HashMap();
    QYp = 28673;
    QYq = new byte[0];
    QYr = new HashMap();
    QYs = 24577;
    mHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(222598);
  }
  
  /* Error */
  private static void a(PermissionHelper.c paramc, int paramInt, f paramf)
  {
    // Byte code:
    //   0: ldc 97
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: checkcast 22	com/tencent/mm/pluginsdk/permission/PermissionHelper$b
    //   9: invokeinterface 101 1 0
    //   14: astore 4
    //   16: aload 4
    //   18: ifnonnull +16 -> 34
    //   21: ldc 103
    //   23: ldc 105
    //   25: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: ldc 97
    //   30: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: new 112	android/content/Intent
    //   37: dup
    //   38: ldc 114
    //   40: new 116	java/lang/StringBuilder
    //   43: dup
    //   44: ldc 118
    //   46: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload 4
    //   51: invokevirtual 127	android/content/Context:getPackageName	()Ljava/lang/String;
    //   54: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 140	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   63: invokespecial 143	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   66: astore 5
    //   68: getstatic 72	com/tencent/mm/pluginsdk/permission/PermissionHelper:QYq	[B
    //   71: astore 4
    //   73: aload 4
    //   75: monitorenter
    //   76: invokestatic 147	com/tencent/mm/pluginsdk/permission/PermissionHelper:hhR	()I
    //   79: istore_3
    //   80: new 36	com/tencent/mm/pluginsdk/permission/PermissionHelper$g
    //   83: dup
    //   84: iload_1
    //   85: aload_2
    //   86: iconst_0
    //   87: invokespecial 150	com/tencent/mm/pluginsdk/permission/PermissionHelper$g:<init>	(ILcom/tencent/mm/pluginsdk/permission/PermissionHelper$f;B)V
    //   90: astore 6
    //   92: getstatic 74	com/tencent/mm/pluginsdk/permission/PermissionHelper:QYr	Ljava/util/Map;
    //   95: iload_3
    //   96: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aload 6
    //   101: invokeinterface 162 3 0
    //   106: pop
    //   107: aload_0
    //   108: checkcast 22	com/tencent/mm/pluginsdk/permission/PermissionHelper$b
    //   111: aload 5
    //   113: iload_3
    //   114: invokeinterface 166 3 0
    //   119: aload 4
    //   121: monitorexit
    //   122: ldc 97
    //   124: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: return
    //   128: astore_0
    //   129: aload_2
    //   130: invokeinterface 169 1 0
    //   135: ldc 97
    //   137: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: return
    //   141: astore_0
    //   142: aload 4
    //   144: monitorexit
    //   145: ldc 97
    //   147: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_0
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramc	PermissionHelper.c
    //   0	152	1	paramInt	int
    //   0	152	2	paramf	f
    //   79	35	3	i	int
    //   66	46	5	localIntent	Intent
    //   90	10	6	localg	g
    // Exception table:
    //   from	to	target	type
    //   5	16	128	java/lang/Throwable
    //   21	28	128	java/lang/Throwable
    //   34	76	128	java/lang/Throwable
    //   122	127	128	java/lang/Throwable
    //   142	152	128	java/lang/Throwable
    //   76	122	141	finally
  }
  
  private static void a(PermissionHelper.c paramc, int paramInt, String paramString, e parame)
  {
    AppMethodBeat.i(222555);
    ??? = ((b)paramc).getContext();
    if (??? == null)
    {
      Log.e("MicroMsg.PermissionHelper", "[-] context is null, skip rest steps.");
      AppMethodBeat.o(222555);
      return;
    }
    if (a.checkSelfPermission((Context)???, paramString) == 0)
    {
      parame.ZP(paramString);
      AppMethodBeat.o(222555);
      return;
    }
    synchronized (QYn)
    {
      int i = hhQ();
      parame = new d(paramInt, paramString, parame, (byte)0);
      QYo.put(Integer.valueOf(i), parame);
      ((b)paramc).requestPermissions(new String[] { paramString }, i);
      AppMethodBeat.o(222555);
      return;
    }
  }
  
  @SuppressLint({"NewApi"})
  public static PermissionHelper.c bc(Activity paramActivity)
  {
    AppMethodBeat.i(222546);
    Log.i("MicroMsg.PermissionHelper", "[+] withActivity called, is_on_mainthread: %s", new Object[] { Boolean.valueOf(hhS()) });
    final PermissionHelper.c[] arrayOfc = new PermissionHelper.c[1];
    arrayOfc[0] = null;
    paramActivity = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 29
        //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 19	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:val$activity	Landroid/app/Activity;
        //   9: instanceof 37
        //   12: ifeq +102 -> 114
        //   15: aload_0
        //   16: getfield 19	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:val$activity	Landroid/app/Activity;
        //   19: checkcast 37	androidx/fragment/app/FragmentActivity
        //   22: invokevirtual 41	androidx/fragment/app/FragmentActivity:getSupportFragmentManager	()Landroidx/fragment/app/e;
        //   25: astore_3
        //   26: aload_3
        //   27: ldc 43
        //   29: invokevirtual 49	androidx/fragment/app/e:findFragmentByTag	(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
        //   32: checkcast 51	com/tencent/mm/pluginsdk/permission/PermissionHelper$AuxSupportFragment
        //   35: astore_2
        //   36: aload_2
        //   37: astore_1
        //   38: aload_2
        //   39: ifnonnull +30 -> 69
        //   42: new 51	com/tencent/mm/pluginsdk/permission/PermissionHelper$AuxSupportFragment
        //   45: dup
        //   46: invokespecial 52	com/tencent/mm/pluginsdk/permission/PermissionHelper$AuxSupportFragment:<init>	()V
        //   49: astore_1
        //   50: aload_3
        //   51: invokevirtual 56	androidx/fragment/app/e:beginTransaction	()Landroidx/fragment/app/i;
        //   54: aload_1
        //   55: ldc 43
        //   57: invokevirtual 62	androidx/fragment/app/i:a	(Landroidx/fragment/app/Fragment;Ljava/lang/String;)Landroidx/fragment/app/i;
        //   60: invokevirtual 66	androidx/fragment/app/i:in	()I
        //   63: pop
        //   64: aload_3
        //   65: invokevirtual 70	androidx/fragment/app/e:executePendingTransactions	()Z
        //   68: pop
        //   69: aload_0
        //   70: getfield 21	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:QYt	[Lcom/tencent/mm/pluginsdk/permission/PermissionHelper$c;
        //   73: iconst_0
        //   74: aload_1
        //   75: aastore
        //   76: aload_0
        //   77: getfield 21	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:QYt	[Lcom/tencent/mm/pluginsdk/permission/PermissionHelper$c;
        //   80: astore_1
        //   81: aload_1
        //   82: monitorenter
        //   83: aload_0
        //   84: getfield 21	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:QYt	[Lcom/tencent/mm/pluginsdk/permission/PermissionHelper$c;
        //   87: invokevirtual 73	java/lang/Object:notifyAll	()V
        //   90: aload_1
        //   91: monitorexit
        //   92: ldc 29
        //   94: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   97: return
        //   98: astore_2
        //   99: ldc 78
        //   101: aload_2
        //   102: ldc 80
        //   104: iconst_0
        //   105: anewarray 4	java/lang/Object
        //   108: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   111: goto -42 -> 69
        //   114: aload_0
        //   115: getfield 19	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:val$activity	Landroid/app/Activity;
        //   118: invokevirtual 92	android/app/Activity:getFragmentManager	()Landroid/app/FragmentManager;
        //   121: astore_3
        //   122: aload_3
        //   123: ldc 43
        //   125: invokevirtual 97	android/app/FragmentManager:findFragmentByTag	(Ljava/lang/String;)Landroid/app/Fragment;
        //   128: checkcast 99	com/tencent/mm/pluginsdk/permission/PermissionHelper$a
        //   131: astore_2
        //   132: aload_2
        //   133: astore_1
        //   134: aload_2
        //   135: ifnonnull +45 -> 180
        //   138: new 99	com/tencent/mm/pluginsdk/permission/PermissionHelper$a
        //   141: dup
        //   142: invokespecial 100	com/tencent/mm/pluginsdk/permission/PermissionHelper$a:<init>	()V
        //   145: astore_1
        //   146: aload_1
        //   147: new 102	java/lang/ref/WeakReference
        //   150: dup
        //   151: aload_0
        //   152: getfield 19	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:val$activity	Landroid/app/Activity;
        //   155: invokespecial 105	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
        //   158: putfield 109	com/tencent/mm/pluginsdk/permission/PermissionHelper$a:mContextRef	Ljava/lang/ref/WeakReference;
        //   161: aload_3
        //   162: invokevirtual 112	android/app/FragmentManager:beginTransaction	()Landroid/app/FragmentTransaction;
        //   165: aload_1
        //   166: ldc 43
        //   168: invokevirtual 118	android/app/FragmentTransaction:add	(Landroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;
        //   171: invokevirtual 121	android/app/FragmentTransaction:commit	()I
        //   174: pop
        //   175: aload_3
        //   176: invokevirtual 122	android/app/FragmentManager:executePendingTransactions	()Z
        //   179: pop
        //   180: aload_0
        //   181: getfield 21	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:QYt	[Lcom/tencent/mm/pluginsdk/permission/PermissionHelper$c;
        //   184: iconst_0
        //   185: aload_1
        //   186: aastore
        //   187: goto -111 -> 76
        //   190: astore_2
        //   191: ldc 78
        //   193: aload_2
        //   194: ldc 80
        //   196: iconst_0
        //   197: anewarray 4	java/lang/Object
        //   200: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   203: goto -23 -> 180
        //   206: astore_2
        //   207: aload_1
        //   208: monitorexit
        //   209: ldc 29
        //   211: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   214: aload_2
        //   215: athrow
        //   216: astore_2
        //   217: goto -127 -> 90
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	220	0	this	1
        //   35	4	2	localAuxSupportFragment	PermissionHelper.AuxSupportFragment
        //   98	4	2	localThrowable1	Throwable
        //   131	4	2	locala	PermissionHelper.a
        //   190	4	2	localThrowable2	Throwable
        //   206	9	2	localObject2	Object
        //   216	1	2	localThrowable3	Throwable
        //   25	151	3	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   50	69	98	java/lang/Throwable
        //   161	180	190	java/lang/Throwable
        //   83	90	206	finally
        //   90	92	206	finally
        //   83	90	216	java/lang/Throwable
      }
    };
    if (hhS())
    {
      paramActivity.run();
      paramActivity = arrayOfc[0];
      AppMethodBeat.o(222546);
      return paramActivity;
    }
    mHandler.postAtFrontOfQueue(paramActivity);
    for (;;)
    {
      if (arrayOfc[0] == null) {}
      try
      {
        arrayOfc.wait();
      }
      catch (Throwable paramActivity)
      {
        continue;
        paramActivity = arrayOfc[0];
        AppMethodBeat.o(222546);
        return paramActivity;
      }
      finally
      {
        AppMethodBeat.o(222546);
      }
    }
  }
  
  public static boolean bqn(String paramString)
  {
    AppMethodBeat.i(222540);
    if (a.checkSelfPermission(MMApplicationContext.getContext(), paramString) == 0)
    {
      AppMethodBeat.o(222540);
      return true;
    }
    AppMethodBeat.o(222540);
    return false;
  }
  
  private static int hhQ()
  {
    synchronized (QYn)
    {
      if (QYp == 32768) {
        QYp = 28673;
      }
      int i = QYp;
      QYp = i + 1;
      return i;
    }
  }
  
  private static int hhR()
  {
    synchronized (QYq)
    {
      if (QYs == 28672) {
        QYs = 24577;
      }
      int i = QYs;
      QYs = i + 1;
      return i;
    }
  }
  
  private static boolean hhS()
  {
    AppMethodBeat.i(222550);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(222550);
      return true;
    }
    AppMethodBeat.o(222550);
    return false;
  }
  
  public static final class AuxSupportFragment
    extends androidx.fragment.app.Fragment
    implements PermissionHelper.b, PermissionHelper.c
  {
    public final void a(int paramInt, String paramString, PermissionHelper.e parame)
    {
      AppMethodBeat.i(223858);
      if (!isDetached()) {
        PermissionHelper.c(this, paramInt, paramString, parame);
      }
      AppMethodBeat.o(223858);
    }
    
    public final void a(PermissionHelper.f paramf)
    {
      AppMethodBeat.i(223864);
      if (!isDetached()) {
        PermissionHelper.a(this, paramf);
      }
      AppMethodBeat.o(223864);
    }
    
    public final void a(String paramString1, String paramString2, final String paramString3, final PermissionHelper.e parame)
    {
      AppMethodBeat.i(223861);
      if (!isDetached())
      {
        Context localContext = getContext();
        if (localContext != null)
        {
          if (PermissionHelper.bqn(paramString3))
          {
            a(241, paramString3, parame);
            AppMethodBeat.o(223861);
            return;
          }
          h.a(localContext, paramString2, paramString1, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(238109);
              PermissionHelper.AuxSupportFragment.this.a(this.val$requestCode, paramString3, parame);
              AppMethodBeat.o(238109);
            }
          });
        }
      }
      AppMethodBeat.o(223861);
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(223867);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (!isDetached()) {
        PermissionHelper.apN(paramInt1);
      }
      AppMethodBeat.o(223867);
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(223855);
      super.onCreate(paramBundle);
      setRetainInstance(true);
      AppMethodBeat.o(223855);
    }
    
    public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(223863);
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      if (!isDetached()) {
        PermissionHelper.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(223863);
    }
  }
  
  public static final class a
    extends android.app.Fragment
    implements PermissionHelper.b, PermissionHelper.c
  {
    public WeakReference<Context> mContextRef;
    
    public final void a(int paramInt, String paramString, PermissionHelper.e parame)
    {
      AppMethodBeat.i(192236);
      if (!isDetached()) {
        PermissionHelper.c(this, paramInt, paramString, parame);
      }
      AppMethodBeat.o(192236);
    }
    
    public final void a(PermissionHelper.f paramf)
    {
      AppMethodBeat.i(192252);
      if (!isDetached()) {
        PermissionHelper.a(this, paramf);
      }
      AppMethodBeat.o(192252);
    }
    
    public final void a(String paramString1, String paramString2, final String paramString3, final PermissionHelper.e parame)
    {
      AppMethodBeat.i(192247);
      if (!isDetached())
      {
        Context localContext = getContext();
        if (localContext != null)
        {
          if (PermissionHelper.bqn(paramString3))
          {
            a(241, paramString3, parame);
            AppMethodBeat.o(192247);
            return;
          }
          h.a(localContext, paramString2, paramString1, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(195505);
              PermissionHelper.a.this.a(this.val$requestCode, paramString3, parame);
              AppMethodBeat.o(195505);
            }
          });
        }
      }
      AppMethodBeat.o(192247);
    }
    
    public final Context getContext()
    {
      AppMethodBeat.i(192240);
      Context localContext = null;
      if (Build.VERSION.SDK_INT >= 23) {
        localContext = super.getContext();
      }
      for (;;)
      {
        AppMethodBeat.o(192240);
        return localContext;
        if (this.mContextRef != null) {
          localContext = (Context)this.mContextRef.get();
        }
      }
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(192255);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (!isDetached()) {
        PermissionHelper.apN(paramInt1);
      }
      AppMethodBeat.o(192255);
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(192234);
      super.onCreate(paramBundle);
      setRetainInstance(true);
      AppMethodBeat.o(192234);
    }
    
    public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(192249);
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      if (!isDetached()) {
        PermissionHelper.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(192249);
    }
  }
  
  static abstract interface b
  {
    public abstract Context getContext();
    
    public abstract void requestPermissions(String[] paramArrayOfString, int paramInt);
    
    public abstract boolean shouldShowRequestPermissionRationale(String paramString);
    
    public abstract void startActivityForResult(Intent paramIntent, int paramInt);
  }
  
  static final class d
  {
    PermissionHelper.e QYA;
    int QYy;
    String QYz;
    
    private d(int paramInt, String paramString, PermissionHelper.e parame)
    {
      this.QYy = paramInt;
      this.QYz = paramString;
      this.QYA = parame;
    }
  }
  
  public static abstract interface e
  {
    public abstract void ZP(String paramString);
    
    public abstract void a(PermissionHelper.c paramc, String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void bvm();
    
    public abstract void bvn();
  }
  
  static final class g
  {
    PermissionHelper.f QYB;
    int QYy;
    
    private g(int paramInt, PermissionHelper.f paramf)
    {
      this.QYy = paramInt;
      this.QYB = paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.PermissionHelper
 * JD-Core Version:    0.7.0.1
 */