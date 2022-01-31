package android.support.v7.widget;

import android.database.Observable;
import java.util.ArrayList;

final class u
  extends Observable<v>
{
  public final void notifyChanged()
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((v)this.mObservers.get(i)).onChanged();
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.u
 * JD-Core Version:    0.7.0.1
 */