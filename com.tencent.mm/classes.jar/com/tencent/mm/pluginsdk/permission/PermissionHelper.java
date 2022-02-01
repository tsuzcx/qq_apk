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
import android.support.v4.app.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class PermissionHelper
{
  private static final byte[] JXL;
  private static final Map<Integer, d> JXM;
  private static volatile int JXN;
  private static final byte[] JXO;
  private static final Map<Integer, g> JXP;
  private static volatile int JXQ;
  private static final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(223807);
    JXL = new byte[0];
    JXM = new HashMap();
    JXN = 28673;
    JXO = new byte[0];
    JXP = new HashMap();
    JXQ = 24577;
    mHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(223807);
  }
  
  /* Error */
  private static void a(PermissionHelper.c paramc, int paramInt, f paramf)
  {
    // Byte code:
    //   0: ldc 95
    //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: checkcast 20	com/tencent/mm/pluginsdk/permission/PermissionHelper$b
    //   9: invokeinterface 99 1 0
    //   14: astore 4
    //   16: aload 4
    //   18: ifnonnull +16 -> 34
    //   21: ldc 101
    //   23: ldc 103
    //   25: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: ldc 95
    //   30: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: new 110	android/content/Intent
    //   37: dup
    //   38: ldc 112
    //   40: new 114	java/lang/StringBuilder
    //   43: dup
    //   44: ldc 116
    //   46: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload 4
    //   51: invokevirtual 125	android/content/Context:getPackageName	()Ljava/lang/String;
    //   54: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 138	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   63: invokespecial 141	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   66: astore 5
    //   68: getstatic 70	com/tencent/mm/pluginsdk/permission/PermissionHelper:JXO	[B
    //   71: astore 4
    //   73: aload 4
    //   75: monitorenter
    //   76: invokestatic 145	com/tencent/mm/pluginsdk/permission/PermissionHelper:gnl	()I
    //   79: istore_3
    //   80: new 34	com/tencent/mm/pluginsdk/permission/PermissionHelper$g
    //   83: dup
    //   84: iload_1
    //   85: aload_2
    //   86: iconst_0
    //   87: invokespecial 148	com/tencent/mm/pluginsdk/permission/PermissionHelper$g:<init>	(ILcom/tencent/mm/pluginsdk/permission/PermissionHelper$f;B)V
    //   90: astore 6
    //   92: getstatic 72	com/tencent/mm/pluginsdk/permission/PermissionHelper:JXP	Ljava/util/Map;
    //   95: iload_3
    //   96: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aload 6
    //   101: invokeinterface 160 3 0
    //   106: pop
    //   107: aload_0
    //   108: checkcast 20	com/tencent/mm/pluginsdk/permission/PermissionHelper$b
    //   111: aload 5
    //   113: iload_3
    //   114: invokeinterface 164 3 0
    //   119: aload 4
    //   121: monitorexit
    //   122: ldc 95
    //   124: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: return
    //   128: astore_0
    //   129: aload_2
    //   130: invokeinterface 167 1 0
    //   135: ldc 95
    //   137: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: return
    //   141: astore_0
    //   142: aload 4
    //   144: monitorexit
    //   145: ldc 95
    //   147: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   145	152	128	java/lang/Throwable
    //   76	122	141	finally
    //   142	145	141	finally
  }
  
  private static void a(PermissionHelper.c paramc, int paramInt, String paramString, e parame)
  {
    AppMethodBeat.i(223799);
    ??? = ((b)paramc).getContext();
    if (??? == null)
    {
      Log.e("MicroMsg.PermissionHelper", "[-] context is null, skip rest steps.");
      AppMethodBeat.o(223799);
      return;
    }
    if (a.checkSelfPermission((Context)???, paramString) == 0)
    {
      parame.Sn(paramString);
      AppMethodBeat.o(223799);
      return;
    }
    synchronized (JXL)
    {
      int i = gnk();
      parame = new d(paramInt, paramString, parame, (byte)0);
      JXM.put(Integer.valueOf(i), parame);
      ((b)paramc).requestPermissions(new String[] { paramString }, i);
      AppMethodBeat.o(223799);
      return;
    }
  }
  
  @SuppressLint({"NewApi"})
  public static PermissionHelper.c aX(Activity paramActivity)
  {
    AppMethodBeat.i(223797);
    Log.i("MicroMsg.PermissionHelper", "[+] withActivity called, is_on_mainthread: %s", new Object[] { Boolean.valueOf(gnm()) });
    PermissionHelper.c[] arrayOfc = new PermissionHelper.c[1];
    arrayOfc[0] = null;
    paramActivity = new PermissionHelper.1(paramActivity, arrayOfc);
    if (gnm())
    {
      paramActivity.run();
      paramActivity = arrayOfc[0];
      AppMethodBeat.o(223797);
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
        AppMethodBeat.o(223797);
        return paramActivity;
      }
      finally
      {
        AppMethodBeat.o(223797);
      }
    }
  }
  
  public static boolean bdR(String paramString)
  {
    AppMethodBeat.i(223796);
    if (a.checkSelfPermission(MMApplicationContext.getContext(), paramString) == 0)
    {
      AppMethodBeat.o(223796);
      return true;
    }
    AppMethodBeat.o(223796);
    return false;
  }
  
  private static int gnk()
  {
    synchronized (JXL)
    {
      if (JXN == 32768) {
        JXN = 28673;
      }
      int i = JXN;
      JXN = i + 1;
      return i;
    }
  }
  
  private static int gnl()
  {
    synchronized (JXO)
    {
      if (JXQ == 28672) {
        JXQ = 24577;
      }
      int i = JXQ;
      JXQ = i + 1;
      return i;
    }
  }
  
  private static boolean gnm()
  {
    AppMethodBeat.i(223798);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(223798);
      return true;
    }
    AppMethodBeat.o(223798);
    return false;
  }
  
  public static final class AuxSupportFragment
    extends android.support.v4.app.Fragment
    implements PermissionHelper.b, PermissionHelper.c
  {
    public final void a(int paramInt, String paramString, PermissionHelper.e parame)
    {
      AppMethodBeat.i(223791);
      if (!isDetached()) {
        PermissionHelper.c(this, paramInt, paramString, parame);
      }
      AppMethodBeat.o(223791);
    }
    
    public final void a(PermissionHelper.f paramf)
    {
      AppMethodBeat.i(223794);
      if (!isDetached()) {
        PermissionHelper.a(this, paramf);
      }
      AppMethodBeat.o(223794);
    }
    
    public final void a(String paramString1, String paramString2, final String paramString3, final PermissionHelper.e parame)
    {
      AppMethodBeat.i(223792);
      if (!isDetached())
      {
        Context localContext = getContext();
        if (localContext != null)
        {
          if (PermissionHelper.bdR(paramString3))
          {
            a(241, paramString3, parame);
            AppMethodBeat.o(223792);
            return;
          }
          h.a(localContext, paramString2, paramString1, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(223789);
              PermissionHelper.AuxSupportFragment.this.a(this.val$requestCode, paramString3, parame);
              AppMethodBeat.o(223789);
            }
          });
        }
      }
      AppMethodBeat.o(223792);
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(223795);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (!isDetached()) {
        PermissionHelper.ahN(paramInt1);
      }
      AppMethodBeat.o(223795);
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(223790);
      super.onCreate(paramBundle);
      setRetainInstance(true);
      AppMethodBeat.o(223790);
    }
    
    public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(223793);
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      if (!isDetached()) {
        PermissionHelper.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(223793);
    }
  }
  
  public static final class a
    extends android.app.Fragment
    implements PermissionHelper.b, PermissionHelper.c
  {
    public WeakReference<Context> mContextRef;
    
    public final void a(int paramInt, String paramString, PermissionHelper.e parame)
    {
      AppMethodBeat.i(223783);
      if (!isDetached()) {
        PermissionHelper.c(this, paramInt, paramString, parame);
      }
      AppMethodBeat.o(223783);
    }
    
    public final void a(PermissionHelper.f paramf)
    {
      AppMethodBeat.i(223787);
      if (!isDetached()) {
        PermissionHelper.a(this, paramf);
      }
      AppMethodBeat.o(223787);
    }
    
    public final void a(String paramString1, String paramString2, final String paramString3, final PermissionHelper.e parame)
    {
      AppMethodBeat.i(223785);
      if (!isDetached())
      {
        Context localContext = getContext();
        if (localContext != null)
        {
          if (PermissionHelper.bdR(paramString3))
          {
            a(241, paramString3, parame);
            AppMethodBeat.o(223785);
            return;
          }
          h.a(localContext, paramString2, paramString1, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(223781);
              PermissionHelper.a.this.a(this.val$requestCode, paramString3, parame);
              AppMethodBeat.o(223781);
            }
          });
        }
      }
      AppMethodBeat.o(223785);
    }
    
    public final Context getContext()
    {
      AppMethodBeat.i(223784);
      Context localContext = null;
      if (Build.VERSION.SDK_INT >= 23) {
        localContext = super.getContext();
      }
      for (;;)
      {
        AppMethodBeat.o(223784);
        return localContext;
        if (this.mContextRef != null) {
          localContext = (Context)this.mContextRef.get();
        }
      }
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(223788);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (!isDetached()) {
        PermissionHelper.ahN(paramInt1);
      }
      AppMethodBeat.o(223788);
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(223782);
      super.onCreate(paramBundle);
      setRetainInstance(true);
      AppMethodBeat.o(223782);
    }
    
    public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(223786);
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      if (!isDetached()) {
        PermissionHelper.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(223786);
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
    int JXW;
    PermissionHelper.e JXX;
    String permission;
    
    private d(int paramInt, String paramString, PermissionHelper.e parame)
    {
      this.JXW = paramInt;
      this.permission = paramString;
      this.JXX = parame;
    }
  }
  
  public static abstract interface e
  {
    public abstract void Sn(String paramString);
    
    public abstract void a(PermissionHelper.c paramc, String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void blw();
    
    public abstract void blx();
  }
  
  static final class g
  {
    int JXW;
    PermissionHelper.f JXY;
    
    private g(int paramInt, PermissionHelper.f paramf)
    {
      this.JXW = paramInt;
      this.JXY = paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.PermissionHelper
 * JD-Core Version:    0.7.0.1
 */