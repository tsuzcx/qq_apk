import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;

class aiht
  implements bhux
{
  aiht(aihl paramaihl) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(aihl.jdField_a_of_type_JavaLangString, 2, "onLongClick, position = " + paramInt);
    }
    paramAdapterView = this.a.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    if (paramAdapterView == this.a.jdField_a_of_type_Aihk)
    {
      this.a.jdField_a_of_type_Aihj = ((aihj)this.a.jdField_a_of_type_Aihk.getItem(paramInt));
      paramView.setSelected(true);
      paramAdapterView = new bdpi();
      paramAdapterView.a(2131364912, alud.a(2131707056), 2130838669);
      paramAdapterView.a(2131366760, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bdft.a(paramView, paramAdapterView, aihl.a(this.a), new aihu(this, paramView));
    }
    while (paramAdapterView != this.a.jdField_a_of_type_Aihv) {
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiht
 * JD-Core Version:    0.7.0.1
 */