package android.support.v4.app;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

final class cc
{
  static Bundle[] b(ca[] paramArrayOfca)
  {
    if (paramArrayOfca == null) {
      return null;
    }
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfca.length];
    int i = 0;
    while (i < paramArrayOfca.length)
    {
      Object localObject1 = paramArrayOfca[i];
      Bundle localBundle = new Bundle();
      localBundle.putString("resultKey", ((ca)localObject1).getResultKey());
      localBundle.putCharSequence("label", ((ca)localObject1).getLabel());
      localBundle.putCharSequenceArray("choices", ((ca)localObject1).getChoices());
      localBundle.putBoolean("allowFreeFormInput", ((ca)localObject1).getAllowFreeFormInput());
      localBundle.putBundle("extras", ((ca)localObject1).getExtras());
      Object localObject2 = ((ca)localObject1).getAllowedDataTypes();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.cc
 * JD-Core Version:    0.7.0.1
 */