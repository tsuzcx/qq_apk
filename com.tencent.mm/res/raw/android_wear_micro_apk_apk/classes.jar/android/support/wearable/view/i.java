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
  public static final Drawable Cu = new j((byte)0);
  public static final Point Cv = new Point(-1, -1);
  public static final Point Cw = new Point(-2, -2);
  private k Cx;
  private DataSetObservable jV = new DataSetObservable();
  
  public static int fb()
  {
    return 0;
  }
  
  public static void fc() {}
  
  public static void fd() {}
  
  public static void fe() {}
  
  public static Drawable ff()
  {
    return Cu;
  }
  
  public static Drawable fg()
  {
    return Cu;
  }
  
  public static Point fh()
  {
    return Cv;
  }
  
  protected static void fi() {}
  
  public static void fj() {}
  
  public abstract Object a(ViewGroup paramViewGroup, int paramInt);
  
  final void a(k paramk)
  {
    this.Cx = paramk;
  }
  
  public abstract boolean a(View paramView, Object paramObject);
  
  public abstract void b(ViewGroup paramViewGroup, Object paramObject);
  
  public abstract int fa();
  
  public abstract int getRowCount();
  
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
 * Qualified Name:     android.support.wearable.view.i
 * JD-Core Version:    0.7.0.1
 */