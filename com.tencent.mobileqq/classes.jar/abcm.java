import com.tencent.mobileqq.armap.ConversationARMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;

public class abcm
  implements Runnable
{
  public abcm(ConversationARMap paramConversationARMap) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "mTouchReleaseRunnable mState:" + this.a.jdField_a_of_type_Int + "  mResume:" + this.a.c + " mTitleIsVisible:" + this.a.j);
    }
    if ((this.a.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null) && (this.a.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getScrollY() != 0))
    {
      this.a.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setSpringbackOffset(0);
      this.a.c(0);
    }
    if (this.a.c) {
      this.a.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setEnableTouch(true);
    }
    if (!this.a.j)
    {
      if (this.a.c) {
        break label159;
      }
      this.a.b(true);
    }
    label159:
    while (this.a.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.m) {
      return;
    }
    this.a.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abcm
 * JD-Core Version:    0.7.0.1
 */