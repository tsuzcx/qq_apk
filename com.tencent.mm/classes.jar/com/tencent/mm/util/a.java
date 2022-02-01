package com.tencent.mm.util;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/util/ActivityHelper;", "", "()V", "START_METHOD", "", "TAG", "USE_ACTIVITY", "", "USE_SERVICE", "delayTime", "", "getDelayTime", "()J", "checkAndStartActivity", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "remoteViews", "Landroid/widget/RemoteViews;", "description", "destClass", "isImmediately", "", "channelId", "isNotifyStill", "plugin", "entry", "checkAndStartActivityWithoutOp", "startActivityOnNotification", "startActivityOnNotificationWithoutOp", "plugin-comm_release"})
public final class a
{
  public static final int QYj = 0;
  public static final int QYk = 1;
  public static String QYl;
  public static final a QYm;
  private static final String TAG = "MicroMsg.ActivityHelper";
  private static final long delayTime = 800L;
  
  static
  {
    AppMethodBeat.i(149830);
    QYm = new a();
    TAG = "MicroMsg.ActivityHelper";
    QYk = 1;
    QYl = "startMethod";
    delayTime = 800L;
    AppMethodBeat.o(149830);
  }
  
  public static final void a(final Context paramContext, final Intent paramIntent, final RemoteViews paramRemoteViews, final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(149827);
    p.h(paramContext, "context");
    p.h(paramIntent, "intent");
    p.h(paramString1, "description");
    p.h(paramString2, "destClass");
    p.h(paramString3, "channelId");
    if ((d.oF(28)) || (p.j(Build.VERSION.CODENAME, "Q"))) {}
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
    p.h(paramContext, "context");
    p.h(paramIntent, "intent");
    p.h(paramString1, "description");
    p.h(paramString2, "destClass");
    p.h(paramString3, "channelId");
    long l = delayTime;
    if ((d.oF(28)) || (p.j(Build.VERSION.CODENAME, "Q"))) {}
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
    p.h(paramContext, "context");
    p.h(paramString1, "plugin");
    p.h(paramString2, "entry");
    p.h(paramIntent, "intent");
    p.h(paramString3, "description");
    p.h(paramString4, "channelId");
    if ((d.oF(28)) || (p.j(Build.VERSION.CODENAME, "Q"))) {}
    for (boolean bool = true;; bool = false)
    {
      MMHandlerThread.postToMainThreadDelayed((Runnable)new c(bool, paramRemoteViews, paramIntent, paramString1, paramString2, paramContext, paramString3, paramString4), 0L);
      AppMethodBeat.o(149829);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(boolean paramBoolean, RemoteViews paramRemoteViews, Intent paramIntent, Context paramContext, String paramString1, String paramString2, String paramString3) {}
    
    public final void run()
    {
      AppMethodBeat.i(149824);
      if ((this.QYn) && (!AppForegroundDelegate.djR.Wc()) && (paramRemoteViews != null))
      {
        localObject1 = a.QYm;
        Log.i(a.hcX(), "start permission notification in Q and use service");
        paramIntent.putExtra("Voip_Call_From", 0);
        localObject1 = a.QYm;
        a.a(paramContext, paramIntent, paramRemoteViews, paramString1, paramString2, paramString3, this.QYr);
        AppMethodBeat.o(149824);
        return;
      }
      Object localObject1 = a.QYm;
      Log.i(a.hcX(), "start permission notification in Q and use activity");
      paramIntent.putExtra("Voip_Call_From", 1);
      localObject1 = paramContext;
      Object localObject2 = paramIntent;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(149824);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(boolean paramBoolean, Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3) {}
    
    public final void run()
    {
      AppMethodBeat.i(149825);
      if ((this.QYn) && (!AppForegroundDelegate.djR.Wc()))
      {
        localObject1 = a.QYm;
        Log.i(a.hcX(), "start permission notification in Q and use service");
        localObject1 = a.QYm;
        a.a(paramContext, paramIntent, paramString1, paramString2, paramString3, this.QYr);
        AppMethodBeat.o(149825);
        return;
      }
      Object localObject1 = a.QYm;
      Log.i(a.hcX(), "start permission notification in Q and use activity");
      localObject1 = paramContext;
      Object localObject2 = paramIntent;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(149825);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(boolean paramBoolean, RemoteViews paramRemoteViews, Intent paramIntent, String paramString1, String paramString2, Context paramContext, String paramString3, String paramString4) {}
    
    public final void run()
    {
      AppMethodBeat.i(149826);
      if ((this.QYn) && (!AppForegroundDelegate.djR.Wc()) && (paramRemoteViews != null))
      {
        localObject = a.QYm;
        Log.i(a.hcX(), "start permission notification in Q and use service");
        paramIntent.putExtra(a.QYl, a.QYj);
        localObject = MMApplicationContext.getSourcePackageName() + ".plugin." + paramString1;
        if (n.J(paramString2, ".", false)) {}
        for (localObject = (String)localObject + paramString2;; localObject = paramString2)
        {
          Class.forName((String)localObject, false, paramContext.getClassLoader());
          a locala = a.QYm;
          a.a(paramContext, paramIntent, paramRemoteViews, paramString3, (String)localObject, paramString4, this.QYr);
          AppMethodBeat.o(149826);
          return;
        }
      }
      paramIntent.putExtra(a.QYl, a.QYk);
      Object localObject = a.QYm;
      Log.i(a.hcX(), "start permission notification in Q and use activity");
      c.a(paramContext, paramString1, paramString2, paramIntent, null);
      AppMethodBeat.o(149826);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.util.a
 * JD-Core Version:    0.7.0.1
 */