package com.tencent.mm.wear.app.d;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.ar;
import android.support.v4.app.at;
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
  private w agD;
  private e agE;
  private Notification agF;
  private Context context;
  
  public d(Context paramContext, w paramw)
  {
    this.context = paramContext;
    this.agD = paramw;
  }
  
  private static CharSequence M(String paramString)
  {
    SpannableString localSpannableString = new SpannableString(paramString);
    localSpannableString.setSpan(new AbsoluteSizeSpan(28), 0, paramString.length(), 33);
    return localSpannableString;
  }
  
  private static SpannableStringBuilder N(String paramString)
  {
    paramString = paramString.split("​​");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < paramString.length)
    {
      Object localObject = paramString[i].split("​");
      if (i != 0)
      {
        localSpannableString1 = new SpannableString("\n");
        localSpannableString1.setSpan(new AbsoluteSizeSpan(18), 0, 1, 33);
        localSpannableStringBuilder.append(localSpannableString1);
      }
      SpannableString localSpannableString1 = localObject[0];
      SpannableString localSpannableString2 = new SpannableString(localSpannableString1);
      localSpannableString2.setSpan(new AbsoluteSizeSpan(21), 0, localSpannableString1.length(), 33);
      localSpannableString2.setSpan(new ForegroundColorSpan(-6052957), 0, localSpannableString1.length(), 33);
      localSpannableStringBuilder.append(localSpannableString2);
      localSpannableString1 = new SpannableString("\n");
      localSpannableString1.setSpan(new AbsoluteSizeSpan(21), 0, 1, 33);
      localSpannableStringBuilder.append(localSpannableString1);
      localSpannableString1 = new SpannableString("\n");
      localSpannableString1.setSpan(new AbsoluteSizeSpan(4), 0, 1, 33);
      localSpannableStringBuilder.append(localSpannableString1);
      localObject = localObject[1];
      localSpannableString1 = new SpannableString((CharSequence)localObject);
      localSpannableString1.setSpan(new AbsoluteSizeSpan(27), 0, ((String)localObject).length(), 33);
      localSpannableStringBuilder.append(localSpannableString1);
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
  
  private static SpannableStringBuilder O(String paramString)
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
  
  private static boolean P(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    return paramString.endsWith("@chatroom");
  }
  
  private static Intent a(Context paramContext, int paramInt, e parame, Class paramClass)
  {
    paramContext = new Intent(paramContext, paramClass);
    paramContext.putExtra("key_talker", parame.agG);
    paramContext.putExtra("key_notification_id", parame.agB);
    paramContext.putExtra("key_fun_id", paramInt);
    return paramContext;
  }
  
  public static CharSequence ck(int paramInt)
  {
    return M(MMApplication.getContext().getString(paramInt));
  }
  
  public static CharSequence o(String paramString1, String paramString2)
  {
    paramString2 = a.V(paramString2);
    SpannableString localSpannableString = new SpannableString(paramString2);
    localSpannableString.setSpan(new AbsoluteSizeSpan(21), 0, paramString2.length(), 33);
    if (!P(paramString1)) {
      localSpannableString.setSpan(new ForegroundColorSpan(-6052957), 0, paramString2.length(), 33);
    }
    return localSpannableString;
  }
  
  public static CharSequence p(String paramString1, String paramString2)
  {
    paramString2 = a.V(paramString2);
    if (P(paramString1)) {}
    for (paramString1 = N(paramString2);; paramString1 = O(paramString2))
    {
      paramString1.setSpan(new StyleSpan(0), 0, paramString1.length(), 33);
      return paramString1;
    }
  }
  
  public final void create()
  {
    this.agE = new e();
    this.agE.agB = this.agD.Xq;
    this.agE.agG = this.agD.XI;
    this.agE.agH = this.agD.Xr;
    this.agE.agI = this.agD.Xs;
    this.agE.agL = this.agD.Yb;
    this.agE.agK = this.agD.XZ;
    this.agE.agM = this.agD.Ya;
    Object localObject1;
    if (this.agD.Xt != null)
    {
      localObject1 = this.agD.Xt.toByteArray();
      this.agE.agN = ((byte[])localObject1);
    }
    for (this.agE.agJ = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);; this.agE.agJ = BitmapFactory.decodeResource(this.context.getResources(), 2130837531))
    {
      com.tencent.mm.wear.a.c.d.c("MicroMsg.NotificationCreator", "send notification %s", new Object[] { this.agE });
      localObject1 = PendingIntent.getService(this.context, this.agE.agB, a(this.context, 11010, this.agE, DeleteNotificationService.class).putExtra("key_unread_count", this.agE.agK), 134217728);
      Object localObject2 = this.context;
      int i = this.agE.agB;
      Object localObject3 = new Intent(this.context, MessageHistoryUI.class);
      Object localObject4 = this.agE;
      ((Intent)localObject3).putExtra("key_talker", ((e)localObject4).agG);
      ((Intent)localObject3).putExtra("key_notification_id", ((e)localObject4).agB);
      ((Intent)localObject3).putExtra("key_avatar", ((e)localObject4).agN);
      localObject2 = PendingIntent.getActivity((Context)localObject2, i, (Intent)localObject3, 134217728);
      localObject3 = PendingIntent.getService(this.context, this.agE.agB, a(this.context, 11011, this.agE, NotDisturbService.class), 134217728);
      localObject4 = f.i(this.context, "message_channel_id");
      ((at)localObject4).a(this.agE.agJ);
      ((at)localObject4).t(2130837543);
      ((at)localObject4).b(o(this.agE.agG, this.agE.agH));
      ((at)localObject4).c(p(this.agE.agG, this.agE.agI));
      ((at)localObject4).b((PendingIntent)localObject1);
      ((at)localObject4).aO();
      if (this.agE.agL) {
        ((at)localObject4).a(new long[] { 0L, 150L, 100L, 400L });
      }
      ((at)localObject4).a(new ar(2130837583, ck(2131165233), (PendingIntent)localObject2));
      ((at)localObject4).a(new ar(2130837580, ck(2131165220), (PendingIntent)localObject3));
      this.agF = ((at)localObject4).build();
      return;
    }
  }
  
  public final void send()
  {
    g.a(this.context, this.agE.agB, this.agF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.d
 * JD-Core Version:    0.7.0.1
 */