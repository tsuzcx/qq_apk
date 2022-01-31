import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

class aigx
  implements bhux
{
  aigx(aigp paramaigp) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.a.jdField_a_of_type_Aign.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (aihj)this.a.jdField_a_of_type_Aign.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.a.jdField_a_of_type_Aihj = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new bdpi();
    paramAdapterView.a(2131364912, alud.a(2131701665), 2130838669);
    paramAdapterView.a(2131366760, this.a.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bdft.a(paramView, paramAdapterView, aigp.a(this.a), new aigy(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigx
 * JD-Core Version:    0.7.0.1
 */