package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;

public abstract class o
{
  private final DataSetObservable jV = new DataSetObservable();
  
  public static void bp()
  {
    throw new UnsupportedOperationException("Required method destroyItem was not overridden");
  }
  
  public abstract boolean bq();
  
  public abstract int getCount();
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.jV.registerObserver(paramDataSetObserver);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.jV.unregisterObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.o
 * JD-Core Version:    0.7.0.1
 */