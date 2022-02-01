package com.tencent.mm.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.s.c;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.av;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/util/FullscreenIntentActivityUtil;", "", "()V", "CONTENTTEXT", "", "DESTCLASS", "NOTIFICATION_CHANNEL_ID", "NOTIFY_STILL", "REMOTEVIEW", "TAG", "getTAG", "()Ljava/lang/String;", "callNormalNotification", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "remoteViews", "Landroid/widget/RemoteViews;", "description", "destClass", "channelId", "isNotifyStill", "", "cancelNotification", "getNotificationIconRs", "", "startActivity", "remoteView", "startActivityWithOp", "stopFullScreenService", "plugin-comm_release"})
public final class d
{
  public static final String LDh = "fullscreenRemoteview";
  public static final String LDi = "contentText";
  public static final String LDj = "destClass";
  public static final String LDk = "channelId";
  public static final String LDl = "notifyStill";
  public static final d LDm;
  private static final String TAG = "MicroMsg.FullscreenIntentActivityUtil";
  
  static
  {
    AppMethodBeat.i(149845);
    LDm = new d();
    LDh = "fullscreenRemoteview";
    LDi = "contentText";
    LDj = "destClass";
    LDk = "channelId";
    LDl = "notifyStill";
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
    Context localContext = ak.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    paramIntent.setClassName(localContext.getPackageName(), paramString2);
    paramIntent = PendingIntent.getActivity(ak.getContext(), 0, paramIntent, 134217728);
    if (paramRemoteViews != null)
    {
      paramContext = new s.c(paramContext, paramString3).eq().t("call").i(System.currentTimeMillis()).a(paramIntent).c(paramIntent).as(dzu()).b(paramRemoteViews).f((CharSequence)ak.getContext().getString(2131755866)).c(paramRemoteViews).g((CharSequence)paramString1).ep().F(true);
      p.g(paramContext, "NotificationCompat.Build…\t\t\t\t\t.setAutoCancel(true)");
    }
    for (;;)
    {
      paramContext = paramContext.build();
      if (paramBoolean) {
        paramContext.flags |= 0x4;
      }
      com.tencent.mm.plugin.notification.d.dyL().notify(41, paramContext);
      AppMethodBeat.o(149843);
      return;
      paramContext = new s.c(paramContext, paramString3).eq().t("reminder").i(System.currentTimeMillis()).a(paramIntent).c(paramIntent).as(dzu()).f((CharSequence)ak.getContext().getString(2131755866)).g((CharSequence)paramString1).ep().F(true);
      p.g(paramContext, "NotificationCompat.Build…\t\t\t\t\t.setAutoCancel(true)");
    }
  }
  
  private static int dzu()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  public static final void evs()
  {
    AppMethodBeat.i(149844);
    com.tencent.mm.plugin.notification.d.dyL().cancel(41);
    AppMethodBeat.o(149844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.util.d
 * JD-Core Version:    0.7.0.1
 */