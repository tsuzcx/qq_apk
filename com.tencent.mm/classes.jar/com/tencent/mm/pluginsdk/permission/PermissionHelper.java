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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class PermissionHelper
{
  private static final byte[] BRl;
  private static final Map<Integer, d> BRm;
  private static volatile int BRn;
  private static final byte[] BRo;
  private static final Map<Integer, g> BRp;
  private static volatile int BRq;
  private static final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(190778);
    BRl = new byte[0];
    BRm = new HashMap();
    BRn = 28673;
    BRo = new byte[0];
    BRp = new HashMap();
    BRq = 24577;
    mHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(190778);
  }
  
  /* Error */
  private static void a(PermissionHelper.c paramc, int paramInt, f paramf)
  {
    // Byte code:
    //   0: ldc 116
    //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: checkcast 20	com/tencent/mm/pluginsdk/permission/PermissionHelper$b
    //   9: invokeinterface 120 1 0
    //   14: astore 4
    //   16: aload 4
    //   18: ifnonnull +16 -> 34
    //   21: ldc 122
    //   23: ldc 124
    //   25: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: ldc 116
    //   30: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: new 131	android/content/Intent
    //   37: dup
    //   38: ldc 133
    //   40: new 135	java/lang/StringBuilder
    //   43: dup
    //   44: ldc 137
    //   46: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload 4
    //   51: invokevirtual 146	android/content/Context:getPackageName	()Ljava/lang/String;
    //   54: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 159	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   63: invokespecial 162	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   66: astore 5
    //   68: getstatic 70	com/tencent/mm/pluginsdk/permission/PermissionHelper:BRo	[B
    //   71: astore 4
    //   73: aload 4
    //   75: monitorenter
    //   76: invokestatic 166	com/tencent/mm/pluginsdk/permission/PermissionHelper:evX	()I
    //   79: istore_3
    //   80: new 34	com/tencent/mm/pluginsdk/permission/PermissionHelper$g
    //   83: dup
    //   84: iload_1
    //   85: aload_2
    //   86: iconst_0
    //   87: invokespecial 169	com/tencent/mm/pluginsdk/permission/PermissionHelper$g:<init>	(ILcom/tencent/mm/pluginsdk/permission/PermissionHelper$f;B)V
    //   90: astore 6
    //   92: getstatic 72	com/tencent/mm/pluginsdk/permission/PermissionHelper:BRp	Ljava/util/Map;
    //   95: iload_3
    //   96: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aload 6
    //   101: invokeinterface 173 3 0
    //   106: pop
    //   107: aload_0
    //   108: checkcast 20	com/tencent/mm/pluginsdk/permission/PermissionHelper$b
    //   111: aload 5
    //   113: iload_3
    //   114: invokeinterface 177 3 0
    //   119: aload 4
    //   121: monitorexit
    //   122: ldc 116
    //   124: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: return
    //   128: astore_0
    //   129: aload_2
    //   130: invokeinterface 180 1 0
    //   135: ldc 116
    //   137: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: return
    //   141: astore_0
    //   142: aload 4
    //   144: monitorexit
    //   145: ldc 116
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
    AppMethodBeat.i(190770);
    ??? = ((b)paramc).getContext();
    if (??? == null)
    {
      ad.e("MicroMsg.PermissionHelper", "[-] context is null, skip rest steps.");
      AppMethodBeat.o(190770);
      return;
    }
    if (a.checkSelfPermission((Context)???, paramString) == 0)
    {
      parame.Bx(paramString);
      AppMethodBeat.o(190770);
      return;
    }
    synchronized (BRl)
    {
      int i = evW();
      parame = new d(paramInt, paramString, parame, (byte)0);
      BRm.put(Integer.valueOf(i), parame);
      ((b)paramc).requestPermissions(new String[] { paramString }, i);
      AppMethodBeat.o(190770);
      return;
    }
  }
  
  public static boolean aBd(String paramString)
  {
    AppMethodBeat.i(190767);
    if (a.checkSelfPermission(aj.getContext(), paramString) == 0)
    {
      AppMethodBeat.o(190767);
      return true;
    }
    AppMethodBeat.o(190767);
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public static PermissionHelper.c aM(Activity paramActivity)
  {
    AppMethodBeat.i(190768);
    ad.i("MicroMsg.PermissionHelper", "[+] withActivity called, is_on_mainthread: %s", new Object[] { Boolean.valueOf(evY()) });
    PermissionHelper.c[] arrayOfc = new PermissionHelper.c[1];
    arrayOfc[0] = null;
    paramActivity = new PermissionHelper.1(paramActivity, arrayOfc);
    if (evY())
    {
      paramActivity.run();
      paramActivity = arrayOfc[0];
      AppMethodBeat.o(190768);
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
        AppMethodBeat.o(190768);
        return paramActivity;
      }
      finally
      {
        AppMethodBeat.o(190768);
      }
    }
  }
  
  private static int evW()
  {
    synchronized (BRl)
    {
      if (BRn == 32768) {
        BRn = 28673;
      }
      int i = BRn;
      BRn = i + 1;
      return i;
    }
  }
  
  private static int evX()
  {
    synchronized (BRo)
    {
      if (BRq == 28672) {
        BRq = 24577;
      }
      int i = BRq;
      BRq = i + 1;
      return i;
    }
  }
  
  private static boolean evY()
  {
    AppMethodBeat.i(190769);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(190769);
      return true;
    }
    AppMethodBeat.o(190769);
    return false;
  }
  
  public static final class AuxSupportFragment
    extends android.support.v4.app.Fragment
    implements PermissionHelper.b, PermissionHelper.c
  {
    public final void a(int paramInt, String paramString, PermissionHelper.e parame)
    {
      AppMethodBeat.i(190762);
      if (!isDetached()) {
        PermissionHelper.c(this, paramInt, paramString, parame);
      }
      AppMethodBeat.o(190762);
    }
    
    public final void a(PermissionHelper.f paramf)
    {
      AppMethodBeat.i(190765);
      if (!isDetached()) {
        PermissionHelper.a(this, paramf);
      }
      AppMethodBeat.o(190765);
    }
    
    public final void a(String paramString1, String paramString2, final String paramString3, final PermissionHelper.e parame)
    {
      AppMethodBeat.i(190763);
      if (!isDetached())
      {
        Context localContext = getContext();
        if (localContext != null)
        {
          if (PermissionHelper.aBd(paramString3))
          {
            a(241, paramString3, parame);
            AppMethodBeat.o(190763);
            return;
          }
          h.a(localContext, paramString2, paramString1, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(190760);
              PermissionHelper.AuxSupportFragment.this.a(this.val$requestCode, paramString3, parame);
              AppMethodBeat.o(190760);
            }
          });
        }
      }
      AppMethodBeat.o(190763);
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(190766);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (!isDetached()) {
        PermissionHelper.Uq(paramInt1);
      }
      AppMethodBeat.o(190766);
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(190761);
      super.onCreate(paramBundle);
      setRetainInstance(true);
      AppMethodBeat.o(190761);
    }
    
    public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(190764);
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      if (!isDetached()) {
        PermissionHelper.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(190764);
    }
  }
  
  public static final class a
    extends android.app.Fragment
    implements PermissionHelper.b, PermissionHelper.c
  {
    public WeakReference<Context> avO;
    
    public final void a(int paramInt, String paramString, PermissionHelper.e parame)
    {
      AppMethodBeat.i(190754);
      if (!isDetached()) {
        PermissionHelper.c(this, paramInt, paramString, parame);
      }
      AppMethodBeat.o(190754);
    }
    
    public final void a(PermissionHelper.f paramf)
    {
      AppMethodBeat.i(190758);
      if (!isDetached()) {
        PermissionHelper.a(this, paramf);
      }
      AppMethodBeat.o(190758);
    }
    
    public final void a(String paramString1, String paramString2, final String paramString3, final PermissionHelper.e parame)
    {
      AppMethodBeat.i(190756);
      if (!isDetached())
      {
        Context localContext = getContext();
        if (localContext != null)
        {
          if (PermissionHelper.aBd(paramString3))
          {
            a(241, paramString3, parame);
            AppMethodBeat.o(190756);
            return;
          }
          h.a(localContext, paramString2, paramString1, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(190752);
              PermissionHelper.a.this.a(this.val$requestCode, paramString3, parame);
              AppMethodBeat.o(190752);
            }
          });
        }
      }
      AppMethodBeat.o(190756);
    }
    
    public final Context getContext()
    {
      AppMethodBeat.i(190755);
      Context localContext = null;
      if (Build.VERSION.SDK_INT >= 23) {
        localContext = super.getContext();
      }
      for (;;)
      {
        AppMethodBeat.o(190755);
        return localContext;
        if (this.avO != null) {
          localContext = (Context)this.avO.get();
        }
      }
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(190759);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (!isDetached()) {
        PermissionHelper.Uq(paramInt1);
      }
      AppMethodBeat.o(190759);
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(190753);
      super.onCreate(paramBundle);
      setRetainInstance(true);
      AppMethodBeat.o(190753);
    }
    
    public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(190757);
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      if (!isDetached()) {
        PermissionHelper.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(190757);
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
    int BRw;
    PermissionHelper.e BRx;
    String permission;
    
    private d(int paramInt, String paramString, PermissionHelper.e parame)
    {
      this.BRw = paramInt;
      this.permission = paramString;
      this.BRx = parame;
    }
  }
  
  public static abstract interface e
  {
    public abstract void Bx(String paramString);
    
    public abstract void a(PermissionHelper.c paramc, String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void aGu();
    
    public abstract void aGv();
  }
  
  static final class g
  {
    int BRw;
    PermissionHelper.f BRy;
    
    private g(int paramInt, PermissionHelper.f paramf)
    {
      this.BRw = paramInt;
      this.BRy = paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.PermissionHelper
 * JD-Core Version:    0.7.0.1
 */