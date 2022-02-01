package com.tencent.mm.util;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.by.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/util/ActivityHelper;", "", "()V", "START_METHOD", "", "TAG", "USE_ACTIVITY", "", "USE_SERVICE", "delayTime", "", "getDelayTime", "()J", "checkAndStartActivity", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "remoteViews", "Landroid/widget/RemoteViews;", "description", "destClass", "isImmediately", "", "channelId", "isNotifyStill", "plugin", "entry", "checkAndStartActivityWithoutOp", "startActivityOnNotification", "startActivityOnNotificationWithoutOp", "plugin-comm_release"})
public final class a
{
  private static final String TAG = "MicroMsg.ActivityHelper";
  public static final int YwR = 0;
  public static final int YwS = 1;
  public static String YwT;
  public static final a YwU;
  private static final long delayTime = 800L;
  
  static
  {
    AppMethodBeat.i(149830);
    YwU = new a();
    TAG = "MicroMsg.ActivityHelper";
    YwS = 1;
    YwT = "startMethod";
    delayTime = 800L;
    AppMethodBeat.o(149830);
  }
  
  public static final void a(final Context paramContext, final Intent paramIntent, final RemoteViews paramRemoteViews, final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(149827);
    p.k(paramContext, "context");
    p.k(paramIntent, "intent");
    p.k(paramString1, "description");
    p.k(paramString2, "destClass");
    p.k(paramString3, "channelId");
    if ((d.qX(28)) || (p.h(Build.VERSION.CODENAME, "Q"))) {}
    for (boolean bool = true;; bool = false)
    {
      MMHandlerThread.postToMainThreadDelayed((Runnable)new a(bool, paramRemoteViews, paramIntent, paramContext, paramString1, paramString2, paramString3), 0L);
      AppMethodBeat.o(149827);
      return;
    }
  }
  
  public static final void a(final Context paramContext, final Intent paramIntent, final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(149828);
    p.k(paramContext, "context");
    p.k(paramIntent, "intent");
    p.k(paramString1, "description");
    p.k(paramString2, "destClass");
    p.k(paramString3, "channelId");
    long l = delayTime;
    if ((d.qX(28)) || (p.h(Build.VERSION.CODENAME, "Q"))) {}
    for (boolean bool = true;; bool = false)
    {
      MMHandlerThread.postToMainThreadDelayed((Runnable)new b(bool, paramContext, paramIntent, paramString1, paramString2, paramString3), l);
      AppMethodBeat.o(149828);
      return;
    }
  }
  
  public static final void a(final Context paramContext, final String paramString1, final String paramString2, final Intent paramIntent, final RemoteViews paramRemoteViews, final String paramString3, final String paramString4)
  {
    AppMethodBeat.i(149829);
    p.k(paramContext, "context");
    p.k(paramString1, "plugin");
    p.k(paramString2, "entry");
    p.k(paramIntent, "intent");
    p.k(paramString3, "description");
    p.k(paramString4, "channelId");
    if ((d.qX(28)) || (p.h(Build.VERSION.CODENAME, "Q"))) {}
    for (boolean bool = true;; bool = false)
    {
      MMHandlerThread.postToMainThreadDelayed((Runnable)new c(bool, paramRemoteViews, paramIntent, paramString1, paramString2, paramContext, paramString3, paramString4), 0L);
      AppMethodBeat.o(149829);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(boolean paramBoolean, RemoteViews paramRemoteViews, Intent paramIntent, Context paramContext, String paramString1, String paramString2, String paramString3) {}
    
    public final void run()
    {
      AppMethodBeat.i(149824);
      if ((this.YwV) && (!AppForegroundDelegate.fby.aax()) && (paramRemoteViews != null))
      {
        localObject1 = a.YwU;
        Log.i(a.iem(), "start permission notification in Q and use service");
        paramIntent.putExtra("Voip_Call_From", 0);
        localObject1 = a.YwU;
        a.a(paramContext, paramIntent, paramRemoteViews, paramString1, paramString2, paramString3, this.YwZ);
        AppMethodBeat.o(149824);
        return;
      }
      Object localObject1 = a.YwU;
      Log.i(a.iem(), "start permission notification in Q and use activity");
      paramIntent.putExtra("Voip_Call_From", 1);
      localObject1 = paramContext;
      Object localObject2 = paramIntent;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(149824);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(boolean paramBoolean, Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3) {}
    
    public final void run()
    {
      AppMethodBeat.i(149825);
      if ((this.YwV) && (!AppForegroundDelegate.fby.aax()))
      {
        localObject1 = a.YwU;
        Log.i(a.iem(), "start permission notification in Q and use service");
        localObject1 = a.YwU;
        a.a(paramContext, paramIntent, paramString1, paramString2, paramString3, this.YwZ);
        AppMethodBeat.o(149825);
        return;
      }
      Object localObject1 = a.YwU;
      Log.i(a.iem(), "start permission notification in Q and use activity");
      localObject1 = paramContext;
      Object localObject2 = paramIntent;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(149825);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(boolean paramBoolean, RemoteViews paramRemoteViews, Intent paramIntent, String paramString1, String paramString2, Context paramContext, String paramString3, String paramString4) {}
    
    public final void run()
    {
      AppMethodBeat.i(149826);
      if ((this.YwV) && (!AppForegroundDelegate.fby.aax()) && (paramRemoteViews != null))
      {
        localObject = a.YwU;
        Log.i(a.iem(), "start permission notification in Q and use service");
        paramIntent.putExtra(a.YwT, a.YwR);
        localObject = MMApplicationContext.getSourcePackageName() + ".plugin." + paramString1;
        if (n.M(paramString2, ".", false)) {}
        for (localObject = (String)localObject + paramString2;; localObject = paramString2)
        {
          Class.forName((String)localObject, false, paramContext.getClassLoader());
          a locala = a.YwU;
          a.a(paramContext, paramIntent, paramRemoteViews, paramString3, (String)localObject, paramString4, this.YwZ);
          AppMethodBeat.o(149826);
          return;
        }
      }
      paramIntent.putExtra(a.YwT, a.YwS);
      Object localObject = a.YwU;
      Log.i(a.iem(), "start permission notification in Q and use activity");
      c.a(paramContext, paramString1, paramString2, paramIntent, null);
      AppMethodBeat.o(149826);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.util.a
 * JD-Core Version:    0.7.0.1
 */