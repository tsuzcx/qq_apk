package com.tencent.mm.wear.app.d;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.tencent.mm.d.b;
import com.tencent.mm.e.a.w;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.service.subservice.DeleteNotificationService;
import com.tencent.mm.wear.app.service.subservice.NotDisturbService;
import com.tencent.mm.wear.app.ui.MessageHistoryUI;
import com.tencent.mm.wear.app.ui.emoji.a;

public final class d
{
  private w adc;
  private e add;
  private Notification ade;
  private Context context;
  
  public d(Context paramContext, w paramw)
  {
    this.context = paramContext;
    this.adc = paramw;
  }
  
  private static SpannableStringBuilder H(String paramString)
  {
    paramString = paramString.split("​​");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < paramString.length)
    {
      Object localObject = paramString[i];
      if (i != 0)
      {
        localSpannableString = new SpannableString("\n");
        localSpannableString.setSpan(new AbsoluteSizeSpan(18), 0, 1, 33);
        localSpannableStringBuilder.append(localSpannableString);
      }
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
      localSpannableString.setSpan(new AbsoluteSizeSpan(27), 0, ((String)localObject).length(), 33);
      localSpannableStringBuilder.append(localSpannableString);
      if (i != paramString.length - 1)
      {
        localObject = new SpannableString("\n");
        ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(27), 0, 1, 33);
        localSpannableStringBuilder.append((CharSequence)localObject);
      }
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  private static boolean I(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    return paramString.endsWith("@chatroom");
  }
  
  private static Intent a(Context paramContext, int paramInt, e parame, Class paramClass)
  {
    paramContext = new Intent(paramContext, paramClass);
    paramContext.putExtra("key_talker", parame.adf);
    paramContext.putExtra("key_notification_id", parame.ada);
    paramContext.putExtra("key_fun_id", paramInt);
    return paramContext;
  }
  
  public static CharSequence bO(int paramInt)
  {
    String str = MMApplication.getContext().getString(paramInt);
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new AbsoluteSizeSpan(28), 0, str.length(), 33);
    return localSpannableString;
  }
  
  public static CharSequence n(String paramString1, String paramString2)
  {
    paramString2 = a.O(paramString2);
    SpannableString localSpannableString = new SpannableString(paramString2);
    localSpannableString.setSpan(new AbsoluteSizeSpan(21), 0, paramString2.length(), 33);
    if (!I(paramString1)) {
      localSpannableString.setSpan(new ForegroundColorSpan(-6052957), 0, paramString2.length(), 33);
    }
    return localSpannableString;
  }
  
  public static CharSequence o(String paramString1, String paramString2)
  {
    paramString2 = a.O(paramString2);
    if (I(paramString1))
    {
      paramString2 = paramString2.split("​​");
      paramString1 = new SpannableStringBuilder();
      int i = 0;
      while (i < paramString2.length)
      {
        Object localObject = paramString2[i].split("​");
        if (i != 0)
        {
          localSpannableString1 = new SpannableString("\n");
          localSpannableString1.setSpan(new AbsoluteSizeSpan(18), 0, 1, 33);
          paramString1.append(localSpannableString1);
        }
        SpannableString localSpannableString1 = localObject[0];
        SpannableString localSpannableString2 = new SpannableString(localSpannableString1);
        localSpannableString2.setSpan(new AbsoluteSizeSpan(21), 0, localSpannableString1.length(), 33);
        localSpannableString2.setSpan(new ForegroundColorSpan(-6052957), 0, localSpannableString1.length(), 33);
        paramString1.append(localSpannableString2);
        localSpannableString1 = new SpannableString("\n");
        localSpannableString1.setSpan(new AbsoluteSizeSpan(21), 0, 1, 33);
        paramString1.append(localSpannableString1);
        localSpannableString1 = new SpannableString("\n");
        localSpannableString1.setSpan(new AbsoluteSizeSpan(4), 0, 1, 33);
        paramString1.append(localSpannableString1);
        localObject = localObject[1];
        localSpannableString1 = new SpannableString((CharSequence)localObject);
        localSpannableString1.setSpan(new AbsoluteSizeSpan(27), 0, ((String)localObject).length(), 33);
        paramString1.append(localSpannableString1);
        if (i != paramString2.length - 1)
        {
          localObject = new SpannableString("\n");
          ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(27), 0, 1, 33);
          paramString1.append((CharSequence)localObject);
        }
        i += 1;
      }
    }
    for (;;)
    {
      paramString1.setSpan(new StyleSpan(0), 0, paramString1.length(), 33);
      return paramString1;
      paramString1 = H(paramString2);
    }
  }
  
  public final void create()
  {
    this.add = new e();
    this.add.ada = this.adc.Vv;
    this.add.adf = this.adc.VN;
    this.add.adg = this.adc.Vw;
    this.add.adh = this.adc.Vx;
    this.add.adk = this.adc.Wg;
    this.add.adj = this.adc.We;
    this.add.adl = this.adc.Wf;
    Object localObject1;
    if (this.adc.Vy != null)
    {
      localObject1 = this.adc.Vy.toByteArray();
      this.add.adm = ((byte[])localObject1);
    }
    for (this.add.adi = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);; this.add.adi = BitmapFactory.decodeResource(this.context.getResources(), 2130837531))
    {
      com.tencent.mm.wear.a.c.d.c("MicroMsg.NotificationCreator", "send notification %s", new Object[] { this.add });
      localObject1 = PendingIntent.getService(this.context, this.add.ada, a(this.context, 11010, this.add, DeleteNotificationService.class).putExtra("key_unread_count", this.add.adj), 134217728);
      Object localObject2 = this.context;
      int i = this.add.ada;
      Object localObject3 = new Intent(this.context, MessageHistoryUI.class);
      Object localObject4 = this.add;
      ((Intent)localObject3).putExtra("key_talker", ((e)localObject4).adf);
      ((Intent)localObject3).putExtra("key_notification_id", ((e)localObject4).ada);
      ((Intent)localObject3).putExtra("key_avatar", ((e)localObject4).adm);
      localObject2 = PendingIntent.getActivity((Context)localObject2, i, (Intent)localObject3, 134217728);
      localObject3 = PendingIntent.getService(this.context, this.add.ada, a(this.context, 11011, this.add, NotDisturbService.class), 134217728);
      localObject4 = new Notification.Builder(this.context);
      ((Notification.Builder)localObject4).setLargeIcon(this.add.adi);
      ((Notification.Builder)localObject4).setSmallIcon(2130837543);
      ((Notification.Builder)localObject4).setContentTitle(n(this.add.adf, this.add.adg));
      ((Notification.Builder)localObject4).setContentText(o(this.add.adf, this.add.adh));
      ((Notification.Builder)localObject4).setDeleteIntent((PendingIntent)localObject1);
      ((Notification.Builder)localObject4).setPriority(2);
      if (this.add.adk) {
        ((Notification.Builder)localObject4).setVibrate(new long[] { 0L, 150L, 100L, 400L });
      }
      ((Notification.Builder)localObject4).addAction(new Notification.Action(2130837583, bO(2131165232), (PendingIntent)localObject2));
      ((Notification.Builder)localObject4).addAction(new Notification.Action(2130837580, bO(2131165220), (PendingIntent)localObject3));
      this.ade = ((Notification.Builder)localObject4).build();
      return;
    }
  }
  
  public final void send()
  {
    f.a(this.context, this.add.ada, this.ade);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.d
 * JD-Core Version:    0.7.0.1
 */