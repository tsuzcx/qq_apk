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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class PermissionHelper
{
  private static final byte[] DjB;
  private static final Map<Integer, d> DjC;
  private static volatile int DjD;
  private static final byte[] DjE;
  private static final Map<Integer, g> DjF;
  private static volatile int DjG;
  private static final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(192682);
    DjB = new byte[0];
    DjC = new HashMap();
    DjD = 28673;
    DjE = new byte[0];
    DjF = new HashMap();
    DjG = 24577;
    mHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(192682);
  }
  
  /* Error */
  private static void a(c paramc, int paramInt, f paramf)
  {
    // Byte code:
    //   0: ldc 117
    //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: checkcast 20	com/tencent/mm/pluginsdk/permission/PermissionHelper$b
    //   9: invokeinterface 121 1 0
    //   14: astore 4
    //   16: aload 4
    //   18: ifnonnull +16 -> 34
    //   21: ldc 123
    //   23: ldc 125
    //   25: invokestatic 130	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: ldc 117
    //   30: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: new 132	android/content/Intent
    //   37: dup
    //   38: ldc 134
    //   40: new 136	java/lang/StringBuilder
    //   43: dup
    //   44: ldc 138
    //   46: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload 4
    //   51: invokevirtual 147	android/content/Context:getPackageName	()Ljava/lang/String;
    //   54: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 160	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   63: invokespecial 163	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   66: astore 5
    //   68: getstatic 71	com/tencent/mm/pluginsdk/permission/PermissionHelper:DjE	[B
    //   71: astore 4
    //   73: aload 4
    //   75: monitorenter
    //   76: invokestatic 167	com/tencent/mm/pluginsdk/permission/PermissionHelper:eLr	()I
    //   79: istore_3
    //   80: new 35	com/tencent/mm/pluginsdk/permission/PermissionHelper$g
    //   83: dup
    //   84: iload_1
    //   85: aload_2
    //   86: iconst_0
    //   87: invokespecial 170	com/tencent/mm/pluginsdk/permission/PermissionHelper$g:<init>	(ILcom/tencent/mm/pluginsdk/permission/PermissionHelper$f;B)V
    //   90: astore 6
    //   92: getstatic 73	com/tencent/mm/pluginsdk/permission/PermissionHelper:DjF	Ljava/util/Map;
    //   95: iload_3
    //   96: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aload 6
    //   101: invokeinterface 174 3 0
    //   106: pop
    //   107: aload_0
    //   108: checkcast 20	com/tencent/mm/pluginsdk/permission/PermissionHelper$b
    //   111: aload 5
    //   113: iload_3
    //   114: invokeinterface 178 3 0
    //   119: aload 4
    //   121: monitorexit
    //   122: ldc 117
    //   124: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: return
    //   128: astore_0
    //   129: aload_2
    //   130: invokeinterface 181 1 0
    //   135: ldc 117
    //   137: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: return
    //   141: astore_0
    //   142: aload 4
    //   144: monitorexit
    //   145: ldc 117
    //   147: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_0
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramc	c
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
  
  private static void a(c paramc, int paramInt, String paramString, e parame)
  {
    AppMethodBeat.i(192674);
    ??? = ((b)paramc).getContext();
    if (??? == null)
    {
      ac.e("MicroMsg.PermissionHelper", "[-] context is null, skip rest steps.");
      AppMethodBeat.o(192674);
      return;
    }
    if (a.checkSelfPermission((Context)???, paramString) == 0)
    {
      parame.FB(paramString);
      AppMethodBeat.o(192674);
      return;
    }
    synchronized (DjB)
    {
      int i = eLq();
      parame = new d(paramInt, paramString, parame, (byte)0);
      DjC.put(Integer.valueOf(i), parame);
      ((b)paramc).requestPermissions(new String[] { paramString }, i);
      AppMethodBeat.o(192674);
      return;
    }
  }
  
  public static boolean aGv(String paramString)
  {
    AppMethodBeat.i(192671);
    if (a.checkSelfPermission(ai.getContext(), paramString) == 0)
    {
      AppMethodBeat.o(192671);
      return true;
    }
    AppMethodBeat.o(192671);
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public static c aQ(Activity paramActivity)
  {
    AppMethodBeat.i(192672);
    ac.i("MicroMsg.PermissionHelper", "[+] withActivity called, is_on_mainthread: %s", new Object[] { Boolean.valueOf(eLs()) });
    c[] arrayOfc = new c[1];
    arrayOfc[0] = null;
    paramActivity = new PermissionHelper.1(paramActivity, arrayOfc);
    if (eLs())
    {
      paramActivity.run();
      paramActivity = arrayOfc[0];
      AppMethodBeat.o(192672);
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
        AppMethodBeat.o(192672);
        return paramActivity;
      }
      finally
      {
        AppMethodBeat.o(192672);
      }
    }
  }
  
  private static int eLq()
  {
    synchronized (DjB)
    {
      if (DjD == 32768) {
        DjD = 28673;
      }
      int i = DjD;
      DjD = i + 1;
      return i;
    }
  }
  
  private static int eLr()
  {
    synchronized (DjE)
    {
      if (DjG == 28672) {
        DjG = 24577;
      }
      int i = DjG;
      DjG = i + 1;
      return i;
    }
  }
  
  private static boolean eLs()
  {
    AppMethodBeat.i(192673);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(192673);
      return true;
    }
    AppMethodBeat.o(192673);
    return false;
  }
  
  public static final class AuxSupportFragment
    extends android.support.v4.app.Fragment
    implements PermissionHelper.b, PermissionHelper.c
  {
    public final void a(int paramInt, String paramString, PermissionHelper.e parame)
    {
      AppMethodBeat.i(192666);
      if (!isDetached()) {
        PermissionHelper.c(this, paramInt, paramString, parame);
      }
      AppMethodBeat.o(192666);
    }
    
    public final void a(PermissionHelper.f paramf)
    {
      AppMethodBeat.i(192669);
      if (!isDetached()) {
        PermissionHelper.a(this, paramf);
      }
      AppMethodBeat.o(192669);
    }
    
    public final void a(String paramString1, String paramString2, final String paramString3, final PermissionHelper.e parame)
    {
      AppMethodBeat.i(192667);
      if (!isDetached())
      {
        Context localContext = getContext();
        if (localContext != null)
        {
          if (PermissionHelper.aGv(paramString3))
          {
            a(241, paramString3, parame);
            AppMethodBeat.o(192667);
            return;
          }
          h.a(localContext, paramString2, paramString1, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(192664);
              PermissionHelper.AuxSupportFragment.this.a(this.val$requestCode, paramString3, parame);
              AppMethodBeat.o(192664);
            }
          });
        }
      }
      AppMethodBeat.o(192667);
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(192670);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (!isDetached()) {
        PermissionHelper.WA(paramInt1);
      }
      AppMethodBeat.o(192670);
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(192665);
      super.onCreate(paramBundle);
      setRetainInstance(true);
      AppMethodBeat.o(192665);
    }
    
    public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(192668);
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      if (!isDetached()) {
        PermissionHelper.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(192668);
    }
  }
  
  public static final class a
    extends android.app.Fragment
    implements PermissionHelper.b, PermissionHelper.c
  {
    public WeakReference<Context> mContextRef;
    
    public final void a(int paramInt, String paramString, PermissionHelper.e parame)
    {
      AppMethodBeat.i(192658);
      if (!isDetached()) {
        PermissionHelper.c(this, paramInt, paramString, parame);
      }
      AppMethodBeat.o(192658);
    }
    
    public final void a(PermissionHelper.f paramf)
    {
      AppMethodBeat.i(192662);
      if (!isDetached()) {
        PermissionHelper.a(this, paramf);
      }
      AppMethodBeat.o(192662);
    }
    
    public final void a(String paramString1, String paramString2, final String paramString3, final PermissionHelper.e parame)
    {
      AppMethodBeat.i(192660);
      if (!isDetached())
      {
        Context localContext = getContext();
        if (localContext != null)
        {
          if (PermissionHelper.aGv(paramString3))
          {
            a(241, paramString3, parame);
            AppMethodBeat.o(192660);
            return;
          }
          h.a(localContext, paramString2, paramString1, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(192656);
              PermissionHelper.a.this.a(this.val$requestCode, paramString3, parame);
              AppMethodBeat.o(192656);
            }
          });
        }
      }
      AppMethodBeat.o(192660);
    }
    
    public final Context getContext()
    {
      AppMethodBeat.i(192659);
      Context localContext = null;
      if (Build.VERSION.SDK_INT >= 23) {
        localContext = super.getContext();
      }
      for (;;)
      {
        AppMethodBeat.o(192659);
        return localContext;
        if (this.mContextRef != null) {
          localContext = (Context)this.mContextRef.get();
        }
      }
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(192663);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (!isDetached()) {
        PermissionHelper.WA(paramInt1);
      }
      AppMethodBeat.o(192663);
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(192657);
      super.onCreate(paramBundle);
      setRetainInstance(true);
      AppMethodBeat.o(192657);
    }
    
    public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(192661);
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      if (!isDetached()) {
        PermissionHelper.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(192661);
    }
  }
  
  static abstract interface b
  {
    public abstract Context getContext();
    
    public abstract void requestPermissions(String[] paramArrayOfString, int paramInt);
    
    public abstract boolean shouldShowRequestPermissionRationale(String paramString);
    
    public abstract void startActivityForResult(Intent paramIntent, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void a(PermissionHelper.f paramf);
    
    public abstract void a(String paramString1, String paramString2, String paramString3, PermissionHelper.e parame);
  }
  
  static final class d
  {
    int DjM;
    PermissionHelper.e DjN;
    String permission;
    
    private d(int paramInt, String paramString, PermissionHelper.e parame)
    {
      this.DjM = paramInt;
      this.permission = paramString;
      this.DjN = parame;
    }
  }
  
  public static abstract interface e
  {
    public abstract void FB(String paramString);
    
    public abstract void a(PermissionHelper.c paramc, String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void aNh();
    
    public abstract void aNi();
  }
  
  static final class g
  {
    int DjM;
    PermissionHelper.f DjO;
    
    private g(int paramInt, PermissionHelper.f paramf)
    {
      this.DjM = paramInt;
      this.DjO = paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.PermissionHelper
 * JD-Core Version:    0.7.0.1
 */