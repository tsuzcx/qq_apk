package com.tencent.mm.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.s.c;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/util/FullscreenIntentActivityUtil;", "", "()V", "CONTENTTEXT", "", "DESTCLASS", "NOTIFICATION_CHANNEL_ID", "NOTIFY_STILL", "REMOTEVIEW", "TAG", "getTAG", "()Ljava/lang/String;", "callNormalNotification", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "remoteViews", "Landroid/widget/RemoteViews;", "description", "destClass", "channelId", "isNotifyStill", "", "cancelNotification", "getNotificationIconRs", "", "startActivity", "remoteView", "startActivityWithOp", "stopFullScreenService", "plugin-comm_release"})
public final class d
{
  public static final String QYC = "fullscreenRemoteview";
  public static final String QYD = "contentText";
  public static final String QYE = "destClass";
  public static final String QYF = "channelId";
  public static final String QYG = "notifyStill";
  public static final d QYH;
  private static final String TAG = "MicroMsg.FullscreenIntentActivityUtil";
  
  static
  {
    AppMethodBeat.i(149845);
    QYH = new d();
    QYC = "fullscreenRemoteview";
    QYD = "contentText";
    QYE = "destClass";
    QYF = "channelId";
    QYG = "notifyStill";
    TAG = "MicroMsg.FullscreenIntentActivityUtil";
    AppMethodBeat.o(149845);
  }
  
  public static void b(Context paramContext, Intent paramIntent, RemoteViews paramRemoteViews, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(149841);
    p.h(paramContext, "context");
    p.h(paramIntent, "intent");
    p.h(paramString1, "description");
    p.h(paramString2, "destClass");
    p.h(paramString3, "channelId");
    c(paramContext, paramIntent, paramRemoteViews, paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(149841);
  }
  
  public static void b(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(149842);
    p.h(paramContext, "context");
    p.h(paramIntent, "intent");
    p.h(paramString1, "description");
    p.h(paramString2, "destClass");
    p.h(paramString3, "channelId");
    c(paramContext, paramIntent, null, paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(149842);
  }
  
  private static void c(Context paramContext, Intent paramIntent, RemoteViews paramRemoteViews, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(149843);
    p.h(paramContext, "context");
    p.h(paramIntent, "intent");
    p.h(paramString1, "description");
    p.h(paramString2, "destClass");
    p.h(paramString3, "channelId");
    paramIntent.setFlags(268435456);
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    paramIntent.setClassName(localContext.getPackageName(), paramString2);
    paramIntent = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, paramIntent, 134217728);
    if (paramRemoteViews != null)
    {
      paramContext = new s.c(paramContext, paramString3).eu().u("call").i(System.currentTimeMillis()).a(paramIntent).c(paramIntent).as(ezb()).b(paramRemoteViews).f((CharSequence)MMApplicationContext.getContext().getString(2131755955)).c(paramRemoteViews).g((CharSequence)paramString1).et().E(true);
      p.g(paramContext, "NotificationCompat.Build…\t\t\t\t\t.setAutoCancel(true)");
    }
    for (;;)
    {
      paramContext = paramContext.build();
      if (paramBoolean) {
        paramContext.flags |= 0x4;
      }
      com.tencent.mm.plugin.notification.d.eys().notify(41, paramContext);
      AppMethodBeat.o(149843);
      return;
      paramContext = new s.c(paramContext, paramString3).eu().u("reminder").i(System.currentTimeMillis()).a(paramIntent).c(paramIntent).as(ezb()).f((CharSequence)MMApplicationContext.getContext().getString(2131755955)).g((CharSequence)paramString1).et().E(true);
      p.g(paramContext, "NotificationCompat.Build…\t\t\t\t\t.setAutoCancel(true)");
    }
  }
  
  private static int ezb()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131234303;
    }
    return 2131234305;
  }
  
  public static final void fAL()
  {
    AppMethodBeat.i(149844);
    com.tencent.mm.plugin.notification.d.eys().cancel(41);
    AppMethodBeat.o(149844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.util.d
 * JD-Core Version:    0.7.0.1
 */