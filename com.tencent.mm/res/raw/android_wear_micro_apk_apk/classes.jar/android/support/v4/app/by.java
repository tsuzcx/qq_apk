package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;

final class by
{
  static RemoteInput[] a(ca[] paramArrayOfca)
  {
    if (paramArrayOfca == null) {
      return null;
    }
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfca.length];
    int i = 0;
    while (i < paramArrayOfca.length)
    {
      ca localca = paramArrayOfca[i];
      arrayOfRemoteInput[i] = new RemoteInput.Builder(localca.getResultKey()).setLabel(localca.getLabel()).setChoices(localca.getChoices()).setAllowFreeFormInput(localca.getAllowFreeFormInput()).addExtras(localca.getExtras()).build();
      i += 1;
    }
    return arrayOfRemoteInput;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.by
 * JD-Core Version:    0.7.0.1
 */