package com.tencent.mm.wear.app.d;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  public static void a(Context paramContext, int paramInt, Notification paramNotification)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).notify(paramInt, paramNotification);
  }
  
  public static void a(Context paramContext, List<Integer> paramList)
  {
    paramContext = (NotificationManager)paramContext.getSystemService("notification");
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramContext.cancel(((Integer)paramList.next()).intValue());
    }
  }
  
  public static void i(Context paramContext, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramInt));
    a(paramContext, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.g
 * JD-Core Version:    0.7.0.1
 */