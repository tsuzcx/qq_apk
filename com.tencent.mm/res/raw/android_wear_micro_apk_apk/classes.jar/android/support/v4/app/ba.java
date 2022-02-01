package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import java.util.Set;

public final class ba
{
  private final Bundle gl;
  private final String hA;
  private final CharSequence hB;
  private final CharSequence[] hC;
  private final boolean hD;
  private final Set<String> hE;
  
  static RemoteInput[] b(ba[] paramArrayOfba)
  {
    if (paramArrayOfba == null) {
      return null;
    }
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfba.length];
    int i = 0;
    while (i < paramArrayOfba.length)
    {
      ba localba = paramArrayOfba[i];
      arrayOfRemoteInput[i] = new RemoteInput.Builder(localba.hA).setLabel(localba.hB).setChoices(localba.hC).setAllowFreeFormInput(localba.hD).addExtras(localba.gl).build();
      i += 1;
    }
    return arrayOfRemoteInput;
  }
  
  public final boolean getAllowFreeFormInput()
  {
    return this.hD;
  }
  
  public final Set<String> getAllowedDataTypes()
  {
    return this.hE;
  }
  
  public final CharSequence[] getChoices()
  {
    return this.hC;
  }
  
  public final Bundle getExtras()
  {
    return this.gl;
  }
  
  public final CharSequence getLabel()
  {
    return this.hB;
  }
  
  public final String getResultKey()
  {
    return this.hA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.ba
 * JD-Core Version:    0.7.0.1
 */