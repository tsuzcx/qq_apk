import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.widget.FixedBounceScrollView;

public class afik
  extends Handler
{
  public afik(QQSettingMe paramQQSettingMe, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      paramMessage = new Rect();
      localObject = this.a.jdField_a_of_type_ArrayOfAndroidViewView[4];
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.offsetDescendantRectToMyCoords((View)localObject, paramMessage);
      localObject = new Rect();
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.getDrawingRect((Rect)localObject);
      boolean bool = ((Rect)localObject).contains(paramMessage);
      if (!bool) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.scrollTo(this.a.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.getScrollX(), paramMessage.top);
      }
      if (bool) {}
      for (long l = 0L;; l = 50L)
      {
        sendEmptyMessageDelayed(1, l);
        return;
      }
    case 1: 
      paramMessage = new Rect();
      localObject = this.a.jdField_a_of_type_ArrayOfAndroidViewView[4];
      ((View)localObject).getHitRect(paramMessage);
      localObject = ((View)localObject).findViewById(2131368995);
      paramMessage.offset(((View)localObject).getLeft() + agej.a(34.0F, this.a.jdField_a_of_type_AndroidViewViewGroup.getResources()), ((View)localObject).getTop() - agej.a(18.0F, this.a.jdField_a_of_type_AndroidViewViewGroup.getResources()));
      localObject = (FrameLayout.LayoutParams)QQSettingMe.b(this.a).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).leftMargin = paramMessage.left;
      ((FrameLayout.LayoutParams)localObject).topMargin = paramMessage.top;
      QQSettingMe.b(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      QQSettingMe.b(this.a).setPadding(agej.a(6.0F, this.a.jdField_a_of_type_AndroidViewViewGroup.getResources()), agej.a(4.0F, this.a.jdField_a_of_type_AndroidViewViewGroup.getResources()), agej.a(6.0F, this.a.jdField_a_of_type_AndroidViewViewGroup.getResources()), agej.a(8.0F, this.a.jdField_a_of_type_AndroidViewViewGroup.getResources()));
      QQSettingMe.b(this.a).setVisibility(0);
      return;
    }
    QQSettingMe.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afik
 * JD-Core Version:    0.7.0.1
 */