package android.arch.lifecycle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class x
{
  private final HashMap<String, u> ap = new HashMap();
  
  public final void clear()
  {
    Iterator localIterator = this.ap.values().iterator();
    while (localIterator.hasNext()) {
      ((u)localIterator.next()).q();
    }
    this.ap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.x
 * JD-Core Version:    0.7.0.1
 */