import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;

public class abyg
  implements Runnable
{
  int jdField_a_of_type_Int;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  
  public abyg(EmoticonPanelLinearLayout paramEmoticonPanelLinearLayout, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewMotionEvent = paramMotionEvent;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = EmoticonPanelLinearLayout.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout);
  }
  
  public void run()
  {
    EmoticonInfo localEmoticonInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.getParent() != null) && (this.jdField_a_of_type_Int == EmoticonPanelLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout)) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_AndroidViewView != null))
    {
      localEmoticonInfo = (EmoticonInfo)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_AndroidViewView.getTag();
      if (localEmoticonInfo != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a(localEmoticonInfo))) {
          break label160;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.c = true;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.getParent().requestDisallowInterceptTouchEvent(true);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.sendAccessibilityEvent(2);
        if (!"delete".equals(localEmoticonInfo.a)) {
          break label120;
        }
      }
    }
    label120:
    while (("setting".equals(localEmoticonInfo.a)) || ("add".equals(localEmoticonInfo.a))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_AndroidViewView, localEmoticonInfo);
    return;
    label160:
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abyg
 * JD-Core Version:    0.7.0.1
 */