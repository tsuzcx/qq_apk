package com.tencent.mm.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.s.c;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.notification.c;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/util/FullscreenIntentActivityUtil;", "", "()V", "CONTENTTEXT", "", "DESTCLASS", "NOTIFICATION_CHANNEL_ID", "NOTIFY_STILL", "REMOTEVIEW", "TAG", "getTAG", "()Ljava/lang/String;", "callNormalNotification", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "remoteViews", "Landroid/widget/RemoteViews;", "description", "destClass", "channelId", "isNotifyStill", "", "cancelNotification", "getNotificationIconRs", "", "startActivity", "remoteView", "startActivityWithOp", "stopFullScreenService", "plugin-comm_release"})
public final class b
{
  public static final String Jpb = "fullscreenRemoteview";
  public static final String Jpc = "contentText";
  public static final String Jpd = "destClass";
  public static final String Jpe = "channelId";
  public static final String Jpf = "notifyStill";
  public static final b Jpg;
  private static final String TAG = "MicroMsg.FullscreenIntentActivityUtil";
  
  static
  {
    AppMethodBeat.i(149845);
    Jpg = new b();
    Jpb = "fullscreenRemoteview";
    Jpc = "contentText";
    Jpd = "destClass";
    Jpe = "channelId";
    Jpf = "notifyStill";
    TAG = "MicroMsg.FullscreenIntentActivityUtil";
    AppMethodBeat.o(149845);
  }
  
  public static void b(Context paramContext, Intent paramIntent, RemoteViews paramRemoteViews, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(149841);
    k.h(paramContext, "context");
    k.h(paramIntent, "intent");
    k.h(paramString1, "description");
    k.h(paramString2, "destClass");
    k.h(paramString3, "channelId");
    c(paramContext, paramIntent, paramRemoteViews, paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(149841);
  }
  
  public static void b(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(149842);
    k.h(paramContext, "context");
    k.h(paramIntent, "intent");
    k.h(paramString1, "description");
    k.h(paramString2, "destClass");
    k.h(paramString3, "channelId");
    c(paramContext, paramIntent, null, paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(149842);
  }
  
  private static void c(Context paramContext, Intent paramIntent, RemoteViews paramRemoteViews, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(149843);
    k.h(paramContext, "context");
    k.h(paramIntent, "intent");
    k.h(paramString1, "description");
    k.h(paramString2, "destClass");
    k.h(paramString3, "channelId");
    paramIntent.setFlags(268435456);
    Context localContext = ai.getContext();
    k.g(localContext, "MMApplicationContext.getContext()");
    paramIntent.setClassName(localContext.getPackageName(), paramString2);
    paramIntent = PendingIntent.getActivity(ai.getContext(), 0, paramIntent, 134217728);
    if (paramRemoteViews != null)
    {
      paramContext = new s.c(paramContext, paramString3).dV().u("call").i(System.currentTimeMillis()).a(paramIntent).c(paramIntent).as(dlN()).b(paramRemoteViews).f((CharSequence)ai.getContext().getString(2131755866)).c(paramRemoteViews).g((CharSequence)paramString1).dU().F(true);
      k.g(paramContext, "NotificationCompat.Build…\t\t\t\t\t.setAutoCancel(true)");
    }
    for (;;)
    {
      paramContext = paramContext.build();
      if (paramBoolean) {
        paramContext.flags |= 0x4;
      }
      c.dlf().notify(41, paramContext);
      AppMethodBeat.o(149843);
      return;
      paramContext = new s.c(paramContext, paramString3).dV().u("reminder").i(System.currentTimeMillis()).a(paramIntent).c(paramIntent).as(dlN()).f((CharSequence)ai.getContext().getString(2131755866)).g((CharSequence)paramString1).dU().F(true);
      k.g(paramContext, "NotificationCompat.Build…\t\t\t\t\t.setAutoCancel(true)");
    }
  }
  
  private static int dlN()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  public static final void fwU()
  {
    AppMethodBeat.i(149844);
    c.dlf().cancel(41);
    AppMethodBeat.o(149844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.util.b
 * JD-Core Version:    0.7.0.1
 */