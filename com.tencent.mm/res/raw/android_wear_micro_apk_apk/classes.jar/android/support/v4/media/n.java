package android.support.v4.media;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

final class n
{
  private final List<o> gL = new ArrayList();
  private final List<Bundle> gM = new ArrayList();
  
  public final o a(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(paramContext.getClassLoader());
    }
    int i = 0;
    while (i < this.gM.size())
    {
      if (z.a((Bundle)this.gM.get(i), paramBundle)) {
        return (o)this.gL.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public final List<Bundle> aI()
  {
    return this.gM;
  }
  
  public final List<o> aJ()
  {
    return this.gL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.n
 * JD-Core Version:    0.7.0.1
 */