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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class PermissionHelper
{
  private static final byte[] FgT;
  private static final Map<Integer, d> FgU;
  private static volatile int FgV;
  private static final byte[] FgW;
  private static final Map<Integer, g> FgX;
  private static volatile int FgY;
  private static final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(218870);
    FgT = new byte[0];
    FgU = new HashMap();
    FgV = 28673;
    FgW = new byte[0];
    FgX = new HashMap();
    FgY = 24577;
    mHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(218870);
  }
  
  /* Error */
  private static void a(PermissionHelper.c paramc, int paramInt, f paramf)
  {
    // Byte code:
    //   0: ldc 114
    //   2: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: checkcast 18	com/tencent/mm/pluginsdk/permission/PermissionHelper$b
    //   9: invokeinterface 118 1 0
    //   14: astore 4
    //   16: aload 4
    //   18: ifnonnull +16 -> 34
    //   21: ldc 120
    //   23: ldc 122
    //   25: invokestatic 127	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: ldc 114
    //   30: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: new 129	android/content/Intent
    //   37: dup
    //   38: ldc 131
    //   40: new 133	java/lang/StringBuilder
    //   43: dup
    //   44: ldc 135
    //   46: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload 4
    //   51: invokevirtual 144	android/content/Context:getPackageName	()Ljava/lang/String;
    //   54: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 157	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   63: invokespecial 160	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   66: astore 5
    //   68: getstatic 68	com/tencent/mm/pluginsdk/permission/PermissionHelper:FgW	[B
    //   71: astore 4
    //   73: aload 4
    //   75: monitorenter
    //   76: invokestatic 164	com/tencent/mm/pluginsdk/permission/PermissionHelper:fea	()I
    //   79: istore_3
    //   80: new 32	com/tencent/mm/pluginsdk/permission/PermissionHelper$g
    //   83: dup
    //   84: iload_1
    //   85: aload_2
    //   86: iconst_0
    //   87: invokespecial 167	com/tencent/mm/pluginsdk/permission/PermissionHelper$g:<init>	(ILcom/tencent/mm/pluginsdk/permission/PermissionHelper$f;B)V
    //   90: astore 6
    //   92: getstatic 70	com/tencent/mm/pluginsdk/permission/PermissionHelper:FgX	Ljava/util/Map;
    //   95: iload_3
    //   96: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aload 6
    //   101: invokeinterface 171 3 0
    //   106: pop
    //   107: aload_0
    //   108: checkcast 18	com/tencent/mm/pluginsdk/permission/PermissionHelper$b
    //   111: aload 5
    //   113: iload_3
    //   114: invokeinterface 175 3 0
    //   119: aload 4
    //   121: monitorexit
    //   122: ldc 114
    //   124: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: return
    //   128: astore_0
    //   129: aload_2
    //   130: invokeinterface 178 1 0
    //   135: ldc 114
    //   137: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: return
    //   141: astore_0
    //   142: aload 4
    //   144: monitorexit
    //   145: ldc 114
    //   147: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(218862);
    ??? = ((b)paramc).getContext();
    if (??? == null)
    {
      ae.e("MicroMsg.PermissionHelper", "[-] context is null, skip rest steps.");
      AppMethodBeat.o(218862);
      return;
    }
    if (a.checkSelfPermission((Context)???, paramString) == 0)
    {
      parame.Jp(paramString);
      AppMethodBeat.o(218862);
      return;
    }
    synchronized (FgT)
    {
      int i = fdZ();
      parame = new d(paramInt, paramString, parame, (byte)0);
      FgU.put(Integer.valueOf(i), parame);
      ((b)paramc).requestPermissions(new String[] { paramString }, i);
      AppMethodBeat.o(218862);
      return;
    }
  }
  
  public static boolean aNr(String paramString)
  {
    AppMethodBeat.i(218859);
    if (a.checkSelfPermission(ak.getContext(), paramString) == 0)
    {
      AppMethodBeat.o(218859);
      return true;
    }
    AppMethodBeat.o(218859);
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public static PermissionHelper.c aR(Activity paramActivity)
  {
    AppMethodBeat.i(218860);
    ae.i("MicroMsg.PermissionHelper", "[+] withActivity called, is_on_mainthread: %s", new Object[] { Boolean.valueOf(feb()) });
    PermissionHelper.c[] arrayOfc = new PermissionHelper.c[1];
    arrayOfc[0] = null;
    paramActivity = new PermissionHelper.1(paramActivity, arrayOfc);
    if (feb())
    {
      paramActivity.run();
      paramActivity = arrayOfc[0];
      AppMethodBeat.o(218860);
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
        AppMethodBeat.o(218860);
        return paramActivity;
      }
      finally
      {
        AppMethodBeat.o(218860);
      }
    }
  }
  
  private static int fdZ()
  {
    synchronized (FgT)
    {
      if (FgV == 32768) {
        FgV = 28673;
      }
      int i = FgV;
      FgV = i + 1;
      return i;
    }
  }
  
  private static int fea()
  {
    synchronized (FgW)
    {
      if (FgY == 28672) {
        FgY = 24577;
      }
      int i = FgY;
      FgY = i + 1;
      return i;
    }
  }
  
  private static boolean feb()
  {
    AppMethodBeat.i(218861);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(218861);
      return true;
    }
    AppMethodBeat.o(218861);
    return false;
  }
  
  public static final class AuxSupportFragment
    extends android.support.v4.app.Fragment
    implements PermissionHelper.b, PermissionHelper.c
  {
    public final void a(int paramInt, String paramString, PermissionHelper.e parame)
    {
      AppMethodBeat.i(218854);
      if (!isDetached()) {
        PermissionHelper.c(this, paramInt, paramString, parame);
      }
      AppMethodBeat.o(218854);
    }
    
    public final void a(PermissionHelper.f paramf)
    {
      AppMethodBeat.i(218857);
      if (!isDetached()) {
        PermissionHelper.a(this, paramf);
      }
      AppMethodBeat.o(218857);
    }
    
    public final void a(String paramString1, String paramString2, final String paramString3, final PermissionHelper.e parame)
    {
      AppMethodBeat.i(218855);
      if (!isDetached())
      {
        Context localContext = getContext();
        if (localContext != null)
        {
          if (PermissionHelper.aNr(paramString3))
          {
            a(241, paramString3, parame);
            AppMethodBeat.o(218855);
            return;
          }
          h.a(localContext, paramString2, paramString1, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(218852);
              PermissionHelper.AuxSupportFragment.this.a(this.val$requestCode, paramString3, parame);
              AppMethodBeat.o(218852);
            }
          });
        }
      }
      AppMethodBeat.o(218855);
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(218858);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (!isDetached()) {
        PermissionHelper.Zc(paramInt1);
      }
      AppMethodBeat.o(218858);
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(218853);
      super.onCreate(paramBundle);
      setRetainInstance(true);
      AppMethodBeat.o(218853);
    }
    
    public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(218856);
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      if (!isDetached()) {
        PermissionHelper.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(218856);
    }
  }
  
  public static final class a
    extends android.app.Fragment
    implements PermissionHelper.b, PermissionHelper.c
  {
    public WeakReference<Context> mContextRef;
    
    public final void a(int paramInt, String paramString, PermissionHelper.e parame)
    {
      AppMethodBeat.i(218846);
      if (!isDetached()) {
        PermissionHelper.c(this, paramInt, paramString, parame);
      }
      AppMethodBeat.o(218846);
    }
    
    public final void a(PermissionHelper.f paramf)
    {
      AppMethodBeat.i(218850);
      if (!isDetached()) {
        PermissionHelper.a(this, paramf);
      }
      AppMethodBeat.o(218850);
    }
    
    public final void a(String paramString1, String paramString2, final String paramString3, final PermissionHelper.e parame)
    {
      AppMethodBeat.i(218848);
      if (!isDetached())
      {
        Context localContext = getContext();
        if (localContext != null)
        {
          if (PermissionHelper.aNr(paramString3))
          {
            a(241, paramString3, parame);
            AppMethodBeat.o(218848);
            return;
          }
          h.a(localContext, paramString2, paramString1, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(218844);
              PermissionHelper.a.this.a(this.val$requestCode, paramString3, parame);
              AppMethodBeat.o(218844);
            }
          });
        }
      }
      AppMethodBeat.o(218848);
    }
    
    public final Context getContext()
    {
      AppMethodBeat.i(218847);
      Context localContext = null;
      if (Build.VERSION.SDK_INT >= 23) {
        localContext = super.getContext();
      }
      for (;;)
      {
        AppMethodBeat.o(218847);
        return localContext;
        if (this.mContextRef != null) {
          localContext = (Context)this.mContextRef.get();
        }
      }
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(218851);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (!isDetached()) {
        PermissionHelper.Zc(paramInt1);
      }
      AppMethodBeat.o(218851);
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(218845);
      super.onCreate(paramBundle);
      setRetainInstance(true);
      AppMethodBeat.o(218845);
    }
    
    public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(218849);
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      if (!isDetached()) {
        PermissionHelper.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(218849);
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
    int Fhe;
    PermissionHelper.e Fhf;
    String permission;
    
    private d(int paramInt, String paramString, PermissionHelper.e parame)
    {
      this.Fhe = paramInt;
      this.permission = paramString;
      this.Fhf = parame;
    }
  }
  
  public static abstract interface e
  {
    public abstract void Jp(String paramString);
    
    public abstract void a(PermissionHelper.c paramc, String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void aQR();
    
    public abstract void aQS();
  }
  
  static final class g
  {
    int Fhe;
    PermissionHelper.f Fhg;
    
    private g(int paramInt, PermissionHelper.f paramf)
    {
      this.Fhe = paramInt;
      this.Fhg = paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.PermissionHelper
 * JD-Core Version:    0.7.0.1
 */