import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

class aiim
  implements bhux
{
  aiim(aiie paramaiie) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Aieh.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (aihj)this.a.jdField_a_of_type_Aieh.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_Aihj = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new bdpi();
    paramAdapterView.a(2131364912, alud.a(2131715576), 2130838669);
    paramAdapterView.a(2131366760, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bdft.a(paramView, paramAdapterView, aiie.a(this.a), new aiin(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiim
 * JD-Core Version:    0.7.0.1
 */