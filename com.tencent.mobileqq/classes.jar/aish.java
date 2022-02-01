import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.SwipListView;

public class aish
  implements amii
{
  public aish(AddContactsView paramAddContactsView) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onAllRecommendsCaneled _B");
    }
    this.a.b.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onRecommendsAvailable _B");
    }
    this.a.b.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
    this.a.e();
    this.a.jdField_a_of_type_ComTencentWidgetSwipListView.getViewTreeObserver().addOnGlobalLayoutListener(new aisi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aish
 * JD-Core Version:    0.7.0.1
 */