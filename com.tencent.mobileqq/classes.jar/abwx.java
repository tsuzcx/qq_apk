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

public class abwx
  extends Handler
{
  public abwx(QQSettingMe paramQQSettingMe, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      paramMessage = new Rect();
      localObject = this.a.jdField_a_of_type_ArrayOfAndroidViewView[3];
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
    }
    paramMessage = new Rect();
    Object localObject = this.a.jdField_a_of_type_ArrayOfAndroidViewView[3];
    ((View)localObject).getHitRect(paramMessage);
    localObject = ((View)localObject).findViewById(2131368385);
    paramMessage.offset(((View)localObject).getLeft() + actj.a(34.0F, this.a.jdField_a_of_type_AndroidViewViewGroup.getResources()), ((View)localObject).getTop() - actj.a(18.0F, this.a.jdField_a_of_type_AndroidViewViewGroup.getResources()));
    localObject = (FrameLayout.LayoutParams)QQSettingMe.b(this.a).getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).leftMargin = paramMessage.left;
    ((FrameLayout.LayoutParams)localObject).topMargin = paramMessage.top;
    QQSettingMe.b(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
    QQSettingMe.b(this.a).setPadding(actj.a(6.0F, this.a.jdField_a_of_type_AndroidViewViewGroup.getResources()), actj.a(4.0F, this.a.jdField_a_of_type_AndroidViewViewGroup.getResources()), actj.a(6.0F, this.a.jdField_a_of_type_AndroidViewViewGroup.getResources()), actj.a(8.0F, this.a.jdField_a_of_type_AndroidViewViewGroup.getResources()));
    QQSettingMe.b(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abwx
 * JD-Core Version:    0.7.0.1
 */