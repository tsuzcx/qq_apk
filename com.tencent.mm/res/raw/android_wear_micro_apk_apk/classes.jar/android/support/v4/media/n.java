package android.support.v4.media;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

final class n
{
  private final List<o> iJ = new ArrayList();
  private final List<Bundle> iK = new ArrayList();
  
  public final o a(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(paramContext.getClassLoader());
    }
    int i = 0;
    while (i < this.iK.size())
    {
      if (z.a((Bundle)this.iK.get(i), paramBundle)) {
        return (o)this.iJ.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public final List<Bundle> aY()
  {
    return this.iK;
  }
  
  public final List<o> aZ()
  {
    return this.iJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.n
 * JD-Core Version:    0.7.0.1
 */