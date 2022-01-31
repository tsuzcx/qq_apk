package android.support.v4.app;

import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.os.Bundle;

final class bd
{
  public static void a(Notification.Builder paramBuilder, bm parambm)
  {
    Notification.Action.Builder localBuilder = new Notification.Action.Builder(parambm.getIcon(), parambm.getTitle(), parambm.getActionIntent());
    if (parambm.aA() != null)
    {
      localObject = by.a(parambm.aA());
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localBuilder.addRemoteInput(localObject[i]);
        i += 1;
      }
    }
    if (parambm.getExtras() != null) {}
    for (Object localObject = new Bundle(parambm.getExtras());; localObject = new Bundle())
    {
      ((Bundle)localObject).putBoolean("android.support.allowGeneratedReplies", parambm.getAllowGeneratedReplies());
      localBuilder.addExtras((Bundle)localObject);
      paramBuilder.addAction(localBuilder.build());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.bd
 * JD-Core Version:    0.7.0.1
 */