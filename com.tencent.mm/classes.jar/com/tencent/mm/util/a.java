package com.tencent.mm.util;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.k;
import d.l;
import d.n.n;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/util/ActivityHelper;", "", "()V", "START_METHOD", "", "TAG", "USE_ACTIVITY", "", "USE_SERVICE", "delayTime", "", "getDelayTime", "()J", "checkAndStartActivity", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "remoteViews", "Landroid/widget/RemoteViews;", "description", "destClass", "isImmediately", "", "channelId", "isNotifyStill", "plugin", "entry", "checkAndStartActivityWithoutOp", "startActivityOnNotification", "startActivityOnNotificationWithoutOp", "plugin-comm_release"})
public final class a
{
  public static final int HOs = 0;
  public static final int HOt = 1;
  public static String HOu;
  private static final long HOv = 800L;
  public static final a HOw;
  private static final String TAG = "MicroMsg.ActivityHelper";
  
  static
  {
    AppMethodBeat.i(149830);
    HOw = new a();
    TAG = "MicroMsg.ActivityHelper";
    HOt = 1;
    HOu = "startMethod";
    HOv = 800L;
    AppMethodBeat.o(149830);
  }
  
  public static final void a(final Context paramContext, final Intent paramIntent, final RemoteViews paramRemoteViews, final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(149827);
    k.h(paramContext, "context");
    k.h(paramIntent, "intent");
    k.h(paramString1, "description");
    k.h(paramString2, "destClass");
    k.h(paramString3, "channelId");
    if ((com.tencent.mm.compatible.util.d.lh(28)) || (k.g(Build.VERSION.CODENAME, "Q"))) {}
    for (boolean bool = true;; bool = false)
    {
      aq.n((Runnable)new a(bool, paramRemoteViews, paramContext, paramIntent, paramString1, paramString2, paramString3), 0L);
      AppMethodBeat.o(149827);
      return;
    }
  }
  
  public static final void a(final Context paramContext, final Intent paramIntent, final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(149828);
    k.h(paramContext, "context");
    k.h(paramIntent, "intent");
    k.h(paramString1, "description");
    k.h(paramString2, "destClass");
    k.h(paramString3, "channelId");
    long l = HOv;
    if ((com.tencent.mm.compatible.util.d.lh(28)) || (k.g(Build.VERSION.CODENAME, "Q"))) {}
    for (boolean bool = true;; bool = false)
    {
      aq.n((Runnable)new b(bool, paramContext, paramIntent, paramString1, paramString2, paramString3), l);
      AppMethodBeat.o(149828);
      return;
    }
  }
  
  public static final void a(final Context paramContext, final String paramString1, final String paramString2, final Intent paramIntent, final RemoteViews paramRemoteViews, final String paramString3, final String paramString4)
  {
    AppMethodBeat.i(149829);
    k.h(paramContext, "context");
    k.h(paramString1, "plugin");
    k.h(paramString2, "entry");
    k.h(paramIntent, "intent");
    k.h(paramString3, "description");
    k.h(paramString4, "channelId");
    if ((com.tencent.mm.compatible.util.d.lh(28)) || (k.g(Build.VERSION.CODENAME, "Q"))) {}
    for (boolean bool = true;; bool = false)
    {
      aq.n((Runnable)new c(bool, paramRemoteViews, paramIntent, paramString1, paramString2, paramContext, paramString3, paramString4), 0L);
      AppMethodBeat.o(149829);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(boolean paramBoolean, RemoteViews paramRemoteViews, Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3) {}
    
    public final void run()
    {
      AppMethodBeat.i(149824);
      if ((this.HOx) && (!AppForegroundDelegate.cKE.Kx()) && (paramRemoteViews != null))
      {
        localObject1 = a.HOw;
        ad.i(a.fgT(), "start permission notification in Q and use service");
        localObject1 = a.HOw;
        a.a(paramContext, paramIntent, paramRemoteViews, paramString1, paramString2, paramString3, this.HOC);
        AppMethodBeat.o(149824);
        return;
      }
      Object localObject1 = a.HOw;
      ad.i(a.fgT(), "start permission notification in Q and use activity");
      localObject1 = paramContext;
      Object localObject2 = paramIntent;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(149824);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(boolean paramBoolean, Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3) {}
    
    public final void run()
    {
      AppMethodBeat.i(149825);
      if ((this.HOx) && (!AppForegroundDelegate.cKE.Kx()))
      {
        localObject1 = a.HOw;
        ad.i(a.fgT(), "start permission notification in Q and use service");
        localObject1 = a.HOw;
        a.a(paramContext, paramIntent, paramString1, paramString2, paramString3, this.HOC);
        AppMethodBeat.o(149825);
        return;
      }
      Object localObject1 = a.HOw;
      ad.i(a.fgT(), "start permission notification in Q and use activity");
      localObject1 = paramContext;
      Object localObject2 = paramIntent;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/util/ActivityHelper$checkAndStartActivityWithoutOp$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(149825);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(boolean paramBoolean, RemoteViews paramRemoteViews, Intent paramIntent, String paramString1, String paramString2, Context paramContext, String paramString3, String paramString4) {}
    
    public final void run()
    {
      AppMethodBeat.i(149826);
      if ((this.HOx) && (!AppForegroundDelegate.cKE.Kx()) && (paramRemoteViews != null))
      {
        localObject = a.HOw;
        ad.i(a.fgT(), "start permission notification in Q and use service");
        paramIntent.putExtra(a.HOu, a.HOs);
        localObject = aj.eFC() + ".plugin." + paramString1;
        if (n.mA(paramString2, ".")) {}
        for (localObject = (String)localObject + paramString2;; localObject = paramString2)
        {
          Class.forName((String)localObject, false, paramContext.getClassLoader());
          a locala = a.HOw;
          a.a(paramContext, paramIntent, paramRemoteViews, paramString3, (String)localObject, paramString4, this.HOC);
          AppMethodBeat.o(149826);
          return;
        }
      }
      paramIntent.putExtra(a.HOu, a.HOt);
      Object localObject = a.HOw;
      ad.i(a.fgT(), "start permission notification in Q and use activity");
      com.tencent.mm.bs.d.a(paramContext, paramString1, paramString2, paramIntent, null);
      AppMethodBeat.o(149826);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.util.a
 * JD-Core Version:    0.7.0.1
 */