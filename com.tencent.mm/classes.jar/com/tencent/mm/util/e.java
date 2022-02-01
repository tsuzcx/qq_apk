package com.tencent.mm.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.notification.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/util/FullscreenIntentActivityUtil;", "", "()V", "CONTENTTEXT", "", "DESTCLASS", "NOTIFICATION_CHANNEL_ID", "NOTIFY_STILL", "REMOTEVIEW", "TAG", "getTAG", "()Ljava/lang/String;", "callNormalNotification", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "remoteViews", "Landroid/widget/RemoteViews;", "description", "destClass", "channelId", "isNotifyStill", "", "cancelNotification", "getNotificationIconRs", "", "startActivity", "remoteView", "startActivityOnService", "serviceClass", "startActivityWithOp", "stopFullScreenService", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final String TAG;
  public static final e agta;
  public static final String agtb;
  public static final String agtc;
  public static final String agtd;
  public static final String agte;
  public static final String agtf;
  
  static
  {
    AppMethodBeat.i(149845);
    agta = new e();
    agtb = "fullscreenRemoteview";
    agtc = "contentText";
    agtd = "destClass";
    agte = "channelId";
    agtf = "notifyStill";
    TAG = "MicroMsg.FullscreenIntentActivityUtil";
    AppMethodBeat.o(149845);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(149842);
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    s.u(paramString1, "description");
    s.u(paramString3, "channelId");
    c(paramContext, paramIntent, null, paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(149842);
  }
  
  public static void b(Context paramContext, Intent paramIntent, RemoteViews paramRemoteViews, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(149841);
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    s.u(paramString1, "description");
    s.u(paramString3, "channelId");
    c(paramContext, paramIntent, paramRemoteViews, paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(149841);
  }
  
  private static void c(Context paramContext, Intent paramIntent, RemoteViews paramRemoteViews, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(149843);
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    s.u(paramString1, "description");
    s.u(paramString3, "channelId");
    paramIntent.setFlags(268435456);
    if (paramString2 != null) {
      paramIntent.setClassName(MMApplicationContext.getContext().getPackageName(), paramString2);
    }
    paramIntent = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, paramIntent, 134217728);
    if (paramRemoteViews != null)
    {
      paramContext = new f.d(paramContext, paramString3);
      paramContext.mPriority = 1;
      paramContext.boM = "call";
      paramContext = paramContext.bt(System.currentTimeMillis());
      paramContext.bor = paramIntent;
      paramContext = paramContext.c(paramIntent).eb(guX());
      paramContext.boO = paramRemoteViews;
      paramContext = paramContext.l((CharSequence)MMApplicationContext.getContext().getString(c.h.app_pushcontent_title));
      paramContext.boP = paramRemoteViews;
      paramContext = paramContext.m((CharSequence)paramString1);
      paramContext.q(2, true);
      paramContext = paramContext.aC(true);
      s.s(paramContext, "Builder(context, channel…\t\t\t\t\t.setAutoCancel(true)");
    }
    for (;;)
    {
      paramContext = paramContext.DA();
      s.s(paramContext, "builder.build()");
      if (paramBoolean) {
        paramContext.flags |= 0x4;
      }
      f.MvN.c(41, paramContext);
      AppMethodBeat.o(149843);
      return;
      paramContext = new f.d(paramContext, paramString3);
      paramContext.mPriority = 1;
      paramContext.boM = "reminder";
      paramContext = paramContext.bt(System.currentTimeMillis());
      paramContext.bor = paramIntent;
      paramContext = paramContext.c(paramIntent).eb(guX()).l((CharSequence)MMApplicationContext.getContext().getString(c.h.app_pushcontent_title)).m((CharSequence)paramString1);
      paramContext.q(2, true);
      paramContext = paramContext.aC(true);
      s.s(paramContext, "Builder(context, channel…\t\t\t\t\t.setAutoCancel(true)");
    }
  }
  
  private static int guX()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return c.d.notification_icon;
    }
    return c.d.notification_icon_gray;
  }
  
  public static final void hPY()
  {
    AppMethodBeat.i(149844);
    f.MvN.cancel(41);
    AppMethodBeat.o(149844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.util.e
 * JD-Core Version:    0.7.0.1
 */