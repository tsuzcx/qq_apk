import android.graphics.Point;
import android.graphics.Rect;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class aarq
  implements View.OnTouchListener
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<TribeVideoPlugin> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aarq(TribeVideoPlugin paramTribeVideoPlugin, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTribeVideoPlugin);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (TribeVideoPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramView == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TribeVideoPlugin.a(paramView).containsKey(this.jdField_a_of_type_JavaLangString))) {}
    for (;;)
    {
      return false;
      Object localObject1 = aarr.a((aarr)TribeVideoPlugin.a(paramView).get(this.jdField_a_of_type_JavaLangString));
      if ((localObject1 != null) && (aarp.a((aarp)localObject1) == 2))
      {
        switch (paramMotionEvent.getAction())
        {
        case 2: 
        default: 
          return false;
        case 0: 
          TribeVideoPlugin.a(paramView).x = ((int)paramMotionEvent.getRawX());
          TribeVideoPlugin.a(paramView).y = ((int)paramMotionEvent.getRawY());
          return false;
        }
        TribeVideoPlugin.b(paramView).x = ((int)paramMotionEvent.getRawX());
        TribeVideoPlugin.b(paramView).y = ((int)paramMotionEvent.getRawY());
        if ((Math.abs(TribeVideoPlugin.a(paramView).y - TribeVideoPlugin.b(paramView).y) < 8) && (Math.abs(TribeVideoPlugin.a(paramView).x - TribeVideoPlugin.b(paramView).x) < 8))
        {
          paramMotionEvent = new Rect();
          localObject1 = TribeVideoPlugin.a(paramView).keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            String str = (String)((Iterator)localObject1).next();
            Object localObject2 = aarr.a((aarr)TribeVideoPlugin.a(paramView).get(str));
            SeekBar localSeekBar = aarp.a(aarr.a((aarr)TribeVideoPlugin.a(paramView).get(str)));
            ((FrameLayout)localObject2).getGlobalVisibleRect(paramMotionEvent);
            if ((paramMotionEvent.contains(TribeVideoPlugin.a(paramView).x, TribeVideoPlugin.a(paramView).y)) && (paramMotionEvent.contains(TribeVideoPlugin.b(paramView).x, TribeVideoPlugin.b(paramView).y)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("TribeVideoPlugin", 2, "videoplayer section clicked");
              }
              if (localSeekBar.getVisibility() == 4)
              {
                TribeVideoPlugin.a(paramView).removeMessages(2, str);
                TribeVideoPlugin.a(paramView, str, true);
                localObject2 = TribeVideoPlugin.a(paramView).obtainMessage();
                ((Message)localObject2).obj = str;
                ((Message)localObject2).what = 2;
                TribeVideoPlugin.a(paramView).sendMessageDelayed((Message)localObject2, 3000L);
              }
              else
              {
                TribeVideoPlugin.a(paramView, str, false);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarq
 * JD-Core Version:    0.7.0.1
 */