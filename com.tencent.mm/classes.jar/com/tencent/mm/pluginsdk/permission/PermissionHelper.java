package com.tencent.mm.pluginsdk.permission;

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
import com.tencent.mm.ui.base.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class PermissionHelper
{
  private static final byte[] XUn;
  private static final Map<Integer, d> XUo;
  private static volatile int XUp;
  private static final byte[] XUq;
  private static final Map<Integer, g> XUr;
  private static volatile int XUs;
  private static final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(244633);
    XUn = new byte[0];
    XUo = new HashMap();
    XUp = 28673;
    XUq = new byte[0];
    XUr = new HashMap();
    XUs = 24577;
    mHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(244633);
  }
  
  /* Error */
  private static void a(PermissionHelper.c paramc, int paramInt, f paramf)
  {
    // Byte code:
    //   0: ldc 93
    //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: checkcast 20	com/tencent/mm/pluginsdk/permission/PermissionHelper$b
    //   9: invokeinterface 97 1 0
    //   14: astore 4
    //   16: aload 4
    //   18: ifnonnull +16 -> 34
    //   21: ldc 99
    //   23: ldc 101
    //   25: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: ldc 93
    //   30: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: new 108	android/content/Intent
    //   37: dup
    //   38: ldc 110
    //   40: new 112	java/lang/StringBuilder
    //   43: dup
    //   44: ldc 114
    //   46: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload 4
    //   51: invokevirtual 123	android/content/Context:getPackageName	()Ljava/lang/String;
    //   54: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 136	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   63: invokespecial 139	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   66: astore 5
    //   68: getstatic 70	com/tencent/mm/pluginsdk/permission/PermissionHelper:XUq	[B
    //   71: astore 4
    //   73: aload 4
    //   75: monitorenter
    //   76: invokestatic 143	com/tencent/mm/pluginsdk/permission/PermissionHelper:iIS	()I
    //   79: istore_3
    //   80: new 34	com/tencent/mm/pluginsdk/permission/PermissionHelper$g
    //   83: dup
    //   84: iload_1
    //   85: aload_2
    //   86: iconst_0
    //   87: invokespecial 146	com/tencent/mm/pluginsdk/permission/PermissionHelper$g:<init>	(ILcom/tencent/mm/pluginsdk/permission/PermissionHelper$f;B)V
    //   90: astore 6
    //   92: getstatic 72	com/tencent/mm/pluginsdk/permission/PermissionHelper:XUr	Ljava/util/Map;
    //   95: iload_3
    //   96: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aload 6
    //   101: invokeinterface 158 3 0
    //   106: pop
    //   107: aload_0
    //   108: checkcast 20	com/tencent/mm/pluginsdk/permission/PermissionHelper$b
    //   111: aload 5
    //   113: iload_3
    //   114: invokeinterface 162 3 0
    //   119: aload 4
    //   121: monitorexit
    //   122: ldc 93
    //   124: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: return
    //   128: astore_0
    //   129: aload_2
    //   130: invokeinterface 165 1 0
    //   135: ldc 93
    //   137: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: return
    //   141: astore_0
    //   142: aload 4
    //   144: monitorexit
    //   145: ldc 93
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
    //   5	16	128	finally
    //   21	28	128	finally
    //   34	76	128	finally
    //   122	127	128	finally
    //   142	152	128	finally
    //   76	122	141	finally
  }
  
  private static void a(PermissionHelper.c paramc, int paramInt, String paramString, e parame)
  {
    AppMethodBeat.i(244602);
    ??? = ((b)paramc).getContext();
    if (??? == null)
    {
      Log.e("MicroMsg.PermissionHelper", "[-] context is null, skip rest steps.");
      AppMethodBeat.o(244602);
      return;
    }
    if (a.checkSelfPermission((Context)???, paramString) == 0)
    {
      parame.Sd(paramString);
      AppMethodBeat.o(244602);
      return;
    }
    synchronized (XUn)
    {
      int i = iIR();
      parame = new d(paramInt, paramString, parame, (byte)0);
      XUo.put(Integer.valueOf(i), parame);
      ((b)paramc).requestPermissions(new String[] { paramString }, i);
      AppMethodBeat.o(244602);
      return;
    }
  }
  
  public static boolean aUq(String paramString)
  {
    AppMethodBeat.i(244571);
    if (a.checkSelfPermission(MMApplicationContext.getContext(), paramString) == 0)
    {
      AppMethodBeat.o(244571);
      return true;
    }
    AppMethodBeat.o(244571);
    return false;
  }
  
  /* Error */
  public static PermissionHelper.c bH(Activity paramActivity)
  {
    // Byte code:
    //   0: ldc 246
    //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 99
    //   7: ldc 248
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: invokestatic 215	com/tencent/mm/pluginsdk/permission/PermissionHelper:iIT	()Z
    //   18: invokestatic 253	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   21: aastore
    //   22: invokestatic 256	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: iconst_1
    //   26: anewarray 23	com/tencent/mm/pluginsdk/permission/PermissionHelper$c
    //   29: astore_1
    //   30: aload_1
    //   31: iconst_0
    //   32: aconst_null
    //   33: aastore
    //   34: new 6	com/tencent/mm/pluginsdk/permission/PermissionHelper$1
    //   37: dup
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 259	com/tencent/mm/pluginsdk/permission/PermissionHelper$1:<init>	(Landroid/app/Activity;[Lcom/tencent/mm/pluginsdk/permission/PermissionHelper$c;)V
    //   43: astore_0
    //   44: invokestatic 215	com/tencent/mm/pluginsdk/permission/PermissionHelper:iIT	()Z
    //   47: ifeq +20 -> 67
    //   50: aload_0
    //   51: invokeinterface 264 1 0
    //   56: aload_1
    //   57: iconst_0
    //   58: aaload
    //   59: astore_0
    //   60: ldc 246
    //   62: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_0
    //   66: areturn
    //   67: getstatic 87	com/tencent/mm/pluginsdk/permission/PermissionHelper:mHandler	Landroid/os/Handler;
    //   70: aload_0
    //   71: invokevirtual 267	android/os/Handler:postAtFrontOfQueue	(Ljava/lang/Runnable;)Z
    //   74: pop
    //   75: aload_1
    //   76: monitorenter
    //   77: aload_1
    //   78: iconst_0
    //   79: aaload
    //   80: ifnonnull +14 -> 94
    //   83: aload_1
    //   84: invokevirtual 270	java/lang/Object:wait	()V
    //   87: goto -10 -> 77
    //   90: astore_0
    //   91: goto -14 -> 77
    //   94: aload_1
    //   95: monitorexit
    //   96: aload_1
    //   97: iconst_0
    //   98: aaload
    //   99: astore_0
    //   100: ldc 246
    //   102: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: areturn
    //   107: astore_0
    //   108: aload_1
    //   109: monitorexit
    //   110: ldc 246
    //   112: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_0
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramActivity	Activity
    //   29	80	1	arrayOfc	PermissionHelper.c[]
    // Exception table:
    //   from	to	target	type
    //   83	87	90	finally
    //   94	96	107	finally
  }
  
  private static int iIR()
  {
    synchronized (XUn)
    {
      if (XUp == 32768) {
        XUp = 28673;
      }
      int i = XUp;
      XUp = i + 1;
      return i;
    }
  }
  
  private static int iIS()
  {
    synchronized (XUq)
    {
      if (XUs == 28672) {
        XUs = 24577;
      }
      int i = XUs;
      XUs = i + 1;
      return i;
    }
  }
  
  private static boolean iIT()
  {
    AppMethodBeat.i(244595);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(244595);
      return true;
    }
    AppMethodBeat.o(244595);
    return false;
  }
  
  public static final class AuxSupportFragment
    extends androidx.fragment.app.Fragment
    implements PermissionHelper.b, PermissionHelper.c
  {
    public final void a(int paramInt, String paramString, PermissionHelper.e parame)
    {
      AppMethodBeat.i(244594);
      if (!isDetached()) {
        PermissionHelper.c(this, paramInt, paramString, parame);
      }
      AppMethodBeat.o(244594);
    }
    
    public final void a(PermissionHelper.f paramf)
    {
      AppMethodBeat.i(244611);
      if (!isDetached()) {
        PermissionHelper.a(this, paramf);
      }
      AppMethodBeat.o(244611);
    }
    
    public final void a(String paramString1, String paramString2, final String paramString3, final PermissionHelper.e parame)
    {
      AppMethodBeat.i(244600);
      if (!isDetached())
      {
        Context localContext = getContext();
        if (localContext != null)
        {
          if (PermissionHelper.aUq(paramString3))
          {
            a(241, paramString3, parame);
            AppMethodBeat.o(244600);
            return;
          }
          k.a(localContext, paramString2, paramString1, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(244578);
              PermissionHelper.AuxSupportFragment.this.a(this.val$requestCode, paramString3, parame);
              AppMethodBeat.o(244578);
            }
          });
        }
      }
      AppMethodBeat.o(244600);
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(244615);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (!isDetached()) {
        PermissionHelper.avQ(paramInt1);
      }
      AppMethodBeat.o(244615);
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(244587);
      super.onCreate(paramBundle);
      setRetainInstance(true);
      AppMethodBeat.o(244587);
    }
    
    public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(244606);
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      if (!isDetached()) {
        PermissionHelper.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(244606);
    }
  }
  
  public static final class a
    extends android.app.Fragment
    implements PermissionHelper.b, PermissionHelper.c
  {
    public WeakReference<Context> mContextRef;
    
    public final void a(int paramInt, String paramString, PermissionHelper.e parame)
    {
      AppMethodBeat.i(244586);
      if (!isDetached()) {
        PermissionHelper.c(this, paramInt, paramString, parame);
      }
      AppMethodBeat.o(244586);
    }
    
    public final void a(PermissionHelper.f paramf)
    {
      AppMethodBeat.i(244607);
      if (!isDetached()) {
        PermissionHelper.a(this, paramf);
      }
      AppMethodBeat.o(244607);
    }
    
    public final void a(String paramString1, String paramString2, final String paramString3, final PermissionHelper.e parame)
    {
      AppMethodBeat.i(244596);
      if (!isDetached())
      {
        Context localContext = getContext();
        if (localContext != null)
        {
          if (PermissionHelper.aUq(paramString3))
          {
            a(241, paramString3, parame);
            AppMethodBeat.o(244596);
            return;
          }
          k.a(localContext, paramString2, paramString1, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(244567);
              PermissionHelper.a.this.a(this.val$requestCode, paramString3, parame);
              AppMethodBeat.o(244567);
            }
          });
        }
      }
      AppMethodBeat.o(244596);
    }
    
    public final Context getContext()
    {
      AppMethodBeat.i(244588);
      Context localContext = null;
      if (Build.VERSION.SDK_INT >= 23) {
        localContext = super.getContext();
      }
      for (;;)
      {
        AppMethodBeat.o(244588);
        return localContext;
        if (this.mContextRef != null) {
          localContext = (Context)this.mContextRef.get();
        }
      }
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(244612);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (!isDetached()) {
        PermissionHelper.avQ(paramInt1);
      }
      AppMethodBeat.o(244612);
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(244582);
      super.onCreate(paramBundle);
      setRetainInstance(true);
      AppMethodBeat.o(244582);
    }
    
    public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(244601);
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      if (!isDetached()) {
        PermissionHelper.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(244601);
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
    String PxW;
    int XUy;
    PermissionHelper.e XUz;
    
    private d(int paramInt, String paramString, PermissionHelper.e parame)
    {
      this.XUy = paramInt;
      this.PxW = paramString;
      this.XUz = parame;
    }
  }
  
  public static abstract interface e
  {
    public abstract void Sd(String paramString);
    
    public abstract void a(PermissionHelper.c paramc, String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void bTy();
    
    public abstract void bTz();
  }
  
  static final class g
  {
    PermissionHelper.f XUA;
    int XUy;
    
    private g(int paramInt, PermissionHelper.f paramf)
    {
      this.XUy = paramInt;
      this.XUA = paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.PermissionHelper
 * JD-Core Version:    0.7.0.1
 */