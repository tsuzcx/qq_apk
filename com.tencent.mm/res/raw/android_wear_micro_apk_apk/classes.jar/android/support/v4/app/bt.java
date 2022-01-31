package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.Set;

public final class bt
  extends ca
{
  private static final bu fG;
  public static final cb fH;
  private final Bundle ew;
  private final String fB;
  private final CharSequence fC;
  private final CharSequence[] fD;
  private final boolean fE;
  private final Set<String> fF;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 20) {
      fG = new bv();
    }
    for (;;)
    {
      fH = new cb() {};
      return;
      if (Build.VERSION.SDK_INT >= 16) {
        fG = new bx();
      } else {
        fG = new bw();
      }
    }
  }
  
  public final boolean getAllowFreeFormInput()
  {
    return this.fE;
  }
  
  public final Set<String> getAllowedDataTypes()
  {
    return this.fF;
  }
  
  public final CharSequence[] getChoices()
  {
    return this.fD;
  }
  
  public final Bundle getExtras()
  {
    return this.ew;
  }
  
  public final CharSequence getLabel()
  {
    return this.fC;
  }
  
  public final String getResultKey()
  {
    return this.fB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.bt
 * JD-Core Version:    0.7.0.1
 */