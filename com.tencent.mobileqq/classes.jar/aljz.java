import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.qphone.base.util.QLog;

public class aljz
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aljz(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.jdField_a_of_type_AndroidViewView.getHeight();
    int j = this.a.b.getHeight();
    if ((j != 0) && (i != 0))
    {
      QLog.d("Q.quicklogin.", 2, "height_root=" + i + " height_bt=" + j);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setMaxHeight(i - j);
      this.a.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aljz
 * JD-Core Version:    0.7.0.1
 */