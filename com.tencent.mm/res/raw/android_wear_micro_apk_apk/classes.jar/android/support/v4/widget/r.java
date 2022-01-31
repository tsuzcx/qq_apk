package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class r
  extends q
{
  private Method pN;
  private Field pO;
  
  r()
  {
    try
    {
      this.pN = View.class.getDeclaredMethod("getDisplayList", null);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          this.pO = View.class.getDeclaredField("mRecreateDisplayList");
          this.pO.setAccessible(true);
          return;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", localNoSuchFieldException);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", localNoSuchMethodException);
      }
    }
  }
  
  public final void a(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    if ((this.pN != null) && (this.pO != null)) {
      try
      {
        this.pO.setBoolean(paramView, true);
        this.pN.invoke(paramView, null);
        super.a(paramSlidingPaneLayout, paramView);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("SlidingPaneLayout", "Error refreshing display list state", localException);
        }
      }
    }
    paramView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.r
 * JD-Core Version:    0.7.0.1
 */