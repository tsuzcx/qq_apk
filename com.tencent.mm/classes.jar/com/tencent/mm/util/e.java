package com.tencent.mm.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.notification.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/util/FullscreenIntentActivityUtil;", "", "()V", "CONTENTTEXT", "", "DESTCLASS", "NOTIFICATION_CHANNEL_ID", "NOTIFY_STILL", "REMOTEVIEW", "TAG", "getTAG", "()Ljava/lang/String;", "callNormalNotification", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "remoteViews", "Landroid/widget/RemoteViews;", "description", "destClass", "channelId", "isNotifyStill", "", "cancelNotification", "getNotificationIconRs", "", "startActivity", "remoteView", "startActivityWithOp", "stopFullScreenService", "plugin-comm_release"})
public final class e
{
  private static final String TAG = "MicroMsg.FullscreenIntentActivityUtil";
  public static final String YyC = "fullscreenRemoteview";
  public static final String YyD = "contentText";
  public static final String YyE = "destClass";
  public static final String YyF = "channelId";
  public static final String YyG = "notifyStill";
  public static final e YyH;
  
  static
  {
    AppMethodBeat.i(149845);
    YyH = new e();
    YyC = "fullscreenRemoteview";
    YyD = "contentText";
    YyE = "destClass";
    YyF = "channelId";
    YyG = "notifyStill";
    TAG = "MicroMsg.FullscreenIntentActivityUtil";
    AppMethodBeat.o(149845);
  }
  
  public static void b(Context paramContext, Intent paramIntent, RemoteViews paramRemoteViews, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(149841);
    p.k(paramContext, "context");
    p.k(paramIntent, "intent");
    p.k(paramString1, "description");
    p.k(paramString2, "destClass");
    p.k(paramString3, "channelId");
    c(paramContext, paramIntent, paramRemoteViews, paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(149841);
  }
  
  public static void b(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(149842);
    p.k(paramContext, "context");
    p.k(paramIntent, "intent");
    p.k(paramString1, "description");
    p.k(paramString2, "destClass");
    p.k(paramString3, "channelId");
    c(paramContext, paramIntent, null, paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(149842);
  }
  
  private static void c(Context paramContext, Intent paramIntent, RemoteViews paramRemoteViews, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(149843);
    p.k(paramContext, "context");
    p.k(paramIntent, "intent");
    p.k(paramString1, "description");
    p.k(paramString2, "destClass");
    p.k(paramString3, "channelId");
    paramIntent.setFlags(268435456);
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    paramIntent.setClassName(localContext.getPackageName(), paramString2);
    paramIntent = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, paramIntent, 134217728);
    if (paramRemoteViews != null)
    {
      paramContext = new e.d(paramContext, paramString3).gq().z("call").e(System.currentTimeMillis()).a(paramIntent).c(paramIntent).bn(fkG()).b(paramRemoteViews).k((CharSequence)MMApplicationContext.getContext().getString(c.h.app_pushcontent_title)).c(paramRemoteViews).l((CharSequence)paramString1).gp().W(true);
      p.j(paramContext, "NotificationCompat.Build…\t\t\t\t\t.setAutoCancel(true)");
    }
    for (;;)
    {
      paramContext = paramContext.gr();
      if (paramBoolean) {
        paramContext.flags |= 0x4;
      }
      d.fjX().c(41, paramContext);
      AppMethodBeat.o(149843);
      return;
      paramContext = new e.d(paramContext, paramString3).gq().z("reminder").e(System.currentTimeMillis()).a(paramIntent).c(paramIntent).bn(fkG()).k((CharSequence)MMApplicationContext.getContext().getString(c.h.app_pushcontent_title)).l((CharSequence)paramString1).gp().W(true);
      p.j(paramContext, "NotificationCompat.Build…\t\t\t\t\t.setAutoCancel(true)");
    }
  }
  
  private static int fkG()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return c.d.notification_icon;
    }
    return c.d.notification_icon_gray;
  }
  
  public static final void gsM()
  {
    AppMethodBeat.i(149844);
    d.fjX().cancel(41);
    AppMethodBeat.o(149844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.util.e
 * JD-Core Version:    0.7.0.1
 */