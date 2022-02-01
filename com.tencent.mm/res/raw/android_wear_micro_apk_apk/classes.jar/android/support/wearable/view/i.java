package android.support.wearable.view;

import android.annotation.TargetApi;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(20)
public abstract class i
{
  public static final Drawable Ej = new j((byte)0);
  public static final Point Ek = new Point(-1, -1);
  public static final Point El = new Point(-2, -2);
  private k Em;
  private DataSetObservable lS = new DataSetObservable();
  
  public static Drawable fq()
  {
    return Ej;
  }
  
  public static Drawable fr()
  {
    return Ej;
  }
  
  public static Point fs()
  {
    return Ek;
  }
  
  public abstract Object a(ViewGroup paramViewGroup, int paramInt);
  
  final void a(k paramk)
  {
    this.Em = paramk;
  }
  
  public abstract boolean a(View paramView, Object paramObject);
  
  public abstract void b(ViewGroup paramViewGroup, Object paramObject);
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.lS.registerObserver(paramDataSetObserver);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.lS.unregisterObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.i
 * JD-Core Version:    0.7.0.1
 */