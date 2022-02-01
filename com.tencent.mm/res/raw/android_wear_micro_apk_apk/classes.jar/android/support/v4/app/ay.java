package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class ay
{
  private static final Object hu = new Object();
  private static Field hv;
  private static boolean hw;
  private static final Object hx = new Object();
  
  public static Bundle a(Notification.Builder paramBuilder, ar paramar)
  {
    paramBuilder.addAction(paramar.icon, paramar.title, paramar.actionIntent);
    paramBuilder = new Bundle(paramar.gl);
    if (paramar.aK() != null) {
      paramBuilder.putParcelableArray("android.support.remoteInputs", a(paramar.aK()));
    }
    if (paramar.aL() != null) {
      paramBuilder.putParcelableArray("android.support.dataRemoteInputs", a(paramar.aL()));
    }
    paramBuilder.putBoolean("android.support.allowGeneratedReplies", paramar.getAllowGeneratedReplies());
    return paramBuilder;
  }
  
  public static Bundle a(Notification paramNotification)
  {
    Object localObject1;
    Bundle localBundle;
    synchronized (hu)
    {
      if (hw) {
        return null;
      }
    }
  }
  
  private static Bundle[] a(ba[] paramArrayOfba)
  {
    if (paramArrayOfba == null) {
      return null;
    }
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfba.length];
    int i = 0;
    while (i < paramArrayOfba.length)
    {
      Object localObject1 = paramArrayOfba[i];
      Bundle localBundle = new Bundle();
      localBundle.putString("resultKey", ((ba)localObject1).getResultKey());
      localBundle.putCharSequence("label", ((ba)localObject1).getLabel());
      localBundle.putCharSequenceArray("choices", ((ba)localObject1).getChoices());
      localBundle.putBoolean("allowFreeFormInput", ((ba)localObject1).getAllowFreeFormInput());
      localBundle.putBundle("extras", ((ba)localObject1).getExtras());
      Object localObject2 = ((ba)localObject1).getAllowedDataTypes();
      if ((localObject2 != null) && (!((Set)localObject2).isEmpty()))
      {
        localObject1 = new ArrayList(((Set)localObject2).size());
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add((String)((Iterator)localObject2).next());
        }
        localBundle.putStringArrayList("allowedDataTypes", (ArrayList)localObject1);
      }
      arrayOfBundle[i] = localBundle;
      i += 1;
    }
    return arrayOfBundle;
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
  
  static Bundle e(ar paramar)
  {
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("icon", paramar.icon);
    localBundle2.putCharSequence("title", paramar.title);
    localBundle2.putParcelable("actionIntent", paramar.actionIntent);
    if (paramar.gl != null) {}
    for (Bundle localBundle1 = new Bundle(paramar.gl);; localBundle1 = new Bundle())
    {
      localBundle1.putBoolean("android.support.allowGeneratedReplies", paramar.getAllowGeneratedReplies());
      localBundle2.putBundle("extras", localBundle1);
      localBundle2.putParcelableArray("remoteInputs", a(paramar.aK()));
      return localBundle2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.ay
 * JD-Core Version:    0.7.0.1
 */