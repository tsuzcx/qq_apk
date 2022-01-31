package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.List;

final class bo
{
  private static final Object fu = new Object();
  private static Field fv;
  private static boolean fw;
  private static final Object fx = new Object();
  
  public static Bundle a(Notification paramNotification)
  {
    Object localObject1;
    Bundle localBundle;
    synchronized (fu)
    {
      if (fw) {
        return null;
      }
    }
  }
  
  public static void a(an paraman, CharSequence paramCharSequence1, boolean paramBoolean, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    paraman = new Notification.BigTextStyle(paraman.ay()).setBigContentTitle(paramCharSequence1).bigText(paramCharSequence3);
    if (paramBoolean) {
      paraman.setSummaryText(paramCharSequence2);
    }
  }
  
  public static Bundle b(Notification.Builder paramBuilder, bm parambm)
  {
    paramBuilder.addAction(parambm.getIcon(), parambm.getTitle(), parambm.getActionIntent());
    paramBuilder = new Bundle(parambm.getExtras());
    if (parambm.aA() != null) {
      paramBuilder.putParcelableArray("android.support.remoteInputs", cc.b(parambm.aA()));
    }
    if (parambm.az() != null) {
      paramBuilder.putParcelableArray("android.support.dataRemoteInputs", cc.b(parambm.az()));
    }
    paramBuilder.putBoolean("android.support.allowGeneratedReplies", parambm.getAllowGeneratedReplies());
    return paramBuilder;
  }
  
  public static SparseArray<Bundle> b(List<Bundle> paramList)
  {
    Object localObject1 = null;
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Bundle localBundle = (Bundle)paramList.get(i);
      Object localObject2 = localObject1;
      if (localBundle != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new SparseArray();
        }
        ((SparseArray)localObject2).put(i, localBundle);
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.bo
 * JD-Core Version:    0.7.0.1
 */