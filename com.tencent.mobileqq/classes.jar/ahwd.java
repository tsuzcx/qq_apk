import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;

class ahwd
  implements bfso
{
  ahwd(ahvz paramahvz) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "ptv template listview onScrollStateChanged state: " + paramInt);
    }
    if (paramInt == 4097)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateManager", 2, "ptv template listview onScrollStateChanged state is idle.");
      }
      this.a.b = this.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 400L);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahwd
 * JD-Core Version:    0.7.0.1
 */