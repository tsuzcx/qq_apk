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
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/util/ActivityHelper;", "", "()V", "START_METHOD", "", "TAG", "USE_ACTIVITY", "", "USE_SERVICE", "delayTime", "", "getDelayTime", "()J", "checkAndStartActivity", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "remoteViews", "Landroid/widget/RemoteViews;", "description", "destClass", "isImmediately", "", "channelId", "isNotifyStill", "plugin", "entry", "checkAndStartActivityWithoutOp", "startActivityOnNotification", "startActivityOnNotificationWithoutOp", "startActivityOnService", "serviceClass", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  public static final a agpj;
  public static final int agpk = 0;
  public static final int agpl;
  public static String agpm;
  private static final long delayTime;
  
  static
  {
    AppMethodBeat.i(149830);
    agpj = new a();
    TAG = "MicroMsg.ActivityHelper";
    agpl = 1;
    agpm = "startMethod";
    delayTime = 800L;
    AppMethodBeat.o(149830);
  }
  
  public static final void a(Context paramContext, Intent paramIntent, RemoteViews paramRemoteViews, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(149827);
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    s.u(paramString1, "description");
    s.u(paramString3, "channelId");
    if ((d.rd(28)) || (s.p(Build.VERSION.CODENAME, "Q"))) {}
    for (boolean bool = true;; bool = false)
    {
      MMHandlerThread.postToMainThreadDelayed(new a..ExternalSyntheticLambda1(bool, paramRemoteViews, paramIntent, paramContext, paramString1, paramString2, paramString3, true), 0L);
      AppMethodBeat.o(149827);
      return;
    }
  }
  
  private static void a(Context paramContext, Intent paramIntent, RemoteViews paramRemoteViews, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(233985);
    e locale = e.agta;
    e.b(paramContext, paramIntent, paramRemoteViews, paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(233985);
  }
  
  public static final void a(Context paramContext, Intent paramIntent, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(233998);
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    s.u(paramString1, "description");
    s.u(paramString3, "channelId");
    long l;
    if (paramBoolean)
    {
      l = 0L;
      if ((!d.rd(28)) && (!s.p(Build.VERSION.CODENAME, "Q"))) {
        break label95;
      }
    }
    label95:
    for (paramBoolean = true;; paramBoolean = false)
    {
      MMHandlerThread.postToMainThreadDelayed(new a..ExternalSyntheticLambda0(paramBoolean, paramContext, paramIntent, paramString1, paramString2, paramString3, false), l);
      AppMethodBeat.o(233998);
      return;
      l = delayTime;
      break;
    }
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, Intent paramIntent, RemoteViews paramRemoteViews, String paramString3, String paramString4)
  {
    AppMethodBeat.i(149829);
    s.u(paramContext, "context");
    s.u(paramString1, "plugin");
    s.u(paramString2, "entry");
    s.u(paramIntent, "intent");
    s.u(paramString3, "description");
    s.u(paramString4, "channelId");
    if ((d.rd(28)) || (s.p(Build.VERSION.CODENAME, "Q"))) {}
    for (boolean bool = true;; bool = false)
    {
      MMHandlerThread.postToMainThreadDelayed(new a..ExternalSyntheticLambda2(bool, paramRemoteViews, paramIntent, paramString1, paramString2, paramContext, paramString3, paramString4, true), 0L);
      AppMethodBeat.o(149829);
      return;
    }
  }
  
  private static final void a(boolean paramBoolean1, Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    AppMethodBeat.i(234014);
    s.u(paramContext, "$context");
    s.u(paramIntent, "$intent");
    s.u(paramString1, "$description");
    s.u(paramString3, "$channelId");
    if ((paramBoolean1) && (!AppForegroundDelegate.heY.eLx))
    {
      Log.i(TAG, "start permission notification in Q and use service");
      e locale = e.agta;
      e.a(paramContext, paramIntent, paramString1, paramString2, paramString3, paramBoolean2);
      AppMethodBeat.o(234014);
      return;
    }
    Log.i(TAG, "start permission notification in Q and use activity");
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/util/ActivityHelper", "checkAndStartActivityWithoutOp$lambda-1", "(ZLandroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/util/ActivityHelper", "checkAndStartActivityWithoutOp$lambda-1", "(ZLandroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(234014);
  }
  
  private static final void a(boolean paramBoolean1, RemoteViews paramRemoteViews, Intent paramIntent, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    AppMethodBeat.i(234008);
    s.u(paramIntent, "$intent");
    s.u(paramContext, "$context");
    s.u(paramString1, "$description");
    s.u(paramString3, "$channelId");
    if ((paramBoolean1) && (!AppForegroundDelegate.heY.eLx) && (paramRemoteViews != null))
    {
      Log.i(TAG, "start permission notification in Q and use service");
      paramIntent.putExtra("Voip_Call_From", 0);
      a(paramContext, paramIntent, paramRemoteViews, paramString1, paramString2, paramString3, paramBoolean2);
      AppMethodBeat.o(234008);
      return;
    }
    Log.i(TAG, "start permission notification in Q and use activity");
    paramIntent.putExtra("Voip_Call_From", 1);
    paramRemoteViews = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramRemoteViews.aYi(), "com/tencent/mm/util/ActivityHelper", "checkAndStartActivityWithoutOp$lambda-0", "(ZLandroid/widget/RemoteViews;Landroid/content/Intent;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramRemoteViews.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/util/ActivityHelper", "checkAndStartActivityWithoutOp$lambda-0", "(ZLandroid/widget/RemoteViews;Landroid/content/Intent;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(234008);
  }
  
  private static final void a(boolean paramBoolean1, RemoteViews paramRemoteViews, Intent paramIntent, String paramString1, String paramString2, Context paramContext, String paramString3, String paramString4, boolean paramBoolean2)
  {
    AppMethodBeat.i(234024);
    s.u(paramIntent, "$intent");
    s.u(paramString1, "$plugin");
    s.u(paramString2, "$entry");
    s.u(paramContext, "$context");
    s.u(paramString3, "$description");
    s.u(paramString4, "$channelId");
    if ((paramBoolean1) && (!AppForegroundDelegate.heY.eLx) && (paramRemoteViews != null))
    {
      Log.i(TAG, "start permission notification in Q and use service");
      paramIntent.putExtra(agpm, agpk);
      paramString1 = MMApplicationContext.getSourcePackageName() + ".plugin." + paramString1;
      if (n.U(paramString2, ".", false)) {}
      for (paramString1 = s.X(paramString1, paramString2);; paramString1 = paramString2)
      {
        Class.forName(paramString1, false, paramContext.getClassLoader());
        a(paramContext, paramIntent, paramRemoteViews, paramString3, paramString1, paramString4, paramBoolean2);
        AppMethodBeat.o(234024);
        return;
      }
    }
    paramIntent.putExtra(agpm, agpl);
    Log.i(TAG, "start permission notification in Q and use activity");
    c.a(paramContext, paramString1, paramString2, paramIntent, null);
    AppMethodBeat.o(234024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.util.a
 * JD-Core Version:    0.7.0.1
 */