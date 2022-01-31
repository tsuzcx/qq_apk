import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.mobileqq.widget.PagingScrollView;
import com.tencent.qphone.base.util.QLog;

public class akvm
  implements View.OnTouchListener
{
  public akvm(PagingScrollView paramPagingScrollView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.c)
    {
      int i = paramMotionEvent.getAction();
      if ((i == 1) || (i == 3))
      {
        this.a.c = false;
        this.a.getParent().requestDisallowInterceptTouchEvent(false);
        if (QLog.isDevelopLevel()) {
          QLog.i("PageScrollView", 4, "C.TE ACT_UP or CANCEL");
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akvm
 * JD-Core Version:    0.7.0.1
 */